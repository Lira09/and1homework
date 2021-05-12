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



public class ThirdFragment extends Fragment {
    private  Bundle ownOne;
    private String fromSecond;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            ownOne = getArguments();
            fromSecond = ownOne.getString("from_second");
            Log.e("test2343", "onCreate: this is third fragment YO  "+ fromSecond );
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button_third_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle fromThird = new Bundle();
                fromThird.putString("from_third", fromSecond);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment forth = new FourthFragment();
                forth.setArguments(fromThird);
                fragmentManager.beginTransaction()
                        .replace(R.id.fr_cont, forth)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_third, container, false);
    }
}