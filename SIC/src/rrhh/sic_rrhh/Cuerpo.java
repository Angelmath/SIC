/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

import Login.Entidad.Login;
import Login.ventas.CellRenderer;
import Login.ventas.HeaderCellRenderer;
import Login.ventas.Principal;
import Login.ventas.permisos;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.HeaderFooter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import rrhh.Entidad.Empleado;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import rrhh.Entidad.Anticipos;
import rrhh.Entidad.Bono;
import rrhh.Entidad.Comisiones;
import rrhh.Entidad.CvEstudio;
import rrhh.Entidad.CvLaboral;
import rrhh.Entidad.DeptEmpl;
import rrhh.Entidad.Evaluacion;
import rrhh.Entidad.Horas;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Otros;
import rrhh.Entidad.Permisos;
import rrhh.Entidad.Prestamos;
import rrhh.Entidad.Pruebasf;
import rrhh.Entidad.Roles;
import rrhh.servicio.Funcion;
import rrhh.servicio.ServiceHb;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import rrhh.Entidad.Departamento;
import static rrhh.sic_rrhh.lista_departamentos.getUltimoDiaDelMes;

/**
 *
 * @author Matheus
 */
public final class Cuerpo extends javax.swing.JFrame {
    Dimension d;
    Login log;
    Empleado empleado;
    inicio inicio_panel= new inicio();
    reportes_roles paneroles= new reportes_roles();
    reportes report ;
    reportes2 report2 = new reportes2();
    ausentismo au;
    reportes_estadistico estadistico = new reportes_estadistico();
    ingresos paneingresos= new ingresos();
    egresos paneegresos= new egresos();
    notificaciones noti= new notificaciones();
    ingresar_empleado ing;
    editar_empleado1 edi;
    lista_empleados listemp = new lista_empleados();
    lista_departamentos listdept = new lista_departamentos();
    perfil_empleado perfil=new perfil_empleado();
    perfil_empleado_base perfil1 = new perfil_empleado_base();
    perfil_empleado_desempeno perfil2 = new perfil_empleado_desempeno();
    perfil_empleado_historia perfil3 = new perfil_empleado_historia();
    perfil_empleado_medico perfil4 = new perfil_empleado_medico();
    perfil_empleado_pdf perfil5 = new perfil_empleado_pdf();
    perfil_empleado_pruebasfisicas perfil6 = new perfil_empleado_pruebasfisicas();
    ArrayList position = new ArrayList();
    int nav_seleccionado=1; // Controla la animaciones del nav izquierdo
    boolean configuracion=false; // Controla el boton de cerrar secion y configuracion
    boolean trampa=false;
    String departamentoguardia;
    Empleado emptemp;
    Evaluacion evatemp;
    int xx;
    int yy;
    int sortColumn;
    int[] row;
    DefaultTableModel base;
    JPanel anterior = new JPanel();/*Back entre Paneles*/
    
    public void cedeno(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Empleado> ltemp = helper.getPersonasBycedeno();
            if(ltemp!=null){
                for(Empleado i: ltemp){
                    List<CvEstudio> ce= helper.getCvEstudioAll(""+i.getCi());
                    if(ce!=null){
                        for(CvEstudio x:ce){
                            String ci= i.getCid();
                            String nombre= i.getNombre1()+";"+i.getNombre2()+";"+i.getApellido1()+";"+i.getApellido2();
                            String descripcion= x.getPais()+";"+x.getNivel()+";"+x.getInstitucion()+";"+x.getArea();
                            if(x.getFechaInicio()!=null){
                                descripcion= descripcion +";Inicio: "+Funcion.DateFormatSql(x.getFechaInicio());
                            }
                            if(x.getFechaFinal()!=null){
                                descripcion= descripcion +";Fin: "+Funcion.DateFormatSql(x.getFechaFinal());
                            }
                            System.out.println(ci+";"+nombre+";"+descripcion);
                        }
                    }
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    /**
     * Creates new form Cuerpo
     */
    public class evaluacion implements Comparable<evaluacion>{
        int valor;
        String dueño;
        
        public int getValor() {
            return valor;
        }
        
        public void setValor(int valor) {
            this.valor = valor;
        }
        
        public String getDueño() {
            return dueño;
        }
        
        public void setDueño(String dueño) {
            this.dueño = dueño;
        }
        
        @Override
        public int compareTo(evaluacion o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    public void evaluacion(){
        List<Evaluacion> evaluacion2;
        List<Empleado> emplea=null;
        try{
            ServiceHb helper2 = new ServiceHb();
            helper2.iniciarTransaccion();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString = "01-10-2015 01:20:56";
            Date date = sdf.parse(dateInString);
            evaluacion2= helper2.getEvaluacionByTipoO(Funcion.DateFormatSql(date));
            ArrayList lt = new ArrayList();
            for(Evaluacion eva : evaluacion2){
                perfil2.getjTextField1a().setText(eva.getCampo11());
                perfil2.getjTextField2a().setText(eva.getCampo12());
                perfil2.getjTextField3a().setText(eva.getCampo13());
                perfil2.getjTextField4a().setText(eva.getCampo21());
                perfil2.getjTextField5a().setText(eva.getCampo22());
                
                float val1= (Float.parseFloat(eva.getCampo11())+Float.parseFloat(eva.getCampo12())+Float.parseFloat(eva.getCampo13())+Float.parseFloat(eva.getCampo21())+Float.parseFloat(eva.getCampo22()))/5;
                perfil2.getjTextField3a1().setText(Float.toString(val1));
                
                perfil2.getjTextField6a().setText(eva.getCampo23());
                perfil2.getjTextField7a().setText(eva.getCampo24());
                perfil2.getjTextField8a().setText(eva.getCampo25());
                perfil2.getjTextField9a().setText(eva.getCampo31());
                perfil2.getjTextField10a().setText(eva.getCampo32());
                perfil2.getjTextField11a().setText(eva.getCampo33());
                float val2= (Float.parseFloat(eva.getCampo23())+Float.parseFloat(eva.getCampo24())+Float.parseFloat(eva.getCampo25())+Float.parseFloat(eva.getCampo31())+Float.parseFloat(eva.getCampo32())+Float.parseFloat(eva.getCampo33()))/6;
                perfil2.getjTextField3a2().setText(Float.toString(val2));
                
                perfil2.getjTextField12a().setText(eva.getCampo41());
                perfil2.getjTextField13a().setText(eva.getCampo42());
                perfil2.getjTextField14a().setText(eva.getCampo43());
                float val3= (Float.parseFloat(eva.getCampo41())+Float.parseFloat(eva.getCampo42())+Float.parseFloat(eva.getCampo43()))/3;
                perfil2.getjTextField3a3().setText(Float.toString(val3));
                
                
                perfil2.getjTextField15a().setText(eva.getCampo44());
                perfil2.getjTextField16a().setText(eva.getCampo51());
                perfil2.getjTextField17a().setText(eva.getCampo52());
                perfil2.getjTextField18a().setText(eva.getCampo53());
                float val4= (Float.parseFloat(eva.getCampo44())+Float.parseFloat(eva.getCampo51())+Float.parseFloat(eva.getCampo52())+Float.parseFloat(eva.getCampo53()))/4;
                perfil2.getjTextField3a4().setText(Float.toString(val4));
                
                perfil2.getjTextField19a().setText(eva.getCampo61());
                perfil2.getjTextField20a().setText(eva.getCampo62());
                perfil2.getjTextField21a().setText(eva.getCampo63());
                float val5= (Float.parseFloat(eva.getCampo61())+Float.parseFloat(eva.getCampo62())+Float.parseFloat(eva.getCampo63()))/3;
                perfil2.getjTextField3a5().setText(Float.toString(val5));
                
                
                float val7= (val1+val2+val3+val4+val5)/5;
                perfil2.getjTextField3a7().setText(Float.toString(val7));
                
                if(0<val7&& val7<=1){
                    perfil2.getjLabel35().setBackground(Color.red);
                }
                if(1<val7&& val7<=2){
                    perfil2.getjLabel36().setBackground(Color.red);
                }
                if(2<val7&& val7<=3){
                    perfil2.getjLabel37().setBackground(Color.yellow);
                }
                if(3<val7&& val7<=4){
                    perfil2.getjLabel38().setBackground(Color.green);
                }
                if(4<val7&& val7<=5){
                    perfil2.getjLabel1().setBackground(Color.green);
                }
                try{
                    Empleado em = helper2.getPersonasCid(eva.getCi());
                    if(em!=null){
                        evaluacion e = new evaluacion();
                        e.dueño=em.getApellido1() + " " + em.getNombre1();
                        e.valor= (int)((double)val7*100);
                        lt.add(e);
                    }else{
                        em = helper2.getPersonasCid2(eva.getCi());
                        if(em!=null){
                            evaluacion e = new evaluacion();
                            e.dueño=em.getApellido1() + " " + em.getNombre1();
                            e.valor= (int)((double)val7*100);
                            lt.add(e);
                        }
                    }
                }catch(Exception io){}
                //System.out.println(em.getApellido1() + " " + em.getNombre1() + " Calificación: "+ Float.toString(val7) + " fecha: "+ eva.getFecha());
                
                Collections.sort(lt, new Comparator<evaluacion>() {
                    @Override
                    public int compare(evaluacion p1, evaluacion p2) {
                        return new Integer(p1.getValor()).compareTo(p2.getValor());
                    }
                });
                
            }
            helper2.cerrarSesion();
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            for (Object lt1 : lt) {
                System.out.println(((evaluacion) lt1).getDueño() + " " + df.format(((float) ((evaluacion) lt1).getValor()) / 100));
            }
        }catch(Exception io){
            
        }
    }
    public void enviocorreos() throws DocumentException{
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        Date f = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(f);
        String anio=Integer.toString(calendar.get(Calendar.YEAR));
        String mes=fecha[calendar.get(Calendar.MONTH)];
        pdftotalindividual();
        //        try{
        //            ServiceHb helper = new ServiceHb();
        //            helper.iniciarTransaccion();
        //            Correos co = helper.getCorreos(mes,anio);
        //            if(co!=null){
        //                if(co.getEnvio()!=null){
        //                    JavaMail jm = new JavaMail();
        //                    jm.email("","Ausentimos y Multas", "Se adjunta el pdf que contiene datos por departamentos del Ausentismo y Multas");
        //                    co.setEnvio("SI");
        //                }else{
        //
        //                }
        //            }else{
        //                JavaMail jm = new JavaMail();
        //                jm.email("","Ausentimos y Multas", "Se adjunta el pdf que contiene datos por departamentos del Ausentismo y Multas");
        //                co.setEnvio("SI");
        //            }
        //            helper.actualizarObjeto(co);
        //            helper.confirmarTransaccion();
        //            helper.cerrarSesion();
        //        }catch(Exception io){
        //
        //        }
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
    public void pdftotalindividual() throws DocumentException{
        //String imagepath = Server.MapPath("Images");
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        try
        {
            ficheroPdf = new FileOutputStream("C:\\Users\\Matheus\\Desktop\\pruebas\\individuales\\correos.pdf");
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
        }
        catch (FileNotFoundException | DocumentException ex)
        {
            System.out.println(ex.toString());
        }
        documento.open();
        Paragraph parrafo1 = new Paragraph("INFORMACION MULTAS",new Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0)));
        documento.add(parrafo1);
        PdfPCell celda;
        
        ServiceHb helper;
        ArrayList<String> lst;
        Date f = new Date();
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(f);
        List<Departamento> dep=null;
        int num;
        try{
            num=3;
            lst= buscames(num);
            if(lst!=null){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                dep=helper.getdepartamentosByTipo();
                ArrayList<Double> l;
                ArrayList<String> l2;
                ArrayList<Integer> l3;
                
                ArrayList<Double> m;
                ArrayList<String> m2;
                ArrayList<Integer> m3;
                
                ArrayList<Double> g;
                ArrayList<String> g2;
                ArrayList<Integer> g3;
                for(Departamento x: dep){
                    PdfPTable border = new PdfPTable(7);
                    documento.add(new Paragraph(x.getNombre()));
                    l = new ArrayList<>();
                    l2 = new ArrayList<>();
                    l3 = new ArrayList<>();

                    m = new ArrayList<>();
                    m2 = new ArrayList<>();
                    m3 = new ArrayList<>();

                    g = new ArrayList<>();
                    g2 = new ArrayList<>();
                    g3 = new ArrayList<>();
                    for(String i: lst){
                        String mes= i.split("/")[0];
                        String anio= i.split("/")[1];
                        List<Empleado> em;
                        em = helper.getPersonasdepartamento(x.getNombre());
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
                                    if(""+c.getCi()==z.getCi()){
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
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Phrase("FECHA"));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Phrase("N°"));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Phrase("Leve"));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Phrase("N°"));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Phrase("Media"));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Phrase("N°"));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Phrase("Grave"));
                    border.addCell(celda);
                    
                    for(int i=0; i<l.size();i++){
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(l2.get(i),new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(l3.get(i)),new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("$" +l.get(i),new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(l3.get(i)),new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("$" +m.get(i),new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(l3.get(i)),new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("$" +g.get(i),new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                    }
                    documento.add(border);
                }
                helper.cerrarSesion();
                
            }
            
        }catch(Exception io){
            
        }
        parrafo1 = new Paragraph("INFORMACION AUSENTISMO",new Font(com.itextpdf.text.Font.HELVETICA, 7, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0)));
        documento.add(parrafo1);
            try{
                num=3;
                lst= buscames(num);
                ArrayList<ausen> lt;
                if(lst!=null){
                helper = new ServiceHb();
                helper.iniciarTransaccion();
                String x="";
                String y="";
                for(Departamento v: dep){
                lt = new ArrayList<>();
                PdfPTable border = new PdfPTable(14);
                documento.add(new Paragraph(v.getNombre()));
                int h=8;
                int empleados = 0;
                if(v.getNombre().equalsIgnoreCase("Seguridad Fisica")){
                    h=12;
                }
                int dias=0;
                for(String i: lst){
                    String mes= i.split("/")[0];
                    String anio= i.split("/")[1];
                    dias= getUltimoDiaDelMes(anio,mes);
                    String val= i.split("/")[2];
                    // LLamada a la Clase AUSEN
                    ausen al = new ausen();
                    //
                    List<Empleado> em ;
                    em = helper.getPersonasdepartamento(v.getNombre());
                    empleados=em.size();
                    List<Permisos> hor = helper.getPermisosByTipoindiall(fecha[Integer.parseInt(mes)],anio);
                    List<Multa> mul = helper.getMultamesByTipo3(fecha[Integer.parseInt(mes)],anio);
                    float multas=0;
                    if(mul!=null){
                        for(Multa z: mul){
                            for(Empleado c: em){
                                if(""+c.getCi()==z.getCi()){
                                    float temp=48000;
                                    if(c.getDeptEmpl().getDepartamento().getNombre().equalsIgnoreCase("Seguridad Fisica")){
                                        temp=72000;
                                    }
                                    if(z.getTipo().equalsIgnoreCase("FC")||z.getTipo().equalsIgnoreCase("F. Inj. - Av. con T.")){
                                        multas= multas+ temp;
                                        al.setFc(al.getFc()+(double)temp);
                                        al.setFc1((int) (al.getFc1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("FS")||z.getTipo().equalsIgnoreCase("F. Inj. - Av. sin T.")){
                                        multas= multas+ temp;
                                        al.setFs(al.getFs()+(double)temp);
                                        al.setFs1((int) (al.getFs1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("F")||z.getTipo().equalsIgnoreCase("F. Inj. - No Avisó")){
                                        multas= multas+ temp;
                                        al.setFf(al.getFf()+(double)temp);
                                        al.setFf1((int) (al.getFf1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("A")||z.getTipo().equalsIgnoreCase("Atraso - Avisó")){
                                        multas= multas+ Float.parseFloat(z.getMotivo());
                                        al.setA(al.getA()+Double.parseDouble(z.getMotivo()));
                                        al.setA1((int) (al.getA1()+1));
                                    }else
                                    if(z.getTipo().equalsIgnoreCase("AS")||z.getTipo().equalsIgnoreCase("Atraso - No Avisó")){
                                        multas= multas+ Float.parseFloat(z.getMotivo());
                                        al.setAs(al.getAs()+Double.parseDouble(z.getMotivo()));
                                        al.setAs1((int) (al.getAs1()+1));
                                    }
                                }
                            }   
                        }
                    }
                    if(hor!=null){
                        float var=0;
                            for(Permisos n: hor){
                                for(Empleado c: em){
                                    if(""+c.getCi()==n.getCi()){
                                        var= var+Float.parseFloat(n.getValor());
                                        al.setP(al.getP()+(Double.parseDouble(n.getValor())*100));
                                        al.setP1((int) (al.getP1()+1));
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
                    al.setFecha(fecha[Integer.parseInt(mes)]+" "+anio);
                    lt.add(al);
                }
                
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    
                    celda.setPhrase(new Paragraph("FECHA",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("N°",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("F. Inj. - Av. con T.",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("N°",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("F. Inj. - Av. sin T.",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("N°",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("F. Inj. - No Avisó",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("N°",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("Atraso - Avisó",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("N°",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("Atraso - No Avisó",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("N°",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("Permisos",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    celda = new PdfPCell();
                    celda.setBorder(0);
                    celda.setPhrase(new Paragraph("Total",new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                    border.addCell(celda);
                    
                    
                    DecimalFormat formateador = new DecimalFormat("####.####");
                    for (ausen lt1 : lt) {
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(lt1.getFecha(), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(lt1.getFc1()), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("%" + formateador.format((((lt1.getFc() / (60*h*dias)))) / empleados), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(lt1.getFs1()), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("%" + formateador.format((((lt1.getFs() / (60*h*dias)))) / empleados), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(lt1.getFf1()), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("%" + formateador.format((((lt1.getFf() / (60*h*dias)))) / empleados), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(lt1.getA1()), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("%" + formateador.format((((lt1.getA() / (60*h*dias)))) / empleados), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(lt1.getAs1()), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("%" + formateador.format((((lt1.getAs() / (60*h*dias)))) / empleados), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph(Integer.toString(lt1.getP1()), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        if(v.getNombre().equalsIgnoreCase("Sistemas")){
                            System.out.println("");
                        }
                        celda.setPhrase(new Paragraph("%" + formateador.format((((lt1.getP() / (60*h*dias)))) / empleados), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                        celda = new PdfPCell();
                        celda.setBorder(0);
                        celda.setPhrase(new Paragraph("%" + formateador.format(((((lt1.getFc() + lt1.getFs() + lt1.getFf() + lt1.getA() + lt1.getAs() + lt1.getP()) / (60*h*dias)))) / empleados), new com.itextpdf.text.Font(com.itextpdf.text.Font.HELVETICA, 6, com.itextpdf.text.Font.BOLD, new Color(0, 0, 0))));
                        border.addCell(celda);
                    }
                    documento.add(border);
                
                
                
                }
                helper.cerrarSesion();
                }
                
            }catch(Exception io){
            
            }
        
        documento.close();
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
            String fecha2;
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
    public void enviar(){
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Roles> lt = helper.getRolesByTipo();
            for(Roles i: lt){
                Empleado empe= (Empleado)helper.obtenerObjeto(Empleado.class, Integer.parseInt(i.getCi()));
                if(empe!=null){
                i.setCedula(empe.getCid());
                helper.actualizarObjeto(i);
                }
            }
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println("");
        }
    }
    
    public Cuerpo(Login l) throws DocumentException {
        initComponents();
        //cedeno();
        //evaluacion();
        //enviar();
        report = new reportes(l.getNivel());
        ing = new ingresar_empleado(l.getDireccionrrhh());
        edi = new editar_empleado1(l.getDireccionrrhh());
        au = new ausentismo();
        paneroles.getRol1().setdirrrhh(l.getDireccionrrhh());
        URL url = getClass().getResource("/Login/imagenes/venta_icono.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());
        
        report.getHoras().getjButton1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Horas est = new Horas();
                    est.setMotivo(report.getHoras().getjTextField5().getText());
                    est.setObservacion(report.getHoras().getjTextArea1().getText());
                    est.setTiempo(report.getHoras().getjTextField3().getText());
                    est.setMes(report.getHoras().getjComboBox6().getSelectedItem().toString());
                    est.setFecha(Funcion.DateFormat(report.getHoras().getjDateChooser1().getDate()));
                    est.setAnio(report.getHoras().getjComboBox5().getSelectedItem().toString());
                    est.setResponsable(log.getNombre());
                    est.setCi(report.getHoras().getjLabel1().getText());
                    helper.crearObjeto(est);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Hora Extra Agregada");
                    report.getHoras().setTemporal(false);
                    report.getHoras().llenar();
                }catch(Exception io){
                    
                }
            }
        });
        paneroles.getRol1().getjButton4().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            int respuesta = chooser.showOpenDialog(paneroles.getRol1());
            String cadena="";
            if (respuesta == JFileChooser.APPROVE_OPTION)
            {
                cadena = chooser.getSelectedFile().getAbsolutePath();
                String nombre="";
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    List<Roles> r = helper.getRolesgenerales(paneroles.getRol1().getjComboBox1().getSelectedItem().toString(),paneroles.getRol1().getjComboBox2().getSelectedItem().toString());
                    helper.cerrarSesion();
                    for(Roles i: r){
                        nombre=i.getNombre()+" "+i.getCi();
                        paneroles.getRol1().pdftotalindividual(paneroles.getRol1().getjComboBox1().getSelectedItem().toString(), paneroles.getRol1().getjComboBox2().getSelectedItem().toString(), "", i.getCi(),i.getNombre(),cadena);
                        
                    }
                    JOptionPane.showMessageDialog(null, "TERMINO!!");
                }catch(Exception io){
                    System.out.println(nombre);
                }
            }
            }
        });
        au.getPp().getjButton1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    rrhh.Entidad.Permisos est = new rrhh.Entidad.Permisos();
                    est.setMotivo(au.getPp().getjTextField5().getText());
                    est.setObservacion(au.getPp().getjTextArea1().getText());
                    est.setValor(au.getPp().getjTextField3().getText());
                    est.setMes(au.getPp().getjComboBox6().getSelectedItem().toString());
                    est.setFecha(Funcion.DateFormat(au.getPp().getjDateChooser1().getDate()));
                    est.setAnio(au.getPp().getjComboBox5().getSelectedItem().toString());
                    est.setResponsable(log.getNombre());
                    est.setCi(au.getPp().getjLabel1().getText());
                    helper.crearObjeto(est);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Hora Extra Agregada");
                    au.getPp().setTemporal(false);
                    au.getPp().llenar();
                }catch(Exception io){
                    
                }
            }
        });
        report.getOtros().getjButton5().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Otros est = new Otros();
                    est.setMotivo(report.getOtros().getjComboBox1().getSelectedItem().toString());
                    est.setObservacion(report.getOtros().getjTextArea4().getText());
                    est.setMes(report.getOtros().getjComboBox21().getSelectedItem().toString());
                    est.setFecha(Funcion.DateFormat(report.getOtros().getjDateChooser5().getDate()));
                    est.setAnio(report.getOtros().getjComboBox27().getSelectedItem().toString());
                    est.setAccion("A");
                    est.setValor(report.getOtros().getjTextField1().getText());
                    est.setResponsable(log.getNombre());
                    est.setCi(report.getOtros().getjLabel1().getText());
                    helper.crearObjeto(est);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Otros Agregado");
                    report.getOtros().setTemporal(false);
                    report.getOtros().llenar();
                }catch(Exception io){
                    
                }
            }
        });
        report.getBono().getjButton5().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Bono est = new Bono();
                    est.setMotivo(report.getBono().getjComboBox1().getSelectedItem().toString());
                    est.setObservacion(report.getBono().getjTextArea4().getText());
                    est.setMes(report.getBono().getjComboBox21().getSelectedItem().toString());
                    est.setFecha(Funcion.DateFormat(report.getBono().getjDateChooser5().getDate()));
                    est.setAnio(report.getBono().getjComboBox27().getSelectedItem().toString());
                    est.setResponsable(log.getNombre());
                    est.setCi(report.getBono().getjLabel1().getText());
                    helper.crearObjeto(est);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Bono Agregado");
                    report.getBono().setTemporal(false);
                    report.getBono().llenar();
                }catch(Exception io){
                    
                }
            }
        });
        report.getComi().getjButton5().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Comisiones est = new Comisiones();
                    est.setMotivo(report.getComi().getjTextField8().getText());
                    est.setValor(report.getComi().getjTextField1().getText());
                    est.setAccion("A");
                    est.setObservacion(report.getComi().getjTextArea4().getText());
                    est.setMes(report.getComi().getjComboBox21().getSelectedItem().toString());
                    est.setFecha(Funcion.DateFormat(report.getComi().getjDateChooser5().getDate()));
                    est.setAnio(report.getComi().getjComboBox27().getSelectedItem().toString());
                    est.setResponsable(log.getNombre());
                    est.setCi(report.getComi().getjLabel1().getText());
                    helper.crearObjeto(est);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Comisiones Agregado");
                    report.getComi().setTemporal(false);
                    report.getComi().llenar();
                }catch(Exception io){
                    
                }
            }
        });
        report2.getMulta().getjButton3().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Multa est = new Multa();
                    String ti="";
                    if(report2.getMulta().getjComboBox14().getItemCount()==0){
                        
                    }else{
                        ti = report2.getMulta().getjComboBox14().getSelectedItem().toString();
                    }
                    
                    if(ti.equalsIgnoreCase("Aviso con Tiempo")){
                        est.setTipo("F. Inj. - Av. con T.");
                    }else
                    if(ti.equalsIgnoreCase("Aviso sin Tiempo")){
                        est.setTipo("F. Inj. - Av. sin T.");
                    }else
                    if(ti.equalsIgnoreCase("Sin Avisar")){
                        est.setTipo("F. Inj. - No Avisó");
                    }else
                    if(ti.equalsIgnoreCase("Leve")){
                        est.setTipo("F. R.I. - Leve");
                    }else
                    if(ti.equalsIgnoreCase("Media")){
                        est.setTipo("F. R.I. - Media");
                    }else
                    if(ti.equalsIgnoreCase("Grave")){
                        est.setTipo("F. R.I. - Grave");
                    }else
                    if(ti.equalsIgnoreCase("Aviso")){
                        est.setTipo("Atraso - Avisó");
                    }else
                    if(ti.equalsIgnoreCase("No Aviso")){
                        est.setTipo("Atraso - No Avisó");
                    }else{
                        est.setTipo("Otros");
                    }
                    
                    if(report2.getMulta().getjTextField10().isVisible()){
                        est.setMotivo(report2.getMulta().getjTextField10().getText());
                    }else{
                        est.setMotivo(report2.getMulta().getjTextField7().getText());
                    }
                    est.setObservacion(report2.getMulta().getjTextArea3().getText());
                    est.setMes(report2.getMulta().getjComboBox6().getSelectedItem().toString());
                    est.setFecha(Funcion.DateFormat(report2.getMulta().getjDateChooser1().getDate()));
                    est.setAnio(report2.getMulta().getjComboBox5().getSelectedItem().toString());
                    est.setResponsable(log.getNombre());
                    est.setCi(report2.getMulta().getjLabel2().getText());
                    if(log.getUsuario().contains("juleissy.iniga")){
                        //est.setAccion("A");
                    }
                    helper.crearObjeto(est);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Multa Agregado");
                    report2.getMulta().setTemporal(false);
                    report2.getMulta().llenar();
                }catch(Exception io){
                    
                }
            }
        });
        report2.getPrestamos().getjButton11().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Prestamos est = new Prestamos();
                    est.setMotivo(report2.getPrestamos().getjComboBox34().getSelectedItem().toString());
                    est.setObservacion(report2.getPrestamos().getjTextArea7().getText());
                    est.setMes(report2.getPrestamos().getjComboBox33().getSelectedItem().toString());
                    est.setFecha(Funcion.DateFormat(report2.getPrestamos().getjDateChooser7().getDate()));
                    est.setAnio(report2.getPrestamos().getjComboBox39().getSelectedItem().toString());
                    est.setResponsable(log.getNombre());
                    est.setCi(report2.getPrestamos().getjLabel2().getText());
                    if(log.getUsuario().contains("juleissy.iniga")||log.getUsuario().contains("poligrafo1")){
                        est.setAccion("A");
                        est.setValor(report2.getPrestamos().getValor().getText());
                    }
                    helper.crearObjeto(est);
                    helper.confirmarTransaccion();
                    helper.cerrarSesion();
                    JOptionPane.showMessageDialog(null,"Prestamo Agregado");
                    report2.getPrestamos().setTemporal(false);
                    report2.getPrestamos().llenar();
                }catch(Exception io){
                    
                }
            }
        });
        au.getjLabel3().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    au.visible(au.getPa());
                    au.getjLabel2().setText("Ausentismo");
                    au.getPa().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        au.getjLabel1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    au.visible(au.getPp());
                    au.getjLabel2().setText("Permisos");
                    au.getPp().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        report.getjLabel3().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    report.visible(report.getHoras());
                    report.getjLabel2().setText("Horas Extras");
                    report.getHoras().setNivel(log.getNivel());
                    report.getHoras().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        report.getjLabel1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    report.visible(report.getBono());
                    report.getjLabel2().setText("Bonos");
                    report.getBono().setNivel(log.getNivel());
                    report.getBono().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        report.getjLabel6().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    report.visible(report.getOtros());
                    report.getjLabel2().setText("Otros");
                    report.getOtros().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        report.getjLabel4().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    report.visible(report.getComi());
                    report.getjLabel2().setText("Comisiones");
                    report.getComi().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        report2.getjLabel3().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    report2.visible(report2.getMulta());
                    report2.getjLabel2().setText("Multas");
                    report2.getMulta().setNivel(log.getNivel());
                    report2.getMulta().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        report2.getjLabel1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    report2.visible(report2.getPrestamos());
                    report2.getjLabel2().setText("Prestamos");
                    report2.getPrestamos().setNivel(log.getNivel());
                    report2.getPrestamos().actualizar();
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        edi.getjLabel41().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cambio(perfil);
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        listemp.getjComboBox1().addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                nav_seleccionado=2;
                cambio(listemp);
                listaempleados lt = new listaempleados(3);
                lt.start();
            }
        });
        listemp.getjLabel3().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    nav_seleccionado=2;
                    cambio(ing);
                    getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
                    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
                    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
                    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
                    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        inicio_panel.getjLabel18().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    nav_seleccionado=3;
                    listdept.actualizar();
                    listdept.empleados();
                    cambio(listdept);
                    getjLabel9().setLocation(getjLabel9().getX(), getjLabel6().getY());
                    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-lightblue.png"))); // NOI18N
                    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-blue.png"))); // NOI18N
                    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-lightblue.png"))); // NOI18N
                    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
                } catch (Exception ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        perfil.getjLabel1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambioedi1();
            }
        });
        edi.getjLabel32().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                if(selectedSiteName.equalsIgnoreCase("cajamarcacajamarca")){
                    try {
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        DeptEmpl dep = emptemp.getDeptEmpl();
                        emptemp.setDeptEmpl(null);
                        helper.actualizarObjeto(emptemp);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        
                        helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        helper.eliminarObjeto(emptemp);
                        helper.eliminarObjeto(dep);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        JOptionPane.showMessageDialog(null,"Empleado Eliminado");
                        
                        
                        nav_seleccionado=2;
                        cambio(listemp);
                        listaempleados lt = new listaempleados(2);
                        lt.start();
                        getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
                        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
                        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
                    } catch (Exception ex) {
                        
                    }
                }
            }
        });
        perfil1.getjLabel1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(emptemp.getPerfilpuesto()!=null){
                        String sFichero = log.getDireccionrrhh()+"/departamentos/"+emptemp.getPerfilpuesto()+".pdf";
                        File fichero = new File(sFichero);
                        if(fichero.exists()){
                            Principal p = new Principal(sFichero);
                            p.next();
                        }else{
                            JOptionPane.showMessageDialog(null,"No existe es Documento");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"No existe es Documento");
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil1.getjLabel2().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String sFichero = log.getDireccionrrhh()+"/Antecedentes/"+emptemp.getCid()+".pdf";
                    File fichero = new File(sFichero);
                    if(fichero.exists()){
                        Principal p = new Principal(sFichero);
                        p.next();
                    }else{
                        JOptionPane.showMessageDialog(null,"No existen procesos judiciales...");
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil1.getjLabel3().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String sFichero = log.getDireccionrrhh()+"/Pruebas 16PF#Cedula/"+emptemp.getCid()+".pdf";
                    File fichero = new File(sFichero);
                    if(fichero.exists()){
                        Principal p = new Principal(sFichero);
                        p.next();
                    }else{
                        JOptionPane.showMessageDialog(null,"No existe es Documento");
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil2.getjLabel3().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String sFichero = log.getDireccionrrhh()+"/Evaluación de Desempeño/"+emptemp.getCid()+".pdf";
                    File fichero = new File(sFichero);
                    if(fichero.exists()){
                        Principal p = new Principal(sFichero);
                        p.next();
                    }else{
                        JOptionPane.showMessageDialog(null,"No existe Documento");
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil2.getjLabel2().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    anterior=perfil2;
                    cambioperfil(perfil6);
                    perfilempleados per = new perfilempleados(6);
                    per.start();
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil2.getjLabel5().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ingresoevaluacion pf= new ingresoevaluacion(null, null, true, null, emptemp);
                    anterior=perfil2;
                    cambioperfil(perfil2);
                    perfilempleados per = new perfilempleados(2);
                    per.start();
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil2.getjLabel52().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(perfil2.getjComboBox1().getItemCount()!=0){
                        String d= perfil2.getjComboBox1().getSelectedItem().toString();
                        String id= d.split("/")[1];
                        ServiceHb help = new ServiceHb();
                        help.iniciarTransaccion();
                        Evaluacion v = (Evaluacion)help.obtenerObjeto(Evaluacion.class, Integer.parseInt(id));
                        help.eliminarObjeto(v);
                        help.confirmarTransaccion();
                        help.cerrarSesion();
                        anterior=perfil2;
                        cambioperfil(perfil2);
                        perfilempleados per = new perfilempleados(2);
                        per.start();
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil2.getjLabel53().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if(perfil2.getjComboBox1().getItemCount()!=0){
                        String d= perfil2.getjComboBox1().getSelectedItem().toString();
                        String id= d.split("/")[1];
                        ServiceHb help = new ServiceHb();
                        help.iniciarTransaccion();
                        Evaluacion v = (Evaluacion)help.obtenerObjeto(Evaluacion.class, Integer.parseInt(id));

                        help.cerrarSesion();
                        ingresoevaluacion in = new ingresoevaluacion(null, null, true, v, emptemp);
                        anterior=perfil2;
                        cambioperfil(perfil2);
                        perfilempleados per = new perfilempleados(2);
                        per.start();
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil2.getjComboBox1().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciar();
                perfil2.getjLabel35().setBackground(Color.white);
                perfil2.getjLabel36().setBackground(Color.white);
                perfil2.getjLabel37().setBackground(Color.white);
                perfil2.getjLabel38().setBackground(Color.white);
                perfil2.getjLabel1().setBackground(Color.white);
                if(perfil2.getjComboBox1().getItemCount()!=0){
                    String d= perfil2.getjComboBox1().getSelectedItem().toString();
                    String id= d.split("/")[1];
                    try{
                        ServiceHb help = new ServiceHb();
                        help.iniciarTransaccion();
                        Evaluacion eva= (Evaluacion)help.obtenerObjeto(Evaluacion.class,Integer.parseInt(id));
                        help.cerrarSesion();
                        if(eva!=null){
                            perfil2.getjTextField1a().setText(eva.getCampo11());
                            perfil2.getjTextField2a().setText(eva.getCampo12());
                            perfil2.getjTextField3a().setText(eva.getCampo13());
                            perfil2.getjTextField4a().setText(eva.getCampo21());
                            perfil2.getjTextField5a().setText(eva.getCampo22());
                            
                            float val1= (Float.parseFloat(eva.getCampo11())+Float.parseFloat(eva.getCampo12())+Float.parseFloat(eva.getCampo13())+Float.parseFloat(eva.getCampo21())+Float.parseFloat(eva.getCampo22()))/5;
                            perfil2.getjTextField3a1().setText(Float.toString(val1));
                            
                            
                            perfil2.getjTextField6a().setText(eva.getCampo23());
                            perfil2.getjTextField7a().setText(eva.getCampo24());
                            perfil2.getjTextField8a().setText(eva.getCampo25());
                            perfil2.getjTextField9a().setText(eva.getCampo31());
                            perfil2.getjTextField10a().setText(eva.getCampo32());
                            perfil2.getjTextField11a().setText(eva.getCampo33());
                            float val2= (Float.parseFloat(eva.getCampo23())+Float.parseFloat(eva.getCampo24())+Float.parseFloat(eva.getCampo25())+Float.parseFloat(eva.getCampo31())+Float.parseFloat(eva.getCampo32())+Float.parseFloat(eva.getCampo33()))/6;
                            perfil2.getjTextField3a2().setText(Float.toString(val2));
                            
                            perfil2.getjTextField12a().setText(eva.getCampo41());
                            perfil2.getjTextField13a().setText(eva.getCampo42());
                            perfil2.getjTextField14a().setText(eva.getCampo43());
                            float val3= (Float.parseFloat(eva.getCampo41())+Float.parseFloat(eva.getCampo42())+Float.parseFloat(eva.getCampo43()))/3;
                            perfil2.getjTextField3a3().setText(Float.toString(val3));
                            
                            
                            perfil2.getjTextField15a().setText(eva.getCampo44());
                            perfil2.getjTextField16a().setText(eva.getCampo51());
                            perfil2.getjTextField17a().setText(eva.getCampo52());
                            perfil2.getjTextField18a().setText(eva.getCampo53());
                            float val4= (Float.parseFloat(eva.getCampo44())+Float.parseFloat(eva.getCampo51())+Float.parseFloat(eva.getCampo52())+Float.parseFloat(eva.getCampo53()))/4;
                            perfil2.getjTextField3a4().setText(Float.toString(val4));
                            
                            perfil2.getjTextField19a().setText(eva.getCampo61());
                            perfil2.getjTextField20a().setText(eva.getCampo62());
                            perfil2.getjTextField21a().setText(eva.getCampo63());
                            float val5= (Float.parseFloat(eva.getCampo61())+Float.parseFloat(eva.getCampo62())+Float.parseFloat(eva.getCampo63()))/3;
                            perfil2.getjTextField3a5().setText(Float.toString(val5));
                            
                            
                            float val7= (val1+val2+val3+val4+val5)/5;
                            perfil2.getjTextField3a7().setText(Float.toString(val7));
                            
                            if(0<val7&& val7<=1){
                                perfil2.getjLabel35().setBackground(Color.red);
                            }
                            if(1<val7&& val7<=2){
                                perfil2.getjLabel36().setBackground(Color.red);
                            }
                            if(2<val7&& val7<=3){
                                perfil2.getjLabel37().setBackground(Color.yellow);
                            }
                            if(3<val7&& val7<=4){
                                perfil2.getjLabel38().setBackground(Color.green);
                            }
                            if(4<val7&& val7<=5){
                                perfil2.getjLabel1().setBackground(Color.green);
                            }
                        }
                    }catch(Exception io){
                        
                    }
                }
            }
        });
        perfil6.getjLabel5().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ingresopruebasf pf= new ingresopruebasf(null, null, true, null, emptemp);
                    anterior=perfil2;
                    cambioperfil(perfil6);
                    perfilempleados per = new perfilempleados(6);
                    per.start();
                } catch (Exception ex) {
                    
                }
            }
        });
        this.log=l;
        jLabel15.setText(log.getNombre());
        d = Toolkit.getDefaultToolkit().getScreenSize();
        dispose();
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        administracion(log.getNivel());
        diseñosmarco();
        diseñotablas();
        agregarpaneles();
        eventosmarco();
        setEventoMouseagregarEmpleado(inicio_panel.getjLabel16()); //agregar clientes
        setVisible(true);
        actualizarlistanav();   
    }
    
    public void administracion(String nivel){
        if(nivel.equalsIgnoreCase("Seguridad")){
            jLabel24.setEnabled(false);
            jLabel22.setEnabled(false);
            jLabel26.setEnabled(false);
            jLabel6.setEnabled(false);
            jLabel20.setEnabled(false);
            inicio_panel.getjLabel14().setEnabled(false);
            inicio_panel.getjLabel16().setEnabled(false);
            inicio_panel.getjLabel18().setEnabled(false);
            perfil.getjLabel1().setEnabled(false);
        }
    }
    public void cambioedi1(){
        edi.setTurno(1);
        cambio(edi);
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        edi.rellenar(emptemp);
        edi.cambio(edi.getjPanel5());
    }
    public void vaciar(){
        perfil2.getjTextField1a().setText("");
        perfil2.getjTextField2a().setText("");
        perfil2.getjTextField3a().setText("");
        
        perfil2.getjTextField3a1().setText("");
        
        perfil2.getjTextField4a().setText("");
        perfil2.getjTextField5a().setText("");
        perfil2.getjTextField6a().setText("");
        perfil2.getjTextField7a().setText("");
        perfil2.getjTextField8a().setText("");
        
        perfil2.getjTextField3a2().setText("");
        
        perfil2.getjTextField9a().setText("");
        perfil2.getjTextField10a().setText("");
        perfil2.getjTextField11a().setText("");
        
        perfil2.getjTextField3a3().setText("");
        
        perfil2.getjTextField12a().setText("");
        perfil2.getjTextField13a().setText("");
        perfil2.getjTextField14a().setText("");
        perfil2.getjTextField15a().setText("");
        
        perfil2.getjTextField3a4().setText("");
        
        perfil2.getjTextField16a().setText("");
        perfil2.getjTextField17a().setText("");
        perfil2.getjTextField18a().setText("");
        
        perfil2.getjTextField3a5().setText("");
        
        perfil2.getjTextField19a().setText("");
        perfil2.getjTextField20a().setText("");
        perfil2.getjTextField21a().setText("");
        
        
        perfil2.getjTextField3a7().setText("");
    }
    public void actualizarlistanav(){
        position.add(jLabel5.getY());
        position.add(jPanel1.getY());
        position.add(jLabel14.getY());
        
        position.add(jLabel6.getY());
        position.add(jLabel11.getY());
        
        position.add(jLabel7.getY());
        position.add(jPanel2.getY());
        position.add(jLabel12.getY()+15);
    }
    
    public void actual(){
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jLabel5.setLocation(jLabel5.getX(),(Integer)position.get(0));
        jPanel1.setLocation(jPanel1.getX(),(Integer)position.get(1));
        jLabel14.setLocation(jLabel14.getX(),(Integer)position.get(2));
        
        jLabel6.setLocation(jLabel6.getX(),(Integer)position.get(3));
        jLabel11.setLocation(jLabel11.getX(),(Integer)position.get(4));
        
        jLabel7.setLocation(jLabel7.getX(),(Integer)position.get(5));
        jPanel2.setLocation(jPanel2.getX(),(Integer)position.get(6));
        jLabel12.setLocation(jLabel12.getX(),(Integer)position.get(7));
        
    }
    
    public void eventosmarco(){
        perfil.getjLabel25().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cambioperfil(perfil1);
                    perfilempleados per = new perfilempleados(1);
                    per.start();
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil.getjLabel26().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cambioperfil(perfil3);
                    perfilempleados per = new perfilempleados(3);
                    per.start();
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil.getjLabel27().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    
                    cambioperfil(perfil2);
                    perfilempleados per = new perfilempleados(2);
                    per.start();
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil.getjLabel28().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cambioperfil(perfil4);
                    perfilempleados per = new perfilempleados(4);
                    per.start();
                } catch (Exception ex) {
                    
                }
            }
        });
        inicio_panel.getjLabel15().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    nav_seleccionado=2;
                    listemp.actdepa();
                    cambio(listemp);
                    listaempleados lt = new listaempleados(2);
                    lt.start();
                    getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
                    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
                    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
                    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
                    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
                } catch (Exception ex) {
                    
                }
            }
        });
        
    }
    
    public void agregarpaneles(){
        /*Paneles del Frame*/
        inicio_panel.setLocation(100, 61);
        add(inicio_panel);
        
        au.setLocation(100, 61);
        add(au);
        
        edi.setLocation(100, 61);
        add(edi);
        
        noti.setLocation(100, 61);
        add(noti);
        
        report.setLocation(100, 61);
        add(report);
        
        report2.setLocation(100, 61);
        add(report2);
        
        estadistico.setLocation(100, 61);
        add(estadistico);
        
        ing.setLocation(100, 61);
        add(ing);
        
        listemp.setLocation(100, 61);
        add(listemp);
        
        listdept.setLocation(100, 61);
        add(listdept);
        
        paneegresos.setLocation(100, 61);
        add(paneegresos);
        
        paneingresos.setLocation(100, 61);
        add(paneingresos);
        
        paneroles.setLocation(100, 61);
        add(paneroles);
        
        perfil.setLocation(100, 61);
        add(perfil);
        
        perfil1.setLocation(0, 200);
        perfil.add(perfil1);
        
        perfil2.setLocation(0, 200);
        perfil.add(perfil2);
        
        perfil3.setLocation(0, 200);
        perfil.add(perfil3);
        
        perfil4.setLocation(0, 200);
        perfil.add(perfil4);
        
        perfil5.setLocation(0, 200);
        perfil.add(perfil5);
        
        perfil6.setLocation(0, 200);
        perfil.add(perfil6);
    }
    
    public void diseñosmarco(){
        setSize(d.width, d.height-1);
        jLabel2.setSize(d.width,58);
        jLabel10.setLocation((d.width/2)-(jLabel10.getWidth()/2), jLabel10.getY());
        jTextField1.setLocation((d.width/2)-(jTextField1.getWidth()/2), jTextField1.getY());
        jLabel15.setLocation((d.width)-(jLabel15.getWidth()), jLabel15.getY());
        jLabel16.setLocation((d.width)-(jLabel16.getWidth()), jLabel16.getY());
        jLabel25.setLocation((d.width)-(jLabel25.getWidth()), jLabel25.getY());
        jLabel17.setLocation((d.width)-(jLabel17.getWidth()), jLabel17.getY());
        jLabel1.setSize(d.width,3);
        jLabel3.setSize(100, d.height-61);
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        /* Nav 1 paso para inicializar el lado izquierdo */
        
        
        jLabel14.setLocation(jLabel14.getX(), jLabel14.getY()-55);
        jLabel6.setLocation(jLabel6.getX(), jLabel6.getY()-55);
        jLabel11.setLocation(jLabel11.getX(), jLabel11.getY()-55);
        jLabel7.setLocation(jLabel7.getX(), jLabel7.getY()-55);
        jPanel2.setLocation(jPanel2.getX(), jLabel7.getY()+jLabel7.getHeight()+10);
        jLabel12.setLocation(jLabel12.getX(), jPanel2.getY());
        /* Fin de Nav 1
         *
         */
    }
    
    private void setEventoMouseinicio_notificacion(JButton tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked1(e);
                } catch (Exception ex) {
                    
                }
            }
        });
    }
    
    private void setEventoMouseagregarEmpleado(JLabel tbl)    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tblEjemploMouseClicked2(e);
                } catch (Exception ex) {
                    
                }
            }
        });
    }
    
    public void cambioperfil(JPanel pane){
        perfil1.setVisible(false);
        perfil2.setVisible(false);
        perfil3.setVisible(false);
        perfil4.setVisible(false);
        perfil5.setVisible(false);
        perfil6.setVisible(false);
        pane.setVisible(true);
    }
    
    public Login getLog() {
        return log;
    }
    
    public void setLog(Login log) {
        this.log = log;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public reportes_roles getPaneroles() {
        return paneroles;
    }
    
    public void setPaneroles(reportes_roles paneroles) {
        this.paneroles = paneroles;
    }
    
    public ingresos getPaneingresos() {
        return paneingresos;
    }
    
    public void setPaneingresos(ingresos paneingresos) {
        this.paneingresos = paneingresos;
    }
    
    public egresos getPaneegresos() {
        return paneegresos;
    }
    
    public void setPaneegresos(egresos paneegresos) {
        this.paneegresos = paneegresos;
    }
    
    public lista_empleados getListemp() {
        return listemp;
    }
    
    public void setListemp(lista_empleados listemp) {
        this.listemp = listemp;
    }
    
    public perfil_empleado getPerfil() {
        return perfil;
    }
    
    public void setPerfil(perfil_empleado perfil) {
        this.perfil = perfil;
    }
    
    public perfil_empleado_base getPerfil1() {
        return perfil1;
    }
    
    public void setPerfil1(perfil_empleado_base perfil1) {
        this.perfil1 = perfil1;
    }
    
    public perfil_empleado_desempeno getPerfil2() {
        return perfil2;
    }
    
    public void setPerfil2(perfil_empleado_desempeno perfil2) {
        this.perfil2 = perfil2;
    }
    
    public perfil_empleado_historia getPerfil3() {
        return perfil3;
    }
    
    public void setPerfil3(perfil_empleado_historia perfil3) {
        this.perfil3 = perfil3;
    }
    
    public perfil_empleado_medico getPerfil4() {
        return perfil4;
    }
    
    public void setPerfil4(perfil_empleado_medico perfil4) {
        this.perfil4 = perfil4;
    }
    
    public perfil_empleado_pdf getPerfil5() {
        return perfil5;
    }
    
    public void setPerfil5(perfil_empleado_pdf perfil5) {
        this.perfil5 = perfil5;
    }
    
    public JLabel getjLabel21() {
        return jLabel21;
    }
    
    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }
    
    public JLabel getjLabel22() {
        return jLabel22;
    }
    
    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }
    
    public JLabel getjLabel23() {
        return jLabel23;
    }
    
    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }
    
    public void cambio(JPanel pane){
        inicio_panel.setVisible(false);
        noti.setVisible(false);
        ing.setVisible(false);
        edi.setVisible(false);
        listemp.setVisible(false);
        listdept.setVisible(false);
        perfil.setVisible(false);
        paneingresos.setVisible(false);
        paneegresos.setVisible(false);
        paneroles.setVisible(false);
        report.setVisible(false);
        report2.setVisible(false);
        estadistico.setVisible(false);
        au.setVisible(false);
        pane.setVisible(true);
    }
    public ingresar_empleado getIng() {
        return ing;
    }
    public void perfilempleado(final Empleado emp){
        String sub= log.getDireccionrrhh()+"foto_empleados\\"+cambioci(emp.getCid())+".jpeg";
        File f=new File(sub);
        if(!f.exists()){
            sub= log.getDireccionrrhh()+"foto_empleados\\"+cambioci(emp.getCid())+".jpg";
        }
        final String dir = sub;
        final Image ima;
        try{
            BufferedImage b = (BufferedImage)ImageIO.read(new File(dir));
            ima = b.getScaledInstance(perfil.getjLabel4().getWidth(), perfil.getjLabel4().getHeight(), 1);
            perfil.getjLabel4().setIcon(new ImageIcon(ima)); // NOI18N
        }catch(Exception io){
            perfil.getjLabel4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/no_image2.jpg"))); // NOI18N
        }
        perfil.getjLabel5().setText(emp.getNombre1() + " "+emp.getNombre2() + " "+emp.getApellido1() + " "+emp.getApellido2());
        perfil.getjLabel6().setText(emp.getCiudad());
        perfil.getjLabel7().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    refreshpdfcajamarca(emp,dir);
                    
                } catch (Exception ex) {
                    
                }
            }
        });
        cambio(perfil);
        perfil.setEmp(emp);
        cambioperfil(perfil1);
        perfilempleados per = new perfilempleados(1);
        per.start();
    }
    public String fechacompletadias(int dias){
        Double anio = Math.floor(dias/365);
        Double residuo = (double)dias%365;
        Double mes = Math.floor(residuo/30);
        residuo = (double) residuo%30;
        return Integer.toString(anio.intValue())+ " Años " + Integer.toString(mes.intValue()) + " Meses " + Integer.toString(residuo.intValue())+ " Dias";
    }
    public int calcularEdad(Date fechaNacimiento, Date fechaActual){
        Calendar fechaAct = Calendar.getInstance();
        fechaAct.setTime(fechaActual);
        
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        
        int dif_anios = fechaAct.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int dif_meses = fechaAct.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int dif_dias = fechaAct.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        
        //Si está en ese año pero todavía no los ha cumplido
        if(dif_meses<0 || (dif_meses==0 && dif_dias<0)){
            dif_anios--;
        }
        return dif_anios;
    }
    
    public perfil_empleado_pruebasfisicas getPerfil6() {
        return perfil6;
    }
    
    public void setPerfil6(perfil_empleado_pruebasfisicas perfil6) {
        this.perfil6 = perfil6;
    }
    
    public String getDepartamentoguardia() {
        return departamentoguardia;
    }
    
    public void setDepartamentoguardia(String departamentoguardia) {
        this.departamentoguardia = departamentoguardia;
    }
    
    public Empleado getEmptemp() {
        return emptemp;
    }
    
    public void setEmptemp(Empleado emptemp) {
        this.emptemp = emptemp;
    }
    
    public Evaluacion getEvatemp() {
        return evatemp;
    }
    
    public void setEvatemp(Evaluacion evatemp) {
        this.evatemp = evatemp;
    }
    
    public JPanel getAnterior() {
        return anterior;
    }
    
    public void setAnterior(JPanel anterior) {
        this.anterior = anterior;
    }
    
    public JLabel getjLabel25() {
        return jLabel25;
    }
    
    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }
    
    public static int diasfecha(Date fechaMayor,Date fechaMenor){
        /* CREAMOS LOS OBJETOS GREGORIAN CALENDAR PARA EFECTUAR LA RESTA */
        GregorianCalendar date1 = new GregorianCalendar();
        date1.setTime(fechaMenor); //dateIni es el objeto Date
        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime(fechaMayor); //dateFin es el objeto Date
        int rango;
        /* COMPROBAMOS SI ESTAMOS EN EL MISMO AÑO */
        if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
            rango = date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR);
        } else {
            /* SI ESTAMOS EN DISTINTO AÑO COMPROBAMOS QUE EL AÑO DEL DATEINI NO SEA BISIESTO
             * SI ES BISIESTO SON 366 DIAS EL AÑO
             * SINO SON 365
             */
            int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? 366 : 365;
            /* CALCULAMOS EL RANGO DE AÑOS */
            int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
            /* CALCULAMOS EL RANGO DE DIAS QUE HAY */
            rango = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));
        }
        return rango;
    }
    
    public String estadocivil(String cadena){
        String regreso="";
        if(cadena.equalsIgnoreCase("S")){
            regreso="Soltero (A)";
        }
        if(cadena.equalsIgnoreCase("D")){
            regreso="Divorciado (A)";
        }
        if(cadena.equalsIgnoreCase("C")){
            regreso="Casado (A)";
        }
        if(cadena.equalsIgnoreCase("V")){
            regreso="Viudo (A)";
        }
        if(cadena.equalsIgnoreCase("U")){
            regreso="Union Libre";
        }
        
        return regreso;
    }
    public void perfil1(Empleado emp){
        emptemp=emp;
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
        String s3="";
        if(emp.getFechaNacimiento()!=null){
            s3 = df3.format(emp.getFechaNacimiento());
        }
        perfil1.getjLabel19().setText(emp.getCuidadResidencia()+", "+ s3);//lugar y fecha de nacimiento
        Date dato = new Date();
        perfil1.getjLabel9().setText(Integer.toString(calcularEdad(emp.getFechaNacimiento(),dato)));//Edad
        perfil1.getjLabel12().setText(estadocivil(emp.getEstadoCivil().toString()));//Estado Civil
        perfil1.getjLabel13().setText(cambioci(emp.getCid()));//CI
        perfil1.getjLabel14().setText(emp.getTelefono());//Telefono
        perfil1.getjLabel15().setText(emp.getCelular());//Celular
        perfil1.getjLabel16().setText(emp.getCorreo());//Email
        
        perfil1.getjPanel1().removeAll();
        perfil1.getjPanel2().removeAll();
        
        perfil1.getjPanel1().setSize(perfil1.getjPanel1().getWidth(), 20);
        perfil1.getjPanel2().setSize(perfil1.getjPanel2().getWidth(), 20);
        perfil1.getjPanel3().setSize(d.width-100, d.height-61-200);
        
        perfil1.getjPanel1().setPreferredSize(new Dimension(perfil1.getjPanel1().getWidth(), 20));
        perfil1.getjPanel2().setPreferredSize(new Dimension(perfil1.getjPanel2().getWidth(), 20));
        perfil1.getjPanel3().setPreferredSize(new Dimension(d.width-100, d.height-61-200));
        
        perfil1.getjPanel1().setLocation(50, 280);
        perfil1.getjPanel2().setLocation(50, 350);
        
        List<CvEstudio> estudio=null;
        List<CvLaboral> laboral=null;
        
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            estudio= helper.getCvEstudioByTipo(""+emp.getCi());
            laboral= helper.getCvLaboralByTipo(""+emp.getCi());
            helper.cerrarSesion();
        }catch(Exception io){
            
        }
        
        int cont=0;
        if(estudio!=null){
            for(CvEstudio i : estudio){
                
                JLabel nivel = new JLabel();
                nivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                nivel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel institucion = new JLabel();
                institucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                institucion.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                
                nivel.setText(i.getNivel()+"   "+i.getInstitucion()+" ");
                nivel.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
                
                institucion.setText(i.getArea());
                institucion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                nivel.setBounds(0,cont*35,(int)nivel.getMinimumSize().getWidth(),35);
                
                institucion.setBounds((int)nivel.getMinimumSize().getWidth(),cont*35,(int)institucion.getMinimumSize().getWidth(),35);
                
                perfil1.getjPanel1().add(nivel);
                
                perfil1.getjPanel1().add(institucion);
                
                cont++;
                
            }
        }
        int cont2=0;
        if(laboral!=null){
            for(CvLaboral i : laboral){
                
                JLabel institucion = new JLabel();
                institucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                institucion.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel cargo = new JLabel();
                cargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                cargo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel telefono = new JLabel();
                telefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                telefono.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel telefonotext = new JLabel();
                telefonotext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                telefonotext.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel puesto = new JLabel();
                puesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                puesto.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel fecha = new JLabel();
                fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                fecha.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel vacio = new JLabel();
                fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                fecha.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                institucion.setText(i.getInstitucion());
                institucion.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
                if(i.getFechaInicio()==null || i.getFechaFinal()==null){
                    fecha.setText("Tiempo no disponible");
                    fecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                }else{
                    fecha.setText(fechacompletadias(diasfecha(i.getFechaFinal(),i.getFechaInicio())));
                    fecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                }
                cargo.setText("CARGO: ");
                cargo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
                
                puesto.setText(i.getPuesto());
                puesto.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                telefono.setText("TELÉFONOS: ");
                telefono.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
                
                telefonotext.setText(i.getTelefono());
                telefonotext.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                vacio.setText("");
                vacio.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                
                institucion.setBounds(0,cont2*35*5,(int)institucion.getMinimumSize().getWidth(),35);
                
                fecha.setBounds(0,(cont2*35*5)+35,(int)fecha.getMinimumSize().getWidth(),35);
                
                cargo.setBounds(0,(cont2*35*5)+70,(int)cargo.getMinimumSize().getWidth(),35);
                
                puesto.setBounds((int)cargo.getMinimumSize().getWidth(),(cont2*35*5)+70,(int)puesto.getMinimumSize().getWidth(),35);
                
                telefono.setBounds(0,(cont2*35*5)+105,(int)telefono.getMinimumSize().getWidth(),35);
                
                telefonotext.setBounds((int)telefono.getMinimumSize().getWidth(),(cont2*35*4)+105,(int)telefonotext.getMinimumSize().getWidth(),35);
                
                vacio.setBounds(0,(cont2*35*5)+140,10,35);
                
                perfil1.getjPanel2().add(institucion);
                perfil1.getjPanel2().add(fecha);
                perfil1.getjPanel2().add(cargo);
                perfil1.getjPanel2().add(puesto);
                perfil1.getjPanel2().add(telefono);
                perfil1.getjPanel2().add(telefonotext);
                
                cont2++;
                
            }
        }
        perfil1.getjPanel3().setPreferredSize(new Dimension(perfil1.getjPanel3().getWidth(), perfil1.getjPanel3().getHeight()+(cont*35)+((cont2)*35*5)));
        perfil1.getjPanel1().setPreferredSize(new Dimension(perfil1.getjPanel1().getWidth(), (cont*35)));
        perfil1.getjPanel1().setSize(new Dimension(perfil1.getjPanel1().getWidth(), (cont*35)));
        perfil1.getjSeparator5().setLocation(perfil1.getjSeparator5().getX(), 310+(cont*35)-20);
        perfil1.getjLabel17().setLocation(perfil1.getjLabel17().getX(), 320+(cont*35)-20);
        perfil1.getjPanel2().setLocation(perfil1.getjPanel2().getX(), 350+(cont*35)-20);
        perfil1.getjPanel2().setPreferredSize(new Dimension(perfil1.getjPanel2().getWidth(), (cont2*35)*5));
        perfil1.getjPanel2().setSize(new Dimension(perfil1.getjPanel2().getWidth(), (cont2*35)*5));
        
    }
    public void perfil2(Empleado emp){
        emptemp=emp;
        
        perfil2.getjPanel1().removeAll();
        
        perfil2.getjPanel1().setSize((d.width-102)/2, d.height-91-200);
        
        perfil2.getjPanel1().setPreferredSize(new Dimension((d.width-102)/2, d.height-61-200));
        
        List<Anticipos> anticipo=null;
        List<Evaluacion> evaluacion=null;
        List<Evaluacion> evaluacioninv=null;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            anticipo= helper.getAnticiposByTipo(""+emp.getCi());
            evaluacion= helper.getEvaluacionByTipo(""+emp.getCi());
            evaluacioninv= helper.getEvaluacionByTipo2(""+emp.getCi());
            helper.cerrarSesion();
        }catch(Exception io){
        }
        
        int cont=0;
        if(anticipo!=null){
            for(final Anticipos i : anticipo){
                
                JLabel motivo = new JLabel();
                motivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                motivo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JTextArea observacion = new JTextArea();
                observacion.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(observacion,
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollBar sb = scrollPane.getVerticalScrollBar();
                sb.setUI(new MyScrollbarUI());
                //scrollPane.setUI(new MyScrollbarUI());
                
                JLabel fecha = new JLabel();
                fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                fecha.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                motivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                
                
                observacion.setText(i.getObservacion()+ "\n" + i.getMotivo());
                observacion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                observacion.setLineWrap(true);
                
                fecha.setText(i.getAnio()+ " " +i.getMes());
                fecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                
                scrollPane.setSize(400, 80);
                scrollPane.setLocation(120, cont*80);
                fecha.setSize(120, 80);
                fecha.setLocation(0, cont*80);
                
                perfil2.getjPanel1().add(scrollPane);
                perfil2.getjPanel1().add(fecha);
                
                cont++;
                
            }
        }
        /*
         * Panel2 - perfil2
         */
        vaciar();
        Evaluacion eva =null;
        perfil2.getjComboBox1().removeAllItems();
        if(evaluacion!=null){
            eva=evaluacion.get(evaluacion.size()-1);
            for(final Evaluacion i : evaluacioninv){
                perfil2.getjComboBox1().addItem(i.getFecha()+"/"+i.getId());
            }
        }
        perfil2.getjLabel35().setBackground(Color.white);
        perfil2.getjLabel36().setBackground(Color.white);
        perfil2.getjLabel37().setBackground(Color.white);
        perfil2.getjLabel38().setBackground(Color.white);
        perfil2.getjLabel1().setBackground(Color.white);
        
        int pos=0;
        if(evaluacion!=null){
            perfil2.getjTextField1a().setText(eva.getCampo11());
            perfil2.getjTextField2a().setText(eva.getCampo12());
            perfil2.getjTextField3a().setText(eva.getCampo13());
            perfil2.getjTextField4a().setText(eva.getCampo21());
            perfil2.getjTextField5a().setText(eva.getCampo22());
            
            float val1= (Float.parseFloat(eva.getCampo11())+Float.parseFloat(eva.getCampo12())+Float.parseFloat(eva.getCampo13())+Float.parseFloat(eva.getCampo21())+Float.parseFloat(eva.getCampo22()))/5;
            perfil2.getjTextField3a1().setText(Float.toString(val1));
            
            
            perfil2.getjTextField6a().setText(eva.getCampo23());
            perfil2.getjTextField7a().setText(eva.getCampo24());
            perfil2.getjTextField8a().setText(eva.getCampo25());
            perfil2.getjTextField9a().setText(eva.getCampo31());
            perfil2.getjTextField10a().setText(eva.getCampo32());
            perfil2.getjTextField11a().setText(eva.getCampo33());
            float val2= (Float.parseFloat(eva.getCampo23())+Float.parseFloat(eva.getCampo24())+Float.parseFloat(eva.getCampo25())+Float.parseFloat(eva.getCampo31())+Float.parseFloat(eva.getCampo32())+Float.parseFloat(eva.getCampo33()))/6;
            perfil2.getjTextField3a2().setText(Float.toString(val2));
            
            perfil2.getjTextField12a().setText(eva.getCampo41());
            perfil2.getjTextField13a().setText(eva.getCampo42());
            perfil2.getjTextField14a().setText(eva.getCampo43());
            float val3= (Float.parseFloat(eva.getCampo41())+Float.parseFloat(eva.getCampo42())+Float.parseFloat(eva.getCampo43()))/3;
            perfil2.getjTextField3a3().setText(Float.toString(val3));
            
            
            perfil2.getjTextField15a().setText(eva.getCampo44());
            perfil2.getjTextField16a().setText(eva.getCampo51());
            perfil2.getjTextField17a().setText(eva.getCampo52());
            perfil2.getjTextField18a().setText(eva.getCampo53());
            float val4= (Float.parseFloat(eva.getCampo44())+Float.parseFloat(eva.getCampo51())+Float.parseFloat(eva.getCampo52())+Float.parseFloat(eva.getCampo53()))/4;
            perfil2.getjTextField3a4().setText(Float.toString(val4));
            
            perfil2.getjTextField19a().setText(eva.getCampo61());
            perfil2.getjTextField20a().setText(eva.getCampo62());
            perfil2.getjTextField21a().setText(eva.getCampo63());
            float val5= (Float.parseFloat(eva.getCampo61())+Float.parseFloat(eva.getCampo62())+Float.parseFloat(eva.getCampo63()))/3;
            perfil2.getjTextField3a5().setText(Float.toString(val5));
            
            
            float val7= (val1+val2+val3+val4+val5)/5;
            perfil2.getjTextField3a7().setText(Float.toString(val7));
            
            if(0<val7&& val7<=1){
                perfil2.getjLabel35().setBackground(Color.red);
            }
            if(1<val7&& val7<=2){
                perfil2.getjLabel36().setBackground(Color.red);
            }
            if(2<val7&& val7<=3){
                perfil2.getjLabel37().setBackground(Color.yellow);
            }
            if(3<val7&& val7<=4){
                perfil2.getjLabel38().setBackground(Color.green);
            }
            if(4<val7&& val7<=5){
                perfil2.getjLabel1().setBackground(Color.green);
            }
        }
        
    }
    
    /*Pruebas Fisicas*/
    public void perfil6(Empleado emp){
        emptemp=emp;
        
        perfil6.getjPanel1().removeAll();
        
        perfil6.getjPanel1().setSize((d.width-102)/2, d.height-91-200);
        
        perfil6.getjPanel1().setPreferredSize(new Dimension((d.width-102)/2, d.height-61-200));
        
        List<Pruebasf> pruebasf=null;
        
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            pruebasf= helper.getPruebasfByTipo(""+emp.getCi());
            helper.cerrarSesion();
        }catch(Exception io){
        }
        
        int cont=0;
        int pos=0;
        if(pruebasf!=null){
            for(final Pruebasf i : pruebasf){
                
                JLabel titulo = new JLabel();
                titulo.setSize(150, 30);
                titulo.setBackground(new java.awt.Color(250, 250, 250));
                titulo.setFont(new java.awt.Font("Roboto", 3, 15)); // NOI18N
                titulo.setForeground(new java.awt.Color(0, 74, 151));
                titulo.setText(Funcion.DateFormat(i.getFecha()));
                titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                titulo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                titulo.setOpaque(true);
                
                JLabel campo1 = new JLabel();
                campo1.setSize(150, 29);
                campo1.setText(i.getTrote());
                campo1.setBackground(new Color( 245, 245 , 245));
                campo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                campo1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                campo1.setOpaque(true);
                
                JLabel campo2 = new JLabel();
                campo2.setSize(150, 29);
                campo2.setBackground(new Color( 220, 220 , 220));
                campo2.setText(i.getFlexionesp());
                campo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                campo2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                campo2.setOpaque(true);
                
                JLabel campo3 = new JLabel();
                campo3.setSize(150, 29);
                campo3.setBackground(new Color( 245, 245 , 245));
                campo3.setText(i.getAbdominales());
                campo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                campo3.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                campo3.setOpaque(true);
                
                JLabel campo4 = new JLabel();
                campo4.setSize(150, 29);
                campo4.setBackground(new Color( 220, 220 , 220));
                campo4.setText(i.getBarras());
                campo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                campo4.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                campo4.setOpaque(true);
                
                JLabel campo5 = new JLabel();
                campo5.setSize(150, 29);
                campo5.setBackground(new Color( 245, 245 , 245));
                campo5.setText(i.getSentadillas());
                campo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                campo5.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                campo5.setOpaque(true);
                
                JLabel campo6 = new JLabel();
                campo6.setSize(150, 29);
                campo6.setBackground(new Color( 220, 220 , 220));
                campo6.setText(i.getCabo());
                campo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                campo6.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                campo6.setOpaque(true);
                
                javax.swing.JButton jButton5 = new javax.swing.JButton();
                
                jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-eliminar.png"))); // NOI18N
                
                jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        try{
                            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                            if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                                ServiceHb dele = new ServiceHb();
                                dele.iniciarTransaccion();
                                dele.eliminarObjeto(i);
                                dele.confirmarTransaccion();
                                dele.cerrarSesion();
                                anterior=perfil2;
                                cambioperfil(perfil6);
                                perfilempleados per = new perfilempleados(6);
                                per.start();
                            }
                        }catch(Exception io){
                            
                        }
                    }
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        
                    }
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        
                    }
                });
                jButton5.setSize(49, 29);
                
                javax.swing.JButton jButton6 = new javax.swing.JButton();
                
                jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/boton-editar.png"))); // NOI18N
                
                jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        try{
                            String selectedSiteName = JOptionPane.showInputDialog(null,"Clave ");
                            if(selectedSiteName.equalsIgnoreCase("cajamarca")){
                                ingresopruebasf pf= new ingresopruebasf(null, null, true, i, emptemp);
                                anterior=perfil2;
                                cambioperfil(perfil6);
                                perfilempleados per = new perfilempleados(6);
                                per.start();
                            }
                        }catch(Exception io){
                            
                        }
                    }
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        
                    }
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        
                    }
                });
                jButton6.setSize(49, 29);
                
                titulo.setLocation(pos, perfil6.getjLabel2().getY());
                campo1.setLocation(pos, perfil6.getjLabel4().getY());
                campo2.setLocation(pos, perfil6.getjLabel6().getY());
                campo3.setLocation(pos, perfil6.getjLabel8().getY());
                campo4.setLocation(pos, perfil6.getjLabel9().getY());
                campo5.setLocation(pos, perfil6.getjLabel10().getY());
                campo6.setLocation(pos, perfil6.getjLabel11().getY());
                jButton6.setLocation(pos+25, perfil6.getjLabel15().getY());
                jButton5.setLocation(pos+75, perfil6.getjLabel15().getY());
                
                
                perfil6.getjPanel1().add(titulo);
                perfil6.getjPanel1().add(campo1);
                perfil6.getjPanel1().add(campo2);
                perfil6.getjPanel1().add(campo3);
                perfil6.getjPanel1().add(campo4);
                perfil6.getjPanel1().add(campo5);
                perfil6.getjPanel1().add(campo6);
                perfil6.getjPanel1().add(jButton5);
                perfil6.getjPanel1().add(jButton6);
                pos= pos +152;
                
            }
        }
        
        perfil6.getjPanel1().setPreferredSize(new Dimension(perfil6.getjPanel1().getWidth(), (cont*150)));
        
        perfil6.getjPanel1().setSize(new Dimension(perfil6.getjPanel1().getWidth(), (cont*150)));
        
    }
    
    public void perfil5(Empleado emp){
        perfil5.getjPanel1().removeAll();
        perfil5.getjPanel1().setSize(d.width-100, d.height-61-200);
        perfil5.getjPanel1().setPreferredSize(new Dimension(d.width-100, d.height-61-200));
        
        String sub= log.getDireccionrrhh()+"curriculum\\"+cambioci(emp.getCid())+".pdf";
        
        mostrarpdf p = new mostrarpdf(sub, perfil5.getjPanel1());
        p.next();
        perfil5.getjPanel1().setSize(p.getWidth(), p.getHeight());
        perfil5.getjPanel1().setPreferredSize(new Dimension(p.getWidth(), p.getHeight()));
        
        
    }
    public void perfil3(Empleado emp){
        perfil3.getjLabel2().removeAll();
        emptemp=emp;
        perfil3.getjLabel2().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String sFichero = log.getDireccionrrhh()+"/Pruebas Fisicas/"+emptemp.getCid()+".pdf";
                    File fichero = new File(sFichero);
                    if(fichero.exists()){
                        Principal p = new Principal(sFichero);
                        p.next();
                    }else{
                        JOptionPane.showMessageDialog(null,"No existe es Documento");
                    }
                } catch (Exception ex) {
                    
                }
            }
        });
        perfil3.getjPanel1().removeAll();
        perfil3.getjPanel2().removeAll();
        perfil3.getjPanel3().removeAll();
        
        perfil3.getjPanel1().setSize(perfil3.getjPanel1().getWidth(), 0);
        perfil3.getjPanel2().setSize(perfil3.getjPanel2().getWidth(), 0);
        perfil3.getjPanel3().setSize(perfil3.getjPanel3().getWidth(), 0);
        perfil3.getjPanel4().setSize(d.width-100, d.height-61-200);
        
        perfil3.getjPanel1().setPreferredSize(new Dimension(perfil3.getjPanel1().getWidth(), 0));
        perfil3.getjPanel2().setPreferredSize(new Dimension(perfil3.getjPanel2().getWidth(), 0));
        perfil3.getjPanel3().setPreferredSize(new Dimension(perfil3.getjPanel3().getWidth(), 0));
        perfil3.getjPanel4().setPreferredSize(new Dimension(d.width-100, d.height-61-200));
        
        perfil3.getjPanel1().setLocation(50, 90);
        perfil3.getjPanel2().setLocation(50, 180);
        perfil3.getjPanel3().setLocation(50, 270);
        
        List<Multa> multa=null;
        List<Bono> bono=null;
        List<Prestamos> prestamos=null;
        
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            multa= helper.getMultaByTipoAprobadas(""+emp.getCi());
            bono= helper.getBonoByTipoAprobado(""+emp.getCi());
            prestamos=helper.getPrestamosByTipoAprobado(""+emp.getCi());
            helper.cerrarSesion();
        }catch(Exception io){
        }
        
        int cont=0;
        if(bono!=null){
            for(final Bono i : bono){
                
                JLabel motivo = new JLabel();
                motivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                motivo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JTextArea observacion = new JTextArea();
                observacion.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(observacion,
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollBar sb = scrollPane.getVerticalScrollBar();
                sb.setUI(new MyScrollbarUI());
                JLabel fecha = new JLabel();
                fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                fecha.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel responsable = new JLabel();
                responsable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                responsable.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                motivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                responsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                
                motivo.setText(i.getMotivo());
                motivo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
                
                observacion.setText(i.getObservacion());
                observacion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                observacion.setLineWrap(true);
                
                fecha.setText(i.getFecha());
                fecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                responsable.setText(i.getResponsable());
                responsable.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                motivo.setSize(220, 80);
                motivo.setLocation(0, cont*80);
                scrollPane.setSize(310, 80);
                scrollPane.setLocation(220, cont*80);
                fecha.setSize(160, 80);
                fecha.setLocation(530, cont*80);
                responsable.setSize(270, 80);
                responsable.setLocation(690, cont*80);
                
                perfil3.getjPanel1().add(motivo);
                perfil3.getjPanel1().add(scrollPane);
                perfil3.getjPanel1().add(fecha);
                perfil3.getjPanel1().add(responsable);
                
                cont++;
                
            }
        }
        int cont2=0;
        if(prestamos!=null){
            for(final Prestamos i : prestamos){
                
                JLabel motivo = new JLabel();
                motivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                motivo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JTextArea observacion = new JTextArea();
                observacion.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(observacion,
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollBar sb = scrollPane.getVerticalScrollBar();
                sb.setUI(new MyScrollbarUI());
                scrollPane.setBorder(null);
                
                JLabel fecha = new JLabel();
                fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                fecha.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel responsable = new JLabel();
                responsable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                motivo.setText(i.getValor() +" " + i.getMotivo());
                motivo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
                
                observacion.setText(i.getObservacion());
                observacion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                observacion.setLineWrap(true);
                
                fecha.setText(i.getFecha());
                fecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                responsable.setText(i.getResponsable());
                responsable.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                motivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                responsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                
                motivo.setSize(220, 80);
                motivo.setLocation(0, cont2*80);
                scrollPane.setSize(310, 80);
                scrollPane.setLocation(220, cont2*80);
                fecha.setSize(160, 80);
                fecha.setLocation(530, cont2*80);
                responsable.setSize(270, 80);
                responsable.setLocation(690, cont2*80);
                
                perfil3.getjPanel2().add(motivo);
                perfil3.getjPanel2().add(scrollPane);
                perfil3.getjPanel2().add(fecha);
                perfil3.getjPanel2().add(responsable);
                
                cont2++;
                
            }
        }
        
        int cont3=0;
        if(multa!=null){
            for(final Multa i : multa){
                
                JLabel motivo = new JLabel();
                motivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                motivo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JTextArea observacion = new JTextArea();
                observacion.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(observacion,
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollBar sb = scrollPane.getVerticalScrollBar();
                sb.setUI(new MyScrollbarUI());
                scrollPane.setBorder(null);
                
                JLabel fecha = new JLabel();
                fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                fecha.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel responsable = new JLabel();
                responsable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                responsable.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                if(i.getTipo().equalsIgnoreCase("Atraso - Avisó")){
                    motivo.setText(i.getMotivo() + " minutos");
                }else if(i.getTipo().equalsIgnoreCase("Atraso - No Avisó")){
                    motivo.setText(i.getMotivo()+ " minutos");
                }else if(i.getTipo().equalsIgnoreCase("F. Inj. - No Avisó")){
                    motivo.setText(i.getMotivo()+ " minutos");
                }else if(i.getTipo().equalsIgnoreCase("A")){
                    motivo.setText(i.getMotivo()+ " minutos");
                }else if(i.getTipo().equalsIgnoreCase("AS")){
                    motivo.setText(i.getMotivo()+ " minutos");
                }else if(i.getTipo().equalsIgnoreCase("FC")){
                    motivo.setText(i.getMotivo()+ " minutos");
                }else if(i.getTipo().equalsIgnoreCase("FS")){
                    motivo.setText(i.getMotivo()+ " minutos");
                }else if(i.getTipo().equalsIgnoreCase("F")){
                    motivo.setText(i.getMotivo()+ " minutos");
                }else{
                    motivo.setText(i.getMotivo());
                }
                
                motivo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
                
                observacion.setText(i.getObservacion());
                observacion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                observacion.setLineWrap(true);
                
                fecha.setText(i.getFecha());
                fecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                responsable.setText(i.getResponsable());
                responsable.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                
                motivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                fecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                responsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230,230,230)));
                
                motivo.setSize(220, 80);
                motivo.setLocation(0, cont3*80);
                scrollPane.setSize(310, 80);
                scrollPane.setLocation(220, cont3*80);
                fecha.setSize(160, 80);
                fecha.setLocation(530, cont3*80);
                responsable.setSize(270, 80);
                responsable.setLocation(690, cont3*80);
                
                perfil3.getjPanel3().add(motivo);
                perfil3.getjPanel3().add(scrollPane);
                perfil3.getjPanel3().add(fecha);
                perfil3.getjPanel3().add(responsable);
                
                cont3++;
                
            }
        }
        
        perfil3.getjPanel4().setPreferredSize(new Dimension(perfil3.getjPanel4().getWidth(), perfil3.getjPanel4().getHeight()+(cont*70)+(cont2*70)+(cont3*70)));
        
        perfil3.getjPanel1().setPreferredSize(new Dimension(perfil3.getjPanel1().getWidth(), (cont*80)));
        perfil3.getjPanel2().setPreferredSize(new Dimension(perfil3.getjPanel2().getWidth(), (cont2*80)));
        perfil3.getjPanel3().setPreferredSize(new Dimension(perfil3.getjPanel3().getWidth(), (cont3*80)));
        
        perfil3.getjPanel1().setSize(new Dimension(perfil3.getjPanel1().getWidth(), (cont*80)));
        perfil3.getjPanel2().setSize(new Dimension(perfil3.getjPanel2().getWidth(), (cont2*80)));
        perfil3.getjPanel3().setSize(new Dimension(perfil3.getjPanel3().getWidth(), (cont3*80)));
        
        perfil3.getjLabel18().setLocation(perfil3.getjLabel8().getX(), 110+(cont*80));
        perfil3.getjLabel30().setLocation(perfil3.getjLabel30().getX(), 150+(cont*80));
        perfil3.getjLabel31().setLocation(perfil3.getjLabel31().getX(), 150+(cont*80));
        perfil3.getjLabel32().setLocation(perfil3.getjLabel32().getX(), 150+(cont*80));
        perfil3.getjLabel33().setLocation(perfil3.getjLabel33().getX(), 150+(cont*80));
        perfil3.getjPanel2().setLocation(perfil3.getjPanel2().getX(), 180+(cont*80));
        
        perfil3.getjLabel17().setLocation(perfil3.getjLabel17().getX(), 200+(cont*80)+(cont2*80));
        perfil3.getjLabel34().setLocation(perfil3.getjLabel34().getX(), 240+(cont*80)+(cont2*80));
        perfil3.getjLabel36().setLocation(perfil3.getjLabel36().getX(), 240+(cont*80)+(cont2*80));
        perfil3.getjLabel37().setLocation(perfil3.getjLabel37().getX(), 240+(cont*80)+(cont2*80));
        perfil3.getjLabel35().setLocation(perfil3.getjLabel35().getX(), 240+(cont*80)+(cont2*80));
        perfil3.getjPanel3().setLocation(perfil3.getjPanel3().getX(), 270+(cont*80)+(cont2*80));
        
    }
    public void update(){
        listemp.getjPanel1().removeAll();
        List<Empleado> empleados;
        JPanel contenedor = new JPanel();
        contenedor.setBackground(Color.white);
        JScrollPane pane = new JScrollPane(contenedor);
        pane.setHorizontalScrollBar(null);
        JScrollBar sb = pane.getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        pane.setBackground(Color.white);
        pane.setSize(1010, 500);
        listemp.getjPanel1().setSize(1010, 500);
        listemp.getjPanel1().setLocation(40, 150);
        pane.setBorder(null);
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            empleados= helper.getPersonasByTipotext(listemp.getjComboBox1().getSelectedItem().toString());
            contenedor.setLayout(null);
            listemp.getjPanel1().add(pane);
            int cont=0;
            for(final Empleado i : empleados){
                if(trampa){
                    trampa=!trampa;
                    break;
                }
                i.setCliente(i.getDeptEmpl().getDepartamento().getNombre());
                JLabel imagen = new JLabel();
                JLabel nombres = new JLabel();
                nombres.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                JLabel ingreso = new JLabel();
                ingreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                ingreso.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel departamento = new JLabel();
                departamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                departamento.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel nacimiento = new JLabel();
                nacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                nacimiento.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                JLabel celular = new JLabel();
                celular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                celular.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
                imagen.setSize(50, 75);
                
                String sub= log.getDireccionrrhh()+"foto_empleados\\"+cambioci(i.getCid())+".jpeg";
                
                String dir = sub;
                try{
                    BufferedImage b = (BufferedImage)ImageIO.read(new File(dir));
                    Image ima = b.getScaledInstance(50, 75, 1);
                    imagen.setIcon(new ImageIcon(ima)); // NOI18N
                }catch(Exception io){
                    imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/no_image2.jpg"))); // NOI18N
                }
                
                nombres.setText(i.getNombre1() +" "+  i.getNombre2() +" "+  i.getApellido1() +" "+  i.getApellido2());
                nombres.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                nombres.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            setTrampa(true);
                            perfilempleado(i);
                        } catch (Exception ex) {
                            
                        }
                    }
                });
                
                ingreso.setText(Funcion.DateFormatSql(i.getFechaIngreso()));
                ingreso.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                if(i.getDepartamento()!=null){
                departamento.setText(i.getDepartamento());
                departamento.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                }else{
                    departamento.setText("Inactivo");
                    departamento.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                }
                if(i.getFechaNacimiento()!=null){
                    nacimiento.setText(Funcion.DateFormatSql(i.getFechaNacimiento()));
                    nacimiento.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                }else{
                    nacimiento.setText("No Ingresado");
                    nacimiento.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                }
                
                celular.setText(i.getCelular());
                celular.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                
                
                imagen.setBounds(0,cont*77,50,77);
                
                nombres.setBounds(75, cont*77, 205, 77);
                
                ingreso.setBounds(280,  cont*77,  160, 77);
                
                departamento.setBounds(440,  cont*77,  210, 77);
                
                nacimiento.setBounds(650,  cont*77,  190, 77);
                
                celular.setBounds(840,  cont*77,  170, 77);
                
                
                
                contenedor.add(imagen);
                
                contenedor.add(nombres);
                
                contenedor.add(ingreso);
                
                contenedor.add(departamento);
                
                contenedor.add(nacimiento);
                
                contenedor.add(celular);
                
                cont++;
                contenedor.setPreferredSize(new Dimension(1010, (cont*77)+21));
                pane.setViewportView(contenedor);
            }
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
        
    }
    
    public void update(String filtro){
        listemp.getjPanel1().removeAll();
        List<Empleado> empleados;
        JPanel contenedor = new JPanel();
        contenedor.setBackground(Color.white);
        JScrollPane pane = new JScrollPane(contenedor);
        pane.setHorizontalScrollBar(null);
        JScrollBar sb = pane.getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        pane.setBackground(Color.white);
        pane.setSize(1010, 500);
        listemp.getjPanel1().setSize(1010, 500);
        listemp.getjPanel1().setLocation(40, 150);
        pane.setBorder(null);
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(log.getNivel().equalsIgnoreCase("Seguridad")){
                empleados= helper.getPersonasByTipotext(filtro,"Seguridad Fisica");
            }else{
                empleados= helper.getPersonasByTipotext(filtro,listemp.getjComboBox1().getSelectedItem().toString());
            }
            if(empleados!=null){
            contenedor.setLayout(null);
            
            listemp.getjPanel1().add(pane);
            
            int cont=0;
                for(Empleado i : empleados){
                    if(trampa){
                        trampa=!trampa;
                        helper.cerrarSesion();
                        break;
                    }
                    i.setCliente(i.getDeptEmpl().getDepartamento().getNombre());
                    JLabel imagen = new JLabel();
                    JLabel nombres = new JLabel();

                    nombres.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                    JLabel ingreso = new JLabel();
                    ingreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    ingreso.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

                    JLabel departamento = new JLabel();
                    departamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    departamento.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

                    JLabel nacimiento = new JLabel();
                    nacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    nacimiento.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

                    JLabel celular = new JLabel();
                    celular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    celular.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

                    imagen.setSize(50, 75);

                    String sub= log.getDireccionrrhh()+"foto_empleados\\"+cambioci(i.getCid())+".jpeg";

                    String dir = sub;
                    File archivo= new File(dir);
                    if(!archivo.exists()){
                        sub= log.getDireccionrrhh()+"foto_empleados\\"+cambioci(i.getCid())+".jpg";
                        if(!new File(sub).exists()){
                            sub= log.getDireccionrrhh()+"foto_empleados\\"+i.getCi()+".jpeg";
                            if(!new File(sub).exists()){
                                sub= log.getDireccionrrhh()+"foto_empleados\\"+i.getCi()+".jpg";
                            }
                        }
                        dir=sub;
                    }
                    try{
                        BufferedImage b = (BufferedImage)ImageIO.read(new File(dir));
                        Image ima = b.getScaledInstance(50, 75, 1);
                        imagen.setIcon(new ImageIcon(ima)); // NOI18N
                    }catch(Exception io){

                        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/no_image2.jpg"))); // NOI18N
                    }

                    nombres.setText(i.getNombre1() +" "+  i.getNombre2() +" "+  i.getApellido1() +" "+  i.getApellido2());
                    nombres.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
                    final Empleado ee= i;
                    nombres.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                setTrampa(false);
                                perfilempleado(ee);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    ingreso.setText(Funcion.DateFormatSql(i.getFechaIngreso()));
                    ingreso.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N

                    departamento.setText(i.getDepartamento());
                    departamento.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N

                    nacimiento.setText(Funcion.DateFormatSql(i.getFechaIngreso()));
                    nacimiento.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N

                    celular.setText(i.getCelular());
                    celular.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N


                    imagen.setBounds(0,cont*77,50,77);

                    nombres.setBounds(75, cont*77, 205, 77);

                    ingreso.setBounds(280,  cont*77,  160, 77);

                    departamento.setBounds(440,  cont*77,  210, 77);

                    nacimiento.setBounds(650,  cont*77,  190, 77);

                    celular.setBounds(840,  cont*77,  170, 77);



                    contenedor.add(imagen);

                    contenedor.add(nombres);

                    contenedor.add(ingreso);

                    contenedor.add(departamento);

                    contenedor.add(nacimiento);

                    contenedor.add(celular);

                    cont++;

                    contenedor.setPreferredSize(new Dimension(1010, (cont*75)+70));
                    pane.setViewportView(contenedor);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
            System.out.println(io);
        }
        
    }
    public static BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
        BufferedImage dbi = null;
        if(sbi != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(sbi, at);
        }
        return dbi;
    }
    public String cambioci(String ci){
        String substring=ci;
        if(ci.substring(0,1).equalsIgnoreCase("0")){
            substring = ci.substring(1, ci.length());
        }
        return substring;
    }
    public void refreshpdfcajamarca(Empleado emp, String ima){
        //String imagepath = Server.MapPath("Images");
        Document documento = new Document(PageSize.A4, 0, 0, 0, 0);
        FileOutputStream ficheroPdf;
        List<CvEstudio> estudio;
        List<CvLaboral> laboral;
        final String IMAGE = (getClass().getResource("/rrhh/imagenes/cajahead.jpg")).toString();
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            estudio= helper.getCvEstudioByTipo(""+emp.getCi());
            laboral= helper.getCvLaboralByTipo(""+emp.getCi());
            String sub= log.getDireccionrrhh()+"pdf_cajamarca\\"+cambioci(emp.getCid())+".pdf";
            File f = new File(sub);
            if(!f.exists()){
                sub= log.getDireccionrrhh()+"pdf_cajamarca\\"+emp.getCi()+".pdf";
            }
            ficheroPdf = new FileOutputStream(sub);
            PdfWriter writer = PdfWriter.getInstance(documento,ficheroPdf);
            
            documento.open();
            
            documento.setMargins(0, 0, 0, 0);
            
            PdfPCell celda;
            Font fontpersonalizado2 = FontFactory.getFont("ARIAL", 7, Font.NORMAL);
            Font font = FontFactory.getFont("ARIAL", 11, Font.BOLDITALIC);
            Font fontpersonalizado = FontFactory.getFont("ARIAL", 12, Font.BOLDITALIC);
            Font fontselected = FontFactory.getFont("ARIAL", 22, Font.BOLD);
            
            fontselected.setColor(Color.red);
            //aqui agregamos todo el contenido del PDF...
            /*Cabecera celdas 1 2 y 3*/
            
            com.itextpdf.text.Image image2 = com.itextpdf.text.Image.getInstance((getClass().getResource("/rrhh/imagenes/pie-de-pagina.png")));
            
            Chunk chunk = new Chunk(image2, 0, -45);
            HeaderFooter footer = new HeaderFooter(new Phrase(chunk), false);
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setBorder(Rectangle.NO_BORDER);
            documento.setFooter(footer);
            com.itextpdf.text.Image image3 = com.itextpdf.text.Image.getInstance((getClass().getResource("/rrhh/imagenes/cv-experiencia-laboral.png")));
            
            com.itextpdf.text.Image image4 = com.itextpdf.text.Image.getInstance((getClass().getResource("/rrhh/imagenes/cv-cursos-realizados.png")));
            
            com.itextpdf.text.Image image5 = com.itextpdf.text.Image.getInstance((getClass().getResource("/rrhh/imagenes/cv-estudios-realizados.png")));
            
            com.itextpdf.text.Image image6 = com.itextpdf.text.Image.getInstance((getClass().getResource("/rrhh/imagenes/cv-datos-personales.png")));
            
            com.itextpdf.text.Image image7 = com.itextpdf.text.Image.getInstance(ima);
            image7.scaleAbsoluteHeight((float) 80);
            image7.scaleAbsoluteWidth((float) 80);
            
            PdfContentByte canvas = writer.getDirectContentUnder();
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(IMAGE);
            image.scaleAbsolute(PageSize.A4.getWidth(),PageSize.A4.getHeight());
            image.setAbsolutePosition(0, 0);
            canvas.addImage(image);
            PdfPTable foto = new PdfPTable(1);
            
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda.setMinimumHeight(10);
            foto.addCell(celda);
            
            celda = new PdfPCell(image7);
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda.setMinimumHeight(110);
            foto.addCell(celda);
            
            PdfPTable head = new PdfPTable(1);
            celda = new PdfPCell(new Phrase("",new Font(font)));
            celda.setBorder(0);
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda.setMinimumHeight(110);
            head.addCell(celda);
            
            documento.add(foto);
            
            /*Datos Personales*/
            documento.add(image6);
            String campo1=" NOMBRES Y APELLIDOS: ";
            String campo1a=emp.getNombre1()+" "+emp.getNombre2()+" "+emp.getApellido1()+" "+emp.getApellido2();
            String campo2="NUMERO DE CEDULA: ";
            String campo2a=cambioci(emp.getCid());//CI
            DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
            String campo3="FECHA DE NACIMIENTO: ";//Edad
            String campo3a=df4.format(emp.getFechaNacimiento());//Edad
            String campo4="DIRECCIÓN: ";
            String campo4a=emp.getDireccion();
            String campo5="TELEFONOS: ";
            String campo5a=emp.getTelefono()+ " "+ emp.getCelular();
            String campo6="E-MAIL: ";
            String campo6a=emp.getCorreo();
            String identacion="                  ";
            documento.add(new Phrase("\n"+identacion+campo1,new Font(fontpersonalizado)));
            documento.add(new Phrase(campo1a+"\n",new Font(font)));
            
            documento.add(new Phrase(identacion+campo2,new Font(fontpersonalizado)));
            documento.add(new Phrase(campo2a+"\n",new Font(font)));
            
            documento.add(new Phrase(identacion+campo3,new Font(fontpersonalizado)));
            documento.add(new Phrase(campo3a+"\n",new Font(font)));
            
            documento.add(new Phrase(identacion+campo4,new Font(fontpersonalizado)));
            documento.add(new Phrase(campo4a+"\n",new Font(font)));
            
            documento.add(new Phrase(identacion+campo5,new Font(fontpersonalizado)));
            documento.add(new Phrase(campo5a+"\n",new Font(font)));
            
            documento.add(new Phrase(identacion+campo6,new Font(fontpersonalizado)));
            documento.add(new Phrase(campo6a+"\n"+"\n",new Font(font)));
            //documento.add(head);
            /*Estudios Realizados*/
            documento.add(image5);
            
            
            
            int cont=0;
            if(estudio!=null){
                for(final CvEstudio i : estudio){
                    String nivel= i.getNivel();
                    String institucion= " "+i.getInstitucion()+" "+i.getArea();
                    documento.add(new Phrase(identacion+nivel,new Font(fontpersonalizado)));
                    documento.add(new Phrase("\n "+identacion+institucion+"\n\n",new Font(font)));
                }
            }
            /*Cursos Realizados*/
            documento.add(image4);
            
            /*Experiencia Laboral*/
            documento.add(image3);
            
            int cont2=0;
            if(laboral!=null){
                for(final CvLaboral i : laboral){
                    String institucion=i.getInstitucion();
                    String fecha;
                    if(i.getFechaInicio()==null || i.getFechaFinal()==null){
                        fecha=" ";
                    }else{
                        fecha= fechacompletadias(diasfecha(i.getFechaFinal(),i.getFechaInicio()));
                    }
                    String cargoa= i.getPuesto();
                    
                    documento.add(new Phrase("\n"+identacion+institucion,new Font(fontpersonalizado)));
                    documento.add(new Phrase("\n"+identacion+" TIEMPO: "+fecha,new Font(font)));
                    documento.add(new Phrase("\n"+identacion+" CARGO: "+cargoa+"\n",new Font(font)));
                }
            }
            
            documento.close();
            
            helper.cerrarSesion();
            
            JOptionPane.showMessageDialog(null,"Perfil convertido a PDF.");
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        
    }
    
    /*Hilos entre Enlazados*/
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
            if(num==2){
                update(getjTextField1().getText());
            }else{
                update();
            }
        }
    }

    public reportes2 getReport2() {
        return report2;
    }

    public void setReport2(reportes2 report2) {
        this.report2 = report2;
    }

    public ausentismo getAu() {
        return au;
    }

    public void setAu(ausentismo au) {
        this.au = au;
    }

    public reportes_estadistico getEstadistico() {
        return estadistico;
    }

    public void setEstadistico(reportes_estadistico estadistico) {
        this.estadistico = estadistico;
    }

    public editar_empleado1 getEdi() {
        return edi;
    }

    public void setEdi(editar_empleado1 edi) {
        this.edi = edi;
    }

    public lista_departamentos getListdept() {
        return listdept;
    }

    public void setListdept(lista_departamentos listdept) {
        this.listdept = listdept;
    }

    public boolean isTrampa() {
        return trampa;
    }

    public void setTrampa(boolean trampa) {
        this.trampa = trampa;
    }

    public JLabel getjLabel26() {
        return jLabel26;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }
    
    public class perfilempleados extends Thread {
        int numero;
        public perfilempleados(int num){
            this.numero=num;
        }
        @Override
        public void run() {
            if(numero==1){
                perfil.getjLabel25().setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-IG-darkblue.png"))); // NOI18N
                //perfil.getjLabel29().setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-PP-lightblue.png"))); // NOI18N
                perfil.getjLabel26().setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-HL-lightblue.png"))); // NOI18N
                perfil.getjLabel27().setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-D-lightblue.png"))); // NOI18N
                perfil.getjLabel28().setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/boton-HM-lightblue.png"))); // NOI18N
                perfil.turno=1;
                perfil1(perfil.emp);
            }
            if(numero==2){
                perfil2(perfil.emp);
            }
            if(numero==3){
                perfil3(perfil.emp);
            }
            if(numero==4){
            }
            if(numero==5){
                perfil5(perfil.emp);
            }
            if(numero==6){
                perfil6(perfil.emp);
            }
        }
    }
    public class reporteempleados extends Thread {
        int num;
        
        public reporteempleados(int num){
            this.num=num;
        }
        
        @Override
        public void run() {
            if(num==1){
                //report.llenartablas();
            }
            if(num==2){
                
            }
        }
    }
    protected int compare(int i, int j) {
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        return s1.compareTo(s2);
    }
    
    public void diseñotablas(){
        tablasmodelos(listdept.getjTable1(),listdept);
        JScrollBar sb = listdept.getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        listdept.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        listdept.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        listdept.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        listdept.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        listdept.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        listdept.getjTable1().getColumn("ESTADO").setCellRenderer(new ButtonRenderer());
        listdept.getjTable1().getColumn("EDITAR").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(report.getComi().getjTable6(),report.getComi());
        sb = report.getComi().getjScrollPane11().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getComi().getjTable6().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getComi().getjTable6().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getComi().getjTable6().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(report.getComi().getjTable7(),report.getComi());
        sb = report.getComi().getjScrollPane13().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getComi().getjTable7().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getComi().getjTable7().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getComi().getjTable7().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        report.getComi().getjTable7().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        report.getComi().getjTable7().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        report.getComi().getjTable7().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        report.getComi().getjTable7().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        
        tablasmodelos(report.getOtros().getjTable6(),report.getOtros());
        sb = report.getOtros().getjScrollPane11().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getOtros().getjTable6().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getOtros().getjTable6().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getOtros().getjTable6().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(report.getOtros().getjTable7(),report.getOtros());
        sb = report.getOtros().getjScrollPane13().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getOtros().getjTable7().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getOtros().getjTable7().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getOtros().getjTable7().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        report.getOtros().getjTable7().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        report.getOtros().getjTable7().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        report.getOtros().getjTable7().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        report.getOtros().getjTable7().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        
        tablasmodelos(report.getBono().getjTable6(),report.getBono());
        sb = report.getBono().getjScrollPane11().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getBono().getjTable6().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getBono().getjTable6().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getBono().getjTable6().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(paneroles.getMul2().getjTable1(),paneroles.getMul2());
        sb = paneroles.getMul2().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 9;i++){
        paneroles.getMul2().getjTable1().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul2().getjTable1().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul2().getjTable2(),paneroles.getMul2());
        sb = paneroles.getMul2().getjScrollPane2().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 9;i++){
        paneroles.getMul2().getjTable2().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul2().getjTable2().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul2().getjTable3(),paneroles.getMul2());
        sb = paneroles.getMul2().getjScrollPane3().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 8;i++){
        paneroles.getMul2().getjTable3().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul2().getjTable3().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul2().getjTable4(),paneroles.getMul1());
        sb = paneroles.getMul2().getjScrollPane4().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 8;i++){
        paneroles.getMul2().getjTable4().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul2().getjTable4().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul2().getjTable5(),paneroles.getMul2());
        sb = paneroles.getMul2().getjScrollPane5().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 8;i++){
        paneroles.getMul2().getjTable5().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul2().getjTable5().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul1().getjTable1(),paneroles.getMul1());
        sb = paneroles.getMul1().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 9;i++){
        paneroles.getMul1().getjTable1().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul1().getjTable1().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul1().getjTable2(),paneroles.getMul1());
        sb = paneroles.getMul1().getjScrollPane2().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 9;i++){
        paneroles.getMul1().getjTable2().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul1().getjTable2().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul1().getjTable3(),paneroles.getMul1());
        sb = paneroles.getMul1().getjScrollPane3().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 8;i++){
        paneroles.getMul1().getjTable3().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul1().getjTable3().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul1().getjTable4(),paneroles.getMul1());
        sb = paneroles.getMul1().getjScrollPane4().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 8;i++){
        paneroles.getMul1().getjTable4().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul1().getjTable4().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getMul1().getjTable5(),paneroles.getMul1());
        sb = paneroles.getMul1().getjScrollPane5().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 8;i++){
        paneroles.getMul1().getjTable5().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getMul1().getjTable5().getColumn("Aprobar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getRol1().getjTable1(),report.getBono());
        sb = paneroles.getRol1().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 26;i++){
        paneroles.getRol1().getjTable1().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getRol1().getjTable1().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(paneroles.getRol2().getjTable1(),report.getBono());
        sb = paneroles.getRol2().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        for(int i=0; i< 26;i++){
        paneroles.getRol2().getjTable1().getColumnModel().getColumn(i).setCellRenderer( new CellRenderer("text center") );
        }
        paneroles.getRol2().getjTable1().getColumn("Editar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(au.getPp().getjTable1(),au.getPa());
        sb = au.getPp().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        au.getPp().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        au.getPp().getjTable1().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(au.getPa().getjTable2(),au.getPa());
        sb = au.getPa().getjScrollPane2().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        au.getPa().getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        au.getPa().getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        au.getPa().getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        au.getPa().getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(au.getPp().getjTable2(),au.getPp());
        sb = au.getPp().getjScrollPane2().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        au.getPp().getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        au.getPp().getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(report.getBono().getjTable7(),report.getBono());
        sb = report.getBono().getjScrollPane13().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getBono().getjTable7().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getBono().getjTable7().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getBono().getjTable7().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        report.getBono().getjTable7().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        report.getBono().getjTable7().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        report.getBono().getjTable7().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        report.getBono().getjTable7().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        
        tablasmodelos(report2.getPrestamos().getjTable10(),report2.getPrestamos());
        sb = report2.getPrestamos().getjScrollPane23().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report2.getPrestamos().getjTable10().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable10().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable10().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(report2.getPrestamos().getjTable9(),report2.getPrestamos());
        sb = report2.getPrestamos().getjScrollPane20().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report2.getPrestamos().getjTable9().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable9().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable9().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable9().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable9().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable9().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        report2.getPrestamos().getjTable9().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        report2.getPrestamos().getjTable9().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
        
        
        tablasmodelos(report2.getMulta().getjTable5(),report2.getMulta());
        sb = report2.getMulta().getjScrollPane9().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report2.getMulta().getjTable5().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable5().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable5().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(report2.getMulta().getjTable4(),report2.getMulta());
        sb = report2.getMulta().getjScrollPane7().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report2.getMulta().getjTable4().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable4().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable4().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable4().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable4().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable4().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        report2.getMulta().getjTable4().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        report2.getMulta().getjTable4().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
                
        
        tablasmodelos(report.getHoras().getjTable2(),report.getHoras());
        sb = report.getHoras().getjScrollPane2().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getHoras().getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(report.getHoras().getjTable1(),report.getHoras());
        sb = report.getHoras().getjScrollPane1().getVerticalScrollBar();
        sb.setUI(new MyScrollbarUI());
        
        report.getHoras().getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        report.getHoras().getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        
        report.getHoras().getjTable1().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        
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
    
    public JLabel getjLabel1() {
        return jLabel1;
    }
    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    public JLabel getjLabel10() {
        return jLabel10;
    }
    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
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
    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
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
    public JLabel getjLabel9() {
        return jLabel9;
    }
    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }
    public int getNav_seleccionado() {
        return nav_seleccionado;
    }
    public void setNav_seleccionado(int nav_seleccionado) {
        this.nav_seleccionado = nav_seleccionado;
    }
    public JLabel getjLabel11() {
        return jLabel11;
    }
    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }
    public JLabel getjLabel12() {
        return jLabel12;
    }
    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }
    public JLabel getjLabel13() {
        return jLabel13;
    }
    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }
    public JLabel getjLabel14() {
        return jLabel14;
    }
    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }
    public JLabel getjLabel15() {
        return jLabel15;
    }
    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }
    public void setIng(ingresar_empleado ing) {
        this.ing = ing;
    }
    public JLabel getjLabel19() {
        return jLabel19;
    }
    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }
    public JLabel getjLabel20() {
        return jLabel20;
    }
    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }
    public notificaciones getNoti() {
        return noti;
    }
    public void setNoti(notificaciones noti) {
        this.noti = noti;
    }
    public JLabel getjLabel16() {
        return jLabel16;
    }
    public boolean isConfiguracion() {
        return configuracion;
    }
    public void setConfiguracion(boolean configuracion) {
        this.configuracion = configuracion;
    }
    public JTextField getjTextField1() {
        return jTextField1;
    }
    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }
    public JLabel getjLabel17() {
        return jLabel17;
    }
    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }
    public Dimension getD() {
        return d;
    }
    public void setD(Dimension d) {
        this.d = d;
    }
    public inicio getInicio_panel() {
        return inicio_panel;
    }
    public void setInicio_panel(inicio inicio_panel) {
        this.inicio_panel = inicio_panel;
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
    
    
    
    private void tblEjemploMouseClicked1(java.awt.event.MouseEvent evt) throws Exception {
        List<Empleado> emp;
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            emp=helper.getPersonasByTipo();
            JPanel jp = new JPanel();
            jp.setBackground(Color.white);
            JScrollPane jsp;
            int posX=50;
            int posY=50;
            if(emp!=null){
                jp.setLayout(new GridLayout(emp.size(),4));
                if((emp.size()*50)>d.height-110){
                    
                    jp.setSize(d.width-120, emp.size()*50);
                }else{
                    jp.setSize(d.width-120, d.height-110);
                }
                for(Empleado i: emp){
                    JLabel nombre = new JLabel();
                    nombre.setSize(250, 50);
                    
                    JLabel fecha_ingreso = new JLabel();
                    fecha_ingreso.setSize(150,50);
                    
                    JLabel fecha_cumpleaños = new JLabel();
                    fecha_cumpleaños.setSize(150,50);
                    
                    JCheckBox select = new JCheckBox();
                    select.setSize(150,50);
                    
                    nombre.setText(i.getNombre1()+" "+i.getNombre2()+" "+i.getApellido1()+" "+i.getApellido2());
                    fecha_ingreso.setText(Funcion.DateFormatSql(i.getFechaIngreso()));
                    fecha_cumpleaños.setText(Funcion.DateFormatSql(i.getFechaNacimiento()));
                    select.setName(i.getCid());
                    jp.add(nombre);
                    jp.add(fecha_ingreso);
                    jp.add(fecha_cumpleaños);
                    jp.add(select);
                    posY= posY + 50;
                }
            }
            helper.cerrarSesion();
            cambio(noti);
            jsp= new JScrollPane(jp);
            jsp.setSize(d.width-120, d.height-110);
            JScrollBar sb = jsp.getVerticalScrollBar();
            sb.setUI(new MyScrollbarUI());
            noti.add(jsp);
            
        }catch(Exception io){
            
        }
        
    }
    private void tblEjemploMouseClicked2(java.awt.event.MouseEvent evt) throws Exception {
        nav_seleccionado=2;
        getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
        cambio(ing);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
        jLabel25.setText("jLabel16");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });
        getContentPane().add(jLabel25);
        jLabel25.setBounds(700, 140, 172, 38);
        jLabel25.setVisible(false);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
        jLabel16.setText("jLabel16");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        getContentPane().add(jLabel16);
        jLabel16.setBounds(700, 100, 172, 38);
        jLabel16.setVisible(false);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-lightblue.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(700, 61, 172, 38);
        jLabel17.setVisible(false);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/linea-separadora-3.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 340, 56, 2);

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 74, 151));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-lightblue.png"))); // NOI18N
        jLabel15.setText("     Jan Topic");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        getContentPane().add(jLabel15);
        jLabel15.setBounds(700, 0, 172, 58);

        jPanel2.setOpaque(false);

        jLabel24.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 173, 218));
        jLabel24.setText("- Reportes");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        jPanel2.add(jLabel24);

        jLabel21.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 173, 218));
        jLabel21.setText("- Ingresos");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel2.add(jLabel21);

        jLabel23.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 173, 218));
        jLabel23.setText("- Descuentos");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        jPanel2.add(jLabel23);

        jLabel22.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 173, 218));
        jLabel22.setText("- Roles");
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
        jPanel2.add(jLabel22);

        jLabel26.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 173, 218));
        jLabel26.setText("- Ausentismo");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });
        jPanel2.add(jLabel26);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 390, 80, 110);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 173, 218));
        jLabel19.setText("- Lista");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel1.add(jLabel19);

        jLabel20.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 173, 218));
        jLabel20.setText("- Agregar");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
        jPanel1.add(jLabel20);

        jLabel27.setFont(new java.awt.Font("Roboto", 3, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 173, 218));
        jLabel27.setText("-Descargar");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        jPanel1.add(jLabel27);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 220, 60, 70);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/linea-separadora-3.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 500, 56, 10);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/linea-separadora-2.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(22, 170, 56, 2);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/linea-separadora-3.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 290, 56, 2);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(null);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(330, 11, 210, 32);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/buscar.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(260, 10, 321, 34);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/select-icon-blue.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(84, 130, 15, 29);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitoreo/imagenes/icono-rrhh-TEXTO.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 12, 140, 34);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-lightblue.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(35, 350, 30, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(35, 300, 30, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-lightblue.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(35, 180, 30, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-blue.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(35, 130, 30, 30);

        jLabel2.setBackground(new java.awt.Color(234, 234, 234));
        jLabel2.setBackground(new java.awt.Color(234, 234, 234));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/barra-superior.png"))); // NOI18N
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 910, 58);

        jLabel3.setBackground(new java.awt.Color(234, 234, 234));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/barra-izquierda.png"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 61, 100, 550);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setBackground(new java.awt.Color(0, 173, 238));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 58, 870, 3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CI", "Nombre", "Nombre 2", "Apellido", "Apellido 2", "Correo", "Foto", "Estado Civil", "Pais", "Cuidad", "Direccion", "telefono", "Celular", "Nacimiento", "Ingreso", "B. tipo", "B. dueño", "B. ci", "B. num", "S. total", "S. base", "S. iva", "S. supl.", "S. extra", "Banco", "Departamento", "Fondos", "Perfil", "ACTIVO", "Decimo Tercero", "Decimo Cuarto", "Alimentacion", "Actividades Comunes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, true, false, false, false, false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setVisible(false);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 80, 90, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        if(nav_seleccionado!=2){
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
            
        }
    }//GEN-LAST:event_jLabel5MouseEntered
    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        if(nav_seleccionado!=2){
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel5MouseExited
    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        if(nav_seleccionado!=3){
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel6MouseExited
    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        if(nav_seleccionado!=3){
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-blue.png"))); // NOI18N
            
        }
    }//GEN-LAST:event_jLabel6MouseEntered
    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        if(nav_seleccionado!=4){
jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel7MouseExited
    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        if(nav_seleccionado!=4){
            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-blue.png"))); // NOI18N
            
        }
    }//GEN-LAST:event_jLabel7MouseEntered
    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        if(nav_seleccionado!=1){
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel4MouseExited
    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        if(nav_seleccionado!=1){
            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-blue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel4MouseEntered
    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        configuracion= !configuracion;
        getjLabel16().setVisible(configuracion);
        getjLabel17().setVisible(configuracion);
        getjLabel25().setVisible(configuracion);
        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-arriba-blue.png"))); // NOI18N
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-blue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseClicked
    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseExited
    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/configuracion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseEntered
    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseExited
    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel16MouseEntered
    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        
        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-arriba-lightblue.png"))); // NOI18
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseExited
    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        
        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-arriba-blue.png"))); // NOI18N
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/flecha-abajo-blue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseEntered
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        nav_seleccionado=1;
        getjLabel9().setLocation(getjLabel9().getX(), getjLabel4().getY());
        cambio(inicio_panel);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-lightblue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-blue.png"))); // NOI18N
        
    }//GEN-LAST:event_jLabel4MouseClicked
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        nav_seleccionado=2;
        getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
        
        if(!getjPanel1().isVisible()){
            actual();
            jPanel1.setVisible(true);
            int up=getjPanel1().getHeight();
            jLabel14.setLocation(jLabel14.getX(),(Integer)position.get(2)+up);

            jLabel6.setLocation(jLabel6.getX(),(Integer)position.get(3)+up);
            jLabel11.setLocation(jLabel11.getX(),(Integer)position.get(4)+up);

            jLabel7.setLocation(jLabel7.getX(),(Integer)position.get(5)+up);
            jPanel2.setLocation(jPanel2.getX(),(Integer)position.get(6)+up);
            jLabel12.setLocation(jLabel12.getX(),(Integer)position.get(7)+up);
        }else{
            actual();
        }
        
    }//GEN-LAST:event_jLabel5MouseClicked
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try {
            nav_seleccionado=3;
            listdept.turno1();
            cambio(listdept);
            getjLabel9().setLocation(getjLabel9().getX(), getjLabel6().getY());
            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-lightblue.png"))); // NOI18N
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-blue.png"))); // NOI18N
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-lightblue.png"))); // NOI18N
            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
        } catch (Exception ex) {
            Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               
        
       
    }//GEN-LAST:event_jLabel6MouseClicked
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        nav_seleccionado=4;
        getjLabel9().setLocation(getjLabel9().getX(), getjLabel7().getY());
        
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/nomina-icon-blue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-lightblue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
        
        if(!getjPanel2().isVisible()){
            actual();
            jPanel2.setVisible(true);
            int up=getjPanel2().getHeight();
            jPanel2.setLocation(jPanel2.getX(),(Integer)position.get(6)+10);
            jLabel12.setLocation(jLabel12.getX(),(Integer)position.get(7)+up-15);
        }else{
            actual();
        }
        /*
         Original
         */
        
    }//GEN-LAST:event_jLabel7MouseClicked
    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        permisos permisos = new permisos(log);
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked
    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        nav_seleccionado=2;
        cambio(ing);
        getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel20MouseClicked
    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel19MouseEntered
    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel19MouseExited
    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jLabel20.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel20MouseExited
    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jLabel20.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel20MouseEntered
    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        nav_seleccionado=2;
        listemp.actdepa();
        if(log.getNivel().equalsIgnoreCase("Seguridad")){
            listemp.getjComboBox1().setVisible(false);
        }
        cambio(listemp);
        listaempleados lt = new listaempleados(2);
        lt.start();
        getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
    
    }//GEN-LAST:event_jLabel19MouseClicked
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        
    }//GEN-LAST:event_jTextField1KeyPressed
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if(evt.getKeyChar()=='\n') {
            nav_seleccionado=2;
            if(listemp.getjComboBox1().getItemCount()==0){
                listemp.actdepa();
            }
            cambio(listemp);
            listaempleados lt = new listaempleados(2);
            lt.start();
            getjLabel9().setLocation(getjLabel9().getX(), getjLabel5().getY());
            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/accounts-icon-lightblue.png"))); // NOI18N
            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/dptos-icon-lightblue.png"))); // NOI18N
            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/users-icon-blue.png"))); // NOI18N
            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rrhh/imagenes/home-icon-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jLabel22.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jLabel22.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel22MouseExited

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jLabel23.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        cambio(paneroles);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        cambio(report2);
        report2.getMulta().setNivel(log.getNivel());
        report2.getMulta().actualizar();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        cambio(report);
        report.getHoras().setNivel(log.getNivel());
        report.getHoras().actualizar();
        
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        cambio(estadistico);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        jLabel24.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        jLabel24.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        System.exit(0); 
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/imagenes/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        cambio(au);
        au.getPa().actualizar();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        jLabel26.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        jLabel26.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = chooser.showOpenDialog(this);
        String cadena="";
        if (respuesta == JFileChooser.APPROVE_OPTION)
        {
            cadena = chooser.getSelectedFile().getAbsolutePath();
        try{
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            List<Empleado> r = helper.getPersonasBycedeno();
            helper.confirmarTransaccion();
            helper.cerrarSesion();
            verempleados(r,cadena);
        }catch(Exception io){

        }
        }
    }//GEN-LAST:event_jLabel27MouseClicked

    public void verempleados(List<Empleado> lt, String dir){
        try{
            if(lt!=null){
                DefaultTableModel temp3 = (DefaultTableModel) jTable1.getModel();
                for(int i=temp3.getRowCount()-1;i>=0;i--){
                   temp3.removeRow(i);
                }
                for(Empleado i: lt){
                    String c=i.getCid();
                    String c1=i.getNombre1();
                    String c2=i.getNombre2();
                    String c3=i.getApellido1();
                    String c4=i.getApellido2();
                    String c5=i.getCorreo();
                    String c6=i.getFoto();
                    String c7=i.getEstadoCivil()+"";
                    String c8=i.getPais();
                    String c9=i.getCuidadResidencia();
                    String c10=i.getDireccion();
                    String c11=i.getTelefono();
                    String c12=i.getCelular();
                    String c13=Funcion.DateFormatSql(i.getFechaNacimiento());
                    String c14=Funcion.DateFormatSql(i.getFechaIngreso());
                    String c15=i.getCuentatipo();
                    String c16=i.getCuentadue();
                    String c17=i.getCuentaci();
                    String c18=i.getCuentanum();
                    String c19=i.getCumple2();
                    String c20=i.getDato1();
                    String c21=i.getDato2();
                    String c22=i.getDato4();
                    String c23=i.getDato3();
                    String c24=i.getBanco();
                    String c25=i.getDepartamento();
                    String c26=i.getFondos();
                    String c27=i.getPerfilpuesto();
                    String c28=i.getEstado();
                    String c29=i.getDecimotercero();
                    String c30=i.getDecimocuarto();
                    String c31=i.getAlimentacion();
                    String c32=i.getActividades();
                    Object nuevo[]= {c,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32};
                    temp3.addRow(nuevo);
                }
            }
            
            if(new exportar(jTable1,new File (dir+"\\Empleados.xls"),"").export()){
            JOptionPane.showMessageDialog(null, "Grabado Completado");
            }else{
                JOptionPane.showMessageDialog(null, "Error en Datos");
            }
        }catch(Exception io){}
    }
    
    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        jLabel27.setForeground(new java.awt.Color(0, 74, 151));
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        jLabel27.setForeground(new java.awt.Color(0, 173, 218));
    }//GEN-LAST:event_jLabel27MouseExited

    public reportes getReport() {
        return report;
    }

    public void setReport(reportes report) {
        this.report = report;
    }

    public ArrayList getPosition() {
        return position;
    }

    public void setPosition(ArrayList position) {
        this.position = position;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
    
    public class MyScrollbarUI extends BasicScrollBarUI {

       private Image imageThumb, imageTrack;
        private JButton b = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }

        };

        MyScrollbarUI() {
            imageThumb = FauxImage.create(32, 32, new Color(0,74,151));
            imageTrack = FauxImage.create(32, 32, Color.lightGray);
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

        static public Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }
    
    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuerpo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Cuerpo(null).setVisible(true);
                } catch (DocumentException ex) {
                    Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
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
}
