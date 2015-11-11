/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import javax.swing.JLabel;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rrhh.Entidad.Bono;
import rrhh.Entidad.Comisiones;
import rrhh.Entidad.Horas;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Prestamos;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Angelmath
 */
public class erroresMultas extends javax.swing.JDialog {
    ArrayList<String> list;
    /**
     * Creates new form ingresoU
     */
    public erroresMultas(java.awt.Frame parent, boolean modal,ArrayList<String> list) {
        super(parent, modal);
        initComponents();
        setSize(800,380);
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        this.list=list;
        DefaultTableModel temp4 = (DefaultTableModel) jTable1.getModel();
        for(int i=temp4.getRowCount()-1;i>=0;i--){
           temp4.removeRow(i);
        }
        if(list.size()>0){
            DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
            for(String i: list){
                String cad[]=i.split("|");
                String c1=cad[0];
                String c2=cad[1];
                String c3=cad[2];
                String c4=cad[3];
                String c5=cad[4];
                Object nuevo[]= {c1,c2,c3,c4,c5};
                temp.addRow(nuevo);
            }
        }
        setVisible(true);
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }
    
    public void alt (Component bt, String text){
        jLabel9.setVisible(true);
        jLabel9.setText(text);
        jLabel9.setSize((int)jLabel9.getMinimumSize().getWidth(), 25);
        jLabel9.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
    }

    public JLabel getjLabel1() {
        return jLabel1;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(378, 320));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Observacion", "Motivo", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        jTable1.setRowHeight(26);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 730, 220);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel9.setText("jLabel8");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 70, 25);
        jLabel9.setVisible(false);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Multas Perdidas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 20, 790, 30);

        jButton1.setText("Eliminar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 320, 100, 40);

        jButton2.setText("Salir");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(430, 320, 100, 40);

        jLabel1.setBackground(new java.awt.Color(242, 242, 242));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-2, -2, 800, 380);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
        if(selectedSiteName.equalsIgnoreCase("cajamarca")){
            if(list.size()>0){
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                for(String i: list){
                    int id= Integer.parseInt(i.split("|")[0].replace("ID:", ""));
                    String tipo= i.split("|")[6];
                    if(tipo.contains("Multa")){
                        helper.obtenerObjeto(Multa.class, id);
                    }
                    if(tipo.contains("Hora")){
                        helper.obtenerObjeto(Horas.class, id);
                    }
                    if(tipo.contains("Comision")){
                        helper.obtenerObjeto(Comisiones.class, id);
                    }
                    if(tipo.contains("Bono")){
                        helper.obtenerObjeto(Bono.class, id);
                    }
                    if(tipo.contains("Prestamo")){
                        helper.obtenerObjeto(Prestamos.class, id);
                    }
                    
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                JOptionPane.showMessageDialog(null, "Eliminados");
            }catch(Exception io){
                JOptionPane.showMessageDialog(null, "Errores por ID");
            }
            }
            dispose();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked


 public void empleados(){    
    
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(erroresMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(erroresMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(erroresMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(erroresMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                erroresMultas dialog = new erroresMultas(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
