package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.exception.UnknownOperationException;
import com.adrianconstantin.mathtrainer.natural.NaturalAdditionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalDivisionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalMultiplicationHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalSubtractionHanlder;
import com.adrianconstantin.mathtrainer.utils.Utils;

public class MainMathTrainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_math_trainer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * @param view
     */
    public void ButtonClickEvent(View view) throws UnknownOperationException, IllegalAccessException, InstantiationException {
        Intent intent = new Intent(this, OperationHandlerActivity.class);
        Bundle bundle = new Bundle();

        switch (view.getId())
        {
            case R.id.buttonAddition:
                bundle.putParcelable(Utils.OPERATION, new NaturalAdditionHandler());
                break;
            case R.id.buttonSubtraction:
                bundle.putParcelable(Utils.OPERATION, new NaturalSubtractionHanlder());
                break;
            case R.id.buttonMultiplication:
                bundle.putParcelable(Utils.OPERATION, new NaturalMultiplicationHandler());
                break;
            case R.id.buttonDivision:
                bundle.putParcelable(Utils.OPERATION, new NaturalDivisionHandler());
                break;
            default:
                throw new UnknownOperationException();
        }
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
