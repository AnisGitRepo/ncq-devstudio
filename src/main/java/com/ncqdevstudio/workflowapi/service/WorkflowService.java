package com.ncqdevstudio.workflowapi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.ncqdevstudio.workflowapi.dto.WorkflowCategoryDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowSearchCriteria;
import com.ncqdevstudio.workflowapi.entites.Workflow;
import com.ncqdevstudio.workflowapi.mapper.WorkflowMapper;
import com.ncqdevstudio.workflowapi.repository.WorkflowRepository;

/**
 * Service component for managing workflow
 * @author ABM
 *
 */
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
		
		
		if(criteria == null){
			return null;
		}
		
		Set<Workflow> workflows = new HashSet<Workflow>();		
		String name = criteria.getName();		
		
		if(!StringUtils.isEmpty(name)){
			workflows.addAll(workflowRepository.findAllWorkflowByName(name));
		}
          	
		List<Integer> idCategories = criteria.getIdCategories();
		
		if(!CollectionUtils.isEmpty(idCategories)){
			workflows = workflows.stream()
			  .distinct()
			  .filter(workflowRepository.findAllWorkflowByListIdCategories(idCategories)::contains)
			  .collect(Collectors.toSet());			
		}
		
		Integer status = criteria.getStatus();
		
		if(status != null){
			workflows = workflows.stream()
					  .distinct()
					  .filter(workflowRepository.findAllWorkflowByStatus(status)::contains)
					  .collect(Collectors.toSet());
		}		
		
		return workflowMapper.toWorkflowDtos(new ArrayList<Workflow>(workflows));
	}

}
