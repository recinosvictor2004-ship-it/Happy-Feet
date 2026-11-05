package com.mycompany.happyfeetveterinaria.repository;

import com.mycompany.happyfeetveterinaria.model.entities.Mascota;
import com.mycompany.happyfeetveterinaria.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MascotaRepository {

    private final Connection connection;

    public MascotaRepository() {
        this.connection = DatabaseConnection
                .getInstance()
                .getConnection();
    }

    public boolean guardar(Mascota mascota) {

        String sql = """
            INSERT INTO mascotas
            (
                dueno_id,
                nombre,
                raza_id,
                fecha_nacimiento,
                sexo,
                peso_actual,
                microchip,
                tatuaje,
                url_foto,
                alergias,
                condiciones_preexistentes
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try {

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setInt(1, mascota.getDuenoId());
            ps.setString(2, mascota.getNombre());
            ps.setInt(3, mascota.getRazaId());
            ps.setDate(4,
                    java.sql.Date.valueOf(
                            mascota.getFechaNacimiento()));

            ps.setString(5, mascota.getSexo());
            ps.setDouble(6, mascota.getPesoActual());
            ps.setString(7, mascota.getMicrochip());
            ps.setString(8, mascota.getTatuaje());
            ps.setString(9, mascota.getUrlFoto());
            ps.setString(10, mascota.getAlergias());
            ps.setString(11, mascota.getCondicionesPreexistentes());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al guardar mascota");
            e.printStackTrace();

        }

        return false;
    }
    
    
    public List<Mascota> listarTodos() {

    List<Mascota> mascotas = new ArrayList<>();

    String sql = "SELECT * FROM mascotas";

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Mascota mascota = new Mascota();

            mascota.setId(rs.getInt("id"));
            mascota.setDuenoId(rs.getInt("dueno_id"));
            mascota.setRazaId(rs.getInt("raza_id"));
            mascota.setNombre(rs.getString("nombre"));

            mascotas.add(mascota);
        }

    } catch (SQLException e) {

        System.out.println("Error al listar mascotas");
        e.printStackTrace();

    }

    return mascotas;
}
    
    
    
    
    public Mascota buscarPorId(int id) {

    String sql = "SELECT * FROM mascotas WHERE id = ?";

    try {

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Mascota mascota = new Mascota();

            mascota.setId(rs.getInt("id"));
            mascota.setDuenoId(rs.getInt("dueno_id"));
            mascota.setRazaId(rs.getInt("raza_id"));
            mascota.setNombre(rs.getString("nombre"));

            return mascota;
        }

    } catch (SQLException e) {

        System.out.println("Error al buscar mascota");
        e.printStackTrace();
    }

    return null;
}
}
