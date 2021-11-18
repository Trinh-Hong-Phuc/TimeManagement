package com.example.timemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class BaoThuc extends AppCompatActivity {
    Button btnSetup, btnStop;
    TextView txtHienThi;
    TimePicker timePicker;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_thuc);

        btnSetup = (Button) findViewById(R.id.btnSetup);
        btnStop = (Button) findViewById(R.id.btnStop);
        txtHienThi = (TextView) findViewById(R.id.textView);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final Intent intent = new Intent(BaoThuc.this,ALarmReceiver.class);
        btnSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());

                int gio = timePicker.getCurrentHour();
                int phut = timePicker.getCurrentMinute();

                String string_gio = String.valueOf(gio);
                String string_phut = String.valueOf(phut);

                if (gio > 12) {
                    string_gio = String.valueOf(gio - 12);
                }
                if (phut < 10) {
                    string_phut = "0" + String.valueOf(phut);
                }
                intent.putExtra("extra", "on");
                pendingIntent = PendingIntent.getBroadcast(BaoThuc.this, 0, intent, pendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(alarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                txtHienThi.setText("Your alarm time is " + string_gio + ":" + string_phut);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHienThi.setText("Stop");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra","off");
                sendBroadcast(intent);
            }
        });

    }
}