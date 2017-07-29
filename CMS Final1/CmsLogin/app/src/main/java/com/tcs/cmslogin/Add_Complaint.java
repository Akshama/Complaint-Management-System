package com.tcs.cmslogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Complaint extends AppCompatActivity {

    public EditText nam,email,phone,complaint;
    Button create;
    user_complaint userComplaintList;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__complaint);
        userComplaintList = new user_complaint();

        loginDataBaseAdapter= new LoginDataBaseAdapter(this);

        nam= (EditText)findViewById(R.id.name);
        email= (EditText)findViewById(R.id.email_id);
        phone= (EditText)findViewById(R.id.contact_no);
        complaint= (EditText)findViewById(R.id.complaint);
        create=(Button) findViewById(R.id.submit);

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

                userComplaintList.setName(name1);
                userComplaintList.setEmail(email1);
                userComplaintList.setPhone(phone1);
                userComplaintList.setComplaint(complaint1);
                userComplaintList.setStatus("Pending");

                loginDataBaseAdapter.insertEntryC(userComplaintList);

                Intent i= new Intent(Add_Complaint.this,ViewComp.class);
//                i.putExtra("Name",name1);
//                i.putExtra("Email",email1);
//                i.putExtra("Phone",phone1);
//                i.putExtra("Complaint",complaint1);

                startActivity(i);

            }
        });
    }
}
