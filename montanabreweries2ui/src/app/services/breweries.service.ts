import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';

import { Brewery } from '../brewery';
import {
  HttpClient,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpHeaders
} from '@angular/common/http';
import { Configuration } from '../app.constants';

@Injectable({ providedIn: 'root' })
export class BreweriesService {
  private brewiesListUrl = 'brewerylist';
  private actionUrl: string;

  constructor(private http: HttpClient, private configuration: Configuration) {
    this.actionUrl = configuration.server + this.brewiesListUrl;
  }

  public getBreweries(): Observable<Brewery[]> {
    return this.http.post<Brewery[]>(this.actionUrl, '');
  }
}

@Injectable()
export class CustomInterceptor implements HttpInterceptor {
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (!req.headers.has('Content-type')) {
      req = req.clone({
        headers: req.headers.set('Content-Type', 'application/json')
      });
    }

    req = req.clone({ headers: req.headers.set('Accept', 'application/json') });
    return next.handle(req);
  }
}
