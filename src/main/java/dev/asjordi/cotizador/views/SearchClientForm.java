package dev.asjordi.cotizador.views;

import dev.asjordi.cotizador.models.Cliente;
import dev.asjordi.cotizador.services.ClienteService;
import dev.asjordi.cotizador.services.IService;
import dev.asjordi.cotizador.utils.FormIcon;
import dev.asjordi.cotizador.utils.TableFilter;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class SearchClientForm extends javax.swing.JFrame {
    
    private IService service;

    public SearchClientForm() {
        initComponents();
        this.setIconImage(FormIcon.getIcon().getImage());
        this.service = new ClienteService();
        tablaClientes.setAutoCreateRowSorter(true);
        tablaClientes.setDefaultEditor(Object.class, null);
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
        tablaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Cotizaciones - Buscar Cliente");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 450));
        setMinimumSize(new java.awt.Dimension(600, 450));
        setResizable(false);

        pMain.setBackground(new java.awt.Color(255, 255, 255));
        pMain.setMaximumSize(null);

        pTitle.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar Cliente");

        javax.swing.GroupLayout pTitleLayout = new javax.swing.GroupLayout(pTitle);
        pTitle.setLayout(pTitleLayout);
        pTitleLayout.setHorizontalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTitleLayout.createSequentialGroup()
                .addGap(164, 164, 164)
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
                .addContainerGap(76, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1)
        );
        pDataTableLayout.setVerticalGroup(
            pDataTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
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
                    .addComponent(pDataTable, javax.swing.GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addComponent(pTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
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
        TableFilter.applyFilter(tablaClientes, txtFiltroBuscar);
    }//GEN-LAST:event_txtFiltroBuscarKeyReleased

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        if (evt.getClickCount() == 2 && tablaClientes.getSelectedRow() != -1) {
            int id = Integer.parseInt(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0)));
            AddQuoteForm.setClientId(id);
            this.dispose();
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pDataTable;
    private javax.swing.JPanel pFilters;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTitle;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtFiltroBuscar;
    // End of variables declaration//GEN-END:variables
}
