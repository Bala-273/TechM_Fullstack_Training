package com.myTraining.core.servlets;

import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.LoginException;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Search Pages Servlet",
                "sling.servlet.paths=/bin/search-pages",
                "sling.servlet.methods=GET"
        }
)
public class SearchServlet extends SlingSafeMethodsServlet {

    @Reference
    private QueryBuilder queryBuilder;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        // Build query parameters
        Map<String, String> predicates = new HashMap<>();
        predicates.put("type", "cq:Page");
        predicates.put("path", "/content/us/en");
        predicates.put("fulltext", request.getParameter("query"));
        predicates.put("p.limit", "10");

        // Obtain ResourceResolver with proper authentication
        Map<String, Object> authInfo = new HashMap<>();
        authInfo.put(ResourceResolverFactory.SUBSERVICE, "data-reader"); // Ensure proper service user exists

        try (ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(authInfo)) {
            Session session = resolver.adaptTo(Session.class);
            if (session == null) {
                response.getWriter().write("Error: Could not obtain JCR session.");
                return;
            }

            Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), session);
            SearchResult result = query.getResult();

            if (!result.getHits().isEmpty()) {
                for (Hit hit : result.getHits()) {
                    response.getWriter().write(hit.getPath() + "\n");
                }
            } else {
                response.getWriter().write("No results found.\n");
            }

        } catch (LoginException e) {
            response.getWriter().write("Error: Unable to obtain a service resource resolver.\n");
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
