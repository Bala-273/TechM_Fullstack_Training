import React from 'react';
import ReactDOM from 'react-dom/client';

function EvenLength() {
  return <h1>Even Length</h1>;
}

function OddLength() {
  return <h1>Odd Length</h1>;
}

function CheckStringLength(props) {
  const str = props.str;

  If conditional
  if (str.length % 2 === 0) {
    return <EvenLength />;
  } 

  // Logical && conditional
  const checkWithLogicalAnd = str.length % 2 === 0 && <EvenLength />;
  if (checkWithLogicalAnd) {
    return checkWithLogicalAnd;
  }

  // Ternary operator conditional
  return str.length % 2 === 0 ? <EvenLength /> : <OddLength />;
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<CheckStringLength str="Hello" />);
