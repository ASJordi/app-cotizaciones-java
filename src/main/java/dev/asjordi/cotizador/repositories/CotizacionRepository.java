package dev.asjordi.cotizador.repositories;

import dev.asjordi.cotizador.models.Cliente;
import dev.asjordi.cotizador.models.Cotizacion;
import dev.asjordi.cotizador.models.CotizacionDetalle;
import dev.asjordi.cotizador.models.Servicio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class CotizacionRepository implements IRepository<Cotizacion> {

    private Connection conn;
    
    public CotizacionRepository() {}

    public CotizacionRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Cotizacion> getAll() throws SQLException {
        List<Cotizacion> list = new ArrayList<>();
        String sql = "SELECT c.id, c.fecha, c.subtotal, c.iva, c.total, c.id_cliente, cl.nombre, cl.telefono, cl.correo, cl.direccion, cl.estatus FROM cotizaciones AS c INNER JOIN clientes AS cl ON c.id_cliente = cl.id;";
        
        try (var ps = conn.prepareStatement(sql)) {
            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cotizacion cotizacion = createCotizacionFromResultSet(rs);
                    cotizacion.setDetalles(getDetallesCotizacion(cotizacion.getId()));
                    list.add(cotizacion);
                }
            }
        }

        return list;
    }
    
    @Override
    public Cotizacion getById(Integer id) throws SQLException {
        Cotizacion cotizacion = null;

        try (var ps = conn.prepareStatement("SELECT * FROM cotizaciones WHERE id = ?")) {
            ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    cotizacion = createCotizacionFromResultSet(rs);
                    cotizacion.setDetalles(getDetallesCotizacion(cotizacion.getId()));
                }
            }
        }

        return cotizacion;
    }
    
    private List<CotizacionDetalle> getDetallesCotizacion(int id) throws SQLException {
        List<CotizacionDetalle> list = new ArrayList<>();

        String sql = "SELECT cd.id, cd.id_cotizacion, cd.id_servicio, s.descripcion, s.importe, s.estatus FROM cotizacion_detalle AS cd INNER JOIN servicios AS s ON id_servicio = s.id WHERE id_cotizacion = ?;";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            
            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    CotizacionDetalle d = new CotizacionDetalle();
                    d.setId(rs.getInt("id"));
                    d.setIdCotizacion(rs.getInt("id_cotizacion"));
                    
                    Servicio s = new Servicio();
                    s.setId(rs.getInt("id_servicio"));
                    s.setDescripcion(rs.getString("descripcion"));
                    s.setImporte(rs.getDouble("importe"));
                    s.setEstatus(rs.getBoolean("estatus"));
                    
                    d.setServicio(s);
                    list.add(d);
                }
            }
        }

        return list;
    }

    @Override
    public Cotizacion add(Cotizacion cotizacion) throws SQLException {
        String sql = "INSERT INTO cotizaciones (fecha, subtotal, iva, total, id_cliente) VALUES (?, ?, ?, ?, ?)";
        try (var ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, Date.valueOf(cotizacion.getFecha()));
            ps.setDouble(2, cotizacion.getSubtotal());
            ps.setDouble(3, cotizacion.getIva());
            ps.setDouble(4, cotizacion.getTotal());
            ps.setInt(5, cotizacion.getCliente().getId());

            ps.executeUpdate();

            try (var generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cotizacion.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudieron obtener las claves generadas");
                }
            }
        }

        insertCotizacionDetalles(cotizacion);

        return cotizacion;
    }
    
    private void insertCotizacionDetalles(Cotizacion cotizacion) throws SQLException {
        String sql = "INSERT INTO cotizacion_detalle (id_cotizacion, id_servicio) VALUES (?, ?)";
        try (var ps = conn.prepareStatement(sql)) {
            
            for (Servicio s : cotizacion.getServicios()) {
                ps.setInt(1, cotizacion.getId());
                ps.setInt(2, s.getId());
                ps.executeUpdate();
            }
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        deleteCotizacionDetalles(id);

        try (var ps = conn.prepareStatement("DELETE FROM cotizaciones WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void deleteCotizacionDetalles(int cotizacionId) throws SQLException {
        String sql = "DELETE FROM cotizacion_detalle WHERE id_cotizacion = ?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cotizacionId);
            ps.executeUpdate();
        }
    }
    
    private Cotizacion createCotizacionFromResultSet(ResultSet rs) throws SQLException {
        Cotizacion c = new Cotizacion();
        Cliente cliente = new Cliente();
        
        c.setId(rs.getInt("id"));
        c.setFecha(rs.getDate("fecha").toLocalDate());
        c.setSubtotal(rs.getDouble("subtotal"));
        c.setIva(rs.getDouble("iva"));
        c.setTotal(rs.getDouble("total"));
        
        cliente.setId(rs.getInt("id_cliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setCorreo(rs.getString("correo"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setEstatus(rs.getBoolean("estatus"));
        c.setCliente(cliente);
        
        return c;
    }
}
