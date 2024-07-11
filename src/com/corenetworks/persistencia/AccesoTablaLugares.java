package com.corenetworks.persistencia;

import com.corenetworks.modelo.Lugar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesoTablaLugares extends Conexion{
    public int altaLugar(Lugar l) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                insert into lugares values (?,?);
                """;
        //2.Abrir conexion
        abrirConexion();
        //3.Obtener el statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //4.Asignar valor a los parametros del statement
        comando.setInt(1, l.getIdLugar());
        comando.setString(2, l.getNombre());
        //5.Ejecutar query
        resultado = comando.executeUpdate();
        //6.Devolver el resultado
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int eliminarLugar(int id) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                delete from lugares where id_lugar = ?;
                """;
        //2.Abrir conexion
        abrirConexion();
        //3.Obtener el statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //4.Asignar valor a los parametros del statement
        comando.setInt(1, id);
        //5.Ejecutar query
        resultado = comando.executeUpdate();
        //6.Devolver el resultado
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public List<Lugar> consultaLugar(int id) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Lugar> resultado = new ArrayList<>();
        String sql = "select * from lugares where id_lugar = ?";
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        comando.setInt(1, id);
        //4. Ejecutar la sentencia
        rejilla = comando.executeQuery();
        //5. Obtener el resultado
        while (rejilla.next()) {
            //En caso de que si traiga resultados
            resultado.add(new Lugar(rejilla.getInt(1),
                    rejilla.getString(2)));
        }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }

    public List<Lugar> mostrarLugares() throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Lugar> resultado = new ArrayList<>();
        String sql = "select * from lugares";
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
            resultado.add(new Lugar(rejilla.getInt(1),
                    rejilla.getString(2)));       }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int modificarLugares(Lugar l) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                update lugares
                set nombre = ?
                where id_lugar = ?
                """;
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        //Dar valor a los parámetros
        comando.setString(1, l.getNombre());
        comando.setInt(2, l.getIdLugar());

        resultado=comando.executeUpdate();

        //6. cerrar
        comando.close();
        cerrarConexion();
        return resultado;
    }
}
