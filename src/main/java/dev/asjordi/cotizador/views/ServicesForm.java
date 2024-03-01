package dev.asjordi.cotizador.views;

import dev.asjordi.cotizador.models.Servicio;
import dev.asjordi.cotizador.services.IService;
import dev.asjordi.cotizador.services.ServicioService;
import dev.asjordi.cotizador.utils.ImageUtils;
import dev.asjordi.cotizador.utils.FormatNumber;
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
public class ServicesForm extends javax.swing.JFrame {
    
    private final IService<Servicio> service;

    public ServicesForm() {
        initComponents();
        this.setIconImage(ImageUtils.getIcon().getImage());
        this.service = new ServicioService();
        btnGroupFilter.clearSelection();
        txtId.setVisible(false);
        tablaServicios.setAutoCreateRowSorter(true);
        loadData();
    }
    
    private void loadData() {
        DefaultTableModel tModel = new DefaultTableModel();
        String[] columns = {"Id", "Descripción", "Importe", "Estatus"};
        tModel.setColumnIdentifiers(columns);
        
        try {
            List<Servicio> list = service.getAll();
            if (!list.isEmpty()) {
                for (Servicio s : list) {
                    Object[] data = {s.getId(), s.getDescripcion(), s.getImporte(), s.getEstatus() ? "Activo" : "Inactivo"};
                    tModel.addRow(data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        tablaServicios.setModel(tModel);
    }
    
    private void clear() {
        txtFiltroBuscar.setText("");
        txtDescripcion.setText("");
        txtImporte.setText("");
        txtId.setText("");
        cbEstatus.setSelectedIndex(0);
        btnGroupFilter.clearSelection();
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
        tablaServicios = new javax.swing.JTable();
        pAddCliente = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        pLogo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Cotizaciones - Servicios | Productos");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        pMain.setBackground(new java.awt.Color(255, 255, 255));

        pTitle.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aministración Servicios - Productos");

        javax.swing.GroupLayout pTitleLayout = new javax.swing.GroupLayout(pTitle);
        pTitle.setLayout(pTitleLayout);
        pTitleLayout.setHorizontalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(267, 267, 267))
        );
        pTitleLayout.setVerticalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pFilters.setBackground(new java.awt.Color(255, 255, 255));
        pFilters.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 207, 229)));
        pFilters.setPreferredSize(new java.awt.Dimension(784, 47));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
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
        pDataTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Servicios | Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pDataTable.setForeground(new java.awt.Color(0, 0, 0));
        pDataTable.setMaximumSize(new java.awt.Dimension(700, 124));
        pDataTable.setMinimumSize(new java.awt.Dimension(700, 124));
        pDataTable.setPreferredSize(new java.awt.Dimension(700, 124));

        tablaServicios.setBackground(new java.awt.Color(255, 255, 255));
        tablaServicios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaServicios.setForeground(new java.awt.Color(0, 0, 0));
        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Descripción", "Importe", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServicios);

        javax.swing.GroupLayout pDataTableLayout = new javax.swing.GroupLayout(pDataTable);
        pDataTable.setLayout(pDataTableLayout);
        pDataTableLayout.setHorizontalGroup(
            pDataTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        pDataTableLayout.setVerticalGroup(
            pDataTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        pAddCliente.setBackground(new java.awt.Color(255, 255, 255));
        pAddCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pAddCliente.setForeground(new java.awt.Color(0, 0, 0));
        pAddCliente.setMaximumSize(new java.awt.Dimension(700, 124));
        pAddCliente.setMinimumSize(new java.awt.Dimension(700, 124));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Descripción:");

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Importe:");

        txtImporte.setBackground(new java.awt.Color(255, 255, 255));
        txtImporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtImporte.setForeground(new java.awt.Color(0, 0, 0));

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
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAddClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pAddClienteLayout.createSequentialGroup()
                                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtImporte)
                                    .addComponent(txtDescripcion)
                                    .addComponent(cbEstatus, 0, 347, Short.MAX_VALUE)))
                            .addGroup(pAddClienteLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar))))
                    .addGroup(pAddClienteLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pAddClienteLayout.setVerticalGroup(
            pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddClienteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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
            .addGap(0, 123, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addComponent(pDataTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pMainLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(pLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE))))
                    .addComponent(pFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 1179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addComponent(pTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addComponent(pAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(pLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(127, 127, 127))))
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
        String desc = txtDescripcion.getText();
        String importe = txtImporte.getText();
        boolean estatus = cbEstatus.getSelectedIndex() == 0 ? true : false;
        
        if (!desc.isBlank() && !importe.isBlank()) {
            
            try {
                
                Servicio s = new Servicio();
                s.setDescripcion(desc);
                s.setImporte(FormatNumber.roundTo2DecimalPlaces(Double.parseDouble(importe)));
                s.setEstatus(estatus);
                
                if (!id.isBlank()) s.setId(Integer.parseInt(id));
                
                service.add(s);
                JOptionPane.showMessageDialog(rootPane, "Servicio agregado / actualizado", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);
                
                clear();
                loadData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        } else JOptionPane.showMessageDialog(rootPane, "Favor de llenar todos los campos", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if (tablaServicios.getRowCount() > 0) {
            
            if (tablaServicios.getSelectedRow() != -1) {
                
                int id = Integer.parseInt(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0)));
                
                if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de eliminar el registro?", "App Cotizaciones", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    
                    try {
                        service.delete(id);
                        JOptionPane.showMessageDialog(rootPane, "Servicio eliminado", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);
                        
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

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
        if (tablaServicios.getSelectedRow() != -1) {
            txtId.setText(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0)));
            txtDescripcion.setText(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 1)));
            txtImporte.setText(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 2)));
            cbEstatus.setSelectedIndex(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 3)).equals("Activo") ? 0 : 1);
        }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void txtFiltroBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroBuscarKeyReleased
        TableFilter.applyFilter(tablaServicios, txtFiltroBuscar);
    }//GEN-LAST:event_txtFiltroBuscarKeyReleased

    private void rbActivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbActivoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) TableFilter.applyFilter(tablaServicios, rbActivo, 3);
    }//GEN-LAST:event_rbActivoItemStateChanged

    private void rbInactivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbInactivoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) TableFilter.applyFilter(tablaServicios, rbInactivo, 3);
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
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFiltroBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImporte;
    // End of variables declaration//GEN-END:variables
}
