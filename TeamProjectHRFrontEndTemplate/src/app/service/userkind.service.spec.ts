import { TestBed } from '@angular/core/testing';

import { UserkindService } from './userkind.service';

describe('UserkindService', () => {
  let service: UserkindService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserkindService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
