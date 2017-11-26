package com.themesama.api.dao.md5.impl;

import com.themesama.api.dao.base.impl.BaseDaoImpl;
import com.themesama.api.dao.md5.MD5Dao;
import com.themesama.api.models.MD5Model;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/*
 * Modele ozel veritabani islemleri - Ozel sorgulari icerir. HQL bilgisini modelden alir
 */
@Repository
public class MD5DaoImpl extends BaseDaoImpl implements MD5Dao {

    @Override
    public MD5Model getByKey(String key) {
        Session session = getFactory().openSession();
        Query query = session.getNamedQuery("getByKey");
        query.setParameter("key", key);
        MD5Model md5Model;

        try {
            md5Model = (MD5Model) query.getSingleResult();
        } catch (NoResultException e) {
            //
            md5Model = new MD5Model();
            md5Model.setMd5("");
            md5Model.setKey(key);
        } finally {
            session.close();
        }

        return md5Model;
    }

    @Override
    public MD5Model getByValue(String md5) {
        Session session = getFactory().openSession();
        Query query = session.getNamedQuery("getByValue");
        query.setParameter("md5", md5);
        MD5Model md5Model;

        try {
            md5Model = (MD5Model) query.getSingleResult();
        } catch (NoResultException e) {
            //
            md5Model = new MD5Model();
            md5Model.setMd5(md5);
            md5Model.setKey("");
        } finally {
            session.close();
        }

        return md5Model;
    }

    @Override
    public List<MD5Model> getLatest() {
        Session session = getFactory().openSession();
        Query query = session.getNamedQuery("getLatest");
        query.setFirstResult(0);
        query.setMaxResults(10);
        List<MD5Model> md5ModelList = query.getResultList();
        session.close();
        return md5ModelList;
    }
}
