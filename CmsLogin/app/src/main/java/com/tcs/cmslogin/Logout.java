package com.tcs.cmslogin;

<<<<<<< HEAD
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
=======
import android.app.Fragment;
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Button;
=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b

/**
 * Created by hema on 28-Jun-17.
 */

public class Logout extends Fragment {

    View myView;
<<<<<<< HEAD
    Button yes;
    LoginDataBaseAdapter loginDataBaseAdapter;
=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
<<<<<<< HEAD
        ((AdminActivity) getActivity()).setActionBarTitle("Logout");

        myView=inflater.inflate(R.layout.logout,container,false);
        yes=(Button)myView.findViewById(R.id.yes);
        //no=(Button)myView.findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myview){
                Intent in=new Intent(getActivity(),MainActivity.class);
                startActivity(in);
                getActivity().finish();


            }
        });

=======
        myView=inflater.inflate(R.layout.logout,container,false);
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
        return myView;
    }
}
