import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeerTileComponent } from './beer-tile.component';

describe('BeerTileComponent', () => {
  let component: BeerTileComponent;
  let fixture: ComponentFixture<BeerTileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeerTileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeerTileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
