package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.foodapp.model.GIOHANG;
import com.example.foodapp.model.SANPHAM;
import com.example.foodapp.ui.home.HomeFragment;
import com.nex3z.notificationbadge.NotificationBadge;
import com.squareup.picasso.Picasso;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    NotificationBadge badge;

    Button btnAddtocard;
    ImageView btnBack;

    int soluong = 0;

    ImageView imgadd;
    ImageView imgtru;
    TextView tvsoluong;

    ImageView imghinhsp;
    TextView tensp;
    TextView giasp;

    SANPHAM sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);

        badge = findViewById(R.id.soluonggiohang);

        btnBack = findViewById(R.id.btnBack);
        imgadd = findViewById(R.id.imgAdd);
        imgtru = findViewById(R.id.imgtru);
        tvsoluong = findViewById(R.id.tvSoLuong);
        btnAddtocard=findViewById(R.id.btnAddCard);

        imghinhsp = findViewById(R.id.imghinhsp);
        tensp = findViewById(R.id.tvtensp);
        giasp = findViewById(R.id.tvgiasp);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietSanPhamActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        imgadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong++;
                tvsoluong.setText(String.valueOf(soluong));
            }
        });


        imgtru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soluong>0){
                    soluong--;
                    tvsoluong.setText(String.valueOf(soluong));
                }
            }
        });

        ///LẤY DỮ LIỆU
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String gia = intent.getStringExtra("gia");
        String hinh = intent.getStringExtra("hinh");

        ///GÁN DỮ LIỆU VÀO
        tensp.setText(name);
        giasp.setText(gia);
        Picasso.get().load(SEVER.imgsanpham+hinh).into(imghinhsp);

        btnAddtocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GIOHANG giohang = new GIOHANG(name, hinh, soluong,soluong);
                SEVER.manggiohang.add(giohang);
            }
        });

    }
}