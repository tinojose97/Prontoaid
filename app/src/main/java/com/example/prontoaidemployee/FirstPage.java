package com.example.prontoaidemployee;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import javax.security.auth.Subject;

public class FirstPage extends AppCompatActivity {
        FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        auth = FirebaseAuth.getInstance();


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

                EditText usernam = (EditText) findViewById(R.id.uname);
                final EditText paswswd = (EditText) findViewById(R.id.signinPwd);
                final String email = usernam.getText().toString();
                final String password = paswswd.getText().toString();
                if (usernam.getText().toString().equals(""))
                    Toast.makeText(FirstPage.this, "Invalid username", Toast.LENGTH_LONG).show();
                else if (paswswd.getText().toString().equals(""))
                    Toast.makeText(FirstPage.this, "Invalid password", Toast.LENGTH_LONG).show();
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(FirstPage.this, new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            if (paswswd.length() < 6) {
                                Toast.makeText(FirstPage.this, getString(R.string.minimum_password), Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(FirstPage.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else {

                            startActivity(new Intent(FirstPage.this, Home_screen.class));

                        }
                    }
                });


            }
        });
    }}