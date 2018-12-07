package org.lanqiao.domain;

public class User {
    private int uid;
    private String uname;
    private String password;
    private String phone;
    private String address;
    private String wallet;

    public User() {
    }

    public User(String uname, String password, String phone, String address, String wallet) {
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.wallet = wallet;
    }

    public User(int uid, String uname, String password, String phone, String address, String wallet) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.wallet = wallet;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", wallet='" + wallet + '\'' +
                '}';
    }
}
