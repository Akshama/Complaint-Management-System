package com.tcs.cmslogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ISHA GUPTA on 12-07-2017.
 */

public class Chane_Password extends AppCompatActivity {

    EditText oldpass,newpass,conpass;
    Button change;
    View view;
    user users;

LoginDataBaseAdapter loginDataBaseAdapter = new LoginDataBaseAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_change_pass);
       oldpass = (EditText) findViewById(R.id.old);
        newpass = (EditText) findViewById(R.id.contact_no);
//        conpass = (EditText) findViewById(R.id.contact_no1);
        users= new user();
        users.setName(getIntent().getStringExtra("name"));
        users.setPassword(getIntent().getStringExtra("pass"));

//        Log.d("BBB",users.getPassword());
//        Log.d("BBB",users.getName());

        change = (Button) findViewById(R.id.submit);

//
//        users.setName(getIntent().getStringExtra("name"));
//        users.setPassword(getIntent().getStringExtra("pass"));
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if((users.getPassword()).equals(oldpass.getText().toString())){

//                    if(!conpass.getText().toString().equals(newpass.getText().toString()))
//                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
//                    else
                        loginDataBaseAdapter.updateEntryU(users.getName(),newpass.getText().toString());
                    Toast.makeText(getApplicationContext(),"Password Updated",Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(getApplicationContext(),"Please enter the old password correctly",Toast.LENGTH_LONG).show();
                }


            }
        });
    }


}



