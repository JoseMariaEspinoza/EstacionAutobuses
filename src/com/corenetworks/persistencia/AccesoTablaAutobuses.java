package com.corenetworks.persistencia;

import com.corenetworks.modelo.Autobuses;
import com.corenetworks.modelo.Visitas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesoTablaAutobuses extends Conexion {
    public int altaAutobus(Autobuses a) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                insert into autobuses values (?,?);
                """;
        //2.Abrir conexion
        abrirConexion();
        //3.Obtener el statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //4.Asignar valor a los parametros del statement
        comando.setString(1, a.getMatricula());
        comando.setInt(2, a.getaFabricacion());

        //5.Ejecutar query
        resultado = comando.executeUpdate();
        //6.Devolver el resultado
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int eliminarAutobus(String matricula) throws SQLException {
        //1.Declarar variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                delete from autobuses where matricula = ?;
                """;
        //2.Abrir conexion
        abrirConexion();
        //3.Obtener el statement de la conexion
        comando = miConexion.prepareStatement(sql);
        //4.Asignar valor a los parametros del statement
        comando.setString(1, matricula);
        //5.Ejecutar query
        resultado = comando.executeUpdate();
        //6.Devolver el resultado
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public List<Autobuses> consultaAutobus(String matricula) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Autobuses> resultado = new ArrayList<>();
        String sql = "select * from autobuses where matricula = ?";
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        comando.setString(1, matricula);
        //4. Ejecutar la sentencia
        rejilla = comando.executeQuery();
        //5. Obtener el resultado
        while (rejilla.next()) {
            //En caso de que si traiga resultados
            resultado.add(new Autobuses(rejilla.getString(1),
                    rejilla.getInt(2)));
        }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;
    }

    public List<Autobuses> mostrarAutobuses() throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        ResultSet rejilla;
        List<Autobuses> resultado = new ArrayList<>();
        String sql = "select * from autobuses";
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
            resultado.add(new Autobuses(rejilla.getString(1),
                    rejilla.getInt(2)));      }
        //6. cerrar
        rejilla.close();
        comando.close();
        cerrarConexion();
        return resultado;

    }

    public int modificarVisita(Autobuses a) throws SQLException {
        //0. Definición de variables
        PreparedStatement comando;
        int resultado;
        String sql = """
                update autobuses
                set a_fabricacion = ?
                where matricula = ?
                """;
        //1. Abrir la conexion
        abrirConexion();
        //2. Obtener el comando de la conexion
        comando = miConexion.prepareStatement(sql);
        //3. Asignar valor a los parámetros del comando
        //Dar valor a los parámetros
        comando.setInt(1, a.getaFabricacion());
        comando.setString(2,a.getMatricula());

        resultado = comando.executeUpdate();
        //6. cerrar
        comando.close();
        cerrarConexion();
        return resultado;
    }
}
