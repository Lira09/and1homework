package com.geek.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditFragment extends Fragment {

    private EditText editTitle;
    private Button btnSand;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initView(View view) {
        btnSand = view.findViewById(R.id.button_1_test2);
        editTitle = view.findViewById(R.id.edit_one_test2);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        btnSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editTitle.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("edit_value", value);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment secondFrag = new SecondFragment();
                secondFrag.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.fr_cont, secondFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}