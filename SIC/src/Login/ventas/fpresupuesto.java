/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Clientes;
import Login.Entidad.Instalacion;
import Login.servicio.ServiceHb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import monitoreo.servicio.Funcion;
/**
 *
 * @author homemig
 */
public class fpresupuesto extends javax.swing.JPanel {
    String cl;
    String mes;
    String anio;
    fpresupuesto2 f = new fpresupuesto2();
    Calendar rightNow=Calendar.getInstance();;
    /**
     * Creates new form cliente
     */
    public fpresupuesto() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        mes= fecha[month];
        anio= ""+ccyy;
        setSize(d.width, d.height-95);
        jLabel22.setLocation(d.width-(jLabel22.getWidth()*2), d.height-95-(jLabel22.getHeight()*2));
        add(f);
        f.setLocation(jPanel1.getX(), jPanel1.getY());
        setVisible(false);
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

    public fpresupuesto2 getF() {
        return f;
    }

    public void setF(fpresupuesto2 f) {
        this.f = f;
    }

    public Calendar getRightNow() {
        return rightNow;
    }

    public void setRightNow(Calendar rightNow) {
        this.rightNow = rightNow;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton10() {
        return jButton10;
    }

    public void setjButton10(JButton jButton10) {
        this.jButton10 = jButton10;
    }

    public JButton getjButton11() {
        return jButton11;
    }

    public void setjButton11(JButton jButton11) {
        this.jButton11 = jButton11;
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

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public JButton getjButton6() {
        return jButton6;
    }

    public void setjButton6(JButton jButton6) {
        this.jButton6 = jButton6;
    }

    public JButton getjButton7() {
        return jButton7;
    }

    public void setjButton7(JButton jButton7) {
        this.jButton7 = jButton7;
    }

    public JButton getjButton8() {
        return jButton8;
    }

    public void setjButton8(JButton jButton8) {
        this.jButton8 = jButton8;
    }

    public JButton getjButton9() {
        return jButton9;
    }

    public void setjButton9(JButton jButton9) {
        this.jButton9 = jButton9;
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

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
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

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setLayout(null);

        jButton4.setText("DPT. ADMINISTRATIVO");
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
        jPanel1.add(jButton4);
        jButton4.setBounds(30, 40, 250, 40);

        jButton3.setText("DPT. COMERCIAL");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(30, 250, 250, 40);

        jButton2.setText("DPT. MARKETING");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 330, 250, 40);

        jButton5.setText("DPT. FINANCIERO");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(30, 110, 250, 40);

        jButton6.setText("DPT. RRHH");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(30, 180, 250, 40);

        jButton7.setText("OFICINAS");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(340, 330, 250, 40);

        jButton8.setText("DPT. SEGURIDAD FIS.");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(340, 250, 250, 40);

        jButton9.setText("DPT. SEGURIDAD ELEC.");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(340, 180, 250, 40);

        jButton10.setText("DPT. PYL");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(340, 110, 250, 40);

        jButton11.setText("DPT. SISTEMAS");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(340, 40, 250, 40);

        jButton1.setText("Generar Presupues Mensual");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(220, 390, 190, 23);

        add(jPanel1);
        jPanel1.setBounds(40, 110, 630, 430);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setText("Asignacion Presupuestaria");
        add(jLabel2);
        jLabel2.setBounds(30, 40, 230, 30);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel1.setText("Modulo Financiero - Contable");
        add(jLabel1);
        jLabel1.setBounds(30, 10, 330, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/back.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        add(jLabel22);
        jLabel22.setBounds(930, 530, 50, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton4.getText());
        f.llenarpresu(jButton4.getText());
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton3.getText());
        f.llenarpresu(jButton3.getText());
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton2.getText());
        f.llenarpresu(jButton2.getText());
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton5.getText());
        f.llenarpresu(jButton5.getText());
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton6.getText());        // TODO add your handling code here:
        f.llenarpresu(jButton6.getText());
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton7.getText());
        f.llenarpresu(jButton7.getText());
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton8.getText());
        f.llenarpresu(jButton8.getText());
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton9.getText());
        f.llenarpresu(jButton9.getText());
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton10.getText());
        f.llenarpresu(jButton10.getText());
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        jPanel1.setVisible(false);
        f.setVisible(true);
        f.getjLabel3().setText(jButton11.getText());
        f.llenarpresu(jButton11.getText());
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Clientes cl = (Clientes)helper.obtenerObjeto(Clientes.class, 245);
            List<Instalacion>lt = helper.getlistaInstPresupuesto(cl,mes + anio);
            String[] depas= {"DPT. ADMINISTRATIVO","DPT. SISTEMAS","DPT. FINANCIERO","DPT. PYL","DPT. RRHH","DPT. SEGURIDAD ELEC.","DPT. COMERCIAL","DPT. SEGURIDAD FIS.","DPT. MARKETING","OFICINAS"};
            if(lt==null){
                for(int i=0; i< depas.length;i++){
                    Instalacion in = new Instalacion();
                    in.setDetalle(depas[i]+ " "+mes+" "+anio);
                    in.setClientes(cl);
                    in.setFecha(Funcion.DateFormat(rightNow.getTime()));
                    in.setProceso("Cancelado");
                    in.setTipo("Presupuesto");
                    helper.crearOrActualizarObjeto(in);
                }
            }
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Presupuesto del Mes Agregado");
        }catch(Exception io){
        
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered

    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited

    }//GEN-LAST:event_jLabel22MouseExited
            
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
