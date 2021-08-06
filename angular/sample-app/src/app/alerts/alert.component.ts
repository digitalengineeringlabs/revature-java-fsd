import { Component } from "@angular/core";
import { AlertService } from "./alert.service";

@Component({
    selector: 'app-alert',
    template: `
        Alert: {{message}}
    `
})
export class AlertComponent {

    message:string=''

    constructor(private service:AlertService){}

    ngOnInit(){
        this.service.alert.subscribe({
            next: (data)=>{this.message = data}
        })
    }
}