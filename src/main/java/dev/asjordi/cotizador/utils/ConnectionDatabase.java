package dev.asjordi.cotizador.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class ConnectionDatabase {
    
    private final static String url = "jdbc:mysql://localhost:3306/appcotizador?useTimezone=true&serverTimezone=UTC";
    private static BasicDataSource pool;
    
    private ConnectionDatabase() {}
    
    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
    
    private static BasicDataSource getInstance() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(getProps().getProperty("user"));
            pool.setPassword(getProps().getProperty("password"));
            pool.setInitialSize(2);
            pool.setMinIdle(3);
            pool.setMaxIdle(5);
            pool.setMaxTotal(10);
        }
        
        return pool;
    }
    
    private static Properties getProps() {
        Properties p = new Properties();
        p.setProperty("user", System.getenv("user_mysql"));
        p.setProperty("password", System.getenv("password_mysql"));
        p.setProperty("useSSL", "true");
        return p;
    }
    
}
