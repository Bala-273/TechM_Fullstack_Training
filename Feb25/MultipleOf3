import React from 'react';
import ReactDOM from 'react-dom/client';

function MultipleOf3() {
  return <h1>The number of elements in the array is a multiple of 3.</h1>;
}

function NotMultipleOf3() {
  return <h1>The number of elements in the array is not a multiple of 3.</h1>;
}

function CheckArrayLength(props) {
  const arr = props.arr;

  // If conditional
  if (arr.length % 3 === 0) {
    return <MultipleOf3 />;
  }

  // Logical && conditional
  const checkWithLogicalAnd = arr.length % 3 === 0 && <MultipleOf3 />;
  if (checkWithLogicalAnd) {
    return checkWithLogicalAnd;
  }

  // Ternary operator conditional
  return arr.length % 3 === 0 ? <MultipleOf3 /> : <NotMultipleOf3 />;
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<CheckArrayLength arr={[9, 4, 24]} />);
