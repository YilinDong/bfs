package com.hr.hrserver.service;

import com.hr.hrserver.dao.*;
import com.hr.hrserver.pojo.*;
import com.hr.hrserver.util.UtilFunction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
class FacilityReportForm{
    int employeeID;
    String title;
    String description;
}
@Getter
@Setter
@NoArgsConstructor
class FacilityReportDetailForm{
    int reportID;
    int employeeID;
    String Comment;
}

public class HousingAndFacilityReportService {

    public int addNewReport(Map<Object, Object> facilityReportInput){
        FacilityReportForm fRF = (FacilityReportForm) facilityReportInput;

        //add to form FacilityReport
        FacilityReport facilityReport = new FacilityReport();
        facilityReport.setTitle(fRF.title);
        facilityReport.setEmployeeID(fRF.employeeID);
        facilityReport.setReportDate(UtilFunction.getTodayDate());
        facilityReport.setDescription(fRF.description);
        facilityReport.setStatus("Open");

        FacilityReportDaoImpl fRDI = new FacilityReportDaoImpl();
        int reportID = (int) fRDI.save(facilityReport);

        return reportID;
        //add to form FacilityReportDetail
    }

    public int addNewCommentToReport(Map<Object, Object> FacilityReportDetailInput){
        FacilityReportDetailForm fRDF = (FacilityReportDetailForm) FacilityReportDetailInput;

        //find report create date
        FacilityReportDaoImpl fRDI = new FacilityReportDaoImpl();
        Date reportDate = fRDI.getReportDateByID(fRDF.reportID);

        //assemble object and save to table FacilityReportDetail
        FacilityReportDetail fRDObject = new FacilityReportDetail();
        fRDObject.setReportID(fRDF.reportID);
        fRDObject.setEmployeeID(fRDF.employeeID);
        fRDObject.setComment(fRDF.Comment);
        fRDObject.setCreatedDate(reportDate);
        fRDObject.setLastModificationDate(UtilFunction.getTodayDate());

        FacilityReportDetailDaoImpl fRDDI = new FacilityReportDetailDaoImpl();
        return (int) fRDDI.save(fRDObject);
    }

    public HouseDetail getHouseDetailByEmployeeID(int eID){
        HouseDetail houseDetail = new HouseDetail();

        //get HouseID from table Employee using eID
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee employee = (Employee) employeeDao.get(eID);
        int houseID = employee.getHouseID();

        //get Address column (which refers to Address.ID) from House using House.ID
        //And set Address Object to houseDetail
        HouseDaoImpl houseDao = new HouseDaoImpl();
        House house = houseDao.getHouseByID(houseID);
        AddressDaoImpl addressDao = new AddressDaoImpl();
        //assign to houseDetail
        houseDetail.address=
                (Address) addressDao.get(
                        house.getAddressID()
                );

        //in Employee table find all column with this same HouseID,
        // retrieve their FirstName,PreferredName, cellPhone as a list
        List<OccupantRaw> returnList = employeeDao.getSomeInfoByHouseID(1);
        System.out.println(returnList.get(0).getClass());
        List<Occupant> oList = new ArrayList<>();
        for(OccupantRaw o : returnList){
            Occupant newOccu = new Occupant();
            newOccu.name = o.PreferredName==""? o.FirstName : o.PreferredName;
            newOccu.phoneNumber = o.CellPhone;
            oList.add(newOccu);
        }
        //assign to houseDetail
        houseDetail.occupantList=oList;

        return houseDetail;
    }

}
