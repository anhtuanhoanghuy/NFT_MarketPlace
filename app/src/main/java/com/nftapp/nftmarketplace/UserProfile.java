package com.nftapp.nftmarketplace;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nftapp.nftmarketplace.adapter.ItemAdapter;
import com.nftapp.nftmarketplace.model.Item;
import com.nftapp.nftmarketplace.model.User;
import com.nftapp.nftmarketplace.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfile extends AppCompatActivity {
    public static TextView user_name;
    private ImageView logout_button;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;
    private ImageView avt_button;
    private ImageView background_button;
    private List<Item> mListItem;

    private TextView bio;

    private Button create_NFT_button;
    private int avatarResource ;
    private int backgroundResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        user_name = findViewById(R.id.user_name);
        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, SplashScreen.class);
                startActivity(intent);
            }
        });

        avt_button = findViewById(R.id.avatar);
        background_button = findViewById(R.id.background_image);
        user_name = findViewById(R.id.user_name);
        bio = findViewById(R.id.bio);

        Bundle bundleReceive = getIntent().getExtras();
        if(bundleReceive == null) {
            return;
        }
        User user = (User) bundleReceive.get("object_user");
        if(user != null) {
            avatarResource = user.getUser_avatar();
            avt_button.setImageResource(avatarResource);
            backgroundResource = user.getUser_background();
            background_button.setImageResource(backgroundResource);
            user_name.setText(user.getUser_name());
            bio.setText(user.getBio());
        }


//        avt_button.setImageResource(avatarResource);
//        background_button.setImageResource(backgroundResource);


        create_NFT_button = findViewById(R.id.create_nft);
        rcvItem = findViewById(R.id.rcv_items);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
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
                    Intent intent = new Intent(getApplicationContext(), SearchNFT.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("object_user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);

//                    startActivity(new Intent(getApplicationContext(), SearchNFT.class));
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


        mItemAdapter = new ItemAdapter( this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvItem.setLayoutManager(gridLayoutManager);
        mListItem = new ArrayList<>();
//        if (getListItem().size() != 0) {
//            mItemAdapter.setData(getListItem());
//        } else {
//            ImageView no_result_found_icon;
//            TextView no_result_found_text;
//
//            no_result_found_icon = findViewById(R.id.no_result_found_icon);
//            no_result_found_text = findViewById(R.id.no_result_found_text);
//
//            no_result_found_icon.setVisibility(View.VISIBLE);
//            no_result_found_text.setVisibility(View.VISIBLE);
//        }
        callApiGetUsers();
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
        update_avt_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(UserProfile.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(101);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            Uri uri = data.getData();
            if ( requestCode == 101) {
                avt_button.setImageURI(uri);
            } else {
                background_button.setImageURI(uri);}

                    // Use Uri object instead of File to avoid storage permissions
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
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
        update_avt_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(UserProfile.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(102);
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

//    private List<Item> getListItem() {
//        List<Item> list = new ArrayList<>();
//        list.add(new Item(R.drawable.avt1, "Avt1", 10 ,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt2, "Avt2", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt3, "Avt3", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt4, "Avt4", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt5, "Avt5", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt6, "Avt6", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt7, "Avt7", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt8, "Avt8", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt9, "Avt9", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt1, "Avt1", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt2, "Avt2", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt3, "Avt3", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt4, "Avt4", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt5, "Avt5", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt6, "Avt6", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt7, "Avt7", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt8, "Avt8", 10,"TuanAnh", "", "x"));
//        list.add(new Item(R.drawable.avt9, "Avt9", 10,"TuanAnh", "", "x"));
//        return list;
//
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mItemAdapter != null) {
            mItemAdapter.release();
        }
    }
    private void callApiGetUsers() {
        ApiService.apiService.getListItem(1).enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                mListItem = response.body();
//                ItemAdapter mItemAdapter = new ItemAdapter((Context) mListItem);
                if (mListItem.size() != 0) {
                    mItemAdapter.setData(mListItem);
                    rcvItem.setAdapter(mItemAdapter);
                } else {
                    ImageView no_result_found_icon;
                    TextView no_result_found_text;

                    no_result_found_icon = findViewById(R.id.no_result_found_icon);
                    no_result_found_text = findViewById(R.id.no_result_found_text);

                    no_result_found_icon.setVisibility(View.VISIBLE);
                    no_result_found_text.setVisibility(View.VISIBLE);
                }
                Log.d("test",mListItem.toString());
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(UserProfile.this,"failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}


