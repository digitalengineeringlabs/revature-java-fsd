//data types

let message:string = 'Hi there'
let year:number = 2021

console.log(message)
console.log(year)

function add(a:number,b:any) : number{
    console.log(a)    
    console.log(b)    
    return a + b
}

let result = add(3,'6')
console.log(result)

//let fruits:string[] = ['Apple','Banana']
let fruits:Array<string> = ['Apple','Banana']


class User {
    fullname:string

    constructor(fname:string){
        this.fullname = fname
    }

    getName() :string {
        return this.fullname;
    }
}

let user1 = new User('Kevin');

console.log(user1.fullname)
console.log(user1.getName())

interface Address {
    street : string
    zip? : number
}

let addr:Address = {street:'Grand Ave'}

interface Runnable {
    run():void
}

class Thread implements Runnable {

    run():void {
        //TODO:
    }

}