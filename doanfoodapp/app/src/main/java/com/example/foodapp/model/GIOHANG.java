package com.example.foodapp.model;

public class GIOHANG {
    public String tensp, hinhsp;
    public int soluong, thanhtien;

    public GIOHANG(String tensp, String hinhsp, int soluong, int thanhtien) {
        this.tensp = tensp;
        this.hinhsp = hinhsp;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhsp() {
        return hinhsp;
    }

    public void setHinhsp(String hinhsp) {
        this.hinhsp = hinhsp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
}
