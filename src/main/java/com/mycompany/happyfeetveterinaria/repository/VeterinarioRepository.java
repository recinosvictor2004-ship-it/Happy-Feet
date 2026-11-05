package com.mycompany.happyfeetveterinaria.repository;

import com.mycompany.happyfeetveterinaria.model.entities.Veterinario;
import com.mycompany.happyfeetveterinaria.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class VeterinarioRepository {

    private final Connection connection;

    public VeterinarioRepository() {
        this.connection = DatabaseConnection
                .getInstance()
                .getConnection();
    }
public boolean guardar(Veterinario veterinario) {

    String sql = """
        INSERT INTO veterinarios
        (
            nombre_completo,
            documento_identidad,
            licencia_profesional,
            especialidad,
            telefono,
            email,
            fecha_contratacion
        )
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setString(1,
                veterinario.getNombreCompleto());

        ps.setString(2,
                veterinario.getDocumentoIdentidad());

        ps.setString(3,
                veterinario.getLicenciaProfesional());

        ps.setString(4,
                veterinario.getEspecialidad());

        ps.setString(5,
                veterinario.getTelefono());

        ps.setString(6,
                veterinario.getEmail());

        ps.setDate(
                7,
                Date.valueOf(
                        veterinario.getFechaContratacion()
                )
        );

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println(
                "Error al guardar veterinario");

        e.printStackTrace();
    }

    return false;
}


public List<Veterinario> listarTodos() {

    List<Veterinario> veterinarios =
            new ArrayList<>();

    String sql = "SELECT * FROM veterinarios";

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Veterinario veterinario =
                    new Veterinario();

            veterinario.setId(rs.getInt("id"));

            veterinario.setNombreCompleto(
                    rs.getString("nombre_completo"));

            veterinarios.add(veterinario);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar veterinarios");

        e.printStackTrace();
    }

    return veterinarios;
}



public Veterinario buscarPorId(int id) {

    String sql =
            "SELECT * FROM veterinarios WHERE id = ?";

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Veterinario veterinario =
                    new Veterinario();

            veterinario.setId(
                    rs.getInt("id"));

            veterinario.setNombreCompleto(
                    rs.getString("nombre_completo"));

            return veterinario;
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar veterinario");

        e.printStackTrace();
    }

    return null;
}
}