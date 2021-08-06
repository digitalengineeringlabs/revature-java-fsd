import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";

@Component({
    selector: "app-product",
    template: `
        <ng-content select="h1"></ng-content>
        <div>
            <h3>{{title | uppercase | lowercase }}</h3>
            <p>{{price | currency : 'EUR'}}</p>
            <p>{{supplier.name | shorten : 3}}</p>
            <button (click)="removeHandler()">Remove</button>
        </div>
        <ng-content select="div"></ng-content>
    `
})
export class ProductComponent {

    @Input('name') title:string = '';
    @Input() price:string = '';
    @Input() supplier:any;

    @Output() remove:EventEmitter<any> = new EventEmitter<any>();

    //Instantiation phase
    constructor(){
        console.log('Instantiation phase')
    }

    ngOnInit(){
        console.log('Initialization phase')
        //updating state here only
    }

    ngOnChanges(){
        console.log('ngOnChanges phase')
         //no updating state here only
      }
      ngDoCheck(){
        console.log('ngDoCheck phase')
     // no updating state here only
      }
    
      ngAfterViewInit(){
        console.log('ngAfterViewInit phase')
         // no updating state here only
    
      }
    ngAfterViewChecked(){
      console.log('ngAfterViewChecked phase')
       // no updating state here only
    
    }
    ngOnDestroy(){
        console.log('Destroy phase')
    }

    removeHandler(){
        this.remove.emit(this.title)
    }
}