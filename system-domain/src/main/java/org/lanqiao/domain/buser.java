package org.lanqiao.domain;

public class buser {
    private String uname;
    private String password;
    private String phone;
    private String address;

    public buser() {
    }

    public buser(String uname, String password, String phone, String address) {
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.address = address;
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

    @Override
    public String toString() {
        return "buser{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
