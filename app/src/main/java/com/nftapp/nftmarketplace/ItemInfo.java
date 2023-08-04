package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nftapp.nftmarketplace.model.Item;

public class ItemInfo extends AppCompatActivity {
    private Button buy_button;
    private Button auction_button;
    private BottomNavigationView bottomNavigationView;
    private ImageView back_button;
    private ImageView item_image;
    private TextView item_name;
    private TextView item_price;
    private TextView author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        buy_button = findViewById(R.id.buy_button);
        auction_button = findViewById(R.id.auction_button);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
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
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        Item item = (Item) bundle.get("object_item");
        item_image = findViewById(R.id.item_image);
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
        author = findViewById(R.id.author);

        Intent intent = getIntent();
        item_image.setImageResource(item.getResourceImage());
        item_name.setText(item.getItem_name());
        item_price.setText(item.getItem_price());
        author.setText(item.getAuthor());
        if (item.getAuthor().equals((String) UserProfile.user_name.getText())) {
            buy_button.setVisibility(View.GONE);
            auction_button.setVisibility(View.VISIBLE);
            auction_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ItemInfo.this,"You clicked auction button",Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            auction_button.setVisibility(View.GONE);
            buy_button.setVisibility(View.VISIBLE);
            buy_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ItemInfo.this,"Order successfully",Toast.LENGTH_SHORT).show();
                    buy_button.setText("Ordered");
                }
            });

        }
        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemInfo.this,AccountProfile.class);
                startActivity(intent);
            }
        });
    }
}