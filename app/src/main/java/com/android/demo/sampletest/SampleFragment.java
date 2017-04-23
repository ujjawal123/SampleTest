package com.android.demo.sampletest;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ujjaw on 15-04-2017.
 */
public class SampleFragment extends Fragment implements View.OnClickListener {

    private LoadSecondFragment  listener;
    public static SampleFragment newInstance(Bundle bundle) {

        SampleFragment fragment = new SampleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txt = (TextView) view.findViewById(R.id.title);

        view.findViewById(R.id.btn_frag).setOnClickListener(this);
        if (getArguments() != null) {

            String s1 = getArguments().getString("title", null);
            txt.setText(TextUtils.isEmpty(s1) ? "No title found" : s1);

            UserData data=getArguments().getParcelable("parce");


            String format=String.format("Name %s\nAddress %s\nAge %d",data.name,data.address,data.age);
            txt.setText(txt.getText()+"\n"+format);
            /*if (TextUtils.isEmpty(s1)) {
                txt.setText("No title found");
            } else if ("no_title".equalsIgnoreCase(s1)) {
                txt.setText("Title not assigned");
            } else {
                txt.setText(s1);
            }*/

            //null emptyt no title found
            //no_title   title_not assigned
            //title title
        }


        //boolean bool;//false
        //Boolean bools;//null

        //value is empty
        //value is false
        //value is truye

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof LoadSecondFragment)
            listener= (LoadSecondFragment) context;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onSecondFrag("Second fragment launching from the first fragment");
        }
    }

    public interface  LoadSecondFragment{
        void onSecondFrag(String bundle);
        void onThrirdFrag();
    }
}