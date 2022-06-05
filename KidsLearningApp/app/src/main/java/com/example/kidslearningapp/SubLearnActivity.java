package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class SubLearnActivity extends AppCompatActivity {
    ImageView imageView;
    TextView letterDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_learn);
        imageView = findViewById(R.id.imageView);
        letterDisplay = findViewById(R.id.letterDisplay);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            String letter = bundle.getString("letter");
            String result = bundle.getString("result");
            int id = getResources().getIdentifier(letter.toLowerCase(), "drawable", getPackageName());
            Toast.makeText(getApplicationContext(), letter + " for " + result.toString() , Toast.LENGTH_SHORT).show();
            letterDisplay.setText(result.toString());
            imageView.setImageResource(id);
        }
    }

}