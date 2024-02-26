package dev.asjordi.cotizador.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public interface IService<T> {
    
    List<T> getAll() throws SQLException;
    T getById(Integer id) throws SQLException;
    T add(T t) throws SQLException;
    void delete(Integer id) throws SQLException;
    
}
