import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { FilterMap } from '../filter';

@Injectable({ providedIn: 'root' })
export class FilterService {
  private filterMapSource = new Subject<FilterMap>();

  filterMap$ = this.filterMapSource.asObservable();

  public getFilter(): Observable<FilterMap> {
    return this.filterMap$;
  }
}
