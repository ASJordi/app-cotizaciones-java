package dev.asjordi.cotizador.services;

import dev.asjordi.cotizador.models.Cliente;
import dev.asjordi.cotizador.repositories.ClienteRepository;
import dev.asjordi.cotizador.repositories.IRepository;
import dev.asjordi.cotizador.utils.ConnectionDatabase;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class ClienteService implements IService<Cliente>{
    
    private IRepository<Cliente> repo;

    public ClienteService() {
        this.repo = new ClienteRepository();
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            return repo.getAll();
        }
    }

    @Override
    public Cliente getById(Integer id) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            return repo.getById(id);
        }
    }

    @Override
    public Cliente add(Cliente c) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            
            if (conn.getAutoCommit()) conn.setAutoCommit(false);
            Cliente newCliente = null;
            
            try {
                newCliente = repo.add(c);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            
            return newCliente;
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            
            if (conn.getAutoCommit()) conn.setAutoCommit(false);
            
            try {
                repo.delete(id);
                conn.commit();
            } catch(SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            
        }
    }
    
}
