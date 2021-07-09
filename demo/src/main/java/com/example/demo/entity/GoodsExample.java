package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("GOODS_ID like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("GOODS_ID not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("GOODS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("GOODS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("GOODS_NAME =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("GOODS_NAME <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("GOODS_NAME >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_NAME >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("GOODS_NAME <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("GOODS_NAME <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("GOODS_NAME like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("GOODS_NAME not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("GOODS_NAME in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("GOODS_NAME not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("GOODS_NAME between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("GOODS_NAME not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsRateIsNull() {
            addCriterion("GOODS_RATE is null");
            return (Criteria) this;
        }

        public Criteria andGoodsRateIsNotNull() {
            addCriterion("GOODS_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsRateEqualTo(String value) {
            addCriterion("GOODS_RATE =", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateNotEqualTo(String value) {
            addCriterion("GOODS_RATE <>", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateGreaterThan(String value) {
            addCriterion("GOODS_RATE >", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_RATE >=", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateLessThan(String value) {
            addCriterion("GOODS_RATE <", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateLessThanOrEqualTo(String value) {
            addCriterion("GOODS_RATE <=", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateLike(String value) {
            addCriterion("GOODS_RATE like", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateNotLike(String value) {
            addCriterion("GOODS_RATE not like", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateIn(List<String> values) {
            addCriterion("GOODS_RATE in", values, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateNotIn(List<String> values) {
            addCriterion("GOODS_RATE not in", values, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateBetween(String value1, String value2) {
            addCriterion("GOODS_RATE between", value1, value2, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateNotBetween(String value1, String value2) {
            addCriterion("GOODS_RATE not between", value1, value2, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlIsNull() {
            addCriterion("GOODS_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlIsNotNull() {
            addCriterion("GOODS_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlEqualTo(String value) {
            addCriterion("GOODS_IMG_URL =", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlNotEqualTo(String value) {
            addCriterion("GOODS_IMG_URL <>", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlGreaterThan(String value) {
            addCriterion("GOODS_IMG_URL >", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_IMG_URL >=", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlLessThan(String value) {
            addCriterion("GOODS_IMG_URL <", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlLessThanOrEqualTo(String value) {
            addCriterion("GOODS_IMG_URL <=", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlLike(String value) {
            addCriterion("GOODS_IMG_URL like", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlNotLike(String value) {
            addCriterion("GOODS_IMG_URL not like", value, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlIn(List<String> values) {
            addCriterion("GOODS_IMG_URL in", values, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlNotIn(List<String> values) {
            addCriterion("GOODS_IMG_URL not in", values, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlBetween(String value1, String value2) {
            addCriterion("GOODS_IMG_URL between", value1, value2, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsImgUrlNotBetween(String value1, String value2) {
            addCriterion("GOODS_IMG_URL not between", value1, value2, "goodsImgUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIsNull() {
            addCriterion("GOODS_ORIGINAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIsNotNull() {
            addCriterion("GOODS_ORIGINAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceEqualTo(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE =", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotEqualTo(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE <>", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceGreaterThan(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE >", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE >=", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceLessThan(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE <", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceLessThanOrEqualTo(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE <=", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceLike(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE like", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotLike(String value) {
            addCriterion("GOODS_ORIGINAL_PRICE not like", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIn(List<String> values) {
            addCriterion("GOODS_ORIGINAL_PRICE in", values, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotIn(List<String> values) {
            addCriterion("GOODS_ORIGINAL_PRICE not in", values, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceBetween(String value1, String value2) {
            addCriterion("GOODS_ORIGINAL_PRICE between", value1, value2, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotBetween(String value1, String value2) {
            addCriterion("GOODS_ORIGINAL_PRICE not between", value1, value2, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceIsNull() {
            addCriterion("GOODS_CURRENT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceIsNotNull() {
            addCriterion("GOODS_CURRENT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceEqualTo(String value) {
            addCriterion("GOODS_CURRENT_PRICE =", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceNotEqualTo(String value) {
            addCriterion("GOODS_CURRENT_PRICE <>", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceGreaterThan(String value) {
            addCriterion("GOODS_CURRENT_PRICE >", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_CURRENT_PRICE >=", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceLessThan(String value) {
            addCriterion("GOODS_CURRENT_PRICE <", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceLessThanOrEqualTo(String value) {
            addCriterion("GOODS_CURRENT_PRICE <=", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceLike(String value) {
            addCriterion("GOODS_CURRENT_PRICE like", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceNotLike(String value) {
            addCriterion("GOODS_CURRENT_PRICE not like", value, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceIn(List<String> values) {
            addCriterion("GOODS_CURRENT_PRICE in", values, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceNotIn(List<String> values) {
            addCriterion("GOODS_CURRENT_PRICE not in", values, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceBetween(String value1, String value2) {
            addCriterion("GOODS_CURRENT_PRICE between", value1, value2, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentPriceNotBetween(String value1, String value2) {
            addCriterion("GOODS_CURRENT_PRICE not between", value1, value2, "goodsCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonIsNull() {
            addCriterion("GOODS_SEASON is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonIsNotNull() {
            addCriterion("GOODS_SEASON is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonEqualTo(String value) {
            addCriterion("GOODS_SEASON =", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonNotEqualTo(String value) {
            addCriterion("GOODS_SEASON <>", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonGreaterThan(String value) {
            addCriterion("GOODS_SEASON >", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_SEASON >=", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonLessThan(String value) {
            addCriterion("GOODS_SEASON <", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonLessThanOrEqualTo(String value) {
            addCriterion("GOODS_SEASON <=", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonLike(String value) {
            addCriterion("GOODS_SEASON like", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonNotLike(String value) {
            addCriterion("GOODS_SEASON not like", value, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonIn(List<String> values) {
            addCriterion("GOODS_SEASON in", values, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonNotIn(List<String> values) {
            addCriterion("GOODS_SEASON not in", values, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonBetween(String value1, String value2) {
            addCriterion("GOODS_SEASON between", value1, value2, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsSeasonNotBetween(String value1, String value2) {
            addCriterion("GOODS_SEASON not between", value1, value2, "goodsSeason");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIsNull() {
            addCriterion("GOODS_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIsNotNull() {
            addCriterion("GOODS_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionEqualTo(String value) {
            addCriterion("GOODS_DESCRIPTION =", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotEqualTo(String value) {
            addCriterion("GOODS_DESCRIPTION <>", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionGreaterThan(String value) {
            addCriterion("GOODS_DESCRIPTION >", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_DESCRIPTION >=", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLessThan(String value) {
            addCriterion("GOODS_DESCRIPTION <", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLessThanOrEqualTo(String value) {
            addCriterion("GOODS_DESCRIPTION <=", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionLike(String value) {
            addCriterion("GOODS_DESCRIPTION like", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotLike(String value) {
            addCriterion("GOODS_DESCRIPTION not like", value, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionIn(List<String> values) {
            addCriterion("GOODS_DESCRIPTION in", values, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotIn(List<String> values) {
            addCriterion("GOODS_DESCRIPTION not in", values, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionBetween(String value1, String value2) {
            addCriterion("GOODS_DESCRIPTION between", value1, value2, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsDescriptionNotBetween(String value1, String value2) {
            addCriterion("GOODS_DESCRIPTION not between", value1, value2, "goodsDescription");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIsNull() {
            addCriterion("GOODS_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIsNotNull() {
            addCriterion("GOODS_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountEqualTo(String value) {
            addCriterion("GOODS_AMOUNT =", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotEqualTo(String value) {
            addCriterion("GOODS_AMOUNT <>", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountGreaterThan(String value) {
            addCriterion("GOODS_AMOUNT >", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_AMOUNT >=", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountLessThan(String value) {
            addCriterion("GOODS_AMOUNT <", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountLessThanOrEqualTo(String value) {
            addCriterion("GOODS_AMOUNT <=", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountLike(String value) {
            addCriterion("GOODS_AMOUNT like", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotLike(String value) {
            addCriterion("GOODS_AMOUNT not like", value, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountIn(List<String> values) {
            addCriterion("GOODS_AMOUNT in", values, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotIn(List<String> values) {
            addCriterion("GOODS_AMOUNT not in", values, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountBetween(String value1, String value2) {
            addCriterion("GOODS_AMOUNT between", value1, value2, "goodsAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsAmountNotBetween(String value1, String value2) {
            addCriterion("GOODS_AMOUNT not between", value1, value2, "goodsAmount");
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