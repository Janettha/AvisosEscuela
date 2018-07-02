package com.tecnoanca.anca.avisosescuela.Dao;

import com.tecnoanca.anca.avisosescuela.Dto.Estudiante;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class Estudiantes {
    List<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Estudiantes(){
        fill();
    }

    public List<Estudiante> getEstudiantes(){
        return estudiantes;
    }

    private void fill(){
        Estudiante e = new Estudiante();
        for(int i = 0; i<10; i++) {
            e.setNombre(i + " Nombre");
            e.setApellidos(i + " Apellidos");
            e.setCalificacion(i+ (int) (Math.random() * 10));
            e.setAsistencia(getAsistencia());
        }
    }

    public boolean getAsistencia(){
        Calendar day = Calendar.getInstance();
        long d;
        d = day.getTimeInMillis() + (int)Math.random() *3;

        if(d % 2 == 0) { return true;
        }else{ return false; }
    }

    public int getSize(){
        return estudiantes.size();
    }
}
