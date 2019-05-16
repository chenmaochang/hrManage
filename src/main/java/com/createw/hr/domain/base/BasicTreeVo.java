package com.createw.hr.domain.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BasicTreeVo<T>{

    private String id ;

    private String name ;


    @JsonIgnore
    private Long parentId ;

    @JsonIgnore
    private String parentName ;



    private List<T> children = new ArrayList<>(  );


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicTreeVo<?> that = (BasicTreeVo<?>) o;
        return Objects.equals( id, that.id );
    }

    @Override
    public int hashCode() {

        return Objects.hash( id );
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}