/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Ctecobrar;
import Login.Entidad.Factura;
import Login.Entidad.Indexcontable;
import Login.Entidad.Proveedores;
import Login.servicio.ServiceHb;
import static Login.ventas.fccobrar.getPrimerDiaDelMes;
import static Login.ventas.fccobrar.getPrimerDiaDelMes3;
import static Login.ventas.fccobrar.getUltimoDiaDelMes;
import static Login.ventas.fccobrar.getUltimoDiaDelMes3;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import monitoreo.servicio.Funcion;
import javax.swing.table.*;
/**
 *
 * @author homemig
 */
public class fbalance extends javax.swing.JPanel {
    String cl;
    int actual=0;
    /**
     * Creates new form cliente
     */
    public fbalance() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        actual=rightNow.get(Calendar.DAY_OF_MONTH);
        jLabel4.setText(fecha[month]+", "+ccyy);
        jLabel2.setText(Funcion.DateFormat(rightNow.getTime()));
        setSize(d.width, d.height-95);
        int x=(int)(d.getWidth()-(jScrollPane1.getX())-100);
        int y=(int)(d.getHeight()-(jScrollPane1.getY()*2)-50);

        
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        javax.swing.JTable table = new javax.swing.JTable( dm ) {
            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
        };
        
        TableColumnModel cm = table.getColumnModel();
        ColumnGroup g_name = new ColumnGroup("Cuentas por Cobrar");
        g_name.add(cm.getColumn(0));
        g_name.add(cm.getColumn(1));
        g_name.add(cm.getColumn(2));
        g_name.add(cm.getColumn(3));
        g_name.add(cm.getColumn(4));
        g_name.add(cm.getColumn(5));
        ColumnGroup g_lang = new ColumnGroup("Cuentas por Pagar");
        g_lang.add(cm.getColumn(6));
        g_lang.add(cm.getColumn(7));
        g_lang.add(cm.getColumn(8));
        g_lang.add(cm.getColumn(9));
        g_lang.add(cm.getColumn(10));
        ColumnGroup g_other = new ColumnGroup("Balance");
        g_other.add(cm.getColumn(11));
        g_other.add(cm.getColumn(12));
        g_other.add(cm.getColumn(13));
        
        GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
        header.addColumnGroup(g_name);
        header.addColumnGroup(g_lang);
        header.addColumnGroup(g_other);
        jTable1.setVisible(false);
        jScrollPane1.setVisible(false);
        table.setRowHeight(26);
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        resizeColumnWidth(table);
        JScrollPane scroll = new JScrollPane( table );
        add( scroll );
        scroll.setLocation(jScrollPane1.getX(), jScrollPane1.getY());
        scroll.setSize(x, y);
        jPanel1.setLocation(x+jScrollPane1.getX()-jPanel1.getWidth(), y+jScrollPane1.getY());
        table.getColumnModel().getColumn(12).setCellRenderer( new CellRenderer("negativo") );
        table.getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("negativo") );
        table.getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("negativo") );
        setVisible(false);
    }
    public void resizeColumnWidth(javax.swing.JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 110; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width, width);
        }
        columnModel.getColumn(column).setPreferredWidth(width);
    }
    columnModel.getColumn(0).setPreferredWidth(60);
    columnModel.getColumn(5).setPreferredWidth(80);
    columnModel.getColumn(10).setPreferredWidth(80);
    columnModel.getColumn(12).setPreferredWidth(80);
    columnModel.getColumn(13).setPreferredWidth(80);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jButton1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton1.setText("Balances Previos");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(40, 310, 200, 40);

        jButton2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton2.setText("Balance en Curso");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(40, 250, 200, 40);

        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(30, 220, 220, 160);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cliente", "Proyecto", "Plan de Pagos", "Obs.", "Monto", "Proveedor", "Proyecto", "Plan de Pagos", "Obs.", "Monto", "Nota", "Diferencia", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setPreferredSize(new java.awt.Dimension(850, 64));
        jTable1.setRowHeight(26);
        add(jTable1);
        jTable1.setBounds(60, 30, 100, 40);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setMinWidth(160);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setMinWidth(160);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(12).setResizable(false);
            jTable1.getColumnModel().getColumn(13).setResizable(false);
        }
        add(jScrollPane1);
        jScrollPane1.setBounds(280, 100, 650, 430);

        jLabel2.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel2.setText("10/12/2015");
        add(jLabel2);
        jLabel2.setBounds(470, 60, 150, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel3.setText("Fecha");
        add(jLabel3);
        jLabel3.setBounds(280, 60, 150, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel4.setText("Octubre, 2015");
        add(jLabel4);
        jLabel4.setBounds(470, 20, 150, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel5.setText("Periodo");
        add(jLabel5);
        jLabel5.setBounds(280, 20, 150, 30);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(340, 0, 110, 50);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel7.setText("Estado Actual");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 110, 50);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(110, 0, 110, 50);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel9.setText("Estado Estimado");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(220, 0, 110, 50);

        add(jPanel1);
        jPanel1.setBounds(480, 530, 450, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        carga1();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        carga2();
    }//GEN-LAST:event_jButton1MouseClicked

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
    
    public void carga1(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date inicio = new java.sql.Date(getPrimerDiaDelMes().getTime());
            java.sql.Date fin = new java.sql.Date(getUltimoDiaDelMes().getTime());
            List<Factura> list2 = helper.getlistaFactura(inicio, fin);
            List<Ctecobrar> list = helper.getlistaCtecobrar(inicio,fin);
            Indexcontable ind = helper.getIndexcontable("Saldo Inicial");
            Calendar ca = Calendar.getInstance();
            int mes = ca.get(Calendar.MONTH);
            int maxdia = ca.getMaximum(Calendar.DAY_OF_MONTH);
            JTable tabla = new JTable();
            tabla= jTable1;
            
            
            DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            int tempo=0;
            int vacio=0;
            int i=1;
            float suma=0;
            float semisuma=0;
            DefaultTableModel temp3 = (DefaultTableModel) tabla.getModel();
            float inicial=Float.parseFloat(ind.getMonto());
            DecimalFormat df = new DecimalFormat("0.00");
            suma= suma + inicial;
            Object nuevo3[]= {(i)+"/"+(mes+1),"","","","","","","","","","","Estado Inicial","","$"+df.format(inicial).replace(",", ".")};
            temp3.addRow(nuevo3);
            if(list!=null || list2!=null){
                while(maxdia+1!=i){
                    //for(int i=0; i< maxdia;i++)
                    tempo=0;
                    for(int y=0;y<list.size();y++){
                        Calendar cqa = Calendar.getInstance();
                        cqa.setTime(list.get(y).getFecha());
                        int day= cqa.get(Calendar.DAY_OF_MONTH);
                        Double d=0.0;
                        Double d2=0.0;
                        if(day==i){
                            tempo=1;
                            
                            if(i< maxdia){
                                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                                float val= Float.parseFloat(list.get(y).getMontos().replace(",", "."));
                                float val2 = Float.parseFloat(list.get(y).getSaldo());
                                d=d+val;
                                d2=d2+val2;
                                suma = suma + val2;
                                Object nuevo[]= {(i)+"/"+(mes+1),list.get(y).getCliente(),list.get(y).getProyecto(),list.get(y).getPlanpagos(),list.get(y).getObservacion(),"$"+df.format(val2).replace(",", "."),"","","","","","",df.format(val2).replace(",", "."),"$"+df.format(suma).replace(",", ".")};
                                temp.addRow(nuevo);
                            }
                        }
                        
                    }
                    for(int y=0;y<list2.size();y++){
                        Calendar cqa = Calendar.getInstance();
                        cqa.setTime(list2.get(y).getFecha());
                        int day= cqa.get(Calendar.DAY_OF_MONTH);
                        if(day==i){
                            tempo=1;
                            if(i< maxdia){
                                float val= Float.parseFloat(list2.get(y).getTotal().replace(",", "."));
                                suma = suma - (val);
                                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                                Proveedores p = (Proveedores)helper.obtenerObjeto(Proveedores.class, Integer.parseInt(list2.get(y).getIdproveedor()));
                                Object nuevo[]= {(i)+"/"+(mes+1),"","","","","",p.getRazon(),"",list2.get(y).getTipo(),list2.get(y).getObservacion(),"-$"+df.format(val).replace(",", "."),"","-$"+df.format(val).replace(",", "."),"$"+df.format(suma).replace(",", ".")};
                                temp.addRow(nuevo);
                            }
                        }
                        
                    }
                    if(actual==i){
                        semisuma=suma;
                    }
                    i++;
                }
            }
            jLabel8.setText("$"+df.format(semisuma).replace(",", "."));
            jLabel6.setText("$"+df.format(suma).replace(",", "."));
         helper.cerrarSesion();   
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
            List<Factura> list2 = helper.getlistaFactura(inicio, fin);
            List<Ctecobrar> list = helper.getlistaCtecobrar(inicio,fin);
            Calendar ca = Calendar.getInstance();
            int mes = ca.get(Calendar.MONTH);
            int maxdia = ca.getMaximum(Calendar.DAY_OF_MONTH);
            JTable tabla = new JTable();
            tabla= jTable1;
            
            
            DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            int tempo=0;
            int vacio=0;
            int i=1;
            float suma=0;
            float semisuma=0;
            DefaultTableModel temp3 = (DefaultTableModel) tabla.getModel();
            float inicial=10000;
            DecimalFormat df = new DecimalFormat("0.00");
            suma= suma + inicial;
            Object nuevo3[]= {(i)+"/"+(mes+1),"","","","","","","","","","","Estado Inicial","","$"+df.format(inicial).replace(",", ".")};
            temp3.addRow(nuevo3);
            if(list!=null || list2!=null){
                while(maxdia+1!=i){
                    //for(int i=0; i< maxdia;i++)
                    tempo=0;
                    for(int y=0;y<list.size();y++){
                        Calendar cqa = Calendar.getInstance();
                        cqa.setTime(list.get(y).getFecha());
                        int day= cqa.get(Calendar.DAY_OF_MONTH);
                        if(day==i){
                            tempo=1;
                            Double d=0.0;
                            Double d2=0.0;
                            if(i< maxdia){
                                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                                float val= Float.parseFloat(list.get(y).getMontos().replace(",", "."));
                                float val2 = Float.parseFloat(list.get(y).getSaldo());
                                d=d+val;
                                d2=d2+val2;
                                suma = suma + val2;
                                Object nuevo[]= {(i)+"/"+(mes+1),list.get(y).getCliente(),list.get(y).getProyecto(),list.get(y).getPlanpagos(),list.get(y).getObservacion(),"$"+df.format(val2).replace(",", "."),"","","","","","",df.format(val2).replace(",", "."),"$"+df.format(suma).replace(",", ".")};
                                temp.addRow(nuevo);
                            }
                        }
                        
                    }
                    for(int y=0;y<list2.size();y++){
                        Calendar cqa = Calendar.getInstance();
                        cqa.setTime(list2.get(y).getFecha());
                        int day= cqa.get(Calendar.DAY_OF_MONTH);
                        if(day==i){
                            tempo=1;
                            if(i< maxdia){
                                if(list2.get(y).getPagado().equalsIgnoreCase("Pagado")){
                                float val= Float.parseFloat(list2.get(y).getTotal().replace(",", "."));
                                suma = suma - (val);
                                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                                Proveedores p = (Proveedores)helper.obtenerObjeto(Proveedores.class, Integer.parseInt(list2.get(y).getIdproveedor()));
                                Object nuevo[]= {(i)+"/"+(mes+1),"","","","","",p.getRazon(),"",list2.get(y).getTipo(),list2.get(y).getObservacion(),"$"+df.format(val).replace(",", "."),"","-$"+df.format(val).replace(",", "."),"$"+df.format(suma).replace(",", ".")};
                                temp.addRow(nuevo);
                                }
                            }
                        }   
                    }
                    if(actual==i){
                        semisuma=suma;
                    }
                    i++;
                }
            }
            jLabel8.setText("$"+df.format(semisuma).replace(",", "."));
            jLabel6.setText("$"+df.format(suma).replace(",", "."));
         helper.cerrarSesion();   
        }catch(Exception io){
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
