package com.myTraining.core.services.impl;

import com.myTraining.core.services.HelloWorldService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = HelloWorldService.class)
public class HelloWorldServiceImpl implements HelloWorldService {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Override
    public String getMessage() {
        String message = "Hello, this is from HelloWorldService!";

        LOG.info("HelloWorldServiceImpl is returning message: {}", message);

        return message;
    }
}
