package com.corenetworks.presentacion;

import com.corenetworks.modelo.Autobus;
import com.corenetworks.persistencia.AccesoTablaAutobuses;

import java.sql.SQLException;
import java.util.Scanner;

public class PruebaTablaAutobuses {
    private static Scanner s1 = new Scanner(System.in);
    private static AccesoTablaAutobuses ata1 = new AccesoTablaAutobuses();
    private static char[] letraNif = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private static int numDni, aFabricacion;
    private static String dni = "", matricula;

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = s1.nextInt();
            switch(opcion){
                case 1 -> altaAutobus();
                case 2 -> modificarAutobus();
                case 3 -> consultarAutobus();
                case 4 -> mostrarAutobuses();
                case 5 -> eliminarAutobus();

            }
        }while (opcion>=1 && opcion<=10);
    }

    private static void modificarAutobus() {
        System.out.println("Introduce la matricula");
        matricula = s1.next().toUpperCase();
        System.out.println("Introduce el año de fabricacion");
        aFabricacion = s1.nextInt();

        try {
            ata1.modificarVisita(new Autobus(matricula,aFabricacion));
            System.out.println("Autobus modificado");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void consultarAutobus() {
        System.out.println("Introduce la matricula");
        matricula = s1.next().toUpperCase();        try {
            System.out.println(ata1.consultaAutobus(matricula));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void mostrarAutobuses() {
        try {
            System.out.println(ata1.mostrarAutobuses());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void eliminarAutobus() {
        mostrarAutobuses();
        System.out.println("Introduce la matricula");
        matricula = s1.next().toUpperCase();
        try {
            ata1.eliminarAutobus(matricula);
            System.out.println("Autobus eliminado");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void altaAutobus() {
        System.out.println("Introduce la matricula");
        matricula = s1.next().toUpperCase();
        System.out.println("Introduce el año de fabricacion");
        aFabricacion = s1.nextInt();
        try {
            ata1.altaAutobus(new Autobus(matricula,aFabricacion));
            System.out.println("Autobus creado");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void mostrarMenu() {
        System.out.println("--- Menu principal ---");
        System.out.println("1) Alta autobus\n2) Modificar autobus\n3) Consultar autobus\n4) Mostrar autobuses\n5) Eliminar autobus");
        System.out.println("Escriba la opción -> ");
    }
}
