import React,{Suspense, lazy} from 'react';

import AB4_React from './AB4_React';
const ABComponent2 = React.lazy(() => import('./ABComponent2'));
const ABComponent3 = React.lazy(() => import('./ABComponent3'));

function AB1_React() {
  return (
    <div>   
       <h1>Welcome to ReactApp with Vite and AB1_React!!!</h1>       
       <Suspense fallback={<h1>Loading...</h1>}>
       <ABComponent2 />
       <ABComponent3 />    
      <AB4_React />
      </Suspense>
    </div>
  );
}

export default AB1_React;