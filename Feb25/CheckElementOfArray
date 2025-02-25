import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';

function IsFlower() {
  return <h1>It is a flower.</h1>;
}

function NotFlower() {
  return <h1>It is not a flower.</h1>;
}

function CheckFlower(props) {
  const flowers = ['Rose', 'Jasmine', 'Lotus'];
  const input = props.input.trim();  // Get the input string

  // If conditional
  if (flowers.includes(input)) {
    return <IsFlower />;
  }

  // Logical && conditional
  const checkWithLogicalAnd = flowers.includes(input) && <IsFlower />;
  if (checkWithLogicalAnd) {
    return checkWithLogicalAnd;
  }

  // Ternary operator conditional
  return flowers.includes(input) ? <IsFlower /> : <NotFlower />;
}

function App() {
  const [input, setInput] = useState('');

  const handleChange = (event) => {
    setInput(event.target.value);
  };

  return (
    <div>
      <input
        type="text"
        value={input}
        onChange={handleChange}
        placeholder="Enter a flower name"
      />
      <CheckFlower input={input} />
    </div>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
