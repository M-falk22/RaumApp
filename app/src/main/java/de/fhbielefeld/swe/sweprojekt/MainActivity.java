package de.fhbielefeld.swe.sweprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TimePicker Picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Picker = findViewById(R.id.time_picker);
        Picker.setIs24HourView(true);
    }
}