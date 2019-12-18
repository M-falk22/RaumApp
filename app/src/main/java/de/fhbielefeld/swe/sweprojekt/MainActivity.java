package de.fhbielefeld.swe.sweprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TimePicker;

import android.widget.Button;
import android.view.View;
import android.widget.EditText;





public class MainActivity extends AppCompatActivity {
    TimePicker Picker;
    Button Button;
    Raum[] RaumListe = new Raum[10]; // 10 Speicherpunkte [Array]
    EditText RaumEingabe;
    int AnzahlRaum = 0;
    int RaumIndex = 0;

    @Override


    protected void onCreate(Bundle savedInstanceState) {    //In dem R Objekt liegen IDs für jedes User Interface Element,
        super.onCreate(savedInstanceState);                 //welche man per XML angelegt hat.
        setContentView(R.layout.activity_main);
        Button = findViewById(R.id.button);
        Picker = findViewById(R.id.time_picker);
        Picker.setIs24HourView(true);
        RaumEingabe = findViewById(R.id.editText);


        RaumListe[AnzahlRaum] = new Raum(AnzahlRaum++);     //Ein Raum wird erstellt und an die erste Stelle vom Array gelegt.

        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                RaumIndex = Integer.parseInt(RaumEingabe.getText().toString()); //Erstmal nur Zahlen

                if(RaumIndex < AnzahlRaum)
                {
                    int StartzeitStunde = Picker.getHour();
                    int StartzeitMinute = Picker.getMinute();

                    RaumListe[RaumIndex].Buchen(StartzeitStunde, StartzeitMinute);  //Zeit und Raum werden gespeichert

                    int AnzahlBuchungen = RaumListe[RaumIndex].AnzahlBuchungen;     //Testcode

                    Buchung TestBuchung = RaumListe[RaumIndex].getBuchung(AnzahlBuchungen-1);

                    System.out.println("Raum: "+RaumListe[RaumIndex]+" Startzeit: "+TestBuchung.StartzeitStunde+":"+TestBuchung.StartzeitMinute);
                }
            }
        });
    }


}
