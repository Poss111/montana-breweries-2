import { TestBed } from '@angular/core/testing';

import { BreweriesService } from './breweries.service';

describe('BreweriesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BreweriesService = TestBed.get(BreweriesService);
    expect(service).toBeTruthy();
  });
});
