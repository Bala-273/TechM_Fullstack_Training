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
                "sling.servlet.paths=/bin/create-page",  // ✅ Servlet path
                "sling.servlet.methods=GET"
        }
)
public class CreatePageServlet extends SlingSafeMethodsServlet {
    private static final String DEFAULT_TEMPLATE = "/conf/myTraining/settings/wcm/templates/content-page"; // ✅ Change to your template path
    private static final String PARENT_PATH = "/content/myTraining"; // ✅ Parent path where new pages will be created

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
