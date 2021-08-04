var division = function(a,b) {
    return new Promise(function(resolve,reject){
        if(b==0){
            reject('not allowed')
        }
        resolve(a/b);
    })
}

async function calculate(){
    // division(4,0).then((data)=>{console.log(data)}).catch((err)=>{console.log(err)});
    try {
        var result = await division(4,2)
        console.log(result)
    } catch(e){
        console.log(e)
    }
}

calculate();

// get('http://some').then(data=>{
//     get('http://some2'+data).then(data2 => {
//         get('http://some3'+data).then(data3=>{

//         }).catch(err3=>{})
//     }).catch(err2=>{})
// }).catch(err=>{})

// async function someCall(){
//     try {
//         var data = await get('http://some')
//         var data2 = await get('http://some2'+data)
//         var data3 = await get('http://some3'+data2)
//     } catch(e){
//         console.log(e)
//     }
// }

// destructuring

// let data = ['2012','12','25']
// let month = data[1]

let [year,month,date] = ['2012','12','25']
console.log(year)

let {name1,address1} = {
    name1: 'Mike',
    address1: 'Grand Ave'
}

console.log(name1)
console.log(address1)

// Spread and REST Operator ...

function add(name, ...args){
    console.log(args[0])
    console.log(args[1])
    console.log(name)
}

add('Mike',1,2,3,4,5)

//REST

var veges = ['Carrot','Beans']

var items = ['Chair', ...veges]

console.log(items)

var address = {city:'Chicago',state:'IL'}

var user = {name:'Kevin', ...address}

console.log(user)