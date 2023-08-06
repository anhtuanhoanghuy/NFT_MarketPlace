package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nftapp.nftmarketplace.model.Item;
import com.nftapp.nftmarketplace.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginMeta_Activity extends AppCompatActivity {

    private EditText editUserName;
    private EditText editPassWord;

    private List<User> mListUser;
    private User mUser;
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_meta);

        editUserName = findViewById(R.id.input_username);
        editPassWord = findViewById(R.id.input_password);

        mListUser = getListUser();

        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(view -> {
            clickLogin();
        });
    }

    private void clickLogin() {
        String strUserName = editUserName.getText().toString().trim();
        String strPassword = editPassWord.getText().toString().trim();

        if(mListUser == null || mListUser.isEmpty()) {
            return;
        }

        boolean isHasUser = false;
        for(User user : mListUser) {
            if(strUserName.equals(user.getUser_name()) && strPassword.equals(user.getPassword())) {
                isHasUser = true;
                mUser = user;
                break;
            }
        }

        if(isHasUser) {
            Intent intent = new Intent(LoginMeta_Activity.this, HomePage.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_user", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(LoginMeta_Activity.this,"Login Fail",Toast.LENGTH_SHORT).show();
        }
    }


    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, R.drawable.avt1, R.drawable.background, "TuanAnh", "123456789", "123456", 100F, "1@gmail.com", "0385961788", "1", "no"));
        list.add(new User(1, R.drawable.avt1, R.drawable.background, "MinhTuong", "123456789", "123456", 100F, "1@gmail.com", "0385961788", "1", "no"));
        return list;
    }
}