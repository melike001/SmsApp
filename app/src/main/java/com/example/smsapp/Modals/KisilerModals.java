package com.example.smsapp.Modals;

public class KisilerModals {
    String img;
    String name;
    String no;

    public KisilerModals() {
    }

    public KisilerModals(String img, String name, String no) {
        this.img = img;
        this.name = name;
        this.no = no;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
