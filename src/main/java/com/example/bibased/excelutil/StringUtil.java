package com.example.bibased.excelutil;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * String工具类
 */
public class StringUtil {
	/**
	 * 拼接值
	 */
	@SuppressWarnings("rawtypes")
	public static String getSqlInValuesFromList(List list,String propertyName) throws Exception{
		StringBuffer buffer = new StringBuffer("");
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				Object obj = list.get(i);
				String methodname = "get" + propertyName.substring(0,1).toUpperCase() + propertyName.substring(1);
				Method method = obj.getClass().getMethod(methodname);
				Object value = method.invoke(obj);
				if(value!=null){
					if(!buffer.toString().equals("")){
						buffer.append(",");
					}
					buffer.append("'" + value.toString() + "'");
				}
			}
		}
		return buffer.toString();
	}
	/**
	 * 值转换，如果original与target值相同，则返回defaultvalue，否则返回original
	 */
	public static String transferValue(String original,String target,String defaultvalue){
		String var = defaultvalue;
		if(!equalTrimIgnoreCase(original,target)){
			return original;
		}
		return var;
	}
	
	public static boolean isblank(String str) {
		if (str == null || str.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean equalTrim(String str1,String str2){
		if(str1==null && str2==null){
			return true;
		}
		if(str1!=null && str2!=null){
			if(str1.trim().equals(str2.trim())){
				return true;
			}
		}
		return false;
	}
	
	public static boolean equalTrimIgnoreCase(String str1,String str2){
		if(str1==null && str2==null){
			return true;
		}
		if(str1!=null && str2!=null){
			if(str1.trim().toLowerCase().equals(str2.trim().toLowerCase())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 防止出现科学计算法,将数字转换成string num->保留小数点位数
	 */
	public static String changeNumToStr(double f, int num) {
		String str = "";
		if (num > 0) {
			str += "0.";
		}
		for (int i = 0; i < num; i++) {
			str = str + "0";
		}
		str = "##########" + str;
		DecimalFormat df = new DecimalFormat(str);
		String numstr = df.format(f);
		return numstr;
	}

	/**
	 * 防止出现科学计算法,将数字转换成string num->保留小数点位数
	 */
	public static String changeNumToStr(float f, int num) {
		String str = "";
		if (num > 0) {
			str += "0.";
		}
		for (int i = 0; i < num; i++) {
			str = str + "0";
		}
		str = "##########" + str;
		DecimalFormat df = new DecimalFormat(str);
		String numstr = df.format(f);
		return numstr;
	}

	/**
	 * 将Clob转换成String
	 */
	public static String convertClobToString(Clob clob) throws SQLException,
			IOException {
		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();

		return reString;
	}

	/**
	 * 将Blob转换成String
	 */
	public static String convertBlobToString(Blob blob) throws SQLException {
		String value = null;
		StringBuffer buffer = new StringBuffer("");
		byte[] bytes = blob.getBytes(1L, (int) blob.length());
		if (bytes != null && bytes.length > 0) {
			for (int i = 0; i < bytes.length; i++) {
				buffer.append(bytes[i]);
			}
			value = buffer.toString();
		}
		System.out.println(value);
		return value;
	}

	/**
	 * 将InputStream 转换成String
	 */
	public static String convertInputSteamToString(InputStream input)
			throws IOException {
		if(input == null){
			return null;
		}
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = input.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}
	
	/**
	 * 将string转成InputStream
	 */
	public static InputStream convertStrToInputSteam(String str){
		if(str==null){
			return null;
		}
		InputStream input = new ByteArrayInputStream(str.getBytes());   
		return input;
	}
	
	/**
	 * 功能：清理小数点之后的0
	 */
	public static String clearZero(String amount){
		if(amount==null || amount.trim().equals("")){
			return "";
		}
		if(Double.parseDouble(amount)==0){
			return "0";
		}
		int i = amount.indexOf(".");
		if(i>=0){
			int k = amount.lastIndexOf("0");
			while(k==amount.length()-1){
				amount = amount.substring(0,amount.length()-1);
				k = amount.lastIndexOf("0");
			}
			
			if(i==amount.length()-1){
				amount = amount.substring(0,amount.length()-1);
			}
		}
		return amount;
	}
	/**
	 * 将java字段转换成数据库字段
	 */
	public static String convertColumnToDataBase(String columnName){
		StringBuffer buffer = new StringBuffer("");
		if(columnName!=null && !columnName.trim().equals("")){
			columnName = columnName.trim();
			for(int i=0;i<columnName.length();i++){
				if(Character.isUpperCase(columnName.charAt(i))){
					buffer.append("_" + Character.toLowerCase(columnName.charAt(i)));
				}else{
					buffer.append(columnName.charAt(i));
				}
			}
		}
		return buffer.toString();
	}
	/**
	 * 如果 value为空  则  返回 defaultValue
	 */
	public static String filterNull(String value,String defaultValue){
		if(isblank(value)){
			return defaultValue;
		}else{
			return value;
		}
	}
	
	/**
	 * 功能：去掉null值
	 */
	public static String filterStringNull(String o){
		if(o==null || o.trim().equals("")){
			return "";
		}
		return o;
	}
	
	public static String getSqlValues(List<String> list){
		StringBuffer buffer =new StringBuffer("");
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				String value = list.get(i);
				if(!buffer.toString().equals("") && !StringUtil.isblank(value)){
					buffer.append(",");
				}
				if(!StringUtil.isblank(value)){
					buffer.append("'" + value + "'");
				}
			}
		}
		return buffer.toString();
	}
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("121");
		list.add("2334");
		System.out.println(getSqlValues(list));
	}
}
