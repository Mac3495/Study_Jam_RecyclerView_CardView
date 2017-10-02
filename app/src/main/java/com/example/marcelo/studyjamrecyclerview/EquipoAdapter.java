package com.example.marcelo.studyjamrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo on 01/10/2017.
 */

public class EquipoAdapter extends RecyclerView.Adapter<EquipoAdapter.EquipoViewHolder> {

    Context context;
    List<Equipo> dataset;
    OnEquipoSlectedListener onEquipoSlectedListener;

    public interface OnEquipoSlectedListener{
        void onEquipoSelected(Equipo equipo);
    }

    public EquipoAdapter(Context context, OnEquipoSlectedListener onEquipoSlectedListener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onEquipoSlectedListener = onEquipoSlectedListener;
    }

    @Override
    public EquipoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipo, parent, false);
        return new EquipoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EquipoViewHolder holder, int position) {
        Equipo equipo = dataset.get(position);
        holder.imagen.setImageResource(equipo.getImagen());
        holder.nombre.setText(equipo.getNombre());

        holder.setEquipoSelecetedListener(equipo, onEquipoSlectedListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class EquipoViewHolder extends RecyclerView.ViewHolder{

        View cardView;

        ImageView imagen;
        TextView nombre;

        public EquipoViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_item);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.nombre_item);
        }


        public void setEquipoSelecetedListener(final Equipo equipo, final OnEquipoSlectedListener onEquipoSlectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onEquipoSlectedListener.onEquipoSelected(equipo);
                }
            });
        }
    }

    public void setDataset(List<Equipo> equipos) {
        if(equipos == null){
            dataset = new ArrayList<>();
        }
        else {
            dataset = equipos;
        }
        notifyDataSetChanged();
    }
}
