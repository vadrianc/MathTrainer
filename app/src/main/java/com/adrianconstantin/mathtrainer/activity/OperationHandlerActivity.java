package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.exception.TestFinishedException;
import com.adrianconstantin.mathtrainer.test.ITest;
import com.adrianconstantin.mathtrainer.utils.Utils;


public class OperationHandlerActivity extends AppCompatActivity {

    /**
     *
     */
    IOperationHandler mOperationHandler = null;

    /**
     *
     */
    IOperationHandler mCurrentOperationHandler = null;

    /**
     *
     */
    ITest mTest = null;

    /**
     *
     */
    boolean mBlockResultHandler = false;

    /**
     *
     */
    int mWrongAnswerCount = 0;

    /**
     *
     */
    ImageButton mHelpMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_handler);

        try {
            init();
        } catch (TestFinishedException e) {
            finish();
        }
    }

    /**
     *
     */
    private void init() throws TestFinishedException {
        setupToolbar();
        setupEditText();

        mCurrentOperationHandler = GetOperationHandler();

        setupTitle();
        populateTextView();

        // show the keyboard.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        initHelpMeButton();
    }

    /**
     *
     */
    private void initHelpMeButton(){
        mHelpMeButton = new ImageButton(OperationHandlerActivity.this);
        mHelpMeButton.setId(R.id.helpMeBtn);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.width = (int) getResources().getDimension(R.dimen.help_me_btn_width);
        params.height = (int) getResources().getDimension(R.dimen.help_me_btn_height);
        int margin = (int) getResources().getDimension(R.dimen.control_margin);
        params.setMargins(margin, margin, margin, margin);
        mHelpMeButton.setImageResource(R.mipmap.ic_help_me);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        mHelpMeButton.setLayoutParams(params);
        mHelpMeButton.setBackgroundColor(Color.TRANSPARENT);

        mHelpMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickEvent(v);
            }
        });
    }

    /**
     *
     */
    private void setupTitle(){
        if (mOperationHandler != null){
            getSupportActionBar().setTitle(mOperationHandler.GetOperationName());
            return;
        }

        updateTitleForTest();
    }

    /**
     *
     */
    private void updateTitleForTest(){
        if (mTest != null) {
            String title = String.format("%s %s",
                    getResources().getString(R.string.toolbar_title_test),
                    mTest.GetProgress());
            getSupportActionBar().setTitle(title);
        }
    }

    /**
     *
     */
    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.opToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.colorTextTitle), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    /**
     *
     */
    private void setupEditText(){
        final EditText resultEditText = (EditText)findViewById(R.id.resultEditText);
        resultEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No implementation.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No implementation.
            }

            @Override
            public void afterTextChanged(Editable s) {
                handleTextChange(resultEditText);
            }
        });
    }

    /**
     *
     */
    private void handleTextChange(EditText resultEditText)
    {
        if (resultEditText.getText() == null ||
                resultEditText.getText().toString().equals("") ||
                resultEditText.getText().toString().equals("-") ||
                mBlockResultHandler == true) return;

        int resultLength = mCurrentOperationHandler.ExecuteOperation().toString().length();
        int inputLength = resultEditText.getText().length();

        int userInput = Integer.parseInt(resultEditText.getText().toString());

        boolean showConfirmation = resultLength <= inputLength;
        boolean valuesAreEqual = (Integer)mCurrentOperationHandler.ExecuteOperation() == userInput;

        if (valuesAreEqual) {
            if (mTest != null) {
                mTest.GetResult().PutCorrectAnswer(mCurrentOperationHandler.GetExpression(), resultEditText.getText().toString());
            }
            else {
                handleCorrectAnswer();
            }

            displayConfirmationImage(R.mipmap.ic_thumb_up);
            handleNextOperation();
        }
        else if (showConfirmation) {
            displayConfirmationImage(R.mipmap.ic_thumb_down);

            if (mTest != null) {
                mTest.GetResult().PutIncorrectAnswer(mCurrentOperationHandler.GetExpression(),
                        resultEditText.getText().toString(),
                        mCurrentOperationHandler.ExecuteOperation().toString());
                mBlockResultHandler = true;
                handleNextOperation();
            }
            else {
                handleWrongAnswer();
            }
        }
        else {
            hideConfirmationImage();
        }
    }

    /**
     *
     */
    private void handleWrongAnswer() {
        mWrongAnswerCount++;

        if(mWrongAnswerCount == 5) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.editLayout);
            layout.addView(mHelpMeButton);

            EditText editor = (EditText)findViewById(R.id.resultEditText);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)editor.getLayoutParams();
            int margin = (int) getResources().getDimension(R.dimen.control_margin);
            params.setMargins(margin, margin, 0, margin);
        }
    }

    /**
     *
     */
    private void handleCorrectAnswer() {
        mWrongAnswerCount = 0;
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.editLayout);
        layout.removeView(mHelpMeButton);

        EditText editor = (EditText)findViewById(R.id.resultEditText);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)editor.getLayoutParams();
        int margin = (int) getResources().getDimension(R.dimen.control_margin);
        params.setMargins(margin, margin, margin, margin);
    }

    /**
     *
     */
    private void handleNextOperation(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean testFinishedExceptionThrown = false;

                try {
                    mCurrentOperationHandler = GetOperationHandler();
                } catch (TestFinishedException e) {
                    testFinishedExceptionThrown = true;
                }

                if (testFinishedExceptionThrown) {
                    Intent intent = new Intent(OperationHandlerActivity.this, ResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(Utils.TEST_RESULT, (Parcelable) mTest.GetResult());
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    return;
                }

                mCurrentOperationHandler.GenerateOperands();
                populateTextView();
                final EditText resultEditText = (EditText) findViewById(R.id.resultEditText);
                resultEditText.getText().clear();
                hideConfirmationImage();
                updateTitleForTest();
                mBlockResultHandler = false;
            }
        }, 3000);
    }

    /**
     *
     * @param id
     */
    private void displayConfirmationImage(int id){
        ImageView answerConfirmImg = (ImageView)findViewById(R.id.answerConfirmImg);
        answerConfirmImg.setImageResource(id);
        answerConfirmImg.setVisibility(View.VISIBLE);
    }

    /**
     *
     */
    private void hideConfirmationImage(){
        ImageView answerConfirmImg = (ImageView)findViewById(R.id.answerConfirmImg);
        answerConfirmImg.setVisibility(View.GONE);
    }

    /**
     *
     * @return
     */
    private IOperationHandler GetOperationHandler() throws TestFinishedException {
        if (mOperationHandler == null && mTest == null) {
            Intent intent = getIntent();
            mOperationHandler = intent.getExtras().getParcelable(Utils.OPERATION);
            mTest = intent.getExtras().getParcelable(Utils.TEST);
        }

        if (mOperationHandler != null) return mOperationHandler;

        return mTest.GetNextOperation();
    }

    /**
     *
     */
    private void populateTextView(){
        TextView charTextView = (TextView)findViewById(R.id.char_text);

        if (mCurrentOperationHandler.GetOperationSymbol() != 0) {
            charTextView.setText(mCurrentOperationHandler.GetExpression());
        }
        else {
            charTextView.setText(Html.fromHtml(mCurrentOperationHandler.GetExpression()));
        }

        TextView resultEditText = (TextView)findViewById(R.id.resultEditText);

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(mCurrentOperationHandler.GetResultMaxLength());

        resultEditText.setFilters(filters);
    }

    /**
     *
     * @param view
     */
    public void ButtonClickEvent(View view){
        switch (view.getId()) {
            case R.id.helpMeBtn:
                EditText resultEditText = (EditText)findViewById(R.id.resultEditText);
                resultEditText.setText(mCurrentOperationHandler.ExecuteOperation().toString());
        }
    }
}
