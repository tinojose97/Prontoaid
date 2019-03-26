package com.example.prontoaidemployee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class signup_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);






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

                EditText fstname=(EditText)findViewById(R.id.first_name);
                EditText lstname=(EditText) findViewById(R.id.last_name);
                EditText paswrd= (EditText)findViewById(R.id.password);
                EditText cpaswrd= (EditText)findViewById(R.id.confirm_pswrd);
                EditText phnno= (EditText)findViewById(R.id.phone_number);
                EditText occpt=(EditText)findViewById(R.id.occupation);
                Spinner sploc= (Spinner) findViewById(R.id.spinner );

                if(fstname.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"Enter the first name",Toast.LENGTH_LONG).show();
                else if(lstname.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"enter the last name",Toast.LENGTH_LONG).show();
                else if(phnno.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"Enter a valid phone number",Toast.LENGTH_LONG).show();
                else if(occpt.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"Enter an Occupation",Toast.LENGTH_LONG).show();
                else if(paswrd.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"enter a password",Toast.LENGTH_LONG).show();
                else if(cpaswrd.getText().toString().equals(""))
                    Toast.makeText(signup_page.this,"confirm password",Toast.LENGTH_LONG).show();
                else if(!paswrd.equals(cpaswrd))
                    Toast.makeText(signup_page.this,"Password Does not match",Toast.LENGTH_LONG).show();
                else if(!sploc.isSelected())
                    Toast.makeText(signup_page.this,"select a location",Toast.LENGTH_LONG).show();

                else
                startActivity(new Intent(signup_page.this, Home_screen.class));
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
