package com.bangb.common.untils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.bangb.common.constant.WsErrConstant;
import com.bangb.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * 包管理工具
 * 找出项目中涉及到的所有Java类
 * @author Preciousness
 */
@Slf4j
public class PackageUtils {
	
	/**
	 * 找从寻项目入口entrance开始涉及的所有Java类
	 * @param entrance  项目入口Action/Controller的文件路径
	 * @return
	 * @throws BusinessException 
	 */
	public static List<String> queryAllJavaFile(String entrance) throws BusinessException {
		// 参数校验
		if (entrance == null || "".equals(entrance.trim())) {
			log.info("参数不合法！");
			throw new BusinessException(WsErrConstant.REQ_PARAMS_ERROR_CODE,"参数不合法！");
		}
		File controlFile = new File(entrance);
		if (controlFile == null || !controlFile.exists()) {
			log.info("文件不存在！");
			throw new BusinessException(WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_CODE,"文件不存在！");
		}
		
		// 以字符为单位，读取文件内容
        Reader reader = null;  
        try {  
            // 一次读多个字符  
            char[] tempchars = new char[30];  
            int charread = 0;  
            reader = new InputStreamReader(new FileInputStream(controlFile));  
            // 读入多个字符到字符数组中，charread为一次读取字符数  
            while ((charread = reader.read(tempchars)) != -1) {  
                // 同样屏蔽掉\r不显示  
                if ((charread == tempchars.length)  
                        && (tempchars[tempchars.length - 1] != '\r')) {  
                    System.out.print(tempchars);  
                } else {  
                    for (int i = 0; i < charread; i++) {  
                        if (tempchars[i] == '\r') {  
                            continue;  
                        } else {  
                            System.out.print(tempchars[i]);  
                        }  
                    }  
                }  
            }  
  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        }  
		List<String> listStr = new ArrayList<String>();
		return listStr;
	}
	
	public static List<String> ReadJavaFile(String entrance) throws BusinessException {
		File javaFile = new File(entrance);
		Reader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(javaFile));
			char[] tempchars = new char[30];  
			int charread = -1;
			StringBuilder builder = new StringBuilder();
			while((charread=reader.read(tempchars))!=-1) {
				if (tempchars[tempchars.length-1]!='\r') {
					String outPut = new String(tempchars, 0, charread);
					System.out.print(outPut);
					builder.append(outPut);
				}
			}
			String reg = "^import java.util.ArrayList;";
			String builderStr = builder.toString();
			if (builderStr.matches(reg)) {
				System.out.println("************");
				System.out.print(builderStr);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			log.info("文件不存在！");
			throw new BusinessException(WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_CODE,"文件不存在！");
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new BusinessException(WsErrConstant.IO_EXCEPTION_ERROR_CODE,"IO流异常！");
		}
		List<String> listStr = new ArrayList<String>();
		return listStr;
	}
}
