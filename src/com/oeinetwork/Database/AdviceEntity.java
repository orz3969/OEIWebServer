package com.oeinetwork.Database;

import javax.persistence.*;

/**
 * Created by scotg_000 on 2015/7/17
 */
@Entity
@Table(name = "advice", schema = "", catalog = "oei")
public class AdviceEntity {
    private int id;
    private String contactM;
    private String voice;
    private long recordTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contact_m")
    public String getContactM() {
        return contactM;
    }

    public void setContactM(String contactM) {
        this.contactM = contactM;
    }

    @Basic
    @Column(name = "voice")
    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Basic
    @Column(name = "record_time")
    public long getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(long recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdviceEntity that = (AdviceEntity) o;

        if (id != that.id) return false;
        if (recordTime != that.recordTime) return false;
        if (contactM != null ? !contactM.equals(that.contactM) : that.contactM != null) return false;
        if (voice != null ? !voice.equals(that.voice) : that.voice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (contactM != null ? contactM.hashCode() : 0);
        result = 31 * result + (voice != null ? voice.hashCode() : 0);
        result = 31 * result + (int) (recordTime ^ (recordTime >>> 32));
        return result;
    }
}
