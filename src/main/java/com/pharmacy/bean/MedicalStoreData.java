package com.pharmacy.bean;

public class MedicalStoreData {
    private String name,address,phoneNo,longitude,latitude,about,presentStatus;
    private long distance,duration;
    private int storeId;

    public MedicalStoreData(String name, String address, String phoneNo, String latitude, String longitude, String about){
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.about = about;
        distance = 0;
        duration = 0;
        presentStatus = null;
        storeId = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getPresentStatus() {
        return presentStatus;
    }

    public void setPresentStatus(String presentStatus) {
        this.presentStatus = presentStatus;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
