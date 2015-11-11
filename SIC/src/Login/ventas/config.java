/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Notificaciones;
import Login.Entidad.Login;
import Login.Entidad.Permisos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Login.servicio.ServiceHb;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author homemig
 */

public class config extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    int numero;
    int xx;
    int yy;
    int sortColumn;
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    DefaultTableModel base;
    int[] row;
    Login usuario;
    boolean configuracion=false;
    
    public config(final Login log) {
        initComponents();
        
        this.usuario=log;
        setSize(d.width, d.height-1);
        jLabel13.setSize(d.width,58);
        jLabel16.setLocation((d.width)-(jLabel16.getWidth()), jLabel16.getY());
        jLabel15.setLocation((d.width)-(jLabel15.getWidth()), jLabel15.getY());
        jLabel15.setText(log.getNombre());
        jLabel17.setLocation((d.width)-(jLabel17.getWidth()), jLabel17.getY());
        jLabel18.setLocation((d.width)-(jLabel18.getWidth()), jLabel18.getY());
        jLabel5.setSize(d.width, jLabel5.getHeight());
        jLabel1.setSize(d.width, jLabel1.getHeight());
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        List<Permisos> permisos =null;
        try{
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        permisos = helper.getlistaPermisos(log);
        if(log.getNivel().equalsIgnoreCase("Administrador")){
            jComboBox1.setVisible(true);
            jComboBox2.setVisible(true);
            jButton1.setVisible(true);
           
                List<Login> l = helper.getLogin();
                List<Permisos> p = helper.getPermisos();
                
                
                jComboBox1.removeAllItems();
                jComboBox2.removeAllItems();
                for(Login i: l){
                    jComboBox1.addItem(i.getNombre());
                }
                for(Permisos i: p){
                    jComboBox2.addItem(i.getAcceso());
                }
            
        }else{
            jComboBox1.setVisible(false);
            jComboBox2.setVisible(false);
            jButton1.setVisible(false);
        }
        helper.cerrarSesion();
        }catch(Exception io){
            
        }
        
        DefaultTableModel temp2 = (DefaultTableModel) getjTable1().getModel();
        for(int i=temp2.getRowCount()-1;i>=0;i--){
           temp2.removeRow(i);
        }
        if(permisos!=null){
            for(int i=0; i<permisos.size();i++){
                if(getjTable1().getRowCount()< permisos.size()){
                    DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
                    Object nuevo[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo);
                }
                getjTable1().getModel().setValueAt(permisos.get(i).getAcceso(), i, 0);
            }
        }
        
        jTextField1.setText(log.getPass());      //contraseña
        jTextField2.setText(log.getDireccion());      //ventas
        jTextField3.setText(log.getCi());      //cedula
        jTextField4.setText(log.getUsuario());      //usuario
        jTextField5.setText(log.getNombre());     //nombre empleado   
        jTextField6.setText(log.getDireccionrrhh());      //rrhh
        jTextField7.setText(log.getDescargas());      //descargas
                
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas - Cajamarca");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(450, 500));
        getContentPane().setLayout(null);

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 74, 151));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-lightblue.png"))); // NOI18N
        jLabel15.setText("     Jan Topic");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        getContentPane().add(jLabel15);
        jLabel15.setBounds(1150, 0, 172, 58);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-lightblue.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(1150, 61, 172, 38);
        jLabel17.setVisible(false);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
        jLabel16.setText("jLabel16");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        getContentPane().add(jLabel16);
        jLabel16.setBounds(1150, 100, 172, 38);
        jLabel16.setVisible(false);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
        jLabel18.setText("jLabel16");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        getContentPane().add(jLabel18);
        jLabel18.setBounds(1150, 140, 172, 38);
        jLabel18.setVisible(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/icono-ventas-TEXTO.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 12, 159, 34);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 58, 1320, 3);

        jLabel13.setBackground(new java.awt.Color(234, 234, 234));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/barra-superior.png"))); // NOI18N
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 0, 1360, 58);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel2.setText("Direccion Owncloud Ventas:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(560, 110, 150, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(210, 380, 260, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel3.setText("Constraseña:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 380, 130, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel4.setText("CI:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 200, 130, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel6.setText("Usuario:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 290, 130, 30);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(710, 110, 260, 30);

        jTextField3.setEditable(false);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(210, 200, 260, 30);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(210, 290, 260, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel7.setText("Empleado:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 110, 130, 30);

        jTextField5.setEditable(false);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(210, 110, 260, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel10.setText("Direccion Owncloud RRHH:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(560, 200, 150, 30);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(710, 200, 260, 30);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel11.setText("Descarga de Archivos:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(560, 290, 150, 30);

        jTextField7.setEditable(false);
        jTextField7.setEnabled(false);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(710, 290, 260, 30);

        jLabel12.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Datos de Acceso SIC");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 30, 330, 40);

        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(710, 30, 260, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Permisos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(560, 380, 220, 150);

        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(810, 380, 160, 30);
        jPanel1.add(jButton1);
        jButton1.setBounds(980, 380, 40, 30);

        jLabel8.setBackground(new java.awt.Color(51, 51, 255));
        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Guardar");
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(300, 30, 140, 40);

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(980, 290, 40, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 90, 1110, 550);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setSize(d.width, d.height);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/fondo SIC.jpg"))); // NOI18N
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1330, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    public class MyScrollbarUI extends BasicScrollBarUI {

       private java.awt.Image imageThumb, imageTrack;
        private JButton b = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }

        };

        MyScrollbarUI() {
            imageThumb = FauxImage.create(32, 32, new Color(212,208,200));
            imageTrack = FauxImage.create(32, 32, Color.GRAY);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, java.awt.Rectangle r) {
            g.setColor(Color.blue);
            ((Graphics2D) g).drawImage(imageThumb,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, java.awt.Rectangle r) {
            ((Graphics2D) g).drawImage(imageTrack,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return b;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return b;
        }
    }
    
    private static class FauxImage {

        static public java.awt.Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getXx() {
        return xx;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public int getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(int sortColumn) {
        this.sortColumn = sortColumn;
    }

    public DefaultTableModel getBase() {
        return base;
    }

    public void setBase(DefaultTableModel base) {
        this.base = base;
    }

    public int[] getRow() {
        return row;
    }

    public void setRow(int[] row) {
        this.row = row;
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public boolean isConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(boolean configuracion) {
        this.configuracion = configuracion;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        configuracion= !configuracion;
        getjLabel16().setVisible(configuracion);
        getjLabel17().setVisible(configuracion);
        getjLabel18().setVisible(configuracion);
        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-arriba-blue.png"))); // NOI18N
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-blue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered

        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-arriba-blue.png"))); // NOI18N
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-blue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited

        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-arriba-lightblue.png"))); // NOI18
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        permisos permisos = new permisos(usuario);
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            //usuario= helper.getLogin(jTextField3.getText());
            if(jTextField7.getText().equalsIgnoreCase("")){
                usuario.setDescargas(null);
            }else{
                usuario.setDescargas(jTextField7.getText());
            }
            
            if(jTextField3.getText().equalsIgnoreCase("")){
                usuario.setCi(null);
            }else{
                usuario.setCi(jTextField3.getText());
            }
            
            if(jTextField1.getText().equalsIgnoreCase("")){
                usuario.setPass(null);
            }else{
                usuario.setPass(jTextField1.getText());
            }
            
            if(jTextField2.getText().equalsIgnoreCase("")){
                usuario.setDireccion(null);
            }else{
                usuario.setDireccion(jTextField2.getText());
            }
            
            if(jTextField6.getText().equalsIgnoreCase("")){
                usuario.setDireccionrrhh(null);
            }else{
                usuario.setDireccionrrhh(jTextField6.getText());
            }
            
            if(jTextField4.getText().equalsIgnoreCase("")){
                usuario.setUsuario(null);
            }else{
                usuario.setUsuario(jTextField4.getText());
            }
            
            if(jTextField5.getText().equalsIgnoreCase("")){
                usuario.setNombre(null);
            }else{
                usuario.setNombre(jTextField5.getText());
            }
            
            helper.actualizarObjeto(usuario);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(this, "Usuario Editado");
        }catch(Exception io){
            JOptionPane.showMessageDialog(this, "Error en Usuario");
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        int respuesta = chooser.showOpenDialog(this);
        //Comprobar si se ha pulsado Aceptar
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
        String cadena= chooser.getSelectedFile().getAbsolutePath();
        jTextField7.setText(cadena+"\\");
        }else{
        
        }
    }//GEN-LAST:event_jButton2MouseClicked
   
      
    private void logeo(){
        List<Login> usuario=null;
        String password="";
        String user="";
        ServiceHb helper = new ServiceHb();
        try {
            helper.iniciarTransaccion();
            usuario=helper.getlistaUsuarios();
            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Login i: usuario){
            if(i.getUsuario().equalsIgnoreCase(user)&&i.getPass().equalsIgnoreCase(password)){
                
                new permisos(i).setVisible(true);
                dispose();
            }
        }
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
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
            java.util.logging.Logger.getLogger(config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new config(null).setVisible(true);
            }
        });
    }
    protected int compare(int i, int j) {
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        return s1.compareTo(s2);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
