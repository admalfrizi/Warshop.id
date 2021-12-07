package com.example.warshop_id.ActivityScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.warshop_id.R;

public class DetailBarang extends AppCompatActivity {

    ImageView img_list, btnback;
    TextView namabarang , hargabarang ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        img_list = findViewById(R.id.imageView);
        namabarang = findViewById(R.id.namabarang);
        hargabarang = findViewById(R.id.hargabarang);
        btnback = findViewById(R.id.btn_back);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailBarang.super.onBackPressed();
            }
        });

        Bundle extras = getIntent().getExtras();
        int img_view = extras.getInt("img_view");
        String namelist = extras.getString("namelist");
        String price = extras.getString("price");

        img_list.setImageResource(img_view);
        namabarang.setText(namelist);
        hargabarang.setText(price);

    }
}