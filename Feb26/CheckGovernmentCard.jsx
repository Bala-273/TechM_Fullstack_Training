import React, { useState } from "react";
import ReactDOM from "react-dom/client";

function CheckGovernmentCard() {
  const [hasAadhar, setHasAadhar] = useState(null);
  const [hasPan, setHasPan] = useState(null);

  const askUser = () => {
    const aadharResponse = prompt("Do you have an Aadhar card? (yes/no)").toLowerCase();
    const panResponse = prompt("Do you have a PAN card? (yes/no)").toLowerCase();

    setHasAadhar(aadharResponse === "yes");
    setHasPan(panResponse === "yes");
  };

  return (
    <div>
      <h1>User Card Details:</h1>
      {hasAadhar === null || hasPan === null ? (
        <button onClick={askUser}>Check Government Cards</button>
      ) : (
        <p>
          {hasAadhar || hasPan ? (
            <>
              {hasAadhar && "Aadhar Card is available. "}
              {hasPan && "PAN Card is available. "}
            </>
          ) : (
            "User has no government cards."
          )}
        </p>
      )}
    </div>
  );
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<CheckGovernmentCard />);
