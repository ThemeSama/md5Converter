package com.themesama.api.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
 * Model vasitasiyla yapilacak HQL sorgulari
 */
@NamedQueries({
        @NamedQuery(
                name = "getByKey",
                query = "from MD5Model m where m.key = :key"
        ),
        @NamedQuery(
                name = "getByValue",
                query = "from MD5Model m where m.md5 = :md5"
        ),
        @NamedQuery(
                name = "getLatest",
                query = "from MD5Model m order by m.accessDate desc"
        )
})
@Entity
@Table(name = "tbl_md5")
/*
 * MD5 Tablo Modeli
 *
 */
public class MD5Model implements Serializable{

    private long id;
    private String key;
    private String md5;
    private Date accessDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    public long getId() {
        return id;
    }

    @Column(name = "md5_key", nullable=false)
    public String getKey() {
        return key;
    }

    @Column(name = "md5_value", nullable=false)
    public String getMd5() {
        return md5;
    }

    @Column(name = "md5_date", nullable=false)
    public Date getAccessDate() {
        return accessDate;
    }

    public MD5Model setId(long id) {
        this.id = id;
        return this;
    }

    public MD5Model setKey(String key) {
        this.key = key;
        return this;
    }

    public MD5Model setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public MD5Model setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
        return this;
    }
}
