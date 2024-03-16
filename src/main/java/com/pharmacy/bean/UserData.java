package com.pharmacy.bean;

public class UserData {
   private String name,gmail,address,phone,password,code;
    public UserData(String name, String gmail, String address, String phone, String password,String code){
        this.name = name;
        this.gmail = gmail;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGmail(String gmail){
        this.gmail = gmail;
    }
    public String getGmail(){
        return gmail;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }

    public String encryptionData(String data){
        String encData = "";
        return encData;
    }

    public String decryptionData(String data){
        String decData = "";
        return  decData;
    }

}
