
package hn.edu.unah.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL =
            "jdbc:mysql://localhost:3306/tutorgest_db";

    private ConexionDB() {
        // Evita instanciar esta clase.
    }

    public static Connection getConnection()
            throws SQLException {

        String usuario =
                System.getenv("TUTORGEST_DB_USER");

        String contrasena =
                System.getenv("TUTORGEST_DB_PASSWORD");

        if (usuario == null || usuario.isBlank()
                || contrasena == null) {
            throw new IllegalStateException(
                    "Configura las credenciales de MySQL."
            );
        }

        return DriverManager.getConnection(
                URL, usuario, contrasena
        );
    }
}
