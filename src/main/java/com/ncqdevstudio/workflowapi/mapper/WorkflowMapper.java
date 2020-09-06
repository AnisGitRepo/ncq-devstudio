package com.ncqdevstudio.workflowapi.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.ncqdevstudio.workflowapi.dto.WorkflowCategoryDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowDto;
import com.ncqdevstudio.workflowapi.entites.Workflow;
import com.ncqdevstudio.workflowapi.entites.WorkflowCategory;


@Mapper(componentModel = "spring")
public interface WorkflowMapper {

	@Named("toWorkflowCategoryDto")
	@Mapping(target = "parentCategory", ignore = true)
    @Mapping(target = "workflows", ignore = true)
	WorkflowCategoryDto toWorkflowCategoryDto(WorkflowCategory workflowCategory);
	
	@IterableMapping(qualifiedByName = "toWorkflowCategoryDto")
	List<WorkflowCategoryDto> toWorkflowCategoryDtos(List<WorkflowCategory> workflowCategories);
	
	@Named("toWorkflowDto")
	@Mapping(target = "categories", ignore = true)
	WorkflowDto toWorkflowDto(Workflow workflow);
	
	@IterableMapping(qualifiedByName = "toWorkflowDto")
	List<WorkflowDto> toWorkflowDtos(List<Workflow> workflows);
}
