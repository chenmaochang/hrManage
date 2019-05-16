package com.createw.hr.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.createw.hr.domain.base.BasicTreeVo;

@Component
public class TKnowledgeCategory  extends BasicTreeVo<TKnowledgeCategory> implements Serializable{
    private String id;

    private String categoryName;

    private String categoryCode;

    private Integer categoryLevel;

    private Integer contentNum;

    private String pid;

    private String path;

    private String createUid;
    
    private Date createTime;

    private String updateUid;
    
    private Date updateTime;

    private String sysStatus;
    
    //辅助查询字段,不存数据库
    private Date createStart;
    private Date createEnd;
    
    private List<TKnowledgeCategory> tKnowledgeCategories; 

    private static final long serialVersionUID = 1L;


    public String getId() {
		return id;
	}

	public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public Integer getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public Integer getContentNum() {
        return contentNum;
    }

    public void setContentNum(Integer contentNum) {
        this.contentNum = contentNum;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid == null ? null : createUid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid == null ? null : updateUid.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus == null ? null : sysStatus.trim();
    }

	public Date getCreateStart() {
		return createStart;
	}

	public void setCreateStart(Date createStart) {
		this.createStart = createStart;
	}

	public Date getCreateEnd() {
		return createEnd;
	}

	public void setCreateEnd(Date createEnd) {
		this.createEnd = createEnd;
	}

	public List<TKnowledgeCategory> gettKnowledgeCategories() {
		return tKnowledgeCategories;
	}

	public void settKnowledgeCategories(List<TKnowledgeCategory> tKnowledgeCategories) {
		this.tKnowledgeCategories = tKnowledgeCategories;
	}
    
}