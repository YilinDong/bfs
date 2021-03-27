package com.hr.hrserver.dao;

import com.hr.hrserver.pojo.DigitalDocument;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.util.CollectionUtils;

public class DigitalDocumentDaoImpl extends BaseDaoImpl implements DigitalDocumentDao {

    public DigitalDocumentDaoImpl() {
        super(DigitalDocument.class);
    }

    @Override
    public DigitalDocument getDigitalDocumentByType(String type){
        Query query = getCurrentSession().createQuery("from DigitalDocument d where d.type=:type");
        Transaction tx = getCurrentSession().beginTransaction();
        query.setParameter("type", type);
        if(CollectionUtils.isEmpty(query.list())) {
            return null;
        }
        return (DigitalDocument) query.list().get(0);
    }
}
