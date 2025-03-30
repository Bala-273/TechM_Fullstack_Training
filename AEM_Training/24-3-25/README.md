# **AEM - Assignment 5**  

## **1. Create 5 Unique News Article Pages Under `/content/us/en/news`**  

### **Steps:**  
1. Start AEM.
2. Open the sites  
3. Navigate to the content structure for pages:  
   ```
   /us/en/news/
   ```  
4. Create **five unique news article pages** using the **Page Template**.  
5. Use the **News Component** to display:  
   - Title  
   - News Details  
   - Published Date  
6. Ensure each news article has different content.  

### **Testing:**  
- Open AEM: `http://localhost:4502/sites.html/content/us/en/news`  
- Verify that all five news pages are created and properly display the news content.  

---

## **2. Create Header Experience Fragment (XF) with Navigation Menu**  

### **Steps:**  
1. Navigate to Experience Fragments in AEM:  
   ```
   /content/experience-fragments/myTraining/header
   ```  
2. Create a **Header XF** named `news-header`.  
3. Add a **Navigation Component** with links to:  
   - News (`/content/us/en/news`)  
   - Contact Us (`/content/us/en/contact`)  
   - About Me (`/content/us/en/about`)  
4. Apply this **Header XF** to all pages.  

### **Testing:**  
- Open a news article page and verify that the **header menu** is displayed correctly.  

---

## **3. Create "About Me" and "Contact Us" Pages**  

### **About Me Page:**  
1. Create a page at:  
   ```
   /content/us/en/about
   ```  
2. Use **Teaser, Image, Text, and Title Components** to provide journalist details.  

### **Contact Us Page:**  
1. Create a page at:  
   ```
   /content/us/en/contact
   ```  
2. Use **Text Component** to include:  
   - Mobile Number  
   - Office Address  
   - Email Address  

### **Testing:**  
- Open both pages in AEM Editor and verify the content is displayed correctly.  

---

## **4. Create Footer Experience Fragment (XF) with 4 Sections**  

### **Steps:**  
1. Navigate to Experience Fragments:  
   ```
   /content/experience-fragments/myTraining/footer
   ```  
2. Create a **Footer XF** named `news-footer`.  
3. Add the following sections:  
   - **News Menu Section:** Use the **List Component** to display four news articles.  
   - **About Me Section:** Use the **Text Component** for journalist details.  
   - **Contact Us Section:** Use the **Text Component** for contact details.  
   - **Social Media Section:** Use the **List Component** to display social media links.  
4. Assign this **Footer XF** to all pages.  

### **Testing:**  
- Open a page and verify that the **footer is displayed correctly**.  

---

## **5. Create a Custom Service to Print "Hello World"**  

### **Steps:**  
1. Create a service class in `core` module.  
2. Implement a method to return "Hello, World!".  
3. Inject this service into the **News Component Sling Model**.  
4. Print the returned value in logs.  

### **Code:**  

```java
package com.myTraining.core.services;

public interface HelloWorldService {
    String getMessage();
}
```

### **Impl Code:**

```java
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

```

```java
package com.myTraining.core.models;

import com.myTraining.core.services.HelloWorldService;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class NewsModel {

    @OSGiService
    private HelloWorldService helloWorldService;

    public String getHelloMessage() {
        return helloWorldService.getHelloWorldMessage();
    }
}
```

```java
package com.myTraining.core.models;

import com.myTraining.core.services.HelloWorldService;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;

import static com.adobe.cq.wcm.core.components.commons.editor.dialog.childreneditor.Item.LOG;

@Model(adaptables = org.apache.sling.api.resource.Resource.class)
public class NewsModel {

    private static final Logger LOG = LoggerFactory.getLogger(NewsModel.class);


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

    /*@OSGiService
    private HelloWorldService helloWorldService;*/

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

    @Inject
    private HelloWorldService helloWorldService;

    public String getServiceMessage() {
        String message = helloWorldService.getMessage();

        LOG.info("NewsModel received service message: {}", message);

        return message;
    }
}

```  

### **Testing:**  
1. Deploy the code:  
   ```
   mvn clean install -PautoInstallPackage  
   ```  
2. Open AEM Logs and verify the `"Hello, World!"` message is printed.  

---

## **6. Create Custom Configuration for 3rd Party API Integration**  

### **Steps:**  
1. Create ApiConfig in config folder
2. Create ApiService in services folder
3. Define an **OSGi Configuration** to store API URL.  
4. Implement a service to fetch data from the API.  
5. Print the API response in logs.  

### **Code:**  

```java
package com.myTraining.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "API Configuration")
public @interface ApiConfig {

    @AttributeDefinition(name = "API Endpoint", description = "Enter the API URL")
    String apiEndpoint() default "https://jsonplaceholder.typicode.com/posts";
}
```

```java
package com.myTraining.core.services;

import com.myTraining.core.config.ApiConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

@Component(service = ApiService.class, immediate = true)
@Designate(ocd = ApiConfig.class)
public class ApiService {

    private static final Logger LOG = LoggerFactory.getLogger(ApiService.class);
    private String apiUrl;

    @Activate
    @Modified
    protected void activate(ApiConfig config) {
        this.apiUrl = config.apiEndpoint();
        LOG.info("Configured API URL: {}", apiUrl);
        fetchAndLogApiData();  // Call API during activation
    }

    public String fetchApiData() {
        String jsonResponse = "";
        LOG.info("Fetching API data from: {}", apiUrl);

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();
            LOG.info("HTTP Response Code: {}", responseCode);

            if (responseCode == 200) {
                InputStream inputStream = conn.getInputStream();
                jsonResponse = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                LOG.info("API Response Data: {}", jsonResponse);
            } else {
                LOG.error("API Call Failed. Response Code: {}", responseCode);
            }
        } catch (Exception e) {
            LOG.error("Error in fetchApiData()", e);
        }

        return jsonResponse;
    }

    private void fetchAndLogApiData() {
        String data = fetchApiData();
        LOG.info("Final API Response Logged: {}", data);
    }
}
```

### **Testing:**  
1. Deploy the code:  
   ```
   mvn clean install -PautoInstallPackage  
   ```  
2. Open **AEM OSGi Console**:  
   ```
   http://localhost:4502/system/console/configMgr  
   ```  
3. Search for **API Configuration** and provide the API URL.  
4. Check logs for API response.  

---

## **Summary**  

In this implementation, we have:  
1. Created **five news article pages** using the Newsroom Template.
2. Developed **header and footer** using Experience Fragments.
3. Created **About Me** and **Contact Us** pages.
4. Implemented a **custom service** to print "Hello, World!" in logs.
5. Developed a **custom configuration** to fetch data from a **third-party API** and print it in logs.  

