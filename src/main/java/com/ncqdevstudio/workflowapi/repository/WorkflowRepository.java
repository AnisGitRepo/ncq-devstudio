package com.ncqdevstudio.workflowapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncqdevstudio.workflowapi.entites.Workflow;
import com.ncqdevstudio.workflowapi.entites.WorkflowCategory;

/**
 * Repository component for managing workflow
 * @author ABM
 *
 */
@Repository
public class WorkflowRepository {

	
	@Autowired
	EntityManager em;
	
	public List<WorkflowCategory> findAllWorkflowCategories(){
		return em.createQuery("select c from WorkflowCategory c", WorkflowCategory.class).getResultList();
	}
	
	public List<Workflow> findAllWorkflowByName(String name){
		return em.createQuery("select distinct w from Workflow w where LOWER(w.name) LIKE '%"+name.toLowerCase()+"%'", Workflow.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Workflow> findAllWorkflowByListIdCategories(List<Integer> idCategories){
		String nativeQuery = "select w.* from workflows_categories wc, workflow w"
 				+ " where wc.workflow_id = w.id_workflow and wc.category_id in :categories";
		Query q = em.createNativeQuery(nativeQuery, Workflow.class);
		q.setParameter("categories", idCategories);
		return q.getResultList();
	}
	
	public List<Workflow> findAllWorkflowByStatus(Integer status){
		return em.createQuery("select distinct w from Workflow w where w.status = "+status, Workflow.class).getResultList();
	}
	
	/*public Set<Workflow> findWorkflowsByFilter(WorkflowSearchCriteria criteria){
		
		if(criteria == null){
			return null;
		}
		
		Set<Workflow> workflows = new HashSet<Workflow>();		
		String name = criteria.getName();		
		
		if(!StringUtils.isEmpty(name)){
			workflows.addAll(em.createQuery("select distinct w from Workflow w where LOWER(w.name) LIKE '%"+name.toLowerCase()+"%'").getResultList());
		}
          	
		List<Integer> idCategories = criteria.getIdCategories();
		
		if(!CollectionUtils.isEmpty(idCategories)){
     		String nativeQuery = "select w.* from workflows_categories wc, workflow w"
     				+ " where wc.workflow_id = w.id_workflow and wc.category_id in :categories";
			Query q = em.createNativeQuery(nativeQuery, Workflow.class);
			q.setParameter("categories", idCategories);
			workflows = workflows.stream()
			  .distinct()
			  .filter(q.getResultList()::contains)
			  .collect(Collectors.toSet());			
		}
		
		Integer status = criteria.getStatus();
		
		if(status != null){
			Query q = em.createQuery("select distinct w from Workflow w where w.status = "+status);
			workflows = workflows.stream()
					  .distinct()
					  .filter(q.getResultList()::contains)
					  .collect(Collectors.toSet());
		}
		
		return workflows;
	}*/
	
	 
}
