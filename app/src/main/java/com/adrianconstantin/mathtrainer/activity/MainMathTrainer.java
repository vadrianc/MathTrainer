package com.adrianconstantin.mathtrainer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.base.OperationType;
import com.adrianconstantin.mathtrainer.exception.UnknownOperationException;
import com.adrianconstantin.mathtrainer.integer.IntegerAdditionHandler;
import com.adrianconstantin.mathtrainer.integer.IntegerDivisionHandler;
import com.adrianconstantin.mathtrainer.integer.IntegerMultiplicationHandler;
import com.adrianconstantin.mathtrainer.integer.IntegerSubtractionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalAdditionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalDivisionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalMultiplicationHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalSquarePowerHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalSquareRootHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalSubtractionHanlder;
import com.adrianconstantin.mathtrainer.setting.OperandType;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.optionsItem:
                Intent optionsIntent = new Intent(this, OptionsActivity.class);
                startActivity(optionsIntent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    /**
     *
     * @param view
     */
    public void ButtonClickEvent(View view) throws UnknownOperationException, IllegalAccessException, InstantiationException {
        Intent intent = new Intent(this, OperationHandlerActivity.class);
        Bundle bundle = null;

        switch (OperationSettings.Instance().GetOperandType()) {
            case NATURAL:
                bundle = handleNaturalOperation(view.getId());
                break;
            case INTEGER:
                bundle = handleIntegerOperation(view.getId());
                break;
        }

        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     *
     * @param id
     * @return
     * @throws UnknownOperationException
     */
    private Bundle handleNaturalOperation(int id) throws UnknownOperationException {
        List<Pair<OperandType, OperationType>> operationDescriptors;
        Bundle bundle = new Bundle();

        switch (id)
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
                bundle.putParcelable(Utils.OPERATION, new NaturalSquareRootHandler());
                break;
            case R.id.takeTestSquarePowerAndRoot:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.POWER));
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.ROOT));

                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            default:
                throw new UnknownOperationException();
        }

        return bundle;
    }

    /**
     *
     * @param id
     * @return
     * @throws UnknownOperationException
     */
    private Bundle handleIntegerOperation(int id) throws UnknownOperationException {
        List<Pair<OperandType, OperationType>> operationDescriptors;
        Bundle bundle = new Bundle();

        switch (id)
        {
            case R.id.buttonAddition:
                bundle.putParcelable(Utils.OPERATION, new IntegerAdditionHandler());
                break;
            case R.id.buttonSubtraction:
                bundle.putParcelable(Utils.OPERATION, new IntegerSubtractionHandler());
                break;
            case R.id.buttonMultiplication:
                bundle.putParcelable(Utils.OPERATION, new IntegerMultiplicationHandler());
                break;
            case R.id.buttonDivision:
                bundle.putParcelable(Utils.OPERATION, new IntegerDivisionHandler());
                break;
            case R.id.takeTestButtonAll4:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.ADDITION));
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.SUBSTRACTION));
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.MULTIPLICATION));
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.DIVISION));

                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            case R.id.takeTestButtonAddSub:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.ADDITION));
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.SUBSTRACTION));
                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            case R.id.takeTestButtonMulDiv:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.MULTIPLICATION));
                operationDescriptors.add(new Pair(OperandType.INTEGER, OperationType.DIVISION));

                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            case R.id.buttonSquarePower:
                bundle.putParcelable(Utils.OPERATION, new NaturalSquarePowerHandler());
                break;
            case R.id.buttonSquareRoot:
                bundle.putParcelable(Utils.OPERATION, new NaturalSquareRootHandler());
                break;
            case R.id.takeTestSquarePowerAndRoot:
                operationDescriptors = new ArrayList<Pair<OperandType, OperationType>>();
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.POWER));
                operationDescriptors.add(new Pair(OperandType.NATURAL, OperationType.ROOT));

                bundle.putParcelable(Utils.TEST, new CustomTest(operationDescriptors, Utils.MAX_TEST_QUESTIONS));
                break;
            default:
                throw new UnknownOperationException();
        }

        return bundle;
    }
}
