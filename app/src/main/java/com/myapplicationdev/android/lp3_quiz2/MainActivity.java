package com.myapplicationdev.android.lp3_quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    EditText etTitle, etRemarks;
    Button btnLaunch;
    RadioButton rb;
    int reqCode = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle = findViewById(R.id.etTitle);
        etRemarks = findViewById(R.id.etRemarks);
        btnLaunch = findViewById(R.id.btnLaunch);
        rg = findViewById(R.id.rg);

      

        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, TaskReminderReceiver.class);
                i.putExtra("title", etTitle.getText().toString());
                i.putExtra("remark", etRemarks.getText().toString());
                int radio = rg.getCheckedRadioButtonId();
                rb = findViewById(radio);
                i.putExtra("radiobutton",rb.getText().toString());

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        MainActivity.this, reqCode,
                        i, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)
                        getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        pendingIntent);

            }
        });
    }
}
