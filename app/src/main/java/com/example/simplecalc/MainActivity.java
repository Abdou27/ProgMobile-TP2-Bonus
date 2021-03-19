package com.example.simplecalc;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    Button buttonPlusOrMinus, buttonDot, buttonDelete, buttonResult;
    Button buttonMemorise, buttonRecallMemory, buttonLeftPar, buttonRightPar;
    Button buttonPower, buttonClear;

    TextView resultTextView;

    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(button1OnClickListener);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(button2OnClickListener);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(button3OnClickListener);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(button4OnClickListener);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(button5OnClickListener);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(button6OnClickListener);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(button7OnClickListener);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(button8OnClickListener);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(button9OnClickListener);
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(button0OnClickListener);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(buttonAddOnClickListener);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(buttonSubtractOnClickListener);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(buttonMultiplyOnClickListener);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(buttonDivideOnClickListener);

        buttonPlusOrMinus = findViewById(R.id.buttonPlusOrMinus);
        buttonPlusOrMinus.setOnClickListener(buttonPlusOrMinusOnClickListener);
        buttonDot = findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(buttonDotOnClickListener);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(buttonDeleteOnClickListener);
        buttonResult = findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(buttonResultOnClickListener);

        buttonMemorise = findViewById(R.id.buttonMemorise);
        buttonMemorise.setOnClickListener(buttonMemoriseOnClickListener);
        buttonRecallMemory = findViewById(R.id.buttonRecallMemory);
        buttonRecallMemory.setOnClickListener(buttonRecallMemoryOnClickListener);
        buttonLeftPar = findViewById(R.id.buttonLeftParentheses);
        buttonLeftPar.setOnClickListener(buttonLeftParOnClickListener);
        buttonRightPar = findViewById(R.id.buttonRightParentheses);
        buttonRightPar.setOnClickListener(buttonRightParOnClickListener);

        buttonPower = findViewById(R.id.buttonPower);
        buttonPower.setOnClickListener(buttonPowerOnClickListener);
        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(buttonClearOnClickListener);

        resultTextView = findViewById(R.id.resultTextView);
    }

    private final View.OnClickListener button1OnClickListener = v -> {
        checkNaN();
        result = result + "1";
        updateResultTextView();
    };
    private final View.OnClickListener button2OnClickListener = v -> {
        checkNaN();
        result = result + "2";
        updateResultTextView();
    };
    private final View.OnClickListener button3OnClickListener = v -> {
        checkNaN();
        result = result + "3";
        updateResultTextView();
    };
    private final View.OnClickListener button4OnClickListener = v -> {
        checkNaN();
        result = result + "4";
        updateResultTextView();
    };
    private final View.OnClickListener button5OnClickListener = v -> {
        checkNaN();
        result = result + "5";
        updateResultTextView();
    };
    private final View.OnClickListener button6OnClickListener = v -> {
        checkNaN();
        result = result + "6";
        updateResultTextView();
    };
    private final View.OnClickListener button7OnClickListener = v -> {
        checkNaN();
        result = result + "7";
        updateResultTextView();
    };
    private final View.OnClickListener button8OnClickListener = v -> {
        checkNaN();
        result = result + "8";
        updateResultTextView();
    };
    private final View.OnClickListener button9OnClickListener = v -> {
        checkNaN();
        result = result + "9";
        updateResultTextView();
    };
    private final View.OnClickListener button0OnClickListener = v -> {
        checkNaN();
        result = result + "0";
        updateResultTextView();
    };
    private final View.OnClickListener buttonAddOnClickListener = v -> {
        checkNaN();
        Character c = result.charAt(result.length() - 1);
        if (c.equals('-') || c.equals('*') || c.equals('/') || c.equals('.')) {
            if (result.length() > 0) {
                result =  result.substring(0, result.length() - 1);
            }
        }
        result = result + "+";
        updateResultTextView();
    };
    private final View.OnClickListener buttonSubtractOnClickListener = v -> {
        checkNaN();
        Character c = result.charAt(result.length() - 1);
        if (c.equals('+') || c.equals('*') || c.equals('/') || c.equals('.')) {
            if (result.length() > 0) {
                result =  result.substring(0, result.length() - 1);
            }
        }
        result = result + "-";
        updateResultTextView();
    };
    private final View.OnClickListener buttonMultiplyOnClickListener = v -> {
        checkNaN();
        Character c = result.charAt(result.length() - 1);
        if (c.equals('+') || c.equals('-') || c.equals('/') || c.equals('.')) {
            if (result.length() > 0) {
                result =  result.substring(0, result.length() - 1);
            }
        }
        result = result + "*";
        updateResultTextView();
    };
    private final View.OnClickListener buttonDivideOnClickListener = v -> {
        checkNaN();
        Character c = result.charAt(result.length() - 1);
        if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('.')) {
            if (result.length() > 0) {
                result =  result.substring(0, result.length() - 1);
            }
        }
        result = result + "/";
        updateResultTextView();
    };
    private final View.OnClickListener buttonPlusOrMinusOnClickListener = v -> {
        checkNaN();
        if(result.startsWith("-")) {
            result = result.substring(1);
        } else {
            result = "-" + result;
        }
        updateResultTextView();
    };
    private final View.OnClickListener buttonDotOnClickListener = v -> {
        checkNaN();
        Character c = result.charAt(result.length() - 1);
        if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
            result = result + "0";
        }
        result = result + ".";
        updateResultTextView();
    };
    private final View.OnClickListener buttonDeleteOnClickListener = v -> {
        checkNaN();
        if (result.length() > 0) {
            result =  result.substring(0, result.length() - 1);
        }
        updateResultTextView();
    };
    private final View.OnClickListener buttonResultOnClickListener = v -> {
        Expression e = new Expression(result);
        result = String.valueOf(e.calculate());
        if (!result.equals("NaN") && result.endsWith(".0") && Math.floor(Double.parseDouble(result)) == Double.parseDouble(result))
            result = result.substring(0, result.length() - 2);
        updateResultTextView();
    };
    private final View.OnClickListener buttonMemoriseOnClickListener = v -> {
        SharedPreferences settings = getSharedPreferences("SimpleCalcPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("memorisedResult", result);
        editor.commit();

        Toast.makeText(this, "Memorised " + result, Toast.LENGTH_LONG).show();
    };
    private final View.OnClickListener buttonRecallMemoryOnClickListener = v -> {
        SharedPreferences settings = getSharedPreferences("SimpleCalcPref", Context.MODE_PRIVATE);
        result = settings.getString("memorisedResult", "");
        updateResultTextView();
    };
    private final View.OnClickListener buttonLeftParOnClickListener = v -> {
        checkNaN();
        result = result + "(";
        updateResultTextView();
    };
    private final View.OnClickListener buttonRightParOnClickListener = v -> {
        checkNaN();
        result = result + ")";
        updateResultTextView();
    };
    private final View.OnClickListener buttonPowerOnClickListener = v -> {
        checkNaN();
        result = result + "^";
        updateResultTextView();
    };
    private final View.OnClickListener buttonClearOnClickListener = v -> {
        result = "";
        updateResultTextView();
    };
    private void updateResultTextView() {
        resultTextView.setText(result);
    }
    private void checkNaN() {result = result.equals("NaN") ? "" : result; }
}