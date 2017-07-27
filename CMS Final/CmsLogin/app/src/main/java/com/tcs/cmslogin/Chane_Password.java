package com.tcs.cmslogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ISHA GUPTA on 12-07-2017.
 */

public class Chane_Password extends Fragment {

    EditText oldpass,newpass,conpass,name;
    Button change;
    View view;
LoginDataBaseAdapter loginDataBaseAdapter = new LoginDataBaseAdapter(getContext());
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_change_pass, container, false);
       oldpass = (EditText) view.findViewById(R.id.old);
        newpass = (EditText) view.findViewById(R.id.contact_no);
        conpass = (EditText) view.findViewById(R.id.contact_no1);
        name = (EditText) view.findViewById(R.id.name);

        change = (Button) view.findViewById(R.id.submit);


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!conpass.getText().toString().equals(newpass.getText().toString()))
                    Toast.makeText(getActivity(), "Password does not match", Toast.LENGTH_LONG).show();
                else
                    loginDataBaseAdapter.updateEntryU(name.getText().toString(),conpass.getText().toString());
                Toast.makeText(getContext(),"Password Updated",Toast.LENGTH_LONG).show();

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("CHANGE PASSWORD");
    }

}



