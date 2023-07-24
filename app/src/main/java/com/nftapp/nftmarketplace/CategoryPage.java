package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nftapp.nftmarketplace.adapter.ItemAdapter;
import com.nftapp.nftmarketplace.model.Category;
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends AppCompatActivity {
    private TextView category_name;
    private ImageView back_button;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;
    private ImageView avt_button;
    private ImageView background_button;
    private Button create_NFT_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_search);
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
                    startActivity(new Intent(getApplicationContext(), UserProfile.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
        rcvItem = findViewById(R.id.rcv_items);
        mItemAdapter = new ItemAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvItem.setLayoutManager(gridLayoutManager);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        Category category = (Category) bundle.get("object_category");
        category_name = findViewById(R.id.category_name);
        Intent intent = getIntent();
        category_name.setText(category.getNameCategory());
        mItemAdapter.setData(category.getItems());
        rcvItem.setAdapter(mItemAdapter);
    }


}


