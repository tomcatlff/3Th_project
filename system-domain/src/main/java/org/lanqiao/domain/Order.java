package org.lanqiao.domain;

import java.util.Date;

public class Order {
    private int oid;
    private Date otime;
    private int totalprice;
    private String ostate;
    private String bstate;

    public Order() {
    }

    public Order(Date otime, int totalprice, String ostate, String bstate) {
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

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
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
        return "Order{" +
                "oid=" + oid +
                ", otime=" + otime +
                ", totalprice=" + totalprice +
                ", ostate='" + ostate + '\'' +
                ", bstate='" + bstate + '\'' +
                '}';
    }
}
