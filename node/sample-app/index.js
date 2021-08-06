const {Observable} = require('rxjs')

const observable = new Observable((observer)=>{
    let i = 0
    setInterval(() => {
        if(i > 5){
            observer.complete();
        }
        observer.next(i++);
        observer.error('wrong');
    }, 1000);
})

observable.subscribe((data)=>{
    console.log('next : '+data)
},(error)=>{
    console.log('error : '+error)
},()=>{
    console.log('complete')
});


