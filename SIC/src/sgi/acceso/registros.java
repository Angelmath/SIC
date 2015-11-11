/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.acceso;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import sgi.servicio.ServiceHb;
import sgi.tablas.Foto;

/**
 *
 * @author Angelmath
 */
public class registros extends javax.swing.JPanel {
    Dimension d;
    paneles f;
    /**
     * Creates new form registros
     * @param frame
     */
    public registros(paneles frame) {
        d = Toolkit.getDefaultToolkit().getScreenSize();
        f=frame;
        initComponents();
        setSize(1140, d.height-60-103);
        jScrollPane1.setSize(1140,  getHeight()-jScrollPane1.getY());
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        jPanel2.setLocation(((getWidth())/2) - (jPanel2.getWidth()/2), jPanel2.getY());
        jLabel2.setSize(d.width-60, 1);
        setVisible(false);
    }
    public void cambio(JLabel lb){
        campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-ingreso-grey.png"))); // NOI18N
        campo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-salida-grey.png"))); // NOI18N
        campo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-reporte-grey.png"))); // NOI18N

        if(lb==campo1){
            campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-ingreso-blue.png"))); // NOI18N
        }
        if(lb==campo2){
            campo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-salida-blue.png"))); // NOI18N
        }
        if(lb==campo3){
            campo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-reporte-blue.png"))); // NOI18N
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        campo3 = new javax.swing.JLabel();
        campo1 = new javax.swing.JLabel();
        campo2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        setMinimumSize(new java.awt.Dimension(1000, 540));
        setPreferredSize(new java.awt.Dimension(1000, 540));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Id", "Placa", "Cedula", "Nombre", "Apellido", "Material", "Observacion", "Ingreso", "Salida", "Acreditar", "Extra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(30);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 120, 1200, 410);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        campo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-reporte-blue.png"))); // NOI18N
        campo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo3MouseClicked(evt);
            }
        });
        jPanel2.add(campo3);
        campo3.setBounds(200, 0, 98, 28);

        campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-ingreso-grey.png"))); // NOI18N
        campo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo1MouseClicked(evt);
            }
        });
        jPanel2.add(campo1);
        campo1.setBounds(0, 0, 98, 28);

        campo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-salida-grey.png"))); // NOI18N
        campo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo2MouseClicked(evt);
            }
        });
        jPanel2.add(campo2);
        campo2.setBounds(100, 0, 98, 28);

        add(jPanel2);
        jPanel2.setBounds(250, 38, 300, 28);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(4, 50, 1190, 1);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col= jTable1.getSelectedColumn();
        ServiceHb helper=null;
        try{
            if(col==2){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                Foto foto = helper.getfotoPlaca(jTable1.getValueAt(row, col).toString());
                helper.cerrarSesion();
                mostrarimg m = new mostrarimg(null, true, foto.getFoto());
            }
            if(col==3){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                Foto foto = helper.getfotoCi(jTable1.getValueAt(row, col).toString());
                helper.cerrarSesion();
                mostrarimg m = new mostrarimg(null, true, foto.getFoto());
            }
        }catch(Exception io){
            try{
            helper.cerrarSesion();
            }catch(Exception ios){}
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void campo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo1MouseClicked
//        cambio(campo1);
        f.setEventoMouseingreso1();
    }//GEN-LAST:event_campo1MouseClicked

    private void campo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo2MouseClicked
  //      cambio(campo2);
        f.setEventoMouseingreso2();
    }//GEN-LAST:event_campo2MouseClicked

    private void campo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo3MouseClicked
    //    cambio(campo3);
        f.setEventoMouseingreso3();
    }//GEN-LAST:event_campo3MouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campo1;
    private javax.swing.JLabel campo2;
    private javax.swing.JLabel campo3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
