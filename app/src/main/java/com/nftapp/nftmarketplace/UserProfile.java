package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nftapp.nftmarketplace.adapter.ItemAdapter;
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;
    private ImageView avt_button;
    private ImageView background_button;
    private Button create_NFT_button;
    private int avatarResource = R.drawable.avt;
    private int backgroundResource = R.drawable.background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        avt_button = findViewById(R.id.avatar);
        avt_button.setImageResource(avatarResource);
        background_button = findViewById(R.id.background_image);
        background_button.setImageResource(backgroundResource);
        create_NFT_button = findViewById(R.id.create_nft);
        rcvItem = findViewById(R.id.rcv_items);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.action_search) {
                    startActivity(new Intent(getApplicationContext(), CategoryPage.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.action_profile) {
                    return true;
                }
                return false;
            }
        });

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

    private void showAvtDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetavtlayout);

        LinearLayout profile_image_layout = dialog.findViewById(R.id.profile_image_layout);
        LinearLayout update_avt_layout = dialog.findViewById(R.id.update_avt_layout);
        LinearLayout edit_profile_layout = dialog.findViewById(R.id.edit_profile_layout);

        profile_image_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this,ImgView.class);
                intent.putExtra("src",avatarResource);
                startActivity(intent);
            }
        });
        update_avt_layout.setOnClickListener(view -> Toast.makeText(UserProfile.this, "update avt", Toast.LENGTH_SHORT).show());
        edit_profile_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this,EditProfile.class);
                startActivity(intent);
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
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
        profile_image_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this,ImgView.class);
                intent.putExtra("src",backgroundResource);
                startActivity(intent);
            }
        });
        update_avt_layout.setOnClickListener(view -> Toast.makeText(UserProfile.this, "update background", Toast.LENGTH_SHORT).show());
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private List<Item> getListItem() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.avt1, "Avt1", "10.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt2, "Avt2", "20.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt3, "Avt3", "30.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt4, "Avt4", "40.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt5, "Avt5", "50.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt6, "Avt6", "60.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt7, "Avt7", "70.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt8, "Avt8", "80.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt9, "Avt9", "90.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt1, "Avt1", "10.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt2, "Avt2", "20.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt3, "Avt3", "30.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt4, "Avt4", "40.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt5, "Avt5", "50.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt6, "Avt6", "60.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt7, "Avt7", "70.000 VND","MinhTuong"));
        list.add(new Item(R.drawable.avt8, "Avt8", "80.000 VND","AnhTuan"));
        list.add(new Item(R.drawable.avt9, "Avt9", "90.000 VND","MinhTuong"));
        return list;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mItemAdapter != null) {
            mItemAdapter.release();
        }
    }
}


