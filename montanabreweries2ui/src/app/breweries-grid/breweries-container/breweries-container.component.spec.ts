import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BreweriesContainerComponent } from './breweries-container.component';

describe('BreweriesContainerComponent', () => {
  let component: BreweriesContainerComponent;
  let fixture: ComponentFixture<BreweriesContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BreweriesContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BreweriesContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
