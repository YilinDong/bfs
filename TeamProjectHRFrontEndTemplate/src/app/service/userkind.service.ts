import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserkindService {

  execChange: Subject<any> = new Subject<any>();

  constructor() { }

  isUserHr(flag: boolean) {
    this.execChange.next(flag);
  }
}
