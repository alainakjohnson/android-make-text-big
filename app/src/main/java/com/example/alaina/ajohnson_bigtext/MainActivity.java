package com.example.alaina.ajohnson_bigtext;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Fragment1.FragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, new Fragment1());
        fragmentTransaction.commit();
    }

    @Override
    public void onTextUpdate(String newText, int newColor) {
        View twoContainers = findViewById(R.id.container2);
        if(twoContainers != null){
            Fragment2 frag = new Fragment2();
            frag.updateData(newText, newColor);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.addToBackStack(null);
            transaction.replace(R.id.container2, frag, "fragment2").commit();
        }
        else {
            Fragment2 frag = new Fragment2();
            frag.updateData(newText, newColor);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.addToBackStack(null);
            transaction.replace(R.id.container, frag, "fragment2").commit();
        }
    }
}