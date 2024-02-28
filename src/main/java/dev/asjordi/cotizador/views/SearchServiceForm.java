package dev.asjordi.cotizador.views;

import dev.asjordi.cotizador.models.Servicio;
import dev.asjordi.cotizador.services.IService;
import dev.asjordi.cotizador.services.ServicioService;
import dev.asjordi.cotizador.utils.FormIcon;
import dev.asjordi.cotizador.utils.TableFilter;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class SearchServiceForm extends javax.swing.JFrame {
    
    private final IService<Servicio> service;
    private AddQuoteForm aq;

    public SearchServiceForm(AddQuoteForm aq) {
        initComponents();
        this.setIconImage(FormIcon.getIcon().getImage());
        this.service = new ServicioService();
        tablaServicios.setAutoCreateRowSorter(true);
        tablaServicios.setDefaultEditor(Object.class, null);
        loadData();
        this.aq = aq;
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFilter = new javax.swing.ButtonGroup();
        pMain = new javax.swing.JPanel();
        pTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pFilters = new javax.swing.JPanel();
        txtFiltroBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pDataTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Cotizaciones - Buscar Servicio | Producto");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        pMain.setBackground(new java.awt.Color(255, 255, 255));

        pTitle.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar Servicio - Producto");

        javax.swing.GroupLayout pTitleLayout = new javax.swing.GroupLayout(pTitle);
        pTitle.setLayout(pTitleLayout);
        pTitleLayout.setHorizontalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTitleLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1)
                .addContainerGap(112, Short.MAX_VALUE))
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

        javax.swing.GroupLayout pFiltersLayout = new javax.swing.GroupLayout(pFilters);
        pFilters.setLayout(pFiltersLayout);
        pFiltersLayout.setHorizontalGroup(
            pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFiltroBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pFiltersLayout.setVerticalGroup(
            pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltersLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(jScrollPane1)
        );
        pDataTableLayout.setVerticalGroup(
            pDataTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pFilters, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addComponent(pDataTable, javax.swing.GroupLayout.PREFERRED_SIZE, 688, Short.MAX_VALUE))
                .addContainerGap())
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addComponent(pTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
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

    private void txtFiltroBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroBuscarKeyReleased
        TableFilter.applyFilter(tablaServicios, txtFiltroBuscar);
    }//GEN-LAST:event_txtFiltroBuscarKeyReleased

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
        if (evt.getClickCount() == 2 && tablaServicios.getSelectedRow() != -1) {
            
            int id = Integer.parseInt(String.valueOf(tablaServicios.getValueAt(tablaServicios.getSelectedRow(), 0)));
            
            try {
                Servicio s = service.getById(id);
                aq.addServicio(s);
                this.dispose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pDataTable;
    private javax.swing.JPanel pFilters;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTitle;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtFiltroBuscar;
    // End of variables declaration//GEN-END:variables
}
