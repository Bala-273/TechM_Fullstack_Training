import React, { Suspense, lazy } from "react";

import C5 from "../../../HTML_CSS_JS_HandsOn/f2/C5";


const C3 = lazy(() => import("./C3"));
const C4 = lazy(() => import("../../../HTML_CSS_JS_HandsOn/f2/C4"));

export default function C2(){
    return(
        <div>
            <h2>Component C2</h2>

            <C5 />

            <Suspense fallback = {<h3>Loading components...</h3>}>
            <C3 />
            <C4 />
            </Suspense>

            

        </div>
    );
}