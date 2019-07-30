package com.msr.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ClazzExample {
	protected int startRow;
	protected int pageSize;
	
    public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public ClazzExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
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

        public Criteria andClazzIdIsNull() {
            addCriterion("clazz_id is null");
            return (Criteria) this;
        }

        public Criteria andClazzIdIsNotNull() {
            addCriterion("clazz_id is not null");
            return (Criteria) this;
        }

        public Criteria andClazzIdEqualTo(Integer value) {
            addCriterion("clazz_id =", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdNotEqualTo(Integer value) {
            addCriterion("clazz_id <>", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdGreaterThan(Integer value) {
            addCriterion("clazz_id >", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("clazz_id >=", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdLessThan(Integer value) {
            addCriterion("clazz_id <", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdLessThanOrEqualTo(Integer value) {
            addCriterion("clazz_id <=", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdIn(List<Integer> values) {
            addCriterion("clazz_id in", values, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdNotIn(List<Integer> values) {
            addCriterion("clazz_id not in", values, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdBetween(Integer value1, Integer value2) {
            addCriterion("clazz_id between", value1, value2, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdNotBetween(Integer value1, Integer value2) {
            addCriterion("clazz_id not between", value1, value2, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzNameIsNull() {
            addCriterion("clazz_name is null");
            return (Criteria) this;
        }

        public Criteria andClazzNameIsNotNull() {
            addCriterion("clazz_name is not null");
            return (Criteria) this;
        }

        public Criteria andClazzNameEqualTo(String value) {
            addCriterion("clazz_name =", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotEqualTo(String value) {
            addCriterion("clazz_name <>", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameGreaterThan(String value) {
            addCriterion("clazz_name >", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameGreaterThanOrEqualTo(String value) {
            addCriterion("clazz_name >=", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameLessThan(String value) {
            addCriterion("clazz_name <", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameLessThanOrEqualTo(String value) {
            addCriterion("clazz_name <=", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameLike(String value) {
            addCriterion("clazz_name like", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotLike(String value) {
            addCriterion("clazz_name not like", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameIn(List<String> values) {
            addCriterion("clazz_name in", values, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotIn(List<String> values) {
            addCriterion("clazz_name not in", values, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameBetween(String value1, String value2) {
            addCriterion("clazz_name between", value1, value2, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotBetween(String value1, String value2) {
            addCriterion("clazz_name not between", value1, value2, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzAddressIsNull() {
            addCriterion("clazz_address is null");
            return (Criteria) this;
        }

        public Criteria andClazzAddressIsNotNull() {
            addCriterion("clazz_address is not null");
            return (Criteria) this;
        }

        public Criteria andClazzAddressEqualTo(String value) {
            addCriterion("clazz_address =", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressNotEqualTo(String value) {
            addCriterion("clazz_address <>", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressGreaterThan(String value) {
            addCriterion("clazz_address >", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressGreaterThanOrEqualTo(String value) {
            addCriterion("clazz_address >=", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressLessThan(String value) {
            addCriterion("clazz_address <", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressLessThanOrEqualTo(String value) {
            addCriterion("clazz_address <=", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressLike(String value) {
            addCriterion("clazz_address like", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressNotLike(String value) {
            addCriterion("clazz_address not like", value, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressIn(List<String> values) {
            addCriterion("clazz_address in", values, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressNotIn(List<String> values) {
            addCriterion("clazz_address not in", values, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressBetween(String value1, String value2) {
            addCriterion("clazz_address between", value1, value2, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzAddressNotBetween(String value1, String value2) {
            addCriterion("clazz_address not between", value1, value2, "clazzAddress");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeIsNull() {
            addCriterion("clazz_startTime is null");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeIsNotNull() {
            addCriterion("clazz_startTime is not null");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_startTime =", value, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_startTime <>", value, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("clazz_startTime >", value, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_startTime >=", value, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("clazz_startTime <", value, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_startTime <=", value, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("clazz_startTime in", values, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("clazz_startTime not in", values, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clazz_startTime between", value1, value2, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clazz_startTime not between", value1, value2, "clazzStarttime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeIsNull() {
            addCriterion("clazz_endTime is null");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeIsNotNull() {
            addCriterion("clazz_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_endTime =", value, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_endTime <>", value, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("clazz_endTime >", value, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_endTime >=", value, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("clazz_endTime <", value, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clazz_endTime <=", value, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("clazz_endTime in", values, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("clazz_endTime not in", values, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clazz_endTime between", value1, value2, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clazz_endTime not between", value1, value2, "clazzEndtime");
            return (Criteria) this;
        }

        public Criteria andClazzStatusIsNull() {
            addCriterion("clazz_status is null");
            return (Criteria) this;
        }

        public Criteria andClazzStatusIsNotNull() {
            addCriterion("clazz_status is not null");
            return (Criteria) this;
        }

        public Criteria andClazzStatusEqualTo(Integer value) {
            addCriterion("clazz_status =", value, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusNotEqualTo(Integer value) {
            addCriterion("clazz_status <>", value, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusGreaterThan(Integer value) {
            addCriterion("clazz_status >", value, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("clazz_status >=", value, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusLessThan(Integer value) {
            addCriterion("clazz_status <", value, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusLessThanOrEqualTo(Integer value) {
            addCriterion("clazz_status <=", value, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusIn(List<Integer> values) {
            addCriterion("clazz_status in", values, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusNotIn(List<Integer> values) {
            addCriterion("clazz_status not in", values, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusBetween(Integer value1, Integer value2) {
            addCriterion("clazz_status between", value1, value2, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("clazz_status not between", value1, value2, "clazzStatus");
            return (Criteria) this;
        }

        public Criteria andClazzNoteIsNull() {
            addCriterion("clazz_note is null");
            return (Criteria) this;
        }

        public Criteria andClazzNoteIsNotNull() {
            addCriterion("clazz_note is not null");
            return (Criteria) this;
        }

        public Criteria andClazzNoteEqualTo(String value) {
            addCriterion("clazz_note =", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteNotEqualTo(String value) {
            addCriterion("clazz_note <>", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteGreaterThan(String value) {
            addCriterion("clazz_note >", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteGreaterThanOrEqualTo(String value) {
            addCriterion("clazz_note >=", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteLessThan(String value) {
            addCriterion("clazz_note <", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteLessThanOrEqualTo(String value) {
            addCriterion("clazz_note <=", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteLike(String value) {
            addCriterion("clazz_note like", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteNotLike(String value) {
            addCriterion("clazz_note not like", value, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteIn(List<String> values) {
            addCriterion("clazz_note in", values, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteNotIn(List<String> values) {
            addCriterion("clazz_note not in", values, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteBetween(String value1, String value2) {
            addCriterion("clazz_note between", value1, value2, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andClazzNoteNotBetween(String value1, String value2) {
            addCriterion("clazz_note not between", value1, value2, "clazzNote");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table clazz
     *
     * @mbggenerated do_not_delete_during_merge Mon Jul 08 10:48:09 JST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
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