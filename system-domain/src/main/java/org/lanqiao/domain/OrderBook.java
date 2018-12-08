package org.lanqiao.domain;

public class OrderBook {
    private int oid;
    private String bname;
    private int bstateid;
    private String bstate;

    public OrderBook() {
    }

    public OrderBook(String bname, int bstateid, String bstate) {
        this.bname = bname;
        this.bstateid = bstateid;
        this.bstate = bstate;
    }

    public OrderBook(int oid, String bname, int bstateid, String bstate) {
        this.oid = oid;
        this.bname = bname;
        this.bstateid = bstateid;
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

    public int getBstateid() {
        return bstateid;
    }

    public void setBstateid(int bstateid) {
        this.bstateid = bstateid;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "oid=" + oid +
                ", bname='" + bname + '\'' +
                ", bstateid=" + bstateid +
                ", bstate='" + bstate + '\'' +
                '}';
    }
}
