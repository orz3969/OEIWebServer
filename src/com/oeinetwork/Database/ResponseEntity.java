package com.oeinetwork.Database;

import javax.persistence.*;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/7/31.
 */

@Entity
@Table(name = "response", schema = "", catalog = "oeinetwork")
public class ResponseEntity {
    private int id;
    private String keyWord;
    private String responseType;
    private String responseObject;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "keyWord")
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Basic
    @Column(name = "responseType")
    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    @Basic
    @Column(name = "responseObject")
    public String getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(String responseObject) {
        this.responseObject = responseObject;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (keyWord != null ? keyWord.hashCode() : 0);
        result = 31 * result + (responseType != null ? responseType.hashCode() : 0);
        result = 31 * result + (responseObject != null ? responseObject.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseEntity that = (ResponseEntity) o;

        if (id != that.id) return false;
        if (keyWord != null ? !keyWord.equals(that.keyWord) : that.keyWord != null) return false;
        if (responseType != null ? !responseType.equals(that.responseType) : that.responseType != null) return false;
        if (responseObject != null ? !responseObject.equals(that.responseObject) : that.responseObject != null) return false;

        return true;
    }
}
