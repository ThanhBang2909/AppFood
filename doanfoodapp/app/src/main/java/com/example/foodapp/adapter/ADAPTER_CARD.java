package com.example.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.SEVER;
import com.example.foodapp.model.GIOHANG;
import com.example.foodapp.model.SANPHAM;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADAPTER_CARD extends RecyclerView.Adapter<VIEWHOLDER_CART>{

    Context context;
    ArrayList<GIOHANG> data;

    public ADAPTER_CARD(Context context, ArrayList<GIOHANG> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VIEWHOLDER_CART onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanphamtheochude, parent,false);
        return new VIEWHOLDER_CART(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VIEWHOLDER_CART holder, int position) {
        GIOHANG giohang = data.get(position);
        holder.tvtensp.setText(giohang.tensp);
        holder.tvgiasp.setText(giohang.soluong+"");
        //Picasso.get().load(SEVER.imgsanpham+giohang.hingsp).into(holder.img_sanpham);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class VIEWHOLDER_CART extends RecyclerView.ViewHolder {

    ImageView img_sanpham;
    TextView tvtensp, tvgiasp;

    public VIEWHOLDER_CART(@NonNull View itemView) {
        super(itemView);
        tvtensp = itemView.findViewById(R.id.tv_tensp);
        tvgiasp = itemView.findViewById(R.id.tv_giasp);
        img_sanpham = itemView.findViewById(R.id.imghinh);
    }
}
