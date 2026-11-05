package com.mycompany.happyfeetveterinaria.repository;

import com.mycompany.happyfeetveterinaria.model.entities.Cita;
import com.mycompany.happyfeetveterinaria.util.DatabaseConnection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

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
    
    
    
    
    
    
    
    public List<Cita> obtenerCitasPorFecha(
        LocalDate fecha) {
    List<Cita> citas =
            new ArrayList<>();
    String sql = """
            SELECT *
            FROM citas
            WHERE DATE(fecha_hora) = ?
            ORDER BY fecha_hora
            """;
    try {
        PreparedStatement ps =
                connection.prepareStatement(sql);
        ps.setDate(
                1,
                java.sql.Date.valueOf(fecha));
        ResultSet rs =
                ps.executeQuery();
        while (rs.next()) {
            Cita cita = new Cita();
            cita.setId(
                    rs.getInt("id"));
            cita.setMascotaId(
                    rs.getInt("mascota_id"));
            cita.setVeterinarioId(
                    rs.getInt("veterinario_id"));
            cita.setFechaHora(
                    rs.getTimestamp("fecha_hora")
                            .toLocalDateTime());
            cita.setMotivo(
                    rs.getString("motivo"));
            cita.setEstadoId(
                    rs.getInt("estado_id"));
            cita.setObservaciones(
                    rs.getString("observaciones"));
            citas.add(cita);
        }
    } catch (SQLException e) {
        System.out.println(
                "Error al obtener citas");
        e.printStackTrace();
    }
    return citas;
}
    
}