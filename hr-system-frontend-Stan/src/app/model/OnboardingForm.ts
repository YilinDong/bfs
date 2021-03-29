import { FormArray } from "@angular/forms";

export class OnboardingForm {
    firstName: string;
    lastName: string;
    middleName: string;
    preferredName: string;
    address: string;
    cellPhone: string;
    workPhone: string;
    email: string;
    SSN: string;
    birthday: Date;
    gender: string;
    isCitizenOrPerm: string;
    greenCardOrCitizen: string;
    workAuth: string;
    workAuthOther: string;
    workAuthOtherStart: Date;
    workAuthOtherEnd: Date;

    hasDriverLicense: string;
    driverLicenseNumber: string;
    driverLicenseExpirationDate: Date;

    referred: string;
    referFirstName: string;
    referLastName: string;
    referMiddleName: string;
    referPhone: number;
    referAddress: string;
    referEmail: string;
    referRelationship: string;
    emergencyContacts: FormArray;


    constructor() {
    }
}