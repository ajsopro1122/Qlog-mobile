package com.example.qlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button btn1 = (Button)findViewById(R.id.walkin);
        Button btn2 = (Button)findViewById(R.id.bookAppointment);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(HomePage.this, WalkIn.class);
                startActivity(int1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(HomePage.this,BookAppointment.class);
                startActivity(int2);
            }
        });
    }
}