import React from "react";

function ContactDetails({ email, phone }) {
  return (
    <div>
      <h3>Contact Me</h3>
      <p>Email: {email}</p>
      <p>Phone: {phone}</p>
    </div>
  );
}

export default ContactDetails;
