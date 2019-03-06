import { Component, OnInit, Input } from '@angular/core';
import { FilterService } from 'src/app/services/filter.service';
import { FilterMap } from 'src/app/filter';

@Component({
  selector: 'filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {
  @Input('placeholderValue') placeholderText: String;
  @Input('filterName') filterName: String;
  @Input('filterOperation') filterOperation: String;

  filterMap: FilterMap;
  textValue: string;

  constructor(private filterService: FilterService) {}

  ngOnInit() {}

  submitFilter() {
    if (this.textValue != null && this.textValue != '') {
      this.filterMap = new FilterMap();
      this.filterMap.name = this.filterName;
      this.filterMap.operation = this.filterOperation;
      this.filterMap.value = this.textValue;
    }
  }
}
