package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.test.CustomResult;
import com.adrianconstantin.mathtrainer.utils.Utils;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initToolbar();
        displayResult();
    }

    /**
     * 
     */
    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.resultToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Test Result");
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.colorTextTitle), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    /**
     *
     */
    private void displayResult(){
        Intent intent = getIntent();
        CustomResult result = intent.getExtras().getParcelable(Utils.TEST_RESULT);

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(result.GetCustomMessage());
        strBuilder.append("\n\n");
        strBuilder.append("Incorrect answers:\n");
        strBuilder.append(result.GetIncorrectAnswers());
        strBuilder.append("\n");
        strBuilder.append("Correct answers:\n");
        strBuilder.append(result.GetCorrectAnswers());

        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);
        resultTextView.setText(strBuilder.toString());
    }
}
