# **AEM - Assignment 6**  

## **1. Creating a Custom Workflow (CustomWorkflow)**  

### **Steps:**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **Workflow** → **Models**  
2. Click **Create** → **Create Model**.  
3. Enter **Title**: `My Custom Workflow` → Click **Done**.  
4. Open the workflow model for editing.  
5. Drag and drop a **Process Step** from the side panel.  
6. Configure the process step:  
   - **Title**: `Custom Process`  
   - **Process**: Select or create a custom workflow process (See Step 2).  
7. Click **Save & Close** to activate the workflow.  

---

## **2. Creating a Custom Workflow Process to Print Page Title in Logs**  

### **Steps:**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **General** → **CRXDE Lite**  
2. Go to:  
   ```
   /apps/myTraining/core/src/com/myTraining/workflow/CustomWorkflowProcess.java  
   ```  
3. Create a **custom workflow process** that prints the page title in logs.  

#### **Code:**  

```java
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

```

4. Click **Save All**, build, and deploy the bundle.  
5. Open **Workflow Console** → Select **My Custom Workflow**.  
6. Run the workflow on a page.  
7. Open **AEM Logs** and verify that the page title is logged.  

---

## **3. Creating an Event Handler to Print Resource Path in Logs**  

### **Steps:**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **General** → **CRXDE Lite**  
2. Go to:  
   ```
   /apps/myTraining/core/src/com/myTraining/listeners/CustomEventHandler.java  
   ```  
3. Implement an **event handler** to log the resource path.  

#### **Code:**  

```java
package com.myTraining.core.listeners;

import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;

@Component(
        service = EventHandler.class,
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/REMOVED"
        }
)
public class CustomEventHandler implements EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomEventHandler.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public void handleEvent(Event event) {
        try (ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, "readService"))) {
            String resourcePath = (String) event.getProperty(SlingConstants.PROPERTY_PATH);
            LOG.info("Event Triggered: {} | Resource Path: {}", event.getTopic(), resourcePath);

            // Fetch the resource (Optional)
            Resource resource = resourceResolver.getResource(resourcePath);
            if (resource != null) {
                LOG.info("Resource Exists: {}", resource.getPath());
            } else {
                LOG.warn("Resource Not Found at: {}", resourcePath);
            }
        } catch (Exception e) {
            LOG.error("Error handling event", e);
        }
    }
}
```

4. Click **Save All**, build, and deploy the bundle.  
5. Modify any resource under `/content/myTraining`.  
6. Open **AEM Logs** and check for resource change logs.  

---

## **4. Creating a Sling Job to Print "Hello World" in Logs**  

### **Steps:**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **General** → **CRXDE Lite**  
2. Go to:  
   ```
   /apps/myTraining/core/src/com/myTraining/jobs/HelloWorldJob.java 
   ```  
3. Implement a **Sling Job** that logs "Hello World".  

#### **Code:**  

```java

package com.myTraining.core.jobs;

import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = JobConsumer.class,
        property = {
                JobConsumer.PROPERTY_TOPICS + "=com/myTraining/core/jobs/helloWorldJob"
        }
)
public class HelloWorldJob implements JobConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public JobResult process(org.apache.sling.event.jobs.Job job) {
        LOG.info("Hello World from Sling Job!");
        return JobResult.OK;
    }
}
```

4. Click **Save All**, build, and deploy the bundle.  
5. Trigger the job using **JobManager**.  
6. Open **AEM Logs** and verify the "Hello World" message.  

---

## **5. Creating a Scheduler to Print "Hello World" Every 5 Minutes**  

### **Steps:**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **General** → **CRXDE Lite**  
2. Go to:  
   ```
   /apps/myTraining/core/src/com/myTraining/schedulers/HelloWorldScheduler.java  
   ```  
3. Implement an **OSGi Scheduler** that runs every 5 minutes.  

#### **Sample Code:**  

```java
package com.myTraining.core.schedulers;

import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, immediate = true)
@Designate(ocd = HelloWorldScheduler.Config.class)
public class HelloWorldScheduler implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldScheduler.class);

    @Reference
    private Scheduler scheduler;

    private String cronExpression;

    @ObjectClassDefinition(name = "Hello World Scheduler - Custom Config")
    public @interface Config {
        @AttributeDefinition(name = "Cron Expression", description = "Cron Expression for Scheduler")
        String cron_expression() default "0 */5 * * * ?";  // Runs every 5 minutes
    }

    @Activate
    @Modified
    protected void activate(Config config) {
        this.cronExpression = config.cron_expression();
        LOG.info("Hello World Scheduler Activated with cron: {}", cronExpression);
    }

    @Override
    public void run() {
        LOG.info("Hello World");
    }
}
```

4. Click **Save All**, build, and deploy the bundle.  
5. Open **AEM Logs** and verify that "Yellow World" is logged every 5 minutes.  

---

## **6. Creating Users and Assigning Permissions**  

### **Steps:**  

#### **Creating a User Group**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **Security** → **Groups**  
2. Click **Create Group**.  
3. Enter **Group Name**: `DevAuthors` → Click **Save**.  

#### **Creating Users**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **Security** → **Users**  
2. Click **Create User** and enter details:  
   - **User 1**: `devuser1`  
   - **User 2**: `devuser2`  
   - **User 3**: `devuser3`  
3. Add all users to **DevAuthors** group.  

#### **Setting Permissions**  

1. **Start AEM** and navigate to:  
   - **AEM Start** → **Tools** → **Security** → **Permissions**  
2. Select **DevAuthors** group.  
3. Assign **Read Only** permissions for:  
   - `/content`  
   - `/dam`  
4. Grant **Replication Access** to the group.  
5. Click **Save** and verify permissions by logging in as a test user.  

---

## **Summary**  

This report documents the creation of workflows, event handlers, Sling jobs, schedulers, and user management in AEM. The provided steps and sample code will help implement these features efficiently.
