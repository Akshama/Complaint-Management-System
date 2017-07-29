package com.tcs.cmslogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ISHA GUPTA on 27-07-2017.
 */

public class ViewComp extends AppCompatActivity {

    LoginDataBaseAdapter loginDataBaseAdapter;
    user_complaint userComplaintList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter viewComplaintAdapter;
    TextView nam,email,phone,complaint,status;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);

        nam = (TextView) findViewById(R.id.name1);
        email = (TextView) findViewById(R.id.email1);
        phone = (TextView) findViewById(R.id.phone1);
        complaint = (TextView) findViewById(R.id.comp1);
        status = (TextView) findViewById(R.id.status1);
        delete = (Button) findViewById(R.id.submit);

//        nam.setText(getIntent().getStringExtra("Name"));
//        email.setText(getIntent().getStringExtra("Email"));
//        phone.setText(getIntent().getStringExtra("Phone"));
//        complaint.setText(getIntent().getStringExtra("Complaint"));
//        status.setText("Pending");

//        String status=loginDataBaseAdapter.getstatus(userComplaintList.get(position).getId());
//        if(status=="Resolved"){
//            holder.status.setText("Resolved");
//
//        }else
//        {
//            holder.status.setText("Pending");
//
//        }

        userComplaintList = loginDataBaseAdapter.getcomplaint(getIntent().getStringExtra("name"));
        nam.setText(userComplaintList.getName());
        email.setText(userComplaintList.getEmail());
        phone.setText(userComplaintList.getPhone());
        complaint.setText(userComplaintList.getComplaint());
        status.setText(userComplaintList.getStatus());

//        if (status.getText().toString().equalsIgnoreCase("Resolved")) {
//
//            delete.setVisibility(View.VISIBLE);
//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    loginDataBaseAdapter.delete_complaint(userComplaintList.getId());
//                }
//            });
//
//        }


//        if(loginDataBaseAdapter.inComplaint()){if(loginDataBaseAdapter.getstatus(userComplaintList.getId()).equalsIgnoreCase("Resolved")){
//            status.setText("Resolved");
//            delete.setVisibility(View.VISIBLE);
//        }}
//
//        if(delete.getVisibility()==View.VISIBLE){
//
//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    loginDataBaseAdapter.delete_complaint(userComplaintList.getId());
//                }
//            });
//
//        }


    }
}
