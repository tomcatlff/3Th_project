package org.lanqiao.domain;

public class BookSort {
   private int bsortno;
   private String bsort;

    public BookSort() {
    }

    public BookSort(String bsort) {
        this.bsort = bsort;
    }

    public int getBsortno() {
        return bsortno;
    }

    public void setBsortno(int bsortno) {
        this.bsortno = bsortno;
    }

    public String getBsort() {
        return bsort;
    }

    public void setBsort(String bsort) {
        this.bsort = bsort;
    }

    @Override
    public String toString() {
        return "BookSort{" +
                "bsortno=" + bsortno +
                ", bsort='" + bsort + '\'' +
                '}';
    }
}
