package com.example.textto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.Manifest;
public class Choose extends AppCompatActivity {

    ImageView call, message;
    Button backButton;
    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

        call = findViewById(R.id.imageViewCall);
        message = findViewById(R.id.imageViewMessage);
        backButton = findViewById(R.id.chooseBackBtn);

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(Choose.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Choose.this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                }
                Intent intent = new Intent(Choose.this, Friends.class);
                startActivity(intent);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(Choose.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Choose.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                } Intent intent = new Intent(Choose.this, Call.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
