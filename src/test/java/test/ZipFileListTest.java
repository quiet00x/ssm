package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bangb.common.exception.BusinessException;
import com.bangb.common.untils.FileUtils;
import com.bangb.user.bean.ZipEntryBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZipFileListTest {
	public static void main(String[] args) throws BusinessException, IOException {
		for(int i = 0; i <=100; i++) {
			test();
		}
	}

	private static void test() throws BusinessException {
		List<ZipEntryBean> listStr = new ArrayList<ZipEntryBean>();
		
		String srcFilePath1 = "D:\\temp\\ziptest\\1.pdf";
		ZipEntryBean entryBean1 = new ZipEntryBean(srcFilePath1);
		
		String srcFilePath2 = "D:\\temp\\ziptest\\2.pdf";
		ZipEntryBean entryBean2 = new ZipEntryBean(srcFilePath2);
		
		String srcFilePath3 = "D:\\temp\\ziptest\\3.pdf";
		ZipEntryBean entryBean3 = new ZipEntryBean(srcFilePath3);
		
		String srcFilePath4 = "D:\\temp\\ziptest\\4.pdf";
		ZipEntryBean entryBean4 = new ZipEntryBean(srcFilePath4);
		
		String srcFilePath5 = "D:\\temp\\ziptest\\5.pdf";
		ZipEntryBean entryBean5 = new ZipEntryBean(srcFilePath5);
		
		String srcFilePath6 = "D:\\temp\\ziptest\\6.pdf";
		ZipEntryBean entryBean6 = new ZipEntryBean(srcFilePath6);
		
		String srcFilePath7 = "D:\\temp\\ziptest\\7.pdf";
		ZipEntryBean entryBean7 = new ZipEntryBean(srcFilePath7);
		
		String srcFilePath8 = "D:\\temp\\ziptest\\8.pdf";
		ZipEntryBean entryBean8 = new ZipEntryBean(srcFilePath8);
		
		String srcFilePath9 = "D:\\temp\\ziptest\\9.pdf";
		ZipEntryBean entryBean9 = new ZipEntryBean(srcFilePath9);
		
		String srcFilePath10 = "D:\\temp\\ziptest\\10.pdf";
		ZipEntryBean entryBean10 = new ZipEntryBean(srcFilePath10);
		
		String srcFilePath11 = "D:\\temp\\ziptest\\11.pdf";
		ZipEntryBean entryBean11 = new ZipEntryBean(srcFilePath11);
		
		String srcFilePath12 = "D:\\temp\\ziptest\\12.pdf";
		ZipEntryBean entryBean12 = new ZipEntryBean(srcFilePath12);
		
		String srcFilePath13 = "D:\\temp\\ziptest\\13.pdf";
		ZipEntryBean entryBean13 = new ZipEntryBean(srcFilePath13);
		
		String srcFilePath14 = "D:\\temp\\ziptest\\14.pdf";
		ZipEntryBean entryBean14 = new ZipEntryBean(srcFilePath14);
		
		String srcFilePath15 = "D:\\temp\\ziptest\\15.pdf";
		ZipEntryBean entryBean15 = new ZipEntryBean(srcFilePath15);
		
		String srcFilePath16 = "D:\\temp\\ziptest\\16.pdf";
		ZipEntryBean entryBean16 = new ZipEntryBean(srcFilePath16);
		
		String srcFilePath17 = "D:\\temp\\ziptest\\17.pdf";
		ZipEntryBean entryBean17 = new ZipEntryBean(srcFilePath17);
		
		String srcFilePath18 = "D:\\temp\\ziptest\\18.pdf";
		ZipEntryBean entryBean18 = new ZipEntryBean(srcFilePath18);
		
		String srcFilePath19 = "D:\\temp\\ziptest\\19.pdf";
		ZipEntryBean entryBean19 = new ZipEntryBean(srcFilePath19);
		
		String srcFilePath20 = "D:\\temp\\ziptest\\20.pdf";
		ZipEntryBean entryBean20 = new ZipEntryBean(srcFilePath20);
		
		String srcFilePath21 = "D:\\temp\\ziptest\\21.pdf";
		ZipEntryBean entryBean21 = new ZipEntryBean(srcFilePath21);
		
		String srcFilePath22 = "D:\\temp\\ziptest\\22.pdf";
		ZipEntryBean entryBean22 = new ZipEntryBean(srcFilePath22);
		
		String srcFilePath23 = "D:\\temp\\ziptest\\23.pdf";
		ZipEntryBean entryBean23 = new ZipEntryBean(srcFilePath23);
		
		String srcFilePath24 = "D:\\temp\\ziptest\\24.pdf";
		ZipEntryBean entryBean24 = new ZipEntryBean(srcFilePath24);
		
		String srcFilePath25 = "D:\\temp\\ziptest\\25.pdf";
		ZipEntryBean entryBean25 = new ZipEntryBean(srcFilePath25);
		
		String srcFilePath26 = "D:\\temp\\ziptest\\26.pdf";
		ZipEntryBean entryBean26 = new ZipEntryBean(srcFilePath26);
		
		String srcFilePath27 = "D:\\temp\\ziptest\\27.pdf";
		ZipEntryBean entryBean27 = new ZipEntryBean(srcFilePath27);
		
		String srcFilePath28 = "D:\\temp\\ziptest\\28.pdf";
		ZipEntryBean entryBean28 = new ZipEntryBean(srcFilePath28);
		
		String srcFilePath29 = "D:\\temp\\ziptest\\29.pdf";
		ZipEntryBean entryBean29 = new ZipEntryBean(srcFilePath29);
		
		String srcFilePath30 = "D:\\temp\\ziptest\\30.pdf";
		ZipEntryBean entryBean30 = new ZipEntryBean(srcFilePath30);
		
		String srcFilePath31 = "D:\\temp\\ziptest\\31.pdf";
		ZipEntryBean entryBean31 = new ZipEntryBean(srcFilePath31);
		
		String srcFilePath32 = "D:\\temp\\ziptest\\32.pdf";
		ZipEntryBean entryBean32 = new ZipEntryBean(srcFilePath32);
		
		String srcFilePath33 = "D:\\temp\\ziptest\\33.pdf";
		ZipEntryBean entryBean33 = new ZipEntryBean(srcFilePath33);
		
		String srcFilePath34 = "D:\\temp\\ziptest\\34.pdf";
		ZipEntryBean entryBean34 = new ZipEntryBean(srcFilePath34);
		
		String srcFilePath35 = "D:\\temp\\ziptest\\35.pdf";
		ZipEntryBean entryBean35 = new ZipEntryBean(srcFilePath35);
		
		String srcFilePath36 = "D:\\temp\\ziptest\\36.pdf";
		ZipEntryBean entryBean36 = new ZipEntryBean(srcFilePath36);
		
		String srcFilePath37 = "D:\\temp\\ziptest\\37.pdf";
		ZipEntryBean entryBean37 = new ZipEntryBean(srcFilePath37);
		
		String srcFilePath38 = "D:\\temp\\ziptest\\38.pdf";
		ZipEntryBean entryBean38 = new ZipEntryBean(srcFilePath38);
		
		String srcFilePath39 = "D:\\temp\\ziptest\\39.pdf";
		ZipEntryBean entryBean39 = new ZipEntryBean(srcFilePath39);
		
		String srcFilePath40 = "D:\\temp\\ziptest\\40.pdf";
		ZipEntryBean entryBean40 = new ZipEntryBean(srcFilePath40);
		
		
		listStr.add(entryBean1);
		listStr.add(entryBean2);
		listStr.add(entryBean3);
		listStr.add(entryBean4);
		listStr.add(entryBean5);
		listStr.add(entryBean6);
		listStr.add(entryBean7);
		listStr.add(entryBean8);
		listStr.add(entryBean9);
		listStr.add(entryBean10);
		listStr.add(entryBean11);
		listStr.add(entryBean12);
		listStr.add(entryBean13);
		listStr.add(entryBean14);
		listStr.add(entryBean15);
		listStr.add(entryBean16);
		listStr.add(entryBean17);
		listStr.add(entryBean18);
		listStr.add(entryBean19);
		listStr.add(entryBean20);
		listStr.add(entryBean21);
		listStr.add(entryBean22);
		listStr.add(entryBean23);
		listStr.add(entryBean24);
		listStr.add(entryBean25);
		listStr.add(entryBean26);
		listStr.add(entryBean27);
		listStr.add(entryBean28);
		listStr.add(entryBean29);
		listStr.add(entryBean30);
		listStr.add(entryBean31);
		listStr.add(entryBean32);
		listStr.add(entryBean33);
		listStr.add(entryBean34);
		listStr.add(entryBean35);
		listStr.add(entryBean36);
		listStr.add(entryBean37);
		listStr.add(entryBean38);
		listStr.add(entryBean39);
		listStr.add(entryBean40);
		
		long start = System.currentTimeMillis();
		FileUtils.multipleFileZip(null, listStr);
		long end = System.currentTimeMillis();
		log.debug("multipleFileZip:" + (end-start) + "ms");
		
		start = System.currentTimeMillis();
		FileUtils.multipleFileZipPro(null, listStr);
		end = System.currentTimeMillis();
		log.debug("multipleFileZipPro:" + (end-start) + "ms");
	} 

}
