package com.ncqdevstudio.workflowapi.dto;

import java.util.List;

public class WorkflowSearchCriteria {
	
	private String name;
	private List<Integer> idCategories;
	private Integer status;	
	
	public WorkflowSearchCriteria() {
		super();
	}
	public WorkflowSearchCriteria(String name, List<Integer> idCategories,
			Integer status) {
		super();
		this.name = name;
		this.idCategories = idCategories;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getIdCategories() {
		return idCategories;
	}
	public void setIdCategories(List<Integer> idCategories) {
		this.idCategories = idCategories;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	

}
