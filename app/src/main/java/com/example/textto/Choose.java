package com.example.textto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

public class Choose extends AppCompatActivity {

    ImageView call, message;
    Button backButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

        call = findViewById(R.id.imageViewCall);
        message = findViewById(R.id.imageViewMessage);
        backButton = findViewById(R.id.chooseBackBtn);

        ;




    }
}
