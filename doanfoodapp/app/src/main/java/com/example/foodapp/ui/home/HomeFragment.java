package com.example.foodapp.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.R;
import com.example.foodapp.SEVER;
import com.example.foodapp.adapter.ADAPTER_CHUDESANPHAM;
import com.example.foodapp.adapter.ADAPTER_SANPHAM;
import com.example.foodapp.model.CHUDE_SANPHAM;
import com.example.foodapp.model.GIOHANG;
import com.example.foodapp.model.SANPHAM;
import com.example.foodapp.slides.ADAPTER_SLIDES;
import com.example.foodapp.slides.HINH_SLIDES;
import com.nex3z.notificationbadge.NotificationBadge;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    EditText home_editseach;
    NotificationBadge badge;


    ADAPTER_CHUDESANPHAM adapter_chudesanpham;
    ArrayList<CHUDE_SANPHAM> datachude = new ArrayList<>();
    RecyclerView rvChuDeSP;

    ADAPTER_SANPHAM adapter_sanpham;
    ArrayList<SANPHAM> datasanpham = new ArrayList<>();
    RecyclerView rvSanPham;

    private ViewPager2 viewPager;
    private List<HINH_SLIDES> hinhanh;
    //Tạo ra một luồng xử lý tự động chạy
    private Handler handler = new Handler();
    //Luồng sẽ chạy hàm bên dưới
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //kiểm tra hình ảnh đang chạy phải hình cuối cùng không
            if (viewPager.getCurrentItem() == hinhanh.size() - 1){
                //nếu là hình cuối quay lại hình đầu tiên
                viewPager.setCurrentItem(0);
            }else {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvChuDeSP = view.findViewById(R.id.rycyclerview_chudesp);
        rvSanPham = view.findViewById(R.id.rvDanhSachSP);
        home_editseach = view.findViewById(R.id.home_edtseach);
        badge = view.findViewById(R.id.badge);

        Loadchude();
        LoadSanPham();

        home_editseach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // lấy dữ liệu ở đây
                String chuoitim = charSequence.toString();
                adapter_sanpham.getFilter().filter(chuoitim);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        if(SEVER.manggiohang!=null){

        }else{
            SEVER.manggiohang=new ArrayList<>();
        }
        badge.setText(SEVER.manggiohang.size()+"");

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.slides_FHome);

        hinhanh = new ArrayList<>();

        hinhanh.add(new HINH_SLIDES(SEVER.slidepath+"slides1.jpeg","link"));
        hinhanh.add(new HINH_SLIDES(SEVER.slidepath+"slides2.jpeg","link"));
        hinhanh.add(new HINH_SLIDES(SEVER.slidepath+"slides3.jpeg","link"));
        hinhanh.add(new HINH_SLIDES(SEVER.slidepath+"slides4.jpeg","link"));
        hinhanh.add(new HINH_SLIDES(SEVER.slidepath+"slides5.jpeg","link"));
        hinhanh.add(new HINH_SLIDES(SEVER.slidepath+"slides6.jpeg","link"));

        ADAPTER_SLIDES adapter = new ADAPTER_SLIDES(hinhanh, getContext());
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 2000);
            }
        });

        return view;
    }

    void Loadchude() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        Response.Listener<JSONArray> thanhcong = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        datachude.add(new CHUDE_SANPHAM(jsonObject.getString("macd"),
                                jsonObject.getString("tencd"),
                                jsonObject.getString("hinhcd")));
                    } catch (JSONException e) {
                        Toast.makeText(getContext(), "Lỗi", Toast.LENGTH_LONG).show();
                    }
                }
            }
        };
        Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Lỗi kết nối", Toast.LENGTH_LONG).show();
            }
        };
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SEVER.chudepath, thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);


        adapter_chudesanpham = new ADAPTER_CHUDESANPHAM(getContext(), datachude);
        rvChuDeSP.setAdapter(adapter_chudesanpham);
        rvChuDeSP.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false ));
    }

    void LoadSanPham() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
                        Toast.makeText(getContext(), "Lỗi ", Toast.LENGTH_LONG).show();
                    }
                }
            }
        };
        Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Lỗi kết nối", Toast.LENGTH_LONG).show();
            }
        };
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SEVER.sanphampath, thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);

        adapter_sanpham = new ADAPTER_SANPHAM(getContext(), datasanpham);
        rvSanPham.setAdapter(adapter_sanpham);
        rvSanPham.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

}