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


public class FourthFragment extends Fragment {

    private Bundle onwTwo;
        private String fromThird;

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            onwTwo=getArguments();
            fromThird = onwTwo.getString("from_third");
            Log.e("test43524", "onCreate: forth fragment" + fromThird);
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button_forth_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle sendBundle = new Bundle();
                sendBundle.putString("from_fourth", fromThird);

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                Fragment fifthFrag = new FivthFragment ();

                fifthFrag.setArguments(sendBundle);

                fragmentManager.beginTransaction()
                        .replace(R.id.fr_cont, fifthFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }
}