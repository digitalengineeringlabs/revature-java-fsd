import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class ProductsService {

    items = [
        {
          title:'Furtuniture',
          price: '400',
          supplier: {
            name: 'Amazon'
          }
        },
        {
          title:'Mobile',
          price: '40',
          supplier: {
            name: 'Amazon Amazon Amazon '
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

      getItems(){
          return this.items;
      }

}