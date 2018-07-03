package com.tecnoanca.anca.avisosescuela.Listas;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tecnoanca.anca.avisosescuela.Dto.Estudiante;
import com.tecnoanca.anca.avisosescuela.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActDocentes extends AppCompatActivity implements AsistenciasFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_act_docentes);

        // define TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_2));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // define ViewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        // fake list model... for test
        Estudiante[] listaEstudiante1 = creaListaEstudiante("1", 20);
        Estudiante[] listaEstudiante2 = creaListaEstudiante("2", 40);

        Log.e("Tab1","Lista 1:"+listaEstudiante1.length);
        Log.e("Tab2","Lista 2:"+listaEstudiante2.length);

        //  ViewPager need a PagerAdapter
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(), listaEstudiante1, listaEstudiante2);
        viewPager.setAdapter(adapter);

        // Listeners
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(getOnTabSelectedListener(viewPager));
    }

    @NonNull
    private TabLayout.OnTabSelectedListener getOnTabSelectedListener(final ViewPager viewPager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Toast.makeText(MainActDocentes.this, "Tab Seleccionado"
                        +  tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // nothing now
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // nothing now
            }
        };
    }

    @Override
    public void onFragmentInteraction(Estudiante estudiante) {
        // the user clicked on this item over the list
        Toast.makeText(MainActDocentes.this, Estudiante.class.getSimpleName()
                + ":" + estudiante.getNombre() +" "+estudiante.getApellidos(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private Estudiante[] creaListaEstudiante(String tab, int tam) {
        List<Estudiante> lista = new ArrayList<>();
        for(int i = 0; i < tam; i++ ) {
            Estudiante e = new Estudiante();
            e.setNombre(String.valueOf(i)+"_nombre:"+tab);
            e.setApellidos(String.valueOf(i)+"_apellidos:"+tab);
            e.setCalificacion(i+ (int) (Math.random() * 10));
            e.setAsistencia(getAsistencia());
            lista.add(e);
        }
        return lista.toArray(new Estudiante[lista.size()]);
    }

    public boolean getAsistencia(){
        Calendar day = Calendar.getInstance();
        long d;
        d = day.getTimeInMillis() + (int)Math.random() *3;

        if(d % 2 == 0) { return true;
        }else{ return false; }
    }

}
