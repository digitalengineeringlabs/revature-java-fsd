import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})
export class MenusComponent implements OnInit {

  title:string = ''

  menus:any = []

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.fetchMenus()
  }

  fetchMenus(){
    this.http.get('http://localhost:8080/api-servlet-app/menus').subscribe({
      next: (data) => {
        this.menus = data
      }
    })
  }

  onTitleChange(e:any){
    this.title = e.target.value
  }

  submitMenu(){
    console.log('adding menu..');
    
    this.http.post('http://localhost:8080/api-servlet-app/menus',JSON.stringify({title:this.title})).subscribe({
      next: (data)=>{
        this.fetchMenus()
      }
    })
  }

}
