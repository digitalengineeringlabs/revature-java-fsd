import { Component, Output, EventEmitter } from "@angular/core";

@Component({
    selector: 'app-add-product',
    template: `
    <h3>Add Product</h3>
    <p>
        <input type="text" name="title" [value]="title" (input)="onTitleInput($event)" placeholder="Title">
        <input type="text" name="price" [value]="price" (input)="onPriceInput($event)" placeholder="Price">
        <button (click)="addProduct()">Add</button>
        </p>
    `
})
export class AddProductComponent {

    title:string = ''
    price:string = ''

    @Output() add:EventEmitter<any> = new EventEmitter<any>();

    onTitleInput(e:any){
        this.title = e.target.value;
    }

    onPriceInput(e:any){
        this.price = e.target.value;
    }

    addProduct(){
        this.add.emit({title:this.title, price:this.price});
    }

}