package com.tcs.cmslogin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
<<<<<<< HEAD
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
=======
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b

/**
 * Created by hema on 28-Jun-17.
 */

<<<<<<< HEAD
public class ChangePassword extends Fragment {

    View myView;
    Button change_passw;
    LoginDataBaseAdapter loginDataBaseAdapter;
    TextView current_pass,new_pass,confirm_pass;
=======
public class ChangePassword extends Fragment{

    View myView;
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
<<<<<<< HEAD
        ((AdminActivity) getActivity()).setActionBarTitle("ChangePassword");

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        myView=inflater.inflate(R.layout.changepassword,container,false);

        change_passw=(Button)myView.findViewById(R.id.change_pass);
        current_pass=(TextView)myView.findViewById(R.id.current_pass);
        new_pass=(TextView)myView.findViewById(R.id.new_pass);
        confirm_pass=(TextView)myView.findViewById(R.id.confirm_pass);



        change_passw.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myview){
                Log.d("going","gone");
                if(!confirm_pass.getText().toString().equals(new_pass.getText().toString()))
                    Toast.makeText(getActivity(), "Password does not match", Toast.LENGTH_LONG).show();
                else
                    loginDataBaseAdapter.updateEntryA(confirm_pass.getText().toString());
            }
        });
        return myView;
    }






=======
        myView=inflater.inflate(R.layout.changepassword,container,false);
        return myView;
    }
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
}
