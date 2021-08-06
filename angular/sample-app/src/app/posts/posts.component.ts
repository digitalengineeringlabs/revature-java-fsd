import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { PostsService } from "./posts.service";

@Component({
    selector:'app-posts',
    template: `
    <h3>Posts</h3>
    <p *ngFor="let post of posts">{{post.title}}</p>
    `
})
export class PostsComponent{

    posts:any = []

    constructor(private service:PostsService){}

    ngOnInit(){
        this.service.getPosts()
        this.service.data.subscribe({
            next: (data) => {
                this.posts = data
            }
        })
    }
}