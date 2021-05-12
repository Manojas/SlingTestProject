package com.aem.mindtree.core.workflows;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service=WorkflowProcess.class,immediate=true,property= {
		"process.label"+" =My first workflow",Constants.SERVICE_VENDOR+"=Custom workflow",
		Constants.SERVICE_DESCRIPTION+"=Custom workflow step"}

)
public class FirstWorkFlow implements WorkflowProcess{

	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		// TODO Auto-generated method stub
		
	}

}
