

import React from 'react';
import ReactDOM from 'react-dom/client';

/*function Car(props) {
  return <li>I am a { props.brand }</li>;
}

function Garage() {
  const cars = ['Ford', 'BMW', 'Audi'];

    //map function iterates over cars array, car is element [(for i in arr) like car in cars]

  return (
    <>
	    <h1>Who lives in my garage?</h1>
	    <ul>
        {cars.map((c) => <Car brand={c} />)}
      </ul>
    </>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Garage />); */

function Car(props) {
  return <li> Car Id:{props.id} I am a { props.brand }</li>;
}
export default function Garage() {
  const cars = [
    {id: 1, brand: 'Ford'},
    {id: 2, brand: 'BMW'},
    {id: 3, brand: 'Audi'}
  ];

  return (
    <>
	    <h1>Who lives in my garage?</h1>
	    <ul>
        {cars.map((car) => <Car key={car.id} id={car.id} brand={car.brand} />)}
      </ul>
    </>
  );
}

