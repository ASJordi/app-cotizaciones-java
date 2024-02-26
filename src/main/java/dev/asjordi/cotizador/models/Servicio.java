package dev.asjordi.cotizador.models;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class Servicio {
    
    private Integer id;
    private String descripcion;
    private Double importe;
    private boolean estatus;

    public Servicio() {}

    public Servicio(String descripcion, Double importe, boolean estatus) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.estatus = estatus;
    }

    public Servicio(Integer id, String descripcion, Double importe, boolean estatus) {
        this(descripcion, importe, estatus);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
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
        sb.append("Servicio{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", importe=").append(importe);
        sb.append(", estatus=").append(estatus);
        sb.append('}');
        return sb.toString();
    }
    
}
