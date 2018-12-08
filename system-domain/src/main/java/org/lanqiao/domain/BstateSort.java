package org.lanqiao.domain;

public class BstateSort {
    private int bstateid;
    private String bstate;

    public BstateSort() {
    }

    public BstateSort(String bstate) {
        this.bstate = bstate;
    }

    public BstateSort(int bstateid, String bstate) {
        this.bstateid = bstateid;
        this.bstate = bstate;
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
        return "BstateSort{" +
                "bstateid=" + bstateid +
                ", bstate='" + bstate + '\'' +
                '}';
    }
}
