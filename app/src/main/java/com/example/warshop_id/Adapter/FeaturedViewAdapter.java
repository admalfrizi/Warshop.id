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

import com.example.warshop_id.ClassesHelper.FeaturedHelperClass;
import com.example.warshop_id.ActivityScreen.LocationActivity;
import com.example.warshop_id.R;

import java.util.List;

public class FeaturedViewAdapter extends RecyclerView.Adapter<FeaturedViewAdapter.FeaturedViewHolder>  {
    Context context;
    List<FeaturedHelperClass> featuredLocations;

    public FeaturedViewAdapter(Context context, List<FeaturedHelperClass> featuredLocations) {
        this.context = context;
        this.featuredLocations = featuredLocations;

    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, address;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            address = itemView.findViewById(R.id.featured_address);


        }

    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_design, parent, false);
        return new FeaturedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.address.setText(featuredHelperClass.getAddress());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, LocationActivity.class);
            intent.putExtra("img_view",featuredLocations.get(position).getImage());
            intent.putExtra("title",featuredLocations.get(position).getTitle());
            intent.putExtra("address",featuredLocations.get(position).getAddress());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return featuredLocations.size();
    }


}
