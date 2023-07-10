package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText titleEditText,descriptionEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        titleEditText= findViewById(R.id.tile);
        descriptionEditText= findViewById(R.id.description);

        Button WhatsApp=findViewById(R.id.whatsApp);
        Button browser=findViewById(R.id.Website);
        Button call=findViewById(R.id.call);
        Button send=findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                if (title.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please write your Subject", Toast.LENGTH_SHORT).show();
                } else if (description.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please write your Message", Toast.LENGTH_SHORT).show();
                } else {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tariqsbadar@gmail.com", "kkaleemuddin@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, description);
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
            }
        });

        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com"));
                startActivity(browserIntent);
            }
        });
        WhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone=+92 3344856560";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        call.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                String phoneNumber = "tel:" + "+92 3344856560";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(phoneNumber));
                startActivity(dialIntent);
            }
        });

    }
}