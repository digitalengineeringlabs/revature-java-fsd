import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html'
})
export class LoginComponent {

    constructor(private http:HttpClient,private router:Router){}

    onSubmit(form:NgForm){
        console.log(form);
        this.http.post('http://localhost:9080/api-servlet-app/login',
            JSON.stringify({username:form.value.username,password:form.value.password}))
            .subscribe({
                next: (data:any)=>{
                    if(data.status === 'success') {
                        localStorage.setItem("username", form.value.username);
                    }
                    this.router.navigate([''])
                }
            })
            // .subscribe((data)=>{},(error)=>{},()=>{})
            // .subscribe({
            //     next:(data)=>{},
            //     error:(error)=>{},
            //     complete:()=>{}
            // })
    }

}