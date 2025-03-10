import React from "react";

export function EvenNumber() {
  return <h1>Even Number!</h1>;
}

export function OddNumber() {
  return <h1>Odd Number!</h1>;
}

export default function CheckNumber(props) {
  const isNum = props.num;
  return <>{isNum % 2 === 0 ? <EvenNumber /> : <OddNumber />}</>;
}
