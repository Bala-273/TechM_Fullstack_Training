package com.myTraining.core.workflow;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = WorkflowProcess.class, property = {"process.label=My Custom Workflow Process"})
public class CustomWorkflowProcess implements WorkflowProcess {

    private static final Logger LOG = LoggerFactory.getLogger(CustomWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        LOG.info("Executing Custom Workflow Process...");

        try {
            // Get Payload Path (Path of the Page/Asset being processed)
            WorkflowData workflowData = workItem.getWorkflowData();
            String payloadPath = workflowData.getPayload().toString();
            LOG.info("Payload Path: {}", payloadPath);

            // Get Resource Resolver
            ResourceResolver resourceResolver = workflowSession.adaptTo(ResourceResolver.class);
            if (resourceResolver == null) {
                LOG.error("ResourceResolver is NULL!");
                return;
            }

            // Fetch Resource
            Resource resource = resourceResolver.getResource(payloadPath);
            if (resource == null) {
                LOG.error("No Resource Found at: {}", payloadPath);
                return;
            }

            // Get jcr:title if it's a page
            Resource contentResource = resource.getChild("jcr:content");
            if (contentResource != null) {
                ValueMap properties = contentResource.getValueMap();
                String pageTitle = properties.get("jcr:title", "No Title Found");
                LOG.info("Page Title: {}", pageTitle);
            } else {
                LOG.warn("Not a Page Content Node.");
            }
        } catch (Exception e) {
            LOG.error("Error in Custom Workflow Process", e);
        }
    }
}
