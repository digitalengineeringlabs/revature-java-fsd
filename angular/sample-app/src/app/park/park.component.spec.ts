import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { ParkComponent } from './park.component';

describe('ParkComponent', () => {
  
  let component: ParkComponent;
  let fixture: ComponentFixture<ParkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render title', ()=>{   
    component.title = 'Yosemite Park'
    fixture.detectChanges();

    const dom = fixture.nativeElement
    expect(dom.querySelector('#park-title').textContent).toEqual('Yosemite Park')
  })

  it('should emit book event', ()=>{
    let result:string = ''

    component.title = 'Yosemite Park'
    component.book.subscribe({
      next: (data:any)=>{
        result = data
      }
    })

    const html = fixture.debugElement
    const btn = html.query(By.css('#btn-book'))
    btn.triggerEventHandler('click', null)

    expect(result).toEqual('Yosemite Park')
  })


});
