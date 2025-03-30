# **AEM - Assignment 7**  

## **1. Create `SampleServlet` Using `SlingAllMethodsServlet` and Register it Using `resourceType`**  

### **Implementation:**  
```java
package com.myTraining.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Sample Servlet",
                "sling.servlet.paths=/bin/sample-servlet",  
                "sling.servlet.methods=GET"
        }
)
public class SampleServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"Hello from SampleServlet!\"}");
    }
}

```

### **Testing:**  
1. Start the AEM instance.
2. Open the web browser.  
3. Access the servlet via page URL:  
   ```
   http://localhost:4502/bin/sample-servlet
   ```

---

## **2. Create `CreatePageServlet` Using `SlingSafeMethodsServlet` and Register Using Path**  

### **Task:**  
Develop a servlet to create new pages dynamically in AEM using `PageManager`.  

### **Implementation:**  
```java
package com.myTraining.core.servlets;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Create Page Servlet",
                "sling.servlet.paths=/bin/create-page",  
                "sling.servlet.methods=GET"
        }
)
public class CreatePageServlet extends SlingSafeMethodsServlet {
    private static final String DEFAULT_TEMPLATE = "/conf/myTraining/settings/wcm/templates/content-page"; 
    private static final String PARENT_PATH = "/content/myTraining"; // 

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        // Get page name from request
        String pageName = request.getParameter("pageName");
        if (pageName == null || pageName.isEmpty()) {
            response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Page name is required\"}");
            return;
        }

        try {
            // Get PageManager API
            PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
            if (pageManager != null) {
                // Create the new page
                Page newPage = pageManager.create(PARENT_PATH, pageName, DEFAULT_TEMPLATE, pageName);

                if (newPage != null) {
                    response.setStatus(SlingHttpServletResponse.SC_OK);
                    response.getWriter().write("{\"message\": \"Page created successfully\", \"path\": \"" + newPage.getPath() + "\"}");
                } else {
                    response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.getWriter().write("{\"error\": \"Failed to create page\"}");
                }
            } else {
                response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"error\": \"PageManager not found\"}");
            }
        } catch (WCMException e) {
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Exception: " + e.getMessage() + "\"}");
        }
    }
}
```

### **Testing:**  
Access in the browser:  
```
http://localhost:4502/bin/create-page?pageName=samplePage
```
Verify the page under `/content/myTraining/samplepage`.

---

## **3. Create `SearchServlet` to Search Content Using `PredicateMap`**  

### **Task:**  
Develop a servlet to search content in AEM using `QueryBuilder` and `PredicateMap`.  

### **Implementation:**  
```java
package com.myTraining.core.servlets;

import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.LoginException;
import org.osgi.service.component.annotations.Reference;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.jcr.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/searchcontent")
public class SearchServlet extends SlingSafeMethodsServlet {

    @Reference
    private QueryBuilder queryBuilder;

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Map<String, String> predicates = new HashMap<>();
        predicates.put("type", "cq:Page");
        predicates.put("path", "/content/myTraining");
        predicates.put("fulltext", request.getParameter("query"));
        predicates.put("p.limit", "10");

        JSONArray resultsArray = new JSONArray();
        ResourceResolver resolver = null;
        Session session = null;

        try {
            Map<String, Object> authInfo = new HashMap<>();
            authInfo.put(ResourceResolverFactory.SUBSERVICE, "data-reader");
            resolver = resolverFactory.getServiceResourceResolver(authInfo);
            session = resolver.adaptTo(Session.class);

            if (session != null) {
                Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), session);
                SearchResult result = query.getResult();

                for (Hit hit : result.getHits()) {
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("path", hit.getPath());
                    resultsArray.put(jsonObj);
                }
            } else {
                response.getWriter().write("{\"error\": \"Failed to obtain session\"}");
                return;
            }

        } catch (LoginException e) {
            response.getWriter().write("{\"error\": \"ResourceResolver login failed: " + e.getMessage() + "\"}");
        } catch (Exception e) {
            response.getWriter().write("{\"error\": \"Error: " + e.getMessage() + "\"}");
        } finally {
            if (session != null) {
                session.logout();
            }
            if (resolver != null) {
                resolver.close();
            }
        }

        response.getWriter().write(resultsArray.toString());
    }
}
```

### **Testing:**  
Access in the browser:  
```
http://localhost:4502/bin/search-pages?query=home
```
Expected JSON response:  
```json
[
    {"path": "/content/myTraining/home-page"},
    {"path": "/content/myTraining/home"}
]
```

---
