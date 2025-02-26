import React, { useState } from "react";
import ReactDOM from 'react-dom/client';

function StudentList() {
    const students = [
        {id:1, name: "Stark", department: "Robotics Engineering"},
        {id:2, name: "Bala", department: "Artificial Intelligence"},
        {id:3, name: "Sathish", department: "Data Science"}

    ];

    return(
        <div>
            <h1>Student List</h1>
            <ul>
                {students.map((student) => (
            <li key = {student.id}>
                {student.name} - {student.department}
            </li>
            ))}
            </ul>
    </div>
    );
}
 
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<StudentList/>);
