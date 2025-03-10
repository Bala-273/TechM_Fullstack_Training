import React from "react";
import ProfilePicture from "./ProfilePicture";
import ProfileInfo from "./ProfileInfo";
import Hobbies from "./HobbiesInfo";
import SocialLinks from "./SocialLinks";
import ContactDetails from "./ContactDetails";

function ProfileCard() {
  return (
    <center>
    <div style={styles.card}>
      <ProfilePicture />
      <ProfileInfo name="John Doe" bio="Frontend Developer & Tech Enthusiast" />
      <Hobbies hobbies={["Reading", "Coding", "Traveling"]} />
      <SocialLinks twitter="johndoe" linkedin="johndoe" />
      <ContactDetails email="john@example.com" phone="+1234567890" />
    </div>
    </center>
  );
}

// Simple styling
const styles = {
  card: {
    width: "300px",
    padding: "20px",
    borderRadius: "10px",
    boxShadow: "0 4px 8px rgba(0,0,0,0.2)",
    textAlign: "center",
    backgroundColor: "#f9f9f9"
  }

};

export default ProfileCard;
