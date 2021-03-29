import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HRComponentComponent } from './components/hrcomponent/hrcomponent.component';
import { OnboardingFormServiceService } from './services/onboarding-form-service.service'; 
import { HttpClientModule } from '@angular/common/http';
import { ErrorComponentComponent } from './components/error-component/error-component.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PersonalInfoComponent } from './components/personal-info/personal-info.component';
import { VisaStatusMgmtComponent } from './components/visa-status-mgmt/visa-status-mgmt.component';
import { HousingComponent } from './components/housing/housing.component';
import { LoginComponent } from './components/login/login.component';
import { NameSectionComponent } from './components/personal-info/name-section/name-section.component';
import { AddressSectionComponent } from './components/personal-info/address-section/address-section.component';
import { ContactSectionComponent } from './components/personal-info/contact-section/contact-section.component';
import { EmploymentSectionComponent } from './components/personal-info/employment-section/employment-section.component';
import { EmergencySectionComponent } from './components/personal-info/emergency-section/emergency-section.component';
import { DocumentSectionComponent } from './components/personal-info/document-section/document-section.component';
import { AuthServiceService } from './services/auth-service.service';
import { AuthGuardServiceGuard } from './guard/auth-guard-service.guard';
import { LogoutComponent } from './components/logout/logout.component';
import { UserMockData } from './MockData/UserMockData';
import { PersonalInfo } from './model/PersonalInfo';
import { HousingDetailComponent } from './components/housing/housing-detail/housing-detail.component';
import { FacilityReportingComponent } from './components/housing/facility-reporting/facility-reporting.component';


@NgModule({
  declarations: [
    AppComponent,
    HRComponentComponent,
    ErrorComponentComponent,
    DashboardComponent,
    PersonalInfoComponent,
    VisaStatusMgmtComponent,
    HousingComponent,
    LoginComponent,
    NameSectionComponent,
    AddressSectionComponent,
    ContactSectionComponent,
    EmploymentSectionComponent,
    EmergencySectionComponent,
    DocumentSectionComponent,
    LogoutComponent,
    HousingDetailComponent,
    FacilityReportingComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [OnboardingFormServiceService, AuthServiceService, AuthGuardServiceGuard, UserMockData, PersonalInfo],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
