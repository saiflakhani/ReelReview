package com.example.pallavi.reelreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText email,password;
    Button login,register;
    String e,p;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.lemail);
        password = (EditText)findViewById(R.id.lpass);
        login = (Button)findViewById(R.id.loginbt);
        register = (Button)findViewById(R.id.lsignup);
        e = email.getText().toString();
        p = password.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String pass = helper.searchPass(e);
                if(p.equals(pass)) {

                    Intent intent = new Intent(Login.this, ShowGenre.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this,"Incorrect password or email.",Toast.LENGTH_SHORT).show();
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });
    }
}
