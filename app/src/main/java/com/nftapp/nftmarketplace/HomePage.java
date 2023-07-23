package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nftapp.nftmarketplace.adapter.CategoryAdapter;
import com.nftapp.nftmarketplace.model.Category;
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    return true;
                } else if (itemId == R.id.action_search) {
                    startActivity(new Intent(getApplicationContext(), CategoryPage.class));
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
    }

    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Item> item = new ArrayList<>();
        item.add(new Item(R.drawable.avt1, "Avt1", "10.000 VND"));
        item.add(new Item(R.drawable.avt2, "Avt2", "20.000 VND"));
        item.add(new Item(R.drawable.avt3, "Avt3", "30.000 VND"));
        item.add(new Item(R.drawable.avt4, "Avt4", "40.000 VND"));
        item.add(new Item(R.drawable.avt5, "Avt5", "50.000 VND"));
        item.add(new Item(R.drawable.avt6, "Avt6", "60.000 VND"));
        item.add(new Item(R.drawable.avt7, "Avt7", "70.000 VND"));
        item.add(new Item(R.drawable.avt8, "Avt8", "80.000 VND"));
        item.add(new Item(R.drawable.avt9, "Avt9", "90.000 VND"));
        listCategory.add(new Category("Trending",item));
        listCategory.add(new Category("Top Buy Collections",item));
        listCategory.add(new Category("Trending in Gaming",item));
        listCategory.add(new Category("Trending In Art",item));
        listCategory.add(new Category("Trending In Music",item));
        listCategory.add(new Category("Trending in Photography",item));
        return listCategory;
    }


}