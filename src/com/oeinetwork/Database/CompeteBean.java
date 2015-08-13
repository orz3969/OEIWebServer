package com.oeinetwork.Database;

/**
 * Created by Orz on 2015/8/13
 */
public class CompeteBean {
    private String Name;
    private String ClassName;
    private String PhoneNumber;
    private String QQNumber;
    private String Group;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getQQNumber() {
        return QQNumber;
    }

    public void setQQNumber(String QQNumber) {
        this.QQNumber = QQNumber;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }
}
