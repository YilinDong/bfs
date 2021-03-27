package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.FacilityReport;
import com.hr.hrserver.pojo.FacilityReportDetail;

import java.util.Date;
import java.util.List;

public interface FacilityReportDao {
    public List<FacilityReport> getFacilityReportByEmployeeID(int eid);
    public List<FacilityReportDetail> getFacilityReportDetailByFacilityReportID(int fReportId);
    public Date getReportDateByID(int fReportId);
}
