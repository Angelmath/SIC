/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Caldepartamento;
import Login.Entidad.Calpermisos;
import Login.Entidad.Login;
import Login.servicio.ServiceHb;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.JCheckBox;

/**
 *
 * @author Angelmath
 */
public final class calendarnewpm extends javax.swing.JDialog {
    marco padre;
    Login empl;
    List<Caldepartamento> lista2;
    List<Login> listalogin;
    List<Calpermisos> listpermi;
    /**
     * Creates new form ingresoU
     */
    public calendarnewpm(java.awt.Frame parent, marco padre, boolean modal, Login log, List<Caldepartamento> listdepa, Calendar calFin2,List<Calpermisos> listpermi) {
        super(parent, modal);
        initComponents();
        this.empl=log;       
        lista2=listdepa;
        this.listpermi=listpermi;
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        jTextField2.setText(log.getNombre());
        jTextField3.setText(log.getDepartamento());
        String[] horas={"05:00","05:30","06:00","06:30","07:00","07:30", "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30"};
        jDateChooser2.setDate(calFin2.getTime());
        jDateChooser1.setDate(calFin2.getTime());
        setVisible(true);
        this.padre=padre;
        
    }
    
    public calendarnewpm(java.awt.Frame parent, marco padre, boolean modal, Login log, List<Caldepartamento> listdepa, Calendar calFin2,List<Calpermisos> listpermi, String hora) {
        super(parent, modal);
        initComponents();
        this.empl=log;       
        lista2=listdepa;
        this.listpermi=listpermi;
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        jTextField2.setText(log.getNombre());
        jTextField3.setText(log.getDepartamento());
        String[] horas={"05:00","05:30","06:00","06:30","07:00","07:30", "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30"};
        jDateChooser2.setDate(calFin2.getTime());
        jDateChooser1.setDate(calFin2.getTime());
        setVisible(true);
        this.padre=padre;
        
    }
    
    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setBackground(new java.awt.Color(230, 230, 230));
        setMinimumSize(new java.awt.Dimension(920, 430));
        setPreferredSize(new java.awt.Dimension(930, 500));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 151));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Project Manager");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 0, 220, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 30, 980, 1);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(101, 101, 101));
        jLabel4.setText("Cliente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 50, 130, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(101, 101, 101));
        jLabel5.setText("Fecha Inicio");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(480, 50, 90, 30);

        jTextField2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(101, 101, 101));
        jTextField2.setEnabled(false);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(190, 130, 230, 30);

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(101, 101, 101));
        jLabel7.setText("Fases Previas");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 180, 130, 30);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(455, 50, 1, 340);

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(101, 101, 101));
        jLabel10.setText("Proyecto");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 90, 130, 30);

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(101, 101, 101));
        jLabel11.setText("Asignación por Fase");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(480, 170, 170, 30);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-aceptar-grey.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        getContentPane().add(jLabel13);
        jLabel13.setBounds(310, 400, 111, 39);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-cancelar-grey.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        getContentPane().add(jLabel14);
        jLabel14.setBounds(500, 400, 110, 38);

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(101, 101, 101));
        jLabel16.setText("Días");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(850, 320, 40, 30);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(600, 90, 240, 30);
        getContentPane().add(jDateChooser2);
        jDateChooser2.setBounds(600, 50, 240, 30);

        jTextField3.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(101, 101, 101));
        jTextField3.setEnabled(false);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(190, 90, 230, 30);

        jTextField4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField4);
        jTextField4.setBounds(600, 130, 60, 30);

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(101, 101, 101));
        jLabel19.setText("Fecha Término");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(480, 90, 100, 30);

        jTextField5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField5);
        jTextField5.setBounds(600, 320, 180, 30);

        jLabel20.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(101, 101, 101));
        jLabel20.setText("Fase 5");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(480, 320, 100, 30);

        jLabel21.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(101, 101, 101));
        jLabel21.setText("Fecha Término");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(480, 130, 100, 30);

        jLabel22.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(101, 101, 101));
        jLabel22.setText("Fase 1");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(480, 200, 100, 30);

        jLabel23.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(101, 101, 101));
        jLabel23.setText("Fase 2");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(480, 230, 100, 30);

        jLabel24.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(101, 101, 101));
        jLabel24.setText("Fase 3");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(480, 260, 100, 30);

        jLabel25.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(101, 101, 101));
        jLabel25.setText("Fase 4");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(480, 290, 100, 30);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField6);
        jTextField6.setBounds(190, 50, 230, 30);

        jTextField7.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField7);
        jTextField7.setBounds(600, 200, 180, 30);

        jTextField8.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField8);
        jTextField8.setBounds(600, 230, 180, 30);

        jTextField9.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField9);
        jTextField9.setBounds(600, 260, 180, 30);

        jTextField10.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField10);
        jTextField10.setBounds(600, 290, 180, 30);

        jTextField11.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField11);
        jTextField11.setBounds(800, 200, 40, 30);

        jTextField12.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField12);
        jTextField12.setBounds(800, 230, 40, 30);

        jTextField13.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField13);
        jTextField13.setBounds(800, 260, 40, 30);

        jTextField14.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField14);
        jTextField14.setBounds(800, 290, 40, 30);

        jTextField15.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(101, 101, 101));
        getContentPane().add(jTextField15);
        jTextField15.setBounds(800, 320, 40, 30);

        jLabel26.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(101, 101, 101));
        jLabel26.setText("Días");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(670, 130, 40, 30);

        jLabel27.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(101, 101, 101));
        jLabel27.setText("Días");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(850, 200, 40, 30);

        jLabel28.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(101, 101, 101));
        jLabel28.setText("Días");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(850, 230, 40, 30);

        jLabel29.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(101, 101, 101));
        jLabel29.setText("Días");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(850, 260, 40, 30);

        jLabel30.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(101, 101, 101));
        jLabel30.setText("Días");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(850, 290, 40, 30);

        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(101, 101, 101));
        jLabel9.setText("Comercial");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 130, 130, 30);

        jCheckBox1.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox1.setText("Dpt. Marketing");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(320, 210, 100, 23);

        jCheckBox2.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox2.setText("Revisión");
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(320, 240, 110, 23);

        jCheckBox3.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox3.setText("Configuración");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox3);
        jCheckBox3.setBounds(320, 180, 110, 23);

        jCheckBox4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox4.setText("Pruebas");
        getContentPane().add(jCheckBox4);
        jCheckBox4.setBounds(320, 270, 110, 23);

        jCheckBox5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox5.setText("Cableado");
        getContentPane().add(jCheckBox5);
        jCheckBox5.setBounds(190, 240, 110, 23);

        jCheckBox6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox6.setText("Auditoría");
        getContentPane().add(jCheckBox6);
        jCheckBox6.setBounds(320, 300, 110, 23);

        jCheckBox7.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox7.setText("Montaje");
        getContentPane().add(jCheckBox7);
        jCheckBox7.setBounds(190, 270, 110, 23);

        jCheckBox8.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox8.setText("Reparación");
        getContentPane().add(jCheckBox8);
        jCheckBox8.setBounds(190, 330, 110, 23);

        jCheckBox9.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox9.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox9.setText("Calibración");
        getContentPane().add(jCheckBox9);
        jCheckBox9.setBounds(190, 300, 110, 23);

        jCheckBox10.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox10.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox10.setText("Ducteria");
        getContentPane().add(jCheckBox10);
        jCheckBox10.setBounds(190, 210, 110, 23);

        jCheckBox11.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jCheckBox11.setForeground(new java.awt.Color(101, 101, 101));
        jCheckBox11.setText("Inspeccion");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox11);
        jCheckBox11.setBounds(190, 180, 110, 23);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-aceptar-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-aceptar-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-cancelar-grey.png"))); // NOI18N
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-cancelar-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    public Login getEmpl() {
        return empl;
    }

    public void setEmpl(Login empl) {
        this.empl = empl;
    }
    
    public boolean validacion(){
        
    return true;
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
            java.util.logging.Logger.getLogger(calendarnewpm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calendarnewpm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calendarnewpm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calendarnewpm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                calendarnewpm dialog = new calendarnewpm(new javax.swing.JFrame(),null, true,null,null,null,null);
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
