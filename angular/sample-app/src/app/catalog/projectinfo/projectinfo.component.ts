import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-projectinfo',
  templateUrl: './projectinfo.component.html',
  styleUrls: ['./projectinfo.component.css']
})
export class ProjectinfoComponent implements OnInit {

  id:string = '';

  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe({
      next: (data)=>{
        this.id = data.id
      }
    })
  }

}
