/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import static Login.ventas.marco.reiniciarJTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.Empleado;
import rrhh.servicio.Funcion;

/**
 *
 * @author Matheus
 */
public class Fvinculoslaboral extends javax.swing.JDialog {
    List<Empleado> lista;
    List<Departamento> depa;
    int selected;
    String v1="";
    String v2="";
    String departamentoo="";
    int breakhilo=0;
    DefaultTableModel base;
    DecimalFormat df = new DecimalFormat("#.##");
    int xx;
    int yy;
    int sortColumn;
    int[] row;
    /**
     * Creates new form calendariovinculos
     */
    public Fvinculoslaboral(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(790,345);
        jTable1.getColumn("Agregar").setCellRenderer(new ButtonRenderer());
        setPreferredSize(new Dimension(640,307));
        dispose();
        setUndecorated(true);
        setLocationRelativeTo(null);
        tablasmodelos(jTable1,jPanel1);
        JScrollBar sb = jScrollPane1.getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        jTable1.getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        jTable1.getColumn("Agregar").setCellRenderer(new ButtonRenderer());
        
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            depa = helper.getdepartamentosByTipo2();
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        for(Departamento j: depa){
            jComboBox1.addItem(j.getNombre());
        }
        jComboBox1.addItem("Inactivo");
        jComboBox1.addActionListener(new java.awt.event.ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTablas up = new updateTablas(1);
                up.start();
            }
        });
        TableColumn sportColumn = jTable1.getColumnModel().getColumn(7);
        JCheckBox comboBox = new JCheckBox();
        comboBox.setSelected(true);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        sportColumn.setCellRenderer(new CellRenderer("check"));
        setVisible(true);
    }
    public void llenar(){
        try{
            rrhh.servicio.ServiceHb helper = new rrhh.servicio.ServiceHb();
            helper.iniciarTransaccion();
            lista= helper.getPersonasByTipotext2(jComboBox1.getSelectedItem().toString(),jTextField1.getText());
            reiniciarJTable(jTable1);    
            if(lista!=null){
                System.out.println("total=sueldo+suple+decimo3+decimo4+vacaciones+fondo+patronal");
                for(Empleado i: lista){
                    if(i.getDepartamento()!=null){
                        String c= ""+i.getCi();
                        String c1=i.getNombre1()+" "+i.getNombre2();
                        String c2=i.getApellido1()+" "+i.getApellido2();
                        String c3=i.getDeptEmpl().getDepartamento().getNombre();
                        String c4=i.getPerfilpuesto();
                        double total=0;
                        Calendar cd = Calendar.getInstance();                        
                        if(!i.getDato1().isEmpty()){
                            double sueldo= Double.parseDouble(i.getDato1());
                            double suple= Double.parseDouble(i.getDato3());
                            double decimo3= (sueldo+suple)/12;
                            double decimo4= 354/12;
                            double vacaciones= (sueldo+suple)/24;
                            double patronal= ((sueldo)*11.15)/100;
                            double fondo=0;
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                            int diferenciames= diferenciaFechas(Funcion.DateFormat(cd.getTime()),Funcion.DateFormat(i.getFechaIngreso()),1);
                            int dif= diferenciames-365-31;
                            if(dif>0){
                                double extra = Float.parseFloat(i.getDato4());
                                fondo = (float)((sueldo+extra)*8.33)/100;
                            }
                            System.out.println(c1+" "+(sueldo+suple)+" "+decimo3+" "+decimo4+" "+vacaciones+" "+fondo+" "+patronal);
                            total=sueldo+suple+decimo3+decimo4+vacaciones+fondo+patronal;
                            total=total/22;
                        }
                        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                        Object nuevo[]= {i.getCid(),c1,c2,c3,c4,df.format(total).replace(",", "."),c,false};
                        temp.addRow(nuevo);
                    }
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public int diferenciaFechas(String fec1, String fec2,int valor){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        int retorno=0;
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        try
        {
            Calendar cal1 = null;
            date1=df.parse(fec1);
            cal1=Calendar.getInstance();
            
            Calendar cal2 = null;
            date2=df.parse(fec2);
            cal2=Calendar.getInstance();
            
            // different date might have different offset
            cal1.setTime(date1);
            long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET);
            
            cal2.setTime(date2);
            long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET);
            
            // Use integer calculation, truncate the decimals
            int hr1 = (int)(ldate1/3600000); //60*60*1000
            int hr2 = (int)(ldate2/3600000);
            
            int days1 = (int)hr1/24;
            int days2 = (int)hr2/24;
            
            int dateDiff = days2 - days1;
            int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
            int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
            
            if(valor==1) {
                if (dateDiff<0) dateDiff=dateDiff*(-1);
                retorno=dateDiff;
            }else if(valor==2){
                if (monthDiff<0) monthDiff=monthDiff*(-1);
                retorno=monthDiff;
            }else if(valor==3){
                if (yearDiff<0) yearDiff=yearDiff*(-1);
                retorno=yearDiff;
            }
        }
        catch (Exception pe)
        {
        }
        return retorno;
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
    
    public class updateTablas extends Thread {
        int turno;
        public updateTablas(int turno){
            this.turno=turno;
        }
        
        @Override
        public void run() {
            breakhilo=1;
            try{
                sleep(800);
                breakhilo=0;
            }catch(Exception io){
            }
            
            if(turno==1){
                llenar();
            }
            if(turno==2){
                //llenarfinan();
            }
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jScrollPane1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellidos", "Departamento", "Cargo", "Valor Dia", "Agregar", "Select"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setMinWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(6).setMinWidth(60);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(7).setMinWidth(60);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 30, 790, 240);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(0, 0, 400, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(400, 0, 390, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 790, 270);

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALIR");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 310, 790, 40);

        jPanel2.setLayout(null);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 Dia", "1/2 Dia", "1/3 Dia", "1/4 Dia" }));
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(300, 0, 210, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 270, 790, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if(col==7){
            Boolean b = (Boolean)jTable1.getValueAt(row, col);
            jTable1.setValueAt(!b, row, col);
        }
        if(col==6){
            int tam = jTable1.getRowCount();
            double v=0;
            for(int i=0; i< tam ; i++){
                String valor= jTable1.getValueAt(i, 5).toString();
                String nom=  jTable1.getValueAt(i, 1).toString() +" "+jTable1.getValueAt(i, 2).toString();
                String ci=  jTable1.getValueAt(i, 0).toString();
                if ((Boolean)jTable1.getValueAt(i,7) && jTable1.isEnabled()){
                    double va= Double.parseDouble(valor);
                    if(jComboBox2.getSelectedIndex()==0){

                    }
                    if(jComboBox2.getSelectedIndex()==1){
                        va= va/2;
                    }
                    if(jComboBox2.getSelectedIndex()==2){
                        va= va/3;
                    }
                    if(jComboBox2.getSelectedIndex()==3){
                        va= va/4;
                    }   
                    v=v+va;
                    v2= v2+ " "+nom+" ci:"+ci;
                }
            }
            v1=df.format(v).replace(",", ".");
            dispose();
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        v1="";
        v2="";
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        updateTablas up = new updateTablas(1);
        up.start();
    }//GEN-LAST:event_jTextField1KeyTyped

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }


    public List<Empleado> getLista() {
        return lista;
    }

    public void setLista(List<Empleado> lista) {
        this.lista = lista;
    }

    public List<Departamento> getDepa() {
        return depa;
    }

    public void setDepa(List<Departamento> depa) {
        this.depa = depa;
    }

    public String getDepartamentoo() {
        return departamentoo;
    }

    public void setDepartamentoo(String departamentoo) {
        this.departamentoo = departamentoo;
    }

    public int getBreakhilo() {
        return breakhilo;
    }

    public void setBreakhilo(int breakhilo) {
        this.breakhilo = breakhilo;
    }

    public DefaultTableModel getBase() {
        return base;
    }

    public void setBase(DefaultTableModel base) {
        this.base = base;
    }

    public int getXx() {
        return xx;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public int getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(int sortColumn) {
        this.sortColumn = sortColumn;
    }

    public int[] getRow() {
        return row;
    }

    public void setRow(int[] row) {
        this.row = row;
    }

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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
            java.util.logging.Logger.getLogger(Fvinculoslaboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fvinculoslaboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fvinculoslaboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fvinculoslaboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fvinculoslaboral dialog = new Fvinculoslaboral(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
