package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.Facility;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.util.CollectionUtils;

public class FacilityDaoImpl extends BaseDaoImpl implements FacilityDao{

    public FacilityDaoImpl() {
        super(Facility.class);
    }

    @Override
    public Facility getFacilityByHouseID(int hid) {
        Query query = getCurrentSession().createQuery("from Facility f where f.HouseID=:hid");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("hid", hid);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        tx.commit();
        return (Facility) query.list().get(0);
    }
}
