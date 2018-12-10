package com.example.bibased.excelutil;


public class ExcelModel extends BaseObject {
	private static final long serialVersionUID = 4066620883719108053L;
	
	//当前是第几个sheet页
	private String sheetNumber;
	//sheet页的名称
	private String sheetName;
	//excel名称
	private String excelName;
	//导入开始行数
	private String beginNum;
	//导入结束行数
	private String endNum;
	//导入开始列数
	private String beginCol;
	//导入结束列数
	private String endCol;
	
	public String getSheetNumber() {
		return sheetNumber;
	}

	public void setSheetNumber(String sheetNumber) {
		this.sheetNumber = sheetNumber;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	public String getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(String beginNum) {
		this.beginNum = beginNum;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

	public String getBeginCol() {
		return beginCol;
	}

	public void setBeginCol(String beginCol) {
		this.beginCol = beginCol;
	}

	public String getEndCol() {
		return endCol;
	}

	public void setEndCol(String endCol) {
		this.endCol = endCol;
	}
	
	
	
	
	
	
}