# AEM News Website

This project is a News Website built using Adobe Experience Manager (AEM). The site showcases a modular structure with reusable components, a clean content hierarchy, and follows best practices for content authoring and navigation.

---

## Project Structure

- **Home Page**

  - Features teaser components for different news categories.
  - Each teaser includes a **Call-to-Action (CTA)** button labeled **"Read Full Article"**, which navigates users to the full news article on its respective page.

- **News Pages**

  - Organized into the following categories:
    - Business
    - Sports
    - Tech
    - Entertainment
  - Each page is built using the **Teaser component** to display news items with a thumbnail, title, and link to read more.

- **About Us**

  - Implemented using the **Text component**.
  - Contains information about the organization, mission, or editorial team.

- **Contact Us**
  - A **Custom contact-us component** developed specifically for this site.
  - Displays:
    - Phone number
    - Email address
    - Social media handles (YouTube, Instagram, Twitter, etc.)
  - All contact fields include hyperlinks for quick access.

---

## Navigation Flow

- The **Home page teasers** direct users to corresponding **news category pages**.
- **News category pages** display multiple teaser items representing different articles.
- The **CTA ("Read Full Article")** links guide users to the detailed news content.
- **Contact component** allows users to connect directly through provided links.

---

## 🧩 Components Used

| Page       | Components Used                                       |
| ---------- | ----------------------------------------------------- |
| Home       | Teaser (with CTA to news pages)                       |
| News Pages | Teaser (per article)                                  |
| About Us   | Text                                                  |
| Contact Us | Custom Contact Component (Phone, Email, Social Links) |

---
