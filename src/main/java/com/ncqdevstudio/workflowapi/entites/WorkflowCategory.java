package com.ncqdevstudio.workflowapi.entites;

import io.swagger.annotations.ApiModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@ApiModel(description="All details about the workflow category. ")
@Entity
public class WorkflowCategory {

	@Id
	private int idCategory;
	private String name;
	private String description;
	private String logo;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	private int status;
	
	@OneToOne
	@JoinColumn(name = "parentIdCategory", referencedColumnName = "idCategory")
	private WorkflowCategory parentCategory;
	
	@ManyToMany
	@JoinTable(name="WORKFLOWS_CATEGORIES",
	joinColumns = @JoinColumn(name="WORKFLOW_ID"),
	inverseJoinColumns = @JoinColumn(name="CATEGORY_ID")
	)
	private List<Workflow> workflows = new ArrayList<Workflow>();
		
	public WorkflowCategory() {
		super();
	}
	
	public WorkflowCategory(int idCategory, String name, String description,
			String logo, LocalDateTime createAt, LocalDateTime updateAt,
			int status, WorkflowCategory parentCategory) {
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

	public WorkflowCategory getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(WorkflowCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Workflow> getWorkflows() {
		return workflows;
	}

	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
	}

	
	
	
	
	
	
	
	
}
