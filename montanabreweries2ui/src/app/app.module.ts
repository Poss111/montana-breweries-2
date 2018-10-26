import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { TableModule } from 'primeng/table';
import { HttpClientModule } from '@angular/common/http';
import { MicrobrewService } from './services/microbrews.service';
import { Configuration } from './app.constants';
import { BreweriesGridComponent } from './components/breweries-grid/breweries-grid.component';
import { BreweriesService } from './services/breweries.service';
import { WebsocketService } from './services/websocket.service';
import { StompService, StompConfig } from '@stomp/ng2-stompjs';
import { stompConfig } from './constants/stomp-config.module';
import { BeerTileComponent } from './components/beer-tile/beer-tile.component';

@NgModule({
  declarations: [
    AppComponent,
    BreweriesGridComponent,
    BeerTileComponent
  ],
  imports: [
    BrowserModule,
    TableModule,
    HttpClientModule
  ],
  providers: [MicrobrewService, BreweriesService, Configuration, WebsocketService, StompService, { provide: StompConfig, useValue: stompConfig}],
  bootstrap: [AppComponent]
})
export class AppModule { }
