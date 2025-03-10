import React from "react";

export default function ABComponentForError() {
    const undefinedVariable = undefined;
    console.log(undefinedVariable.abc())
  return (
    <h3>ABComponentForError</h3>
  )
}