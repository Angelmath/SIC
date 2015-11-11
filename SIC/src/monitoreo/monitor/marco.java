package monitoreo.monitor;

import Login.ventas.*;
import Login.Entidad.Login;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.table.*;
import maps.java.StaticMaps;

/**
 *
 * @author Matheus Puero
 */
public final class marco extends javax.swing.JFrame {
    int breakhilo=0;
    JTable tableSorted;
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int pdfcarga;
    int xx;
    int yy;
    int sortColumn;
    int[] row;
    Login Usuario;
    Runnable idn2;
    DefaultTableModel base;
    boolean configuracion=false; // Controla el boton de cerrar secion y configuracion
    inicio in;
    tareas ta;
    configuracion conf;
    master mast;
    private StaticMaps ObjStaticMaps=new StaticMaps();
    
    public marco(Login Usuario) {
        initComponents();
        this.Usuario= Usuario;
        paneles();    // Inicializacion de los Paneles
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(d.width, d.height-1);
        
        jLabel15.setLocation((d.width)-(jLabel15.getWidth()), jLabel15.getY());
        jLabel16.setLocation((d.width)-(jLabel16.getWidth()), jLabel16.getY());
        jLabel18.setLocation((d.width)-(jLabel18.getWidth()), jLabel18.getY());
        jLabel17.setLocation((d.width)-(jLabel17.getWidth()), jLabel17.getY());
        jLabel1.setSize(d.width,3);
        
        setResizable(true);
        
        jLabel8.setSize(d.width, 58);
        jLabel3.setSize(100, d.height);
        jLabel8.setIcon(new ImageIcon(((ImageIcon) jLabel8.getIcon()).getImage().getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_DEFAULT)));
        jLabel3.setIcon(new ImageIcon(((ImageIcon) jLabel3.getIcon()).getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_DEFAULT)));
        
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
        
        accesoUsuario();/*Angelmath*/
        
        tablas();/*Angelmath*/
        
        eventos();/*Angelmath*/
        
    }    
    
    private void paneles() {
        in= new inicio();
        in.setLocation(100, 61);
        add(in);
        
        ta= new tareas();
        ta.setLocation(100, 61);
        add(ta);
        
        mast= new master();
        mast.setLocation(100, 61);
        add(mast);
        
        conf= new configuracion();
        conf.setLocation(100, 61);
        add(conf);
    }
    public void visible(JPanel pane){
        in.setVisible(false);
        ta.setVisible(false);
        mast.setVisible(false);
        conf.setVisible(false);
        pane.setVisible(true);
    }
    
    private void accesoUsuario() {
        visible(in);
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

    public inicio getIn() {
        return in;
    }

    public void setIn(inicio in) {
        this.in = in;
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

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
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

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        jLabel16.setBounds(700, 140, 172, 38);
        jLabel16.setVisible(false);

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
        jLabel17.setBounds(700, 61, 172, 38);
        jLabel17.setVisible(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/icono-monitoreo-TEXTO.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 12, 200, 34);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/barra-superior.png"))); // NOI18N
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
        jLabel8.setBounds(0, 0, 1000, 58);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 58, 870, 3);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/permisos-boton-lightblue.png"))); // NOI18N
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
        jLabel18.setBounds(700, 100, 172, 38);
        jLabel18.setVisible(false);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/barra-separadora-sic.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 272, 56, 2);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/barra-separadora-sic.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 330, 56, 2);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/barra-separadora-sic.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(22, 170, 56, 2);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/barra-separadora-sic.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 220, 56, 2);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/select-icon-blue.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(84, 130, 15, 29);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/config2-icon-lightblue.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(35, 285, 30, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/master-icon-lightblue.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(35, 233, 30, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/monitoreo-icon-lightblue.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(35, 180, 30, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-blue.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(35, 130, 30, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/barra-izquierda.png"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 61, 100, 550);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 61, 0, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
   
    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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


    public Runnable getIdn2() {
        return idn2;
    }

    public void setIdn2(Runnable idn2) {
        this.idn2 = idn2;
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
        permisos permisos = new permisos(Usuario);
        dispose();  
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseExited

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

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/permisos-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/permisos-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
//        nav_seleccionado=4;
        getjLabel10().setLocation(getjLabel10().getX(), getjLabel7().getY());
        visible(conf);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/config2-icon-blue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/master-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/monitoreo-icon-lightblue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
//        if(nav_seleccionado!=4){
//            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-blue.png"))); // NOI18N
//
//        }
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
//        if(nav_seleccionado!=4){
//            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
//        }
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
//        nav_seleccionado=3;
        getjLabel10().setLocation(getjLabel10().getX(), getjLabel6().getY());
        visible(mast);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/config2-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/master-icon-blue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/monitoreo-icon-lightblue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
//        if(nav_seleccionado!=3){
//            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-blue.png"))); // NOI18N
//
//        }
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
//        if(nav_seleccionado!=3){
//            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
//        }
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/config2-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/master-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/monitoreo-icon-blue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
        getjLabel10().setLocation(getjLabel10().getX(), getjLabel5().getY());
        visible(ta);
        //ta.tiempo();
//        getjLabel18().setVisible(!getjLabel18().isVisible());
//        getjLabel19().setVisible(!getjLabel19().isVisible());
//        getjLabel20().setVisible(!getjLabel20().isVisible());
//        if(!getjLabel20().isVisible()){
//            getjLabel6().setLocation(getjLabel6().getX(), getjLabel6().getY()-60);
//            getjLabel7().setLocation(getjLabel7().getX(), getjLabel7().getY()-60);
//            getjLabel11().setLocation(getjLabel11().getX(), getjLabel11().getY()-60);
//            getjLabel12().setLocation(getjLabel12().getX(), getjLabel12().getY()-60);
//            getjLabel14().setLocation(getjLabel14().getX(), getjLabel14().getY()-60);
//        }else{
//            getjLabel6().setLocation(getjLabel6().getX(), getjLabel6().getY()+60);
//            getjLabel7().setLocation(getjLabel7().getX(), getjLabel7().getY()+60);
//            getjLabel11().setLocation(getjLabel11().getX(), getjLabel11().getY()+60);
//            getjLabel12().setLocation(getjLabel12().getX(), getjLabel12().getY()+60);
//            getjLabel14().setLocation(getjLabel14().getX(), getjLabel14().getY()+60);
//        }
            
             this.ta.getjLabel1().setText("");
             Image imagenMapa;
        try {
            imagenMapa = ObjStaticMaps.getStaticMap("Ecuador Guayaquil",
                Integer.valueOf("5"),new Dimension(500,500),
                Integer.valueOf("5"),this.seleccionarFormato(),
                this.seleccionarTipoMapa());
        
            if(imagenMapa!=null){
                ImageIcon imgIcon=new ImageIcon(imagenMapa);
                Icon iconImage=(Icon)imgIcon;
                ta.getjLabel1().setIcon(iconImage);
            }
         } catch (MalformedURLException ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MouseClicked
    
    private StaticMaps.Format seleccionarFormato(){
        StaticMaps.Format formato= StaticMaps.Format.png;
//        switch(JCombo_ME_Formato.getSelectedItem().toString()){
//            case "png":
//                formato= StaticMaps.Format.png;
//                break;
//            case "png32":
//                formato= StaticMaps.Format.png32;
//                break;
//            case "gif":
//                formato= StaticMaps.Format.gif;
//                break;
//            case "jpg":
//                formato= StaticMaps.Format.jpg;
//                break;
//            case "jpg_baseline":
//                formato= StaticMaps.Format.jpg_baseline;
//                break;
//        }
        formato= StaticMaps.Format.png;
        return formato;
    }
    
    private StaticMaps.Maptype seleccionarTipoMapa(){
        StaticMaps.Maptype tipoMapa= StaticMaps.Maptype.roadmap;
//        switch(JCombo_ME_TipoMapa.getSelectedItem().toString()){
//            case "roadmap":
//                tipoMapa= StaticMaps.Maptype.roadmap;
//                break;
//            case "satellite":
//                tipoMapa= StaticMaps.Maptype.satellite;
//                break;
//            case "hybrid":
//                tipoMapa= StaticMaps.Maptype.hybrid;
//                break;
//            case "terrain":
//                tipoMapa= StaticMaps.Maptype.terrain;
//                break;
//        }
        tipoMapa= StaticMaps.Maptype.roadmap;
        return tipoMapa;
    }
        
    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
//        if(nav_seleccionado!=2){
//            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
//
//        }
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
//        if(nav_seleccionado!=2){
//            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-lightblue.png"))); // NOI18N
//        }
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
//        nav_seleccionado=1;
        getjLabel10().setLocation(getjLabel10().getX(), getjLabel4().getY());
        visible(in);
//        cambio(inicio_panel);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/config2-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/master-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/monitoreo-icon-lightblue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-blue.png"))); // NOI18N

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
//        if(nav_seleccionado!=1){
//            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-blue.png"))); // NOI18N
//        }
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
//        if(nav_seleccionado!=1){
//            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
//        }
    }//GEN-LAST:event_jLabel4MouseExited
    
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
            java.util.logging.Logger.getLogger(marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    // End of variables declaration//GEN-END:variables
  
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
        
    }

    private void eventos() {
        //Cliente
            
        //
    }
    
    public class updateTablas extends Thread {
        int turno;
        public updateTablas(int turno){
            this.turno=turno;
        }
        
        public void run() {
            breakhilo=1;
            try{
            sleep(200);
            breakhilo=0;
            }catch(Exception io){}
            if(turno==7){
            }
        }
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
  public boolean stopCellEditing() {
    isPushed = false;
    return stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    fireEditingStopped();
  }
}
