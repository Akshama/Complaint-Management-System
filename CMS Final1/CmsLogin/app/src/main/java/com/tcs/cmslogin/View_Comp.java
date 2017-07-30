package com.tcs.cmslogin;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ISHA GUPTA on 30-07-2017.
 */

public class View_Comp extends Fragment {

    LoginDataBaseAdapter loginDataBaseAdapter;
    View view;
    user_complaint userComplaintList;
    TextView nam,email,phone,complaint,status;
    Button delete;
    String name;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((UserActivity) getActivity()).setActionBarTitle("View Complaint");

        loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        view = inflater.inflate(R.layout.activity_view, container, false);
        userComplaintList = new user_complaint();


        nam = (TextView) view.findViewById(R.id.name1);
        email = (TextView) view.findViewById(R.id.email1);
        phone = (TextView) view.findViewById(R.id.phone1);
        complaint = (TextView) view.findViewById(R.id.comp1);
        status = (TextView) view.findViewById(R.id.status1);
        delete = (Button) view.findViewById(R.id.submit);

        Intent i = getActivity().getIntent();
        name = i.getStringExtra("name");

        userComplaintList = loginDataBaseAdapter.getcomplaint(name);
        nam.setText(userComplaintList.getName());
        email.setText(userComplaintList.getEmail());
        phone.setText(userComplaintList.getPhone());
        complaint.setText(userComplaintList.getComplaint());
        status.setText(userComplaintList.getStatus());


        if (status.getText().toString().equalsIgnoreCase("Resolved")) {

            delete.setVisibility(View.VISIBLE);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    loginDataBaseAdapter.delete_complaint(userComplaintList.getId());
                }
            });

        }


        return view;
    }
}
