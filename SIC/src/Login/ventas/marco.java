package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Ctepagar;
import Login.Entidad.Diseno;
import Login.Entidad.Estatico;
import Login.Entidad.Factu;
import Login.Entidad.Instalacion;
import Login.Entidad.Listamateriales;
import Login.Entidad.Login;
import Login.Entidad.Materiales;
import Login.Entidad.Notas;
import Login.Entidad.Notificaciones;
import Login.Entidad.Orden;
import Login.Entidad.Productos;
import Login.Entidad.Proveedores;
import Login.Entidad.Proyectos;
import Login.Entidad.Report;
import Login.Entidad.Ticket;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import Login.servicio.ServiceHb;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.sun.pdfview.PDFFile;
import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.text.DateFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.*;
import rrhh.servicio.Funcion;

/**
 *
 * @author Matheus Puero
 */

public final class marco extends javax.swing.JFrame {
    int terminar=0;
    cliente cl;
    int breakhilo=0;
    Instalacion backinst;
    clientes2 cls2;
    reportes rp;
    facturacion fc;
    instalacion inst;
    contable cont;
    pyl py;
    configuracion pf;
    Login Usuario;
    ventas vt;
    materiales ma;
    JTable tableSorted;
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int pdfcarga;
    int xx;
    int yy;
    int sortColumn;
    int[] row;
    String responsable;
    String insta;
    String prof;
    String cliente;
    String cli;
    Runnable idn3;
    Runnable idn1;
    Runnable idn2;
    DefaultTableModel base;
    boolean regreso=false;
    boolean configuracion=false; // Controla el boton de cerrar secion y configuracion
    calendarpanel cp;
    

    public void changenombre(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Clientes> ltcl = helper.getlistaClientes();

            if(ltcl!=null){
                for(Clientes i: ltcl){
                    i.setApellido(i.getApellido().toUpperCase());
                }
            }
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }catch(Exception io){}
    }
    
    public marco(Login Usuario) {
        this.Usuario=Usuario;
        initComponents();
        paneles();    // Inicializacion de los Paneles
        //changenombre();
        //repair();
        //instalacioncambiadas();
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(d.width, d.height-1);
        jLabel15.setLocation((d.width)-(jLabel15.getWidth()), jLabel15.getY());
        jLabel16.setLocation((d.width)-(jLabel16.getWidth()), jLabel16.getY());
        jLabel18.setLocation((d.width)-(jLabel18.getWidth()), jLabel18.getY());
        jPanel1.setLocation((d.width/2)-(jPanel1.getWidth()/2), jPanel1.getY());
        jLabel1.setSize(d.width,3);
        setResizable(true);
        
        jLabel8.setSize(d.width, 25);
        jLabel15.setText(Usuario.getNombre());
        //Agregar Panel Cliente Class Java
        dispose();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //
        
        //Agregar Icono al Frame
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        //
        tablas();/*Angelmath*/
        accesoUsuario();/*Angelmath*/
        eventos();/*Angelmath*/
    }
    
    public void repair(){
                try{
                ServiceHb neo = new ServiceHb();
                neo.iniciarTransaccion();
                List<Instalacion> clie = neo.getlistaInstalaciones();
        
                for(Instalacion i: clie){
                    //Proyectos proy = neo.getProyectoVt(Integer.toString(i.getId()));
                    if(i.getFechafin()!=null){
                      i.setFechafininsta(Funcion.StringToDate(i.getFechafin()));
//                    Calendar data = Calendar.getInstance();
                    //i.setFechafactu(data.getTime());
//                    int anticipo=Integer.parseInt(proy.getAnticipo());
//                    int credito=Integer.parseInt(proy.getCredito());
//                    int diferido=Integer.parseInt(proy.getDiferido());
//                    int temp=0;
//                    if(anticipo==0){
//                    i.setFechaanticipo(null);
//                    }else{
//                    i.setFechaanticipo(data.getTime());
//                    temp++;
//                    }
//                    data.add(Calendar.MONTH, temp+credito);
//                    i.setFechafactu(data.getTime());
//                    data.add(Calendar.MONTH, diferido);
//                    i.setFechafactufin(data.getTime());
                    neo.actualizarObjeto(i);
                    }
                }
                neo.confirmarTransaccion();
                neo.cerrarSesion();
                }catch(Exception io){
                    System.out.println("xD");
                }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setTitle("SIC - Ventas");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-back-grey.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 40, 58);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-fwd-grey.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 0, 40, 58);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(400, 0, 110, 58);

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
        jLabel15.setBounds(700, 0, 172, 58);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
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
        jLabel16.setBounds(700, 100, 172, 38);
        jLabel16.setVisible(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/icono-ventas-TEXTO.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 12, 159, 34);

        jLabel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel8MouseDragged(evt);
            }
        });
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1000, 58);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 58, 870, 3);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
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
        jLabel18.setBounds(700, 60, 172, 38);
        jLabel18.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void eventoCliente_Instalacion_Tabla1(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked201(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
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
    
    
    
    public int getBreakhilo() {
        return breakhilo;
    }
    
    public void setBreakhilo(int breakhilo) {
        this.breakhilo = breakhilo;
    }
    
    public Instalacion getBackinst() {
        return backinst;
    }
    
    public void setBackinst(Instalacion backinst) {
        this.backinst = backinst;
    }
    
    public materiales getMa() {
        return ma;
    }
    
    public void setMa(materiales ma) {
        this.ma = ma;
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
    
    public JLabel getjLabel9() {
        return jLabel9;
    }
    
    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }
    
    public void instalacionbusqueda() throws Exception{
        ServiceHb helper = new ServiceHb();
        if(cls2.getjLabel2().getText().equalsIgnoreCase("Lista de Clientes")){
            List<Clientes> list=null;
            try {
                helper.iniciarTransaccion();
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaClientesSearch(cls2.getjTextField1().getText());
                    }
                    else{
                        list = helper.getlistaClientes();
                    }
                }else{
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        if(Usuario.getId()==23){
                            list = helper.getlistaClientesSearch2(cls2.getjTextField1().getText(),Usuario.getNombre());
                        }else{
                            list = helper.getlistaClientesSearch(cls2.getjTextField1().getText(),Usuario.getNombre());
                        }
                    }
                    else{
                        if(Usuario.getId()==23){
                            list = helper.getlistaClientes2(Usuario);
                        }else{
                            list = helper.getlistaClientes(Usuario);
                        }
                    }
                }
                
            reiniciarJTable(cls2.getjTable1());
            
            if(list!=null){
                DefaultTableModel temp = (DefaultTableModel) cls2.getjTable1().getModel();
                for (Clientes list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    String c1 = list1.getRuc();
                    String c2 = list1.getApellido();
                    String c3 = list1.getPersona();
                    String c4 = list1.getNombre();
                    String c5 = list1.getNumero1();
                    String c6="";
                    String c7="";
                    if(list1.getLogin2()!=null){
                        c6 = list1.getLogin2().getNombre();
                    }
                    if(list1.getLogin2()!=null){
                        c7 = list1.getLogin3().getNombre();
                    }
                    String c8 = list1.getCorreo();
                    String c9 = "" + list1.getId();
                    Object nuevo[]= {c2,c1,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
            
            helper.cerrarSesion();
                
            } catch (Exception ex) {

                helper.cerrarSesion();
                
            }
        }
        if(cls2.getjLabel2().getText().equalsIgnoreCase("Instalaciones en Diseño")){
            List<Instalacion> list;
            try {
                helper.iniciarTransaccion();
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionDiseñoSearch(cls2.getjTextField1().getText());
                    }
                    else{
                        list = helper.getlistaInstalacionDiseño();
                    }
                }
                else{
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionDiseñoSearch(cls2.getjTextField1().getText(),Usuario);
                    }
                    else{
                        list = helper.getlistaInstalacionDiseño(Usuario);
                    }
                }
                reiniciarJTable(cls2.getjTable2());
                
                if(list!=null){
                    for (Instalacion list1 : list) {
                        String c1 = list1.getClientes().getApellido();
                        String c2 = list1.getDetalle();
                        String c3 = formatoFecha(list1.getFecha());
                        String c4 = list1.getTipo();
                        String c5 = "" + list1.getId();
                        DefaultTableModel temp = (DefaultTableModel) cls2.getjTable2().getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5};
                        temp.addRow(nuevo);
                    }
                }
                
                helper.cerrarSesion();
            } catch (Exception ex) {
                helper.cerrarSesion();
            }
        }
        if(cls2.getjLabel2().getText().equalsIgnoreCase("Instalaciones Aprobadas")){
            List<Instalacion> list;
            try {
                helper.iniciarTransaccion();
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionesAprobadaSearch(cls2.getjTextField1().getText());
                    }
                    else{
                        list = helper.getlistaInstalacionAprobada();
                    }
                }
                else{
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionesAprobadaSearch(cls2.getjTextField1().getText(),Usuario);
                    }
                    else{
                        list = helper.getlistaInstalacionAprobada(Usuario);
                    }
                    
                }
                reiniciarJTable(cls2.getjTable2());
                
                if(list!=null){
                    DefaultTableModel temp = (DefaultTableModel) cls2.getjTable2().getModel();
                    for (Instalacion list1 : list) {
                        String c1 = list1.getClientes().getApellido();
                        String c2 = list1.getDetalle();
                        String c3 = formatoFecha(list1.getFecha());
                        String c4 = list1.getTipo();
                        String c5 = "" + list1.getId();
                        
                        Object nuevo[]= {c1,c2,c3,c4,c5};
                        temp.addRow(nuevo);
                    }
                }
                
                helper.cerrarSesion();
            } catch (Exception ex) {
                helper.cerrarSesion();
            }
        }
        if(cls2.getjLabel2().getText().equalsIgnoreCase("Instalaciones Enviadas al Cliente")){
            List<Instalacion> list;
            try {
                helper.iniciarTransaccion();
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionEnviadaSearch(cls2.getjTextField1().getText());
                    }
                    else{
                        list = helper.getlistaInstalacionEnviada();
                    }
                }else{
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionEnviadaSearch(cls2.getjTextField1().getText(),Usuario);
                    }
                    else{
                        list = helper.getlistaInstalacionEnviada(Usuario);
                    }
                    
                }
                reiniciarJTable(cls2.getjTable2());
                
                if(list!=null){
                    DefaultTableModel temp = (DefaultTableModel) cls2.getjTable2().getModel();
                    for (Instalacion list1 : list) {
                        String c1 = list1.getClientes().getApellido();
                        String c2 = list1.getDetalle();
                        String c3 = formatoFecha(list1.getFecha());
                        String c4 = list1.getTipo();
                        String c5 = "" + list1.getId();
                        
                        Object nuevo[]= {c1,c2,c3,c4,c5};
                        temp.addRow(nuevo);
                    }
                }
                helper.cerrarSesion();
            } catch (Exception ex) {
                helper.cerrarSesion();
                Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(cls2.getjLabel2().getText().equalsIgnoreCase("Instalaciones Aceptadas")){
            List<Instalacion> list;
            try {
                helper.iniciarTransaccion();
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionAceptadaSearch(cls2.getjTextField1().getText());
                    }
                    else{
                        list = helper.getlistaInstalacionAceptada();
                    }
                }else{
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionAceptadaSearch(cls2.getjTextField1().getText(),Usuario);
                    }
                    else{
                        list = helper.getlistaInstalacionAceptada(Usuario);
                    }
                    
                }
                reiniciarJTable(cls2.getjTable2());
                
                if(list!=null){
                    DefaultTableModel temp = (DefaultTableModel) cls2.getjTable2().getModel();
                    for (Instalacion list1 : list) {
                        String c1 = list1.getClientes().getApellido();
                        String c2 = list1.getDetalle();
                        String c3 = formatoFecha(list1.getFecha());
                        String c4 = list1.getTipo();
                        String c5 = "" + list1.getId();
                        Object nuevo[]= {c1,c2,c3,c4,c5};
                        temp.addRow(nuevo);
                    }
                }
                
                helper.cerrarSesion();
            } catch (Exception ex) {
                helper.cerrarSesion();
            }
        }
        if(cls2.getjLabel2().getText().equalsIgnoreCase("Instalaciones Rechazadas")){
            List<Instalacion> list;
            try {
                helper.iniciarTransaccion();
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionRechazadaSearch(cls2.getjTextField1().getText());
                    }
                    else{
                        list = helper.getlistaInstalacionRechazada();
                    }
                }else{
                    if(!cls2.getjTextField1().getText().equalsIgnoreCase("")){
                        list = helper.getlistaInstalacionRechazadaSearch(cls2.getjTextField1().getText(),Usuario);
                    }
                    else{
                        list = helper.getlistaInstalacionRechazada(Usuario);
                    }
                    
                }
                reiniciarJTable(cls2.getjTable2());
                
                if(list!=null){
                    DefaultTableModel temp = (DefaultTableModel) cls2.getjTable2().getModel();
                    for (Instalacion list1 : list) {
                        String c1 = list1.getClientes().getApellido();
                        String c2 = list1.getDetalle();
                        String c3 = formatoFecha(list1.getFecha());
                        String c4 = list1.getTipo();
                        String c5 = "" + list1.getId();
                        Object nuevo[]= {c1,c2,c3,c4,c5};
                        temp.addRow(nuevo);
                    }
                }
                
                helper.cerrarSesion();
            } catch (Exception ex) {
                helper.cerrarSesion();
            }
        }
    }
    
    private void eventoTextCliente_Instalacion_Busqueda(JTextField tbl)    {
        tbl.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                updateTablas up = new updateTablas(7);
                up.start();
            }
            
            
            
        });
    }
    
    public void textopyl() throws Exception{
        List<Instalacion> list=null;
        List<Ticket> list2=null;
        ServiceHb helper = new ServiceHb();
        try {
            helper.iniciarTransaccion();
            if(py.getjLabel7().getText().equalsIgnoreCase("Tickets En Curso")){
                if(!py.getjTextField1().getText().equalsIgnoreCase("")){
                    list2= helper.getTicketsencurso(py.getjTextField1().getText());
                }else{
                    list2= helper.getTicketsencurso();
                }
                reiniciarJTable(py.getjTable1());
                
                if(list2!=null){
                    for (Ticket list21 : list2) {
                        if(breakhilo==1){
                            break;
                        }
                        String c1 = list21.getNumero();
                        String c2 = list21.getCliente();
                        String c3 = list21.getDireccion();
                        String c4 = list21.getEstado();
                        String c5 = list21.getContacto();
                        String c6 = list21.getDetalle();
                        String c7 = "" + list21.getId();
                        String c8 = "" + list21.getId();
                        DefaultTableModel temp = (DefaultTableModel) py.getjTable2().getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8};
                        temp.addRow(nuevo);
                    }
                }
            }else if(py.getjLabel7().getText().equalsIgnoreCase("Tickets Culminado")){
                if(!py.getjTextField1().getText().equalsIgnoreCase("")){
                    list2= helper.getTicketsculminado(py.getjTextField1().getText());
                }else{
                    list2= helper.getTicketsculminado();
                }
                reiniciarJTable(py.getjTable1());
                
                if(list2!=null){
                    for (Ticket list21 : list2) {
                        String c1 = list21.getNumero();
                        String c2 = list21.getCliente();
                        String c3 = list21.getDireccion();
                        String c4 = list21.getEstado();
                        String c5 = list21.getContacto();
                        String c6 = list21.getDetalle();
                        String c7 = "" + list21.getId();
                        String c8 = "" + list21.getId();
                        DefaultTableModel temp = (DefaultTableModel) py.getjTable1().getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8};
                        temp.addRow(nuevo);
                    }
                }
            }else{
                if(!py.getjTextField1().getText().equalsIgnoreCase("")){
                    list= helper.getlistaInstalacionpyl1("Aprobación Financiera",py.getjTextField1().getText());
                }else{
                    list= helper.getlistaInstalacionpyl1("Aprobación Financiera");
                }
                reiniciarJTable(py.getjTable2());
                
                if(list!=null){
                    for (Instalacion list1 : list) {
                        Clientes clie = list1.getClientes();
                        String c1=clie.getApellido();
                        String c2=clie.getNombre();
                        String c3 = list1.getDetalle();
                        String c4 = formatoFecha(list1.getFecha());
                        String c5 = list1.getTipo();
                        String c6 = list1.getProceso();
                        String c7 = "" + list1.getId();
                        String c8 = "" + list1.getId();
                        DefaultTableModel temp = (DefaultTableModel) py.getjTable2().getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8};
                        temp.addRow(nuevo);
                    }
                }
            }

            helper.cerrarSesion();
            
        } catch (Exception ex) {

            helper.cerrarSesion();
        }
    }
    
    public JLabel getjLabel1() {
        return jLabel1;
    }
    
    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    
    private void eventoTextoPYL(JTextField tbl)    {
        tbl.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                updateTablas up = new updateTablas(8);
                up.start();
                
            }
        });
    }
    
    public void textoVentas() throws Exception{
        List<Instalacion> list=null;
        ServiceHb helper = new ServiceHb();
        try {
            helper.iniciarTransaccion();
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Culminadas")){
                if(!vt.getjTextField1().getText().equalsIgnoreCase("")){
                    list = helper.getlistaInstalacionpyl2a(vt.getjTextField1().getText());
                }else{
                    list = helper.getlistaInstalacionpyl2a();
                }
            }
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Facturadas")){
                if(!vt.getjTextField1().getText().equalsIgnoreCase("")){
                    list= helper.getlistaInstalacionpyl1("Facturado",vt.getjTextField1().getText());
                }else{
                    list= helper.getlistaInstalacionpyl1("Facturado");
                }
            }
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Cancelados")){
                if(!vt.getjTextField1().getText().equalsIgnoreCase("")){
                    list= helper.getlistaInstalacionpyl1("Cancelado",vt.getjTextField1().getText());
                }else{
                    list= helper.getlistaInstalacionpyl1("Cancelado");
                }
            }
            if(vt.getjLabel7().getText().equalsIgnoreCase("Espera de Aprobación Financiera")){
                if(!vt.getjTextField1().getText().equalsIgnoreCase("")){
                    list= helper.getlistaInstalacionpyl1("Espera Aprobación Financiera",vt.getjTextField1().getText());
                }else{
                    list= helper.getlistaInstalacionpyl1("Espera Aprobación Financiera");
                }
            }
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Fechas")){
                if(!vt.getjTextField1().getText().equalsIgnoreCase("")){
                    list= helper.getlistaInstalacionFinan2(11,vt.getjTextField1().getText(),vt.getjTextField1().getText());
                }else{
                    list= helper.getlistaInstalacionFinan(0);
                }
            }
            reiniciarJTable(vt.getjTable1());
            
            if(list!=null){
                for (Instalacion list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    Clientes clie = list1.getClientes();
                    String c1=clie.getApellido();
                    String c2=clie.getNombre();
                    String c3 = list1.getDetalle();
                    String c4="";
                    if (vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Facturadas")) {
                        if (list1.getFechaanticipo() != null) {
                            c4 = Funcion.DateFormat(list1.getFechaanticipo());
                        } else {
                            c4 = Funcion.DateFormat(list1.getFechafactu());
                        }
                    } else {
                        c4 = formatoFecha(list1.getFecha());
                    }
                    String c5 = list1.getTipo();
                    String c6 = list1.getProceso();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    String c9 = list1.getPendiente();
                    DefaultTableModel temp = (DefaultTableModel) vt.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        } catch (Exception ex) {
            helper.cerrarSesion();
        }
    }
    
    private void eventoTextoVentas(JTextField tbl)    {
        tbl.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                updateTablas up = new updateTablas(16);
                up.start();
            }
        });
    }
    
    private void eventoVentasPendientes(JTable tbl)    {
        
        tbl.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                ServiceHb helper = new ServiceHb();
                if(e.getKeyChar()=='p' ||e.getKeyChar()=='P' ){
                    Object id = vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(), 6);
                    Instalacion in;
                    int clave = Integer.parseInt(id.toString());
                    try {
                        
                        helper.iniciarTransaccion();
                        in = (Instalacion)helper.obtenerObjeto(Instalacion.class, clave);
                        if(in.getPendiente()!=null){
                            if(in.getPendiente().equalsIgnoreCase("X")){
                                in.setPendiente("O");
                                
                            }else{
                                in.setPendiente("X");
                            }
                        }else{
                            in.setPendiente("X");
                        }
                        helper.actualizarObjeto(in);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    } catch (Exception ex) {
                        System.out.println("");
                    }
                    pyl1c();
                    pyl1ca();
                    pyl1f();
                }
            }
        });
    }
    
    private void eventoCliente_Instalacion_Tabla3(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked206a(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoCliente_Instalacion_Tabla2(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked206(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoregresarCliente(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked322(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoCliente_Instalacion_Seguimiento(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked202seguimiento(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void eventoCliente_Instalacion_Seguimientofecha(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked202fechaseguimiento(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void eventoCliente_Instalacion_All(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked202(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoCliente_Instalacion_Espera(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked203(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoCliente_Instalacion_Diseno(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClickedaprobacion203(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoCliente_Instalacion_Aprobados(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked204(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoCliente_Instalacion_Enviado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked205(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void eventoCliente_Instalacion_Aceptado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked205aceptado(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void eventoCliente_Instalacion_Rechazado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked205rechazado(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void clientes_to_seguimiento(){
        try{
            ServiceHb helper = new ServiceHb();
            List<Instalacion> list;
            helper.iniciarTransaccion();
            if(Usuario.getNivel().equalsIgnoreCase("Ventas")){
                visible(cls2);
                list = helper.getlistaInstalacionseguimiento(Usuario.getNombre(),cls2.getjComboBox2().getSelectedItem().toString());
            }else{
                list = helper.getlistaInstalacionseguimiento(cls2.getjComboBox2().getSelectedItem().toString());
            }
            reiniciarJTable(cls2.getjTable3());
            
            if(list!=null){
                int x=0;
                for(Instalacion i : list){
                    if(inst!=null){
                        if(breakhilo==1){
                            break;}
                        String c1=i.getClientes().getApellido();
                        String c2=i.getDetalle();
                        String c3=i.getProceso();
                        String c4=i.getTipo();
                        String c5="";
                        String c6=""+i.getId();
                        String c7=""+i.getId();
                        
                        String fin="";
                        if(i.getFechafin()!=null){
                            c5=formatoFecha(i.getFecha())+" / " + formatoFecha(i.getFechafin());
                        }else{
                            c5=formatoFecha(i.getFecha())+" / No Disponible";
                        }
                        DefaultTableModel temp = (DefaultTableModel) cls2.getjTable3().getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                        temp.addRow(nuevo);
                        x++;
                    }
                }
            }
            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clientes_to_seguimiento2(){
        try{
            ServiceHb helper = new ServiceHb();
            List<Instalacion> list2=null;
            ArrayList<Instalacion> list= new ArrayList<>();
            Date fecha1 = cls2.getjDateChooser1().getDate();
            Date fecha2 = cls2.getjDateChooser2().getDate();
            helper.iniciarTransaccion();
            if(Usuario.getNivel().equalsIgnoreCase("Ventas")){
                visible(cls2);
                list2 = helper.getlistaInstalacionseguimiento(Usuario.getNombre(),cls2.getjComboBox2().getSelectedItem().toString());
            }else{
                list2 = helper.getlistaInstalacionseguimiento(cls2.getjComboBox2().getSelectedItem().toString());
            }
            
            if(list2!= null){
                for(Instalacion i: list2){
                    if(i.getFechafin()!=null){
                        if((Funcion.StringToDate(i.getFechafin()).before(fecha2) && Funcion.StringToDate(i.getFechafin()).after(fecha1))||(Funcion.StringToDate(i.getFecha()).before(fecha2) && Funcion.StringToDate(i.getFecha()).after(fecha1))){
                            list.add(i);
                        }else{
                            
                        }
                    }else{
                    }
                }
            }
            reiniciarJTable(cls2.getjTable3());
            
            if(list!=null){
                int x=0;
                for(Instalacion i : list){
                    if(inst!=null){
                        if(breakhilo==1){
                            break;}
                        String c1=i.getClientes().getApellido();
                        String c2=i.getDetalle();
                        String c3=i.getProceso();
                        String c4=i.getTipo();
                        String c5="";
                        if(i.getFechafin()!=null){
                            c5=formatoFecha(i.getFecha())+" / " + formatoFecha(i.getFechafin());
                        }else{
                            c5=formatoFecha(i.getFecha())+" / No Disponible";
                        }
                        String c6=""+i.getId();
                        String c7=""+i.getId();
                        DefaultTableModel temp = (DefaultTableModel) cls2.getjTable3().getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                        temp.addRow(nuevo);
                        x++;
                    }
                }
            }
            helper.cerrarSesion();
        } catch (Exception ex) {
            System.out.println("");
        }
    }
    
    public void clientes_to_instalacion(){
        try{
            ServiceHb helper = new ServiceHb();
            visible(cl);
            int contador= 0;
            List<Instalacion> list=null;
            helper.iniciarTransaccion();
            List<Proyectos> list2;
            int filas = cls2.getjTable1().getSelectedRow();
            int col = cls2.getjTable1().getSelectedColumn();
            if (col==8)
            {
                cl.getjTextField2().setText(cls2.getjTable1().getModel().getValueAt(filas, 1).toString());
                cl.getjTextField1().setText(cls2.getjTable1().getModel().getValueAt(filas, 0).toString());
                if(cls2.getjTable1().getModel().getValueAt(filas, 2).toString().equalsIgnoreCase("Juridica")){
                    cl.getjComboBox1().setSelectedIndex(1);
                }else{
                    cl.getjComboBox1().setSelectedIndex(0);
                }
                list=helper.getlistaInstalacion2(cls2.getjTable1().getModel().getValueAt(filas, 8).toString());
                cl.getjTextField5().setText(cls2.getjTable1().getModel().getValueAt(filas, 3).toString());
                cl.getjTextField6().setText(cls2.getjTable1().getModel().getValueAt(filas, 4).toString());
                cl.getjTextField8().setText(cls2.getjTable1().getModel().getValueAt(filas, 5).toString());
                if(cls2.getjTable1().getModel().getValueAt(filas, 7)==null){
                    cl.getjTextField13().setText("");
                }else{
                    cl.getjTextField13().setText(cls2.getjTable1().getModel().getValueAt(filas, 7).toString());
                }
                cliente=cls2.getjTable1().getModel().getValueAt(filas, 8).toString();
                cl.setIdcl(Integer.parseInt(cliente));
                Clientes client= (Clientes)helper.obtenerObjeto(Clientes.class, cl.getIdcl());
                cl.setL1(client.getLogin());
                cl.setL2(client.getLogin2());
                cl.setL3(client.getLogin3());
                if(cl.getL2()!=null){
                    cl.getjTextField10().setText(cl.getL2().getNombre());
                    cl.getjTextField14().setText(cl.getL2().getId()+"");
                }else{
                    cl.getjTextField10().setText(null);
                    cl.getjTextField14().setText(null);
                }
                if(cl.getL3()!=null){
                    cl.getjTextField9().setText(cl.getL3().getNombre());
                    cl.getjTextField12().setText(cl.getL3().getId()+"");
                }else{
                    cl.getjTextField9().setText(null);
                    cl.getjTextField12().setText(null);
                }
                if(Usuario.getNivel().contains("Ventas")){
                    cl.getjLabel18().setVisible(false);
                    cl.getjLabel19().setVisible(false);
                    cl.getjLabel20().setVisible(false);
                }else{
                    cl.getjLabel18().setVisible(true);
                    cl.getjLabel19().setVisible(true);
                    cl.getjLabel20().setVisible(true);
                }
            }
            cl.setCl(cls2.getjTable1().getModel().getValueAt(filas, 3).toString());
            reiniciarJTable(cl.getjTable1());
            
            if(list!=null){
                int i=0;
                for(Instalacion x: list){
                    if(breakhilo==1){
                        break;
                    }
                    String c1=x.getDetalle();
                    String c2=formatoFecha(x.getFecha());
                    String c3=x.getProceso();
                    String c4=x.getTipo();
                    String c5=""+x.getId();
                    String c6=""+x.getId();
                    String c7=""+x.getId();
                    DefaultTableModel temp = (DefaultTableModel) cl.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                    temp.addRow(nuevo);
                    cli=Integer.toString(x.getClientes().getId());
                    i++;
                }
                
            }
            helper.cerrarSesion();
            cl.actualizar();
        }catch(Exception io){
            System.out.println("");
        }
    }
    
    private void tblEjemploMouseClicked201(java.awt.event.MouseEvent evt) throws Exception {
        if(cls2.getjTable1().getSelectedColumn()==8){
            updateTablas up = new updateTablas(23);
            up.start();
        }
    }
    
    private void tblEjemploMouseClicked322(java.awt.event.MouseEvent evt) throws Exception {
        accesoUsuario();
    }
    
    
    private void tblEjemploMouseClicked206a(java.awt.event.MouseEvent evt) throws Exception {
        if(cls2.getjTable3().getSelectedColumn()==6){
            Clientes mod;
            Instalacion in;
            List<Instalacion> list=null;
            List<Proyectos> list2;
            List<Diseno> list3;
            List<Report> list4;
            List<Factu> list5;
            List<Notas> list6;
            List<Orden> list7;
            
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            in = (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(cls2.getjTable3().getModel().getValueAt(cls2.getjTable3().getSelectedRow(),cls2.getjTable3().getSelectedColumn()).toString()));
            mod =in.getClientes();
            int filas = cls2.getjTable3().rowAtPoint(evt.getPoint());
            if (filas >= 0 && cls2.getjTable3().isEnabled())
            {
                this.insta=cls2.getjTable3().getModel().getValueAt(filas, 6).toString();
                inst.getjLabel15().setText(cls2.getjTable3().getModel().getValueAt(filas, 1).toString());
                inst.getjTextField1().setText(cls2.getjTable3().getModel().getValueAt(filas, 0).toString());
            }
            Instalacion instalacion= (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(insta));
            inst.getjTextField9().setText(instalacion.getFecha());
            list2= helper.getlistaProyectos1a(insta,"1");
            list3= helper.getlistaDisenoa(insta,"1");
            list4= helper.getlistaReporta(insta,"1");
            list5= helper.getlistaFactua(insta,"1");
            list6= helper.getlistaNotasa(insta,"1");
            list7= helper.getlistaOrdena(insta,"1");
            
            backinst=instalacion;
            regreso=true;
            transiciondeInstalacion(instalacion);
            
            
            inst.getjPanel1().setVisible(true);
            inst.getjPanel1().removeAll();
            int contador = Integer.parseInt(instalacion.getGrupo());
            
            for(int i=0;contador>i;i++){
                final JLabel lab = new JLabel("Grupo"+Integer.toString(i+1));
                final int var = i;
                lab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(51, 51, 51)));
                lab.setBounds(0, 70, 70, 20);
                lab.setLocation((70*i), 12);
                lab.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            tblEjemploMouseClicked100(e,Integer.toString(var+1),Integer.parseInt(insta));
                        } catch (Exception ex) {
                            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                lab.setVisible(true);
                inst.getjPanel1().add(lab);
            }
            inst.getjPanel1().repaint();
            /*
             */
            
            
            inst.getjTextField2().setText(mod.getCi());
            if(mod.getPersona().equalsIgnoreCase("Juridica")){
                inst.getjComboBox1().setSelectedItem("Juridica");
            }else{
                inst.getjComboBox1().setSelectedItem("Natural");
            }
            inst.getjTextField5().setText(mod.getNombre());
            inst.getjTextField6().setText(mod.getNumero1());
            inst.getjTextField8().setText(mod.getResponsable());
            inst.getjTextField11().setText(mod.getCorreo());
            
            
            inst.getjComboBox9().removeAllItems();
            if(list2!=null){
                for (Proyectos list21 : list2) {
                    inst.getjComboBox9().addItem(list21.getSubproyecto());
                }
            }else{
                inst.getjButton6().setVisible(false);
            }
            inst.getjComboBox11().removeAllItems();
            if(list3!=null){
                for (Diseno list31 : list3) {
                    inst.getjComboBox11().addItem(list31.getNombre());
                }
            }
            inst.getjComboBox13().removeAllItems();
            if(list4!=null){
                for (Report list41 : list4) {
                    inst.getjComboBox13().addItem(list41.getNombre());
                }
            }
            inst.getjComboBox15().removeAllItems();
            if(list5!=null){
                for (Factu list51 : list5) {
                    inst.getjComboBox15().addItem(list51.getNombre());
                }
            }
            inst.getjComboBox12().removeAllItems();
            if(list6!=null){
                for (Notas list61 : list6) {
                    inst.getjComboBox12().addItem(list61.getNombre());
                }
            }
            inst.getjComboBox14().removeAllItems();
            if(list7!=null){
                for (Orden list71 : list7) {
                    inst.getjComboBox14().addItem(list71.getNombre());
                }
            }
            helper.cerrarSesion();
            visible(inst);
        }
        
    }
    
    
    private void tblEjemploMouseClicked206(java.awt.event.MouseEvent evt) throws Exception {
        if(cls2.getjTable2().getSelectedColumn()==4){
            visible(inst);
            if(Usuario.getNivel().equalsIgnoreCase("Ventas")){
                inst.getjButton12().setVisible(true);
                inst.getjButton13().setVisible(true);
                inst.getjButton14().setVisible(false);
                inst.getjButton15().setVisible(false);
                inst.getjButton7().setVisible(true);
                inst.getjButton6().setVisible(true);
            }
            if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                inst.getjButton12().setVisible(true);
                inst.getjButton13().setVisible(true);
                inst.getjButton14().setVisible(true);
                inst.getjButton15().setVisible(true);
                inst.getjButton7().setVisible(true);
            }
            if(Usuario.getNivel().equalsIgnoreCase("Contable")){
                inst.getjButton12().setVisible(false);
                inst.getjButton13().setVisible(false);
                inst.getjButton14().setVisible(false);
                inst.getjButton23().setVisible(false);
                inst.getjButton26().setVisible(false);
                inst.getjButton15().setVisible(true);
                inst.getjButton21().setVisible(true);
                inst.getjButton7().setVisible(true);
                inst.getjButton6().setVisible(false);
            }
            if(Usuario.getNivel().equalsIgnoreCase("PYL")){
                inst.getjButton12().setVisible(false);
                inst.getjButton13().setVisible(false);
                inst.getjButton15().setVisible(false);
                inst.getjButton12().setVisible(false);
                inst.getjButton13().setVisible(false);
                inst.getjButton20().setVisible(false);
                inst.getjButton14().setVisible(false);
                inst.getjButton21().setVisible(false);
                inst.getjButton23().setVisible(false);
                inst.getjButton26().setVisible(false);
                inst.getjButton7().setVisible(true);
                inst.getjButton6().setVisible(false);
            }
        }
        if(cls2.getjTable2().getSelectedColumn()==4){
            Clientes mod;
            Instalacion in;
            List<Instalacion> list=null;
            List<Proyectos> list2;
            List<Diseno> list3;
            List<Report> list4;
            List<Factu> list5;
            List<Notas> list6;
            List<Orden> list7;
            
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            in = (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(cls2.getjTable2().getModel().getValueAt(cls2.getjTable2().getSelectedRow(),cls2.getjTable2().getSelectedColumn()).toString()));
            mod =in.getClientes();
            int filas = cls2.getjTable2().rowAtPoint(evt.getPoint());
            if (filas >= 0 && cls2.getjTable2().isEnabled())
            {
                this.insta=cls2.getjTable2().getModel().getValueAt(filas, 4).toString();
                inst.getjLabel15().setText(cls2.getjTable2().getModel().getValueAt(filas, 1).toString());
                inst.getjTextField1().setText(cls2.getjTable2().getModel().getValueAt(filas, 0).toString());
            }
            Instalacion instalacion= (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(insta));
            inst.getjTextField9().setText(instalacion.getFecha());
            list2= helper.getlistaProyectos1a(insta,"1");
            list3= helper.getlistaDisenoa(insta,"1");
            list4= helper.getlistaReporta(insta,"1");
            list5= helper.getlistaFactua(insta,"1");
            list6= helper.getlistaNotasa(insta,"1");
            list7= helper.getlistaOrdena(insta,"1");
            
            backinst=instalacion;
            regreso=true;
            transiciondeInstalacion(instalacion);
            
            
            inst.getjPanel1().setVisible(true);
            inst.getjPanel1().removeAll();
            int contador = Integer.parseInt(instalacion.getGrupo());
            
            for(int i=0;contador>i;i++){
                final JLabel lab = new JLabel("Grupo"+Integer.toString(i+1));
                final int var = i;
                lab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(51, 51, 51)));
                lab.setBounds(0, 70, 70, 20);
                lab.setLocation((70*i), 12);
                lab.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            tblEjemploMouseClicked100(e,Integer.toString(var+1),Integer.parseInt(insta));
                        } catch (Exception ex) {
                            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                lab.setVisible(true);
                inst.getjPanel1().add(lab);
            }
            inst.getjPanel1().repaint();
            /*
             */
            
            
            inst.getjTextField2().setText(mod.getCi());
            if(mod.getPersona().equalsIgnoreCase("Juridica")){
                inst.getjComboBox1().setSelectedItem("Juridica");
            }else{
                inst.getjComboBox1().setSelectedItem("Natural");
            }
            inst.getjTextField5().setText(mod.getNombre());
            inst.getjTextField6().setText(mod.getNumero1());
            inst.getjTextField8().setText(mod.getResponsable());
            inst.getjTextField11().setText(mod.getCorreo());
            
            
            inst.getjComboBox9().removeAllItems();
            if(list2!=null){
                for (Proyectos list21 : list2) {
                    inst.getjComboBox9().addItem(list21.getSubproyecto());
                }
            }else{
                inst.getjButton6().setVisible(false);
            }
            inst.getjComboBox11().removeAllItems();
            if(list3!=null){
                for (Diseno list31 : list3) {
                    inst.getjComboBox11().addItem(list31.getNombre());
                }
            }
            inst.getjComboBox13().removeAllItems();
            if(list4!=null){
                for (Report list41 : list4) {
                    inst.getjComboBox13().addItem(list41.getNombre());
                }
            }
            inst.getjComboBox15().removeAllItems();
            if(list5!=null){
                for (Factu list51 : list5) {
                    inst.getjComboBox15().addItem(list51.getNombre());
                }
            }
            inst.getjComboBox12().removeAllItems();
            if(list6!=null){
                for (Notas list61 : list6) {
                    inst.getjComboBox12().addItem(list61.getNombre());
                }
            }
            inst.getjComboBox14().removeAllItems();
            if(list7!=null){
                for (Orden list71 : list7) {
                    inst.getjComboBox14().addItem(list71.getNombre());
                }
            }
            helper.cerrarSesion();
        }
        
    }
    
    public void cambionavcls2(JLabel jl){
        cls2.getjLabel3().setVisible(false);
        cls2.getjButton2().setVisible(false);
        cls2.getjLabel6().setVisible(false);
        cls2.getjDateChooser1().setVisible(false);
        cls2.getjDateChooser2().setVisible(false);
        cls2.getjComboBox2().setVisible(false);
        cls2.getjScrollPane3().setVisible(false);
        cls2.getjLabel10().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-clientes-gris.png"))); // NOI18N
        cls2.getjLabel10().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cls2.getjLabel11().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-EN-DISENO-gray.png"))); // NOI18N
        cls2.getjLabel11().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cls2.getjLabel13().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-en-espera-gris.png"))); // NOI18N
        cls2.getjLabel13().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cls2.getjLabel12().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aprobados-gris.png"))); // NOI18N
        cls2.getjLabel12().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cls2.getjLabel9().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-enviados-gris.png"))); // NOI18N
        cls2.getjLabel9().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cls2.getjLabel14().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-P-ACEPTADO-gray.png"))); // NOI18N
        cls2.getjLabel14().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cls2.getjLabel15().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-P-RECHAZADO-gray.png"))); // NOI18N
        cls2.getjLabel15().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cls2.getjLabel16().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-SEG-VENTAS-gray.png"))); // NOI18N
        cls2.getjLabel16().setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }
    public void seguidboton(){
        cls2.getjButton1().setVisible(false);
        visible(cls2);
        cambionavcls2(cls2.getjLabel16());
        cls2.getjLabel16().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-SEG-VENTAS-blue.png"))); // NOI18N
        cls2.getjLabel16().setBorder(null);
        cls2.getjLabel2().setText("Lista de Seguimiento");
        cls2.getjScrollPane1().setVisible(false);
        cls2.getjScrollPane2().setVisible(false);
        
        cls2.getjLabel3().setVisible(true);
        cls2.getjLabel6().setVisible(true);
        cls2.getjDateChooser1().setVisible(true);
        cls2.getjDateChooser2().setVisible(true);
        cls2.getjButton2().setVisible(true);
        cls2.getjScrollPane3().setVisible(true);
        cls2.getjComboBox2().setVisible(true);
        updateTablas up = new updateTablas(21);
        up.start();
        
    }
    private void tblEjemploMouseClicked202seguimiento(java.awt.event.MouseEvent evt) throws Exception {
        cls2.getjButton1().setVisible(false);
        visible(cls2);
        cambionavcls2(cls2.getjLabel16());
        cls2.getjLabel16().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-SEG-VENTAS-blue.png"))); // NOI18N
        cls2.getjLabel16().setBorder(null);
        cls2.getjLabel2().setText("Lista de Seguimiento");
        cls2.getjScrollPane1().setVisible(false);
        cls2.getjScrollPane2().setVisible(false);
        cls2.getjPanel1().setVisible(false);
        
        cls2.getjLabel3().setVisible(true);
        cls2.getjButton2().setVisible(true);
        cls2.getjLabel6().setVisible(true);
        cls2.getjDateChooser1().setVisible(true);
        cls2.getjDateChooser2().setVisible(true);
        cls2.getjScrollPane3().setVisible(true);
        
        cls2.getjComboBox2().setVisible(true);
        updateTablas up = new updateTablas(21);
        up.start();
        
    }
    
    private void tblEjemploMouseClicked202fechaseguimiento(java.awt.event.MouseEvent evt) throws Exception {
        
        if(cls2.getjDateChooser1().getDate()!=null && cls2.getjDateChooser2().getDate()!=null){
            cls2.getjButton1().setVisible(false);
            visible(cls2);
            cambionavcls2(cls2.getjLabel16());
            cls2.getjLabel16().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-SEG-VENTAS-blue.png"))); // NOI18N
            cls2.getjLabel16().setBorder(null);
            cls2.getjLabel2().setText("Lista de Seguimiento");
            cls2.getjScrollPane1().setVisible(false);
            cls2.getjScrollPane2().setVisible(false);
            cls2.getjPanel1().setVisible(false);
            
            cls2.getjLabel3().setVisible(true);
            cls2.getjButton2().setVisible(true);
            cls2.getjLabel6().setVisible(true);
            cls2.getjDateChooser1().setVisible(true);
            cls2.getjDateChooser2().setVisible(true);
            cls2.getjScrollPane3().setVisible(true);
            
            cls2.getjComboBox2().setVisible(true);
            updateTablas up = new updateTablas(211);
            up.start();
        }
        
    }
    
    private void tblEjemploMouseClicked202(java.awt.event.MouseEvent evt) throws Exception {
        cls2.getjButton1().setVisible(true);
        visible(cls2);
        cambionavcls2(cls2.getjLabel10());
        cls2.getjLabel10().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-clientes-azul.png"))); // NOI18N
        cls2.getjLabel10().setBorder(null);
        updateTablas up = new updateTablas(1);
        up.start();
        
    }
    
    private void tblEjemploMouseClicked203(java.awt.event.MouseEvent evt) throws Exception {
        cls2.getjTextField1().setVisible(true);
        cls2.getjButton1().setVisible(false);
        visible(cls2);
        cambionavcls2(cls2.getjLabel11());
        cls2.getjLabel11().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-EN-DISENO-blue.png"))); // NOI18N
        cls2.getjLabel11().setBorder(null);
        updateTablas up = new updateTablas(6);
        up.start();
        
        
    }
    
    private void tblEjemploMouseClickedaprobacion203(java.awt.event.MouseEvent evt) throws Exception {
        cls2.getjTextField1().setVisible(true);
        cls2.getjButton1().setVisible(false);
        visible(cls2);
        cambionavcls2(cls2.getjLabel13());
        cls2.getjLabel13().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-en-espera-azul.png"))); // NOI18N
        cls2.getjLabel13().setBorder(null);
        updateTablas up = new updateTablas(61);
        up.start();
        
        
    }
    
    private void tblEjemploMouseClicked204(java.awt.event.MouseEvent evt) throws Exception {
        cls2.getjTextField1().setVisible(true);
        cls2.getjButton1().setVisible(false);
        visible(cls2);
        cambionavcls2(cls2.getjLabel12());
        cls2.getjLabel12().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aprobados-azul.png"))); // NOI18N
        cls2.getjLabel12().setBorder(null);
        updateTablas up = new updateTablas(5);
        up.start();
        
    }
    
    private void tblEjemploMouseClicked205(java.awt.event.MouseEvent evt) throws Exception {
        visible(cls2);
        cambionavcls2(cls2.getjLabel9());
        cls2.getjLabel9().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-enviados-azul.png"))); // NOI18N
        cls2.getjLabel9().setBorder(null);
        updateTablas up = new updateTablas(4);
        up.start();
        
        
    }
    
    
    private void tblEjemploMouseClicked205aceptado(java.awt.event.MouseEvent evt) throws Exception {
        visible(cls2);
        cambionavcls2(cls2.getjLabel14());
        cls2.getjLabel14().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-P-ACEPTADO-blue.png"))); // NOI18N
        cls2.getjLabel14().setBorder(null);
        updateTablas up = new updateTablas(62);
        up.start();
        
    }
    
    private void tblEjemploMouseClicked205rechazado(java.awt.event.MouseEvent evt) throws Exception {
        visible(cls2);
        cambionavcls2(cls2.getjLabel15());
        cls2.getjLabel15().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/BOTON-P-RECHAZADO-blue.png"))); // NOI18N
        cls2.getjLabel15().setBorder(null);
        updateTablas up = new updateTablas(63);
        up.start();
        
        
    }
    private void eventoCliente_Instalacion_AgregarCliente(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked101(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked101(java.awt.event.MouseEvent evt) throws Exception {
        ingresoU ingresoU = new ingresoU(this, true, this);
        clientes();
    }
    
    private void eventoPYLtablaaceptados(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked102(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked102(java.awt.event.MouseEvent evt) throws Exception {
        ServiceHb helper = new ServiceHb();
        try{
            helper.iniciarTransaccion();
            if(py.getjTable2().getSelectedColumn()==6){
                ingresoU5 ingresoU5 = new ingresoU5(this, this, true,null,py.getjTable2().getModel().getValueAt(py.getjTable2().getSelectedRow(),6).toString(),1,py.getjTable2().getModel().getValueAt(py.getjTable2().getSelectedRow(),0).toString(),py.getjTable2().getModel().getValueAt(py.getjTable2().getSelectedRow(),1).toString(),Usuario.getNombre());
                pyl1();
            }
            if(py.getjTable2().getSelectedColumn()==7){
                
                visible(inst);
                Clientes mod;
                List<Instalacion> list=null;
                List<Proyectos> list2;
                List<Diseno> list3;
                List<Report> list4;
                List<Factu> list5;
                List<Notas> list6;
                List<Orden> list7;
                
                int filas = py.getjTable2().rowAtPoint(evt.getPoint());
                if (filas >= 0 && py.getjTable2().isEnabled())
                {
                    this.insta=py.getjTable2().getModel().getValueAt(filas, 6).toString();
                    inst.getjLabel15().setText(py.getjTable2().getModel().getValueAt(filas, 2).toString());
                }
                Instalacion instalacion= (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(insta));
                String grupo=instalacion.getSelectt();
                backinst=instalacion;
                list2= helper.getlistaProyectos1a(insta,grupo);
                list3= helper.getlistaDisenoa(insta,grupo);
                list4= helper.getlistaReporta(insta,grupo);
                list5= helper.getlistaFactua(insta,grupo);
                list6= helper.getlistaNotasa(insta,grupo);
                list7= helper.getlistaOrdena(insta,grupo);
                
                transiciondeInstalacion(instalacion);
                
                mod= instalacion.getClientes();
                
                inst.getjTextField1().setText(mod.getApellido());
                inst.getjTextField2().setText(mod.getRuc());
                if(mod.getPersona().equalsIgnoreCase("Juridica")){
                    inst.getjComboBox1().setSelectedItem("Juridica");
                }else{
                    inst.getjComboBox1().setSelectedItem("Natural");
                }
                inst.getjTextField5().setText(mod.getNombre());
                inst.getjTextField6().setText(mod.getNumero1());
                inst.getjTextField8().setText(mod.getResponsable());
                inst.getjTextField11().setText(mod.getCorreo());
                
                
                inst.getjComboBox9().removeAllItems();
                if(list2!=null){
                    for (Proyectos list21 : list2) {
                        inst.getjComboBox9().addItem(list21.getSubproyecto());
                    }
                }else{
                    inst.getjButton6().setVisible(false);
                }
                inst.getjComboBox11().removeAllItems();
                if(list3!=null){
                    for (Diseno list31 : list3) {
                        inst.getjComboBox11().addItem(list31.getNombre());
                    }
                }
                inst.getjComboBox13().removeAllItems();
                if(list4!=null){
                    for (Report list41 : list4) {
                        inst.getjComboBox13().addItem(list41.getNombre());
                    }
                }
                inst.getjComboBox15().removeAllItems();
                if(list5!=null){
                    for (Factu list51 : list5) {
                        inst.getjComboBox15().addItem(list51.getNombre());
                    }
                }
                inst.getjComboBox12().removeAllItems();
                if(list6!=null){
                    for (Notas list61 : list6) {
                        inst.getjComboBox12().addItem(list61.getNombre());
                    }
                }
                inst.getjComboBox14().removeAllItems();
                if(list7!=null){
                    for (Orden list71 : list7) {
                        inst.getjComboBox14().addItem(list71.getNombre());
                    }
                }
            }
            inst.getjLabel6().setVisible(false);
            inst.getjButton21().setVisible(false);
            inst.getjButton23().setVisible(false);
            inst.getjButton26().setVisible(false);
            helper.cerrarSesion();
        }catch(Exception io){
            helper.cerrarSesion();
        }
    }
    
    private void eventoProveedoresTabla(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked209(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked209(java.awt.event.MouseEvent evt) throws Exception {
        ServiceHb helper = new ServiceHb();
        if(vt.getjTable2().getSelectedColumn()==6){
            ingresoU10 ingresoU10 = new ingresoU10(this, this, true, Usuario, (Proveedores)vt.getjTable2().getModel().getValueAt(vt.getjTable2().getSelectedRow(),9));
            proveedor();
        }
        if(vt.getjTable2().getSelectedColumn()==7){
            helper.iniciarTransaccion();
            String num = vt.getjTable2().getModel().getValueAt(vt.getjTable2().getSelectedRow(),6).toString();
            Proveedores pro = (Proveedores)helper.obtenerObjeto(Proveedores.class, Integer.parseInt(num));
            ingresoU42 ingresoU42 = new ingresoU42(this, true, this, pro);
            helper.cerrarSesion();
            proveedor();
        }
        if(vt.getjTable2().getSelectedColumn()==8){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                helper.iniciarTransaccion();
                
                String num = vt.getjTable2().getModel().getValueAt(vt.getjTable2().getSelectedRow(),7).toString();
                Proveedores pro = (Proveedores)helper.obtenerObjeto(Proveedores.class, Integer.parseInt(num));
                helper.eliminarObjeto(pro);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                proveedor();
                JOptionPane.showMessageDialog(null, "Proveedor Agregado");
            }
        }
    }
    
    private void eventoVentasTabla(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked112(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked112(java.awt.event.MouseEvent evt) throws Exception {
        ServiceHb helper = null;
        if(vt.getjTable1().getSelectedColumn()==6){
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            String num = vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(),6).toString();
            Instalacion in = (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(num));
            Ticket t = helper.getTicket2(in.getTick().getId());
            
            helper.cerrarSesion();
            if(vt.getjLabel7().getText().equalsIgnoreCase("Espera de Aprobación Financiera")){
                ingresoU71 ingresoU7 = new ingresoU71(this, this, true,Integer.toString(t.getId()),Usuario,"1",vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(),1).toString());
                vt.getjPanel1().setVisible(true);
                updateTablas up = new updateTablas(121);
                up.start();
            }
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Culminadas") && vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(), 5).toString().equalsIgnoreCase("Culminada")){
                ingresoU7 ingresoU7 = new ingresoU7(this, this, true,Integer.toString(t.getId()),Usuario,"1",vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(),1).toString());
                vt.getjPanel1().setVisible(true);
                updateTablas up = new updateTablas(13);
                up.start();
            }
            
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Facturadas")){
                ingresoU7 ingresoU7 = new ingresoU7(this, this, true,Integer.toString(t.getId()),Usuario,"2",vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(),1).toString());
                vt.getjPanel1().setVisible(true);
                updateTablas up = new updateTablas(14);
                up.start();
            }
            
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Canceladas")){
                ingresoU7 ingresoU7 = new ingresoU7(this, this, true,Integer.toString(t.getId()),Usuario,"3",vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(),1).toString());
                vt.getjPanel1().setVisible(true);
                updateTablas up = new updateTablas(12);
                up.start();
            }
            
            if(vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Fechas")){
                ingresoU7 ingresoU7 = new ingresoU7(this, this, true,Integer.toString(t.getId()),Usuario,"2",vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(),1).toString());
                vt.getjPanel1().setVisible(true);
                updateTablas up = new updateTablas(12);
                up.start();
            }
            
            backinst=in;
            
            
        }
        if(vt.getjTable1().getSelectedColumn()==7){
            helper = new ServiceHb();
            visible(inst);
            Clientes mod;
            List<Instalacion> list=null;
            List<Proyectos> list2;
            List<Diseno> list3;
            List<Report> list4;
            List<Factu> list5;
            List<Notas> list6;
            List<Ctepagar> list7;
            helper.iniciarTransaccion();
            Instalacion in;
            String num="";
            int filas = vt.getjTable1().rowAtPoint(evt.getPoint());
            if (filas >= 0 && vt.getjTable1().isEnabled())
            {
                num = vt.getjTable1().getModel().getValueAt(vt.getjTable1().getSelectedRow(),6).toString();
                in = (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(num));
                this.insta=Integer.toString(in.getId());
                inst.getjLabel15().setText(vt.getjTable1().getModel().getValueAt(filas, 2).toString());
            }
            String grupo;
            
            in =(Instalacion) helper.obtenerObjeto(Instalacion.class,Integer.parseInt(num));
            this.insta= Integer.toString(in.getId());
            grupo=in.getSelectt();
            backinst=in;
            list2= helper.getlistaProyectos1a(insta,grupo);
            list3= helper.getlistaDisenoa(insta,grupo);
            list4= helper.getlistaReporta(insta,grupo);
            list5= helper.getlistaFactua(insta,grupo);
            list6= helper.getlistaNotasa(insta,grupo);
            
            
            transiciondeInstalacion(in);
            
            mod= in.getClientes();
            
            
            inst.getjTextField1().setText(mod.getApellido());
            inst.getjTextField2().setText(mod.getRuc());
            if(mod.getPersona().equalsIgnoreCase("Juridica")){
                inst.getjComboBox1().setSelectedItem("Juridica");
            }else{
                inst.getjComboBox1().setSelectedItem("Natural");
            }
            inst.getjTextField5().setText(mod.getNombre());
            inst.getjTextField6().setText(mod.getNumero1());
            inst.getjTextField8().setText(mod.getResponsable());
            inst.getjTextField11().setText(mod.getCorreo());
            
            
            inst.getjComboBox9().removeAllItems();
            if(list2!=null){
                for (Proyectos list21 : list2) {
                    inst.getjComboBox9().addItem(list21.getSubproyecto());
                }
            }else{
                inst.getjButton6().setVisible(false);
            }
            inst.getjComboBox11().removeAllItems();
            if(list3!=null){
                for (Diseno list31 : list3) {
                    inst.getjComboBox11().addItem(list31.getNombre());
                }
            }
            inst.getjComboBox13().removeAllItems();
            if(list4!=null){
                for (Report list41 : list4) {
                    inst.getjComboBox13().addItem(list41.getNombre());
                }
            }
            inst.getjComboBox15().removeAllItems();
            if(list5!=null){
                for (Factu list51 : list5) {
                    inst.getjComboBox15().addItem(list51.getNombre());
                }
            }
            inst.getjComboBox12().removeAllItems();
            if(list6!=null){
                for (Notas list61 : list6) {
                    inst.getjComboBox12().addItem(list61.getNombre());
                }
            }
            
            inst.getjLabel6().setVisible(false);
            inst.getjButton23().setVisible(false);
            inst.getjButton26().setVisible(false);
            helper.cerrarSesion();
        }
        
    }
    
    private void eventoPYLtabla1(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked43(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked43(java.awt.event.MouseEvent evt) throws Exception {
        ServiceHb helper = new ServiceHb();
        if(py.getjTable1().getSelectedColumn()==6){
            ingresoU6 ingresoU6 = new ingresoU6(this, this, true,py.getjTable1().getModel().getValueAt(py.getjTable1().getSelectedRow(),6).toString(),Usuario,py.getjTable1().getModel().getValueAt(py.getjTable1().getSelectedRow(),1).toString());
            if(py.getjLabel7().getText().equalsIgnoreCase("Tickets Culminado")){
                pyl("2");
            }
            if(py.getjLabel7().getText().equalsIgnoreCase("Tickets En Curso")){
                pyl("1");
            }
        }
        if(py.getjTable1().getSelectedColumn()==7){
            visible(inst);
            Clientes mod;
            List<Instalacion> list=null;
            List<Proyectos> list2;
            List<Diseno> list3;
            List<Report> list4;
            List<Factu> list5;
            List<Notas> list6;
            List<Orden> list7;
            helper.iniciarTransaccion();
            
            int filas = py.getjTable1().rowAtPoint(evt.getPoint());
            if (filas >= 0 && py.getjTable1().isEnabled())
            {
                this.insta=py.getjTable1().getModel().getValueAt(filas, 6).toString();
                inst.getjLabel15().setText(py.getjTable1().getModel().getValueAt(filas, 5).toString());
            }
            Ticket tk= (Ticket) helper.obtenerObjeto(Ticket.class,Integer.parseInt(insta));
            Instalacion instalacion = helper.getlistaInstalacionpyl(tk.getId());
            this.insta= Integer.toString(instalacion.getId());
            backinst=instalacion;
            String grupo=instalacion.getSelectt();
            list2= helper.getlistaProyectos1a(insta,grupo);
            list3= helper.getlistaDisenoa(insta,grupo);
            list4= helper.getlistaReporta(insta,grupo);
            list5= helper.getlistaFactua(insta,grupo);
            list6= helper.getlistaNotasa(insta,grupo);
            list7= helper.getlistaOrdena(insta,grupo);
            
            transiciondeInstalacion(instalacion);
            
            mod= instalacion.getClientes();
            
            
            inst.getjTextField1().setText(mod.getApellido());
            inst.getjTextField2().setText(mod.getRuc());
            if(mod.getPersona().equalsIgnoreCase("Juridica")){
                inst.getjComboBox1().setSelectedItem("Juridica");
            }else{
                inst.getjComboBox1().setSelectedItem("Natural");
            }
            inst.getjTextField5().setText(mod.getNombre());
            inst.getjTextField6().setText(mod.getNumero1());
            inst.getjTextField8().setText(mod.getResponsable());
            inst.getjTextField11().setText(mod.getCorreo());
            
            
            inst.getjComboBox9().removeAllItems();
            if(list2!=null){
                for (Proyectos list21 : list2) {
                    inst.getjComboBox9().addItem(list21.getSubproyecto());
                }
            }else{
                inst.getjButton6().setVisible(false);
            }
            inst.getjComboBox11().removeAllItems();
            if(list3!=null){
                for (Diseno list31 : list3) {
                    inst.getjComboBox11().addItem(list31.getNombre());
                }
            }
            inst.getjComboBox13().removeAllItems();
            if(list4!=null){
                for (Report list41 : list4) {
                    inst.getjComboBox13().addItem(list41.getNombre());
                }
            }
            inst.getjComboBox15().removeAllItems();
            if(list5!=null){
                for (Factu list51 : list5) {
                    inst.getjComboBox15().addItem(list51.getNombre());
                }
            }
            inst.getjComboBox12().removeAllItems();
            if(list6!=null){
                for (Notas list61 : list6) {
                    inst.getjComboBox12().addItem(list61.getNombre());
                }
            }
            inst.getjComboBox14().removeAllItems();
            if(list7!=null){
                for (Orden list71 : list7) {
                    inst.getjComboBox14().addItem(list71.getNombre());
                }
            }
            inst.getjLabel6().setVisible(false);
            inst.getjButton21().setVisible(false);
            inst.getjButton23().setVisible(false);
            inst.getjButton26().setVisible(false);
            helper.cerrarSesion();
        }
    }
    
    private void eventoregresarProyecto(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked3(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked3(java.awt.event.MouseEvent evt) throws Exception {
        backinst();
    }
    public void backinst(){
        //Usuario: PYL
        if(Usuario.getNivel().equalsIgnoreCase("PYL")){
            inst.getjButton4().setVisible(true);// Boton Descargar Reporte Oculto - Instalacion
            inst.getjButton20().setVisible(true);// Boton Eliminar Reporte Oculto - Instalacion
            inst.getjButton14().setVisible(true);// Boton Editar Reporte Oculto - Instalacion
            visible(py);// Muestra el panel ventas
        }else
            //
            //Usuario: Contable
            if(Usuario.getNivel().equalsIgnoreCase("Contable")){
                inst.getjButton4().setVisible(true);// Boton Descargar Reporte Oculto - Instalacion
                inst.getjButton21().setVisible(true);// Boton Elimiar Facturacion Oculto - Instalacion
                inst.getjButton15().setVisible(true);// Boton Cargar Facturacion Oculto - Instalacion
                visible(vt);// Muestra el panel ventas
                //                vt.getjLabel7().setText("Instalaciones Culminadas");/*Angelmath*/
                //                updateTablas up = new updateTablas(3);
                //                up.start();
            } else if(!regreso){
                regreso=false;
                updateTablas up = new updateTablas(22);
                up.start();
            }
            else{
                regreso=false;
                visible(cls2);
            }
    }
    
    public static void reiniciarJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);

    }
    
    public void backinstcls2(){
        try{
            ServiceHb helper = new ServiceHb();
            List<Instalacion> list=null;
            List<Proyectos> list2;
            DefaultTableModel temp4;
            helper.iniciarTransaccion();
            list=helper.getlistaInstalacion(backinst.getClientes());

            reiniciarJTable(cl.getjTable1());
            if(list!=null){
                for(Instalacion i: list){
                    if(breakhilo==1){
                        break;
                    }
                    String c1=i.getDetalle();
                    String c2=formatoFecha(i.getFecha());
                    String c3=i.getProceso();
                    String c4=i.getTipo();
                    String c5=""+i.getId();
                    String c6=""+i.getId();
                    String c7=""+i.getId();
                    DefaultTableModel temp = (DefaultTableModel) cl.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                    temp.addRow(nuevo);
                }
                cli=Integer.toString(list.get(list.size()-1).getClientes().getId());
            }
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
        visible(cl);
    }
    private void tblEjemploMouseClicked4(java.awt.event.MouseEvent evt) throws Exception {
        
        
    }
    
    private void setEventoMouseClicked5(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked5(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventometodolistaMateriales2(java.awt.event.MouseEvent evt) throws Exception {
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            backinst.setMateriales(null);
            helper.actualizarObjeto(backinst);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Lista de Materiales Vacia");
        }else{
            JOptionPane.showMessageDialog(null, "Contraseña Erronea");
        }
    }
    
    private void setEventometodolistaMateriales(java.awt.event.MouseEvent evt) throws Exception {
        if(inst.getjComboBox9().getItemCount()>0){
            if(backinst.getMateriales()!=null){
                actualizarlistamateriales();
            }else{
                actualizarlistamateriales();
            }
            visible(ma);
            if(backinst.getTicket()!=null){
                ma.getjLabel3().setText(backinst.getTicket_1());
            }else{
                ma.getjLabel3().setText("N/A");
            }
            ma.getjLabel5().setText(inst.getjTextField1().getText());
            ma.getjLabel2().setText(inst.getjLabel15().getText());
            ma.getjLabel4().setText(inst.getjTextField9().getText());
            
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Materiales> mat = helper.getMateriales(backinst.getMateriales());
            List<Listamateriales> ltma = helper.getlistaMateriales(Integer.toString(mat.get(mat.size()-1).getId()));
            DefaultTableModel temp4 = (DefaultTableModel) ma.getjTable1().getModel();
            if(mat.get(mat.size()-1).getInicio()!=null){
                ma.getjDateChooser1().setDate(mat.get(mat.size()-1).getInicio());
            }
            
            ma.getjComboBox2().removeAllItems();
            for(Materiales i: mat){
                if(i.getAprobado()!=null){
                    ma.getjComboBox2().addItem("OrdenTrabajo" +Integer.toString(i.getId()));
                }
            }
            
            /*
             * 
             */
            
            for(int i=temp4.getRowCount()-1;i>=0;i--){
                temp4.removeRow(i);
            }
            
            if(ltma!=null){
                for (Listamateriales ltma1 : ltma) {
                    String c1 = ltma1.getCantidad();
                    String c2 = ltma1.getDescripcion();
                    String c3 = ltma1.getSerial();
                    String c4 = ltma1.getSerial();
                    DefaultTableModel temp = (DefaultTableModel) ma.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
            try{
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                Materiales mate = helper.getMaterialesnombre(ma.getjComboBox2().getSelectedItem().toString());
                helper.cerrarSesion();
                
                if(mate.getOrdentrabajo()!=null){
                    ma.getjTextField1().setText(mate.getOrdentrabajo());
                    ma.getjButton9().setVisible(true);
                    ma.getjButton18().setVisible(true);
                }else{
                    ma.getjTextField1().setText("");
                    ma.getjButton9().setVisible(false);
                    ma.getjButton18().setVisible(false);
                }
            }catch(Exception io){
                System.out.println("");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Proforma no Existe o no Aprobada");
        }
        
        
    }
    public void eliminar(java.awt.event.MouseEvent evt) throws Exception {
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Proyectos proyecto;
            List<Productos> list2;
            proyecto= helper.getlistaProyectos2(insta,inst.getjComboBox9().getSelectedItem().toString());
            list2= helper.getlistaProductos(Integer.toString(proyecto.getId()));
            backinst.setMateriales(null);
            helper.actualizarObjeto(backinst);
            helper.confirmarTransaccion();
            if(list2!=null){
                for(Productos i: list2){
                    helper.eliminarObjeto(i);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println("");
        }
    }
    public void actualizarlistamateriales() throws Exception{
        ServiceHb helper = new ServiceHb();
        try{
            List<Productos> list2;
            Materiales materiales;
            Proyectos proyecto;
            Listamateriales lista;
            helper.iniciarTransaccion();
            proyecto= helper.getlistaProyectos2(insta,inst.getjComboBox9().getSelectedItem().toString());
            list2= helper.getlistaProductos(Integer.toString(proyecto.getId()));
            
            materiales= new Materiales();
            materiales.setNombre(inst.getjLabel15().getText());
            helper.crearObjeto(materiales);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(list2!=null){
                for(Productos i: list2){
                    lista=new Listamateriales();
                    lista.setCantidad(i.getCantidad());
                    lista.setDescripcion(i.getDescripcion());
                    lista.setDisponible(i.getCantidad());
                    lista.setAgregado("0");
                    if(i.getSerial()!=null){
                        lista.setSerial(i.getSerial());
                    }else{
                        lista.setSerial("000000");
                    }
                    lista.setMaterial(materiales.getId());
                    helper.crearOrActualizarObjeto(lista);
                }
            }
            backinst.setMateriales(Integer.toString(materiales.getId()));
            materiales.setOrden(Integer.toString(materiales.getId()));
            helper.actualizarObjeto(backinst);
            helper.actualizarObjeto(materiales);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Lista de Materiales Actualizada");
        }catch(Exception io){
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Error al Actualizar Lista de Materiales");
        }
        
        
        
    }
    
    
    private void setEventometodolistaMaterialesgenerar(java.awt.event.MouseEvent evt){
        //actualizarlistamateriales();
    }
    
    private void tblEjemploMouseClicked5(java.awt.event.MouseEvent evt) throws Exception {
        visible(fc);
        reiniciarJTable(fc.getjTable1());
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        prof=null;
        fc.getjLabel4().setText("pendiente"); // numero proforma
        fc.getjTextField1().setText(""); //Observaciones
        fc.getjLabel2().setText("0"); //subtotal
        fc.getjLabel3().setText("0"); //iva
        fc.getjLabel17().setText("$0,00"); //subtotal
        fc.getjLabel18().setText("$0,00"); //iva
        fc.getjLabel13().setText("$0,00"); //total
        fc.getjLabel3().setText("$0,00"); //total 2
        fc.getjLabel1().setText(inst.getjTextField1().getText());
        fc.getjLabel11().setText(inst.getjTextField5().getText());
        fc.setCliente(inst.getInstalacion());
        
        helper.cerrarSesion();
    }
    
    private void setEventoMouseClicked31(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked31(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked31(java.awt.event.MouseEvent evt) throws Exception {
        if(inst.getjComboBox9().getItemCount()>0){
            visible(fc);
            reiniciarJTable(fc.getjTable1());
            List<Proyectos> list;
            List<Productos> list2;
            Proyectos proyecto;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list= helper.getlistaProyectos1(insta);
            prof= inst.getjComboBox9().getSelectedItem().toString();
            proyecto= helper.getlistaProyectos2(insta,inst.getjComboBox9().getSelectedItem().toString());
            list2= helper.getlistaProductos(Integer.toString(proyecto.getId()));
            if(list2!=null){
                for (Productos list21 : list2) {
                    String c1 = list21.getCantidad();
                    String c2 = list21.getDescripcion();
                    String c3 = list21.getUnitario();
                    String c4 = list21.getTotal();
                    String c6 = list21.getOriginal();
                    String c5="";
                    if (list21.getSerial() != null) {
                        c5 = list21.getSerial();
                    } else {
                        c5="000000";
                    }
                    DefaultTableModel temp = (DefaultTableModel) fc.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6};
                    temp.addRow(nuevo);
                }
            }
            fc.getjLabel4().setText(proyecto.getSubproyecto()); // numero proforma
            fc.getjTextField1().setText(proyecto.getObservacion1()); //Observaciones
            fc.getjTextField2().setText(proyecto.getGmeses()); //subtotal
            fc.getjTextField3().setText(proyecto.getGtiempo()); //iva
            fc.getjTextField4().setText(proyecto.getGvalidez()); //total
            fc.getjLabel17().setText(proyecto.getSubtotal()); //subtotal
            fc.getjLabel18().setText(proyecto.getIva()); //iva
            fc.getjLabel13().setText(proyecto.getTotal()); //total
            fc.getjLabel3().setText(proyecto.getTotal()); //total 2
            fc.getInteres().setSelectedItem(Integer.parseInt(proyecto.getInteres()));
            fc.getAumento().setSelectedItem(Integer.parseInt(proyecto.getAumento()));
            fc.getDescuento().setSelectedItem(Integer.parseInt(proyecto.getDescuento()));
            
            fc.getjLabel1().setText(inst.getjTextField1().getText());
            fc.getjLabel11().setText(inst.getjTextField5().getText());
            fc.getjLabel20().setText(inst.getjTextField8().getText());
            fc.setCliente(inst.getInstalacion());
            fc.getjTextField6().setText("");
            fc.getjTextField7().setText("");
            fc.getjTextField5().setText("");
            if(proyecto.getAnticipo()!=null){
                fc.getjTextField6().setText(proyecto.getAnticipo());
            }
            if(proyecto.getCredito()!=null){
                fc.getjTextField7().setText(proyecto.getCredito());
            }
            if(proyecto.getDiferido()!=null){
                fc.getjTextField5().setText(proyecto.getDiferido());
            }
            
            helper.cerrarSesion();
            fc.tablaeditada();
        }else{
            JOptionPane.showMessageDialog(null, "No Existe Datos que Editar");
        }
        
    }
    
    private void setEventomateriales_instalacion(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventobotonmateriales_instalacion(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventobotonmateriales_instalacion(java.awt.event.MouseEvent evt) throws Exception {
        visible(inst);
    }
    
    private void setEventoMouseClicked6(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked6(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked6(java.awt.event.MouseEvent evt) throws Exception {
        visible(inst);
    }
    
    private void setEventoMouseClicked8(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked8(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked8(java.awt.event.MouseEvent evt) throws Exception {
        ServiceHb helper = new ServiceHb();
        if(pf.getjTable2().getSelectedColumn()==5){
            Login mod = new Login();
            helper.iniciarTransaccion();
            int filas = pf.getjTable2().rowAtPoint(evt.getPoint());
            if (filas >= 0 && pf.getjTable2().isEnabled())
            {
                mod= (Login)helper.obtenerObjeto(Login.class,helper.getLogin(pf.getjTable2().getModel().getValueAt(filas, 0).toString()).getId());
            }
            helper.cerrarSesion();
            ingresoU2 ingresoU2 = new ingresoU2(this, this, true, mod);
            JOptionPane.showMessageDialog(null, "Usuario Editado");
            config();
        }
        
        if(pf.getjTable2().getSelectedColumn()==6){
            Login elim;
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                
                helper.iniciarTransaccion();
                int filas = pf.getjTable2().rowAtPoint(evt.getPoint());
                if (filas >= 0 && pf.getjTable2().isEnabled())
                {
                    elim= (Login)helper.obtenerObjeto(Login.class,helper.getLogin(pf.getjTable2().getModel().getValueAt(filas, 0).toString()).getId());
                    helper.eliminarObjeto(elim);
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
            }
            config();
        }
    }
    
    private void setEventoMouseClicked50(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked50(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked50(java.awt.event.MouseEvent evt) throws Exception {
        Instalacion instalacion;
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        instalacion = (Instalacion)helper.obtenerObjeto(Instalacion.class,Integer.parseInt(insta));
        final int numero = Integer.parseInt(instalacion.getGrupo())+1;
        inst.getjPanel1().setVisible(true);
        final JLabel lab = new JLabel("Grupo"+Integer.toString(numero));
        lab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(51, 51, 51)));
        lab.setBounds(0, 70, 70, 20);
        lab.setLocation((70*(numero-1)), 12);
        lab.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked100(e,Integer.toString(numero),Integer.parseInt(insta));
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        lab.setVisible(true);
        inst.getjPanel1().add(lab);
        inst.getjPanel1().repaint();
        instalacion.setGrupo(Integer.toString(numero));
        helper.actualizarObjeto(instalacion);
        helper.confirmarTransaccion();
        helper.cerrarSesion();
    }
    
    private void setEventoMouseClicked51(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked51(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked51(java.awt.event.MouseEvent evt) throws Exception {
        
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave");
        ServiceHb helper = new ServiceHb();
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            Instalacion instalacion;
            helper.iniciarTransaccion();
            
            instalacion = (Instalacion)helper.obtenerObjeto(Instalacion.class,Integer.parseInt(insta));
            int numero = Integer.parseInt(instalacion.getGrupo()) -1 ;
            instalacion.setGrupo(Integer.toString(numero));
            
            helper.actualizarObjeto(instalacion);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }
        helper = new ServiceHb();
        List<Instalacion> list=null;
        List<Proyectos> list2;
        List<Diseno> list3;
        List<Report> list4;
        List<Factu> list5;
        List<Notas> list6;
        List<Orden> list7;
        helper.iniciarTransaccion();
        Instalacion instalacion= (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(insta));
        list2= helper.getlistaProyectos1a(insta,"1");
        list3= helper.getlistaDisenoa(insta,"1");
        list4= helper.getlistaReporta(insta,"1");
        list5= helper.getlistaFactua(insta,"1");
        list6= helper.getlistaNotasa(insta,"1");
        list7= helper.getlistaOrdena(insta,"1");
        transiciondeInstalacion(instalacion);
        
        /*
         */
        inst.getjPanel1().setVisible(true);
        inst.getjPanel1().removeAll();
        int contador = Integer.parseInt(instalacion.getGrupo());
        
        inst.getjPanel1().repaint();
        inst.getjComboBox9().removeAllItems();
        if(list2!=null){
            for (Proyectos list21 : list2) {
                inst.getjComboBox9().addItem(list21.getSubproyecto());
            }
        }else{
            inst.getjButton6().setVisible(false);
        }
        inst.getjComboBox11().removeAllItems();
        if(list3!=null){
            for (Diseno list31 : list3) {
                inst.getjComboBox11().addItem(list31.getNombre());
            }
        }
        inst.getjComboBox13().removeAllItems();
        if(list4!=null){
            for (Report list41 : list4) {
                inst.getjComboBox13().addItem(list41.getNombre());
            }
        }
        inst.getjComboBox15().removeAllItems();
        if(list5!=null){
            for (Factu list51 : list5) {
                inst.getjComboBox15().addItem(list51.getNombre());
            }
        }
        inst.getjComboBox12().removeAllItems();
        if(list6!=null){
            for (Notas list61 : list6) {
                inst.getjComboBox12().addItem(list61.getNombre());
            }
        }
        inst.getjComboBox14().removeAllItems();
        if(list7!=null){
            for (Orden list71 : list7) {
                inst.getjComboBox14().addItem(list71.getNombre());
            }
        }
        /*
         */
        helper.cerrarSesion();
    }
    
    private void tblEjemploMouseClicked100(java.awt.event.MouseEvent evt, String grupo, int in) throws Exception {
        List<Instalacion> list=null;
        List<Proyectos> list2;
        List<Diseno> list3;
        List<Report> list4;
        List<Factu> list5;
        List<Notas> list6;
        List<Orden> list7;
        ServiceHb helper= new ServiceHb();
        helper.iniciarTransaccion();
        list2= helper.getlistaProyectos1a(Integer.toString(in),grupo);
        list3= helper.getlistaDisenoa(Integer.toString(in),grupo);
        list4= helper.getlistaReporta(Integer.toString(in),grupo);
        list5= helper.getlistaFactua(Integer.toString(in),grupo);
        list6= helper.getlistaNotasa(Integer.toString(in),grupo);
        list7= helper.getlistaOrdena(Integer.toString(in),grupo);
        helper.cerrarSesion();
        inst.setSelecionado(grupo);
        inst.getjComboBox9().removeAllItems();
        if(list2!=null){
            for (Proyectos list21 : list2) {
                inst.getjComboBox9().addItem(list21.getSubproyecto());
            }
        }else{
            inst.getjButton6().setVisible(false);
        }
        inst.getjComboBox11().removeAllItems();
        if(list3!=null){
            for (Diseno list31 : list3) {
                inst.getjComboBox11().addItem(list31.getNombre());
            }
        }
        inst.getjComboBox13().removeAllItems();
        if(list4!=null){
            for (Report list41 : list4) {
                inst.getjComboBox13().addItem(list41.getNombre());
            }
        }
        inst.getjComboBox15().removeAllItems();
        if(list5!=null){
            for (Factu list51 : list5) {
                inst.getjComboBox15().addItem(list51.getNombre());
            }
        }
        inst.getjComboBox12().removeAllItems();
        if(list6!=null){
            for (Notas list61 : list6) {
                inst.getjComboBox12().addItem(list61.getNombre());
            }
        }
        inst.getjComboBox14().removeAllItems();
        if(list7!=null){
            for (Orden list71 : list7) {
                inst.getjComboBox14().addItem(list71.getNombre());
            }
        }
        
    }
    
    private void setEventoMouseClicked18(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked18(e);
                } catch (Exception ex) {
                    try {
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(helper.obtenerObjeto(Factu.class, pdfcarga));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex1) {
                        Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked18(java.awt.event.MouseEvent evt) throws Exception {
        
        ingresoU9 ingresoU9 = new ingresoU9(this, this, true, Usuario, inst.getjTextField1().getText(), insta, cliente);
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        List<Factu> list3= helper.getlistaFactu(insta);
        helper.cerrarSesion();
        inst.getjComboBox15().removeAllItems();
        if(list3!=null){
            for (Factu list31 : list3) {
                inst.getjComboBox15().addItem(list31.getNombre());
            }
        }
    }
    
    private void setEventoMouseClicked19(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked19(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                    
                    
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked19(java.awt.event.MouseEvent evt) throws Exception {
        File f = new File(Usuario.getDireccion()+"/"+inst.getjComboBox15().getSelectedItem().toString());
        if(f.exists()){
            Principal p = new Principal(Usuario.getDireccion()+"/"+inst.getjComboBox15().getSelectedItem().toString());
            p.next();
        }
    }
    
    private void setEventoMouseClicked40(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked40(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked40(java.awt.event.MouseEvent evt) throws Exception {
        ingresoU4 ingresoU4 = new ingresoU4(this,this, true, Usuario,inst.getjTextField1().getText() ,insta,inst.getSelecionado());
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        List<Proyectos>list2= helper.getlistaProyectos1(insta);
        helper.cerrarSesion();
        inst.getjComboBox9().removeAllItems();
        if(list2!=null){
            for (Proyectos list21 : list2) {
                inst.getjComboBox9().addItem(list21.getSubproyecto());
            }
        }else{
            inst.getjButton6().setVisible(false);
        }
        visible(inst);
    }
    
    private void eventoPYLencurso(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked103(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked103(java.awt.event.MouseEvent evt) throws Exception {
        visible(py);
        py.getjLabel7().setText("Tickets En Curso");
        py.getjLabel11().setBackground(new Color(255,255,255));
        py.getjLabel10().setBackground(new Color(212,208,200));
        py.getjLabel12().setBackground(new Color(212,208,200));
        py.getjLabel9().setBackground(new Color(212,208,200));
        py.visi(py.getjPanel2());
        updateTablas up = new updateTablas(9);
        up.start();
        
    }
    
    private void eventoPYLculminado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked104(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked104(java.awt.event.MouseEvent evt) throws Exception {
        py.getjLabel7().setText("Tickets Culminado");
        py.getjLabel9().setBackground(new Color(255,255,255));
        py.getjLabel10().setBackground(new Color(212,208,200));
        py.getjLabel12().setBackground(new Color(212,208,200));
        py.getjLabel11().setBackground(new Color(212,208,200));
        py.visi(py.getjPanel2());
        updateTablas up = new updateTablas(10);
        up.start();
        
    }
    
    private void eventoPYLsoporte(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked105a(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoPYLaceptado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked105(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked105a(java.awt.event.MouseEvent evt) throws Exception {
        if(Usuario.getDepartamento().equalsIgnoreCase("Dpt. Compras")){
            py.getjLabel12().setBackground(new Color(255,255,255));
            py.getjLabel10().setBackground(new Color(212,208,200));
            py.getjLabel11().setBackground(new Color(212,208,200));        
            py.getjLabel9().setBackground(new Color(212,208,200));
            py.getjLabel9().setEnabled(false);
            visible(py);// Muestra el panel ventas
            py.visi(py.getSp2());
            py.getSp2().setUs(Usuario);
            py.getSp2().hilollenarcero();
        }else{
            visible(py);
            py.getjLabel12().setBackground(new Color(255,255,255));
            py.getjLabel10().setBackground(new Color(212,208,200));
            py.getjLabel11().setBackground(new Color(212,208,200));        
            py.getjLabel9().setBackground(new Color(212,208,200));
            py.visi(py.getSp());
            py.getSp().setUs(Usuario);
            py.getSp().hilollenarcero();
        }
    }
    
    private void tblEjemploMouseClicked105(java.awt.event.MouseEvent evt) throws Exception {
        visible(py);
        py.getjLabel10().setBackground(new Color(255,255,255));
        py.getjLabel11().setBackground(new Color(212,208,200));
        py.getjLabel12().setBackground(new Color(212,208,200));
        py.getjLabel9().setBackground(new Color(212,208,200));
        py.visi(py.getjPanel2());
        updateTablas up = new updateTablas(11);
        up.start();
        
    }
    
    private void setEventoMouseClicked106(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked106(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked106(java.awt.event.MouseEvent evt) throws Exception {
        visible(py);
        py.getjLabel7().setText("Tickets En Curso");
        py.getjLabel11().setBackground(new Color(255,255,255));
        py.getjLabel12().setBackground(new Color(212,208,200));
        py.getjLabel10().setBackground(new Color(212,208,200));
        py.getjLabel9().setBackground(new Color(212,208,200));
        py.visi(py.getjPanel2());
        pyl("1");
    }
    
    private void setEventoMouseClicked107(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked107(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked107(java.awt.event.MouseEvent evt) throws Exception {
        visible(py);
        py.getjLabel7().setText("Tickets Culminado");
        py.getjLabel11().setBackground(new Color(255,255,255));
        py.getjLabel12().setBackground(new Color(212,208,200));
        py.getjLabel10().setBackground(new Color(212,208,200));
        py.getjLabel9().setBackground(new Color(212,208,200));
        py.visi(py.getjPanel2());
        pyl("2");
    }
    
    private void setEventoMouseClicked108(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked108(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked108(java.awt.event.MouseEvent evt) throws Exception {
        py.getjLabel11().setBackground(new Color(255,255,255));
        py.getjLabel10().setBackground(new Color(212,208,200));
        py.getjLabel9().setBackground(new Color(212,208,200));
        py.getjLabel12().setBackground(new Color(212,208,200));
        py.visi(py.getjPanel2());
        pyl1();
    }
    
    private void eventoVentasbotonFechas(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked109a(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoVentasbotonFacturado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked109(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked109a(java.awt.event.MouseEvent evt) throws Exception {
        vt.getjPanel1().setVisible(true);
        visible(vt);
        vt.getjLabel7().setText("Instalaciones Fechas");
        transicionventas(vt.getjLabel14());
        updateTablas up = new updateTablas(314);
        up.start();
        
    }
    
    private void tblEjemploMouseClicked109(java.awt.event.MouseEvent evt) throws Exception {
        vt.getjPanel1().setVisible(true);
        visible(vt);
        vt.getjLabel7().setText("Instalaciones Facturadas");
        transicionventas(vt.getjLabel11());
        updateTablas up = new updateTablas(14);
        up.start();
        
    }
    
    private void eventoVentasbotonCulminado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked111(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked111(java.awt.event.MouseEvent evt) throws Exception {
        vt.getjPanel1().setVisible(true);
        visible(vt);
        vt.getjLabel7().setText("Instalaciones Culminadas");
        transicionventas(vt.getjLabel10());
        updateTablas up = new updateTablas(13);
        up.start();
    }
    
    private void eventoVentasbotonProveedores(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked207(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked207(java.awt.event.MouseEvent evt) throws Exception {
        vt.getjPanel1().setVisible(false);
        visible(vt);
        vt.getjLabel7().setText("Proveedores");
        vt.getjScrollPane1().setVisible(false);
        vt.getjScrollPane2().setVisible(true);
        vt.getjButton1().setVisible(true);
        transicionventas(vt.getjLabel12());
        updateTablas up = new updateTablas(15);
        up.start();
    }
    
    private void eventoProveedoresAgregar(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked208(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked208(java.awt.event.MouseEvent evt) throws Exception {
        ingresoU42 ingresoU42 = new ingresoU42(this, true, this, null);
        proveedor();
    }
    
    private void eventoVentasbotonFinanciero(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClickedfinancieron110(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eventoVentasbotonCancelado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked110(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClickedfinancieron110(java.awt.event.MouseEvent evt) throws Exception {
        vt.getjPanel1().setVisible(true);
        visible(vt);
        vt.getjLabel7().setText("Espera de Aprobación Financiera");
        transicionventas(vt.getjLabel13());
        updateTablas up = new updateTablas(121);
        up.start();
    }
    
    public void transicionventas(JLabel lb){
        vt.getjLabel9().setBackground(new Color(212,208,200));
        vt.getjLabel10().setBackground(new Color(212,208,200));
        vt.getjLabel11().setBackground(new Color(212,208,200));
        vt.getjLabel12().setBackground(new Color(212,208,200));
        vt.getjLabel13().setBackground(new Color(212,208,200));
        vt.getjLabel14().setBackground(new Color(212,208,200));
        lb.setBackground(new Color(255,255,255));
    }
    
    private void tblEjemploMouseClicked110(java.awt.event.MouseEvent evt) throws Exception {
        vt.getjPanel1().setVisible(true);
        visible(vt);
        vt.getjLabel7().setText("Instalaciones Cancelados");
        transicionventas(vt.getjLabel9());
        updateTablas up = new updateTablas(12);
        up.start();
        
        
    }
    
    private void setEventoMouseClicked20(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked20(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked20(java.awt.event.MouseEvent evt) throws Exception {
        File archivoEntrada = new File(Usuario.getDireccion()+"/"+inst.getjComboBox15().getSelectedItem().toString());
        if(archivoEntrada.isFile()){
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
                //Crear un objeto File con el archivo elegido
                
                File archivoSalida = new File(chooser.getSelectedFile().getAbsolutePath()+"/"+inst.getjComboBox15().getSelectedItem().toString());
                //Mostrar el nombre del archvivo en un campo de texto
                
                
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Archivo no Agregado");
        }
        
        
    }
    
    private void eventocargarReporte(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked21(e);
                } catch (Exception ex) {
                    try {
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(helper.obtenerObjeto(Report.class, pdfcarga));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    } catch (Exception ex1) {
                    }
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked21(java.awt.event.MouseEvent evt) throws Exception {
        
        
        JFileChooser chooser = new JFileChooser();
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        List<Report> list3;
        int valido=0;
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        if(Usuario.getNombre().equalsIgnoreCase("Jan Topic")){
            chooser.setCurrentDirectory(new File(((Estatico)helper.obtenerObjeto(Estatico.class, 1)).getDirectorio()));
        }
        int respuesta = chooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            try{
                PagePanel panelpdf = null;
                JFileChooser selector;
                PDFFile pdffile;
                int indice=0;
                int max=0;
                
                File file = chooser.getSelectedFile();
                
                RandomAccessFile raf = new RandomAccessFile(file, "r");
                
                byte[] b = new byte[(int) raf.length()];
                raf.readFully(b);
                java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(b);
                
                pdffile = new PDFFile(buf);
            }catch(Exception io){
                
            }
        }
        if(valido==0){
            Report reporte = new Report();
            reporte.setInstalacion(insta);
            reporte.setProyecto(prof);
            reporte.setGrupo(inst.getSelecionado());
            reporte.setNombre(inst.getjTextField1().getText()+" Reporte "+insta+ " " +reporte.getId()+".pdf");
            helper.crearObjeto(reporte);
            pdfcarga= reporte.getId();
            list3= helper.getlistaReport(insta);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            //Comprobar si se ha pulsado Aceptar
            if (respuesta == JFileChooser.APPROVE_OPTION)
            {
                //Crear un objeto File con el archivo elegido
                File archivoEntrada = chooser.getSelectedFile();
                //Mostrar el nombre del archvivo en un campo de texto
                
                File archivoSalida = new File(Usuario.getDireccion()+"\\"+reporte.getNombre());
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                inst.getjComboBox13().removeAllItems();
                if(list3!=null){
                    for (Report list31 : list3) {
                        inst.getjComboBox13().addItem(list31.getNombre());
                    }
                }
            }
        }else{
            JOptionPane.showConfirmDialog(null, "Sistema Incapaz de Leer PDF... ", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
    }
    
    private void setEventoMouseClicked22(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked22(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked22(java.awt.event.MouseEvent evt) throws Exception {
        String cad = inst.getjComboBox13().getSelectedItem().toString();
        File f = new File(Usuario.getDireccion()+"/"+cad);
        if(f.exists()){
            Principal p = new Principal(Usuario.getDireccion()+"/"+cad);
            p.next();
        }
    }
    
    private void setEventoMouseClicked23(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked23(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked23(java.awt.event.MouseEvent evt) throws Exception {
        File archivoEntrada = new File(Usuario.getDireccion()+"/"+inst.getjComboBox13().getSelectedItem().toString());
        if(archivoEntrada.isFile()){
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
                //Crear un objeto File con el archivo elegido
                
                File archivoSalida = new File(chooser.getSelectedFile().getAbsolutePath()+"/"+inst.getjComboBox13().getSelectedItem().toString());
                //Mostrar el nombre del archvivo en un campo de texto
                
                
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Archivo no Agregado");
        }
    }
    
    private void eventocargardiseñoproyecto(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked24(e);
                } catch (Exception ex) {
                    try {
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(helper.obtenerObjeto(Diseno.class, pdfcarga));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    } catch (Exception ex1) {
                        
                    }
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked24(java.awt.event.MouseEvent evt) throws Exception {
        JFileChooser chooser = new JFileChooser();
        List<Diseno> list3;
        int valido=0;
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        if(Usuario.getNombre().equalsIgnoreCase("Jan Topic")){
            chooser.setCurrentDirectory(new File(((Estatico)helper.obtenerObjeto(Estatico.class, 1)).getDirectorio()));
        }
        int respuesta = chooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            try{
                PagePanel panelpdf = null;
                JFileChooser selector;
                PDFFile pdffile;
                int indice=0;
                int max=0;
                
                File file = chooser.getSelectedFile();
                String extension = "";
                int i = file.getPath().lastIndexOf('.');
                if (i >= 0) {
                    extension = file.getPath().substring(i+1);
                }
                if(!extension.equalsIgnoreCase("pdf")){
                    errorespdf(1);
                    valido=1;
                }else{
                    RandomAccessFile raf = new RandomAccessFile(file, "r");
                    
                    byte[] b = new byte[(int) raf.length()];
                    raf.readFully(b);
                    java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(b);
                    
                    pdffile = new PDFFile(buf);
                }
            }catch(Exception io){
                errorespdf(2);
                valido=1;
            }
        }
        if(valido==0){
            Diseno diseño = new Diseno();
            diseño.setInstalacion(insta);
            diseño.setProyecto(prof);
            diseño.setGrupo(inst.getSelecionado());
            diseño.setNombre(inst.getjTextField1().getText()+" Diseño "+insta+ " " +diseño.getId()+".pdf");
            helper.crearObjeto(diseño);
            pdfcarga= diseño.getId();
            list3= helper.getlistaDiseno(insta);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            
            //Comprobar si se ha pulsado Aceptar
            if (respuesta == JFileChooser.APPROVE_OPTION)
            {
                //Crear un objeto File con el archivo elegido
                File archivoEntrada = chooser.getSelectedFile();
                //Mostrar el nombre del archvivo en un campo de texto
                
                File archivoSalida = new File(Usuario.getDireccion()+"/"+diseño.getNombre());
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                inst.getjComboBox11().removeAllItems();
                if(list3!=null){
                    for (Diseno list31 : list3) {
                        inst.getjComboBox11().addItem(list31.getNombre());
                    }
                }
            }
        }else{
            JOptionPane.showConfirmDialog(null, "Sistema no puede de Leer PDF... ", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        
    }
    
    private void eventoconsultadiseño(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked25(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked25(java.awt.event.MouseEvent evt) throws Exception {
        File f = new File(Usuario.getDireccion()+"/"+inst.getjComboBox11().getSelectedItem().toString());
        if(f.exists()){
            Principal p = new Principal(Usuario.getDireccion()+"/"+inst.getjComboBox11().getSelectedItem().toString());
            p.next();
        }
    }
    
    private void setEventoMouseClicked26(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked26(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked26(java.awt.event.MouseEvent evt) throws Exception {
        File archivoEntrada = new File(Usuario.getDireccion()+"/"+inst.getjComboBox11().getSelectedItem().toString());
        if(archivoEntrada.isFile()){
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
                //Crear un objeto File con el archivo elegido
                
                File archivoSalida = new File(chooser.getSelectedFile().getAbsolutePath()+"/"+inst.getjComboBox11().getSelectedItem().toString());
                //Mostrar el nombre del archvivo en un campo de texto
                
                
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Archivo no Agregado");
        }
        
    }
    
    private void setEventoMouseClicked41(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked41(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked41(java.awt.event.MouseEvent evt) throws Exception {
        File archivoEntrada = new File(Usuario.getDireccion()+"/"+inst.getjComboBox9().getSelectedItem().toString()+".pdf");
        if(archivoEntrada.isFile()){
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
                //Crear un objeto File con el archivo elegido
                
                File archivoSalida = new File(chooser.getSelectedFile().getAbsolutePath()+"/"+inst.getjTextField1().getText()+" "+inst.getjLabel15().getText()+" "+inst.getjComboBox9().getSelectedItem().toString()+".pdf");
                //Mostrar el nombre del archvivo en un campo de texto
                
                
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Archivo no Agregado");
        }
        
    }
    
    private void setEventoMouseClicked35(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked35(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked35(java.awt.event.MouseEvent evt) throws Exception {
        List<Diseno>  list3;
        Diseno di;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            di= helper.getDiseno(inst.getjComboBox11().getSelectedItem().toString());
            helper.eliminarObjeto(di);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getlistaDiseno(insta);
            helper.cerrarSesion();
            inst.getjComboBox11().removeAllItems();
            if(list3!=null){
                for (Diseno list31 : list3) {
                    inst.getjComboBox11().addItem(list31.getNombre());
                }
            }
        }
    }
    
    private void setEventoMouseClicked36(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked36(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked36(java.awt.event.MouseEvent evt) throws Exception {
        List<Report>  list3;
        Report di;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            di= helper.getReport(inst.getjComboBox13().getSelectedItem().toString());
            helper.eliminarObjeto(di);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getlistaReport(insta);
            helper.cerrarSesion();
            inst.getjComboBox13().removeAllItems();
            if(list3!=null){
                for (Report list31 : list3) {
                    inst.getjComboBox13().addItem(list31.getNombre());
                }
            }
        }
    }
    
    private void setEventoMouseClicked37(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked37(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void eliminarOrden2(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seteliminarOrden2(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    private void seteliminarOrden2(java.awt.event.MouseEvent evt) throws Exception {
        List<Orden>  list3;
        Orden di;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            di= helper.getOrden(ma.getjTextField1().getText());
            helper.eliminarObjeto(di);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getlistaOrden(insta);
            helper.cerrarSesion();
            ma.getjTextField1().setText("");
            ma.getjButton18().setVisible(false);
            ma.getjButton9().setVisible(false);
        }
    }
    
    private void eliminarOrden(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seteliminarOrden(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    private void seteliminarOrden(java.awt.event.MouseEvent evt) throws Exception {
        List<Materiales>  list3;
        Materiales di;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            di= helper.getMaterialesnombre(ma.getjComboBox2().getSelectedItem().toString());
            helper.eliminarObjeto(di);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getMateriales(backinst.getTicket_1());
            Materiales mate = list3.get(0);
            helper.cerrarSesion();
            ma.getjComboBox2().removeAllItems();
            for(Materiales i: list3){
                if(i.getAprobado()!=null){
                    ma.getjComboBox2().addItem("OrdenTrabajo" +Integer.toString(i.getId()));
                }
            }
            
            if(mate.getOrdentrabajo()!=null){
                ma.getjTextField1().setText(mate.getOrdentrabajo());
                ma.getjButton9().setVisible(true);
                ma.getjButton18().setVisible(true);
            }else{
                ma.getjTextField1().setText("");
                ma.getjButton9().setVisible(false);
                ma.getjButton18().setVisible(false);
            }
            
        }
    }
    
    private void setEventoOrden_Eliminar(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventobotonOrden_Eliminar(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    private void setEventobotonOrden_Eliminar(java.awt.event.MouseEvent evt) throws Exception {
        List<Orden>  list3;
        Orden di;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            di= helper.getOrden(inst.getjComboBox14().getSelectedItem().toString());
            helper.eliminarObjeto(di);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getlistaOrden(insta);
            helper.cerrarSesion();
            inst.getjComboBox14().removeAllItems();
            if(list3!=null){
                for (Orden list31 : list3) {
                    inst.getjComboBox14().addItem(list31.getNombre());
                }
            }
        }
    }
    
    
    private void tblEjemploMouseClicked37(java.awt.event.MouseEvent evt) throws Exception {
        List<Notas>  list3;
        Notas di;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            di= helper.getNotas(inst.getjComboBox12().getSelectedItem().toString());
            helper.eliminarObjeto(di);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getlistaNotas(insta);
            helper.cerrarSesion();
            inst.getjComboBox12().removeAllItems();
            if(list3!=null){
                for (Notas list31 : list3) {
                    inst.getjComboBox12().addItem(list31.getNombre());
                }
            }
        }
    }
    
    private void setEventoMouseClicked38(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked38(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked38(java.awt.event.MouseEvent evt) throws Exception {
        List<Factu>  list3;
        Factu di;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            di= helper.getFactu(inst.getjComboBox15().getSelectedItem().toString());
            helper.eliminarObjeto(di);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getlistaFactu(insta);
            helper.cerrarSesion();
            inst.getjComboBox15().removeAllItems();
            if(list3!=null){
                for (Factu list31 : list3) {
                    inst.getjComboBox15().addItem(list31.getNombre());
                }
            }
        }
    }
    
    private void setEventoMouseClicked27(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked27(e);
                } catch (Exception ex) {
                    try {
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(helper.obtenerObjeto(Factu.class, pdfcarga));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex1) {
                        Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        });
    }
    
    private void setEventoOrden_Proyecto(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventobotonOrden_Proyecto(e);
                } catch (Exception ex) {
                    try {
                        Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex1) {
                        Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        });
    }
    
    public void errorespdf(int i){
        if(i==1){//No PDF
            JOptionPane.showConfirmDialog(null, "El Archivo a Agregar no es PDF", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        if(i==2){//No PDF
            JOptionPane.showConfirmDialog(null, "El Formato PDF no puede ser Ingresado... Modifiquelo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
    }
    
    private void setEventobotonOrden_Proyecto(java.awt.event.MouseEvent evt) throws Exception {
        JFileChooser chooser = new JFileChooser();
        
        List<Orden> list3;
        Materiales mat;
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        mat= helper.getMaterialesnombre(ma.getjComboBox2().getSelectedItem().toString());
        Orden notas = new Orden();
        notas.setInstalacion(insta);
        notas.setProyecto(prof);
        notas.setNombre("");
        notas.setGrupo(inst.getSelecionado());
        helper.crearObjeto(notas);
        if(Usuario.getNombre().equalsIgnoreCase("Jan Topic")){
            chooser.setCurrentDirectory(new File(((Estatico)helper.obtenerObjeto(Estatico.class, 1)).getDirectorio()));
        }
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        
        helper = new ServiceHb();
        helper.iniciarTransaccion();
        
        notas.setNombre("Orden de Trabajo "+notas.getId()+".pdf");
        mat.setOrdentrabajo("Orden de Trabajo "+notas.getId());
        ma.getjTextField1().setText("Orden de Trabajo "+notas.getId());
        helper.actualizarObjeto(mat);
        helper.actualizarObjeto(notas);
        pdfcarga= notas.getId();
        list3= helper.getlistaOrden(insta);
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        
        int respuesta = chooser.showOpenDialog(this);
        //Comprobar si se ha pulsado Aceptar
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            File archivoEntrada = chooser.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            
            File archivoSalida = new File(Usuario.getDireccion()+"/"+notas.getNombre());
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
            JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            inst.getjComboBox14().removeAllItems();
            if(list3!=null){
                for (Orden list31 : list3) {
                    inst.getjComboBox14().addItem(list31.getNombre());
                }
            }
        }
        
    }
    
    
    
    private void setEventoOrden_Instalacion(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventobotonOrden_Instalacion(e);
                } catch (Exception ex) {
                    try {
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(helper.obtenerObjeto(Factu.class, pdfcarga));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    } catch (Exception ex1) {
                        
                    }
                }
            }
        });
    }
    
    private void setEventobotonOrden_Instalacion(java.awt.event.MouseEvent evt) throws Exception {
        JFileChooser chooser = new JFileChooser();
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        List<Orden> list3;
        
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        Orden notas = new Orden();
        notas.setInstalacion(insta);
        notas.setProyecto(prof);
        notas.setNombre("");
        notas.setGrupo(inst.getSelecionado());
        helper.crearObjeto(notas);
        if(Usuario.getNombre().equalsIgnoreCase("Jan Topic")){
            chooser.setCurrentDirectory(new File(((Estatico)helper.obtenerObjeto(Estatico.class, 1)).getDirectorio()));
        }
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        String selectedSiteName = JOptionPane.showInputDialog(null,"Ingrese el Nombre al Documento ");
        
        helper = new ServiceHb();
        helper.iniciarTransaccion();
        
        notas.setNombre("Orden "+notas.getId()+" "+selectedSiteName+".pdf");
        helper.actualizarObjeto(notas);
        pdfcarga= notas.getId();
        list3= helper.getlistaOrden(insta);
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        
        int respuesta = chooser.showOpenDialog(this);
        //Comprobar si se ha pulsado Aceptar
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            //Crear un objeto File con el archivo elegido
            File archivoEntrada = chooser.getSelectedFile();
            //Mostrar el nombre del archvivo en un campo de texto
            
            File archivoSalida = new File(Usuario.getDireccion()+"/"+notas.getNombre());
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
            JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            inst.getjComboBox14().removeAllItems();
            if(list3!=null){
                for (Orden list31 : list3) {
                    inst.getjComboBox14().addItem(list31.getNombre());
                }
            }
        }
        
    }
    
    public void refreshpdfcajamarca(String Direcc, String autor, String contenido){
        //String imagepath = Server.MapPath("Images");
        Document documento = new Document(PageSize.A4, 0, 0, 0, 0);
        FileOutputStream ficheroPdf;
        final String IMAGE = (getClass().getResource("/rrhh/imagenes/cajahead.jpg")).toString();
        try {
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            String sub= Direcc;
            ficheroPdf = new FileOutputStream(sub);
            PdfWriter writer = PdfWriter.getInstance(documento,ficheroPdf);
            
            documento.open();
            
            documento.setMargins(0, 0, 0, 0);
            
            PdfPCell celda = new PdfPCell();
            Font fontpersonalizado2 = FontFactory.getFont("ARIAL", 7, Font.NORMAL);
            Font font = FontFactory.getFont("ARIAL", 9, Font.NORMAL);
            Font font2 = FontFactory.getFont("ARIAL", 11, Font.BOLDITALIC);
            Font fontselected = FontFactory.getFont("ARIAL", 22, Font.BOLD);
            
            fontselected.setColor(Color.red);
            //aqui agregamos todo el contenido del PDF...
            /*Cabecera celdas 1 2 y 3*/
            
            com.itextpdf.text.Image image2 = com.itextpdf.text.Image.getInstance((getClass().getResource("/rrhh/imagenes/pie-de-pagina.png")));
            
            Chunk chunk = new Chunk(image2, 0, -45);
            HeaderFooter footer = new HeaderFooter(new Phrase(chunk), false);
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setBorder(Rectangle.NO_BORDER);
            documento.setFooter(footer);
            
            
            PdfContentByte canvas = writer.getDirectContentUnder();
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(IMAGE);
            image.scaleAbsolute(PageSize.A4.getWidth(),PageSize.A4.getHeight());
            image.setAbsolutePosition(0, 0);
            canvas.addImage(image);
            PdfPTable foto = new PdfPTable(1);
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda.setMinimumHeight(110);
            foto.addCell(celda);
            
            /*Datos Personales*/
            String campo1= "AUTOR: ";
            String campo1a=autor;
            String campo3="FECHA: ";//Edad
            DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
            String s3= df3.format(new Date());
            String campo3a=s3;//Edad
            String campo4="DESTINATARIO: ";
            String campo4a=" Todos";
            String campo6="CONTENIDO:";
            String campo6a=contenido;
            String identacion="                  ";
            documento.add(foto);
            
            foto = new PdfPTable(new float[] { 2, 3 });
            
            celda = new PdfPCell(new Phrase(campo1,new Font(font2)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            celda.setMinimumHeight(20);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase(campo1a,new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase(campo3,new Font(font2)));
            celda.setBorder(0);
            celda.setMinimumHeight(20);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase(campo3a,new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase(campo4,new Font(font2)));
            celda.setBorder(0);
            celda.setMinimumHeight(20);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase(campo4a,new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase(campo6,new Font(font2)));
            celda.setBorder(0);
            celda.setMinimumHeight(40);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            celda = new PdfPCell(new Phrase(campo6a,new Font(font)));
            celda.setBorder(0);
            celda.setColspan(2);
            celda.setMinimumHeight(110);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            foto.addCell(celda);
            
            foto.setSpacingAfter(20);
            documento.add(foto);
            
            documento.close();
            helper.cerrarSesion();
        }catch(DocumentException | IOException ex){
            System.out.println(ex.toString());
        }
        
        
    }
    private void tblEjemploMouseClicked27(java.awt.event.MouseEvent evt) throws Exception {
        JFileChooser chooser = new JFileChooser();
        //Mostrar la ventana para abrir archivo y recoger la respuesta
        //En el parámetro del showOpenDialog se indica la ventana
        //  al que estará asociado. Con el valor this se asocia a la
        //  ventana que la abre.
        List<Notas> list3;
        
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        Notas notas = new Notas();
        ingresoNotasVarias dialog = new ingresoNotasVarias(new javax.swing.JFrame(),null, true,null,null,0,"",Usuario.getNombre());
        notas.setInstalacion(insta);
        notas.setProyecto(prof);
        notas.setNombre("");
        notas.setGrupo(inst.getSelecionado());
        helper.crearObjeto(notas);
        if(Usuario.getNombre().equalsIgnoreCase("Jan Topic")){
            chooser.setCurrentDirectory(new File(((Estatico)helper.obtenerObjeto(Estatico.class, 1)).getDirectorio()));
        }
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        
        helper = new ServiceHb();
        helper.iniciarTransaccion();
        notas.setNombre(inst.getjTextField1().getText()+" Notas "+insta+ " " +notas.getId()+".pdf");
        helper.actualizarObjeto(notas);
        pdfcarga= notas.getId();
        list3= helper.getlistaNotas(insta);
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        
        JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        inst.getjComboBox12().removeAllItems();
        if(list3!=null){
            for (Notas list31 : list3) {
                inst.getjComboBox12().addItem(list31.getNombre());
            }
        }
        if(!dialog.getA().isEmpty()){
            refreshpdfcajamarca(Usuario.getDireccion()+"/"+notas.getNombre(),dialog.getA().get(0).toString(),dialog.getA().get(2).toString());
        }
    }
    
    private void setEventolistaMaterialeseliminar(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    eliminar(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventolistaMateriales(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventometodolistaMateriales(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventolistaMateriales2(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventometodolistaMateriales2(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void agregarOrden(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseagregarOrden(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseagregarOrden(java.awt.event.MouseEvent evt) throws Exception {
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Orden or = new Orden();
            or.setGrupo("1");
            or.setInstalacion(insta);
            helper.cerrarSesion();
        }catch(Exception io){
        }
    }
    
    private void consultarOrden2(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseconsultarOrden2(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseconsultarOrden2(java.awt.event.MouseEvent evt) throws Exception {
        File f = new File(Usuario.getDireccion()+"/"+ma.getjTextField1().getText()+".pdf");
        if(f.exists()){
            Principal p = new Principal(Usuario.getDireccion()+"/"+ma.getjTextField1().getText()+".pdf");
        }
    }
    
    private void consultarOrden(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseconsultarOrden(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseconsultarOrden(java.awt.event.MouseEvent evt) throws Exception {
        
    }
    
    private void setEventoMouseClicked39(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked39(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked39(java.awt.event.MouseEvent evt) throws Exception {
        File f = new File(Usuario.getDireccion()+"/"+inst.getjComboBox9().getSelectedItem().toString()+".pdf");
        if(f.exists()){
            Principal p = new Principal(Usuario.getDireccion()+"/"+inst.getjComboBox9().getSelectedItem().toString()+".pdf");
            p.next();
        }
    }
    
    
    private void setEventoMouseClicked28(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked28(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    private void setEventoOrden_Consultar(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventobotonOrden_Consultar(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventobotonOrden_Consultar(java.awt.event.MouseEvent evt) throws Exception {
        File f = new File(Usuario.getDireccion()+"/"+inst.getjComboBox14().getSelectedItem().toString());
        if(f.exists()){
            Principal p = new Principal(Usuario.getDireccion()+"/"+inst.getjComboBox14().getSelectedItem().toString());
            p.next();
        }
    }
    
    
    private void tblEjemploMouseClicked28(java.awt.event.MouseEvent evt) throws Exception {
        File f = new File(Usuario.getDireccion()+"/"+inst.getjComboBox12().getSelectedItem().toString());
        if(f.exists()){
            Principal p = new Principal(Usuario.getDireccion()+"/"+inst.getjComboBox12().getSelectedItem().toString());
            p.next();
        }
    }
    
    private void setEventoOrden_Descargar(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventobotonOrden_Descargar(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventoMouseClicked29(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked29(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventobotonOrden_Descargar(java.awt.event.MouseEvent evt) throws Exception {
        File archivoEntrada = new File(Usuario.getDireccion()+"/"+inst.getjComboBox14().getSelectedItem().toString());
        if(archivoEntrada.isFile()){
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
                //Crear un objeto File con el archivo elegido
                
                File archivoSalida = new File(chooser.getSelectedFile().getAbsolutePath()+"/"+inst.getjComboBox14().getSelectedItem().toString());
                //Mostrar el nombre del archvivo en un campo de texto
                
                
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Archivo no Agregado");
        }
    }
    
    
    private void tblEjemploMouseClicked29(java.awt.event.MouseEvent evt) throws Exception {
        File archivoEntrada = new File(Usuario.getDireccion()+"/"+inst.getjComboBox12().getSelectedItem().toString());
        if(archivoEntrada.isFile()){
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
                //Crear un objeto File con el archivo elegido
                
                File archivoSalida = new File(chooser.getSelectedFile().getAbsolutePath()+"/"+inst.getjComboBox12().getSelectedItem().toString());
                //Mostrar el nombre del archvivo en un campo de texto
                
                
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
                JOptionPane.showConfirmDialog(null, "Listo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Archivo no Agregado");
        }
    }
    
    private void setEventoMouseClicked30(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked30(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked30(java.awt.event.MouseEvent evt) throws Exception {
        if(fc.getjTextField2().getText().equalsIgnoreCase("")||fc.getjTextField3().getText().equalsIgnoreCase("")||fc.getjTextField4().getText().equalsIgnoreCase("")||fc.getjTable1().getRowCount()==0){
            if(fc.getjTextField2().getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null, "Garantia no Agregada");
            if(fc.getjTextField3().getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null, "Tiempo de Entrega no Agregada");
            if(fc.getjTextField4().getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null, "Validez de Oferta no Agregada");
            if(fc.getjTable1().getRowCount()==0)
                JOptionPane.showMessageDialog(null, "No hay Datos Ingresados en la Tabla");
        }else{
            List<Productos> list=null;
            ArrayList<Productos> product= new ArrayList<>();
            List<Proyectos> list2;
            Login ln;
            
            Proyectos proyecto =null;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            if(prof!=null){
                proyecto=helper.getlistaProyectos2(insta, prof);
            }
            if(proyecto!=null){
                list=helper.getlistaProductos(Integer.toString(proyecto.getId()));
                proyecto.setContacto(fc.getjLabel1().getText());
                proyecto.setInstalacion(insta);
                proyecto.setNumero(fc.getjLabel4().getText());
                proyecto.setIva(fc.getjLabel18().getText());
                proyecto.setObservacion1(fc.getjTextField1().getText());
                proyecto.setGmeses(fc.getjTextField2().getText());
                proyecto.setGtiempo(fc.getjTextField3().getText());
                proyecto.setGvalidez(fc.getjTextField4().getText());
                proyecto.setAnticipo(fc.getjTextField6().getText());
                proyecto.setCredito(fc.getjTextField7().getText());
                proyecto.setDiferido(fc.getjTextField5().getText());
                proyecto.setInventario("");
                proyecto.setRazon(fc.getjLabel11().getText());
                proyecto.setSubproyecto(prof);
                proyecto.setGrupo(inst.getSelecionado());
                proyecto.setSubtotal(fc.getjLabel17().getText());
                proyecto.setTotal(fc.getjLabel13().getText());
                proyecto.setInteres(fc.getInteres().getSelectedItem().toString());
                proyecto.setAumento(fc.getAumento().getSelectedItem().toString());
                proyecto.setDescuento(fc.getDescuento().getSelectedItem().toString());
                helper.actualizarObjeto(proyecto);
            }else{
                proyecto= new Proyectos();
                proyecto.setContacto(fc.getjLabel1().getText());
                proyecto.setInstalacion(insta);
                proyecto.setIva(fc.getjLabel18().getText());
                proyecto.setNumero("Pendiente "+Integer.toString(proyecto.getId()));
                proyecto.setObservacion1(fc.getjTextField1().getText());
                proyecto.setGmeses(fc.getjTextField2().getText());
                proyecto.setGtiempo(fc.getjTextField3().getText());
                proyecto.setGvalidez(fc.getjTextField4().getText());
                proyecto.setAnticipo(fc.getjTextField6().getText());
                proyecto.setCredito(fc.getjTextField7().getText());
                proyecto.setDiferido(fc.getjTextField5().getText());
                proyecto.setInventario("");
                proyecto.setGrupo(inst.getSelecionado());
                proyecto.setRazon(fc.getjLabel11().getText());
                proyecto.setSubproyecto("");
                proyecto.setSubtotal(fc.getjLabel17().getText());
                proyecto.setTotal(fc.getjLabel13().getText());
                proyecto.setInteres(fc.getInteres().getSelectedItem().toString());
                proyecto.setAumento(fc.getAumento().getSelectedItem().toString());
                proyecto.setDescuento(fc.getDescuento().getSelectedItem().toString());
                helper.crearObjeto(proyecto);
                proyecto.setSubproyecto("Pendiente "+Integer.toString(proyecto.getId()));
                helper.actualizarObjeto(proyecto);
                proyecto.setNumero("Pendiente "+Integer.toString(proyecto.getId()));
                helper.actualizarObjeto(proyecto);
            }
            
            if(list!=null){
                for(Productos i: list){
                    helper.eliminarObjeto(i);
                }
                for(int y=0; y<=fc.getjTable1().getModel().getRowCount()-1;y++){
                    Productos p = new Productos();
                    p.setCantidad(fc.getjTable1().getModel().getValueAt(y, 0).toString());
                    p.setDescripcion(fc.getjTable1().getModel().getValueAt(y, 1).toString());
                    p.setUnitario(fc.getjTable1().getModel().getValueAt(y, 2).toString());
                    p.setTotal(fc.getjTable1().getModel().getValueAt(y, 3).toString());
                    p.setSerial(fc.getjTable1().getModel().getValueAt(y, 4).toString());
                    p.setOriginal(fc.getjTable1().getModel().getValueAt(y, 5).toString());
                    p.setProyecto(Integer.toString(proyecto.getId()));
                    helper.crearObjeto(p);
                    product.add(p);
                }
            }else{
                for(int y=0; y<=fc.getjTable1().getModel().getRowCount()-1;y++){
                    Productos p = new Productos();
                    p.setCantidad(fc.getjTable1().getModel().getValueAt(y, 0).toString());
                    p.setDescripcion(fc.getjTable1().getModel().getValueAt(y, 1).toString());
                    p.setUnitario(fc.getjTable1().getModel().getValueAt(y, 2).toString());
                    p.setTotal(fc.getjTable1().getModel().getValueAt(y, 3).toString());
                    p.setSerial(fc.getjTable1().getModel().getValueAt(y, 4).toString());
                    p.setOriginal(fc.getjTable1().getModel().getValueAt(y, 5).toString());
                    p.setProyecto(Integer.toString(proyecto.getId()));
                    helper.crearObjeto(p);
                    product.add(p);
                }
            }
            list2= helper.getlistaProyectos1(insta);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            inst.getjComboBox9().removeAllItems();
            if(list2!=null){
                for (Proyectos list21 : list2) {
                    inst.getjComboBox9().addItem(list21.getSubproyecto());
                }
                
            }
            if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                inst.getjButton6().setVisible(true);
            }
            
            /*Angelmath*/
            pdf(proyecto,product);
            visible(inst);
        }
    }
    
    private void setEventoactualizarmateriales(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    setEventobotonactualizarmateriales(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventobotonactualizarmateriales(java.awt.event.MouseEvent evt) throws Exception {
        
        List<Listamateriales> list=null;
        ArrayList<Productos> product= new ArrayList<>();
        List<Proyectos> list2;
        Login ln;
        Proyectos proyecto =null;
        
        
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        
        Materiales mat = new Materiales();
        mat.setInicio(ma.getjDateChooser1().getDate());
        mat.setAprobado("X");
        mat.setNombre(inst.getjLabel15().getText());
        mat.setOrden(backinst.getMateriales());
        helper.crearObjeto(mat);
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        
        helper = new ServiceHb();
        helper.iniciarTransaccion();
        for(int y=0; y<=ma.getjTable1().getModel().getRowCount()-1;y++){
            Listamateriales p = new Listamateriales();
            p.setCantidad(ma.getjTable1().getModel().getValueAt(y, 0).toString());
            p.setDescripcion(ma.getjTable1().getModel().getValueAt(y, 1).toString());
            if((ma.getjTable1().getModel().getValueAt(y, 2)!=null)){
                if(ma.getjTable1().getModel().getValueAt(y, 2).toString().equalsIgnoreCase("")){
                    p.setSerial("000000");
                }else{
                    p.setSerial(ma.getjTable1().getModel().getValueAt(y, 2).toString());
                }
            }else{
                p.setSerial("000000");
            }
            p.setMaterial(mat.getId());
            helper.crearObjeto(p);
        }
        
        
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        ordenpdf(Integer.toString(mat.getId()));
        visible(inst);
        
    }
    
    private void setEventoMouseClicked32(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked32(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked32(java.awt.event.MouseEvent evt) throws Exception {
        
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            
            List<Productos> list;
            List<Proyectos> list2;
            Proyectos proyectos;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            proyectos= helper.getProyectos(inst.getjComboBox9().getSelectedItem().toString());
            helper.eliminarObjeto(proyectos);
            list=helper.getlistaProductos(Integer.toString(proyectos.getId()));
            
            if(list!=null){
                for(Productos i: list){
                    helper.eliminarObjeto(i);
                }
            }
            
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            list2=helper.getlistaProyectos1(insta);
            helper.cerrarSesion();
            inst.getjComboBox9().removeAllItems();
            if(list2!=null){
                for (Proyectos list21 : list2) {
                    inst.getjComboBox9().addItem(list21.getSubproyecto());
                }
            }       else{
                inst.getjButton6().setVisible(false);
            }
            visible(inst);
        }
        
    }
    
    private void eventoBotonProcesosProyecto(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked34(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked34(java.awt.event.MouseEvent evt) throws Exception {
        
        Proyectos proyecto=null;
        Estatico est;
        Proyectos py2;
        Notificaciones noti= new Notificaciones();
        String selectedSiteName = JOptionPane.showInputDialog(null,"Ingrese Clave para Confirmar Accion");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            Date dd = new Date();
            noti.setFecha(dd);
            noti.setVisto("NO");
            noti.setResponsable(Usuario.getNombre());
            noti.setInformacion("El Cliente "+inst.getjTextField1().getText()+" con proyecto "+inst.getjLabel15().getText()+" cambio de estado");
            if(Usuario.getNivel().equalsIgnoreCase("Ventas")||Usuario.getNivel().equalsIgnoreCase("Administrador")||Usuario.getNivel().equalsIgnoreCase("Contable")){
                ArrayList<Productos> product= new ArrayList<>();
                List<Productos> list=null;
                List<Proyectos> list2=null;
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Instalacion instalacion = (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(insta));
                if(instalacion.getTipo().equalsIgnoreCase("Venta Directa")||instalacion.getTipo().equalsIgnoreCase("Poligrafos")){
                    /**************************************************/
                    if(instalacion.getProceso().equalsIgnoreCase("Enviada a Cliente")){
                        String selectedSiteName2 = JOptionPane.showInputDialog(null,"Aceptado (A) - Rechazado (R)");
                        if(selectedSiteName2.equalsIgnoreCase("A")){
                            instalacion.setProceso("Aceptada por Cliente");
                            noti.setModulo("Ventas");
                            noti.setInstalacion(instalacion.getProceso());
                            inst.getjButton6().setVisible(true);
                            instalacion.setSelectt(inst.getSelecionado());
                            JOptionPane.showMessageDialog(null, "Aceptado");
                        }else if(selectedSiteName2.equalsIgnoreCase("R")){
                            instalacion.setProceso("Rechazada por Cliente");
                            noti.setModulo("Ventas");
                            noti.setInstalacion(instalacion.getProceso());
                            inst.getjButton6().setVisible(false);
                            instalacion.setSelectt(inst.getSelecionado());
                            JOptionPane.showMessageDialog(null, "Rechazado");
                        }else{
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    }
                    /*Paso 1*/
                    else if(instalacion.getProceso().equalsIgnoreCase("En Diseño")){
                        instalacion.setSelectt("1");
                        instalacion.setProceso("Espera Aprobación Tecnica");
                        noti.setModulo("Ventas");
                        noti.setInstalacion(instalacion.getProceso());
                        inst.getjButton6().setText("Aprobación Tecnica");
                        inst.getjButton6().setVisible(true);
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        JOptionPane.showMessageDialog(null, "Espera Aprobación Tecnica");
                    }
                    /*Paso 2*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Espera Aprobación Tecnica")){
               
                        prof= inst.getjComboBox9().getSelectedItem().toString();
                        py2=helper.getlistaProyectos2(insta, prof);
                        proyecto=py2;
                        list=helper.getlistaProductos(Integer.toString(py2.getId()));
                        est = (Estatico) helper.obtenerObjeto(Estatico.class, 1);
                        py2.setSubproyecto(est.getProforma());
                        py2.setNumero(est.getProforma());
                        helper.actualizarObjeto(py2);
                        
                        int num2;
                        String cad2=est.getProforma().split("-")[0]; //6 digitos
                        String cad1=est.getProforma().split("-")[1]; //4 digitos
                        
                        int num1 = Integer.parseInt(cad1);
                        
                        num1++;
                        
                        cad1= Integer.toString(num1);
                        
                        while(cad1.length()<4){
                            cad1= "0"+cad1;
                        }
                        if(cad1.length()>4){
                            cad1="0000";
                            num2 = Integer.parseInt(cad2);
                            num2++;
                            cad2= Integer.toString(num2);
                        }
                        while(cad2.length()!=6){
                            cad2= "0"+cad2;
                        }
                        est.setProforma(cad2+"-"+cad1);
                        
                        if(list!=null){
                            for (Productos list1 : list) {
                                Productos p = new Productos();
                                p.setCantidad(list1.getCantidad());
                                p.setDescripcion(list1.getDescripcion());
                                p.setUnitario(list1.getUnitario());
                                p.setTotal(list1.getTotal());
                                p.setSerial(list1.getSerial());
                                p.setProyecto(cad2+"-"+cad1);
                                helper.crearObjeto(p);
                                product.add(p);
                            }
                        }
                        list2= helper.getlistaProyectos1(insta);
                        
                        inst.getjComboBox9().removeAllItems();
                        if(list2!=null){
                            for (Proyectos list21 : list2) {
                                inst.getjComboBox9().addItem(list21.getSubproyecto());
                            }
                        }else{
                            inst.getjButton6().setVisible(false);
                        }
                        Date fecha = new Date();
                        DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
                        String s3= df3.format(fecha);
                        py2.setFecha(s3);
                        instalacion.setSelectt(inst.getSelecionado());
                        noti.setModulo("Ventas");
                        noti.setInstalacion(instalacion.getProceso());
                        instalacion.setProceso("Aprobación Tecnica");
                        JOptionPane.showMessageDialog(null, "Proforma Aprobada");
                        inst.getjButton6().setText("Enviar a Cliente");
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        pdf(proyecto,product);
                    }
                    /*Paso 3*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Aprobación Tecnica")){
                        instalacion.setProceso("Enviada a Cliente");
                        noti.setModulo("Ventas");
                        noti.setInstalacion(instalacion.getProceso());
                        inst.getjButton6().setText("Aceptado (A) - Rechazado (R)");
                        inst.getjButton6().setVisible(true);
                        JOptionPane.showMessageDialog(null, "Enviada a Cliente");
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    }
                    /*Paso 5*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Aceptada por Cliente")){
                        instalacion.setProceso("Espera Aprobación Financiera");
                        noti.setModulo("Ventas");
                        noti.setInstalacion(instalacion.getProceso());
                        inst.getjButton6().setText("Aprobación Financiera");
                        inst.getjButton6().setVisible(true);
                        JOptionPane.showMessageDialog(null, "Espera Aprobación Financiera");
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    }
                    /*Paso 6*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Espera Aprobación Financiera")){
                        instalacion.setProceso("Aprobación Financiera");
                        inst.getjButton6().setVisible(true);
                        noti.setModulo("Contable");
                        noti.setInstalacion(instalacion.getProceso());
                        /*Angelmath*/
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        pdf(proyecto,list);
                        JOptionPane.showMessageDialog(null, "Aprobación Financiera");
                    }
                    
                    /**************************************************/
                }else{
                    if(instalacion.getProceso().equalsIgnoreCase("Enviada a Cliente")){
                        String selectedSiteName2 = JOptionPane.showInputDialog(null,"Aceptado (A) - Rechazado (R)");
                        if(selectedSiteName2.equalsIgnoreCase("A")){
                            instalacion.setProceso("Aceptada por Cliente");
                            inst.getjButton6().setVisible(true);
                            instalacion.setSelectt(inst.getSelecionado());
                            noti.setModulo("Ventas");
                            noti.setInstalacion(instalacion.getProceso());
                            JOptionPane.showMessageDialog(null, "Aceptado");
                        }else if(selectedSiteName2.equalsIgnoreCase("R")){
                            instalacion.setProceso("Rechazada por Cliente");
                            noti.setModulo("Ventas");
                            noti.setInstalacion(instalacion.getProceso());
                            inst.getjButton6().setVisible(false);
                            instalacion.setSelectt(inst.getSelecionado());
                            JOptionPane.showMessageDialog(null, "Rechazado");
                        }else{
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    }
                    /*Paso 1*/
                    else if(instalacion.getProceso().equalsIgnoreCase("En Diseño")){
                        if(inst.getjComboBox11().getItemCount()!=0){
                            instalacion.setProceso("Espera Aprobación Tecnica");
                            noti.setModulo("Ventas");
                            noti.setInstalacion(instalacion.getProceso());
                            inst.getjButton6().setText("Aprobación Tecnica");
                            if(!Usuario.getNivel().equalsIgnoreCase("Administrador")){
                                inst.getjButton6().setVisible(false);
                            }else{
                                inst.getjButton6().setVisible(true);
                            }
                            helper.actualizarObjeto(instalacion);
                            helper.crearObjeto(noti);
                            helper.confirmarTransaccion();
                            helper.cerrarSesion();
                            JOptionPane.showMessageDialog(null, "Espera Aprobación Tecnica");
                        }else{
                            JOptionPane.showMessageDialog(null, "Diseño no Ingresado");
                        }
                    }
                    /*Paso 2*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Espera Aprobación Tecnica")){
                        prof= inst.getjComboBox9().getSelectedItem().toString();
                        py2=helper.getlistaProyectos2(insta, prof);
                        proyecto=py2;
                        list=helper.getlistaProductos(Integer.toString(py2.getId()));
                        est = (Estatico) helper.obtenerObjeto(Estatico.class, 1);
                        py2.setSubproyecto(est.getProforma());
                        py2.setNumero(est.getProforma());
                        helper.actualizarObjeto(py2);
                        
                        int num2;
                        String cad2=est.getProforma().split("-")[0]; //6 digitos
                        String cad1=est.getProforma().split("-")[1]; //4 digitos
                        
                        int num1 = Integer.parseInt(cad1);
                        
                        num1++;
                        
                        cad1= Integer.toString(num1);
                        
                        while(cad1.length()<4){
                            cad1= "0"+cad1;
                        }
                        if(cad1.length()>4){
                            cad1="0000";
                            num2 = Integer.parseInt(cad2);
                            num2++;
                            cad2= Integer.toString(num2);
                        }
                        while(cad2.length()!=6){
                            cad2= "0"+cad2;
                        }
                        est.setProforma(cad2+"-"+cad1);
                        
                        if(list!=null){
                            for (Productos list1 : list) {
                                Productos p = new Productos();
                                p.setCantidad(list1.getCantidad());
                                p.setDescripcion(list1.getDescripcion());
                                p.setUnitario(list1.getUnitario());
                                p.setTotal(list1.getTotal());
                                p.setSerial(list1.getSerial());
                                p.setProyecto(cad2+"-"+cad1);
                                helper.crearObjeto(p);
                                product.add(p);
                            }
                        }
                        list2= helper.getlistaProyectos1(insta);
                        
                        inst.getjComboBox9().removeAllItems();
                        if(list2!=null){
                            for (Proyectos list21 : list2) {
                                inst.getjComboBox9().addItem(list21.getSubproyecto());
                            }
                        }else{
                            inst.getjButton6().setVisible(false);
                        }
                        
                        Date fecha = new Date();
                        DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
                        String s3= df3.format(fecha);
                        py2.setFecha(s3);
                        instalacion.setSelectt(inst.getSelecionado());
                        
                        instalacion.setProceso("Aprobación Tecnica");
                        JOptionPane.showMessageDialog(null, "Proforma Aprobada");
                        noti.setModulo("Ventas");
                        noti.setInstalacion(instalacion.getProceso());
                        inst.getjButton6().setText("Enviar a Cliente");
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        pdf(proyecto,product);
                    }
                    /*Paso 3*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Aprobación Tecnica")){
                        instalacion.setProceso("Enviada a Cliente");
                        inst.getjButton6().setText("Aceptado (A) - Rechazado (R)");
                        noti.setModulo("Ventas");
                        noti.setInstalacion(instalacion.getProceso());
                        inst.getjButton6().setVisible(true);
                        JOptionPane.showMessageDialog(null, "Enviada a Cliente");
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    }
                    /*Paso 5*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Aceptada por Cliente")){
                        instalacion.setProceso("Espera Aprobación Financiera");
                        noti.setModulo("Ventas");
                        noti.setInstalacion(instalacion.getProceso());
                        inst.getjButton6().setText("Aprobación Financiera");
                        if(!Usuario.getNivel().equalsIgnoreCase("Ventas")){
                            inst.getjButton6().setVisible(false);
                        }else{
                            inst.getjButton6().setVisible(true);
                        }
                        JOptionPane.showMessageDialog(null, "Espera Aprobación Financiera");
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                    }
                    /*Paso 6*/
                    else if(instalacion.getProceso().equalsIgnoreCase("Espera Aprobación Financiera")){
                        instalacion.setProceso("Aprobación Financiera");
                        noti.setModulo("Contable");
                        noti.setInstalacion(instalacion.getProceso());
                        if(!Usuario.getNivel().equalsIgnoreCase("Administrador")){
                            inst.getjButton6().setVisible(false);
                        }else{
                            inst.getjButton6().setVisible(true);
                        }
                        /*Angelmath*/
                        helper.actualizarObjeto(instalacion);
                        helper.crearObjeto(noti);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        pdf(proyecto,list);
                        JOptionPane.showMessageDialog(null, "Aprobación Financiera");
                    }
                    
                }
                
                transiciondeInstalacion(instalacion);
                
            }
            
        }
        if(Usuario.getNivel().equalsIgnoreCase("Administrador")&&selectedSiteName.equalsIgnoreCase("cajamarcajan")){
            Date dd = new Date();
            noti.setFecha(dd);
            noti.setVisto("NO");
            noti.setResponsable(Usuario.getNombre());
            noti.setInformacion("El Cliente "+inst.getjTextField1().getText()+" con proyecto "+inst.getjLabel15().getText()+" cambio de estado");
                ArrayList<Productos> product= new ArrayList<>();
                List<Productos> list=null;
                List<Proyectos> list2=null;
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Instalacion instalacion = (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(insta));
                    /**************************************************/
                if(instalacion.getProceso().equalsIgnoreCase("En Diseño")||instalacion.getProceso().equalsIgnoreCase("Espera Aprobación Tecnica")){
                prof= inst.getjComboBox9().getSelectedItem().toString();
                py2=helper.getlistaProyectos2(insta, prof);
                proyecto=py2;
                list=helper.getlistaProductos(Integer.toString(py2.getId()));
                est = (Estatico) helper.obtenerObjeto(Estatico.class, 1);
                py2.setSubproyecto(est.getProforma());
                py2.setNumero(est.getProforma());
                helper.actualizarObjeto(py2);

                int num2;
                String cad2=est.getProforma().split("-")[0]; //6 digitos
                String cad1=est.getProforma().split("-")[1]; //4 digitos

                int num1 = Integer.parseInt(cad1);

                num1++;

                cad1= Integer.toString(num1);

                while(cad1.length()<4){
                    cad1= "0"+cad1;
                }
                if(cad1.length()>4){
                    cad1="0000";
                    num2 = Integer.parseInt(cad2);
                    num2++;
                    cad2= Integer.toString(num2);
                }
                while(cad2.length()!=6){
                    cad2= "0"+cad2;
                }
                est.setProforma(cad2+"-"+cad1);

                if(list!=null){
                    for (Productos list1 : list) {
                        Productos p = new Productos();
                        p.setCantidad(list1.getCantidad());
                        p.setDescripcion(list1.getDescripcion());
                        p.setUnitario(list1.getUnitario());
                        p.setTotal(list1.getTotal());
                        p.setSerial(list1.getSerial());
                        p.setProyecto(cad2+"-"+cad1);
                        helper.crearObjeto(p);
                        product.add(p);
                    }
                }
                list2= helper.getlistaProyectos1(insta);

                inst.getjComboBox9().removeAllItems();
                if(list2!=null){
                    for (Proyectos list21 : list2) {
                        inst.getjComboBox9().addItem(list21.getSubproyecto());
                    }
                }else{
                    inst.getjButton6().setVisible(false);
                }

                Date fecha = new Date();
                DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
                String s3= df3.format(fecha);
                py2.setFecha(s3);
                instalacion.setSelectt(inst.getSelecionado());
                }
                noti.setModulo("Ventas");
                noti.setInstalacion(instalacion.getProceso());
                instalacion.setProceso("Espera Aprobación Financiera");
                JOptionPane.showMessageDialog(null, "Proforma Aprobada y Transferida");
                inst.getjButton6().setText("Aprobación Financiera");
                if(!Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    inst.getjButton6().setVisible(false);
                }else{
                    inst.getjButton6().setVisible(true);
                }
                helper.actualizarObjeto(instalacion);
                helper.crearObjeto(noti);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                pdf(proyecto,product);
                transiciondeInstalacion(instalacion);
            }                
    }
    
    
    private void setEventoMouseClicked210(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked210(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void tablasmodelos(final JTable pane, final JPanel panel){
        JTableHeader jtableHeader = pane.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        pane.setTableHeader(  jtableHeader );
        jtableHeader.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                base = (DefaultTableModel)pane.getModel();
                sortColumn = pane.getSelectedColumn();
                
                int size = base.getRowCount();
                row = new int[size];
                for (int i = 0; i < size; i++) {
                    row[i] = i;
                }
                for (int i = 1; i < row.length; i++) {
                    int j = i;
                    while (j > 0 && compare(j - 1, j) > 0) {
                        int temp = row[j];
                        row[j] = row[j - 1];
                        row[j - 1] = temp;
                        j--;
                    }
                }
                ArrayList cd = new ArrayList();
                for (int i = 0; i < row.length; i++) {
                    cd.add(((Vector) base.getDataVector().elementAt(row[i])));
                }
                
                while(base.getRowCount()!=0){
                    base.removeRow(0);
                }
                
                for (int i = 0; i < row.length; i++) {
                    base.addRow(((Vector)cd.get(i)).toArray());
                }
                
                pane.setModel(base);
                pane.repaint();
                panel.validate();
                panel.repaint();
                getContentPane().repaint();
            }
        });
    }
    
    private void tblEjemploMouseClicked210(java.awt.event.MouseEvent evt) throws Exception {
        //        ingresoU41 ingresoU41 = new ingresoU41(this, this, true, Usuario, inst.getjTextField1().getText(), insta, cliente);
        //        ServiceHb helper = new ServiceHb();
        //        helper.iniciarTransaccion();
        //        List<Ctepagar>
        //        inst.getjComboBox2().removeAllItems();
        //        if(list7!=null){
        //            for(int i=0; i<list7.size();i++){
        //                inst.getjComboBox2().addItem(list7.get(i).getPdf());
        //            }
        //        }
        //        helper.confirmarTransaccion();
        //        helper.cerrarTransaccion();
        //        helper.cerrarSesion();
    }
    
    private void setEventoMouseClicked211(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setEventoMouseClicked212(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked212(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void tblEjemploMouseClicked212(java.awt.event.MouseEvent evt) throws Exception {
        
    }
    
    public void pyl(String proceso){
        visible(py);
        py.getjScrollPane2().setVisible(false);
        py.getjScrollPane1().setVisible(true);
        List<Ticket> list;
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(proceso.equalsIgnoreCase("1")){
                if(Usuario.getCi().equalsIgnoreCase("0918774159")){
                    list= helper.getTicketsencursoinst();
                }else if(Usuario.getCi().equalsIgnoreCase("0926213885")){
                    list= helper.getTicketsencursopoli();
                }else {
                    list= helper.getTicketsencurso();
                }
                
            }else{
                if(Usuario.getCi().equalsIgnoreCase("0918774159")){
                    list= helper.getTicketsculminadoinst();
                }else if(Usuario.getCi().equalsIgnoreCase("0926213885")){
                    list= helper.getTicketsculminadopoli();
                }else {
                    list= helper.getTicketsculminado();
                }
            }

            helper.cerrarSesion();
            reiniciarJTable(py.getjTable1());
            if(list!=null){
                for (Ticket list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    String c1 = list1.getNumero();
                    String c2 = list1.getCliente();
                    String c3 = list1.getDireccion();
                    String c4 = list1.getEstado();
                    String c5 = list1.getContacto();
                    String c6 = list1.getDetalle();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    DefaultTableModel temp = (DefaultTableModel) py.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8};
                    temp.addRow(nuevo);
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public reportes getRp() {
        return rp;
    }
    
    public void setRp(reportes rp) {
        this.rp = rp;
    }
    
    public cliente getCl() {
        return cl;
    }
    
    public void setCl(cliente cl) {
        this.cl = cl;
    }
    
    public facturacion getFc() {
        return fc;
    }
    
    public void setFc(facturacion fc) {
        this.fc = fc;
    }
    
    public clientes2 getCls2() {
        return cls2;
    }
    
    public void setCls2(clientes2 cls2) {
        this.cls2 = cls2;
    }
    
    public instalacion getInst() {
        return inst;
    }
    
    public void setInst(instalacion inst) {
        this.inst = inst;
    }
    
    public configuracion getPf() {
        return pf;
    }
    
    public void setPf(configuracion pf) {
        this.pf = pf;
    }
    
    public pyl getPy() {
        return py;
    }
    
    public void setPy(pyl py) {
        this.py = py;
    }
    
    public contable getCont() {
        return cont;
    }
    
    public void setCont(contable cont) {
        this.cont = cont;
    }
    
    public Runnable getIdn1() {
        return idn1;
    }
    
    public ventas getVt() {
        return vt;
    }
    
    public void setVt(ventas vt) {
        this.vt = vt;
    }
    
    public void setIdn1(Runnable idn1) {
        this.idn1 = idn1;
    }
    
    public Runnable getIdn2() {
        return idn2;
    }
    
    public void setIdn2(Runnable idn2) {
        this.idn2 = idn2;
    }
    
    public String getResponsable() {
        return responsable;
    }
    
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    public Runnable getIdn3() {
        return idn3;
    }
    
    public void setIdn3(Runnable idn3) {
        this.idn3 = idn3;
    }
    
    public String getInsta() {
        return insta;
    }
    
    public void setInsta(String insta) {
        this.insta = insta;
    }
    
    public String getProf() {
        return prof;
    }
    
    public void setProf(String prof) {
        this.prof = prof;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public Dimension getD() {
        return d;
    }
    
    public void setD(Dimension d) {
        this.d = d;
    }
    
    public int getPdfcarga() {
        return pdfcarga;
    }
    
    public void setPdfcarga(int pdfcarga) {
        this.pdfcarga = pdfcarga;
    }
    
    public void clientes(){
        List<Clientes> list=null;
        ServiceHb helper = new ServiceHb();
        try{
            if(Usuario.getNivel().equalsIgnoreCase("Administrador")||Usuario.getNivel().equalsIgnoreCase("Ventas")){
                visible(cls2);
                cls2.getjScrollPane1().setVisible(true);
                cls2.getjScrollPane2().setVisible(false);
                cls2.getjButton1().setVisible(true);
                cls2.getjLabel2().setText("Lista de Clientes");
                
                helper.iniciarTransaccion();
                if(Usuario.getNivel().equalsIgnoreCase("Ventas")){
                    visible(cls2);
                    list = helper.getlistaClientes2(Usuario.getId());
                }else if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list = helper.getlistaClientes();
                }
                reiniciarJTable(cls2.getjTable1());
                if(list!=null){
                    DefaultTableModel temp = (DefaultTableModel) cls2.getjTable1().getModel();
                    for(Clientes x: list){
                        if(breakhilo==1){
                            break;}
                        String c1=x.getRuc();
                        String c2=x.getApellido();
                        String c3=x.getPersona();
                        String c4=x.getNombre();
                        String c5=x.getNumero1();
                        String c6="";
                        String c7="";
                        if(x.getLogin2()!=null){
                            c6 = x.getLogin2().getNombre();
                        }
                        if(x.getLogin2()!=null){
                            c7 = x.getLogin3().getNombre();
                        }
                        String c8 = x.getCorreo();
                        String c9 = "" + x.getId();

                        Object nuevo[]= {c2,c1,c3,c4,c5,c6,c7,c8,c9};
                        temp.addRow(nuevo);
                    }
                }else if(Usuario.getNivel().equalsIgnoreCase("PYL")){
                    visible(py);
                    inst.getjButton21().setVisible(true);
                }else if(Usuario.getNivel().equalsIgnoreCase("Contable")){
                    inst.getjButton4().setVisible(true);// Boton Descargar Reporte Oculto - Instalacion
                    inst.getjButton21().setVisible(true);// Boton Elimiar Facturacion Oculto - Instalacion
                    inst.getjButton15().setVisible(true);// Boton Cargar Facturacion Oculto - Instalacion
                    visible(vt);// Muestra el panel ventas
                    vt.getjLabel7().setText("Instalaciones Culminadas");/*Angelmath*/
                    pyl1c();/*Angelmath*/
                    pyl1();/*Angelmath*/
                }
                helper.cerrarSesion();
            }
        } catch (Exception ex) {
            //Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clienteinst(String tipo){
        try{
            if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                visible(cls2);
            }else if(Usuario.getNivel().equalsIgnoreCase("PYL")){
                visible(py);
                inst.getjButton21().setVisible(true);
            }else if(Usuario.getNivel().equalsIgnoreCase("Instalador")){
                visible(vt);
                pyl1c();
            }
            List<Instalacion> list=null;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(tipo.equalsIgnoreCase("En Curso")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionesencurso();
                }else if(Usuario.getId()==23){
                    list=helper.getlistaInstalacionesencurso2();
                }else{
                    list=helper.getlistaInstalacionesencurso(Usuario);
                }
                cls2.getjLabel2().setText("Instalaciones En Diseño");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
                cls2.getjButton1().setVisible(false);
            }if(tipo.equalsIgnoreCase("En Aprovacion")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionesenaprobacion();
                }else if(Usuario.getId()==23){
                    list=helper.getlistaInstalacionesenaprobacion2();
                }else{
                    list=helper.getlistaInstalacionesenaprobacion(Usuario);
                }
                cls2.getjLabel2().setText("Instalaciones En Aprobacion");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
                cls2.getjButton1().setVisible(false);
            }
            if(tipo.equalsIgnoreCase("Aprovacion")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionaprobada();
                }if(Usuario.getId()==23){
                    list=helper.getlistaInstalacionaprobada2();
                }else{
                    list=helper.getlistaInstalacionaprobada(Usuario);
                }
                
                cls2.getjLabel2().setText("Instalaciones Aprobadas");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
            }
            if(tipo.equalsIgnoreCase("Aceptado")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionAceptada();
                }else if(Usuario.getId()==23){
                    list=helper.getlistaInstalacionAceptada2();
                } else{
                    list=helper.getlistaInstalacionAceptada(Usuario);
                }
                cls2.getjLabel2().setText("Instalaciones Aceptadas por Cliente");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
            }
            if(tipo.equalsIgnoreCase("Enviado")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionEnviada();
                }else if(Usuario.getId()==23){
                    list=helper.getlistaInstalacionEnviada2();
                }else{
                    list=helper.getlistaInstalacionEnviada(Usuario);
                }
                cls2.getjLabel2().setText("Instalaciones Enviadas al Cliente");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
            }
            
            if(tipo.equalsIgnoreCase("Aceptado por Cliente")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionAceptada();
                }else if(Usuario.getId()==23){
                    list=helper.getlistaInstalacionAceptada3();
                }else{
                    list=helper.getlistaInstalacionAceptada(Usuario);
                }
                cls2.getjLabel2().setText("Instalaciones Aceptadas");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
            }
            if(tipo.equalsIgnoreCase("Gregory")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionEstados();
                }else{
                    list=helper.getlistaInstalacionEstados(Usuario);
                }
                cls2.getjLabel2().setText("Instalaciones Aceptadas");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
            }
            if(tipo.equalsIgnoreCase("Rechazada por Cliente")){
                if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                    list=helper.getlistaInstalacionRechazada();
                }else if(Usuario.getId()==23){
                    list=helper.getlistaInstalacionRechazada2();
                }else{
                    list=helper.getlistaInstalacionRechazada(Usuario);
                }
                cls2.getjLabel2().setText("Instalaciones Rechazadas");
                cls2.getjScrollPane1().setVisible(false);
                cls2.getjScrollPane2().setVisible(true);
            }
            reiniciarJTable(cls2.getjTable2());
            
            if(list!=null){
                for(Instalacion x: list){
                    if(breakhilo==1){break;}
                    String c1=x.getClientes().getApellido();
                    String c2=x.getDetalle();
                    String c3=formatoFecha(x.getFecha());
                    String c4=x.getTipo();
                    String c5=""+x.getId();
                    DefaultTableModel temp = (DefaultTableModel) cls2.getjTable2().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5};
                    temp.addRow(nuevo);
                }
            }else{
                reiniciarJTable(cls2.getjTable1());
            }
            
            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void clientes2(){
        List<Clientes> list = null;
        List<Login> list2;
        List<Instalacion> pendiente;
        try{
            if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                visible(cls2);
            }else if(Usuario.getNivel().equalsIgnoreCase("PYL")){
                visible(py);
            }else if(Usuario.getNivel().equalsIgnoreCase("Instalador")){
                visible(vt);
                pyl1c();
            }
            
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list = helper.getlistaClientes();
            for(int j=list.size()-1; j>0;j--){
                pendiente= helper.getlistaInstalaciones2(list.get(j).getId());
                if(pendiente==null){
                    list.remove(j);
                }
            }
            
            list2 = helper.getlistaUsuarios();
            helper.cerrarSesion();
            reiniciarJTable(cls2.getjTable1());
            
            if(list!=null){
                for(int i=0; i<list.size();i++){
                        
                    String c1=list.get(i).getRuc();
                    String c2=list.get(i).getApellido();
                    String c3=list.get(i).getPersona();
                    String c4=list.get(i).getNombre();
                    String c5=list.get(i).getNumero1();
                    String c6=list.get(i).getCorreo();
                    DefaultTableModel temp = (DefaultTableModel) cls2.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6};
                    temp.addRow(nuevo);
                    
                    for(Login lo : list2){
                        if(lo.getCi().equalsIgnoreCase(list.get(i).getResponsable())){
                            cls2.getjTable1().getModel().setValueAt(lo.getNombre(), i, 5);
                            break;
                        }else{
                            cls2.getjTable1().getModel().setValueAt("Jan Topic", i, 5);
                        }
                    }
                    cls2.getjTable1().getModel().setValueAt(list.get(i).getId(), i, 7);
                    
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void config(){
        
        List<Login> list;
        try {
            visible(pf);
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Estatico est= (Estatico)helper.obtenerObjeto(Estatico.class, 1);
            pf.getjTextField1().setText(est.getProforma());
            pf.getjTextField2().setText(est.getDirectorio());
            pf.getjTextField3().setText(est.getTicket());
            list = helper.getlistaUsuarios();
            helper.cerrarSesion();
            reiniciarJTable(pf.getjTable2());
            
            for (Login list1 : list) {
                String c1 = list1.getCi();
                String c2 = list1.getNombre();
                String c3 = list1.getUsuario();
                String c4 = list1.getPass();
                String c5 = list1.getNivel();
                String c6 = list1.getDireccion();
                DefaultTableModel temp = (DefaultTableModel) pf.getjTable2().getModel();
                Object nuevo[]= {c1,c2,c3,c4,c5,c6};
                temp.addRow(nuevo);
            }
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jLabel8MousePressed
    
    private void jLabel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(point.x - xx, point.y - yy);
    }//GEN-LAST:event_jLabel8MouseDragged
    
    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        System.exit(0); 
    }//GEN-LAST:event_jLabel16MouseClicked
    
    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseEntered
    
    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseExited
            
    public boolean isRegreso() {
        return regreso;
    }
    
    public void setRegreso(boolean regreso) {
        this.regreso = regreso;
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
    
    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        permisos permisos = new permisos(Usuario);
        dispose();
    }//GEN-LAST:event_jLabel18MouseClicked
    
    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered
    
    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(cl.isVisible()){
            accesoUsuario();
        }else  if(cls2.isVisible()){
            permisos permisos = new permisos(Usuario);
            dispose();
        }else if(inst.isVisible()){
            backinst();
        }else if(fc.isVisible()){
            visible(inst);
        }else if(ma.isVisible()){
            visible(inst);
        }else if(vt.isVisible()){
            interfasecont m = new interfasecont(Usuario);
            dispose();
        }
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-back-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-back-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-fwd-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-fwd-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        JOptionPane.showMessageDialog(null, "No habilitado");
    }//GEN-LAST:event_jLabel3MouseClicked
    
    public void pyl1(){
        List<Instalacion> list;
        py.getjLabel10().setBackground(new Color(255,255,255));
        py.getjLabel11().setBackground(new Color(212,208,200));
        py.getjLabel9().setBackground(new Color(212,208,200));
        py.getjLabel12().setBackground(new Color(212,208,200));
        py.getjScrollPane1().setVisible(false);
        py.getjScrollPane2().setVisible(true);
        ServiceHb helper = new ServiceHb();
        py.getjLabel7().setText("Instalaciones Aceptadas");
        try {
            helper.iniciarTransaccion();
            if(Usuario.getCi().equalsIgnoreCase("0918774159")){
                list= helper.getlistaInstalacionpyl1inst("Aprobación Financiera");
            }else if(Usuario.getCi().equalsIgnoreCase("0926213885")){
                list= helper.getlistaInstalacionpyl1poli("Aprobación Financiera");
            }else {
                list= helper.getlistaInstalacionpyl1("Aprobación Financiera");
            }
            reiniciarJTable(py.getjTable2());
            
            if(list!=null){
                for (Instalacion list1 : list) {
                    if(breakhilo==1){
                        break;}
                    Clientes clie = list1.getClientes();
                    String c1=clie.getApellido();
                    String c2=clie.getNombre();
                    String c3 = list1.getDetalle();
                    String c4 = formatoFecha(list1.getFecha());
                    String c5 = list1.getProceso();
                    String c6 = "" + list1.getId();
                    String c7 = "" + list1.getId();
                    DefaultTableModel temp = (DefaultTableModel) py.getjTable2().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                    temp.addRow(nuevo);
                }
            }

            helper.cerrarSesion();
        } catch (Exception ex) {
        }
    }
    
    
    public void proveedor(){
        List<Proveedores> list;
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list= helper.getlistaProveedores();
            reiniciarJTable(vt.getjTable2());
            
            if(list!=null){
                for (Proveedores list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    String c1 = list1.getRazon();
                    String c2 = list1.getRuc();
                    String c3 = list1.getContacto();
                    String c4 = list1.getNumero();
                    String c5 = list1.getCorreo();
                    String c6 = list1.getDireccion();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    String c9 = "" + list1.getId();
                    Object c10 = list1;
                    DefaultTableModel temp = (DefaultTableModel) vt.getjTable2().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
                    temp.addRow(nuevo);
                }
            }

            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pyl1c(){
        vt.getjScrollPane1().setVisible(true);
        vt.getjScrollPane2().setVisible(false);
        vt.getjButton1().setVisible(false);
        inst.getjButton6().setVisible(false);
        
        transicionventas(vt.getjLabel10());
        List<Instalacion> list;
        
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list= helper.getlistaInstalacionpyl1a();
            reiniciarJTable(vt.getjTable1());
            
            if(list!=null){
                for (Instalacion list1 : list) {
                    if(breakhilo==1){break;}
                    Clientes clie = list1.getClientes();
                    String c1=clie.getApellido();
                    String c2=clie.getNombre();
                    String c3 = list1.getDetalle();
                    String c4 = formatoFecha(list1.getFecha());
                    String c5 = list1.getTipo();
                    String c6 = list1.getProceso();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    String c9 = "" + list1.getPendiente();
                    DefaultTableModel temp = (DefaultTableModel) vt.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
            vt.getjTable1().getColumnModel().getColumn(6).setMaxWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());
            vt.getjTable1().getColumnModel().getColumn(6).setMinWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMaxWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMinWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());

            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pyl1f(){
        vt.getjScrollPane1().setVisible(true);
        vt.getjScrollPane2().setVisible(false);
        vt.getjButton1().setVisible(false);
        inst.getjButton6().setVisible(false);
        
        List<Instalacion> list;
        ServiceHb helper = new ServiceHb();
        String n="";
        try {
            helper.iniciarTransaccion();
            list= helper.getlistaInstalacionpyl1("Facturado");
            reiniciarJTable(vt.getjTable1());
            
            if(list!=null){
                for (Instalacion list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    n = "" + list1.getId();
                    Clientes clie = list1.getClientes();
                    String c1=clie.getApellido();
                    String c2=clie.getNombre();
                    String c3 = list1.getDetalle();
                    String c4="";
                    if (vt.getjLabel7().getText().equalsIgnoreCase("Instalaciones Facturadas")) {
                        if (list1.getFechaanticipo() != null) {
                            c4 = Funcion.DateFormat(list1.getFechaanticipo());
                        } else if (list1.getFechafactu() != null) {
                            c4 = Funcion.DateFormat(list1.getFechafactu());
                        } else {
                            c4="Actualizar";
                        }
                    } else {
                        c4 = formatoFecha(list1.getFecha());
                    }
                    String c5 = list1.getTipo();
                    String c6 = list1.getProceso();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    String c9 = list1.getPendiente();
                    DefaultTableModel temp = (DefaultTableModel) vt.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
            vt.getjTable1().getColumnModel().getColumn(6).setMaxWidth(60);
            vt.getjTable1().getColumnModel().getColumn(6).setMinWidth(60);
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMaxWidth(60);
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMinWidth(60);
            
            if(Usuario.getNivel().equalsIgnoreCase("Asistente")){
                vt.getjTable1().getColumnModel().getColumn(7).setMaxWidth(0);
                vt.getjTable1().getColumnModel().getColumn(7).setMinWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
                vt.getjTable1().getColumnModel().getColumn(8).setMaxWidth(0);
                vt.getjTable1().getColumnModel().getColumn(8).setMinWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            }

            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex+n);
        }
    }
    
    public void pyl1fechas(){
        vt.getjScrollPane1().setVisible(true);
        vt.getjScrollPane2().setVisible(false);
        vt.getjButton1().setVisible(false);
        inst.getjButton6().setVisible(false);
        
        List<Instalacion> list;
        ServiceHb helper = new ServiceHb();
        String n="";
        try {
            helper.iniciarTransaccion();
            list= helper.getlistaInstalacionFinan(0);
            reiniciarJTable(vt.getjTable1());
            
            if(list!=null){
                for (Instalacion list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    n = "" + list1.getId();
                    Clientes clie = list1.getClientes();
                    String c1=clie.getApellido();
                    String c2=clie.getNombre();
                    String c3 = list1.getDetalle();
                    String c4="";
                    if (list1.getFechaanticipo() != null) {
                        c4 = Funcion.DateFormat(list1.getFechaanticipo());
                    } else if (list1.getFechafactu() != null) {
                        c4 = Funcion.DateFormat(list1.getFechafactu());
                    } else {
                        c4="Actualizar";
                    }
                    String c5 = list1.getTipo();
                    String c6 = list1.getProceso();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    String c9 = list1.getPendiente();
                    DefaultTableModel temp = (DefaultTableModel) vt.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
            vt.getjTable1().getColumnModel().getColumn(6).setMaxWidth(60);
            vt.getjTable1().getColumnModel().getColumn(6).setMinWidth(60);
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMaxWidth(60);
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMinWidth(60);
            
            if(Usuario.getNivel().equalsIgnoreCase("Asistente")){
                vt.getjTable1().getColumnModel().getColumn(7).setMaxWidth(0);
                vt.getjTable1().getColumnModel().getColumn(7).setMinWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
                vt.getjTable1().getColumnModel().getColumn(8).setMaxWidth(0);
                vt.getjTable1().getColumnModel().getColumn(8).setMinWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
                vt.getjTable1().getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            }

            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex+n);
        }
    }
    
    public void pyl12ca(){
        vt.getjScrollPane1().setVisible(true);
        vt.getjScrollPane2().setVisible(false);
        vt.getjButton1().setVisible(false);
        inst.getjButton6().setVisible(false);
        
        List<Instalacion> list;
        ServiceHb helper = new ServiceHb();
        try {
            helper.iniciarTransaccion();
            list= helper.getlistaInstalacionpyl1("Espera Aprobación Financiera");
            reiniciarJTable(vt.getjTable1());
            
            if(list!=null){
                for (Instalacion list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    Clientes clie = list1.getClientes();
                    String c1=clie.getApellido();
                    String c2=clie.getNombre();
                    String c3 = list1.getDetalle();
                    String c4 = formatoFecha(list1.getFecha());
                    String c5 = list1.getTipo();
                    String c6 = list1.getProceso();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    String c9 = list1.getPendiente();
                    DefaultTableModel temp = (DefaultTableModel) vt.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
            

            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void pyl1ca(){
        vt.getjScrollPane1().setVisible(true);
        vt.getjScrollPane2().setVisible(false);
        vt.getjButton1().setVisible(false);
        inst.getjButton6().setVisible(false);
        
        List<Instalacion> list;
        ServiceHb helper = new ServiceHb();
        try {
            helper.iniciarTransaccion();
            list= helper.getlistaInstalacionpyl1("Cancelado");
            reiniciarJTable(vt.getjTable1());
            
            if(list!=null){
                for (Instalacion list1 : list) {
                    if(breakhilo==1){
                        break;
                    }
                    Clientes clie = list1.getClientes();
                    String c1=clie.getApellido();
                    String c2=clie.getNombre();
                    String c3 = list1.getDetalle();
                    String c4 = formatoFecha(list1.getFecha());
                    String c5 = list1.getTipo();
                    String c6 = list1.getProceso();
                    String c7 = "" + list1.getId();
                    String c8 = "" + list1.getId();
                    String c9 = list1.getPendiente();
                    DefaultTableModel temp = (DefaultTableModel) vt.getjTable1().getModel();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
            vt.getjTable1().getColumnModel().getColumn(6).setMaxWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());
            vt.getjTable1().getColumnModel().getColumn(6).setMinWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMaxWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());
            vt.getjTable1().getTableHeader().getColumnModel().getColumn(6).setMinWidth(vt.getjTable1().getColumnModel().getColumn(7).getMaxWidth());
            

            helper.cerrarSesion();
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void visible(JPanel pane){
        cl.setVisible(false);
        cls2.setVisible(false);
        fc.setVisible(false);
        inst.setVisible(false);
        py.setVisible(false);
        rp.setVisible(false);
        ma.setVisible(false);
        pf.setVisible(false);
        vt.setVisible(false);
        cont.setVisible(false);
        pane.setVisible(true);
    }
    
    
    public void pdf(Proyectos py, List<Productos> lista){
        //String imagepath = Server.MapPath("Images");
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        
        Clientes c2=null;
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Instalacion in = helper.getInstalacion(py.getInstalacion());
            c2 = in.getClientes();
            
            int cell=16;
            
            ficheroPdf = new FileOutputStream(Usuario.getDireccion()+"/"+py.getNumero()+".pdf");
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            
            
            documento.open();
            //aqui agregamos todo el contenido del PDF...
            documento.add(new Paragraph(" "));
            Image image1 = Image.getInstance(Usuario.getDireccion()+"/logo.png");
            image1.scaleAbsolute(115f, 41f);
            
            image1.setAlignment(1);
            documento.add(image1);
            documento.add(new Paragraph(" "));
            
            String s3;
            Date fecha =null;
            if(py.getFecha()!=null){
                s3=py.getFecha();
            }
            else{
                DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
                s3= df3.format(new Date());
            }
            Phrase parrafo1 = new Phrase("PROFORMA DE VENTA No.:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo1a = new Phrase(py.getNumero(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            Phrase parrafo2 = new Phrase("ASESOR COMERCIAL:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo2a = new Phrase(c2.getLogin().getNombre(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            Phrase parrafo3 = new Phrase("CLIENTE:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo3a = new Phrase(c2.getApellido(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            
            Phrase parrafo4 = new Phrase("FECHA:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo4a = new Phrase(s3,new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            
            Phrase parrafo5;
            Phrase parrafo5a;
            if(c2.getRuc().equalsIgnoreCase("")){
                parrafo5 = new Phrase("RUC / CI:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
                parrafo5a = new Phrase("NO DISPONIBLE",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            }
            else{
                parrafo5 = new Phrase("RUC / CI:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
                parrafo5a = new Phrase(c2.getRuc(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            }
            
            
            Phrase parrafo6 = new Phrase("Costo Comercial:",new Font(Font.HELVETICA, 8, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo6a = new Phrase("$"+convert(py.getTotal().substring(1, py.getTotal().length())),new Font(Font.HELVETICA, 8, Font.NORMAL, new Color(0, 0, 0)));
            
            PdfPCell celda = new PdfPCell();
            float[] widths = {1f, 1f, 0.3f, 0.6f,1f};
            PdfPTable tb = new PdfPTable(widths);
            
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo1);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo1a);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo4);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo4a);
            tb.addCell(celda);
            /*--------------------------------*/
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo2);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo2a);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo3);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo3a);
            tb.addCell(celda);
            
            /*--------------------------------*/
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo5);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo5a);
            tb.addCell(celda);
            
            /*--------------------------------*/
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            /*--------------------------------*/
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo6);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo6a);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            documento.add(tb);
            
            
            Paragraph prueba = new Paragraph();
            prueba.setSpacingAfter(TOP_ALIGNMENT);
            documento.add(new Paragraph(" "));
            
            Paragraph parrafo3b = new Paragraph("PROFORMA DE VENTA",new Font(Font.HELVETICA, 11, Font.BOLD, new Color(0, 0, 255)));
            parrafo3b.setAlignment(1);
            documento.add(parrafo3b);
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidths(new float[]{1,4,1,2});
            
            
            celda = new PdfPCell(new Phrase("CANT",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(216,216,216));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("DESCRIPCIÓN",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(1);
            celda.setBorder(0);
            celda.setPaddingTop(6);
            celda.setBackgroundColor(new Color(216,216,216));
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("P.UNIT",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(1);
            celda.setPaddingTop(6);
            celda.setBorder(0);
            celda.setBackgroundColor(new Color(216,216,216));
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("PRECIO TOTAL",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(1);
            celda.setPaddingTop(6);
            celda.setBorder(0);
            celda.setBackgroundColor(new Color(216,216,216));
            tabla.addCell(celda);
            /*ESTANDAR*/
            
            
            
            int canti=1;
            
            for(Productos i: lista){
                if(canti>16){
                    celda = new PdfPCell(new Phrase(i.getCantidad(),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(1);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(i.getDescripcion(),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(0);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    celda = new PdfPCell(new Phrase("$"+convert(i.getUnitario()),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase("$"+convert(i.getTotal().substring(1,i.getTotal().length())),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    /*  Espacios  */
                    
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                }else{
                    celda = new PdfPCell(new Phrase(i.getCantidad(),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(1);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(i.getDescripcion(),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(0);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    celda = new PdfPCell(new Phrase("$"+convert(i.getUnitario()),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase("$"+convert(i.getTotal().substring(1,i.getTotal().length())),new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    /*  Espacios  */
                    
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                }
                canti++;
            }
            
            int tam=lista.size();
            if(tam<16){
                while((cell-tam)>0){
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    cell--;
                }
                
            }
            tabla.setHorizontalAlignment(1);
            documento.add(tabla);
            
            tabla = new PdfPTable(3);
            tabla.setWidths(new float[]{5,1,1});
            
            celda = new PdfPCell(new Phrase("Observaciones: "+py.getObservacion1(),new Font(Font.HELVETICA, 7, Font.NORMAL, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("SUBTOTAL",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("$"+convert(py.getSubtotal().substring(1, py.getSubtotal().length())),new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Garantia:                    "+py.getGmeses()+" meses\nTiempo de Entrega:   "+py.getGtiempo()+" dias\nValidez de Oferta:      "+py.getGvalidez()+" dias",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(164, 164, 164))));
            celda.setFixedHeight(20);
            celda.setRowspan(2);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            celda = new PdfPCell(new Phrase("IVA 12%",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("$"+convert(py.getIva().substring(1, py.getIva().length())),new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("TOTAL",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 255))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("$"+convert(py.getTotal().substring(1, py.getTotal().length())),new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 255))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            documento.add(tabla);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            
            
            
            tabla = new PdfPTable(2);
            tabla.setWidths(new float[]{1,1});
            
            
            celda = new PdfPCell(new Phrase("Para consultas, dirigirse con:",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            celda = new PdfPCell(new Phrase("Los pagos se realizan con la sgte información",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            /*-----------------------------------------*/
            
            Instalacion ina = helper.getInstalacion(py.getInstalacion());
            Clientes c= ina.getClientes();
            
            celda = new PdfPCell(new Phrase(c.getLogin().getNombre()+" Coordinación de Ventas",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            helper.cerrarSesion();
            
            celda = new PdfPCell(new Phrase("Cajamarca Protective Services",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("(04) 2287275 Ext. 5003",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("RUC: 0992810572001",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Email: ventas@cajamarca.ec",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Piedrahita 1501, Entre los Rios y Esmeraldas",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            
            celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(0, 0, 0))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            celda = new PdfPCell(new Phrase("Guayaquil - Ecuador",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            documento.add(tabla);
            documento.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        
    }
    
    
    public void pdf(Proyectos py, ArrayList<Productos> lista){
        //String imagepath = Server.MapPath("Images");
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        
        Clientes c2=null;
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Instalacion in = helper.getInstalacion(py.getInstalacion());
            c2 = in.getClientes();
            
            int cell=22;
            
            ficheroPdf = new FileOutputStream(Usuario.getDireccion()+"/"+py.getNumero()+".pdf");
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(15);
            
            
            documento.open();
            //aqui agregamos todo el contenido del PDF...
            Image image1 = Image.getInstance(Usuario.getDireccion()+"/logo.png");
            image1.scaleAbsolute(115f, 41f);
            
            image1.setAlignment(1);
            documento.add(image1);
            documento.add(new Paragraph(" "));
            
            String s3;
            Date fecha =null;
            if(py.getFecha()!=null){
                s3=py.getFecha();
            }
            else{
                DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
                s3= df3.format(new Date());
            }
            Phrase parrafo1 = new Phrase("PROFORMA DE VENTA No.:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo1a = new Phrase(py.getNumero(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            Phrase parrafo2 = new Phrase("ASESOR COMERCIAL:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo2a = new Phrase(inst.getjTextField8().getText(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            Phrase parrafo3 = new Phrase("CLIENTE:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo3a = new Phrase(c2.getApellido(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            
            Phrase parrafo4 = new Phrase("FECHA:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo4a = new Phrase(s3,new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            
            Phrase parrafo5;
            Phrase parrafo5a;
            if(c2.getRuc().equalsIgnoreCase("")){
                parrafo5 = new Phrase("RUC / CI:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
                parrafo5a = new Phrase("NO DISPONIBLE",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            }
            else{
                parrafo5 = new Phrase("RUC / CI:",new Font(Font.HELVETICA, 6, Font.BOLD, new Color(0, 0, 0)));
                parrafo5a = new Phrase(c2.getRuc(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
            }
            
            
            Phrase parrafo6 = new Phrase("Costo Comercial:",new Font(Font.HELVETICA, 8, Font.BOLD, new Color(0, 0, 0)));
            Phrase parrafo6a = new Phrase("$"+convert(py.getTotal().substring(1, py.getTotal().length())),new Font(Font.HELVETICA, 8, Font.NORMAL, new Color(0, 0, 0)));
            
            PdfPCell celda = new PdfPCell();
            float[] widths = {1f, 1f, 0.3f, 0.6f,1f};
            PdfPTable tb = new PdfPTable(widths);
            
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo1);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo1a);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo4);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo4a);
            tb.addCell(celda);
            /*--------------------------------*/
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo2);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo2a);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo3);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo3a);
            tb.addCell(celda);
            
            /*--------------------------------*/
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo5);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo5a);
            tb.addCell(celda);
            
            /*--------------------------------*/
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo6);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(parrafo6a);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            celda = new PdfPCell();
            celda.setBorder(0);
            celda.addElement(null);
            tb.addCell(celda);
            
            documento.add(tb);
            
            
            Paragraph parrafo3b = new Paragraph("PROFORMA DE VENTA",new Font(Font.HELVETICA, 11, Font.BOLD, new Color(0, 0, 255)));
            parrafo3b.setAlignment(1);
            documento.add(parrafo3b);
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidths(new float[]{1,4,1,2});
            
            
            celda = new PdfPCell(new Phrase("CANT",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(216,216,216));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("DESCRIPCIÓN",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(1);
            celda.setBorder(0);
            celda.setPaddingTop(6);
            celda.setBackgroundColor(new Color(216,216,216));
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("P.UNIT",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(1);
            celda.setPaddingTop(6);
            celda.setBorder(0);
            celda.setBackgroundColor(new Color(216,216,216));
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("PRECIO TOTAL",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(1);
            celda.setPaddingTop(6);
            celda.setBorder(0);
            celda.setBackgroundColor(new Color(216,216,216));
            tabla.addCell(celda);
            /*ESTANDAR*/
            
            
            
            int canti=1;
            
            for(Productos i: lista){
                if(canti>22){
                    celda = new PdfPCell(new Phrase(i.getCantidad(),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(1);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(i.getDescripcion(),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(0);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    celda = new PdfPCell(new Phrase("$"+convert(i.getUnitario()),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase("$"+convert(i.getTotal().substring(1,i.getTotal().length())),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    /*  Espacios  */
                    
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                }else{
                    celda = new PdfPCell(new Phrase(i.getCantidad(),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(1);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(i.getDescripcion(),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(0);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    celda = new PdfPCell(new Phrase("$"+convert(i.getUnitario()),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase("$"+convert(i.getTotal().substring(1,i.getTotal().length())),new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setHorizontalAlignment(2);
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    /*  Espacios  */
                    
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                }
                canti++;
            }
            
            int tam=lista.size();
            if(tam<22){
                while((cell-tam)>0){
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(255, 255, 255));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    
                    
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
                    celda.setBackgroundColor(new Color(242, 242, 242));
                    celda.setBorder(0);
                    tabla.addCell(celda);
                    cell--;
                }
                
            }
            tabla.setHorizontalAlignment(1);
            documento.add(tabla);
            
            tabla = new PdfPTable(3);
            tabla.setWidths(new float[]{5,1,1});
            
            celda = new PdfPCell(new Phrase("Observaciones: "+py.getObservacion1(),new Font(Font.HELVETICA, 7, Font.NORMAL, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("SUBTOTAL",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("$"+convert(py.getSubtotal().substring(1, py.getSubtotal().length())),new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            PdfPTable tablaa = new PdfPTable(4);
            tablaa.setWidths(new float[]{1,1,1,1});
            celda = new PdfPCell(new Phrase("Garantia:\nTiempo de Entrega:\nValidez de Oferta:",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(164, 164, 164))));
            celda.setFixedHeight(20);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tablaa.addCell(celda);
            
            celda = new PdfPCell(new Phrase(""+py.getGmeses()+" meses\n"+py.getGtiempo()+" dias\n"+py.getGvalidez()+" dias",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(164, 164, 164))));
            celda.setFixedHeight(20);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tablaa.addCell(celda);
            
            String cadena1="0";
            String cadena2="0";
            String cadena3="0";
            if(py.getAnticipo()!=null){
                cadena1=py.getAnticipo();
            }
            if(py.getCredito()!=null){
                cadena2=py.getCredito();
            }
            if(py.getDiferido()!=null){
                cadena3=py.getDiferido();
            }
            
            celda = new PdfPCell(new Phrase("Forma de Pago(Anticipo):\nDiferido:\nCrédito:",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(164, 164, 164))));
            celda.setFixedHeight(20);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            
            tablaa.addCell(celda);
            
            celda = new PdfPCell(new Phrase("$ "+cadena1+"\n"+cadena3+" meses\n"+cadena2+" meses",new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(164, 164, 164))));
            celda.setFixedHeight(20);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            
            tablaa.addCell(celda);
            
            celda = new PdfPCell(tablaa);
            celda.setRowspan(2);
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
            celda.setBorder(0);
            
            tabla.addCell(celda);
            
            
            celda = new PdfPCell(new Phrase("IVA 12%",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("$"+convert(py.getIva().substring(1, py.getIva().length())),new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 0))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("TOTAL",new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 255))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("$"+convert(py.getTotal().substring(1, py.getTotal().length())),new Font(Font.HELVETICA, 7, Font.BOLD, new Color(0, 0, 255))));
            celda.setFixedHeight(20);
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            documento.add(tabla);
            
            
            
            
            tabla = new PdfPTable(2);
            tabla.setWidths(new float[]{1,1});
            
            
            celda = new PdfPCell(new Phrase("Para consultas, dirigirse con:",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            celda = new PdfPCell(new Phrase("Los pagos se realizan con la sgte información",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(0, 0, 0))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            /*-----------------------------------------*/
            
            Instalacion ina = helper.getInstalacion(py.getInstalacion());
            Clientes c= ina.getClientes();
            
            celda = new PdfPCell(new Phrase(c.getLogin().getNombre()+" Coordinación de Ventas",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            helper.cerrarSesion();
            
            celda = new PdfPCell(new Phrase("Cajamarca Protective Services",new Font(Font.HELVETICA, 5, Font.BOLD, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("(04) 2287275 Ext. 5003",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("RUC: 0992810572001",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Email: ventas@cajamarca.ec",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Piedrahita 1501, Entre los Rios y Esmeraldas",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            
            celda = new PdfPCell(new Phrase(" ",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(0, 0, 0))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            
            celda = new PdfPCell(new Phrase("Guayaquil - Ecuador",new Font(Font.HELVETICA, 5, Font.NORMAL, new Color(164, 164, 164))));
            celda.setPaddingTop(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            tabla.addCell(celda);
            
            documento.add(tabla);
            documento.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        
    }
    
    protected int compare(int i, int j) {
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        return s1.compareTo(s2);
    }
    
    public String convert(String nueva){
        String last=nueva.replace(".", ",");
        String decimal="";
        String mil="";
        String millon="";
        String msl="";
        String joke="";
        if(last.split(",").length>1){
            String nuevo=last.split(",")[1];
            if(nuevo.length()==1){
                decimal= "."+nuevo+"0";
            }
            if(nuevo.length()==2){
                decimal= "."+nuevo;
            }
        }else{
            decimal= ".00";
        }
        String ultimo=last.split(",")[0];
        String numero=ultimo.substring(0, ultimo.length());
        int cant=numero.length();
        if(cant>0){
            if(ultimo.length()-3>=0){
                mil=ultimo.substring(ultimo.length()-3, ultimo.length());
            }else{
                mil=ultimo.substring(0, ultimo.length());
            }
        }
        if(cant>3){
            if(ultimo.length()-6>=0){
                millon=ultimo.substring(ultimo.length()-6, ultimo.length()-3)+",";
            }else{
                millon=ultimo.substring(0, ultimo.length()-3)+",";
            }
        }
        if(cant>6){
            if(ultimo.length()-9>=0){
                msl=ultimo.substring(ultimo.length()-9, ultimo.length()-6)+"'";
            }else{
                msl=ultimo.substring(0, ultimo.length()-6)+"'";
            }
        }
        
        
        last=msl+millon+mil+decimal;
        return last;
        
    }
    
    public void configuracion(){
        List<Login> list;
        try {
            visible(pf);
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list = helper.getlistaUsuarios();
            
            helper.cerrarSesion();
            reiniciarJTable(pf.getjTable2());
            
            for (Login list1 : list) {
                String c1 = list1.getCi();
                String c2 = list1.getNombre();
                String c3 = list1.getUsuario();
                String c4 = list1.getPass();
                String c5 = list1.getNivel();
                DefaultTableModel temp = (DefaultTableModel) pf.getjTable2().getModel();
                Object nuevo[]= {c1,c2,c3,c4,c5};
                temp.addRow(nuevo);
            }
        } catch (Exception ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new marco(null).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    public Login getUsuario() {
        return Usuario;
    }
    
    public void setUsuario(Login Usuario) {
        this.Usuario = Usuario;
    }
    
    public DefaultTableModel getBase() {
        return base;
    }
    
    public void setBase(DefaultTableModel base) {
        this.base = base;
    }
    
    public int getSortColumn() {
        return sortColumn;
    }
    
    public void setSortColumn(int sortColumn) {
        this.sortColumn = sortColumn;
    }
    
    public int[] getRow() {
        return row;
    }
    
    public void setRow(int[] row) {
        this.row = row;
    }
    
    public String getCli() {
        return cli;
    }
    
    public void setCli(String cli) {
        this.cli = cli;
    }
    
    public JTable getTableSorted() {
        return tableSorted;
    }
    
    public void setTableSorted(JTable tableSorted) {
        this.tableSorted = tableSorted;
    }
    
    public JLabel getjLabel8() {
        return jLabel8;
    }
    
    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }
    
    private void tablas() {
        tablasmodelos(cl.getjTable1(),cl);
        JScrollBar sb = cl.getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        cl.getjTable1().getColumn("Accion").setCellRenderer(new ButtonRenderer());
        cl.getjTable1().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        cl.getjTable1().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        
        cl.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text izquierda") );
        cl.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(20);
        cl.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        cl.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        cl.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text derecha") );
        
        tablasmodelos(py.getSp().getjTable1(),py.getSp());
        py.getSp().getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        py.getSp().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable1().getColumnModel().getColumn(7).setMaxWidth(50);
        py.getSp().getjTable1().getColumn("IR").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(py.getSp2().getjTable2(),py.getSp2());
        py.getSp2().getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        py.getSp2().getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        py.getSp2().getjTable2().getColumnModel().getColumn(5).setMaxWidth(70);
        py.getSp2().getjTable2().getColumnModel().getColumn(6).setMaxWidth(70);
        py.getSp2().getjTable2().getColumnModel().getColumn(7).setMaxWidth(70);
        py.getSp2().getjTable2().getColumn("Accion").setCellRenderer(new ButtonRenderer());
        py.getSp2().getjTable2().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        py.getSp2().getjTable2().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(py.getSp().getjTable2(),py.getSp());
        py.getSp().getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        py.getSp().getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable2().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable2().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable2().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        py.getSp().getjTable2().getColumnModel().getColumn(4).setMaxWidth(70);
        py.getSp().getjTable2().getColumnModel().getColumn(5).setMaxWidth(70);
        py.getSp().getjTable2().getColumnModel().getColumn(6).setMaxWidth(70);
        py.getSp().getjTable2().getColumn("Accion").setCellRenderer(new ButtonRenderer());
        py.getSp().getjTable2().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        py.getSp().getjTable2().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(cls2.getjTable1(),cls2);
        cls2.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        cls2.getjTable1().getColumn("IR").setCellRenderer(new ButtonRenderer());
        cls2.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text izquierda") );
        cls2.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(30);
        cls2.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable1().getColumnModel().getColumn(2).setPreferredWidth(20);
        cls2.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable1().getColumnModel().getColumn(4).setPreferredWidth(30);
        cls2.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(cls2.getjTable2(),cls2);
        cls2.getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        cls2.getjTable2().getColumn("IR").setCellRenderer(new ButtonRenderer());
        
        cls2.getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text izquierda") );
        cls2.getjTable2().getColumnModel().getColumn(0).setPreferredWidth(20);
        cls2.getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        cls2.getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable2().getColumnModel().getColumn(2).setMinWidth(160);
        cls2.getjTable2().getColumnModel().getColumn(2).setMaxWidth(160);
        cls2.getjTable2().getColumnModel().getColumn(3).setMaxWidth(160);
        cls2.getjTable2().getColumnModel().getColumn(3).setMinWidth(160);
        cls2.getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text derecha") );
        
        tablasmodelos(cls2.getjTable3(),cls2);
        cls2.getjScrollPane3().getVerticalScrollBar().setUI(new MyScrollbarUI());
        cls2.getjTable3().getColumn("IR").setCellRenderer(new ButtonRenderer());
        cls2.getjTable3().getColumn("Pagos").setCellRenderer(new ButtonRenderer());
        cls2.getjTable3().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text izquierda") );
        cls2.getjTable3().getColumnModel().getColumn(1).setPreferredWidth(30);
        cls2.getjTable3().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable3().getColumnModel().getColumn(2).setPreferredWidth(20);
        cls2.getjTable3().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable3().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        cls2.getjTable3().getColumnModel().getColumn(4).setPreferredWidth(30);
        cls2.getjTable3().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        
        
        tablasmodelos(py.getjTable2(),py);
        py.getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        py.getjTable2().getColumn("Ticket").setCellRenderer(new ButtonRenderer());
        py.getjTable2().getColumn("Ver").setCellRenderer(new ButtonRenderer());
        
        cls2.getjTable1().getColumn("IR").setCellRenderer(new ButtonRenderer());
        cls2.getjTable2().getColumn("IR").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(py.getjTable1(),py);
        py.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        py.getjTable1().getColumn("Accion").setCellRenderer(new ButtonRenderer());
        py.getjTable1().getColumn("Ver").setCellRenderer(new ButtonRenderer());
        
        py.getjTable2().getColumn("Ticket").setCellRenderer(new ButtonRenderer());
        py.getjTable2().getColumn("Ver").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(fc.getjTable1(),fc);
        fc.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        vt.getjTable1().getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(6).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(7).setCellRenderer(new CellRenderer("colores"));
        vt.getjTable1().getColumnModel().getColumn(8).setCellRenderer(new CellRenderer("colores"));
        
        tablasmodelos(vt.getjTable1(),vt);
        vt.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        tablasmodelos(vt.getjTable2(),vt);
        vt.getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        vt.getjTable2().getColumn("Ver").setCellRenderer(new ButtonRenderer());
        vt.getjTable2().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        vt.getjTable2().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        vt.getjTable1().getColumn("Accion").setCellRenderer(new ButtonRenderer());
        vt.getjTable1().getColumn("Ver").setCellRenderer(new ButtonRenderer());
        
        
        tablasmodelos(pf.getjTable2(),pf);
        pf.getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        pf.getjTable2().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        pf.getjTable2().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(rp.getjTable2(),rp);
        rp.getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        tablasmodelos(rp.getjTable3(),rp);
        rp.getjScrollPane3().getVerticalScrollBar().setUI(new MyScrollbarUI());
        pf.getjTable2().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        pf.getjTable2().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
    }
    
    private void eventos() {
        eventoseguimiento(cls2.getjComboBox2());
        //Cliente
        eventoTabla1_Cliente(cl.getjTable1());
        eventoBonton_Eliminar(cl.getjButton1());
        eventoBoton_Editar(cl.getjButton3()); //Modificar Cliente
        eventoBoton_Agregar_Instalacion(cl.getjButton2()); //Agregar Instalacion
        eventoCampoTexto_Instalacion(cl.getjTextField3()); //Clientes
        eventoregresarCliente(cl.getjLabel21()); //Clientes
        //
        
        //Clientes por Instalaciones
        eventoTextCliente_Instalacion_Busqueda(cls2.getjTextField1()); //Clientes
        eventoCliente_Instalacion_Tabla1(cls2.getjTable1()); //Clientes
        eventoCliente_Instalacion_All(cls2.getjLabel10()); //Clientes Todos //
        eventoCliente_Instalacion_Espera(cls2.getjLabel11()); //Clientes En Espera //
        eventoCliente_Instalacion_Diseno(cls2.getjLabel13()); //Clientes En Espera //
        eventoCliente_Instalacion_Aprobados(cls2.getjLabel12()); //Clientes Aprobados //
        eventoCliente_Instalacion_Enviado(cls2.getjLabel9()); //Clientes Enviado //
        eventoCliente_Instalacion_Aceptado(cls2.getjLabel14()); //Clientes Enviado //
        eventoCliente_Instalacion_Rechazado(cls2.getjLabel15()); //Clientes Enviado //
        eventoCliente_Instalacion_Seguimiento(cls2.getjLabel16()); //Clientes Enviado //
        eventoCliente_Instalacion_Seguimientofecha(cls2.getjButton2()); //Clientes Enviado //
        eventoCliente_Instalacion_Tabla2(cls2.getjTable2()); //Clientes
        eventoCliente_Instalacion_Tabla3(cls2.getjTable3());
        eventoCliente_Instalacion_AgregarCliente(cls2.getjButton1()); //agregar clientes
        //
        
        //PYL
        eventoTextoPYL(py.getjTextField1()); //Clientes
        eventoPYLencurso(py.getjLabel11()); //
        eventoPYLculminado(py.getjLabel9()); //
        eventoPYLaceptado(py.getjLabel10()); //
        eventoPYLsoporte(py.getjLabel12());
        eventoPYLtabla1(py.getjTable1()); //
        eventoPYLtablaaceptados(py.getjTable2()); //agregar clientes
        //
        
        //Ventas
        eventoVentasPendientes(vt.getjTable1());
        eventoVentasTabla(vt.getjTable1()); //
        eventoVentasbotonFinanciero(vt.getjLabel13()); //
        eventoVentasbotonCancelado(vt.getjLabel9()); //
        eventoVentasbotonCulminado(vt.getjLabel10()); //
        eventoVentasbotonFechas(vt.getjLabel14()); //
        eventoVentasbotonFacturado(vt.getjLabel11()); //
        eventoVentasbotonProveedores(vt.getjLabel12()); //
        eventoProveedoresAgregar(vt.getjButton1()); //
        eventoProveedoresTabla(vt.getjTable2()); //
        eventoTextoVentas(vt.getjTextField1()); //Clientes
        //
        // Instalacion
        eventoBotonProcesosProyecto(inst.getjButton6()); //Final
        eventoregresarProyecto(inst.getjLabel21()); //Instalacion
        
        setEventoMouseClicked50(inst.getjButton26()); //Constular Agregar Grupos
        setEventoMouseClicked51(inst.getjButton23()); //Constular Eliminar Grupos
        //facturación
        setEventoMouseClicked18(inst.getjButton15()); //Agregar Instalacion
        setEventoMouseClicked19(inst.getjButton10()); //Agregar Instalacion
        setEventoMouseClicked20(inst.getjButton5()); //Agregar Instalacion
        setEventoMouseClicked38(inst.getjButton21()); //Elimnar Instalacion
        //reporte
        eventocargarReporte(inst.getjButton14()); //Cargar Instalacion
        setEventoMouseClicked22(inst.getjButton9()); //Constular Instalacion
        setEventoMouseClicked23(inst.getjButton4()); //Descargar Instalacion
        setEventoMouseClicked36(inst.getjButton20()); //Elimnar Instalacion
        setEventoMouseClicked41(inst.getjButton25()); //Descargar Instalacion
        //diseño
        eventocargardiseñoproyecto(inst.getjButton13()); //Cargar Instalacion
        eventoconsultadiseño(inst.getjButton8()); //Constular Instalacion
        setEventoMouseClicked26(inst.getjButton3()); //Descargar Instalacion
        setEventoMouseClicked35(inst.getjButton19()); //Elimnar Instalacion
        setEventoMouseClicked40(inst.getjButton22()); //Constular Instalacion
        //notas
        setEventoMouseClicked27(inst.getjButton7()); //Cargar Instalacion
        setEventoMouseClicked28(inst.getjButton2()); //Constular Instalacion
        setEventoMouseClicked29(inst.getjButton1()); //Descargar Instalacion
        setEventoMouseClicked37(inst.getjButton17()); //Elimnar Instalacion
        //Ordenes
        setEventoOrden_Instalacion(inst.getjButton30()); //Cargar Ordenes
        setEventoOrden_Consultar(inst.getjButton31()); //Constular Ordenes
        setEventoOrden_Descargar(inst.getjButton32()); //Descargar Ordenes
        setEventoOrden_Eliminar(inst.getjButton33()); //Elimnar Ordenes
        //Facturacion
        setEventoMouseClicked32(inst.getjButton18()); //Facturacion Boton Eliminar
        setEventoMouseClicked5(inst.getjButton12()); // Instalacion Nueva Proyecto
        setEventoMouseClicked31(inst.getjButton11()); //Instalacion Editar Proforma
        setEventoMouseClicked39(inst.getjButton16()); //Constular Instalacion
        //Lista Materiales
        setEventolistaMateriales(inst.getjButton36()); //Constular Instalacion
        setEventolistaMaterialeseliminar(inst.getjButton34()); //Constular Instalacion
        
        //
        
        //Facturacion
        setEventoMouseClicked6(fc.getjLabel19()); //regresar a Instalacion
        setEventoMouseClicked30(fc.getjLabel21()); //Facturacion Boton Guardar
        //
        setEventoMouseClicked8(pf.getjTable2()); //Modificar Empleado
        
        setEventomateriales_instalacion(ma.getjLabel19());
        setEventoactualizarmateriales(ma.getjLabel21()); //Facturacion Boton Guardar
        consultarOrden(ma.getjButton11());
        consultarOrden2(ma.getjButton9());
        setEventoOrden_Proyecto(ma.getjButton8());
        
        eliminarOrden(ma.getjButton19()); //Facturacion Boton Eliminar
        eliminarOrden2(ma.getjButton18()); //Facturacion Boton Eliminar
        
    }
    
    private void eventoseguimiento(JComboBox tbl)    {
        tbl.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                seguidboton();
            }
        }
                );
    }
    
    private void eventoTabla1_Cliente(JTable tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    eventoTabla1_ClienteClicked(e);
                } catch (Exception ex) {
                }
            }
        });
    }
    
    
    
    public void ordenpdf(String cadena){
        //String imagepath = Server.MapPath("Images");
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        List<Listamateriales> ltma;
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            ltma = helper.getlistaMateriales(cadena);
            int cell=16;
            ficheroPdf = new FileOutputStream(Usuario.getDireccion()+"/OrdenTrabajo"+cadena+".pdf");
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            
            documento.open();
            PdfPCell celda;
            Font fontpersonalizado2 = FontFactory.getFont("ARIAL", 7, Font.NORMAL);
            Font font = FontFactory.getFont("ARIAL", 10, Font.BOLDITALIC);
            @SuppressWarnings("UnusedAssignment")
            Font fontpersonalizado = FontFactory.getFont("ARIAL", 16, Font.BOLDITALIC);
            Font fontselected = FontFactory.getFont("ARIAL", 22, Font.BOLD);
            
            fontselected.setColor(Color.red);
            //aqui agregamos todo el contenido del PDF...
            /*Cabecera celdas 1 2 y 3*/
            
            Image image1 = Image.getInstance(Usuario.getDireccion()+"/logo.png");
            image1.scaleAbsoluteHeight((float) 40);
            image1.scaleAbsoluteWidth((float) 120);
            
            PdfPTable Contorno = new PdfPTable(1);
            PdfPTable head = new PdfPTable(10);
            head.setTotalWidth(700);
            head.setWidths(new int[]{64,40,80,60,84,61,102,62,80,65});
            
            celda = new PdfPCell(image1);
            celda.setHorizontalAlignment(0);
            celda.setColspan(4);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(7);
            head.addCell(celda);
            
            PdfPTable head2 = new PdfPTable(6);
            head2.setWidths(new int[]{84,61,102,62,80,65});
            fontpersonalizado = FontFactory.getFont("ARIAL", 14, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("ORDEN DE TRABAJO",new Font(fontpersonalizado)));
            celda.setColspan(6);
            celda.setHorizontalAlignment(1);
            
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            head2.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            celda.setColspan(6);
            celda.setFixedHeight(10);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            head2.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            celda.setColspan(3);
            
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            head2.addCell(celda);
            
            celda = new PdfPCell(new Phrase("N°",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(0);
            head2.addCell(celda);
            int cad1=cadena.length(); //4 digitos
            while(true){
                if(cad1>7){
                    break;
                }else{
                    cadena= "0"+cadena;
                    cad1=cadena.length();
                }
            }
            celda = new PdfPCell(new Phrase(cadena,new Font(font)));
            celda.setHorizontalAlignment(2);
            celda.setColspan(2);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head2.addCell(celda);
            
            celda = new PdfPCell(head2);
            celda.setColspan(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(9);
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setColspan(12);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(83,141,213));
            head.addCell(celda);
            
            //columna 5
            fontpersonalizado = FontFactory.getFont("ARIAL", 9, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("FECHA:",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            celda.setColspan(2);
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase(Funcion.DateFormatSql(new Date()),new Font(font))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("TICKET #",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(0);
            celda.setColspan(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            head.addCell(celda);
            if(backinst.getTicket_1()!=null){
                celda = new PdfPCell(new Phrase(backinst.getTicket_1(),new Font(font))); //ingreso de Datos 5I
            }else{
                celda = new PdfPCell(new Phrase("",new Font(font))); //ingreso de Datos 5I
            }
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            //columna 6
            fontpersonalizado = FontFactory.getFont("ARIAL", 9, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("CLIENTE:",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            celda.setColspan(2);
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase(inst.getjTextField1().getText(),new Font(font))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("CONTACTO:",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(0);
            celda.setColspan(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase(inst.getjTextField5().getText(),new Font(font))); //ingreso de Datos 5I
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            //columna 7
            fontpersonalizado = FontFactory.getFont("ARIAL", 9, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("PROYECTO:",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            celda.setColspan(2);
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase(inst.getjLabel15().getText(),new Font(font))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("TELF:",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(0);
            celda.setColspan(2);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            head.addCell(celda);
            Clientes c = (Clientes) helper.obtenerObjeto(Clientes.class, Integer.parseInt(cliente));
            celda = new PdfPCell(new Phrase(c.getNumero1(),new Font(font))); //ingreso de Datos 5I
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setColspan(10);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(83,141,213));
            head.addCell(celda);
            
            //COLUMNA9
            fontpersonalizado = FontFactory.getFont("ARIAL", 8, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("TIPO DE TRABAJO:",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(0);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            celda.setColspan(2);
            celda.setRowspan(2);
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("OBRA NUEVA",new Font(font))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setColspan(4);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Calibración de Equipos",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            head.addCell(celda);
            
            if(ma.getjCheckBox4().isSelected()){
                celda = new PdfPCell(new Phrase("X",new Font(fontselected))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontselected))); //ingreso de Datos 5E
            }
            celda.setHorizontalAlignment(1);
            celda.setBorder(Rectangle.BOX);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Revisión de Equipos",new Font(fontpersonalizado)));
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBackgroundColor(new Color(255,255,255));
            celda.setBorder(Rectangle.BOX);
            head.addCell(celda);
            if(ma.getjCheckBox5().isSelected()){
                celda = new PdfPCell(new Phrase("X",new Font(fontselected))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontselected))); //ingreso de Datos 5E
            }
            
            celda.setBorder(Rectangle.BOX);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            //linea 10
            celda = new PdfPCell(new Phrase("Fase 1 Ducteria",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            if(ma.getjCheckBox1().isSelected()){
                celda = new PdfPCell(new Phrase("X",new Font(fontselected))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontselected))); //ingreso de Datos 5E
            }
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Fase 1 Montaje equipos",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            if(ma.getjCheckBox3().isSelected()){
                celda = new PdfPCell(new Phrase("X",new Font(fontselected))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado))); //ingreso de Datos 5E
            }
            
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Configuración de equipos",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            if(ma.getjCheckBox2().isSelected()){
                celda = new PdfPCell(new Phrase("X",new Font(fontselected))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontselected))); //ingreso de Datos 5E
            }
            
            celda.setHorizontalAlignment(1);
            celda.setBorder(Rectangle.BOX);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            
            
            celda = new PdfPCell(new Phrase("Reparación",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            
            if(ma.getjCheckBox6().isSelected()){
                celda = new PdfPCell(new Phrase("X",new Font(fontselected))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontselected))); //ingreso de Datos 5E
            }
            celda.setHorizontalAlignment(1);
            celda.setBorder(Rectangle.BOX);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setColspan(10);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(83,141,213));
            head.addCell(celda);
            
            fontpersonalizado = FontFactory.getFont("ARIAL", 12, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("INSTRUCCIONES DEL TRABAJO",new Font(fontpersonalizado)));
            celda.setColspan(10);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            //LINEA13
            fontpersonalizado = FontFactory.getFont("ARIAL", 9, Font.BOLDITALIC);
            PdfPTable tabla3 = new PdfPTable(1);
            if(ma.getjTextArea1().getText()!=null){
                celda = new PdfPCell(new Phrase(ma.getjTextArea1().getText(),new Font(fontpersonalizado2)));
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            }
            
            celda.setBorder(0);
            celda.setMinimumHeight(60);
            celda.setBackgroundColor(new Color(255,255,255));
            tabla3.addCell(celda);
            
            
            celda = new PdfPCell(tabla3);
            celda.setColspan(10);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            //196,215,155 verde
            
            //83,141,213 azul
            //linea 19
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setColspan(10);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(196,215,155));
            head.addCell(celda);
            fontpersonalizado = FontFactory.getFont("ARIAL", 8, Font.BOLDITALIC);
            
            celda = new PdfPCell(new Phrase("Personal Asignado",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setMinimumHeight(30);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setColspan(2);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            if(ma.getjTextArea2().getText()!=null){
                celda = new PdfPCell(new Phrase(ma.getjTextArea2().getText(),new Font(fontpersonalizado2))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado))); //ingreso de Datos 5E
            }
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Nombre de Tecnicos",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setColspan(2);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            if(ma.getjTextArea3().getText()!=null){
                celda = new PdfPCell(new Phrase(ma.getjTextArea3().getText(),new Font(fontpersonalizado2))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado))); //ingreso de Datos 5E
            }
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("F. INICIO",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setColspan(2);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            if(ma.getjDateChooser1().getDate()!=null){
                celda = new PdfPCell(new Phrase(Funcion.DateFormatSql(ma.getjDateChooser1().getDate()),new Font(fontpersonalizado))); //ingreso de Datos 5E
            }else{
                celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado))); //ingreso de Datos 5E
            }
            
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("F. FINAL",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setColspan(2);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado))); //ingreso de Datos 5E
            celda.setHorizontalAlignment(1);
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            //linea 21
            
            celda = new PdfPCell(new Phrase("Herramientas Adicionales:",new Font(fontpersonalizado)));
            celda.setColspan(5);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Observaciones:",new Font(fontpersonalizado)));
            celda.setColspan(5);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            PdfPTable tabla4 = new PdfPTable(1);
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            celda.setBorder(0);
            celda.setMinimumHeight(10);
            celda.setBackgroundColor(new Color(255,255,255));
            tabla4.addCell(celda);
            tabla4.addCell(celda);
            tabla4.addCell(celda);
            
            celda = new PdfPCell(tabla4);
            celda.setColspan(5);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            PdfPTable tabla5 = new PdfPTable(1);
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            celda.setBorder(0);
            celda.setMinimumHeight(10);
            celda.setBackgroundColor(new Color(255,255,255));
            tabla5.addCell(celda);
            tabla5.addCell(celda);
            tabla5.addCell(celda);
            
            celda = new PdfPCell(tabla5);
            celda.setColspan(5);
            celda.setBorder(Rectangle.BOX);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setColspan(10);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            // linea 25
            fontpersonalizado = FontFactory.getFont("ARIAL", 12, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("Materiales Requeridos",new Font(fontpersonalizado)));
            celda.setColspan(5);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Materiales Recibidos",new Font(fontpersonalizado)));
            celda.setColspan(5);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            fontpersonalizado = FontFactory.getFont("ARIAL", 8, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("Cant:",new Font(fontpersonalizado)));
            celda.setColspan(2);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("DESCRIPCION",new Font(fontpersonalizado)));
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("Cant:",new Font(fontpersonalizado)));
            celda.setColspan(2);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("BODEGA ENTREGA",new Font(fontpersonalizado)));
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            /*
             *
             *
             *
             *
             */
            //linea 27  Datos A Ingresar de SIC
            int cantidad=18;
            for(int temp=0; temp <cantidad;temp++){
                if(temp<ltma.size()){
                    celda = new PdfPCell(new Phrase(ltma.get(temp).getCantidad(),new Font(fontpersonalizado2)));
                }else{
                    celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                }
                celda.setColspan(2);
                celda.setMinimumHeight(14);
                celda.setBorder(Rectangle.BOX);
                celda.setHorizontalAlignment(1);
                celda.setBackgroundColor(new Color(255,255,255));
                head.addCell(celda);
                
                
                if(temp<ltma.size()){
                    celda = new PdfPCell(new Phrase(ltma.get(temp).getDescripcion(),new Font(fontpersonalizado2)));
                }else{
                    celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                }
                celda.setColspan(3);
                celda.setMinimumHeight(14);
                celda.setBorder(Rectangle.BOX);
                celda.setHorizontalAlignment(1);
                celda.setBackgroundColor(new Color(255,255,255));
                head.addCell(celda);
                
                celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado2)));
                celda.setColspan(2);
                celda.setMinimumHeight(14);
                celda.setBorder(Rectangle.BOX);
                celda.setHorizontalAlignment(1);
                celda.setBackgroundColor(new Color(255,255,255));
                head.addCell(celda);
                
                celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado2)));
                celda.setColspan(3);
                celda.setMinimumHeight(14);
                celda.setBorder(Rectangle.BOX);
                celda.setHorizontalAlignment(1);
                celda.setBackgroundColor(new Color(255,255,255));
                head.addCell(celda);
            }
            //
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado2)));
            celda.setColspan(10);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(230,230,230));
            head.addCell(celda);
            //FOot
            
            PdfPTable tabla6 = new PdfPTable(1);
            
            celda = new PdfPCell(new Phrase("Nombre:",new Font(fontpersonalizado)));
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            tabla6.addCell(celda);
            
            celda = new PdfPCell(new Phrase("      ________________________________________\n Recibi Conforme",new Font(fontpersonalizado)));
            celda.setMinimumHeight(30);
            celda.setBorder(Rectangle.BOX);
            celda.setVerticalAlignment(Element.ALIGN_BOTTOM);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            tabla6.addCell(celda);
            
            celda = new PdfPCell(tabla6);
            celda.setBorder(Rectangle.BOX);
            celda.setVerticalAlignment(2);
            celda.setColspan(6);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            
            celda = new PdfPCell(new Phrase("Visto Bueno",new Font(fontpersonalizado)));
            celda.setColspan(1);
            celda.setBorder(Rectangle.BOX);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            celda = new PdfPCell(new Phrase("_________________      Entregado",new Font(fontpersonalizado)));
            celda.setColspan(3);
            celda.setBorder(Rectangle.BOX);
            celda.setHorizontalAlignment(1);
            celda.setVerticalAlignment(Element.ALIGN_BOTTOM);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            celda.setColspan(10);
            celda.setHorizontalAlignment(1);
            celda.setMinimumHeight(130);
            celda.setBorder(0);
            celda.setVerticalAlignment(Element.ALIGN_BOTTOM);
            celda.setBackgroundColor(new Color(255,255,255));
            head.addCell(celda);
            
            documento.add(head);
            
            
            //196,215,155 verde
            
            //83,141,213 azul
            PdfPTable tabla7 = new PdfPTable(1);
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            celda.setBorder(Rectangle.BOX);
            celda.setMinimumHeight(12);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(83,141,213));
            tabla7.addCell(celda);
            fontpersonalizado = FontFactory.getFont("ARIAL", 12, Font.BOLDITALIC);
            celda = new PdfPCell(new Phrase("INSTRUCCIONES DEL TRABAJO",new Font(fontpersonalizado)));
            celda.setBorder(Rectangle.BOX);
            celda.setMinimumHeight(12);
            celda.setHorizontalAlignment(1);
            celda.setBackgroundColor(new Color(255,255,255));
            tabla7.addCell(celda);
            
            celda = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
            celda.setBorder(Rectangle.BOX);
            celda.setMinimumHeight(500);
            celda.setHorizontalAlignment(0);
            celda.setBackgroundColor(new Color(255,255,255));
            tabla7.addCell(celda);
            
            documento.add(tabla7);
            documento.close();
            helper.cerrarSesion();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        
    }
    
    private void eventoTabla1_ClienteClicked(java.awt.event.MouseEvent evt) throws Exception {
        if(cl.getjTable1().getSelectedColumn()==4){
            visible(inst);
            inst.getjTextField9().setText(cl.getjTable1().getModel().getValueAt(cl.getjTable1().getSelectedRow(), 1).toString());
            if(Usuario.getNivel().equalsIgnoreCase("Ventas")){
                Login lg2=null;
                Login lg3=null;
                inst.getjButton12().setVisible(true);
                inst.getjButton13().setVisible(true);
                inst.getjButton14().setVisible(false);
                inst.getjButton15().setVisible(false);
                inst.getjButton7().setVisible(true);
                inst.getjButton6().setVisible(true);
                int row2=cl.getjTable1().getSelectedRow();
                int col2=cl.getjTable1().getSelectedColumn();
                String tipoinstalacion=null;
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Clientes client = (Clientes) helper.obtenerObjeto(Clientes.class, cl.idcl);
                    Instalacion instalacion = (Instalacion) helper.obtenerObjeto(Instalacion.class, Integer.parseInt(cl.getjTable1().getValueAt(row2, col2).toString()));
                    tipoinstalacion = instalacion.getTipo();
                    inst.setInstalacion(tipoinstalacion);
                    inst.setIdinstalacion(instalacion.getId());
                    lg2 = client.getLogin2();
                    lg3 = client.getLogin3();
                    helper.cerrarSesion();
                }catch(Exception io){}
                
                
                if(lg2!=null){
                    if(lg2.getId()==Usuario.getId()){
                        inst.getjButton11().setVisible(false);
                        if(tipoinstalacion.contains("Poligrafos")){
                            inst.getjButton11().setVisible(true);
                        }
                        if(tipoinstalacion.contains("Guardianía")){
                            inst.getjButton11().setVisible(true);
                        }
                        if(tipoinstalacion.contains("Soporte Técnico")){
                            inst.getjButton11().setVisible(true);
                        }
                        if(tipoinstalacion.contains("Venta Directa")){
                            inst.getjButton11().setVisible(true);
                        }
                    }
                }
                if(lg3!=null){
                    if(lg3.getId()==Usuario.getId()){
                        inst.getjButton11().setVisible(false);
                        if(tipoinstalacion.contains("Instalación")){
                            inst.getjButton11().setVisible(true);
                        }
                        if(tipoinstalacion.contains("Soporte Técnico")){
                            inst.getjButton11().setVisible(true);
                        }
                    }
                }
                
            }
            if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                inst.getjButton12().setVisible(true);
                inst.getjButton13().setVisible(true);
                inst.getjButton14().setVisible(true);
                inst.getjButton15().setVisible(true);
                inst.getjButton7().setVisible(true);
                inst.getjButton6().setVisible(true);
            }
            if(Usuario.getNivel().equalsIgnoreCase("Contable")){
                inst.getjButton12().setVisible(false);
                inst.getjButton13().setVisible(false);
                inst.getjButton14().setVisible(false);
                inst.getjButton23().setVisible(false);
                inst.getjButton26().setVisible(false);
                inst.getjButton15().setVisible(true);
                inst.getjButton21().setVisible(true);
                inst.getjButton7().setVisible(true);
                inst.getjButton6().setVisible(false);
            }
            if(Usuario.getNivel().equalsIgnoreCase("PYL")){
                inst.getjButton12().setVisible(false);
                inst.getjButton13().setVisible(false);
                inst.getjButton15().setVisible(false);
                inst.getjButton12().setVisible(false);
                inst.getjButton13().setVisible(false);
                inst.getjButton20().setVisible(false);
                inst.getjButton14().setVisible(false);
                inst.getjButton21().setVisible(false);
                inst.getjButton23().setVisible(false);
                inst.getjButton26().setVisible(false);
                inst.getjButton7().setVisible(true);
                inst.getjButton6().setVisible(false);
            }
        }
        if(cl.getjTable1().getSelectedColumn()==4){
            
            Clientes mod;
            List<Instalacion> list=null;
            List<Proyectos> list2;
            List<Diseno> list3;
            List<Report> list4;
            List<Factu> list5;
            List<Notas> list6;
            List<Orden> list7;
            
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            int filas = cl.getjTable1().rowAtPoint(evt.getPoint());
            if (filas >= 0 && cl.getjTable1().isEnabled())
            {
                this.insta=cl.getjTable1().getModel().getValueAt(filas, 4).toString();
                inst.getjLabel15().setText(cl.getjTable1().getModel().getValueAt(filas, 0).toString());
            }
            Instalacion instalacion= (Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(insta));
            inst.setIdinstalacion(instalacion.getId());
            list2= helper.getlistaProyectos1a(insta,"1");
            list3= helper.getlistaDisenoa(insta,"1");
            list4= helper.getlistaReporta(insta,"1");
            list5= helper.getlistaFactua(insta,"1");
            list6= helper.getlistaNotasa(insta,"1");
            list7= helper.getlistaOrdena(insta,"1");
            
            /*
             */
            inst.getjPanel1().setVisible(true);
            inst.getjPanel1().removeAll();
            int contador = Integer.parseInt(instalacion.getGrupo());
            
            for(int i=0;contador>i;i++){
                final JLabel lab = new JLabel("Grupo"+Integer.toString(i+1));
                final int var = i;
                lab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(51, 51, 51)));
                lab.setBounds(0, 70, 70, 20);
                lab.setLocation((70*i), 12);
                lab.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            tblEjemploMouseClicked100(e,Integer.toString(var+1),Integer.parseInt(insta));
                        } catch (Exception ex) {
                            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                lab.setVisible(true);
                inst.getjPanel1().add(lab);
            }
            inst.getjPanel1().repaint();
            /*
             */
            helper.cerrarSesion();
            inst.getjTextField1().setText(cl.getjTextField1().getText());
            inst.getjTextField2().setText(cl.getjTextField2().getText());
            if(cl.getjComboBox1().getSelectedItem().toString().equalsIgnoreCase("Juridica")){
                inst.getjComboBox1().setSelectedItem("Juridica");
            }else{
                inst.getjComboBox1().setSelectedItem("Natural");
            }
            inst.getjTextField5().setText(cl.getjTextField5().getText());
            inst.getjTextField6().setText(cl.getjTextField6().getText());
            inst.getjTextField8().setText(cl.getjTextField8().getText());
            inst.getjTextField11().setText(cl.getjTextField13().getText());
            inst.getjComboBox9().removeAllItems();
            if(list2!=null){
                for (Proyectos list21 : list2) {
                    inst.getjComboBox9().addItem(list21.getSubproyecto());
                }
            }else{
                inst.getjButton6().setVisible(false);
            }
            
            inst.getjComboBox11().removeAllItems();
            if(list3!=null){
                for (Diseno list31 : list3) {
                    inst.getjComboBox11().addItem(list31.getNombre());
                }
            }else{
                inst.getjButton6().setVisible(false);
            }
            inst.getjComboBox13().removeAllItems();
            if(list4!=null){
                for (Report list41 : list4) {
                    inst.getjComboBox13().addItem(list41.getNombre());
                }
            }
            inst.getjComboBox15().removeAllItems();
            if(list5!=null){
                for (Factu list51 : list5) {
                    inst.getjComboBox15().addItem(list51.getNombre());
                }
            }
            inst.getjComboBox12().removeAllItems();
            if(list6!=null){
                for (Notas list61 : list6) {
                    inst.getjComboBox12().addItem(list61.getNombre());
                }
            }
            inst.getjComboBox14().removeAllItems();
            if(list7!=null){
                for (Orden list71 : list7) {
                    inst.getjComboBox14().addItem(list71.getNombre());
                }
            }
            if(instalacion.getTipo().equalsIgnoreCase("Venta Directa")){
                if(list2!=null){
                    inst.getjButton6().setVisible(true);
                }
            }
            transiciondeInstalacion(instalacion);
            backinst=instalacion;
        }else if(cl.getjTable1().getSelectedColumn()==6){
            ingresoU3 ingresoU3 = new ingresoU3(this, this, true,null,cl.getjTable1().getModel().getValueAt(cl.getjTable1().getSelectedRow(),6).toString(),1,Usuario,cl.idcl);
            visible(cl);
            List<Instalacion> list;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list=helper.getlistaInstalacion2(cliente);
            helper.cerrarSesion();
            reiniciarJTable(cl.getjTable1());
            
            if(list!=null){
                DefaultTableModel temp = (DefaultTableModel) cl.getjTable1().getModel();
                for (Instalacion list1 : list) {
                    String c1 = list1.getDetalle();
                    String c2 = formatoFecha(list1.getFecha());
                    String c3 = list1.getProceso();
                    String c4 = list1.getTipo();
                    String c5 = "" + list1.getId();
                    String c6 = "" + list1.getId();
                    String c7 = "" + list1.getId();
                    Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                    temp.addRow(nuevo);
                }
            }
            
        }else if(cl.getjTable1().getSelectedColumn()==5){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                Clientes mod;
                List<Instalacion> list;
                Instalacion instala;
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                
                list= helper.getlistaInstalacion2(cliente);
                int filas = cl.getjTable1().rowAtPoint(evt.getPoint());
                if (filas >= 0 && cl.getjTable1().isEnabled())
                {
                    instala = (Instalacion) helper.obtenerObjeto(Instalacion.class,Integer.parseInt(cl.getjTable1().getModel().getValueAt(filas, 4).toString()));
                    list.remove(instala);
                    helper.eliminarObjeto(instala);
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                reiniciarJTable(cl.getjTable1());
                DefaultTableModel temp = (DefaultTableModel) cl.getjTable1().getModel();
                if(list!=null){
                    for (Instalacion list1 : list) {
                        String c1 = list1.getDetalle();
                        String c2 = formatoFecha(list1.getFecha());
                        String c3 = list1.getProceso();
                        String c4 = list1.getTipo();
                        String c5 = "" + list1.getId();
                        String c6 = "" + list1.getId();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6};
                        temp.addRow(nuevo);
                    }
                }
            }
        }else{
            if((Usuario.getNivel().equalsIgnoreCase("Administrador")||Usuario.getNivel().equalsIgnoreCase("PYL"))&&cl.getjTable1().getModel().getValueAt(cl.getjTable1().getSelectedRow(),2).toString().equalsIgnoreCase("Aceptada por Cliente")){
                String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                    ingresoU5 ingresoU5 = new ingresoU5(this, this, true,null,cl.getjTable1().getModel().getValueAt(cl.getjTable1().getSelectedRow(),6).toString(),1,cl.getjTextField1().getText(),cl.getjTextField5().getText(),Usuario.getNombre());
                }
            }
        }
    }
    public String formatoFecha(String fecha){
        String cadena[]= fecha.split("/");
        if(fecha.contains("/")){
            return cadena[2]+"-"+cadena[1]+"-"+cadena[0];
        }
        return fecha;
        
    }
    private void eventoBonton_Eliminar(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    eventoBonton_EliminarClicked(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void eventoBonton_EliminarClicked(java.awt.event.MouseEvent evt) throws Exception {
        Clientes mod;
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            mod= (Clientes)helper.obtenerObjeto(Clientes.class,Integer.parseInt(cliente));
            helper.eliminarObjeto(mod);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }
        clientes();
    }
    public void cambioradiobuttonInstalador(JRadioButton rad){
        inst.getjRadioButton1().setSelected(false);
        inst.getjRadioButton2().setSelected(false);
        inst.getjRadioButton3().setSelected(false);
        inst.getjRadioButton4().setSelected(false);
        inst.getjRadioButton5().setSelected(false);
        inst.getjRadioButton6().setSelected(false);
        inst.getjRadioButton7().setSelected(false);
        inst.getjRadioButton8().setSelected(false);
        inst.getjRadioButton9().setSelected(false);
        inst.getjRadioButton10().setSelected(false);
        inst.getjRadioButton11().setSelected(false);
        rad.setSelected(true);
    }
    public void transiciondeInstalacion(Instalacion in){
        if(in.getProceso().equalsIgnoreCase("En Diseño")){
            cambioradiobuttonInstalador(inst.getjRadioButton2());
            if(inst.getjComboBox9().getItemCount()!=0){
                if(in.getTipo().equalsIgnoreCase("Venta Directa")){
                    inst.getjButton11().setVisible(true);
                    inst.getjButton18().setVisible(true);
                    inst.getjButton6().setVisible(true);
                }
                if(in.getTipo().equalsIgnoreCase("Poligrafos")){
                    inst.getjButton11().setVisible(true);
                    inst.getjButton18().setVisible(true);
                    inst.getjButton6().setVisible(true);
                }
                if(in.getTipo().equalsIgnoreCase("Guardianía")){
                    inst.getjButton11().setVisible(true);
                    inst.getjButton18().setVisible(true);
                    inst.getjButton6().setVisible(true);
                }
                inst.getjButton6().setText("Espera Aprobación Tecnica");
                inst.getjButton6().setVisible(true);
                inst.getjButton11().setVisible(true);
                inst.getjButton18().setVisible(true);
                if(in.getTipo().equalsIgnoreCase("Instalacion")){
                    if(inst.getjComboBox11().getItemCount()!=0){
                        inst.getjButton6().setVisible(true);
                    }else{
                        inst.getjButton6().setVisible(false);
                    }
                }
            }else{
                inst.getjButton6().setVisible(false);
                inst.getjButton11().setVisible(true);
                inst.getjButton18().setVisible(true);
            }
            
        }
        if(in.getProceso().equalsIgnoreCase("Espera Aprobación Tecnica")){
            cambioradiobuttonInstalador(inst.getjRadioButton9());
            inst.getjButton6().setText("Aprobación Tecnica");
            inst.getjButton6().setVisible(false);
            if(in.getTipo().equalsIgnoreCase("Venta Directa")){
                inst.getjButton11().setVisible(true);
                inst.getjButton18().setVisible(true);
                inst.getjButton6().setVisible(true);
            }
            if(in.getTipo().equalsIgnoreCase("Poligrafos")){
                inst.getjButton11().setVisible(true);
                inst.getjButton18().setVisible(true);
                inst.getjButton6().setVisible(true);
            }
            if(in.getTipo().equalsIgnoreCase("Guardianía")){
                inst.getjButton11().setVisible(true);
                inst.getjButton18().setVisible(true);
                inst.getjButton6().setVisible(true);
            }
            if(Usuario.getNivel().equalsIgnoreCase("Administrador")){
                inst.getjButton11().setVisible(true);
                inst.getjButton6().setVisible(true);
                inst.getjButton18().setVisible(true);
            }
        }
        if(in.getProceso().equalsIgnoreCase("Aprobación Tecnica")){
            cambioradiobuttonInstalador(inst.getjRadioButton10());
            inst.getjButton6().setText("Enviar a Cliente");
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
            inst.getjButton6().setVisible(true);
        }
        if(in.getProceso().equalsIgnoreCase("Enviada a Cliente")){
            cambioradiobuttonInstalador(inst.getjRadioButton3());
            inst.getjButton6().setText("A / R");
            inst.getjButton12().setVisible(true);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
        }
        if(in.getProceso().equalsIgnoreCase("Aceptada por Cliente")){
            cambioradiobuttonInstalador(inst.getjRadioButton4());
            inst.getjButton6().setText("Espera Aprobación Financiera");
            inst.getjButton12().setVisible(true);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
        }
        if(in.getProceso().equalsIgnoreCase("Rechazada por Cliente")){
            cambioradiobuttonInstalador(inst.getjRadioButton4());
            inst.getjButton6().setVisible(false);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
        }
        if(in.getProceso().equalsIgnoreCase("Espera Aprobación Financiera")){
            cambioradiobuttonInstalador(inst.getjRadioButton11());
            inst.getjButton6().setText("Aprobación Financiera");
            if(Usuario.getNivel().equalsIgnoreCase("Contable")){
                inst.getjButton6().setVisible(true);
            }else{
                inst.getjButton6().setVisible(false);
            }
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
        }
        if(in.getProceso().equalsIgnoreCase("Aprobación Financiera")){
            cambioradiobuttonInstalador(inst.getjRadioButton8());
            inst.getjButton6().setVisible(false);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
            inst.getjButton6().setVisible(false);
            
        }
        if(in.getProceso().equalsIgnoreCase("En Curso")){
            cambioradiobuttonInstalador(inst.getjRadioButton1());
            inst.getjButton6().setVisible(false);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(true);
            inst.getjButton18().setVisible(false);
        }
        if(in.getProceso().equalsIgnoreCase("Culminada")){
            cambioradiobuttonInstalador(inst.getjRadioButton5());
            inst.getjButton6().setVisible(false);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
        }
        if(in.getProceso().equalsIgnoreCase("Facturado")){
            cambioradiobuttonInstalador(inst.getjRadioButton6());
            inst.getjButton6().setVisible(false);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
        }
        if(in.getProceso().equalsIgnoreCase("Cancelado")){
            cambioradiobuttonInstalador(inst.getjRadioButton7());
            inst.getjButton6().setVisible(false);
            inst.getjButton12().setVisible(false);
            inst.getjButton11().setVisible(false);
            inst.getjButton18().setVisible(false);
        }
        if(in.getTipo().equalsIgnoreCase("Soporte Técnico")){
            inst.getjButton12().setVisible(true);
            inst.getjButton11().setVisible(true);
            inst.getjButton18().setVisible(true);
        }
        
    }
    private void eventoBoton_Editar(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    eventoBoton_EditarClicked(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void eventoBoton_EditarClicked(java.awt.event.MouseEvent evt){
        Clientes mod;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            mod= (Clientes)helper.obtenerObjeto(Clientes.class,Integer.parseInt(cliente));
            mod.setApellido(cl.getjTextField1().getText());
            mod.setCi(cl.getjTextField2().getText());
            mod.setPersona(cl.getjComboBox1().getSelectedItem().toString());
            mod.setRuc(cl.getjTextField2().getText());
            mod.setNombre(cl.getjTextField5().getText());
            mod.setNumero1(cl.getjTextField6().getText());
            mod.setNumero2(cl.getjTextField6().getText());
            mod.setCorreo(cl.getjTextField13().getText());
            mod.setResponsable(((Login)helper.obtenerObjeto(Login.class, cl.getL1().getId())).getNombre());
            mod.setLogin(((Login)helper.obtenerObjeto(Login.class, cl.getL1().getId())));
            mod.setLogin2(((Login)helper.obtenerObjeto(Login.class, cl.getL2().getId())));
            mod.setLogin3(((Login)helper.obtenerObjeto(Login.class, cl.getL3().getId())));
            helper.actualizarObjeto(mod);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
        clientes();
    }
    
    private void eventoBoton_Agregar_Instalacion(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    eventoBoton_Agregar_InstalacionClicked(e);
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void eventoBoton_Agregar_InstalacionClicked(java.awt.event.MouseEvent evt) throws Exception {
        ingresoU3 ingresoU3 = new ingresoU3(this, this, true,null,cliente,0,Usuario,cl.idcl);
        visible(cl);
        List<Instalacion> list;
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        list=helper.getlistaInstalacion2(cliente);
        
        helper.cerrarSesion();
        reiniciarJTable(cl.getjTable1());
        
        if(list!=null){
            for (Instalacion list1 : list) {
                String c1 = list1.getDetalle();
                String c2 = formatoFecha(list1.getFecha());
                String c3 = list1.getProceso();
                String c4 = list1.getTipo();
                String c5 = "" + list1.getId();
                String c6 = "" + list1.getId();
                String c7 = "" + list1.getId();
                DefaultTableModel temp = (DefaultTableModel) cl.getjTable1().getModel();
                Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                temp.addRow(nuevo);
            }
        }
    }
    
    private void eventoCampoTexto_Instalacion(JTextField tbl)    {
        tbl.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                List<Instalacion> list;
                ServiceHb helper = new ServiceHb();
                try {
                    helper.iniciarTransaccion();
                    String letra = cl.getjTextField3().getText();
                    if(!letra.equalsIgnoreCase("")){
                        list=helper.getlistaInstalacionSearch(letra,cli);
                    }else{
                        list=helper.getlistaInstalacion2(cli);
                    }
                    reiniciarJTable(cl.getjTable1());
                    
                    if(list!=null){
                        for(Instalacion x: list){
                            String c1=x.getDetalle();
                            String c2=formatoFecha(x.getFecha());
                            String c3=x.getProceso();
                            String c4=x.getTipo();
                            String c5=""+x.getId();
                            String c6=""+x.getId();
                            String c7=""+x.getId();
                            DefaultTableModel temp = (DefaultTableModel) cl.getjTable1().getModel();
                            Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7};
                            temp.addRow(nuevo);
                        }
                        
                    }
                    
                    helper.cerrarSesion();
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    
    
    private void accesoUsuario() {
        //Todos los Usuarios - menos Usuario: Administradores
        if(!Usuario.getNivel().equalsIgnoreCase("Administrador")){
            
            inst.getjButton22().setVisible(false);// Boton Carga Proforma Oculto - Instalacion
            inst.getjButton11().setVisible(false);// Boton Editar Proforma Oculto - Instalacion
            inst.getjButton18().setVisible(false);// Boton Eliminar Proforma Oculto - Instalacion
            inst.getjButton6().setVisible(false);// Boton Aprobar Proforma Oculto - Instalacion
            inst.getjButton24().setVisible(false);
            inst.getjButton19().setVisible(false);// Boton Aprobar Diseño Oculto - Instalacion
            inst.getjButton20().setVisible(false);// Boton Aprobar Reporte Oculto - Instalacion
            inst.getjButton21().setVisible(false);// Boton Aprobar Facturacion Oculto - Instalacion
            
            inst.getjButton12().setVisible(false);// Boton Cargar Proforma Oculto - Instalacion
            inst.getjButton13().setVisible(false);// Boton Cargar Diseño Oculto - Instalacion
            inst.getjButton14().setVisible(false);// Boton Cargar Reporte Oculto - Instalacion
            inst.getjButton15().setVisible(false);// Boton Cargar Facturacion Oculto - Instalacion
        }
        
        //
        //Usuarios: Administrador y Ventas
        if(Usuario.getNivel().equalsIgnoreCase("Administrador") || Usuario.getNivel().equalsIgnoreCase("Ventas")){
            cl.getjButton1().setVisible(true);// Boton Eliminar Cliente Oculto - Cliente
            cl.getjButton2().setVisible(true);// Boton Agregar Instalacion Oculto - Cliente
            cl.getjButton3().setVisible(true);// Boton Editar Cliente Oculto - Cliente
            inst.getjButton18().setVisible(true);// Boton Eliminar Diseño Oculto - Instalacion
            inst.getjButton19().setVisible(true);// Boton Eliminar Proforma Oculto - Instalacion
            inst.getjButton11().setVisible(true);// Boton Editar Proforma Oculto - Instalacion
            updateTablas up = new updateTablas(1);
            up.start();
        }
        
        
        //Usuario: PYL
        if(Usuario.getNivel().equalsIgnoreCase("PYL")){
            if(Usuario.getDepartamento().equalsIgnoreCase("Dpt. Compras")){
                py.getjLabel12().setBackground(new Color(255,255,255));
                py.getjLabel10().setBackground(new Color(212,208,200));
                py.getjLabel11().setBackground(new Color(212,208,200));        
                py.getjLabel9().setBackground(new Color(212,208,200));
                py.getjLabel9().setEnabled(false);
                visible(py);// Muestra el panel ventas
                py.visi(py.getSp2());
                py.getSp2().setUs(Usuario);
                py.getSp2().hilollenarcero();
            }else{
                inst.getjButton4().setVisible(true);// Boton Descargar Reporte Oculto - Instalacion
                inst.getjButton20().setVisible(true);// Boton Eliminar Reporte Oculto - Instalacion
                inst.getjButton14().setVisible(true);// Boton Editar Reporte Oculto - Instalacion
                visible(py);// Muestra el panel ventas
                updateTablas up = new updateTablas(2);
                up.start();
            }
        }
        //
        //Usuario: Contable
        if(Usuario.getNivel().equalsIgnoreCase("Contable")){
            inst.getjButton4().setVisible(true);// Boton Descargar Reporte Oculto - Instalacion
            inst.getjButton21().setVisible(true);// Boton Elimiar Facturacion Oculto - Instalacion
            inst.getjButton15().setVisible(true);// Boton Cargar Facturacion Oculto - Instalacion
            visible(vt);// Muestra el panel ventas
            
            vt.getjLabel7().setText("Espera de Aprobación Financiera");
            transicionventas(vt.getjLabel13());
            updateTablas up = new updateTablas(121);
            up.start();
        }
        if(Usuario.getNivel().equalsIgnoreCase("Asistente")){
            vt.getjLabel13().setEnabled(false);
            vt.getjLabel10().setEnabled(false);
            vt.getjLabel9().setEnabled(false);
            
            inst.getjButton4().setVisible(true);// Boton Descargar Reporte Oculto - Instalacion
            inst.getjButton21().setVisible(true);// Boton Elimiar Facturacion Oculto - Instalacion
            inst.getjButton15().setVisible(true);// Boton Cargar Facturacion Oculto - Instalacion
            visible(vt);// Muestra el panel ventas
            
            vt.getjLabel7().setText("Instalaciones Facturadas");
            transicionventas(vt.getjLabel11());
            updateTablas up = new updateTablas(14);
            up.start();
        }
        //
    }
    public class updateTablas extends Thread {
        int turno;
        public updateTablas(int turno){
            this.turno=turno;
        }
        /*
         * 5. Instalacion boton aprovado
         * 6. Instalacion boton en diseño
         * 61. Instalacion boton en espera
         * 4. Instalacion boton enviado
         * 62. Instalacion boton aceptado
         * 63. Instalacion boton en rechazado
         * 7. Instalacion busqueda por tipo
         * 11. PYL aprobacion financiera
         * 20. Seguimiento Ventas
         * 9. PYL en curso
         */
        @Override
        public void run() {
            breakhilo=1;
            cls2.getjPanel1().setVisible(true);
            try{
                sleep(800);
                breakhilo=0;
            }catch(Exception io){
            }
            if(turno==314){
                pyl1fechas();
            }
            if(turno==14){
                pyl1f();
            }
            if(turno==15){
                proveedor();
            }
            if(turno==22){
                backinstcls2();
            }
            if(turno==23){
                clientes_to_instalacion();
            }
            if(turno==21){
                cls2.getjPanel1().setVisible(false);
                clientes_to_seguimiento();
            }
            if(turno==211){
                cls2.getjPanel1().setVisible(false);
                clientes_to_seguimiento2();
            }
            if(turno==24){
            }
            if(turno==16){
                try{
                    textoVentas();
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(turno==1){
                clientes();
            }
            if(turno==2){
                pyl1();
            }
            if(turno==3){
                pyl1c();
            }
            if(turno==4){
                clienteinst("Enviado");
            }
            if(turno==5){
                clienteinst("Aprovacion");
            }
            if(turno==6){
                clienteinst("En Curso");
            }
            if(turno==61){
                clienteinst("En Aprovacion");
            }
            if(turno==62){
                clienteinst("Aceptado por Cliente");
            }
            if(turno==64){
                clienteinst("Gregory");
            }
            if(turno==63){
                clienteinst("Rechazada por Cliente");
            }
            if(turno==7){
                try {
                    instalacionbusqueda();
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(turno==8){
                try{
                    textopyl();
                } catch (Exception ex) {
                    Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(turno==9){
                pyl("1");
            }
            if(turno==10){
                pyl("2");
            }
            if(turno==11){
                pyl1();
            }
            if(turno==12){
                pyl1ca();
            }
            if(turno==121){
                pyl12ca();
            }
            if(turno==13){
                pyl1c();
            }
            
        }
    }
    private void paneles() {
        
        cl= new cliente();
        cl.setLocation(0, 61);
        add(cl);
        
        cls2= new clientes2(this, this);
        cls2.setLocation(0, 61);
        add(cls2);
        
        fc= new facturacion(Usuario);
        fc.setLocation(0, 61);
        add(fc);
        
        ma= new materiales(Usuario);
        ma.setLocation(0, 61);
        add(ma);
        
        inst= new instalacion();
        inst.setLocation(0, 61);
        add(inst);
        
        py = new pyl();
        py.setLocation(0, 61);
        add(py);
        
        rp = new reportes(this, this);
        rp.setLocation(0, 61);
        add(rp);
        
        pf= new configuracion(this, this);
        pf.setLocation(0, 61);
        add(pf);
        
        vt= new ventas();
        vt.setLocation(0, 61);
        add(vt);
        
        cont = new contable(this,this);
        cont.setLocation(0, 61);
        add(cont);
    }
}

class ButtonRenderer extends JLabel implements TableCellRenderer {
    
    public ButtonRenderer() {
        setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
        } else {
            setForeground(table.getForeground());
            if(row%2==0){
                this.setBackground(new Color( 245, 245 , 245));
            }else{
                this.setBackground(new Color( 220, 220 , 220));
            }
            setIcon(new ImageIcon(getClass().getResource("/Login/imagenes/boton-ir.png")));
            setHorizontalAlignment(0);
        }
        setText((value == null) ? "" : "");
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    
    private String label;
    
    private boolean isPushed;
    
    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
    boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }
    
    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            //
            //
            JOptionPane.showMessageDialog(button, label + ": Ouch!");
            // System.out.println(label + ": Ouch!");
        }
        isPushed = false;
        return label;
    }
    
    @Override
    @SuppressWarnings("InfiniteRecursion")
    public boolean stopCellEditing() {
        isPushed = false;
        return stopCellEditing();
    }
    
    @Override
    @SuppressWarnings("InfiniteRecursion")
    protected void fireEditingStopped() {
        fireEditingStopped();
    }
}
