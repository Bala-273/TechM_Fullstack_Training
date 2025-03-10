import React from "react";

export function EvenNumber() {
  return <h1>Even Number!</h1>;
}

export function OddNumber() {
  return <h1>Odd Number!</h1>;
}

export default function NumberComponent(props) {
  const isNum = Number(props.num);

  return (
    <div>
      {isNum % 2 === 0 ? <EvenNumber /> : <OddNumber />}
    </div>
  );
}
