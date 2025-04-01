
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
