package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.ApplicationWorkFlow;
import com.hr.hrserver.pojo.Employee;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.util.CollectionUtils;

public class ApplicationWorkFlowDaoImpl extends BaseDaoImpl implements ApplicationWorkFlowDao{
    public ApplicationWorkFlowDaoImpl(){super(ApplicationWorkFlow.class);}

    @Override
    public ApplicationWorkFlow getAWFbyEmployeeID(int id) {
        Query query = getCurrentSession().createQuery("from ApplicationWorkFlow a where a.EmployeeID=:uid");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("uid", id);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        ApplicationWorkFlow a = (ApplicationWorkFlow)query.list().get(0);
        return  a;
    }
}
