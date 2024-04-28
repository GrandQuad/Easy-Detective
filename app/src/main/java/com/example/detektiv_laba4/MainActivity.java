package com.example.detektiv_laba4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnswer = findViewById(R.id.btnAnswer);
    }

    public void btnAnswerClick (View v)
    {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
}