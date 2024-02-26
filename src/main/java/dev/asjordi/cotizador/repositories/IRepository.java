package dev.asjordi.cotizador.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public interface IRepository<T> {
    
    void setConn(Connection conn);
    List<T> getAll() throws SQLException;
    T getById(Integer id) throws SQLException;
    T add(T t) throws SQLException;
    void delete(Integer id) throws SQLException;
    
}
