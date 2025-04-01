/*package com.myTraining.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class)
public class NewsroomModel {

    @Inject
    private Resource resource;

    public List<NewsArticle> getNewsArticles() {
        List<NewsArticle> newsList = new ArrayList<>();
        Resource newsRoot = resource.getResourceResolver().getResource("/content/news");

        if (newsRoot != null) {
            for (Resource child : newsRoot.getChildren()) {
                ValueMap props = child.getValueMap();
                newsList.add(new NewsArticle(
                        props.get("title", String.class),
                        props.get("description", String.class),
                        props.get("image", String.class)
                ));
            }
        }
        return newsList;
    }

    public static class NewsArticle {
        private final String title;
        private final String description;
        private final String image;

        public NewsArticle(String title, String description, String image) {
            this.title = title;
            this.description = description;
            this.image = image;
        }

        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getImage() { return image; }
    }
}*/
