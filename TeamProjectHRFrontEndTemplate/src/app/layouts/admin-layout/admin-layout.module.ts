import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

import { AdminLayoutRoutes } from "./admin-layout.routing";
import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { IconsComponent } from "../../pages/icons/icons.component";
import { MapComponent } from "../../pages/map/map.component";
import { NotificationsComponent } from "../../pages/notifications/notifications.component";
import { PersonalinfoComponent } from "../../pages/personal/personalinfo.component";
import { VisamanagementhrComponent } from "../../pages/visamanagementhr/visamanagementhr.component";
import { PersoanlvisamgmtComponent } from "../../pages/persoanlvisamgmt/persoanlvisamgmt.component";
import { HousemgmtComponent } from "../../pages/housemgmt/housemgmt.component";
import { HousingComponent } from "src/app/pages/housing/housing.component";
// import { RtlComponent } from "../../pages/rtl/rtl.component";

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    HttpClientModule,
    NgbModule,
  ],
  declarations: [
    DashboardComponent,
    PersonalinfoComponent,
    VisamanagementhrComponent,
    IconsComponent,
    PersoanlvisamgmtComponent,
    NotificationsComponent,
    MapComponent,
    HousemgmtComponent,
    HousingComponent
    // RtlComponent
  ]
})
export class AdminLayoutModule {}
