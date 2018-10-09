import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { TableModule } from 'primeng/table';
import { HttpClientModule } from '@angular/common/http';
import { MicrobrewService } from './services/microbrews.service';
import { Configuration } from './app.constants';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    TableModule,
    HttpClientModule
  ],
  providers: [MicrobrewService, Configuration],
  bootstrap: [AppComponent]
})
export class AppModule { }
