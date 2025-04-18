package com.example.textto;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username, password, time;
        Button logInBtn;

        password = findViewById(R.id.editTextTextPassword);
        logInBtn = findViewById(R.id.button);


    }
}