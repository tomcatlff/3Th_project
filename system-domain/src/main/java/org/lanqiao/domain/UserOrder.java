package org.lanqiao.domain;

public class UserOrder {
    private int oid;
    private String uname;
    private String phone;
    private String address;
    private String otime;
    private String totalprice;
    private String ostate;
    private String bstate;

    public UserOrder() {
    }

    public UserOrder(String uname, String phone, String address, String otime, String totalprice, String ostate, String bstate) {
        this.uname = uname;
        this.phone = phone;
        this.address = address;
        this.otime = otime;
        this.totalprice = totalprice;
        this.ostate = ostate;
        this.bstate = bstate;
    }

    public UserOrder(int oid, String uname, String phone, String address, String otime, String totalprice, String ostate, String bstate) {
        this.oid = oid;
        this.uname = uname;
        this.phone = phone;
        this.address = address;
        this.otime = otime;
        this.totalprice = totalprice;
        this.ostate = ostate;
        this.bstate = bstate;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getOstate() {
        return ostate;
    }

    public void setOstate(String ostate) {
        this.ostate = ostate;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "oid=" + oid +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", otime='" + otime + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", ostate='" + ostate + '\'' +
                ", bstate='" + bstate + '\'' +
                '}';
    }
}
