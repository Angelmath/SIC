/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Ctecobrar;
import Login.Entidad.Indexitem;
import Login.Entidad.Items;
import Login.Entidad.Login;
import Login.servicio.ServiceHb;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import monitoreo.servicio.Funcion;
/**
 *
 * @author homemig
 */
public class bodegapanel extends javax.swing.JPanel {
    String cl;
    Login user;
    List<Indexitem> items=null;
     int xx;
    int yy;
    int sortColumn;
    int[] row;
    DefaultTableModel base;
    /**
     * Creates new form cliente
     */
    public bodegapanel(Login Usuario) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.user= Usuario;
        initComponents();
        setSize(d.width, d.height-95);
        jScrollPane1.setSize(d.width-(jScrollPane1.getX()*2), d.height-300);
        jTable1.setMinimumSize(new Dimension(d.width-(jScrollPane1.getX()*2)-20, d.height-300));
        jButton1.setLocation(jScrollPane1.getWidth()+jScrollPane1.getX()-jButton1.getWidth(), jButton1.getY());
        try {
            ServiceHb neo = new ServiceHb();
            neo.iniciarTransaccion();
            List<Indexitem> list = neo.getListaIndexitem();
            neo.confirmarTransaccion();
            neo.cerrarTransaccion();
            neo.cerrarSesion();
            items=list;
            jComboBox1.removeAllItems();
            jComboBox1.addItem("ALL");
            for(Indexitem i: list){
                jComboBox1.addItem(i.getTipo());
            }
        } catch (Exception ex) {
        
        }
        vistatabla();
        llenar();
        
        setVisible(true);
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
                repaint();
            }
        });
    }
    protected int compare(int i, int j) {
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        return s1.compareTo(s2);
    }
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
    
    public void vistatabla(){
        tablasmodelos(jTable1,null);
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jTable1.getColumn("Editar").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTable1.getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(11).setCellRenderer( new CellRenderer("imagen2") );
        jTable1.getColumnModel().getColumn(12).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(13).setCellRenderer( new CellRenderer("text center") );
    }
    public void llenar(){
        JTable tabla = jTable1;
        List<Items> list=null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list= helper.getlistaItems(jComboBox1.getSelectedItem().toString(),jTextField1.getText());
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
        reiniciarJTable(tabla);
        DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            temp2.removeRow(i);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if(list!=null){
            for(Items i: list){
                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                int v1 = i.getId();
                String v2 = i.getCodigo();
                String v3 = i.getCat();
                String v4 = i.getMarca();
                String v5 = i.getModelo();
                String v6 = i.getProveedor();
                String v7 = i.getDc();
                String v8 = i.getDl();
                String v9 = i.getCosto();
                String v10="";
                if(i.getOtro1()==null){
                    if(!i.getCosto().equalsIgnoreCase("")){
                    v10 = "$"+df.format(valorpvp(i)).replace(",", ".");
                    }
                }else{
                    v10=i.getOtro1();
                }
                String v11 = i.getFt();
                Object nuevo2[]= {v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,user.getDireccion()+"\\ficha_items\\"+v1,v1,v1};
                temp.addRow(nuevo2);
            }
        }
    }
    public static void reiniciarJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);

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
                    if(it.getCosto().contains("738")){
                        System.out.println("738");
                    }
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

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
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
        String error="";
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date inicio = new java.sql.Date(getPrimerDiaDelMes().getTime());
            java.sql.Date fin = new java.sql.Date(getUltimoDiaDelMes().getTime());
            DecimalFormat df = new DecimalFormat("0.00");
            List<Ctecobrar> list = helper.getlistaCtecobrar(inicio,fin);
            Calendar ca = Calendar.getInstance();
            int mes = ca.get(Calendar.MONTH);
            int maxdia = ca.getMaximum(Calendar.DAY_OF_MONTH);
            JTable tabla = new JTable();
            tabla= jTable1;
            helper.cerrarSesion();
            
            DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            int tempo=0;
            int vacio=0;
            int i=1;
            
            if(list!=null){
                while(maxdia!=i){
                    //for(int i=0; i< maxdia;i++)
                    tempo=0;
                    for(int y=0;y<list.size();y++){
                        Calendar cqa = Calendar.getInstance();
                        cqa.setTime(list.get(y).getFecha());
                        int day= cqa.get(Calendar.DAY_OF_MONTH);
                        if(day==i){
                            tempo=1;
                            if(i< maxdia){
                                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                                float val = Float.parseFloat(list.get(y).getMontos());
                                Object nuevo[]= {(i)+"/"+(mes+1),list.get(y).getCliente(),list.get(y).getProyecto(),list.get(y).getPlanpagos(),list.get(y).getObservacion(),"$"+df.format(val).replace(",", ".")};
                                temp.addRow(nuevo);
                            }
                        }
                        
                    }
                    if(tempo==0){
                        if(i< maxdia){
                            DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                            Object nuevo[]= {(i)+"/"+(mes+1),"","","","",""};
                            temp.addRow(nuevo);
                        }
                    }else{

                    }
                    i++;
                }
            }
            
        }catch(Exception io){
            
        }
    }
    
    
    public void carga2(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date inicio = new java.sql.Date(getPrimerDiaDelMes3().getTime());
            java.sql.Date fin = new java.sql.Date(getUltimoDiaDelMes3().getTime());
            DecimalFormat df = new DecimalFormat("0.00");
            List<Ctecobrar> list = helper.getlistaCtecobrar(inicio,fin);
            Calendar ca = Calendar.getInstance();
            int mes = ca.get(Calendar.MONTH);
            int maxdia = ca.getMaximum(Calendar.DAY_OF_MONTH);
            JTable tabla = new JTable();
            tabla= jTable1;
            helper.cerrarSesion();
            
            DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            int tempo=0;
            int vacio=0;
            int i=1;
            
            if(list!=null){
                    //for(int i=0; i< maxdia;i++)
                    tempo=0;
                    for(int y=0;y<list.size();y++){
                        Calendar cqa = Calendar.getInstance();
                        cqa.setTime(list.get(y).getFecha());
                        int day= cqa.get(Calendar.DAY_OF_MONTH);
                        mes = cqa.get(Calendar.MONTH);
                            tempo=1;
                            if(i< maxdia){
                                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                                float val = Float.parseFloat(list.get(y).getMontos());
                                Object nuevo[]= {(day)+"/"+(mes+1),list.get(y).getCliente(),list.get(y).getProyecto(),list.get(y).getPlanpagos(),list.get(y).getObservacion(),"$"+df.format(val).replace(",", ".")};
                                temp.addRow(nuevo);
                            }
                        
                    }
            }
            
        }catch(Exception io){
            
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Codigo", "CAT.", "Marca", "Modelo", "Proveedor", "DC", "DL", "Costo", "PVP", "FT", "Imagen", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(80);
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
            jTable1.getColumnModel().getColumn(2).setMinWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(11).setMinWidth(80);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(11).setMaxWidth(80);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(60, 122, 990, 380);

        jButton1.setText("Agregar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(850, 40, 200, 40);

        jLabel22.setFont(new java.awt.Font("Roboto Medium", 3, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ITEMS");
        add(jLabel22);
        jLabel22.setBounds(60, 50, 90, 30);

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox1MouseReleased(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(220, 50, 190, 30);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modelo / Codigo ");
        add(jLabel1);
        jLabel1.setBounds(440, 50, 150, 30);

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(610, 50, 170, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        bodegamateriales mat = new bodegamateriales(null,null,true,0,user);
        llenar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==11){
            File f = new File(user.getDireccion()+jTable1.getValueAt(row, col).toString());
            if(f.exists()){
                Principal p = new Principal(user.getDireccion()+jTable1.getValueAt(row, col).toString());
                p.next();
            }
        }
        if(col==12){
            int item= Integer.parseInt(jTable1.getValueAt(row, col).toString());
            bodegamateriales mat = new bodegamateriales(null,null,true,item,user);
            llenar();
        }
        if(col==13){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                int item= Integer.parseInt(jTable1.getValueAt(row, col).toString());
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    helper.eliminarObjeto(((Items)helper.obtenerObjeto(Items.class, item)));
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                }catch(Exception io){
                }
                llenar();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        llenar();        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseReleased
        
    }//GEN-LAST:event_jComboBox1MouseReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        llenar();
    }//GEN-LAST:event_jTextField1KeyTyped
            
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
