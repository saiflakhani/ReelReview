package com.example.pallavi.reelreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
DatabaseHelper helper = new DatabaseHelper(this);
    EditText name,email,password,confirmpass;
    Button register;
    String n,e,p,cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.regname);
        email = (EditText)findViewById(R.id.regemail);
        password = (EditText)findViewById(R.id.regpass);
        register = (Button)findViewById(R.id.register);
        confirmpass = (EditText)findViewById(R.id.regconf);

        n = name.getText().toString();
        e = email.getText().toString();
        p = password.getText().toString();
        cf = confirmpass.getText().toString();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(!p.equals(cf)){
                    Toast.makeText(Register.this,"Passwords dont match...",Toast.LENGTH_SHORT).show();
                }
                else{
                    //insert into db

                    Contact c = new Contact();
                    c.setName(n);
                    c.setEmail(e);
                    c.setPassword(p);

                    helper.insertContact(c);
                   Intent intent = new Intent(Register.this, Login.class);
                   startActivity(intent);

                }
            }
        });
    }
}
