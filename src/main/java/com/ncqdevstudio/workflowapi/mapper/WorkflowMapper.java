package com.ncqdevstudio.workflowapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ncqdevstudio.workflowapi.dto.WorkflowCategoryDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowDto;
import com.ncqdevstudio.workflowapi.entites.Workflow;
import com.ncqdevstudio.workflowapi.entites.WorkflowCategory;

@Mapper(componentModel = "spring")
public interface WorkflowMapper {

	@Mapping(target = "parentCategory", ignore = true)
    @Mapping(target = "workflows", ignore = true)
	WorkflowCategoryDto toWorkflowCategoryDto(WorkflowCategory workflowCategory);
	
	@Mapping(target = "categories", ignore = true)
	WorkflowDto toWorkflowDto(Workflow workflow);
}
