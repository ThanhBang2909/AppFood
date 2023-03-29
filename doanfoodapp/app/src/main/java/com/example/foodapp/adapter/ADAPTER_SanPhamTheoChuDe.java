package com.example.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.ChiTietSanPhamActivity;
import com.example.foodapp.R;
import com.example.foodapp.SEVER;
import com.example.foodapp.model.SANPHAM;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADAPTER_SanPhamTheoChuDe extends RecyclerView.Adapter<VIEWHOLDER_SanPhamTheoChuDe>{
    Context context;
    ArrayList<SANPHAM> data;

    public ADAPTER_SanPhamTheoChuDe(Context context, ArrayList<SANPHAM> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public VIEWHOLDER_SanPhamTheoChuDe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanphamtheochude, parent,false);
        return new VIEWHOLDER_SanPhamTheoChuDe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VIEWHOLDER_SanPhamTheoChuDe holder, int position) {
        SANPHAM sp = data.get(position);
        holder.tvtensp.setText(sp.tensanpham);
        holder.tvgiasp.setText(sp.giasanpham+"");
        Picasso.get().load(SEVER.imgsanpham+sp.hinhsanpham).into(holder.img_sanpham);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                intent.putExtra("name",sp.tensanpham);
                intent.putExtra("gia",sp.giasanpham+"");
                intent.putExtra("hinh",sp.hinhsanpham);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class VIEWHOLDER_SanPhamTheoChuDe extends RecyclerView.ViewHolder {

    ImageView img_sanpham;
    TextView tvtensp, tvgiasp;

    public VIEWHOLDER_SanPhamTheoChuDe(@NonNull View itemView) {
        super(itemView);
        tvtensp = itemView.findViewById(R.id.tv_tensp);
        tvgiasp = itemView.findViewById(R.id.tv_giasp);
        img_sanpham = itemView.findViewById(R.id.imghinh);
    }
}
