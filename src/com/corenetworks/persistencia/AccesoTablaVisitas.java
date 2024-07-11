package com.corenetworks.persistencia;

import com.corenetworks.modelo.Visitas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesoTablaVisitas extends Conexion{
    public int altaVisita(Visitas v) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                insert into visitas values (?,?,?,?,?);
                """;
        //2.Abrir conexion
        abrirConexion();
        //3.Obtener el statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //4.Asignar valor a los parametros del statement
        comando.setInt(1, v.getIdVista());
        comando.setDate(2, Date.valueOf(v.getfVisita()));
        comando.setString(3, v.getDni());
        comando.setString(4, v.getMatricula());
        comando.setInt(5, v.getIdLugar());

        //5.Ejecutar query
        resultado = comando.executeUpdate();
        //6.Devolver el resultado
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int eliminarVisita(int id) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                delete from visitas where id_visita = ?;
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

    public List<Visitas> consultaVisita(int id) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Visitas> resultado = new ArrayList<>();
        String sql = "select * from visitas where id_visita = ?";
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
            resultado.add(new Visitas(rejilla.getInt(1),
                    rejilla.getDate(2).toLocalDate(),
                    rejilla.getString(3), rejilla.getString(4),
                    rejilla.getInt(5)));
        }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }

    public List<Visitas> mostrarVisitas() throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Visitas> resultado = new ArrayList<>();
        String sql = "select * from visitas";
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
            resultado.add(new Visitas(rejilla.getInt(1),
                    rejilla.getDate(2).toLocalDate(),
                    rejilla.getString(3),rejilla.getString(4),
                    rejilla.getInt(5)));        }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int modificarVisita(Visitas v) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                update visitas
                set f_visita = ?, dni_conductor = ?, matricula = ?, id_lugar = ?
                where id_visita = ?
                """;
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        //Dar valor a los parámetros
        comando.setDate(1, Date.valueOf(v.getfVisita()));
        comando.setString(2, v.getDni());
        comando.setString(3, v.getMatricula());
        comando.setInt(4, v.getIdLugar());
        comando.setInt(5, v.getIdVista());
        resultado = comando.executeUpdate();
        //6. cerrar
        comando.close();
        cerrarConexion();
        return resultado;
    }
}
