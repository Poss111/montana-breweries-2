import { Component, OnInit, ViewChildren } from '@angular/core';
import { Microbrew } from 'src/app/microbrew';
import { FilterMap } from 'src/app/filter';
import { MicrobrewService } from 'src/app/services/microbrews.service';
import { WebsocketService } from 'src/app/services/websocket.service';
import { FilterService } from 'src/app/services/filter.service';
import { FiltersComponent } from 'src/app/components/filters/filters.component';
import { Subscription } from 'rxjs';
import { Message } from '@stomp/stompjs';

@Component({
  selector: 'app-breweries-container',
  templateUrl: './breweries-container.component.html',
  styleUrls: ['./breweries-container.component.css']
})
export class BreweriesContainerComponent implements OnInit {
  title = 'montanabreweries2ui';

  @ViewChildren(FiltersComponent)
  private filtersComponent: FiltersComponent[];

  private datasubscription: Subscription;

  private statesubscription: Subscription;

  microbrews: Microbrew[];

  filterMaps: FilterMap[] = [];

  constructor(
    private microbrewService: MicrobrewService,
    private websocketService: WebsocketService,
    private filterService: FilterService
  ) {}

  ngOnInit() {
    this.getMicrobrews();
    this.websocketService.connectWebSocket();
    this.datasubscription = this.websocketService
      .getSocketDataObservable()
      .subscribe(this.onData);
    this.statesubscription = this.websocketService
      .getSocketStateObservable()
      .subscribe(this.onStateChange);
    this.filterService.getFilter().subscribe(filtering => {
      this.filterMaps.push(filtering);
    });
    // this.getMicrobrews();
  }

  getMicrobrews(): void {
    console.log('Calling Microbrews Service...');
    this.microbrewService
      .getMicrobrews()
      .subscribe(microbrews => (this.microbrews = microbrews));
  }

  private onData = (message: Message) => {
    this.microbrews = JSON.parse(message.body);
  };

  private onStateChange = (state: String) => {
    console.log('WS connection State has changed :: ' + state);
  };

  submitFilters() {
    this.filtersComponent.forEach(function(filterComponent) {
      filterComponent.submitFilter();
    });
  }

  ngOnDestroy() {
    this.datasubscription.unsubscribe();
    this.statesubscription.unsubscribe();
  }
}
