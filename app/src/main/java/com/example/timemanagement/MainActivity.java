package com.example.timemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button BaoThuc;
    private Button DemNguoc;
    private Button BamGio;
    private Button GioiThieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaoThuc = (Button) this.findViewById(R.id.baothuc);
        BaoThuc.setOnClickListener(this::onClick2);

        DemNguoc = (Button) this.findViewById(R.id.demnguoc);
        DemNguoc.setOnClickListener(this::onClick);

        BamGio = (Button) this.findViewById(R.id.bamgio);
        BamGio.setOnClickListener(this::onClick1);

        GioiThieu = (Button) this.findViewById(R.id.gioithieu);
        GioiThieu.setOnClickListener(this::onClick3);

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, DemNguoc.class);
        startActivity(intent);
    }
    public void onClick1(View view) {
        Intent intent = new Intent(this, BamGio.class);
        startActivity(intent);
    }
    public void onClick2(View view) {
        Intent intent = new Intent(this, BaoThuc.class);
        startActivity(intent);
    }
    public void onClick3(View view) {
        Intent intent = new Intent(this, BannerActivity.class);
        startActivity(intent);
    }
}