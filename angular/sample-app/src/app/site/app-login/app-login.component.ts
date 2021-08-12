import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-app-login',
  templateUrl: './app-login.component.html',
  styleUrls: ['./app-login.component.css']
})
export class AppLoginComponent implements OnInit {

  username:string = '';

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
    this.userService.logInAlert.subscribe({
      next: (loggedIn)=>{
        if(loggedIn){
          this.router.navigate(['/'])
        }
      }
    })
  }

  onNameChange(e:any){
    this.username = e.target.value
  }

  onSubmit(){
    this.userService.authenticate(this.username,'')
    
  }

}
