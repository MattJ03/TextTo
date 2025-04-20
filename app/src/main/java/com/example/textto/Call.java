package com.example.textto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.Bundle;
import android.Manifest;

import java.security.Permission;

public class Call extends AppCompatActivity {

    EditText name, number;
    Button backBtn, callBtn;
    private static final int CALL_PHONE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (ActivityCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Call.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PHONE_PERMISSIONS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);

        name = findViewById(R.id.editTextCallName);
        number = findViewById(R.id.editTextPhone2);
        backBtn = findViewById(R.id.buttonBackCall);
        callBtn = findViewById(R.id.buttonCall);

        name.hasFocus();

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if (name.getText().toString().isEmpty() && !number.getText().toString().isEmpty()) {
                        Toast.makeText(Call.this, "Enter a name to send to", Toast.LENGTH_LONG).show();
                    } else if (!name.getText().toString().isEmpty() && number.getText().toString().isEmpty()) {
                        Toast.makeText(Call.this, "Enter a number to call", Toast.LENGTH_LONG).show();
                    } else if (name.getText().toString().isEmpty() && number.getText().toString().isEmpty()) {
                        Toast.makeText(Call.this, "Enter a name and number", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + number.getText().toString()));
                        startActivity(intent);
                    }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setText("");
                name.setText("");
                Intent intent = new Intent(Call.this, Choose.class);
                startActivity(intent);
            }
        });
    }
}
