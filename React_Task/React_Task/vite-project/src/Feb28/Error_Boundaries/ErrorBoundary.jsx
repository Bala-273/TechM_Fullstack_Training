import React, { Component } from "react";

export default class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }
componentDidCatch(err, errInfo) {
    console.error("Error :" + err);
    console.error("Error info:" + errInfo);
    this.setState({ hasError: true });
  }
render() {
    if (this.state.hasError) {
      return (
        <div>
          ErrorBoundary
          <h2>Something went wrong!!!!</h2>
        </div>
      );
    }
    return this.props.children;
  }
}

/*createRoot(document.getElementById('root')).render(
  <StrictMode>
    <h2>Hi!!!</h2>
    <ErrorBoundary>
        <ABComponentForError />
    </ErrorBoundary>
      
  </StrictMode>,
) */
