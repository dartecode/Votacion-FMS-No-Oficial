package com.dartcode.votacion_fms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView lblMC1, lblMC2, lblResultado, lblEasyModeMC1, lblEasyModeMC2, lblHardModeMC1, lblHardModeMC2,
                lblTematicasMC1, lblTematicasMC2, lblPersonajesMC1, lblPersonajesMC2, lblMinutosMC1, lblMinutosMC2,
                lblDeluxeMC1, lblDeluxeMC2, lblTotalMC1, lblTotalMC2;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        lblMC1 = findViewById(R.id.lblMC1);
        lblMC2 = findViewById(R.id.lblMC2);
        lblResultado = findViewById(R.id.lblResultado);
        lblEasyModeMC1 = findViewById(R.id.lblEasyModeMC1);
        lblEasyModeMC2 = findViewById(R.id.lblEasyModeMC2);
        lblHardModeMC1 = findViewById(R.id.lblHardModeMC1);
        lblHardModeMC2 = findViewById(R.id.lblHardModeMC2);
        lblTematicasMC1 = findViewById(R.id.lblTematicasMC1);
        lblTematicasMC2 = findViewById(R.id.lblTematicasMC2);
        lblPersonajesMC1 = findViewById(R.id.lblPersonajesMC1);
        lblPersonajesMC2 = findViewById(R.id.lblPersonajesMC2);
        lblMinutosMC1 = findViewById(R.id.lblMinutosMC1);
        lblMinutosMC2 = findViewById(R.id.lblMinutosMC2);
        lblDeluxeMC1 = findViewById(R.id.lblDeluxeMC1);
        lblDeluxeMC2 = findViewById(R.id.lblDeluxeMC2);
        lblTotalMC1 = findViewById(R.id.lblTotalMC1);
        lblTotalMC2 = findViewById(R.id.lblTotalMC2);
        btnSalir = findViewById(R.id.btnSalir);

        resultado();

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultadoActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    private void resultado() {
        SharedPreferences preferences = getSharedPreferences("VOTACION_FMS", Context.MODE_PRIVATE);
        String MC1 = preferences.getString("mc1","");
        String MC2 = preferences.getString("mc2","");
        lblMC1.setText(MC1);
        lblMC2.setText(MC2);

        int easyModeMC1 = preferences.getInt("easymodeMC1", 0);
        int easyModeMC2 = preferences.getInt("easymodeMC2", 0);

        int hardModeMC1 = preferences.getInt("hardmodeMC1",0);
        int hardModeMC2 = preferences.getInt("hardmodeMC2", 0);

        int tematica1MC1 = preferences.getInt("tematica1MC1",0);
        int tematica2MC1 = preferences.getInt("tematica2MC1",0);
        int tematicasMC1 = tematica1MC1 + tematica2MC1;

        int tematica1MC2 = preferences.getInt("tematica1MC2",0);
        int tematica2MC2 = preferences.getInt("tematica2MC2",0);
        int tematicasMC2 = tematica1MC2 + tematica2MC2;

        int personajesMC1 = preferences.getInt("personajesMC1",0);
        int personajesMC2 = preferences.getInt("personajesMC2",0);

        int minuto1MC1 = preferences.getInt("sangre1MC1",0);
        int minuto2MC1 = preferences.getInt("sangre2MC1",0);
        int minutosMC1 = minuto1MC1 + minuto2MC1;

        int minuto1MC2 = preferences.getInt("sangre1MC2",0);
        int minuto2MC2 = preferences.getInt("sangre2MC2",0);
        int minutosMC2 = minuto1MC2 + minuto2MC2;

        int deluxeMC1 = preferences.getInt("deluxeMC1",0);
        int deluxeMC2 = preferences.getInt("deluxeMC2",0);

        int totalMC1 = easyModeMC1 + hardModeMC1 + tematicasMC1 + personajesMC1 + minutosMC1 + deluxeMC1;
        int totalMC2 = easyModeMC2 + hardModeMC2 + tematicasMC2 + personajesMC2 + minutosMC2 + deluxeMC2;

        lblEasyModeMC1.setText(String.valueOf(easyModeMC1));
        lblEasyModeMC2.setText(String.valueOf(easyModeMC2));
        lblHardModeMC1.setText(String.valueOf(hardModeMC1));
        lblHardModeMC2.setText(String.valueOf(hardModeMC2));
        lblTematicasMC1.setText(String.valueOf(tematicasMC1));
        lblTematicasMC2.setText(String.valueOf(tematicasMC2));
        lblPersonajesMC1.setText(String.valueOf(personajesMC1));
        lblPersonajesMC2.setText(String.valueOf(personajesMC2));
        lblMinutosMC1.setText(String.valueOf(minutosMC1));
        lblMinutosMC2.setText(String.valueOf(minutosMC2));
        lblDeluxeMC1.setText(String.valueOf(deluxeMC1));
        lblDeluxeMC2.setText(String.valueOf(deluxeMC2));
        lblTotalMC1.setText(String.valueOf(totalMC1));
        lblTotalMC2.setText(String.valueOf(totalMC2));

        int diferencia = totalMC1 - totalMC2;

        if (diferencia >= -5 && diferencia <= 5){
            lblResultado.setText("RÉPLICA");
        }else if (diferencia > 5){
            lblResultado.setText("EL GANADOR ES: " + MC1);
        }else {
            lblResultado.setText("EL GANADOR ES: " + MC2);
        }

    }
}
