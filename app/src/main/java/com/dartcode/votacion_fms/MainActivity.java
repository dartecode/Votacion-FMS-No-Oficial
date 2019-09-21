package com.dartcode.votacion_fms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PaisesFMS> listaPaises;
    RecyclerView recyclerFMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPaises = new ArrayList<>();
        recyclerFMS= (RecyclerView) findViewById(R.id.recyclerFMS);
        recyclerFMS.setLayoutManager(new LinearLayoutManager(this));
        llenarRecycler();
        AdaptadorFMS adapter = new AdaptadorFMS(listaPaises);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaPaises.get(recyclerFMS.getChildAdapterPosition(view)).getPais().equals("PERSONALIZADA")){
                    Intent intent = new Intent(MainActivity.this, PersonalizadoActivity.class);
                    String pais = listaPaises.get(recyclerFMS.getChildAdapterPosition(view)).getPais();
                    intent.putExtra("PAIS", pais);
                    startActivity(intent);
                }else {
                    String pais = listaPaises.get(recyclerFMS.getChildAdapterPosition(view)).getPais();
                    Intent intent = new Intent(MainActivity.this, CompetidoresActivity.class);
                    intent.putExtra("PAIS", pais);
                    startActivity(intent);
                }
            }
        });
        recyclerFMS.setAdapter(adapter);
    }

    private void llenarRecycler() {
        listaPaises.add(new PaisesFMS("ESPAÑA","Competidores de FMS España", R.drawable.espana));
        listaPaises.add(new PaisesFMS("ARGENTINA","Competidores de FMS Argentina", R.drawable.argentina));
        listaPaises.add(new PaisesFMS("CHILE","Competidores de FMS Chile", R.drawable.chile));
        listaPaises.add(new PaisesFMS("MEXICO","Competidores de FMS México", R.drawable.mexico));
        listaPaises.add(new PaisesFMS("PERSONALIZADA","Batalla con formato fms", R.drawable.fms));
    }

}
