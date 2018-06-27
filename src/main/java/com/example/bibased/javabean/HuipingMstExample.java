package com.example.bibased.javabean;

import java.util.ArrayList;
import java.util.List;

public class HuipingMstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HuipingMstExample() {
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

        public Criteria andYuanuserIsNull() {
            addCriterion("yuanuser is null");
            return (Criteria) this;
        }

        public Criteria andYuanuserIsNotNull() {
            addCriterion("yuanuser is not null");
            return (Criteria) this;
        }

        public Criteria andYuanuserEqualTo(String value) {
            addCriterion("yuanuser =", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserNotEqualTo(String value) {
            addCriterion("yuanuser <>", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserGreaterThan(String value) {
            addCriterion("yuanuser >", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserGreaterThanOrEqualTo(String value) {
            addCriterion("yuanuser >=", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserLessThan(String value) {
            addCriterion("yuanuser <", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserLessThanOrEqualTo(String value) {
            addCriterion("yuanuser <=", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserLike(String value) {
            addCriterion("yuanuser like", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserNotLike(String value) {
            addCriterion("yuanuser not like", value, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserIn(List<String> values) {
            addCriterion("yuanuser in", values, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserNotIn(List<String> values) {
            addCriterion("yuanuser not in", values, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserBetween(String value1, String value2) {
            addCriterion("yuanuser between", value1, value2, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andYuanuserNotBetween(String value1, String value2) {
            addCriterion("yuanuser not between", value1, value2, "yuanuser");
            return (Criteria) this;
        }

        public Criteria andNewuserIsNull() {
            addCriterion("newuser is null");
            return (Criteria) this;
        }

        public Criteria andNewuserIsNotNull() {
            addCriterion("newuser is not null");
            return (Criteria) this;
        }

        public Criteria andNewuserEqualTo(String value) {
            addCriterion("newuser =", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotEqualTo(String value) {
            addCriterion("newuser <>", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserGreaterThan(String value) {
            addCriterion("newuser >", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserGreaterThanOrEqualTo(String value) {
            addCriterion("newuser >=", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserLessThan(String value) {
            addCriterion("newuser <", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserLessThanOrEqualTo(String value) {
            addCriterion("newuser <=", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserLike(String value) {
            addCriterion("newuser like", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotLike(String value) {
            addCriterion("newuser not like", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserIn(List<String> values) {
            addCriterion("newuser in", values, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotIn(List<String> values) {
            addCriterion("newuser not in", values, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserBetween(String value1, String value2) {
            addCriterion("newuser between", value1, value2, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotBetween(String value1, String value2) {
            addCriterion("newuser not between", value1, value2, "newuser");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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