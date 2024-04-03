package com.pharmacy.Admin;

public class AdminMedicinInfo {
    private String medicinName;
    private int quantity;

    public AdminMedicinInfo(String medicinName,int quantity){
        this.medicinName = medicinName;
        this.quantity = quantity;
    }

    public String getMedicinName() {
        return medicinName;
    }

    public void setMedicinName(String medicinName) {
        this.medicinName = medicinName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
