package org.lanqiao.domain;

public class Condation {
    private String serBname;
    private String serBsort;

    public Condation() {
    }

    public Condation(String serBname, String serBsort) {
        this.serBname = serBname;
        this.serBsort = serBsort;
    }

    public Condation(String serBname) {
        this.serBname = serBname;
    }

    public String getSerBname() {
        return serBname;
    }

    public void setSerBname(String serBname) {
        this.serBname = serBname;
    }

    public String getSerBsort() {
        return serBsort;
    }

    public void setSerBsort(String serBsort) {
        this.serBsort = serBsort;
    }

    @Override
    public String toString() {
        return "Condation{" +
                "serBname='" + serBname + '\'' +
                ", serBsort='" + serBsort + '\'' +
                '}';
    }
}
