/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Bono;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Comisiones;
import rrhh.Entidad.Horas;
import rrhh.Entidad.Otros;
import rrhh.Entidad.Prestamos;
import rrhh.Entidad.Roles;
import rrhh.servicio.Funcion;
import rrhh.servicio.ServiceHb;

/**
 *
 * @author Matheus
 */
public final class generar_roles extends javax.swing.JPanel {
    Dimension d;
    Empleado emp;
    DecimalFormat df2 = new DecimalFormat("0.00");
    int turno=1;
    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
    final long MILLSECS_PER_MOUNT = 24 * 30 * 60 * 60 * 1000 ; //Milisegundos al mes
    /**
     * Creates new form inicio
     */
    public generar_roles() {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width-100, d.height-61);
        fecha_update();
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getColumn("Editar").setCellRenderer(new ButtonRenderer());
        setVisible(false);
    }
    
    public void fecha_update(){
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        jComboBox2.removeAllItems();
        jComboBox1.removeAllItems();
        Date f = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(f);
        for(int i=2013; i<2021;i++){
            jComboBox2.addItem(i);
        }
        for(int i=0; i<12;i++){
            jComboBox1.addItem(fecha[i]);
        }
        jComboBox2.setSelectedItem(calendar.get(Calendar.YEAR));
        jComboBox1.setSelectedItem(fecha[calendar.get(Calendar.MONTH)]);
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

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }    

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(null);

        jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton1.setText("Generar Roles");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(480, 20, 140, 30);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Fecha:");
        add(jLabel1);
        jLabel1.setBounds(660, 20, 60, 30);

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        add(jComboBox1);
        jComboBox1.setBounds(730, 20, 150, 30);

        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        add(jComboBox2);
        jComboBox2.setBounds(890, 20, 90, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Dias", "Sueldo Basico", "Horas Extras", "Comisiones", "IESS", "Suplementario", "Movilizacion", "P. Comisariato", "P. Quirografario", "IESS: Extension", "P. Hipotecario", "P. Empresa", "P. Cooperativo", "P. Actividades Comunes", "P. Medilink", "Multas", "Fondos", "Bonos", "Decimo Tercero", "Decimo Cuarto", "Alimentacion", "Liquidacion", "Total Bonos", "Reposiciones", "Varios", "Total", "Editar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setOpaque(false);
        jTable1.setRowHeight(24);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(23).setMinWidth(0);
            jTable1.getColumnModel().getColumn(23).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(23).setMaxWidth(0);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 1090, 480);

        jButton2.setText("Limpiar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(20, 20, 80, 30);

        jButton3.setText("Descargar Excel Mensual");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(110, 20, 180, 30);

        jButton4.setText("Descargar Excel Banco");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(300, 20, 160, 30);
        add(jLabel2);
        jLabel2.setBounds(1000, 20, 100, 30);
    }// </editor-fold>//GEN-END:initComponents

    
    public class listaempleados extends Thread {
        int num;
        public listaempleados(int num){
            this.num= num;
        }
        public listaempleados(){
            this.num= 1;
        }
        @Override
        public void run() {
            generarroles();
        }
    }
    
    public void generarroles(){
        String err="";
        try{
            List<Roles> roles;
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            String mes=jComboBox1.getSelectedItem().toString();
            String anio=jComboBox2.getSelectedItem().toString();
            /*---------------------------*/
            Roles user=null;
            int base=0;
            int num=0;
            Calendar cale = Calendar.getInstance();
            cale.set(Integer.parseInt(anio), jComboBox1.getSelectedIndex(), 1);
            int ultimo2= cale.getMaximum(Calendar.DAY_OF_MONTH);
            cale.set(Integer.parseInt(anio), jComboBox1.getSelectedIndex(), ultimo2);
            List<Empleado> empleado=helper.getPersonasByTipo(cale.getTime());
            base= empleado.size();
            for(Empleado empl : empleado){
                num++;
                jLabel2.setText(num+"/"+base);
                err=empl.getApellido1()+empl.getApellido2();
                if(empl.getDato1()!=null){
                    List<Roles> r = helper.getRolesmesByTipo(""+empl.getCid(),mes,anio);
                    float sup= 0;
                    float sup2= 0;
                    float reserva=0;
                    float pago=0;
                    float iess=0;
                    float saldo=0;
                    float extra=0;
                    float fondo=0;
                    float decimo3=0;
                    float decimo4=0;
                    float alimentacion=Float.parseFloat("40");
                    float actividades=Float.parseFloat("1.5")*-1;
                    float suplementario=0;
                    Double dias=0.0;
                    if(r==null){
                        user= new Roles();
                        user.setMes(mes);
                        user.setAnio(anio);
                        user.setCi(""+empl.getCid());
                        user.setNombre(empl.getNombre1()+" "+empl.getNombre2()+ " " +empl.getApellido1()+ " "+ empl.getApellido2());
                        user.setDepa(empl.getDeptEmpl().getDepartamento().getNombre());
                        user.setBanco(empl.getBanco());
                        user.setCuentaci(empl.getCuentaci());
                        user.setCuentadue(empl.getCuentadue());
                        user.setCuentanum(empl.getCuentanum());
                        user.setCuentatipo(empl.getCuentatipo());
                        saldo = Float.parseFloat(empl.getDato1());
                        iess = Float.parseFloat(empl.getDato2());
                        suplementario = Float.parseFloat(empl.getDato3());
                        extra = Float.parseFloat(empl.getDato4());
                        fondo = (float)((saldo+extra)*8.33)/100;
                        iess= (float)((saldo+extra)*0.0945);
                        Date fecha = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                        String dateInString = "31-"+Funcion.DateTimeToString4mes(fecha)+"-"+Funcion.DateTimeToString4year(fecha)+" 10:20:56";
                        Date date = sdf.parse(dateInString);
                        Calendar cd = Calendar.getInstance();
                        int anio2= Integer.parseInt(jComboBox2.getSelectedItem().toString());
                        int mes2= jComboBox1.getSelectedIndex();
                        cd.set(anio2, mes2, 1);
                        int ultimo= cd.getMaximum(Calendar.DAY_OF_MONTH);
                        cd.set(anio2, mes2, ultimo);
                        
                        int diferencia= (int) ((cd.getTimeInMillis() - empl.getFechaIngreso().getTime())/MILLSECS_PER_DAY) ;
                        if(diferencia > 30){
                            user.setDias("30");
                        }else{
                            user.setDias(Integer.toString(diferencia));
                        }
                                                
                        sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                        int diferenciames= diferenciaFechas(Funcion.DateFormat(cd.getTime()),Funcion.DateFormat(empl.getFechaIngreso()),1);
                        int dif= diferenciames-365-31;
                        if(dif>0){
                            if(empl.getFondos().equalsIgnoreCase("No Acumula")){
                                user.setFondos(String.format("%.2f",fondo).replace(",", "."));
                            }else{
                                user.setFondos(String.format("%.2f",0.0).replace(",", "."));
                            }
                        }else{
                            user.setFondos(String.format("%.2f",0.0).replace(",", "."));
                        }
                        dias = Double.parseDouble(user.getDias())/30;
                        user.setSueldo(String.format("%.2f", saldo*dias).replace(",", "."));
                        user.setIess(String.format("%.2f", (saldo+extra)*dias*0.0945).replace(",", "."));
                        user.setSuplementaria2(String.format("%.2f", (extra)*dias).replace(",", "."));
                        user.setSuplementaria(String.format("%.2f", (suplementario)*dias).replace(",", "."));
                        
                        sup= Float.parseFloat(user.getSuplementaria());
                        sup2= Float.parseFloat(user.getSuplementaria2());
                        reserva= Float.parseFloat(user.getFondos());
                        pago=Float.parseFloat(user.getSueldo());
                        iess=Float.parseFloat(user.getIess());
                    }else{
                        user=r.get(0);
                        sup=  Float.parseFloat(user.getSuplementaria());
                        sup2=  Float.parseFloat(user.getSuplementaria2());
                        reserva= Float.parseFloat(user.getFondos());
                        pago= Float.parseFloat(user.getSueldo());
                        iess= Float.parseFloat(user.getIess());
                    }
                    user.setCedula(empl.getCid());
                    float totalA=0;
                    List<Horas> v1= helper.getHorasmesByTipo(""+empl.getCid(), mes, anio);
                    List<Multa> v2= helper.getMultamesByTipo(""+empl.getCid(), mes, anio);
                    List<Prestamos> v3= helper.getPrestamosmesByTipo(""+empl.getCid(), mes, anio);
                    List<Bono> v5= helper.getBonomesByTipo(""+empl.getCid(), mes, anio);
                    List<Comisiones> v6= helper.getComisionesmesByTipo(""+empl.getCid(), mes, anio);
                    List<Otros> v7= helper.getOtrosmesByTipo(""+empl.getCid(), mes, anio);
                    
                    float hora=0;
                    if(v1!=null){
                        for(Horas val: v1){
                            if(val.getAccion()!=null){
                                if(val.getAccion().equalsIgnoreCase("A")){
                                    totalA= totalA+Float.parseFloat(val.getValor());
                                    hora=Float.parseFloat(val.getValor())+hora;
                                }
                            }
                        }
                    }
                    
                    float multaa=0;
                    if(v2!=null){
                        for(Multa val: v2){
                            if(val.getAccion()!=null){
                                if(val.getAccion().equalsIgnoreCase("A")){
                                    totalA= totalA+Float.parseFloat(val.getValor());
                                    multaa= multaa+Float.parseFloat(val.getValor());
                                }
                            }
                        }
                    }
                    float prestamo=0;
                    float prestamo1=0;
                    float prestamo2=0;
                    float prestamo3=0;
                    float prestamo4=0;
                    float prestamo5=0;
                    float prestamo6=0;
                    float prestamo7=0;
                    float prestamo8=0;
                    if(v3!=null){
                        for(Prestamos val: v3){
                            if(val.getAccion()!=null){
                                if(val.getAccion().equalsIgnoreCase("A")){
                                    totalA= totalA+Float.parseFloat(val.getValor());
                                    prestamo= prestamo + Float.parseFloat(val.getValor());
                                    if(val.getMotivo().equalsIgnoreCase("Comisariato")){
                                        prestamo1=prestamo1+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Préstamo Quirografario")){
                                        prestamo2=prestamo2+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Préstamo Hipotecario")){
                                        prestamo4=prestamo4+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Préstamo Empresa")){
                                        prestamo5=prestamo5+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Préstamo Cooperativa")){
                                        prestamo6=prestamo6+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Seguro de asistencia Médica")){
                                        prestamo8=prestamo8+Float.parseFloat(val.getValor());
                                    }else{       
                                        prestamo3=prestamo3+Float.parseFloat(val.getValor());
                                    }
                                }
                            }
                        }
                    }
                    
                    float bonoa=0;
                    float liquidacion=0;
                    float bon=0;
                    float movi=0;
                    //tabla mover celdas agregar decimos y comisiones... comisiones con calculo iess
                    if(empl.getAlimentacion().contains("SI")){
                        dias = Double.parseDouble(user.getDias())/30;
                        alimentacion=((float)(alimentacion*dias));
                        totalA=totalA+alimentacion;
                    }else{
                        alimentacion= Float.parseFloat("0");
                    }
                    
                    if(v5!=null){
                        for(Bono val: v5){
                            if(val.getAccion()!=null){
                                if(val.getAccion().equalsIgnoreCase("A")){
                                    if(val.getMotivo().equalsIgnoreCase("Liquidación de Vacaciones")){
                                        //totalA= totalA+Float.parseFloat(val.getValor());
                                        liquidacion=liquidacion+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Movilización")){
                                        movi= movi+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Bonos")||val.getMotivo().equalsIgnoreCase("Liq. Decimotercero Dic-Jul 2015")){
                                        bon= bon+Float.parseFloat(val.getValor());
                                    }else if(val.getMotivo().equalsIgnoreCase("Alimentación")){
                                        alimentacion=alimentacion+Float.parseFloat(val.getValor());
                                    }
                                    totalA= totalA+Float.parseFloat(val.getValor());
                                    bonoa=bonoa+Float.parseFloat(val.getValor());
                                }
                            }
                        }
                    }
                    
                    float comi=0;
                    if(v6!=null){
                        for(Comisiones val: v6){
                            if(val.getAccion()!=null){
                                if(val.getAccion().equalsIgnoreCase("A")){
                                    comi=comi+Float.parseFloat(val.getValor());
                                }
                            }
                        }
                        dias = Double.parseDouble(user.getDias())/30;
                        saldo = Float.parseFloat(empl.getDato1());
                        extra = Float.parseFloat(empl.getDato4());
                        double dou = ((saldo+extra)*dias*0.0945);
                        iess= (float)dou+ (float)((comi)*0.0945);
                    }
                    
                    
                    if(v7!=null){
                        for(Otros val: v7){
                            if(val.getAccion()!=null){
                                if(val.getAccion().equalsIgnoreCase("A")){
                                    movi= movi+Float.parseFloat(val.getValor());
                                }
                            }
                        }
                    }
                    
                    if(empl.getDecimotercero().contains("SI")){
                        saldo = Float.parseFloat(empl.getDato1());
                        suplementario = Float.parseFloat(empl.getDato3());
                        extra = Float.parseFloat(empl.getDato4());
                        dias = Double.parseDouble(user.getDias())/30;
                        if(empl.getDeptEmpl().getDepartamento().getNombre().equalsIgnoreCase("Seguridad Fisica")){
                            decimo3 = (float) ((saldo+extra+suplementario+alimentacion)/12);
                            decimo3=((float)(decimo3*dias));
                        }else{
                            decimo3 = (float) ((saldo+extra+suplementario+movi+comi+alimentacion)/12);
                            decimo3=((float)(decimo3*dias));
                        }
                        /*
                        if(empl.getCid().contains("917916462")||empl.getCid().contains("919889006")){
                            decimo3 = decimo3*2;
                        }*/
                        totalA=totalA+decimo3;
                    }
                    if(empl.getDecimocuarto().contains("SI")){
                        saldo = Float.parseFloat(empl.getDato1());
                        suplementario = Float.parseFloat(empl.getDato3());
                        extra = Float.parseFloat(empl.getDato4());
                        dias = Double.parseDouble(user.getDias())/30;
                        decimo4 = (float) (29.5);
                        decimo4=((float)(decimo4*dias));
                        if(empl.getCid().contains("917916462")){
                            //decimo4 = decimo4*2;
                        }
                        totalA=totalA+decimo4;
                    }
                    
                    if(empl.getActividades().contains("SI")){
                        totalA=totalA+actividades;
                    }else{
                        actividades= Float.parseFloat("0");
                    }
                    
                    DecimalFormat df = new DecimalFormat("#.##");
                    user.setBonos(String.valueOf(df.format(bonoa).replace(",", ".")));
                    user.setIess(String.valueOf(df.format(iess).replace(",", ".")));
                    user.setMultas(String.valueOf(df.format(multaa).replace(",", ".")));
                    user.setPrestamo1(String.valueOf(df.format(prestamo1).replace(",", ".")));
                    user.setPrestamo2(String.valueOf(df.format(prestamo2).replace(",", ".")));
                    user.setPrestamo3(String.valueOf(df.format(prestamo3).replace(",", ".")));
                    user.setPrestamo4(String.valueOf(df.format(prestamo4).replace(",", ".")));
                    user.setPrestamo5(String.valueOf(df.format(prestamo5).replace(",", ".")));
                    user.setPrestamo6(String.valueOf(df.format(prestamo6).replace(",", ".")));
                    user.setPrestamo7(String.valueOf(df.format(actividades).replace(",", ".")));
                    user.setPrestamo8(String.valueOf(df.format(prestamo8).replace(",", ".")));
                    user.setActividades(String.valueOf(df.format(actividades).replace(",", ".")));
                    user.setReposiciones(String.valueOf(df.format(hora).replace(",", ".")));
                    user.setComisiones(String.valueOf(df.format(comi).replace(",", ".")));
                    user.setDecimocuarto(String.valueOf(df.format(decimo4).replace(",", ".")));
                    user.setDecimo4(String.valueOf(df.format(decimo4).replace(",", ".")));
                    user.setDecimotercero(String.valueOf(df.format(decimo3).replace(",", ".")));
                    user.setDecimo3(String.valueOf(df.format(decimo3).replace(",", ".")));
                    user.setMobilizacion(String.valueOf(df.format(movi).replace(",", ".")));
                    user.setAlimentacion(String.valueOf(df.format(alimentacion).replace(",", ".")));
                    
                    user.setLiquidacion(String.valueOf(df.format(liquidacion).replace(",", ".")));
                    user.setBon(String.valueOf(df.format(bon).replace(",", ".")));
                    user.setVarios(String.valueOf(df.format(totalA).replace(",", ".")));
                    float todo= pago+totalA-iess+sup+sup2+reserva+comi;
                    
                    user.setTotal(String.valueOf(df.format(todo).replace(",", ".")));
                    helper.crearOrActualizarObjeto(user);
                }
                
            }
        helper.confirmarTransaccion();
        helper.cerrarSesion();
        /*---------------------------*/
        
        helper = new ServiceHb();
        helper.iniciarTransaccion();
        roles = helper.getRolesgenerales(mes, anio);
        DefaultTableModel temp = (DefaultTableModel) getjTable1().getModel();
        for(int i=temp.getRowCount()-1;i>=0;i--){
           temp.removeRow(i);
        }
        if(roles!=null){
        int i=0;
        for(Roles x:roles){
            if(getjTable1().getRowCount()< roles.size()){
                DefaultTableModel tempa = (DefaultTableModel) getjTable1().getModel();
                Object nuevo[]= {tempa.getRowCount()+1,"",""};
                tempa.addRow(nuevo);
            }
                getjTable1().getModel().setValueAt(x.getNombre(), i, 0);
                getjTable1().getModel().setValueAt(x.getDias(), i, 1);
                getjTable1().getModel().setValueAt(x.getSueldo() , i, 2);
                getjTable1().getModel().setValueAt(x.getSuplementaria2() , i, 3);
                getjTable1().getModel().setValueAt(x.getComisiones(), i, 4);
                getjTable1().getModel().setValueAt(x.getIess(), i, 5);
                getjTable1().getModel().setValueAt(x.getSuplementaria(), i, 6);
                getjTable1().getModel().setValueAt(x.getMobilizacion(), i, 7);
                getjTable1().getModel().setValueAt(x.getPrestamo1(), i, 8);
                getjTable1().getModel().setValueAt(x.getPrestamo2(), i, 9);
                getjTable1().getModel().setValueAt(x.getPrestamo3(), i, 10);
                getjTable1().getModel().setValueAt(x.getPrestamo4(), i, 11);
                getjTable1().getModel().setValueAt(x.getPrestamo5(), i, 12);
                getjTable1().getModel().setValueAt(x.getPrestamo6(), i, 13);
                getjTable1().getModel().setValueAt(x.getPrestamo7(), i, 14);
                getjTable1().getModel().setValueAt(x.getPrestamo8(), i, 15);
                getjTable1().getModel().setValueAt(x.getMultas(), i, 16);
                getjTable1().getModel().setValueAt(x.getFondos(), i, 17);
                getjTable1().getModel().setValueAt(x.getBon(), i, 18);
                getjTable1().getModel().setValueAt(x.getDecimotercero(), i, 19);
                getjTable1().getModel().setValueAt(x.getDecimocuarto(), i, 20);
                getjTable1().getModel().setValueAt(x.getAlimentacion(), i, 21);
                getjTable1().getModel().setValueAt(x.getLiquidacion(), i, 22);
                getjTable1().getModel().setValueAt(x.getBonos(), i, 23);
                getjTable1().getModel().setValueAt(x.getReposiciones(), i, 24);
                getjTable1().getModel().setValueAt(x.getVarios(), i, 25);
                getjTable1().getModel().setValueAt(x.getTotal(), i, 26);
                getjTable1().getModel().setValueAt(x, i, 27);
                i++;
            }
        }   
        
        helper.cerrarSesion();
        }
        
        catch(Exception io){
            JOptionPane.showMessageDialog(null, "Error al general Roles por el Empleado:"+ err);
        }
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        listaempleados lt = new listaempleados();
        lt.start();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JTable table = jTable1;
        int row= table.getSelectedRow();
        int col=table.getSelectedColumn();
        if(col==27){
            String selectedSiteName = JOptionPane.showInputDialog(null,"Editar (E)");
            if(selectedSiteName.toString().equalsIgnoreCase("E")){ 
                try {
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Roles h = (Roles)table.getValueAt(row, col);
                    h.setDias(table.getValueAt(row, 1).toString());
                    h.setSueldo(table.getValueAt(row, 2).toString());
                    h.setSuplementaria2(table.getValueAt(row, 3).toString());
                    h.setComisiones(table.getValueAt(row, 4).toString());
                    h.setIess(table.getValueAt(row, 5).toString());
                    h.setSuplementaria(table.getValueAt(row, 6).toString());
                    h.setFondos(table.getValueAt(row, 17).toString());
                    h.setVarios(table.getValueAt(row, 25).toString());
                    float totalA=Float.parseFloat(h.getVarios());
                    DecimalFormat df = new DecimalFormat("#.##");
                    float todo= Float.parseFloat(h.getSueldo())+totalA-Float.parseFloat(h.getIess())+Float.parseFloat(h.getSuplementaria())+Float.parseFloat(h.getSuplementaria2())+Float.parseFloat(h.getFondos())+Float.parseFloat(h.getComisiones());
                    h.setTotal(String.valueOf(df.format(todo).replace(",", ".")));
                    helper.actualizarObjeto(h);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Rol Editado");
                }catch(Exception io){

                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        JTable table = jTable1;
        int row= table.getSelectedRow();
        int col=table.getSelectedColumn();
        if(col==1){
            int key = evt.getKeyCode();
            if (key == KeyEvent.VK_ENTER){
                Roles r = (Roles)table.getValueAt(row, 27);
                float sueldo=0;
                float extra=0;
                float iess=0;
                float suplementaria=0;
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Empleado em=null;
                    if(isNumeric(r.getCi())){
                        em = helper.getPersonasCid2((r.getCi()));
                        if(em==null){
                            em = helper.getPersonasCid((r.getCi()));
                        }
                    }else{
                        em = helper.getPersonasCid((r.getCi()));
                    }
                    sueldo= Float.parseFloat(em.getDato1());
                    extra= Float.parseFloat(em.getDato4());
                    iess= Float.parseFloat(em.getDato2());
                    suplementaria= Float.parseFloat(em.getDato3());
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                }catch(Exception io){}
                float dias= Float.parseFloat(table.getValueAt(row, 1).toString());
                sueldo= sueldo*(dias/30);
                table.setValueAt(sueldo,row, 2);
                extra= extra*(dias/30);
                table.setValueAt(extra,row, 3);
                iess= iess*(dias/30);
                table.setValueAt(iess,row, 5);
                suplementaria= suplementaria*(dias/30);
                table.setValueAt(suplementaria,row, 6);
            }
        }
        if(col==2 ||col==3|| col==4){
            int key = evt.getKeyCode();
            if (key == KeyEvent.VK_ENTER){
                float sueldo= Float.parseFloat(table.getValueAt(row, 2).toString());
                float extra= Float.parseFloat(table.getValueAt(row, 3).toString());
                float comisiones= Float.parseFloat(table.getValueAt(row, 4).toString());
                
                float iees= (float)((sueldo+extra+comisiones)*0.0945);
                table.setValueAt(String.format("%.2f", iees).replace(",", "."),row, 5);
            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try{
            String mes=jComboBox1.getSelectedItem().toString();
            String anio=jComboBox2.getSelectedItem().toString();
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Roles> r = helper.getRolesgenerales(mes, anio);
            float total=0;
            for(Roles x: r){
                helper.eliminarObjeto(x);
            }
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }catch(Exception io){
    
        }

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            int respuesta = chooser.showOpenDialog(this);
            String cadena="";
            if (respuesta == JFileChooser.APPROVE_OPTION)
            {
                cadena = chooser.getSelectedFile().getAbsolutePath()+"\\";
            try{
                String mes=jComboBox1.getSelectedItem().toString();
                String anio=jComboBox2.getSelectedItem().toString();
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Roles> r = helper.getRolesgenerales(mes, anio);
                helper.confirmarTransaccion();
                helper.cerrarSesion();
                crearexcel4(r,mes,anio,cadena);
            }catch(Exception io){

            }
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private float parse(float val){       
        DecimalFormat twoDForm = new DecimalFormat("0.00");
        return Float.parseFloat(twoDForm.format(val).replace(",","."));
    }
    
    public void crearexcel4(List<Roles> roles, String mes, String anio,String dir) {
        // Se crea el libro
        HSSFWorkbook libro = new HSSFWorkbook();
        // Se crea una hoja dentro del libro
        HSSFSheet hoja = libro.createSheet();
        hoja.setColumnWidth((short)0, (short)4000);
        hoja.setColumnWidth((short)1, (short)9000);
        hoja.setColumnWidth((short)2, (short)4000);
        hoja.setColumnWidth((short)3, (short)4000);
        hoja.setColumnWidth((short)4, (short)4000);
        hoja.setColumnWidth((short)5, (short)4000);
        hoja.setColumnWidth((short)6, (short)4000);
        hoja.setColumnWidth((short)7, (short)4000);
        hoja.setColumnWidth((short)8, (short)4000);
        hoja.setColumnWidth((short)9, (short)4000);
        hoja.setColumnWidth((short)10, (short)4000);
        hoja.setColumnWidth((short)11, (short)4000);
        hoja.setColumnWidth((short)12, (short)4000);
        hoja.setColumnWidth((short)13, (short)4000);
        hoja.setColumnWidth((short)14, (short)4000);
        hoja.setColumnWidth((short)15, (short)4000);
        hoja.setColumnWidth((short)16, (short)4000);
        hoja.setColumnWidth((short)17, (short)4000);
        hoja.setColumnWidth((short)18, (short)4000);
        hoja.setColumnWidth((short)19, (short)4000);
        hoja.setColumnWidth((short)20, (short)4000);
        hoja.setColumnWidth((short)21, (short)4000);
        hoja.setColumnWidth((short)22, (short)4000);
        hoja.setColumnWidth((short)23, (short)4000);
        hoja.setColumnWidth((short)24, (short)4000);
        hoja.setColumnWidth((short)25, (short)4000);
        hoja.setColumnWidth((short)26, (short)4000);
        Double cont=0.0;
        HSSFCellStyle cs = libro.createCellStyle();
        
        cs.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        cs.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cs.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cs.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cs.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        cs.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cs.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        cs.setTopBorderColor(IndexedColors.BLACK.getIndex());
        
        HSSFCellStyle cs2 = libro.createCellStyle();
        cs2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        cs2.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cs2.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cs2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cs2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        cs2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cs2.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        cs2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        HSSFDataFormat df = libro.createDataFormat(); 
        short dataFormat = df.getFormat("0.00");
        cs2.setDataFormat(dataFormat);
        HSSFFont f = libro.createFont();
        f.setFontHeightInPoints((short) 20);
        f.setColor(new HSSFColor().getIndex());
        f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        
        HSSFFont f2 = libro.createFont();
        f2.setFontHeightInPoints((short) 11);
        f2.setColor(new HSSFColor().getIndex());
        f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // Se crea una fila dentro de la hoja
        HSSFRow fila = hoja.createRow(0);
        HSSFCell celda = fila.createCell((short)0);
        String texto = "";
        Double decimotercero=0.0;
        Double decimo=0.0;
        Double decimocuarto=0.0;
        int col =0;
        fila = hoja.createRow(col);
        celda = fila.createCell((short)col);
        texto = "Cedula";
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Nómina Guardias de Seguridad";
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Nº de Días Trabajados";
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Sueldo Base";
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Horas Extra";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "(-)IESS 9,45%";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Suplementario";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Prést. Comisariato";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Prést. Quirografario";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "IESS: Extensión a Cónyuges";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Prést. Hipotecario";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Prést. Empresa";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "MediLink";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Prést. Actividades Comunes";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Multas";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Fondos de Reserva";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Movilizacion";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Bono";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Decimo Tercero";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Decimo Cuarto";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Alimentacion";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Liquidacion";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        texto = "Reposiciones";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        col++;
        celda = fila.createCell((short)col);
        
        texto = "Pago "+mes;
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        
        col++;
        celda = fila.createCell((short)col);
        
        texto = "Decimo Tercero ";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        
        col++;
        celda = fila.createCell((short)col);
        
        texto = "Decimo Cuarto ";
        //texto.applyFont(f2);
        celda.setCellValue(texto);
        celda.setCellStyle(cs);
        
        
        String err="";
        
        double totalsueldo=0;
        double totalfondos=0;
        double totalsuplementaria=0;
        double totalsuplementaria2=0;
        double totalreserva=0;
        double totalmobi=0;
        double totalprestamos=0;
        double totalrep=0;
        double totalmultas=0;
        double totaliess=0;
        double totalextra=0;
        double total=0;
        double fondos = 0.0;
        double totalcomisariato=0;
        double totalhipotecario=0;
        double totalquirografario=0;
        double totalprestamosempresa=0;
        double totalprestamoiess=0;
        double totalprestamoactividades=0;
        double totalprestamomedi=0;
        double hor=0;
        double rep=0;
        
        double comisariato=0;
        double hipotecario=0;
        double quirografario=0;
        double prestamosempresa=0;
        double prestamoiess=0;
        double prestamoactividades=0;
        double prestamomedi=0;
        int linea=1;
        try {
            if(roles!=null){
                for(Roles i: roles){
                    if(i.getDepa().equalsIgnoreCase("Seguridad Fisica")){
                        err=i.getNombre();
                        col=0;
                        cont=0.0;
                        decimo=0.0;
                        err= i.getCi();
                        fila = hoja.createRow(linea);
                        
                        /*-------Cedula-------*/
                        celda = fila.createCell((short)col);
                        texto = i.getCedula();
                        celda.setCellValue(texto);
                        celda.setCellStyle(cs);
                        
                        /*-------Nombre-------*/
                        col++;
                        celda = fila.createCell((short)col);
                        texto = i.getNombre();
                        celda.setCellValue(texto);
                        celda.setCellStyle(cs);
                        
                        /*-------Dias-------*/
                        col++;
                        texto = i.getDias();
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        cont= Double.parseDouble(i.getSueldo());
                        totalsueldo=totalsueldo+cont;
                        
                        /*-------Sueldo Base-------*/
                        texto = df2.format(cont).replace(",", ".");
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        cont=0.0;
                        
                        /*-------Horas Extra-------*/
                        cont = Double.parseDouble(i.getSuplementaria2());
                        texto = df2.format(cont).replace(",", ".");
                        totalsuplementaria2=totalsuplementaria2+cont;
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------IESS-------*/
                        texto = "-"+df2.format(Double.parseDouble(i.getIess())).replace(",", ".");
                        totaliess= totaliess + Double.parseDouble(i.getIess());
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------Suplementario-------*/
                        
                        texto = df2.format(Double.parseDouble(i.getSuplementaria())).replace(",", ".");
                        totalsuplementaria= totalsuplementaria + Double.parseDouble(i.getSuplementaria());
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------Prestamos -------*/
                        comisariato= Float.parseFloat(i.getPrestamo1());
                        quirografario=Float.parseFloat(i.getPrestamo2());
                        hipotecario=Float.parseFloat(i.getPrestamo4());
                        prestamosempresa=Float.parseFloat(i.getPrestamo5());
                        prestamoiess=Float.parseFloat(i.getPrestamo3());
                        prestamoactividades=Float.parseFloat(i.getPrestamo7());
                        prestamomedi=Float.parseFloat(i.getPrestamo8());
                        cont=cont+comisariato+quirografario+hipotecario+prestamosempresa+prestamoiess+prestamoactividades+prestamomedi;
                        
                        totalcomisariato=totalcomisariato+comisariato;
                        totalquirografario=totalquirografario+quirografario;
                        totalhipotecario=totalhipotecario+hipotecario;
                        totalprestamosempresa=totalprestamosempresa+prestamosempresa;
                        totalprestamoiess=totalprestamoiess+prestamoiess;
                        totalprestamoactividades=totalprestamoactividades+prestamoactividades;
                        totalprestamomedi=totalprestamomedi+prestamomedi;
                        /*-------Prestamos Comisariato -------*/
                        col++;
                        texto = ""+df2.format(comisariato).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Prestamos Quirografario-------*/
                        col++;
                        texto = ""+df2.format(quirografario).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Prestamos Extension de Pension-------*/
                        col++;
                        texto = ""+df2.format(prestamoiess).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Prestamos Hipotecario-------*/
                        col++;
                        texto = ""+df2.format(hipotecario).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Prestamos Empresarial-------*/
                        col++;
                        texto = ""+df2.format(prestamosempresa).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Prestamos Actividades-------*/
                        col++;
                        texto = ""+df2.format(prestamomedi).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Prestamos Actividades-------*/
                        col++;
                        texto = ""+df2.format(prestamoactividades).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        comisariato=0;
                        hipotecario=0;
                        quirografario=0;
                        prestamosempresa=0;
                        prestamoiess=0;
                        prestamoactividades=0;
                        prestamomedi=0;
                        cont=0.0;
                        
                        cont=(double)Float.parseFloat(i.getMultas());
                        
                        if(cont==0.0){
                            texto = "0.00";
                        }else{
                            texto = df2.format(cont*-1).replace(",", ".");
                            totalmultas= totalmultas + cont;
                        }
                        /*-------Multas -------*/
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)*-1));
                        celda.setCellStyle(cs2);
                        cont=0.0;
                        hor=0.0;
                        rep=0.0;
                        
                        cont=cont+Float.parseFloat(i.getReposiciones());
                        rep=rep+Float.parseFloat(i.getReposiciones());
                        totalrep= totalrep+Float.parseFloat(i.getReposiciones()); 
                        fondos=0.0;
                        
                        totalfondos= totalfondos+ Double.parseDouble(i.getFondos());

                        cont=cont+Double.parseDouble(i.getBonos());
                        hor=hor+Double.parseDouble(i.getBonos());
                        totalextra= totalextra + Double.parseDouble(i.getBonos());
                        /*-------Fondos Reserva -------*/
                        texto = df2.format(Double.parseDouble(i.getFondos())).replace(",", ".");
                        totalreserva= totalreserva + Double.parseDouble(i.getFondos());
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Mobilizacion -------*/
                        texto = df2.format(Double.parseDouble(i.getMobilizacion())).replace(",", ".");
                        totalmobi= totalmobi + Double.parseDouble(i.getMobilizacion());
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        /*-------Bonos -------*/
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getBon())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getDecimotercero())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getDecimocuarto())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        if(i.getDecimocuarto().equalsIgnoreCase("0")){
                            decimocuarto= decimocuarto+ (354.00/12.00);  
                        }
                        if(i.getDecimotercero().equalsIgnoreCase("0")){
                            decimotercero= decimotercero+ (Double.parseDouble(i.getSueldo())/12)+(Double.parseDouble(i.getAlimentacion())/12)+(Double.parseDouble(i.getBon())/12)+(Double.parseDouble(i.getReposiciones())/12)+(Double.parseDouble(i.getSuplementaria())/12)+(Double.parseDouble(i.getSuplementaria2())/12);  
                            decimo=(Double.parseDouble(i.getSueldo())/12)+(Double.parseDouble(i.getAlimentacion())/12)+(Double.parseDouble(i.getBon())/12)+(Double.parseDouble(i.getReposiciones())/12)+(Double.parseDouble(i.getSuplementaria())/12)+(Double.parseDouble(i.getSuplementaria2())/12);  
                        }
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getAlimentacion())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getLiquidacion())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        /*-------Reposiciones -------*/
                        if(cont==0.0){
                            texto = "0.00";
                        }else{
                            texto = df2.format(rep).replace(",", ".");
                        }
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------Total Pago Mes -------*/
                        col++;
                        celda = fila.createCell((short)col);
                        texto = df2.format(Double.parseDouble(i.getTotal())).replace(",", ".");
                        total= total + Double.parseDouble(i.getTotal());
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------Decimo Tercero-------*/
                        col++;
                        celda = fila.createCell((short)col);
                        texto = df2.format(decimo).replace(",", ".");
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------Decimo Cuarto-------*/
                        col++;
                        celda = fila.createCell((short)col);
                        if(!i.getDecimocuarto().equalsIgnoreCase("0")){
                        texto = df2.format(0).replace(",", ".");
                        }else{
                        texto = df2.format((354.00/12.00)).replace(",", ".");
                        }
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        
                        linea++;
                    }
                }
            }
            int coltt=0;
            fila = hoja.createRow(linea);
            celda = fila.createCell((short)coltt);
            texto = "TOTAL";
            celda.setCellType(Cell.CELL_TYPE_STRING);
            celda.setCellValue(texto);
            celda.setCellStyle(cs2);
            coltt++;
            texto = "";
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(texto);
            celda.setCellStyle(cs2);
            coltt++;
            texto = "";
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(texto);
            celda.setCellStyle(cs2);
            coltt++;
            //Sueldo
            texto = df2.format(totalsueldo).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            //
            texto = df2.format(totalsuplementaria2).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            
            texto = df2.format(totaliess).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalsuplementaria).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalcomisariato).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalquirografario).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            texto = df2.format(totalprestamoiess).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            
            texto = df2.format(totalhipotecario).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalprestamosempresa).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalprestamomedi).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalprestamoactividades).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalmultas).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalfondos).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            coltt++;
            celda = fila.createCell((short)coltt);
            texto = df2.format(totalrep).replace(",", ".");
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            coltt++;
            celda = fila.createCell((short)coltt);
            texto = df2.format(total).replace(",", ".");
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            
            //-----------------------------------------------------------------------------------------//
            linea++;
            linea++;
            comisariato=0;
            hipotecario=0;
            quirografario=0;
            prestamosempresa=0;
            prestamoiess=0;
            prestamoactividades=0;
            prestamomedi=0;
            totalcomisariato=0;
            totalhipotecario=0;
            totalquirografario=0;
            totalprestamosempresa=0;
            totalprestamoiess=0;
            totalprestamoactividades=0;
            totalprestamomedi=0;
            col=0;
            fila = hoja.createRow(linea);
            
            celda = fila.createCell((short)col);
            texto = "Cedula";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            
            celda = fila.createCell((short)col);
            texto = "Nómina Administrativa";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Nº de Días Trabajados";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Sueldo";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Comisiones";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "(-)IESS 9,45%";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Suplementario";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Prést. Comisariato";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Prést. Quirografario";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "IESS: Extensión a Cónyuges";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            
            celda = fila.createCell((short)col);
            texto = "Prést. Hipotecario";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Prést. Empresa";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Medilink";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Prést. Actividades Comunes";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Multas";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Fondos de Reserva";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Movilizacion";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Bono";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Decimo Tercero";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Decimo Cuarto";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Alimentacion";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Liquidacion";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            col++;
            celda = fila.createCell((short)col);
            texto = "Pago "+mes;
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            
            col++;
            celda = fila.createCell((short)col);

            texto = "Decimo Tercero ";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            
            col++;
            celda = fila.createCell((short)col);

            texto = "Decimo Cuarto ";
            //texto.applyFont(f2);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            
            df2 = new DecimalFormat("#.##");
            err="";
            totalsueldo=0;
            totalprestamos=0;
            totalfondos=0;
            totalmultas=0;
            totaliess=0;
            double totalmovi=0;
            double totalcomi=0;
            totalrep=0;
            totalextra=0;
            totalsuplementaria=0;
            totalsuplementaria2=0;
            total=0;
            linea++;
            if(roles!=null){
                for(Roles i: roles){
                    if(i.getDepa().equalsIgnoreCase("Seguridad Fisica")){}
                    else{
                        err=i.getNombre();
                        col=0;
                        cont=0.0;
                        err= i.getCi();
                        decimo=0.0;
                        
                        fila = hoja.createRow(linea);
                        /*-------Cedula-------*/
                        celda = fila.createCell((short)col);
                        texto = i.getCi();
                        celda.setCellValue(texto);
                        celda.setCellStyle(cs);
                        
                        /*-------Nombre-------*/
                        col++;
                        texto = i.getNombre();
                        celda = fila.createCell((short)col);
                        celda.setCellValue(texto);
                        celda.setCellStyle(cs);
                        col++;
                        texto = i.getDias();
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        cont= Double.parseDouble(i.getSueldo());
                        totalsueldo=totalsueldo+cont;
                        texto = df2.format(cont).replace(",", ".");
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        cont=0.0;
                        
                        cont= Double.parseDouble(i.getComisiones());
                        totalcomi=totalcomi+cont;
                        texto = df2.format(cont).replace(",", ".");
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        cont=0.0;
                        
                        texto = "-"+df2.format(Double.parseDouble(i.getIess())).replace(",", ".");
                        totaliess= totaliess + Double.parseDouble(i.getIess());
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        cont = Double.parseDouble(i.getSuplementaria());
                        totalsuplementaria= totalsuplementaria+cont;
                        if(cont==0.0){
                            texto = "0.00";
                        }else{
                            texto = df2.format(cont).replace(",", ".");
                        }
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        comisariato= Float.parseFloat(i.getPrestamo1());
                        quirografario=Float.parseFloat(i.getPrestamo2());
                        hipotecario=Float.parseFloat(i.getPrestamo4());
                        prestamosempresa=Float.parseFloat(i.getPrestamo5());
                        prestamoiess=Float.parseFloat(i.getPrestamo3());
                        prestamoactividades=Float.parseFloat(i.getPrestamo7());
                        prestamomedi=Float.parseFloat(i.getPrestamo8());
                                
                        cont=cont+comisariato+quirografario+hipotecario+prestamosempresa+prestamoiess+prestamoactividades+prestamomedi;
                        
                        totalcomisariato=totalcomisariato+comisariato;
                        totalquirografario=totalquirografario+quirografario;
                        totalhipotecario=totalhipotecario+hipotecario;
                        totalprestamosempresa=totalprestamosempresa+prestamosempresa;
                        totalprestamoiess=totalprestamoiess+prestamoiess;
                        totalprestamoactividades=totalprestamoactividades+prestamoactividades;
                        totalprestamomedi=totalprestamomedi+prestamomedi;
                        col++;
                        texto = df2.format(comisariato).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        col++;
                        texto = df2.format(quirografario).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        col++;
                        texto = df2.format(prestamoiess).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        col++;
                        texto = df2.format(hipotecario).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        col++;
                        texto = df2.format(prestamosempresa).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        col++;
                        texto = df2.format(prestamomedi).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        col++;
                        texto = ""+df2.format(prestamoactividades).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        comisariato=0;
                        hipotecario=0;
                        quirografario=0;
                        prestamosempresa=0;
                        prestamoiess=0;
                        prestamoactividades=0;
                        prestamomedi=0;
                        cont=0.0;
                        
                        
                        cont=(double)Float.parseFloat(i.getMultas());
                        
                        if(cont==0.0){
                            texto = "0.00";
                        }else{
                            texto = df2.format(cont).replace(",", ".");
                            totalmultas= totalmultas + cont;
                        }
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        cont=0.0;
                        hor=0.0;
                        rep=0.0;
                        cont=cont+Float.parseFloat(i.getReposiciones());
                        rep=rep+Float.parseFloat(i.getReposiciones());
                        totalrep= totalrep+Float.parseFloat(i.getReposiciones());
                        
                        fondos=0.0;
                        totalfondos= totalfondos+ Double.parseDouble(i.getFondos());
                        cont=cont+Double.parseDouble(i.getBonos());
                        hor=hor+Double.parseDouble(i.getBonos());
                        totalextra= totalextra+Double.parseDouble(i.getBonos());
                        col++;
                        
                        texto = df2.format(Double.parseDouble(i.getFondos())).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        col++;
                        
                        cont = Double.parseDouble(i.getMobilizacion());
                        totalmovi= totalmovi+cont;
                        texto = df2.format(cont).replace(",", ".");
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getBon())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getDecimotercero())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getDecimocuarto())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        if(i.getDecimocuarto().equalsIgnoreCase("0")){
                            decimocuarto= decimocuarto+ (354.00/12.00);  
                        }
                        if(i.getDecimotercero().equalsIgnoreCase("0")){
                            decimotercero= decimotercero+ (Double.parseDouble(i.getSueldo())/12)+(Double.parseDouble(i.getAlimentacion())/12)+(Double.parseDouble(i.getBon())/12)+(Double.parseDouble(i.getReposiciones())/12)+(Double.parseDouble(i.getSuplementaria())/12)+(Double.parseDouble(i.getSuplementaria2())/12);  
                            decimo=(Double.parseDouble(i.getSueldo())/12)+(Double.parseDouble(i.getAlimentacion())/12)+(Double.parseDouble(i.getBon())/12)+(Double.parseDouble(i.getReposiciones())/12)+(Double.parseDouble(i.getSuplementaria())/12)+(Double.parseDouble(i.getSuplementaria2())/12);  
                        }
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getAlimentacion())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(df2.format(Double.parseDouble(i.getLiquidacion())).replace(",", "."))));
                        celda.setCellStyle(cs2);
                        
                        col++;
                        celda = fila.createCell((short)col);
                        texto = df2.format(Double.parseDouble(i.getTotal())).replace(",", ".");
                        total= total + Double.parseDouble(i.getTotal());
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------Decimo -------*/
                        col++;
                        celda = fila.createCell((short)col);
                        texto = df2.format(decimo).replace(",", ".");
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        /*-------Decimo Cuarto-------*/
                        col++;
                        celda = fila.createCell((short)col);
                        if(!i.getDecimocuarto().equalsIgnoreCase("0")){
                        texto = df2.format(0).replace(",", ".");
                        }else{
                        texto = df2.format((354.00/12.00)).replace(",", ".");
                        }
                        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
                        celda.setCellValue(parse(Float.parseFloat(texto)));
                        celda.setCellStyle(cs2);
                        
                        linea++;
                    }
                }
            }
            coltt=0;
            fila = hoja.createRow(linea);
            celda = fila.createCell((short)coltt);
            texto = "TOTAL";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            coltt++;
            
            texto = "";
            celda = fila.createCell((short)coltt);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            coltt++;
            coltt++;
            texto = "";
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(texto);
            celda.setCellStyle(cs2);
            texto = df2.format(totalsueldo).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalcomi).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totaliess).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            
            coltt++;
            texto = df2.format(totalsuplementaria).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            
            texto = df2.format(totalcomisariato).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalquirografario).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalprestamoiess).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalhipotecario).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            texto = df2.format(totalprestamosempresa).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            texto = df2.format(totalprestamomedi).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            texto = df2.format(totalprestamoactividades).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            
            texto = df2.format(totalmultas).replace(",", ".");
            coltt++;
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)*-1));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(totalfondos).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            coltt++;
            texto = df2.format(totalmovi).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            coltt++;
            texto = df2.format(0).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            cont=0.0;
            
            coltt++;
            celda = fila.createCell((short)coltt);
            texto = df2.format(total).replace(",", ".");
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            linea++;
            linea++;
            fila = hoja.createRow(linea);
            
            coltt=0;
            fila = hoja.createRow(linea);
            celda = fila.createCell((short)coltt);
            texto = "Decimos";
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            coltt++;
            
            texto = "Tercero";
            celda = fila.createCell((short)coltt);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            coltt++;
            
            texto = df2.format(decimotercero).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            
            coltt++;
            texto = "Cuarto";
            celda = fila.createCell((short)coltt);
            celda.setCellValue(texto);
            celda.setCellStyle(cs);
            
            coltt++;
            texto = df2.format(decimocuarto).replace(",", ".");
            celda = fila.createCell((short)coltt);
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
            celda.setCellValue(parse(Float.parseFloat(texto)));
            celda.setCellStyle(cs2);
            
            
            FileOutputStream elFichero;
            //elFichero = new FileOutputStream("C:\\Users\\Cajamarca RRHH\\Desktop\\"+mes+anio+"roles.xls");
            elFichero = new FileOutputStream(dir+mes+anio+"roles.xls");
            
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            System.out.println(err);
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int respuesta = chooser.showOpenDialog(this);
        String cadena="";
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            cadena = chooser.getSelectedFile().getAbsolutePath();
            try{
                String mes=jComboBox1.getSelectedItem().toString();
                String anio=jComboBox2.getSelectedItem().toString();
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                List<Roles> r = helper.getRolesgenerales(mes, anio);
                helper.cerrarSesion();
                crearexcel(r,mes,anio,cadena);
            }catch(Exception io){

            }
        }
    }//GEN-LAST:event_jButton4MouseClicked

    public void crearexcel(List<Roles> roles, String mes, String anio, String dir) {
        // Se crea el libro
        HSSFWorkbook libro = new HSSFWorkbook();
        // Se crea una hoja dentro del libro
        
        HSSFSheet hoja = libro.createSheet();
        hoja.setColumnWidth((short)0, (short)1500);
        hoja.setColumnWidth((short)1, (short)4000);
        hoja.setColumnWidth((short)2, (short)1500);
        hoja.setColumnWidth((short)3, (short)1500);
        hoja.setColumnWidth((short)4, (short)1500);
        hoja.setColumnWidth((short)5, (short)1500);
        hoja.setColumnWidth((short)6, (short)4000);
        
        hoja.setColumnWidth((short)7, (short)7000);
        hoja.setColumnWidth((short)8, (short)1000);
        hoja.setColumnWidth((short)9, (short)4000);
        hoja.setColumnWidth((short)10, (short)7000);
        hoja.setColumnWidth((short)11, (short)5000);
        hoja.setColumnWidth((short)12, (short)12000);
        HSSFCellStyle cs = libro.createCellStyle();
        HSSFCellStyle cs2 = libro.createCellStyle();
        
        HSSFDataFormat df = libro.createDataFormat();
        HSSFFont f = libro.createFont();
        f.setFontHeightInPoints((short) 12);
        f.setColor(new HSSFColor().getIndex());
        f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        
        HSSFFont f2 = libro.createFont();
        f2.setFontHeightInPoints((short) 10);
        f2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        
        // Se crea una fila dentro de la hoja
        HSSFRow fila = null;
        HSSFCell celda = null;
        String texto = "";
        
        int emp=0;
        int linea=-1;
        String err="";
        try {
            if(roles!=null){
                for(Roles i: roles){
                    emp++;
                    linea++;
                    fila = hoja.createRow(linea);
                    texto = "PA";
                    celda = fila.createCell((short)0);
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    if((i.getCuentaci()!=null)){
                        if(i.getCuentaci().split("")[0]=="9"){
                            texto = "0"+i.getCuentaci();
                        }else{
                            texto = i.getCuentaci();
                        }
                    }else{
                        texto = i.getNombre();
                    }
                    celda = fila.createCell((short)1);
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)2);
                    texto = "USD";
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    
                    texto = formatoexcel(i.getTotal());
                    celda = fila.createCell((short)3);
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)4);
                    texto = "CTA";
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)5);
                    texto = i.getCuentatipo();
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)6);
                    texto = i.getCuentanum();
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)7);
                    texto = "Pago de Rol "+mes+" "+anio;
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)8);
                    texto = "C";
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)9);
                    if((i.getCuentaci()!=null)){
                        if(i.getCuentaci().split("")[0]=="9"){
                            texto = "0"+i.getCuentaci();
                        }else{
                            texto = i.getCuentaci();
                        }
                    }else{
                        texto = i.getNombre();
                    }
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)10);
                    texto = i.getCuentadue();
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)11);
                    texto = i.getBanco();
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                    
                    celda = fila.createCell((short)12);
                    texto = i.getNombre();
                    celda.setCellValue(texto);
                    celda.setCellStyle(cs2);
                }
            }
            FileOutputStream elFichero;
            //elFichero = new FileOutputStream("C:\\Users\\Cajamarca RRHH\\Desktop\\"+mes+anio+"Transferencias.xls");
            elFichero = new FileOutputStream(dir+"\\"+mes+anio+"Transferencias.xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception ex) {
            
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
    public String formatoexcel(String campo){
        String[] val = campo.split("\\.",0);
        String retorno="";
        if(val.length==1){
            retorno = val[0]+"00";
        }else if(val[1].length()==1){
            retorno = val[0]+val[1]+"0";
        }else{
            retorno = val[0]+val[1];
        }
        
        return retorno;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
