package com.umg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umg.connection.MariaDBConnection;

public class TestDao {

	 // Método para crear un nuevo estudiante

    public static boolean estudiante( String primernombre, String segundonombre, 
    		String primerapellido,String fecha_nacimiento) {

        Connection conn = MariaDBConnection.getConnection();

        if (conn != null) {

            try {

                String consulta = "INSERT INTO estudiantes (primernombre, segundonombre, primerapellido, fecha_nacimiento) VALUES (?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(consulta);


                statement.setString(1, primernombre);
                statement.setString(2, segundonombre);
                statement.setString(3, primerapellido );
                statement.setString(4, fecha_nacimiento );

                int filasInsertadas = statement.executeUpdate();
                
                System.out.println("Registro creado: " + filasInsertadas);

                statement.close();

                conn.close();

                return filasInsertadas > 0;

            } catch (SQLException e) {

                System.out.println("Error al crear cliente: " + e.getMessage());

                return false;

            }

        } else {

            System.out.println("No se pudo establecer la conexión.");

            return false;

        }
        
    }
   
}
