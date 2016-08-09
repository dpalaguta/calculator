package com.example.dmitry.calculator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class AddNewUserActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_add_user, button_send;
    EditText first_name, last_name, email, phone, login, password;
    LinearLayout child_block;

    ArrayList <EditText> arrayList = new ArrayList();

    final String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Log.d(TAG, "onCreate recovery");

        child_block = (LinearLayout) findViewById(R.id.layout_add_child);

        button_add_user = (Button) findViewById(R.id.button_add_user);
        button_add_user.setOnClickListener(this);

        button_send = (Button) findViewById(R.id.button_send);
        button_send.setOnClickListener(this);

        first_name = (EditText) findViewById(R.id.editText_first_name);
        Drawable img = getResources().getDrawable(R.mipmap.peopleone);
        img.setBounds(0, 0, 50, 50);
        first_name.setCompoundDrawables(img, null, null, null);
        first_name.setHintTextColor(getResources().getColor(R.color.white));

        last_name = (EditText) findViewById(R.id.editText_last_name);
        img.setBounds(0, 0, 50, 50);
        last_name.setCompoundDrawables(img, null, null, null);
        last_name.setHintTextColor(getResources().getColor(R.color.white));

        email = (EditText) findViewById(R.id.editText_email);
        img = getResources().getDrawable(R.mipmap.ic_dialog_email);
        img.setBounds(0, 0, 50, 50);
        email.setCompoundDrawables(img, null, null, null);
        email.setHintTextColor(getResources().getColor(R.color.white));

        phone = (EditText) findViewById(R.id.editText_phone);
        img = getResources().getDrawable(R.mipmap.ic_menu_call);
        img.setBounds(0, 0, 50, 50);
        phone.setCompoundDrawables(img, null, null, null);
        phone.setHintTextColor(getResources().getColor(R.color.white));

        login = (EditText) findViewById(R.id.editText_login);
        img = getResources().getDrawable(R.mipmap.peopleone);
        img.setBounds(0, 0, 50, 50);
        login.setCompoundDrawables(img, null, null, null);
        login.setHintTextColor(getResources().getColor(R.color.white));

        password = (EditText) findViewById(R.id.editText_password);
        img = getResources().getDrawable(R.mipmap.ic_lock_idle_lock);
        img.setBounds(0, 0, 50, 50);
        password.setCompoundDrawables(img, null, null, null);
        password.setHintTextColor(getResources().getColor(R.color.white));

        addChildBlock(child_block);

    }

    private void addChildBlock(LinearLayout layout){


        EditText last_name = new EditText(this);
        int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
        int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(matchParent, wrapContent);
        lParams.setMargins(20, 0, 20, 0);
        last_name.setHint("Last Name");
        last_name.setHintTextColor(getResources().getColor(R.color.white));
        last_name.setId(View.generateViewId());
        Drawable img = getResources().getDrawable(R.mipmap.peopleone);
        img.setBounds(0, 0, 50, 50);
        last_name.setCompoundDrawables(img, null, null, null);
        // arrayList.add(last_name);

        EditText date_birth = new EditText(this);
        lParams.setMargins(20, 0, 20, 0);
        date_birth.setHint("Date of Birth");
        date_birth.setHintTextColor(getResources().getColor(R.color.white));
        date_birth.setId(View.generateViewId());
        img = getResources().getDrawable(R.mipmap.ic_menu_my_calendar);
        img.setBounds(0, 0, 50, 50);
        date_birth.setCompoundDrawables(img, null, null, null);
        //     arrayList.add(date_birth);


        layout.addView(last_name, lParams);
        layout.addView(date_birth, lParams);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add_user:{
                addChildBlock(child_block);
            }break;

            case R.id.button_send:{
                finish();
            }

        }
    }
}
