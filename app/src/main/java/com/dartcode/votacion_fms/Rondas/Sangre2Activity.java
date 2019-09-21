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

public class Sangre2Activity extends AppCompatActivity {

    private Spinner mc1patron1, mc1patron2, mc1patron3, mc1patron4, mc1patron5, mc1patron6, mc1extra1, mc1extra2, mc1extra3,
            mc2patron1, mc2patron2,  mc2patron3, mc2patron4, mc2patron5, mc2patron6, mc2extra1, mc2extra2,mc2extra3;

    private CheckBox cbRespuesta1Mc2, cbRespuesta2Mc2, cbRespuesta3Mc2, cbRespuesta4Mc2, cbRespuesta5Mc2, cbRespuesta6Mc2;

    int sangre2MC1, sangre2MC2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sangre2);
        getSupportActionBar().setTitle("MINUTO A SANGRE VUELTA");
        TextView mc1 = findViewById(R.id.sangre2_mc1);
        TextView mc2 = findViewById(R.id.sangre2_mc2);
        Button btnContinuar = findViewById(R.id.btnSangre2Continuar);

        mc1patron1 = findViewById(R.id.s2mc1p1);
        mc1patron2 = findViewById(R.id.s2mc1p2);
        mc1patron3 = findViewById(R.id.s2mc1p3);
        mc1patron4 = findViewById(R.id.s2mc1p4);
        mc1patron5 = findViewById(R.id.s2mc1p5);
        mc1patron6 = findViewById(R.id.s2mc1p6);
        mc1extra1 = findViewById(R.id.s2mc1e1);
        mc1extra2 = findViewById(R.id.s2mc1e2);
        mc1extra3 = findViewById(R.id.s2mc1e3);
        mc2patron1 = findViewById(R.id.s2mc2p1);
        mc2patron2 = findViewById(R.id.s2mc2p2);
        mc2patron3 = findViewById(R.id.s2mc2p3);
        mc2patron4 = findViewById(R.id.s2mc2p4);
        mc2patron5 = findViewById(R.id.s2mc2p5);
        mc2patron6 = findViewById(R.id.s2mc2p6);
        mc2extra1 = findViewById(R.id.s2mc2e1);
        mc2extra2 = findViewById(R.id.s2mc2e2);
        mc2extra3 = findViewById(R.id.s2mc2e3);

        cbRespuesta1Mc2 = findViewById(R.id.sangre2_cb1);
        cbRespuesta2Mc2 = findViewById(R.id.sangre2_cb2);
        cbRespuesta3Mc2 = findViewById(R.id.sangre2_cb3);
        cbRespuesta4Mc2 = findViewById(R.id.sangre2_cb4);
        cbRespuesta5Mc2 = findViewById(R.id.sangre2_cb5);
        cbRespuesta6Mc2 = findViewById(R.id.sangre2_cb6);

        SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
        mc1.setText(preferences.getString("mc1", ""));
        mc2.setText(preferences.getString("mc2", ""));

        llenarSpinners();

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puntuar();
                Intent pasarPantalla = new Intent(Sangre2Activity.this, DeluxeActivity.class);
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
        sangre2MC1 = patron1 + patron2 + patron3 + patron4 + patron5 + patron6 + extra1 + extra2 + extra3;
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
        sangre2MC2 = patron1 + patron2 + patron3 + patron4 + patron5 + patron6 + extra1 + extra2 + extra3;

        if (cbRespuesta1Mc2.isChecked()){
            sangre2MC1++;
        }
        if (cbRespuesta2Mc2.isChecked()){
            sangre2MC1++;
        }
        if (cbRespuesta3Mc2.isChecked()){
            sangre2MC1++;
        }
        if (cbRespuesta4Mc2.isChecked()){
            sangre2MC1++;
        }
        if (cbRespuesta5Mc2.isChecked()){
            sangre2MC1++;
        }
        if (cbRespuesta6Mc2.isChecked()){
            sangre2MC1++;
        }
    }

    private void puntuar(){
        puntajeMC1();
        puntajeMC2();
        SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("sangre2MC1", sangre2MC1);
        editor.putInt("sangre2MC2", sangre2MC2);
        editor.commit();
    }

}
