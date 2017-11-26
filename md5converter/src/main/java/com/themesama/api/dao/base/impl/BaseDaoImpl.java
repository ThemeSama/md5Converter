package com.themesama.api.dao.base.impl;

import com.themesama.api.dao.base.BaseDao;
import com.themesama.api.models.MD5Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Temel Veritabani Islemleri
 */
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public MD5Model saveOrUpdate(MD5Model md5Model) {
        Session session = getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(md5Model);
        transaction.commit();
        session.close();
        return md5Model;
    }

    @Override
    public void update(MD5Model md5Model) {
        getFactory().openSession().update(md5Model);
    }

    @Override
    public void delete(MD5Model md5Model) {
        getFactory().openSession().delete(md5Model);
    }

    @Override
    public void persist(MD5Model md5Model) {
        getFactory().openSession().persist(md5Model);
    }

    @Override
    public MD5Model merge(MD5Model md5Model) {

        return (MD5Model) getFactory().openSession().merge(md5Model);
    }

    //GETTER
    public SessionFactory getFactory() {
        return factory;
    }
}