package com.example.practical_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTemplate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        // region Activity
        Button BtnGoToMain = findViewById(R.id.BtnGoToMain);

        BtnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTemplate.this, MainActivity.class);
                startActivity(intent);
                // called to perform onDestroy(), very optional
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("template stopping");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("template activity being destroyed");
    }
}