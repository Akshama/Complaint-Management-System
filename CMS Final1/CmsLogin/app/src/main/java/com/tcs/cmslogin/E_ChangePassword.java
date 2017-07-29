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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Akshama PC on 28-Jun-17.
 */

public class E_ChangePassword extends Fragment {

    View myView;
    Button change_passw;
    LoginDataBaseAdapter loginDataBaseAdapter;
    TextView current_pass,new_pass,confirm_pass;
    String empID;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((E_navigation) getActivity()).setActionBarTitle("ChangePassword");

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        myView=inflater.inflate(R.layout.engineer_changepassword,container,false);

        change_passw=(Button)myView.findViewById(R.id.change_pass);
        current_pass=(TextView)myView.findViewById(R.id.current_pass);
        new_pass=(TextView)myView.findViewById(R.id.new_pass);
        confirm_pass=(TextView)myView.findViewById(R.id.confirm_pass);


        Intent i = getActivity().getIntent();
        empID = i.getStringExtra("ID");

        change_passw.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myview){
                Log.d("going","gone");
                String check=loginDataBaseAdapter.getSingleEntryE(empID);
                if(!current_pass.getText().toString().equals(check))
                    Toast.makeText(getActivity(), "Please Enter Correct Password", Toast.LENGTH_LONG).show();
                else if(!confirm_pass.getText().toString().equals(new_pass.getText().toString()))
                    Toast.makeText(getActivity(), "Password does not match", Toast.LENGTH_LONG).show();
                else {
                    loginDataBaseAdapter.updateEntryE_pass(empID, confirm_pass.getText().toString());
                    Toast.makeText(getActivity(), "Password changed successfully!", Toast.LENGTH_LONG).show();
                }
            }
        });
        return myView;
    }






}
