package com.corenetworks.modelo;

public class Lugar {
    private int idLugar;
    private String nombre;

    @Override
    public String toString() {
        return "Lugar{" +
                "idLugar=" + idLugar +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Lugar() {
    }

    public Lugar(int idLugar, String nombre) {
        this.idLugar = idLugar;
        this.nombre = nombre;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
