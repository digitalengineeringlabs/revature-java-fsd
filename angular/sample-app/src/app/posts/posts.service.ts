import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Subject } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class PostsService {

    data:Subject<any> = new Subject()

    constructor(private http:HttpClient){}

    getPosts(){
        this.http.get('https://jsonplaceholder.typicode.com/posts').subscribe({
            next: (data)=>{
                this.data.next(data)
            }
        })
    }

}