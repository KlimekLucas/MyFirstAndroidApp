package com.example.rottan.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {


    TextView tvContactsApp;
    Button btnCreateNewContact;
    final int ContactAddActivity = 2;

    ImageView ivMood;
    TextView tvPhone;
    TextView tvAdres;
    TextView tvWeb;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ContactAddActivity) {
            if (resultCode == RESULT_OK) {
                tvPhone.setText(data.getStringExtra("number"));
                tvPhone.setVisibility(View.VISIBLE);
                tvWeb.setText(data.getStringExtra("website"));
                tvWeb.setVisibility(View.VISIBLE);
                tvAdres.setText(data.getStringExtra("adres"));
                tvAdres.setVisibility(View.VISIBLE);
                ivMood.setVisibility(View.VISIBLE);
                if (data.getStringExtra("emotion").equals("happy")) {
                    ivMood.setImageResource(R.drawable.ic_mood_black_24dp);
                } else if (data.getStringExtra("emotion").equals("neutral")) {

                    ivMood.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);

                } else
                {
                    ivMood.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContactsApp = findViewById(R.id.tvContactsApp);
        btnCreateNewContact = findViewById(R.id.btnCreateNewContact);

        ivMood = findViewById(R.id.ivMood);
        tvAdres = findViewById(R.id.tvAdres);
        tvPhone = findViewById(R.id.tvPhone);
        tvWeb = findViewById(R.id.tvWebsite);


     btnCreateNewContact.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this,
                     com.example.rottan.myapplication.ContactAddActivity.class  );

             startActivityForResult(intent,ContactAddActivity);
         }


     });


     tvAdres.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + tvAdres.getText().toString()));
             startActivity(intent);
         }
     });


     tvWeb.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www." + tvWeb.getText().toString()));
             startActivity(intent);
         }
     });

     tvPhone.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(tvPhone.getText().toString()));
             Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tvPhone.getText().toString()) );
             startActivity(intent);
         }
     });


    }
}