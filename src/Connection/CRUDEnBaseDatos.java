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
public class CRUDEnBaseDatos {

    public static void crud() {

        String username = "postgres";
        String password = "dani0124+";
        String jdbcURL = "jdbc:postgresql://localhost:2048/mibasedatos";
        try {
            //Crear la conexion
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            
            System.out.println("Conectado");
            
            //Generar objeto statement el cual se usa para operar la base de datos
            Statement statement = connection.createStatement();

            //Realizar operacion de Insertar, Actualizar o Eliminar
            //Insertar
            String instruccionSql = "insert into authors(au_id,au_lname,au_fname,city,contract) values('800-00-0000','Perez','Pedro','Santa Clara','true')";
            String instruccionSql2 = "insert into authors(au_id,au_lname,au_fname,city,contract) values('800-00-0001','Alonso','Juan','Cienfuegos','true')";
            statement.executeUpdate(instruccionSql);
            statement.executeUpdate(instruccionSql2);
            //Actualizar
            String instruccionSql3 = "update authors set city='Santiago' where au_id='800-00-0000'";
            statement.executeUpdate(instruccionSql3);
            //Eliminar
            String instruccionSql4 = "delete from authors where au_id='800-00-0001'";
            statement.execute(instruccionSql4);
            
        } catch (SQLException ex) {
            System.out.println("Error al conectar al servidor de PostgreSql");

        }
    }
}
