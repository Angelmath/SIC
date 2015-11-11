/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Estatico;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.Entidad.Productos;
import Login.Entidad.Proyectos;
import Login.servicio.ServiceHb;
import static Login.ventas.marco.reiniciarJTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angelmath
 */
public final class pylcrearproforma extends javax.swing.JDialog {
    marco padre;
    Instalacion in;    
    String selecionado="1";
    Login usuario;
    int desc=0;
    int inte=0;
    int aumen=0;
    List<Proyectos> list2;
    String instalacion;
    String cliente;
    String numero;
    String prof;
    DecimalFormat df = new DecimalFormat("#.##");
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param modal
     * @param in
     * @param nombrecliente
     * @param nombreinsta
     * @param us
     * @param numero
     */
    public pylcrearproforma(java.awt.Frame parent, marco padre, boolean modal, Instalacion in, String nombrecliente, String nombreinsta, Login us, String numero) {
        super(parent, modal);
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.padre=padre;
        this.usuario=us;
        this.in=in;
        this.instalacion=nombreinsta;
        this.cliente=nombrecliente;
        setSize(d.width, d.height-95);
        jPanel1.setSize(d.width, d.height-95);
        jSeparator1.setSize(d.width, 1);
        setEventoMouseClicked8(jTable1);
        JTextField tf = new JTextField();
        tf.setSize(200, 28);
        jTable1.getColumn("VER").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("P. UNIT").setCellEditor(new ButtonEditor2(tf));
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
        setLocationRelativeTo(null);    
        String responsable="";
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Instalacion inst = (Instalacion)helper.obtenerObjeto(Instalacion.class, in.getId());
            responsable= inst.getClientes().getLogin().getNombre();
            helper.cerrarSesion();
        }catch(Exception io){
        }
        jLabel1.setText(cliente);
        jLabel11.setText(responsable);
        if(!numero.equalsIgnoreCase("")){
            reiniciarJTable(getjTable1());
            List<Proyectos> list;
            List<Productos> ltproductos;
            Proyectos proyecto;
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                list= helper.getlistaProyectos1(""+in.getId());
                prof= numero;
                proyecto= helper.getlistaProyectos2(""+in.getId(),numero);
                ltproductos= helper.getlistaProductos(Integer.toString(proyecto.getId()));
                if(ltproductos!=null){
                    for (Productos ltproducto : ltproductos) {
                        String c1 = ltproducto.getCantidad();
                        String c2 = ltproducto.getDescripcion();
                        String c3 = ltproducto.getUnitario();
                        String c4 = ltproducto.getTotal();
                        String c6 = ltproducto.getOriginal();
                        String c5;
                        if (ltproducto.getSerial() != null) {
                            c5 = ltproducto.getSerial();
                        } else {
                            c5="000000";
                        }
                        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
                        Object nuevo[]= {c1,c2,c3,c4,c5,c6};
                        temp.addRow(nuevo);
                    }
                }
                getjLabel4().setText(proyecto.getSubproyecto()); // numero proforma
                getjTextField1().setText(proyecto.getObservacion1()); //Observaciones
                getjTextField2().setText(proyecto.getGmeses()); //subtotal
                getjTextField3().setText(proyecto.getGtiempo()); //iva
                getjTextField4().setText(proyecto.getGvalidez()); //total
                getjLabel17().setText(proyecto.getSubtotal()); //subtotal
                getjLabel18().setText(proyecto.getIva()); //iva
                getjLabel13().setText(proyecto.getTotal()); //total
                getjLabel3().setText(proyecto.getTotal()); //total 2
                getInteres().setSelectedItem(Integer.parseInt(proyecto.getInteres()));
                getAumento().setSelectedItem(Integer.parseInt(proyecto.getAumento()));
                getDescuento().setSelectedItem(Integer.parseInt(proyecto.getDescuento()));
            }catch(Exception io){}
        }
        setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        interes = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        descuento = new javax.swing.JComboBox();
        jTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        aumento = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(500, 325));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setVisible(false);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("$0,00");
        jLabel17.setVisible(false);
        jPanel2.add(jLabel17);
        jLabel17.setBounds(1010, 0, 120, 30);

        interes.setEnabled(false);
        interes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interesActionPerformed(evt);
            }
        });
        jPanel2.add(interes);
        interes.setBounds(700, 90, 90, 30);

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField3.setText("0");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(190, 60, 70, 30);

        jLabel16.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel16.setText("I.V.A 12%");
        jLabel16.setVisible(false);
        jPanel2.add(jLabel16);
        jLabel16.setBounds(810, 30, 160, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel10.setText("Observaciones:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 0, 100, 30);

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("$0,00");
        jLabel18.setVisible(false);
        jPanel2.add(jLabel18);
        jLabel18.setBounds(1010, 30, 120, 30);

        descuento.setEnabled(false);
        descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descuentoActionPerformed(evt);
            }
        });
        jPanel2.add(descuento);
        descuento.setBounds(700, 30, 90, 30);

        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField5.setText("0");
        jTextField5.setEnabled(false);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField5);
        jTextField5.setBounds(430, 60, 110, 30);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(190, 0, 600, 30);

        jLabel25.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel25.setText("Garantia (Meses):");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(10, 30, 150, 30);

        jLabel30.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel30.setText("Forma Pago (Anticipo):");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(270, 30, 160, 30);

        jLabel29.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel29.setText("Interes:");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(540, 90, 160, 30);

        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField6.setText("0");
        jTextField6.setEnabled(false);
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
        jPanel2.add(jTextField6);
        jTextField6.setBounds(430, 30, 110, 30);

        jLabel22.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel22.setText("Crédito (Meses):");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(270, 90, 160, 30);

        jLabel26.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel26.setText("Tiempo de Entrega (Dias):");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(10, 60, 160, 30);

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel13.setText("$0,00");
        jLabel13.setVisible(false);
        jPanel2.add(jLabel13);
        jLabel13.setBounds(1010, 60, 120, 30);

        aumento.setEnabled(false);
        aumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aumentoActionPerformed(evt);
            }
        });
        jPanel2.add(aumento);
        aumento.setBounds(700, 60, 90, 30);

        jTextField7.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField7.setText("0");
        jTextField7.setEnabled(false);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField7);
        jTextField7.setBounds(430, 90, 110, 30);

        jLabel27.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel27.setText("Diferido (Meses):");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(270, 60, 160, 30);

        jLabel15.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel15.setText("SUBTOTAL");
        jLabel15.setVisible(false);
        jPanel2.add(jLabel15);
        jLabel15.setBounds(810, 0, 160, 30);

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField2.setText("0");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(190, 30, 70, 30);

        jLabel31.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel31.setText("Descuento:");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(540, 30, 160, 30);

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel12.setText("TOTAL");
        jLabel12.setVisible(false);
        jPanel2.add(jLabel12);
        jLabel12.setBounds(810, 60, 160, 30);

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField4.setText("0");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField4);
        jTextField4.setBounds(190, 90, 70, 30);

        jLabel32.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel32.setText("Aumento:");
        jPanel2.add(jLabel32);
        jLabel32.setBounds(540, 60, 160, 30);

        jLabel24.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel24.setText("Validez de Oferta (Dias):");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(10, 90, 150, 30);

        jLabel9.setOpaque(true);
        jPanel2.add(jLabel9);
        jLabel9.setBounds(0, 0, 1130, 130);

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel7.setText("Proforma de Venta No. ");
        jLabel7.setVisible(false);

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("$0,00");
        jLabel3.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("pendiente");
        jLabel4.setVisible(false);

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel5.setText("Costo Comercial:");
        jLabel5.setVisible(false);

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel6.setText("Nombre de Cliente:");
        jLabel6.setVisible(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Soporte");

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel1.setVisible(false);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel11.setVisible(false);

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

        jLabel14.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        jLabel14.setText("Comercial:");
        jLabel14.setVisible(false);

        jSeparator1.setOpaque(true);

        jButton1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton1.setText("Quitar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton3.setText("Subir");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton4.setText("Bajar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton5.setText("Extra");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(410, 410, 410)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel20))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(500, 500, 500)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jLabel8)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1330, 640);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) && (caracter != '.') && (caracter != '\b' /*corresponde a BACK_SPACE*/))
    {
        evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jTextField6KeyTyped

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

    private void interesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interesActionPerformed
        inte = (Integer)interes.getSelectedItem();
    }//GEN-LAST:event_interesActionPerformed

    private void descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descuentoActionPerformed
        desc= (Integer)descuento.getSelectedItem();
    }//GEN-LAST:event_descuentoActionPerformed

    private void aumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aumentoActionPerformed
        aumen= (Integer)aumento.getSelectedItem();
    }//GEN-LAST:event_aumentoActionPerformed

    
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
        String numero2=ultimo.substring(0, ultimo.length());
        int cant=numero2.length();
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
    
    
    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged

    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if((evt.getKeyChar()==KeyEvent.VK_ENTER)){
            int row = jTable1.getSelectedRow();
            int col = jTable1.getSelectedColumn();
            jTable1.setValueAt(jTable1.getValueAt(row, 2), row, 5);
        }
        updatetable();
        encerar();
    }//GEN-LAST:event_jTable1KeyPressed

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
        }
    }//GEN-LAST:event_jTable1KeyTyped

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        if(getjTextField2().getText().equalsIgnoreCase("")||getjTextField3().getText().equalsIgnoreCase("")||getjTextField4().getText().equalsIgnoreCase("")||getjTable1().getRowCount()==0){
            if(getjTextField2().getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null, "Garantia no Agregada");
            if(getjTextField3().getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null, "Tiempo de Entrega no Agregada");
            if(getjTextField4().getText().equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null, "Validez de Oferta no Agregada");
            if(getjTable1().getRowCount()==0)
                JOptionPane.showMessageDialog(null, "No hay Datos Ingresados en la Tabla");
        }else{
            List<Productos> list=null;
            ArrayList<Productos> product= new ArrayList<>();
            List<Proyectos> list21;
            Login ln;
            
            Proyectos proyecto =null;
            try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            
            if(prof!=null){
                proyecto=helper.getlistaProyectos2(""+in.getId(), prof);
            }
            if(proyecto!=null){
                list=helper.getlistaProductos(Integer.toString(proyecto.getId()));
                Estatico est=null;
                if(proyecto.getNumero().contains("Pendiente")){
                    est = (Estatico) helper.obtenerObjeto(Estatico.class, 1);
                    proyecto.setSubproyecto(est.getProforma());
                    proyecto.setNumero(est.getProforma());

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
                }
                proyecto.setContacto(getjLabel1().getText());
                proyecto.setInstalacion(""+in.getId());
                proyecto.setIva(getjLabel18().getText());
                proyecto.setObservacion1(getjTextField1().getText());
                proyecto.setGmeses(getjTextField2().getText());
                proyecto.setGtiempo(getjTextField3().getText());
                proyecto.setGvalidez(getjTextField4().getText());
                proyecto.setAnticipo(getjTextField6().getText());
                proyecto.setCredito(getjTextField7().getText());
                proyecto.setDiferido(getjTextField5().getText());
                proyecto.setInventario("");
                proyecto.setRazon(getjLabel11().getText());
                proyecto.setGrupo(selecionado);
                proyecto.setSubtotal(getjLabel17().getText());
                proyecto.setTotal(getjLabel13().getText());
                proyecto.setInteres(getInteres().getSelectedItem().toString());
                proyecto.setAumento(getAumento().getSelectedItem().toString());
                proyecto.setDescuento(getDescuento().getSelectedItem().toString());
                helper.actualizarObjeto(proyecto);
                if(est!=null){
                    helper.actualizarObjeto(est);
                }
            }else{
                proyecto= new Proyectos();
                proyecto.setContacto(getjLabel1().getText());
                proyecto.setInstalacion(""+in.getId());
                proyecto.setIva(getjLabel18().getText());
                
                Estatico est = (Estatico) helper.obtenerObjeto(Estatico.class, 1);
                proyecto.setSubproyecto(est.getProforma());
                proyecto.setNumero(est.getProforma());

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
                
                proyecto.setObservacion1(getjTextField1().getText());
                proyecto.setGmeses(getjTextField2().getText());
                proyecto.setGtiempo(getjTextField3().getText());
                proyecto.setGvalidez(getjTextField4().getText());
                proyecto.setAnticipo(getjTextField6().getText());
                proyecto.setCredito(getjTextField7().getText());
                proyecto.setDiferido(getjTextField5().getText());
                proyecto.setInventario("");
                proyecto.setGrupo(selecionado);
                proyecto.setRazon(getjLabel11().getText());
                proyecto.setSubtotal(getjLabel17().getText());
                proyecto.setTotal(getjLabel13().getText());
                proyecto.setInteres(getInteres().getSelectedItem().toString());
                proyecto.setAumento(getAumento().getSelectedItem().toString());
                proyecto.setDescuento(getDescuento().getSelectedItem().toString());
                helper.crearObjeto(proyecto);
                helper.actualizarObjeto(est);
            }
            
            if(list!=null){
                for(Productos i: list){
                    helper.eliminarObjeto(i);
                }
                for(int y=0; y<=getjTable1().getModel().getRowCount()-1;y++){
                    Productos p = new Productos();
                    p.setCantidad(getjTable1().getModel().getValueAt(y, 0).toString());
                    p.setDescripcion(getjTable1().getModel().getValueAt(y, 1).toString());
                    p.setUnitario(getjTable1().getModel().getValueAt(y, 2).toString());
                    p.setTotal(getjTable1().getModel().getValueAt(y, 3).toString());
                    p.setSerial(getjTable1().getModel().getValueAt(y, 4).toString());
                    p.setOriginal(getjTable1().getModel().getValueAt(y, 5).toString());
                    p.setProyecto(Integer.toString(proyecto.getId()));
                    helper.crearObjeto(p);
                    product.add(p);
                }
            }else{
                for(int y=0; y<=getjTable1().getModel().getRowCount()-1;y++){
                    Productos p = new Productos();
                    p.setCantidad(getjTable1().getModel().getValueAt(y, 0).toString());
                    p.setDescripcion(getjTable1().getModel().getValueAt(y, 1).toString());
                    p.setUnitario(getjTable1().getModel().getValueAt(y, 2).toString());
                    p.setTotal(getjTable1().getModel().getValueAt(y, 3).toString());
                    p.setSerial(getjTable1().getModel().getValueAt(y, 4).toString());
                    p.setOriginal(getjTable1().getModel().getValueAt(y, 5).toString());
                    p.setProyecto(Integer.toString(proyecto.getId()));
                    helper.crearObjeto(p);
                    product.add(p);
                }
            }
            list21= helper.getlistaProyectos1(""+in.getId());
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            }catch(Exception io){
                System.out.println(io);
            }

            pdf(proyecto,product);
        }
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    public void pdf(Proyectos py, ArrayList<Productos> lista){
        //String imagepath = Server.MapPath("Images");
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        
        Clientes c2=null;
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Instalacion inst = helper.getInstalacion(py.getInstalacion());
            c2 = inst.getClientes();
            
            int cell=22;
            
            ficheroPdf = new FileOutputStream(usuario.getDireccion()+"/"+py.getNumero()+".pdf");
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(15);
            
            
            documento.open();
            //aqui agregamos todo el contenido del PDF...
            Image image1 = Image.getInstance(usuario.getDireccion()+"/logo.png");
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
            Phrase parrafo2a = new Phrase(jLabel11.getText(),new Font(Font.HELVETICA, 6, Font.NORMAL, new Color(0, 0, 0)));
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
    
    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar-texto-hover.png"))); // NOI18N
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar-texto.png"))); // NOI18N
    }//GEN-LAST:event_jLabel21MouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        DefaultTableModel model =  (DefaultTableModel)getjTable1().getModel();
        int rows = getjTable1().getSelectedRow();
        model.removeRow(rows);

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
        ingresoInventario invent = new ingresoInventario(null,null,true,usuario,"");
        ArrayList list = invent.getLt();
        int x=0;
        for(int i=0; i< (list.size()/8);i++){
            String c1="1";
            String c2="("+invent.getLt().get(6+(x*8)).toString()+") "+invent.getLt().get(2+(x*8)).toString();
            String c3=invent.getLt().get(4+(x*8)).toString().replace("$", "");
            String c4=invent.getLt().get(4+(x*8)).toString().replace(",", ".");
            Object c5=invent.getLt().get(6+(x*8));
            
            Object nuevo[]= {c1,c2,c3,c4,c5,c3};
            temp.addRow(nuevo);
            x++;
        }
        updatetable();
        encerar();
    }//GEN-LAST:event_jButton2MouseClicked
    
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
        if(getjTable1().getSelectedColumn()==4){
            int row = getjTable1().rowAtPoint(evt.getPoint());
            if (row >= 0 && getjTable1().isEnabled())
            {
                presentar1 presentar1 = new presentar1(null,null,true,getjTable1().getValueAt(getjTable1().getSelectedRow(), 4).toString(),getjTable1().getValueAt(getjTable1().getSelectedRow(), 2).toString(),usuario);
            }
        }
    }
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

    public List<Proyectos> getList2() {
        return list2;
    }

    public void setList2(List<Proyectos> list2) {
        this.list2 = list2;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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


    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
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

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
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

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
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

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked

        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
        Object nuevo[]= {"1","(ADIC.) ","0","$0","000000","0"};
        temp.addRow(nuevo);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    public void encerar(){
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

    }
    
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        encerar();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    public Instalacion getIn() {
        return in;
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

    
    public void setIn(Instalacion in) {
        this.in = in;
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
            java.util.logging.Logger.getLogger(pylcrearproforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                pylcrearproforma dialog = new pylcrearproforma(new javax.swing.JFrame(),null, true,null,"","",null,"");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
