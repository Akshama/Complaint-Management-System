package com.tcs.cmslogin;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Akshama PC on 21-Jul-17.
 */

public class E_Profile extends Fragment {

    View myView;
    TextView dept,emailid,name, id;
    LoginDataBaseAdapter loginDataBaseAdapter;
    String empid1;
    String emp_name,emp_dept,emp_email;
    //String paths[]={"CMS01","CMS02"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((E_navigation) getActivity()).setActionBarTitle("MY PROFILE");

        myView=inflater.inflate(R.layout.e_profile,container,false);
        dept=(TextView) myView.findViewById(R.id.e_eng_dept);
        emailid=(TextView) myView.findViewById(R.id.e_eng_email);
        name=(TextView) myView.findViewById(R.id.e_eng_name);
        id =(TextView) myView.findViewById(R.id.e_eng_id);

        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());

        Intent i = getActivity().getIntent();
        empid1 = i.getStringExtra("ID");

        ArrayList<String> details=loginDataBaseAdapter.getDetails(empid1);
        if(details==null){}

        else
        {
            name.setText(details.get(0));
            dept.setText(details.get(1));
            emailid.setText(details.get(2));
            id.setText(empid1);

        }

        return myView;
    }



}
