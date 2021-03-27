import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HRComponentComponent } from './hrcomponent.component';

describe('HRComponentComponent', () => {
  let component: HRComponentComponent;
  let fixture: ComponentFixture<HRComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HRComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HRComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
