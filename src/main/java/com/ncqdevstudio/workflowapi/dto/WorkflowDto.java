package com.ncqdevstudio.workflowapi.dto;

import java.util.ArrayList;
import java.util.List;


public class WorkflowDto {

	private int idWorkflow;
	private String name;
	private String description;
	private int status;
	private List<WorkflowCategoryDto> categories = new ArrayList<WorkflowCategoryDto>();
	
	public WorkflowDto() {
		super();
	}

	public WorkflowDto(int idWorkflow, String name, String description,
			int status, List<WorkflowCategoryDto> categories) {
		super();
		this.idWorkflow = idWorkflow;
		this.name = name;
		this.description = description;
		this.status = status;
		this.categories = categories;
	}

	public int getIdWorkflow() {
		return idWorkflow;
	}

	public void setIdWorkflow(int idWorkflow) {
		this.idWorkflow = idWorkflow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<WorkflowCategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(List<WorkflowCategoryDto> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idWorkflow;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkflowDto other = (WorkflowDto) obj;
		if (idWorkflow != other.idWorkflow)
			return false;
		return true;
	}
	
	
	
	
}
