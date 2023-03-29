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

import com.example.foodapp.R;
import com.example.foodapp.SEVER;
import com.example.foodapp.SanPhamTheoCDActivity;
import com.example.foodapp.model.CHUDE_SANPHAM;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADAPTER_CHUDESANPHAM extends RecyclerView.Adapter<VIEWHOLDER_CHUDE>{

    Context context;
    ArrayList<CHUDE_SANPHAM> data;

    public ADAPTER_CHUDESANPHAM(Context context, ArrayList<CHUDE_SANPHAM> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VIEWHOLDER_CHUDE onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chudesanpham, parent,false);
        return new VIEWHOLDER_CHUDE(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VIEWHOLDER_CHUDE holder, int position) {
        CHUDE_SANPHAM cd = data.get(position);
        holder.tvname_chude.setText(cd.tenChude);
        Picasso.get().load(SEVER.imgpath+cd.hinhChude).into(holder.img_chude);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SanPhamTheoCDActivity.class);
                intent.putExtra("macd", cd.maChude);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class VIEWHOLDER_CHUDE extends RecyclerView.ViewHolder {

    ImageView img_chude;
    TextView tvname_chude;

    public VIEWHOLDER_CHUDE(@NonNull View itemView) {
        super(itemView);
        tvname_chude = itemView.findViewById(R.id.tvChude);
        img_chude = itemView.findViewById(R.id.imgChude);
    }
}
