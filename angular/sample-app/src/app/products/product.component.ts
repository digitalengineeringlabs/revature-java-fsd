import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
    selector: "app-product",
    template: `
        <div>
            <h3>{{title}}</h3>
            <p>{{price}}</p>
            <p>{{supplier.name}}</p>
            <button (click)="removeHandler()">Remove</button>
        </div>
    `
})
export class ProductComponent {

    @Input('name') title:string = '';
    @Input() price:string = '';
    @Input() supplier:any;

    @Output() remove:EventEmitter<any> = new EventEmitter<any>();

    removeHandler(){
        this.remove.emit(this.title)
    }


}