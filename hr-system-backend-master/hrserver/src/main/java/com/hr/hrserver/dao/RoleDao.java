package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.Role;

public interface RoleDao {
    public Role getRoleByID(int rid);
    public String getRoleNameByID(int rid);
}
