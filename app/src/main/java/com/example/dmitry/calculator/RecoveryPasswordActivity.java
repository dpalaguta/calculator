package com.example.dmitry.calculator;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecoveryPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_recovery;
    EditText email_input;
    final String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password);
        Log.d(TAG, "onCreate recovery");

        email_input = (EditText) findViewById(R.id.emailEdit);
        Drawable img = getResources().getDrawable(R.mipmap.sym_action_email);
        img.setBounds(0, 0, 50, 50);
        email_input.setCompoundDrawables(img, null, null, null);

        button_recovery = (Button) findViewById(R.id.button_send);
        button_recovery.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_send: {

                finish();

            }break;


        }

    }


}
