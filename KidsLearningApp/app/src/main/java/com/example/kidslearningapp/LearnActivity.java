package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        listView = findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<>();
        int j = 65;
        for (int i = 0; i < 25; i++) {
            arrayList.add(Character.toString((char)j));
            j++;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(LearnActivity.this, android.R.layout.simple_dropdown_item_1line, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LearnActivity.this, "Clicked item: " + position + " " + arrayList.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}