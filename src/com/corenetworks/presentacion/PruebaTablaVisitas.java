package com.corenetworks.presentacion;

import com.corenetworks.modelo.Conductor;
import com.corenetworks.modelo.Visitas;
import com.corenetworks.persistencia.AccesoTablaVisitas;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class PruebaTablaVisitas {
    private static Scanner s1 = new Scanner(System.in);
    private static AccesoTablaVisitas atv1 = new AccesoTablaVisitas();
    private static char[] letraNif = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private static int numDni, idVisita, idLugar, ano, mes, dia;
    private static String dni = "", matricula;
    private static LocalDate fVisita;

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = s1.nextInt();
            switch(opcion){
                case 1 -> altaVisita();
                case 2 -> modificarVisita();
                case 3 -> consultarVisita();
                case 4 -> mostrarVisitas();
                case 5 -> eliminarVisita();

            }
        }while (opcion>=1 && opcion<=10);
    }

    private static void modificarVisita() {
        System.out.println("Introduce el IdVisita");
        idVisita = s1.nextInt();
        System.out.println("Introduce el año de la visita");
        ano = s1.nextInt();
        System.out.println("Introduce el mes de la visita");
        mes = s1.nextInt();
        System.out.println("Introduce el dia de la visita");
        dia = s1.nextInt();
        fVisita = LocalDate.of(ano,mes,dia);
        System.out.println("Introduzca el Dni sin la letra");
        numDni = s1.nextInt();
        dni = String.valueOf(numDni) + letraNif[numDni%23];
        System.out.println("Introduzca la matricula");
        matricula = s1.next();
        System.out.println("Introduce el idLugar");
        idLugar = s1.nextInt();

        try {
            atv1.modificarVisita(new Visitas(idVisita,fVisita,dni,matricula,idLugar));
            System.out.println("Visita modificada");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void consultarVisita() {
        System.out.println("Introduce el IdVisita");
        idVisita = s1.nextInt();
        try {
            System.out.println(atv1.consultaVisita(idVisita));
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void mostrarVisitas() {
        try {
            System.out.println(atv1.mostrarVisitas());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void eliminarVisita() {
        System.out.println("Introduce el IdVisita");
        idVisita = s1.nextInt();
        try {
            atv1.eliminarVisita(idVisita);
            System.out.println("Visita eliminada");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void altaVisita() {
        System.out.println("Introduce el IdVisita");
        idVisita = s1.nextInt();
        System.out.println("Introduce el año de la visita");
        ano = s1.nextInt();
        System.out.println("Introduce el mes de la visita");
        mes = s1.nextInt();
        System.out.println("Introduce el dia de la visita");
        dia = s1.nextInt();
        fVisita = LocalDate.of(ano,mes,dia);
        System.out.println("Introduzca el Dni sin la letra");
        numDni = s1.nextInt();
        dni = String.valueOf(numDni) + letraNif[numDni%23];
        System.out.println("Introduzca la matricula");
        matricula = s1.next();
        System.out.println("Introduce el idLugar");
        idLugar = s1.nextInt();
        try {
            atv1.altaVisita(new Visitas(idVisita,fVisita,dni,matricula,idLugar));
            System.out.println("Visita creada");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private static void mostrarMenu() {
        System.out.println("--- Menu principal ---");
        System.out.println("1) Alta visita\n2) Modificar visita\n3) Consultar visita\n4) Mostrar visitas\n5) Eliminar visitas");
        System.out.println("Escriba la opción -> ");
    }
}
