package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateNFT extends AppCompatActivity {
    private Button create_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_nft);

        create_button = findViewById(R.id.create_button);

        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateNFT.this,"Created",Toast.LENGTH_SHORT).show();
            }
        });
    }
}