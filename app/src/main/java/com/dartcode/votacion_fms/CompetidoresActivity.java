package com.dartcode.votacion_fms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.dartcode.votacion_fms.Rondas.EasyModeActivity;

public class CompetidoresActivity extends AppCompatActivity {

    TextView lblNombre;
    Button btnEmpezarBatalla;
    Spinner spinnerMc_uno, spinnerMc_dos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competidores);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        spinnerMc_uno = (Spinner) findViewById(R.id.mc_uno);
        spinnerMc_dos = (Spinner) findViewById(R.id.mc_dos);
        btnEmpezarBatalla = (Button) findViewById(R.id.btnEmpezarBatalla);

        String pais = getIntent().getStringExtra("PAIS");
        lblNombre.setText("FMS " + pais);
        SpinnerEleccion(pais);

        btnEmpezarBatalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("mc1", spinnerMc_uno.getSelectedItem().toString());
                editor.putString("mc2", spinnerMc_dos.getSelectedItem().toString());
                editor.commit();
                Intent intent = new Intent(CompetidoresActivity.this, EasyModeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void SpinnerEleccion(String pais) {

        ArrayAdapter<CharSequence> adapter;

        switch (pais){
            case "ESPAÑA":
                adapter = ArrayAdapter.createFromResource(this, R.array.ESPAÑA,
                        R.layout.spinner_item_fms);
                spinnerMc_uno.setAdapter(adapter);
                spinnerMc_dos.setAdapter(adapter);
                break;

            case "ARGENTINA":
                adapter = ArrayAdapter.createFromResource(this, R.array.ARGENTINA,
                        R.layout.spinner_item_fms);
                spinnerMc_uno.setAdapter(adapter);
                spinnerMc_dos.setAdapter(adapter);
                break;

            case "CHILE":
                adapter = ArrayAdapter.createFromResource(this, R.array.CHILE,
                        R.layout.spinner_item_fms);
                spinnerMc_uno.setAdapter(adapter);
                spinnerMc_dos.setAdapter(adapter);
                break;

            case "MEXICO":
                adapter = ArrayAdapter.createFromResource(this, R.array.MEXICO,
                        R.layout.spinner_item_fms);
                spinnerMc_uno.setAdapter(adapter);
                spinnerMc_dos.setAdapter(adapter);
                break;
        }
    }

}
