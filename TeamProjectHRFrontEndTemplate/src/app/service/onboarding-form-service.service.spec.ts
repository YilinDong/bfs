import { TestBed } from '@angular/core/testing';

import { OnboardingFormServiceService } from './onboarding-form-service.service';

describe('OnboardingFormServiceService', () => {
  let service: OnboardingFormServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OnboardingFormServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
