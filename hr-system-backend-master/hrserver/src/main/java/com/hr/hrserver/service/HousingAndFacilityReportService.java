package com.hr.hrserver.service;

import com.hr.hrserver.dao.FacilityReportDaoImpl;
import com.hr.hrserver.dao.FacilityReportDetailDaoImpl;
import com.hr.hrserver.dao.HouseDaoImpl;
import com.hr.hrserver.pojo.FacilityReport;
import com.hr.hrserver.pojo.FacilityReportDetail;
import com.hr.hrserver.util.UtilFunction;

import java.util.Date;
import java.util.Map;

class FacilityReportForm{
    int employeeID;
    String title;
    String description;
}
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

}
