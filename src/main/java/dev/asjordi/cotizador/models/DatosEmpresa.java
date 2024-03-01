package dev.asjordi.cotizador.models;

import javax.swing.ImageIcon;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class DatosEmpresa {
    
    private Integer id;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String contacto;
    private String slogan;
    private String banco;
    private String titular;
    private String noCuenta;
    private String clabe;
    private String observaciones;
    private Integer iva;
    private ImageIcon logo;

    public DatosEmpresa() {
    }

    public DatosEmpresa(String nombre, String descripcion, String direccion, String contacto, String slogan, String banco, String titular, String noCuenta, String clabe, String observaciones, Integer iva) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.contacto = contacto;
        this.slogan = slogan;
        this.banco = banco;
        this.titular = titular;
        this.noCuenta = noCuenta;
        this.clabe = clabe;
        this.observaciones = observaciones;
        this.iva = iva;
    }

    public DatosEmpresa(Integer id, String nombre, String descripcion, String direccion, String contacto, String slogan, String banco, String titular, String noCuenta, String clabe, String observaciones, Integer iva) {
        this(nombre, descripcion, direccion, contacto, slogan, banco, titular, noCuenta, clabe, observaciones, iva);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public ImageIcon getLogo() {
        return logo;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataCompany{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", direccion=").append(direccion);
        sb.append(", contacto=").append(contacto);
        sb.append(", slogan=").append(slogan);
        sb.append(", banco=").append(banco);
        sb.append(", titular=").append(titular);
        sb.append(", noCuenta=").append(noCuenta);
        sb.append(", clabe=").append(clabe);
        sb.append(", observaciones=").append(observaciones);
        sb.append(", iva=").append(iva);
        sb.append('}');
        return sb.toString();
    }
}
