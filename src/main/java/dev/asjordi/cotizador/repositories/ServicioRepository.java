package dev.asjordi.cotizador.repositories;

import dev.asjordi.cotizador.models.Servicio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class ServicioRepository implements IRepository<Servicio> {
    
    private Connection conn;

    public ServicioRepository() {}

    public ServicioRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Servicio> getAll() throws SQLException {
        List<Servicio> servicios = new ArrayList<>();
        
        try (var stmt = conn.createStatement();
            var rs = stmt.executeQuery("SELECT * FROM servicios;")) {
            
            while (rs.next()) {
                servicios.add(createServicio(rs));
            }
            
        }
        
        return servicios;
    }

    @Override
    public Servicio getById(Integer id) throws SQLException {
        Servicio servicio = null;
        
        try (var ps = conn.prepareStatement("SELECT * FROM servicios WHERE id = ?;")) {
            ps.setInt(1, id);
            
            try (var rs = ps.executeQuery()) {
                if (rs.next()) servicio = createServicio(rs);
            }   
            
        }
        
        return servicio;
    }

    @Override
    public Servicio add(Servicio s) throws SQLException {
        String sql;
        boolean isUpdate = s.getId() != null && s.getId() > 0;
        
        if (isUpdate) sql = "UPDATE servicios SET descripcion = ?, importe = ?, estatus = ? WHERE id = ?;";
        else sql = "INSERT INTO servicios (descripcion, importe, estatus) VALUES (?, ?, ?);";
        
        try (var ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getDescripcion());
            ps.setDouble(2, s.getImporte());
            ps.setBoolean(3, s.getEstatus());
            
            if (isUpdate) ps.setInt(4, s.getId());
            
            ps.executeUpdate();
            
            if (s.getId() == null) {
                try (var rs = ps.getGeneratedKeys()) {
                    if (rs.next()) s.setId(rs.getInt(1));
                }
            }
        }
        
        return s;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (var ps = conn.prepareStatement("DELETE FROM servicios WHERE id = ?;")) {
            ps.setInt(1, id);
            ps.executeUpdate();
            
        }
    }
    
    private Servicio createServicio(ResultSet rs) throws SQLException {
        Servicio s = new Servicio();
        
        s.setId(rs.getInt("id"));
        s.setDescripcion(rs.getString("descripcion"));
        s.setImporte(rs.getDouble("importe"));
        s.setEstatus(rs.getBoolean("estatus"));
        
        return s;
    }
    
}
