/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login.ventas;

import Login.Entidad.Articulos;
import Login.Entidad.Clientes;
import Login.Entidad.Ctepagar;
import Login.Entidad.Factura;
import Login.Entidad.Fcomisiones;
import Login.Entidad.Fempleado;
import Login.Entidad.Instalacion;
import Login.Entidad.Login;
import Login.Entidad.Productos;
import Login.Entidad.Proyectos;
import Login.servicio.ServiceHb;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import rrhh.servicio.Funcion;
/**
 *
 * @author homemig
 */
public class fproyectos extends javax.swing.JPanel {
    String cl;
    String numeroinstala="";
    List<Productos> lt=null;
    Proyectos proyecto =null;
    List<Articulos> ltart;
    List<Ctepagar> list;
    Factura fact;
    Factura fact2;
    fproyectos2 f = new fproyectos2();
    fproyectos3 f2 = new fproyectos3();
    fproyectos4 f3 = new fproyectos4();
    fproyectos5 f4 = new fproyectos5();
    fproyectos6 f5 = new fproyectos6();
    int x=0;
    int y=0;
    double porcent=0;
    String idcliente="";
    String idinstalacion="";
    String fcomisiones="";
    String totalinstalacion;
    String nombrecliente;
    String nombreinstalacion;
    double proyectoval=0;
    Instalacion in;
    DecimalFormat df = new DecimalFormat("0.00");
    int breakhilo=0;
    Login usuario;
    /**
     * Creates new form cliente
     * @param user
     */
    public fproyectos(Login user) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        String[] fecha= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        initComponents();
        Calendar rightNow = Calendar.getInstance();
        int ccyy = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        setSize(d.width, d.height-95);
        this.usuario=user;
        add(f);
        f.setLocation(jPanel1.getX(), jPanel1.getY());
        add(f3);
        f3.setLocation(jPanel1.getX(), jPanel1.getY());
        add(f4);
        f4.setLocation(jPanel1.getX(), jPanel1.getY());
        add(f5);
        f5.setLocation(jPanel1.getX(), jPanel1.getY());
        add(f2);
        f2.setLocation(jPanel1.getX(), jPanel1.getY());
        
        f2.getjButton1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ServiceHb helper = new ServiceHb();
                    helper.iniciarTransaccion();
                    Fcomisiones fc= helper.getFcomisiones(idcliente,idinstalacion);
                    if(helper.getFcomisiones(idcliente,idinstalacion)==null){
                        fc= new Fcomisiones();
                        Calendar d = Calendar.getInstance();
                        fc.setFecha(new java.sql.Date(d.getTime().getTime()));
                        fc.setClientes((Clientes)helper.obtenerObjeto(Clientes.class, Integer.parseInt(idcliente)));
                        fc.setInstalacion((Instalacion)helper.obtenerObjeto(Instalacion.class, Integer.parseInt(idinstalacion)));
                        fc.setRentabilidad(f2.getjLabel20().getText());
                        fc.setValor1(f2.getjLabel11().getText().substring(2, f2.getjLabel11().getText().length()));
                        fc.setValor2(f2.getjLabel2().getText().substring(3, f2.getjLabel2().getText().length()));
                        fc.setDiferido(f2.getjLabel4().getText());
                        fc.setDias(numeroinstala);
                        helper.crearObjeto(fc);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        JOptionPane.showMessageDialog(null,"Comision prepara con fecha "+ Funcion.DateFormatSql(d.getTime()));
                    }else{
                        Calendar d = Calendar.getInstance();
                        fc.setFecha(new java.sql.Date(d.getTime().getTime()));
                        fc.setRentabilidad(f2.getjLabel20().getText());
                        fc.setValor1(f2.getjLabel11().getText().substring(2, f2.getjLabel11().getText().length()));
                        fc.setValor2(f2.getjLabel2().getText().substring(3, f2.getjLabel2().getText().length()));
                        fc.setDiferido(f2.getjLabel4().getText());
                        fc.setDias(numeroinstala);
                        helper.actualizarObjeto(fc);
                        helper.confirmarTransaccion();
                        helper.cerrarSesion();
                        JOptionPane.showMessageDialog(null,"Actualizado / Comision prepara con fecha "+ Funcion.DateFormatSql(d.getTime()));
                    }
                }catch(Exception io){
                    System.out.println(io);
                }
            }
        });
        f2.getjButton2().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            @SuppressWarnings("UseSpecificCatch")
            public void mouseClicked(MouseEvent e) {
                float ancho=0;
                try{
                    Document documento = new Document(PageSize.A4, 0, 0, 0, 0);
                    ancho=documento.getPageSize().getWidth()-100;
                    FileOutputStream ficheroPdf;
                    PdfWriter writer=null;
                    PdfWriter writer2=null;
                    String direccion="";
                    Calendar now2 = Calendar.getInstance();
                    try
                    {
                        JFileChooser chooser = new JFileChooser();
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        //Mostrar la ventana para abrir archivo y recoger la respuesta
                        //En el parámetro del showOpenDialog se indica la ventana
                        //  al que estará asociado. Con el valor this se asocia a la
                        //  ventana que la abre.
                        int respuesta = chooser.showOpenDialog(null);
                        String cadena="";
                        if (respuesta == JFileChooser.APPROVE_OPTION)
                        {
                            direccion = chooser.getSelectedFile().getAbsolutePath();
                        }
                        Calendar d= Calendar.getInstance();
                        ficheroPdf = new FileOutputStream(direccion+"/"+idcliente+idinstalacion+".pdf");
                        writer= PdfWriter.getInstance(documento,ficheroPdf);
                    }catch (IOException ex){
                        System.out.println(ex.toString());
                    }
                    ServiceHb helper= null;
                    try{
                        List<Productos> lt=null;
                        helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        PdfPTable tabla;
                        PdfPCell casilla;
                        PdfPTable salto = null;
                        PdfPCell celda;
                        Font fontpersonalizado = FontFactory.getFont("ARIAL", 7, Font.BOLD);
                        Font fontpersonalizado2 = FontFactory.getFont("ARIAL", 7, Font.NORMAL);
                        documento.open();
                        PdfContentByte canvas = writer.getDirectContent();
                        fondos(documento,canvas);
//Materiales
                        double total=0;
                        double total2=0;
                        double total3=0;
                        double total4=0;
                        double total5=0;
                        tabla = new PdfPTable(6);
                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                        tabla.setTotalWidth(ancho);
                        tabla.setLockedWidth(true);
                        celda = new PdfPCell(new Paragraph("ADQUISICION DE MATERIALES"));
                        celda.setColspan(6);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        float pagina= documento.getPageSize().getHeight()-140;
                        final float max=pagina;
                        pagina = pagina-tabla.getRow(0).calculateHeights();
                        if(ltart!=null){
                            Object nuevo2[]= {"FECHA","DETALLE","CANT.","PRECIO","SUBTOTAL","TOTAL DIARIO"};
                            for(Object obj: nuevo2){
                                celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                                celda.setBorderColor(new Color(195,195,195));
                                celda.setColspan(1);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla.addCell(celda);
                            }
                            pagina = pagina-tabla.getRow(1).calculateHeights();
                            int tam=0;
                            double diario=0;
                            int turno=0;
                            for(int i=0; i< ltart.size();i++){
                                turno=0;
                                fact= helper.getFacturafecha(ltart.get(i).getIdfactura());
                                String fecha="";
                                if(fact!=null){
                                    fecha = Funcion.DateFormatSql(fact.getFecha());
                                }
                                if((i+1)==ltart.size()){
                                    diario=diario+Double.parseDouble(ltart.get(i).getTotal());
                                    turno=1;
                                }else{
                                    fact2= helper.getFacturafecha(ltart.get(i+1).getIdfactura());
                                    String fecha2="";
                                    if(fact2!=null){
                                        fecha2 = Funcion.DateFormatSql(fact2.getFecha());
                                        if(fecha.equalsIgnoreCase(fecha2)){
                                            diario=diario+Double.parseDouble(ltart.get(i).getTotal());
                                        }else{
                                            diario=diario+Double.parseDouble(ltart.get(i).getTotal());
                                            turno=1;
                                        }
                                    }
                                }
                                String uni = "$ "+df.format(Double.parseDouble(ltart.get(i).getUnitario())).replace(",", ".");
                                String tot = "$ "+df.format(Double.parseDouble(ltart.get(i).getTotal())).replace(",", ".");
                                total= total+Double.parseDouble(ltart.get(i).getTotal());
                                if(turno==0){
                                    Object nuevo[]= {fecha,ltart.get(i).getDescripcion(),ltart.get(i).getCantidad(),uni,tot,""};
                                    for(Object obj: nuevo){
                                        
                                        celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                                        if(((String)obj).equalsIgnoreCase("")){
                                            celda.setBorder(Rectangle.RIGHT);
                                        }
                                        celda.setBorderColor(new Color(195,195,195));
                                        celda.setColspan(1);
                                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        tabla.addCell(celda);
                                    }
                                }else{
                                    Object nuevo[]= {fecha,ltart.get(i).getDescripcion(),ltart.get(i).getCantidad(),uni,tot,"$ "+df.format(diario).replace(",", ".")};
                                    int va=0;
                                    for(Object obj: nuevo){
                                        va++;
                                        celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                                        if(va==5){
                                            celda.setBorder(Rectangle.BOTTOM);
                                        }
                                        celda.setColspan(1);
                                        celda.setBorderColor(new Color(195,195,195));
                                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        tabla.addCell(celda);
                                    }
                                    diario=0;
                                }
                                pagina = pagina-tabla.getRow(tam).getMaxHeights();
                                tam++;
                                if(pagina <11){
                                    salto= new PdfPTable(1);
                                    casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                                    casilla.setMinimumHeight(90);
                                    casilla.setBorder(PdfPCell.NO_BORDER);
                                    salto.addCell(casilla);
                                    documento.add(salto);
                                    
                                    documento.add(tabla);
                                    documento.newPage();
                                    fondos(documento,canvas);
                                    tabla = new PdfPTable(6);
                                    tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                                    tabla.setTotalWidth(ancho);
                                    tabla.setLockedWidth(true);
                                    pagina= max;
                                    tam=0;
                                }
                                
                            }
                        }
                        salto= new PdfPTable(1);
                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                        casilla.setMinimumHeight(90);
                        casilla.setBorder(PdfPCell.NO_BORDER);
                        salto.addCell(casilla);
                        documento.add(salto);
                        
                        celda = new PdfPCell(new Paragraph("Total",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("Adquisición de Materiales",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(4);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("$ "+df.format(total).replace(",", "."),new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        documento.add(tabla);
                        documento.newPage();
                        fondos(documento,canvas);
                        /*Parte 2*/
                        
                        
                        tabla = new PdfPTable(4);
                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                        tabla.setTotalWidth(ancho);
                        tabla.setLockedWidth(true);
                        tabla.setWidths(new int[]{1,3,1,1});
                        celda = new PdfPCell(new Paragraph("MANO DE OBRA TECNICOS"));
                        celda.setColspan(4);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        pagina= documento.getPageSize().getHeight()-140;
                        pagina = pagina-tabla.getRow(0).calculateHeights();
                        
                        if(list!=null){
                            Object nuevo2[]= {"FECHA","DETALLE","CANT.","SUBTOTAL"};
                            for(Object obj: nuevo2){
                                celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                                celda.setBorderColor(new Color(195,195,195));
                                celda.setColspan(1);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla.addCell(celda);
                            }
                            pagina = pagina-tabla.getRow(1).calculateHeights();
                            int tam=0;
                            double diario=0;
                            int turno=0;
                            for (Ctepagar list1 : list) {
                                if (list1.getDetalle().contains("ci:")) {
                                    String fecha = list1.getFecha();
                                    String desc = list1.getDetalle();
                                    String[] cadena =desc.split(" ");
                                    String result="";
                                    int contador=0;
                                    for(String n :cadena){
                                        if(n.contains("ci:")){
                                            result=result+", ";
                                            contador++;
                                        }else{
                                            result=result+n+" ";
                                        }
                                    }
                                    result= result.substring(0, result.length()-2);
                                    String uni = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    String tot = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    total2=total2+Double.parseDouble(list1.getValor());
                                    Object nuevo[]= {fecha,result,""+contador,tot};
                                    for(Object obj: nuevo){
                                        celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                                        celda.setBorderColor(new Color(195,195,195));
                                        celda.setColspan(1);
                                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        tabla.addCell(celda);
                                    }
                                    pagina = pagina-tabla.getRow(tam).getMaxHeights();
                                    tam++;
                                    if(pagina <90){
                                        salto= new PdfPTable(1);
                                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado2)));
                                        casilla.setMinimumHeight(90);
                                        casilla.setBorder(PdfPCell.NO_BORDER);
                                        salto.addCell(casilla);
                                        documento.add(salto);

                                        documento.add(tabla);
                                        documento.newPage();
                                        fondos(documento,canvas);
                                        tabla = new PdfPTable(4);
                                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                                        tabla.setTotalWidth(ancho);
                                        tabla.setLockedWidth(true);
                                        tabla.setWidths(new int[]{1,3,1,1});
                                        pagina= max;
                                        tam=0;
                                    }
                                }
                            }
                        }
                        salto= new PdfPTable(1);
                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                        casilla.setMinimumHeight(90);
                        casilla.setBorder(PdfPCell.NO_BORDER);
                        salto.addCell(casilla);
                        documento.add(salto);
                        
                        celda = new PdfPCell(new Paragraph("Total",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("Mano de Obra Técnicos",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(2);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("$ "+df.format(total2).replace(",", "."),new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        documento.add(tabla);
                        
                        documento.newPage();
                        fondos(documento,canvas);
                        
                        tabla = new PdfPTable(3);
                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                        tabla.setTotalWidth(ancho);
                        tabla.setLockedWidth(true);
                        tabla.setWidths(new int[]{1,3,1});
                        celda = new PdfPCell(new Paragraph("TRANSPORTE"));
                        celda.setColspan(3);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        pagina= documento.getPageSize().getHeight()-140;
                        pagina = pagina-tabla.getRow(0).calculateHeights();
                        
                        if(list!=null){
                            Object nuevo2[]= {"FECHA","DETALLE","SUBTOTAL"};
                            for(Object obj: nuevo2){
                                celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                                celda.setBorderColor(new Color(195,195,195));
                                celda.setColspan(1);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla.addCell(celda);
                            }
                            pagina = pagina-tabla.getRow(1).calculateHeights();
                            int tam=0;
                            for (Ctepagar list1 : list) {
                                if (list1.getDetalle().contains("Transporte")) {
                                    String fecha = list1.getFecha();
                                    String desc = list1.getDetalle();
                                    String result="";
                                    String uni = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    String tot = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    total3=total3+Double.parseDouble(list1.getValor());
                                    Object nuevo[]= {fecha,desc,tot};
                                    for(Object obj: nuevo){
                                        celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                                        celda.setBorderColor(new Color(195,195,195));
                                        celda.setColspan(1);
                                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        tabla.addCell(celda);
                                    }
                                    pagina = pagina-tabla.getRow(tam).getMaxHeights();
                                    tam++;
                                    if(pagina <50){
                                        salto= new PdfPTable(1);
                                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado2)));
                                        casilla.setMinimumHeight(90);
                                        casilla.setBorder(PdfPCell.NO_BORDER);
                                        salto.addCell(casilla);
                                        documento.add(salto);

                                        documento.add(tabla);
                                        documento.newPage();
                                        fondos(documento,canvas);
                                        tabla = new PdfPTable(3);
                                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                                        tabla.setTotalWidth(ancho);
                                        tabla.setLockedWidth(true);
                                        tabla.setWidths(new int[]{1,3,1});
                                        pagina= max;
                                        tam=0;
                                    }
                                }
                            }
                        }
                        salto= new PdfPTable(1);
                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                        casilla.setMinimumHeight(90);
                        casilla.setBorder(PdfPCell.NO_BORDER);
                        salto.addCell(casilla);
                        documento.add(salto);
                        
                        celda = new PdfPCell(new Paragraph("Total",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("Transporte",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("$ "+df.format(total3).replace(",", "."),new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        documento.add(tabla);
                        
                        documento.newPage();
                        fondos(documento,canvas);
                        
                        
                        tabla = new PdfPTable(3);
                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                        tabla.setTotalWidth(ancho);
                        tabla.setLockedWidth(true);
                        tabla.setWidths(new int[]{1,3,1});
                        celda = new PdfPCell(new Paragraph("COMBUSTIBLE"));
                        celda.setColspan(3);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        pagina= documento.getPageSize().getHeight()-140;
                        pagina = pagina-tabla.getRow(0).calculateHeights();
                        
                        if(list!=null){
                            Object nuevo2[]= {"FECHA","DETALLE","SUBTOTAL"};
                            for(Object obj: nuevo2){
                                celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                                celda.setBorderColor(new Color(195,195,195));
                                celda.setColspan(1);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla.addCell(celda);
                            }
                            pagina = pagina-tabla.getRow(1).calculateHeights();
                            int tam=0;
                            for (Ctepagar list1 : list) {
                                if (list1.getDetalle().contains("Combustible")) {
                                    String fecha = list1.getFecha();
                                    String desc = list1.getDetalle();
                                    String result="";
                                    String uni = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    String tot = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    total4=total4+Double.parseDouble(list1.getValor());
                                    Object nuevo[]= {fecha,desc,tot};
                                    for(Object obj: nuevo){
                                        celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                                        celda.setBorderColor(new Color(195,195,195));
                                        celda.setColspan(1);
                                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        tabla.addCell(celda);
                                    }
                                    pagina = pagina-tabla.getRow(tam).getMaxHeights();
                                    tam++;
                                    if(pagina <50){
                                        salto= new PdfPTable(1);
                                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                                        casilla.setMinimumHeight(90);
                                        casilla.setBorder(PdfPCell.NO_BORDER);
                                        salto.addCell(casilla);
                                        documento.add(salto);

                                        documento.add(tabla);
                                        documento.newPage();
                                        fondos(documento,canvas);
                                        tabla = new PdfPTable(3);
                                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                                        tabla.setTotalWidth(ancho);
                                        tabla.setLockedWidth(true);
                                        tabla.setWidths(new int[]{1,3,1});
                                        pagina= max;
                                        tam=0;
                                    }
                                }
                            }
                        }
                        salto= new PdfPTable(1);
                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                        casilla.setMinimumHeight(90);
                        casilla.setBorder(PdfPCell.NO_BORDER);
                        salto.addCell(casilla);
                        documento.add(salto);
                        
                        celda = new PdfPCell(new Paragraph("Total",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("Combustible",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("$ "+df.format(total4).replace(",", "."),new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        documento.add(tabla);
                        
                        documento.newPage();
                        fondos(documento,canvas);
                        
                        //Extras
                        
                        tabla = new PdfPTable(3);
                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                        tabla.setTotalWidth(ancho);
                        tabla.setLockedWidth(true);
                        tabla.setWidths(new int[]{1,3,1});
                        celda = new PdfPCell(new Paragraph("EXTRAS"));
                        celda.setColspan(3);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        pagina= documento.getPageSize().getHeight()-140;
                        pagina = pagina-tabla.getRow(0).calculateHeights();
                        
                        if(list!=null){
                            Object nuevo2[]= {"FECHA","DETALLE","SUBTOTAL"};
                            for(Object obj: nuevo2){
                                celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                                celda.setBorderColor(new Color(195,195,195));
                                celda.setColspan(1);
                                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                tabla.addCell(celda);
                            }
                            pagina = pagina-tabla.getRow(1).calculateHeights();
                            int tam=0;
                            for (Ctepagar list1 : list) {
                                if (!list1.getDetalle().contains("Combustible") && !list1.getDetalle().contains("ci:") &&!list1.getDetalle().contains("Transporte")  ) {
                                    String fecha = list1.getFecha();
                                    String desc = list1.getDetalle();
                                    String result="";
                                    String uni = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    String tot = "$ " + df.format(Double.parseDouble(list1.getValor())).replace(",", ".");
                                    total5=total5+Double.parseDouble(list1.getValor());
                                    Object nuevo[]= {fecha,desc,tot};
                                    for(Object obj: nuevo){
                                        celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                                        celda.setBorderColor(new Color(195,195,195));
                                        celda.setColspan(1);
                                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        tabla.addCell(celda);
                                    }
                                    pagina = pagina-tabla.getRow(tam).getMaxHeights();
                                    tam++;
                                    if(pagina <50){
                                        salto= new PdfPTable(1);
                                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                                        casilla.setMinimumHeight(90);
                                        casilla.setBorder(PdfPCell.NO_BORDER);
                                        salto.addCell(casilla);
                                        documento.add(salto);

                                        documento.add(tabla);
                                        documento.newPage();
                                        fondos(documento,canvas);
                                        tabla = new PdfPTable(3);
                                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                                        tabla.setTotalWidth(ancho);
                                        tabla.setLockedWidth(true);
                                        tabla.setWidths(new int[]{1,3,1});
                                        pagina= max;
                                        tam=0;
                                    }
                                }
                            }
                        }
                        salto= new PdfPTable(1);
                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                        casilla.setMinimumHeight(90);
                        casilla.setBorder(PdfPCell.NO_BORDER);
                        salto.addCell(casilla);
                        documento.add(salto);
                        
                        celda = new PdfPCell(new Paragraph("Total",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("Extra",new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("$ "+df.format(total5).replace(",", "."),new Font(fontpersonalizado2)));
                        celda.setBorderColor(new Color(195,195,195));
                        celda.setColspan(1);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        
                        documento.add(tabla);
                        
                        documento.newPage();
                        fondos(documento,canvas);
                        
                        
                        //Final Vendedor
                        
                        
                        tabla = new PdfPTable(3);
                        tabla.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                        tabla.setTotalWidth(ancho);
                        tabla.setLockedWidth(true);
                        tabla.setWidths(new int[]{1,3,1});
                        celda = new PdfPCell(new Paragraph(nombrecliente));
                        celda.setColspan(3);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        
                        celda = new PdfPCell(new Paragraph("Venta"));
                        celda.setColspan(3);
                        celda.setHorizontalAlignment(Element.ALIGN_LEFT);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        
                        pagina= documento.getPageSize().getHeight()-140;
                        pagina = pagina-tabla.getRow(0).calculateHeights();
                        
                        Object nuevo2[]= {"FECHA","DETALLE","TOTAL"};
                        for(Object obj: nuevo2){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                            celda.setBorderColor(new Color(195,195,195));
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        Object nuevo3[]= {"",nombreinstalacion,totalinstalacion};
                        for(Object obj: nuevo3){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                            celda.setBorderColor(new Color(195,195,195));
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        celda = new PdfPCell(new Paragraph("INVERSION",new Font(fontpersonalizado)));
                        celda.setBorder(PdfPCell.NO_BORDER);
                        celda.setColspan(3);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celda);
                        Object nuevo4[]= {"Uso de Materiales","","$ "+df.format(total).replace(",", ".")};
                        for(Object obj: nuevo4){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        Object nuevo5[]= {"Mano de obra técnicos","","$ "+df.format(total2).replace(",", ".")};
                        for(Object obj: nuevo5){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        Object nuevo6[]= {"Transporte","","$ "+df.format(total3).replace(",", ".")};
                        for(Object obj: nuevo6){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        Object nuevo7[]= {"Combustible","","$ "+df.format(total4).replace(",", ".")};
                        for(Object obj: nuevo7){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        Object nuevo71[]= {"Extras","","$ "+df.format(total5).replace(",", ".")};
                        for(Object obj: nuevo71){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        Object nuevo8[]= {"Total Inversión","","$ "+df.format(total+total2+total3+total4).replace(",", ".")};
                        for(Object obj: nuevo8){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado2)));
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        celda = new PdfPCell(new Paragraph(""));
                        celda.setColspan(3);
                        celda.setHorizontalAlignment(Element.ALIGN_LEFT);
                        celda.setBorder(PdfPCell.NO_BORDER);
                        tabla.addCell(celda);
                        
                        Object nuevo9[]= {"Utilidad del proyecto","","$ "+df.format(proyectoval-total-total2-total3-total4).replace(",", ".")};
                        for(Object obj: nuevo9){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                            celda.setColspan(1);
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        Object nuevo10[]= {"Rentabilidad ","",df.format(porcent).replace(",",".")+" %"};
                        for(Object obj: nuevo10){
                            celda = new PdfPCell(new Paragraph((String)obj,new Font(fontpersonalizado)));
                            celda.setBorder(PdfPCell.NO_BORDER);
                            celda.setColspan(1);
                            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celda);
                        }
                        
                        salto= new PdfPTable(1);
                        casilla = new PdfPCell(new Phrase("",new Font(fontpersonalizado)));
                        casilla.setMinimumHeight(90);
                        casilla.setBorder(PdfPCell.NO_BORDER);
                        salto.addCell(casilla);
                        documento.add(salto);
                        
                        documento.add(tabla);
                        

                        /*Fin Parte 3*/
                        documento.close();
                        helper.cerrarSesion();
                    }catch(Exception ex){
                        documento.close();
                    }
                    JOptionPane.showMessageDialog(null, "PDF Generado");
                }catch(Exception io){
                    System.out.println(io);
                }
            }
        });
        f.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row= f.getjTable1().getSelectedRow();
                int col= f.getjTable1().getSelectedColumn();
                if(col==4){
                    f2.setVisible(true);
                    f.setVisible(false);
                    idcliente=f.getjTable1().getValueAt(row, 5).toString();
                    idinstalacion=f.getjTable1().getValueAt(row, 6).toString();
                    f2.getjLabel15().setText(f.getjTable1().getValueAt(row, 0).toString());
                    f2.getjLabel8().setText(f.getjTable1().getValueAt(row, 2).toString());
                    nombrecliente=f.getjTable1().getValueAt(row, 0).toString();
                    nombreinstalacion=f.getjTable1().getValueAt(row, 2).toString();
                    updateTablas up = new updateTablas(1);
                    up.start();
                }
            }
        });
        f5.getjComboBox1().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel temp2 = (DefaultTableModel) f5.getjTable2().getModel();
                for(int i=temp2.getRowCount()-1;i>=0;i--){
                   temp2.removeRow(i);
                }
                f5.setComi(null);
                f5.setNinstalacion("");
                f5.setNcliente("");
                f5.setList(null);
                f5.setId("");
                updateTablas up = new updateTablas(4);
                up.start();
            }
        });
        f3.getjTable1().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row= f3.getjTable1().getSelectedRow();
                int col= f3.getjTable1().getSelectedColumn();
                if(col==6){
                    visible(f4);
                    fcomisiones=f3.getjTable1().getValueAt(row, 6).toString();
                    try{
                        ServiceHb helper = new ServiceHb();
                        helper.iniciarTransaccion();
                        Fcomisiones ft = (Fcomisiones)helper.obtenerObjeto(Fcomisiones.class, Integer.parseInt(fcomisiones));
                        numeroinstala=ft.getDias();
                        f4.setIdcliente(""+ft.getClientes().getId());
                        f4.setIdinstalacion(""+ft.getInstalacion().getId());
                        f4.getDiasint().setText(numeroinstala);
                        helper.cerrarSesion();
                    }catch(Exception io){
                    
                    }
                    f4.getjLabel1().setText(fcomisiones);
                    f4.getC1().setText(f3.getjTable1().getValueAt(row, 0).toString());
                    f4.getC2().setText(f3.getjTable1().getValueAt(row, 1).toString());
                    double campo1= Double.parseDouble(f3.getjTable1().getValueAt(row, 3).toString().replace("$ ",""));
                    double campo2= Double.parseDouble(f3.getjTable1().getValueAt(row, 4).toString().replace("-$ ",""));
                    f4.getC3().setText(f3.getjTable1().getValueAt(row, 3).toString());
                    f4.getC4().setText(f3.getjTable1().getValueAt(row, 4).toString());
                    f4.getC5().setText(f3.getjTable1().getValueAt(row, 5).toString());
                    f4.getC6().setText("$ "+df.format((campo1-campo2)).replace(",", "."));
                    
                    updateTablas up = new updateTablas(3);
                    up.start();
                }
            }
        });
        
        setVisible(false);
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public fproyectos2 getF() {
        return f;
    }

    public String getNumeroinstala() {
        return numeroinstala;
    }

    public void setNumeroinstala(String numeroinstala) {
        this.numeroinstala = numeroinstala;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public void setF(fproyectos2 f) {
        this.f = f;
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

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void fondos(Document documento,PdfContentByte canvas){
        try {
            Image imghead = Image.getInstance(usuario.getDireccion()+"/plantilla.jpg");
            imghead.setAbsolutePosition(0, 0);
            imghead.setAlignment(Image.ALIGN_CENTER);
            float scaler = ((documento.getPageSize().getWidth() - documento.leftMargin()
                    - documento.rightMargin()) / imghead.getWidth()) * 100;
            imghead.scalePercent(scaler);
            PdfTemplate tp = canvas.createTemplate(PageSize.A4.getWidth(), PageSize.A4.getHeight()); //el área destinada para el encabezado
            tp.addImage(imghead);
            x=(int)imghead.getWidth();
            y=(int)imghead.getHeight();
            canvas.addTemplate(tp,0, 0);//posición del témplate derecha y abajo
        } catch (IOException | DocumentException io) {
            
        }
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

    public fproyectos3 getF2() {
        return f2;
    }

    public void setF2(fproyectos3 f2) {
        this.f2 = f2;
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

    public fproyectos5 getF4() {
        return f4;
    }

    public void setF4(fproyectos5 f4) {
        this.f4 = f4;
    }

    public String getFcomisiones() {
        return fcomisiones;
    }

    public void setFcomisiones(String fcomisiones) {
        this.fcomisiones = fcomisiones;
    }
    
    public void llenarrrhh(){
        ServiceHb helper= null;
        try{
            List<Fempleado> lfemplt=null;
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            lfemplt=helper.getlistaFempleado(fcomisiones);
            f4.llenarlt(lfemplt);
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public void llenarfinal(){
        ServiceHb helper= null;
        try{
            List<Fcomisiones> ltfcomi=null;
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            ltfcomi=helper.getlistaComisiones(f5.getjComboBox1().getSelectedItem().toString());
            DefaultTableModel temp2 = (DefaultTableModel) f5.getjTable1().getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(ltfcomi!=null){
                for(Fcomisiones i: ltfcomi){
                    if(breakhilo==1){break;}
                    DefaultTableModel temp = (DefaultTableModel) f5.getjTable1().getModel();
                    String val1= "$ "+df.format(Double.parseDouble(i.getValor1())).replace(",", ".");
                    String val2= "-$ "+df.format(Double.parseDouble(i.getValor2())).replace(",", ".");
                    String val3=  "% "+df.format(Double.parseDouble(i.getRentabilidad())).replace(",", ".");
                    Object nuevo[]= {i.getClientes().getApellido(),i.getInstalacion().getDetalle(),Funcion.DateFormatSql(i.getFecha()),val1,val2,val3,i.getId()};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public void llenarcomi(){
        ServiceHb helper= null;
        try{
            List<Fcomisiones> ltfcomi2=null;
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            ltfcomi2=helper.getlistaComisiones();
            DefaultTableModel temp2 = (DefaultTableModel) f3.getjTable1().getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            if(ltfcomi2!=null){
                for(Fcomisiones i: ltfcomi2){
                    if(breakhilo==1){break;}
                    DefaultTableModel temp = (DefaultTableModel) f3.getjTable1().getModel();
                    String val1= "$ "+df.format(Double.parseDouble(i.getValor1())).replace(",", ".");
                    String val2= "-$ "+df.format(Double.parseDouble(i.getValor2())).replace(",", ".");
                    String ret= "% "+df.format(Double.parseDouble(i.getRentabilidad())).replace(",", ".");
                    Object nuevo[]= {i.getClientes().getApellido(),i.getInstalacion().getDetalle(),Funcion.DateFormatSql(i.getFecha()),val1,val2,ret,i.getId()};
                    temp.addRow(nuevo);
                }
            }
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    public void llenarfinan(){
        ServiceHb helper= null;
        double total1=0;
        try{
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            proyecto=helper.getlistaProyectosFinan(idinstalacion);
            in =(Instalacion) helper.obtenerObjeto(Instalacion.class, Integer.parseInt(idinstalacion));
            lt=helper.getlistaProductos(Integer.toString(proyecto.getId()));
            DefaultTableModel temp2 = (DefaultTableModel) f2.getjTable2().getModel();
            reiniciarJTable(f2.getjTable2());
            
            f2.getjLabel13().setText(proyecto.getDescuento());
            f2.getjLabel14().setText(proyecto.getAumento());
            f2.getjLabel12().setText(proyecto.getInteres());
            
            f2.getjLabel3().setText(proyecto.getAnticipo());
            f2.getjLabel4().setText(proyecto.getDiferido());
            f2.getjLabel1().setText(proyecto.getCredito());
            
            if(lt!=null){
                DefaultTableModel temp = (DefaultTableModel) f2.getjTable2().getModel();
                for(Productos i: lt){
                    if(breakhilo==1){break;}
                    if(i.getDescripcion().toUpperCase().contains("Cuadrilla".toUpperCase())){
                        numeroinstala=i.getCantidad();
                    }else{
                        numeroinstala="1";
                    }
                    String nn= i.getTotal().replace("$", "");
                    String uni= "$ "+df.format(Double.parseDouble(i.getUnitario())).replace(",", ".");
                    String tot= "$ "+df.format(Double.parseDouble(nn)).replace(",", ".");
                    Object nuevo[]= {i.getCantidad(),i.getDescripcion(),uni,tot};
                    temp.addRow(nuevo);
                    total1=Double.parseDouble(nn)+total1;
                    proyectoval=total1;
                    f2.getjLabel11().setText("$ "+df.format(total1).replace(",", "."));
                }
            }
            f2.getjLabel11().setText("$ "+df.format(total1).replace(",", "."));
            totalinstalacion="$ "+df.format(total1).replace(",", "."); 
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
        double total2=0;
        try{
            helper= new ServiceHb();
            helper.iniciarTransaccion();
            ltart = helper.getListaArticulosfin(idcliente,idinstalacion);
            list = helper.getlistaCtePagarvarios(idcliente,idinstalacion);
            DefaultTableModel temp2 = (DefaultTableModel) f2.getjTable1().getModel();
            for(int i=temp2.getRowCount()-1;i>=0;i--){
               temp2.removeRow(i);
            }
            
            if(ltart!=null){
                for(Articulos i: ltart){
                    if(breakhilo==1){break;}
                    DefaultTableModel temp = (DefaultTableModel) f2.getjTable1().getModel();
                    fact= helper.getFacturafecha(i.getIdfactura());
                    String fecha="";
                    if(fact!=null){
                        if(fact.getFecha2()!=null){
                            fecha = Funcion.DateFormatSql(fact.getFecha2());
                        }else{
                            fecha = Funcion.DateFormatSql(fact.getFecha());
                        }
                    }
                    String uni = "$ "+df.format(Double.parseDouble(i.getUnitario())).replace(",", ".");
                    String tot = "$ "+df.format(Double.parseDouble(i.getTotal())).replace(",", ".");
                    Object nuevo[]= {fecha,i.getCantidad(),i.getDescripcion(),uni,tot,i.getId()};
                    temp.addRow(nuevo);
                    total2=Double.parseDouble(i.getTotal())+total2;
                    f2.getjLabel2().setText("-$ "+df.format(total2).replace(",", "."));
                }
            }
            if(list!=null){
                for(Ctepagar i: list){
                    if(breakhilo==1){break;}
                    DefaultTableModel temp = (DefaultTableModel) f2.getjTable1().getModel();
                    String fecha= i.getFecha();
                    String desc= i.getDetalle();
                    String uni = "$ "+df.format(Double.parseDouble(i.getValor())).replace(",", ".");
                    String tot = "$ "+df.format(Double.parseDouble(i.getValor())).replace(",", ".");
                    Object nuevo[]= {fecha,"1",desc,uni,tot};
                    temp.addRow(nuevo);
                    total2=Double.parseDouble(i.getValor())+total2;
                    f2.getjLabel2().setText("-$ "+df.format(total2).replace(",", "."));
                }
            }
            f2.getjLabel2().setText("-$ "+df.format(total2).replace(",", "."));
            
            porcent= ((total1-total2)/total1)*100;
            if(porcent>50){
                f2.getjLabel9().setText("% "+df.format(porcent).replace(",", ".")+ ">> % 50");
                f2.getjButton1().setVisible(true);
            }else{
                f2.getjLabel9().setText("% "+df.format(porcent).replace(",", ".")+ "<< % 50");
                f2.getjButton1().setVisible(true);
                JOptionPane.showMessageDialog(null, "Menos del 50%");
            }
            f2.getjLabel20().setText(""+porcent);
            
            helper.cerrarSesion();
        }catch(Exception io){
        
        }
    }
    
    public static void reiniciarJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);

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
                llenarfinan();
            }
            if(turno==2){
                llenarcomi();
            }
            if(turno==3){
                llenarrrhh();
            }
            if(turno==4){
                llenarfinal();
            }
        }
    }
    
    public void carga1(){
    }
    
    
    public void carga2(){
        
    }

    public fproyectos4 getF3() {
        return f3;
    }

    public void setF3(fproyectos4 f3) {
        this.f3 = f3;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public fproyectos6 getF5() {
        return f5;
    }

    public void setF5(fproyectos6 f5) {
        this.f5 = f5;
    }

    public String getIdinstalacion() {
        return idinstalacion;
    }

    public void setIdinstalacion(String idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public int getBreakhilo() {
        return breakhilo;
    }

    public void setBreakhilo(int breakhilo) {
        this.breakhilo = breakhilo;
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
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setLayout(null);

        jButton5.setFont(new java.awt.Font("Roboto Light", 3, 10)); // NOI18N
        jButton5.setText("CONSULTA: PROYECTOS EN CURSO");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(30, 120, 250, 40);

        jButton6.setFont(new java.awt.Font("Roboto Light", 3, 10)); // NOI18N
        jButton6.setText("BUSQUEDA DE COMISIONES / RRHH");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(30, 280, 250, 40);

        jButton7.setFont(new java.awt.Font("Roboto Light", 3, 10)); // NOI18N
        jButton7.setText("CONTROL DE COMISIONES PENDIENTES");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(30, 200, 250, 40);

        add(jPanel1);
        jPanel1.setBounds(30, 100, 310, 430);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setText("Analisis de Proyectos");
        add(jLabel2);
        jLabel2.setBounds(30, 40, 230, 30);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel1.setText("Modulo Financiero - Contable");
        add(jLabel1);
        jLabel1.setBounds(30, 10, 330, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        visible(f);
        //f.getjLabel3().setText(jButton4.getText());
        f.llenarhilo();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        visible(f5);
        updateTablas up = new updateTablas(4);
        up.start();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        visible(f3);
        updateTablas up = new updateTablas(2);
        up.start();
    }//GEN-LAST:event_jButton7MouseClicked
    public void visible(JPanel pane){
        f.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        jPanel1.setVisible(false);
        pane.setVisible(true);
    }        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
