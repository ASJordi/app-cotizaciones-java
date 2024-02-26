package dev.asjordi.cotizador.models;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class Cliente {
    
    private Integer id;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private boolean estatus;

    public Cliente() {}

    public Cliente(String nombre, String telefono, String correo, String direccion, boolean estatus) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estatus = estatus;
    }

    public Cliente(Integer id, String nombre, String telefono, String correo,String direccion, boolean estatus) {
        this(nombre, telefono, correo, direccion, estatus);
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", telefono=").append(telefono);
        sb.append(", correo=").append(correo);
        sb.append(", direccion=").append(direccion);
        sb.append(", estatus=").append(estatus);
        sb.append('}');
        return sb.toString();
    } 
}
