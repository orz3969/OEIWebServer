package com.oeinetwork.Database;

import javax.persistence.*;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/8/11.
 */
@Entity
@Table(name = "activity", schema = "", catalog = "oei")
public class ActivityEntity {
    private int id;
    private String activityName;
    private String activityData;
    private long recordTime;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "activityName", nullable = false, insertable = true, updatable = true, length = 255)
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Basic
    @Column(name = "activityData", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getActivityData() {
        return activityData;
    }

    public void setActivityData(String activityData) {
        this.activityData = activityData;
    }

    @Basic
    @Column(name = "recordTime", nullable = false, insertable = true, updatable = true)
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

        ActivityEntity that = (ActivityEntity) o;

        if (id != that.id) return false;
        if (recordTime != that.recordTime) return false;
        if (activityName != null ? !activityName.equals(that.activityName) : that.activityName != null) return false;
        if (activityData != null ? !activityData.equals(that.activityData) : that.activityData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (activityName != null ? activityName.hashCode() : 0);
        result = 31 * result + (activityData != null ? activityData.hashCode() : 0);
        result = 31 * result + (int) (recordTime ^ (recordTime >>> 32));
        return result;
    }
}
