import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BreweriesFilterComponent } from './breweries-filter.component';

describe('BreweriesFilterComponent', () => {
  let component: BreweriesFilterComponent;
  let fixture: ComponentFixture<BreweriesFilterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BreweriesFilterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BreweriesFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
