package com.tecnoanca.anca.avisosescuela.Dto;

public class Estudiante {

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
}
