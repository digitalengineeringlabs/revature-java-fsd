import { Injectable } from "@angular/core";
import { Subject } from "rxjs";


@Injectable({
    providedIn: 'root'
})
export class AlertService {

    alert:Subject<any> = new Subject()

    post(message:string){
        this.alert.next(message)
    }


}