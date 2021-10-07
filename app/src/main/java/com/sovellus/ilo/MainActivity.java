package com.sovellus.ilo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.testi.EXTRA_TEXT";
    TextView tvAloitusHeader;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("onClick", "button clicked");
                EditText editTxtName = (EditText) findViewById(R.id.editTxtName);
                String name = editTxtName.getText().toString();

                if (!name.isEmpty()) {
                    Intent intent = new Intent(v.getContext(), HomeActivity.class);
                    intent.putExtra(EXTRA_TEXT, name);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Tarvitaan nimi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}