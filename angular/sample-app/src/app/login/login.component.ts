import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  signupForm:any;

  constructor() { 
  }

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      username: new FormControl('peter',Validators.required),
      password: new FormControl(null)
    });
  }

  onSubmit(){
    console.log(this.signupForm)
  }


}
