package com.example.dmitry.calculator;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_login, button_recovery_password, button_add_new_user;
    EditText editText_login, editText_password;
    final String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_login = (EditText) findViewById(R.id.login_view);
        Drawable img = getResources().getDrawable(R.mipmap.peopleone);
        img.setBounds(0, 0, 50, 50);
        editText_login.setCompoundDrawables(img, null, null, null);
        editText_login.setHintTextColor(getResources().getColor(R.color.white));

        editText_password = (EditText) findViewById(R.id.password_view);
        img = getResources().getDrawable(R.mipmap.ic_lock_idle_lock);
        img.setBounds(0, 0, 50, 50);
        editText_password.setCompoundDrawables(img, null, null, null);
        editText_password.setHintTextColor(getResources().getColor(R.color.white));

        button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(this);

        button_recovery_password = (Button) findViewById(R.id.button_recovery_pass);
        button_recovery_password.setOnClickListener(this);

        button_add_new_user = (Button) findViewById(R.id.button_add_new_user);
        button_add_new_user.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:{
                Intent palindrome_activity = new Intent(this, CalculatorPalindromeActivity.class);
                startActivity(palindrome_activity);
                finish();

            }break;

            case R.id.button_recovery_pass:{
                Log.d(TAG, "case recovery");
                Intent recovery_password_activity = new Intent(this, RecoveryPasswordActivity.class);
                recovery_password_activity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(recovery_password_activity);

            }break;

            case R.id.button_add_new_user: {
                Intent new_user_activity = new Intent(this, AddNewUserActivity.class);
                new_user_activity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(new_user_activity);
            }
        }
    }
}
