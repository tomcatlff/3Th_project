package org.lanqiao.domain;

public class OstateSort {
    private int ostateid;
    private String ostate;

    public OstateSort() {
    }

    public OstateSort(String ostate) {
        this.ostate = ostate;
    }

    public OstateSort(int ostateid, String ostate) {
        this.ostateid = ostateid;
        this.ostate = ostate;
    }

    public int getOstateid() {
        return ostateid;
    }

    public void setOstateid(int ostateid) {
        this.ostateid = ostateid;
    }

    public String getOstate() {
        return ostate;
    }

    public void setOstate(String ostate) {
        this.ostate = ostate;
    }

    @Override
    public String toString() {
        return "OstateSort{" +
                "ostateid=" + ostateid +
                ", ostate='" + ostate + '\'' +
                '}';
    }
}
