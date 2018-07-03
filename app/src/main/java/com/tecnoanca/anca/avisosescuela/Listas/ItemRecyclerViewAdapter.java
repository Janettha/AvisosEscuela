package com.tecnoanca.anca.avisosescuela.Listas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecnoanca.anca.avisosescuela.Dto.Estudiante;
import com.tecnoanca.anca.avisosescuela.R;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    private final Estudiante[] estudiantes;
    private final AsistenciasFragment.OnFragmentInteractionListener interactionListener;

    public ItemRecyclerViewAdapter(Estudiante[] estudiantes, AsistenciasFragment.OnFragmentInteractionListener listener) {
        this.estudiantes = estudiantes;
        interactionListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alumno_asistencia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Estudiante e = estudiantes[position];

    }

    @Override
    public int getItemCount() {
        return estudiantes.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView numeroLista;
        public final TextView nombreCompleto;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            numeroLista = (TextView) view.findViewById(R.id.numeroLista);
            nombreCompleto = (TextView) view.findViewById(R.id.nombreCompleto);
        }
    }
}
