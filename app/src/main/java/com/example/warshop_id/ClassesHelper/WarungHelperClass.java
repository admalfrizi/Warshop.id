package com.example.warshop_id.ClassesHelper;

public class WarungHelperClass {

    int imagelist;
    String  namelist, price ;

    public WarungHelperClass(int imagelist, String namelist, String price) {
        this.imagelist = imagelist;
        this.namelist = namelist;
        this.price = price;
    }

    public int getImagelist() {
        return imagelist;
    }

    public void setImagelist(int imagelist) {
        this.imagelist = imagelist;
    }

    public String getNamelist() {
        return namelist;
    }

    public void setNamelist(String namelist) {
        this.namelist = namelist;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
