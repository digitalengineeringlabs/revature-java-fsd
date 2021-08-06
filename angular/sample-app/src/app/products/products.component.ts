import { Component, OnInit } from '@angular/core';
import { IProduct } from './product';
import { ProductsService } from './products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {

  items:IProduct[] = []

  constructor(private service:ProductsService){
    console.log('Instantiation phase')
  }

  ngOnInit(){
    this.items = this.service.getItems();
      console.log('Initialization phase')
  }

  ngOnChanges(){
    console.log('ngOnChanges phase')
  }
  ngDoCheck(){
    console.log('ngDoCheck phase')

  }

  ngAfterViewInit(){
    console.log('ngAfterViewInit phase')

  }
ngAfterViewChecked(){
  console.log('ngAfterViewChecked phase')

}

  ngOnDestroy(){
      console.log('Destroy phase')
  }

  onRemoveItem(e:any){
    console.log(e)
    let filtered = this.items.filter((i) => {return i.title !== e});
    this.items = filtered
  }

  onAddProduct(data:any) {
    console.log(data)
    this.items.push({supplier:{name:'Unknown'},...data})
  }



}
