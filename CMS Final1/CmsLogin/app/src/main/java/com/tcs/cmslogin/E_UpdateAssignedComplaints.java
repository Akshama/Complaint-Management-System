package com.tcs.cmslogin;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Akshama PC on 27-Jun-17.
 */

public class E_UpdateAssignedComplaints extends Fragment  {

    View myView;
    LoginDataBaseAdapter loginDataBaseAdapter;
    TextView tv16,tv18;
    EditText tv19;
    Button update;
    String id=null;
    String empid1, compID,compid;
    String status;

    public void addHeaders(){

        /** Create a TableRow dynamically **/


        addData();

    }

    public void addData() {
        Intent i = getActivity().getIntent();
        empid1 = i.getStringExtra("ID");
        compid = loginDataBaseAdapter.getSelect_AssignedCompId(empid1);
        String compname = loginDataBaseAdapter.getSelect_Complaint(compid);
        String comp_status=loginDataBaseAdapter.getSelect_ComplaintStatus1(compid);


        tv16.setText(compid);
        tv18.setText(compname);
        tv19.setText(comp_status);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((E_navigation) getActivity()).setActionBarTitle("View Complaints");
        myView=inflater.inflate(R.layout.e_updateassignedcompl,container,false);
        tv16 = (TextView) myView.findViewById(R.id.textView16);
        tv18 = (TextView) myView.findViewById(R.id.textView18);
        tv19 = (EditText) myView.findViewById(R.id.textView19);
        update = (Button) myView.findViewById(R.id.button);
        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        addHeaders();

        update.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myview){

                status =tv19.getText().toString();
                loginDataBaseAdapter.updateStatus(status,compid);
                Toast.makeText(getActivity(), "Status Updated Successfully", Toast.LENGTH_LONG).show();
            }
        });

        return myView;
    }
}
