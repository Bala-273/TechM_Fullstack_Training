import React from "react";

function SocialLinks({ twitter, linkedin }) {
  return (
    <div>
      <h3>Connect with me:</h3>
      <p>
        <a href={`https://twitter.com/${twitter}`} target="_blank">Twitter</a> |  
        <a href={`https://linkedin.com/in/${linkedin}`} target="_blank">LinkedIn</a>
      </p>
    </div>
  );
}

export default SocialLinks;
