package dev.asjordi.cotizador.services;

import dev.asjordi.cotizador.models.DatosEmpresa;
import dev.asjordi.cotizador.repositories.DatosEmpresaRepository;
import dev.asjordi.cotizador.repositories.IRepositoryWithImage;
import dev.asjordi.cotizador.utils.ConnectionDatabase;
import java.io.FileInputStream;
import java.sql.SQLException;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class DatosEmpresaService implements IServiceWithImage<DatosEmpresa> {
    
    private IRepositoryWithImage<DatosEmpresa> repo;
    
    public DatosEmpresaService() {
        this.repo = new DatosEmpresaRepository();
    }

    @Override
    public DatosEmpresa getData() throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            this.repo.setConn(conn);
            return repo.getData();
        }
    }

    @Override
    public DatosEmpresa getImage() throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            this.repo.setConn(conn);
            return repo.getImage();
        }
    }

    @Override
    public DatosEmpresa updateData(DatosEmpresa d) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            this.repo.setConn(conn);
            
            if (conn.getAutoCommit()) conn.setAutoCommit(false);
            DatosEmpresa de = null;
            
            try {
                de = repo.updateData(d);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            
            return de;
        }
    }

    @Override
    public void updateImage(FileInputStream fis, Integer len) throws SQLException {
        try (var conn = ConnectionDatabase.getConnection()) {
            this.repo.setConn(conn);
            if (conn.getAutoCommit()) conn.setAutoCommit(false);
            
            try {
                repo.updateImage(fis, len);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            
        }
    }
    
}
