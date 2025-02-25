import React from 'react';
import ReactDOM from 'react-dom/client';

function ContainsVowel() {
  return <h1>The string contains a vowel.</h1>;
}

function NoVowel() {
  return <h1>The string does not contain any vowels.</h1>;
}

function CheckVowelInString(props) {
  const str = props.str.toLowerCase(); // Convert string to lowercase to handle case insensitivity

  // If conditional
  if (/[aeiou]/.test(str)) {
    return <ContainsVowel />;
  }

  // Logical && conditional
  const checkWithLogicalAnd = /[aeiou]/.test(str) && <ContainsVowel />;
  if (checkWithLogicalAnd) {
    return checkWithLogicalAnd;
  }

  // Ternary operator conditional
  return /[aeiou]/.test(str) ? <ContainsVowel /> : <NoVowel />;
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<CheckVowelInString str="Hell" />);
