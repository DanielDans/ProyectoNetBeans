
package Connection;

import java.sql.*;

/**
 *
 * @author Casa
 */
public class EjemploDeConeccionYConsulta {

    public static void ejemploDeConeccionYConsulta() {
        //Pasos para trabajar con una base de datos en postgresql
        //Paso 0- No es necesario pero minimiza condigo:
        /* Se guardan las variables nombre de usario, la cual por defecto es postgres, contraseña es la que yo definí 
 al inicio dani0124+ y por ultimo la url, esta se compone de:
 nombre_driver(jdbc):sistema_gestor(postresql)://seridor_local(localhost):puertoDefinidoAlInicio(2048)/nombrebaseDatos(mibasedatos)
         */
        String username = "postgres";
        String password = "dani0124+";
        String puerto ="2048";
        String nombreBD = "proyectoConduce";
        
        try {
            //Paso 1 Se establece la coneccion con la base de datos y se guarda en una variable de tipo Connection
            String jdbcURL = "jdbc:postgresql://localhost:"+puerto+"/"+nombreBD+"";
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Concetado al servidor PostreSql");
            
            //Paso 2 Crear un objeto de tipo Statement con el que se envía codigo sql a la base de datos
            Statement statement = connection.createStatement();
            
            //Paso 3 Ejecutar codigo SQL usando el objeto statement
            // el metodo executeQuery envia la consulta SQL y devuelve una tabla que es un objeto de tipo ResultSet
            ResultSet resulset = statement.executeQuery("select * from municipio");
            
            //Paso 4 Recorrer y leer el resultset, para ello usamos el metodo next()que devuelve falso cuando termina la
            //tabla y l metodo getString al cual se le pasa el titulo de la columna que se desea obtener
            
            while(resulset.next()){
                System.out.println(resulset.getString(1));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al conectar al servidor to PostgreSql");
                
        }
    }
}
