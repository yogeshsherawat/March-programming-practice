
// Hoisting
console.log("Hoisting:");
x = 23; // Gives reference error

var x;


anotherRandomFunc();

function anotherRandomFunc() {
    console.log(message); // here message gave undefind cuz in its executation context message was not having value
    //until this command was executed
    message = "Hello"; // Throws a reference error
    console.log(message);
    var message;
}

//  Scope and Lexical Environment
console.log("--");
var v = 10;
f1();
f2();
console.log(v);
function f1() {
    console.log(v);
}
function f2(){
    var v = 100;
    console.log(v);
}

// var can be declared a many times as we want
// but this is not same with let
var a = 5;
var a = 6;
//console.log(b) // this will throw reference error that is b is not initialized first
let b = 6;
//let b = 7; // this will throw syntax error
const c;
//c = 1000; // this will throw syntax error , cuz const declaration and intializations are done at same time
const d = 1000;
d = 50; // this will throw type error, meaning we cannot reinitialize const variable
console.log(b);