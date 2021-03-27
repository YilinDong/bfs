import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, EmailValidator, FormArray, FormBuilder, NgForm, Validators, Form } from '@angular/forms';

@Component({
  selector: 'app-hrcomponent',
  templateUrl: './hrcomponent.component.html',
  styleUrls: ['./hrcomponent.component.css']
})
export class HRComponentComponent implements OnInit {
  onboardingForm: FormGroup;
  // emergencyContacts: FormArray;

  constructor(
    private formBuilder: FormBuilder
    ) { }

  ngOnInit(): void {

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
      email: [],
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
      emergencyContacts: this.formBuilder.array([this.createEmergencyContact()]),
    });
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

  private createEmergencyContact(): FormGroup{
    return new FormGroup({
      emergencyContactFirstName: new FormControl(''),
      emergencyContactLastName: new FormControl(''),
      emergencyContactMiddleName: new FormControl(''),
      emergencyContactPhone: new FormControl(''),
      emergencyContactEmail: new FormControl('', Validators.email),
      emergencyContactRelationship: new FormControl(''),
    });
  }
  onSubmit(formGroup: FormGroup) {
    console.log(formGroup);
  }
}
