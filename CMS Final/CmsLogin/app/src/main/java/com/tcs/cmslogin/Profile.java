package com.tcs.cmslogin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Akshama PC on 7/15/2017.
 */
public class Profile extends Fragment {

    TextView name,ID, email, dept;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Profile");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container, false);

        name = (TextView) view.findViewById(R.id.editText);
        ID = (TextView) view.findViewById(R.id.editText1);
        email = (TextView) view.findViewById(R.id.editText2);
        dept = (TextView) view.findViewById(R.id.editText3);

        loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
        Intent i = getActivity().getIntent();
        String empid = i.getStringExtra("ID1");
       // String empname = loginDataBaseAdapter.getname(empid);
      //  name.setText(empname);
       set();
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    public void set()
    {
        String TAG = "myApp";
        ArrayList<String> details1= loginDataBaseAdapter.getDetails("CMS03");
        if(details1==null){
           // Log.v(TAG, "NULL");
        }
        else
        {
          //  Log.v(TAG, "NOT NULL");
            name.setText(details1.get(0));
            dept.setText(details1.get(1));
            ID.setText(details1.get(2));

        }
    }


}
