import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-breweries-filters',
  templateUrl: './breweries-filters.component.html',
  styleUrls: ['./breweries-filters.component.css']
})
export class BreweriesFiltersComponent implements OnInit {
  filterValue: string;

  constructor() {}

  ngOnInit() {}

  onEventMyOwn(event: any) {
    this.filterValue = event.valueTyped;
  }
}
