package com.example.textto;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.Bundle;

public class Call extends AppCompatActivity {

    EditText name, number;
    Button backBtn, callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                if(name.getText().toString().isEmpty() && !number.getText().toString().isEmpty()) {
                    Toast.makeText(Call.this, "Enter a name to send to", Toast.LENGTH_LONG).show();
                } else if(!name.getText().toString().isEmpty() && number.getText().toString().isEmpty()) {
                    Toast.makeText(Call.this, "Enter a number to call", Toast.LENGTH_LONG).show();
                } else if(name.getText().toString().isEmpty() && number.getText().toString().isEmpty()) {
                    Toast.makeText(Call.this, "Enter a name and number", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_C)
                }
            }
        });

    }
}
