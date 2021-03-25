import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { OnboardingForm } from '../../model/OnboardingForm';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OnboardingFormServiceService {

  url : string;

  constructor(private http : HttpClient) { }

  submitForm(data): Observable<OnboardingForm>{
    return this.http.post<OnboardingForm>(this.url, data);
  }
}
