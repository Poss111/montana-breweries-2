import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-breweries-filter',
  templateUrl: './breweries-filter.component.html',
  styleUrls: ['./breweries-filter.component.css']
})
export class BreweriesFilterComponent implements OnInit {
  @Input()
  filterName: string;

  @Output()
  textInput = new EventEmitter<any>();

  constructor() {}

  ngOnInit() {}

  onChangeEvent(event) {
    console.log('Change is occuring! ' + event);
    this.textInput.emit({ valueTyped: event });
  }
}
