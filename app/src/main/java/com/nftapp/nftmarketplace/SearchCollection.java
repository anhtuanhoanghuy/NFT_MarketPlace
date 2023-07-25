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
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SearchCollection extends AppCompatActivity {
    private Button search_nft_button;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_collection);
        rcvItem = findViewById(R.id.rcv_items);
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
        search_nft_button = findViewById(R.id.search_nft_button);
        search_nft_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchCollection.this, SearchNFT.class);
                startActivity(intent);
            }
        });

        mItemAdapter = new ItemAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvItem.setLayoutManager(gridLayoutManager);
        if (getListItem().size() != 0) {
            mItemAdapter.setData(getListItem());
        } else {
            ImageView no_result_found_icon;
            TextView no_result_found_text;

            no_result_found_icon = findViewById(R.id.no_result_found_icon);
            no_result_found_text = findViewById(R.id.no_result_found_text);

            no_result_found_icon.setVisibility(View.VISIBLE);
            no_result_found_text.setVisibility(View.VISIBLE);
        }
        rcvItem.setAdapter(mItemAdapter);

    }

    private List<Item> getListItem() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.avt1, "Avt1", "10.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt2, "Avt2", "20.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt3, "Avt3", "30.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt4, "Avt4", "40.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt5, "Avt5", "50.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt6, "Avt6", "60.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt7, "Avt7", "70.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt1, "Avt1", "10.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt2, "Avt2", "20.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt3, "Avt3", "30.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt4, "Avt4", "40.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt5, "Avt5", "50.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt6, "Avt6", "60.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt7, "Avt7", "70.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt8, "Avt8", "80.000 VND", "MinhTuong"));
        list.add(new Item(R.drawable.avt9, "Avt9", "90.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt8, "Avt8", "80.000 VND", "AnhTuan"));
        list.add(new Item(R.drawable.avt9, "Avt9", "90.000 VND", "MinhTuong"));
        return list;
    }
}

