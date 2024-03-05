package dev.asjordi.cotizador.services;

import dev.asjordi.cotizador.models.Cotizacion;
import dev.asjordi.cotizador.repositories.CotizacionRepository;
import dev.asjordi.cotizador.repositories.IRepository;
import dev.asjordi.cotizador.utils.ConnectionDatabase;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class CotizacionService implements IService<Cotizacion> {
    
    private IRepository<Cotizacion> repo;

    public CotizacionService() {
        this.repo = new CotizacionRepository();
    }

    @Override
    public List<Cotizacion> getAll() throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            return repo.getAll();
        }
    }

    @Override
    public Cotizacion getById(Integer id) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            return repo.getById(id);
        }
    }

    @Override
    public Cotizacion add(Cotizacion c) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            
            if (conn.getAutoCommit()) conn.setAutoCommit(false);
            Cotizacion newC = null;
            
            try {
                newC = repo.add(c);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            
            return newC;
            
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
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }   
        }
    }
    
}
