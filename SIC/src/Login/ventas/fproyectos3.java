/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Articulos;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author homemig
 */
public class fproyectos3 extends javax.swing.JPanel {
    String cl;
    String mes;
    String anio;
    String depa="";
    Calendar rightNow=Calendar.getInstance();;
    /**
     * Creates new form cliente
     */
    public fproyectos3() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        mes= fecha[month];
        anio= ""+ccyy;
        int divpanel= (d.height-350)/2;
        jScrollPane2.setSize(d.width-jScrollPane2.getX()-100, divpanel);
        jPanel2.setLocation(jScrollPane2.getWidth()+jScrollPane2.getX()-jPanel2.getWidth(), jScrollPane2.getHeight()+jScrollPane2.getY());
        jScrollPane1.setLocation(jScrollPane1.getX(), jPanel2.getY()+jPanel2.getHeight());
        jScrollPane1.setSize(d.width-jScrollPane1.getX()-100, divpanel);
        jPanel1.setLocation(jScrollPane1.getWidth()+jScrollPane1.getX()-jPanel1.getWidth(), jScrollPane1.getHeight()+jScrollPane1.getY());
        
        setSize(d.width, d.height-95);
        setVisible(false);
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDepa() {
        return depa;
    }

    public void setDepa(String depa) {
        this.depa = depa;
    }

    public Calendar getRightNow() {
        return rightNow;
    }

    public void setRightNow(Calendar rightNow) {
        this.rightNow = rightNow;
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

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }
    
    
    public String getCl() {
        return cl;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
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

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cantidad", "Detalle", "Unitario", "Total", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 230, 700, 200);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Descripcion", "Unitario", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(24);
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 40, 700, 110);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("valor");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 0, 160, 40);

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel6.setText("Valor de Ingreso:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(260, 0, 110, 40);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(520, 0, 180, 40);

        jButton1.setFont(new java.awt.Font("Roboto Light", 3, 12)); // NOI18N
        jButton1.setText("Generar Comisiones");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 0, 160, 40);
        jButton1.setVisible(false);

        jButton2.setText("PDF");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(0, 0, 80, 40);

        add(jPanel1);
        jPanel1.setBounds(30, 440, 700, 40);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel11);
        jLabel11.setBounds(780, 30, 160, 40);

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel12);
        jLabel12.setBounds(140, 30, 70, 40);

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel13);
        jLabel13.setBounds(0, 30, 70, 40);

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel14);
        jLabel14.setBounds(70, 30, 70, 40);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel10.setText("Valor de Ingreso:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(520, 30, 110, 40);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(370, 30, 70, 40);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 30, 70, 40);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(300, 30, 70, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Credito");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(370, 0, 70, 30);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Descuento");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 0, 70, 30);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Aumento");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel16);
        jLabel16.setBounds(70, 0, 70, 30);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Interes");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel17);
        jLabel17.setBounds(140, 0, 70, 30);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Anticipo");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel18);
        jLabel18.setBounds(230, 0, 70, 30);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Diferido");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel19);
        jLabel19.setBounds(300, 0, 70, 30);

        add(jPanel2);
        jPanel2.setBounds(30, 150, 940, 70);

        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(230, 0, 290, 40);

        jLabel15.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        add(jLabel15);
        jLabel15.setBounds(30, 0, 200, 40);
        add(jLabel20);
        jLabel20.setBounds(0, 0, 0, 30);
        jLabel20.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==5){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Articulos art = (Articulos)helper.obtenerObjeto(Articulos.class,Integer.parseInt(jTable1.getValueAt(row, col).toString()));
                    helper.eliminarObjeto(art);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null, "Eliminado.. Generar de nuevo");
                }catch(Exception io){

                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
