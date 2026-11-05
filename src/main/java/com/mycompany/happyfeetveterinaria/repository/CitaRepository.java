package com.mycompany.happyfeetveterinaria.repository;

import com.mycompany.happyfeetveterinaria.model.entities.Cita;
import com.mycompany.happyfeetveterinaria.util.DatabaseConnection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;


import java.sql.Connection;

public class CitaRepository {

    private final Connection connection;

    public CitaRepository() {

        this.connection =
                DatabaseConnection
                .getInstance()
                .getConnection();
    }
    
    
    public boolean guardar(Cita cita) {

    String sql = """
        INSERT INTO citas
        (
            mascota_id,
            veterinario_id,
            fecha_hora,
            motivo,
            estado_id,
            observaciones
        )
        VALUES (?, ?, ?, ?, ?, ?)
        """;

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setInt(1, cita.getMascotaId());

        ps.setInt(2, cita.getVeterinarioId());

        ps.setTimestamp(
                3,
                Timestamp.valueOf(
                        cita.getFechaHora()
                )
        );

        ps.setString(4, cita.getMotivo());

        ps.setInt(5, cita.getEstadoId());

        ps.setString(6, cita.getObservaciones());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println("Error al guardar cita");

        e.printStackTrace();
    }

    return false;
}
}