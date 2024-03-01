package dev.asjordi.cotizador.services;

import java.io.FileInputStream;
import java.sql.SQLException;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public interface IServiceWithImage<T> {
    T getData() throws SQLException;
    T getImage() throws SQLException;
    T updateData(T t) throws SQLException;
    void updateImage(FileInputStream fis, Integer len) throws SQLException;
}
