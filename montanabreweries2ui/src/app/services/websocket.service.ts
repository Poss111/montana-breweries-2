import { Injectable } from '@angular/core';
import { Subscription, Observable } from 'rxjs';
import { Message } from '@stomp/stompjs';
import { StompService, StompState } from '@stomp/ng2-stompjs';
import { map } from 'rxjs/operators';
import { WebSocketConfig } from '../websocket.config';

@Injectable({ providedIn: 'root' })
export class WebsocketService {
  public message: Observable<Message>;

  public wsstate: Observable<string>;

  constructor(private stompService: StompService) {}

  public connectWebSocket() {
    this.wsstate = this.stompService.state.pipe(
      map((state: number) => StompState[state])
    );
    this.message = this.stompService.subscribe(WebSocketConfig.topic);
  }

  public getSocketDataObservable() {
    return this.message;
  }

  public getSocketStateObservable() {
    return this.wsstate;
  }
}
