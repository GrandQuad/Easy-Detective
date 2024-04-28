package com.example.detektiv_laba4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity  {

    public static final String ANIMAL = "Animal";
    public static final int RESULT_VIEW = 1;
    TextView textViewResult;
    RadioButton radioDog, radioCat, radioLisa;
    public static String [] animaList = new String[3];
    int choose = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        textViewResult = findViewById(R.id.textViewResult);
        radioCat = findViewById(R.id.radio_cat);
        radioDog = findViewById(R.id.radio_dog);
        radioLisa = findViewById(R.id.radio_lisa);
        animaList = getResources().getStringArray(R.array.animaList);

        radioCat.setText(animaList[2]);
        radioDog.setText(animaList[1]);
        radioLisa.setText(animaList[0]);


    }

    public void onRadioClick(View v)
    {
     Intent intent = new Intent(this, ResultActivity.class);
     if (v.getId() == R.id.radio_lisa) {
         choose = 1;
     }

     if (v.getId() == R.id.radio_dog) {
             choose = 2;
     }
     if (v.getId() == R.id.radio_cat) {
         choose = 3;
     }


     intent.putExtra(ANIMAL, choose);
     startActivityForResult(intent, RESULT_VIEW);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null)
        {
            if (requestCode == RESULT_VIEW && resultCode == RESULT_OK)
            {
                int chooseBtn = data.getIntExtra(ResultActivity.BUTTON_CHOOSE, 0);

                if (chooseBtn == 1)
                {
                    if (choose == 3)
                    {
                        textViewResult.setTextColor(getResources().getColor(R.color.green));
                        textViewResult.setText(getResources().getString(R.string.yesBtnY, animaList[choose - 1]));
                    }
                    else
                    {
                        textViewResult.setTextColor(getResources().getColor(R.color.blue));
                        textViewResult.setText(getResources().getString(R.string.yesBtn, animaList[choose - 1]));
                    }
                }

                if (chooseBtn == 2)
                {
                    if (choose == 3)
                    {
                        textViewResult.setTextColor(getResources().getColor(R.color.green));
                        textViewResult.setText(getResources().getString(R.string.noBtnN, animaList[choose - 1]));
                    }
                    else
                    {
                        textViewResult.setTextColor(getResources().getColor(R.color.blue));
                        textViewResult.setText(getResources().getString(R.string.noBtn, animaList[choose - 1]));
                    }
                }
            }
        }
    }
}
