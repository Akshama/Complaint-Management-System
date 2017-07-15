package com.tcs.cmslogin;

<<<<<<< HEAD
import android.app.Fragment;
=======
<<<<<<< HEAD
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
=======
import android.app.Fragment;
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import android.widget.Button;
=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60

/**
 * Created by hema on 28-Jun-17.
 */

public class Logout extends Fragment {

    View myView;
<<<<<<< HEAD
=======
<<<<<<< HEAD
    Button yes;
    LoginDataBaseAdapter loginDataBaseAdapter;
=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
<<<<<<< HEAD
        myView=inflater.inflate(R.layout.logout,container,false);
=======
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
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
        return myView;
    }
}
