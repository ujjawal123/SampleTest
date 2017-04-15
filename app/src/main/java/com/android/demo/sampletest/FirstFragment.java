package com.android.demo.sampletest;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bhara on 15/04/17.
 */

public class FirstFragment extends Fragment {


    public static FirstFragment newInstance(String data) {
        Bundle args = new Bundle();
        args.putString("title", data);
        args.putString("dob","25,May");
        args.putString("ars","asdfd");
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, null);
    }
    private void test(){

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView= (TextView) view.findViewById(R.id.title);
        setValue(textView,"hi there");

    }


    private void getFormatted(){
    }


    private void onTest(String test) {
    }


    private void setValue(TextView vview,String value){
        vview.setText(String.valueOf(value));
        Log.i("TAG","executing");
    }

    private void delete(){
    }
}
