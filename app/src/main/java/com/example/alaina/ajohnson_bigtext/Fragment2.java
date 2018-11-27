package com.example.alaina.ajohnson_bigtext;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private TextView textDisplay;
    private String text;
    private int color;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);

        textDisplay = view.findViewById(R.id.bigtext);
        textDisplay.setText(text);
        textDisplay.setTextColor(color);

        return view;
    }

    public void updateData(String newText, int newColor){
        this.text = newText;
        this.color = newColor;
    }
}
