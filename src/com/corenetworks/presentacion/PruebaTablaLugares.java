package com.corenetworks.presentacion;

import com.corenetworks.modelo.Autobus;
import com.corenetworks.modelo.Lugar;
import com.corenetworks.persistencia.AccesoTablaLugares;

import java.sql.SQLException;
import java.util.Scanner;

public class PruebaTablaLugares {
    private static Scanner s1 = new Scanner(System.in);
    private static AccesoTablaLugares atl1 = new AccesoTablaLugares();
    private static char[] letraNif = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private static int numDni, idLugar;
    private static String dni = "", nombre;

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = s1.nextInt();
            switch(opcion){
                case 1 -> altaLugar();
                case 2 -> modificarLugares();
                case 3 -> consultarLugar();
                case 4 -> mostrarLugares();
                case 5 -> eliminarLugar();

            }
        }while (opcion>=1 && opcion<=10);
    }

    private static void modificarLugares() {
        System.out.println("Introduce el idLugar");
        idLugar = s1.nextInt();
        System.out.println("Introduce el nombre de la ciudad");
        nombre = s1.next();

        try {
            atl1.modificarLugares(new Lugar(idLugar,nombre));
            System.out.println("Lugar modificado");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void consultarLugar() {
        System.out.println("Introduce el idLugar");
        idLugar = s1.nextInt();
        try {
            System.out.println(atl1.consultaLugar(idLugar));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void mostrarLugares() {
        try {
            System.out.println(atl1.mostrarLugares());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void eliminarLugar() {
        mostrarLugares();
        System.out.println("Introduce el idLugar");
        idLugar = s1.nextInt();
        try {
            atl1.eliminarLugar(idLugar);
            System.out.println("Lugar eliminado");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void altaLugar() {
        System.out.println("Introduce el idLugar");
        idLugar = s1.nextInt();
        System.out.println("Introduce el nombre de la ciudad");
        nombre = s1.next();
        try {
            atl1.altaLugar(new Lugar(idLugar,nombre));
            System.out.println("Lugar creado");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void mostrarMenu() {
        System.out.println("--- Menu principal ---");
        System.out.println("1) Alta lugar\n2) Modificar lugar\n3) Consultar lugar\n4) Mostrar lugares\n5) Eliminar lugar");
        System.out.println("Escriba la opción -> ");
    }
}
