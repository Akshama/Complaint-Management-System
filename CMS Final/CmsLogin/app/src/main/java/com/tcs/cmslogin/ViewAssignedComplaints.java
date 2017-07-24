package com.tcs.cmslogin;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akshama PC on 23-Jul-17.
 */

public class ViewAssignedComplaints extends Fragment {

    View myView;
    LoginDataBaseAdapter loginDataBaseAdapter;
    TextView tv0;
    String id=null;

    ArrayList<TextView> tv=new ArrayList<>();

    public void addHeaders(){

        /** Create a TableRow dynamically **/
        TableLayout stk = (TableLayout) myView.findViewById(R.id.t_l2);

        TableRow tbrow0 = new TableRow(this.getActivity());

        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("COMPLAINT ID");
        tv0.setTextColor(Color.BLACK);
        tv0.setPadding(20,20,20,20);
        tv0.setTypeface(null, Typeface.BOLD);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("NAME");
        tv1.setTextColor(Color.BLACK);
        tv1.setPadding(10,20,20,20);
        tv1.setTypeface(null, Typeface.BOLD);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("COMPLAINT");
        tv2.setTextColor(Color.BLACK);
        tv2.setPadding(20,20,10,20);
        tv2.setTypeface(null, Typeface.BOLD);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this.getActivity());
        tv3.setText("ENGINEER ID");
        tv3.setTextColor(Color.BLACK);
        tv3.setPadding(10,20,20,20);
        tv3.setTypeface(null, Typeface.BOLD);
        tbrow0.addView(tv3);

        stk.addView(tbrow0, new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        addData();

    }

    public void addData() {
        ArrayList<String> compid = loginDataBaseAdapter.getCompId();
        ArrayList<String> compname = loginDataBaseAdapter.getCompName();
        ArrayList<String> complaint = loginDataBaseAdapter.getComplaint();
        ArrayList<String> assign_empid = loginDataBaseAdapter.getAssigned_EmpId();

        if (compid==null)
        {
        }

        else
        {
            int i = compid.size() - 1;
            int j = 0;
            TableLayout stk = (TableLayout) myView.findViewById(R.id.t_l2);
            while (i >= 0) {
                TableRow tbrow0 = new TableRow(this.getActivity());

                tv0 = new TextView(this.getActivity());
                id = compid.get(j);

                tv.add(tv0);
                //tv.get(j).setTag(j);

                tv0.setText(id);
                tv0.setTextColor(Color.BLACK);
                tv0.setPadding(30, 30, 30, 30);


                tbrow0.addView(tv0);

                TextView tv1 = new TextView(this.getActivity());
                tv1.setText(compname.get(j));
                tv1.setTextColor(Color.BLACK);
                tv1.setPadding(10, 20, 20, 20);
                tbrow0.addView(tv1);

                TextView tv2 = new TextView(this.getActivity());
                tv2.setText(complaint.get(j));
                tv2.setTextColor(Color.BLACK);
                tv2.setPadding(30, 30, 10, 30);

                //tv2.setLines(3);
                tv2.setWidth(0);
                tbrow0.addView(tv2);

                TextView tv3 = new TextView(this.getActivity());
                if(assign_empid==null)
                {
                    tv3.setText("Not Assigned");
                }
                else {
                    tv3.setText(assign_empid.get(j));
                }
                tv3.setTextColor(Color.BLACK);
                tv3.setPadding(50, 30, 10, 30);

                //tv2.setLines(3);
                tbrow0.addView(tv3);

                j++;
                i--;

                stk.addView(tbrow0, new TableLayout.LayoutParams(
                        TableRow.LayoutParams.FILL_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
            }

        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        myView=inflater.inflate(R.layout.viewassignedcomplaints,container,false);

        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        addHeaders();

        return myView;
    }
}
