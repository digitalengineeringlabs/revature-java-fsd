import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  isLoggedIn:boolean = false
  logInAlert:Subject<boolean> = new Subject()

  constructor() { }

  authenticate(username:string,password:string){
    if(username === 'mike'){
      setTimeout(() => {
        this.isLoggedIn = true
        this.logInAlert.next(true)
      }, 1000); 
      
    }
  }

}
