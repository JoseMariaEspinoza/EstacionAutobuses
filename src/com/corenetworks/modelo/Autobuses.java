package com.corenetworks.modelo;

public class Autobuses {
    private String matricula;
    private int aFabricacion;

    @Override
    public String toString() {
        return "Autobuses{" +
                "matricula='" + matricula + '\'' +
                ", aFabricacion=" + aFabricacion +
                '}';
    }

    public Autobuses() {
    }

    public Autobuses(String matricula, int aFabricacion) {
        this.matricula = matricula;
        this.aFabricacion = aFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getaFabricacion() {
        return aFabricacion;
    }

    public void setaFabricacion(int aFabricacion) {
        this.aFabricacion = aFabricacion;
    }
}
