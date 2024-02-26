package dev.asjordi.cotizador.repositories;

import dev.asjordi.cotizador.models.Cliente;
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
public class ClienteRepository implements IRepository<Cliente> {
    
    private Connection conn;
    
    public ClienteRepository() {}

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        
        try (var stmt = conn.createStatement();
            var rs = stmt.executeQuery("SELECT * FROM clientes;")) {
            
            while (rs.next()) {
                clientes.add(createCliente(rs));
            }
            
        }
        
        return clientes;
    }

    @Override
    public Cliente getById(Integer id) throws SQLException {
        Cliente cliente = null;
        
        try (var ps = conn.prepareStatement("SELECT * FROM clientes WHERE id = ?;")) {
            ps.setInt(1, id);
            
            try (var rs = ps.executeQuery()) {
                if (rs.next()) cliente = createCliente(rs);
            }
            
        }
        
        return cliente;
    }

    @Override
    public Cliente add(Cliente c) throws SQLException {
        String sql;
        boolean isUpdate = c.getId() != null && c.getId() > 0;
        
        if (isUpdate) sql = "UPDATE clientes SET nombre = ?, telefono = ?, correo = ?, direccion = ?, estatus = ? WHERE id = ?;";
        else sql = "INSERT INTO clientes (nombre, telefono, correo, direccion, estatus) VALUES (?, ?, ?, ?, ?);";
        
        try (var ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getDireccion());
            ps.setBoolean(5, c.getEstatus());
            
            if (isUpdate) ps.setInt(6, c.getId());
            
            ps.executeUpdate();
            
            if (c.getId() == null) { 
                try (var rs = ps.getGeneratedKeys()) {
                    if (rs.next()) c.setId(rs.getInt(1));
                }
            }
            
        }
        
        return c;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (var ps = conn.prepareStatement("DELETE FROM clientes WHERE id = ?;")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public Cliente createCliente(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        
        c.setId(rs.getInt("id"));
        c.setNombre(rs.getString("nombre"));
        c.setTelefono(rs.getString("telefono"));
        c.setCorreo(rs.getString("correo"));
        c.setDireccion(rs.getString("direccion"));
        c.setEstatus(rs.getBoolean("estatus"));
        
        return c;
    }

    
}
