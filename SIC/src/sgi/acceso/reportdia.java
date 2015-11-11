/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.acceso;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import sgi.servicio.Funcion;
import sgi.tablas.RPall;

/**
 *
 * @author Angelmath
 */
public final class reportdia extends javax.swing.JDialog {
    /**
     * Creates new form ingresoU
     * @param parent
     * @param modal
     * @param h1
     */
    RPall in;
    DefaultTableModel base;
    Calendar ini;
    Calendar fin;
    int sortColumn;
    boolean report=false;
    int[] row;
    public reportdia(java.awt.Frame parent, boolean modal, RPall in) {
        super(parent, modal);
        initComponents();
        setSize(610, 240);
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        this.in=in;
        jTimeButton1.addPropertyChangeListener(this::timeOnlyPopupChanged);
        jTimeButton2.addPropertyChangeListener(this::timeOnlyPopupChanged2);
        
        setVisible(true);
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }
    
    private void timeOnlyPopupChanged(java.beans.PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof Date){
            Calendar calen = Calendar.getInstance();
            calen.setTime((Date)evt.getNewValue());
            calen.set(Calendar.SECOND, 0);
            c6.setText(Funcion.horain(calen.getTime()).replace(":", ","));
        }
    }
    
    private void timeOnlyPopupChanged2(java.beans.PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof Date){
            Calendar calen = Calendar.getInstance();
            calen.setTime((Date)evt.getNewValue());
            calen.set(Calendar.SECOND, 0);
            c4.setText(Funcion.horain(calen.getTime()).replace(":", ","));
        }
    }
    
    public void tablasmodelos(final JTable pane, final JPanel panel){
        
        JTableHeader jtableHeader = pane.getTableHeader();
        
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        
        pane.setTableHeader(  jtableHeader );
        
        jtableHeader.addMouseListener(new MouseAdapter() {
            
            
            
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                base = (DefaultTableModel)pane.getModel();
                
                sortColumn = pane.getSelectedColumn();
                
                
                
                int size = base.getRowCount();
                
                row = new int[size];
                
                for (int i = 0; i < size; i++) {
                    
                    row[i] = i;
                    
                }
                
                for (int i = 1; i < row.length; i++) {
                    int j = i;
                    while (j > 0 && compare(j - 1, j) > 0) {
                        int temp = row[j];
                        row[j] = row[j - 1];
                        row[j - 1] = temp;
                        j--;
                    }
                }
                ArrayList cd = new ArrayList();
                for (int i = 0; i < row.length; i++) {
                    cd.add(((Vector) base.getDataVector().elementAt(row[i])));
                }
                
                while(base.getRowCount()!=0){
                    base.removeRow(0);
                }
                for (int i = 0; i < row.length; i++) {
                    base.addRow(((Vector)cd.get(i)).toArray());
                }
                pane.setModel(base);
                pane.repaint();
                panel.validate();
                panel.repaint();
                getContentPane().repaint();
            }
        });
        
    }

    protected int compare(int i, int j) {
        
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        
        return s1.compareTo(s2);
        
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    
    public void alt (Component bt, String text){
        jLabel9.setVisible(true);
        jLabel9.setText(text);
        jLabel9.setSize((int)jLabel9.getMinimumSize().getWidth(), 25);
        jLabel9.setLocation(bt.getX()+bt.getWidth(), bt.getY()-25);
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
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        c6 = new javax.swing.JTextField();
        jTimeButton1 = new org.jbundle.thin.base.screen.jcalendarbutton.JTimeButton();
        jTimeButton2 = new org.jbundle.thin.base.screen.jcalendarbutton.JTimeButton();
        c4 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso");
        setMinimumSize(new java.awt.Dimension(610, 240));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(null);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabel9.setText("jLabel8");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(214, 214, 214), new java.awt.Color(214, 214, 214), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 70, 25);
        jLabel9.setVisible(false);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EDITAR Patrulla / Relevo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 20, 330, 30);

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel4.setText("INICIO:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 80, 140, 30);

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jLabel5.setText("FIN:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 110, 140, 30);

        jButton6.setText("Cerrar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(340, 180, 140, 40);

        c6.setText("00,00,00");
        jPanel1.add(c6);
        c6.setBounds(180, 80, 120, 30);
        jPanel1.add(jTimeButton1);
        jTimeButton1.setBounds(310, 80, 40, 30);
        jPanel1.add(jTimeButton2);
        jTimeButton2.setBounds(310, 110, 40, 30);

        c4.setText("23,59,00");
        c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4ActionPerformed(evt);
            }
        });
        jPanel1.add(c4);
        c4.setBounds(180, 110, 120, 30);
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(370, 110, 150, 30);
        jPanel1.add(jDateChooser3);
        jDateChooser3.setBounds(370, 80, 150, 30);

        jButton7.setText("Generar");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(150, 180, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 610, 240);

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public boolean vacio(){
        return false;
    }
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        dispose();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        if(!c4.getText().isEmpty()&&!c6.getText().isEmpty()&&(jDateChooser2.getDate()!=null)&&(jDateChooser3.getDate()!=null)){
            
            fin = Calendar.getInstance();
            fin.setTime(jDateChooser2.getDate());
            fin.set(Calendar.HOUR_OF_DAY, Integer.parseInt(c4.getText().split(",")[0]));
            fin.set(Calendar.MINUTE, Integer.parseInt(c4.getText().split(",")[1]));
            fin.set(Calendar.SECOND, Integer.parseInt(c4.getText().split(",")[2]));
            
            ini = Calendar.getInstance();
            ini.setTime(jDateChooser3.getDate());
            ini.set(Calendar.HOUR_OF_DAY, Integer.parseInt(c6.getText().split(",")[0]));
            ini.set(Calendar.MINUTE, Integer.parseInt(c6.getText().split(",")[1]));
            ini.set(Calendar.SECOND, Integer.parseInt(c6.getText().split(",")[2]));
            
            System.out.println(Funcion.DateTimeToString4(fin.getTime()));
            System.out.println(Funcion.DateTimeToString4(ini.getTime()));
            report=true;
            dispose();
        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c4ActionPerformed

    public Calendar getIni() {
        return ini;
    }

    public void setIni(Calendar ini) {
        this.ini = ini;
    }

    public Calendar getFin() {
        return fin;
    }

    public void setFin(Calendar fin) {
        this.fin = fin;
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
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException io){}
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            reportdia dialog = new reportdia(new javax.swing.JFrame(), true,null);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    public class MyScrollbarUI extends BasicScrollBarUI {
        
        
        
        private java.awt.Image imageThumb, imageTrack;
        
        private JButton b = new JButton() {
            
            
            
            @Override
            
            public Dimension getPreferredSize() {
                
                return new Dimension(0, 0);
                
            }
            
            
            
        };
        
        
        
        MyScrollbarUI() {
            
            imageThumb = FauxImage.create(32, 32, new Color(212,208,200));
            
            imageTrack = FauxImage.create(32, 32, Color.GRAY);
            
        }
        
        
        
        @Override
        
        protected void paintThumb(Graphics g, JComponent c, java.awt.Rectangle r) {
            
            g.setColor(Color.blue);
            
            ((Graphics2D) g).drawImage(imageThumb,
                    
                    r.x, r.y, r.width, r.height, null);
            
        }
        
        
        
        @Override
        
        protected void paintTrack(Graphics g, JComponent c, java.awt.Rectangle r) {
            
            ((Graphics2D) g).drawImage(imageTrack,
                    
                    r.x, r.y, r.width, r.height, null);
            
        }
        
        @Override
        
        protected JButton createDecreaseButton(int orientation) {
            
            return b;
            
        }
        
        @Override
        
        protected JButton createIncreaseButton(int orientation) {
            
            return b;
            
        }
        
    }
    
    
    
    private static class FauxImage {
        
        
        
        static public java.awt.Image create(int w, int h, Color c) {
            
            BufferedImage bi = new BufferedImage(
                    
                    w, h, BufferedImage.TYPE_INT_ARGB);
            
            Graphics2D g2d = bi.createGraphics();
            
            g2d.setPaint(c);
            
            g2d.fillRect(0, 0, w, h);
            
            g2d.dispose();
            
            return bi;
            
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField c4;
    private javax.swing.JTextField c6;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private org.jbundle.thin.base.screen.jcalendarbutton.JTimeButton jTimeButton1;
    private org.jbundle.thin.base.screen.jcalendarbutton.JTimeButton jTimeButton2;
    // End of variables declaration//GEN-END:variables
}
