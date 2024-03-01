package dev.asjordi.cotizador.views;

import dev.asjordi.cotizador.models.DatosEmpresa;
import dev.asjordi.cotizador.services.DatosEmpresaService;
import dev.asjordi.cotizador.services.IServiceWithImage;
import dev.asjordi.cotizador.utils.ImageUtils;
import java.awt.Image;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class DataCompanyForm extends javax.swing.JFrame {
    
    private final IServiceWithImage<DatosEmpresa> service;

    public DataCompanyForm() {
        initComponents();
        this.setIconImage(ImageUtils.getIcon().getImage());
        this.service = new DatosEmpresaService();
        loadData();
        ImageUtils.getLogo(labelLogo);
    }
    
    private void loadData() {
        try {
            DatosEmpresa d = service.getData();
            txtNombre.setText(d.getNombre());
            txtDescripcion.setText(d.getDescripcion());
            txtDireccion.setText(d.getDireccion());
            txtContacto.setText(d.getContacto());
            txtSlogan.setText(d.getSlogan());
            txtBanco.setText(d.getBanco());
            txtTitular.setText(d.getTitular());
            txtNoCuenta.setText(d.getNoCuenta());
            txtClabe.setText(d.getClabe());
            txtObservaciones.setText(d.getObservaciones());
            txtIva.setValue(d.getIva());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Integer getIvaValue() {
        try {
        txtIva.commitEdit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return (Integer) txtIva.getValue();
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMain = new javax.swing.JPanel();
        pHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        pData = new javax.swing.JPanel();
        pDataBusiness = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        txtSlogan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pDataBank = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        txtTitular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNoCuenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtClabe = new javax.swing.JTextField();
        pDataBank1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtIva = new javax.swing.JSpinner();
        pButtons = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCargarLogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Cotizaciones - Configuración");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 800));
        setMinimumSize(new java.awt.Dimension(700, 800));
        setResizable(false);

        pMain.setBackground(new java.awt.Color(255, 255, 255));

        pHead.setBackground(new java.awt.Color(255, 255, 255));
        pHead.setMaximumSize(new java.awt.Dimension(120, 120));
        pHead.setMinimumSize(new java.awt.Dimension(120, 120));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configuración");

        labelLogo.setBackground(new java.awt.Color(255, 255, 255));
        labelLogo.setForeground(new java.awt.Color(255, 255, 255));
        labelLogo.setMaximumSize(new java.awt.Dimension(120, 120));
        labelLogo.setMinimumSize(new java.awt.Dimension(120, 120));
        labelLogo.setPreferredSize(new java.awt.Dimension(120, 120));

        javax.swing.GroupLayout pHeadLayout = new javax.swing.GroupLayout(pHead);
        pHead.setLayout(pHeadLayout);
        pHeadLayout.setHorizontalGroup(
            pHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pHeadLayout.setVerticalGroup(
            pHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34))
        );

        pData.setBackground(new java.awt.Color(255, 255, 255));

        pDataBusiness.setBackground(new java.awt.Color(255, 255, 255));
        pDataBusiness.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descripción:");

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dirección:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contacto:");

        txtContacto.setBackground(new java.awt.Color(255, 255, 255));
        txtContacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtContacto.setForeground(new java.awt.Color(0, 0, 0));

        txtSlogan.setBackground(new java.awt.Color(255, 255, 255));
        txtSlogan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSlogan.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Eslogan:");

        javax.swing.GroupLayout pDataBusinessLayout = new javax.swing.GroupLayout(pDataBusiness);
        pDataBusiness.setLayout(pDataBusinessLayout);
        pDataBusinessLayout.setHorizontalGroup(
            pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBusinessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSlogan)
                    .addComponent(txtContacto)
                    .addComponent(txtDireccion)
                    .addComponent(txtNombre)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pDataBusinessLayout.setVerticalGroup(
            pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBusinessLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataBusinessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pDataLayout = new javax.swing.GroupLayout(pData);
        pData.setLayout(pDataLayout);
        pDataLayout.setHorizontalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pDataBusiness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pDataLayout.setVerticalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataLayout.createSequentialGroup()
                .addComponent(pDataBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pDataBank.setBackground(new java.awt.Color(255, 255, 255));
        pDataBank.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Bancarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Banco:");

        txtBanco.setBackground(new java.awt.Color(255, 255, 255));
        txtBanco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBanco.setForeground(new java.awt.Color(0, 0, 0));

        txtTitular.setBackground(new java.awt.Color(255, 255, 255));
        txtTitular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTitular.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Titular:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("No. Cuenta:");

        txtNoCuenta.setBackground(new java.awt.Color(255, 255, 255));
        txtNoCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoCuenta.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CLABE:");

        txtClabe.setBackground(new java.awt.Color(255, 255, 255));
        txtClabe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtClabe.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pDataBankLayout = new javax.swing.GroupLayout(pDataBank);
        pDataBank.setLayout(pDataBankLayout);
        pDataBankLayout.setHorizontalGroup(
            pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClabe)
                    .addComponent(txtNoCuenta)
                    .addComponent(txtBanco)
                    .addComponent(txtTitular, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pDataBankLayout.setVerticalGroup(
            pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBankLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtClabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pDataBank1.setBackground(new java.awt.Color(255, 255, 255));
        pDataBank1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Observaciones:");

        txtObservaciones.setBackground(new java.awt.Color(255, 255, 255));
        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtObservaciones.setForeground(new java.awt.Color(0, 0, 0));
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("% IVA");

        txtIva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIva.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        txtIva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pDataBank1Layout = new javax.swing.GroupLayout(pDataBank1);
        pDataBank1.setLayout(pDataBank1Layout);
        pDataBank1Layout.setHorizontalGroup(
            pDataBank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBank1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataBank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(pDataBank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(txtIva))
                .addContainerGap())
        );
        pDataBank1Layout.setVerticalGroup(
            pDataBank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBank1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataBank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pDataBank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataBank1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13))
                    .addGroup(pDataBank1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
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

        btnCargarLogo.setBackground(new java.awt.Color(255, 255, 255));
        btnCargarLogo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCargarLogo.setForeground(new java.awt.Color(0, 0, 0));
        btnCargarLogo.setText("Seleccionar Logo");
        btnCargarLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pButtonsLayout = new javax.swing.GroupLayout(pButtons);
        pButtons.setLayout(pButtonsLayout);
        pButtonsLayout.setHorizontalGroup(
            pButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonsLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnGuardar)
                .addGap(83, 83, 83)
                .addComponent(btnCargarLogo)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        pButtonsLayout.setVerticalGroup(
            pButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pButtonsLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(pButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCargarLogo))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataBank1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addComponent(pHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDataBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDataBank1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnCargarLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarLogoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.png", "png");
        fc.setFileFilter(filter);
        int selection = fc.showOpenDialog(this);
        
        if (selection == JFileChooser.APPROVE_OPTION) {
            try {

                FileInputStream fis = new FileInputStream(fc.getSelectedFile());
                int len = (int) fc.getSelectedFile().length();
                
                Image icono = ImageIO.read(fc.getSelectedFile()).getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT);
                labelLogo.setIcon(new ImageIcon(icono));
                labelLogo.updateUI();

                service.updateImage(fis, len);
                JOptionPane.showMessageDialog(rootPane, "Logo actualizado", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnCargarLogoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txtNombre.getText();
        String descripcion = txtDescripcion.getText();
        String direccion = txtDireccion.getText();
        String contacto = txtContacto.getText();
        String slogan = txtSlogan.getText();
        String banco = txtBanco.getText();
        String titular = txtTitular.getText();
        String noCuenta = txtNoCuenta.getText();
        String clabe = txtClabe.getText();
        String observaciones = txtObservaciones.getText();
        int iva = getIvaValue();
        
        if (!nombre.isBlank() && !descripcion.isBlank() && !direccion.isBlank() && !contacto.isBlank() && !slogan.isBlank() && !banco.isBlank() && !titular.isBlank() && !noCuenta.isBlank() && !clabe.isBlank() && !observaciones.isBlank()) {
            
            try {
                DatosEmpresa de = new DatosEmpresa();
                de.setId(1);
                de.setNombre(nombre);
                de.setDescripcion(descripcion);
                de.setDireccion(direccion);
                de.setContacto(contacto);
                de.setSlogan(slogan);
                de.setBanco(banco);
                de.setTitular(titular);
                de.setNoCuenta(noCuenta);
                de.setClabe(clabe);
                de.setObservaciones(observaciones);
                de.setIva(iva);

                service.updateData(de);
                JOptionPane.showMessageDialog(rootPane, "Datos actualizados!", "App Cotizaciones", JOptionPane.INFORMATION_MESSAGE);
                loadData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else JOptionPane.showMessageDialog(rootPane, "Favor de llenar todos los campos", "App Cotizaciones", JOptionPane.ERROR_MESSAGE);  
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarLogo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel pButtons;
    private javax.swing.JPanel pData;
    private javax.swing.JPanel pDataBank;
    private javax.swing.JPanel pDataBank1;
    private javax.swing.JPanel pDataBusiness;
    private javax.swing.JPanel pHead;
    private javax.swing.JPanel pMain;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtClabe;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JSpinner txtIva;
    private javax.swing.JTextField txtNoCuenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtSlogan;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
