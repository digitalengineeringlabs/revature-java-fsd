// var fn = function (){
//     console.log('Called')
// }

// setTimeout(fn,1000)

// console.log('Started')

// setInterval(fn, 1000);

//Asynchronous methods

//Synchronous

var add = function (a,b, cb){
    //return a+b
    setTimeout(function(){
        cb(a+b)
    },1000)
    
}

add(5,7,function(r){
    console.log(r)
})

//Promise
var promise = new Promise(function(resolve,reject){
    if(false){
        resolve('Successfull response')
    }
    else {
        reject('Error occured')
    }
})

promise.then(
    function(data)
    {
        console.log(data)
    }
).catch(function(err){console.error(err)})


var subtract = function (a,b) {
  return new Promise(function(resolve,reject){
    if(a > 0){
        resolve(a - b)
    }
    else {
        reject('first argument must be greater than 0')
    }
    });
}

//var result = subtract(6,2)
subtract(0,2).then(function(data){
    console.log('REsult: '+data)
}).catch(function(err){
    console.log('Error: '+err)
});


fetch('https://jsonplaceholder.typicode.com/posts/1', 
    {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    }
  }).then(function(data){
      console.log(data)
  })