package com.example.salman.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    EditText usernameInput;
    EditText passwordInput;
    Button btnSave;
    Button btnDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput= (EditText) findViewById(R.id.etUsername);
        passwordInput = (EditText) findViewById(R.id.etPassword);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        t1 = (TextView) findViewById(R.id.TextView1);

        //save the user info

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username",usernameInput.getText().toString());
                editor.putString("password",passwordInput.getText().toString());
                editor.apply();

                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();
            }
        });
        // print out user data

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String name =sp.getString("username","not Found");
                String pass = sp.getString("password","not Found");
                t1.setText(name + " " + pass);



            }
        });


    }
}
