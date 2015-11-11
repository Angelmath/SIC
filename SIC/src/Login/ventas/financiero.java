package Login.ventas;

import Login.Entidad.Login;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Matheus Puero
 */

public final class financiero extends javax.swing.JFrame {
    int breakhilo=0;
    Login Usuario;
    JTable tableSorted;
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    fccobrar ccobrar;
    fcpagar cpagar;
    fbalance balance;
    findex index;
    fpresupuesto presupuesto;
    fproyectos proyectos;
    fmensual mensual;
    fcajachica cajachica;
    fcalendario calendario;
    fpagosvarios proveedores;
    
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
    
    public financiero(Login Usuario, int panel) {
        this.Usuario=Usuario;
        initComponents();
        paneles();    // Inicializacion de los Paneles
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
        turnopanel(panel);
        accesoUsuario();/*Angelmath*/
        tablas();/*Angelmath*/
        
        eventos();/*Angelmath*/
        
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
    
    private void tablas() {
        tablasmodelos(ccobrar.getjTable1(),ccobrar);
        JScrollBar sb = ccobrar.getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        ccobrar.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        ccobrar.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(20);
        ccobrar.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        ccobrar.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        ccobrar.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        ccobrar.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        ccobrar.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        ccobrar.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(proyectos.getF4().getjTable1(),proyectos.getF4());
        sb = proyectos.getF4().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proyectos.getF4().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF4().getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        tablasmodelos(proyectos.getF().getjTable1(),proyectos.getF());
        sb = proyectos.getF().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proyectos.getF().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        proyectos.getF().getjTable1().getColumn("Iniciar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(proyectos.getF2().getjTable2(),proyectos.getF2());
        sb = proyectos.getF2().getjScrollPane2().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proyectos.getF2().getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF2().getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF2().getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF2().getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(proyectos.getF2().getjTable1(),proyectos.getF2());
        sb = proyectos.getF2().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proyectos.getF2().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF2().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF2().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF2().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF2().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        proyectos.getF2().getjTable1().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(proveedores.getjTable1(),proveedores);
        sb = proyectos.getF3().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proveedores.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        proveedores.getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        
        proveedores.getjTable1().getColumn("Guardar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(proyectos.getF3().getjTable1(),proyectos.getF3());
        sb = proyectos.getF3().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proyectos.getF3().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF3().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF3().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF3().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF3().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF3().getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF3().getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        proyectos.getF3().getjTable1().getColumn("Ver").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(proyectos.getF5().getjTable1(),proyectos.getF5());
        sb = proyectos.getF5().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proyectos.getF5().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable1().getColumn("Ver").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(proyectos.getF5().getjTable2(),proyectos.getF5());
        sb = proyectos.getF5().getjScrollPane2().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        proyectos.getF5().getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        proyectos.getF5().getjTable2().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        
        tablasmodelos(cpagar.getjTable1(),cpagar);
        sb = cpagar.getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        cpagar.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        cpagar.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(20);
        cpagar.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        cpagar.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        cpagar.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );

        TableColumn sportColumn = cpagar.getjTable1().getColumnModel().getColumn(5);
        JCheckBox comboBox = new JCheckBox();
        comboBox.setSize(40, 26);
        comboBox.setSelected(true);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        sportColumn.setCellRenderer(new CellRenderer("check"));
    }
    
    
    public void turnopanel(int i){
        if(i==0){
            visible(balance);
        }
        if(i==1){
            visible(ccobrar);
        }
        if(i==2){
            visible(cpagar);
        }
        if(i==3){
            visible(presupuesto);
        }
        if(i==4){
            visible(cajachica);
        }
        if(i==5){
            visible(index);
        }
        if(i==6){
            visible(proyectos);
        }
        if(i==7){
            visible(mensual);
        }
        if(i==8){
            visible(proveedores);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("SIC - Ventas");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
    
    public int getBreakhilo() {
        return breakhilo;
    }
    
    public void setBreakhilo(int breakhilo) {
        this.breakhilo = breakhilo;
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
  
    
    public JLabel getjLabel1() {
        return jLabel1;
    }
    
    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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
    
    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jLabel8MousePressed
    
    private void jLabel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(point.x - xx, point.y - yy);
    }//GEN-LAST:event_jLabel8MouseDragged
    
    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        dispose();
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
        interfasefinan m = new interfasefinan(Usuario);
        dispose();
    }//GEN-LAST:event_jLabel18MouseClicked
    
    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered
    
    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        if(ccobrar.isVisible()){
            interfasefinan m = new interfasefinan(Usuario);
            dispose();
        }else  if(cpagar.isVisible()){
            interfasefinan m = new interfasefinan(Usuario);
            dispose();
        }else if(balance.isVisible()){
            interfasefinan m = new interfasefinan(Usuario);
            dispose();
        }else if(index.isVisible()){
            interfasefinan m = new interfasefinan(Usuario);
            dispose();
        }else if(presupuesto.isVisible()){
            if(!presupuesto.getjPanel1().isVisible()){
                presupuesto.getF().setVisible(false);
                presupuesto.getjPanel1().setVisible(true);
            }else{
                interfasefinan m = new interfasefinan(Usuario);
                dispose();
            }
        }else if(proyectos.isVisible()){
            if(proyectos.getF().isVisible()){
                proyectos.visible(proyectos.getjPanel1());
            }else if(proyectos.getF2().isVisible()){
                proyectos.visible(proyectos.getF());
            }else if(proyectos.getF3().isVisible()){
                proyectos.visible(proyectos.getjPanel1());
            }else if(proyectos.getF4().isVisible()){
                proyectos.visible(proyectos.getF3());
            }else if(proyectos.getF5().isVisible()){
                proyectos.visible(proyectos.getjPanel1());
            }else{
                interfasefinan m = new interfasefinan(Usuario);
                dispose();
            }
        }else if(mensual.isVisible()){
            if(mensual.getFm().isVisible()){
                mensual.visible(mensual.getjPanel1());
            }else if(mensual.getFm3().isVisible()){
                mensual.visible(mensual.getjPanel1());
            }else{
                interfasefinan m = new interfasefinan(Usuario);
                dispose();
            }
        }else if(cajachica.isVisible()){
            interfasefinan m = new interfasefinan(Usuario);
            dispose();
        }else if(calendario.isVisible()){
            interfasefinan m = new interfasefinan(Usuario);
            dispose();
        }else if(proveedores.isVisible()){
            interfasefinan m = new interfasefinan(Usuario);
            dispose();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-back-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-back-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        JOptionPane.showMessageDialog(null, "No habilitado");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-fwd-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-fwd-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel3MouseExited
    
    public void visible(JPanel pane){
        balance.setVisible(false);
        ccobrar.setVisible(false);
        cpagar.setVisible(false);
        pane.setVisible(true);
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
            java.util.logging.Logger.getLogger(financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(financiero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new financiero(null,0).setVisible(true);
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
    
    private void eventos() {
        
    }
    
    
    public String formatoFecha(String fecha){
        String cadena[]= fecha.split("/");
        if(fecha.contains("/")){
            return cadena[2]+"-"+cadena[1]+"-"+cadena[0];
        }
        return fecha;
        
    }
    
    private void accesoUsuario() {
        
    }
    private void paneles() {
        cpagar = new fcpagar();
        cpagar.setLocation(0, 61);
        add(cpagar);  
        
        ccobrar = new fccobrar();
        ccobrar.setLocation(0, 61);
        add(ccobrar);  
        
        balance = new fbalance();
        balance.setLocation(0, 61);
        add(balance);
        
        
        index = new findex();
        index.setLocation(0, 61);
        add(index);
        
        proyectos = new fproyectos(Usuario);
        proyectos.setLocation(0, 61);
        add(proyectos);
        
        
        mensual = new fmensual();
        mensual.setLocation(0, 61);
        add(mensual);
        
        
        cajachica = new fcajachica();
        cajachica.setLocation(0, 61);
        add(cajachica);
        
        proveedores = new fpagosvarios();
        proveedores.setLocation(0, 61);
        add(proveedores);
        
        presupuesto = new fpresupuesto();
        presupuesto.setLocation(0, 61);
        add(presupuesto);
        
        calendario = new fcalendario();
        calendario.setLocation(0, 61);
        add(calendario);
        
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
        public boolean stopCellEditing() {
            isPushed = false;
            return stopCellEditing();
        }
        
        @Override
        protected void fireEditingStopped() {
            fireEditingStopped();
        }
        
    }
    
    
}
    
    
