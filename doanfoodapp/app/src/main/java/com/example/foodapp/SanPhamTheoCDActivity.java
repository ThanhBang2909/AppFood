package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.adapter.ADAPTER_SanPhamTheoChuDe;
import com.example.foodapp.model.SANPHAM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SanPhamTheoCDActivity extends AppCompatActivity {

    ADAPTER_SanPhamTheoChuDe adapter_sanPhamTheoChuDe;
    ArrayList<SANPHAM> datasanpham = new ArrayList<>();
    RecyclerView rvSanPhamTheoChuDe;
    ImageView imgback;
    String macd;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_theo_cdactivity);
        rvSanPhamTheoChuDe = findViewById(R.id.rvsanphamchude);
        imgback = findViewById(R.id.btnBack);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SanPhamTheoCDActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        intent = getIntent();
        macd = intent.getStringExtra("macd");
        LoadSanPhamTheoChuDe(macd);
    }

    public void LoadSanPhamTheoChuDe(String macd){
        String url = SEVER.sanphamtheochudepath+"?macd='"+macd+"'";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Response.Listener<JSONArray> thanhcong = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        datasanpham.add(new SANPHAM(jsonObject.getString("masp"),
                                jsonObject.getString("macd"),
                                jsonObject.getString("tensp"),
                                jsonObject.getString("hinhsp"),
                                jsonObject.getInt("giasp"),
                                jsonObject.getString("mota")));
                    } catch (JSONException e) {
                        Toast.makeText(SanPhamTheoCDActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        };
        Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SanPhamTheoCDActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);

        adapter_sanPhamTheoChuDe = new ADAPTER_SanPhamTheoChuDe(this, datasanpham);
        rvSanPhamTheoChuDe.setAdapter(adapter_sanPhamTheoChuDe);
        rvSanPhamTheoChuDe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }
}