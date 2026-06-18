package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneradorBD {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:personasDB;create=true");
                    Statement sttm = conn.createStatement()) {

            sttm.execute("CREATE TABLE persona (id INT, nombre VARCHAR(100))");
            sttm.execute("CREATE TABLE telefonos (id INT, numero VARCHAR(100), idPersona INT)");

            sttm.execute("INSERT INTO persona VALUES (1, 'Alex')");
            sttm.execute("INSERT INTO persona VALUES (2, 'Bob')");
            sttm.execute("INSERT INTO persona VALUES (3, 'Carlo')");
            sttm.execute("INSERT INTO telefonos VALUES (1, '2920-339955', 1)");
            sttm.execute("INSERT INTO telefonos VALUES (2, '2920-319581', 2)");
            sttm.execute("INSERT INTO telefonos VALUES (3, '2920-591837', 3)");
            sttm.execute("INSERT INTO telefonos VALUES (4, '2920315591', 1)");

            System.out.println("se pudo generar");
        }
    }
}
