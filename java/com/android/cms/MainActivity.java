package com.android.cms;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener
{
    Button btnSignIn,btnSignUp;
    Spinner type;
    public final String[] paths={"Administrator","Engineer","User"};
    LoginDataBaseAdapter loginDataBaseAdapter;
    String item;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get The Reference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIN);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);


        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
                startActivity(intentSignUP);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        item = parent.getItemAtPosition(position).toString();
        this.position=position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    // Methos to handleClick Event of Sign In Button
    public void signIn(View V)
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the Refferences of views
        final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);
        type = (Spinner)dialog.findViewById(R.id.spinner);

        type.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                // fetch the Password form database for respective user name

                String storedPassword;
                if(item.equals("Administrator"))
                {
                    storedPassword=loginDataBaseAdapter.getSingleEntryA(userName);
                }
                else if(item.equals("User"))
                {
                    storedPassword=loginDataBaseAdapter.getSingleEntry(userName);
                }
                else
                {
                    storedPassword=loginDataBaseAdapter.getSingleEntry(userName);
                }
                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(MainActivity.this, "Congrats: Login Successful", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    if(item.equals("Administrator")){

                        Intent intentA = new Intent(MainActivity.this,AdminActivity.class);
                        startActivity(intentA);
                    }else if(item.equals("User")) {

                        Intent intentU = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(intentU);
                    }else {

                        Intent intentE = new Intent(MainActivity.this,EngActivity.class);
                        startActivity(intentE);
                    }
                    // Intent intentWelcome=new Intent(getApplicationContext(),Welcome.class);
                    // startActivity(intentWelcome);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}