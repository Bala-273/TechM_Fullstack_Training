# **AEM Digital Asset Management and Component Development Report**  

## **1. What is DAM and Why Do We Use It?**  
Digital Asset Management (DAM) is a system in AEM that allows the storage, management, organization, and delivery of digital assets like images, videos, PDFs, and documents.  

- Centralized asset storage  
- Easy asset search with metadata  
- Asset versioning and rendition support  
- Seamless integration with AEM components and pages  
- Optimized delivery of assets to end users  

---

## **2. Creating a Folder in DAM and Uploading Images**  

### **Steps to Create Folder:**  
1. Log in to AEM Author instance:  
   http://localhost:4502/aem/assets.html/content/dam  
2. Click Create > Folder  
3. Provide Folder Name: myTraining → Click Create  
4. Navigate inside myTraining → Click Create > Folder  
   - Name: us  
5. Inside us, create another folder named en-us  

Your final path will be:  
```
/content/dam/myTraining/us/en-us
```
or directly accessible at:  
```
http://localhost:4502/assets.html/content/dam/myTraining/us/en-us
```

### **Steps to Upload Images:**  
1. Inside en-us folder, click Create > Files  
2. Select and upload two images from your local machine  
3. Verify the images are visible in the folder  

---

## **3. Authoring Uploaded Images on Page Using Image Component**  

1. Go to: http://localhost:4502/sites.html  
2. Open your site and select a page (or create a new page)  
3. Click Edit to open in page editor  
4. From the left panel, search for Image Component  
5. Drag & drop Image Component onto the page  
6. Click on the image placeholder → Configure (Wrench Icon)  
7. Click Select Image → Browse to:  
   ```
   /content/dam/myTraining/us/en-us
   ```
8. Choose one of the uploaded images → Click Done  
9. Repeat the same for the second image  
10. Save & Close the page  

---

## **4. What are Renditions? How to Check Renditions**  

Renditions are automatically generated versions of an image in different resolutions and sizes. They improve performance and ensure responsive delivery.  

### **Steps to Check Renditions:**  
1. Go to:  
   ```
   http://localhost:4502/assets.html/content/dam/myTraining/us/en-us
   ```
2. Click on any uploaded image  
3. In the left panel, click on Renditions  
4. You will see different versions like:  
   - Original  
   - Thumbnail  
   - Web Renditions (small, medium, large)  

**Example Renditions URL:**  
For image:  
```
/content/dam/myTraining/us/en-us/image1.jpg
```
You can access renditions at:  
```
http://localhost:4502/assets.html/content/dam/myTraining/us/en-us/image1.jpg/renditions
```

---

## **5. Adding FirstName and LastName Fields in HelloWorld2 Component**  

### **Steps:**  

### **A) Update cq:dialog**  
1. Go to CRXDE:  
   ```
   http://localhost:4502/crx/de/index.jsp
   ```
2. Open:  
   ```
   /apps/myTraining/components/content/helloworld2/cq:dialog
   ```
3. Add two fields:  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0" xmlns:cq="http://www.day.com/jcr/cq/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0" xmlns:nt="http://www.jcp.org/jcr/nt/1.0"
          jcr:primaryType="nt:unstructured"
          jcr:title="Properties"
          sling:resourceType="cq/gui/components/authoring/dialog">
    <content
            jcr:primaryType="nt:unstructured"
            sling:resourceType="granite/ui/components/coral/foundation/fixedcolumns">
        <items jcr:primaryType="nt:unstructured">
            <column
                    jcr:primaryType="nt:unstructured"
                    sling:resourceType="granite/ui/components/coral/foundation/container">
                <items jcr:primaryType="nt:unstructured">
                    <firstName
                            jcr:primaryType="nt:unstructured"
                            sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                            fieldLabel="First Name"
                            name="./firstName"/>
                    <lastName
                            jcr:primaryType="nt:unstructured"
                            sling:resourceType="granite/ui/components/coral/foundation/form/textfield"
                            fieldLabel="Last Name"
                            name="./lastName"/>
                </items>
            </column>
        </items>
    </content>
</jcr:root>
```

### **B) Update helloworld2.html**  
```html
<sly data-sly-use.helloWorld2="com.myTraining.core.models.HelloWorld2"/>
<div class="helloworld2-component">
    <p><strong>First Name:</strong> ${helloWorld2.firstName}</p>
    <p><strong>Last Name:</strong> ${helloWorld2.lastName}</p>
</div>

```

---

## **6. Using @ValueMapValue in HelloWorldModel2**  

### **Steps:**  
1. Go to:  
   ```
   /apps/myTraining/core/src/com/myTraining/core/models/HelloWorldModel.java
   ```
2. Add the following code:  

```java
package com.myTraining.core.models;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class HelloWorld2 {

    @ValueMapValue
    private String firstName;

    @ValueMapValue
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

```

3. Build and deploy the bundle  
4. Open the page and verify that first name and last name values appear after authoring  

---

## **7. Creating Packages Using Package Manager**  

Package Manager is used to bundle content and code for easy deployment, backup, and transfer between AEM environments.  

### **Steps to Create Packages:**  

### **A) Create DAM Package (Images)**  
1. Go to Package Manager:  
   ```
   http://localhost:4502/crx/packmgr/index.jsp
   ```
2. Click Create Package  
3. Name: dam-assets  
4. Group: myTraining  
5. Version: 1.0  
6. Edit the package and add Filter Path:  
   ```
   /content/dam/myTraining/us/en-us
   ```
7. Click Save > Build > Download  

### **B) Create HelloWorld Component Package**  
1. Again, click Create Package  
2. Name: helloworld-component  
3. Group: myTraining  
4. Version: 1.0  
5. Add Filter Path:  
   ```
   /apps/myTraining/components/content/helloworld
   ```
6. Save > Build > Download  

---

## **8. Configure Replication Agent and Publish Page**  

### **A) Configure Replication Agent**  
1. Go to:  
   ```
   http://localhost:4502/etc/replication/agents.author.html
   ```
2. Open Default Agent (publish)  
3. Edit configuration:  
   ```
   Transport URI: http://localhost:4503/bin/receive
   ```
4. Click Test Connection → It should succeed  
5. Save configuration  

### **B) Publish the Page**  
1. Navigate to:  
   ```
   http://localhost:4502/sites.html
   ```
2. Open your project page  
3. Select the page → Click Quick Publish > Publish Page  
4. Verify the page is accessible on Publish Instance:  
   ```
   http://localhost:4503
   ```

---

## **Summary**  
In this report, we have successfully covered:  
- Creation and use of DAM  
- Uploading assets and checking renditions  
- Authoring assets on a page  
- Enhancing HelloWorld component with fields and Sling Model  
- Using @ValueMapValue annotation  
- Packaging assets and components  
- Replication configuration and page publishing  

---
