package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.base.OperationType;
import com.adrianconstantin.mathtrainer.exception.UnknownOperationException;
import com.adrianconstantin.mathtrainer.natural.NaturalAdditionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalDivisionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalMultiplicationHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalSquarePowerHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalSubtractionHanlder;
import com.adrianconstantin.mathtrainer.setting.OperandType;
import com.adrianconstantin.mathtrainer.test.CustomTest;
import com.adrianconstantin.mathtrainer.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainMathTrainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_math_trainer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
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
        List<Pair<OperandType, OperationType>> operationDescriptors;

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
            case R.id.takeTestButtonAll4:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.ADDITION));
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.SUBSTRACTION));
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.MULTIPLICATION));
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.DIVISION));

                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            case R.id.takeTestButtonAddSub:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.ADDITION));
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.SUBSTRACTION));
                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            case R.id.takeTestButtonMulDiv:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.MULTIPLICATION));
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.DIVISION));

                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            case R.id.buttonSquarePower:
                bundle.putParcelable(Utils.OPERATION, new NaturalSquarePowerHandler());
                break;
            case R.id.buttonSquareRoot:
                break;
            case R.id.takeTestSquarePowerAndRoot:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.POWER));

                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            default:
                throw new UnknownOperationException();
        }
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
