package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nftapp.nftmarketplace.adapter.ItemAdapter;
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {

    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;
    private ImageView avt_button;
    private ImageView background_button;
    private Button create_NFT_button;
    int[] item_image = {R.drawable.avt1,R.drawable.avt2,R.drawable.avt3,R.drawable.avt4,R.drawable.avt5,R.drawable.avt6,R.drawable.avt7,R.drawable.avt8,R.drawable.avt9};
    String[] item_name = {"avt1","avt2","avt3","avt4","avt5","avt6","avt7","avt8","avt9"};
    String[] item_price = {"1","2","3","4","5","6","7","8","9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        avt_button = findViewById(R.id.avatar);
        background_button = findViewById(R.id.background_image);
        create_NFT_button = findViewById(R.id.create_nft);
        rcvItem = findViewById(R.id.rcv_items);

        avt_button.setOnClickListener(view -> showAvtDialog());
        background_button.setOnClickListener(view -> showBackgroundDialog());
        create_NFT_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, CreateNFT.class);
                startActivity(intent);
            }
        });


        mItemAdapter = new ItemAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcvItem.setLayoutManager(gridLayoutManager);
        mItemAdapter.setData(getListItem());
        rcvItem.setAdapter(mItemAdapter);
//        rcvItem.setOnClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(UserProfile.this, ItemInfo.class);
//                intent.putExtra("item_image",item_image[i]);
//                intent.putExtra("item_name",item_name[i]);
//                intent.putExtra("item_price",item_price[i]);
//                startActivity(intent);
//            }
//        });
    }

    private void showAvtDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetavtlayout);

        LinearLayout profile_image_layout = dialog.findViewById(R.id.profile_image_layout);
        LinearLayout update_avt_layout = dialog.findViewById(R.id.update_avt_layout);
        LinearLayout edit_profile_layout = dialog.findViewById(R.id.edit_profile_layout);

        profile_image_layout.setOnClickListener(view -> Toast.makeText(UserProfile.this,"see avt",Toast.LENGTH_SHORT).show());

        update_avt_layout.setOnClickListener(view -> Toast.makeText(UserProfile.this,"update avt",Toast.LENGTH_SHORT).show());

        edit_profile_layout.setOnClickListener(view -> Toast.makeText(UserProfile.this,"edit profile",Toast.LENGTH_SHORT).show());

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void showBackgroundDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetbackgroundlayout);

        LinearLayout profile_image_layout = dialog.findViewById(R.id.background_image_layout);
        LinearLayout update_avt_layout = dialog.findViewById(R.id.update_background_layout);

        profile_image_layout.setOnClickListener(view -> Toast.makeText(UserProfile.this,"see background",Toast.LENGTH_SHORT).show());

        update_avt_layout.setOnClickListener(view -> Toast.makeText(UserProfile.this,"update background",Toast.LENGTH_SHORT).show());

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
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