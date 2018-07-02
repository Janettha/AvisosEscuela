package com.tecnoanca.anca.avisosescuela.Docentes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tecnoanca.anca.avisosescuela.Dao.Estudiantes;
import com.tecnoanca.anca.avisosescuela.Fragments.fragmentAsistencias;
import com.tecnoanca.anca.avisosescuela.Fragments.fragmentCalificaciones;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm, Estudiantes e1, Estudiantes e2) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0){
            fragment = new fragmentAsistencias();
        }
        else if (position == 1){
            fragment = new fragmentCalificaciones();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).toString();
        return title;
    }
}
