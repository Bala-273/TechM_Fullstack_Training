# Event Assist Application

## 1. Introduction

The **Event Assist Application** is a Single Page Application (SPA) developed using Angular. It is designed to streamline the process of organizing and managing events by offering users a seamless experience to:

- Submit event-related enquiries
- View available services
- Explore upcoming events

---

## 2. Application Details and Workflow

The application includes the following modules and features:

- **User Authentication**: Users log in with valid credentials stored securely in the browser’s local storage.
- **Home Page**: Overview of upcoming events and featured services.
- **Enquiry Submission**: Users can submit event-related enquiries through a form.
- **Enquiry Response**: Admins can view and respond to customer enquiries.
- **Services Page**: Displays available services with a filtering feature.
- **Contact Page**: Shows detailed contact information.
- **About Page**: Information about the Event Assist platform.
- **Logout Functionality**: Available from the menu bar on any page.

---

## 3. Project Structure

```
src/app/
│
├── common/
│   ├── login/                 # LoginComponent: Manages user login
│   └── menu-bar/             # MenuBarComponent: Navigation with logout button
│
├── data/
│   └── info.ts               # Static contact data for Contact Page
│
├── model/
│   ├── contact.model.ts      # Contact info model
│   ├── event.model.ts        # Event details model
│   └── service.model.ts      # Services model
│
├── pages/
│   ├── about/                # AboutComponent
│   ├── contact/              # ContactComponent
│   ├── enquiry/
│   │   ├── enquiry-form/     # EnquiryFormComponent
│   │   └── enquiry-response/ # EnquiryResponseComponent
│   ├── home/                 # HomeComponent
│   ├── event/
│   │   ├── event/            # EventComponent
│   │   └── event-card/       # EventCardComponent
│   └── services/
│       ├── service-card/     # ServiceCardComponent
│       └── services/         # ServicesComponent (includes filtering)
│
├── pipes/
│   └── filter.pipe.ts        # Custom FilterPipe for services
│
├── services/
│   └── api.service.ts        # Handles all HTTP requests
│
└── json/
    └── mock-data.json        # Simulated backend data
```

---

## 4. Angular Concepts Implemented

### 1. Components

Components are the backbone of the application:
- `LoginComponent`
- `MenuBarComponent`
- `HomeComponent`
- `EnquiryComponent`
- `EventComponent`
- Others...

### 2. Parent-Child Component Communication

Utilized `@Input()` to pass data from parent to child components:
- `HomeComponent` → `EventCardComponent`
- `ServicesComponent` → `ServiceCardComponent`

### 3. Structural and Attribute Directives

Used to control the DOM:
- `*ngFor` for iterating over events/services
- `*ngIf` for conditional rendering (e.g., logout button)

### 4. @Input Decorator

Facilitates component reusability and data sharing between components.

### 5. Basic Routing

Defined in `app-routing.module.ts`:
- Routes for Home, About, Contact, Services, and Enquiry pages
- Lazy loading applied for performance optimization

### 6. Services

Angular Services are used for data handling:
- `api.service.ts`:
  - Manages all HTTP interactions
  - Fetches event, service, and enquiry data

### 7. Observables

Used for asynchronous data handling:
- API calls return observables
- Subscribed to in components for real-time UI updates

### 8. API Calls

Implemented via Angular’s `HttpClientModule`:
- **GET** and **POST** requests
- Fetches data from mock JSON files

### 9. Forms

Used both **Template-Driven** and **Reactive** Forms:

- **Template-Driven**: `LoginComponent`
- **Reactive**: `EnquiryResponseComponent` (with validation)

### 10. Pipes

Created a **custom FilterPipe**:
- Filters services by category or search keywords

---
