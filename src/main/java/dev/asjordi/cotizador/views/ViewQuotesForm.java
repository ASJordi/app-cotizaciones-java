package dev.asjordi.cotizador.views;

import dev.asjordi.cotizador.models.Cotizacion;
import dev.asjordi.cotizador.models.DatosEmpresa;
import dev.asjordi.cotizador.services.CotizacionService;
import dev.asjordi.cotizador.services.DatosEmpresaService;
import dev.asjordi.cotizador.services.IService;
import dev.asjordi.cotizador.services.IServiceWithImage;
import dev.asjordi.cotizador.utils.ImageUtils;
import dev.asjordi.cotizador.utils.PrintQuotesReport;
import dev.asjordi.cotizador.utils.TableFilter;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class ViewQuotesForm extends javax.swing.JFrame {

    private final IService<Cotizacion> cotizacionService;
    private final IServiceWithImage<DatosEmpresa> empresaService;

    public ViewQuotesForm() {
        initComponents();
        this.setIconImage(ImageUtils.getIcon().getImage());
        this.cotizacionService = new CotizacionService();
        this.empresaService = new DatosEmpresaService();
        tablaCotizaciones.setAutoCreateRowSorter(true);
        loadData();
    }

    private void loadData() {
        DefaultTableModel tModel = new DefaultTableModel();
        String[] columns = {"Id", "Cliente", "Teléfono", "Correo", "Fecha", "SubTotal", "Iva", "Total"};
        tModel.setColumnIdentifiers(columns);

        try {
            List<Cotizacion> list = cotizacionService.getAll();
            if (!list.isEmpty()) {
                for (Cotizacion c : list) {
                    Object[] data = {c.getId(), c.getCliente().getNombre(), c.getCliente().getTelefono(), c.getCliente().getCorreo(), c.getFecha(), c.getSubtotal(), c.getIva(), c.getTotal()};
                    tModel.addRow(data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tablaCotizaciones.setModel(tModel);
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
        btnImprimir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pDataTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCotizaciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Cotizaciones - Ver Cotizaciones");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        pMain.setBackground(new java.awt.Color(255, 255, 255));

        pTitle.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cotizaciones");

        javax.swing.GroupLayout pTitleLayout = new javax.swing.GroupLayout(pTitle);
        pTitle.setLayout(pTitleLayout);
        pTitleLayout.setHorizontalGroup(
            pTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTitleLayout.createSequentialGroup()
                .addContainerGap(507, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(465, 465, 465))
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

        btnImprimir.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(0, 0, 0));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir cotización");
        btnImprimir.setBorder(null);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar cotización");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
                .addComponent(btnImprimir)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(27, 27, 27))
        );
        pFiltersLayout.setVerticalGroup(
            pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltersLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar)
                    .addGroup(pFiltersLayout.createSequentialGroup()
                        .addGroup(pFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFiltroBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pDataTable.setBackground(new java.awt.Color(255, 255, 255));
        pDataTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cotizaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pDataTable.setForeground(new java.awt.Color(0, 0, 0));
        pDataTable.setMaximumSize(new java.awt.Dimension(700, 124));
        pDataTable.setMinimumSize(new java.awt.Dimension(700, 124));
        pDataTable.setPreferredSize(new java.awt.Dimension(700, 124));

        tablaCotizaciones.setBackground(new java.awt.Color(255, 255, 255));
        tablaCotizaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaCotizaciones.setForeground(new java.awt.Color(0, 0, 0));
        tablaCotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Teléfono", "Correo", "Fecha", "SubTotal", "IVA", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCotizaciones);
        if (tablaCotizaciones.getColumnModel().getColumnCount() > 0) {
            tablaCotizaciones.getColumnModel().getColumn(0).setResizable(false);
        }

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(pFilters, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE))
                .addContainerGap())
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addComponent(pTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
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

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (tablaCotizaciones.getRowCount() > 0) {

            if (tablaCotizaciones.getSelectedRow() != -1) {

                int id = Integer.parseInt(String.valueOf(tablaCotizaciones.getValueAt(tablaCotizaciones.getSelectedRow(), 0)));

                try {
                    PrintQuotesReport pq = new PrintQuotesReport(id);
                    pq.print();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else JOptionPane.showMessageDialog(rootPane, "Favor de seleccionar un registro", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);

        } else JOptionPane.showMessageDialog(rootPane, "No hay registros!", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (tablaCotizaciones.getRowCount() > 0) {

            if (tablaCotizaciones.getSelectedRow() != -1) {

                int id = Integer.parseInt(String.valueOf(tablaCotizaciones.getValueAt(tablaCotizaciones.getSelectedRow(), 0)));

                if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de eliminar el registro?", "App Cotizaciones", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    try {
                        cotizacionService.delete(id);
                        JOptionPane.showMessageDialog(rootPane, "Cotización eliminada", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);

                        loadData();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

            } else JOptionPane.showMessageDialog(rootPane, "Favor de seleccionar un registro", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);

        } else JOptionPane.showMessageDialog(rootPane, "No hay registros!", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFiltroBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroBuscarKeyReleased
        TableFilter.applyFilter(tablaCotizaciones, txtFiltroBuscar);
    }//GEN-LAST:event_txtFiltroBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGroupFilter;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pDataTable;
    private javax.swing.JPanel pFilters;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pTitle;
    private javax.swing.JTable tablaCotizaciones;
    private javax.swing.JTextField txtFiltroBuscar;
    // End of variables declaration//GEN-END:variables
}
