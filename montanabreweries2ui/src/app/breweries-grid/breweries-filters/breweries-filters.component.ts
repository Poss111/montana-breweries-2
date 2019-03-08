import { Component, OnInit } from '@angular/core';
import { Filter } from '../shared/filter';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-breweries-filters',
  templateUrl: './breweries-filters.component.html',
  styleUrls: ['./breweries-filters.component.css']
})
export class BreweriesFiltersComponent implements OnInit {
  filterValue: string;
  filter: Map<string, string>;
  constructor() {}

  ngOnInit() {
    this.filter = new Map();
  }

  onEventMyOwn(event: any) {
    this.filter.set(event.filterNme, event.valueTyped);
    console.log(this.filter);
  }
}
