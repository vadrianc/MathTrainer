package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.test.CustomResult;
import com.adrianconstantin.mathtrainer.utils.Utils;
import com.facebook.FacebookSdk;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        FacebookSdk.sdkInitialize(getApplicationContext());

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
        strBuilder.append("\n");

        if (result.GetIncorrectAnswers().length() > 0) {
            strBuilder.append("\n");
            strBuilder.append("Incorrect answers:\n");
            strBuilder.append(result.GetIncorrectAnswers());
        }

        if (result.GetCorrectAnswers().length() > 0) {
            strBuilder.append("\n");
            strBuilder.append("Correct answers:\n");
            strBuilder.append(result.GetCorrectAnswers());
        }

        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);
        String resultText = strBuilder.toString();
        // 3 - stands for string single text lines that can occupy multiple lines in the text view.
        resultTextView.setLines(countOccurences(strBuilder.toString(), '\n') + 3);

        if (resultText.contains("<sup>") || resultText.contains("&radic;")) {
            resultTextView.setLines(20);
        }

        if (resultText.contains("<br>")){
            resultText = resultText.replace("\n", "<br>");
            resultTextView.setText(Html.fromHtml("<html>" + resultText + "</html>"));
        }
        else {
            resultTextView.setText(resultText);
        }
    }

    /**
     *
     * @param str
     * @param ch
     * @return
     */
    private int countOccurences(String str, char ch){
        int count = 0;

        for (char chr : str.toCharArray()){
            if (chr == ch) count++;
        }

        return count;
    }

    public void ButtonClickEvent(View view){
        switch (view.getId()) {
            case R.id.facebookBtn:

        }
    }
}
