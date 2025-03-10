import React from "react";

function Hobbies({ hobbies }) {
  return (
    <div>
      <h3>Hobbies</h3>
      <ul>
        {hobbies.map((hobby, index) => (
          <li key={index}>{hobby}</li>
        ))}
      </ul>
    </div>
  );
}

export default Hobbies;
