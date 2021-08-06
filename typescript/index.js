//data types
var message = 'Hi there';
var year = 2021;
console.log(message);
console.log(year);
function add(a, b) {
    console.log(a);
    console.log(b);
    return a + b;
}
var result = add(3, '6');
console.log(result);
//let fruits:string[] = ['Apple','Banana']
var fruits = ['Apple', 'Banana'];
var User = /** @class */ (function () {
    function User(fname) {
        this.fullname = fname;
    }
    User.prototype.getName = function () {
        return this.fullname;
    };
    return User;
}());
var user1 = new User('Kevin');
console.log(user1.fullname);
console.log(user1.getName());
