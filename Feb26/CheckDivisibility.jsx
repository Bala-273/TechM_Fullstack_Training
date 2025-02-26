import React, { useState } from "react";
import ReactDOM from 'react-dom/client';

function CheckDivisibility(props) {
    const num = props.num;

    if(num%16 === 0){
        return <h1>{num} is divisible by 16</h1>
    }
    else{
        return <h1>{num} is not divisible by 16</h1>
    }
    
}
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<CheckDivisibility num= {256} />);
