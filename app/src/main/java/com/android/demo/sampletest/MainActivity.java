package com.android.demo.sampletest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SampleFragment.LoadSecondFragment,SecondFragment.OnThirdLoad {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //frg_test=(Button)findViewById(R.id.frg_test);

        //if we need to set only listener no need to create button/view object
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        List<String> ara=new ArrayList<>();


        if (v.getId() == R.id.button1) {
            UserData data=new UserData();
            data.name="Bharatesh";
            data.address="bnaglaore";
                    data.age=29;
            data.courses=new String[]{"a","b"};
            data.isMarried=true;
            data.subjs=Arrays.asList(data.courses);

            Bundle bundle=new Bundle();
            bundle.putString("title","Test Parcelable");
            bundle.putParcelable("parce",data);
            fragment = SampleFragment.newInstance(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            // fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (v.getId() == R.id.button2) {
            onSecondFrag("This is a second fragment loading from activity");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onSecondFrag(String s) {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, SecondFragment.newInstance(s));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onThrirdFrag() {

    }
}
