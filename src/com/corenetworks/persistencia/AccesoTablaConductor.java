package com.corenetworks.persistencia;

import com.corenetworks.modelo.Conductor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesoTablaConductor extends Conexion {
    public int altaConductor(Conductor c) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                insert into conductores values (?,?);
                """;
        //2.Abrir conexion
        abrirConexion();
        //3.Obtener el statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //4.Asignar valor a los parametros del statement
        comando.setString(1, c.getDni());
        comando.setString(2, c.getNombre());
        //5.Ejecutar query
        resultado = comando.executeUpdate();
        //6.Devolver el resultado
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int eliminarConductor(String dni) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                delete from conductores where dni_conductor = ?;
                """;
        //2.Abrir conexion
        abrirConexion();
        //3.Obtener el statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //4.Asignar valor a los parametros del statement
        comando.setString(1, dni);
        //5.Ejecutar query
        resultado = comando.executeUpdate();
        //6.Devolver el resultado
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public List<Conductor> consultaConductor(String dni) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Conductor> resultado = new ArrayList<>();
        String sql = "select * from conductores where dni_conductor = ?";
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        comando.setString(1, dni);
        //4. Ejecutar la sentencia
        rejilla = comando.executeQuery();
        //5. Obtener el resultado
        while (rejilla.next()) {
            //En caso de que si traiga resultados
            resultado.add(new Conductor(rejilla.getString("dni_conductor"), rejilla.getString("nombre")));
        }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }

    public List<Conductor> mostrarConductores() throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Conductor> resultado = new ArrayList<>();
        String sql = "select * from conductores";
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        //4. Ejecutar la sentencia
        rejilla = comando.executeQuery();
        //5. Obtener el resultado
        while (rejilla.next()) {
            //En caso de que si traiga resultados
            resultado.add(new Conductor(rejilla.getString("dni_conductor"), rejilla.getString("nombre")));
        }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int modificarConductor(Conductor c) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                update conductores
                set nombre = ?
                where dni_conductor = ?
                """;
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        //Dar valor a los parámetros

        comando.setString(1, c.getNombre());
        comando.setString(2, c.getDni());


        resultado = comando.executeUpdate();
        //6. cerrar
        comando.close();
        cerrarConexion();
        return resultado;
    }
}
