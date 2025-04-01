package com.myTraining.core.models;

import com.adobe.cq.wcm.core.components.models.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = Page.class,
        resourceType = BasePageModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BasePageModel implements Page {

    public static final String RESOURCE_TYPE = "myTraining/components/structure/base-page";

    @Self
    private Page page;

    @ValueMapValue
    private String pageTitle;

    @ValueMapValue
    private String description;

    @Override
    public String getTitle() {
        return pageTitle != null ? pageTitle : page.getTitle();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getCssClassNames() {
        return page.getCssClassNames();
    }
}
