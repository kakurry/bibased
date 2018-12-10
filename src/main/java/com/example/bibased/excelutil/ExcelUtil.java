package com.example.bibased.excelutil;

//import com.sun.rowset.internal.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.VerticalAlignment;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.ifp.common.common.exception.ClassException;
//import com.ifp.common.common.model.ExcelModel;
//import com.ifp.common.common.model.ProductDataValue;

/**
 * 2018/1/15
 * 
 * @author zhaoyuqi excel导入工具类
 */
public class ExcelUtil {

	/**
	 * 初始化excel
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static Workbook initExcel(String filePath) throws Exception {
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
		InputStream stream = new FileInputStream(filePath);
		Workbook wb = null;
		if ("xls".equals(fileType)) {
			wb = new HSSFWorkbook(stream);
		} else if ("xlsx".equals(fileType)) {
			wb = new XSSFWorkbook(stream);
		} else {
			System.out.println("您输入的excel格式不正确");
		}
		return wb;

	}
	/**
	 * 获取excel有几个sheet页
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static int getSheetNum(String filePath) throws Exception {
		Workbook initExcel = initExcel(filePath);
		int numberOfSheets = initExcel.getNumberOfSheets();
		return numberOfSheets;
	}
	
	/**
	 * 获取sheet页的名称
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static List<ExcelModel> getSheetName(String filePath) throws Exception {
		Workbook initExcel = initExcel(filePath);
		List<ExcelModel> sheetList = new ArrayList<ExcelModel>();
		for (int i = 0; i < initExcel.getNumberOfSheets(); i++) {
			ExcelModel excelModel = new ExcelModel();
			excelModel.setSheetNumber(String.valueOf(i));
			excelModel.setSheetName(initExcel.getSheetName(i));
			sheetList.add(excelModel);
		}
		return sheetList;
	}
	
	/**
	 * 指定读取哪个sheet的内容，并且指定从哪行开始到哪行结束，表头固定都有
	 * @param filePath
	 * @param sheetNum
	 * @param beginNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public static List<ProductDataValue> getSheetData(String filePath, String sheetNum, String beginNum, String endNum) throws Exception {
		Workbook initExcel = initExcel(filePath);
		// 区分是xls还是xlsx
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
		List<ProductDataValue> sheetList = new ArrayList<ProductDataValue>();
		Sheet sheet = initExcel.getSheetAt(Integer.valueOf(sheetNum));
		// 获取该sheet的总行数，包括空行
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();

		int startNum = Integer.valueOf(beginNum);
		int finalNum = Integer.valueOf(endNum);
		if (startNum <= 0) {
			startNum = 1;
		}

		if (finalNum >= physicalNumberOfRows) {
			finalNum = physicalNumberOfRows;
		}

		if (startNum > finalNum) {
			throw new ClassException("请检查开始行数结束行数");
		}

		for (int i = startNum -1 ; i < finalNum; i++) {
			Row row = sheet.getRow(i);
			ProductDataValue productDataValue = new ProductDataValue();
			Field[] appFields = productDataValue.getClass().getDeclaredFields();
			List<Field> FieldList = new ArrayList<Field>();

			for (int j = 0; j < appFields.length; j++) {
				String name = appFields[j].getName();
				// 赋值到filed属性中
				if (name.startsWith("field")) {
					FieldList.add(appFields[j]);
				}
			}

			int size = FieldList.size();
			Field[] fields = (Field[]) FieldList.toArray(new Field[size]);

			for (Cell cell : row) {
				if ("xls".equals(fileType)) {
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				} else if ("xlsx".equals(fileType)) {
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				}
				for (Field field : fields) {
					try {
						if (field.get(productDataValue) == null) {
							field.set(productDataValue, cell.getStringCellValue());
							break;
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				}

			}

			sheetList.add(productDataValue);

		}

		return sheetList;
	}
	
	/**
	 * 指定读取哪个sheet的内容，并且指定从哪行开始到哪行结束从哪列开始到哪列结束，表头固定都有
	 * @param filePath
	 * @param sheetNum
	 * @param beginNum
	 * @param endNum
	 * @param beginCol
	 * @param endCol
	 * @return
	 * @throws Exception
	 */
	public static List<ProductDataValue> getSheetData(String filePath, String sheetNum, String beginNum, String endNum, String beginCol, String endCol) throws Exception {
		Workbook initExcel = initExcel(filePath);
		// 区分是xls还是xlsx
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
		List<ProductDataValue> sheetList = new ArrayList<ProductDataValue>();
		Sheet sheet = initExcel.getSheetAt(Integer.valueOf(sheetNum));
		// 获取该sheet的总行数，包括空行
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		int physicalNumberOfCols = sheet.getRow(0).getPhysicalNumberOfCells();

		int startNum = Integer.valueOf(beginNum);
		int finalNum = Integer.valueOf(endNum);
		int startCol = Integer.valueOf(beginCol);
		int finalCol = Integer.valueOf(endCol);
		if (startNum <= 0) {
			startNum = 1;
		}

		if (finalNum >= physicalNumberOfRows) {
			finalNum = physicalNumberOfRows;
		}
		if (startCol <= 0) {
			startCol = 1;
		}

		if (finalCol >= physicalNumberOfCols) {
			finalCol = physicalNumberOfCols;
		}

		if (startNum > finalNum) {
			throw new ClassException("请检查开始行数结束行数");
		}
		if (startCol > finalCol) {
			throw new ClassException("请检查开始列数结束列数");
		}
		ProductDataValue productDataValue1 = new ProductDataValue();
		Field[] appFields = productDataValue1.getClass().getDeclaredFields();
		List<Field> FieldList = new ArrayList<Field>();
		for (int j = 0; j < appFields.length; j++) {
			String name = appFields[j].getName();
			// 赋值到filed属性中
			if (name.startsWith("field")) {
				FieldList.add(appFields[j]);
			}
		}
		int size = FieldList.size();
		Field[] fields = (Field[]) FieldList.toArray(new Field[size]);
		
		for (int i = startNum -1 ; i < finalNum; i++) {
			
			Row row = sheet.getRow(i);
			if(row == null){
				continue;
			}
			ProductDataValue productDataValue = new ProductDataValue();
			for (int k = startCol -1; k < finalCol; k++ ) {
				if(row.getCell(k) == null){
					continue;
				}
				if ("xls".equals(fileType)) {
					row.getCell(k).setCellType(HSSFCell.CELL_TYPE_STRING);
				} else if ("xlsx".equals(fileType)) {
					row.getCell(k).setCellType(XSSFCell.CELL_TYPE_STRING);
				}
				try {
					if (fields[k].get(productDataValue) == null) {
						fields[k].set(productDataValue, row.getCell(k).getStringCellValue());
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}

			sheetList.add(productDataValue);

		}

		return sheetList;
	}
	
	/**
	 * 获取指定sheet页的列数
	 * @param filePath
	 * @param sheetNum
	 * @return
	 * @throws Exception
	 */
	public static int getSheetLie(String filePath,String sheetNum) throws Exception {
		Workbook initExcel = initExcel(filePath);
		Sheet sheet = initExcel.getSheetAt(Integer.valueOf(sheetNum));
		int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();//获得总列数
		return coloumNum;
	}
	
	
	public static int getSheetLine(String filePath,String sheetNum) throws Exception {
		Workbook initExcel = initExcel(filePath);
		Sheet sheet = initExcel.getSheetAt(Integer.valueOf(sheetNum));
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		return physicalNumberOfRows;
	}
	
	public static void main(String[] args) {
		try {
			/*int sheetLie = getSheetLie("C:/Users/zhanxiaolin-n22/Desktop/2.xls","0");
			System.out.println(sheetLie);
			int sheetNum = getSheetNum("C:/Users/zhanxiaolin-n22/Desktop/2.xls");
			System.out.println(sheetNum);
			
			List<ExcelModel> sheetName = getSheetName("C:/Users/zhanxiaolin-n22/Desktop/2.xls");
			System.out.println(sheetName);*/
			
			List<ProductDataValue> sheetData = getSheetData("C:/Users/zhanxiaolin-n22/Desktop/2.xls","0","1","1");
			System.out.println(sheetData);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public static void getHSSFWorkbook(HttpServletResponse response ,String fileName ,String sheetName,String []title,String [][]values, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        sheet.setColumnWidth(0, 256*27+184);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        //HSSFCellStyle style = wb.createCellStyle();
        //设置上下  
       // style.setAlignment(HorizontalAlignment.CENTER);  
        //设置左右  
        //style.setVerticalAlignment(VerticalAlignment.CENTER);  

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
        	sheet.setColumnWidth(i, 256*27+184);
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            //cell.setCellStyle(style);
        }

        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
      //响应到客户端
	  try {
		  	setResponseHeader(response, fileName);
		  	OutputStream os = response.getOutputStream();
	        wb.write(os);
	        os.flush();
	        os.close();
	   } catch (Exception e) {
	         e.printStackTrace();
	   }
	       // return wb;
	    }
  //发送响应流方法
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
