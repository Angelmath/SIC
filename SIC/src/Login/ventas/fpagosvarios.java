/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Ctepagar;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
import static Login.ventas.marco.reiniciarJTable;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 *
 * @author homemig
 */
public class fpagosvarios extends javax.swing.JPanel {
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
    List cellDataList = null;
    /**
     * Creates new form cliente
     */
    public fpagosvarios() {
        Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Date d = new Date();
        actual=Funcion.DateFormat(d);
        actualizardatos();
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
        jScrollPane1.setSize(di.width-100-jPanel2.getWidth(), di.height-jScrollPane1.getY()-150);
        jPanel2.setLocation(jScrollPane1.getWidth()+jScrollPane1.getX(), jPanel2.getY());
        jPanel3.setLocation((di.width/2)-(jPanel3.getWidth()/2), jPanel3.getY());
        jPanel1.setLocation((di.width/2)-(jPanel1.getWidth()/2), jPanel1.getY());
        setSize(di.width, di.height-95);
        setVisible(false);
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
    
    public JLabel getjLabel1() {
        return jLabel1;
    }
    
    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    
    public JLabel getjLabel2() {
        return jLabel2;
    }
    
    public void actualizardatos(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            clie= helper.getlistaClientes();
            Clientes cl = (Clientes)helper.obtenerObjeto(Clientes.class, 245);
            inst= helper.getlistaInstPresupuesto(cl);
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
    }
    
    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }
    
    public static Date getPrimerDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static Date getPrimerDiaDelMes3() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes3() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +3);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public void carga1(){
    }
    
    
    public void carga2(){
        
    }
    
    
    public String getCl() {
        return cl;
    }
    
    public void setCl(String cl) {
        this.cl = cl;
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setText("Pagos Varios");
        add(jLabel2);
        jLabel2.setBounds(30, 40, 230, 30);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel1.setText("Modulo Financiero - Contable");
        add(jLabel1);
        jLabel1.setBounds(30, 10, 330, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Detalle", "Fecha", "Valor", "Cliente", "c", "Categoria", "a", "Estado", "Guardar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, false, false, false, false, false
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 240, 880, 360);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(210, 10, 210, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-buscar.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(420, 10, 30, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Detalle", "Fecha", "Cliente", "Instalacion" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(20, 10, 170, 30);

        add(jPanel1);
        jPanel1.setBounds(310, 180, 470, 50);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jButton9.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton9.setText("Mano de Obra");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(20, 0, 110, 40);

        jButton5.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton5.setText("Extra");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(20, 50, 110, 40);

        jButton6.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton6.setText("Up");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(20, 100, 110, 40);

        jButton7.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton7.setText("Down");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(20, 150, 110, 40);

        jButton3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(20, 200, 110, 40);

        add(jPanel2);
        jPanel2.setBounds(920, 240, 140, 240);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);
        jPanel3.add(jDateChooser1);
        jDateChooser1.setBounds(130, 10, 150, 30);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel10.setText("Fecha:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(10, 10, 90, 30);

        jLabel20.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel20.setText("Relacion:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(10, 40, 80, 30);

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
        jPanel3.add(jTextField11);
        jTextField11.setBounds(130, 40, 150, 30);

        jComboBox3.setVisible(false);
        jPanel3.add(jComboBox3);
        jComboBox3.setBounds(100, 40, 28, 30);

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
        jPanel3.add(jComboBox2);
        jComboBox2.setBounds(280, 40, 250, 30);

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel19.setText("Instalacion:");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(730, 10, 120, 30);

        jComboBox4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jPanel3.add(jComboBox4);
        jComboBox4.setBounds(690, 40, 230, 30);

        jLabel12.setVisible(false);
        jPanel3.add(jLabel12);
        jLabel12.setBounds(530, 40, 30, 30);

        jPanel3.add(jComboBox5);
        jComboBox5.setBounds(920, 40, 40, 30);
        jComboBox5.setVisible(false);

        jButton8.setText("Asignar");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(960, 40, 80, 30);

        jButton1.setText("Importar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(960, 10, 80, 30);

        jLabel21.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel21.setText("Instalacion:");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(570, 40, 120, 30);

        add(jPanel3);
        jPanel3.setBounds(40, 80, 1040, 80);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        
    }//GEN-LAST:event_jTextField11FocusGained
    
    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
        
    }//GEN-LAST:event_jTextField11FocusLost
    
    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        llenarpredictivo();
    }//GEN-LAST:event_jTextField11KeyReleased
    
    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped
    
    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        
    }//GEN-LAST:event_jComboBox2ItemStateChanged
    
    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        
    }//GEN-LAST:event_jComboBox2MouseClicked
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
    }//GEN-LAST:event_jComboBox2ActionPerformed
    
    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        if((jComboBox2.getItemCount()!=0) && (jComboBox4.getItemCount()!=0)){
            int row = jTable1.getSelectedRow();
            int col = jTable1.getSelectedColumn();
            jTable1.setValueAt(Funcion.DateFormatSql(jDateChooser1.getDate()), row, 2);
            jTable1.setValueAt(jComboBox2.getSelectedItem().toString(), row, 4);
            jTable1.setValueAt(jComboBox3.getItemAt(jComboBox2.getSelectedIndex()).toString(), row, 5);
            jTable1.setValueAt(jComboBox4.getSelectedItem().toString(), row, 6);
            jTable1.setValueAt(jComboBox5.getItemAt(jComboBox4.getSelectedIndex()).toString(), row, 7);
        }
    }//GEN-LAST:event_jButton8MouseClicked
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col=  jTable1.getSelectedColumn();
        try{
            if(col==9){
                Ctepagar cpa=null;
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                String ci= jTable1.getValueAt(row, 0).toString();
                String c1= jTable1.getValueAt(row, 1).toString();
                String c2= jTable1.getValueAt(row, 2).toString();
                String c3= jTable1.getValueAt(row, 3).toString();
                String c4= jTable1.getValueAt(row, 4).toString();
                String c5= jTable1.getValueAt(row, 5).toString();
                String c6= jTable1.getValueAt(row, 6).toString();
                String c7= jTable1.getValueAt(row, 7).toString();
                String c8= jTable1.getValueAt(row, 8).toString();
                String c9= jTable1.getValueAt(row, 9).toString();
                if(!ci.isEmpty()){
                    cpa= (Ctepagar)helper.obtenerObjeto(Ctepagar.class, Integer.parseInt(ci));
                    cpa.setDetalle(c1);
                    cpa.setFecha(c2);
                    cpa.setValor(c3);
                    cpa.setCliente(c4);
                    cpa.setIdcliente(c5);
                    cpa.setInstalacion(c6);
                    cpa.setIdinstalacion(c7);
                    cpa.setTotal("Aprobado");
                    helper.crearOrActualizarObjeto(cpa);
                    JOptionPane.showMessageDialog(null, "Descripcion Editada");
                }else{
                    cpa = new Ctepagar();
                    cpa.setDetalle(c1);
                    cpa.setFecha(c2);
                    cpa.setValor(c3);
                    cpa.setCliente(c4);
                    cpa.setIdcliente(c5);
                    cpa.setInstalacion(c6);
                    cpa.setIdinstalacion(c7);
                    cpa.setTotal("Aprobado");
                    helper.crearOrActualizarObjeto(cpa);
                    JOptionPane.showMessageDialog(null, "Descripcion Agregada");
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
            }
        }catch(Exception io){
            
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        
    }//GEN-LAST:event_jTable1InputMethodTextChanged
    
    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        
    }//GEN-LAST:event_jTable1PropertyChange
    
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
    }//GEN-LAST:event_jTable1KeyPressed
    
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
        Object nuevo[]= {"","","","","","","","","",""};
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
    
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            for(int i=0; i<jTable1.getRowCount();i++){
                if(jTable1.isCellSelected(i, 0)){
                    Ctepagar ct = (Ctepagar)helper.obtenerObjeto(Ctepagar.class, Integer.parseInt(jTable1.getValueAt(i, 0).toString()));
                    helper.eliminarObjeto(ct);
                }
            }
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            llenar();
        }catch(Exception io){
            
        }
    }//GEN-LAST:event_jButton3MouseClicked
    public void llenar(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Ctepagar> list = helper.getlistaCtePagarvarios(jTextField1.getText(),jComboBox1.getSelectedIndex());
            helper.cerrarSesion();
            reiniciarJTable(jTable1);
            if(list!=null){
                
                DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                for(Ctepagar i: list){
                    String c= ""+i.getId();
                    String c1= i.getDetalle();
                    String c2= i.getFecha();
                    String c3= i.getValor();
                    String c4= i.getCliente();
                    String c5= i.getIdcliente();
                    String c6= i.getInstalacion();
                    String c7= i.getIdinstalacion();
                    String c8= i.getTotal();
                    String c9= ""+i.getId();
                    Object nuevo[]= {c,c1,c2,c3,c4,c5,c6,c7,c8,c9};
                    temp.addRow(nuevo);
                }
            }
        }catch(Exception io){
            
        }
    }
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        llenar();
    }//GEN-LAST:event_jTextField1KeyTyped
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        Fvinculoslaboral f1 = new Fvinculoslaboral(padre, true);
        if(!f1.getV1().isEmpty()){
            DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
            Object nuevo[]= {"",f1.getV2(),"",f1.getV1(),"","","","","Pendiente",""};
            temp.addRow(nuevo);
        }
    }//GEN-LAST:event_jButton9MouseClicked
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            try{
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                //Mostrar la ventana para abrir archivo y recoger la respuesta
                //En el parámetro del showOpenDialog se indica la ventana
                //  al que estará asociado. Con el valor this se asocia a la
                //  ventana que la abre.
                int respuesta = chooser.showOpenDialog(this);
                String cadena="";
                DecimalFormat df = new DecimalFormat("0.00");
                if (respuesta == JFileChooser.APPROVE_OPTION)
                {
                    cadena = chooser.getSelectedFile().getAbsolutePath();
                    readExcelFile(cadena);
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();

                    if((jComboBox2.getItemCount()!=0) && (jComboBox4.getItemCount()!=0)){
                        int row = jTable1.getSelectedRow();
                        int col = jTable1.getSelectedColumn();
                        String c1 = jComboBox2.getSelectedItem().toString();
                        String c2 = jComboBox3.getItemAt(jComboBox2.getSelectedIndex()).toString();
                        String c3 = jComboBox4.getSelectedItem().toString();
                        String c4 = jComboBox5.getItemAt(jComboBox4.getSelectedIndex()).toString();
                        for (Object cellDataList1 : cellDataList) {
                            List cellTempList = (List) cellDataList1;
                            Ctepagar cpa = new Ctepagar();
                            cpa.setDetalle(((HSSFCell)cellTempList.get(0)).getStringCellValue());
                            cpa.setFecha(Funcion.DateFormatSql(((HSSFCell)cellTempList.get(1)).getDateCellValue()));
                            cpa.setValor(df.format(((HSSFCell)cellTempList.get(2)).getNumericCellValue()).replace(",", "."));
                            cpa.setCliente(c1);
                            cpa.setIdcliente(c2);
                            cpa.setInstalacion(c3);
                            cpa.setIdinstalacion(c4);
                            cpa.setTotal("Aprobado");
                            helper.crearObjeto(cpa);
                        }
                        helper.confirmarTransaccion();
                    }
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null, "Terminado!!");
                }
            }catch(Exception io){
                JOptionPane.showMessageDialog(null, "Error en formato de Excel revisar Plantilla!!");
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked
        
    public marco getPadre() {
        return padre;
    }
    
    public void setPadre(marco padre) {
        this.padre = padre;
    }
    
    public instalacion getEmpl() {
        return empl;
    }
    
    public void setEmpl(instalacion empl) {
        this.empl = empl;
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
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public File getArchivoEntrada() {
        return archivoEntrada;
    }
    
    public void setArchivoEntrada(File archivoEntrada) {
        this.archivoEntrada = archivoEntrada;
    }
    
    public File getArchivoEntrada2() {
        return archivoEntrada2;
    }
    
    public void setArchivoEntrada2(File archivoEntrada2) {
        this.archivoEntrada2 = archivoEntrada2;
    }
    
    public String getActual() {
        return actual;
    }
    
    public void setActual(String actual) {
        this.actual = actual;
    }
    
    public String getProve() {
        return prove;
    }
    
    public void setProve(String prove) {
        this.prove = prove;
    }
    
    public List<Clientes> getClie() {
        return clie;
    }
    
    public void setClie(List<Clientes> clie) {
        this.clie = clie;
    }
    
    public List<Instalacion> getInst() {
        return inst;
    }
    
    public void setInst(List<Instalacion> inst) {
        this.inst = inst;
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
    
    public JComboBox getjComboBox1() {
        return jComboBox1;
    }
    
    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
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
    
    public JLabel getjLabel12() {
        return jLabel12;
    }
    
    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }
    
    public JLabel getjLabel19() {
        return jLabel19;
    }
    
    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }
    
    public JLabel getjLabel20() {
        return jLabel20;
    }
    
    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }
    
    public JLabel getjLabel5() {
        return jLabel5;
    }
    
    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }
    
    public JPanel getjPanel1() {
        return jPanel1;
    }
    
    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
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
    
    public JTextField getjTextField1() {
        return jTextField1;
    }
    
    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    
    private void readExcelFile(String fileName)
    {
        /**
         * Create a new instance for cellDataList
         */
        cellDataList = new ArrayList();
        try
        {
            /**
             * Create a new instance for FileInputStream class
             */
            FileInputStream fileInputStream = new FileInputStream(fileName);
            /**
             * Create a new instance for POIFSFileSystem class
             */
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            /*
            * Create a new instance for HSSFWorkBook Class
            */
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            HSSFSheet hssfSheet = workBook.getSheetAt(0);
            /**
             * Iterate the rows and cells of the spreadsheet
             * to get all the datas.
             */
            Iterator rowIterator = hssfSheet.rowIterator();
            rowIterator.next();
            while (rowIterator.hasNext())
            {
                HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                List cellTempList = new ArrayList();
                while (iterator.hasNext())
                {
                    HSSFCell hssfCell = (HSSFCell) iterator.next();
                    cellTempList.add(hssfCell);
                }
                cellDataList.add(cellTempList);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    /**
     * This method is used to print the cell data to the console.
     * @param cellDataList - List of the data's in the spreadsheet.
     */
    private void printToConsole(List cellDataList)
    {
        for (Object cellDataList1 : cellDataList) {
            List cellTempList = (List) cellDataList1;
            for (Object cellTempList1 : cellTempList) {
                HSSFCell hssfCell = (HSSFCell) cellTempList1;
                String stringCellValue = hssfCell.toString();
                System.out.print(stringCellValue + "\t");
            }
            System.out.println();
        }
    }
    
    public JTextField getjTextField11() {
        return jTextField11;
    }
    
    public void setjTextField11(JTextField jTextField11) {
        this.jTextField11 = jTextField11;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    // End of variables declaration//GEN-END:variables
}
