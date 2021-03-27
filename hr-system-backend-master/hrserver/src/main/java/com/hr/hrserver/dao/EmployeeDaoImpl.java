package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.Employee;
import com.hr.hrserver.pojo.OccupantRaw;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

    //Given a HouseID retrieve employee's FirstName, PreferredName, and cellPhone as a list
    public List<OccupantRaw> getSomeInfoByHouseID(int hID){
        String qry = "Select FirstName, PreferredName, CellPhone from Employee Where HouseID="+hID+"";
        Query query = getCurrentSession().createSQLQuery(qry);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        List<OccupantRaw> result = new ArrayList<>();
        for (int i=0;i<query.list().size();i++){
            OccupantRaw oR = new OccupantRaw();
            Object[] le = (Object[]) query.list().get(i);
            oR.FirstName = le[0].toString();
            oR.PreferredName = le[1].toString();
            oR.CellPhone = le[2].toString();
            result.add(oR);
        }
        return result;
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
