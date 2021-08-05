import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  items = [
    {
      title:'Television',
      price: '400',
      supplier: {
        name: 'Amazon'
      }
    },
    {
      title:'Mobile',
      price: '40',
      supplier: {
        name: 'Amazon'
      }
    },
    {
      title:'Chair',
      price: '4',
      supplier: {
        name: 'Amazon'
      }
    }
  ]

  constructor() { }

  ngOnInit(): void {
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
