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
import { FiltersComponent } from './components/filters/filters.component';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { FilterService } from './services/filter.service';

@NgModule({
  declarations: [
    AppComponent,
    BreweriesGridComponent,
    BeerTileComponent,
    FiltersComponent
  ],
  imports: [
    BrowserModule,
    TableModule,
    HttpClientModule,
    ButtonModule,
    InputTextModule,
    FormsModule
  ],
  providers: [MicrobrewService, BreweriesService, FilterService, Configuration, WebsocketService, StompService, { provide: StompConfig, useValue: stompConfig}],
  bootstrap: [AppComponent]
})
export class AppModule { }
