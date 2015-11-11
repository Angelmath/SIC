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
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import monitoreo.servicio.Funcion;
/**
 *
 * @author Matheus
 */
public final class calendarioceldas extends javax.swing.JPanel {
    Calendar calFin;
    int numero;
    int num=0;
    int xx;
    int yy;
    int sortColumn;
    int alto=0;
    int ancho=0;
    calendarpanel cp;
    boolean trampa=true;
    Login log;
    JPanel capa;
    JPanel contenedores;
    ArrayList<Integer> fechann;
    Calendar calFin2;
    calendarpanel ca;
    List<Caldepartamento> listdepa;
    List<Calpermisos> listpermi;
    List<Calendario> listcalen;
    /**
     * Creates new form calendarioceldas
     * @param mes
     * @param anio
     * @param d
     * @param jPanel7
     * @param log
     * @param capa
     * @param contenedores
     * @param listpermi
     * @param ca
     * @param fechann
     * @param listdepa
     * @param visiblecapa
     */
    public calendarioceldas(int mes,int anio, Dimension d, JPanel jPanel7, Login log, JPanel capa, JPanel contenedores,ArrayList<Integer> fechann,calendarpanel ca, List<Caldepartamento> listdepa, List<Calpermisos> listpermi, String visiblecapa) {
        initComponents();
        setSize(d);
        this.log=log;
        this.capa=capa;
        this.contenedores=contenedores;
        this.fechann=fechann;
        this.ca=ca;
        this.listdepa=listdepa;
        this.listpermi= listpermi;
        GregorianCalendar c = new GregorianCalendar();
        ca.setListpermi(listpermi);
        Date date = new Date();
	c.setTime(date);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mesactual = c.get(Calendar.MONTH); 
        int anioactual= c.get(Calendar.YEAR);
        
	calFin2 = new GregorianCalendar(anio,mes,dia);
        int diasemana= calFin2.get(Calendar.DAY_OF_WEEK)-1;
        int anchodia= d.width/7;
        for(int i=0;i<jPanel7.getComponentCount();i++){
            ((JLabel)jPanel7.getComponent(i)).setSize(anchodia, 40);
            ((JLabel)jPanel7.getComponent(i)).setLocation(i*anchodia, 0);
            ((JLabel)jPanel7.getComponent(i)).setOpaque(true);
            ((JLabel)jPanel7.getComponent(i)).setBackground(new Color(240,240,240));
            if(diasemana==i){
                ((JLabel)jPanel7.getComponent(i)).setBackground(new Color(200,200,200));
                
            }
        }
        
        calFin = new GregorianCalendar(anio,mes,1);
        
        num= calFin.getActualMaximum(Calendar.DAY_OF_MONTH);
        int altocelda=0;
        int anchocelda=d.width/7;
        int minimo= calFin.get(Calendar.DAY_OF_WEEK)-1; 
        float temp1= num + minimo;
        temp1= temp1/7;
        int rows= 1+((int)Math.ceil(temp1));
        if(minimo!=6){
            altocelda= d.height/rows;
        }else{
            altocelda= d.height/(rows-1);
        }
        if(minimo!=6){
            for(int i=0; i<=minimo; i++){
                final javax.swing.JLabel j = new javax.swing.JLabel();
                j.setBounds(i*anchocelda, 0, anchocelda, altocelda);
                add(j);
            }
        }
        int y=0;
        int x=minimo;
        int brinco=0;
        int condi=0;
        
        Calendar actual = new GregorianCalendar(anioactual,mesactual,dia);
        
        ServiceHb helper = new ServiceHb();
        helper.iniciarTransaccion();
        Calendar fecha1 =new GregorianCalendar(anio,mes,1);
        Calendar fecha2 =new GregorianCalendar(anio,mes,fecha1.getActualMaximum(Calendar.DAY_OF_MONTH));
        String[] vss=visiblecapa.split(",");
        if(visiblecapa.contains(log.getDepartamento())){
            listcalen= helper.getCalendario(fecha1.getTime(),fecha2.getTime(),log.getNombre(),log.getDepartamento());
        }else{
            listcalen= helper.getCalendario(fecha1.getTime(),fecha2.getTime(),log.getNombre(),log.getDepartamento(),log.getId());
        }
        
        if(listcalen!=null){
            for(int i=listcalen.size()-1; i>0;i--){
                if(!vss[0].equalsIgnoreCase("")){
                    for(String z: vss){
                        if((listcalen.get(i).getLogin().getDepartamento().indexOf(z))!=-1){
                            listcalen.remove(i);
                            break;
                        }
                    }
                }
            }
        }
        try{
            for(int i=0+minimo; i<(num+minimo); i++){
                JPanel pane = new JPanel();
                if((i%7)==0){
                    if(i!=0)    {
                        y++;
                        x=0;
                    }
                }
                pane.setBounds(x*anchocelda, y*altocelda, anchocelda,altocelda);
                x++;

                pane.setOpaque(false);
                //pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(103, 103, 103)));
                pane.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 203, 203), 1, true), null));
                pane.setLayout(null);
                final int text=i+1-minimo;
                final ImageIcon icon ;
                String trampimg="";
                boolean visor=false;
                //Condicion para tipo de circulo
                
                Calendar calval =new GregorianCalendar(anio,mes,text);
                if(actual.after(calval)){
                    if(contiene(calval)){
                        visor=true;
                        trampimg = "calendario-circulo-green-1";
                        JPanel titulo = new JPanel();
                        titulo.setBounds(45, 3, anchocelda-45, altocelda-17);
                        titulo.setLayout(null);
                        titulo.setOpaque(false);
                        int cx=5;
                        int cy=0;
                        for(Calendario z: listcalen){    
                            if(Funcion.DateFormatSql(z.getFechaini()).equalsIgnoreCase(Funcion.DateFormatSql(calval.getTime()))){
                                JLabel lab = new JLabel("- " + z.getTitulo());
                                lab.setBounds(cx, cy, 80, 15);
                                lab.setFont(new java.awt.Font("Roboto Medium", 0, 10));
                                String[] color = z.getCaldepartamento().getColor().split(",");
                                lab.setForeground(new Color(Integer.parseInt(color[0]),Integer.parseInt(color[1]),Integer.parseInt(color[2])));
                                titulo.add(lab);
                                cy=cy+15;
                            }
                        }
                        pane.add(titulo);
                    }
                }
                if(actual.equals(calval)){
                    
                        trampimg = "calendario-circulo-blue";
                        JPanel titulo = new JPanel();
                        titulo.setBounds(45, 3, anchocelda-45, altocelda-17);
                        titulo.setLayout(null);
                        titulo.setOpaque(false);
                        int cx=5;
                        int cy=0;
                        if(contiene(calval)){
                            visor=true;
                            for(Calendario z: listcalen){
                                if(Funcion.DateFormatSql(z.getFechaini()).equalsIgnoreCase(Funcion.DateFormatSql(calval.getTime()))){
                                    JLabel lab = new JLabel("- " + z.getTitulo());
                                    lab.setBounds(cx, cy, 80, 15);
                                    lab.setFont(new java.awt.Font("Roboto Medium", 0, 10));
                                    String[] color = z.getCaldepartamento().getColor().split(",");
                                    lab.setForeground(new Color(Integer.parseInt(color[0]),Integer.parseInt(color[1]),Integer.parseInt(color[2])));
                                    titulo.add(lab);
                                    cy=cy+15;
                                }
                            }
                        }
                        pane.add(titulo);
                }
                if(actual.before(calval)){
                    if(contiene(calval)){
                        visor=true;
                        trampimg= "calendario-circulo-green";
                        JPanel titulo = new JPanel();
                        titulo.setBounds(45, 3, anchocelda-45, altocelda-17);
                        titulo.setLayout(null);
                        titulo.setOpaque(false);
                        int cx=5;
                        int cy=0;
                        for(Calendario z: listcalen){
                            if(Funcion.DateFormatSql(z.getFechaini()).equalsIgnoreCase(Funcion.DateFormatSql(calval.getTime()))){
                                JLabel lab = new JLabel("- " + z.getTitulo());
                                lab.setFont(new java.awt.Font("Roboto Medium", 0, 10));
                                lab.setBounds(cx, cy, 80, 15);
                                String[] color = z.getCaldepartamento().getColor().split(",");
                                lab.setForeground(new Color(Integer.parseInt(color[0]),Integer.parseInt(color[1]),Integer.parseInt(color[2])));
                                titulo.add(lab);
                                cy=cy+15;
                            }
                        }
                        pane.add(titulo);
                    }
                }
                final javax.swing.JLabel j;
                if(trampimg.equalsIgnoreCase("")){
                    j= new javax.swing.JLabel() {
                      @Override
                      public void paintComponent(Graphics g) {
                        g.drawImage(null, 0, 0, null);
                        super.paintComponent(g);
                      }
                    };
                    
                }else{
                    icon = new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/"+trampimg+".png")); // NOI18N
                    j= new javax.swing.JLabel() {
                      @Override
                      public void paintComponent(Graphics g) {
                        g.drawImage(icon.getImage(), 0, 0, null);
                        super.paintComponent(g);
                      }
                    };
                }
                j.setBounds(5, 5, 41, 41);
                j.setFont(new java.awt.Font("Roboto Thin", 1, 15)); // NOI18N
                j.setText(Integer.toString(i+1-minimo));
                if(trampimg.equalsIgnoreCase("")){
                j.setForeground(Color.black);
                }else{
                j.setForeground(Color.white);
                }
                j.setHorizontalAlignment(0);
                pane.add(j);
                int fy= pane.getHeight()-3-14;
                int tx = pane.getWidth()-3;
                if(!actual.after(calval)){
                    if(false){
                    final javax.swing.JLabel agre= new javax.swing.JLabel();
                    agre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-edit-icon-lightgray.png"))); // NOI18N
                    agre.setBounds(tx-47-6, fy, 13, 13);
                    agre.addMouseListener(new MouseAdapter() { 
                        @Override
                        public void mousePressed(MouseEvent me) { 
                            calFin2 =new GregorianCalendar(getCalFin2().get(Calendar.YEAR),getCalFin2().get(Calendar.MONTH),text);
                            calendarnew cnew = new calendarnew(null, null, true,getLog(),getListdepa(),calFin2,getListpermi());
                        }
                        @Override
                        public void mouseEntered(MouseEvent me) { 
                            agre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-edit-icon-lightblue.png"))); // NOI18N
                        }
                        @Override
                        public void mouseExited(MouseEvent me) { 
                            agre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-edit-icon-lightgray.png"))); // NOI18N
                        }
                    });
                    pane.add(agre);
                    }
                }
                if(visor){
                    final javax.swing.JLabel agre2= new javax.swing.JLabel();
                    agre2.setBounds(tx-34-3, fy, 20, 13);
                    agre2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-eye-icon-lightgray.png"))); // NOI18N
                    agre2.addMouseListener(new MouseAdapter() { 
                        @Override
                        public void mousePressed(MouseEvent me) { 
                            //calendarioevento cal = new calendarioevento(null, true, getLog());
                            String[] dias= {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
                            String[] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
                            calFin2 =new GregorianCalendar(getCalFin2().get(Calendar.YEAR),getCalFin2().get(Calendar.MONTH),text);
                            getCa().getjLabel2().setText(dias[getCalFin2().get(Calendar.DAY_OF_WEEK)-1]+" "+text+" de "+ meses[getCalFin2().get(Calendar.MONTH)]+" de "+ getCalFin2().get(Calendar.YEAR));
                            getCa().setFecha(new GregorianCalendar(getCalFin2().get(Calendar.YEAR),getCalFin2().get(Calendar.MONTH),text));
                            getCa().actualizartiempo();
                            getCapa().setVisible(true);
                            getContenedores().setVisible(false);
                        }
                        @Override
                        public void mouseEntered(MouseEvent me) { 
                            agre2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-eye-icon-lightblue.png"))); // NOI18N
                        }
                        @Override
                        public void mouseExited(MouseEvent me) { 
                            agre2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-eye-icon-lightgray.png"))); // NOI18N
                        }
                    });
                    pane.add(agre2);
                }
                if(!actual.after(calval)){
                        final javax.swing.JLabel agre3= new javax.swing.JLabel();
                        //agre3.setBounds(tx-47-6, fy, 13, 13);
                        agre3.setBounds(tx-14, fy, 14, 14);
                        agre3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-add-icon-lightgray.png"))); // NOI18N
                        agre3.addMouseListener(new MouseAdapter() { 
                            @Override
                            public void mousePressed(MouseEvent me) { 
                                calFin2 =new GregorianCalendar(getCalFin2().get(Calendar.YEAR),getCalFin2().get(Calendar.MONTH),text);
                                calendarnew cnew = new calendarnew(null, null, true,getLog(), getListdepa(),calFin2,getListpermi());
                            }
                            @Override
                            public void mouseEntered(MouseEvent me) { 
                                agre3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-add-icon-lightblue.png"))); // NOI18N
                            }
                            @Override
                            public void mouseExited(MouseEvent me) { 
                                agre3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/calendario-add-icon-lightgray.png"))); // NOI18N
                            }
                        });
                        pane.add(agre3);
                }
                add(pane);

            }
        helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
        setVisible(true);
    }
    public boolean contiene(Calendar cld){
        if(listcalen!=null){
            for(Calendario i: listcalen){
                if(Funcion.DateFormatSql(i.getFechaini()).equalsIgnoreCase(Funcion.DateFormatSql(cld.getTime()))){
                    return true;
                }
            }
        }
        return false;
    }
    
    public Calendar getCalFin() {
        return calFin;
    }

    public void setCalFin(Calendar calFin) {
        this.calFin = calFin;
    }

    public int getNumero() {
        return numero;
    }

    public JPanel getCapa() {
        return capa;
    }

    public void setCapa(JPanel capa) {
        this.capa = capa;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public List<Caldepartamento> getListdepa() {
        return listdepa;
    }

    public void setListdepa(List<Caldepartamento> listdepa) {
        this.listdepa = listdepa;
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

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public calendarpanel getCp() {
        return cp;
    }

    public void setCp(calendarpanel cp) {
        this.cp = cp;
    }

    public Calendar getCalFin2() {
        return calFin2;
    }

    public void setCalFin2(Calendar calFin2) {
        this.calFin2 = calFin2;
    }

    public boolean isTrampa() {
        return trampa;
    }

    public JPanel getContenedores() {
        return contenedores;
    }

    public void setContenedores(JPanel contenedores) {
        this.contenedores = contenedores;
    }

    public void setTrampa(boolean trampa) {
        this.trampa = trampa;
    }

    public ArrayList<Integer> getFechann() {
        return fechann;
    }

    public void setFechann(ArrayList<Integer> fechann) {
        this.fechann = fechann;
    }
    
    public void mostrar(String texto){
        trampa=false;
        cp.setVisible(true);
        cp.getjLabel2().setText("Dia: " + texto);
        cp.repaint();
    }

    public calendarpanel getCa() {
        return ca;
    }

    public void setCa(calendarpanel ca) {
        this.ca = ca;
    }

    public Login getLog() {
        return log;
    }

    public List<Calpermisos> getListpermi() {
        return listpermi;
    }

    public void setListpermi(List<Calpermisos> listpermi) {
        this.listpermi = listpermi;
    }

    public void setLog(Login log) {
        this.log = log;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
