package com.example.alaina.ajohnson_bigtext;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.graphics.Color;

public class Fragment1 extends Fragment {

    private FragListener listener;

    private int seekR, seekG, seekB;
    private SeekBar Red, Green, Blue;
    private EditText text;
    private Button submit;

    public interface FragListener {
        void onTextUpdate (String newText, int newColor);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        text = view.findViewById(R.id.yourText);
        submit = view.findViewById(R.id.submit_btn);

        Red = view.findViewById(R.id.rseek);
        Green = view.findViewById(R.id.gseek);
        Blue = view.findViewById(R.id.bseek);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newText = getString(text);
                int newColor = getColor();
                listener.onTextUpdate(newText, newColor);
            }
        });

        Red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekR = progress;
                preview(text);
            }
        });

        Green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekG = progress;
                preview(text);
            }
        });

        Blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekB = progress;
                preview(text);
            }
        });

        return view;
    }

    private String getString(EditText text) {
        String s = text.getText().toString();
        return s;
    }

    private int getColor() {
        int color = Color.rgb(seekR, seekG, seekB);
        return color;
    }

    private void preview(EditText text) {
        text.setTextColor(getColor());
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof FragListener){
            listener = (FragListener)context;
        }
        else {
            throw new RuntimeException(context.toString()
                + " must implement FragListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }
}