import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Microbrew } from './microbrew';
import { MicrobrewService } from './services/microbrews.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'montanabreweries2ui';

  microbrews: Microbrew[];

  constructor(private microbrewService : MicrobrewService) {}

  ngOnInit() {
    this.getMicrobrews();
    console.log(this.microbrews);
  }

  getMicrobrews(): void {
    console.log("Calling Microbrews Service...");
    this.microbrewService.getMicrobrews().subscribe(microbrews => this.microbrews = microbrews);
  }
}


