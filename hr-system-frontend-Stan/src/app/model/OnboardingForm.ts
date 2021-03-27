export class OnboardingForm {

    firstName: string;
    lastName: string;
    middleName: string;
    preferredName: string;
    avatar: File;
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
    workAuthFile: File;
    hasDriverLicense: string;
    driverLicenseNumber: string;
    driverLicenseExpirationDate: Date;
    driverLicenseCopy: File;
    referred: string;
    referFirstName: string;
    referLastName: string;
    referMiddleName: string;
    referPhone: number;
    referAddress: string;
    referEmail: string;
    referRelationship: string;

    constructor() {
    }
}