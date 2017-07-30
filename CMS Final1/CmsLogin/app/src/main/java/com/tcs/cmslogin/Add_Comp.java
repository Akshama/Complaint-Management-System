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
import android.widget.Toast;

/**
 * Created by ISHA GUPTA on 30-07-2017.
 */

public class Add_Comp extends Fragment {

    LoginDataBaseAdapter loginDataBaseAdapter;
    View view;
    public EditText nam,email,phone,complaint;
    Button create;
    user_complaint userComplaintList;
    String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((UserActivity) getActivity()).setActionBarTitle("Add Complaint");

        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        view=inflater.inflate(R.layout.activity_add__complaint,container,false);

        userComplaintList = new user_complaint();


        nam= (EditText)view.findViewById(R.id.name);
        email= (EditText)view.findViewById(R.id.email_id);
        phone= (EditText)view.findViewById(R.id.contact_no);
        complaint= (EditText)view.findViewById(R.id.complaint);
        create=(Button) view.findViewById(R.id.submit);

        Intent i = getActivity().getIntent();
        name = i.getStringExtra("name");

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1,email1,complaint1,phone1;
                name1= nam.getText().toString();
                email1= email.getText().toString();
                phone1= phone.getText().toString();
                complaint1= complaint.getText().toString();

                Log.d("AAAA",name1);
                Log.d("AAAA",email1);
                Log.d("AAAA",phone1);
                Log.d("AAAA",complaint1);

                if(name1.equalsIgnoreCase(name)){

                    userComplaintList.setName(name1);
                    userComplaintList.setEmail(email1);
                    userComplaintList.setPhone(phone1);
                    userComplaintList.setComplaint(complaint1);
                    userComplaintList.setStatus("Pending");

                    loginDataBaseAdapter.insertEntryC(userComplaintList);

//                    Intent i= new Intent(getActivity(),View_Comp.class);
////                    i.putExtra("name",userComplaintList.getName());
//
//                    startActivity(i);
                    Toast.makeText(getActivity(),"Complaint Added!",Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(getActivity(),"Username doesnot match",Toast.LENGTH_SHORT).show();
                }


            }
        });

        return view;
    }

}
