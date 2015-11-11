/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Login;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author homemig
 */
public class facturacion extends javax.swing.JPanel {
Login usuario;
String cliente="";
int desc=0;
int inte=0;
int aumen=0;
DecimalFormat df = new DecimalFormat("#.##");
    /**
     * Creates new form facturacion
     * @param us
     */
    public facturacion(Login us) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        this.usuario=us;
        setVisible(false);
        setSize(d.width, d.height-95);
        jSeparator1.setSize(d.width, 1);
        setEventoMouseClicked8(jTable1);
        jTable1.getColumn("VER").setCellRenderer(new ButtonRenderer());
        JTextField tf = new JTextField();
        tf.setSize(200, 28);
        if(us.getNivel().equalsIgnoreCase("Administrador")){
            jTable1.getColumn("P. UNIT").setCellEditor(new ButtonEditor2(tf));
        }else{
            jTable1.getColumn("P. UNIT").setCellEditor(new ButtonEditor(tf));
        }
        aumento.removeAllItems();
        descuento.removeAllItems();
        interes.removeAllItems();
        if(usuario.getNivel().equalsIgnoreCase("Administrador")){
            for(int i=0;i<11;i++){
                descuento.addItem(i);
            }
            for(int i=0;i<1001;i++){
                aumento.addItem(i);
            }
            for(int i=0;i<21;i++){
                interes.addItem(i);
            }
        }else{
            for(int i=0;i<6;i++){
                descuento.addItem(i);
            }
            for(int i=0;i<1001;i++){
                aumento.addItem(i);
            }
            for(int i=0;i<21;i++){
                interes.addItem(i);
            }
        }
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                updatetable();
            }
            @Override
            public void ancestorRemoved(AncestorEvent event) {
                updatetable();
            }
            @Override
            public void ancestorMoved(AncestorEvent event) {
                updatetable();
            }
        });
        
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

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JLabel getjLabel28() {
        return jLabel28;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }
    
    private void tblEjemploMouseClicked8(java.awt.event.MouseEvent evt) throws Exception {
        if(getjTable1().getSelectedColumn()==4){
            int row = getjTable1().rowAtPoint(evt.getPoint());
            if (row >= 0 && getjTable1().isEnabled())
            {
                presentar1 presentar1 = new presentar1(null,null,true,getjTable1().getValueAt(getjTable1().getSelectedRow(), 4).toString(),getjTable1().getValueAt(getjTable1().getSelectedRow(), 2).toString(),usuario);
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
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        interes = new javax.swing.JComboBox();
        descuento = new javax.swing.JComboBox();
        aumento = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setVisible(false);
        add(jLabel2);
        jLabel2.setBounds(280, 20, 140, 20);

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel7.setText("Proforma de Venta No. ");
        add(jLabel7);
        jLabel7.setBounds(40, 10, 140, 20);

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("$0,00");
        add(jLabel3);
        jLabel3.setBounds(220, 40, 110, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("pendiente");
        add(jLabel4);
        jLabel4.setBounds(220, 10, 110, 20);

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel5.setText("Costo Comercial:");
        add(jLabel5);
        jLabel5.setBounds(40, 40, 170, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel6.setText("Nombre de Cliente:");
        add(jLabel6);
        jLabel6.setBounds(830, 20, 130, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("PROFORMA DE VENTA");
        add(jLabel8);
        jLabel8.setBounds(520, 70, 270, 29);

        jLabel24.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel24.setText("Validez de Oferta (Dias):");
        add(jLabel24);
        jLabel24.setBounds(40, 530, 150, 30);

        jLabel22.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel22.setText("Crédito (Meses):");
        add(jLabel22);
        jLabel22.setBounds(300, 530, 160, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel10.setText("Observaciones:");
        add(jLabel10);
        jLabel10.setBounds(40, 440, 100, 30);

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel12.setText("TOTAL");
        add(jLabel12);
        jLabel12.setBounds(840, 500, 160, 30);

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel13.setText("$0,00");
        add(jLabel13);
        jLabel13.setBounds(1040, 500, 120, 30);

        jLabel15.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel15.setText("SUBTOTAL");
        add(jLabel15);
        jLabel15.setBounds(840, 440, 160, 30);

        jLabel16.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel16.setText("I.V.A 12%");
        add(jLabel16);
        jLabel16.setBounds(840, 470, 160, 30);

        jLabel17.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("$0,00");
        add(jLabel17);
        jLabel17.setBounds(1040, 440, 120, 30);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(980, 20, 170, 20);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        add(jLabel11);
        jLabel11.setBounds(980, 50, 170, 20);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(220, 440, 600, 30);

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("$0,00");
        add(jLabel18);
        jLabel18.setBounds(1040, 470, 120, 30);

        jLabel25.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel25.setText("Garantia (Meses):");
        add(jLabel25);
        jLabel25.setBounds(40, 470, 150, 30);

        jLabel26.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel26.setText("Tiempo de Entrega (Dias):");
        add(jLabel26);
        jLabel26.setBounds(40, 500, 160, 30);

        jLabel27.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel27.setText("Diferido (Meses):");
        add(jLabel27);
        jLabel27.setBounds(300, 500, 160, 30);

        jTextField7.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField7.setText("0");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        add(jTextField7);
        jTextField7.setBounds(460, 530, 110, 30);

        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField6.setText("0");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        add(jTextField6);
        jTextField6.setBounds(460, 470, 110, 30);

        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField5.setText("0");
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        add(jTextField5);
        jTextField5.setBounds(460, 500, 110, 30);

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        add(jTextField4);
        jTextField4.setBounds(220, 530, 70, 30);

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        add(jTextField3);
        jTextField3.setBounds(220, 500, 70, 30);

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        add(jTextField2);
        jTextField2.setBounds(220, 470, 70, 30);

        jLabel29.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel29.setText("Interes:");
        add(jLabel29);
        jLabel29.setBounds(570, 530, 160, 30);

        jLabel30.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel30.setText("Forma Pago (Anticipo):");
        add(jLabel30);
        jLabel30.setBounds(300, 470, 160, 30);

        jLabel31.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel31.setText("Descuento:");
        add(jLabel31);
        jLabel31.setBounds(570, 470, 160, 30);

        jLabel32.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel32.setText("Aumento:");
        add(jLabel32);
        jLabel32.setBounds(570, 500, 160, 30);

        interes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interesActionPerformed(evt);
            }
        });
        add(interes);
        interes.setBounds(730, 530, 90, 30);

        descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descuentoActionPerformed(evt);
            }
        });
        add(descuento);
        descuento.setBounds(730, 470, 90, 30);

        aumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aumentoActionPerformed(evt);
            }
        });
        add(aumento);
        aumento.setBounds(730, 500, 90, 30);

        jLabel9.setOpaque(true);
        add(jLabel9);
        jLabel9.setBounds(30, 440, 1130, 130);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANT.", "DESCRIPCION", "P. UNIT", "PRECIO TOTAL", "VER", "original"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, false
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
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(2).setMinWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(3).setMinWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 1130, 330);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 204));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar-texto.png"))); // NOI18N
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
        add(jLabel21);
        jLabel21.setBounds(30, 590, 90, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setVisible(false);
        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/back.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        add(jLabel19);
        jLabel19.setBounds(1250, 580, 50, 50);

        jLabel14.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel14.setText("Comercial:");
        add(jLabel14);
        jLabel14.setBounds(830, 50, 130, 20);
        add(jLabel20);
        jLabel20.setBounds(380, 20, 0, 0);

        jSeparator1.setOpaque(true);
        add(jSeparator1);
        jSeparator1.setBounds(0, 10, 1000, 1);

        jButton1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton1.setText("Quitar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1230, 380, 73, 70);

        jButton2.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(1230, 110, 70, 70);

        jButton3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton3.setText("Subir");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(1230, 200, 73, 70);

        jButton4.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton4.setText("Bajar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(1230, 290, 73, 70);

        jButton5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton5.setText("Extra");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(1230, 470, 70, 70);

        jLabel23.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Valores en 0");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        jLabel23.setVisible(true);
        add(jLabel23);
        jLabel23.setBounds(220, 590, 160, 20);

        jLabel28.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Valores en Defecto");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });
        jLabel23.setVisible(true);
        add(jLabel28);
        jLabel28.setBounds(410, 590, 160, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked

    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getAumen() {
        return aumen;
    }

    public void setAumen(int aumen) {
        this.aumen = aumen;
    }

    public JComboBox getAumento() {
        return aumento;
    }

    public void setAumento(JComboBox aumento) {
        this.aumento = aumento;
    }

    public JComboBox getDescuento() {
        return descuento;
    }

    public void setDescuento(JComboBox descuento) {
        this.descuento = descuento;
    }

    public JComboBox getInteres() {
        return interes;
    }

    public void setInteres(JComboBox interes) {
        this.interes = interes;
    }

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if((evt.getKeyChar()==KeyEvent.VK_ENTER)){
            if(usuario.getNivel().equalsIgnoreCase("Administrador")){
                int row = jTable1.getSelectedRow();
                int col = jTable1.getSelectedColumn();
                jTable1.setValueAt(jTable1.getValueAt(row, 2), row, 5);
            }
        }
        updatetable();
    }//GEN-LAST:event_jTable1KeyPressed
    public void updatetable(){
        Double cantidad=0.0;
        Double precio=0.0;
        Double total;
        Double total2=0.0;
        Double original=0.0;
        Double iva;
        Double total3;
        try{
        if(jTable1.getRowCount()!=0){
        int row = jTable1.getSelectedRow();
        
            if(getjTable1().getModel().getValueAt(row, 5).toString().equalsIgnoreCase("0")){
                jTable1.setValueAt(jTable1.getValueAt(row, 2), row, 5);
            }else{
            for (int i=0; i<=getjTable1().getModel().getRowCount()-1; i++)
            {
                precio=0.0;
                try{    
                    cantidad=Double.parseDouble(getjTable1().getModel().getValueAt(i, 0).toString());
                
                } catch (Exception ex) {
                    getjTable1().getModel().setValueAt("",i, 0);
                }
                try{    
                    original=Double.parseDouble(getjTable1().getModel().getValueAt(i, 5).toString());
                    if(desc!=0){
                        if(precio==0.0){
                            precio=(original-((desc*original)/100));
                        }else{
                            precio=precio-((desc*precio)/100);
                        }
                    }
                    if(aumen!=0){
                        if(precio==0.0){
                            precio=(original+((aumen*original)/100));
                        }else{
                            precio=precio+((aumen*precio)/100);
                        }
                    }
                    if(inte!=0){
                        if(precio==0.0){
                            precio=(original+((inte*original)/100));
                        }else{
                            precio=precio+((inte*precio)/100);
                        }
                    }
                    if((inte==0)&&(aumen==0)&&(desc==0)){
                    precio=original;
                    }
                    getjTable1().getModel().setValueAt(df.format(precio).replace(",", "."),i, 2);
                } catch (Exception ex) {
                    getjTable1().getModel().setValueAt("",i, 2);
                }
                if(!getjTable1().getModel().getValueAt(i, 2).toString().equalsIgnoreCase("")||!getjTable1().getModel().getValueAt(i, 0).toString().equalsIgnoreCase("")){
                total= cantidad*precio;
                total2= total + total2;
                getjTable1().setValueAt("$"+df.format(total).replace(",", "."), i, 3);
                }
            }
            
        getjLabel17().setText("$"+df.format(total2).replace(",", "."));
        iva=total2*0.12;
        getjLabel18().setText("$"+df.format(iva).replace(",", "."));
        total3= iva + total2;
        getjLabel13().setText("$"+df.format(total3).replace(",", ".")); 
        getjLabel3().setText("$"+df.format(total3).replace(",", ".")); 
            }
        }
        }catch(Exception io){
        }
    }
    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
       
    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        
    }//GEN-LAST:event_jTable1InputMethodTextChanged

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

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel26() {
        return jLabel26;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
        ingresoInventario in = new ingresoInventario(null,null,true,usuario,cliente);
        ArrayList list = in.getLt();
        int x=0;
        for(int i=0; i< (list.size()/8);i++){
            String c1="1";
            String c2="("+in.getLt().get(6+(x*8)).toString()+") "+in.getLt().get(2+(x*8)).toString();
            String c3=in.getLt().get(4+(x*8)).toString().replace("$", "");
            String c4=in.getLt().get(4+(x*8)).toString().replace(",", ".");
            Object c5=in.getLt().get(6+(x*8));
            
            Object nuevo[]= {c1,c2,c3,c4,c5,c3};
            temp.addRow(nuevo);
            x++;
        }                
        updatetable();
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
        model.removeRow(rows);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked

        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
        Object nuevo[]= {"1","(ADIC.) ","0","$0","000000","0"};
        temp.addRow(nuevo);
        tablaeditada();
    }//GEN-LAST:event_jButton5MouseClicked

    public void tablaeditada(){
       int row= jTable1.getRowCount();
    }
    
    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar-texto.png"))); // NOI18N
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar-texto-hover.png"))); // NOI18N
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
           (caracter > '9')) &&
           (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
           evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
           (caracter > '9')) &&
           (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
           evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
           (caracter > '9')) &&
           (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
           evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
           (caracter > '9')) &&
           (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
           evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
           (caracter > '9')) && (caracter != '.') && (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
           evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
           (caracter > '9')) &&
           (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
           evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        if((evt.getKeyChar()=='p') ||(evt.getKeyChar()=='P')){
            int row = jTable1.getSelectedRow();
            int col = jTable1.getSelectedColumn();
            String c1=""+jTable1.getValueAt(row, 0);
            String c2=""+jTable1.getValueAt(row, 1);
            String c3=""+jTable1.getValueAt(row, 2);
            String c4=""+jTable1.getValueAt(row, 3);
            String c5=""+jTable1.getValueAt(row, 4);
            String c6=""+jTable1.getValueAt(row, 5);
            DefaultTableModel temp =  (DefaultTableModel)getjTable1().getModel();
            Object nuevo[]= {c1,c2,c3,c4,c5,c6};
            temp.addRow(nuevo);
            tablaeditada();
        }
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descuentoActionPerformed
        desc= (Integer)descuento.getSelectedItem();
    }//GEN-LAST:event_descuentoActionPerformed

    private void aumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aumentoActionPerformed
        aumen= (Integer)aumento.getSelectedItem();
    }//GEN-LAST:event_aumentoActionPerformed

    private void interesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interesActionPerformed
        inte = (Integer)interes.getSelectedItem();
    }//GEN-LAST:event_interesActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        int row=jTable1.getSelectedRow();
        int col= jTable1.getSelectedColumn();
        int tam= jTable1.getRowCount();
        if(tam>0){
            for(int i=0; i<tam; i++){
                jTable1.setValueAt(0, i, 2);
                jTable1.setValueAt("$"+0, i, 3);
            }
            
        }
        getjLabel17().setText("$"+df.format(0).replace(",", "."));
        getjLabel18().setText("$"+df.format(0).replace(",", "."));
        getjLabel13().setText("$"+df.format(0).replace(",", ".")); 
        getjLabel3().setText("$"+df.format(0).replace(",", ".")); 
        getjTextField5().setText(""+df.format(0).replace(",", ".")); 
        getjTextField6().setText(""+df.format(0).replace(",", ".")); 
        getjTextField7().setText(""+df.format(0).replace(",", ".")); 
        
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        updatetable();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseExited

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

   

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    
    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    
    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
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

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
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

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
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

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
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

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
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

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
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

class ButtonEditor extends DefaultCellEditor {
        protected JTextField button;
        
        private String label;
        
        private boolean isPushed;
        
        public ButtonEditor(JTextField jl) {
            super(jl);
            button = new JTextField();
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
            if(table.getValueAt(row, 1).toString().indexOf("(ADIC.)")!=-1){
                button.setEditable(true);
            }else{
                button.setEditable(false);
            }
            label= ""+value;
            button.setText(label);
            return button;
        }
        
        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }
        
        
        
    }
    
class ButtonEditor2 extends DefaultCellEditor {
        protected JTextField button;
        
        private String label;
        
        private boolean isPushed;
        
        public ButtonEditor2(JTextField jl) {
            super(jl);
            button = new JTextField();
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
            button.setEditable(true);
            
            label= ""+value;
            button.setText(label);
            return button;
        }
        
        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }
        
        
        
    }

    




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox aumento;
    private javax.swing.JComboBox descuento;
    private javax.swing.JComboBox interes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
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
