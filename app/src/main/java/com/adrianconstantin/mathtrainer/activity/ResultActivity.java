package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.test.CustomResult;
import com.adrianconstantin.mathtrainer.utils.Utils;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        displayResult();
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
