/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Indexitem;
import Login.Entidad.Items;
import Login.Entidad.Login;
import Login.servicio.ServiceHb;
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
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Angelmath
 */
public final class ingresoInventario extends javax.swing.JDialog {
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
    List<Indexitem> items;
    List<Items> it;
    /**
     * Creates new form ingresoU
     * @param parent
     * @param padre
     * @param modal
     * @param us
     * @param cliente
     */
    public ingresoInventario(java.awt.Frame parent, marco padre, boolean modal,Login us, String cliente) {
        super(parent,modal);
        this.padre=padre;
        this.Usuario= us;
        initComponents();  
        setSize(1300,670);
        setLocationRelativeTo(null);
        getjTable2().getColumn("GO").setCellRenderer(new ButtonRenderer());
        getjLabel1().setSize(1300, 670);
        JTableHeader jtableHeader = getjTable2().getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        getjTable2().setTableHeader(  jtableHeader );
        getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("imagen3") );
        getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("parrafo") );
        
        try {
            ServiceHb neo = new ServiceHb();
            neo.iniciarTransaccion();
            List<Indexitem> list = neo.getListaIndexitem();
            neo.confirmarTransaccion();
            neo.cerrarTransaccion();
            neo.cerrarSesion();
            items=list;
            jComboBox3.removeAllItems();
            if(us.getDepartamento().equalsIgnoreCase("Dpt. PyL")){
                for(Indexitem i: list){
                    if(i.getTipo().contains("Instalacion")){
                        jComboBox3.addItem(i.getTipo());
                    }
                }
                getjTable2().getColumnModel().getColumn(4).setMaxWidth(0);
                getjTable2().getColumnModel().getColumn(4).setMinWidth(0);
                getjTable2().getColumnModel().getColumn(4).setPreferredWidth(0);
            }else if(us.getDepartamento().equalsIgnoreCase("Dpt. Compras")){
                for(Indexitem i: list){
                    if(i.getTipo().contains("Cables")||i.getTipo().contains("Computo")||i.getTipo().contains("Ducteria")||i.getTipo().contains("Equipos Electricos")||i.getTipo().contains("Estanteria")||i.getTipo().contains("Monitores")||i.getTipo().contains("CCTV: Varios")){
                        jComboBox3.addItem(i.getTipo());
                    }
                }
                getjTable2().getColumnModel().getColumn(4).setMaxWidth(0);
                getjTable2().getColumnModel().getColumn(4).setMinWidth(0);
                getjTable2().getColumnModel().getColumn(4).setPreferredWidth(0);
            }else{
                jComboBox3.addItem("ALL");
                for(Indexitem i: list){
                    jComboBox3.addItem(i.getTipo());
                }
            }
            if(!us.getNivel().equalsIgnoreCase("administrador")){
                if(cliente.contains("Poligrafos") ||cliente.contains("Guardianía")){
                    jComboBox3.removeAllItems();
                    for(Indexitem i: list){
                        if(i.getTipo().contains("Servicios")){
                            jComboBox3.addItem(i.getTipo());
                        }
                    }
                }
                if(cliente.contains("Soporte Técnico")){
                    jComboBox3.removeAllItems();
                    for(Indexitem i: list){
                        if(i.getTipo().contains("Cables")||i.getTipo().contains("Computo")||i.getTipo().contains("Ducteria")||i.getTipo().contains("Equipos Electricos")||i.getTipo().contains("Estanteria")||i.getTipo().contains("Monitores")||i.getTipo().contains("CCTV: Varios")){
                            jComboBox3.addItem(i.getTipo());
                        }
                    }
                }
            }
            
            
        } catch (Exception ex) {
        
        }
        setEventoMouseClicked8(getjTable2());
        TableColumn sportColumn = jTable1.getColumnModel().getColumn(8);
        JCheckBox comboBox = new JCheckBox();
        comboBox.setSelected(true);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        sportColumn.setCellRenderer(new CellRenderer("check"));
        setVisible(true);
    }
    
    
    public void llenar(){
        JTable tabla = jTable1;
        List<Items> list=null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(campo.getText().isEmpty()){
            list= helper.getlistaItems(jComboBox3.getSelectedItem().toString());
            }else{
            list= helper.getlistaItems2(jComboBox3.getSelectedItem().toString(), campo.getText());
            }
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
        it=list;
        DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            temp2.removeRow(i);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if(list!=null){
            for(Items i: list){
                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                int v1 = i.getId();
                String v2 = i.getCat();
                String v3 = i.getDl();
                String v4 = Usuario.getDireccion()+"\\ficha_items\\"+i.getId();
                String v5 = "";
                String v6 = i.getModelo();
                String v7 = i.getCodigo();
                String v8 = i.getMarca();
                if(i.getOtro1()==null){
                    if(!i.getCosto().equalsIgnoreCase("")){
                    v5 = "$"+df.format(valorpvp(i)).replace(",", ".");
                    }
                }else{
                    v5=i.getOtro1();
                }
                Object nuevo2[]= {v1,v2,v3,v4,v5,v8,v6,v7,false};
                temp.addRow(nuevo2);
            }
        }
    }
    
    
    public void llenar2(){
        JTable tabla = jTable1;
        List<Items> list=it;
        
        DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            temp2.removeRow(i);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if(list!=null){
            for(Items i: list){
                if(i.getDc().toUpperCase().contains(campo.getText().toUpperCase())){
                int v1 = i.getId();
                String v2 = i.getCat();
                String v3 = i.getDl();
                String v4 = i.getCodigo();
                String v5 = "";
                String v6 = i.getModelo();
                String v7 = i.getCodigo();
                if(i.getOtro1()==null){
                    if(!i.getCosto().equalsIgnoreCase("")){
                    v5 = "$"+df.format(valorpvp(i)).replace(",", ".");
                    }
                }else{
                    v5=i.getOtro1();
                }
                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                Object nuevo2[]= {v1,v2,v3,v4,v5,v6,v7,false};
                temp.addRow(nuevo2);
                }
            }
        }
    }
    
    
    public Double valorpvp(Items it){
        for(Indexitem i: items){
            if(i.getTipo().equalsIgnoreCase(it.getCat())){
                if(i.getCategoria()!=null){
                if(i.getCategoria().equalsIgnoreCase("Margen")){
                    
                    Double val = Double.parseDouble(it.getCosto())*(1+Double.parseDouble(i.getTipoa()));
                    return val;
                }
                if(i.getCategoria().equalsIgnoreCase("Formula")){
                    Double cost = Double.parseDouble(it.getCosto());
                    Double ca = Double.parseDouble(i.getTipoa());
                    Double cb = Double.parseDouble(i.getTipob());
                    Double cc = Double.parseDouble(i.getTipoc());
                    Double cd = Double.parseDouble(i.getTipod());
                    Double ce = Double.parseDouble(i.getTipoe());
                    Double cf = Double.parseDouble(i.getTipof());
                    Double cg = Double.parseDouble(i.getTipog());
                    Double inf1=0.0; 
                    Double inf2=0.0; 
                    Double sup1=0.0; 
                    Double sup2=0.0; 
                    if(i.getInf1()!=null){
                    inf1 = Double.parseDouble(i.getInf1());
                    }
                    if(i.getInf2()!=null){
                    inf2 = Double.parseDouble(i.getInf2());
                    }
                    if(i.getSup1()!=null){
                    sup1 = Double.parseDouble(i.getSup1());
                    }
                    if(i.getSup2()!=null){
                    sup2 = Double.parseDouble(i.getSup2());
                    }
                    if(cost<inf1){
                        Double val = cost*(1+inf2);
                        return val;
                    }else if(cost>sup1){
                        Double val = cost*(1+sup2);
                        return val;
                    }else{
                        Double parteA=ca*(Math.pow(cost, cb));
                        Double parteB=cc*(Math.pow(cost,cd));
                        Double parteC=ce*Math.pow(cost, cf);
                        Double parteD=cg;
                        Double val = (parteA)+(parteB)+(parteC)+parteD;
                        return val;
                    }
                }
                if(i.getCategoria().equalsIgnoreCase("Valor Fijo")){
                    Double val = Double.parseDouble(it.getCosto());
                    return val;
                }
                }
                break;
            }
            
        }
        return 0.0;
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
            for(int i=0;i<getjTable2().getRowCount();i++){
                int row = i;
                if ((Boolean)getjTable2().getValueAt(row,8) && getjTable2().isEnabled())
                {
                    lt.add(getjTable2().getValueAt(i, 0));
                    lt.add(getjTable2().getValueAt(i, 1));
                    lt.add(getjTable2().getValueAt(i, 2));
                    lt.add(getjTable2().getValueAt(i, 3));
                    lt.add(getjTable2().getValueAt(i, 4));
                    lt.add(getjTable2().getValueAt(i, 6));
                    lt.add(getjTable2().getValueAt(i, 7));
                    lt.add(getjTable2().getValueAt(i, 8));
                }
            }
            dispose();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        campo = new javax.swing.JTextField();
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
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(520, 50, 200, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GO", "CATEGORIA", "DESCRIPCION", "IMAGEN", "PRECIO", "MARCA", "MODELO", "INTERNO", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
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
        jTable1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jTable1AncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(2).setMinWidth(360);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(8).setMinWidth(50);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 1270, 460);

        campo.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        campo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoKeyTyped(evt);
            }
        });
        getContentPane().add(campo);
        campo.setBounds(460, 90, 320, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 80, 50);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseDragged
        evt.consume();
    	JComponent c = (JComponent) evt.getSource();
        TransferHandler handler = c.getTransferHandler();
        handler.exportAsDrag(c, evt, TransferHandler.MOVE);
    }//GEN-LAST:event_jTable1MouseDragged

    private void jTable1AncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTable1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorMoved

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==8){
            Boolean b = (Boolean)jTable1.getValueAt(row, col);
            jTable1.setValueAt(!b, row, col);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        llenar();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void campoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoKeyReleased
        
    }//GEN-LAST:event_campoKeyReleased

    private void campoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoKeyTyped
        llenar2();
    }//GEN-LAST:event_campoKeyTyped

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
                ingresoInventario ingresoInventario = new ingresoInventario(null, null, true,null,"");
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campo;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
