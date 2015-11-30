package com.adrianconstantin.mathtrainer.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.notification.NotificationReceiver;
import com.adrianconstantin.mathtrainer.setting.OperandType;
import com.adrianconstantin.mathtrainer.setting.OperationDifficulty;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;

import java.util.Calendar;

public class OptionsActivity extends AppCompatActivity {

    /**
     *
     */
    private TimePickerDialog mTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        OperationSettings.Instance().LoadOptions(getApplicationContext());

        initToolbar();
        initDifficultyButton();
        initOperandTypeButton();
        initNotificationCheckBox();
        initTextViewTime();
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
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleExit();
            }
        });
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
     */
    private void initNotificationCheckBox(){
        TextView timeTextView = (TextView)findViewById(R.id.textViewTime);
        ImageButton timeImageButton = (ImageButton) findViewById(R.id.imageEditTime);
        CheckBox notificationCheckBox = (CheckBox)findViewById(R.id.notificationCheckBox);
        notificationCheckBox.setChecked(OperationSettings.Instance().GetIsNotificationEnabled());
        timeTextView.setEnabled(notificationCheckBox.isChecked());
        timeImageButton.setEnabled(notificationCheckBox.isChecked());

        updateTimeTextColor();
    }

    /**
     *
     */
    private void initTextViewTime(){
        int mHour = OperationSettings.Instance().GetHour();
        int mMinute = OperationSettings.Instance().GetMinute();
        mTimePicker = new TimePickerDialog(this, R.style.TimePickerDialogTheme, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                OperationSettings.Instance().SetHour(hourOfDay);
                OperationSettings.Instance().SetMinute(minute);

                TextView timeTextView = (TextView) findViewById(R.id.textViewTime);
                timeTextView.setText(OperationSettings.Instance().GetTime());
            }
        }, mHour, mMinute, true);

        mTimePicker.setTitle("Select Time");

        TextView timeTextView = (TextView) findViewById(R.id.textViewTime);
        timeTextView.setText(OperationSettings.Instance().GetTime());
    }

    /**
     *
     * @param view
     */
    public void onTextViewTimeClicked(View view){
        mTimePicker.show();
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

    /**
     *
     * @param view
     */
    public void onNotificationClicked(View view) {
        if (view.getId() == R.id.notificationCheckBox) {
            TextView timeTextView = (TextView)findViewById(R.id.textViewTime);
            ImageButton timeImageButton = (ImageButton) findViewById(R.id.imageEditTime);
            CheckBox notificationCheckBox = (CheckBox)findViewById(R.id.notificationCheckBox);
            timeTextView.setEnabled(notificationCheckBox.isChecked());
            timeImageButton.setEnabled(notificationCheckBox.isChecked());
            OperationSettings.Instance().SetIsNotificationEnabled(notificationCheckBox.isChecked());

            updateTimeTextColor();
        }
    }

    /**
     *
     */
    private void updateTimeTextColor() {
        TextView timeTextView = (TextView)findViewById(R.id.textViewTime);
        CheckBox notificationCheckBox = (CheckBox)findViewById(R.id.notificationCheckBox);

        if (notificationCheckBox.isChecked()) {
            timeTextView.setTextColor(Color.parseColor("#000000"));
        } else {
            timeTextView.setTextColor(Color.parseColor("#BDBDBD"));
        }
    }

    @Override
    public void onBackPressed() {
        handleExit();
    }

    /**
     *
     */
    private void handleExit() {
        createNotification();
        OperationSettings.Instance().SaveOptions(this.getApplicationContext());
        finish();
    }

    /**
     *
     */
    private void createNotification(){
        if (!OperationSettings.Instance().GetIsNotificationEnabled()) return;

        Intent alarmIntent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, OperationSettings.Instance().GetHour());
        calendar.set(Calendar.MINUTE, OperationSettings.Instance().GetMinute());
        calendar.set(Calendar.SECOND, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }


}
