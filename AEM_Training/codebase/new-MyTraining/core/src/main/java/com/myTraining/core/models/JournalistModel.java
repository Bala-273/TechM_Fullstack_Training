package com.myTraining.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class JournalistModel {

    @Inject
    @ValueMapValue
    private String name;

    @Inject
    @ValueMapValue
    private String bio;



    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

}
