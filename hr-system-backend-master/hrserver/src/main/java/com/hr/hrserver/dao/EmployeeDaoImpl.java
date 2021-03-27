package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.Employee;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao{

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Override
    public Employee getEmployeeByUserId(int id) {
        Query query = getCurrentSession().createQuery("from Employee e where e.UserID=:uid");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("uid", id);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        Employee e = (Employee)query.list().get(0);
        return  e ;
    }

    public Employee getEmployeeByUserEmail(String email) {
        Query query = getCurrentSession().createQuery("from Employee e where e.Email=:email");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("email", email);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        Employee e = (Employee)query.list().get(0);
        return  e ;
    }

    public List<Employee> testDao(){
        String email="admin@gmail.com";
        Query query = getCurrentSession().createQuery("from Employee e where e.Email=:email");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("email", email);
//        if(CollectionUtils.isEmpty(query.list())) {
//            return null;
//        }
        List<Employee> e = query.list();
        tx.commit();
        return e;
    }

}
