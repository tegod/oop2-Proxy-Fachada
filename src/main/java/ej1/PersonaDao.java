package ej1;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {
    private Connection obtenerConexion() throws SQLException {
        String url = "jdbc:derby:personasDB;create=true";
        String user = "app";
        String password = "app";
        return DriverManager.getConnection(url, user, password);
    }

    public Persona personaPorId(int id) {
        String sql = "SELECT nombre FROM persona WHERE id = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql);) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            String nombrePersona = null;
            if(result.next()) {
                nombrePersona =result.getString(1);
            }else {
                return null;
            }

            Set<Telefono> telefonos = new TelefonoProxy(id, this);

            return new Persona(id, nombrePersona, telefonos);
        } catch(SQLException e) {
            throw new RuntimeException("error al buscar a la persona " + e.getMessage());
        }
    }

    public Set<Telefono> buscarTelefonoPorPersonaId(int idPersona) {
        Set<Telefono> telefonosReales = new HashSet<>();
        String sql = "SELECT numero FROM telefonos WHERE idPersona = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, idPersona);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                telefonosReales.add(new Telefono(rs.getString(1)));
            }

            return telefonosReales;

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el teléfono " + e.getMessage());
        }
    }
}
