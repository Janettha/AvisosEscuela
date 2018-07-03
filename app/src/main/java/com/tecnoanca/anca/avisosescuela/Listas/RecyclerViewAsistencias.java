package com.tecnoanca.anca.avisosescuela.Listas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tecnoanca.anca.avisosescuela.Dto.Estudiante;
import com.tecnoanca.anca.avisosescuela.R;

public class RecyclerViewAsistencias extends RecyclerView.ViewHolder  {
    TextView numeroLista;
    TextView nombreCompleto;

    public RecyclerViewAsistencias(View itemView, int viewType) {
        super(itemView);
        numeroLista = itemView.findViewById(R.id.numeroLista);
        nombreCompleto = itemView.findViewById(R.id.nombreCompleto);
    }

    public void bind(Estudiante e) {
        numeroLista.setText(e.getNumeroLista());
        nombreCompleto.setText(e.getNombre()+" "+e.getApellidos());
    }
}
