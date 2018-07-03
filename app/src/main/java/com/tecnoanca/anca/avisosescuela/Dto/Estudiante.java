package com.tecnoanca.anca.avisosescuela.Dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Estudiante implements Parcelable {

    private String nombre;
    private String apellidos;
    private String numeroLista;
    private boolean asistencia;
    private int calificacion;

    public Estudiante() {
        nombre = "";
        apellidos = "";
        numeroLista = "";
        asistencia = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroLista() {
        return numeroLista;
    }

    public void setNumeroLista(String numeroLista) {
        this.numeroLista = numeroLista;
    }

    public boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    protected Estudiante(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        numeroLista = in.readString();
        asistencia = in.readInt()==1;
        calificacion = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeString(numeroLista);
        dest.writeInt(isAsistencia() ? 1 : 0);
        dest.writeInt(calificacion);
    }

    public static final Creator<Estudiante> CREATOR = new Creator<Estudiante>() {
        @Override
        public Estudiante createFromParcel(Parcel in) {
            return new Estudiante(in);
        }

        @Override
        public Estudiante[] newArray(int size) {
            return new Estudiante[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
