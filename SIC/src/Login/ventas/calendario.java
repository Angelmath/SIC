/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Caldepartamento;
import Login.Entidad.Calpermisos;
import Login.Entidad.Login;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author homemig
 */

public final class calendario extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    calendariofiltro1 ca;
    calendariofiltro2 ca2;
    calendariofiltro3 ca3;
    calendariofiltro4 ca4;
    int numero;
    int num=0;
    int xx;
    int yy;
    int sortColumn;
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    DefaultTableModel base;
    int[] row;
    Login usuario;
    boolean configuracion=false;
    Calendar calFin;
    Calendar calFindias;
    calendarpanel capa;
    boolean trampa=true;
    javax.swing.JPanel pane;
    int alto=0;
    int ancho=0;
    ArrayList<Integer> fechann= new ArrayList<>();
    List<Caldepartamento> listdepa;
    List<Calpermisos> listpermi;
    
    public calendario(final Login log) {
        initComponents();
        this.usuario=log;
        calFin = Calendar.getInstance();
        fechann.add(calFin.get(Calendar.MONTH));
        fechann.add(calFin.get(Calendar.YEAR));
        fechann.add(calFin.get(Calendar.DAY_OF_MONTH));
        llenardepartamentos();
        llenarpermisos();
        calFindias = Calendar.getInstance();
        setSize(d.width, d.height-1);
        jLabel8.setSize(d.width, jLabel8.getHeight());
        jPanel7.setSize(d.width,jPanel7.getHeight());
        jPanel6.setSize(d.width,jPanel6.getHeight());
        jPanel8.setSize(d.width,d.height-jPanel8.getY()-1);
        
        capa= new calendarpanel(log,d.height-jPanel9.getY()-1);
        jPanel9.setSize(d.width,d.height-jPanel9.getY()-1);
        jPanel9.setVisible(false);
        jPanel9.add(capa);
        capa.getjLabel5().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    jPanel9.setVisible(false);
                    jPanel8.setVisible(true);
                    calendario();
                    JPanel p1 = (JPanel)jPanel3.getComponent(0);
                    JPanel p2 = (JPanel)jPanel4.getComponent(0);
                    JPanel p3 = (JPanel)jPanel5.getComponent(0);
                    JPanel p4 = (JPanel)jPanel10.getComponent(0);
                    for(int i=1; i<p1.getComponentCount();i++){
                        p1.getComponent(i).setVisible(false);
                    }
                    for(int i=1; i<p2.getComponentCount();i++){
                        p2.getComponent(i).setVisible(false);
                    }
                    for(int i=1; i<p3.getComponentCount();i++){
                        p3.getComponent(i).setVisible(false);
                    }
                    for(int i=1; i<p4.getComponentCount();i++){
                        p4.getComponent(i).setVisible(false);
                    }
                } catch (Exception ex) {
                }
            }
        });
        jLabel10.setSize(d.width, jLabel10.getHeight());
        getjLabel5().setSize(d.width, d.height-1);
        jLabel3.setSize(d.width, d.height-1);
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        jPanel1.setSize(d.width, (d.height-1)-60);
        jLabel15.setLocation((d.width)-(jLabel15.getWidth()), jLabel15.getY());
        jLabel16.setLocation((d.width)-(jLabel16.getWidth()), jLabel16.getY());
        jLabel17.setLocation((d.width)-(jLabel17.getWidth()), jLabel17.getY());
        jLabel18.setLocation((d.width)-(jLabel18.getWidth()), jLabel18.getY());
        jLabel1.setSize(d.width,3);
        jLabel15.setText(usuario.getNombre());
        jPanel2.setSize(d.width, (d.height-1)-140);
        alto= (jPanel2.getHeight()-50)/6;
        ancho= jPanel2.getWidth()/7;
        
        
        agregarfiltros();
        calendario();
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        c7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas - Cajamarca");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(450, 500));
        getContentPane().setLayout(null);

        jLabel3.setVisible(false);
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 34, 14);

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
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

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-icono-texto-darkblue.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 12, 210, 34);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 57, 1320, 3);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(null);
        getContentPane().add(jPanel9);
        jPanel9.setBounds(0, 60, 1330, 400);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(null);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        jPanel4.setOpaque(false);
        jPanel6.add(jPanel4);
        jPanel4.setBounds(322, 0, 160, 35);

        jPanel3.setOpaque(false);
        jPanel6.add(jPanel3);
        jPanel3.setBounds(161, 0, 160, 35);

        jPanel5.setOpaque(false);
        jPanel6.add(jPanel5);
        jPanel5.setBounds(0, 0, 160, 35);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-reload-light-blue.png"))); // NOI18N
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
        jPanel6.add(jLabel2);
        jLabel2.setBounds(650, 10, 22, 22);

        jPanel10.setOpaque(false);
        jPanel6.add(jPanel10);
        jPanel10.setBounds(483, 0, 160, 35);

        jPanel8.add(jPanel6);
        jPanel6.setBounds(0, 0, 1330, 400);

        jPanel7.setBackground(new java.awt.Color(247, 247, 247));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 227, 227)));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(null);

        c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1.setText("DOMINGO");
        jPanel7.add(c1);
        c1.setBounds(0, 0, 140, 40);

        c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c2.setText("LUNES");
        jPanel7.add(c2);
        c2.setBounds(140, 0, 140, 40);

        c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3.setText("MARTES");
        jPanel7.add(c3);
        c3.setBounds(290, 0, 140, 40);

        c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4.setText("MIERCOLES");
        jPanel7.add(c4);
        c4.setBounds(430, 0, 140, 40);

        c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c5.setText("JUEVES");
        jPanel7.add(c5);
        c5.setBounds(570, 0, 140, 40);

        c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c6.setText("VIERNES");
        jPanel7.add(c6);
        c6.setBounds(710, 0, 140, 40);

        c7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c7.setText("SABADO");
        jPanel7.add(c7);
        c7.setBounds(850, 0, 140, 40);

        jPanel8.add(jPanel7);
        jPanel7.setBounds(0, 41, 990, 40);

        jLabel10.setBackground(new java.awt.Color(247, 247, 247));
        jLabel10.setOpaque(true);
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel10MouseDragged(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel8.add(jLabel10);
        jLabel10.setBounds(0, 5, 1320, 36);

        jPanel1.setEnabled(false);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1110, 590);

        jPanel8.add(jPanel1);
        jPanel1.setBounds(0, 80, 1130, 470);

        getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 55, 1330, 400);

        jLabel8.setOpaque(true);
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
        jLabel8.setBounds(0, 0, 1320, 57);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setSize(d.width, d.height);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/fondo SIC 4.jpg"))); // NOI18N
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1330, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(point.x - xx, point.y - yy);
    }//GEN-LAST:event_jLabel8MouseDragged
    
    public void llenarpermisos(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            listpermi = helper.getCalpermisos();
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public void llenardepartamentos(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            listdepa = helper.getCaldepartamento();
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public void agregarfiltros(){
        filtro1();
        filtro2();
        filtro3();
        filtro4();
    }
    
    public void filtro4(){
        ca4 = new calendariofiltro4(0,ca3);
        ca4.setLocation(0, 0);
        jPanel10.removeAll();
        jPanel10.setSize(ca4.getWidth(), ca4.getHeight());
        jPanel10.setPreferredSize(new Dimension(ca4.getWidth(), ca4.getHeight()));
        jPanel10.add(ca4);
        jPanel10.revalidate();
    }
    
    public void filtro1(){
        int mes= calFin.get(Calendar.MONTH);
        ca = new calendariofiltro1(mes);
        ca.setLocation(0, 0);
        jPanel3.removeAll();
        jPanel3.setSize(ca.getWidth(), ca.getHeight());
        jPanel3.setPreferredSize(new Dimension(ca.getWidth(), ca.getHeight()));
        jPanel3.add(ca);
        jPanel3.revalidate();
    }
    
    public void filtro2(){
        int anio= calFin.get(Calendar.YEAR);
        ca2 = new calendariofiltro2(anio);
        ca2.setLocation(0, 0);
        jPanel5.removeAll();
        jPanel5.setSize(ca2.getWidth(), ca2.getHeight());
        jPanel5.setPreferredSize(new Dimension(ca2.getWidth(), ca2.getHeight()));
        jPanel5.add(ca2);
        jPanel5.revalidate();
    }
    
    public void filtro3(){
        ca3 = new calendariofiltro3(listdepa);
        ca3.setLocation(0, 0);
        jPanel4.removeAll();
        jPanel4.setSize(ca3.getWidth(), ca3.getHeight());
        jPanel4.setPreferredSize(new Dimension(ca3.getWidth(), ca3.getHeight()));
        jPanel4.add(ca3);
        jPanel4.revalidate();
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public calendariofiltro1 getCa() {
        return ca;
    }

    public void setCa(calendariofiltro1 ca) {
        this.ca = ca;
    }

    public calendariofiltro2 getCa2() {
        return ca2;
    }

    public void setCa2(calendariofiltro2 ca2) {
        this.ca2 = ca2;
    }

    public calendariofiltro3 getCa3() {
        return ca3;
    }

    public void setCa3(calendariofiltro3 ca3) {
        this.ca3 = ca3;
    }

    public boolean isTrampa() {
        return trampa;
    }

    public void setTrampa(boolean trampa) {
        this.trampa = trampa;
    }

    public JLabel getC1() {
        return c1;
    }

    public void setC1(JLabel c1) {
        this.c1 = c1;
    }

    public JLabel getC2() {
        return c2;
    }

    public void setC2(JLabel c2) {
        this.c2 = c2;
    }

    public JLabel getC3() {
        return c3;
    }

    public void setC3(JLabel c3) {
        this.c3 = c3;
    }

    public JLabel getC4() {
        return c4;
    }

    public void setC4(JLabel c4) {
        this.c4 = c4;
    }

    public JLabel getC5() {
        return c5;
    }

    public void setC5(JLabel c5) {
        this.c5 = c5;
    }

    public JLabel getC6() {
        return c6;
    }

    public void setC6(JLabel c6) {
        this.c6 = c6;
    }

    public JLabel getC7() {
        return c7;
    }

    public void setC7(JLabel c7) {
        this.c7 = c7;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    public JPanel getjPanel8() {
        return jPanel8;
    }

    public void setjPanel8(JPanel jPanel8) {
        this.jPanel8 = jPanel8;
    }

    public JPanel getjPanel9() {
        return jPanel9;
    }

    public void setjPanel9(JPanel jPanel9) {
        this.jPanel9 = jPanel9;
    }


    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public Calendar getCalFin() {
        return calFin;
    }

    public void setCalFin(Calendar calFin) {
        this.calFin = calFin;
    }

    public Calendar getCalFindias() {
        return calFindias;
    }

    public void setCalFindias(Calendar calFindias) {
        this.calFindias = calFindias;
    }

    public JPanel getPane() {
        return pane;
    }

    public void setPane(JPanel pane) {
        this.pane = pane;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public void calendario(){
        capa.setListdepa(listdepa);
        String visiblecapa="";
        JCheckBox checkbox=null;
        for(int i=1;i<ca3.getComponentCount();i++){
            checkbox= ((JCheckBox)(ca3.getComponent(i)));
            if(!checkbox.isSelected()){
                visiblecapa=checkbox.getText()+","+visiblecapa;
            }
        }
        calendarioceldas cal =new calendarioceldas(ca.getNumero(),Integer.parseInt(ca2.getCampo()),jPanel2.getSize(),jPanel7,usuario,jPanel9,jPanel8,fechann,capa,listdepa,listpermi,visiblecapa);
        cal.setLocation(0,0);
        for(int i=0; i< jPanel2.getComponentCount();i++){
            jPanel2.remove(jPanel2.getComponent(i));
        }
        jPanel2.add(cal);
        jPanel2.repaint();
        jPanel2.validate();
    }
    
    public static Date getPrimerDiaDelMes(int año, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.set(año,mes,
        cal.getActualMinimum(Calendar.DAY_OF_MONTH),
        cal.getMinimum(Calendar.HOUR_OF_DAY),
        cal.getMinimum(Calendar.MINUTE),
        cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
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
    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jLabel8MousePressed

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

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
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

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
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
        System.exit(0); 
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseDragged

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        calendario();
        JPanel p1 = (JPanel)jPanel3.getComponent(0);
        JPanel p2 = (JPanel)jPanel4.getComponent(0);
        JPanel p3 = (JPanel)jPanel5.getComponent(0);
        JPanel p4 = (JPanel)jPanel10.getComponent(0);
        for(int i=1; i<p1.getComponentCount();i++){
            p1.getComponent(i).setVisible(false);
        }
        for(int i=1; i<p2.getComponentCount();i++){
            p2.getComponent(i).setVisible(false);
        }
        for(int i=1; i<p3.getComponentCount();i++){
            p3.getComponent(i).setVisible(false);
        }
        for(int i=1; i<p4.getComponentCount();i++){
            p4.getComponent(i).setVisible(false);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-reload-light-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-reload-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseEntered
    
    public class notificaciones extends Thread {
        
        public notificaciones(int num){
            numero=num;
        }
                
        @Override
        public void run() {
          if(numero==1){
              actualizartablas(numero,"");
          }
          if(numero==2){
              actualizartablas(numero,"");
          }
          if(numero==3){
              actualizartablas(numero,"");
          }
        }
      }
        
    public void actualizartablas(int tipo,String modo){
        
    }
    
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
            Logger.getLogger(calendario.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new calendario(null).setVisible(true);
            }
        });
    }
    protected int compare(int i, int j) {
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        return s1.compareTo(s2);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
