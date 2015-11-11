/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.ventas;

import Login.Entidad.Caldepartamento;
import Login.Entidad.Calendario;
import Login.Entidad.Calpermisos;
import Login.Entidad.Login;
import Login.servicio.ServiceHb;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public final class calendarpanel extends javax.swing.JPanel {
    Login usuario;
    DefaultTableModel base;
    int sortColumn;
    int[] row;
    JDialog d;
    Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
    Calendar fecha;
    List<Caldepartamento> listdepa;
    List<Calpermisos> listpermi;
    List<Calendario> listaeventos;
    calendario calend;
    /**
     * Creates new form calendarpanel2
     */
    public calendarpanel(final Login log, int alto) {
        initComponents();
        this.d=d;
        this.usuario=log;
        setSize(di.width, alto);
        jLabel3.setSize(di.width, alto);
        jPanel1.setSize(di.width, jPanel1.getHeight());
        jPanel2.setSize(di.width, alto-36-20);    
        
        actualizartiempo();
        setVisible(true);
    }
    
    public void actualizarcalendario(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            listaeventos = helper.getCalendario(fecha.getTime(), usuario);
            helper.cerrarSesion();
            }catch(Exception io){
        }
    }
    
    public void actualizartiempo(){
        jPanel2.removeAll();
        try{
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        listaeventos = helper.getCalendario(fecha.getTime(), usuario);
           
        JPanel pane = new JPanel();
        pane.setLayout(null);
        JScrollPane scroll = new JScrollPane();
        scroll.setSize(jPanel2.getWidth(), jPanel2.getHeight()-20);
        String[] horas={"05:00","05:30","06:00","06:30","07:00","07:30", "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30"};
        int x=0;
        int y=0;
        int posx=0;
        final JLabel le = new JLabel();
        le.setText("Evento");
        le.setBounds(0, 0, 200, 35);
        le.setOpaque(false);
        le.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        le.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le.setFont(new java.awt.Font("Roboto Light", 1, 15)); // NOI18N
        le.setForeground(new java.awt.Color(167, 167, 167));
        pane.add(le);
        pane.setSize(200, 35);
        pane.setPreferredSize(new Dimension(200, 35));
        scroll.setViewportView(pane);
        for(String i: horas){
            final JLabel l = new JLabel();
            l.setText(i);
            final String texto= i;
            l.setBounds(200+(posx*60), 0, 60, 35);
            l.setOpaque(false);
            l.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
            l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            l.setFont(new java.awt.Font("Roboto Light", 2, 13)); // NOI18N
            l.setForeground(new java.awt.Color(207, 207, 207));
            pane.add(l);
            pane.setSize(200+(posx*60), 35);
            pane.setPreferredSize(new Dimension(200+(posx*60), 35));
            scroll.setViewportView(pane);
            posx++;
        }
        final JLabel ls = new JLabel();
        ls.setBounds(0, 35, 200, jPanel2.getHeight()-20-35);
        ls.setOpaque(false);
        ls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
        ls.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pane.add(ls);
        pane.setSize(200+(0*60), 35);
        pane.setPreferredSize(new Dimension(200+(0*60), 35));
        scroll.setViewportView(pane);
        for(int col=1; col<posx;col++){
            final JLabel l = new JLabel();
            l.setBounds(200+(col*60), 35, 60, jPanel2.getHeight()-20-35);
            l.setOpaque(false);
            l.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
            l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            pane.add(l);
            pane.setSize(200+(col*60), 35);
            pane.setPreferredSize(new Dimension(200+(col*60), 35));
            scroll.setViewportView(pane);
        }
            if(listaeventos!=null){
                for(Calendario z: listaeventos){
                    java.sql.Date d1 = new java.sql.Date(fecha.getTime().getTime());
                    final JLabel l2 = new JLabel();
                    final Calendario calz= z;
                    l2.setText("  "+z.getTitulo());
                    final String texto=z.getTitulo();
                    String[] color= z.getCaldepartamento().getColor().split(",");
                    l2.setForeground(new Color(Integer.parseInt(color[0]),Integer.parseInt(color[1]),Integer.parseInt(color[2])));
                    l2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
                    l2.setBounds(0, 35+(y*60), 200, 60);
                    l2.setOpaque(false);
                    l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
                    final calendarpanel cale= this;
                    l2.addMouseListener(new MouseAdapter() { 
                        @Override
                        public void mousePressed(MouseEvent me) { 
                            calendarnew cnew = new calendarnew(null, cale, true,usuario,listdepa,fecha,listpermi,texto,calz);
                        }
                    }); 
                    pane.add(l2);
                    
                    final JLabel l3 = new JLabel();
                    l3.setBounds(200, 35+(y*60), posx*60, 60);
                    l3.setOpaque(false);
                    l3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 237, 237)));
                    
                    pane.add(l3);
                    int emp=0;
                    int ini=0;
                    int fin=0;
                    for(String ti: horas){
                        emp++;
                        if(ti.equalsIgnoreCase(z.getHour())){
                            ini=emp;
                        }
                        if(ti.equalsIgnoreCase(z.getAllhour())){
                            fin=emp;
                        }
                    }
                    final JLabel l4 = new JLabel();
                    l4.setBounds(200+(ini*60), 35+(y*60), (((fin-ini)*60)), 60);
                    l4.setBackground(new Color(Integer.parseInt(color[0]),Integer.parseInt(color[1]),Integer.parseInt(color[2])));
                    l4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(Integer.parseInt(color[0]),Integer.parseInt(color[1]),Integer.parseInt(color[2]))));
                    l4.setOpaque(true);
                    pane.add(l4,0);
                    y++;
                }
            }
        scroll.getViewport().setOpaque(false);
        Border border = BorderFactory.createEmptyBorder( 0, 0, 0, 0 );
        scroll.setViewportBorder( border );
        scroll.setBorder( border );
        
        pane.setOpaque(false);
        jPanel2.add(scroll);
         helper.cerrarSesion();
        }catch(Exception io){
        }    
    }
    
    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public DefaultTableModel getBase() {
        return base;
    }

    public void setBase(DefaultTableModel base) {
        this.base = base;
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-botonback-darkblue.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 6, 24, 24);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-addevent-darkblue.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(92, 6, 24, 24);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-flecha-left-darkblue.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 6, 11, 24);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-flecha-right-darkblue.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 6, 11, 24);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 2, 14)); // NOI18N
        jLabel2.setText("Dia: ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(240, 0, 330, 36);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(65, 0, 1, 36);

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(135, 0, 1, 36);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 890, 36);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);
        add(jPanel2);
        jPanel2.setBounds(0, 36, 890, 450);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/fondo SIC 4.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 890, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        calendarnew cnew = new calendarnew(null, this, true,usuario,listdepa,fecha,listpermi);
    }//GEN-LAST:event_jLabel6MouseClicked

    public List<Calpermisos> getListpermi() {
        return listpermi;
    }

    public void setListpermi(List<Calpermisos> listpermi) {
        this.listpermi = listpermi;
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        String[] dias= {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        String[] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        fecha.add(Calendar.DAY_OF_YEAR, -1);
        jLabel2.setText(dias[fecha.get(Calendar.DAY_OF_WEEK)-1]+" "+fecha.get(Calendar.DAY_OF_MONTH)+" de "+ meses[fecha.get(Calendar.MONTH)]+" de "+ fecha.get(Calendar.YEAR));
        actualizartiempo();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String[] dias= {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        String[] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        fecha.add(Calendar.DAY_OF_YEAR, 1);
        jLabel2.setText(dias[fecha.get(Calendar.DAY_OF_WEEK)-1]+" "+fecha.get(Calendar.DAY_OF_MONTH)+" de "+ meses[fecha.get(Calendar.MONTH)]+" de "+ fecha.get(Calendar.YEAR));
        actualizartiempo();
    }//GEN-LAST:event_jLabel4MouseClicked

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

    public JDialog getD() {
        return d;
    }

    public void setD(JDialog d) {
        this.d = d;
    }

    public Dimension getDi() {
        return di;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setDi(Dimension di) {
        this.di = di;
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

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public List<Calendario> getListaeventos() {
        return listaeventos;
    }

    public void setListaeventos(List<Calendario> listaeventos) {
        this.listaeventos = listaeventos;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public List<Caldepartamento> getListdepa() {
        return listdepa;
    }

    public void setListdepa(List<Caldepartamento> listdepa) {
        this.listdepa = listdepa;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public calendario getCalend() {
        return calend;
    }

    public void setCalend(calendario calend) {
        this.calend = calend;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
