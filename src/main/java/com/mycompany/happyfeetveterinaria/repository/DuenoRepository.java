package com.mycompany.happyfeetveterinaria.repository;

import com.mycompany.happyfeetveterinaria.model.entities.Dueno;
import com.mycompany.happyfeetveterinaria.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class DuenoRepository {

    private final Connection connection;

    public DuenoRepository() {
        this.connection = DatabaseConnection
                .getInstance()
                .getConnection();
    }
    public boolean guardar(Dueno dueno) {

    String sql = """
        INSERT INTO duenos
        (
            nombre_completo,
            documento_identidad,
            direccion,
            telefono,
            email,
            contacto_emergencia
        )
        VALUES (?, ?, ?, ?, ?, ?)
        """;

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setString(1, dueno.getNombreCompleto());
        ps.setString(2, dueno.getDocumentoIdentidad());
        ps.setString(3, dueno.getDireccion());
        ps.setString(4, dueno.getTelefono());
        ps.setString(5, dueno.getEmail());
        ps.setString(6, dueno.getContactoEmergencia());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println("Error al guardar dueño");
        e.printStackTrace();

    }

    return false;
}
    public List<Dueno> listarTodos() {

    List<Dueno> duenos = new ArrayList<>();

    String sql = "SELECT * FROM duenos";

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Dueno dueno = new Dueno();

            dueno.setId(rs.getInt("id"));
            dueno.setNombreCompleto(
                    rs.getString("nombre_completo"));
            dueno.setDocumentoIdentidad(
                    rs.getString("documento_identidad"));
            dueno.setDireccion(
                    rs.getString("direccion"));
            dueno.setTelefono(
                    rs.getString("telefono"));
            dueno.setEmail(
                    rs.getString("email"));
            dueno.setContactoEmergencia(
                    rs.getString("contacto_emergencia"));

            duenos.add(dueno);
        }

    } catch (SQLException e) {

        System.out.println("Error al listar dueños");
        e.printStackTrace();

    }

    return duenos;
}

    public Dueno buscarPorId(int id) {

    String sql = "SELECT * FROM duenos WHERE id = ?";

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Dueno dueno = new Dueno();

            dueno.setId(rs.getInt("id"));
            dueno.setNombreCompleto(
                    rs.getString("nombre_completo"));
            dueno.setDocumentoIdentidad(
                    rs.getString("documento_identidad"));
            dueno.setDireccion(
                    rs.getString("direccion"));
            dueno.setTelefono(
                    rs.getString("telefono"));
            dueno.setEmail(
                    rs.getString("email"));
            dueno.setContactoEmergencia(
                    rs.getString("contacto_emergencia"));

            return dueno;
        }

    } catch (SQLException e) {

        System.out.println("Error al buscar dueño");
        e.printStackTrace();

    }

    return null;
}
    public boolean eliminar(int id) {

    String sql = "DELETE FROM duenos WHERE id = ?";

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setInt(1, id);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println("Error al eliminar dueño");
        e.printStackTrace();

    }

    return false;
}
}

