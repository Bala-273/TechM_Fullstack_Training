function myFunction(){
    console.log("Inside Function!")
}
myFunction()


function sum(x, y) { 
    return x + y; 
}
console.log(sum(6, 9));


var sum = function (x, y) {
    return x + y;
};
console.log(sum(4, 5));


let sum1 = (a, b) => a + b;
console.log(sum1(1, 2)); 


let firstName = prompt("Enter your firstname: ");
let lastName = prompt("Enter your lastname: ");
let age = prompt("Enter your age: ");
let city = prompt("Enter your city: ");

let person = {
  firstName : firstName,
  lastName : lastName,
  age : age,
  city : city 
}

person.name1 = function() {
  return this.firstName + " " + this.lastName;
};

person.name2 = function () {
  return (this.firstName + " " + this.lastName).toUpperCase();
};
console.log(person.name1());
console.log(person.name2());
console.log("name1 function definition: "+person.name1);
console.log("name2 function definition: "+person.name2);

document.getElementById("demo").innerHTML = person;

document.getElementById("demo").innerHTML =
person.name1 + "," + person.age + "," + person.city; 



function counter() {
  // Private variable
      let count = 0; 
    
     return function () {
       // Access and modify the private variable
          count++;
          return count;
      };
  }
  
  const increment = counter();
  console.log(increment());
  console.log(increment());
  console.log(increment());
  

// 1. Multiplication Table
let number = prompt("Enter the number: ");
let limit = prompt("Enter the limit: ");

console.log(`Multiplication Table of ${number} upto limit ${limit}`);

for(let i = 1; i<=limit; i++){
  console.log(`${number} x ${i} = ${number*i}`);
}


// 2. Display Factors
function factor(n){
  console.log(`The factors of ${n} are: `);
  for(i=1; i<=n; i++){
    if(n%i == 0){
      console.log(i);
    }
  }
}

let num = Number(prompt("Enter a number to find its factors: "));
factor(num);


// 3. Check Odd or Even
function checkSum(num) {
  let sum = 0;
  let temp = num;

  while (temp > 0) {
      sum += temp % 10;
      temp = Math.floor(temp / 10);
  }

  console.log(`The sum of digits of ${num} is ${sum}, which is ${sum % 2 === 0 ? "Even" : "Odd"}.`);
}

let num1 = Number(prompt("Enter a number to check whether the sum is odd or even:"));
if (!isNaN(num1) && num1 >= 0) {
  checkSum(num1);
} else {
  console.log("Please enter a valid non-negative number.");
}


