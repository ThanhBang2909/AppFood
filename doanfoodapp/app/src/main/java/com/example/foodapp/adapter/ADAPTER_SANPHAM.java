package com.example.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
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

public class ADAPTER_SANPHAM extends RecyclerView.Adapter<VIEWHOLDER_SANPHAM> implements Filterable {

    Context context;
    ArrayList<SANPHAM> data;
    ArrayList<SANPHAM> dataOrigin;

    public ADAPTER_SANPHAM(Context context, ArrayList<SANPHAM> data) {
        this.context = context;
        this.data = data;
        this.dataOrigin = data;
    }

    @NonNull
    @Override
    public VIEWHOLDER_SANPHAM onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanpham, parent,false);
        return new VIEWHOLDER_SANPHAM(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VIEWHOLDER_SANPHAM holder, int position) {
        SANPHAM sp = data.get(position);
        holder.tvname_chude.setText(sp.tensanpham);
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

    @Override
    public Filter getFilter() {
        return new ItemFilter();
    }

    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String chuoitim = charSequence.toString().toLowerCase().trim();
            FilterResults filterResults = new FilterResults();
            if (!TextUtils.isEmpty(chuoitim)) {
                ArrayList<SANPHAM> tam = new ArrayList<>();
                for (SANPHAM sp : dataOrigin) {
                    if (sp.tensanpham.toLowerCase().toString().contains(chuoitim))
                        tam.add(sp);
                }
                filterResults.values = tam;
                filterResults.count = tam.size();

            } else {
                filterResults.values = dataOrigin;
                filterResults.count = dataOrigin.size();
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            // Nếu nhập vào != null và giá trị lớn hơn không thì thực hiện
            if (filterResults != null && filterResults.count > 0) {
                data = (ArrayList<SANPHAM>) filterResults.values;
                notifyDataSetChanged();
            }
        }
    }
}

class VIEWHOLDER_SANPHAM extends RecyclerView.ViewHolder {

    ImageView img_sanpham;
    TextView tvname_chude, tvgiasp;

    public VIEWHOLDER_SANPHAM(@NonNull View itemView) {
        super(itemView);
        tvname_chude = itemView.findViewById(R.id.tv_tensp);
        tvgiasp = itemView.findViewById(R.id.tv_giasp);
        img_sanpham = itemView.findViewById(R.id.imghinhsp);
    }
}