package com.example.textto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class Friends extends AppCompatActivity {

    EditText textMessage, textPhone;
    Button buttonSend, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);

        textPhone = findViewById(R.id.editTextPhone);
        textMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        buttonBack = findViewById(R.id.buttonBack);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textPhone.getText().toString().isEmpty() && !textMessage.getText().toString().isEmpty()) {
                  Toast.makeText(Friends.this, "Enter a phone number to send to", Toast.LENGTH_LONG).show();
                } else if(!textPhone.getText().toString().isEmpty() && textMessage.getText().toString().isEmpty()) {
                    Toast.makeText(Friends.this, "Enter a message to send", Toast.LENGTH_LONG).show();
                } else if(textPhone.getText().toString().isEmpty() && textMessage.getText().toString().isEmpty()) {
                    Toast.makeText(Friends.this, "Enter phone number and message to send", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:" + textPhone.getText().toString()));
                    intent.putExtra("sms_body", textMessage.getText().toString());

                    startActivity(intent);
                    textPhone.setText("");
                    textMessage.setText("");
                    Toast.makeText(Friends.this, "Message Sent", Toast.LENGTH_LONG).show();
                     Intent returnBackIntent = new Intent(Friends.this, MainActivity.class);


                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textMessage.setText("");
                textPhone.setText("");
                Intent backIntent = new Intent(Friends.this, MainActivity.class);
                startActivity(backIntent);
            }
        });

    }
}
