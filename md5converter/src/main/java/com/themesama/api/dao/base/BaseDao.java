package com.themesama.api.dao.base;

import com.themesama.api.models.MD5Model;

public interface BaseDao {

    MD5Model saveOrUpdate(MD5Model md5Model);

    void update(MD5Model md5Model);

    void delete(MD5Model md5Model);

    void persist(MD5Model md5Model);

    MD5Model merge(MD5Model md5Model);

}