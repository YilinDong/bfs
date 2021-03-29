import { Component } from '@angular/core';
import { AuthServiceService } from './services/auth-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-form';
  // isloggedin: boolean;

  constructor(public auth: AuthServiceService){
    
  }

  // loggedin(){
  //   this.isloggedin = this.auth.isLoggedin();
  // }
  

}
