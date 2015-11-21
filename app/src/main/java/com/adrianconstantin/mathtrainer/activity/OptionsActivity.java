package com.adrianconstantin.mathtrainer.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.setting.OperandType;
import com.adrianconstantin.mathtrainer.setting.OperationDifficulty;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        initToolbar();
        initDifficultyButton();
        initOperandTypeButton();
    }

    /**
     *
     */
    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.optionsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Options");
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.colorTextTitle), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    /**
     *
     */
    private void initDifficultyButton(){
        RadioButton difficultyBtn = null;

        switch (OperationSettings.Instance().GetOperationDifficulty()){
            case EASY:
                difficultyBtn = (RadioButton) findViewById(R.id.radio_easy);
                break;
            case NORMAL:
                difficultyBtn = (RadioButton) findViewById(R.id.radio_normal);
                break;
            case HARD:
                difficultyBtn = (RadioButton) findViewById(R.id.radio_hard);
                break;
        }

        difficultyBtn.setChecked(true);
    }

    /**
     *
     */
    private void initOperandTypeButton(){
        RadioButton operandTypeBtn = null;

        switch (OperationSettings.Instance().GetOperandType()){
            case NATURAL:
                operandTypeBtn = (RadioButton) findViewById(R.id.radio_natural);
                break;
            case INTEGER:
                operandTypeBtn = (RadioButton) findViewById(R.id.radio_integer);
                break;
        }

        operandTypeBtn.setChecked(true);
    }

    /**
     *
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        if (!checked) return;

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_easy:
                OperationSettings.Instance().SetOperationDifficulty(OperationDifficulty.EASY);
                break;
            case R.id.radio_normal:
                OperationSettings.Instance().SetOperationDifficulty(OperationDifficulty.NORMAL);
                break;
            case R.id.radio_hard:
                OperationSettings.Instance().SetOperationDifficulty(OperationDifficulty.HARD);
                break;
            case R.id.radio_natural:
                OperationSettings.Instance().SetOperandType(OperandType.NATURAL);
                break;
            case R.id.radio_integer:
                OperationSettings.Instance().SetOperandType(OperandType.INTEGER);
                break;
        }
    }
}
