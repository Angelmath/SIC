/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Ctecobrar;
import Login.Entidad.Proyectos;
import Login.servicio.ServiceHb;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import monitoreo.servicio.Funcion;
/**
 *
 * @author homemig
 */
public class fccobrar extends javax.swing.JPanel {
    String cl;
    /**
     * Creates new form cliente
     */
    public fccobrar() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        
        jLabel4.setText(fecha[month]+", "+ccyy);
        jLabel2.setText(Funcion.DateFormat(rightNow.getTime()));
        setSize(d.width, d.height-95);
        int x=(int)(d.getWidth()-(jScrollPane1.getX())-100);
        int y=(int)(d.getHeight()-(jScrollPane1.getY()*2)-50);
        jScrollPane1.setSize(x, y);

        jPanel1.setLocation(x+jScrollPane1.getX()-jPanel1.getWidth(), y+jScrollPane1.getY());
        jTable1.setSize(x, y);
        jTable1.getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("negativo") );
        jTable1.getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("negativo") );
        jTable1.getColumn("Editar").setCellRenderer(new ButtonRenderer());
        setVisible(false);
        
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
            
            DefaultTableModel temp2 = (DefaultTableModel) tabla.getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                temp2.removeRow(i);
            }
            int tempo=0;
            int vacio=0;
            int i=1;
            Double d=0.0;
            Double d2=0.0;
            if(list!=null){
                while(maxdia!=i){
                    //for(int i=0; i< maxdia;i++)
                    tempo=0;
                    for (Ctecobrar list1 : list) {
                        Calendar cqa = Calendar.getInstance();
                        cqa.setTime(list1.getFecha());
                        int day= cqa.get(Calendar.DAY_OF_MONTH)+1;
                        if (day==i) {
                            tempo=1;
                            if (i< (maxdia)) {
                                DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                                float val = Float.parseFloat(list1.getMontos());
                                float val2 = Float.parseFloat(list1.getSaldo());
                                d=d+val;
                                d2=d2+val2;
                                if(list1.getIdproyecto()!=0){
                                    Proyectos p = (Proyectos) helper.obtenerObjeto(Proyectos.class, list1.getIdproyecto());
                                    Object[] nuevo = {(day)+"/"+(mes+1), list1.getCliente(), list1.getFactura(), list1.getProyecto(), list1.getPlanpagos(), p.getNumero()+" " + list1.getObservacion(), "$"+df.format(val).replace(",", "."), "$"+df.format(val-val2).replace(",", "."), list1};
                                    temp.addRow(nuevo);
                                }else{
                                    Object[] nuevo = {(day)+"/"+(mes+1), list1.getCliente(), list1.getFactura(), list1.getProyecto(), list1.getPlanpagos(),list1.getObservacion(), "$"+df.format(val).replace(",", "."), "$"+df.format(val-val2).replace(",", "."), list1};
                                    temp.addRow(nuevo);
                                }
                            }
                        }
                    }
                    if(tempo==0){
                        if(i< maxdia){
                            DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                            Object nuevo[]= {(i)+"/"+(mes+1),"","","","","","",""};
                            temp.addRow(nuevo);
                        }
                    }else{

                    }
                    i++;
                }
            }
            helper.cerrarSesion();
            jLabel10.setText("$ "+ df.format(d2).replace(",", "."));
            jLabel11.setText("$ "+ df.format(d).replace(",", "."));
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
            Double d=0.0;
            Double d2=0.0;
            if(list!=null){
                    //for(int i=0; i< maxdia;i++)
                    tempo=0;
                for (Ctecobrar list1 : list) {
                    Calendar cqa = Calendar.getInstance();
                    cqa.setTime(list1.getFecha());
                    int day= cqa.get(Calendar.DAY_OF_MONTH);
                    mes = cqa.get(Calendar.MONTH);
                    tempo=1;
                    if (i< maxdia) {
                        DefaultTableModel temp = (DefaultTableModel) tabla.getModel();
                        float val = Float.parseFloat(list1.getMontos());
                        float val2 = Float.parseFloat(list1.getSaldo());
                        d=d+val;
                        d2=d2+(val-val2);
                        Object[] nuevo = {(day)+"/"+(mes+1), list1.getCliente(),list1.getFactura(), list1.getProyecto(), list1.getPlanpagos(), list1.getObservacion(), "$"+df.format(val).replace(",", "."), "$"+df.format(val-val2).replace(",", "."), list1};
                        temp.addRow(nuevo);
                    }
                }
            }
            jLabel10.setText("$ "+ df.format(d2).replace(",", "."));
            jLabel11.setText("$ "+ df.format(d-d2).replace(",", "."));
        }catch(Exception io){
            
        }
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

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jButton2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton2.setText("CUENTAS POR COBRAR: +/- 3 MESES");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(40, 310, 250, 40);

        jButton3.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton3.setText("CUENTAS POR COBRAR : EN CURSO");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(40, 250, 250, 40);

        jButton4.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButton4.setText("AGREGAR");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(40, 370, 250, 40);

        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(30, 220, 270, 210);

        jTable1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cliente", "N° Factura", "Proyecto", "Plan de Pagos", "Observacion", "Monto", "Saldo", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(26);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(70);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(8).setMinWidth(60);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(60);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(330, 120, 720, 380);

        jLabel2.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel2.setText("10/12/2015");
        add(jLabel2);
        jLabel2.setBounds(570, 60, 150, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel3.setText("Fecha");
        add(jLabel3);
        jLabel3.setBounds(380, 60, 150, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel4.setText("Octubre, 2015");
        add(jLabel4);
        jLabel4.setBounds(570, 20, 150, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Thin", 0, 12)); // NOI18N
        jLabel5.setText("Periodo");
        add(jLabel5);
        jLabel5.setBounds(380, 20, 150, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CUENTAS POR COBRAR");
        add(jLabel6);
        jLabel6.setBounds(620, 90, 200, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel7.setText("Cuentas por Cobrar");
        add(jLabel7);
        jLabel7.setBounds(30, 40, 180, 30);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel8.setText("Modulo Financiero - Contable");
        add(jLabel8);
        jLabel8.setBounds(30, 10, 330, 30);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel9.setText("Total:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 150, 50);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(310, 0, 160, 50);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(150, 0, 150, 50);

        add(jPanel1);
        jPanel1.setBounds(580, 500, 470, 50);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        carga1();
    }//GEN-LAST:event_jButton3MouseClicked
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        carga2();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int row= jTable1.getSelectedRow();
        int col= jTable1.getSelectedColumn();
        if(col==8){
                try{
                    editctecobrar ct= new editctecobrar(null, true, null, (Ctecobrar)jTable1.getValueAt(row, col));
                    JOptionPane.showMessageDialog(null, "Generar Cuentas por Cobrar para Actualizar");
                }catch(Exception io){
                
                }
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        agregarfacturas af = new agregarfacturas(null, null, true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
