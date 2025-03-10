// 1. Get user input and calculate cube
let num = prompt("Enter a number to calculate cube: ");
num = Number(num);

if (!isNaN(num)) {
    let cube = num ** 3;
    alert(`The cube of ${num} is ${cube}`);
    console.log(`The cube of ${num} is ${cube}`);
} else {
    alert("Enter a valid number");
    console.log("Enter a valid number");
}


// 2. Check number is positive or negative
var number = prompt("Enter a number to check for positive or negative:");
number = Number(number);

if (!isNaN(number)) {
    if (number >= 0) {
        alert(`${number} is positive`);
        console.log(`${number} is positive`);
    } else {
        alert(`${number} is negative`);
        console.log(`${number} is negative`);
    }
} else {
    alert("Please enter a valid number.");
    console.log("Invalid number input.");
}


// 3. Check prime number
const primeNumber = Number(prompt("Enter a number to check for prime:"));
let isPrime = true;

if (isNaN(primeNumber) || !Number.isInteger(primeNumber)) {
    alert("Please enter a valid integer.");
} else {
    if (primeNumber < 2) {
        isPrime = false;
    } else {
        for (let i = 2; i <= Math.sqrt(primeNumber); i++) {
            if (primeNumber % i === 0) {
                isPrime = false;
                break;
            }
        }
    }
    alert(`${primeNumber} is ${isPrime ? "a prime number" : "not a prime number"}`);
    console.log(`${primeNumber} is ${isPrime ? "a prime number" : "not a prime number"}`);
}


// 4. Display user address
let address = prompt("Enter your address:");
alert(`Your address is: ${address}`);
console.log(`Your address is: ${address}`);


// 5. Confirmation box for movie plan
let willGoToFilm = confirm("Will you go to the film today?");
console.log(willGoToFilm ? "User will go to the film today." : "User will not go to the film today.");


// 6. Get user age
let age = prompt("Enter your age:");
age = Number(age);

if (!isNaN(age) && age > 0) {
    console.log(`Your age is ${age}`);
} else {
    console.log("Invalid age entered.");
}


// 7. Check if number is divisible by 12
let checkNum = prompt("Enter a number to check divisible by 12:");
checkNum = Number(checkNum);

if (!isNaN(checkNum)) {
    if (checkNum % 12 === 0) {
        alert(`${checkNum} is divisible by 12`);
        console.log(`${checkNum} is divisible by 12`);
    } else {
        alert(`${checkNum} is not divisible by 12`);
        console.log(`${checkNum} is not divisible by 12`);
    }
} else {
    alert("Enter a valid number.");
    console.log("Invalid number input.");
}


// 8. Tomato price calculation
let tomatoPrices = [40, 55, 60, 45, 50, 48, 52]; 
let total = tomatoPrices.reduce((sum, price) => sum + price, 0);
let averagePrice = total / tomatoPrices.length;

console.log(averagePrice > 50 ? "Tomato has given good profit." : "No profit from tomato.");


// 9. Leap year check
let year = parseInt(prompt("Enter a year to check for leap year:"));
let month = parseInt(prompt("Enter a month (1-12):"));

if (!isNaN(year) && !isNaN(month) && month >= 1 && month <= 12) {
    let isLeapYear = (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);

    if (isLeapYear) {
        if (month === 2) {
            console.log("The year is a leap year and the month is February with 29 days.");
        } else {
            console.log("The year is a leap year and the month is not February.");
        }
    } else {
        console.log("The given year is not a leap year.");
    }
} else {
    console.log("Invalid input. Please enter a valid year and month.");
}


// 10. Get the Maths score from the user
let mathScore = prompt("Enter your Maths score:");
mathScore = Number(mathScore);

if (isNaN(mathScore) || mathScore < 0 || mathScore > 100) {
    alert("Please enter a valid score between 0 and 100.");
    console.log("Invalid input. Score must be between 0 and 100.");
} else {
    if (mathScore === 100) {
        alert("Phenomenal!");
        console.log("Phenomenal!");
    } else if (mathScore > 85) {
        alert("Excellent!");
        console.log("Excellent!");
    } else if (mathScore >= 71) {
        alert("Good work!");
        console.log("Good work!");
    } else if (mathScore >= 51) {
        alert("Practice well!");
        console.log("Practice well!");
    } else {
        alert("Hard work is needed.");
        console.log("Hard work is needed.");
    }
}


// 11. Day of the week
let day = prompt("Enter the day of the week: ").trim().toLowerCase();

switch(day){
    case "monday":
        alert("Start of the week");
        console.log("Start of the week");
        break;

    case "tuesday":
    case "wednesday":
    case "thursday":
        alert("Mid of the week");
        console.log("Mid of the week");
        break;

    case "friday":
        alert("Last working day of the week");
        console.log("Last working day of the week");
        break;

    case "saturday":
        alert("Weekend Saturday");
        console.log("Weekend Saturday");
        break;

    case "sunday":
        alert("Weekend Sunday");
        console.log("Weekend Sunday");
        break;
    
    default:
        alert("Invalid input");
        console.log("Invalid input");
}


// 12. Multiplication Tables
function Tables(num,limit){
    for(i=1; i<=limit; i++){
        console.log(`${num} x ${i} = ` + num*i);
    }
}

num = prompt("Enter a number to generate its multiples: ");
limit = prompt("Enter a number to set the limit of the multiplication: ");
Tables(num,limit);


// 13. Multiples of number between a range
let multiple = prompt("Enter the number to generate multiples between a range: ");
let limit1 = prompt("Enter the number for limit1: ");
let limit2 = limit1 + 40;

if(isNaN(multiple) || isNaN(limit1)){
    alert("Enter a valid number");
    console.log("Enter a valid number");
}
else{
    console.log(`The multiples of ${multiple} from ${limit1} to ${limit2}:`);
}

i = limit1;
while(i<=limit2){
    if(i%multiple == 0){
        console.log(i);
    }i++;
}

// 14. Interval of 30 divisible by 7
function divisibleby7(num,limit){
    for(i=num; i<=limit; i++){
        if(i%7==0){
            break;
        }else{
        console.log(i);
    }
}}

num = Number(prompt("Enter a number to generate factors divisible by 7: "));
limit = num+30;
divisibleby7(num,limit);


// 15. Skip displaying multiples of 5
function divisibleby5(num,limit){
    for(i=num; i<=limit; i++){
        if(i%5==0){
            continue;
        }else{
        console.log(i);
    }
}}

num = Number(prompt("Enter a number to generate factors divisible by 5: "));
limit = num+50;
divisibleby5(num,limit);