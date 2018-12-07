package org.lanqiao.domain;

public class Book {
    private int bid;
    private int bsortno;
    private String bimg;
    private String bname;
    private String author;
    private String publishing;
    private String pubtime;
    private Double price;
    private String info;
    private int bcount;

    public Book() {
    }

    public Book(int bsortno, String bimg, String bname, String author, String publishing, String pubtime, Double price, String info, int bcount) {
        this.bsortno = bsortno;
        this.bimg = bimg;
        this.bname = bname;
        this.author = author;
        this.publishing = publishing;
        this.pubtime = pubtime;
        this.price = price;
        this.info = info;
        this.bcount = bcount;
    }

    public Book(int bid, int bsortno, String bimg, String bname, String author, String publishing, String pubtime, Double price, String info, int bcount) {
        this.bid = bid;
        this.bsortno = bsortno;
        this.bimg = bimg;
        this.bname = bname;
        this.author = author;
        this.publishing = publishing;
        this.pubtime = pubtime;
        this.price = price;
        this.info = info;
        this.bcount = bcount;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBsortno() {
        return bsortno;
    }

    public void setBsortno(int bsortno) {
        this.bsortno = bsortno;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public String getBaname() {
        return bname;
    }

    public void setBaname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getBcount() {
        return bcount;
    }

    public void setBcount(int bcount) {
        this.bcount = bcount;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bsortno=" + bsortno +
                ", bimg='" + bimg + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", publishing='" + publishing + '\'' +
                ", pubtime='" + pubtime + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", bcount=" + bcount +
                '}';
    }
}
