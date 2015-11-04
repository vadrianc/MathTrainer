package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.exception.UnknownOperationException;
import com.adrianconstantin.mathtrainer.utils.Utils;

public class OperationHandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_handler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {
            handleIntent();
        } catch (UnknownOperationException e) {
            e.printStackTrace();
        }
    }

    private IOperationHandler handleIntent() throws UnknownOperationException {
        IOperationHandler operationHandler = null;

        Intent intent = getIntent();
        operationHandler  = intent.getExtras().getParcelable(Utils.OPERATION);

        if (operationHandler == null)
        {
            throw new UnknownOperationException();
        }

        TextView charTextView = (TextView)findViewById(R.id.char_text);
        charTextView.setText(Character.toString(operationHandler.GetOperationSymbol()));

        return operationHandler;
    }
}
