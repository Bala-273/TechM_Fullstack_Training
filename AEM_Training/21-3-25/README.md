## AEM - Assignment 4

## 1. Create News Room Page Component Using Base Page Component

- **Location:**  
  `ui.apps/src/main/content/jcr_root/apps/myTraining/components/`

- **Steps:**
  1. Create a new folder named `newsroom-page`.
  2. Inside `newsroom-page`, create a new file `newsroom-page.html`.
  3. Add the following code to extend the base page component:
     ```html
     <sly data-sly-use.basePage="com.myTraining.core.models.BasePageModel">
         <div class="newsroom-page">
             <sly data-sly-include="@basePage.html"/>
         </div>
     </sly>
     ```

---

## 2. Create Custom Page Property: NEWS Configurations

- **Location:**  
  `ui.apps/src/main/content/jcr_root/apps/myTraining/components//newsroom-page`

- **Steps:**
  1. Create a `cq:dialog` file in the `newsroom-page` folder.
  2. Add the following code to define custom properties:
     ```xml
     <jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
               xmlns:cq="http://www.day.com/jcr/cq/1.0"
               xmlns:jcr="http://www.jcp.org/jcr/1.0"
               jcr:primaryType="cq:Dialog"
               cq:dialogMode="floating">
         <content jcr:primaryType="nt:unstructured"
                  sling:resourceType="granite/ui/components/coral/foundation/container">
             <items jcr:primaryType="nt:unstructured">
                 <newsConfig jcr:primaryType="nt:unstructured"
                             sling:resourceType="granite/ui/components/coral/foundation/form/fieldset"
                             jcr:title="NEWS Configurations">
                     <items jcr:primaryType="nt:unstructured">
                         <defaultImage jcr:primaryType="nt:unstructured"
                                       sling:resourceType="granite/ui/components/coral/foundation/form/fileupload"
                                       fieldLabel="Default News Image"
                                       name="./defaultNewsImage"/>
                         <readMoreCTA jcr:primaryType="nt:unstructured"
                                      sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                                      fieldLabel="Read More CTA"
                                      name="./readMoreCTA"/>
                     </items>
                 </newsConfig>
             </items>
         </content>
     </jcr:root>
     ```

---

## 3. Create News Room Template Type Using News Room Page Component

- **Location:**  
  `ui.apps/src/main/content/jcr_root/conf/myTraining/settings/wcm/template-types`

- **Steps:**
  1. Create a new folder named `newsroom-template-type`.
  2. Inside this folder, create a file named `.content.xml`.
  3. Add the following code:
     ```xml
     <jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
               xmlns:cq="http://www.day.com/jcr/cq/1.0"
               xmlns:jcr="http://www.jcp.org/jcr/1.0"
               jcr:primaryType="cq:TemplateType"
               jcr:title="News Room Template Type"
               allowedPaths="/content/myTraining(/.*)?"
               allowedChildren="/apps/myTraining/components/structure/newsroom-page"/>
     ```

---

## 4. Create News Room Template Using News Room Template Type

- **Location:**  
  `ui.apps/src/main/content/jcr_root/conf/myTraining/settings/wcm/templates`

- **Steps:**
  1. Create a new folder named `newsroom-template`.
  2. Inside this folder, create a file named `.content.xml`.
  3. Add the following code:
     ```xml
     <jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0"
               xmlns:cq="http://www.day.com/jcr/cq/1.0"
               xmlns:jcr="http://www.jcp.org/jcr/1.0"
               jcr:primaryType="cq:Template"
               jcr:title="News Room Template"
               jcr:description="Template for News Room Pages"
               allowedPaths="/content/myTraining(/.*)?"
               cq:templateType="/conf/myTraining/settings/wcm/template-types/newsroom-template-type"/>
     ```

---

## 5. Apply Styling to News/Hello World Component from ui.frontend

- **Location:**  
  `ui.frontend/src/main/webpack/components/news/news.scss`

- **Steps:**
  1. Add the following CSS code to style the component:
     ```scss
     .news-component {
         h2 {
             color: green;
         }
         p {
             color: yellow;
         }
         .date {
             color: black;
         }
     }
     ```

---


##  Summary
- **Created a News Room Page Component** using the Base Page Component.
- **Added Custom Page Properties** for NEWS Configurations (Default News Image, Read More CTA).
- **Created a News Room Template Type** and **News Room Template**.
- **Applied Styling** to News/Hello World components from the `ui.frontend`.

---
