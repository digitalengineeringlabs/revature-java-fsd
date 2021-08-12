import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageServiceService {

  constructor() { }

  formatMessage(msg:string){
    return 'Warning: '+msg
  }

}
