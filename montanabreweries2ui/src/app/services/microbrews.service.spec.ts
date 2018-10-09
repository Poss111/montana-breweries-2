import { TestBed } from '@angular/core/testing';

import { MicrobrewsService } from './microbrews.service';

describe('MicrobrewsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MicrobrewsService = TestBed.get(MicrobrewsService);
    expect(service).toBeTruthy();
  });
});
