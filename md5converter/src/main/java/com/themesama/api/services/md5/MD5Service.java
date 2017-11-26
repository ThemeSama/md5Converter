package com.themesama.api.services.md5;

import com.themesama.api.models.MD5Model;

import java.util.List;

public interface MD5Service {

    MD5Model getByKey(String key);
    MD5Model getByValue(String value);
    List<MD5Model> getLatest();

    void saveOrUpdate(MD5Model md5Model);
}
