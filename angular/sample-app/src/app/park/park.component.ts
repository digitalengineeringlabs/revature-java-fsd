import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-park',
  templateUrl: './park.component.html',
  styleUrls: ['./park.component.css']
})
export class ParkComponent implements OnInit {

  @Input() title:string = ''
  @Output() book = new EventEmitter<string>()

  constructor() { }

  ngOnInit(): void {
  }

  bookSite(){
    console.log('Emitting event...')
    this.book.emit(this.title)
  }

}
