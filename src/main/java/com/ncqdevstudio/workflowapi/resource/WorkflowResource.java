package com.ncqdevstudio.workflowapi.resource;

import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncqdevstudio.workflowapi.dto.WorkflowCategoryDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowSearchCriteria;
import com.ncqdevstudio.workflowapi.service.WorkflowService;

/**
 * Endpoint for managing workflow
 * @author ABM
 *
 */
@RestController
@RequestMapping("/api")
public class WorkflowResource {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	
	private WorkflowService workflowService;

	@Autowired
	public WorkflowResource(WorkflowService workflowService) {
		this.workflowService = workflowService;
	}
	
	
	@GetMapping("/workflow_categories")
	public ResponseEntity<List<WorkflowCategoryDto>> findAllWorkflowCategories(){
		logger.info("Get all workflows categories");
		return new ResponseEntity<List<WorkflowCategoryDto>>(workflowService.findAllWorkflowCategories(), HttpStatus.OK);
	}
	
	@PostMapping("/workflows")
	public ResponseEntity<List<WorkflowDto>> findWorkflowsByFilter(@RequestBody WorkflowSearchCriteria criteria) {
		logger.info("Get all workflows by criteria");
		return new ResponseEntity<List<WorkflowDto>>(workflowService.findWorkflowsByFilter(criteria), HttpStatus.OK);
	}
	
	
	
	

}
