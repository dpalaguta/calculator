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
    EditText address;
    final String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password);
        Log.d(TAG, "onCreate recovery");

        address = (EditText) findViewById(R.id.emailEdit);
        Drawable img = getResources().getDrawable(R.mipmap.sym_action_email);
        img.setBounds(0, 0, 50, 50);
        address.setCompoundDrawables(img, null, null, null);

        button_recovery = (Button) findViewById(R.id.button_send);
        button_recovery.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_send: {

                if (address.getText().length() > 0){
                    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                    emailIntent.setType("plain/text");
                    // Кому
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                            new String[] {
                                    address.getText().toString()
                            });
                    // Зачем
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                            "Recovery password");
                    // О чём
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                            "Your old password ");

                    // Поехали!
                    startActivity(Intent.createChooser(emailIntent,
                            "Отправка письма..."));
                }

                finish();

            }break;


        }

    }


}



