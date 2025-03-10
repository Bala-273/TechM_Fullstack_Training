//If Else - Check Odd Even
import React from 'react';
import ReactDOM from 'react-dom/client';

function EvenNumber() {
    return <h1>EvenNumber!</h1>;
}
function OddNumber() {
    return <h1>OddNumber!</h1>;
}

function CheckNumber(props) {
  const isNum = props.num;
  if (isNum % 2 === 0) {
    return <EvenNumber />;
  }
  return <OddNumber />;
}

const root = ReactDOM.createRoot(document.getElementById('root1'));
root.render(<CheckNumber num={903} />);


//Logical && Friends
import React from 'react';
import ReactDOM from 'react-dom/client';

function FriendsForMe(props) {
  const friends = props.friends;
  return (
    <>
      <h1>About Friends!!</h1>
      { friends.length > 0 &&
        <h2>
          You have {friends.length} friends for you!!!
        </h2>
      }
      <h3>You have no friends for you!!!</h3>
    </>
  );
}

const friends = ['ABCD', 'MDA', 'SP',];
const friendss = []; // Empty array
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<FriendsForMe friends={friends} />);


//Ternary operator - Odd Even
import React from 'react';
import ReactDOM from 'react-dom/client';

function EvenNumber() {
    return <h1>EvenNumber!</h1>;
}

function OddNumber() {
    return <h1>OddNumber!</h1>;
}

function CheckNumber(props) {
  const isNum = props.num;
  return (
    <>
      { isNum % 2 === 0 ? <EvenNumber /> : <OddNumber /> }
    </>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<CheckNumber num={9} />);


// 1. divisible by 13
import React from 'react';
import ReactDOM from 'react-dom/client';

function CheckDivisibleby13(props) {
    const number = props.num;

    /*if(number%13 === 0){
        return <h1>{number} is divisible by 13</h1>;
    }
    else{
        return <h1>{number} is not divisible by 13</h1>
    }
    
}*/

/*return( 
    <>
        {number % 13 ===0 &&  <h1>{number } is divisible by 13</h1>}
        {number % 13 !=0 &&<h1>{number} is not divisible by 13</h1>}

    </>
); */

return(
    <>
        {number % 13 ===0 ? (<h1>{number} is divisible by 13</h1>):
            (<h1>{number} is not divisible by 13</h1>)}
        </>
);
}
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<CheckDivisibleby13 num={262} />);


// 2. Check for Vowels
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

// 3. Check for multiples of 3
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

// 4. Check for even length and odd lenght
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

  /* If conditional
  if (str.length % 2 === 0) {
    return <EvenLength />;
  } */

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

// 5. FLower or not?
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