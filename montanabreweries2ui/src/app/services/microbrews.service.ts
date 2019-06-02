import {Injectable} from '@angular/core';

import {Observable} from 'rxjs';

import {Microbrew} from '../microbrew';
import {HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Configuration} from '../app.constants';

@Injectable({ providedIn: 'root' })
export class CustomInterceptor implements HttpInterceptor {
  intercept(
      req: HttpRequest<any>,
      next: HttpHandler
  ): Observable<HttpEvent<any>> {
    console.log("Using custom interceptor...");

    req = req.clone({headers: req.headers.set('Content-Type', 'application/json')});
    return next.handle(req);
  }
}

@Injectable({providedIn: 'root'})
export class MicrobrewService {
  private microbrewsUrl = 'microbrewlist';
  private actionUrl: string;

  constructor(private http: HttpClient, private configuration: Configuration) {
    this.actionUrl = configuration.server + this.microbrewsUrl;
  }

  public getMicrobrews(): Observable<Microbrew[]> {
    // console.log("Making call...");
    // const headers = new HttpHeaders()
    //     .set('Content-Type', 'application/json');
    return this.http.post<Microbrew[]>(this.actionUrl, '');
  }
}
