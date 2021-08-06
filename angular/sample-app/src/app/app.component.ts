import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  // template: `
  //   <h2>This is rendered from class</h2>
  //   {{title}}
  // `,
  styleUrls: ['./app.component.css']
  // styles: [`
  //   h2 {
  //     color : red
  //   }
  // `]
})
export class AppComponent {
  
  title = 'Vimal';
  inactive = false;
  country = 'UK'
  addProduct:boolean = false;

  picture = 'somenice.jpeg'
  supplier = {
    name: 'Amaxon'
  }

  vehicles = ['Car','Bus','Train']

  getTitle(){
    return this.title;
  }

  sayHello(){
    console.log('Hello')
    this.title = 'Changed'
  }

  onRemoveProduct(e:Event){
    console.log(e)
  }

}
