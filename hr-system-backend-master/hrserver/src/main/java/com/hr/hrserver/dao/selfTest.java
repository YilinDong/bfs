package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.*;
import com.hr.hrserver.service.HousingAndFacilityReportService;
import com.hr.hrserver.util.UtilFunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class selfTest {
    public static void main(String[] args) throws ParseException {

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

        HousingAndFacilityReportService hFRS = new HousingAndFacilityReportService();
        System.out.println(hFRS.getHouseDetailByEmployeeID(1).address.getAddressLine1());
        System.out.println(hFRS.getHouseDetailByEmployeeID(1).address.getAddressLine2());
        for(Occupant o: hFRS.getHouseDetailByEmployeeID(1).occupantList)
            System.out.println(o.name + "/////" + o.phoneNumber);

//        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
//        System.out.println(employeeDaoImpl.getSomeInfoByHouseID(1).CellPhone);

    }
}
