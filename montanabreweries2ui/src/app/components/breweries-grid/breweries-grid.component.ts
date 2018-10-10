import { Component, OnInit } from '@angular/core';
import { BreweriesService } from 'src/app/services/breweries.service';
import { Brewery } from 'src/app/brewery';

@Component({
  selector: 'breweries-grid',
  templateUrl: './breweries-grid.component.html',
  styleUrls: ['./breweries-grid.component.css']
})
export class BreweriesGridComponent implements OnInit {

  breweries: Brewery[];

  constructor(private breweriesService : BreweriesService) {}

  ngOnInit() {
    this.getBreweries();
  }

  getBreweries(): void {
    console.log("Calling Breweries Service...");
    this.breweriesService.getBreweries().subscribe(breweries => this.breweries = breweries);
  }

}
