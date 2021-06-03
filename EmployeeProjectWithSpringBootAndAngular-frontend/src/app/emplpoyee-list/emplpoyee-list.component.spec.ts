import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmplpoyeeListComponent } from './emplpoyee-list.component';

describe('EmplpoyeeListComponent', () => {
  let component: EmplpoyeeListComponent;
  let fixture: ComponentFixture<EmplpoyeeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmplpoyeeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmplpoyeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
