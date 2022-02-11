package com.techsoldev.studentrecorder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity{
        private String email = "f180243@nu.edu.pk";
        private String pass = "811928";
        private EditText emailtext, passwordtext ;
        private CardView loginBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setTheme(R.style.LightTheme);
            setContentView(R.layout.activity_login);

            emailtext = (EditText) findViewById(R.id.username_login);
            passwordtext = (EditText) findViewById(R.id.user_password_login);
            loginBtn = (CardView) findViewById(R.id.login_btn);



            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email_text = emailtext.getText().toString();
                    // check whether user fill the edittext or not
                    if (emailtext.getText().toString().trim().equalsIgnoreCase("")) {
                        emailtext.setError("This field can not be blank");
                        emailtext.requestFocus();
                    }
                    else if (! Patterns.EMAIL_ADDRESS.matcher(email_text).matches())
                    {
                        emailtext.setError("invalid email");
                        emailtext.requestFocus();
                    }


                    else if (passwordtext.getText().toString().trim().equalsIgnoreCase("")) {
                        passwordtext.setError("This field can not be blank");
                        passwordtext.requestFocus();
                    } else {
                        loginFun();
                    }


                }
            });
        }

        private void loginFun() {

            String email_text = emailtext.getText().toString();
            String password_text = passwordtext.getText().toString();

            if (email_text.equals(email)) {
                if (password_text.equals(pass)) {

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    finish();
                    startActivity(intent);


                } else {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Login failed")
                            .setMessage("incorrect password")
                            .setPositiveButton(android.R.string.ok, null)
                            .show();
                }
            } else {
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("Login failed")
                        .setMessage("incorrect name")
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
            }

        }
}