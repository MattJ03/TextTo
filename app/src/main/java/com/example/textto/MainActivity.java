package com.example.textto;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;


import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username, password, time;
        Button logInBtn, tocBtn;
        Handler handler = new Handler();
        Runnable getTime;

        password = findViewById(R.id.editTextTextPassword);
        username = findViewById(R.id.usernameText);
        logInBtn = findViewById(R.id.button);
        time = findViewById(R.id.editTextTime);
        tocBtn = findViewById(R.id.button2);

        getTime = new Runnable() {
            @Override
            public void run() {
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd:MM:yyyy"));
            time.setText(currentTime);
            handler.postDelayed(this, 1000);
            }
        };
        handler.post(getTime);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Either or both fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Friends.class);
                    startActivity(intent);
                }
            }
        });

        tocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tocIntent = new Intent(MainActivity.this, TOC.class);
                startActivity(tocIntent);
            }
        });

    }
}