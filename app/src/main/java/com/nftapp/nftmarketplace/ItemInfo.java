package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nftapp.nftmarketplace.model.Item;

public class ItemInfo extends AppCompatActivity {
    private ImageView item_image;
    private TextView item_name;
    private TextView item_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        Item item = (Item) bundle.get("object_item");
        item_image = findViewById(R.id.item_image);
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);

        Intent intent = getIntent();
        item_image.setImageResource(item.getResourceImage());
        item_name.setText(item.getItem_name());
        item_price.setText(item.getItem_price());





    }
}