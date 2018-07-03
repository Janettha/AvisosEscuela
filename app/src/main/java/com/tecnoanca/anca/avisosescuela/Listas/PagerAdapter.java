package com.tecnoanca.anca.avisosescuela.Listas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.tecnoanca.anca.avisosescuela.Dto.Estudiante;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numeroTabs;
    private Estudiante[] estudiantesTab1;
    private Estudiante[] estudiantesTab2;

    public PagerAdapter(FragmentManager fm, int numTabs, Estudiante[]e1, Estudiante[]e2){
        super(fm);
        numeroTabs = numTabs;
        Log.e("PA","lista1"+e1.length);
        Log.e("PA","lista2"+e2.length);
        estudiantesTab1 = e1;
        estudiantesTab2 = e2;
        Log.e("PA","lista1"+estudiantesTab1.length);
        Log.e("PA","lista2"+estudiantesTab2.length);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AsistenciasFragment tab1 = AsistenciasFragment.newInstance(estudiantesTab1, "Grupo1", "Materia1");
                Log.e("PA","lista1"+estudiantesTab1.length);
                return tab1;
            case 1:
                AsistenciasFragment tab2 = AsistenciasFragment.newInstance(estudiantesTab2, "Grupo2", "Materia2");
                Log.e("PA","lista2"+estudiantesTab2.length);
                return tab2;
            default:
                throw new RuntimeException("Posicion inválida del tab: " + position);
        }
    }

    @Override
    public int getCount() {
        return numeroTabs;
    }
}
