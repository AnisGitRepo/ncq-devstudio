package com.ncqdevstudio.workflowapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ncqdevstudio.workflowapi.dto.WorkflowCategoryDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowDto;
import com.ncqdevstudio.workflowapi.dto.WorkflowSearchCriteria;
import com.ncqdevstudio.workflowapi.resource.WorkflowResource;
import com.ncqdevstudio.workflowapi.service.WorkflowService;

@RunWith(SpringRunner.class)
@WebMvcTest(WorkflowResource.class)
public class WorkflowResourceTest {

	
	 @Autowired
	 private MockMvc mvc;
	 
	 @MockBean
	 private WorkflowService service;
	 
	 
	 @Test
	 public void findAllWorkflowCategories() throws Exception{
		 
		 WorkflowCategoryDto workflowCategory = new WorkflowCategoryDto(1, "CAT1", "CATEGORY", "LOGO", LocalDateTime.now(), LocalDateTime.now(), 1, null);
		    
		 List<WorkflowCategoryDto> allWorkflowCategories = new ArrayList<WorkflowCategoryDto>();
		 allWorkflowCategories.add(workflowCategory);
         
		 Mockito.when(service.findAllWorkflowCategories()).thenReturn(allWorkflowCategories);
		 
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/workflow_categories")
		      .contentType(MediaType.APPLICATION_JSON);
		 
		 MvcResult result = mvc.perform(requestBuilder).andReturn();
		 
		 String expected = "[{name:CAT1}]";
		 
		 JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	 
	 
	 @Test
	 public void findWorkflowsByFilter() throws Exception{
		 
		 WorkflowDto workflow = new WorkflowDto(1, "WORKFLOW1", "WORKFLOW", 1, null);
		    
		 List<WorkflowDto> allWorkflows = new ArrayList<WorkflowDto>();
		 allWorkflows.add(workflow);
		 
		 WorkflowSearchCriteria criteria = new WorkflowSearchCriteria();
		 criteria.setName("workflow");
         
		 Mockito.when(service.findWorkflowsByFilter(Mockito.any())).thenReturn(allWorkflows);
		 
		 ObjectMapper mapper = new ObjectMapper();
		 ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		 String requestBodyJson = ow.writeValueAsString(criteria);
		 
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/workflows").content(requestBodyJson)
		      .contentType(MediaType.APPLICATION_JSON);
		 
		 MvcResult result = mvc.perform(requestBuilder).andReturn();
		 
		 String expected = "[{name:WORKFLOW1}]";
		 
		 JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
}
