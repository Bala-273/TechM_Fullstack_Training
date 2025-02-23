// Creating an object with properties and a method
let student = {
    name: "Stark",
    age: 21,
    course: "Computer Science",
    getDetails: function() {
        return `${this.name} is ${this.age} years old and studying ${this.course}.`;
    }
};

console.log("Accessing properties and functions:")
console.log(student.getDetails());

student.address = {
    city: "Chennai",
    pincode: "600093"
};
student.updateCourse = function(newCourse) {
    this.course = newCourse;
};
student.showAddress = function() {
    return `${this.name} lives in ${this.address.city}, pincode: ${this.address.pincode}.`;
};

console.log("\nAccessing new properties and functions:")
console.log(student.showAddress());
student.updateCourse("Data Science");
console.log(student.getDetails());

delete student.age;
delete student.updateCourse;

console.log("\nDisplaying after removing certain properties:")
console.log(student);
