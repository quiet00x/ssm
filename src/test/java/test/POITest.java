package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 利用POI将查询数据导出为EXCEl文件
 * @author Preciousness
 */
public class POITest {
	
	private static Logger log = LoggerFactory.getLogger(POITest.class);
	
//	public static void main(String[] args) throws Exception {
//		String filePath = "D:/temp/demo.xls";
//		List<Map<Integer, Map<Integer, String>>> parse = parseExcel(new FileInputStream(new File(filePath)),null);
//		for (Map<Integer, Map<Integer, String>> map : parse) {
//			log.debug("map:" + map);
//		}
//
//	}
//
//
//	/**
//	 * 解析Excel文件 形参为文件流或者二进制字节码
//	 * @param fileStream 文件输入流
//	 * @param bytes 二进制字节码
//	 * @return list<Map>
//	 * @throws Exception
//	 */
//	@SuppressWarnings("resource")
//	public static List<Map<Integer, Map<Integer, String>>> parseExcel(
//			FileInputStream fileStream, Byte[] bytes) throws Exception {
//		List<Map<Integer, Map<Integer, String>>> list = new ArrayList<Map<Integer, Map<Integer, String>>>();
//
//		if (fileStream != null) {
//			try {
//				HSSFWorkbook workbook = new HSSFWorkbook(fileStream);
//				 log.debug("当前文档共计" + workbook.getNumberOfSheets() + "个工作空间");
//				 int maxSheetNum = workbook.getNumberOfSheets();
//				 // 遍历Excel文档所有工作空间
//				 for(int sheetNum = 0; sheetNum < maxSheetNum; sheetNum++) {
//					 // 获取当前工作空间
//					 Sheet sheet = workbook.getSheetAt(sheetNum);
//					 String sheetName = sheet.getSheetName();
//					 log.debug("sheetName:" + sheetName);
//					 // 获取起始行号
//					 int firstRow = sheet.getFirstRowNum();
//					 // 获取终止行号
//					 int lastRow = sheet.getLastRowNum();
//					 // 遍历当前工作空间行
//					 for(int rowNum = firstRow; rowNum <= lastRow; rowNum ++) {
//						 Map<Integer,Map<Integer,String>> rowMap = new HashMap<Integer,Map<Integer,String>>();
//						 Row row = sheet.getRow(rowNum);
//						 int firstCell = row.getFirstCellNum();
//						 int lastCell = row.getLastCellNum();
//						 Map<Integer,String> cellMap = new HashMap<Integer,String> ();
//						 // 遍历列
//						 for(int cellNum = firstCell; cellNum < lastCell; cellNum ++) {
//							 // 获取当前单元格
//							 Cell cell = row.getCell(cellNum);
//							 CellType cellType = cell.getCellType();
//							 String data = getTheValue(cell, cellType);
//							 cellMap.put(cellNum,data);
//						 }
//						 rowMap.put(rowNum, cellMap);
//						 list.add(rowMap);
//					 }
//				 }
//			} catch (IOException e) {
//				log.error(e.getClass() + e.getMessage());
//				throw new BusinessException(WsErrConstant.FileAbout.FILE_NOT_FOUND_ERROR_CODE, e.getMessage(), e);
//			}
//		}
//		if (bytes != null && bytes.length > 0) {
//
//		}
//		return list;
//	}
//
//	 /**
//     * 解析excel文档（支持xls、xlsx格式）
//     * @param path - 文件路径
//     * @param formula - 是否获取公式结果
//     * @param sdf - 日期格式
//     * @return  List - 结果表
//     * @throws Exception - 打开文件失败
//     */
//    public static List<Map<Integer, Map<Integer, String>>> parse(String path)
//    			throws Exception {
//        File file = new File(path);
//
//        List<Map<Integer, Map<Integer, String>>> list = new ArrayList<Map<Integer, Map<Integer, String>>>();
//        if (file.isFile()) {
//        	HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
//            log.debug("当前活动sheet" + workbook.getActiveSheetIndex());
//            log.debug("当前共计文档"+workbook.getNumberOfSheets());
//            int max=workbook.getNumberOfSheets();
//            for(int sheetNum=0;sheetNum<max;sheetNum++){
//                list.add(getSheet(workbook, sheetNum));//解析sheet表
//            }
//        }
//        else
//        {
//            throw new Exception("文件不存在");
//        }
//        return list;
//    }
//
//    /**
//     * 获取sheet表内容
//     * @param wb - 文档
//     * @param sheetNum - 打开那张sheet表
//     * @param formula - 是否获得公式结果
//     * @param sdf - 日期格式
//     * @return Map - 结果表
//     */
//    public static Map<Integer, Map<Integer, String>> getSheet(Workbook wb, int sheetNum)
//    {
//        String sheetName = wb.getSheetName(sheetNum);
//        log.debug("打开了sheet表：" + sheetName);
//        Sheet sheet = wb.getSheet(sheetName);
//        Map<Integer, Map<Integer, String>> map=getRowAndCell(sheet);//解析所有单元格
//        return map;
//
//    }
//
//    /**
//     * 从sheet表中获取每行每列的值
//     * @param sheet - sheet表
//     * @param formula - 是否获取公式结果
//     * @param sdf - 日期格式
//     * @return Map - 结果表
//     */
//     public static Map<Integer, Map<Integer, String>> getRowAndCell(Sheet sheet)
//     {
//         Map<Integer,Map<Integer,String>> rowMap = new HashMap<Integer,Map<Integer,String>>();
//         int firstRowNum = sheet.getFirstRowNum();
//         int lastRowNum = sheet.getLastRowNum();
//
//         if(lastRowNum>0){
//
//
//         // 遍历行
//         for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++ )
//         {
//             Row row = sheet.getRow(rowNum);
//             int firstCellNum = row.getFirstCellNum();
//             int lastCellNum = row.getLastCellNum();
//             Map<Integer,String> cellMap=new HashMap<Integer,String> ();
//             // 遍历列
//             for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++ )
//             {
//                 Cell cell = row.getCell(cellNum);
//                 CellType type = cell.getCellType();
//                 String data = getTheValue(cell,type);
//                 System.out.println("第" + rowNum + "行，第" + cellNum + "列，类型是" + type +"，内容是："+data);
//                 cellMap.put(cellNum, data);
//             }
//             rowMap.put(rowNum, cellMap);
//         }
//         }
//         return rowMap;
//     }
//
//     public static String getTheValue(Cell cell, CellType type) {
//    	 String data = null;
//    	 if ("STRING".equals(type.toString().trim())) {
//    		 data = cell.getStringCellValue();
//    	 }
//    	 if ("NUMERIC".equals(type.toString().trim())) {
//    		 data = String.valueOf(cell.getNumericCellValue());
//    	 }
//    	 if ("BOOLEAN".equals(type.toString().trim())) {
//    		 data = String.valueOf(cell.getBooleanCellValue());
//    	 }
//    	 if ("BLANK".equals(type.toString().trim())) {
//    		 data = null;
//    	 }
//    	 if ("ERROR".equals(type.toString().trim())) {
//    		 data = null;
//    	 }
//        return data;
//     }
//
//
//	public static String createExcelBook(String descFilePath) throws IOException {
//		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
//		HSSFRow row = sheet.createRow(0);
//		HSSFCell cell = row.createCell(0);
//		cell.setCellValue("Y");
//		FileOutputStream out = new FileOutputStream(descFilePath);
//		workbook.write(out);//保存Excel文件
//		out.close();//关闭文件流
//		return descFilePath;
//	}
//
//
//	public static List<Map<String, Object>> initMap() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, BusinessException {
//		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//		StmtBean stmtBean = new StmtBean();
//		stmtBean.setId(1);
//		stmtBean.setCusNo("0101010101");
//		stmtBean.setAcctNo("123123123123");
//		stmtBean.setStmtId("111111111111");
//		stmtBean.setStmtDate("2019-01-31");
//		listMap.add(TranceUtil.beanToMapPro(stmtBean));
//		StmtBean stmtBean1 = new StmtBean();
//		stmtBean1.setId(2);
//		stmtBean1.setCusNo("0101010101");
//		stmtBean1.setAcctNo("124124124124");
//		stmtBean1.setStmtId("111111111112");
//		stmtBean1.setStmtDate("2019-01-31");
//		listMap.add(TranceUtil.beanToMapPro(stmtBean1));
//		StmtBean stmtBean2 = new StmtBean();
//		stmtBean2.setId(3);
//		stmtBean2.setCusNo("0101010101");
//		stmtBean2.setAcctNo("125125125125");
//		stmtBean2.setStmtId("111111111113");
//		stmtBean2.setStmtDate("2019-01-31");
//		listMap.add(TranceUtil.beanToMapPro(stmtBean2));
//		StmtBean stmtBean3 = new StmtBean();
//		stmtBean3.setId(4);
//		stmtBean3.setCusNo("0101010101");
//		stmtBean3.setAcctNo("125125125125");
//		stmtBean3.setStmtId("111111111113");
//		stmtBean3.setStmtDate("2019-01-31");
//		listMap.add(TranceUtil.beanToMapPro(stmtBean3));
//		return listMap;
//	}
	
}
