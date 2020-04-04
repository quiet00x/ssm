package com.bangb.common.untils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PDFCompoundUtil {
	
	/**
	 * 将多张图片合成为一个pdf文件
	 * @param imgList  图片路径列表
	 * @param descFilePath 目标文件全路径
	 * @return 目标文件全路径
	 */
    public static String imgListConverPdf(List<String> imgList, String descFilePath) {
    	if (imgList == null || imgList.size() == 0) {
    		log.info("传入图片路径列表为空！");
    		return null;
    	}
    	if (descFilePath == null || "".equals(descFilePath.trim())) {
    		log.info("未传入目标文件路径");
    		// 默认放入本地C盘临时目录中
    		descFilePath = "C:/temp/temp.pdf";
    	} 
		File descFile = new File(descFilePath);
		if (!descFile.exists()) {
			descFile.setExecutable(true);
			descFile.getParentFile().mkdirs();
		}
		// 第一步：创建一个document对象。
		Document document = new Document();
		document.setMargins(0, 0, 0, 0);
		// 第二步：
		// 创建一个PdfWriter实例，
		try {
			PdfWriter.getInstance(document, new FileOutputStream(descFile));
			// 第三步：打开文档。
			document.open();
			// 第四步：在文档中增加图片。
			for (String imgPath : imgList) {
				File imgFile = new File(imgPath);
				if (imgFile.getName().toLowerCase().endsWith(".bmp") || imgFile.getName().toLowerCase().endsWith(".jpg")
						|| imgFile.getName().toLowerCase().endsWith(".jpeg")
						|| imgFile.getName().toLowerCase().endsWith(".gif")
						|| imgFile.getName().toLowerCase().endsWith(".png")) {
					Image img = Image.getInstance(imgPath);
					img.setAlignment(Image.ALIGN_CENTER);
					float imgWidth = img.getWidth();
					float imgHight = img.getHeight();
					img.scaleAbsolute(imgWidth, imgHight);
					// 根据图片大小设置页面
					document.setPageSize(new Rectangle(imgWidth, imgHight));
					document.newPage();
					document.add(img);
					log.debug("imgName:" + imgPath + "has been added");
				} else {
					log.info("待合成文件类型非图片！");
					continue;
				}
			}
			document.close();
			log.debug("over filePath is " + descFilePath);
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			document = null;
		}
		return descFilePath;
	}
}
