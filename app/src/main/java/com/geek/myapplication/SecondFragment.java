package com.geek.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SecondFragment extends Fragment {
    private Bundle bundle;
    private String valueFrom;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bundle = getArguments();
            valueFrom = bundle.getString("edit_value");
            Log.e("test2343", "onCreate: this is second fragment YO" + valueFrom );
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button_second_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle sendBundle = new Bundle();
                sendBundle.putString("from_second", valueFrom);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment thirdFragment = new ThirdFragment();
                thirdFragment.setArguments(sendBundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.fr_cont, thirdFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}