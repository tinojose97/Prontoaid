package com.example.prontoaidemployee;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class signup_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);




        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();


        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("kakkanad");
        categories.add("Palarivattom");
        categories.add("Tripunithara");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);













        Button signupButton = findViewById(R.id.signupbtn);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText name=(EditText)findViewById(R.id.name);

                EditText paswrd= (EditText)findViewById(R.id.password);
                EditText cpaswrd= (EditText)findViewById(R.id.confirm_pswrd);
                EditText phnno= (EditText)findViewById(R.id.phone_number);
                EditText occpt=(EditText)findViewById(R.id.occupation);
                EditText emaid=(EditText)findViewById(R.id.email);
                final String nme = name.getText().toString().trim();
                final String email=emaid.getText().toString().trim();
                final  String password=paswrd.getText().toString().trim();
                final String phoneno=phnno.getText().toString().trim();
                final  String job=occpt.getText().toString().trim();
                if(name.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"Enter the  name",Toast.LENGTH_LONG).show();
                else if(emaid.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"enter the EmailID",Toast.LENGTH_LONG).show();
                else if(phnno.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"Enter a valid phone number",Toast.LENGTH_LONG).show();
                else if(occpt.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"Enter an Occupation",Toast.LENGTH_LONG).show();
                else if(paswrd.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"enter a password",Toast.LENGTH_LONG).show();
                else if(cpaswrd.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"confirm password",Toast.LENGTH_LONG).show();
                else if(!paswrd.getText().toString().equals(cpaswrd.getText().toString()))
                    Toast.makeText(signup_page.this,"Password Does not match",Toast.LENGTH_LONG).show();
                else
                { auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(signup_page.this, new OnCompleteListener<AuthResult>() {

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(signup_page.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        if (!task.isSuccessful()) {
                            Toast.makeText(signup_page.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {



                            startActivity(new Intent(signup_page.this, Home_screen.class));
                            finish();
                        }
                       // progressDialog.dismiss();
                    }
                });
            }}
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
