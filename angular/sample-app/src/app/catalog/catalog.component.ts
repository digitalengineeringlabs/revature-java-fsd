import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {

  paramsSubscription:Subscription;

  products = [{id:1,title:'Watch'},{id:2,title:'Monitor'},{id:3,title:'Camera'}]

  constructor(private route:ActivatedRoute) { 
    this.paramsSubscription = this.route.params.subscribe({
      next: (data)=>{console.log(data)}
    })

    this.route.queryParams.subscribe({
      next: (data)=>{console.log(data)}
    })
  }

  ngOnInit(): void {
    
  }

  ngOnDestroy(){
    this.paramsSubscription.unsubscribe()
  }

}
