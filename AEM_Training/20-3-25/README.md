# **AEM - Assignment 3**  

## **1. Creating a News Component with Sling Model**  

### **Steps to Create News Component:**  

### **A) Create Component in CRXDE:**  
1. Go to CRXDE:  
   ```
   http://localhost:4502/crx/de/index.jsp
   ```
2. Navigate to:  
   ```
   /apps/myTraining/components/content
   ```
3. Click **Create > Component**  
4. Name it: **news**  
5. Open **news.html** and add:  

```html

<sly data-sly-use.clientLib="/libs/granite/sightly/templates/clientlib.html"/>
<sly data-sly-call="${clientLib.css @ categories='myTraining.news'}"/>

<div class="cop-news-component">
    <h2 class="news-title">${properties.title}</h2>
    <p class="news-detail">${properties.detail}</p>
    <p class="news-date">${properties.publishedDate}</p>
    <p class="news-source">Source: ${properties.source}</p>
</div>
<sly data-sly-call="${clientLib.js @ categories='myTraining.news'}"/>


```

### **B) Create Sling Model for News Component**  
1. Navigate to:  
   ```
   /apps/myTraining/core/src/com/myTraining/core/models/NewsModel.java
   ```
2. Add the following code:  

```java
package com.myTraining.core.models;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;

@Model(adaptables = org.apache.sling.api.resource.Resource.class)
public class NewsModel {

    @Inject
    @Default(values = "No Title")
    private String title;

    @Inject
    @Default(values = "No Details Available")
    private String detail;

    @Inject
    @Default(values = "Unknown Date")
    private String publishedDate;

    @Inject
    @Default(values = "Unknown Source")
    private String source;

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSource() {
        return source;
    }
}

```

3. Build and deploy the bundle  
4. Add this component to a page and author the values  

---

## **2. Creating a Multi-Field News Component**  

### **Steps:**  

### **A) Create Multi-Field Component in CRXDE:**  
1. Navigate to:  
   ```
   /apps/myTraining/components/content
   ```
2. Click **Create > Component**  
3. Name it: **NewsList**  
4. Open **cq:dialog** and add:  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
          xmlns:cq="http://www.day.com/jcr/cq/1.0"
          xmlns:jcr="http://www.jcp.org/jcr/1.0"
          jcr:primaryType="cq:Dialog"
          jcr:title="News List"
          sling:resourceType="cq/gui/components/authoring/dialog">
    <content jcr:primaryType="nt:unstructured"
             sling:resourceType="granite/ui/components/coral/foundation/container">
        <items jcr:primaryType="nt:unstructured">
            <newsItems jcr:primaryType="nt:unstructured"
                       sling:resourceType="granite/ui/components/coral/foundation/form/multifield"
                       fieldLabel="News Items">
                <field jcr:primaryType="nt:unstructured"
                       sling:resourceType="granite/ui/components/coral/foundation/form/container">
                    <items jcr:primaryType="nt:unstructured">
                        <title jcr:primaryType="nt:unstructured"
                               sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                               fieldLabel="News Title"
                               name="./title"/>
                        <source jcr:primaryType="nt:unstructured"
                                sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                                fieldLabel="News Source"
                                name="./source"/>
                    </items>
                </field>
            </newsItems>
        </items>
    </content>
</jcr:root>


```

### **B) Create Sling Model for Multi-Field:**  

```java
package com.myTraining.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsListModel {

    @Inject
    private List<NewsItem> newsItems;

    public List<NewsItem> getNewsItems() {
        return Optional.ofNullable(newsItems).orElse(new ArrayList<>());
    }

    public static class NewsItem {
        @Inject
        private String title;

        @Inject
        private String source;

        public String getTitle() {
            return title;
        }

        public String getSource() {
            return source;
        }
    }
}

```

### **C) Update NewsList.html:**  

```html

<sly data-sly-use.model="com.myTraining.core.models.NewsListModel"/>
<div class="news-list">
    <sly data-sly-list.newsItem="${model.newsItems}">
        <div class="news-item">
            <h3>${newsItem.title}</h3>
            <p>Source: ${newsItem.source}</p>
        </div>
    </sly>
```

---

## **3. Creating Clientlibs for News Component**  

### **Steps:**  
1. Navigate to:  
   ```
   /apps/myTraining/clientlibs/news
   ```
2. Create **css.txt** and add:  

```
news.css
```

3. Inside **news** folder, create **news.css** and **news.js**  
4. Add styles in **news.css:**  

```css
.cop-news-component h2 {
    color: green;
}

.cop-news-component p {
    color: yellow;
}

.cop-news-component .news-date {
    color: blue;
}

```

5. Include clientlibs in **news.html:**  

```html

<sly data-sly-use.clientLib="/libs/granite/sightly/templates/clientlib.html"/>
<sly data-sly-call="${clientLib.css @ categories='myTraining.news'}"/>

<div class="cop-news-component">
    <h2 class="news-title">${properties.title}</h2>
    <p class="news-detail">${properties.detail}</p>
    <p class="news-date">${properties.publishedDate}</p>
    <p class="news-source">Source: ${properties.source}</p>
</div>
<sly data-sly-call="${clientLib.js @ categories='myTraining.news'}"/>


```

---

## **4. Adding Custom Style Name to News Component**  

### **Steps:**  
1. Open **cq:dialog** of **news**  
2. Add the following node:  

```xml
<extraClientlibs jcr:primaryType="nt:unstructured"
                 sling:resourceType="granite/ui/components/coral/foundation/form/select"
                 fieldLabel="Component Style"
                 name="./componentStyle">
    <items jcr:primaryType="nt:unstructured">
        <style1 jcr:primaryType="nt:unstructured"
                value="cop-news"
                text="Custom News Style"/>
    </items>
</extraClientlibs>
```

---

## **5. Creating a Base Page Component with Metadata**  

### **Steps:**  

### **A) Add Metadata in basePage.html**  

```html
<head>
    <meta property="og:title" content="${pageProperties.ogTitle}">
    <meta property="og:description" content="${pageProperties.ogDescription}">
    <meta property="og:image" content="${pageProperties.ogImage}">
</head>
```

### **B) Add Global Page Properties**  
1. Navigate to:  
   ```
   /apps/myTraining/components/structure/basePage/cq:dialog
   ```
2. Add fields:  

```xml
<items jcr:primaryType="cq:WidgetCollection">
    <ogTitle jcr:primaryType="nt:unstructured" fieldLabel="OG Title" name="./ogTitle" xtype="textfield"/>
    <ogDescription jcr:primaryType="nt:unstructured" fieldLabel="OG Description" name="./ogDescription" xtype="textfield"/>
    <ogImage jcr:primaryType="nt:unstructured" fieldLabel="OG Image Path" name="./ogImage" xtype="textfield"/>
</items>
```

---

## **Summary**  
In this report, we have successfully covered:  
- Creating a **news** component with Sling Model  
- Implementing a multi-field **news** component  
- Creating and applying clientlibs  
- Styling the component with CSS  
- Adding a custom component style option  
- Creating a base page component with metadata  
- Configuring global page properties  

---
