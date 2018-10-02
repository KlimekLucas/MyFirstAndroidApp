package com.example.rottan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactAddActivity extends AppCompatActivity {

    EditText etName;
    EditText etAdress;
    EditText etWebsite;
    EditText etNumber;

    TextView tvName;
    TextView tvWebsite;
    TextView tvAdres;
    ImageView ivHappy;
    ImageView ivNormal;
    ImageView ivSad;
    Integer emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);


        etWebsite = findViewById(R.id.etWeb);
        etName = findViewById(R.id.etName);
        etAdress = findViewById(R.id.etAdress);



        etNumber = findViewById(R.id.etNumber);

        ivHappy = findViewById(R.id.ivHappy);
        ivNormal = findViewById(R.id.ivNormal);
        ivSad = findViewById(R.id.ivSad);


        ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                if (etName.getText().toString().isEmpty() ||
                        etWebsite.getText().toString().isEmpty() ||
                        etAdress.getText().toString().isEmpty() ||
                        etNumber.getEditableText().toString().isEmpty())
                {

                    Toast.makeText(ContactAddActivity.this,"please enter All fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    String emotion ="happy";
                    String name = etName.getText().toString().trim();
                    String website = etWebsite.getText().toString().trim();
                    String adres = etAdress.getText().toString().trim();
                    String number = etNumber.getText().toString().trim();

                    intent.putExtra("name",name);
                    intent.putExtra("website",website);
                    intent.putExtra("adres",adres);
                    intent.putExtra("number",number);
                    intent.putExtra("emotion", emotion);

                    setResult(RESULT_OK,intent);
                    ContactAddActivity.this.finish();
                }
            }
        });
////////////////////////////////////////////



        ivNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                if (etName.getText().toString().isEmpty() ||
                        etWebsite.getText().toString().isEmpty() ||
                        etAdress.getText().toString().isEmpty() ||
                        etNumber.getEditableText().toString().isEmpty())
                {

                    Toast.makeText(ContactAddActivity.this,"please enter All fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    String emotion ="neutral";
                    String name = etName.getText().toString().trim();
                    String website = etWebsite.getText().toString().trim();
                    String adres = etAdress.getText().toString().trim();
                    String number = etNumber.getText().toString().trim();

                    intent.putExtra("name",name);
                    intent.putExtra("website",website);
                    intent.putExtra("adres",adres);
                    intent.putExtra("number",number);
                    intent.putExtra("emotion", emotion);

                    setResult(RESULT_OK,intent);
                    ContactAddActivity.this.finish();
                }
            }
        });


        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                if (etName.getText().toString().isEmpty() ||
                        etWebsite.getText().toString().isEmpty() ||
                        etAdress.getText().toString().isEmpty() ||
                        etNumber.getEditableText().toString().isEmpty())
                {

                    Toast.makeText(ContactAddActivity.this,"please enter All fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    String emotion ="sad";
                    String name = etName.getText().toString().trim();
                    String website = etWebsite.getText().toString().trim();
                    String adres = etAdress.getText().toString().trim();
                    String number = etNumber.getText().toString().trim();

                    intent.putExtra("name",name);
                    intent.putExtra("website",website);
                    intent.putExtra("adres",adres);
                    intent.putExtra("number",number);
                    intent.putExtra("emotion", emotion);

                    setResult(RESULT_OK,intent);
                    ContactAddActivity.this.finish();
                }
            }
        });

    }
}
