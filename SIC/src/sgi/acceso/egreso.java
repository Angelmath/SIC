/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.acceso;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import sgi.servicio.ServiceHb;
import sgi.tablas.Foto;

/**
 *
 * @author Angelmath
 */
public class egreso extends javax.swing.JPanel {
    JFrame padre;
    Dimension d;
    paneles f;
    /**
     * Creates new form egreso
     * @param frame
     */
    public egreso(paneles frame) {
        f=frame;
        d = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        setSize(1140, d.height-60-103);
        jScrollPane1.setSize(1140,  getHeight()-jScrollPane1.getY());
        jPanel2.setLocation(((getWidth())/2) - (jPanel2.getWidth()/2), jPanel2.getY());
        jPanel1.setLocation(((getWidth())/2) - (jPanel1.getWidth()/2), jPanel1.getY());
        jLabel12.setSize(d.width-60, 1);
        setVisible(false);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        campo3 = new javax.swing.JLabel();
        campo1 = new javax.swing.JLabel();
        campo2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        setLayout(null);

        jScrollPane1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Id", "Placa", "Cedula", "Nombre", "Apellido", "Material", "Observacion", "Ingreso", "Salida", "Accion", "Acreditar", "Extra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, false, false, false, true
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
            jTable1.getColumnModel().getColumn(10).setMinWidth(50);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 163, 1200, 370);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel7.setText("Apellido:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(260, 10, 70, 30);

        jTextField3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(570, 10, 140, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel5.setText("Cedula:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(510, 10, 70, 30);

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel8.setText("Placa:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(740, 10, 60, 30);

        jTextField4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(800, 10, 150, 30);

        jTextField6.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jPanel1.add(jTextField6);
        jTextField6.setBounds(570, 10, 140, 30);

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel6.setText("Cedula:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(510, 10, 70, 30);

        jTextField2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jPanel1.add(jTextField2);
        jTextField2.setBounds(330, 10, 140, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(260, 10, 70, 30);

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setText("Placa:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(740, 10, 60, 30);

        jTextField1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(90, 10, 140, 30);

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 70, 30);

        add(jPanel1);
        jPanel1.setBounds(30, 100, 970, 60);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        campo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-reporte-grey.png"))); // NOI18N
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

        campo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/mini-pestana-salida-blue.png"))); // NOI18N
        campo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo2MouseClicked(evt);
            }
        });
        jPanel2.add(campo2);
        campo2.setBounds(100, 0, 98, 28);

        add(jPanel2);
        jPanel2.setBounds(250, 38, 300, 28);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setOpaque(true);
        add(jLabel12);
        jLabel12.setBounds(4, 50, 1190, 1);
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

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

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

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campo1;
    private javax.swing.JLabel campo2;
    private javax.swing.JLabel campo3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
