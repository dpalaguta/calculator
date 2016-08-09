package com.example.dmitry.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dmitry on 07.08.2016.
 */
public class CalculatorPairsActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "myLog";

    private Button button0, button1,button2,button3,button4,
            button5,button6,button7,button8,button9,button_del,
            central_button_calc, button_whitespase;
    private Button button_factorial, button_palindrome;
    private EditText editText_pairs;
    private TextView textView_resault_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_pairs);
        editText_pairs = (EditText) findViewById(R.id.editText_pairs);

        editText_pairs.setFocusable(false);
        editText_pairs.setFocusableInTouchMode(false);

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

        button_whitespase = (Button) findViewById(R.id.button_whitespace);
        button_whitespase.setOnClickListener(this);

        central_button_calc = (Button) findViewById(R.id.central_button_calc);
        central_button_calc.setOnClickListener(this);

        button_del = (Button) findViewById(R.id.button_del_numb);
        button_del.setOnClickListener(this);

        button_factorial = (Button) findViewById(R.id.button_factorial_activity);
        button_factorial.setOnClickListener(this);

        button_palindrome = (Button) findViewById(R.id.button_palindrome_activity);
        button_palindrome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:{
                if (editText_pairs.length() > 0)
                editText_pairs.setText(editText_pairs.getText()+"0");
            }break;
            case R.id.button1:{
                editText_pairs.setText(editText_pairs.getText()+"1");
            }break;
            case R.id.button2:{
                editText_pairs.setText(editText_pairs.getText()+"2");
            }break;
            case R.id.button3:{
                editText_pairs.setText(editText_pairs.getText()+"3");
            }break;
            case R.id.button4:{
                editText_pairs.setText(editText_pairs.getText()+"4");
            }break;
            case R.id.button5:{
                editText_pairs.setText(editText_pairs.getText()+"5");
            }break;
            case R.id.button6:{
                editText_pairs.setText(editText_pairs.getText()+"6");
            }break;
            case R.id.button7:{
                editText_pairs.setText(editText_pairs.getText()+"7");
            }break;
            case R.id.button8:{
                editText_pairs.setText(editText_pairs.getText()+"8");
            }break;
            case R.id.button9:{
                editText_pairs.setText(editText_pairs.getText()+"9");
            }break;


            case R.id.button_whitespace:{
                if (editText_pairs.length() > 0 &&
                        editText_pairs.getText().charAt(editText_pairs.length()-1) != ' ')
                    editText_pairs.setText(editText_pairs.getText()+" ");
            }break;

            case R.id.button_del_numb:{
                if (editText_pairs.getText().length() > 0)
                editText_pairs.setText(editText_pairs.getText().subSequence(0,
                        editText_pairs.getText().length()-1));
            }break;



            case R.id.central_button_calc:{
                textView_resault_field.setText(getResultPairs());

            }break;


            case R.id.button_factorial_activity:{
                Intent factorial_activity = new Intent(this, CalculatorFactorialSumDigitsActivity.class);
                factorial_activity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(factorial_activity);
              finish();

            }break;

            case R.id.button_palindrome_activity:{
                Intent palindrome_activity = new Intent(this, CalculatorPalindromeActivity.class);
                palindrome_activity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(palindrome_activity);
               finish();

            }
        }
        editText_pairs.setSelection(editText_pairs.getText().length());
    }

    private String getResultPairs(){


        String [] word_array = editText_pairs.getText().toString().split(" ");

        if (word_array.length % 2 != 0 && word_array.length > 0 || word_array.length == 2)
            return "Enter the even amount of numbers more the two";

        ArrayList<PairsNumb> pair_array = new ArrayList<>();

        for (int i = 0; i < word_array.length-1; i+= 2){
            int numb_one = Integer.valueOf(word_array[i]);
            int numb_two = Integer.valueOf(word_array[i+1]);
            pair_array.add(new PairsNumb(numb_one, numb_two));
        }


        int longest_size = 0;
        int sublist_position = 0;
        int count_size = 0;



        for (int i = 0; i < pair_array.size()-1; i++){

            if (pair_array.get(i).getNum_one() < pair_array.get(i+1).getNum_one() &&
                    pair_array.get(i).getNum_two() > pair_array.get(i+1).getNum_two())
            {
                count_size++;
                if (count_size > longest_size) {
                    longest_size = count_size;
                    sublist_position = i - count_size;
                }

            } else count_size = 0;
        }


        sublist_position++;
        longest_size++;


        String result_string = "";
        Log.d(TAG, "check point " + sublist_position + " - "+ longest_size+ " "+pair_array.size());
        for (int i = sublist_position; i < sublist_position + longest_size; i++)
        {
            result_string += pair_array.get(i).getNum_one()+ " "+pair_array.get(i).getNum_two()+ " ";
        }



        return result_string;
    }


}

class PairsNumb{

    PairsNumb(int num_one, int nub_two){
        this.num_one = num_one;
        this.num_two = nub_two;

    }

    public int getNum_one() {
        return num_one;
    }


    public int getNum_two() {
        return num_two;
    }

    private int num_one;
    private int num_two;


}
