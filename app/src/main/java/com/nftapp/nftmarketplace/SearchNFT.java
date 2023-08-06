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
import com.nftapp.nftmarketplace.model.User;

import java.util.ArrayList;
import java.util.List;

public class SearchNFT extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_nft);
        rcvItem = findViewById(R.id.rcv_items);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_search);

        Bundle bundleReceive = getIntent().getExtras();
        User user = (User) bundleReceive.get("object_user");
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    Intent intent = new Intent(getApplicationContext(), HomePage.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("object_user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);

//                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.action_search) {
                    return true;
                } else if (itemId == R.id.action_profile) {
                    Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("object_user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);

//                    startActivity(new Intent(getApplicationContext(), UserProfile.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
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
        list.add(new Item(R.drawable.avt2, "Avt1", 10, "TuanAnh", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt3, "Avt2", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt4, "Avt3", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt5, "Avt4", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt6, "Avt5", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt7, "Avt6", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt1, "Avt7", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt2, "Avt8", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt3, "Avt9", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt4, "Avt1", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt5, "Avt2", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt6, "Avt3", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt7, "Avt4", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt8, "Avt5", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt9, "Avt6", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt1, "Avt7", 10, "MinhTuong", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt8, "Avt8", 10, "AnhTuan", "Sell On Market", "x"));
        list.add(new Item(R.drawable.avt9, "Avt9", 10, "MinhTuong", "Sell On Market", "x"));
        return list;
    }
}