// first order functions
var sum = function (a) {
    return function (b) {
        if (b)
            return sum(a + b);
        return a;
    }
}

var mul = a => {
    return (b) => {
        return (b ? sum(a + b) : a); 
    }
    
}

var x = sum(1)(2)(3)(4)();
console.log(x);