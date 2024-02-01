package com.example.practical_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical_3.ViewHolderAdapterTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ActivityTemplate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        // region get extra information from calling activity
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        System.out.println(username);
        System.out.println(password);

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

        // region recyclerView
        RecyclerView recyclerView = findViewById(R.id.RVTemplate);
        final ViewHolderAdapterTemplate adapter = new ViewHolderAdapterTemplate(new ViewHolderAdapterTemplate.NoteDiff());
        recyclerView.setAdapter(adapter);
        // can choose other layoutManager like GridLayoutManager but usually LinearLayoutManager is more than enough
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // usually will fetch something from somewhere but this is just a mock of data to be presented
        String[] mockArray = {
                "Mock String 1",
                "Mock String 2",
                "Mock String 3",
                "Mock String 4",
                "Mock String 5",
                "Mock String 6",
                "Mock String 7",
                "Mock String 8",
                "Mock String 9",
                "Mock String 10"
        };
        List<String> mockData = new ArrayList<String>(Arrays.asList(mockArray));
        adapter.submitList(mockData);
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