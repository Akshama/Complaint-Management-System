package com.tcs.cmslogin;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ISHA GUPTA on 30-07-2017.
 */

public class Show_Profile1 extends Fragment {

    TextView name;
    View view;
    String name1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view=inflater.inflate(R.layout.fragment_profile1,container,false);

        name = (TextView) view.findViewById(R.id.textView1);
        Intent i= getActivity().getIntent();
        name1=i.getStringExtra("name");



        name.append(name1);

        return view;

    }
}
