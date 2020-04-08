package com.example.septimatechapp;

public class ModelProducts {
    String pId, pImage, pName;

    public ModelProducts() {
    }

    public ModelProducts(String pName, String pImage) {
        //this.pId = pId;
        this.pName = pName;
        this.pImage = pImage;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }
}
