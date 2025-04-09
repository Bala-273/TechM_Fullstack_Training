# Quotes App

## 1. Introduction

The **Quotes App** is a mobile application built using **Flutter** and **Firebase**. It allows users to view and contribute motivational and inspirational quotes. The app supports **multi-language localization** (English, Tamil, and Spanish), offering a seamless experience for diverse users. Its core aim is to deliver random quotes over a visually appealing background, providing users with daily inspiration.

---

## 2. Application Details

Built with **Flutter (frontend)** and **Firebase Firestore (backend)**, the application includes the following features:

- **Random Quote Display**: Fetches and displays a random quote every 20 seconds using a timer event.
- **Multi-Language Support**: Supports English, Tamil, and Spanish through Flutter Localization. Users can dynamically change the language from the dropdown menu on the home screen.
- **Add Quote Feature**: Allows users to submit their own quotes, which are stored in Firebase.
- **All Quotes Screen**: Displays all saved quotes in a scrollable list, with options to delete individual quotes.
- **Custom Background Image**: All quotes are shown on a themed background image to enhance aesthetics.
- **Smooth Navigation**: Navigation between screens is handled using `Navigator.push()` and `Navigator.pop()`.
- **Dark Theme**: Consistent UI design with black backgrounds and white text across AppBar, FAB, and other UI elements.

---

## 3. Workflow and Concepts Used

### Navigation

Utilizes Flutter’s `Navigator` to manage screen transitions:

- **HomeScreen → AddQuoteScreen** (via FAB)
- **HomeScreen → AllQuotesScreen** (via list icon)

Example:

```dart
Navigator.push(context, MaterialPageRoute(builder: (_) => AddQuoteScreen()));
```

### Events

The app responds to user actions through various event-driven methods:

- **Show Another Quote**: Triggers `_updateRandomQuote()` to display a new quote.
- **Language Selection**: Updates UI using `setState()` and `widget.setLocale()`.
- **Add Quote Button**: Navigates to `AddQuoteScreen`.
- **Delete Quote**: Calls `deleteQuote()` in `FirebaseService`.
- **Quote Refresh Timer**: Uses `Timer.periodic()` to refresh quote every 20 seconds.

### Images

- Background image is stored in `assets/` and rendered using `Image.asset()`.
- Dark background with white text ensures readability.

### Layouts

UI is built using:

- `Column`, `Stack`, and `Positioned` widgets for structured quote display.
- `ListView.builder()` in AllQuotesScreen for rendering a scrollable list of quotes.
- Responsive design with padding and alignment to fit different screen sizes.

### Database (Firebase Firestore)

All quote data is stored and managed via Firebase Firestore:

- **getQuotesOnce()**: Fetches quotes on app load.
- **addQuote()**: Adds a new quote to the collection.
- **deleteQuote()**: Deletes a specific quote from the collection.

### Localization (Multi-language Support)

- Localization setup is configured under `lib/l10n/`.
- The app supports **English**, **Tamil**, and **Spanish**.
- Quotes are stored in multiple languages within Firestore.
- Language changes are applied using a `DropdownButton` on the home screen.

---
