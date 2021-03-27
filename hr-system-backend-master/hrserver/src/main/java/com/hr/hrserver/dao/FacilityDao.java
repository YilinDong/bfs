package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.Facility;

public interface FacilityDao {
    Facility getFacilityByHouseID(int hid);
}
