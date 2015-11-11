/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Login;
import Login.Entidad.Materiales;
import Login.Entidad.Orden;
import Login.servicio.ServiceHb;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author homemig
 */
public class materiales extends javax.swing.JPanel {
Login usuario;
    /**
     * Creates new form facturacion
     */
    public materiales(Login us) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        this.usuario=us;
        setVisible(false);
        setSize(d.width, d.height-95);
        jPanel1.setLocation((d.width/2)-(jPanel1.getWidth()/2), ((d.height -95)/2)-(jPanel1.getHeight()/2));
        jSeparator1.setSize(d.width, 1);
        setEventoMouseClicked8(getjTable1());
        jTable1.getColumn("VER").setCellRenderer(new materiales.ButtonRenderer());
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            List<rrhh.Entidad.Empleado> emp = helper.getPersonasdepartamento("Seguridad Electronica");
            helper.cerrarSesion();
            jComboBox1.removeAllItems();
            for(rrhh.Entidad.Empleado i : emp){
                jComboBox1.addItem(i.getNombre1()+" "+i.getNombre2()+" "+i.getApellido1()+" "+i.getApellido2());
            }
        }catch(Exception io){
        }
    }

    public JButton getjButton11() {
        return jButton11;
    }

    public void setjButton11(JButton jButton11) {
        this.jButton11 = jButton11;
    }

    public JButton getjButton8() {
        return jButton8;
    }

    public void setjButton8(JButton jButton8) {
        this.jButton8 = jButton8;
    }

    public JButton getjButton9() {
        return jButton9;
    }

    public void setjButton9(JButton jButton9) {
        this.jButton9 = jButton9;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JButton getjButton6() {
        return jButton6;
    }

    public void setjButton6(JButton jButton6) {
        this.jButton6 = jButton6;
    }

    public JButton getjButton7() {
        return jButton7;
    }

    public void setjButton7(JButton jButton7) {
        this.jButton7 = jButton7;
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
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

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }
    
    private void setEventoMouseClicked8(JTable tbl)
    {
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
        if(getjTable1().getSelectedColumn()==2){
            int row = getjTable1().rowAtPoint(evt.getPoint());
            if(!getjTable1().getValueAt(getjTable1().getSelectedRow(), 2).toString().equalsIgnoreCase("000000")){
                if (row >= 0 && getjTable1().isEnabled())
                {
                    presentar1materiales presentar1 = new presentar1materiales(null,null,true,getjTable1().getValueAt(getjTable1().getSelectedRow(), 2).toString(),usuario);
                }
            }
        }
    }
    
    public ComponentUI getUi() {
        return ui;
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jSeparator1.setOpaque(true);
        add(jSeparator1);
        jSeparator1.setBounds(0, 10, 890, 10);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton1.setText("Quitar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(790, 440, 70, 60);

        jButton2.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.setVisible(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(790, 290, 70, 30);

        jButton3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton3.setText("Subir");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(790, 320, 70, 60);

        jButton4.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton4.setText("Bajar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(790, 380, 70, 60);

        jButton5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton5.setText("Extra");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(790, 500, 70, 60);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cant.", "DESCRIPCION", "VER", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDropMode(javax.swing.DropMode.ON);
        jTable1.setRowHeight(28);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(60);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(150);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 290, 750, 280);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MATERIALES");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(300, 260, 290, 29);

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Agregar");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel1.add(jLabel21);
        jLabel21.setBounds(30, 590, 90, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setVisible(false);
        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/back.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel19);
        jLabel19.setBounds(810, 590, 50, 50);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Roboto Thin", 3, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel6.setText("Historial:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(470, 20, 100, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel7.setText("Cliente:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 50, 100, 30);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel2.setText("Valor");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(220, 50, 250, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel3.setText("Valor");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(220, 20, 250, 30);

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel9.setText("Instalacion:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(50, 80, 140, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel10.setText("Fecha:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(50, 110, 140, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel4.setText("Valor");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(220, 110, 260, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel5.setText("Valor");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(220, 80, 270, 30);

        jLabel13.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("F. INICIO:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(50, 140, 58, 30);

        jDateChooser1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(210, 140, 170, 30);

        jLabel16.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel16.setText("Ticket:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(50, 20, 100, 30);

        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox2MouseReleased(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(470, 60, 150, 30);

        jTextField1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jTextField1.setEnabled(false);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(470, 110, 150, 30);

        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(760, 60, 33, 30);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-buscar.png"))); // NOI18N
        jPanel2.add(jButton9);
        jButton9.setBounds(700, 110, 50, 30);
        jButton9.setVisible(false);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-buscar.png"))); // NOI18N
        jPanel2.add(jButton11);
        jButton11.setBounds(700, 60, 50, 30);

        jButton18.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-eliminar.png"))); // NOI18N
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton18MouseExited(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton18);
        jButton18.setBounds(640, 110, 49, 29);
        jButton18.setVisible(false);

        jButton19.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-eliminar.png"))); // NOI18N
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19MouseExited(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton19);
        jButton19.setBounds(640, 60, 49, 29);

        jTabbedPane1.addTab("Informacion", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel1.setText("Instrucciones:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(30, 10, 140, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(30, 50, 570, 140);

        jTabbedPane1.addTab("Instrucciones", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jCheckBox1.setText("Fase 1: Ducteria");
        jPanel5.add(jCheckBox1);
        jCheckBox1.setBounds(40, 70, 160, 25);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jCheckBox2.setText("Configuración de equipos");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox2);
        jCheckBox2.setBounds(420, 70, 180, 25);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jCheckBox3.setText("Fase 1: Montaje Equipos");
        jPanel5.add(jCheckBox3);
        jCheckBox3.setBounds(40, 140, 190, 25);

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jCheckBox4.setText("Calibracion de Equipos");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox4);
        jCheckBox4.setBounds(420, 140, 180, 25);

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jCheckBox5.setText("Revisión de equipos");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox5);
        jCheckBox5.setBounds(240, 140, 160, 25);

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jCheckBox6.setText("Reparación");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox6);
        jCheckBox6.setBounds(240, 70, 120, 25);

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Tipo de Trabajo:");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(20, 10, 110, 30);

        jTabbedPane1.addTab("Tipo de Trabajo", jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(20, 110, 290, 90);

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel11.setText("Nombre de Tecnicos:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(420, 70, 140, 30);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(420, 110, 330, 90);

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 3, 12)); // NOI18N
        jLabel14.setText("Personal Asignado:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(30, 70, 114, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(180, 20, 270, 30);

        jLabel15.setText("Seguridad Electronica:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(20, 20, 130, 30);

        jButton6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton6.setText("Agregar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(580, 73, 80, 30);

        jButton7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton7.setText("Agregar");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(170, 73, 90, 30);

        jTabbedPane1.addTab("Empleados", jPanel3);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 10, 840, 240);

        add(jPanel1);
        jPanel1.setBounds(0, 10, 880, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked

    }//GEN-LAST:event_jLabel19MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        Double cantidad=0.0;
        Double precio=0.0;
        Double total;
        Double total2=0.0;
        Double iva;
        Double total3;
        DecimalFormat df = new DecimalFormat("#.##");
        
        
        
        if(java.awt.event.KeyEvent.getKeyText(evt.getKeyCode()).equalsIgnoreCase("f1")&&getjTable1().getSelectedRow()!=getjTable1().getRowCount()){
            DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
            temp.removeRow(getjTable1().getSelectedRow());
         }
         
             for (int i=0; i<=getjTable1().getModel().getRowCount()-1; i++)
            {
                try{    
                cantidad=Double.parseDouble(getjTable1().getModel().getValueAt(i, 0).toString());
                
                } catch (Exception ex) {
                    getjTable1().getModel().setValueAt("",i, 0);
                }
                try{    
                precio=Double.parseDouble(getjTable1().getModel().getValueAt(i, 2).toString());
                } catch (Exception ex) {
                    getjTable1().getModel().setValueAt("",i, 2);
                }
                if(!getjTable1().getModel().getValueAt(i, 2).toString().equalsIgnoreCase("")||!getjTable1().getModel().getValueAt(i, 0).toString().equalsIgnoreCase("")){
                total= cantidad*precio;
                total2= total + total2;
                getjTable1().setValueAt("$"+df.format(total).replace(",", "."), i, 3);
                }
            }
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
       
    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
                DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
                ingresoMateriales in = new ingresoMateriales(null,null,true,usuario);
                Object nuevo[]= {"",in.getLt().get(3),in.getLt().get(5)};
                temp.addRow(nuevo);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        DefaultTableModel model =  (DefaultTableModel)getjTable1().getModel();
        int[] rows = getjTable1().getSelectedRows();
        model.moveRow(rows[0],rows[rows.length-1],rows[0]-1);
        getjTable1().setRowSelectionInterval(rows[0]-1, rows[rows.length-1]-1);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        DefaultTableModel model =  (DefaultTableModel)getjTable1().getModel();
        int[] rows = getjTable1().getSelectedRows();
        model.moveRow(rows[0],rows[rows.length-1],rows[0]+1);
        getjTable1().setRowSelectionInterval(rows[0]+1, rows[rows.length-1]+1);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        DefaultTableModel model =  (DefaultTableModel)getjTable1().getModel();
        int rows = getjTable1().getSelectedRow();
        if(getjTable1().getValueAt(rows,2).toString().equalsIgnoreCase("000000")){
            model.removeRow(rows);
        }else{
            
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
        Object nuevo[]= {"","","000000"};
        temp.addRow(nuevo);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
//        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar-texto-hover.png"))); // NOI18N
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
//        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar-texto.png"))); // NOI18N
    }//GEN-LAST:event_jLabel21MouseExited

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    public JCheckBox getjCheckBox1() {
        return jCheckBox1;
    }

    public void setjCheckBox1(JCheckBox jCheckBox1) {
        this.jCheckBox1 = jCheckBox1;
    }

    public JCheckBox getjCheckBox2() {
        return jCheckBox2;
    }

    public void setjCheckBox2(JCheckBox jCheckBox2) {
        this.jCheckBox2 = jCheckBox2;
    }

    public JCheckBox getjCheckBox3() {
        return jCheckBox3;
    }

    public void setjCheckBox3(JCheckBox jCheckBox3) {
        this.jCheckBox3 = jCheckBox3;
    }

    public JCheckBox getjCheckBox4() {
        return jCheckBox4;
    }

    public void setjCheckBox4(JCheckBox jCheckBox4) {
        this.jCheckBox4 = jCheckBox4;
    }

    public JCheckBox getjCheckBox5() {
        return jCheckBox5;
    }

    public void setjCheckBox5(JCheckBox jCheckBox5) {
        this.jCheckBox5 = jCheckBox5;
    }

    public JCheckBox getjCheckBox6() {
        return jCheckBox6;
    }

    public void setjCheckBox6(JCheckBox jCheckBox6) {
        this.jCheckBox6 = jCheckBox6;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JTextArea getjTextArea2() {
        return jTextArea2;
    }

    public void setjTextArea2(JTextArea jTextArea2) {
        this.jTextArea2 = jTextArea2;
    }

    public JTextArea getjTextArea3() {
        return jTextArea3;
    }

    public void setjTextArea3(JTextArea jTextArea3) {
        this.jTextArea3 = jTextArea3;
    }

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        if(jTextArea2.getText().equalsIgnoreCase("")){
            jTextArea2.setText(jTextArea2.getText()+""+jComboBox1.getSelectedItem().toString());
        }else{
            jTextArea2.setText(jTextArea2.getText()+"\n"+jComboBox1.getSelectedItem().toString());
        }
        
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        if(jTextArea3.getText().equalsIgnoreCase("")){
            jTextArea3.setText(jTextArea3.getText()+""+jComboBox1.getSelectedItem().toString());
        }else{
            jTextArea3.setText(jTextArea3.getText()+"\n"+jComboBox1.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseEntered

    }//GEN-LAST:event_jButton18MouseEntered

    private void jButton18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseExited
        jLabel8.setVisible(false);
    }//GEN-LAST:event_jButton18MouseExited

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19MouseEntered

    private void jButton19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19MouseExited

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        
    }//GEN-LAST:event_jButton8MouseClicked

    private void jComboBox2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseReleased
       
    }//GEN-LAST:event_jComboBox2MouseReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
         try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Materiales mat= helper.getMaterialesnombre(getjComboBox2().getSelectedItem().toString());
            helper.cerrarSesion();
            
            if(mat.getOrdentrabajo()!=null){
                getjTextField1().setText(mat.getOrdentrabajo());
                getjButton9().setVisible(true);
                getjButton18().setVisible(true);
            }else{
                getjTextField1().setText("");
                getjButton9().setVisible(false);
                getjButton18().setVisible(false);
            }
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    public JButton getjButton18() {
        return jButton18;
    }

    public void setjButton18(JButton jButton18) {
        this.jButton18 = jButton18;
    }

    public JButton getjButton19() {
        return jButton19;
    }

    public void setjButton19(JButton jButton19) {
        this.jButton19 = jButton19;
    }
    
    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
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
    this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
    return this;
  }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
