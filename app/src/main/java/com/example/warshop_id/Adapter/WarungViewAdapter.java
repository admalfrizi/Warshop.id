package com.example.warshop_id.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warshop_id.ActivityScreen.DetailBarang;
import com.example.warshop_id.ClassesHelper.WarungHelperClass;
import com.example.warshop_id.R;

import java.util.List;

public class WarungViewAdapter extends RecyclerView.Adapter<WarungViewAdapter.WarungViewHolder>  {
    Context context;
    List<WarungHelperClass> warungLocations;

    public WarungViewAdapter(Context context, List<WarungHelperClass> warungLocations) {
        this.context = context;
        this.warungLocations = warungLocations;

    }
    public static class WarungViewHolder extends RecyclerView.ViewHolder {

        ImageView imagelist;
        TextView namelist, price;

        public WarungViewHolder(@NonNull View itemView) {
            super(itemView);

            imagelist = itemView.findViewById(R.id.barang_list);
            namelist = itemView.findViewById(R.id.name_barang_list);
            price = itemView.findViewById(R.id.price_list);


        }
    }

    @NonNull
    @Override
    public WarungViewAdapter.WarungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_design, parent, false);
        return new WarungViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WarungViewHolder holder, final int position) {
        WarungHelperClass warungHelperClass = warungLocations.get(position);

        holder.imagelist.setImageResource(warungHelperClass.getImagelist());
        holder.namelist.setText(warungHelperClass.getNamelist());
        holder.price.setText(warungHelperClass.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailBarang.class);
                intent.putExtra("img_view",warungLocations.get(position).getImagelist());
                intent.putExtra("namelist",warungLocations.get(position).getNamelist());
                intent.putExtra("price",warungLocations.get(position).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return warungLocations.size();
    }


}
