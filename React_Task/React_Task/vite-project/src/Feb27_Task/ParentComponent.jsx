import React from "react";
import Child1 from "./Child1";
import Child2 from "./Child2";
import Child3 from "./Child3";
import Child4 from "./Child4";
import Child5 from "./Child5";

function ParentComponent(){
    return(
        <center>
        <div>
            <h1>Parent Component</h1>
            <Child1 />
            <Child2 />
            <Child3 />
            <Child4 />
            <Child5 />
        </div>
        </center>
    );
}

export default ParentComponent;