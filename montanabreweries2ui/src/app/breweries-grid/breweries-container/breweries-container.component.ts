import {Component, OnDestroy, OnInit, ViewChildren} from '@angular/core';
import {Microbrew} from 'src/app/microbrew';
import {MicrobrewService} from 'src/app/services/microbrews.service';
import {WebsocketService} from 'src/app/services/websocket.service';
import {FiltersComponent} from 'src/app/components/filters/filters.component';
import {Subscription} from 'rxjs';
import {Message} from '@stomp/stompjs';

@Component({
  selector: 'app-breweries-container',
  templateUrl: './breweries-container.component.html',
  styleUrls: ['./breweries-container.component.css']
})
export class BreweriesContainerComponent implements OnInit, OnDestroy {
  title = 'montanabreweries2ui';

  @ViewChildren(FiltersComponent)
  private filtersComponent: FiltersComponent[];

  private datasubscription: Subscription;

  private statesubscription: Subscription;

  microbrews: Microbrew[];

  constructor(
      private microbrewService: MicrobrewService,
      private websocketService: WebsocketService
  ) {}

  ngOnInit() {
    // this.getMicrobrews();
    this.websocketService.connectWebSocket();
    this.datasubscription = this.websocketService
      .getSocketDataObservable()
        .subscribe((message: Message) => {
          console.log('Data received ', message.body);
          this.microbrews = JSON.parse(message.body);
        });
    this.statesubscription = this.websocketService
      .getSocketStateObservable()
        .subscribe((state: String) => {
          console.log('The Websocket connection state has changed ::', state);
          if ('CONNECTED' === state) {
            console.log('We are connected, querying for Data...');
            this.getMicrobrews();
          }
        });
  }

  getMicrobrews(): void {
    console.log('Calling Microbrews Service...');
    this.microbrewService
      .getMicrobrews()
      .subscribe(microbrews => (this.microbrews = microbrews));
  }

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
