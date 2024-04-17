package com.example.screens;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the RecyclerView
        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Read data from Intent Bundle and store in variables
        Bundle intentData = getIntent().getExtras();
        String dataName = null;
        int dataAge = 0;
        String dataCareer = null;
        String dataRank = null;
        String dataStatus = null;

        if (intentData != null) {
            dataName = intentData.getString("name");
            dataAge = intentData.getInt("age");
            dataCareer = intentData.getString("career");
            dataRank = intentData.getString("rank");
            dataStatus = intentData.getString("status");
        }

        // Create new RecyclerViewItems instance
        RecyclerViewItems recyclerViewItems = new RecyclerViewItems(dataName, dataAge, dataCareer, dataRank, dataStatus);

        // Initialize a new RecycleView Adapter
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(recyclerViewItems);

        // Get the RecyclerView
        RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);

        myRecyclerView.setAdapter(adapter);

    }
}