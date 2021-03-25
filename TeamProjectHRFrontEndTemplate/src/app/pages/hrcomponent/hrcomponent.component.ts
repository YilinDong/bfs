import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, EmailValidator, FormArray, FormBuilder, NgForm, Validators, Form } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { OnboardingFormServiceService } from './../../service/onboarding-form-service.service';


@Component({
  selector: 'app-hrcomponent',
  templateUrl: './hrcomponent.component.html',
  styleUrls: ['./hrcomponent.component.css']
})

export class HRComponentComponent implements OnInit {
  onboardingForm: FormGroup;
  emergencyContacts: FormArray;
  email : string;
  

  constructor(
    private formBuilder: FormBuilder, private activatedRoute: ActivatedRoute, private onboardingFormServiceService : OnboardingFormServiceService
    ) { 
    }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
      this.email = this.activatedRoute.snapshot.queryParams['email'];
    });
    console.log(this.email);
    this.onboardingForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      // lastname : new FormControl(''),
      middleName: [''],
      preferredName:[''],
      avatar:[''],
      // Avatar: new FormControl(File),
      address:['', Validators.required],
      cellPhone:['', Validators.required],
      workPhone:[''],
      carBrand:[''],
      carModel:[''],
      carColor:[''],
      email : this.email,
      SSN:['', Validators.required],
      birthday:['', Validators.required],
      gender:[''],
      isCitizenOrPerm :[''],
      greenCardOrCitizen:[''],
      workAuth:[''],
      workAuthOtherStart:[''],
      workAuthOtherEnd:[''],
      workAuthOther:[''],
      workAuthFile:[],
      hasDriverLicense:[''],
      driverLicenseNumber:[''],
      driverLicenseExpirationDate:[''],
      driverLicenseCopy:[],
      referred:[],
      referFirstName:[''],
      referLastName:[''],
      referMiddleName:[''],
      referPhone:[''],
      referAddress:[''],
      referEmail:[''],
      referRelationship:[''],
      emergencyContacts : this.formBuilder.array([
        this.formBuilder.group({
          emergencyContactFirstName: new FormControl(''),
          emergencyContactLastName: new FormControl(''),
          emergencyContactMiddleName: new FormControl(''),
          emergencyContactPhone: new FormControl(''),
          emergencyContactEmail: new FormControl('', Validators.email),
          emergencyContactRelationship: new FormControl('')
        })
      ])
    });
    this.emergencyContacts = this.onboardingForm.get("emergencyContacts") as FormArray;
}

  addEmergencyContact(){
    const emergencyContact = this.onboardingForm.get('emergencyContacts') as FormArray;
    emergencyContact.push(this.createEmergencyContact());
  }

  private removeEmergencyContacts(i : number){
    const emergencyContacts = this.onboardingForm.get('emergencyContacts') as FormArray;
    if (emergencyContacts.length > 1) {
      emergencyContacts.removeAt(i);
    }
  }

  private createEmergencyContact(): FormControl | FormGroup{
    return new FormGroup({
      emergencyContactFirstName: new FormControl(''),
      emergencyContactLastName: new FormControl(''),
      emergencyContactMiddleName: new FormControl(''),
      emergencyContactPhone: new FormControl(''),
      emergencyContactEmail: new FormControl('', Validators.email),
      emergencyContactRelationship: new FormControl('')
    });
  }
  onSubmit(formGroup: FormGroup) {
    console.log(formGroup);
    this.onboardingFormServiceService.submitForm(this.onboardingForm.value).subscribe((data) => {
      console.log('onboarding form submitted');
    },
    (error : HttpErrorResponse) => {
      console.log(error);
    }
    );
  }
}
