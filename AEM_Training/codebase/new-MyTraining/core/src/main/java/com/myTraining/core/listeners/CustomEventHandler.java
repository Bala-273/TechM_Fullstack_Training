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
