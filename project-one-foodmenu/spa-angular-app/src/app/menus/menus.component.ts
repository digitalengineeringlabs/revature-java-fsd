import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})
export class MenusComponent implements OnInit {

  menus:any = []

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/api-servlet-app/menus').subscribe({
      next: (data) => {
        this.menus = data
      }
    })
  }

}
