import { Component, OnInit, ViewChild, ViewChildren } from '@angular/core';
import { Microbrew } from './microbrew';
import { FilterMap } from './filter';
import { MicrobrewService } from './services/microbrews.service';
import { Subscription } from 'rxjs';
import { WebsocketService } from './services/websocket.service';
import { Message } from '@stomp/stompjs';
import { FilterService } from './services/filter.service';
import { FiltersComponent } from './components/filters/filters.component';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [FilterService]
})
export class AppComponent implements OnInit {
  title = 'montanabreweries2ui';

  @ViewChildren(FiltersComponent)
  private filtersComponent: FiltersComponent[];

  private datasubscription: Subscription;

  private statesubscription: Subscription;

  microbrews: Microbrew[];

  filterMaps: FilterMap[] = [];

  constructor(private microbrewService : MicrobrewService, private websocketService: WebsocketService, private filterService: FilterService) {}

  ngOnInit() {
    this.getMicrobrews();
    this.websocketService.connectWebSocket();
    this.datasubscription = this.websocketService.getSocketDataObservable().subscribe(this.onData);
    this.statesubscription = this.websocketService.getSocketStateObservable().subscribe(this.onStateChange);
    this.filterService.getFilter().subscribe( filtering => {
      this.filterMaps.push(filtering);
    });
    // this.getMicrobrews();
  }

  getMicrobrews(): void {
    console.log("Calling Microbrews Service...");
    this.microbrewService.getMicrobrews().subscribe(microbrews => this.microbrews = microbrews);
  }

  private onData = (message: Message) => {
    this.microbrews = JSON.parse(message.body);
  }

  private onStateChange = (state: String) => {
    console.log('WS connection State has changed :: ' + state);
  }

  submitFilters() {
    this.filtersComponent.forEach(function (filterComponent) {
      filterComponent.submitFilter();
    });
  }

  ngOnDestroy() {
    this.datasubscription.unsubscribe();
    this.statesubscription.unsubscribe();
  }

}


