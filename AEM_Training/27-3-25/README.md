# **AEM - Assignment 8**  

## **1. What is MSM, Blueprint, Live Copy, and Rollout?**  
Multi-Site Management (MSM) in AEM allows managing multiple versions of a website efficiently.  

- **Blueprint**: The master version of a site that acts as the source for multiple Live Copies.  
- **Live Copy**: A copy of the Blueprint that inherits updates when rolled out.  
- **Rollout**: The process of pushing updates from Blueprint to Live Copies using predefined configurations.  

---  

## **2. What is a Language Copy?**  
A **Language Copy** in AEM is a translated version of a site created independently from MSM. It enables content localization without inheriting changes from a Blueprint.  

---  

## **3. Create a Site Using MSM with `/content/us/en` as Source**  

### **Procedure:**  
1. **Navigate to** → `AEM Start → Sites`  
2. **Select** `/content/us/en` as the source site  
3. **Click** `Create → Live Copy`  
4. **Specify** the destination path (e.g., `/content/global`)  
5. **Configure** rollout settings and enable inheritance from `/content/us/en`  
6. **Save** and verify that the Live Copy is created  
7. **Test** the rollout process by making changes in `/content/us/en` and rolling them out to the Live Copy  

## **4. Create a sample McDonald's page in AEM**  

### **Procedure:**
1. **Navigate to** → `AEM Start → Sites`  
2. **Select** `/content` as the source site  
3. **Click** `Create → McDonald's site`
4. **Create** the required pages
5. **Add** components to each page

     
