package com.hr.hrserver.dao;

import com.hr.hrserver.controller.HousingController;
import com.hr.hrserver.model.OnboardingForm;
import com.hr.hrserver.pojo.*;
import com.hr.hrserver.service.HousingAndFacilityReportService;
import com.hr.hrserver.service.S3ServiceB;
import com.hr.hrserver.service.onBoardingService;
import com.hr.hrserver.util.UtilFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


//        RegistrationToken token = new RegistrationToken("3","qwerty", "a@b.com", null);
//        registrationTokenDaoImpl rtdi = new registrationTokenDaoImpl();
//        rtdi.save(token);
//        rtdi.isValidToken("qwerty");

//        Contact c1 = new Contact(1,1,"spouse","SWE",0,0,0);
//        Contact c2 = new Contact(2,1,"father","te",0,1,0);
//
//        ContactDaoImpl cdi = new ContactDaoImpl();
//        cdi.saveAll(Arrays.asList(new Contact[]{c1, c2}.clone()));
//        cdi.save(c1);
//        System.out.println("11111");
//        cdi.save(c2);

//        List<Contact> li = cdi.getAllContactByEmployeeID(1);
//        for(Contact c : li)
//            System.out.println(c.toString());

//        DigitalDocument dd = new DigitalDocument(01,"testDoc",0,"local/","This is a test doc","TD");
//        DigitalDocumentDaoImpl dddi = new DigitalDocumentDaoImpl();
//        dddi.save(dd);
//        System.out.println(dddi.getDigitalDocumentByType("testDoc").toString());

//        Date date=new Date();
//        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String date1=temp.format(date);
//        Date date2=temp.parse(date1);
//
//        FacilityReport fr = new FacilityReport(1,1,date2,"roof","leek","open");
//        FacilityReport fr2 = new FacilityReport(2,1,date2,"floor","break","close");
//        FacilityReportDaoImpl frdi = new FacilityReportDaoImpl();
//
//        frdi.saveAll(Arrays.asList(new FacilityReport[]{fr, fr2}));
//        for (FacilityReport fri : frdi.getFacilityReportByEmployeeID(1))
//            System.out.println(fri.toString());

//        House h = new House(1,1,1,3);
//        Address address = new Address(1,1,"address line1","address line2", "Brighton", "02221","NJ","xxx");
//        HouseDaoImpl hdl = new HouseDaoImpl();
//        hdl.save(h);
//        AddressDaoImpl adi = new AddressDaoImpl();
//        adi.save(address);
//        System.out.println(hdl.getHouseByID(1));

//        Date date=new Date();
//        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String date1=temp.format(date);
//        Date date2=temp.parse(date1);
//        Role role = new Role(1,"sde","des",date2,date2,1);
//
//        RoleDaoImpl rdi = new RoleDaoImpl();
//        rdi.save(role);
//        System.out.println(rdi.getRoleNameByID(1));

//        Employee e = new Employee();
//        e.setUserID(10);
//        EmployeeDaoImpl edl = new EmployeeDaoImpl();

//        System.out.println(edl.save(e));

//        Employee employee = new Employee();
//        employee.setStartDate(UtilFunction.getTodayDate());
//        employee.setUserID(111);
//        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
//        int employeeID = (int) employeeDaoImpl.save(employee);
//        System.out.println(employeeID + " / " + employee);
//        System.out.println(employeeDaoImpl.get(employeeID));
//        System.out.println(employeeDaoImpl.getEmployeeByUserEmail("admin@gmail.com"));

//        System.out.println(employeeDaoImpl.testDao());

        //find a house with Number of People < 4 and and one person to that house
//        HouseDaoImpl hdi = new HouseDaoImpl();
//
//        int houseId = hdi.getHouseIDWhichNumOfPeopLessThan(4);
//
//        System.out.println(hdi.increaseNumOfPeopleByHouseID(houseId));

//        HousingAndFacilityReportService hFRS = new HousingAndFacilityReportService();
//        System.out.println(hFRS.getHouseDetailByEmployeeID(1).address.getAddressLine1());
//        System.out.println(hFRS.getHouseDetailByEmployeeID(1).address.getAddressLine2());
//        for(Occupant o: hFRS.getHouseDetailByEmployeeID(1).occupantList)
//            System.out.println(o.name + "/////" + o.phoneNumber);

//        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
//        System.out.println(employeeDaoImpl.getSomeInfoByHouseID(1).CellPhone);

//        S3ServiceB s3 = new S3ServiceB();
//        s3.putToS3("./anotherTest.txt","12/anotherTestB.txt");
//        s3.getFromS3("./a.pdf","test/tst.pdf");
//        File file = new File("./a.pdf");
//        try {
//            InputStream in = new FileInputStream(file);
//            s3.putFromInputStreamToS3(in,"test/dupOfA.pdf");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        //test HousingAndFacilityReportService
//        HousingAndFacilityReportService HFRS = new HousingAndFacilityReportService();
//
//        System.out.println(
//                HFRS.getHouseDetailByEmployeeID(1).toString()
//        );
//        output:
//         HouseDetail(
//            address=Address(ID=1, EmployeeID=1, AddressLine1=address line1, AddressLine2=address line2,
//                            City=Brighton, Zipcode=02221, StateName=NJ, StateAbbr=xxx),
//            occupantList=
//                    [Occupant(name=Iron Man, phoneNumber=1234567),
//                    Occupant(name=Peterpan, phoneNumber=1234456789),
//                    Occupant(name=TS, phoneNumber=1234456789)]
//         )


//        HashMap<Object, Object> map = new HashMap<Object, Object>(){{
//            put("title","Broken Door");
//            put("username","Dany");
//            put("description","Door won't close");
//        }};
//        System.out.println("Generated ID: "+HFRS.addNewReport(map));
//
//        HashMap<Object, Object> map2 = new HashMap<Object, Object>(){{
//            put("reportID",3);
//            put("username","Dany");
//            put("comment","I glued it up");
//        }};
//        HFRS.addNewCommentToReport(map2);
//
//        System.out.println(
//                HFRS.getFacilityReportByUsername("Dany")
//        );
//        output:[
//            FacilityReport(ID=1, EmployeeID=1, ReportDate=2021-03-25 20:00:00.0,
//                Title=roof, Description=leek, Status=open),
//            FacilityReport(ID=2, EmployeeID=1, ReportDate=2021-03-25 20:00:00.0,
//                Title=floor, Description=break, Status=close),
//            FacilityReport(ID=3, EmployeeID=1, ReportDate=2021-03-27 20:00:00.0,
//                Title=Broken Door, Description=Door won't close, Status=Open)
//        ]

//        FacilityReportDetailDaoImpl FRDDI = new FacilityReportDetailDaoImpl();
//
//        System.out.println(
//                FRDDI.getFacilityReportDetailByFacilityReportID(1)
//        );
//        output:[
//                FacilityReportDetail(ID=1, ReportID=1, EmployeeID=1,
//                        Comment=so the roofi is leeking, CreatedDate=2021-03-19 20:00:00.0,
//                        LastModificationDate=2021-03-19 20:00:00.0),
//                FacilityReportDetail(ID=4, ReportID=1, EmployeeID=2, Comment=raining in door,
//                        CreatedDate=2021-03-20 20:00:00.0, LastModificationDate=2021-03-20 20:00:00.0)
//                        ]



//        OnboardingForm form = new OnboardingForm();
//        form.setFirstName("Stan");
//        form.setLastName("Xuan");
//        form.setMiddleName("B.");
//        form.setPreferredName("Xuan");
//        form.setAvatar("test/Danybili.jpg");
//        form.setAddress("85 Brookline Street");
//        form.setCellPhone("6175554444");
//        form.setWorkPhone("3332221111");
//        form.setSSN("853412609");
//        form.setBirthday(UtilFunction.getTodayDate());
//        form.setGender("Male");
//        form.setIsCitizenOrPerm("True");
//        form.setGreenCardOrCitizen("False");
//        form.setWorkAuth("Other");
//        form.setWorkAuthOther("UserInputString");
//        form.setWorkAuthOtherStart("2010-02-04");
//        form.setWorkAuthOtherEnd("2015-02-03");
//        form.setWorkAuthFile("test/printPage2.pdf");
//        form.setHasDriverLicense("abcdes12");
//        form.setDriverLicenseNumber("123456");
//        form.setDriverLicenseExpirationDate(UtilFunction.getTodayDate());
//
//        form.setReferred("True");
//        form.setReferFirstName("Dany");
//        form.setReferLastName("Liu");
//        form.setMiddleName("S.");
//        form.setReferPhone("3216540987");
//        form.setReferAddress("10 Milton road");
//        form.setReferEmail("bbb@gmail.com");
//        form.setReferRelationship("friend");
//
//        Map<String, String> clist1 = new HashMap<>();
//        clist1.put("emergencyContactFirstName","c1firstname");
//        clist1.put("emergencyContactLastName","c1lastname");
//        clist1.put("emergencyContactMiddleName","c1m");
//        clist1.put("emergencyContactPhone","1111111111");
//        clist1.put("emergencyContactEmail","c1email@mail.com");
//        clist1.put("emergencyContactRelationship","r1");
//
//        Map<String, String> clist2 = new HashMap<>();
//        clist2.put("emergencyContactFirstName","c2firstname");
//        clist2.put("emergencyContactLastName","c2lastname");
//        clist2.put("emergencyContactMiddleName","c2m");
//        clist2.put("emergencyContactPhone","2222222222");
//        clist2.put("emergencyContactEmail","c2email@mail.com");
//        clist2.put("emergencyContactRelationship","r2");
//
//        List clist = Arrays.asList(clist1, clist2);;
//        form.setEmergencyContacts(clist);

//        com.hr.hrserver.model.OnboardingForm form = new OnboardingForm();
//        form.setFirstName("Stan");
//        form.setLastName("Xuan");
//        form.setMiddleName("B.");
//        form.setPreferredName("Xuan");
//        form.setAvatar("test/Danybili.jpg");
//        form.setAddress("85 Brookline Street");
//        form.setCellPhone("6175554444");
//        form.setWorkPhone("3332221111");
//        form.setSSN("853412609");
//        form.setBirthday(UtilFunction.getTodayDate());
//        form.setGender("Male");
//        form.setIsCitizenOrPerm("True");
//        form.setGreenCardOrCitizen("False");
//        form.setWorkAuth("Other");
//        form.setWorkAuthOther("UserInputString");
//        form.setWorkAuthOtherStart("2010-02-04");
//        form.setWorkAuthOtherEnd("2015-02-03");
//        form.setWorkAuthFile("test/printPage2.pdf");
//        form.setHasDriverLicense("abcdes12");
//        form.setDriverLicenseNumber("123456");
//        form.setDriverLicenseExpirationDate(UtilFunction.getTodayDate());
//
//        form.setReferred("True");
//        form.setReferFirstName("Dany");
//        form.setReferLastName("Liu");
//        form.setMiddleName("S.");
//        form.setReferPhone("3216540987");
//        form.setReferAddress("10 Milton road");
//        form.setReferEmail("bbb@gmail.com");
//        form.setReferRelationship("friend");
//
//        Map<String, String> clist1 = new HashMap<>();
//        clist1.put("emergencyContactFirstName","c1firstname");
//        clist1.put("emergencyContactLastName","c1lastname");
//        clist1.put("emergencyContactMiddleName","c1m");
//        clist1.put("emergencyContactPhone","1111111111");
//        clist1.put("emergencyContactEmail","c1email@mail.com");
//        clist1.put("emergencyContactRelationship","r1");
//
//        Map<String, String> clist2 = new HashMap<>();
//        clist2.put("emergencyContactFirstName","c2firstname");
//        clist2.put("emergencyContactLastName","c2lastname");
//        clist2.put("emergencyContactMiddleName","c2m");
//        clist2.put("emergencyContactPhone","2222222222");
//        clist2.put("emergencyContactEmail","c2email@mail.com");
//        clist2.put("emergencyContactRelationship","r2");
//
//        List clist = Arrays.asList(clist1, clist2);;
//        form.setEmergencyContacts(clist);
//
//        System.out.println(form);
//
//        onBoardingService observice= new onBoardingService();
//        observice.saveOnboardingData(form);

//        HousingAndFacilityReportService housingAndFacilityReportService = new HousingAndFacilityReportService();
//        System.out.println(housingAndFacilityReportService.getFacilityReportByUsername("Dany"));

//        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
//        System.out.println(employeeDao.getAllEmployeeInAHouseId(1));
//        List<Integer> a = Arrays.asList(1, 1011, 1012);
//        String str = "(";
//        for (int i : a){
//            str += i+",";
//        }
//        str = str.substring(0,str.lastIndexOf(","))+")";
//        System.out.println(str);
//
//        FacilityReportDaoImpl frdi = new FacilityReportDaoImpl();
//        System.out.println(
//                frdi.getFacilityReportByListOfEmployeeID(a)
//        );
//        System.out.println(
//                housingAndFacilityReportService.getFacilityReportByUsername("Dany")
//        );

public class selfTest {
    public static void main(String[] args) {
        HousingController hc = new HousingController();
//        System.out.println(
//                hc.addCommentToReport(3,"Dany","It broke again")
//        );
//        System.out.println(
//                hc.addReport("Dany","electricity out", "power issue")
//        );
//        System.out.println(
//                hc.editComment(4,"Raining indoor")
//        );
        System.out.println(
                hc.editReport(4,"issue solved", true)
        );
    }
}
