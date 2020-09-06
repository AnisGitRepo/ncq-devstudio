package com.ncqdevstudio.workflowapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncqdevstudio.workflowapi.dto.WorkflowCategoryDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowSearchCriteria;
import com.ncqdevstudio.workflowapi.entites.Workflow;
import com.ncqdevstudio.workflowapi.mapper.WorkflowMapper;
import com.ncqdevstudio.workflowapi.repository.WorkflowRepository;

@Service
public class WorkflowService {

	private WorkflowRepository workflowRepository;
	private WorkflowMapper workflowMapper;

	@Autowired
	public WorkflowService(WorkflowRepository workflowRepository, WorkflowMapper workflowMapper) {
		super();
		this.workflowRepository = workflowRepository;
		this.workflowMapper = workflowMapper;
	}

	public List<WorkflowCategoryDto> findAllWorkflowCategories() {
		return workflowMapper.toWorkflowCategoryDtos(workflowRepository.findAllWorkflowCategories());
	}

	public List<WorkflowDto> findWorkflowsByFilter(WorkflowSearchCriteria criteria) {
		return workflowMapper.toWorkflowDtos(new ArrayList<Workflow>(workflowRepository.findWorkflowsByFilter(criteria)));
	}

}
