import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from "./app.component";
import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { AppRoutingModule } from "./app-routing.module";
import { ComponentsModule } from "./components/components.module";
import { UserkindService } from "./service/userkind.service";
import { OnboardingFormServiceService } from "./service/onboarding-form-service.service";
import { HRComponentComponent } from "./pages/hrcomponent/hrcomponent.component";

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    ReactiveFormsModule,
    ToastrModule.forRoot()
  ],
  declarations: [AppComponent, AdminLayoutComponent, HRComponentComponent,],
  providers: [UserkindService,OnboardingFormServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {}
