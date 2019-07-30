package com.msr.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendanceExample() {
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

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Integer value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Integer value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Integer value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Integer value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Integer value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Integer> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Integer> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Integer value1, Integer value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andADateIsNull() {
            addCriterion("a_date is null");
            return (Criteria) this;
        }

        public Criteria andADateIsNotNull() {
            addCriterion("a_date is not null");
            return (Criteria) this;
        }

        public Criteria andADateEqualTo(Date value) {
            addCriterionForJDBCDate("a_date =", value, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateNotEqualTo(Date value) {
            addCriterionForJDBCDate("a_date <>", value, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateGreaterThan(Date value) {
            addCriterionForJDBCDate("a_date >", value, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("a_date >=", value, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateLessThan(Date value) {
            addCriterionForJDBCDate("a_date <", value, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("a_date <=", value, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateIn(List<Date> values) {
            addCriterionForJDBCDate("a_date in", values, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateNotIn(List<Date> values) {
            addCriterionForJDBCDate("a_date not in", values, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("a_date between", value1, value2, "aDate");
            return (Criteria) this;
        }

        public Criteria andADateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("a_date not between", value1, value2, "aDate");
            return (Criteria) this;
        }

        public Criteria andA1IsNull() {
            addCriterion("a_1 is null");
            return (Criteria) this;
        }

        public Criteria andA1IsNotNull() {
            addCriterion("a_1 is not null");
            return (Criteria) this;
        }

        public Criteria andA1EqualTo(String value) {
            addCriterion("a_1 =", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotEqualTo(String value) {
            addCriterion("a_1 <>", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThan(String value) {
            addCriterion("a_1 >", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThanOrEqualTo(String value) {
            addCriterion("a_1 >=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThan(String value) {
            addCriterion("a_1 <", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThanOrEqualTo(String value) {
            addCriterion("a_1 <=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1Like(String value) {
            addCriterion("a_1 like", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotLike(String value) {
            addCriterion("a_1 not like", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1In(List<String> values) {
            addCriterion("a_1 in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotIn(List<String> values) {
            addCriterion("a_1 not in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1Between(String value1, String value2) {
            addCriterion("a_1 between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotBetween(String value1, String value2) {
            addCriterion("a_1 not between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA2IsNull() {
            addCriterion("a_2 is null");
            return (Criteria) this;
        }

        public Criteria andA2IsNotNull() {
            addCriterion("a_2 is not null");
            return (Criteria) this;
        }

        public Criteria andA2EqualTo(String value) {
            addCriterion("a_2 =", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotEqualTo(String value) {
            addCriterion("a_2 <>", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThan(String value) {
            addCriterion("a_2 >", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThanOrEqualTo(String value) {
            addCriterion("a_2 >=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThan(String value) {
            addCriterion("a_2 <", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThanOrEqualTo(String value) {
            addCriterion("a_2 <=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Like(String value) {
            addCriterion("a_2 like", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotLike(String value) {
            addCriterion("a_2 not like", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2In(List<String> values) {
            addCriterion("a_2 in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotIn(List<String> values) {
            addCriterion("a_2 not in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Between(String value1, String value2) {
            addCriterion("a_2 between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotBetween(String value1, String value2) {
            addCriterion("a_2 not between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA3IsNull() {
            addCriterion("a_3 is null");
            return (Criteria) this;
        }

        public Criteria andA3IsNotNull() {
            addCriterion("a_3 is not null");
            return (Criteria) this;
        }

        public Criteria andA3EqualTo(String value) {
            addCriterion("a_3 =", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotEqualTo(String value) {
            addCriterion("a_3 <>", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThan(String value) {
            addCriterion("a_3 >", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThanOrEqualTo(String value) {
            addCriterion("a_3 >=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThan(String value) {
            addCriterion("a_3 <", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThanOrEqualTo(String value) {
            addCriterion("a_3 <=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Like(String value) {
            addCriterion("a_3 like", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotLike(String value) {
            addCriterion("a_3 not like", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3In(List<String> values) {
            addCriterion("a_3 in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotIn(List<String> values) {
            addCriterion("a_3 not in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Between(String value1, String value2) {
            addCriterion("a_3 between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotBetween(String value1, String value2) {
            addCriterion("a_3 not between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA4IsNull() {
            addCriterion("a_4 is null");
            return (Criteria) this;
        }

        public Criteria andA4IsNotNull() {
            addCriterion("a_4 is not null");
            return (Criteria) this;
        }

        public Criteria andA4EqualTo(String value) {
            addCriterion("a_4 =", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotEqualTo(String value) {
            addCriterion("a_4 <>", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThan(String value) {
            addCriterion("a_4 >", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThanOrEqualTo(String value) {
            addCriterion("a_4 >=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThan(String value) {
            addCriterion("a_4 <", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThanOrEqualTo(String value) {
            addCriterion("a_4 <=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4Like(String value) {
            addCriterion("a_4 like", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotLike(String value) {
            addCriterion("a_4 not like", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4In(List<String> values) {
            addCriterion("a_4 in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotIn(List<String> values) {
            addCriterion("a_4 not in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4Between(String value1, String value2) {
            addCriterion("a_4 between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotBetween(String value1, String value2) {
            addCriterion("a_4 not between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andA5IsNull() {
            addCriterion("a_5 is null");
            return (Criteria) this;
        }

        public Criteria andA5IsNotNull() {
            addCriterion("a_5 is not null");
            return (Criteria) this;
        }

        public Criteria andA5EqualTo(String value) {
            addCriterion("a_5 =", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotEqualTo(String value) {
            addCriterion("a_5 <>", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5GreaterThan(String value) {
            addCriterion("a_5 >", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5GreaterThanOrEqualTo(String value) {
            addCriterion("a_5 >=", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5LessThan(String value) {
            addCriterion("a_5 <", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5LessThanOrEqualTo(String value) {
            addCriterion("a_5 <=", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5Like(String value) {
            addCriterion("a_5 like", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotLike(String value) {
            addCriterion("a_5 not like", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5In(List<String> values) {
            addCriterion("a_5 in", values, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotIn(List<String> values) {
            addCriterion("a_5 not in", values, "a5");
            return (Criteria) this;
        }

        public Criteria andA5Between(String value1, String value2) {
            addCriterion("a_5 between", value1, value2, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotBetween(String value1, String value2) {
            addCriterion("a_5 not between", value1, value2, "a5");
            return (Criteria) this;
        }

        public Criteria andA6IsNull() {
            addCriterion("a_6 is null");
            return (Criteria) this;
        }

        public Criteria andA6IsNotNull() {
            addCriterion("a_6 is not null");
            return (Criteria) this;
        }

        public Criteria andA6EqualTo(String value) {
            addCriterion("a_6 =", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotEqualTo(String value) {
            addCriterion("a_6 <>", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6GreaterThan(String value) {
            addCriterion("a_6 >", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6GreaterThanOrEqualTo(String value) {
            addCriterion("a_6 >=", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6LessThan(String value) {
            addCriterion("a_6 <", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6LessThanOrEqualTo(String value) {
            addCriterion("a_6 <=", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6Like(String value) {
            addCriterion("a_6 like", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotLike(String value) {
            addCriterion("a_6 not like", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6In(List<String> values) {
            addCriterion("a_6 in", values, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotIn(List<String> values) {
            addCriterion("a_6 not in", values, "a6");
            return (Criteria) this;
        }

        public Criteria andA6Between(String value1, String value2) {
            addCriterion("a_6 between", value1, value2, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotBetween(String value1, String value2) {
            addCriterion("a_6 not between", value1, value2, "a6");
            return (Criteria) this;
        }

        public Criteria andA7IsNull() {
            addCriterion("a_7 is null");
            return (Criteria) this;
        }

        public Criteria andA7IsNotNull() {
            addCriterion("a_7 is not null");
            return (Criteria) this;
        }

        public Criteria andA7EqualTo(String value) {
            addCriterion("a_7 =", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7NotEqualTo(String value) {
            addCriterion("a_7 <>", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7GreaterThan(String value) {
            addCriterion("a_7 >", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7GreaterThanOrEqualTo(String value) {
            addCriterion("a_7 >=", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7LessThan(String value) {
            addCriterion("a_7 <", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7LessThanOrEqualTo(String value) {
            addCriterion("a_7 <=", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7Like(String value) {
            addCriterion("a_7 like", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7NotLike(String value) {
            addCriterion("a_7 not like", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7In(List<String> values) {
            addCriterion("a_7 in", values, "a7");
            return (Criteria) this;
        }

        public Criteria andA7NotIn(List<String> values) {
            addCriterion("a_7 not in", values, "a7");
            return (Criteria) this;
        }

        public Criteria andA7Between(String value1, String value2) {
            addCriterion("a_7 between", value1, value2, "a7");
            return (Criteria) this;
        }

        public Criteria andA7NotBetween(String value1, String value2) {
            addCriterion("a_7 not between", value1, value2, "a7");
            return (Criteria) this;
        }

        public Criteria andA8IsNull() {
            addCriterion("a_8 is null");
            return (Criteria) this;
        }

        public Criteria andA8IsNotNull() {
            addCriterion("a_8 is not null");
            return (Criteria) this;
        }

        public Criteria andA8EqualTo(String value) {
            addCriterion("a_8 =", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8NotEqualTo(String value) {
            addCriterion("a_8 <>", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8GreaterThan(String value) {
            addCriterion("a_8 >", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8GreaterThanOrEqualTo(String value) {
            addCriterion("a_8 >=", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8LessThan(String value) {
            addCriterion("a_8 <", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8LessThanOrEqualTo(String value) {
            addCriterion("a_8 <=", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8Like(String value) {
            addCriterion("a_8 like", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8NotLike(String value) {
            addCriterion("a_8 not like", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8In(List<String> values) {
            addCriterion("a_8 in", values, "a8");
            return (Criteria) this;
        }

        public Criteria andA8NotIn(List<String> values) {
            addCriterion("a_8 not in", values, "a8");
            return (Criteria) this;
        }

        public Criteria andA8Between(String value1, String value2) {
            addCriterion("a_8 between", value1, value2, "a8");
            return (Criteria) this;
        }

        public Criteria andA8NotBetween(String value1, String value2) {
            addCriterion("a_8 not between", value1, value2, "a8");
            return (Criteria) this;
        }

        public Criteria andATypeIsNull() {
            addCriterion("a_type is null");
            return (Criteria) this;
        }

        public Criteria andATypeIsNotNull() {
            addCriterion("a_type is not null");
            return (Criteria) this;
        }

        public Criteria andATypeEqualTo(String value) {
            addCriterion("a_type =", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotEqualTo(String value) {
            addCriterion("a_type <>", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeGreaterThan(String value) {
            addCriterion("a_type >", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeGreaterThanOrEqualTo(String value) {
            addCriterion("a_type >=", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeLessThan(String value) {
            addCriterion("a_type <", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeLessThanOrEqualTo(String value) {
            addCriterion("a_type <=", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeLike(String value) {
            addCriterion("a_type like", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotLike(String value) {
            addCriterion("a_type not like", value, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeIn(List<String> values) {
            addCriterion("a_type in", values, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotIn(List<String> values) {
            addCriterion("a_type not in", values, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeBetween(String value1, String value2) {
            addCriterion("a_type between", value1, value2, "aType");
            return (Criteria) this;
        }

        public Criteria andATypeNotBetween(String value1, String value2) {
            addCriterion("a_type not between", value1, value2, "aType");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
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