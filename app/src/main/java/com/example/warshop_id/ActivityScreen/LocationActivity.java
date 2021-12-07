package com.example.warshop_id.ActivityScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.warshop_id.Adapter.WarungViewAdapter;
import com.example.warshop_id.ClassesHelper.WarungHelperClass;
import com.example.warshop_id.R;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity {

    ImageView imageView;
    TextView titleloc;
    TextView addressloc;
    ImageView btnback ;
    RecyclerView listbarang;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        listbarang = findViewById(R.id.list_barang_slider);
        imageView = findViewById(R.id.imageView);
        titleloc = findViewById(R.id.title_loc);
        addressloc = findViewById(R.id.address_loc);
        btnback = findViewById(R.id.btn_back);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationActivity.super.onBackPressed();
            }
        });

        Bundle extras = getIntent().getExtras();
        Integer img_view = extras.getInt("img_view");
        String ratingbar = extras.getString("ratingbar");
        String title = extras.getString("title");
        String address = extras.getString("address");

        imageView.setImageResource(img_view);
        titleloc.setText(title);
        addressloc.setText(address);

        listbarang();



    }

    private void listbarang() {
        listbarang.setHasFixedSize(true);
        listbarang.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<WarungHelperClass> warungLocations = new ArrayList<>();

        warungLocations.add(new WarungHelperClass(R.drawable.aqua, "Aqua Galon" , "15.000"));
        warungLocations.add(new WarungHelperClass(R.drawable.vit, "Vit Galon" , "12.000"));
        warungLocations.add(new WarungHelperClass(R.drawable.rice, "Beras" , "10.000"));
        warungLocations.add(new WarungHelperClass(R.drawable.chiki, "Chiki" , "5.000"));
        warungLocations.add(new WarungHelperClass(R.drawable.taro, "Taro Seaweed" , "8.000"));


        adapter = new WarungViewAdapter(this, warungLocations);
        listbarang.setAdapter(adapter);

    }
}