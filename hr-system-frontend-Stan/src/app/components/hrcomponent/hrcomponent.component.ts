import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, EmailValidator, FormArray, FormBuilder, NgForm, Validators, Form } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { OnboardingFormServiceService } from './../../services/onboarding-form-service.service';


@Component({
  selector: 'app-hrcomponent',
  templateUrl: './hrcomponent.component.html',
  styleUrls: ['./hrcomponent.component.css']
})

export class HRComponentComponent implements OnInit {
  myForm = new FormGroup({
    name: new FormControl('avatar'),
    file: new FormControl('', [Validators.required]),
    fileSource: new FormControl('', [Validators.required])
  });

  onboardingForm: FormGroup;
  emergencyContacts: FormArray;
  email : string;
  // model = {
  //   'username':'',
  //   'password':''
  // };
  // private currentUsername:any;
  

  constructor(
    private formBuilder: FormBuilder, private activatedRoute: ActivatedRoute, private onboardingFormServiceService : OnboardingFormServiceService, private AuthServiceService: AuthServiceService,
    private http: HttpClient
    ) { 
      localStorage.setItem("name", "dani");
    }
    url: string= "/api/savefile";   
    get f(){
      return this.myForm.controls;
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

  onFileChange(event) {
  
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.myForm.patchValue({
        fileSource: file
      });
    }
  }
  
     
  submit(){
    const formData = new FormData();
    formData.append('file', this.myForm.get('fileSource').value,"myfile"+localStorage.getItem("name"));
   
    this.http.post(this.url, formData,{responseType:'text'})
      .subscribe(res => {
        console.log(res);
        alert('Uploaded Successfully.');
      })
  }
  // onSubmit(){
  //   this.AuthServiceService.sendInfo(this.model.username, this.model.password).subscribe(
  //     data=>{
  //       localStorage.setItem("token", JSON.parse(JSON.stringify(data))._body);
  //       // this.currentUsername=this.model.username;
  //       // localStorage.setItem("currentUsername", this.model.username);

  //       this.AuthServiceService.sendToken(localStorage.getItem("token")||"").subscribe(
  //         data=>{
  //           //store personal info here
  //           this.currentUsername=this.model.username;
  //           localStorage.setItem("currentUsername", this.model.username);
  //         }

  //       )
  //     }
  //   )
  // }
}
