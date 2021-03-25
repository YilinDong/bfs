import { Routes } from "@angular/router";

import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { IconsComponent } from "../../pages/icons/icons.component";
import { MapComponent } from "../../pages/map/map.component";
import { NotificationsComponent } from "../../pages/notifications/notifications.component";
import { PersonalinfoComponent } from "../../pages/personal/personalinfo.component";
import { VisamanagementhrComponent } from "../../pages/visamanagementhr/visamanagementhr.component";
import { PersoanlvisamgmtComponent } from "../../pages/persoanlvisamgmt/persoanlvisamgmt.component";
import { HousemgmtComponent } from "../../pages/housemgmt/housemgmt.component";
import { HousingComponent } from "../../pages/housing/housing.component";
// import { RtlComponent } from "../../pages/rtl/rtl.component";

export const AdminLayoutRoutes: Routes = [
  { path: "dashboard", component: DashboardComponent },
  { path: "icons", component: IconsComponent },
  { path: "maps", component: MapComponent },
  { path: "notifications", component: NotificationsComponent },
  { path: "personalinfo", component: PersonalinfoComponent },
  { path: "visamanagementhr", component: VisamanagementhrComponent },
  { path: "persoanlvisamgmt", component: PersoanlvisamgmtComponent },
  { path: "housemgmt", component: HousemgmtComponent },
  { path: "housing", component: HousingComponent },
  // { path: "rtl", component: RtlComponent }
];
