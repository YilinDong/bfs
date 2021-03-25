import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  execChange: Subject<any> = new Subject<any>();

  constructor() { }

  isUserLogin(flag: boolean) {
    this.execChange.next(flag);
  }
}
