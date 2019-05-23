package com.createw.hr.bean;

import java.util.Date;

public class Goods {
    private String id;

    private String goodsName;

    private String goodsDesc;

    private Float goodsPrice;

    private String mainPicture;

    private String requestParam;

    private String responseParam;

    private String pendStatus;

    private Date createTime;

    private Date updateTime;

    private String createId;

    private String updateId;

    private String sysStatus;

    private String belongCategory;

    private String responseSample;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture == null ? null : mainPicture.trim();
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam == null ? null : requestParam.trim();
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam == null ? null : responseParam.trim();
    }

    public String getPendStatus() {
        return pendStatus;
    }

    public void setPendStatus(String pendStatus) {
        this.pendStatus = pendStatus == null ? null : pendStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus == null ? null : sysStatus.trim();
    }

    public String getBelongCategory() {
        return belongCategory;
    }

    public void setBelongCategory(String belongCategory) {
        this.belongCategory = belongCategory == null ? null : belongCategory.trim();
    }

    public String getResponseSample() {
        return responseSample;
    }

    public void setResponseSample(String responseSample) {
        this.responseSample = responseSample == null ? null : responseSample.trim();
    }
}