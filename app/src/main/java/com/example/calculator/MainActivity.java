package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private TextView welcome,or,forgot,clickHere,enter;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.password_text);
        email = findViewById(R.id.email_text);
        button = findViewById(R.id.entry_button);
        welcome = findViewById(R.id.welcome_txt);
        or = findViewById(R.id.signIn_text);
        forgot = findViewById(R.id.forgotPassword);
        clickHere = findViewById(R.id.goText);
        enter = findViewById(R.id.entry_text);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (password.getText().toString().isEmpty()) {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey));
                }else {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
                }

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (email.getText().toString().isEmpty()){
                    button.setBackgroundColor(Color.GRAY);
                }else {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
                }

            }
        });
        button.setOnClickListener(view -> {
            if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                password.setVisibility(View.GONE);
                email.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                or.setVisibility(View.GONE);
                forgot.setVisibility(View.GONE);
                clickHere.setVisibility(View.GONE);
                enter.setVisibility(View.GONE);
                Toast.makeText(this,"Вы успешно зарегистрировались!",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Неверный пароль и логин",Toast.LENGTH_SHORT).show();
            }


        });
    }
}