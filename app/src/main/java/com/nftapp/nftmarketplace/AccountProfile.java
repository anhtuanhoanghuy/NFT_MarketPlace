package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nftapp.nftmarketplace.adapter.ItemAdapter;
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

public class AccountProfile extends AppCompatActivity {
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;
    private Button follow_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_profile);
        rcvItem = findViewById(R.id.rcv_items);
        mItemAdapter = new ItemAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcvItem.setLayoutManager(gridLayoutManager);
        mItemAdapter.setData(getListItem());
        rcvItem.setAdapter(mItemAdapter);
        follow_button = findViewById(R.id.follow_button);
        follow_button.setOnClickListener(new View.OnClickListener() {
            boolean follow_status = false;
            @Override
            public void onClick(View view) {
                if (follow_status == false) {
                    follow_button.setText("Following");
                    follow_status = true;
                } else {
                    follow_button.setText("Follow");
                    follow_status = false;
                }

            }
        });
    }

    private List<Item> getListItem() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.avt1,"Avt1","10.000 VND"));
        list.add(new Item(R.drawable.avt2,"Avt2","20.000 VND"));
        list.add(new Item(R.drawable.avt3,"Avt3","30.000 VND"));
        list.add(new Item(R.drawable.avt4,"Avt4","40.000 VND"));
        list.add(new Item(R.drawable.avt5,"Avt5","50.000 VND"));
        list.add(new Item(R.drawable.avt6,"Avt6","60.000 VND"));
        list.add(new Item(R.drawable.avt7,"Avt7","70.000 VND"));
        list.add(new Item(R.drawable.avt8,"Avt8","80.000 VND"));
        list.add(new Item(R.drawable.avt9,"Avt9","90.000 VND"));
        return list;
    }
}