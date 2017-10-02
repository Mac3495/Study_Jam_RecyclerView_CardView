package com.example.marcelo.studyjamrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EquipoAdapter.OnEquipoSlectedListener{

    RecyclerView recyclerView;
    EquipoAdapter equipoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        equipoAdapter = new EquipoAdapter(this, this);

        llenarDatos();

        recyclerView.setAdapter(equipoAdapter);
    }

    private void llenarDatos() {
        List<Equipo> lista = new ArrayList<>();
        
        lista.add(new Equipo(R.drawable.bolivar, "Boliviar", getString(R.string.Descripcion_Bolivar)));
        lista.add(new Equipo(R.drawable.tigre,"Tigre", getString(R.string.Descripcion_Tigre)));
        lista.add(new Equipo(R.drawable.wilster, "Wilster", getString(R.string.Descripcion_Wilster)));
        lista.add(new Equipo(R.drawable.oriente, "Oriente", getString(R.string.Descripcion_Oriente)));
        lista.add(new Equipo(R.drawable.sanjose, "San Jose", getString(R.string.Descripcion_SanJose)));
        lista.add(new Equipo(R.drawable.blooming, "Blooming", getString(R.string.Descripcion_Blooming)));
        lista.add(new Equipo(R.drawable.realpotosi, "Real Potosi", getString(R.string.Descripcion_RealPotosi)));
        lista.add(new Equipo(R.drawable.nacionalpotosi, "Nacional Potosi", getString(R.string.Descripcion_NacionalPotosi)));

        equipoAdapter.setDataset(lista);
    }

    @Override
    public void onEquipoSelected(Equipo equipo) {
        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("equipo", equipo);
        startActivity(intent);
    }
}
