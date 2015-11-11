/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Permisos;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public class lista_departamentos extends javax.swing.JPanel {
    Dimension d;
    List<Empleado> list=null;
    int X=40;
    int Y=150;
    int breakhilo;
    String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    /**
     * Creates new form inicio
     */
    public lista_departamentos() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        jSeparator1.setSize(d.width-180, 3);
        jLabel4.setLocation(jSeparator1.getX()+jSeparator1.getWidth()-jLabel4.getWidth(), jLabel4.getY());
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if(jTable1.getSelectedColumn()==4){
                    String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                    if(selectedSiteName.equalsIgnoreCase("cajamarcacajamarca")){ 
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(jTable1.getValueAt(jTable1.getSelectedRow(), 4));
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        actualizar();
                        JOptionPane.showMessageDialog(null,"Eliminado");
                    }
                }
                if(jTable1.getSelectedColumn()==3){
                        ingresoU in = new ingresoU(null, true, (Departamento)jTable1.getValueAt(jTable1.getSelectedRow(), 3),jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString(),jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString(),jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                        actualizar();
                }
            } catch (Exception ex) {
                Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        setVisible(false);
    }
    
    public void empleados(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list = helper.getPersonasByTipo();
            jComboBox2.removeAllItems();
            jComboBox3.removeAllItems();
            for(Empleado i: list){
                jComboBox2.addItem(i.getNombre1()+" "+i.getNombre2()+" "+i.getApellido1()+" "+i.getApellido2());
                jComboBox3.addItem(i);
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public void imagenes(String direccion, JLabel label){
        String ex;
        String ex2;
        try{
            URL url = new URL("http://181.198.26.33"+direccion);
            URLConnection urlCon = url.openConnection();
            if (urlCon.getContentType() != null) {//Si hay formato de imagen (No estoy seguro...) 
                    ex2 = urlCon.getContentType();//Obtiene el tipo de imgen  por Ej.: image/jpg 
                    ex = "." + ex2.substring(ex2.length() - 3, ex2.length());//Cambiamos lo anterior por Ej.: por ".jpg"                     
                    ImageIcon icon = new ImageIcon(url);//Iniciamos imagen en un ImageIcon y luego la 
                    //redimensionamos al tamaño de la etiqueta 
                    ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)); 
                    label.setIcon(icono);
            }else {//Si urlCon.getContentType()==null 
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));//Ponemos cursor x defecto 
                    label.setIcon(null);
            }     
        }catch(Exception io){
        
        }
    }
    class ButtonRenderer extends JLabel implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
    } else {
      setForeground(table.getForeground());
      if(row%2==0){
                this.setBackground(new Color( 245, 245 , 245));
            }else{
                this.setBackground(new Color( 220, 220 , 220));
            }
      setIcon(new ImageIcon(getClass().getResource("/Login/imagenes/boton-ir.png")));
      setHorizontalAlignment(0);
    }
    setText((value == null) ? "" : "");
    this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
    return this;
  }
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
                actualizar();
                empleados();
            }
            if(turno==2){
                
            }
        }
    }
    
    public void turno1(){
        updateTablas up = new updateTablas(1);
        up.start();
    }
    
    public void turno2(){
        updateTablas up = new updateTablas(2);
        up.start();
    }

    public List<Empleado> getList() {
        return list;
    }

    public void setList(List<Empleado> list) {
        this.list = list;
    }

    public int getBreakhilo() {
        return breakhilo;
    }

    public void setBreakhilo(int breakhilo) {
        this.breakhilo = breakhilo;
    }

    public String[] getFecha() {
        return fecha;
    }

    public void setFecha(String[] fecha) {
        this.fecha = fecha;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
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

    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void setjComboBox2(JComboBox jComboBox2) {
        this.jComboBox2 = jComboBox2;
    }

    public JComboBox getjComboBox3() {
        return jComboBox3;
    }

    public void setjComboBox3(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
    }

    public JComboBox getjComboBox5() {
        return jComboBox5;
    }

    public void setjComboBox5(JComboBox jComboBox5) {
        this.jComboBox5 = jComboBox5;
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

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }
    
    public void actualizar(){
        try{
        jTextField3.setText(null);
        List<Departamento> list3;
        List<Empleado> em;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list3= helper.getdepartamentosByTipo();
            DefaultTableModel temp4 = (DefaultTableModel) jTable1.getModel();
            for(int i=temp4.getRowCount()-1;i>=0;i--){
               temp4.removeRow(i);
            }
            if(list3!=null){
                DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
                for(Departamento i: list3){
                     String c0= i.getEmpleado().getNombre1() + " "+ i.getEmpleado().getNombre2() + " "+i.getEmpleado().getApellido1() + " "+i.getEmpleado().getApellido2();
                     String c1= i.getNombre();
                     String c2;
                     Long emp= helper.getPersonasdepartamentonum(i.getNombre());
                     c2=""+emp;
                     Object nuevo[]= {c0,c1,c2,i,i};
                     temp.addRow(nuevo);
                 }
                jComboBox1.removeAllItems();
                jComboBox1.addItem("Todos");
                for(Departamento i : list3){
                    jComboBox1.addItem(i.getNombre());
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
    }
    
    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

        public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public void graficarbarrasa(float []y,String []x,String datah,String datav,String titulo)
    {
        int maximo = y.length;
       float y1[]= new float[y.length];
       String[] x1= new String[x.length];
        for (int i = 0; i<y.length; i++) {
            y1[maximo - 1] = y[i];
            maximo--;
        }
        maximo = x.length;
 
        for (String x2 : x) {
            x1[maximo - 1] = x2;
            maximo--;
        }
       DefaultCategoryDataset data = new DefaultCategoryDataset();
        for(int dx=0;dx<y.length;dx++)
        {
         data.setValue(y1[dx],x1[dx],x1[dx]);  
        }
        JFreeChart chart = ChartFactory.createBarChart(titulo,datah,datav,data, PlotOrientation.VERTICAL, false,
true, false);
        ChartFrame frame=new ChartFrame(titulo,chart);
        frame.pack();
        frame.setVisible(true);
    }  
    public ArrayList<String> buscames(int i){
        Date actual = new Date();
        ArrayList<String> lst= new ArrayList<>();
        Calendar c = Calendar.getInstance();
        Calendar fechaFin = new GregorianCalendar();
        fechaFin.setTime(actual);
        int mesactual= c.get(Calendar.MONTH);
        int mesanio= c.get(Calendar.YEAR);
        c.setTimeInMillis(fechaFin.getTime().getTime() - 0);
        int dia = c.get(Calendar.DAY_OF_YEAR);
        int mes = c.get(Calendar.MONTH);
        int anio = c.get(Calendar.YEAR);
        int temp=0;
        for(int x=0; x<i;x++){
            String v;
            if(mes>=x){
                v="1";
            }else{
                v="0";
            }
            if(mesactual-temp>=0){
                lst.add((mesactual-temp)+"/"+mesanio+"/"+v);
            }else{
                lst.add((mesactual-temp+12)+"/"+(mesanio-1)+"/"+v);
            }
            temp++;
        }
        return lst;
        
    }
  
   public static int getUltimoDiaDelMes(String anioFin, String mesFin) {
       Calendar calFin = Calendar.getInstance();
       calFin.set(Integer.parseInt(anioFin), Integer.parseInt(mesFin), 1);
       calFin.set(Integer.parseInt(anioFin), Integer.parseInt(mesFin), calFin.getActualMaximum(Calendar.DAY_OF_MONTH));
       Calendar calInicio = Calendar.getInstance();
       calInicio.set(Integer.parseInt(anioFin), Integer.parseInt(mesFin), 1);
       int diffDays= 0;
       while (calInicio.before(calFin) || calInicio.equals(calFin)) {
            if (calInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                diffDays++;
            }
            calInicio.add(Calendar.DATE, 1);
            }
       return diffDays;
    }

   public void laborales(){
       
   }
   
   public class ausen{
       double fc;
       int fc1;
       double fs;
       int fs1;
       double ff;
       int ff1;
       double a;
       int a1;
       double as;
       int as1;
       double p;
       int p1;
       String fecha;
       
       public ausen(){
            this.fc=0.0;
            this.fs=0.0;
            this.ff=0.0;
            this.a=0.0;
            this.as=0.0;
            this.p=0.0;
            this.fc1=0;
            this.fs1=0;
            this.ff1=0;
            this.a1=0;
            this.as1=0;
            this.p1=0;
            String fecha2="";
       }
        public double getFc() {
            return fc;
        }

        public void setFc(double fc) {
            this.fc = fc;
        }

        public double getFs() {
            return fs;
        }

        public void setFs(double fs) {
            this.fs = fs;
        }

        public double getFf() {
            return ff;
        }

        public double getP() {
            return p;
        }

        public void setP(double p) {
            this.p = p;
        }

        public int getFc1() {
            return fc1;
        }

        public void setFc1(int fc1) {
            this.fc1 = fc1;
        }

        public int getFs1() {
            return fs1;
        }

        public void setFs1(int fs1) {
            this.fs1 = fs1;
        }

        public int getFf1() {
            return ff1;
        }

        public void setFf1(int ff1) {
            this.ff1 = ff1;
        }

        public int getA1() {
            return a1;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public int getAs1() {
            return as1;
        }

        public void setAs1(int as1) {
            this.as1 = as1;
        }

        public int getP1() {
            return p1;
        }

        public void setP1(int p1) {
            this.p1 = p1;
        }

        public void setFf(double ff) {
            this.ff = ff;
        }

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public double getAs() {
            return as;
        }

        public void setAs(double as) {
            this.as = as;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }
       
       
   }
   
    public void llenar5(){
            ServiceHb helper;
            ArrayList<String> lst;
            Date f = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(f);
            
            int num;
            try{
                if(jComboBox5.getSelectedIndex()==0){
                  num=1;  
                }else if(jComboBox5.getSelectedIndex()==1){
                    num=3;
                }else if(jComboBox5.getSelectedIndex()==2){
                    num=6;
                } else{
                    num=12;
                }
                lst= buscames(num);
                ArrayList<ausen> lt = new ArrayList<>();
                String depa = jComboBox1.getSelectedItem().toString();
                int diastotales=0;
                int totalempleados=0;
                if(lst!=null){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                String x="";
                String y="";
                
                for(String i: lst){
                    String mes= i.split("/")[0];
                    String anio= i.split("/")[1];
                    int dias= getUltimoDiaDelMes(anio,mes);
                    diastotales=dias;
                    String val= i.split("/")[2];
                    // LLamada a la Clase AUSEN
                    ausen au = new ausen();
                    //
                    List<Empleado> em ;
                    if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Todos")){
                        em = helper.getPersonasByTipo();
                    }else{
                        em = helper.getPersonasdepartamento(jComboBox1.getSelectedItem().toString());
                    }
                    totalempleados=em.size();
                    List<Permisos> hor = helper.getPermisosByTipoindiall(fecha[Integer.parseInt(mes)],anio);
                    List<Multa> mul = helper.getMultamesByTipo3(fecha[Integer.parseInt(mes)],anio);
                    float multas=0;
                    if(mul!=null){
                        for(Multa z: mul){
                            for(Empleado c: em){
                                if(c.getCid()==z.getCi()){
                                    float temp=48000;
                                    if(c.getDeptEmpl().getDepartamento().getNombre().equalsIgnoreCase("Seguridad Fisica")){
                                        temp=72000;
                                    }
                                    if(z.getTipo().equalsIgnoreCase("FC")||z.getTipo().equalsIgnoreCase("F. Inj. - Av. con T.")){
                                        multas= multas+ temp;
                                        au.setFc(au.getFc()+(double)temp);
                                        au.setFc1((int) (au.getFc1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("FS")||z.getTipo().equalsIgnoreCase("F. Inj. - Av. sin T.")){
                                        multas= multas+ temp;
                                        au.setFs(au.getFs()+(double)temp);
                                        au.setFs1((int) (au.getFs1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("F")||z.getTipo().equalsIgnoreCase("F. Inj. - No Avisó")){
                                        multas= multas+ temp;
                                        au.setFf(au.getFf()+(double)temp);
                                        au.setFf1((int) (au.getFf1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("A")||z.getTipo().equalsIgnoreCase("Atraso - Avisó")){
                                        multas= multas+ Float.parseFloat(z.getMotivo());
                                        au.setA(au.getA()+Double.parseDouble(z.getMotivo()));
                                        au.setA1((int) (au.getA1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("AS")||z.getTipo().equalsIgnoreCase("Atraso - No Avisó")){
                                        multas= multas+ Float.parseFloat(z.getMotivo());
                                        au.setAs(au.getAs()+Double.parseDouble(z.getMotivo()));
                                        au.setAs1((int) (au.getAs1()+1));
                                    }
                                }
                            }   
                        }
                    }
                    if(hor!=null){
                        float var=0;
                            for(Permisos n: hor){
                                for(Empleado c: em){
                                    if(c.getCid()==(n.getCi())){
                                        var= var+Float.parseFloat(n.getValor());
                                        au.setP(au.getP()+(Double.parseDouble(n.getValor())*100));
                                        au.setP1((int) (au.getP1()+1));
                                    }
                                }
                            }
                            
                            var= var+multas;
                            var= (((var/60)/12)/dias)/em.size();
                            if(var==0){
                                y= y + "/"+ var;
                            }else{
                                y= y + "/"+ var*100;
                            }
                            
                            x= x + "/"+ fecha[Integer.parseInt(mes)]+" "+anio;
                        
                    }else{
                        multas= (((multas/60)/12)/22)/em.size();
                        if(multas==0){
                            y= y + "/"+ multas;
                        }else{
                            y= y + "/"+ multas*100;
                        }    
                        x= x + "/"+ fecha[Integer.parseInt(mes)]+" "+anio;
                    }
                    au.setFecha(fecha[Integer.parseInt(mes)]+" "+anio);
                    lt.add(au);
                }
                helper.cerrarSesion();
                
                }
                ingresoU21 u = new ingresoU21(null,true, lt,diastotales,totalempleados,depa);
                
            }catch(Exception io){
            
            }
    }
    
   
    public void llenar2(){
            ServiceHb helper;
            ArrayList<String> lst;
            Date f = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(f);
            int num;
            try{
                if(jComboBox5.getSelectedIndex()==0){
                  num=1;  
                }else if(jComboBox5.getSelectedIndex()==1){
                    num=3;
                }else if(jComboBox5.getSelectedIndex()==2){
                    num=6;
                } else{
                    num=12;
                }
                lst= buscames(num);
                if(lst!=null){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                String x="";
                String y="";
                for(String i: lst){
                    String mes= i.split("/")[0];
                    String anio= i.split("/")[1];
                    int dias= getUltimoDiaDelMes(anio,mes);
                    String val= i.split("/")[2];
                    List<Empleado> em ;
                    if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Todos")){
                        em = helper.getPersonasByTipo();
                    }else{
                        em = helper.getPersonasdepartamento(jComboBox1.getSelectedItem().toString());
                    }
                    List<Permisos> hor = helper.getPermisosByTipoindiall(fecha[Integer.parseInt(mes)],anio);
                    List<Multa> mul = helper.getMultamesByTipo3(fecha[Integer.parseInt(mes)],anio);
                    float multas=0;
                    if(mul!=null){
                        for(Multa z: mul){
                            for(Empleado c: em){
                                if(c.getCid()==(z.getCi())){
                                    float temp=480;
                                    if(c.getDeptEmpl().getDepartamento().getNombre().equalsIgnoreCase("Seguridad Fisica")){
                                        temp=720;
                                    }
                                    if(z.getTipo().equalsIgnoreCase("FC")||z.getTipo().equalsIgnoreCase("F. Inj. - Av. con T.")){
                                        multas= multas+ temp;
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("FS")||z.getTipo().equalsIgnoreCase("F. Inj. - Av. sin T.")){
                                        multas= multas+ temp;
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("F")||z.getTipo().equalsIgnoreCase("F. Inj. - No Avisó")){
                                        multas= multas+ temp;
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("A")||z.getTipo().equalsIgnoreCase("Atraso - Avisó")){
                                        multas= multas+ Float.parseFloat(z.getMotivo());
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("AS")||z.getTipo().equalsIgnoreCase("Atraso - No Avisó")){
                                        multas= multas+ Float.parseFloat(z.getMotivo());
                                    }
                                }
                            }   
                        }
                    }
                    if(hor!=null){
                        float var=0;
                            for(Permisos n: hor){
                                for(Empleado c: em){
                                    if(c.getCi()==Integer.parseInt(n.getCi())){
                                        var= var+Float.parseFloat(n.getValor());
                                    }
                                }
                            }
                            var= var+multas;
                            var= (((var/60)/12)/dias)/em.size();
                            if(var==0){
                                y= y + "/"+ var;
                            }else{
                                y= y + "/"+ var*100;
                            }
                            
                            x= x + "/"+ fecha[Integer.parseInt(mes)]+" "+anio;
                        
                    }else{
                        multas= (((multas/60)/12)/22)/em.size();
                        if(multas==0){
                            y= y + "/"+ multas;
                        }else{
                            y= y + "/"+ multas*100;
                        }    
                        x= x + "/"+ fecha[Integer.parseInt(mes)]+" "+anio;
                    }
                }
                helper.cerrarSesion();
                float a1[]= new float[y.split("/").length-1];
                for(int i=0; i<y.split("/").length-1;i++){
                    a1[i]=Float.parseFloat(y.split("/")[i+1]);
                }
                String[] a2= new String[x.split("/").length-1];
                for(int i=0; i<x.split("/").length-1;i++){
                    a2[i]=x.split("/")[i+1];
                }
                String vertical= "% Ausentismo";
                String horizontal = "Meses";
                String titulo = "Historial";
                graficarbarrasa(a1, a2, horizontal, vertical, titulo);
                }
                
            }catch(Exception io){
            
            }
    }
    
    
    public void llenar3(){
            ServiceHb helper;
            ArrayList<String> lst;
            Date f = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(f);
            int num;
            try{
                if(jComboBox5.getSelectedIndex()==0){
                  num=1;  
                }else if(jComboBox5.getSelectedIndex()==1){
                    num=3;
                }else if(jComboBox5.getSelectedIndex()==2){
                    num=6;
                } else{
                    num=12;
                }
                lst= buscames(num);
                if(lst!=null){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                ArrayList<Double> l = new ArrayList<>();
                ArrayList<String> l2 = new ArrayList<>();

                ArrayList<Double> m = new ArrayList<>();
                ArrayList<String> m2 = new ArrayList<>();

                ArrayList<Double> g = new ArrayList<>();
                ArrayList<String> g2 = new ArrayList<>();
                for(String i: lst){
                    String mes= i.split("/")[0];
                    String anio= i.split("/")[1];
                    List<Empleado> em;
                    if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Todos")){
                        em = helper.getPersonasByTipo();
                    }else{
                        em = helper.getPersonasdepartamento(jComboBox1.getSelectedItem().toString());
                    }
                    
                    List<Multa> mul = helper.getMultamesByTipo3(fecha[Integer.parseInt(mes)],anio);
                    double leve=0;
                    double media=0;
                    double grave=0;
                    
                    if(mul!=null){
                        for(Multa z: mul){
                            for(Empleado c: em){
                                if(c.getCid()==(z.getCi())){
                                    if(z.getTipo().equalsIgnoreCase("FL")||z.getTipo().equalsIgnoreCase("F. R.I. - Leve")){
                                        leve = leve - Double.parseDouble(z.getValor());
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("FM")||z.getTipo().equalsIgnoreCase("F. R.I. - Media")){
                                        media = media - Double.parseDouble(z.getValor());
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("FG")||z.getTipo().equalsIgnoreCase("F. R.I. - Grave")){
                                        grave = grave - Double.parseDouble(z.getValor());
                                    }
                                }
                            }   
                        }
                    }
                    l.add((double)leve);
                    
                    m.add((double)media);
                    
                    g.add((double)grave);
                    
                    l2.add(fecha[Integer.parseInt(mes)]+" "+anio);
                    
                    m2.add(fecha[Integer.parseInt(mes)]+" "+anio);
                    
                    g2.add(fecha[Integer.parseInt(mes)]+" "+anio);
                    
                }
                helper.cerrarSesion();
                JFrame jf = new JFrame();
                JPanel pa = new JPanel();
                pa.setLayout(new GridLayout(1, 3));
                
                GraficaPastel gp = new GraficaPastel();
                ChartPanel p1= gp.crear(l, l2, "Leve");
                ChartPanel p2= gp.crear(m, m2, "Media");
                ChartPanel p3= gp.crear(g, g2, "Grave");
                
                pa.add(p1);
                pa.add(p2);
                pa.add(p3);
                int ancho = p1.getWidth()+p2.getWidth()+p3.getWidth();
                int alto = p1.getHeight();
                pa.setSize(ancho, alto);
                pa.setVisible(true);
                jf.setSize(ancho, alto);
                jf.add(pa);
                jf.setVisible(true);
                }
                
            }catch(Exception io){
            
            }
    }
    
    
    
    public void llenar4(){
            ServiceHb helper;
            ArrayList<String> lst;
            Date f = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(f);
            int num;
            try{
                if(jComboBox5.getSelectedIndex()==0){
                  num=1;  
                }else if(jComboBox5.getSelectedIndex()==1){
                    num=3;
                }else if(jComboBox5.getSelectedIndex()==2){
                    num=6;
                } else{
                    num=12;
                }
                lst= buscames(num);
                if(lst!=null){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                ArrayList<Double> l = new ArrayList<>();
                ArrayList<String> l2 = new ArrayList<>();
                ArrayList<Integer> l3 = new ArrayList<>();

                ArrayList<Double> m = new ArrayList<>();
                ArrayList<String> m2 = new ArrayList<>();
                ArrayList<Integer> m3 = new ArrayList<>();

                ArrayList<Double> g = new ArrayList<>();
                ArrayList<String> g2 = new ArrayList<>();
                ArrayList<Integer> g3 = new ArrayList<>();
                
                for(String i: lst){
                    String mes= i.split("/")[0];
                    String anio= i.split("/")[1];
                    List<Empleado> em;
                    if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Todos")){
                        em = helper.getPersonasByTipo();
                    }else{
                        em = helper.getPersonasdepartamento(jComboBox1.getSelectedItem().toString());
                    }
                    
                    List<Multa> mul = helper.getMultamesByTipo3(fecha[Integer.parseInt(mes)],anio);
                    double leve=0;
                    double media=0;
                    double grave=0;
                    int leve1=0;
                    int media1=0;
                    int grave1=0;
                    
                    
                    if(mul!=null){
                        for(Multa z: mul){
                            for(Empleado c: em){
                                if(c.getCid()==(z.getCi())){
                                    if(z.getTipo().equalsIgnoreCase("FL")||z.getTipo().equalsIgnoreCase("F. R.I. - Leve")){
                                        leve = leve - Double.parseDouble(z.getValor());
                                        leve1++;
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("FM")||z.getTipo().equalsIgnoreCase("F. R.I. - Media")){
                                        media = media - Double.parseDouble(z.getValor());
                                        media1++;
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("FG")||z.getTipo().equalsIgnoreCase("F. R.I. - Grave")){
                                        grave = grave - Double.parseDouble(z.getValor());
                                        grave1++;
                                    }
                                }
                            }   
                        }
                    }
                    l.add((double)leve);
                    l3.add(leve1);
                    
                    m.add((double)media);
                    m3.add(media1);
                    
                    g.add((double)grave);
                    g3.add(grave1);
                    
                    l2.add(fecha[Integer.parseInt(mes)]+" "+anio);
                    
                    m2.add(fecha[Integer.parseInt(mes)]+" "+anio);
                    
                    g2.add(fecha[Integer.parseInt(mes)]+" "+anio);
                    
                }
                helper.cerrarSesion();
                ingresoU2 u = new ingresoU2(null, true, l, m, g, l2, m2, g2,l3,m3,g3,jComboBox1.getSelectedItem().toString());
                }
                
            }catch(Exception io){
            
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);
        add(jSeparator1);
        jSeparator1.setBounds(30, 90, 1020, 10);

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 152));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Departamentos");
        add(jLabel2);
        jLabel2.setBounds(30, 50, 220, 24);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JEFE", "NOMBRE", "PERSONAL A CARGO", "EDITAR", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 1040, 210);

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        add(jTextField3);
        jTextField3.setBounds(270, 400, 230, 24);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setText("Nombre de Jefe:");
        add(jLabel5);
        jLabel5.setBounds(40, 360, 190, 22);

        jComboBox2.setPreferredSize(new java.awt.Dimension(93, 24));
        add(jComboBox2);
        jComboBox2.setBounds(270, 360, 230, 24);

        jLabel4.setBackground(new java.awt.Color(0, 74, 152));
        jLabel4.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4);
        jLabel4.setBounds(700, 50, 160, 24);

        jComboBox3.setPreferredSize(new java.awt.Dimension(93, 24));
        add(jComboBox3);
        jComboBox3.setBounds(540, 360, 230, 24);
        jComboBox3.setVisible(false);
        add(jSeparator2);
        jSeparator2.setBounds(30, 460, 1020, 10);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("Departamento:");
        add(jLabel7);
        jLabel7.setBounds(40, 400, 190, 22);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("Departamento:");
        add(jLabel8);
        jLabel8.setBounds(40, 480, 190, 22);

        add(jComboBox1);
        jComboBox1.setBounds(270, 480, 230, 30);

        jButton1.setText("Ausentismo");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(690, 480, 140, 40);

        jButton2.setText("Multas");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(540, 480, 120, 40);

        jComboBox5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mensual", "Trimestral", "Semestral", "Todos" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox5MouseReleased(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        add(jComboBox5);
        jComboBox5.setBounds(270, 540, 230, 30);

        jButton3.setText("Multas Datos");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(540, 530, 120, 40);

        jButton4.setText("Ausentismo Datos");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(690, 530, 140, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if(jTextField3.getText()!=null && !jTextField3.getText().equalsIgnoreCase("")){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            Departamento dp = new Departamento();
            dp.setEmpleado((Empleado)jComboBox3.getItemAt(jComboBox2.getSelectedIndex()));
            dp.setNombre(jTextField3.getText());
            helper.crearObjeto(dp);
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            actualizar();
            JOptionPane.showMessageDialog(null,"Dpartamento Agregado");
        }catch(Exception io){
        
        }
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jComboBox5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5MouseReleased

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            llenar2();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
            llenar3();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
           
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        llenar4();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        llenar5();
    }//GEN-LAST:event_jButton4MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
