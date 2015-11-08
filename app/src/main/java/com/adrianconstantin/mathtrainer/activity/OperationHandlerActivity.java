package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.IRandomGenerator;
import com.adrianconstantin.mathtrainer.exception.UnknownOperationException;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;
import com.adrianconstantin.mathtrainer.utils.Utils;

public class OperationHandlerActivity extends AppCompatActivity {

    IOperationHandler mOperationHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_handler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        try {
            handleIntent();
        } catch (UnknownOperationException e) {
            e.printStackTrace();
        }

        populateTextView();
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
        if (resultEditText.getText() == null || resultEditText.getText().toString().equals("")) return;

        int resultLength = mOperationHandler.ExecuteOperation().toString().length();
        int inputLength = resultEditText.getText().length();
        int userInput = Integer.parseInt(resultEditText.getText().toString());

        boolean lengthsAreEqual = resultLength == inputLength;
        boolean valuesAreEqual = (Integer)mOperationHandler.ExecuteOperation() == userInput;

        if (valuesAreEqual) {
            mOperationHandler.GenerateOperands();
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
     * @throws UnknownOperationException
     */
    private IOperationHandler handleIntent() throws UnknownOperationException {
        Intent intent = getIntent();
        mOperationHandler  = intent.getExtras().getParcelable(Utils.OPERATION);

        if (mOperationHandler == null)
        {
            throw new UnknownOperationException();
        }

        return mOperationHandler;
    }

    /**
     *
     */
    private void populateTextView(){
        TextView charTextView = (TextView)findViewById(R.id.char_text);
        charTextView.setText(mOperationHandler.GetExpression());

        TextView resultEditText = (TextView)findViewById(R.id.resultEditText);

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(mOperationHandler.ExecuteOperation().toString().length());

        resultEditText.setFilters(filters);
    }
}
