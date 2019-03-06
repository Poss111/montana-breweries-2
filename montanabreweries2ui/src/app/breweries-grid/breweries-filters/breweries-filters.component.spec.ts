import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BreweriesFiltersComponent } from './breweries-filters.component';

describe('BreweriesFiltersComponent', () => {
  let component: BreweriesFiltersComponent;
  let fixture: ComponentFixture<BreweriesFiltersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BreweriesFiltersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BreweriesFiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
