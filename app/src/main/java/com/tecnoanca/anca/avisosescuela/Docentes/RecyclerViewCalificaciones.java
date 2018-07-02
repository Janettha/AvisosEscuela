package com.tecnoanca.anca.avisosescuela.Docentes;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tecnoanca.anca.avisosescuela.Dao.Estudiantes;
import com.tecnoanca.anca.avisosescuela.Dto.Estudiante;
import com.tecnoanca.anca.avisosescuela.R;

public class RecyclerViewCalificaciones extends RecyclerView.ViewHolder {

    TextView numeroLista;
    TextView nombreCompleto;
    TextView calificacion;

    public RecyclerViewCalificaciones(View itemView, int viewType) {
        super(itemView);
        numeroLista = itemView.findViewById(R.id.numeroLista);
        nombreCompleto = itemView.findViewById(R.id.nombreCompleto);
        calificacion = itemView.findViewById(R.id.calificacion);
    }

    public void bind(Estudiante e) {
        Log.e("bindCalificaciones:",e.toString());
        numeroLista.setText(e.getNumeroLista());
        nombreCompleto.setText(e.getNombre()+" "+e.getApellidos());
        calificacion.setText(e.getCalificacion());
    }

}
