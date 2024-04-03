package com.pharmacy.Admin;

public class Administrator {
    private String password,storeName,gmail;

    public Administrator(String storeName,String password,String gmail){
        this.storeName = storeName;
        this.password = password;
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
