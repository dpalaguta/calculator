package com.example.dmitry.calculator;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class AddNewUserActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_add_child, button_send;
    EditText first_name, last_name, email, phone, login, password;
    LinearLayout child_block;

    ArrayList <EditText> arrayList = new ArrayList<EditText>();

    final String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Log.d(TAG, "onCreate recovery");

        child_block = (LinearLayout) findViewById(R.id.layout_add_child);

        button_add_child = (Button) findViewById(R.id.button_add_child);
        button_add_child.setOnClickListener(this);

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
        arrayList.add(last_name);

        EditText date_birth = new EditText(this);
        lParams.setMargins(20, 0, 20, 0);
        date_birth.setHint("Date of Birth");
        date_birth.setHintTextColor(getResources().getColor(R.color.white));
        date_birth.setId(View.generateViewId());
        img = getResources().getDrawable(R.mipmap.ic_menu_my_calendar);
        img.setBounds(0, 0, 50, 50);
        date_birth.setCompoundDrawables(img, null, null, null);
        arrayList.add(date_birth);


        layout.addView(last_name, lParams);
        layout.addView(date_birth, lParams);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add_child:{

                addChildBlock(child_block);
            }break;

            case R.id.button_send:{
                if(login.length() > 0 && password.length() > 0){

                    UserData userData = new UserData();
                    userData.setFirst_name(first_name.getText().toString());
                    userData.setLast_name(last_name.getText().toString());
                    userData.setPhone(phone.getText().toString());
                    userData.setEmail(email.getText().toString());
                    userData.setLogin(login.getText().toString());
                    userData.setPassword(password.getText().toString());


                    for (int i = 0; i < arrayList.size(); i+=2){

                        Children children = new Children(arrayList.get(i).getText().toString(),
                                arrayList.get(i+1).getText().toString());
                        userData.addChildren(children);

                    }


                    for (int i = 0; i < userData.getChildren().size(); i++){
                        Log.d(TAG, userData.getChildren().get(i).getFirst_name_child());
                        Log.d(TAG, userData.getChildren().get(i).getDate_birth());
                    }



                    DatabaseHelper myDbHelper = new DatabaseHelper(this);
                    if (myDbHelper.addUser(userData) != -1) finish(); else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "login is already used", Toast.LENGTH_SHORT);
                        toast.show();
                    }


                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "field login or password is empty", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        }
    }
}

class UserData{
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void addChildren(Children children){
        this.children.add(children);
    }

    public ArrayList<Children> getChildren(){
        return children;
    }

    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String login;
    private String password;

    private ArrayList<Children> children = new ArrayList<>();

}

 class Children{

     Children(String first_name_child, String date_birth){

         this.first_name_child = first_name_child;
         this.date_birth = date_birth;
     }

     public String getFirst_name_child() {
         return first_name_child;
     }

     public String getDate_birth() {
         return date_birth;
     }

     private String first_name_child;
    private String date_birth;

}

