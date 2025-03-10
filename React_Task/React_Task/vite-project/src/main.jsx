import React from "react";
import ReactDOM from "react-dom/client";
import { StrictMode } from "react";
//import App from "./App.jsx";
import ErrorBoundary from "./Feb28/Error_Boundaries/ErrorBoundary";
import ABComponentForError from "./Feb28/Error_Boundaries/ABComponent";
const root = ReactDOM.createRoot(document.getElementById("root")); 



root.render(
  <StrictMode>
    <ErrorBoundary>
    <ABComponentForError />
    </ErrorBoundary>
    
  </StrictMode>
); 

