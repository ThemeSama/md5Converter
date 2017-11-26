package com.themesama.api.controller;

import com.themesama.api.models.MD5Model;
import com.themesama.api.services.md5.MD5Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

/*
 * Rest Taleplerini Karsilayacak Sinif
 * Icerisinde tuketecegimiz servisi ve HTTP protokolu ile yapilan taleplere cevap veren metotlari barindirir
 */
@RestController
public class MainController {

    @Autowired
    private MD5Service md5Service;

    @RequestMapping("/")
    public String home(){
        return "Welcome to MD5 Converter!";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping( value= "/key/{key}", method = RequestMethod.GET )
    public MD5Model md5Key(@PathVariable("key") String key) {

        MD5Model md5Model  = md5Service.getByKey(key);
        md5Model.setAccessDate(new Date());
        if( md5Model.getMd5().equals("") ) {
            md5Model.setMd5(DigestUtils.md5Hex(key));
        }
        md5Service.saveOrUpdate(md5Model);

        return md5Model;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping( value= "/md5/{md5}", method = RequestMethod.GET )
    public MD5Model md5Value(@PathVariable("md5") String md5) {

        MD5Model md5Model = md5Service.getByValue(md5);
        if( !md5Model.getKey().equals("") ) {
            md5Model.setAccessDate(new Date());
            md5Service.saveOrUpdate(md5Model);
        }

        return md5Model;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/latest")
    public List<MD5Model> md5Latest() {
        return md5Service.getLatest();
    }
}
