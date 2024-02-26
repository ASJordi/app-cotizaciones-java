package dev.asjordi.cotizador.services;

import dev.asjordi.cotizador.models.Servicio;
import dev.asjordi.cotizador.repositories.IRepository;
import dev.asjordi.cotizador.repositories.ServicioRepository;
import dev.asjordi.cotizador.utils.ConnectionDatabase;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class ServicioService implements IService<Servicio> {
    
    private IRepository<Servicio> repo;

    public ServicioService() {
        this.repo = new ServicioRepository();
    }

    @Override
    public List<Servicio> getAll() throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            return repo.getAll();
        }
    }

    @Override
    public Servicio getById(Integer id) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            return repo.getById(id);
        }
    }

    @Override
    public Servicio add(Servicio s) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            repo.setConn(conn);
            
            if (conn.getAutoCommit()) conn.setAutoCommit(false);
            Servicio newService = null;
            
            try {
                newService = repo.add(s);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            
            return newService;
            
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
