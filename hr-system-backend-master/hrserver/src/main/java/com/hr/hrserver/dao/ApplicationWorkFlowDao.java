package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.ApplicationWorkFlow;

public interface ApplicationWorkFlowDao {
    ApplicationWorkFlow getAWFbyEmployeeID(int id);
}
