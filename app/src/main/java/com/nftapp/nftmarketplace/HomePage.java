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
import com.nftapp.nftmarketplace.model.User;

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

        Bundle bundleReceive = getIntent().getExtras();
        User user = (User) bundleReceive.get("object_user");
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    return true;
                } else if (itemId == R.id.action_search) {

                    Intent intent = new Intent(getApplicationContext(), SearchNFT.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("object_user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);

//                    startActivity(new Intent(getApplicationContext(), SearchNFT.class));
                    overridePendingTransition(0, 0);
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
    }

    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Item> list1 = new ArrayList<>();
        List<Item> list2 = new ArrayList<>();
        List<Item> list3 = new ArrayList<>();
        list1.add(new Item(R.drawable.avt1, "Avt1", 10,"AnhTuan", "Sell On Market", "x"));
        list1.add(new Item(R.drawable.avt2, "Avt2", 10,"MinhTuong", "Sell On Market", "x"));
        list1.add(new Item(R.drawable.avt3, "Avt3", 10,"AnhTuan", "Sell On Market", "x"));
        list1.add(new Item(R.drawable.avt4, "Avt4", 10,"MinhTuong", "Sell On Market", "x"));
        list1.add(new Item(R.drawable.avt5, "Avt5", 10,"AnhTuan", "Sell On Market", "x"));
        list2.add(new Item(R.drawable.avt6, "Avt6", 10,"MinhTuong", "Sell On Market", "x"));
        list2.add(new Item(R.drawable.avt7, "Avt7", 10,"AnhTuan", "Sell On Market", "x"));
        list2.add(new Item(R.drawable.avt8, "Avt8", 10,"MinhTuong", "Auction", "x"));
        list2.add(new Item(R.drawable.avt9, "Avt9", 10,"AnhTuan", "Auction", "x"));
        list2.add(new Item(R.drawable.avt1, "Avt1", 10,"MinhTuong", "Auction", "x"));
        list2.add(new Item(R.drawable.avt2, "Avt2", 10,"AnhTuan", "Auction", "x"));
        list3.add(new Item(R.drawable.avt3, "Avt3", 10,"MinhTuong", "Auction", "x"));
        list3.add(new Item(R.drawable.avt4, "Avt4", 10,"AnhTuan", "Auction", "x"));
        list3.add(new Item(R.drawable.avt5, "Avt5", 10,"MinhTuong", "Auction", "x"));
        list3.add(new Item(R.drawable.avt6, "Avt6", 10,"AnhTuan", "Auction", "x"));
        list3.add(new Item(R.drawable.avt7, "Avt7", 10,"MinhTuong", "Auction", "x"));
        list3.add(new Item(R.drawable.avt8, "Avt8", 10,"AnhTuan", "Auction", "x"));
        list3.add(new Item(R.drawable.avt9, "Avt9", 10,"MinhTuong", "Auction", "x"));
        listCategory.add(new Category("Trending",list1));
        listCategory.add(new Category("Top Buy Collections",list2));
        listCategory.add(new Category("Trending in Gaming",list3));
        listCategory.add(new Category("Trending In Art",list1));
        listCategory.add(new Category("Trending In Music",list2));
        listCategory.add(new Category("Trending in Photography",list3));
        return listCategory;
    }


}