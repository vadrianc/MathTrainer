package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        mCurrentOperationHandler = GetOperationHandler();

        populateTextView();

        // show the keyboard.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
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
        boolean valuesAreEqual = (Integer)mCurrentOperationHandler.ExecuteOperation() == userInput;

        if (valuesAreEqual) {
            mCurrentOperationHandler = GetOperationHandler();
            mCurrentOperationHandler.GenerateOperands();
            populateTextView();
            resultEditText.getText().clear();
        }
        else if (lengthsAreEqual){
            // display warning
        }
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
}
