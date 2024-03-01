package dev.asjordi.cotizador.repositories;

import dev.asjordi.cotizador.models.DatosEmpresa;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class DatosEmpresaRepository implements IRepositoryWithImage<DatosEmpresa>{
    
    private Connection conn;

    public DatosEmpresaRepository() {}

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public DatosEmpresa getData() throws SQLException {
        DatosEmpresa de = null;
        
        try (var ps = conn.prepareStatement("SELECT * FROM datos_empresa WHERE id = ?;")) {
            ps.setInt(1, 1);
            
            try (var rs = ps.executeQuery()) {
                if (rs.next()) de = createOnlyObject(rs);
            }
        }
        
        return de;
    }

    @Override
    public DatosEmpresa getImage() throws SQLException {
        DatosEmpresa de = new DatosEmpresa();
        
        try (var ps = conn.prepareStatement("SELECT logo FROM datos_empresa WHERE id = ?;")) {
            ps.setInt(1, 1);
            
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    Blob blob = rs.getBlob("logo");
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(data));
                    de.setLogo(new ImageIcon(img));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return de;
    }

    @Override
    public DatosEmpresa updateData(DatosEmpresa d) throws SQLException {
        String sql = "UPDATE datos_empresa SET nombre = ?, descripcion = ?, direccion = ?, contacto = ?, slogan = ?, banco = ?, titular = ?, no_cuenta = ?, clabe = ?, observaciones = ?, iva = ? WHERE id = ?;";

        try (var ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getDescripcion());
            ps.setString(3, d.getDireccion());
            ps.setString(4, d.getContacto());
            ps.setString(5, d.getSlogan());
            ps.setString(6, d.getBanco());
            ps.setString(7, d.getTitular());
            ps.setString(8, d.getNoCuenta());
            ps.setString(9, d.getClabe());
            ps.setString(10, d.getObservaciones());
            ps.setInt(11, d.getIva());
            ps.setInt(12, d.getId());
            ps.executeUpdate();
        }
        
        return d;
    }

    @Override
    public void updateImage(FileInputStream fis, Integer len) throws SQLException {
        try (var ps = conn.prepareStatement("UPDATE datos_empresa SET logo = ? WHERE id = ?;")) {
            ps.setBlob(1, fis, len);
            ps.setInt(2, 1);
            ps.executeUpdate();
        }
    }
    
    private DatosEmpresa createOnlyObject(ResultSet rs) throws SQLException {
        DatosEmpresa d = new DatosEmpresa();
        
        d.setId(rs.getInt("id"));
        d.setNombre(rs.getString("nombre"));
        d.setDescripcion(rs.getString("descripcion"));
        d.setDireccion(rs.getString("direccion"));
        d.setContacto(rs.getString("contacto"));
        d.setSlogan(rs.getString("slogan"));
        d.setBanco(rs.getString("banco"));
        d.setTitular(rs.getString("titular"));
        d.setNoCuenta(rs.getString("no_cuenta"));
        d.setClabe(rs.getString("clabe"));
        d.setObservaciones(rs.getString("observaciones"));
        d.setIva(rs.getInt("iva"));
        
        return d;
    }
    
    private DatosEmpresa createObjectWithImage(ResultSet rs) throws SQLException {
        DatosEmpresa d = new DatosEmpresa();
        d.setLogo(null);
        return d;
    }

}
