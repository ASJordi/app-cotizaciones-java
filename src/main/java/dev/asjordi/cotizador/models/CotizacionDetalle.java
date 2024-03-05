package dev.asjordi.cotizador.models;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class CotizacionDetalle {
    
    private Integer id;
    private Integer idCotizacion;
    private Servicio servicio;

    public CotizacionDetalle() {}

    public CotizacionDetalle(Integer id, Integer idCotizacion, Servicio servicio) {
        this.id = id;
        this.idCotizacion = idCotizacion;
        this.servicio = servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CotizacionDetalle{");
        sb.append("id=").append(id);
        sb.append(", idCotizacion=").append(idCotizacion);
        sb.append(", servicio=").append(servicio);
        sb.append('}');
        return sb.toString();
    }
}
