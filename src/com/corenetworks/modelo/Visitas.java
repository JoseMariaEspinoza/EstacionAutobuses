package com.corenetworks.modelo;

import java.time.LocalDate;

public class Visitas {
    private int idVista;
    private LocalDate fVisita;
    private String dni;
    private String matricula;
    private int idLugar;

    @Override
    public String toString() {
        return "Visitas{" +
                "idVista=" + idVista +
                ", fVisita=" + fVisita +
                ", dni='" + dni + '\'' +
                ", matricula='" + matricula + '\'' +
                ", idLugar=" + idLugar +
                '}';
    }

    public Visitas() {
    }

    public Visitas(int idVista, LocalDate fVisita, String dni, String matricula, int idLugar) {
        this.idVista = idVista;
        this.fVisita = fVisita;
        this.dni = dni;
        this.matricula = matricula;
        this.idLugar = idLugar;
    }

    public int getIdVista() {
        return idVista;
    }

    public void setIdVista(int idVista) {
        this.idVista = idVista;
    }

    public LocalDate getfVisita() {
        return fVisita;
    }

    public void setfVisita(LocalDate fVisita) {
        this.fVisita = fVisita;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }
}
