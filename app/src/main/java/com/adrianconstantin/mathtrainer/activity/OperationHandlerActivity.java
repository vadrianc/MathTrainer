package com.adrianconstantin.mathtrainer.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.base.IOperationHandler;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_handler);
        setupToolbar();

        init();
        mCurrentOperationHandler = GetOperationHandler();

        populateTextView();

        // show the keyboard.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
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
    private void init()
    {
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
                resultEditText.getText().toString().equals("-")) return;

        int resultLength = mCurrentOperationHandler.ExecuteOperation().toString().length();
        int inputLength = resultEditText.getText().length();

        int userInput = Integer.parseInt(resultEditText.getText().toString());

        boolean lengthsAreEqual = resultLength == inputLength;
        boolean isAnswerGreater = mCurrentOperationHandler.ExecuteOperation().intValue() < Integer.parseInt(resultEditText.getText().toString());
        boolean valuesAreEqual = (Integer)mCurrentOperationHandler.ExecuteOperation() == userInput;

        if (valuesAreEqual) {
            displayConfirmationImage(R.mipmap.ic_thumb_up);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mCurrentOperationHandler = GetOperationHandler();
                    mCurrentOperationHandler.GenerateOperands();
                    populateTextView();
                    final EditText resultEditText = (EditText)findViewById(R.id.resultEditText);
                    resultEditText.getText().clear();
                    hideConfirmationImage();
                }
            }, 1000);
        }
        else if (lengthsAreEqual || isAnswerGreater) {
            displayConfirmationImage(R.mipmap.ic_thumb_down);
        }
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
    private IOperationHandler GetOperationHandler() {
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
        charTextView.setText(mCurrentOperationHandler.GetExpression());

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
            case R.id.pencilImg:
                TextView charTextView = (TextView)findViewById(R.id.char_text);
                charTextView.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }
}
