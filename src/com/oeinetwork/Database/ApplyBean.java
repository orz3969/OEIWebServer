package com.oeinetwork.Database;


/**
 * Created by scotg_000 on 2015/7/17
 */
public class ApplyBean {
    private String name;
    private String sex;
    private String dayOfBirth;
    private String politic;
    private String major;
    private String contact;
    private String firstApply;
    private String secondApply;
    private String thirdApply;
    private String selfIntroduction;
    private String workExp;
    private String futureVision;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFirstApply() {
        return firstApply;
    }

    public void setFirstApply(String firstApply) {
        this.firstApply = firstApply;
    }

    public String getSecondApply() {
        return secondApply;
    }

    public void setSecondApply(String secondApply) {
        this.secondApply = secondApply;
    }

    public String getThirdApply() {
        return thirdApply;
    }

    public void setThirdApply(String thirdApply) {
        this.thirdApply = thirdApply;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getFutureVision() {
        return futureVision;
    }

    public void setFutureVision(String futureVision) {
        this.futureVision = futureVision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyBean that = (ApplyBean) o;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (dayOfBirth != null ? !dayOfBirth.equals(that.dayOfBirth) : that.dayOfBirth != null) return false;
        if (politic != null ? !politic.equals(that.politic) : that.politic != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (firstApply != null ? !firstApply.equals(that.firstApply) : that.firstApply != null) return false;
        if (secondApply != null ? !secondApply.equals(that.secondApply) : that.secondApply != null) return false;
        if (thirdApply != null ? !thirdApply.equals(that.thirdApply) : that.thirdApply != null) return false;
        if (selfIntroduction != null ? !selfIntroduction.equals(that.selfIntroduction) : that.selfIntroduction != null)
            return false;
        if (workExp != null ? !workExp.equals(that.workExp) : that.workExp != null) return false;
        if (futureVision != null ? !futureVision.equals(that.futureVision) : that.futureVision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (dayOfBirth != null ? dayOfBirth.hashCode() : 0);
        result = 31 * result + (politic != null ? politic.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (firstApply != null ? firstApply.hashCode() : 0);
        result = 31 * result + (secondApply != null ? secondApply.hashCode() : 0);
        result = 31 * result + (thirdApply != null ? thirdApply.hashCode() : 0);
        result = 31 * result + (selfIntroduction != null ? selfIntroduction.hashCode() : 0);
        result = 31 * result + (workExp != null ? workExp.hashCode() : 0);
        result = 31 * result + (futureVision != null ? futureVision.hashCode() : 0);
        return result;
    }
}
