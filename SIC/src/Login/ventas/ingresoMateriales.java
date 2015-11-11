/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Login;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 *
 * @author Angelmath
 */
public final class ingresoMateriales extends javax.swing.JDialog {
    marco padre;
    instalacion empl;
    String cl;
    Login Usuario;
    String razon;
    String insta;
    String cliente;
    String nombre;
    ArrayList lt= new ArrayList();
    File archivoEntrada=null;
    /**
     * Creates new form ingresoU
     */
    public ingresoMateriales(java.awt.Frame parent, marco padre, boolean modal,Login us) {
        super(parent,modal);
        this.padre=padre;
        this.Usuario= us;
        initComponents();  
        setSize(1300,600);
        setLocationRelativeTo(null);
        getjComboBox1().addItemListener(new ItemChangeListener());
        getjTable2().getColumn("GO").setCellRenderer(new ButtonRenderer());
        getjLabel1().setSize(1300, 600);
        JTableHeader jtableHeader = getjTable2().getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        getjTable2().setTableHeader(  jtableHeader );
        getjTable2().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("imagen") );
        getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("parrafo") );
        setEventoMouseClicked8(getjTable2());
        setVisible(true);
         
        
        
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
        if(getjTable2().getSelectedColumn()==0){
            int row = getjTable2().rowAtPoint(evt.getPoint());
            if (row >= 0 && getjTable2().isEnabled())
            {
                lt.add(getjTable2().getValueAt(getjTable2().getSelectedRow(), 0));
                lt.add(getjTable2().getValueAt(getjTable2().getSelectedRow(), 1));
                lt.add(getjTable2().getValueAt(getjTable2().getSelectedRow(), 2));
                lt.add(getjTable2().getValueAt(getjTable2().getSelectedRow(), 3));
                lt.add(getjTable2().getValueAt(getjTable2().getSelectedRow(), 4));
                lt.add(getjTable2().getValueAt(getjTable2().getSelectedRow(), 5));
                dispose();
            }
            //JOptionPane.showMessageDialog(null, "Usuario Editado");
        }
        
    }
    
    class ItemChangeListener implements ItemListener{
    @Override
    public void itemStateChanged(ItemEvent event) {
       
    }
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    
    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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


    public marco getPadre() {
        return padre;
    }

    public void setPadre(marco padre) {
        this.padre = padre;
    }

    public ArrayList getLt() {
        return lt;
    }

    public void setLt(ArrayList lt) {
        this.lt = lt;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        jLabel25.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Inventario");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(510, 20, 220, 30);

        jComboBox3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(590, 60, 200, 30);

        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(790, 60, 30, 30);

        jComboBox1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "NETWORK CAMERAS", "NETWORK NVRs", "ANALOG CAMERAS", "DVR STORAGE", "ACCESSORIES", "VARIOUS" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(360, 60, 150, 30);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField6);
        jTextField6.setBounds(240, 10, 200, 30);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/icono-buscar.png"))); // NOI18N
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.add(jLabel27);
        jLabel27.setBounds(440, 10, 30, 30);

        jComboBox2.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DESCRIPCION", "CODIGO", "CATEGORIA" }));
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(10, 10, 100, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(350, 100, 490, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GO", "Tipo", "CATEGORIA", "DESCRIPCION", "IMAGEN", "CODIGO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(75);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTable1MouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(40);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(3).setMinWidth(360);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(150);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 180, 1270, 330);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 80, 50);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String fileName = Usuario.getDireccion()+"/Inventario.xls";
        ExcelSheetReader n = new ExcelSheetReader();
        n.readExcelFile(fileName,0);
        DefaultTableModel temp4 = (DefaultTableModel) getjTable2().getModel();
        for(int i=temp4.getRowCount()-1;i>=0;i--){
            temp4.removeRow(i);
        }
        getjComboBox1().getSelectedItem().toString();
        getjComboBox2().getSelectedItem().toString();
        int base=0;
        
        if(getjComboBox1().getSelectedItem().toString().equalsIgnoreCase("ALL")){
            
            int cant=0;
            String tipo="";
            for (int j = base; j < n.getCellDataList().size(); j++)
            {
                List cellTempList = (List) n.getCellDataList().get(j);

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                if(hssfCell.getStringCellValue().equalsIgnoreCase("N/A")||hssfCell.getStringCellValue().equalsIgnoreCase("Codigo")||hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK NVRs")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ANALOG CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("DVR STORAGE")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ACCESSORIES")||hssfCell.getStringCellValue().equalsIgnoreCase("VARIOUS")){   
                    if(hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK NVRs")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ANALOG CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("DVR STORAGE")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ACCESSORIES")||hssfCell.getStringCellValue().equalsIgnoreCase("VARIOUS")){
                        tipo=hssfCell.getStringCellValue();
                    }
                }
                else if(hssfCell.getStringCellValue().equalsIgnoreCase("")){
                    break;
                }else{

                    DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String item =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripcion=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");
                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripcion, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+item, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                }
            }
            
        }else{
        
        if(getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("ALL")){
            String tipo="";
            for (int i = 0; i < n.getCellDataList().size(); i++)
            {
                List cellTempList = (List) n.getCellDataList().get(i);

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                if(hssfCell.getStringCellValue().equalsIgnoreCase(getjComboBox1().getSelectedItem().toString())){
                    base=i+2;
                    tipo=getjComboBox1().getSelectedItem().toString();
                }
            }
            List nuevo = new ArrayList();
            int cant=0;
            for (int j = base; j < n.getCellDataList().size(); j++)
            {
                List cellTempList = (List) n.getCellDataList().get(j);

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                if(hssfCell.getStringCellValue().equalsIgnoreCase("N/A")){
                    break;
                }else{

                    DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String item =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripcion=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripcion, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+item, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                }
            }
            }else{
                String tipo="";
                for (int i = 0; i < n.getCellDataList().size(); i++)
                    {
                        List cellTempList = (List) n.getCellDataList().get(i);

                        HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                        if(hssfCell.getStringCellValue().equalsIgnoreCase(getjComboBox1().getSelectedItem().toString())){
                            base=i+2;
                            tipo= getjComboBox1().getSelectedItem().toString();
                        }
                    }
                    List nuevo = new ArrayList();
                    int cant=0;
                    for (int j = base; j < n.getCellDataList().size(); j++)
                    {
                        
                        List cellTempList = (List) n.getCellDataList().get(j);

                        HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);
                        
                        if(hssfCell.getStringCellValue().equalsIgnoreCase("N/A")){
                            break;
                        }else{
                            if(((HSSFCell) cellTempList.get(1)).getStringCellValue().equalsIgnoreCase(getjComboBox3().getSelectedItem().toString())){
                                    DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String item =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripcion=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripcion, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+item, cant, 4);                    
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                            }
                        }
                    }
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange

    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
          Object item = evt.getItem();
          String fileName = Usuario.getDireccion()+"/Inventario.xls";
          ExcelSheetReader n = new ExcelSheetReader();
          n.readExcelFile(fileName,1);
          if(item.toString().equalsIgnoreCase("ALL")){
                getjComboBox3().removeAllItems();
              
          }
          if(item.toString().equalsIgnoreCase("NETWORK CAMERAS")){
              getjComboBox3().removeAllItems();
              getjComboBox3().addItem("ALL");
              for (int i = 1; i < n.getCellDataList().size(); i++)
                {
                List cellTempList = (List) n.getCellDataList().get(i);
                
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);
                if(!hssfCell.getStringCellValue().equalsIgnoreCase("N/R")){
                getjComboBox3().addItem(hssfCell.getStringCellValue());
                }
            }
          }    
          if(item.toString().equalsIgnoreCase("NETWORK NVRs")){
                getjComboBox3().removeAllItems();
                getjComboBox3().addItem("ALL");
                for (int i = 1; i < n.getCellDataList().size(); i++)
                {
                List cellTempList = (List) n.getCellDataList().get(i);
                
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(1);

                if(!hssfCell.getStringCellValue().equalsIgnoreCase("N/R")){
                getjComboBox3().addItem(hssfCell.getStringCellValue());
                }
            }
          }
          if(item.toString().equalsIgnoreCase("ANALOG CAMERAS")){
                getjComboBox3().removeAllItems();
                getjComboBox3().addItem("ALL");
                for (int i = 1; i < n.getCellDataList().size(); i++)
                {
                List cellTempList = (List) n.getCellDataList().get(i);
                
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(2);

                if(!hssfCell.getStringCellValue().equalsIgnoreCase("N/R")){
                getjComboBox3().addItem(hssfCell.getStringCellValue());
                }
            }
          }
          if(item.toString().equalsIgnoreCase("DVR STORAGE")){
                getjComboBox3().removeAllItems();
                getjComboBox3().addItem("ALL");
                for (int i = 1; i < n.getCellDataList().size(); i++)
                {
                List cellTempList = (List) n.getCellDataList().get(i);
                
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(3);

                if(!hssfCell.getStringCellValue().equalsIgnoreCase("N/R")){
                getjComboBox3().addItem(hssfCell.getStringCellValue());
                }
            }
          }
          if(item.toString().equalsIgnoreCase("ACCESSORIES")){
                getjComboBox3().removeAllItems();
                getjComboBox3().addItem("ALL");
                for (int i = 1; i < n.getCellDataList().size(); i++)
                {
                List cellTempList = (List) n.getCellDataList().get(i);
                
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(4);

                if(!hssfCell.getStringCellValue().equalsIgnoreCase("N/R")){
                getjComboBox3().addItem(hssfCell.getStringCellValue());
                }
            }
          }
          if(item.toString().equalsIgnoreCase("VARIOUS")){
                getjComboBox3().removeAllItems();
                getjComboBox3().addItem("ALL");
              for (int i = 1; i < n.getCellDataList().size(); i++)
                {
                List cellTempList = (List) n.getCellDataList().get(i);
                
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(5);
                if(!hssfCell.getStringCellValue().equalsIgnoreCase("N/R")){
                getjComboBox3().addItem(hssfCell.getStringCellValue());
                }
            }
          }
          
    }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        String fileName = Usuario.getDireccion()+"/Inventario.xls";
        ExcelSheetReader n = new ExcelSheetReader();
        n.readExcelFile(fileName,0);
        DefaultTableModel temp4 = (DefaultTableModel) getjTable2().getModel();
        for(int i=temp4.getRowCount()-1;i>=0;i--){
            temp4.removeRow(i);
        }
        
        int base=0;
        
        if(getjComboBox1().getSelectedItem().toString().equalsIgnoreCase("ALL")){
            
            int cant=0;
            String tipo="";
            for (int j = base; j < n.getCellDataList().size(); j++)
            {
                List cellTempList = (List) n.getCellDataList().get(j);

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                if(hssfCell.getStringCellValue().equalsIgnoreCase("N/A")||hssfCell.getStringCellValue().equalsIgnoreCase("Codigo")||hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK NVRs")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ANALOG CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("DVR STORAGE")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ACCESSORIES")||hssfCell.getStringCellValue().equalsIgnoreCase("VARIOUS")){   
                    if(hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("NETWORK NVRs")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ANALOG CAMERAS")||hssfCell.getStringCellValue().equalsIgnoreCase("DVR STORAGE")
                        ||hssfCell.getStringCellValue().equalsIgnoreCase("ACCESSORIES")||hssfCell.getStringCellValue().equalsIgnoreCase("VARIOUS")){
                        tipo=hssfCell.getStringCellValue();
                    }
                }else if(hssfCell.getStringCellValue().equalsIgnoreCase("")){
                    break;
                }else{
                    String codigox=((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoriax=((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String descripcion="";
                    try{
                        descripcion=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    }catch(Exception io){
                        System.out.println(hssfCell);
                    }
                    
                    if(getjComboBox2().getSelectedItem().toString().equalsIgnoreCase("CODIGO")){
                        if(codigox.indexOf(getjTextField6().getText())!=-1){
                            DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    
                            Object nuevo1[]= {temp.getRowCount()+1,"",""};
                            temp.addRow(nuevo1);
                            String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                            String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                            String itema =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                            String descripciona=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                            String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();

                            double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                            DecimalFormat df = new DecimalFormat("#.##");

                            getjTable2().getModel().setValueAt(codigo, cant, 0);
                            getjTable2().getModel().setValueAt(tipo, cant, 1);
                            getjTable2().getModel().setValueAt(categoria, cant, 2);
                            getjTable2().getModel().setValueAt(descripciona, cant, 3);
                            getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+itema, cant, 4);
                            getjTable2().getModel().setValueAt(codigo, cant, 5);
                            cant++;
                        }
                    }
                    if(getjComboBox2().getSelectedItem().toString().equalsIgnoreCase("CATEGORIA")){
                        if(categoriax.indexOf(getjTextField6().getText())!=-1){
                            DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String itema =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripciona=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripciona, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+itema, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                        }
                    }
                    if(getjComboBox2().getSelectedItem().toString().equalsIgnoreCase("DESCRIPCION")){
                        if(descripcion.indexOf(getjTextField6().getText())!=-1){
                            DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String itema =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripciona=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripciona, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+itema, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                        }
                    }
                    
                }
            }
            
        }else{
        
        if(getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("ALL")){
            String tipo="";
            for (int i = 0; i < n.getCellDataList().size(); i++)
            {
                List cellTempList = (List) n.getCellDataList().get(i);

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                if(((HSSFCell) cellTempList.get(1)).getStringCellValue().equalsIgnoreCase(getjComboBox1().getSelectedItem().toString())){
                    base=i+2;
                    tipo=getjComboBox1().getSelectedItem().toString();
                }
            }
            List nuevo = new ArrayList();
            int cant=0;
            for (int j = base; j < n.getCellDataList().size(); j++)
            {
                List cellTempList = (List) n.getCellDataList().get(j);

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                if(hssfCell.getStringCellValue().equalsIgnoreCase("N/A")){
                    break;
                }else{
                    String item=((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String item2=((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    double item3=((HSSFCell) cellTempList.get(2)).getNumericCellValue();
                    String descripcion="";
                    try{
                        descripcion=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    }catch(Exception io){
                        System.out.println(hssfCell);
                    }
                    if(getjComboBox2().getSelectedItem().toString().equalsIgnoreCase("ITEM")){
                        if(item.indexOf(getjTextField6().getText())!=-1){
                            DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String itema =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripciona=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripciona, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+itema, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                        }
                    }
                    if(getjComboBox2().getSelectedItem().toString().equalsIgnoreCase("CODIGO")){
                        if(item2.indexOf(getjTextField6().getText())!=-1){
                            DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String itema =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripciona=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripciona, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+itema, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                        }
                    }
                    if(getjComboBox2().getSelectedItem().toString().equalsIgnoreCase("DESCRIPCION")){
                        if(descripcion.indexOf(getjTextField6().getText())!=-1){
                            DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String itema =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripciona=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripciona, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+itema, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                        }
                    }
                }
            }
            }else{
                String tipo="";
                for (int i = 0; i < n.getCellDataList().size(); i++)
                    {
                        List cellTempList = (List) n.getCellDataList().get(i);

                        HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);

                        if(hssfCell.getStringCellValue().equalsIgnoreCase(getjComboBox1().getSelectedItem().toString())){
                            base=i+2;
                            tipo=getjComboBox1().getSelectedItem().toString();
                        }
                    }
                    List nuevo = new ArrayList();
                    int cant=0;
                    for (int j = base; j < n.getCellDataList().size(); j++)
                    {
                        
                        List cellTempList = (List) n.getCellDataList().get(j);

                        HSSFCell hssfCell = (HSSFCell) cellTempList.get(0);
                        
                        if(hssfCell.getStringCellValue().equalsIgnoreCase("N/A")){
                            break;
                        }else{
                            if(hssfCell.getStringCellValue().equalsIgnoreCase(getjComboBox3().getSelectedItem().toString())){
                                    DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
                    Object nuevo1[]= {temp.getRowCount()+1,"",""};
                    temp.addRow(nuevo1);
                    String codigo =((HSSFCell) cellTempList.get(0)).getStringCellValue();
                    String categoria =((HSSFCell) cellTempList.get(1)).getStringCellValue();
                    String item =((HSSFCell) cellTempList.get(2)).getStringCellValue();
                    String descripcion=((HSSFCell) cellTempList.get(4)).getStringCellValue();
                    String memo =((HSSFCell) cellTempList.get(5)).getStringCellValue();
                    
                    double precio=((HSSFCell) cellTempList.get(6)).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("#.##");

                    getjTable2().getModel().setValueAt(codigo, cant, 0);
                    getjTable2().getModel().setValueAt(tipo, cant, 1);
                    getjTable2().getModel().setValueAt(categoria, cant, 2);
                    getjTable2().getModel().setValueAt(descripcion, cant, 3);
                    getjTable2().getModel().setValueAt(Usuario.getDireccion()+"/IMAGENES/"+item, cant, 4);
                    getjTable2().getModel().setValueAt(codigo, cant, 5);
                    cant++;
                            }
                        }
                    }
            }
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTable1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseDragged
        evt.consume();
    	JComponent c = (JComponent) evt.getSource();
        TransferHandler handler = c.getTransferHandler();
        handler.exportAsDrag(c, evt, TransferHandler.MOVE);
    }//GEN-LAST:event_jTable1MouseDragged

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
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

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane1;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane1 = jScrollPane2;
    }

    public JTable getjTable2() {
        return jTable1;
    }

    public void setjTable2(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ingresoMateriales ingresoInventario = new ingresoMateriales(null, null, true,null);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
