package com.tcs.cmslogin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hema on 28-Jun-17.
 */

public class ChangePassword extends Fragment{

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        myView=inflater.inflate(R.layout.changepassword,container,false);
        return myView;
    }
}
