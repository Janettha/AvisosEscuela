package com.tecnoanca.anca.avisosescuela.Docentes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnoanca.anca.avisosescuela.Dao.Estudiantes;
import com.tecnoanca.anca.avisosescuela.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Estudiantes items;

    public RecyclerViewAdapter(Estudiantes estudiantes) {
        this.items = estudiantes;
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCalif = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alumno_calificaciones, parent, false);
        View viewAsist = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alumno_asistencia, parent, false);
        switch (viewType) {
            case 0:
                return new RecyclerViewCalificaciones(viewCalif, viewType);
            case 1:
                return new RecyclerViewAsistencias(viewAsist, viewType);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Estudiantes e = new Estudiantes();
        switch (holder.getItemViewType()) {
            case 0:
                RecyclerViewCalificaciones calificacionesVH = (RecyclerViewCalificaciones)holder;
                calificacionesVH.bind(e.getEstudiantes().get(position));
                break;

            case 2:
                RecyclerViewAsistencias asistenciasVH = (RecyclerViewAsistencias)holder;
                asistenciasVH.bind(e.getEstudiantes().get(position));
                break;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.getSize();
    }
}