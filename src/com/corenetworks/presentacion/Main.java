package com.corenetworks.presentacion;

import com.corenetworks.modelo.Conductor;
import com.corenetworks.persistencia.AccesoTablaConductor;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner s1 = new Scanner(System.in);
    private static AccesoTablaConductor atc1 = new AccesoTablaConductor();
    private static char[] letraNif = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private static int numDni;
    private static String nombre,dni = "";

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = s1.nextInt();
            switch(opcion){
                case 1 -> altaConductor();
                case 2 -> modificarConductor();
                case 3 -> consultarConductor();
                case 4 -> mostrarConductores();
                case 5 -> eliminarConductor();

            }
        }while (opcion>=1 && opcion<=10);
    }

    private static void modificarConductor() {
        System.out.println("Introduzca el Dni sin la letra");
        numDni = s1.nextInt();
        dni = String.valueOf(numDni) + letraNif[numDni%23];
        System.out.println("Introduzca el nombre");
        nombre = s1.next();
        try {
            atc1.modificarConductor(new Conductor(dni,nombre));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        System.out.println("Conductor modificado correctamente");
    }

    private static void consultarConductor() {
        System.out.println("Introduzca el Dni sin la letra");
        numDni = s1.nextInt();
        dni = String.valueOf(numDni) + letraNif[numDni%23];
        try {
            System.out.println(atc1.consultaConductor(dni));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void mostrarConductores() {
        try {
            System.out.println(atc1.mostrarConductores());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void eliminarConductor() {
        mostrarConductores();
        System.out.println("Introduzca el Dni sin la letra");
        numDni = s1.nextInt();
        dni = String.valueOf(numDni) + letraNif[numDni%23];
        try {
            atc1.eliminarConductor(dni);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        System.out.println("Conductor eliminado");
    }

    private static void altaConductor() {
        System.out.println("Introduzca el Dni sin la letra");
        numDni = s1.nextInt();
        dni = String.valueOf(numDni) + letraNif[numDni%23];
        System.out.println("Introduzca el nombre");
        nombre = s1.next();
        try {
            atc1.altaConductor(new Conductor(dni,nombre));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        System.out.println("Conductor creado");
    }

    private static void mostrarMenu() {
        System.out.println("--- Menu principal ---");
        System.out.println("1) Alta conductor\n2) Modificar conductor\n3) Consultar conductores\n4) Mostrar conductores\n5) Eliminar conductor");
        System.out.println("Escriba la opción -> ");
    }
}