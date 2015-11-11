/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Notificaciones;
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
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.Empleado;
import rrhh.servicio.Funcion;

/**
 *
 * @author homemig
 */

public class noti extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    int numero;
    int xx;
    int yy;
    int sortColumn;
    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    DefaultTableModel base;
    int[] row;
    Login usuario;
    boolean configuracion=false;
    public noti(final Login log) {
        initComponents();
        this.usuario=log;
        setSize(d.width, d.height-1);
        jLabel5.setSize(d.width, d.height-1);
        jLabel8.setSize(d.width, jLabel8.getHeight());
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        jPanel1.setSize(d.width-(jPanel1.getX()*2), d.height-200);
        jScrollPane1.setSize(d.width-(jPanel1.getX()*2)-10, jPanel1.getHeight()-100);
        jScrollPane2.setSize(d.width-(jPanel1.getX()*2)-10, jPanel1.getHeight()-100);
        jLabel15.setLocation((d.width)-(jLabel15.getWidth()), jLabel15.getY());
        jLabel16.setLocation((d.width)-(jLabel16.getWidth()), jLabel16.getY());
        jLabel17.setLocation((d.width)-(jLabel17.getWidth()), jLabel17.getY());
        jLabel18.setLocation((d.width)-(jLabel18.getWidth()), jLabel18.getY());
        jLabel1.setSize(d.width,3);
        jLabel15.setText(usuario.getNombre());
        jPanel2.setLocation(jPanel1.getWidth()-jPanel2.getWidth(), jPanel2.getY());
        jPanel3.setLocation(jPanel1.getLocation());
        jPanel3.setSize(jPanel1.getSize());
        jComboBox3.setLocation(jPanel3.getWidth()-jComboBox3.getWidth(), jComboBox3.getY());
        tablasmodelos(jTable1,jPanel1);

        jTable1.getColumn("IR").setCellRenderer(new ButtonRenderer());
        
        jTable1.getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("notificacion") );
        jTable1.getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("notificacion") );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("fecha-notificacion") );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("notificacion-center") );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("notificacion-center") );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("notificacion-center") );
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            List<Departamento> dept = helper.getdepartamentosByTipo();
            jComboBox3.removeAllItems();
            jComboBox3.addItem("Todos");
            for(Departamento i: dept){
                jComboBox3.addItem(i.getNombre());
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        notificaciones per = new notificaciones(1);
        per.start();
        
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
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
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
        jLabel8.setBounds(0, 0, 1320, 58);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 58, 1320, 3);

        jLabel4.setText("Modulo Ventas");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 60, 180, 30);

        jLabel6.setText("Modulo RRHH");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 60, 200, 30);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Informacion", "Fecha", "Responsable", "Modulo", "Estado", "IR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(40);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(2).setMinWidth(150);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(3).setMinWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(200);
        jTable1.getColumnModel().getColumn(4).setMinWidth(150);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(6).setMinWidth(70);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(70);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 1090, 190);

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel2.setText("Leido");

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel3.setText("Estatus: ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Leido", "No Leido" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jComboBox2, 0, 126, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(810, 0, 290, 30);

        jComboBox1.setFont(new java.awt.Font("Roboto Medium", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "No Leido", "Leido" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(10, 0, 180, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 90, 1110, 220);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jTable2.setFont(new java.awt.Font("Roboto Thin", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Nombres y Apellidos", "Fecha de Ingreso", "Dias", "Meses", "Años"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setOpaque(false);
        jTable2.setRowHeight(24);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setMinWidth(150);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(150);
        jTable2.getColumnModel().getColumn(3).setMinWidth(50);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(50);
        jTable2.getColumnModel().getColumn(4).setMinWidth(50);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTable2.getColumnModel().getColumn(4).setMaxWidth(50);
        jTable2.getColumnModel().getColumn(5).setMinWidth(50);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTable2.getColumnModel().getColumn(5).setMaxWidth(50);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 40, 1090, 450);

        jButton1.setText("1 Año");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(550, 10, 160, 23);

        jButton2.setText("1 Mes");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(180, 10, 160, 23);

        jButton3.setText("3 Meses");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(360, 10, 160, 23);

        jPanel3.add(jComboBox3);
        jComboBox3.setBounds(900, 10, 200, 30);

        jButton4.setText("Todos");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(10, 10, 160, 23);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 340, 1100, 300);
        jPanel3.setVisible(false);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setSize(d.width, d.height);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/fondo SIC.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1330, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(point.x - xx, point.y - yy);
    }//GEN-LAST:event_jLabel8MouseDragged
  
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

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Todos")){
            notificaciones per = new notificaciones(1);
            per.start();
        }
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("No Leido")){
            notificaciones per = new notificaciones(2);
            per.start();
        }
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Leido")){
            notificaciones per = new notificaciones(3);
            per.start();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().equalsIgnoreCase("SI")){
            jLabel2.setText("No Leido");
        }else{
            jLabel2.setText("Leido");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if(jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Leido")){
            try{
                int serial= (Integer)jTable1.getValueAt(jTable1.getSelectedRow(), 6);
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Notificaciones notifi = (Notificaciones)helper.obtenerObjeto(Notificaciones.class,serial);
                notifi.setVisto("SI");
                helper.actualizarObjeto(notifi);
                helper.confirmarTransaccion();
                helper.cerrarSesion();

                actualizartablas(numero,"");
            }catch(Exception io){

            }
        }else{
            try{
                int serial= (Integer)jTable1.getValueAt(jTable1.getSelectedRow(), 6);
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Notificaciones notifi = (Notificaciones)helper.obtenerObjeto(Notificaciones.class,serial);
                notifi.setVisto("NO");
                helper.actualizarObjeto(notifi);
                helper.confirmarTransaccion();
                helper.cerrarSesion();

                actualizartablas(numero,"");
            }catch(Exception io){

            }
        }
        
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        visible(jPanel1);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        visible(jPanel3);
        cargartodos();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        cargartodos();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        cargar1mes();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        cargar3mes();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        cargar12mes();
    }//GEN-LAST:event_jButton1MouseClicked
    
    public void cargar12mes(){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            List<Empleado> dept = helper.getPersonasByTipotext2(jComboBox3.getSelectedItem().toString());
            helper.cerrarSesion();
            DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            for(Empleado i: dept){
                
                String nombre=i.getNombre1()+" "+i.getNombre2()+" "+i.getApellido1()+" "+i.getApellido2();
                Calendar calin = Calendar.getInstance();
                Calendar calfn = Calendar.getInstance();
                int an=0;
                if(i.getFechaIngreso()!=null){
                    calfn.setTimeInMillis(i.getFechaIngreso().getTime());
                    an=calfn.get(Calendar.MINUTE);
                    an= calin.get(Calendar.MINUTE)-an ;
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }else{
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }
                int anio = (int)(calfn.getTimeInMillis()/ MILLSECS_PER_DAY)/365;
                int dias = calfn.get(Calendar.DAY_OF_MONTH);
                int mes = calfn.get(Calendar.MONTH);
                if((mes<=12) && (mes>=10) &&(anio==0)){
                DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                Object nuevo[]= {i.getCi(),nombre,Funcion.DateFormat(i.getFechaIngreso()),dias,mes,anio};
                temp.addRow(nuevo);
                }
            }
        }catch(Exception io){
        
        }
    }
    
    public void cargar3mes(){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            List<Empleado> dept = helper.getPersonasByTipotext2(jComboBox3.getSelectedItem().toString());
            helper.cerrarSesion();
            DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            for(Empleado i: dept){
                
                String nombre=i.getNombre1()+" "+i.getNombre2()+" "+i.getApellido1()+" "+i.getApellido2();
                Calendar calin = Calendar.getInstance();
                Calendar calfn = Calendar.getInstance();
                int an=0;
                if(i.getFechaIngreso()!=null){
                    calfn.setTimeInMillis(i.getFechaIngreso().getTime());
                    an=calfn.get(Calendar.MINUTE);
                    an= calin.get(Calendar.MINUTE)-an ;
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }else{
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }
                int anio = (int)(calfn.getTimeInMillis()/ MILLSECS_PER_DAY)/365;
                int dias = calfn.get(Calendar.DAY_OF_MONTH);
                int mes = calfn.get(Calendar.MONTH);
                if((mes<=3) && (mes>=2) &&(dias>=15) &&(anio==0)){
                DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                Object nuevo[]= {i.getCi(),nombre,Funcion.DateFormat(i.getFechaIngreso()),dias,mes,anio};
                temp.addRow(nuevo);
                }
            }
        }catch(Exception io){
        
        }
    }
    
    public void cargar1mes(){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            List<Empleado> dept = helper.getPersonasByTipotext2(jComboBox3.getSelectedItem().toString());
            helper.cerrarSesion();
            DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            for(Empleado i: dept){
                
                String nombre=i.getNombre1()+" "+i.getNombre2()+" "+i.getApellido1()+" "+i.getApellido2();
                Calendar calin = Calendar.getInstance();
                Calendar calfn = Calendar.getInstance();
                int an=0;
                if(i.getFechaIngreso()!=null){
                    calfn.setTimeInMillis(i.getFechaIngreso().getTime());
                    an=calfn.get(Calendar.MINUTE);
                    an= calin.get(Calendar.MINUTE)-an ;
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }else{
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }
                int anio = (int)(calfn.getTimeInMillis()/ MILLSECS_PER_DAY)/365;
                int dias = calfn.get(Calendar.DAY_OF_MONTH);
                int mes = calfn.get(Calendar.MONTH);
                if((mes<=1) && (dias>=15) &&(anio==0)){
                DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                Object nuevo[]= {i.getCi(),nombre,Funcion.DateFormat(i.getFechaIngreso()),dias,mes,anio};
                temp.addRow(nuevo);
                }
            }
        }catch(Exception io){
        
        }
    }
    
    
    public void cargartodos(){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            List<Empleado> dept = helper.getPersonasByTipotext2(jComboBox3.getSelectedItem().toString());
            helper.cerrarSesion();
            DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            for(Empleado i: dept){
                DefaultTableModel temp = (DefaultTableModel) jTable2.getModel();
                String nombre=i.getNombre1()+" "+i.getNombre2()+" "+i.getApellido1()+" "+i.getApellido2();
                Calendar calin = Calendar.getInstance();
                Calendar calfn = Calendar.getInstance();
                int an=0;
                if(i.getFechaIngreso()!=null){
                    calfn.setTimeInMillis(i.getFechaIngreso().getTime());
                    an=calfn.get(Calendar.MINUTE);
                    an= calin.get(Calendar.MINUTE)-an ;
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }else{
                    calfn.setTimeInMillis(calin.getTimeInMillis()-calfn.getTimeInMillis());
                }
                int anio = (int)(calfn.getTimeInMillis()/ MILLSECS_PER_DAY)/365;
                int dias = calfn.get(Calendar.DAY_OF_MONTH);
                int mes = calfn.get(Calendar.MONTH);
                Object nuevo[]= {i.getCi(),nombre,Funcion.DateFormat(i.getFechaIngreso()),dias,mes,anio};
                temp.addRow(nuevo);
            }
        }catch(Exception io){
        
        }
    }
    
    public void visible(JPanel pane){
        jPanel1.setVisible(false);
        jPanel3.setVisible(false);
        pane.setVisible(true);
    }
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
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Notificaciones> noti = null;
            if(tipo==1){
                noti= helper.getNotificaciones(modo);
            }
            if(tipo==2){
                noti= helper.getNotificacionesNV(modo);
            }
            if(tipo==3){
                noti= helper.getNotificacionesV(modo);
            }
            helper.cerrarSesion();
            
            
            DefaultTableModel temp2 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            
            if(noti!=null){
            for(int i=0; i<noti.size();i++){
                if(jTable1.getRowCount()< noti.size()){
                    DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                    Object nuevo[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo);
                }
                    jTable1.getModel().setValueAt(noti.get(i).getVisto(), i, 0);
                    jTable1.getModel().setValueAt(noti.get(i).getInformacion(), i, 1);
                    jTable1.getModel().setValueAt(noti.get(i).getFecha(), i, 2);
                    jTable1.getModel().setValueAt(noti.get(i).getResponsable(), i, 3);
                    jTable1.getModel().setValueAt(noti.get(i).getModulo(), i, 4);
                    jTable1.getModel().setValueAt(noti.get(i).getInstalacion(), i, 5);
                    jTable1.getModel().setValueAt(noti.get(i).getId(), i, 6);
                }
            }
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        }catch(Exception io){
        
        }
        
        
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
            Logger.getLogger(noti.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(noti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(noti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(noti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(noti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new noti(null).setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
