package cn.cqu.vspace.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReviewExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReviewExample() {
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

        public Criteria andReviewIdIsNull() {
            addCriterion("REVIEW_ID is null");
            return (Criteria) this;
        }

        public Criteria andReviewIdIsNotNull() {
            addCriterion("REVIEW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReviewIdEqualTo(Integer value) {
            addCriterion("REVIEW_ID =", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotEqualTo(Integer value) {
            addCriterion("REVIEW_ID <>", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThan(Integer value) {
            addCriterion("REVIEW_ID >", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REVIEW_ID >=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThan(Integer value) {
            addCriterion("REVIEW_ID <", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThanOrEqualTo(Integer value) {
            addCriterion("REVIEW_ID <=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdIn(List<Integer> values) {
            addCriterion("REVIEW_ID in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotIn(List<Integer> values) {
            addCriterion("REVIEW_ID not in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdBetween(Integer value1, Integer value2) {
            addCriterion("REVIEW_ID between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REVIEW_ID not between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("BLOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("BLOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("BLOG_ID =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("BLOG_ID <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("BLOG_ID >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BLOG_ID >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("BLOG_ID <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("BLOG_ID <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("BLOG_ID in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("BLOG_ID not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("BLOG_ID between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BLOG_ID not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andReviewRateIsNull() {
            addCriterion("REVIEW_RATE is null");
            return (Criteria) this;
        }

        public Criteria andReviewRateIsNotNull() {
            addCriterion("REVIEW_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andReviewRateEqualTo(String value) {
            addCriterion("REVIEW_RATE =", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateNotEqualTo(String value) {
            addCriterion("REVIEW_RATE <>", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateGreaterThan(String value) {
            addCriterion("REVIEW_RATE >", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEW_RATE >=", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateLessThan(String value) {
            addCriterion("REVIEW_RATE <", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateLessThanOrEqualTo(String value) {
            addCriterion("REVIEW_RATE <=", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateLike(String value) {
            addCriterion("REVIEW_RATE like", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateNotLike(String value) {
            addCriterion("REVIEW_RATE not like", value, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateIn(List<String> values) {
            addCriterion("REVIEW_RATE in", values, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateNotIn(List<String> values) {
            addCriterion("REVIEW_RATE not in", values, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateBetween(String value1, String value2) {
            addCriterion("REVIEW_RATE between", value1, value2, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewRateNotBetween(String value1, String value2) {
            addCriterion("REVIEW_RATE not between", value1, value2, "reviewRate");
            return (Criteria) this;
        }

        public Criteria andReviewHotIsNull() {
            addCriterion("REVIEW_HOT is null");
            return (Criteria) this;
        }

        public Criteria andReviewHotIsNotNull() {
            addCriterion("REVIEW_HOT is not null");
            return (Criteria) this;
        }

        public Criteria andReviewHotEqualTo(String value) {
            addCriterion("REVIEW_HOT =", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotNotEqualTo(String value) {
            addCriterion("REVIEW_HOT <>", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotGreaterThan(String value) {
            addCriterion("REVIEW_HOT >", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEW_HOT >=", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotLessThan(String value) {
            addCriterion("REVIEW_HOT <", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotLessThanOrEqualTo(String value) {
            addCriterion("REVIEW_HOT <=", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotLike(String value) {
            addCriterion("REVIEW_HOT like", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotNotLike(String value) {
            addCriterion("REVIEW_HOT not like", value, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotIn(List<String> values) {
            addCriterion("REVIEW_HOT in", values, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotNotIn(List<String> values) {
            addCriterion("REVIEW_HOT not in", values, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotBetween(String value1, String value2) {
            addCriterion("REVIEW_HOT between", value1, value2, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewHotNotBetween(String value1, String value2) {
            addCriterion("REVIEW_HOT not between", value1, value2, "reviewHot");
            return (Criteria) this;
        }

        public Criteria andReviewDateIsNull() {
            addCriterion("REVIEW_DATE is null");
            return (Criteria) this;
        }

        public Criteria andReviewDateIsNotNull() {
            addCriterion("REVIEW_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andReviewDateEqualTo(String value) {
            addCriterion("REVIEW_DATE =", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateNotEqualTo(String value) {
            addCriterion("REVIEW_DATE <>", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateGreaterThan(String value) {
            addCriterion("REVIEW_DATE >", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEW_DATE >=", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateLessThan(String value) {
            addCriterion("REVIEW_DATE <", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateLessThanOrEqualTo(String value) {
            addCriterion("REVIEW_DATE <=", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateLike(String value) {
            addCriterion("REVIEW_DATE like", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateNotLike(String value) {
            addCriterion("REVIEW_DATE not like", value, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateIn(List<String> values) {
            addCriterion("REVIEW_DATE in", values, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateNotIn(List<String> values) {
            addCriterion("REVIEW_DATE not in", values, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateBetween(String value1, String value2) {
            addCriterion("REVIEW_DATE between", value1, value2, "reviewDate");
            return (Criteria) this;
        }

        public Criteria andReviewDateNotBetween(String value1, String value2) {
            addCriterion("REVIEW_DATE not between", value1, value2, "reviewDate");
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