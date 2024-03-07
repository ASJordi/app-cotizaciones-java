package dev.asjordi.cotizador.utils;

import dev.asjordi.cotizador.models.Cotizacion;
import dev.asjordi.cotizador.models.CotizacionDetalle;
import dev.asjordi.cotizador.models.DatosEmpresa;
import dev.asjordi.cotizador.models.Servicio;
import dev.asjordi.cotizador.services.CotizacionService;
import dev.asjordi.cotizador.services.DatosEmpresaService;
import dev.asjordi.cotizador.services.IService;
import dev.asjordi.cotizador.services.IServiceWithImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class PrintQuotesReport {

    private final IService<Cotizacion> cotizacionService;
    private final IServiceWithImage<DatosEmpresa> empresaService;
    private final InputStream reportStream;
    private final InputStream logoStream;
    private Integer id;
    private DatosEmpresa empresa;

    public PrintQuotesReport(Integer id) throws SQLException, IOException {
        this.cotizacionService = new CotizacionService();
        this.empresaService = new DatosEmpresaService();
        this.reportStream = this.getClass().getResourceAsStream("/reports/QuotesReport.jasper");
//        this.logoStream = this.getClass().getResourceAsStream("/img/logo.png");
        this.logoStream = ImageUtils.convertImageIconToInputStream(this.empresaService.getImage().getLogo());
        this.id = id;
        this.empresa = empresaService.getData();
    }

    public void print() {
        try {
            
            if (reportStream != null) {

                Cotizacion cotizacion = this.cotizacionService.getById(this.id);

                List<Servicio> list = new ArrayList<>();
                int no = 0;

                for (CotizacionDetalle cd : cotizacion.getDetalles()) {
                    Servicio s = new Servicio();
                    s.setId(++no);
                    s.setDescripcion(cd.getServicio().getDescripcion());
                    s.setImporte(cd.getServicio().getImporte());
                    list.add(s);
                }

                JasperReport report = (JasperReport) JRLoader.loadObject(reportStream);
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(list.toArray(new Servicio[0]));

                Map<String, Object> parameters = new HashMap<>();
                parameters.put("ds", ds);

                parameters.put("logoEmpresa", logoStream);
                parameters.put("nombre", empresa.getNombre());
                parameters.put("descripcion", empresa.getDescripcion());
                parameters.put("direccion", empresa.getDireccion());
                parameters.put("contacto", empresa.getContacto());
                parameters.put("slogan", empresa.getSlogan());

                parameters.put("nombreCliente", cotizacion.getCliente().getNombre());
                parameters.put("direccionCliente", cotizacion.getCliente().getDireccion());
                parameters.put("fecha", cotizacion.getFecha());
                parameters.put("telefonoCliente", cotizacion.getCliente().getTelefono());
                parameters.put("correoCliente", cotizacion.getCliente().getCorreo());
                parameters.put("idCotizacion", cotizacion.getId());

                parameters.put("subtotal", cotizacion.getSubtotal());
                parameters.put("iva", cotizacion.getIva());
                parameters.put("total", cotizacion.getTotal());

                parameters.put("banco", empresa.getBanco());
                parameters.put("titular", empresa.getTitular());
                parameters.put("noCuenta", empresa.getNoCuenta());
                parameters.put("clabe", empresa.getClabe());
                parameters.put("observaciones", empresa.getObservaciones());

                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

                JasperViewer viewer = new JasperViewer(jasperPrint, false);
                viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewer.setTitle("App Cotizaciones - Imprimir Cotización");
                viewer.setIconImage(ImageUtils.getIcon().getImage());
                viewer.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void printWithoutDialog() {
        try {
            
            if (reportStream != null) {

                Cotizacion cotizacion = this.cotizacionService.getById(this.id);

                List<Servicio> list = new ArrayList<>();
                int no = 0;

                for (CotizacionDetalle cd : cotizacion.getDetalles()) {
                    Servicio s = new Servicio();
                    s.setId(++no);
                    s.setDescripcion(cd.getServicio().getDescripcion());
                    s.setImporte(cd.getServicio().getImporte());
                    list.add(s);
                }

                JasperReport report = (JasperReport) JRLoader.loadObject(reportStream);
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(list.toArray(new Servicio[0]));

                Map<String, Object> parameters = new HashMap<>();
                parameters.put("ds", ds);

                parameters.put("logoEmpresa", logoStream);
                parameters.put("nombre", empresa.getNombre());
                parameters.put("descripcion", empresa.getDescripcion());
                parameters.put("direccion", empresa.getDireccion());
                parameters.put("contacto", empresa.getContacto());
                parameters.put("slogan", empresa.getSlogan());

                parameters.put("nombreCliente", cotizacion.getCliente().getNombre());
                parameters.put("direccionCliente", cotizacion.getCliente().getDireccion());
                parameters.put("fecha", cotizacion.getFecha());
                parameters.put("telefonoCliente", cotizacion.getCliente().getTelefono());
                parameters.put("correoCliente", cotizacion.getCliente().getCorreo());
                parameters.put("idCotizacion", cotizacion.getId());

                parameters.put("subtotal", cotizacion.getSubtotal());
                parameters.put("iva", cotizacion.getIva());
                parameters.put("total", cotizacion.getTotal());

                parameters.put("banco", empresa.getBanco());
                parameters.put("titular", empresa.getTitular());
                parameters.put("noCuenta", empresa.getNoCuenta());
                parameters.put("clabe", empresa.getClabe());
                parameters.put("observaciones", empresa.getObservaciones());

                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
                JasperPrintManager.printReport(jasperPrint, false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
