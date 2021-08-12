import { Component } from "@angular/core";
import { Router } from "@angular/router";


@Component({
    selector: 'app-home',
    template: `
        <div>
            Home Component
            <button (click)="logout()">Logout</button>
            <ul>
            <li><a routerLink="">Home</a></li>
            <li><a routerLink="menus">Menus</a></li>
            </ul>
            <router-outlet></router-outlet>
        </div>
    `
})
export class HomeComponent{

    constructor(private router:Router){}

    logout(){
        localStorage.clear()
        this.router.navigate(['login'])
    }

}