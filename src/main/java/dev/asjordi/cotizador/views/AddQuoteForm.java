package dev.asjordi.cotizador.views;

import dev.asjordi.cotizador.models.Cliente;
import dev.asjordi.cotizador.models.Cotizacion;
import dev.asjordi.cotizador.models.DatosEmpresa;
import dev.asjordi.cotizador.models.Servicio;
import dev.asjordi.cotizador.services.ClienteService;
import dev.asjordi.cotizador.services.CotizacionService;
import dev.asjordi.cotizador.services.DatosEmpresaService;
import dev.asjordi.cotizador.services.IService;
import dev.asjordi.cotizador.services.IServiceWithImage;
import dev.asjordi.cotizador.utils.ImageUtils;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class AddQuoteForm extends javax.swing.JFrame {
    
    private Integer clientId;
    private IService<Cliente> clientService;
    private IServiceWithImage<DatosEmpresa> companyService;
    private IService<Cotizacion> cotizacionService;
    private List<Servicio> items;
    private double ivaPercent = 0;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal iva = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;

    public AddQuoteForm() {
        initComponents();
        this.setIconImage(ImageUtils.getIcon().getImage());
        tablaServicios.setAutoCreateRowSorter(true);
        this.cotizacionService = new CotizacionService();
        this.clientService = new ClienteService();
        this.companyService = new DatosEmpresaService();
        this.items = new LinkedList<>();
        loadCompanyInfo();
        loadDateInfo();
    }
    
    private void loadDateInfo() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.now();
        txtFecha.setText(df.format(ld));
    }
    
    private void loadCompanyInfo() {
        try {
            DatosEmpresa de = companyService.getData();
            txtNombreEmpresa.setText(de.getNombre());
            txtDesEmpresa.setText(de.getDescripcion());
            txtDirEmpresa.setText(de.getDireccion());
            txtContactoEmpresa.setText(de.getContacto());
            txtSloganEmpresa.setText(de.getSlogan());
            txtIva.setText(String.valueOf(de.getIva()) + "%");
            this.ivaPercent = (double) de.getIva() / 100;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadClientData() {
        try {
            if (this.clientId != null) {
                Cliente c = clientService.getById(clientId);
                txtNombreCliente.setText(c.getNombre());
                txtCorreoCliente.setText(c.getCorreo());
                txtDireccionCliente.setText(c.getDireccion());
                txtTelefonoCliente.setText(c.getTelefono());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setClientId(Integer id) {
        this.clientId = id;
    }
    
    public void addServicio(Servicio s) {
        items.add(s);
        this.subtotal = new BigDecimal(String.valueOf(s.getImporte())).add(subtotal);
        calculatePrice();
    }
    
    private void calculatePrice() {
        this.iva = subtotal.multiply(new BigDecimal(String.valueOf(this.ivaPercent)));
        total = subtotal.add(this.iva);
        updateNoItems();
        setPriceElements();
    }
    
    private void setPriceElements() {
        lblSubtotal.setText(this.subtotal.toPlainString());
        lblTotal.setText(this.total.toPlainString());
        lblIva.setText(this.iva.toPlainString());
    }
    
    private void updateNoItems() {
        lblNoItems.setText(String.valueOf(this.items.size()));
    }
    
    private void updateItemsTabla() {
        var tModel = new DefaultTableModel();
        String[] columns = {"Id", "Descripción", "Importe"};
        tModel.setColumnIdentifiers(columns);
        
        for (Servicio s : items) {
            Object[] data = {s.getId(), s.getDescripcion(), s.getImporte()};
            tModel.addRow(data);
        }
        
        tablaServicios.setModel(tModel);
    }
    
    private void clear() {
        txtNombreCliente.setText("");
        txtCorreoCliente.setText("");
        txtDireccionCliente.setText("");
        txtTelefonoCliente.setText("");

        this.clientId = null;
        this.subtotal = new BigDecimal(BigInteger.ZERO);
        this.total = new BigDecimal(BigInteger.ZERO);
        this.iva = new BigDecimal(BigInteger.ZERO);
        this.items.clear();

        lblNoItems.setText(String.valueOf(items.size()));
        lblSubtotal.setText(this.subtotal.toPlainString());
        lblTotal.setText(this.total.toPlainString());
        lblIva.setText(this.iva.toPlainString());

        var model = (DefaultTableModel) tablaServicios.getModel();
        model.setRowCount(0);
        tablaServicios.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMain = new javax.swing.JPanel();
        pHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pCliente = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtCorreoCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnNuevoCliente = new javax.swing.JButton();
        pDetalleServicios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        pButtons = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pDataBusiness = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesEmpresa = new javax.swing.JTextField();
        txtDirEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtContactoEmpresa = new javax.swing.JTextField();
        txtSloganEmpresa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        pDetalleServicios1 = new javax.swing.JPanel();
        btnAgregarServicio = new javax.swing.JButton();
        btnRemoverServicio = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblNoItems = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Cotizaciones - Nueva Cotización");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        pMain.setBackground(new java.awt.Color(255, 255, 255));
        pMain.setMaximumSize(new java.awt.Dimension(1200, 800));
        pMain.setMinimumSize(new java.awt.Dimension(1200, 800));

        pHead.setBackground(new java.awt.Color(255, 255, 255));
        pHead.setMaximumSize(new java.awt.Dimension(120, 120));
        pHead.setMinimumSize(new java.awt.Dimension(120, 120));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Cotización");
        jLabel1.setFocusable(false);

        javax.swing.GroupLayout pHeadLayout = new javax.swing.GroupLayout(pHead);
        pHead.setLayout(pHeadLayout);
        pHeadLayout.setHorizontalGroup(
            pHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeadLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(308, 308, 308))
        );
        pHeadLayout.setVerticalGroup(
            pHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pCliente.setBackground(new java.awt.Color(255, 255, 255));
        pCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nombre:");

        txtNombreCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombreCliente.setEnabled(false);

        txtCorreoCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreoCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorreoCliente.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreoCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCorreoCliente.setEnabled(false);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Correo:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Dirección:");

        txtDireccionCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccionCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDireccionCliente.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccionCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDireccionCliente.setEnabled(false);

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBuscarCliente.setToolTipText("Buscar cliente");
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Teléfono:");

        txtTelefonoCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefonoCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTelefonoCliente.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefonoCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefonoCliente.setEnabled(false);

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFecha.setEnabled(false);
        txtFecha.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtFecha.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha:");

        btnNuevoCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNuevoCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnNuevoCliente.setToolTipText("Agregar Cliente");
        btnNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pClienteLayout = new javax.swing.GroupLayout(pCliente);
        pCliente.setLayout(pClienteLayout);
        pClienteLayout.setHorizontalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)))
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevoCliente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pClienteLayout.setVerticalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNuevoCliente)
                            .addComponent(btnBuscarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pDetalleServicios.setBackground(new java.awt.Color(255, 255, 255));
        pDetalleServicios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Servicios - Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        tablaServicios.setBackground(new java.awt.Color(255, 255, 255));
        tablaServicios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaServicios.setForeground(new java.awt.Color(0, 0, 0));
        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripción", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaServicios);

        javax.swing.GroupLayout pDetalleServiciosLayout = new javax.swing.GroupLayout(pDetalleServicios);
        pDetalleServicios.setLayout(pDetalleServiciosLayout);
        pDetalleServiciosLayout.setHorizontalGroup(
            pDetalleServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        pDetalleServiciosLayout.setVerticalGroup(
            pDetalleServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );

        pButtons.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pButtonsLayout = new javax.swing.GroupLayout(pButtons);
        pButtons.setLayout(pButtonsLayout);
        pButtonsLayout.setHorizontalGroup(
            pButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonsLayout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pButtonsLayout.setVerticalGroup(
            pButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pDataBusiness.setBackground(new java.awt.Color(255, 255, 255));
        pDataBusiness.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        txtNombreEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreEmpresa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombreEmpresa.setEnabled(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descripción:");

        txtDesEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtDesEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDesEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        txtDesEmpresa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDesEmpresa.setEnabled(false);

        txtDirEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtDirEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDirEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        txtDirEmpresa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDirEmpresa.setEnabled(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dirección:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contacto:");

        txtContactoEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtContactoEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtContactoEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        txtContactoEmpresa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtContactoEmpresa.setEnabled(false);

        txtSloganEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtSloganEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSloganEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        txtSloganEmpresa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSloganEmpresa.setEnabled(false);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Eslogan:");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("IVA:");

        txtIva.setBackground(new java.awt.Color(255, 255, 255));
        txtIva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIva.setForeground(new java.awt.Color(0, 0, 0));
        txtIva.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIva.setEnabled(false);

        javax.swing.GroupLayout pDataBusinessLayout = new javax.swing.GroupLayout(pDataBusiness);
        pDataBusiness.setLayout(pDataBusinessLayout);
        pDataBusinessLayout.setHorizontalGroup(
            pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBusinessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDirEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtDesEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtContactoEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtSloganEmpresa)
                    .addComponent(txtIva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDataBusinessLayout.setVerticalGroup(
            pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBusinessLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataBusinessLayout.createSequentialGroup()
                        .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDesEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pDataBusinessLayout.createSequentialGroup()
                        .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtContactoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSloganEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDirEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pDetalleServicios1.setBackground(new java.awt.Color(255, 255, 255));
        pDetalleServicios1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 207, 229)));

        btnAgregarServicio.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarServicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAgregarServicio.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarServicio.setToolTipText("Agregar Servicio");
        btnAgregarServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarServicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarServicioActionPerformed(evt);
            }
        });

        btnRemoverServicio.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoverServicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRemoverServicio.setForeground(new java.awt.Color(0, 0, 0));
        btnRemoverServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnRemoverServicio.setToolTipText("Borrar Servicio");
        btnRemoverServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoverServicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemoverServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverServicioActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("No. Items:");

        lblNoItems.setBackground(new java.awt.Color(255, 255, 255));
        lblNoItems.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblNoItems.setForeground(new java.awt.Color(0, 0, 0));
        lblNoItems.setText("0");

        lblSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        lblSubtotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(0, 0, 0));
        lblSubtotal.setText("0.00");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Subtotal: $");

        lblIva.setBackground(new java.awt.Color(255, 255, 255));
        lblIva.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblIva.setForeground(new java.awt.Color(0, 0, 0));
        lblIva.setText("0.00");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("IVA: %");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Total: $");

        lblTotal.setBackground(new java.awt.Color(255, 255, 255));
        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setText("0.00");

        javax.swing.GroupLayout pDetalleServicios1Layout = new javax.swing.GroupLayout(pDetalleServicios1);
        pDetalleServicios1.setLayout(pDetalleServicios1Layout);
        pDetalleServicios1Layout.setHorizontalGroup(
            pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetalleServicios1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDetalleServicios1Layout.createSequentialGroup()
                        .addComponent(btnAgregarServicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoverServicio))
                    .addGroup(pDetalleServicios1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNoItems))
                    .addGroup(pDetalleServicios1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIva))
                    .addGroup(pDetalleServicios1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSubtotal))
                    .addGroup(pDetalleServicios1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pDetalleServicios1Layout.setVerticalGroup(
            pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetalleServicios1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoverServicio)
                    .addComponent(btnAgregarServicio))
                .addGap(30, 30, 30)
                .addGroup(pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblNoItems))
                .addGap(18, 18, 18)
                .addGroup(pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblSubtotal))
                .addGap(18, 18, 18)
                .addGroup(pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblIva))
                .addGap(18, 18, 18)
                .addGroup(pDetalleServicios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addComponent(pDetalleServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pDetalleServicios1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataBusiness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addComponent(pHead, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pDataBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pDetalleServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pDetalleServicios1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        NewClientForm nc = new NewClientForm();
        this.setVisible(false);
        
        nc.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setVisible(true);
                loadClientData();
            }
        });
        
        nc.setLocationRelativeTo(null);
        nc.setVisible(true);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        SearchClientForm sc = new SearchClientForm(this);
        this.setVisible(false);
        
        sc.addWindowListener(new WindowAdapter() {            
            @Override
            public void windowClosed(WindowEvent e) {
                setVisible(true);
                loadClientData();
            }
        });
        
        sc.setLocationRelativeTo(null);
        sc.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarServicioActionPerformed
        SearchServiceForm ss = new SearchServiceForm(this);
        this.setVisible(false);
        
        ss.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosed(WindowEvent e) {
                setVisible(true);
                updateItemsTabla();
            }
        });
        
        ss.setLocationRelativeTo(null);
        ss.setVisible(true);
    }//GEN-LAST:event_btnAgregarServicioActionPerformed

    private void btnRemoverServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverServicioActionPerformed
        if (tablaServicios.getRowCount() > 0) {
            
            if (tablaServicios.getSelectedRow() != -1) {
                
                int id = Integer.parseInt(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0)));
                
                if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de eliminar el registro?", "App Cotizaciones", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    
                    for (Servicio s : this.items) {
                        if (s.getId() == id) {
                            this.subtotal = this.subtotal.subtract(new BigDecimal(String.valueOf(s.getImporte())));
                            this.items.remove(s);
                            calculatePrice();
                            updateItemsTabla();
                            break;
                        }
                    }
                }
                
            } else JOptionPane.showMessageDialog(rootPane, "Favor de seleccionar un registro", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
            
        } else JOptionPane.showMessageDialog(rootPane, "No hay registros!", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnRemoverServicioActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Cliente cliente = new Cliente();
        cliente.setId(this.clientId);
        
        Cotizacion cotizacion = new Cotizacion(
            LocalDate.now(), this.subtotal.doubleValue(), this.iva.doubleValue(), this.total.doubleValue(), cliente
        );
        
        cotizacion.setServicios(this.items);
        
        if (this.clientId != null) {
            
            if (tablaServicios.getRowCount() > 0) {
                
                try {
                    this.cotizacionService.add(cotizacion);
                    
                    JOptionPane.showMessageDialog(rootPane, "Cotización agregada con exito!", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
                
            } else JOptionPane.showMessageDialog(rootPane, "Favor de agregar 1 servicio o más", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
            
        } else JOptionPane.showMessageDialog(rootPane, "Favor de seleccionar un cliente", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
        

    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnRemoverServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNoItems;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pButtons;
    private javax.swing.JPanel pCliente;
    private javax.swing.JPanel pDataBusiness;
    private javax.swing.JPanel pDetalleServicios;
    private javax.swing.JPanel pDetalleServicios1;
    private javax.swing.JPanel pHead;
    private javax.swing.JPanel pMain;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtContactoEmpresa;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtDesEmpresa;
    private javax.swing.JTextField txtDirEmpresa;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtSloganEmpresa;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
