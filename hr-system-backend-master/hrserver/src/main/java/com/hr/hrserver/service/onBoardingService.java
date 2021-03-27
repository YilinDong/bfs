package com.hr.hrserver.service;

import com.hr.hrserver.controller.S3Controller;
import com.hr.hrserver.dao.ContactDaoImpl;
import com.hr.hrserver.dao.EmployeeDaoImpl;
import com.hr.hrserver.dao.HouseDaoImpl;
import com.hr.hrserver.dao.PersonalDocumentDaoImpl;
import com.hr.hrserver.pojo.Contact;
import com.hr.hrserver.pojo.Employee;
import com.hr.hrserver.pojo.PersonalDocument;
import com.hr.hrserver.util.UtilFunction;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
class OnboardingInputForm{
    int userId;
    String firstName;
    String lastName;
    String midName;
    String preferredName;
    String avatar;
    String ssn;
    Date dob;
    String gender;
    //contact info
    String address;
    String cellPhone;
    String workPhone;
    String email;
    //car & driver license info
    String carBrand;
    String carModel;
    String carColor;
    String driverLicenseNumber;
    Date driverLicenseExpirationDate;
    //migration info
    boolean isCitizen;
    File workAuthDoc;
    //contact & refer
    List<Contact> contactList;
    Contact referer;
}

public class onBoardingService {
    
    public void saveOnboardingData(Map<Object, Object> onboardingInput){

        OnboardingInputForm onboardingInputForm = (OnboardingInputForm) onboardingInput;

        //save to table employee
        Employee employee = new Employee();
        employee.setUserID(onboardingInputForm.userId);
        employee.setFirstName(onboardingInputForm.firstName);
        employee.setLastName(onboardingInputForm.lastName);
        employee.setMiddleName(onboardingInputForm.midName);
        employee.setPreferredName(onboardingInputForm.preferredName);
        // No preferred name column in table employee
        employee.setAvatar(onboardingInputForm.avatar);
        employee.setSSN(onboardingInputForm.ssn);
        employee.setDOB(onboardingInputForm.dob);
        employee.setGender(onboardingInputForm.gender);
        employee.setCellPhone(onboardingInputForm.cellPhone);
        employee.setAlternatePhone(onboardingInputForm.workPhone);
        employee.setEmail(onboardingInputForm.email);
        employee.setAddress(onboardingInputForm.address);

        employee.setStartDate(UtilFunction.getTodayDate());

        employee.setCar(onboardingInputForm.carBrand);
        employee.setCarModel(onboardingInputForm.carModel);
        employee.setCarColor(onboardingInputForm.carColor);
        employee.setDriverLisence(onboardingInputForm.driverLicenseNumber);
        employee.setDriverLisence_ExpirationDate(onboardingInputForm.driverLicenseExpirationDate);
        employee.setIsCitizen(onboardingInputForm.isCitizen?1:0);

        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        int employeeID = (int) employeeDaoImpl.save(employee);

        //save to table contact
        ContactDaoImpl cdi = new ContactDaoImpl();
        cdi.saveAll(onboardingInputForm.contactList);
        cdi.saveOrupdate(onboardingInputForm.referer);

        //save to table PersonalDocument
        PersonalDocument personalDocument = new PersonalDocument();
        personalDocument.setEmployeeID(employeeID);
        personalDocument.setCreatedDate(UtilFunction.getTodayDate());
        personalDocument.setComment("Work Authorization Document");
        personalDocument.setPath(
                onboardingInputForm.userId+"/"+onboardingInputForm.workAuthDoc.getName()
        );
        PersonalDocumentDaoImpl pddi = new PersonalDocumentDaoImpl();
        pddi.save(personalDocument);

        //save workAuthDoc to s3
        S3Controller s3 = new S3Controller();
        s3.uploadToS3(onboardingInputForm.userId, onboardingInputForm.workAuthDoc);

        // assign a not-fully-occupied-house (occupant<4) to this new user
        HouseDaoImpl hdi = new HouseDaoImpl();
        hdi.assignHouse(onboardingInputForm.userId);
    }
}
