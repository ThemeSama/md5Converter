package com.themesama.api.services.md5.impl;

import com.themesama.api.dao.md5.MD5Dao;
import com.themesama.api.models.MD5Model;
import com.themesama.api.services.md5.MD5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * Veritabanini nesnelestirdikten sonra controller icerisinden erisimi saglayan servis
 */
@Transactional
@Service("MD5Service")
public class MD5ServiceImpl implements MD5Service {
    @Autowired
    private MD5Dao md5Dao;

    @Override
    public MD5Model getByKey(String key) {
        return md5Dao.getByKey(key);
    }

    @Override
    public MD5Model getByValue(String value) {
        return md5Dao.getByValue(value);
    }

    @Override
    public void saveOrUpdate(MD5Model md5Model) {
        md5Dao.saveOrUpdate(md5Model);
    }

    @Override
    public List<MD5Model> getLatest() {
        return md5Dao.getLatest();
    }

    //GETTER
    public MD5Dao getMd5Dao() {
        return md5Dao;
    }
}
