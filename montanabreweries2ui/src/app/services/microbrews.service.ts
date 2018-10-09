import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';

import { Microbrew } from '../microbrew';
import { MICROBREWS } from '../mock-microbrews';
import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Configuration } from '../app.constants';

@Injectable()
export class MicrobrewService {

  private microbrewsUrl = 'microbrewlist';
  private actionUrl: string;

  constructor(private http: HttpClient, private configuration: Configuration) {
    this.actionUrl = configuration.server + this.microbrewsUrl 
  }

  public getMicrobrews(): Observable<Microbrew[]> {
    return this.http.post<Microbrew[]>(this.actionUrl, "");
  }

}

@Injectable()
export class CustomInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (!req.headers.has('Content-type')) {
      req = req.clone({ headers: req.headers.set('Content-Type', 'application/json') });
    }

  req = req.clone({ headers: req.headers.set('Accept', 'application/json') });
  return next.handle(req);
  }
}
