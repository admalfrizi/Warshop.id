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

import com.example.warshop_id.ClassesHelper.RecommendationHelperClass;
import com.example.warshop_id.ActivityScreen.LocationActivity;
import com.example.warshop_id.R;

import java.util.List;

public class RecommendationViewAdapter extends RecyclerView.Adapter<RecommendationViewAdapter.RecommendationViewHolder>{
    Context context;
    List<RecommendationHelperClass> recommendationLocations;

    public RecommendationViewAdapter(Context context, List<RecommendationHelperClass> recommendationsLocations) {
        this.context = context;
        this.recommendationLocations = recommendationsLocations;
    }

    @NonNull
    @Override
    public RecommendationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_slide_design, parent,false);
        return new RecommendationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendationViewHolder holder, int position) {
        RecommendationHelperClass recommendationHelperClass = recommendationLocations.get(position);

        holder.image.setImageResource(recommendationHelperClass.getImage());
        holder.title.setText(recommendationHelperClass.getTitle());
        holder.address.setText(recommendationHelperClass.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LocationActivity.class);
                intent.putExtra("img_view",recommendationLocations.get(position).getImage());
                intent.putExtra("title",recommendationLocations.get(position).getTitle());
                intent.putExtra("address",recommendationLocations.get(position).getAddress());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return recommendationLocations.size();
    }

    public static class RecommendationViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, address;

        public RecommendationViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.lt_image);
            title = itemView.findViewById(R.id.lt_title);
            address = itemView.findViewById(R.id.lt_address);

        }
    }
}
