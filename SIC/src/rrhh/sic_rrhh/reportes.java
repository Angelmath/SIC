/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import rrhh.Entidad.Bono;
import rrhh.Entidad.Comisiones;
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Horas;
import rrhh.Entidad.Otros;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class reportes extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    reporte_horas horas;
    reporte_bono bono;
    reporte_comisiones comi;
    reporte_otros otros;
    int turno=1;
    String nivel;
    /**
     * Creates new form inicio
     */
    public reportes(String nivel) {
        initComponents();
        if(nivel.equalsIgnoreCase("Seguridad")){
            jLabel4.setVisible(false);
            jLabel6.setVisible(false);
        }
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        setVisible(false);
        agregarpaneles();
        this.nivel=nivel;
        visible(horas);
    }

    public reporte_otros getOtros() {
        return otros;
    }

    public void setOtros(reporte_otros otros) {
        this.otros = otros;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }
    
    public void agregarpaneles(){
        horas = new reporte_horas();
        horas.setLocation(0, 61);
        add(horas);
        bono= new reporte_bono();
        bono.setLocation(0, 61);
        add(bono);
        comi= new reporte_comisiones();
        comi.setLocation(0, 61);
        add(comi);
        otros= new reporte_otros();
        otros.setLocation(0, 61);
        add(otros);
        horas.getjTable1().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        bono.getjTable7().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        comi.getjTable7().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        otros.getjTable7().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        horas.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            try{
                int row= horas.getjTable1().getSelectedRow();
                int col=horas.getjTable1().getSelectedColumn();
                if(col==7){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        try {
                            ServiceHb helper = new ServiceHb();
                            helper.iniciarTransaccion();
                            Horas h = (Horas)helper.obtenerObjeto(Horas.class,(Integer.parseInt(horas.getjTable1().getValueAt(row, col).toString())));
                            helper.eliminarObjeto(h);
                            helper.confirmarTransaccion();
                            helper.cerrarSesion();
                            JOptionPane.showMessageDialog(null,"Hora Extra Eliminada");
                            horas.setTemporal(false);
                            horas.llenar();
                        }catch(Exception io){

                        }
                    }
                }
            }catch(Exception io){

            }
        }
        });
        
        bono.getjTable7().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            try{
                int row= bono.getjTable7().getSelectedRow();
                int col=bono.getjTable7().getSelectedColumn();
                if(col==6){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        try {
                            ServiceHb helper = new ServiceHb();
                            helper.iniciarTransaccion();
                            Bono h = (Bono)helper.obtenerObjeto(Bono.class,(Integer.parseInt(bono.getjTable7().getValueAt(row, col).toString())));
                            helper.eliminarObjeto(h);
                            helper.confirmarTransaccion();
                            helper.cerrarSesion();
                            JOptionPane.showMessageDialog(null,"Hora Extra Eliminada");
                            bono.setTemporal(false);
                            bono.llenar();
                        }catch(Exception io){

                        }
                    }
                }
            }catch(Exception io){

            }
        }
        });
        
        otros.getjTable7().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            try{
                int row= otros.getjTable7().getSelectedRow();
                int col=otros.getjTable7().getSelectedColumn();
                if(col==6){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        try {
                            ServiceHb helper = new ServiceHb();
                            helper.iniciarTransaccion();
                            Otros h = (Otros)helper.obtenerObjeto(Otros.class,(Integer.parseInt(otros.getjTable7().getValueAt(row, col).toString())));
                            helper.eliminarObjeto(h);
                            helper.confirmarTransaccion();
                            helper.cerrarSesion();
                            JOptionPane.showMessageDialog(null,"Otros Eliminada");
                            otros.setTemporal(false);
                            otros.llenar();
                        }catch(Exception io){

                        }
                    }
                }
            }catch(Exception io){

            }
        }
        });
        
        comi.getjTable7().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            try{
                int row= comi.getjTable7().getSelectedRow();
                int col=comi.getjTable7().getSelectedColumn();
                if(col==6){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        try {
                            ServiceHb helper = new ServiceHb();
                            helper.iniciarTransaccion();
                            Comisiones h = (Comisiones)helper.obtenerObjeto(Comisiones.class,(Integer.parseInt(comi.getjTable7().getValueAt(row, col).toString())));
                            helper.eliminarObjeto(h);
                            helper.confirmarTransaccion();
                            helper.cerrarSesion();
                            JOptionPane.showMessageDialog(null,"Comisiones Eliminada");
                            comi.setTemporal(false);
                            comi.llenar();
                        }catch(Exception io){

                        }
                    }
                }
            }catch(Exception io){

            }
        }
        });
    }

    public reporte_comisiones getComi() {
        return comi;
    }

    public void setComi(reporte_comisiones comi) {
        this.comi = comi;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }
    
    
    public void visible(JPanel pane){
        horas.setVisible(false);
        bono.setVisible(false);
        comi.setVisible(false);
        otros.setVisible(false);
        pane.setVisible(true);
    }

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public reporte_horas getHoras() {
        return horas;
    }

    public void setHoras(reporte_horas horas) {
        this.horas = horas;
    }

    public reporte_bono getBono() {
        return bono;
    }

    public void setBono(reporte_bono bono) {
        this.bono = bono;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
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

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);
        add(jSeparator1);
        jSeparator1.setBounds(10, 50, 1160, 10);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Horas Extras");
        add(jLabel2);
        jLabel2.setBounds(10, 20, 160, 26);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Otros Ingresos");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel1);
        jLabel1.setBounds(440, 10, 120, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Horas Extra");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel3);
        jLabel3.setBounds(210, 10, 90, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Comisiones");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel4);
        jLabel4.setBounds(320, 10, 100, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Otros");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel6);
        jLabel6.setBounds(680, 10, 100, 40);
        jLabel6.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
