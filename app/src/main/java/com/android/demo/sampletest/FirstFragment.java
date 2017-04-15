package com.android.demo.sampletest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bhara on 15/04/17.
 */

public class FirstFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        //      mTracker.enableAutoActivityTracking(true);

        return rootView;
    }
}
