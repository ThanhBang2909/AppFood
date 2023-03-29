package com.example.foodapp.slides;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ADAPTER_SLIDES extends RecyclerView.Adapter<ADAPTER_SLIDES.SlidesAdapterViewHolder>{

    private List<HINH_SLIDES> hinhanh;
    private Context context;

    public ADAPTER_SLIDES(List<HINH_SLIDES> hinhanh, Context context) {
        this.hinhanh = hinhanh;
        this.context = context;
    }

    @NonNull
    @Override
    public SlidesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slides, parent, false);
        return new SlidesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlidesAdapterViewHolder holder, int position) {
        HINH_SLIDES image = hinhanh.get(position);
        Picasso.get().load(image.getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        if (hinhanh != null){
            return hinhanh.size();
        }
        return 0;
    }

    public class SlidesAdapterViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        public SlidesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgView_item);
        }
    }
}

