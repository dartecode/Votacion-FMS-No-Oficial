package com.dartcode.votacion_fms.Rondas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.dartcode.votacion_fms.R;

public class Sangre1Activity extends AppCompatActivity {

    private Spinner mc1patron1, mc1patron2, mc1patron3, mc1patron4, mc1patron5, mc1patron6, mc1extra1, mc1extra2, mc1extra3,
            mc2patron1, mc2patron2,  mc2patron3, mc2patron4, mc2patron5, mc2patron6, mc2extra1, mc2extra2,mc2extra3;

    private CheckBox cbRespuesta1Mc1, cbRespuesta2Mc1, cbRespuesta3Mc1, cbRespuesta4Mc1, cbRespuesta5Mc1, cbRespuesta6Mc1;

    int sangre1MC1, sangre1MC2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sangre1);
        getSupportActionBar().setTitle("MINUTO A SANGRE IDA");
        TextView mc1 = findViewById(R.id.sangre1_mc1);
        TextView mc2 = findViewById(R.id.sangre1_mc2);
        Button btnContinuar = findViewById(R.id.btnSangre1Continuar);

        mc1patron1 = findViewById(R.id.s1mc1p1);
        mc1patron2 = findViewById(R.id.s1mc1p2);
        mc1patron3 = findViewById(R.id.s1mc1p3);
        mc1patron4 = findViewById(R.id.s1mc1p4);
        mc1patron5 = findViewById(R.id.s1mc1p5);
        mc1patron6 = findViewById(R.id.s1mc1p6);
        mc1extra1 = findViewById(R.id.s1mc1e1);
        mc1extra2 = findViewById(R.id.s1mc1e2);
        mc1extra3 = findViewById(R.id.s1mc1e3);
        mc2patron1 = findViewById(R.id.s1mc2p1);
        mc2patron2 = findViewById(R.id.s1mc2p2);
        mc2patron3 = findViewById(R.id.s1mc2p3);
        mc2patron4 = findViewById(R.id.s1mc2p4);
        mc2patron5 = findViewById(R.id.s1mc2p5);
        mc2patron6 = findViewById(R.id.s1mc2p6);
        mc2extra1 = findViewById(R.id.s1mc2e1);
        mc2extra2 = findViewById(R.id.s1mc2e2);
        mc2extra3 = findViewById(R.id.s1mc2e3);

        cbRespuesta1Mc1 = findViewById(R.id.sangre1_cb1);
        cbRespuesta2Mc1 = findViewById(R.id.sangre1_cb2);
        cbRespuesta3Mc1 = findViewById(R.id.sangre1_cb3);
        cbRespuesta4Mc1 = findViewById(R.id.sangre1_cb4);
        cbRespuesta5Mc1 = findViewById(R.id.sangre1_cb5);
        cbRespuesta6Mc1 = findViewById(R.id.sangre1_cb6);

        llenarSpinners();

        SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
        mc1.setText(preferences.getString("mc1", ""));
        mc2.setText(preferences.getString("mc2", ""));

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puntuar();
                Intent pasarPantalla = new Intent(Sangre1Activity.this, Sangre2Activity.class);
                startActivity(pasarPantalla);
            }
        });
    }

    private void llenarSpinners() {
        ArrayAdapter<CharSequence> patrones = ArrayAdapter.createFromResource(this,
                R.array.Patrones,R.layout.spinner_item_fms);
        ArrayAdapter<CharSequence> extras = ArrayAdapter.createFromResource(this,
                R.array.Extras,R.layout.spinner_item_fms);
        mc1patron1.setAdapter(patrones);
        mc1patron2.setAdapter(patrones);
        mc1patron3.setAdapter(patrones);
        mc1patron4.setAdapter(patrones);
        mc1patron5.setAdapter(patrones);
        mc1patron6.setAdapter(patrones);
        mc2patron1.setAdapter(patrones);
        mc2patron2.setAdapter(patrones);
        mc2patron3.setAdapter(patrones);
        mc2patron4.setAdapter(patrones);
        mc2patron5.setAdapter(patrones);
        mc2patron6.setAdapter(patrones);
        mc1extra1.setAdapter(extras);
        mc1extra2.setAdapter(extras);
        mc1extra3.setAdapter(extras);
        mc2extra1.setAdapter(extras);
        mc2extra2.setAdapter(extras);
        mc2extra3.setAdapter(extras);
    }

    private void puntajeMC1() {
        int patron1 = mc1patron1.getSelectedItemPosition();
        int patron2 = mc1patron2.getSelectedItemPosition();
        int patron3 = mc1patron3.getSelectedItemPosition();
        int patron4 = mc1patron4.getSelectedItemPosition();
        int patron5 = mc1patron5.getSelectedItemPosition();
        int patron6 = mc1patron6.getSelectedItemPosition();
        int extra1 = mc1extra1.getSelectedItemPosition();
        int extra2 = mc1extra2.getSelectedItemPosition();
        int extra3 = mc1extra3.getSelectedItemPosition();
        sangre1MC1 = patron1 + patron2 + patron3 + patron4 + patron5 + patron6 + extra1 + extra2 + extra3;

        if (cbRespuesta1Mc1.isChecked()){
            sangre1MC1++;
        }
        if (cbRespuesta2Mc1.isChecked()){
            sangre1MC1++;
        }
        if (cbRespuesta3Mc1.isChecked()){
            sangre1MC1++;
        }
        if (cbRespuesta4Mc1.isChecked()){
            sangre1MC1++;
        }
        if (cbRespuesta5Mc1.isChecked()){
            sangre1MC1++;
        }
        if (cbRespuesta6Mc1.isChecked()){
            sangre1MC1++;
        }

    }

    private void puntajeMC2() {
        int patron1 = mc2patron1.getSelectedItemPosition();
        int patron2 = mc2patron2.getSelectedItemPosition();
        int patron3 = mc2patron3.getSelectedItemPosition();
        int patron4 = mc2patron4.getSelectedItemPosition();
        int patron5 = mc2patron5.getSelectedItemPosition();
        int patron6 = mc2patron6.getSelectedItemPosition();
        int extra1 = mc2extra1.getSelectedItemPosition();
        int extra2 = mc2extra2.getSelectedItemPosition();
        int extra3 = mc2extra3.getSelectedItemPosition();
        sangre1MC2 = patron1 + patron2 + patron3 + patron4 + patron5 + patron6 + extra1 + extra2 + extra3;
    }

    private void puntuar(){
        puntajeMC1();
        puntajeMC2();
        SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("sangre1MC1", sangre1MC1);
        editor.putInt("sangre1MC2", sangre1MC2);
        editor.commit();
    }

}
