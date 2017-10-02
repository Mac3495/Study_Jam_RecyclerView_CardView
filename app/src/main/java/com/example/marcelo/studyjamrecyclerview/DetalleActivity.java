package com.example.marcelo.studyjamrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    ImageView imagenDetalle;
    TextView nombre, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setTitle("Descripción");

        imagenDetalle = (ImageView) findViewById(R.id.imagen_detalle);
        nombre = (TextView) findViewById(R.id.texto_detalle);
        descripcion = (TextView) findViewById(R.id.descripcion_detalle);

        Bundle bundle = getIntent().getExtras();
        Equipo equipo = (Equipo) bundle.getSerializable("equipo");

        imagenDetalle.setImageResource(equipo.getImagen());
        nombre.setText(equipo.getNombre());
        descripcion.setText(equipo.getDescripcion());

    }
}
