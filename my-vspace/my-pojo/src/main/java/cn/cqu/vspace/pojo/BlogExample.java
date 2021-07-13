package cn.cqu.vspace.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andBlogImgUrlIsNull() {
            addCriterion("BLOG_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlIsNotNull() {
            addCriterion("BLOG_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlEqualTo(String value) {
            addCriterion("BLOG_IMG_URL =", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlNotEqualTo(String value) {
            addCriterion("BLOG_IMG_URL <>", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlGreaterThan(String value) {
            addCriterion("BLOG_IMG_URL >", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("BLOG_IMG_URL >=", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlLessThan(String value) {
            addCriterion("BLOG_IMG_URL <", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlLessThanOrEqualTo(String value) {
            addCriterion("BLOG_IMG_URL <=", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlLike(String value) {
            addCriterion("BLOG_IMG_URL like", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlNotLike(String value) {
            addCriterion("BLOG_IMG_URL not like", value, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlIn(List<String> values) {
            addCriterion("BLOG_IMG_URL in", values, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlNotIn(List<String> values) {
            addCriterion("BLOG_IMG_URL not in", values, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlBetween(String value1, String value2) {
            addCriterion("BLOG_IMG_URL between", value1, value2, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogImgUrlNotBetween(String value1, String value2) {
            addCriterion("BLOG_IMG_URL not between", value1, value2, "blogImgUrl");
            return (Criteria) this;
        }

        public Criteria andBlogDateIsNull() {
            addCriterion("BLOG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBlogDateIsNotNull() {
            addCriterion("BLOG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBlogDateEqualTo(String value) {
            addCriterion("BLOG_DATE =", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateNotEqualTo(String value) {
            addCriterion("BLOG_DATE <>", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateGreaterThan(String value) {
            addCriterion("BLOG_DATE >", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateGreaterThanOrEqualTo(String value) {
            addCriterion("BLOG_DATE >=", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateLessThan(String value) {
            addCriterion("BLOG_DATE <", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateLessThanOrEqualTo(String value) {
            addCriterion("BLOG_DATE <=", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateLike(String value) {
            addCriterion("BLOG_DATE like", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateNotLike(String value) {
            addCriterion("BLOG_DATE not like", value, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateIn(List<String> values) {
            addCriterion("BLOG_DATE in", values, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateNotIn(List<String> values) {
            addCriterion("BLOG_DATE not in", values, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateBetween(String value1, String value2) {
            addCriterion("BLOG_DATE between", value1, value2, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogDateNotBetween(String value1, String value2) {
            addCriterion("BLOG_DATE not between", value1, value2, "blogDate");
            return (Criteria) this;
        }

        public Criteria andBlogContentIsNull() {
            addCriterion("BLOG_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andBlogContentIsNotNull() {
            addCriterion("BLOG_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andBlogContentEqualTo(String value) {
            addCriterion("BLOG_CONTENT =", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotEqualTo(String value) {
            addCriterion("BLOG_CONTENT <>", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentGreaterThan(String value) {
            addCriterion("BLOG_CONTENT >", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentGreaterThanOrEqualTo(String value) {
            addCriterion("BLOG_CONTENT >=", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLessThan(String value) {
            addCriterion("BLOG_CONTENT <", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLessThanOrEqualTo(String value) {
            addCriterion("BLOG_CONTENT <=", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentLike(String value) {
            addCriterion("BLOG_CONTENT like", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotLike(String value) {
            addCriterion("BLOG_CONTENT not like", value, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentIn(List<String> values) {
            addCriterion("BLOG_CONTENT in", values, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotIn(List<String> values) {
            addCriterion("BLOG_CONTENT not in", values, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentBetween(String value1, String value2) {
            addCriterion("BLOG_CONTENT between", value1, value2, "blogContent");
            return (Criteria) this;
        }

        public Criteria andBlogContentNotBetween(String value1, String value2) {
            addCriterion("BLOG_CONTENT not between", value1, value2, "blogContent");
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