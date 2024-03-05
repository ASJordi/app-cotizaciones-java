package dev.asjordi.cotizador.models;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class Cotizacion {
    
    private Integer id;
    private LocalDate fecha;
    private Double subtotal;
    private Double iva;
    private Double total;
    private Cliente cliente;
    private List<CotizacionDetalle> detalles;
    private List<Servicio> servicios;

    public Cotizacion() {
        this.detalles = new LinkedList<>();
        this.servicios = new LinkedList<>();
    }

    public Cotizacion(LocalDate fecha, Double subtotal, Double iva, Double total, Cliente cliente) {
        this();
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.cliente = cliente;
    }

    public Cotizacion(Integer id, LocalDate fecha, Double subtotal, Double iva, Double total, Cliente cliente) {
        this(fecha, subtotal, iva, total, cliente);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<CotizacionDetalle> getDetalles() {
        return this.detalles;
    }

    public void setDetalles(List<CotizacionDetalle> detalles) {
        this.detalles = detalles;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cotizacion{");
        sb.append("id=").append(id);
        sb.append(", fecha=").append(fecha);
        sb.append(", subtotal=").append(subtotal);
        sb.append(", iva=").append(iva);
        sb.append(", total=").append(total);
        sb.append(", cliente=").append(cliente);
        sb.append(", detalles=").append(detalles);
        sb.append('}');
        return sb.toString();
    }
    
}
