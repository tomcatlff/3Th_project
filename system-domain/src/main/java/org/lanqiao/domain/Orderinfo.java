package org.lanqiao.domain;

import java.util.List;

public class Orderinfo {
    private int oid;
    private String bname;
    private String bimg;
    private Double price;
    private int bookcount;
    private String uname;
    private String address;
    private String phone;
    private Double tatolprice;
    private int ostateid;
    private int bstateid;
    private String ostate;
    private String bstate;

    public Orderinfo() {
    }

    public Orderinfo(int oid, String bname, String bimg, Double price, int bookcount, String uname, String address, String phone, Double tatolprice, int ostateid, int bstateid, String ostate, String bstate) {
        this.oid = oid;
        this.bname = bname;
        this.bimg = bimg;
        this.price = price;
        this.bookcount = bookcount;
        this.uname = uname;
        this.address = address;
        this.phone = phone;
        this.tatolprice = tatolprice;
        this.ostateid = ostateid;
        this.bstateid = bstateid;
        this.ostate = ostate;
        this.bstate = bstate;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getBookcount() {
        return bookcount;
    }

    public void setBookcount(int bookcount) {
        this.bookcount = bookcount;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getTatolprice() {
        return tatolprice;
    }

    public void setTatolprice(Double tatolprice) {
        this.tatolprice = tatolprice;
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

    public int getOstateid() {
        return ostateid;
    }

    public void setOstateid(int ostateid) {
        this.ostateid = ostateid;
    }

    public int getBstateid() {
        return bstateid;
    }

    public void setBstateid(int bstateid) {
        this.bstateid = bstateid;
    }

    @Override
    public String toString() {
        return "Orderinfo{" +
                "oid=" + oid +
                ", bname='" + bname + '\'' +
                ", bimg='" + bimg + '\'' +
                ", price=" + price +
                ", bookcount=" + bookcount +
                ", uname='" + uname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", tatolprice=" + tatolprice +
                ", ostateid=" + ostateid +
                ", bstateid=" + bstateid +
                ", ostate='" + ostate + '\'' +
                ", bstate='" + bstate + '\'' +
                '}';
    }
}
