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
            <table border="1">
            <thead>
                <tr>
                    <th>Name</th> 
                    <th>Department</th>
                </tr>
            </thead>
                
            <tbody>
                    {students.map((student) => (
            <tr key = {student.id}>
                <td>{student.name}</td>  
                <td>{student.department}</td>
            </tr>
                ))}
            </tbody>
        </table>
     </div>
    );
}
 
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<StudentList/>);
