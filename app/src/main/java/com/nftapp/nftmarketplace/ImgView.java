package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ImgView extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ImageView img_view;
    private ImageView close_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.action_search) {
                    startActivity(new Intent(getApplicationContext(), SearchNFT.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.action_profile) {
                    return true;
                }
                return false;
            }
        });
        img_view = findViewById(R.id.img_view);
        img_view.setImageResource(getIntent().getIntExtra("src",0));
        close_button = findViewById(R.id.close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}