package test;

import java.util.ArrayList;
import java.util.List;

import com.bangb.common.untils.PDFCompoundUtil;

public class FileTest {
	
	public static void main(String[] args) throws Exception {
		String descFilePath = "D:/temp/temp.pdf";
		List<String> imgList = new ArrayList<String>();
		String imgFile1 = "D:/temp/1.jpg";
		String imgFile2 = "D:/temp/2.jpg";
		String imgFile3 = "D:/temp/3.jpg";
		String imgFile4 = "D:/temp/4.jpg";
		imgList.add(imgFile1);
		imgList.add(imgFile2);
		imgList.add(imgFile3);
		imgList.add(imgFile4);
		PDFCompoundUtil.imgListConverPdf(imgList, null);
	}
}
