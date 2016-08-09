package com.example.dmitry.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

/**
 * Created by Dmitry on 07.08.2016.
 */
public class CalculatorFactorialSumDigitsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLog";
    private Button button0, button1,button2,button3,button4,
            button5,button6,button7,button8,button9,button_del,
            central_button_calc, button_calc;
    private Button button_palindrome, button_pairs;
    private EditText editText_number;
    private TextView textView_resault_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_factorial_sum_digits);
        editText_number = (EditText) findViewById(R.id.editText_number);
        textView_resault_field = (TextView) findViewById(R.id.resault_field);

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);
        button_calc = (Button) findViewById(R.id.button_execute);
        button_calc.setOnClickListener(this);

        central_button_calc = (Button) findViewById(R.id.central_button_calc);
        central_button_calc.setOnClickListener(this);

        button_del = (Button) findViewById(R.id.button_del_numb);
        button_del.setOnClickListener(this);

        button_palindrome = (Button) findViewById(R.id.button_palindrome_activity);
        button_palindrome.setOnClickListener(this);

        button_pairs = (Button) findViewById(R.id.button_pairs_activity);
        button_pairs.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:{
                if (editText_number.length() > 0)
                editText_number.setText(editText_number.getText()+"0");
            }break;
            case R.id.button1:{
                editText_number.setText(editText_number.getText()+"1");
            }break;
            case R.id.button2:{
                editText_number.setText(editText_number.getText()+"2");
            }break;
            case R.id.button3:{
                editText_number.setText(editText_number.getText()+"3");
            }break;
            case R.id.button4:{
                editText_number.setText(editText_number.getText()+"4");
            }break;
            case R.id.button5:{
                editText_number.setText(editText_number.getText()+"5");
            }break;
            case R.id.button6:{
                editText_number.setText(editText_number.getText()+"6");
            }break;
            case R.id.button7:{
                editText_number.setText(editText_number.getText()+"7");
            }break;
            case R.id.button8:{
                editText_number.setText(editText_number.getText()+"8");
            }break;
            case R.id.button9:{
                editText_number.setText(editText_number.getText()+"9");
            }break;


            case R.id.button_del_numb:{
                if (editText_number.getText().length() > 0)
                editText_number.setText(editText_number.getText().subSequence(0,
                        editText_number.getText().length()-1));
            }break;

            case R.id.central_button_calc:{
                if (editText_number.length() > 0) {
                    int value = Integer.valueOf(editText_number.getText().toString());
                    FactorialDigitSum factorialDigitSum = new FactorialDigitSum(value);
                    textView_resault_field.setText(factorialDigitSum.getDigitSum());
                }

            }break;

            case R.id.button_execute:{
                if (editText_number.length() > 0) {
                    int value = Integer.valueOf(editText_number.getText().toString());
                    FactorialDigitSum factorialDigitSum = new FactorialDigitSum(value);
                    textView_resault_field.setText(factorialDigitSum.getDigitSum());
                }

            }break;

            case R.id.button_palindrome_activity:{
                Log.d(TAG, "palindrome");
                Intent palindrome_activity = new Intent(this, CalculatorPalindromeActivity.class);
                palindrome_activity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(palindrome_activity);
               finish();

            }
            break;
            case R.id.button_pairs_activity:{
                Intent pairs_activity = new Intent(this, CalculatorPairsActivity.class);
                pairs_activity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pairs_activity);
                finish();

            } break;


        }
        editText_number.setSelection(editText_number.getText().length());
    }

}

class FactorialDigitSum {
    FactorialDigitSum(int value) {
        this.value = value;
        fact = factorial(value);
        digitSum = BigInteger.ZERO;
    }

    private BigInteger digitSum; // sum of the digits in the number
    private BigInteger fact; //factorial function1s value
    private int value;

    private BigInteger factorial(int value) { //   factorization

        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }

    public String getDigitSum() { //    evaluation sum of the digits in the factorial and out to screen
        BigInteger exit_point = new BigInteger("0");

        while (fact.compareTo(exit_point) > 0) {

            digitSum = digitSum.add(fact.mod(BigInteger.TEN));
            fact = fact.divide(BigInteger.TEN);

        }
        return digitSum.toString();
    }




}

