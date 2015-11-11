/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Articulos;
import Login.Entidad.Clientes;
import Login.Entidad.Factura;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.Entidad.Proveedores;
import Login.Entidad.Retencionfactu;
import java.io.File;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Angelmath
 */
public final class facturaspago extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    Login Usuario;
    String razon;
    String insta;
    String proforma;
    String nombre;
    int id;
    File archivoEntrada=null;
    File archivoEntrada2=null;
    String actual="";
    String prove="";
    List<Clientes> clie = null;
    List<Instalacion> inst = null;
    Factura factura=null;
    Retencionfactu retencion=null;
    Proveedores pv;
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param Razon
     * @param user
     * @param modal
     * @param insta
     * @param prove
     * @param proforma
     * @param fac
     * @param pv
     */
    public facturaspago(java.awt.Frame parent, marco padre, boolean modal, Login user, String Razon, String insta, String proforma, String prove, Factura fac,Proveedores pv) {
        super(parent,modal);
        this.padre=padre;
        this.factura=fac;
        this.Usuario= user;
        this.razon= Razon;
        this.insta= insta;
        this.proforma= proforma;
        this.prove=prove;
        this.pv=pv;
        Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();       
        setLocationRelativeTo(null);
        Date d = new Date();
        actual=Funcion.DateFormat(d);
        actualizarretencion();
        llenarpresupuesto();
        llenarpredictivo();
        jComboBox2.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    jLabel12.setText(jComboBox3.getItemAt(jComboBox2.getSelectedIndex()).toString());  
                    ServiceHb helper2 = new ServiceHb();
                    helper2.iniciarTransaccion();
                    List<Instalacion> in = helper2.getlistaInstalacion2(jLabel12.getText());
                    helper2.cerrarSesion();
                    jComboBox4.removeAllItems();
                    jComboBox5.removeAllItems();
                    if(in!=null){
                        for(Instalacion x: in){
                            jComboBox4.addItem(x.getDetalle());
                            jComboBox5.addItem(x.getId());
                        }
                    }
                }catch(Exception io){}
            }
        });
        
        TableColumn sportColumn = jTable1.getColumnModel().getColumn(2);
        JCheckBox comboBox = new JCheckBox();
        comboBox.setSelected(true);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        sportColumn.setCellRenderer(new CellRenderer("check"));
        if(factura!=null){
            llenar();
        }
        setVisible(true);
    }

    public void llenar(){
        try{
            if(factura.getPagado().equalsIgnoreCase("No Pagado")){
            jDateChooser1.setDate(factura.getFecha2());
            jDateChooser2.setDate(factura.getFecha());
            }else{
            jDateChooser1.setDate(factura.getFecha());
            jDateChooser2.setDate(null);
            }
            jComboBox8.setSelectedItem(factura.getPagado());
            jComboBox1.setSelectedItem(factura.getTipo());
            jTextField9.setText(factura.getSri());
            jTextField1.setText(factura.getIdnombre());
            jTextField3.setText(factura.getSubtotal());
            jTextField2.setText(factura.getSubtotal0());
            jTextField4.setText(factura.getIva());
            jTextField6.setText(factura.getTotal());
            jTextArea1.setText(factura.getObservacion());
            jTextField5.setText(factura.getIdretencion());
            try{    
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Retencionfactu rt = helper.getrentencion(factura.getIdnombre());
                List<Articulos> list = helper.getListaArticulos(factura.getIdnombre());
                DefaultTableModel temp2 = (DefaultTableModel) getjTable1().getModel();
                for(int i=temp2.getRowCount()-1;i>=0;i--){
                   temp2.removeRow(i);
                }
                if(list!=null){   
                    for(int y=0; y<=list.size()-1;y++){
                            Articulos p = list.get(y);
                            String c1=p.getCantidad();
                            String c2=p.getDescripcion();
                            boolean c3=true;
                            String c4=p.getUnitario();
                            String c5=p.getTotal();
                            String c6=p.getIdclienten();
                            String c7=p.getIdcliente();
                            String c8=p.getIdinstalacionn();
                            String c9=p.getIdinstalacion();
                            String c10=p.getIdpresupueston();
                            String c11=p.getIdpresupuesto();
                            if(p.getIva().equalsIgnoreCase("true")){
                                c3=true;
                            }else{
                                c3=false;
                            }
                            DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
                            Object nuevo[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11};
                            temp.addRow(nuevo);
                    }
                }
                helper.cerrarSesion();
            }catch(Exception io){
                JOptionPane.showMessageDialog(null, "Campos con Errores");
            }
        }catch(Exception io){
        
        }
    }
    
    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }
    
    
    public void llenarpresupuesto(){
        jComboBox6.removeAllItems();
        jComboBox7.removeAllItems();
        String cadena="";
        
        for(Instalacion i:inst){
                jComboBox6.addItem(i.getDetalle());
                jComboBox7.addItem(i.getId());
        }
    }
    public void llenarpredictivo(){
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        String cadena="";
        if(jTextField11.getText()!=null){
            cadena= jTextField11.getText();
        }else{
        
        }
        int num=0;
        for(Clientes i:clie){
            if(i.getApellido().toUpperCase().indexOf(cadena.toUpperCase())!=-1){
                jComboBox2.addItem(i.getApellido());
                jComboBox3.addItem(i.getId());
                num++;
            }
            if(num==15){
                break;
            }
        }
    }
    
    public Login getUsuario() {
        return Usuario;
    }

    public void setUsuario(Login Usuario) {
        this.Usuario = Usuario;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getProforma() {
        return proforma;
    }

    public void setProforma(String proforma) {
        this.proforma = proforma;
    }

    public File getArchivoEntrada2() {
        return archivoEntrada2;
    }

    public void setArchivoEntrada2(File archivoEntrada2) {
        this.archivoEntrada2 = archivoEntrada2;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivoEntrada() {
        return archivoEntrada;
    }

    public void setArchivoEntrada(File archivoEntrada) {
        this.archivoEntrada = archivoEntrada;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
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

        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(850, 690));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel11.setText("jLabel8");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel11.setOpaque(true);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-salir.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-aceptar.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel3.setText("Numero:");

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel4.setText("SubTotal 0%");

        jTextField9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField1.setText("001-001");

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setText("000.00");

        jLabel6.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Documento a Pagar");

        jLabel17.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel17.setText("Pagado:");

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel16.setText("Tipo:");

        jTextField11.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel15.setText("AUT. S.R.I.");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Factura", "Liquidacion de Compra", "Nota de Venta" }));

        jButton5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton5.setText("Add");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton6.setText("Up");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton7.setText("Down");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANT.", "DESCRIPCION", "IVA", "P. UNIT", "PRECIO TOTAL", "Cliente", "c", "Categoria", "a", "Presupuesto", "b"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, false, false, false, false, false
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
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(7).setResizable(false);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(8).setMinWidth(0);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(9).setResizable(false);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(10).setMinWidth(0);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(10).setMaxWidth(0);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel5.setText("SubTotal 12%");

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setText("000.00");

        jTextField7.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.setText("000.00");

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setText("000.00");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel7.setText("IVA:");

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel8.setText("Retencion:");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel9.setText("Total a Pagar:");

        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setText("000.00");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel10.setText("Fecha:");

        jComboBox2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel12.setVisible(false);

        jComboBox3.setVisible(false);

        jLabel20.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel20.setText("Relacion:");

        jPanel1.setLayout(null);

        jComboBox4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(140, 0, 260, 30);

        jPanel1.add(jComboBox7);
        jComboBox7.setBounds(400, 30, 40, 30);
        jComboBox7.setVisible(false);

        jButton2.setText("Asignar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(440, 0, 100, 30);

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel18.setText("Presupuesto:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(0, 30, 130, 30);

        jPanel1.add(jComboBox5);
        jComboBox5.setBounds(400, 0, 40, 30);
        jComboBox5.setVisible(false);

        jComboBox6.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jPanel1.add(jComboBox6);
        jComboBox6.setBounds(140, 30, 260, 30);

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel19.setText("Instalacion:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(0, 0, 140, 30);

        jButton8.setText("Asignar");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(440, 30, 100, 30);

        jLabel21.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel21.setText("Observacion:");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pagado", "No Pagado" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel11.setVisible(false);
        jDateChooser2.setVisible(false);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose(); 
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            if(factura!=null){
            
            }else{
                factura= new Factura();
            }
            if(jComboBox8.getSelectedItem().toString().equalsIgnoreCase("Pagado")){
                factura.setFecha(new java.sql.Date(jDateChooser1.getDate().getTime()));
                factura.setFecha2(null);
            }else{
                factura.setFecha(new java.sql.Date(jDateChooser2.getDate().getTime()));
                factura.setFecha2(new java.sql.Date(jDateChooser1.getDate().getTime()));
            }
            factura.setPagado(jComboBox8.getSelectedItem().toString());
            factura.setTipo(jComboBox1.getSelectedItem().toString());
            factura.setSri(jTextField9.getText());
            factura.setIdnombre(jTextField1.getText());
            factura.setSubtotal(jTextField3.getText());
            factura.setSubtotal0(jTextField2.getText());
            factura.setIva(jTextField4.getText());
            factura.setTotal(jTextField6.getText());
            factura.setObservacion(jTextArea1.getText());
            if(retencion!=null){
            factura.setIdretencion(jTextField5.getText());
            }
            factura.setIdproveedor(Integer.toString(pv.getId()));
            try{    
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Articulos> list = helper.getListaArticulos(jTextField1.getText());
                if(list!=null){
                    for(Articulos i: list){
                        helper.eliminarObjeto(i);
                    }
                    for(int y=0; y<=getjTable1().getModel().getRowCount()-1;y++){
                            Articulos p = new Articulos();
                            p.setCantidad(getjTable1().getModel().getValueAt(y, 0).toString());
                            p.setDescripcion(getjTable1().getModel().getValueAt(y, 1).toString());
                            if((Boolean)getjTable1().getModel().getValueAt(y, 2)){
                                p.setIva("true");
                            }else{
                                p.setIva("false");
                            }
                            
                            p.setUnitario(getjTable1().getModel().getValueAt(y, 3).toString());
                            p.setTotal(getjTable1().getModel().getValueAt(y, 4).toString());
                            p.setIdclienten(getjTable1().getModel().getValueAt(y, 5).toString());
                            p.setIdcliente(getjTable1().getModel().getValueAt(y, 6).toString());
                            p.setIdinstalacionn(getjTable1().getModel().getValueAt(y, 7).toString());
                            p.setIdinstalacion(getjTable1().getModel().getValueAt(y, 8).toString());
                            p.setIdfactura(jTextField1.getText());
                            if(getjTable1().getModel().getValueAt(y, 9)!=null){
                                p.setIdpresupueston(getjTable1().getModel().getValueAt(y, 9).toString());
                                p.setIdpresupuesto(getjTable1().getModel().getValueAt(y, 10).toString());
                            }
                            helper.crearObjeto(p);
                    }
                }else{
                    for(int y=0; y<=getjTable1().getModel().getRowCount()-1;y++){
                            Articulos p = new Articulos();
                            p.setCantidad(getjTable1().getModel().getValueAt(y, 0).toString());
                            p.setDescripcion(getjTable1().getModel().getValueAt(y, 1).toString());
                            if((Boolean)getjTable1().getModel().getValueAt(y, 2)){
                                p.setIva("true");
                            }else{
                                p.setIva("false");
                            }
                            p.setUnitario(getjTable1().getModel().getValueAt(y, 3).toString());
                            p.setTotal(getjTable1().getModel().getValueAt(y, 4).toString());
                            p.setIdclienten(getjTable1().getModel().getValueAt(y, 5).toString());
                            p.setIdcliente(getjTable1().getModel().getValueAt(y, 6).toString());
                            p.setIdinstalacionn(getjTable1().getModel().getValueAt(y, 7).toString());
                            p.setIdinstalacion(getjTable1().getModel().getValueAt(y, 8).toString());
                            if(getjTable1().getModel().getValueAt(y, 9)!=null){
                            p.setIdpresupueston(getjTable1().getModel().getValueAt(y, 9).toString());
                            p.setIdpresupuesto(getjTable1().getModel().getValueAt(y, 10).toString());
                            }
                            p.setIdfactura(jTextField1.getText());
                            helper.crearObjeto(p);
                    }
                }
                helper.crearOrActualizarObjeto(factura);
                if(retencion!=null){
                helper.crearOrActualizarObjeto(retencion);
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                JOptionPane.showMessageDialog(null, "Factura Agregada");
                dispose();
            }catch(Exception io){
                
            }
        }catch(Exception io){
            JOptionPane.showMessageDialog(null, "Campos con Errores");
        }
    }//GEN-LAST:event_jButton1MouseClicked
    
    public boolean validacion(){
        
        if(getjTextField1().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "Numero de Factura no Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        if(getjTextField2().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "Valor de la Factura no Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        if(getjTextField4().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "Numero de la Retencion no Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        if(getjTextField9().getText().equalsIgnoreCase("")){
            JOptionPane.showConfirmDialog(null, "AUT. S.R.I. de la Factura no Ingresado", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            return false;
        }
        
    return true;
    }
    
    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

        public void alt (Component bt, String text){
        jLabel11.setVisible(true);
        jLabel11.setText(text);
        jLabel11.setSize((int)jLabel11.getMinimumSize().getWidth(), 25);
        jLabel11.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }  
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
                //alt(jButton1,"Aceptar");
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        //alt(jButton4,"Salir");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jLabel11.setVisible(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged

    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        updatetable();        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        DefaultTableModel model =  (DefaultTableModel)getjTable1().getModel();
        int rows = getjTable1().getSelectedRow();
        model.removeRow(rows);        
    }//GEN-LAST:event_jButton3MouseClicked

     public void updatetable(){
        Double cantidad=0.0;
        Double precio=0.0;
        Double total=0.0;
        Double subtotal=0.0;
        Double total2=0.0;
        Double subtotal2=0.0;
        Double iva;
        Double total3;
        DecimalFormat df = new DecimalFormat("#.##");
        TableModel tabe =getjTable1().getModel();
             for (int i=0; i<=tabe.getRowCount()-1; i++)
            {
                try{    
                cantidad=Double.parseDouble(tabe.getValueAt(i, 0).toString());
                } catch (Exception ex) {
                    tabe.setValueAt("",i, 0);
                }
                try{    
                precio=Double.parseDouble(tabe.getValueAt(i, 3).toString());
                } catch (Exception ex) {
                    tabe.setValueAt("",i, 3);
                }
                if(!tabe.getValueAt(i, 3).toString().equalsIgnoreCase("")||!tabe.getValueAt(i, 0).toString().equalsIgnoreCase("")){
                    if(!(Boolean)tabe.getValueAt(i,2)){
                        total= cantidad*precio;
                        subtotal= subtotal+total;
                        getjTable1().setValueAt(df.format(total).replace(",", "."), i, 4);
                    }else{
                        total2= cantidad*precio;
                        subtotal2= subtotal2+total2;
                        getjTable1().setValueAt(df.format(total2).replace(",", "."), i, 4);
                    }
                }
            }
         
        iva=subtotal2*0.12;
        Double rete=0.0;
        if(retencion!=null){
            rete=Double.parseDouble(retencion.getTotal());
        }
        total3= iva + subtotal2+subtotal-rete;
        getjTextField2().setText(df.format(subtotal).replace(",", "."));
        getjTextField3().setText(df.format(subtotal2).replace(",", "."));
        getjTextField4().setText(df.format(iva).replace(",", "."));
        getjTextField6().setText(df.format(total3).replace(",", "."));
//        getjLabel13().setText("$"+df.format(total3).replace(",", ".")); 
//        getjLabel3().setText("$"+df.format(total3).replace(",", ".")); 

        
    }
    
    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
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

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JTextField getjTextField11() {
        return jTextField11;
    }

    public void setjTextField11(JTextField jTextField11) {
        this.jTextField11 = jTextField11;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
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

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
        Object nuevo[]= {"1","",true,"0","$0","","","",""};
        temp.addRow(nuevo);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        DefaultTableModel model =  (DefaultTableModel)getjTable1().getModel();
        int[] rows = getjTable1().getSelectedRows();
        model.moveRow(rows[0],rows[rows.length-1],rows[0]-1);
        getjTable1().setRowSelectionInterval(rows[0]-1, rows[rows.length-1]-1);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        DefaultTableModel model =  (DefaultTableModel)getjTable1().getModel();
        int[] rows = getjTable1().getSelectedRows();
        model.moveRow(rows[0],rows[rows.length-1],rows[0]+1);
        getjTable1().setRowSelectionInterval(rows[0]+1, rows[rows.length-1]+1);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Double d = Double.parseDouble(jTextField4.getText());
        if(retencion!=null){
            retencion r = new retencion(null, null, true,retencion,this,d);
        }else{
            retencion r = new retencion(null, null, true,null,this,d);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    public List<Clientes> getClie() {
        return clie;
    }

    public void setClie(List<Clientes> clie) {
        this.clie = clie;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Retencionfactu getRetencion() {
        return retencion;
    }

    public void setRetencion(Retencionfactu retencion) {
        this.retencion = retencion;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public JComboBox getjComboBox3() {
        return jComboBox3;
    }

    public void setjComboBox3(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
    }

    public JComboBox getjComboBox4() {
        return jComboBox4;
    }

    public void setjComboBox4(JComboBox jComboBox4) {
        this.jComboBox4 = jComboBox4;
    }

    public JComboBox getjComboBox5() {
        return jComboBox5;
    }

    public void setjComboBox5(JComboBox jComboBox5) {
        this.jComboBox5 = jComboBox5;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public void actualizarretencion(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            clie= helper.getlistaClientes();
            Clientes cl = (Clientes)helper.obtenerObjeto(Clientes.class, 245);
            inst= helper.getlistaInstPresupuesto(cl);
            if(factura!=null){
                if(factura.getIdretencion()!=null){
                    retencion= helper.getrentencion(factura.getIdretencion());
                    jTextField5.setText(retencion.getSri());
                    jTextField7.setText(retencion.getTotal());  
                }
            }else{
                retencion=null;
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained

    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost

    }//GEN-LAST:event_jTextField11FocusLost

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
       
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        llenarpredictivo();
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if((jComboBox2.getItemCount()!=0) && (jComboBox4.getItemCount()!=0)){
            int row = jTable1.getSelectedRow();
            int col = jTable1.getSelectedColumn();
            jTable1.setValueAt(jComboBox2.getSelectedItem().toString(), row, 5);
            jTable1.setValueAt(jComboBox3.getItemAt(jComboBox2.getSelectedIndex()).toString(), row, 6);
            jTable1.setValueAt(jComboBox4.getSelectedItem().toString(), row, 7);
            jTable1.setValueAt(jComboBox5.getItemAt(jComboBox4.getSelectedIndex()).toString(), row, 8);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        if((jComboBox6.getItemCount()!=0)){
            int row = jTable1.getSelectedRow();
            int col = jTable1.getSelectedColumn();
            jTable1.setValueAt(jComboBox6.getSelectedItem().toString(), row, 9);
            jTable1.setValueAt(jComboBox7.getItemAt(jComboBox6.getSelectedIndex()).toString(), row, 10);
        }
    }//GEN-LAST:event_jButton8MouseClicked

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        if(jComboBox8.getSelectedItem().toString().equalsIgnoreCase("Pagado")){
            jDateChooser2.setVisible(false);
        }else{
            jDateChooser2.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed
    
        
    public instalacion getEmpl() {
        return empl;
    }

    public void setEmpl(instalacion empl) {
        this.empl = empl;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProve() {
        return prove;
    }

    public void setProve(String prove) {
        this.prove = prove;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
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
            java.util.logging.Logger.getLogger(facturaspago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturaspago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturaspago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturaspago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
