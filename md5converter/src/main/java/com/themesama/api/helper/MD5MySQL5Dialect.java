package com.themesama.api.helper;

import org.hibernate.dialect.MySQL5Dialect;

/*
 * MySQL icin tablo ve sutunların UTF-8 destegi
 *
 */
public class MD5MySQL5Dialect extends MySQL5Dialect{
    @Override
    public String getTableTypeString() {
        return " DEFAULT CHARSET=utf8";
    }
}
