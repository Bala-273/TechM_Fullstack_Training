const calculate = () => {
    let operation = prompt("Choose an operation: add, subtract, multiply, divide").toLowerCase();
    let num1 = Number(prompt("Enter the first number:"));
    let num2 = Number(prompt("Enter the second number:"));

    const add = (a, b) => a + b;
    const subtract = (a, b) => a - b;
    const multiply = (a, b) => a * b;
    const divide = (a, b) => {
        if (b === 0) return "Cannot divide by zero!";
        return `Quotient: ${Math.floor(a / b)}, Remainder: ${a % b}`;
    };

    switch (operation) {
        case "add":
            console.log(`Sum: ${add(num1, num2)}`);
            break;
        case "subtract":
            console.log(`Difference: ${subtract(num1, num2)}`);
            break;
        case "multiply":
            console.log(`Product: ${multiply(num1, num2)}`);
            break;
        case "divide":
            console.log(`Division: ${divide(num1, num2)}`);
            break;
        default:
            console.log("Invalid operation! Please choose add, subtract, multiply, or divide.");
    }
};

calculate();