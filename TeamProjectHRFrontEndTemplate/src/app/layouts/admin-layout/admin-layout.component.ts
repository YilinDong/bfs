import { Component, OnInit } from "@angular/core";
import { LoginService } from "src/app/service/login.service";
import { UserkindService } from "src/app/service/userkind.service";

@Component({
  selector: "app-admin-layout",
  templateUrl: "./admin-layout.component.html",
  styleUrls: ["./admin-layout.component.scss"]
})
export class AdminLayoutComponent implements OnInit {
  public sidebarColor: string = "red";
  private _subscription_user_kind: any;
  isUserHr: any;
  private _subscription_login: any;
  isLogin: any;

  uname = 'username';
  pwd = 'password';

  constructor(public userKindService: UserkindService, public loginService : LoginService) {
    this._subscription_user_kind = this.userKindService.execChange.subscribe((value) => {
      this.isUserHr= value; 
    });
    this._subscription_login = this.loginService.execChange.subscribe((value) => {
      this.isLogin= value; 
    });
  }

  checkLoginInfo(): void{
    if (this.uname === '1' && this.pwd === '1'){
      this.userKindService.isUserHr(false);
      this.loginService.isUserLogin(true);
    }
    else if (this.uname === '2' && this.pwd === '2'){
      this.userKindService.isUserHr(true);
      this.loginService.isUserLogin(true);
    }
    else {
      this.loginService.isUserLogin(false);
    }
  }

  logOut(): void{
    this.loginService.isUserLogin(false);
  }

  testchange(){
    this.userKindService.isUserHr(!this.isUserHr);
  }

  testlogin(){
    this.loginService.isUserLogin(!this.isLogin);
  }


  ngOnInit() {}
}
