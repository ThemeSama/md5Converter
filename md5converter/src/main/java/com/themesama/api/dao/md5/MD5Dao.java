package com.themesama.api.dao.md5;

import com.themesama.api.dao.base.BaseDao;
import com.themesama.api.models.MD5Model;

import java.util.List;

public interface MD5Dao extends BaseDao {
    MD5Model getByKey(String key);
    MD5Model getByValue(String value);
    List<MD5Model> getLatest();
}
