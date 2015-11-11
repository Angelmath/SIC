/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Login;
import Login.Entidad.Owncloud;
import Login.servicio.ServiceHb;
import static Login.ventas.marco.reiniciarJTable;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author homemig
 */

public class folderowncloud extends javax.swing.JFrame {

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
    
    
    
    public folderowncloud(final Login log) {
        initComponents();
        
        this.usuario=log;
        setSize(d.width, d.height-1);
        jLabel13.setSize(d.width,58);
        jLabel16.setLocation((d.width)-(jLabel16.getWidth()), jLabel16.getY());
        jLabel15.setLocation((d.width)-(jLabel15.getWidth()), jLabel15.getY());
        jLabel15.setText(log.getNombre());
        jLabel17.setLocation((d.width)-(jLabel17.getWidth()), jLabel17.getY());
        jLabel18.setLocation((d.width)-(jLabel18.getWidth()), jLabel18.getY());
        jLabel5.setSize(d.width, d.height);
        jLabel1.setSize(d.width, jLabel1.getHeight());
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        
        tablasmodelos(jTable1,jPanel1);
        JScrollBar sb = jScrollPane1.getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        jTable1.getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        jTable1.getColumn("EDITAR").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("VER").setCellRenderer(new ButtonRenderer());
        
        jPanel1.setLocation((d.width/2)-(jPanel1.getWidth()/2), jPanel1.getY());
        jScrollPane1.setSize(d.width-(jScrollPane1.getX()*2), d.height-100-jScrollPane1.getY());
        jScrollPane1.setLocation((d.width/2)-(jScrollPane1.getWidth()/2), jScrollPane1.getY());
        jButton1.setLocation(jScrollPane1.getX(),jScrollPane1.getY()-jButton1.getHeight());
        new updateTablas().start();
        setVisible(true);
    }
    
    public void cargar(String tipo){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Owncloud> lista = helper.getOwncloud(tipo, usuario);
            reiniciarJTable(jTable1);
            if(lista!=null){
                for(int i=0; i<lista.size();i++){
                    String c1=lista.get(i).getId()+"";
                    String c2=lista.get(i).getNombre();
                    String c3=lista.get(i).getDireccion();
                    DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                    Login l = (Login)helper.obtenerObjeto(Login.class, Integer.parseInt(lista.get(i).getDuenio()));
                    Object nuevo[]= {c1,c2,c3,l.getNombre(),lista.get(i),lista.get(i)};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public void cambio(JLabel label){
        c1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        
    }
    
    public String selectlabel(){
        if(c1.getBorder()==javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)){
            return c1.getText();
        }
        if(c2.getBorder()==javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)){
            return c2.getText();
        }
        if(c3.getBorder()==javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)){
            return c3.getText();
        }
        if(c4.getBorder()==javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)){
            return c4.getText();
        }
        if(c5.getBorder()==javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)){
            return c5.getText();
        }
        if(c6.getBorder()==javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)){
            return c6.getText();
        }
        return "";
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
    
    protected int compare(int i, int j) {
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        return s1.compareTo(s2);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Categoria", "Subido por", "EDITAR", "VER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(4).setMinWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(5).setMinWidth(120);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 190, 1160, 402);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        c1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1.setText("SEG. Electrónica");
        c1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c1MouseClicked(evt);
            }
        });
        jPanel1.add(c1);
        c1.setBounds(180, 0, 180, 50);

        c2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c2.setText("SEG. Física");
        c2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c2MouseClicked(evt);
            }
        });
        jPanel1.add(c2);
        c2.setBounds(360, 0, 180, 50);

        c3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3.setText("RRHH");
        c3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c3MouseClicked(evt);
            }
        });
        jPanel1.add(c3);
        c3.setBounds(540, 0, 180, 50);

        c4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4.setText("Comercial");
        c4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c4MouseClicked(evt);
            }
        });
        jPanel1.add(c4);
        c4.setBounds(720, 0, 180, 50);

        c5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c5.setText("Varios");
        c5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c5MouseClicked(evt);
            }
        });
        jPanel1.add(c5);
        c5.setBounds(900, 0, 180, 50);

        c6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c6.setText("Academia");
        c6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        c6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c6MouseClicked(evt);
            }
        });
        jPanel1.add(c6);
        c6.setBounds(0, 0, 180, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(70, 90, 1080, 50);

        jButton1.setText("AGREGAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 150, 180, 40);

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

    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked
        cambio(c1);
        new updateTablas().start();
    }//GEN-LAST:event_c1MouseClicked

    private void c2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c2MouseClicked
        cambio(c2);
        new updateTablas().start();
    }//GEN-LAST:event_c2MouseClicked

    private void c3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseClicked
        cambio(c3);
        new updateTablas().start();
    }//GEN-LAST:event_c3MouseClicked

    private void c4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseClicked
        cambio(c4);
        new updateTablas().start();
    }//GEN-LAST:event_c4MouseClicked

    private void c5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c5MouseClicked
        cambio(c5);
        new updateTablas().start();
    }//GEN-LAST:event_c5MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        folderownpdf fd = new folderownpdf(this, true,selectlabel(),usuario);
        cargar(selectlabel());
    }//GEN-LAST:event_jButton1MouseClicked

    public String nombrecarpeta(String nombre){
        if(nombre.contains("SEG. Electrónica")){
            return "SIC PDF/Seguridad Electronica";
        }
        if(nombre.contains("Academia")){
            return "SIC PDF/Academia";
        }
        if(nombre.contains("SEG. Física")){
            return "SIC PDF/Seguridad Fisica";
        }
        if(nombre.contains("RRHH")){
            return "SIC PDF/RRHH";
        }
        if(nombre.contains("Comercial")){
            return "SIC PDF/Comercial";
        }
        if(nombre.contains("Varios")){
            return "SIC PDF/Varios";
        }
        
        return "";
    }
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==4){
            Owncloud own = (Owncloud)jTable1.getValueAt(row, col);
            if(Integer.parseInt(own.getDuenio())==usuario.getId()){
                folderownpdfedit dfe = new folderownpdfedit(this, true, selectlabel(), usuario, own);
            }
        }
        if(col==5){
            Owncloud own = (Owncloud)jTable1.getValueAt(row, col);
            String direccion= usuario.getOwncloud();
            File f = new File(direccion+nombrecarpeta(own.getDireccion())+"/"+own.getNombre()+".pdf");
            if(f.exists()){
                Principal p = new Principal(direccion+nombrecarpeta(own.getDireccion())+"/"+own.getNombre()+".pdf");
                p.next();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void c6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c6MouseClicked
        cambio(c6);
        new updateTablas().start();
    }//GEN-LAST:event_c6MouseClicked
   
    public class updateTablas extends Thread {
        int turno;
        public updateTablas(){
        }
        @Override
        public void run() {   
            cargar(selectlabel());
        }
    }  
    
    private void logeo(){
        
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(folderowncloud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new folderowncloud(null).setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
