package com.myapplicationdev.android.lp3_quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    EditText etTitle, etRemarks;
    Button btnLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle = findViewById(R.id.etTitle);
        etRemarks = findViewById(R.id.etRemarks);
        rg = findViewById(R.id.rg);

      

        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, );
                //dummy
                String a = "";
                i.putExtra("data1", a);
                sendBroadcast(i);
            }
        });

    }
}
