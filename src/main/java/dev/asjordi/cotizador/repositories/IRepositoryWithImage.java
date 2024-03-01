package dev.asjordi.cotizador.repositories;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public interface IRepositoryWithImage<T> {
    void setConn(Connection conn);
    T getData() throws SQLException;
    T getImage() throws SQLException;
    T updateData(T t) throws SQLException;
    void updateImage(FileInputStream fis, Integer len) throws SQLException;
}
