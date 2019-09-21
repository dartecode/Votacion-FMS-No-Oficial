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
import android.widget.Spinner;
import android.widget.TextView;

import com.dartcode.votacion_fms.R;
import com.dartcode.votacion_fms.ResultadoActivity;

public class DeluxeActivity extends AppCompatActivity {

    private Spinner mc1patron1, mc1patron2, mc1patron3, mc1patron4, mc1patron5, mc1patron6,
            mc1patron7, mc1patron8, mc1patron9, mc1patron10, mc1patron11, mc1extra1, mc1extra2, mc1extra3,
            mc2patron1, mc2patron2,  mc2patron3, mc2patron4, mc2patron5, mc2patron6,
            mc2patron7, mc2patron8, mc2patron9, mc2patron10, mc2patron11, mc2extra1, mc2extra2,mc2extra3;

    int deluxeMC1, deluxeMC2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deluxe);
        getSupportActionBar().setTitle("DELUXE");
        TextView mc1 = findViewById(R.id.deluxe_mc1);
        TextView mc2 = findViewById(R.id.deluxe_mc2);
        Button btnContinuar = findViewById(R.id.btnDeluxeContinuar);

        mc1patron1 = findViewById(R.id.d1p1);
        mc1patron2 = findViewById(R.id.d1p2);
        mc1patron3 = findViewById(R.id.d1p3);
        mc1patron4 = findViewById(R.id.d1p4);
        mc1patron5 = findViewById(R.id.d1p5);
        mc1patron6 = findViewById(R.id.d1p6);
        mc1patron7 = findViewById(R.id.d1p7);
        mc1patron8 = findViewById(R.id.d1p8);
        mc1patron9 = findViewById(R.id.d1p9);
        mc1patron10 = findViewById(R.id.d1p10);
        mc1patron11 = findViewById(R.id.d1p11);
        mc1extra1 = findViewById(R.id.d1e1);
        mc1extra2 = findViewById(R.id.d1e2);
        mc1extra3 = findViewById(R.id.d1e3);
        mc2patron1 = findViewById(R.id.d2p1);
        mc2patron2 = findViewById(R.id.d2p2);
        mc2patron3 = findViewById(R.id.d2p3);
        mc2patron4 = findViewById(R.id.d2p4);
        mc2patron5 = findViewById(R.id.d2p5);
        mc2patron6 = findViewById(R.id.d2p6);
        mc2patron7 = findViewById(R.id.d2p7);
        mc2patron8 = findViewById(R.id.d2p8);
        mc2patron9 = findViewById(R.id.d2p9);
        mc2patron10 = findViewById(R.id.d2p10);
        mc2patron11 = findViewById(R.id.d2p11);
        mc2extra1 = findViewById(R.id.d2e1);
        mc2extra2 = findViewById(R.id.d2e2);
        mc2extra3 = findViewById(R.id.d2e3);

        SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
        mc1.setText(preferences.getString("mc1", ""));
        mc2.setText(preferences.getString("mc2", ""));

        llenarSpinners();

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alerta = new AlertDialog.Builder(DeluxeActivity.this);
                alerta.setMessage("¿Ha puntuado todos los patrones?")
                        .setCancelable(true)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                puntuar();
                                Intent pasarPantalla = new Intent(DeluxeActivity.this, ResultadoActivity.class);
                                startActivity(pasarPantalla);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Ir a resultado");
                titulo.show();
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
        mc1patron7.setAdapter(patrones);
        mc1patron8.setAdapter(patrones);
        mc1patron9.setAdapter(patrones);
        mc1patron10.setAdapter(patrones);
        mc1patron11.setAdapter(patrones);
        mc1extra1.setAdapter(extras);
        mc1extra2.setAdapter(extras);
        mc1extra3.setAdapter(extras);
        mc2patron1.setAdapter(patrones);
        mc2patron2.setAdapter(patrones);
        mc2patron3.setAdapter(patrones);
        mc2patron4.setAdapter(patrones);
        mc2patron5.setAdapter(patrones);
        mc2patron6.setAdapter(patrones);
        mc2patron7.setAdapter(patrones);
        mc2patron8.setAdapter(patrones);
        mc2patron9.setAdapter(patrones);
        mc2patron10.setAdapter(patrones);
        mc2patron11.setAdapter(patrones);
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
        int patron7 = mc1patron7.getSelectedItemPosition();
        int patron8 = mc1patron8.getSelectedItemPosition();
        int patron9 = mc1patron9.getSelectedItemPosition();
        int patron10 = mc1patron10.getSelectedItemPosition();
        int patron11 = mc1patron11.getSelectedItemPosition();
        int extra1 = mc1extra1.getSelectedItemPosition();
        int extra2 = mc1extra2.getSelectedItemPosition();
        int extra3 = mc1extra3.getSelectedItemPosition();
        deluxeMC1 = patron1 + patron2 + patron3 + patron4 + patron5 + patron6 +
                patron7 + patron8 + patron9 + patron10 + patron11 + extra1 + extra2 + extra3;
    }

    private void puntajeMC2() {
        int patron1 = mc2patron1.getSelectedItemPosition();
        int patron2 = mc2patron2.getSelectedItemPosition();
        int patron3 = mc2patron3.getSelectedItemPosition();
        int patron4 = mc2patron4.getSelectedItemPosition();
        int patron5 = mc2patron5.getSelectedItemPosition();
        int patron6 = mc2patron6.getSelectedItemPosition();
        int patron7 = mc2patron7.getSelectedItemPosition();
        int patron8 = mc2patron8.getSelectedItemPosition();
        int patron9 = mc2patron9.getSelectedItemPosition();
        int patron10 = mc2patron10.getSelectedItemPosition();
        int patron11 = mc2patron11.getSelectedItemPosition();
        int extra1 = mc2extra1.getSelectedItemPosition();
        int extra2 = mc2extra2.getSelectedItemPosition();
        int extra3 = mc2extra3.getSelectedItemPosition();
        deluxeMC2 = patron1 + patron2 + patron3 + patron4 + patron5 + patron6 +
                patron7 + patron8 + patron9 + patron10 + patron11 + extra1 + extra2 + extra3;
    }

    private void puntuar(){
        puntajeMC1();
        puntajeMC2();
        SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("deluxeMC1", deluxeMC1);
        editor.putInt("deluxeMC2", deluxeMC2);
        editor.commit();
    }


}
