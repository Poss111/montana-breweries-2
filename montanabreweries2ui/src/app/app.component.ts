import { Component, OnInit } from '@angular/core';
import { Microbrew } from './microbrew';
import { MicrobrewService } from './services/microbrews.service';
import { Subscription } from 'rxjs';
import { WebsocketService } from './services/websocket.service';
import { Message } from '@stomp/stompjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'montanabreweries2ui';

  private datasubscription: Subscription;


  private statesubscription: Subscription;

  microbrews: Microbrew[];

  constructor(private microbrewService : MicrobrewService, private websocketService: WebsocketService) {}

  ngOnInit() {
    this.websocketService.connectWebSocket();
    this.datasubscription = this.websocketService.getSocketDataObservable().subscribe(this.onData);
    this.statesubscription = this.websocketService.getSocketStateObservable().subscribe(this.onStateChange);
    // this.getMicrobrews();
  }

  getMicrobrews(): void {
    console.log("Calling Microbrews Service...");
    this.microbrewService.getMicrobrews().subscribe(microbrews => this.microbrews = microbrews);
  }

  private onData = (message: Message) {
    this.microbrews = JSON.parse(message.body);
  }

  private onStateChange = (state: String) => {
    console.log('WS connection State has changed :: ' + state);
  }

  ngOnDestroy() {
    this.datasubscription.unsubscribe();
    this.statesubscription.unsubscribe();
  }

}


