package com.oeinetwork.Database;

import javax.persistence.*;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/8/11.
 */
@Entity
@Table(name = "response", schema = "", catalog = "oeinetwork")
public class ResponseEntity {
    private int id;
    private String keyWord;
    private String responseType;
    private String responseObject;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "keyWord", nullable = true, insertable = true, updatable = true, length = 255)
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Basic
    @Column(name = "responseType", nullable = true, insertable = true, updatable = true, length = 255)
    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    @Basic
    @Column(name = "responseObject", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(String responseObject) {
        this.responseObject = responseObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseEntity entity = (ResponseEntity) o;

        if (id != entity.id) return false;
        if (keyWord != null ? !keyWord.equals(entity.keyWord) : entity.keyWord != null) return false;
        if (responseType != null ? !responseType.equals(entity.responseType) : entity.responseType != null)
            return false;
        if (responseObject != null ? !responseObject.equals(entity.responseObject) : entity.responseObject != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (keyWord != null ? keyWord.hashCode() : 0);
        result = 31 * result + (responseType != null ? responseType.hashCode() : 0);
        result = 31 * result + (responseObject != null ? responseObject.hashCode() : 0);
        return result;
    }
}
