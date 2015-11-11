/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Diseno;
import Login.Entidad.Indexitem;
import Login.Entidad.Instalacion;
import Login.Entidad.Items;
import Login.Entidad.Login;
import Login.Entidad.Proveedores;
import Login.Entidad.Proyectos;
import Login.servicio.Funcion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Login.servicio.ServiceHb;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Random;
import javax.swing.JFileChooser;

/**
 *
 * @author Angelmath
 */
public final class bodegamateriales extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    Items ite=null;
    int toca;
    String nombre;
    Instalacion in;
    List<Diseno> dis;
    List<Proyectos> rep;
    String direccion;
    Login user;
    /**
     * Creates new form ingresoU
     */
    public bodegamateriales(java.awt.Frame parent, marco padre, boolean modal, int item, Login Usuario) {
        super(parent,modal);
        initComponents();
        this.padre=padre;
        this.user= Usuario;
        setLocationRelativeTo(null);
        try {
            ServiceHb neo = new ServiceHb();
            neo.iniciarTransaccion();
            if(item==0){
                jTextField10.setVisible(false);
                jButton2.setVisible(false);
                jLabel14.setVisible(false);
            }else{
                ite= (Items)neo.obtenerObjeto(Items.class, item);
                jTextField10.setVisible(true);
                jButton2.setVisible(true);
                jLabel14.setVisible(true);
            }
            List<Proveedores> p = neo.getlistaProveedores();
            List<Indexitem> list = neo.getListaIndexitem();
            neo.confirmarTransaccion();
            neo.cerrarTransaccion();
            neo.cerrarSesion();
            
            jComboBox1.removeAllItems();
            jComboBox2.removeAllItems();
            jComboBox3.removeAllItems();
            for(Indexitem i: list){
                jComboBox2.addItem(i.getTipo());
            }
            for(Proveedores i: p){
                jComboBox1.addItem(i.getRazon());
                jComboBox3.addItem(i.getId());
            }
            if(ite!=null){
                jComboBox2.setSelectedItem(ite.getCat());
                jTextField3.setText(ite.getMarca());
                jTextField4.setText(ite.getModelo());
                jTextField5.setText(ite.getCodigo());
                jComboBox1.setSelectedItem(ite.getProveedor());
                jTextArea1.setText(ite.getDc());
                jTextArea2.setText(ite.getDl());
                jTextField8.setText(ite.getCosto());
                jTextField10.setText(ite.getFt());
                pvp.setText(ite.getOtro1());
                jTextField2.setText(Funcion.DateFormat(ite.getFecha()));
            }else{
                Date d = new Date();
                jTextField2.setText(Funcion.DateFormat(d));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(bodegamateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
    }
    
    public List<Diseno> getDis() {
        return dis;
    }
    
    public void setDis(List<Diseno> dis) {
        this.dis = dis;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public JLabel getjLabel10() {
        return jLabel10;
    }
    
    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }
    
    public JLabel getjLabel11() {
        return jLabel11;
    }
    
    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }
    
    public JLabel getjLabel12() {
        return jLabel12;
    }
    
    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }
    
    public JLabel getjLabel13() {
        return jLabel13;
    }
    
    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }
    
    public JTextField getjTextField8() {
        return jTextField8;
    }
    
    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }
    
    public List<Proyectos> getRep() {
        return rep;
    }
    
    public void setRep(List<Proyectos> rep) {
        this.rep = rep;
    }
    
    public marco getPadre() {
        return padre;
    }
    
    public void setPadre(marco padre) {
        this.padre = padre;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pvp = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(500, 400));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel11.setText("jLabel8");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel11.setOpaque(true);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-salir.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Roboto Medium", 3, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ITEMS");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel3.setText("CAT.:");

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("Codigo:");

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel5.setText("Proveedor:");

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel6.setText("Modelo:");

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel9.setText("DC:");

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel10.setText("DL:");

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel12.setText("Valor Fijo:");

        jTextField8.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel13.setText("Fecha:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCTV IP: Camaras", "CCTV IP: Almacenamiento", "CCTV Analogo: Camaras", "CCTV Analogo: Almacenamiento", "CCTV: Adicionales", "CCTV: Varios", "Control de Acceso / Asistencia", "Sistema de Alarmas", "Seguridad Perimetral", "Networking", "Estanteria", "Equipos Electricos", "Cables", "Ducteria", "Servicios", "Monitores", "Computo", "Software", "Instalacion" }));

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel14.setText("FT:");

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTextField1.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel15.setText("Imagen:");

        jTextField2.setEditable(false);

        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel7.setText("Marca:");

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel16.setText("Costo:");

        pvp.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        pvp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pvp, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pvp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel11.setVisible(false);
        jComboBox3.setVisible(false);
        jTextField1.setVisible(false);
        jButton3.setVisible(false);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked
    public void alt (Component bt, String text){
        
    } 
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(ite!=null){
                
            }else{
                ite = new Items();
            }
            ite.setCat(jComboBox2.getSelectedItem().toString());
            ite.setCodigo(jTextField5.getText());
            ite.setMarca(jTextField3.getText());
            ite.setModelo(jTextField4.getText());
            ite.setProveedor(jComboBox1.getSelectedItem().toString());
            ite.setIdproveedor(jComboBox3.getItemAt(jComboBox1.getSelectedIndex()).toString());
            ite.setDc(jTextArea1.getText());
            ite.setDl(jTextArea2.getText());
            ite.setCosto(jTextField8.getText());
            ite.setFt(jTextField10.getText());
            if(pvp.getText().isEmpty()){
                ite.setOtro1(null);
            }else{
                ite.setOtro1(pvp.getText());
            }
            ite.setFecha(new java.sql.Date(Funcion.StringToDate(jTextField2.getText()).getTime()));
            
            helper.crearOrActualizarObjeto(ite);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        JOptionPane.showMessageDialog(null, "Listo");
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked
    
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        alt(jButton1,"Aceptar");
    }//GEN-LAST:event_jButton1MouseEntered
    
    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered
    
    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited
    
    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
        && (caracter !='.')){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        JFileChooser chooser = new JFileChooser();
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        List<Diseno> list3;
        String fin="";
        int valido=0;
        try{
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();      
        int respuesta = chooser.showOpenDialog(this);
        
        //Comprobar si se ha pulsado Aceptar
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
        File archivoEntrada = chooser.getSelectedFile();
        File archivoSalida = new File(user.getDireccion()+"\\ficha_items\\"+ite.getId()+".pdf"); 
        fin="\\ficha_items\\"+ite.getId()+".pdf";
        if(!archivoSalida.exists()) { 

        archivoSalida.createNewFile(); 

        } 



       FileChannel source = null; 

       FileChannel destination = null; 

       try { 

        source = new FileInputStream(archivoEntrada).getChannel(); 

        destination = new FileOutputStream(archivoSalida).getChannel(); 

        destination.transferFrom(source, 0, source.size()); 

       } 

       finally { 

        if(source != null) { 

         source.close(); 

        } 

        if(destination != null) { 

         destination.close(); 

        } 

       }
       }
        helper.cerrarSesion();
        jTextField10.setText(fin);
    }catch(Exception io){
        JOptionPane.showConfirmDialog(null, "Sistema no puede de Leer PDF... ", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        jTextField5.setText(generarcodigo());
    }//GEN-LAST:event_jButton5MouseClicked
    
    public String generarcodigo(){
        String cat= jComboBox2.getSelectedItem().toString();
        
        String marca1 ="";
        String marca2 ="";
        String modelo="";
        if(jTextField3.getText().isEmpty()){
        }else{
            marca1 =""+jTextField3.getText().charAt(0);
            marca1=marca1.toUpperCase();
            marca2 =""+jTextField3.getText().charAt(jTextField3.getText().length()-1);
            marca2=marca2.toUpperCase();
        }
        if(jTextField4.getText().isEmpty()){
        }else{
            modelo =""+jTextField4.getText().charAt(jTextField4.getText().length()-3)+jTextField4.getText().charAt(jTextField4.getText().length()-2)+jTextField4.getText().charAt(jTextField4.getText().length()-1); 
            modelo=modelo.toUpperCase();
        }
        String rand = getCadenaAlfanumAleatoria(2);
        String result="";
        if(cat.indexOf("CCTV")!=-1){
            if(cat.indexOf("Analogo")!=-1){
                if(cat.indexOf("Almacenamiento")!=-1){
                result="SECA2CA"+marca1+marca2+rand+modelo;
                }
                if(cat.indexOf("Camaras")!=-1){
                result="SECA1CA"+marca1+marca2+rand+modelo;
                }
                return result;
            }
            else if(cat.indexOf("IP")!=-1){
                if(cat.indexOf("Almacenamiento")!=-1){
                result="SECI2CA"+marca1+marca2+rand+modelo;
                }
                if(cat.indexOf("Camaras")!=-1){
                result="SECI1CA"+marca1+marca2+rand+modelo;
                }
                return result;
            }else{
                result="SECVCA"+marca1+marca2+rand+modelo;
                return result;
            }
        }
        return "";
    }
    
    public String getCadenaAlfanumAleatoria (int longitud){
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while ( i < longitud){
        char c = (char)r.nextInt(255);
        if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
        cadenaAleatoria += c;
        i ++;
        }
        }
        return cadenaAleatoria;
    }
    
    public instalacion getEmpl() {
        return empl;
    }
    
    public void setEmpl(instalacion empl) {
        this.empl = empl;
    }
    
    public int getToca() {
        return toca;
    }
    
    public void setToca(int toca) {
        this.toca = toca;
    }
    
    public Instalacion getIn() {
        return in;
    }
    
    public void setIn(Instalacion in) {
        this.in = in;
    }
    
    public JButton getjButton1() {
        return jButton1;
    }
    
    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }
    
    public JButton getjButton4() {
        return jButton4;
    }
    
    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }
    
    public JLabel getjLabel2() {
        return jLabel22;
    }
    
    public void setjLabel2(JLabel jLabel2) {
        this.jLabel22 = jLabel2;
    }
    
    public JLabel getjLabel3() {
        return jLabel3;
    }
    
    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }
    
    public JLabel getjLabel4() {
        return jLabel4;
    }
    
    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }
    
    public JLabel getjLabel5() {
        return jLabel5;
    }
    
    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }
    
    public JLabel getjLabel6() {
        return jLabel6;
    }
    
    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }
    
    public JLabel getjLabel9() {
        return jLabel9;
    }
    
    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }
    
    
    public JTextField getjTextField3() {
        return jTextField3;
    }
    
    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }
    
    public JTextField getjTextField4() {
        return jTextField4;
    }
    
    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bodegamateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bodegamateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bodegamateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bodegamateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField pvp;
    // End of variables declaration//GEN-END:variables
}

