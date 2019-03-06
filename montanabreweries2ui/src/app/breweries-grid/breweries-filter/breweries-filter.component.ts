import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-breweries-filter',
  templateUrl: './breweries-filter.component.html',
  styleUrls: ['./breweries-filter.component.css']
})
export class BreweriesFilterComponent implements OnInit {
  @Input()
  filterName: string;

  constructor() {}

  ngOnInit() {}
}
