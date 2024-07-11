package com.corenetworks.modelo;

public class Conductor {
    private String dni;
    private String nombre;

    @Override
    public String toString() {
        return "Conductor{" +
                "dni='" + dni + '\'' +
                ", Nombre='" + nombre + '\'' +
                '}';
    }

    public Conductor() {
    }

    public Conductor(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
