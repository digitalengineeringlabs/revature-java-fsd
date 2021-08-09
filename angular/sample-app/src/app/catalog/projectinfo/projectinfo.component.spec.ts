import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectinfoComponent } from './projectinfo.component';

describe('ProjectinfoComponent', () => {
  let component: ProjectinfoComponent;
  let fixture: ComponentFixture<ProjectinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectinfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
