package com.example.bibased.javabean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DianpuMstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DianpuMstExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("Id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("Id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andDianmingIsNull() {
            addCriterion("dianming is null");
            return (Criteria) this;
        }

        public Criteria andDianmingIsNotNull() {
            addCriterion("dianming is not null");
            return (Criteria) this;
        }

        public Criteria andDianmingEqualTo(String value) {
            addCriterion("dianming =", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingNotEqualTo(String value) {
            addCriterion("dianming <>", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingGreaterThan(String value) {
            addCriterion("dianming >", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingGreaterThanOrEqualTo(String value) {
            addCriterion("dianming >=", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingLessThan(String value) {
            addCriterion("dianming <", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingLessThanOrEqualTo(String value) {
            addCriterion("dianming <=", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingLike(String value) {
            addCriterion("dianming like", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingNotLike(String value) {
            addCriterion("dianming not like", value, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingIn(List<String> values) {
            addCriterion("dianming in", values, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingNotIn(List<String> values) {
            addCriterion("dianming not in", values, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingBetween(String value1, String value2) {
            addCriterion("dianming between", value1, value2, "dianming");
            return (Criteria) this;
        }

        public Criteria andDianmingNotBetween(String value1, String value2) {
            addCriterion("dianming not between", value1, value2, "dianming");
            return (Criteria) this;
        }

        public Criteria andNeirong1IsNull() {
            addCriterion("neirong1 is null");
            return (Criteria) this;
        }

        public Criteria andNeirong1IsNotNull() {
            addCriterion("neirong1 is not null");
            return (Criteria) this;
        }

        public Criteria andNeirong1EqualTo(String value) {
            addCriterion("neirong1 =", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1NotEqualTo(String value) {
            addCriterion("neirong1 <>", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1GreaterThan(String value) {
            addCriterion("neirong1 >", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1GreaterThanOrEqualTo(String value) {
            addCriterion("neirong1 >=", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1LessThan(String value) {
            addCriterion("neirong1 <", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1LessThanOrEqualTo(String value) {
            addCriterion("neirong1 <=", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1Like(String value) {
            addCriterion("neirong1 like", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1NotLike(String value) {
            addCriterion("neirong1 not like", value, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1In(List<String> values) {
            addCriterion("neirong1 in", values, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1NotIn(List<String> values) {
            addCriterion("neirong1 not in", values, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1Between(String value1, String value2) {
            addCriterion("neirong1 between", value1, value2, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong1NotBetween(String value1, String value2) {
            addCriterion("neirong1 not between", value1, value2, "neirong1");
            return (Criteria) this;
        }

        public Criteria andNeirong2IsNull() {
            addCriterion("neirong2 is null");
            return (Criteria) this;
        }

        public Criteria andNeirong2IsNotNull() {
            addCriterion("neirong2 is not null");
            return (Criteria) this;
        }

        public Criteria andNeirong2EqualTo(String value) {
            addCriterion("neirong2 =", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2NotEqualTo(String value) {
            addCriterion("neirong2 <>", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2GreaterThan(String value) {
            addCriterion("neirong2 >", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2GreaterThanOrEqualTo(String value) {
            addCriterion("neirong2 >=", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2LessThan(String value) {
            addCriterion("neirong2 <", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2LessThanOrEqualTo(String value) {
            addCriterion("neirong2 <=", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2Like(String value) {
            addCriterion("neirong2 like", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2NotLike(String value) {
            addCriterion("neirong2 not like", value, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2In(List<String> values) {
            addCriterion("neirong2 in", values, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2NotIn(List<String> values) {
            addCriterion("neirong2 not in", values, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2Between(String value1, String value2) {
            addCriterion("neirong2 between", value1, value2, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong2NotBetween(String value1, String value2) {
            addCriterion("neirong2 not between", value1, value2, "neirong2");
            return (Criteria) this;
        }

        public Criteria andNeirong3IsNull() {
            addCriterion("neirong3 is null");
            return (Criteria) this;
        }

        public Criteria andNeirong3IsNotNull() {
            addCriterion("neirong3 is not null");
            return (Criteria) this;
        }

        public Criteria andNeirong3EqualTo(String value) {
            addCriterion("neirong3 =", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3NotEqualTo(String value) {
            addCriterion("neirong3 <>", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3GreaterThan(String value) {
            addCriterion("neirong3 >", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3GreaterThanOrEqualTo(String value) {
            addCriterion("neirong3 >=", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3LessThan(String value) {
            addCriterion("neirong3 <", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3LessThanOrEqualTo(String value) {
            addCriterion("neirong3 <=", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3Like(String value) {
            addCriterion("neirong3 like", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3NotLike(String value) {
            addCriterion("neirong3 not like", value, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3In(List<String> values) {
            addCriterion("neirong3 in", values, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3NotIn(List<String> values) {
            addCriterion("neirong3 not in", values, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3Between(String value1, String value2) {
            addCriterion("neirong3 between", value1, value2, "neirong3");
            return (Criteria) this;
        }

        public Criteria andNeirong3NotBetween(String value1, String value2) {
            addCriterion("neirong3 not between", value1, value2, "neirong3");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andDizhiIsNull() {
            addCriterion("dizhi is null");
            return (Criteria) this;
        }

        public Criteria andDizhiIsNotNull() {
            addCriterion("dizhi is not null");
            return (Criteria) this;
        }

        public Criteria andDizhiEqualTo(String value) {
            addCriterion("dizhi =", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotEqualTo(String value) {
            addCriterion("dizhi <>", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiGreaterThan(String value) {
            addCriterion("dizhi >", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiGreaterThanOrEqualTo(String value) {
            addCriterion("dizhi >=", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiLessThan(String value) {
            addCriterion("dizhi <", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiLessThanOrEqualTo(String value) {
            addCriterion("dizhi <=", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiLike(String value) {
            addCriterion("dizhi like", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotLike(String value) {
            addCriterion("dizhi not like", value, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiIn(List<String> values) {
            addCriterion("dizhi in", values, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotIn(List<String> values) {
            addCriterion("dizhi not in", values, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiBetween(String value1, String value2) {
            addCriterion("dizhi between", value1, value2, "dizhi");
            return (Criteria) this;
        }

        public Criteria andDizhiNotBetween(String value1, String value2) {
            addCriterion("dizhi not between", value1, value2, "dizhi");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}