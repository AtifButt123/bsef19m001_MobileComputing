package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizActivity extends AppCompatActivity {

    ImageView quizImageView;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button subBtn;
    public static int count = 0;
    ArrayList<String> alphaList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizImageView = findViewById(R.id.quizImageView);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        subBtn = findViewById(R.id.submitBtn);

        ArrayList<String> alphaList = new ArrayList<>();
        int j = 65;
        for (int i = 0; i < 26; i++) {
            alphaList.add(Character.toString((char)j).toLowerCase());
            j++;
        }
//        Collections.shuffle(alphaList);



        Random random = new Random();


        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() <= 10) {
            set.add(random.nextInt(26));
        }

        Object[]setArr = set.toArray();


        int id = getResources().getIdentifier(alphaList.get((int)setArr[0]), "drawable", getPackageName());
        int a = random.nextInt(26);
        int b = random.nextInt(26);
        int c = random.nextInt(26);
        btn1.setText(alphaList.get(a));
        btn2.setText(alphaList.get(b));
        btn3.setText(alphaList.get(c));
        btn4.setText(alphaList.get((int)setArr[0]));
        quizImageView.setImageResource(id);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ++count;
                if(count<10) {
                    int id = getResources().getIdentifier(alphaList.get((int) setArr[count]), "drawable", getPackageName());
                    int a = random.nextInt(26);
                    int b = random.nextInt(26);
                    int c = random.nextInt(26);
                    btn1.setText(alphaList.get(a));
                    btn2.setText(alphaList.get(b));
                    btn3.setText(alphaList.get(c));
                    btn4.setText(alphaList.get((int) setArr[count]));
                    quizImageView.setImageResource(id);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Limit reached", Toast.LENGTH_SHORT).show();
                    count = 0;
                    subBtn.setEnabled(false);
                    Random random = new Random();
                    Set<Integer> set = new LinkedHashSet<Integer>();
                    while (set.size() <= 10) {
                        set.add(random.nextInt(26));
                    }
                }

            }
        });
    }
}