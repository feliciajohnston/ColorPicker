package com.example.csaper6.colorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView r,g,b;
    private SeekBar seekR, seekG, seekB;
    private int red, green, blue;
    private TableLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (TableLayout) findViewById(R.id.layout);
        r = (TextView) findViewById(R.id.textView_red);
        g = (TextView) findViewById(R.id.textView_green);
        b = (TextView) findViewById(R.id.textView_blue);

        seekR = (SeekBar) findViewById(R.id.seekBar_red);
        seekG = (SeekBar) findViewById(R.id.seekBar_green);
        seekB = (SeekBar) findViewById(R.id.seekBar_blue);

        red = Color.red(seekR.getProgress());
        green = Color.green(seekG.getProgress());
        blue = Color.green(seekB.getProgress());


        seekR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "RED", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeBackground();
                r.setText("R: " + seekBar.getProgress());
            }
        });

        seekG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity.this, "GREEN", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeBackground();
                g.setText("G: " + seekBar.getProgress());
            }
        });

        seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "BLUE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b.setText("B: " + seekBar.getProgress());
                changeBackground();
            }
        });

    }

    private void changeBackground() {
        red = seekR.getProgress();
        green =seekG.getProgress();
        blue = seekB.getProgress();
        layout.setBackgroundColor(Color.rgb(red, green,blue));

    }
}

