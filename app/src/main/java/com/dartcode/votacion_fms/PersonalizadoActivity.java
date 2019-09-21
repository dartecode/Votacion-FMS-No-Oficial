package com.dartcode.votacion_fms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dartcode.votacion_fms.Rondas.EasyModeActivity;

public class PersonalizadoActivity extends AppCompatActivity {

    Button btnEmpezarBatalla;
    EditText txtMC1, txtMC2;
    TextView lblPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizado);
        txtMC1 = findViewById(R.id.txtMC1);
        txtMC2 = findViewById(R.id.txtMC2);
        lblPersonalizado = findViewById(R.id.lblNombrePersonalizado);
        btnEmpezarBatalla = findViewById(R.id.btnPersonalizadoEmpezarBatalla);

        String pais = getIntent().getStringExtra("PAIS");
        lblPersonalizado.setText(pais);

        btnEmpezarBatalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MC1 = txtMC1.getText().toString().toUpperCase();
                String MC2 = txtMC2.getText().toString().toUpperCase();
                if (!MC1.isEmpty() && !MC2.isEmpty()){
                    SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("mc1", MC1);
                    editor.putString("mc2", MC2);
                    editor.commit();
                    Intent pasarPantalla = new Intent(PersonalizadoActivity.this, EasyModeActivity.class);
                    startActivity(pasarPantalla);
                }else if (MC1.isEmpty()){
                    txtMC1.setError("No puede dejar este campo Vacio");
                    txtMC1.setFocusable(true);
                }else if (MC2.isEmpty()){
                    txtMC2.setError("No puede dejar este campo Vacio");
                    txtMC2.setFocusable(true);
                }
            }
        });
    }
}
