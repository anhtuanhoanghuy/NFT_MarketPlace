package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemInfo extends AppCompatActivity {
    private ImageView item_image;
    private TextView item_name;
    private TextView item_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

//        item_image = findViewById(R.id.item_image);
//        item_name = findViewById(R.id.item_name);
//        item_price = findViewById(R.id.item_price);
//
//        Intent intent = getIntent();
//        item_image.setImageResource(intent.getIntExtra("item_image",0));
//        item_name.setText(intent.getStringExtra("item_name"));
//        item_price.setText(intent.getStringExtra("item_price"));





    }
}