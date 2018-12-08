package org.lanqiao.domain;

public class Books {
    private int bid;
    private String bsort;
    private String bimg;
    private String bname;

    public Books() {
    }

    public Books(String bsort, String bimg, String bname) {
        this.bsort = bsort;
        this.bimg = bimg;
        this.bname = bname;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBsort() {
        return bsort;
    }

    public void setBsort(String bsort) {
        this.bsort = bsort;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bid=" + bid +
                ", bsort='" + bsort + '\'' +
                ", bimg='" + bimg + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }
}
