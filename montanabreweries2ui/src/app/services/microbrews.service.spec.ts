import { TestBed } from '@angular/core/testing';

import { MicrobrewService } from './microbrews.service';

describe('MicrobrewsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MicrobrewService = TestBed.get(MicrobrewService);
    expect(service).toBeTruthy();
  });
});
