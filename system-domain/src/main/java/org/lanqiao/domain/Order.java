package org.lanqiao.domain;

import java.util.Date;

public class Order {
    private int oid;
    private Date otime;
    private double totalprice;
    private String ostate;
    private String bstate;
    private int count;
    private String phone;
    private String address;
    private String bimg;
    private String uname;
    private String bname;
    private Double price;

    public Order() {
    }

    public Order(Date otime, double totalprice, String ostate, String bstate, int count, String phone, String address, String bimg, String uname, String bname, Double price) {
        this.otime = otime;
        this.totalprice = totalprice;
        this.ostate = ostate;
        this.bstate = bstate;
        this.count = count;
        this.phone = phone;
        this.address = address;
        this.bimg = bimg;
        this.uname = uname;
        this.bname = bname;
        this.price = price;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", otime=" + otime +
                ", totalprice=" + totalprice +
                ", ostate='" + ostate + '\'' +
                ", bstate='" + bstate + '\'' +
                ", count=" + count +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", bimg='" + bimg + '\'' +
                ", uname='" + uname + '\'' +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                '}';
    }
}
