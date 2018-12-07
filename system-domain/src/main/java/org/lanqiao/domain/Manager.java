package org.lanqiao.domain;

public class Manager {
    private String mname;
    private  String mpassword;

    public Manager() {
    }

    public Manager(String mname, String mpassword) {
        this.mname = mname;
        this.mpassword = mpassword;
    }


    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }


    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mname='" + mname + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }
}
