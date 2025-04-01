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
