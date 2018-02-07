package com.example.soumit.profileapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Soumit on 2/7/2018.
 */

public class NearbyFragment extends Fragment {

    View view;

    public NearbyFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.nearby_layout, container, false);

        return view;
    }
}