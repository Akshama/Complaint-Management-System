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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akshama PC on 27-Jun-17.
 */

public class E_ViewAssignedComplaints extends Fragment  {

    View myView;
    LoginDataBaseAdapter loginDataBaseAdapter;
    TextView tv16,tv18,tv19;
    String id=null;
    String empid1, compID;

    public void addHeaders(){

        /** Create a TableRow dynamically **/


        addData();

    }

    public void addData() {
        Intent i = getActivity().getIntent();
        empid1 = i.getStringExtra("ID");
        String compid = loginDataBaseAdapter.getSelect_AssignedCompId(empid1);
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
        myView=inflater.inflate(R.layout.viewassignedcomplaints,container,false);
        tv16 = (TextView) myView.findViewById(R.id.textView16);
        tv18 = (TextView) myView.findViewById(R.id.textView18);
        tv19 = (TextView) myView.findViewById(R.id.textView19);
        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        addHeaders();

        return myView;
    }
}
