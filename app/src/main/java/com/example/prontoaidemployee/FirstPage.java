package com.example.prontoaidemployee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);

        Button joinButton = findViewById(R.id.joinus);
        joinButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              startActivity(new Intent(FirstPage.this, signup_page.class));

                                          }
                                      });

        Button signinButton = findViewById(R.id.signinbtn);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernam=(EditText)findViewById(R.id.username);
                EditText paswswd=(EditText) findViewById(R.id.signinPwd);
                if(usernam.getText().toString().equals(""))
                    Toast.makeText(FirstPage.this,"Invalid username",Toast.LENGTH_LONG).show();
               else if(paswswd.getText().toString().equals(""))
                    Toast.makeText(FirstPage.this,"Invalid password",Toast.LENGTH_LONG).show();
                else startActivity(new Intent(FirstPage.this, Home_screen.class));

            }
        });




    }
}
