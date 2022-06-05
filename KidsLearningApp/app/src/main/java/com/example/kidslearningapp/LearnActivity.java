package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        String[] result = {"Apple", "Ball", "Cat", "Dog", "Elephant", "Fish", "Goat", "Hen",
                "IceCream", "Jug", "Kite", "Lion", "Monkey", "Nest", "Orange", "Parrot",
                "Quack", "Rabbit", "Sparrow", "Tree", "Umbrella", "Van", "Whale", "X-ray", "Yogurt", "Zebra"};
        ArrayList<String> alphaList = new ArrayList<>();
        int j = 65;
        for (int i = 0; i < 26; i++) {
            alphaList.add(Character.toString((char)j));
            j++;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(LearnActivity.this, android.R.layout.simple_dropdown_item_1line, alphaList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LearnActivity.this, SubLearnActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("letter", alphaList.get(position));
                bundle.putString("result", result[position]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}