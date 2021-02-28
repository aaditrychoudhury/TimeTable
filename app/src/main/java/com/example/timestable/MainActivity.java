package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generateTimeTable(int timesTable){

        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int i = 1; i<=10; i++)
        {
            timesTableContent.add(Integer.toString(i * timesTable));

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTableListView = (ListView)findViewById(R.id.timesTableListView);
        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTable;
                if (progress < min){
                    timeTable = min;
                } else {
                    timeTable = progress;
                }
                generateTimeTable(timeTable);

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimeTable(10);


    }
}