package com.tcs.cmslogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.text.TextUtils.isEmpty;

/**
 * Created by ISHA GUPTA on 12-07-2017.
 */

public class Show_Profile extends Fragment {

    EditText name,phone,a1,a2,a3;

    Button submit;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_profile1, container, false);
        name = (EditText) view.findViewById(R.id.name);
        phone = (EditText) view.findViewById(R.id.contact_no);
        a1 = (EditText) view.findViewById(R.id.addr_street);
        a2 = (EditText) view.findViewById(R.id.addr_city);
        a3 = (EditText) view.findViewById(R.id.addr_country);

        submit = (Button) view.findViewById(R.id.submit);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("MY PROFILE");
    }

}
