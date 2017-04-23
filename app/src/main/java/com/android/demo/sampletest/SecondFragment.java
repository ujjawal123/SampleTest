package com.android.demo.sampletest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bhara on 16/04/17.
 */

public class SecondFragment extends android.support.v4.app.Fragment {

    public static SecondFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("title",title);
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_frag,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView= (TextView) view.findViewById(R.id.title);
        textView.setText(getArguments().getString("title","second nil"));
    }

    public interface OnThirdLoad{
        void onThrirdFrag();
    }


}
