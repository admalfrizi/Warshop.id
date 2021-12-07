package com.example.warshop_id.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warshop_id.ClassesHelper.LastTimeHelperClass;
import com.example.warshop_id.ActivityScreen.LocationActivity;
import com.example.warshop_id.R;

import java.util.List;

public class LastTimeViewAdapter extends RecyclerView.Adapter<LastTimeViewAdapter.LastTimeViewHolder>{
    Context context;
    List<LastTimeHelperClass> lastTimeLocations;

    public LastTimeViewAdapter(Context context, List<LastTimeHelperClass> lastTimeLocations) {
        this.context = context;
        this.lastTimeLocations = lastTimeLocations;
    }
    @Override
    public int getItemCount() {
        return lastTimeLocations.size();
    }

    public static class LastTimeViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView  title, address;

        public LastTimeViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.lt_image);
            title = itemView.findViewById(R.id.lt_title);
            address = itemView.findViewById(R.id.lt_address);

        }
    }

    @NonNull
    @Override
    public LastTimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_slide_design, parent,false);
        return new LastTimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LastTimeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LastTimeHelperClass lastTimeHelperClass = lastTimeLocations.get(position);

        holder.image.setImageResource(lastTimeHelperClass.getImage());
        holder.title.setText(lastTimeHelperClass.getTitle());
        holder.address.setText(lastTimeHelperClass.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LocationActivity.class);
                intent.putExtra("img_view",lastTimeLocations.get(position).getImage());
                intent.putExtra("title",lastTimeLocations.get(position).getTitle());
                intent.putExtra("address",lastTimeLocations.get(position).getAddress());
                context.startActivity(intent);
            }
        });
    }


}
