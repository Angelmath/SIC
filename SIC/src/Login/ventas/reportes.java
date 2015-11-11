/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Ctepagar;
import Login.Entidad.Factu;
import Login.Entidad.Retencion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
/**
 *
 * @author Angelmath
 */
public final class reportes extends javax.swing.JPanel {
    JFrame padre;
    marco marc;
    /**
     * Creates new form clientes
     */
    public reportes(JFrame nuevo, marco marc) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setSize(d.width, d.height-95);
        getjPanel1().setLocation((d.width/2)-(getjPanel1().getWidth() /2),0);
        getjLabel1().setSize(d.width, d.height-95);
        getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text derecha") );
        getjTable2().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text derecha") );
        getjTable3().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text derecha") );
        getjTable3().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text derecha") );
        this.padre=nuevo;
        this.marc=marc;
        setVisible(false);
    }
    
    private void setEventoMouseClicked(JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
 
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                tblEjemploMouseClicked(e);
            } catch (Exception ex) {
                
            }
        }
        });
    }
    
    private void tblEjemploMouseClicked(java.awt.event.MouseEvent evt) throws Exception {
 
    }
    
    public JFrame getPadre() {
        return padre;
    }

    public void setPadre(JFrame padre) {
        this.padre = padre;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public marco getMarc() {
        return marc;
    }

    public void setMarc(marco marc) {
        this.marc = marc;
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

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
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

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public JTable getjTable3() {
        return jTable3;
    }

    public void setjTable3(JTable jTable3) {
        this.jTable3 = jTable3;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 0, 0));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 100, 1130, 10);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(570, 100, 10, 550);

        jButton2.setText("Mensual");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1020, 20, 100, 25);

        jButton3.setText("Anual");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1020, 60, 100, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ganancia Neta");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 10, 150, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Margen Neto");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 40, 150, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Margen Real");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 70, 150, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("0.00");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 70, 100, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("0.00");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(190, 40, 100, 20);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("0.00");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(190, 10, 100, 20);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Factura", "Valor", "Retencion", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setMinWidth(80);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
        jTable2.getColumnModel().getColumn(2).setMinWidth(100);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
        jTable2.getColumnModel().getColumn(3).setMinWidth(80);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(80);
        jTable2.getColumnModel().getColumn(4).setMinWidth(100);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(4).setMaxWidth(100);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(590, 150, 550, 420);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Factura", "Valor", "Retencion", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        jTable3.getColumnModel().getColumn(0).setMinWidth(80);
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable3.getColumnModel().getColumn(0).setMaxWidth(80);
        jTable3.getColumnModel().getColumn(2).setMinWidth(100);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(2).setMaxWidth(100);
        jTable3.getColumnModel().getColumn(4).setMinWidth(100);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(4).setMaxWidth(100);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(0, 150, 550, 420);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        jComboBox1.setSelectedIndex(1);
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(920, 20, 80, 25);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        jComboBox2.setSelectedIndex(1);
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(920, 60, 80, 25);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(840, 20, 60, 25);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("REPORTES");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(500, 60, 140, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Egreso");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(590, 110, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ingreso");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 140, 30);

        jLabel4.setText("Subtotal");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(360, 590, 100, 20);

        jLabel11.setText("Total + Iva");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(360, 620, 90, 20);

        jLabel12.setText("SubTotal");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(900, 590, 100, 20);

        jLabel13.setText("Total + Iva");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(900, 620, 90, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("0.00");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1030, 620, 80, 14);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("0.00");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(460, 590, 80, 14);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("0.00");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(460, 620, 80, 14);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("0.00");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(1030, 590, 80, 14);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1140, 660);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1140, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
//        List<Ctepagar> cte;
//        List<Retencion> ret;
//        List<Factu> fac;
//        ArrayList<Ctepagar> result= new ArrayList<Ctepagar>();
//        ArrayList<Retencion> resultret;
//        resultret = new ArrayList<Retencion>();
//        ArrayList<Factu> resultfac= new ArrayList<Factu>();
//        double cobrar=0.0;
//        double pagar=0.0;
//        try {
//            ServiceHb helper = new ServiceHb();
//            
//            helper.iniciarTransaccion();
//            cte = helper.getlistactepagar();
//            fac = helper.getlistafact();
//            ret = helper.getlistaret();
//            String anio = getjComboBox1().getSelectedItem().toString();
//            String mes= getjComboBox3().getSelectedItem().toString();
//            String inicio= "01";
//            String ultimo= "31";
//            String feh= inicio+"/"+mes+"/"+anio;
//            String feh2= ultimo+"/"+mes+"/"+anio;
//            Date d = Funcion.StringToDate(feh);
//            Date d2 = Funcion.StringToDate(feh2);
//            Date c;
//            for(Ctepagar i: cte){
//                c = Funcion.StringToDate(i.getFecha());
//                if(c.after(d)&&c.before(d2)){
//                    result.add(i);
//                }
//            }
//            for(Retencion i: ret){
//                c = Funcion.StringToDate(i.getFecha());
//                if(c.after(d)&&c.before(d2)){
//                    resultret.add(i);
//                }
//            }
//            for(Factu i: fac){
//                c = Funcion.StringToDate(i.getFecha());
//                if(c.after(d)&&c.before(d2)){
//                    resultfac.add(i);
//                }
//            }  
//            
//            DefaultTableModel temp2 = (DefaultTableModel) getjTable2().getModel();
//            for(int i=temp2.getRowCount()-1;i>=0;i--){
//               temp2.removeRow(i);
//            }
//        if(result!=null){
//            for(int i=0; i<result.size();i++){
//                if(getjTable2().getRowCount()< result.size()){
//                    DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
//                    Object nuevo[]= {temp.getRowCount()+1,"",""};
//                    temp.addRow(nuevo);
//                }
//                Retencion re = (Retencion)helper.getRetencion(Integer.toString(result.get(i).getId()));
//                getjTable2().getModel().setValueAt(result.get(i).getFecha(), i, 0);
//                getjTable2().getModel().setValueAt(result.get(i).getNumero(), i, 1);
//                getjTable2().getModel().setValueAt(result.get(i).getValor(), i, 2);
//                cobrar= Double.parseDouble(result.get(i).getValor())+cobrar;
//                if(re!=null){
//                    getjTable2().getModel().setValueAt(re.getNumero(), i, 3);
//                    getjTable2().getModel().setValueAt(re.getValor(), i, 4);
//                    cobrar= Double.parseDouble(re.getValor())+cobrar;
//                }else{
//                    getjTable2().getModel().setValueAt("", i, 3);
//                    getjTable2().getModel().setValueAt("", i, 4);
//                }
//                
//            }
//        }
//        
//        DefaultTableModel temp3 = (DefaultTableModel) getjTable3().getModel();
//        for(int i=temp3.getRowCount()-1;i>=0;i--){
//           temp3.removeRow(i);
//        }
//        if(resultfac!=null){
//            for(int i=0; i<resultfac.size();i++){
//                if(getjTable3().getRowCount()< resultfac.size()){
//                    DefaultTableModel temp = (DefaultTableModel) getjTable3().getModel();
//                    Object nuevo[]= {temp.getRowCount()+1,"",""};
//                    temp.addRow(nuevo);
//                }
//                Retencion re = (Retencion)helper.getRetencion("ret"+Integer.toString(resultfac.get(i).getId()));
//                getjTable3().getModel().setValueAt(resultfac.get(i).getFecha(), i, 0);
//                String num =resultfac.get(i).getNombre().split(".pdf")[0];
//                getjTable3().getModel().setValueAt(num, i, 1);
//                getjTable3().getModel().setValueAt(resultfac.get(i).getValor(), i, 2);
//                if(re!=null){
//                getjTable3().getModel().setValueAt(re.getNumero(), i, 3);
//                getjTable3().getModel().setValueAt(re.getValor(), i, 4);
//                pagar= Double.parseDouble(re.getValor())+pagar;
//                }else{
//                getjTable3().getModel().setValueAt("", i, 3);
//                getjTable3().getModel().setValueAt("", i, 4);
//                }
//                pagar= Double.parseDouble(resultfac.get(i).getValor())+pagar;
//            }
//        }
//        
//        getjLabel17().setText("$  "+Funcion.DecimalFormatByDouble(cobrar));
//        double cobrariva= cobrar*1.12;
//        getjLabel14().setText("$  "+Funcion.DecimalFormatByDouble(cobrariva));
//        getjLabel15().setText("$  "+Funcion.DecimalFormatByDouble(pagar));
//        double pagariva= pagar*1.12;
//        getjLabel16().setText("$  "+Funcion.DecimalFormatByDouble(pagariva));
//        
//        getjLabel8().setText("%  "+Funcion.DecimalFormatByDouble((pagar-cobrar)*100/cobrar));
//        getjLabel9().setText("%  "+Funcion.DecimalFormatByDouble(pagar*100/cobrar));
//        getjLabel10().setText("$  "+Funcion.DecimalFormatByDouble(pagar-cobrar));
//            helper.confirmarTransaccion();
//            helper.cerrarTransaccion();
//            helper.cerrarSesion();
//        } catch (Exception ex) {
//            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
//        List<Ctepagar> cte;
//        List<Retencion> ret;
//        List<Factu> fac;
//        ArrayList<Ctepagar> result= new ArrayList<Ctepagar>();
//        ArrayList<Retencion> resultret= new ArrayList<Retencion>();
//        ArrayList<Factu> resultfac= new ArrayList<Factu>();
//        double cobrar=0.0;
//        double pagar=0.0;
//        try {
//            ServiceHb helper = new ServiceHb();
//            
//            helper.iniciarTransaccion();
//            cte = helper.getlistactepagar();
//            fac = helper.getlistafact();
//            ret = helper.getlistaret();
//            String anio = getjComboBox2().getSelectedItem().toString();
//            String feh= 01+"/"+01+"/"+anio;
//            String feh2= 31+"/"+12+"/"+anio;
//            Date d = Funcion.StringToDate(feh);
//            Date d2 = Funcion.StringToDate(feh2);
//            Date c;
//            for(Ctepagar i: cte){
//                c = Funcion.StringToDate(i.getFecha());
//                if(c.after(d)&&c.before(d2)){
//                    result.add(i);
//                }
//            }
//            for(Retencion i: ret){
//                c = Funcion.StringToDate(i.getFecha());
//                if(c.after(d)&&c.before(d2)){
//                    resultret.add(i);
//                }
//            }
//            for(Factu i: fac){
//                c = Funcion.StringToDate(i.getFecha());
//                if(c.after(d)&&c.before(d2)){
//                    resultfac.add(i);
//                }
//            }  
//            
//            DefaultTableModel temp2 = (DefaultTableModel) getjTable2().getModel();
//            for(int i=temp2.getRowCount()-1;i>=0;i--){
//               temp2.removeRow(i);
//            }
//        if(result!=null){
//            for(int i=0; i<result.size();i++){
//                if(getjTable2().getRowCount()< result.size()){
//                    DefaultTableModel temp = (DefaultTableModel) getjTable2().getModel();
//                    Object nuevo[]= {temp.getRowCount()+1,"",""};
//                    temp.addRow(nuevo);
//                }
//                Retencion re = (Retencion)helper.getRetencion(Integer.toString(result.get(i).getId()));
//                getjTable2().getModel().setValueAt(result.get(i).getFecha(), i, 0);
//                getjTable2().getModel().setValueAt(result.get(i).getNumero(), i, 1);
//                getjTable2().getModel().setValueAt(result.get(i).getValor(), i, 2);
//                cobrar= Double.parseDouble(result.get(i).getValor())+cobrar;
//                if(re!=null){
//                    getjTable2().getModel().setValueAt(re.getNumero(), i, 3);
//                    getjTable2().getModel().setValueAt(re.getValor(), i, 4);
//                    cobrar= Double.parseDouble(re.getValor())+cobrar;
//                }else{
//                    getjTable2().getModel().setValueAt("", i, 3);
//                    getjTable2().getModel().setValueAt("", i, 4);
//                }
//                
//            }
//        }
//        
//        DefaultTableModel temp3 = (DefaultTableModel) getjTable3().getModel();
//        for(int i=temp3.getRowCount()-1;i>=0;i--){
//           temp3.removeRow(i);
//        }
//        if(resultfac!=null){
//            for(int i=0; i<resultfac.size();i++){
//                if(getjTable3().getRowCount()< resultfac.size()){
//                    DefaultTableModel temp = (DefaultTableModel) getjTable3().getModel();
//                    Object nuevo[]= {temp.getRowCount()+1,"",""};
//                    temp.addRow(nuevo);
//                }
//                Retencion re = (Retencion)helper.getRetencion("ret"+Integer.toString(resultfac.get(i).getId()));
//                getjTable3().getModel().setValueAt(resultfac.get(i).getFecha(), i, 0);
//                String num =resultfac.get(i).getNombre().split(".pdf")[0];
//                getjTable3().getModel().setValueAt(num, i, 1);
//                getjTable3().getModel().setValueAt(resultfac.get(i).getValor(), i, 2);
//                if(re!=null){
//                getjTable3().getModel().setValueAt(re.getNumero(), i, 3);
//                getjTable3().getModel().setValueAt(re.getValor(), i, 4);
//                pagar= Double.parseDouble(re.getValor())+pagar;
//                }else{
//                getjTable3().getModel().setValueAt("", i, 3);
//                getjTable3().getModel().setValueAt("", i, 4);
//                }
//                pagar= Double.parseDouble(resultfac.get(i).getValor())+pagar;
//            }
//        }
//        
//        getjLabel17().setText("$  "+Funcion.DecimalFormatByDouble(cobrar));
//        double cobrariva= cobrar*1.12;
//        getjLabel14().setText("$  "+Funcion.DecimalFormatByDouble(cobrariva));
//        getjLabel15().setText("$  "+Funcion.DecimalFormatByDouble(pagar));
//        double pagariva= pagar*1.12;
//        getjLabel16().setText("$  "+Funcion.DecimalFormatByDouble(pagariva));
//        
//        getjLabel8().setText("%  "+Funcion.DecimalFormatByDouble((pagar-cobrar)*100/cobrar));
//        getjLabel9().setText("%  "+Funcion.DecimalFormatByDouble(pagar*100/cobrar));
//        getjLabel10().setText("$  "+Funcion.DecimalFormatByDouble(pagar-cobrar));
//            helper.confirmarTransaccion();
//            helper.cerrarTransaccion();
//            helper.cerrarSesion();
//        } catch (Exception ex) {
//            Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton3MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
