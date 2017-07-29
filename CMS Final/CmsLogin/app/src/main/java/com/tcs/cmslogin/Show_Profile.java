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

public class Show_Profile extends Fragment {

    TextView name;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view=inflater.inflate(R.layout.fragment_profile1,container,false);

//        name = (TextView) findViewById(R.id.textView1);

//        name.append(getIntent().getStringExtra("name"));

        return view;

    }



}
