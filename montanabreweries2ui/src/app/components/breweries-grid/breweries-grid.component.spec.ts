import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BreweriesGridComponent } from './breweries-grid.component';

describe('BreweriesGridComponent', () => {
  let component: BreweriesGridComponent;
  let fixture: ComponentFixture<BreweriesGridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BreweriesGridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BreweriesGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
