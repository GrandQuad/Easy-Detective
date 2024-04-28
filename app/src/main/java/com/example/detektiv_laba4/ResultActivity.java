package com.example.detektiv_laba4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static String BUTTON_CHOOSE = "BUTTON_CHOOSE";

    TextView animalName;
    ImageView animalImage;
    Button btnYes, btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        animalName = findViewById(R.id.animalName);
        animalImage = findViewById(R.id.animalImage);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

        Bundle arguments = getIntent().getExtras();
        int animalChoose = arguments.getInt(QuestionActivity.ANIMAL);

        switch (animalChoose)
        {
            case 1:
                animalImage.setImageResource(R.drawable.lisa);
                animalName.setText(QuestionActivity.animaList[0]);
                break;
            case 2:
                animalImage.setImageResource(R.drawable.dog);
                animalName.setText(QuestionActivity.animaList[1]);
                break;
            case 3:
                animalImage.setImageResource(R.drawable.kot);
                animalName.setText(QuestionActivity.animaList[2]);
                break;
        }

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        Intent intent = new Intent();
        int chooseBtn;

        if (v.getId() == R.id.btnYes)
        {
         chooseBtn = 1;
        }
        else
        {
         chooseBtn = 2;
        }

        intent.putExtra(BUTTON_CHOOSE, chooseBtn);
        setResult(RESULT_OK, intent);
        finish();
    }

}
