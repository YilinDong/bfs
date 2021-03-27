package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.Address;

public interface AddressDao {
    public Address getAddressByEmployeeID(int id);
}
