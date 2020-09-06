package com.ncqdevstudio.workflowapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncqdevstudio.workflowapi.dto.WorkflowCategoryDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowSearchCriteria;
import com.ncqdevstudio.workflowapi.service.WorkflowService;

@RestController
@RequestMapping("/api")
public class WorkflowResource {
	
	private WorkflowService workflowService;

	@Autowired
	public WorkflowResource(WorkflowService workflowService) {
		this.workflowService = workflowService;
	}
	
	
	@GetMapping("/workflow_categories")
	public ResponseEntity<List<WorkflowCategoryDto>> findAllWorkflowCategories(){
		
		return new ResponseEntity<List<WorkflowCategoryDto>>(workflowService.findAllWorkflowCategories(), HttpStatus.OK);
	}
	
	@GetMapping("/workflows")
	public ResponseEntity<List<WorkflowDto>> findWorkflowsByFilter(@RequestBody WorkflowSearchCriteria criteria) {
		return new ResponseEntity<List<WorkflowDto>>(workflowService.findWorkflowsByFilter(criteria), HttpStatus.OK);
	}
	
	
	
	

}
