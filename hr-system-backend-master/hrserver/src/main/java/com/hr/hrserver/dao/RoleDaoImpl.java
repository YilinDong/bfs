package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.Role;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.util.CollectionUtils;

public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public Role getRoleByID(int rid) {
        Query query = getCurrentSession().createQuery("from Role r where r.ID=:rid");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("rid", rid);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        return (Role) query.list().get(0);
    }

    @Override
    public String getRoleNameByID(int rid) {
        Query query = getCurrentSession().createQuery("from Role r where r.ID=:rid");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("rid", rid);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        return ((Role) query.list().get(0)).RoleName;
    }
}
