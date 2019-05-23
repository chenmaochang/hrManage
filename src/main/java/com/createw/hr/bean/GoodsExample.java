package com.createw.hr.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected String limit;

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

    public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNull() {
            addCriterion("goods_desc is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNotNull() {
            addCriterion("goods_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescEqualTo(String value) {
            addCriterion("goods_desc =", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotEqualTo(String value) {
            addCriterion("goods_desc <>", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThan(String value) {
            addCriterion("goods_desc >", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            addCriterion("goods_desc >=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThan(String value) {
            addCriterion("goods_desc <", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThanOrEqualTo(String value) {
            addCriterion("goods_desc <=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLike(String value) {
            addCriterion("goods_desc like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotLike(String value) {
            addCriterion("goods_desc not like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIn(List<String> values) {
            addCriterion("goods_desc in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotIn(List<String> values) {
            addCriterion("goods_desc not in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescBetween(String value1, String value2) {
            addCriterion("goods_desc between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotBetween(String value1, String value2) {
            addCriterion("goods_desc not between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Float value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Float value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Float value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Float value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Float value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Float> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Float> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Float value1, Float value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Float value1, Float value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andMainPictureIsNull() {
            addCriterion("main_picture is null");
            return (Criteria) this;
        }

        public Criteria andMainPictureIsNotNull() {
            addCriterion("main_picture is not null");
            return (Criteria) this;
        }

        public Criteria andMainPictureEqualTo(String value) {
            addCriterion("main_picture =", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotEqualTo(String value) {
            addCriterion("main_picture <>", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureGreaterThan(String value) {
            addCriterion("main_picture >", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureGreaterThanOrEqualTo(String value) {
            addCriterion("main_picture >=", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLessThan(String value) {
            addCriterion("main_picture <", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLessThanOrEqualTo(String value) {
            addCriterion("main_picture <=", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLike(String value) {
            addCriterion("main_picture like", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotLike(String value) {
            addCriterion("main_picture not like", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureIn(List<String> values) {
            addCriterion("main_picture in", values, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotIn(List<String> values) {
            addCriterion("main_picture not in", values, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureBetween(String value1, String value2) {
            addCriterion("main_picture between", value1, value2, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotBetween(String value1, String value2) {
            addCriterion("main_picture not between", value1, value2, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andRequestParamIsNull() {
            addCriterion("request_param is null");
            return (Criteria) this;
        }

        public Criteria andRequestParamIsNotNull() {
            addCriterion("request_param is not null");
            return (Criteria) this;
        }

        public Criteria andRequestParamEqualTo(String value) {
            addCriterion("request_param =", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotEqualTo(String value) {
            addCriterion("request_param <>", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamGreaterThan(String value) {
            addCriterion("request_param >", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamGreaterThanOrEqualTo(String value) {
            addCriterion("request_param >=", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLessThan(String value) {
            addCriterion("request_param <", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLessThanOrEqualTo(String value) {
            addCriterion("request_param <=", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLike(String value) {
            addCriterion("request_param like", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotLike(String value) {
            addCriterion("request_param not like", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamIn(List<String> values) {
            addCriterion("request_param in", values, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotIn(List<String> values) {
            addCriterion("request_param not in", values, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamBetween(String value1, String value2) {
            addCriterion("request_param between", value1, value2, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotBetween(String value1, String value2) {
            addCriterion("request_param not between", value1, value2, "requestParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamIsNull() {
            addCriterion("response_param is null");
            return (Criteria) this;
        }

        public Criteria andResponseParamIsNotNull() {
            addCriterion("response_param is not null");
            return (Criteria) this;
        }

        public Criteria andResponseParamEqualTo(String value) {
            addCriterion("response_param =", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamNotEqualTo(String value) {
            addCriterion("response_param <>", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamGreaterThan(String value) {
            addCriterion("response_param >", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamGreaterThanOrEqualTo(String value) {
            addCriterion("response_param >=", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamLessThan(String value) {
            addCriterion("response_param <", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamLessThanOrEqualTo(String value) {
            addCriterion("response_param <=", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamLike(String value) {
            addCriterion("response_param like", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamNotLike(String value) {
            addCriterion("response_param not like", value, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamIn(List<String> values) {
            addCriterion("response_param in", values, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamNotIn(List<String> values) {
            addCriterion("response_param not in", values, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamBetween(String value1, String value2) {
            addCriterion("response_param between", value1, value2, "responseParam");
            return (Criteria) this;
        }

        public Criteria andResponseParamNotBetween(String value1, String value2) {
            addCriterion("response_param not between", value1, value2, "responseParam");
            return (Criteria) this;
        }

        public Criteria andPendStatusIsNull() {
            addCriterion("pend_status is null");
            return (Criteria) this;
        }

        public Criteria andPendStatusIsNotNull() {
            addCriterion("pend_status is not null");
            return (Criteria) this;
        }

        public Criteria andPendStatusEqualTo(String value) {
            addCriterion("pend_status =", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusNotEqualTo(String value) {
            addCriterion("pend_status <>", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusGreaterThan(String value) {
            addCriterion("pend_status >", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pend_status >=", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusLessThan(String value) {
            addCriterion("pend_status <", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusLessThanOrEqualTo(String value) {
            addCriterion("pend_status <=", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusLike(String value) {
            addCriterion("pend_status like", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusNotLike(String value) {
            addCriterion("pend_status not like", value, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusIn(List<String> values) {
            addCriterion("pend_status in", values, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusNotIn(List<String> values) {
            addCriterion("pend_status not in", values, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusBetween(String value1, String value2) {
            addCriterion("pend_status between", value1, value2, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andPendStatusNotBetween(String value1, String value2) {
            addCriterion("pend_status not between", value1, value2, "pendStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(String value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(String value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(String value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(String value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(String value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLike(String value) {
            addCriterion("create_id like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotLike(String value) {
            addCriterion("create_id not like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<String> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<String> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(String value1, String value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(String value1, String value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(String value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(String value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(String value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(String value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(String value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLike(String value) {
            addCriterion("update_id like", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotLike(String value) {
            addCriterion("update_id not like", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<String> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<String> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(String value1, String value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(String value1, String value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andSysStatusIsNull() {
            addCriterion("sys_status is null");
            return (Criteria) this;
        }

        public Criteria andSysStatusIsNotNull() {
            addCriterion("sys_status is not null");
            return (Criteria) this;
        }

        public Criteria andSysStatusEqualTo(String value) {
            addCriterion("sys_status =", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotEqualTo(String value) {
            addCriterion("sys_status <>", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusGreaterThan(String value) {
            addCriterion("sys_status >", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sys_status >=", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLessThan(String value) {
            addCriterion("sys_status <", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLessThanOrEqualTo(String value) {
            addCriterion("sys_status <=", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLike(String value) {
            addCriterion("sys_status like", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotLike(String value) {
            addCriterion("sys_status not like", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusIn(List<String> values) {
            addCriterion("sys_status in", values, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotIn(List<String> values) {
            addCriterion("sys_status not in", values, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusBetween(String value1, String value2) {
            addCriterion("sys_status between", value1, value2, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotBetween(String value1, String value2) {
            addCriterion("sys_status not between", value1, value2, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIsNull() {
            addCriterion("belong_category is null");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIsNotNull() {
            addCriterion("belong_category is not null");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryEqualTo(String value) {
            addCriterion("belong_category =", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryNotEqualTo(String value) {
            addCriterion("belong_category <>", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryGreaterThan(String value) {
            addCriterion("belong_category >", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("belong_category >=", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryLessThan(String value) {
            addCriterion("belong_category <", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryLessThanOrEqualTo(String value) {
            addCriterion("belong_category <=", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryLike(String value) {
            addCriterion("belong_category like", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryNotLike(String value) {
            addCriterion("belong_category not like", value, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIn(List<String> values) {
            addCriterion("belong_category in", values, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryNotIn(List<String> values) {
            addCriterion("belong_category not in", values, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryBetween(String value1, String value2) {
            addCriterion("belong_category between", value1, value2, "belongCategory");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryNotBetween(String value1, String value2) {
            addCriterion("belong_category not between", value1, value2, "belongCategory");
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