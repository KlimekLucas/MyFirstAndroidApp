package com.example.rottan.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    final int ContactAddActivity = 2;
    TextView tvContactsApp;
    Button btnCreateNewContact;
    Button btnClose;
    ImageView ivMood;
    TextView tvPhone;
    TextView tvAdres;
    TextView tvWeb;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("Main Activity", "reciving Data");

        if (requestCode == ContactAddActivity) {
            if (resultCode == RESULT_OK) {
                tvPhone.setText(data.getStringExtra("number"));
                tvPhone.setVisibility(View.VISIBLE);
                tvWeb.setText(data.getStringExtra("website"));
                tvWeb.setVisibility(View.VISIBLE);
                tvAdres.setText(data.getStringExtra("adres"));
                tvAdres.setVisibility(View.VISIBLE);
                ivMood.setVisibility(View.VISIBLE);

                switch (data.getIntExtra("emotion",0)) {
                    case 1:
                        ivMood.setImageResource(R.drawable.ic_mood_black_24dp);
                        break;
                    case 2:
                        ivMood.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);
                        break;
                    default:
                        ivMood.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                        break;
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(getString(R.string.mainActivityString), "Application Start");

        tvContactsApp = findViewById(R.id.tvContactsApp);
        btnCreateNewContact = findViewById(R.id.btnCreateNewContact);


        ivMood = findViewById(R.id.ivMood);
        tvAdres = findViewById(R.id.tvAdres);
        tvPhone = findViewById(R.id.tvPhone);
        tvWeb = findViewById(R.id.tvWebsite);
        btnClose = findViewById(R.id.btnClose);


        btnCreateNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.rottan.myapplication.ContactAddActivity.class);

                Log.d("Main Activity", "Start ContactAddActivity");
                startActivityForResult(intent, ContactAddActivity);
            }


        });


        tvAdres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + tvAdres.getText().toString()));
                startActivity(intent);
            }
        });


        tvWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." + tvWeb.getText().toString()));
                startActivity(intent);
            }
        });

        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(tvPhone.getText().toString()));
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tvPhone.getText().toString()));
                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
                Log.d("Main activity", "ApplicationClose");
            }
        });


    }
}
