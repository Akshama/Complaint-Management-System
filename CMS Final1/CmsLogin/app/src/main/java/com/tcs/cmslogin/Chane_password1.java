package com.tcs.cmslogin;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ISHA GUPTA on 30-07-2017.
 */

public class Chane_password1 extends Fragment {

    LoginDataBaseAdapter loginDataBaseAdapter;
//    TextView current_pass,new_pass,confirm_pass;
    String name1;
    EditText oldpass,newpass;
    Button change;
    View view;
    user users;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((UserActivity) getActivity()).setActionBarTitle("ChangePassword");

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        view=inflater.inflate(R.layout.fragment_change_pass,container,false);


        Intent i = getActivity().getIntent();
        name1 = i.getStringExtra("name");

        oldpass = (EditText) view.findViewById(R.id.old);
        newpass = (EditText) view.findViewById(R.id.contact_no);


        change = (Button) view.findViewById(R.id.submit);

        change.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myview){
                Log.d("going","gone");
                String check=loginDataBaseAdapter.getSingleEntryU(name1);
                if(!oldpass.getText().toString().equals(check)){
                    Toast.makeText(getActivity(), "Please Enter Correct Password", Toast.LENGTH_LONG).show();

                } else {
                    loginDataBaseAdapter.updateEntryU_pass(name1, newpass.getText().toString());
                    Toast.makeText(getActivity(), "Password changed successfully!", Toast.LENGTH_LONG).show();
                }
            }
        });



        return  view;
    }




}
