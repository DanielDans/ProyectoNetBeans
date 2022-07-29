/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.*;

/**
 *
 * @author Casa
 */
public class ConsultaPreparada {

    public static void query() {
        String username = "postgres";
        String password = "dani0124+";
        String jdbcURL = "jdbc:postgresql://localhost:2048/mibasedatos";
        try {
            //Crear la conexion
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            System.out.println("Conectado");

            //Preparar consulta
            String consultaPreparada = "select au_id, city from authors where city = ?";
            PreparedStatement miConsulta = connection.prepareStatement(consultaPreparada);
            miConsulta.setString(1, "Salt Lake City");
            ResultSet tabla = miConsulta.executeQuery();
            while(tabla.next()){
                System.out.println( tabla.getString(1)+ " " + tabla.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar al servidor de PostgreSql");
        }

    }
}
