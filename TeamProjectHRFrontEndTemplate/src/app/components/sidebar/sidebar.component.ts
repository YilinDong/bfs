import { Component, OnInit } from "@angular/core";
import { UserkindService } from "src/app/service/userkind.service";

declare interface RouteInfo {
  path: string;
  title: string;
  rtlTitle: string;
  icon: string;
  class: string;
}
export const ROUTESHr: RouteInfo[] = [
  {
    path: "/personalinfo",
    title: "Personal Info",
    rtlTitle: "ملف تعريفي للمستخدم",
    icon: "icon-single-02",
    class: ""
  },  
  {
    path: "/visamanagementhr",
    title: "Visa Management",
    rtlTitle: "قائمة الجدول",
    icon: "icon-puzzle-10",
    class: ""
  },
  {
    path: "/persoanlvisamgmt",
    title: "Personal Visa MGMT",
    rtlTitle: "طباعة",
    icon: "icon-align-center",
    class: ""
  },
  {
    path: "/notifications",
    title: "Hire",
    rtlTitle: "إخطارات",
    icon: "icon-bell-55",
    class: ""
  },
  {
    path: "/housemgmt",
    title: "House Management",
    rtlTitle: "",
    icon: "icon-bank",
    class:""
  },
  {
    path: "/housing",
    title: "Housing",
    rtlTitle: "",
    icon: "icon-bank",
    class:""
  },

  // {
  //   path: "/rtl",
  //   title: "RTL Support",
  //   rtlTitle: "ار تي ال",
  //   icon: "icon-world",
  //   class: ""
  // }
];

export const ROUTESUser: RouteInfo[] = [
  {
    path: "/personalinfo",
    title: "Personal Info",
    rtlTitle: "ملف تعريفي للمستخدم",
    icon: "icon-single-02",
    class: ""
  },  
  {
    path: "/persoanlvisamgmt",
    title: "Personal Visa MGMT",
    rtlTitle: "طباعة",
    icon: "icon-align-center",
    class: ""
  },
  {
    path: "/housing",
    title: "Housing",
    rtlTitle: "",
    icon: "icon-bank",
    class:""
  },

];

@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.css"]
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  menuItemsHr: any[];

  isUserHr: boolean;
  private _subscription_user_kind: any;

  constructor(public userKindService: UserkindService) {
    this._subscription_user_kind = this.userKindService.execChange.subscribe((value) => {
      this.isUserHr= value; 
  });
  }

  ngOnChanges(){
    // if(this.isUserHr){
    //   this.menuItemsHr = ROUTESHr.filter(menuItem => menuItem);
    // }
    // else{
    //   this.menuItems = ROUTESUser.filter(menuItem => menuItem);
    // }
    console.log("sidebar"+this.isUserHr+this.userKindService.isUserHr);
  }

  ngOnInit() {
    this.menuItemsHr = ROUTESHr.filter(menuItem => menuItem);
    this.menuItems = ROUTESUser.filter(menuItem => menuItem);
   }
  isMobileMenu() {
    if (window.innerWidth > 991) {
      return false;
    }
    return true;
  }

  logifhr(){
    console.log(this.isUserHr + "***" + this._subscription_user_kind);
  }
}
