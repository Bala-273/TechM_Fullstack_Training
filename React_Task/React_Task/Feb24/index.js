import React from 'react';
import ReactDOM from 'react-dom/client';

// Task 1: Render h2, h4, and p in separate divs
function RenderElements() {
  return (
    <>
      <div id="div1"><h2>This is an H2 tag</h2></div>
      <div id="div2"><h4>This is an H4 tag</h4></div>
      <div id="div3"><p>This is a paragraph</p></div>
    </>
  );
}

// Task 2: Flower Component (Function with Props)
function Flower(props) {
  return <h2>The flower is {props.name}</h2>;
}

// Task 3: Course Component (Class with Props)
class Course extends React.Component {
  render() {
    return <h2>The course is {this.props.name}</h2>;
  }
}

// Task 4: Animal Component (Function)
function Animal() {
  return <h2>This is an Animal Component</h2>;
}

// Task 5: Game Component (Class)
class Game extends React.Component {
  render() {
    return <h2>This is a Game Component</h2>;
  }
}

// Task 6: Training Component with Subcomponents
function Java() {
  return <h3>Java - Object-Oriented Programming Language</h3>;
}

function JavaScript() {
  return <h3>JavaScript - Scripting Language for Web Development</h3>;
}

function ReactJS() {
  return <h3>React - JavaScript Library for Building UI</h3>;
}

function Angular() {
  return <h3>Angular - Frontend Framework by Google</h3>;
}

function Training() {
  return (
    <div>
      <h2>Topics for Training</h2>
      <Java />
      <JavaScript />
      <ReactJS />
      <Angular />
    </div>
  );
}

// App Component to Render Everything
function App() {
  return (
    <div>
      <RenderElements />
      <Flower name="Rose" />
      <Course name="Information Technology" />
      <Animal />
      <Game />
      <Training />
    </div>
  );
}

// Rendering the App Component
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
