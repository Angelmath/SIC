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
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Prestamos;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class reportes2 extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    reporte_multa multa;
    reporte_prestamos prestamos;
    int turno=1;
    /**
     * Creates new form inicio
     */
    public reportes2() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        setVisible(false);
        agregarpaneles();
        visible(multa);
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

    public reporte_multa getMulta() {
        return multa;
    }

    public void setMulta(reporte_multa multa) {
        this.multa = multa;
    }

    public reporte_prestamos getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(reporte_prestamos prestamos) {
        this.prestamos = prestamos;
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
    
    public void agregarpaneles(){
        multa=new reporte_multa();
        multa.setLocation(0, 61);
        add(multa);
        prestamos=  new reporte_prestamos() ;
        prestamos.setLocation(0, 61);
        add(prestamos);
        multa.getjTable4().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        prestamos.getjTable9().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        multa.getjTable4().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            try{
                int row= multa.getjTable4().getSelectedRow();
                int col=multa.getjTable4().getSelectedColumn();
                if(col==7){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        try {
                            ServiceHb helper = new ServiceHb();
                            helper.iniciarTransaccion();
                            Multa h = (Multa)helper.obtenerObjeto(Multa.class,(Integer.parseInt(multa.getjTable4().getValueAt(row, col).toString())));
                            helper.eliminarObjeto(h);
                            helper.confirmarTransaccion();
                            helper.cerrarSesion();
                            JOptionPane.showMessageDialog(null,"Hora Extra Eliminada");
                            multa.setTemporal(false);
                            multa.llenar();
                        }catch(Exception io){

                        }
                    }
                }
            }catch(Exception io){

            }
        }
        });
        prestamos.getjTable9().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            try{
                int row= prestamos.getjTable9().getSelectedRow();
                int col=prestamos.getjTable9().getSelectedColumn();
                if(col==6){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarca")){ 
                        try {
                            ServiceHb helper = new ServiceHb();
                            helper.iniciarTransaccion();
                            Prestamos h = (Prestamos)helper.obtenerObjeto(Prestamos.class,(Integer.parseInt(prestamos.getjTable9().getValueAt(row, col).toString())));
                            helper.eliminarObjeto(h);
                            helper.confirmarTransaccion();
                            helper.cerrarSesion();
                            JOptionPane.showMessageDialog(null,"Hora Extra Eliminada");
                            prestamos.setTemporal(false);
                            prestamos.llenar();
                        }catch(Exception io){

                        }
                    }
                }
            }catch(Exception io){

            }
        }
        });
    }
    
    
    public void visible(JPanel pane){
        multa.setVisible(false);
        prestamos.setVisible(false);
        pane.setVisible(true);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);
        add(jSeparator1);
        jSeparator1.setBounds(10, 50, 1160, 10);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Multas");
        add(jLabel2);
        jLabel2.setBounds(10, 20, 160, 26);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Otros Descuentos");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel1);
        jLabel1.setBounds(320, 10, 120, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Multas");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel3);
        jLabel3.setBounds(210, 10, 90, 40);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
