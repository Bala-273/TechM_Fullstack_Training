package com.myTraining.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContactUsModel {

    @ValueMapValue
    @Default(values = "Contact Us")
    private String title;

    @ValueMapValue
    @Default(values = "Reach out to us through the following contact details.")
    private String description;

    @ValueMapValue
    @Default(values = "+1 234 567 890")
    private String phone;

    @ValueMapValue
    @Default(values = "contact@yourcompany.com")
    private String email;

    @ValueMapValue
    @Default(values = "https://youtube.com/yourchannel")
    private String youtubeUrl;

    @ValueMapValue
    @Default(values = "https://instagram.com/yourprofile")
    private String instagramUrl;

    @ValueMapValue
    @Default(values = "https://twitter.com/yourprofile")
    private String twitterUrl;


    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getYoutubeUrl() { return youtubeUrl; }
    public String getInstagramUrl() { return instagramUrl; }
    public String getTwitterUrl() { return twitterUrl; }
}
