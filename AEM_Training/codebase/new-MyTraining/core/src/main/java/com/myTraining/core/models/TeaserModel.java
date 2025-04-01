package com.myTraining.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {org.apache.sling.api.resource.Resource.class},
        adapters = {ComponentExporter.class},
        resourceType = "myTraining/components/custom-teaser",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TeaserModel implements ComponentExporter {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String shortDescription;

    @ValueMapValue
    private String longDescription;

    @ValueMapValue
    private String ctaLabel;

    public String getTitle() { return title; }

    public String getImage() { return image; }

    public String getShortDescription() { return shortDescription; }

    public String getLongDescription() { return longDescription; }

    public String getCtaLabel() { return ctaLabel; }

    @Override
    public String getExportedType() {
        return "myTraining/components/custom-teaser";
    }
}
