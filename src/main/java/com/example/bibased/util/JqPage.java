package com.example.bibased.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class JqPage implements Serializable
{
protected Logger logger = LoggerFactory.getLogger(this.getClass());
private static final long serialVersionUID = 5192357666324600054L;
public static final String ASC = "asc";
public static final String DESC = "desc";
protected int pageNo;
protected int pageSize;
protected String orderBy = null;
protected String orderType = null;
protected boolean autoCount = true;
protected int start = 0;

protected List resultList = new ArrayList();
protected long totalCount = -1L;

protected String  limit;   //页面大小
protected String  offset;
protected String searchText;

public JqPage()
{
}



public String getSearchText() {
	return searchText;
}



public void setSearchText(String searchText) {
	this.searchText = searchText;
}



public String getOrderBy() {
	return orderBy;
}

public void setOrderBy(String orderBy) {
	this.orderBy = orderBy;
}

public String getOrderType() {
	return orderType;
}

public void setOrderType(String orderType) {
	this.orderType = orderType;
}

public JqPage(int paramInt)
{
  this.pageSize = paramInt;
}

public String getLimit() {
	return limit;
}

public void setLimit(String limit) {
	this.limit = limit;
}

public String getOffset() {
	return offset;
}

public void setOffset(String offset) {
	this.offset = offset;
}

public JqPage(int paramInt1, int paramInt2) {
  this.pageNo = paramInt1;
  this.pageSize = paramInt2;
}

public int getPageNo()
{
  return this.pageNo;
}

public void setPageNo(int pageNo)
{
  this.pageNo = pageNo;

  if (pageNo < 1)
    this.pageNo = 1;
}

public JqPage pageNo(int thePageNo)
{
  setPageNo(thePageNo);
  return this;
}

public int getPageSize()
{
  return this.pageSize;
}

public void setPageSize(int pageSize)
{
  this.pageSize = pageSize;

  if (pageSize < 1)
    this.pageSize = 1;
}

public JqPage pageSize(int thePageSize)
{
  setPageSize(thePageSize);
  return this;
}

public int getFirst()
{
  if (this.start != 0)
    return this.start + 1;
  return (this.pageNo - 1) * this.pageSize + 1;
}

public void setStart(int start) {
  this.start = start;
}

public String getOrderFields()
{
  return this.orderBy;
}

public void setOrderFields(String orderFields)
{
  this.orderBy = orderFields;
}

public JqPage orderFields(String theOrderFields) {
  setOrderFields(theOrderFields);
  return this;
}

public String getOrder()
{
  return this.orderType;
}

/*public void setOrder(String order)
{
  String[] arrayOfString = StringUtils.split(StringUtils.lowerCase(order), ',');

  for (int i = 0; i < arrayOfString.length; i++) {
    String str = arrayOfString[i];
    if ((!StringUtils.equals("desc", str)) && (!StringUtils.equals("asc", str)))
    {
      throw new IllegalArgumentException("排序方向" + str + "不是合法值");
    }
  }

  this.orderType = StringUtils.lowerCase(order);
}*/

/*public JqPage order(String theOrder) {
  setOrder(theOrder);
  return this;
}*/

/*
public boolean isOrderFieldsSetted()
{
  return (StringUtils.isNotBlank(this.orderBy)) && (StringUtils.isNotBlank(this.orderType));
}
*/

public boolean isAutoCount()
{
  return this.autoCount;
}

public void setAutoCount(boolean autoCount)
{
  this.autoCount = autoCount;
}

public JqPage autoCount(boolean theAutoCount) {
  setAutoCount(theAutoCount);
  return this;
}

public List getResult()
{
  return this.resultList;
}

public void setResult(List result)
{
  this.resultList = result;
}

public long getTotalCount()
{
  return this.totalCount;
}

public void setTotalCount(long totalCount)
{
  this.totalCount = totalCount;
}

public long getTotalPages()
{
  if (this.totalCount < 0L) {
    return -1L;
  }

  long l = this.totalCount / this.pageSize;
  if (this.totalCount % this.pageSize > 0L) {
    l += 1L;
  }
  return l;
}

public boolean isHasNext()
{
  return this.pageNo + 1 <= getTotalPages();
}

public int getNextPage()
{
  if (isHasNext()) {
    return this.pageNo + 1;
  }
  return this.pageNo;
}

public boolean isHasPre()
{
  return this.pageNo - 1 >= 1;
}

public int getPrePage()
{
  if (isHasPre()) {
    return this.pageNo - 1;
  }
  return this.pageNo;
}

public int getStart()
{
  return this.start;
}
}
