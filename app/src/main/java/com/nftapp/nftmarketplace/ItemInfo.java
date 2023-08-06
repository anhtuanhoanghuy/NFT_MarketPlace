package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputEditText;
import com.nftapp.nftmarketplace.model.Item;
import com.nftapp.nftmarketplace.model.User;

import java.util.ArrayList;
import java.util.List;

public class ItemInfo extends AppCompatActivity {
    private String s1 = "Sell On Market";
    private String s2 = "Auction";
    private List<User> mListUser;
    private User mUser;

    private Button buy_button;
    private Button order_button;
    private Button order_auth_button;
    private Button sell_button;
    private Button sell_auth_button;
    private Button auction_button;
    private BottomNavigationView bottomNavigationView;
    private ImageView back_button;
    private ImageView item_image;
    private TextView item_name;
    private TextView item_price;
    private TextView item_username;

    private TextView item_status;
    private TextView item_date_end;

    private LinearLayout group_price;
    private LinearLayout group_status;
    private LinearLayout group_date_end;

    private LinearLayout setSell;
    private LinearLayout setOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        mListUser = getListUser();

        buy_button = findViewById(R.id.buy_button);
        order_button = findViewById(R.id.order_button);
        order_auth_button = findViewById(R.id.order_auth_button);

        sell_button = findViewById(R.id.sell_button);
        sell_auth_button = findViewById(R.id.sell_auth_button);
        auction_button = findViewById(R.id.auction_button);
        back_button = findViewById(R.id.back_button);

        group_price = findViewById(R.id.group_price);
        group_status = findViewById(R.id.group_status);
        group_date_end = findViewById(R.id.group_date_end);
        setSell = findViewById(R.id.set_sell);
        setOrder = findViewById(R.id.set_order);
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
        item_username = findViewById(R.id.item_username);
        item_status = findViewById(R.id.item_status);
        item_date_end = findViewById(R.id.item_date_end);


        Intent intent = getIntent();
        item_image.setImageResource(item.getResourceImage());
        item_name.setText(item.getItem_name());
        item_price.setText(String.valueOf(item.getItem_price()));
        item_username.setText(item.getItem_username());
        item_status.setText(item.getItem_status());
        item_date_end.setText(item.getItem_date_end());


//        if (item.getItem_username().equals((String) UserProfile.user_name.getText())) {
        if (item.getItem_status().equals(s1)) {

            buy_button.setVisibility(View.VISIBLE);
            order_button.setVisibility(View.GONE);
            auction_button.setVisibility(View.GONE);
            sell_button.setVisibility(View.GONE);
            buy_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ItemInfo.this, "Buy successfully", Toast.LENGTH_SHORT).show();
                    buy_button.setText("Buy Success");
                    setOrder.setVisibility(View.GONE);
                }
            });
        } else if (item.getItem_status().equals(s2)) {
            buy_button.setVisibility(View.GONE);
            order_button.setVisibility(View.VISIBLE);
            auction_button.setVisibility(View.GONE);
            sell_button.setVisibility(View.GONE);

            order_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    order_button.setVisibility(View.GONE);
                    setOrder.setVisibility(View.VISIBLE);

                    TextInputEditText inputEditText_order_priceItem = findViewById(R.id.input_order_price_item);
                    order_auth_button = findViewById(R.id.order_auth_button);

                    order_auth_button.setOnClickListener(view1 -> {
                        Float priceItem = Float.parseFloat(String.valueOf(inputEditText_order_priceItem.getText()));
                        if(priceItem > item.getItem_price()) {
                            item_price.setText(String.valueOf(inputEditText_order_priceItem.getText()));

                            auction_button.setVisibility(View.GONE);
                            sell_button.setVisibility(View.GONE);
                            setOrder.setVisibility(View.GONE);
                            order_button.setVisibility(View.VISIBLE);
                            Toast.makeText(ItemInfo.this, "Order successfully", Toast.LENGTH_SHORT).show();
                            order_button.setText("Order Success");
                        } else {
                            Toast.makeText(ItemInfo.this, "Order Fail", Toast.LENGTH_SHORT).show();
                        }

                    });
                }
            });

        } else {
            buy_button.setVisibility(View.GONE);
            order_button.setVisibility(View.GONE);
            auction_button.setVisibility(View.VISIBLE);
            sell_button.setVisibility(View.VISIBLE);
            auction_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    auction_button.setTextColor(Color.GREEN);
                    sell_button.setTextColor(Color.WHITE);
                    setSell.setVisibility(View.VISIBLE);

                    TextInputEditText inputEditText_priceItem = findViewById(R.id.input_price_item);
                    TextInputEditText inputEditText_dateEnd = findViewById(R.id.input_date_end);
                    sell_auth_button = findViewById(R.id.sell_auth_button);

                    sell_auth_button.setOnClickListener(view1 -> {
                        Float priceItem = Float.parseFloat(String.valueOf(inputEditText_priceItem.getText()));
                        String dateEndItem = String.valueOf(inputEditText_dateEnd.getText());

                        item_price.setText(String.valueOf(inputEditText_priceItem.getText()));
                        item_status.setText(String.valueOf(auction_button.getText()));
                        item_date_end.setText(dateEndItem);

                        auction_button.setVisibility(View.GONE);
                        sell_button.setVisibility(View.GONE);
                        setSell.setVisibility(View.GONE);
                    });
                }
            });
            sell_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    auction_button.setTextColor(Color.WHITE);
                    sell_button.setTextColor(Color.GREEN);
                    setSell.setVisibility(View.VISIBLE);

                    TextInputEditText inputEditText_priceItem = findViewById(R.id.input_price_item);
                    TextInputEditText inputEditText_dateEnd = findViewById(R.id.input_date_end);
                    sell_auth_button = findViewById(R.id.sell_auth_button);

                    sell_auth_button.setOnClickListener(view1 -> {
                        Float priceItem = Float.parseFloat(String.valueOf(inputEditText_priceItem.getText()));
                        String dateEndItem = String.valueOf(inputEditText_dateEnd.getText());

                        item_price.setText(String.valueOf(inputEditText_priceItem.getText()));
                        item_status.setText(String.valueOf(sell_button.getText()));
                        item_date_end.setText(dateEndItem);

                        auction_button.setVisibility(View.GONE);
                        sell_button.setVisibility(View.GONE);
                        setSell.setVisibility(View.GONE);

                    });
                }
            });

        }
        item_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemInfo.this,AccountProfile.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_item",item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, R.drawable.avt1, R.drawable.background, "TuanAnh", "123456789", "123456", 100F, "1@gmail.com", "0385961788", "1", "no"));
        list.add(new User(1, R.drawable.avt1, R.drawable.background, "MinhTuong", "123456789", "123456", 100F, "1@gmail.com", "0385961788", "1", "no"));
        return list;
    }
}