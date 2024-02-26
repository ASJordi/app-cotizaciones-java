package dev.asjordi.cotizador.views;

import dev.asjordi.cotizador.models.Cliente;
import dev.asjordi.cotizador.services.ClienteService;
import dev.asjordi.cotizador.services.IService;
import dev.asjordi.cotizador.utils.FormIcon;
import dev.asjordi.cotizador.utils.TableFilter;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class ClientsForm extends javax.swing.JFrame {
    
    private final IService<Cliente> service;

    public ClientsForm() {
        initComponents();
        this.setIconImage(FormIcon.getIcon().getImage());
        this.service = new ClienteService();
        btnGroupFilter.clearSelection();
        txtId.setVisible(false);
        tablaClientes.setAutoCreateRowSorter(true);
        loadData();
    }
    
    private void loadData() {
        DefaultTableModel tModel = new DefaultTableModel();
        String[] columns = {"Id", "Nombre", "Teléfono", "Correo", "Dirección", "Estatus"};
        tModel.setColumnIdentifiers(columns);
        
        try {
        
            List<Cliente> list = service.getAll();
            
            if (!list.isEmpty()) {
                for (Cliente c : list) {
                    Object[] data = {c.getId(), c.getNombre(), c.getTelefono(), c.getCorreo(), c.getDireccion(), c.getEstatus() ? "Activo" : "Inactivo"};
                    tModel.addRow(data);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        tablaClientes.setModel(tModel);
    }
    
    private void clear() {
        txtFiltroBuscar.setText("");
        btnGroupFilter.clearSelection();
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        cbEstatus.setSelectedIndex(0);
        loadData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFilter = new javax.swing.ButtonGroup();
        pMain = new javax.swing.JPanel();
        pTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pFilters = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFiltroBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbActivo = new javax.swing.JRadioButton();
        rbInactivo = new javax.swing.JRadioButton();
        pDataTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        pAddCliente = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtId = new javax.swing.JLabel();
        pLogo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Cotizaciones - Clientes");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        pMain.setBackground(new java.awt.Color(255, 255, 255));

        pTitle.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aministrar Clientes");

        javax.swing.GroupLayout pTitleLayout = new javax.swing.GroupLayout(pTitle);
        pTitle.setLayout(pTitleLayout);
        pTitleLayout.setHorizontalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTitleLayout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pTitleLayout.setVerticalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pFilters.setBackground(new java.awt.Color(255, 255, 255));
        pFilters.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 207, 229)));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Filtrar por:");

        txtFiltroBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltroBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFiltroBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtFiltroBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroBuscarKeyReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Buscar:");

        rbActivo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFilter.add(rbActivo);
        rbActivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbActivo.setForeground(new java.awt.Color(0, 0, 0));
        rbActivo.setText("Activo");
        rbActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbActivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbActivoItemStateChanged(evt);
            }
        });

        rbInactivo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupFilter.add(rbInactivo);
        rbInactivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbInactivo.setForeground(new java.awt.Color(0, 0, 0));
        rbInactivo.setText("Inactivo");
        rbInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbInactivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbInactivoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pFiltersLayout = new javax.swing.GroupLayout(pFilters);
        pFilters.setLayout(pFiltersLayout);
        pFiltersLayout.setHorizontalGroup(
            pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFiltroBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(rbActivo)
                .addGap(18, 18, 18)
                .addComponent(rbInactivo)
                .addContainerGap())
        );
        pFiltersLayout.setVerticalGroup(
            pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltersLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbActivo)
                    .addComponent(rbInactivo)
                    .addComponent(jLabel3)
                    .addComponent(txtFiltroBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pDataTable.setBackground(new java.awt.Color(255, 255, 255));
        pDataTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pDataTable.setForeground(new java.awt.Color(0, 0, 0));
        pDataTable.setMaximumSize(new java.awt.Dimension(700, 124));
        pDataTable.setMinimumSize(new java.awt.Dimension(700, 124));
        pDataTable.setPreferredSize(new java.awt.Dimension(700, 124));

        tablaClientes.setBackground(new java.awt.Color(255, 255, 255));
        tablaClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaClientes.setForeground(new java.awt.Color(0, 0, 0));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Teléfono", "Correo", "Dirección", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout pDataTableLayout = new javax.swing.GroupLayout(pDataTable);
        pDataTable.setLayout(pDataTableLayout);
        pDataTableLayout.setHorizontalGroup(
            pDataTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        pDataTableLayout.setVerticalGroup(
            pDataTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        pAddCliente.setBackground(new java.awt.Color(255, 255, 255));
        pAddCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrar Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pAddCliente.setForeground(new java.awt.Color(0, 0, 0));
        pAddCliente.setMaximumSize(new java.awt.Dimension(700, 124));
        pAddCliente.setMinimumSize(new java.awt.Dimension(700, 124));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre:");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Teléfono:");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Correo:");

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Dirección:");

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Estado:");

        cbEstatus.setBackground(new java.awt.Color(255, 255, 255));
        cbEstatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEstatus.setForeground(new java.awt.Color(0, 0, 0));
        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

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

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        javax.swing.GroupLayout pAddClienteLayout = new javax.swing.GroupLayout(pAddCliente);
        pAddCliente.setLayout(pAddClienteLayout);
        pAddClienteLayout.setHorizontalGroup(
            pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pAddClienteLayout.createSequentialGroup()
                        .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(txtTelefono)
                            .addComponent(txtCorreo)))
                    .addGroup(pAddClienteLayout.createSequentialGroup()
                        .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAddClienteLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(pAddClienteLayout.createSequentialGroup()
                                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtId)
                                    .addComponent(jLabel8))
                                .addGap(32, 32, 32)))
                        .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion)
                            .addComponent(cbEstatus, 0, 360, Short.MAX_VALUE)))
                    .addGroup(pAddClienteLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pAddClienteLayout.setVerticalGroup(
            pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddClienteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(txtId))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pLogo.setBackground(new java.awt.Color(255, 255, 255));
        pLogo.setForeground(new java.awt.Color(255, 255, 255));
        pLogo.setMaximumSize(new java.awt.Dimension(120, 120));
        pLogo.setMinimumSize(new java.awt.Dimension(120, 120));

        javax.swing.GroupLayout pLogoLayout = new javax.swing.GroupLayout(pLogo);
        pLogo.setLayout(pLogoLayout);
        pLogoLayout.setHorizontalGroup(
            pLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        pLogoLayout.setVerticalGroup(
            pLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pFilters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addComponent(pDataTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 486, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                                .addComponent(pLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171)))))
                .addContainerGap())
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addComponent(pTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addComponent(pAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(pLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String direccion = txtDireccion.getText();
        boolean estatus = cbEstatus.getSelectedIndex() == 0 ? true : false;
        
        
        if (!nombre.isBlank() && !telefono.isBlank() && !correo.isBlank() && !direccion.isBlank()) {
            
            try {
                Cliente c = new Cliente();
                c.setNombre(nombre);
                c.setTelefono(telefono);
                c.setCorreo(correo);
                c.setDireccion(direccion);
                c.setEstatus(estatus);

                if (!id.isBlank()) c.setId(Integer.parseInt(id));
                
                service.add(c);
                JOptionPane.showMessageDialog(rootPane, "Cliente agregado / actualizado", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);
                
                clear();
                loadData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else JOptionPane.showMessageDialog(rootPane, "Favor de llenar todos los campos", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaClientes.getRowCount() > 0) {
            if (tablaClientes.getSelectedRow() != -1) {
                int id = Integer.parseInt(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0)));
                
                if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de eliminar el registro?", "App Cotizaciones", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        service.delete(id);
                        JOptionPane.showMessageDialog(rootPane, "Cliente eliminado", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);
                        
                        clear();
                        loadData();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                
            } else JOptionPane.showMessageDialog(rootPane, "Favor de seleccionar un registro", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(rootPane, "No hay registros!", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        if (tablaClientes.getSelectedRow() != -1) {
            txtId.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0)));
            txtNombre.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1)));
            txtTelefono.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 2)));
            txtCorreo.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 3)));
            txtDireccion.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 4)));
            cbEstatus.setSelectedIndex(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 5)).equals("Activo") ? 0 : 1);
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void txtFiltroBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroBuscarKeyReleased
        TableFilter.applyFilter(tablaClientes, txtFiltroBuscar);
    }//GEN-LAST:event_txtFiltroBuscarKeyReleased

    private void rbActivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbActivoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) TableFilter.applyFilter(tablaClientes, rbActivo, 5);
    }//GEN-LAST:event_rbActivoItemStateChanged

    private void rbInactivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbInactivoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) TableFilter.applyFilter(tablaClientes, rbInactivo, 5);
    }//GEN-LAST:event_rbInactivoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGroupFilter;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pAddCliente;
    private javax.swing.JPanel pDataTable;
    private javax.swing.JPanel pFilters;
    private javax.swing.JPanel pLogo;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTitle;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JRadioButton rbInactivo;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFiltroBuscar;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
