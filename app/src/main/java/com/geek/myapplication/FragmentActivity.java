package com.geek.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFragment();
    }
    private void startFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment editFrag = new EditFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fr_cont, editFrag)
                .addToBackStack(null)
                .commit();

    }
}