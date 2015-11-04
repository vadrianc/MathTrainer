package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.IRandomGenerator;
import com.adrianconstantin.mathtrainer.exception.UnknownOperationException;
import com.adrianconstantin.mathtrainer.impl.IntegerRandomGenerator;
import com.adrianconstantin.mathtrainer.utils.Utils;

public class OperationHandlerActivity extends AppCompatActivity {

    IOperationHandler mOperationHandler = null;
    IRandomGenerator<Integer> mRandomGenerator = null;

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

    private void init()
    {
        mRandomGenerator = new IntegerRandomGenerator(100);

        EditText resultEditText = (EditText)findViewById(R.id.resultEditText);
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

            }
        });
    }

    private IOperationHandler handleIntent() throws UnknownOperationException {
        Intent intent = getIntent();
        mOperationHandler  = intent.getExtras().getParcelable(Utils.OPERATION);

        if (mOperationHandler == null)
        {
            throw new UnknownOperationException();
        }

        return mOperationHandler;
    }

    private void generateOperands() {
        mOperationHandler.SetFirstOperand(mRandomGenerator.Generate().doubleValue());
        mOperationHandler.SetSecondOperand(mRandomGenerator.Generate().doubleValue());
    }

    private void populateTextView(){
        generateOperands();

        TextView charTextView = (TextView)findViewById(R.id.char_text);
        charTextView.setText(mOperationHandler.GetExpression());
    }

}
