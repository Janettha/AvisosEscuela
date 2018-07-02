package com.tecnoanca.anca.avisosescuela.Dto;

public class Docente {
    String nombre;
    String apellidos;
    String user;
    String password;

    public Docente() {
        nombre = "";
        apellidos = "";
        user = "";
        password = "";
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
