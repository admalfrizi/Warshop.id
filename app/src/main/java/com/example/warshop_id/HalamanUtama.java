package com.example.warshop_id;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warshop_id.ActivityScreen.ChatActivity;
import com.example.warshop_id.ActivityScreen.NotificationsActivity;
import com.example.warshop_id.ActivityScreen.ProfileActivity;
import com.example.warshop_id.ActivityScreen.SettingsMenu;
import com.example.warshop_id.Adapter.FeaturedViewAdapter;
import com.example.warshop_id.Adapter.LastTimeViewAdapter;
import com.example.warshop_id.Adapter.RecommendationViewAdapter;
import com.example.warshop_id.ClassesHelper.FeaturedHelperClass;
import com.example.warshop_id.ClassesHelper.LastTimeHelperClass;
import com.example.warshop_id.ClassesHelper.RecommendationHelperClass;
import com.example.warshop_id.ClassesHelper.SessionHelperClass;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HalamanUtama extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth auth ;
    RecyclerView featuredslider;
    RecyclerView ltslider;
    RecyclerView rcslider;
    TextView label_username;
    NavigationView navigation_view;
    DrawerLayout drawerLayout;
    ImageView menu_icon, chat_icon, notifications_icon;
    RecyclerView.Adapter adapter;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        featuredslider = findViewById(R.id.featured_slider);
        ltslider = findViewById(R.id.lt_slider);
        rcslider = findViewById(R.id.recommendation_slider);
        navigation_view = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        label_username = (findViewById(R.id.id_username));
        menu_icon = findViewById(R.id.menu_icon);
        chat_icon = findViewById(R.id.chat_btn);
        notifications_icon = findViewById(R.id.notification_btn);
        auth = FirebaseAuth.getInstance();

        SessionHelperClass sessionHelperClass = new SessionHelperClass(this);
        HashMap<String, String> userDetails = sessionHelperClass.getUserDetailFromSession();

        String fullname = userDetails.get(SessionHelperClass.KEY_PHONENUMBER);

        label_username.setText(fullname);


        navigation_view.bringToFront();
        navigation_view.setNavigationItemSelectedListener(this);
        navigation_view.setCheckedItem(R.id.nav_home);

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        chat_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChatActivity.class));
            }
        });

        notifications_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NotificationsActivity.class));
            }
        });

        featuredslider();
        ltslider();
        rcslider();


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_settings){
            startActivity(new Intent(getApplicationContext(), SettingsMenu.class));
        }

        if (id == R.id.nav_profile){
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        if (id == R.id.nav_logout) {
            auth.signOut();
            Intent intent = new Intent(HalamanUtama.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }


    private void featuredslider() {
        featuredslider.setHasFixedSize(true);
        featuredslider.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.warung2,"Warung Haji Nawi","Jl. Indramayu No. 30 Jatinegara, Jakarta Timur, DKI Jakarta"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.warung3, "Warung Sumber Jaya","Jl. Haji Raya No. 1 Jatinegara, Jakarta Timur, DKI Jakarta")) ;
        featuredLocations.add(new FeaturedHelperClass(R.drawable.warung_4, "Warung Gang Mandir","Jl. Kanindra No. A/11 Jatinegara, Jakarta Timur, DKI Jakarta"));

        adapter = new FeaturedViewAdapter(this,featuredLocations);
        featuredslider.setAdapter(adapter);

    }

    private void ltslider() {

        ltslider.setHasFixedSize(true);
        ltslider.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<LastTimeHelperClass> lastTimeLocations = new ArrayList<>();

        lastTimeLocations.add(new LastTimeHelperClass(R.drawable.warung_5, "Warung Bang Aji", "JL. Citra Raya, A/01  Bintaro, Pondok Jaya Tangerang Selatan, Banten, "));
        lastTimeLocations.add(new LastTimeHelperClass(R.drawable.warung_6, "Warung Ayu Sari", "JL. Indramayu, A/01  Jombang, Ciputat, Tangerang Selatan, Banten,"));
        lastTimeLocations.add(new LastTimeHelperClass(R.drawable.warung_7, "Warkop Ponjay", "JL. Kalijaga, B/11  Kuncen, Ungaran Barat, Ungaran, Kab. Semarang,"));

        adapter = new LastTimeViewAdapter(this,lastTimeLocations);
        ltslider.setAdapter(adapter);


    }
    private void rcslider() {
        rcslider.setHasFixedSize(true);
        rcslider.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<RecommendationHelperClass> recommendationLocations = new ArrayList<>();
        recommendationLocations.add(new RecommendationHelperClass(R.drawable.warung_5, "Warung Linda", "JL. Jenderal Sudirman Raya, A/12  Bintaro, Pondok Jaya Tangerang Selatan, Banten, "));
        recommendationLocations.add(new  RecommendationHelperClass(R.drawable.warung_6, "Warung BayangSari", "JL. Moh Hatta, A/01  Jombang, Ciputat, Tangerang Selatan, Banten,"));
        recommendationLocations.add(new  RecommendationHelperClass(R.drawable.warung_7, "Warkop Mpok Nawi", "JL. Kalijaga, B/11  Kuncen, Ungaran Barat, Ungaran, Kab. Semarang,"));

        adapter = new RecommendationViewAdapter(this,recommendationLocations);
        rcslider.setAdapter(adapter);
    }




}
