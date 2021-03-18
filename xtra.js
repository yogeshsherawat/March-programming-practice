x = 23; // Gives reference error

var x;


function anotherRandomFunc() {
    message = "Hello"; // Throws a reference error
    console.log(message);
    var message;
}
anotherRandomFunc();