package com.tcs.cmslogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.text.TextUtils.isEmpty;

/**
 * Created by ISHA GUPTA on 12-07-2017.
 */

public class Show_Profile extends AppCompatActivity {

    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_user);

        name = (TextView) findViewById(R.id.textView1);

//        name.append(getIntent().getStringExtra("name"));


    }



}
