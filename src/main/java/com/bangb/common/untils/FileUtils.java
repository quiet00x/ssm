package com.bangb.common.untils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.bangb.common.constant.Constant;
import com.bangb.common.constant.WsErrConstant;
import com.bangb.common.exception.BusinessException;
import com.bangb.user.bean.ZipEntryBean;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件工具类
 * 采用BufferedInputStream 和 缓冲数组 
 * 实现文件高性能压缩
 * @author Preciousness
 */
@Slf4j
public class FileUtils {
	
	/** 默认缓冲区大小 */
	private static final int DEFAULT_BUFF_SIZE = 8*1024;
	
	/** 默认文件根目录 */
	private static final String FILE_DEF_ROOT_PATH = "D:";
	
	/** 临时目录 */
	private static final String FILE_DEF_TEMP_DIRECTOR = "temp";
	
	/**
	 * 压缩文件入口方法可以同时压缩文件和目录
	 * 利用缓冲流 + 缓冲数组实现的高性能压缩
	 * @param descZipFilePath 目标文件路径 
	 * @param srcFileList<ZipEntryBean> 源文件列表 支持重命名
	 * @return 返回目标文件路径
	 * @throws BusinessException 
	 */
	public static String multipleFileZip(String descZipFilePath, List<ZipEntryBean> srcFileList) throws BusinessException {
		// 参数校验
		if(CollectionUtils.isEmpty(srcFileList)) {
			log.error(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					,srcFileList,WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
			throw new BusinessException(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					, WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
		}
		
		// 若沒有传參，设置默认路径
		descZipFilePath = defaultDescFile(descZipFilePath); 
		
		// 创建压缩文件输出流 
		ZipOutputStream zipOut = null;
		// 创建输出缓冲流 
		BufferedOutputStream bufOut = null;
		try {
			bufOut = new BufferedOutputStream(new FileOutputStream(new File(descZipFilePath)));
			// 注意：此处用zipOutPutStream包装 Buffered
			zipOut = new ZipOutputStream(bufOut);
			
			for (ZipEntryBean entryBean : srcFileList) {
				if (entryBean == null) {
					continue;
				}
				
				// 获取源文件资源路径
				String filePath = entryBean.getSrcFilePath();
				// 源文件路径为空，跳过该次压缩
				if (StringUtils.isBlank(filePath)) {
					continue;
				}
				
				File srcFile = new File(filePath);
				// 文件不存在 则跳过
				if (!srcFile.exists()) {
					log.info(">>>>>>>>>>>filePath:{} is not exist <<<<<<<<<<<",filePath);
					continue;
				}
				
				// 若文件为目录
				if (srcFile.isDirectory()) {
					zipOutPutDirectory(entryBean,zipOut);
				} else { // 文件
					zipOutPutFile(entryBean,zipOut);
				}
			}
		} catch (FileNotFoundException e) {
			throw new BusinessException(WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_CODE
					,WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_MSG,e);
		} finally {
			if (zipOut != null) {
				try {
					zipOut.close();
				} catch (IOException e) {
					zipOut = null;
					throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,
							WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
				}
			}
		}
		log.info(">>>>>>>>>>>zipFilePath：{}<<<<<<<<<<<",descZipFilePath);
		
		return descZipFilePath;
	}

	/**
	 * 处理输出文件默认路径
	 * @param descZipFilePath
	 * @return
	 */
	private static String defaultDescFile(String descZipFilePath) {
		if(StringUtils.isBlank(descZipFilePath)) {
			descZipFilePath = FILE_DEF_ROOT_PATH 
					+ File.separator + FILE_DEF_TEMP_DIRECTOR 
					+ File.separator + DateUtils.dateToString(Calendar.getInstance().getTime(), "yyyyMMdd")
					+ File.separator + UUID.randomUUID() 
					+ Constant.FILE_SUFFIX_ZIP;
			// 创建目录
			new File(descZipFilePath).getParentFile().mkdirs();
		}
		return descZipFilePath;
	}
	
	/**
	 * 压缩目录
	 * 暂时不支持对目录中文件重命名
	 * @param srcFile
	 * @throws BusinessException 
	 */
	private static void zipOutPutDirectory(ZipEntryBean entryBean,ZipOutputStream zipOut) throws BusinessException {
		String srcFilePath = entryBean.getSrcFilePath();
		
		File srcFile = new File(srcFilePath);
		
		File[] fileList = srcFile.listFiles();
		
		for (File filePath : fileList) {
			if (filePath.isDirectory()) { // 目录
				zipOutPutDirectory(entryBean,zipOut);
			} else { // 文件
				zipOutPutFile(entryBean,zipOut);
			}
		}
	}
	
	/**
	 * 压缩单个文件
	 * @param entryBean
	 * @param srcFile
	 * @param zipOut
	 * @throws BusinessException
	 */
	private static void zipOutPutFile(ZipEntryBean entryBean,ZipOutputStream zipOut) throws BusinessException {
		// 获取源文件路径
		String srcFilePath = entryBean.getSrcFilePath();
		// 获取文件
		File srcFile = new File(srcFilePath);
		// 创建输入缓冲流
		BufferedInputStream bufIns = null;
		try {
			// 创建文件输入缓冲流
			bufIns = new BufferedInputStream(new FileInputStream(srcFile));
			// 缓冲数组
			byte[] buffByte = new byte[DEFAULT_BUFF_SIZE];
			// 压缩实例，即压缩包中的文件，可以对文件进行重命名
			String entryName = entryBean.getFileReName();
			
			if (StringUtils.isBlank(entryName)) {
				entryName = srcFile.getName();
			}
			
			ZipEntry zipEntry = new ZipEntry(entryName);
			zipOut.putNextEntry(zipEntry);
			// 设置压缩级别 0-9 0最低最快 9最高 最慢
			zipOut.setLevel(9);
			
			int len = -1;
			while((len=bufIns.read(buffByte,0,DEFAULT_BUFF_SIZE)) != -1) {
				zipOut.write(buffByte,0,len);
			}
			zipOut.closeEntry();
		} catch (FileNotFoundException e) {
			throw new BusinessException(WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_CODE
					,WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_MSG,e);
		} catch (IOException e) {
			throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE
					,WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
		} finally {
			if (bufIns != null) {
				try {
					bufIns.close();
				} catch (IOException e) {
					bufIns = null;
					throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,
							WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
				}
			}
		}
	}

	/**
	 * 复制源文件至指定目录下
	 * @param srcFileList 源文件路径列表
	 * @param zipParFolder 目标目录
	 * @throws BusinessException
	 */
	public static void copyFile(List<String> srcFileList, String zipParFolder) throws BusinessException {
		// 方法独立需要验证参数是否异常，独立验证便于定位！
		if(StringUtils.isBlank(zipParFolder)) {
			log.error(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					,zipParFolder,WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
			throw new BusinessException(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					, WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
		}
		
		if(CollectionUtils.isEmpty(srcFileList)) {
			log.error(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					,srcFileList,WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
			throw new BusinessException(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					, WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
		}
		
		for (String filePath : srcFileList) {
			File file = new File(filePath);
			if(!file.exists()) {
				log.error(">>>>>>>>>>>>>>>>>filePath：{} is not exist<<<<<<<<<<<<<<<<<",filePath);
				continue;
			}
			BufferedInputStream bif = null;
			BufferedOutputStream bof = null;
			try {
				bif = new BufferedInputStream(new FileInputStream(file));
				File descFile = new File(zipParFolder + File.separator + file.getName());
				if(!descFile.exists()) {
					bof = new BufferedOutputStream(new FileOutputStream(descFile));
				} else {
					// 重命名下标
					int index = 1;
					// 文件重命名
					File newFilePath = reNameFile(zipParFolder, descFile,index);
					bof = new BufferedOutputStream(new FileOutputStream(newFilePath));
				}
				byte[] temp = new byte[1024*10];
				int len = -1;
				while((len=bif.read(temp))!=-1){
					bof.write(temp,0,len);
				}
			} catch (FileNotFoundException e) {
				throw new BusinessException(WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_CODE
						,WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_MSG,e);
			} catch (IOException e) {
				throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE
						,WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
			}  finally {
				if (bif != null) {
					try {
						bif.close();
					} catch (IOException e) {
						throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,
								WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
					}
				}
				if (bof != null) {
					try {
						bof.close();
					} catch (IOException e) {
						throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,
								WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
					}
				}
			}
		}
	}
	
	/**
	 * zipParFolder目录下文件重命名
	 * @param zipParFolder 文件所在目录
	 * @param descFile 源文件
	 * @return
	 */
	public static File reNameFile(String zipParFolder, File srcFile,int index) {
		String filePath = srcFile.getPath();
		int lastPIndex = filePath.lastIndexOf(".");
		String newFilePath = filePath.substring(0,lastPIndex) + "_" + (index++) + filePath.substring(lastPIndex);
		File newFile = new File(newFilePath);
		// 存在同名文件，重命名文件
		if (newFile.exists()) {
			newFile = reNameFile(zipParFolder, newFile,index);
		}
		log.info(newFilePath);
		return newFile;
	}
	
	/**
	 * 利用 apache 提供的删除目录方法
	 * @param dirPath
	 * @throws BusinessException
	 */
	public static void deleteDir (String dirPath) throws BusinessException {
		File dirFile = new File(dirPath);
		try {
			org.apache.commons.io.FileUtils.deleteDirectory(dirFile);
		} catch (IOException e) {
			throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE, e.getMessage(),e);
		}
	}
	
	/**
	 * 压缩文件入口方法可以同时压缩文件和目录
	 * 利用缓冲流 + 缓冲数组实现的高性能压缩
	 * @param descZipFilePath 目标文件路径 
	 * @param entryBeanList<ZipEntryBean> 源文件列表 支持重命名
	 * @return 返回目标文件路径
	 * @throws BusinessException 
	 */
	public static String multipleFileZipPro(String descZipFilePath, List<ZipEntryBean> entryBeanList) throws BusinessException {
		// 参数校验
		if(CollectionUtils.isEmpty(entryBeanList)) {
			log.error(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					,entryBeanList,WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
			throw new BusinessException(WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_CODE
					, WsErrConstant.ILLEGAL_NULL_PARAM_EXCEPTION_MSG);
		}
		
		// 若沒有传參，设置默认路径
		descZipFilePath = defaultDescFile(descZipFilePath); 
		
		// 创建压缩文件输出流 
		ZipOutputStream zipOut = null;
		// 创建输出缓冲流 
		BufferedOutputStream bufOut = null;
		try {
			bufOut = new BufferedOutputStream(new FileOutputStream(new File(descZipFilePath)));
			// 注意：此处用zipOutPutStream包装 Buffered
			zipOut = new ZipOutputStream(bufOut);
			
			// 批量读取压缩文件
			List<BufferedInputStream> bufInputStreamList = readFileList(entryBeanList);
			
			for (BufferedInputStream bufferedInputStream : bufInputStreamList) {
				zipOutPutFilePro(bufferedInputStream,zipOut);
			}
			
		} catch (FileNotFoundException e) {
			throw new BusinessException(WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_CODE
					,WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_MSG,e);
		} finally {
			if (zipOut != null) {
				try {
					zipOut.close();
				} catch (IOException e) {
					zipOut = null;
					throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,
							WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
				}
			}
		}
		log.info(">>>>>>>>>>>zipFilePath：{}<<<<<<<<<<<",descZipFilePath);
		
		return descZipFilePath;
	}
	
	/**
	 * 压缩单个文件
	 * @param entryBean
	 * @param srcFile
	 * @param zipOut
	 * @throws BusinessException
	 */
	private static void zipOutPutFilePro(BufferedInputStream buffInputStream,ZipOutputStream zipOut) throws BusinessException {
		try {
			// 缓冲数组
			byte[] buffByte = new byte[DEFAULT_BUFF_SIZE];
			// 压缩实例，即压缩包中的文件，可以对文件进行重命名
			String entryName = UUID.randomUUID() + Constant.FILE_SUFFIX_PDF;
			
			ZipEntry zipEntry = new ZipEntry(entryName);
			zipOut.putNextEntry(zipEntry);
			// 设置压缩级别 0-9 0最低最快 9最高 最慢
			zipOut.setLevel(1);
			
			int len = -1;
			while((len=buffInputStream.read(buffByte,0,DEFAULT_BUFF_SIZE)) != -1) {
				zipOut.write(buffByte,0,len);
			}
			zipOut.closeEntry();
		} catch (IOException e) {
			throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE
					,WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
		} finally {
			if (buffInputStream != null) {
				try {
					buffInputStream.close();
				} catch (IOException e) {
					buffInputStream = null;
					throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,
							WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
				}
			}
		}
	}
	
	/**
	 * 文件批量加载
	 * 三种方案：
	 * 1.利用固定大小线程池
	 * 2.利用ForkJoin
	 * 3.普通方式读取
	 * @param entryBeanList 源文件 支持重命名
	 * @return
	 * @throws BusinessException 
	 */
	public static List<BufferedInputStream> readFileList(List<ZipEntryBean> entryBeanList) throws BusinessException {
		List<BufferedInputStream> bufInputStreamList = new ArrayList<BufferedInputStream>();
		
		for (ZipEntryBean entryBean : entryBeanList) {
			if (entryBean == null) {
				continue;
			}
			
			// 获取源文件资源路径
			String filePath = entryBean.getSrcFilePath();
			// 源文件路径为空，跳过该次压缩
			if (StringUtils.isBlank(filePath)) {
				continue;
			}
			
			File srcFile = new File(filePath);
			// 文件不存在 则跳过
			if (!srcFile.exists()) {
				log.info(">>>>>>>>>>>filePath:{} is not exist <<<<<<<<<<<",filePath);
				continue;
			}
			
			if (srcFile.isDirectory()) {// 目录
				// TODO
			} else { // 文件
				try {
					BufferedInputStream bufInputStream = new BufferedInputStream(new FileInputStream(srcFile));
					bufInputStreamList.add(bufInputStream);
				} catch (FileNotFoundException e) {
					throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,
							WsErrConstant.IO_EXCEPTION_ERROR_MSG,e);
				}
			}
			
		}
		return bufInputStreamList;
	}
	
	
	
}
