package com.example.foodapp;

import com.example.foodapp.model.GIOHANG;

import java.util.ArrayList;
import java.util.List;

public class SEVER {
    public static String serverip = "http://192.168.44.101";
    public static String chudepath = serverip + ":8080/sqlfood/laychude.php";
    public static String sanphampath = serverip + ":8080/sqlfood/laysanpham.php";
    public static String slidepath = serverip + ":8080/sqlfood/slide/";
    public static String imgpath = serverip + ":8080/sqlfood/chude/";
    public static String imgsanpham = serverip + ":8080/sqlfood/sanpham/";
    public static String sanphamtheochudepath = serverip +":8080/sqlfood/sanphamtheochude.php";

    public static ArrayList<GIOHANG> manggiohang;

}