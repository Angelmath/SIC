/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.acceso;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import sgi.servicio.Funcion;
import sgi.servicio.ServiceHb;
import sgi.tablas.Observacion;

/**
 *
 * @author Angelmath
 */
public class observa extends javax.swing.JPanel {
    JFrame padre;
    Dimension d;
    paneles f;
    sgi.tablas.Login mn1=null;
    /**
     * Creates new form egreso
     * @param responsable
     * @param frame
     */
    public observa(sgi.tablas.Login responsable, paneles frame) {
        f=frame;
        d = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        jLabel3.setText(responsable.getNombre());
        mn1= responsable;
        setSize(1140, d.height-60-103);
        jScrollPane2.setSize(1122,  getHeight()-jScrollPane2.getY()-10);
        jPanel2.setLocation(((1140)/2) - (jPanel2.getWidth()/2), jPanel2.getY());
        jLabel4.setSize(d.width-60, 1);
        setVisible(false);
    }

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
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

    public JFrame getPadre() {
        return padre;
    }

    public void setPadre(JFrame padre) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        setForeground(new java.awt.Color(204, 204, 204));
        setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 90, 570, 70);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/agregar.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(630, 90, 39, 62);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel2.setText("Hora");
        add(jLabel2);
        jLabel2.setBounds(40, 160, 200, 20);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel3.setText("Responsable");
        add(jLabel3);
        jLabel3.setBounds(250, 160, 360, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Observacion", "Fecha", "Responsable", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setMinWidth(220);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(220);
            jTable1.getColumnModel().getColumn(3).setMinWidth(60);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 210, 1060, 340);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-observaciones-blue.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 0, 98, 28);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-patrulla-grey.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7);
        jLabel7.setBounds(100, 0, 98, 28);

        add(jPanel2);
        jPanel2.setBounds(250, 38, 200, 28);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setOpaque(true);
        add(jLabel4);
        jLabel4.setBounds(4, 50, 1190, 1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Observacion ob = new Observacion();
            ob.setObservacion(jTextArea1.getText());
            ob.setIdlogin(mn1.getId());
            Calendar base2 = Calendar.getInstance();
            ob.setFecha(base2.getTime());
            helper.crearObjeto(ob);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            refresh();
        }catch(Exception io){
            System.out.println(io);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==3){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
            if(selectedSiteName.equalsIgnoreCase("guardia")){
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    helper.eliminarObjeto((Observacion)helper.obtenerObjeto(Observacion.class, (Integer)jTable1.getValueAt(row, 3)));
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    refresh();
                }catch(Exception io){
                
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        f.setEventoMouseingreso4();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        f.setEventoMouseingreso5();
    }//GEN-LAST:event_jLabel7MouseClicked

    public void refresh(){
        Calendar now = Calendar.getInstance();
        Calendar base = Calendar.getInstance();
        base.set(base.get(Calendar.YEAR),base.get(Calendar.MONTH),base.get(Calendar.DAY_OF_MONTH)-2,7,0,0);
        
        Calendar base2 = Calendar.getInstance();
        base2.set(base2.get(Calendar.YEAR),base2.get(Calendar.MONTH),base2.get(Calendar.DAY_OF_MONTH)-1,19,0,0);
        
        Calendar base3 = Calendar.getInstance();
        base3.set(base3.get(Calendar.YEAR),base3.get(Calendar.MONTH),base3.get(Calendar.DAY_OF_MONTH)+1,7,0,0);
        
        Calendar base4 = Calendar.getInstance();
        base4.set(base4.get(Calendar.YEAR),base4.get(Calendar.MONTH),base4.get(Calendar.DAY_OF_MONTH)+2,19,0,0);
        List<Observacion> list=null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(now.after(base) && now.before(base2)){
                list = helper.getListObservacion(base.getTime(), base2.getTime());
            }else if(now.after(base2) && now.before(base3)){
                list = helper.getListObservacion(base2.getTime(), base3.getTime());
            }else{
                list = helper.getListObservacion(base3.getTime(), base4.getTime());
            }            
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        DefaultTableModel temp2 = (DefaultTableModel) getjTable1().getModel();
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            temp2.removeRow(i);
        }
        if(list!=null){
            ServiceHb helper = null;
            try{
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                for(Observacion i: list){
                    String campo1= i.getObservacion();
                    String campo2= Funcion.DateTimeFormatJS(i.getFecha());
                    String campo3= ((sgi.tablas.Login)helper.obtenerObjeto(sgi.tablas.Login.class, i.getIdlogin())).getNombre();
                    //String campo3= i.getResponsable();
                    int campo4 = i.getId();
                    DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
                    Object nuevo[]= {campo1,campo2,campo3,campo4};
                    temp.addRow(nuevo);
                }
                helper.cerrarSesion();
            }catch(Exception io){
                try{
                    helper.cerrarSesion();
                }catch(Exception io2){}
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
