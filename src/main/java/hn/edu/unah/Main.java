
package hn.edu.unah;

import hn.edu.unah.config.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String sql = "SELECT COUNT(*) FROM estudiantes";

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement ps =
                        conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("Conexion exitosa con MySQL");

            if (rs.next()) {
                System.out.println(
                        "Estudiantes registrados: "
                                + rs.getInt(1)
                );
            }

        } catch (SQLException | IllegalStateException e) {
            System.err.println(
                    "Error de conexion: " + e.getMessage()
            );
        }
    }
}
