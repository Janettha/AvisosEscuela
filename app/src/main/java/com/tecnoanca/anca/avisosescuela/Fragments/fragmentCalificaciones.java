package com.tecnoanca.anca.avisosescuela.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnoanca.anca.avisosescuela.Dao.Estudiantes;
import com.tecnoanca.anca.avisosescuela.Docentes.RecyclerViewAdapter;
import com.tecnoanca.anca.avisosescuela.R;


public class fragmentCalificaciones extends Fragment {

    RecyclerView recyclerView;

    public fragmentCalificaciones() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_list_docentes, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //String[] items = getResources().getStringArray(R.array.tab_B);
        Estudiantes e = new Estudiantes();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(e);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public String toString() {
        return "Calificaciones";
    }
}
