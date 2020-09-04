package com.ncqdevstudio.workflowapi.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class WorkflowCategoryDto {


	private int idCategory;
	private String name;
	private String description;
	private String logo;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	private int status;
	private WorkflowCategoryDto parentCategory;
	private List<WorkflowDto> workflows = new ArrayList<WorkflowDto>();
		
	public WorkflowCategoryDto() {
		super();
	}
	
	public WorkflowCategoryDto(int idCategory, String name, String description,
			String logo, LocalDateTime createAt, LocalDateTime updateAt,
			int status, WorkflowCategoryDto parentCategory) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.description = description;
		this.logo = logo;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.status = status;
		this.parentCategory = parentCategory;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public WorkflowCategoryDto getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(WorkflowCategoryDto parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<WorkflowDto> getWorkflows() {
		return workflows;
	}

	public void setWorkflows(List<WorkflowDto> workflows) {
		this.workflows = workflows;
	}

	
	
	
	
	
	
	
	
}
