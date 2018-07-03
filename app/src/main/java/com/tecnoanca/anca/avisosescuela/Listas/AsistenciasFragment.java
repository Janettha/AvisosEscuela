package com.tecnoanca.anca.avisosescuela.Listas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnoanca.anca.avisosescuela.Dto.Estudiante;
import com.tecnoanca.anca.avisosescuela.R;

public class AsistenciasFragment extends Fragment {
    private static final String ARG_GRUPO = "param1";
    private static final String ARG_MATERIA = "param2";
    private static final String KEY_MODEL = "KEY_MODEL";

    private String idGrupo;
    private String idMateria;

    private Estudiante[] estudiantes;
    private OnFragmentInteractionListener mListener;

    public AsistenciasFragment() {    }

    public static AsistenciasFragment newInstance(Estudiante[] e, String idGrupo, String idMateria) {
        AsistenciasFragment fragment = new AsistenciasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_GRUPO, idGrupo);
        args.putString(ARG_MATERIA, idMateria);
        args.putParcelableArray(KEY_MODEL, e);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idGrupo = getArguments().getString(ARG_GRUPO);
            idMateria = getArguments().getString(ARG_MATERIA);
        }else{
            throw new RuntimeException("Se debe mandar un modelo de Estudiante");
        }
        estudiantes = (Estudiante[]) getArguments().getParcelableArray(KEY_MODEL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_docentes, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new ItemRecyclerViewAdapter(estudiantes, mListener));
        return view;
    }

    public void onButtonPressed(Estudiante estudiante) {
        if (mListener != null) {
            mListener.onFragmentInteraction(estudiante);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Estudiante estudiante);
    }
}
