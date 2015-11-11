package Bitacora.acceso;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import Bitacora.servicio.Funcion;
import Bitacora.servicio.ServiceHb;
import Bitacora.tablas.Asistencia;
import Bitacora.tablas.Monitor;
import Bitacora.tablas.Registros;
import Bitacora.tablas.Usuario;






/**
 * 
 *
 * 
 * @author Angelmath
 * 
 */

public final class Cuadro extends javax.swing.JFrame {
    busqueda n1;
    registrosparcial n5;
    observa n8;

    Monitor moni1=null;
    Thread h1;
    String hora,minutos,segundos,ampm;
    Calendar calendario;
    Thread hilo;
    Timer countdownTimer;
    int ingresotipo=0;
    Timer countdownTimer2;
    Timer countdownTimer3;
    Timer countdownTimer4;
    ServiceHb service =null;
    int timeRemaining = 15;
    int turnonav=1;
    int turnonav2=1;
    boolean ingreso= true;
    boolean ingreso2= true;
    boolean pendiente= true;
    boolean actualizacion= true;
    boolean actual=false;
    boolean actualizar=false;
    boolean configuracion=false;
    boolean error=true;
    DefaultTableModel base;
    int sortColumn;
    int[] row;
    Dimension d;
    String localidad="";
    Monitor mn1=null;
    String responsable="";
    boolean llenartabla=false;
    String direccion="";
    int x=0;
    int y=0;
    /**
     * 
     * Creates new form Cuadro
     * 
     */
    
    /**
     * Creates new form Cuadro
     * @param mn1
     * @param localidad
     * @param base
     * @throws java.awt.FontFormatException
     * @throws com.itextpdf.text.DocumentException
     */
    
    public Cuadro(Monitor mn1,String localidad,String base,String direccion) throws FontFormatException, DocumentException {
        this.direccion= direccion;
        d = Toolkit.getDefaultToolkit().getScreenSize();
        
        responsable=mn1.getMonitor();
        
        this.localidad=localidad;
        
        this.mn1=mn1;
        
        initComponents();
        
        Asistencia nuevo=new Asistencia();
        
        moni1=mn1;
        
        diseñosmarco();
        
        try{
            
            Date now = new Date(System.currentTimeMillis());
            
            ServiceHb servicemoni= new ServiceHb();
            
            servicemoni.iniciarTransaccion();
            
            if(mn1!=null){
                
                nuevo.setFechaEntrada(now);
                
                nuevo.setFechaSalida(null);
                
                nuevo.setMonitor(moni1);
                
                servicemoni.crearObjeto(nuevo);
                
            }
            
            servicemoni.confirmarTransaccion();
            
            servicemoni.cerrarTransaccion();
            
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        dispose();
        
        setUndecorated(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(true);
        
        setLocationRelativeTo(null);
        
        tablas();
        
        eventos();
        
        if(base.equalsIgnoreCase("")){
            actualizar=true;
        }else{   
        }
        new Thread(new Cargando(1)).start();
        
        JLabel jLabel3 = new JLabel();
        jLabel3.setSize(d.width-60, d.height-60);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/fondo.jpg"))); // NOI18N
        jLabel3.setIcon(new ImageIcon(((ImageIcon) jLabel3.getIcon()).getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), java.awt.Image.SCALE_DEFAULT)));
        add(jLabel3);
        
        setVisible(true);
        
    }
    
    
    public void eventos(){
        
        
        setEventoMouseClicked3(n5.getjTable1());
        
        setEventoMouseClicked6(n1.getjButton1());
        
    }
    
    
    
    public void diseñosmarco(){
        
        setSize(d.width-60, d.height-60);
        jPanel1.setLocation(((d.width-60)/2) - (jPanel1.getWidth()/2), jPanel1.getY());
        jLabel1.setSize(d.width-60, jLabel1.getHeight());
        jLabel15.setLocation(((d.width-60)) - (jLabel15.getWidth()), jLabel15.getY());
        jLabel15.setText(moni1.getMonitor());
        jLabel17.setLocation(((d.width-60)) - (jLabel17.getWidth()), jLabel17.getY());
        
        naveprincipal(campo1);
        n1 = new busqueda();
        
        n5 = new registrosparcial();
        
        n8 = new observa(responsable,this,direccion);
        
        n1.setLocation(jPanel1.getX()-277, 103);
        
        add(n1);
        
        n5.setLocation(jPanel1.getX()-277, 103);
        
        add(n5);
        
        
        n8.setLocation(jPanel1.getX()-277, 103);
        
        add(n8);
        
        
    }
    
    
    
    @Override
    
    public java.awt.Image getIconImage() {
        
        java.awt.Image retValue = Toolkit.getDefaultToolkit().
                
                getImage(ClassLoader.getSystemResource("imagenes/icon-caja.png"));
        
        return retValue;
        
    }
   
    protected int compare(int i, int j) {
        
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        
        return s1.compareTo(s2);
        
    }
    
    public void naveprincipal(JLabel lb){
        campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-registro-grey.png"))); // NOI18N
        campo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-observaciones-grey.png"))); // NOI18N
        campo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-busquedA-grey.png"))); // NOI18N
       
        if(lb==campo1){
            campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-registro-blue.png"))); // NOI18N
        }
        if(lb==campo4){
            campo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-observaciones-blue.png"))); // NOI18N
        }
        if(lb==campo5){
            campo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-busquedA-blue.png"))); // NOI18N
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
    
    
    
    public void tablas(){
        
        tablasmodelos(n8.getjTable1(),n8);
        
        n8.getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        n8.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        n8.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        n8.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        
        
        tablasmodelos(n1.getjTable1(),n1);
        
        n1.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        n1.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("text center") );
        
        n1.getjTable1().getColumnModel().getColumn(11).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(n5.getjTable1(),n5);
        
        n5.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        n5.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        
        n5.getjTable1().getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("text center") );
        
        
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
    
    public busqueda getN1() {
        
        return n1;
        
    }
    
    public void setN1(busqueda n1) {
        
        this.n1 = n1;
        
    }
    
    public Thread getH1() {
        
        return h1;
        
    }
    
    
    
    public void setH1(Thread h1) {
        
        this.h1 = h1;
        
    }
    
    
    
    public Timer getCountdownTimer3() {
        
        return countdownTimer3;
        
    }
    
    
    
    public void setCountdownTimer3(Timer countdownTimer3) {
        
        this.countdownTimer3 = countdownTimer3;
        
    }
    
    
    
    public Timer getCountdownTimer4() {
        
        return countdownTimer4;
        
    }
    
    
    
    public void setCountdownTimer4(Timer countdownTimer4) {
        
        this.countdownTimer4 = countdownTimer4;
        
    }
    
    
    
    public int getTurnonav() {
        
        return turnonav;
        
    }
    
    
    
    public void setTurnonav(int turnonav) {
        
        this.turnonav = turnonav;
        
    }
    
    
    
    public int getTurnonav2() {
        
        return turnonav2;
        
    }
    
    
    
    public void setTurnonav2(int turnonav2) {
        
        this.turnonav2 = turnonav2;
        
    }
    
    
    
    public boolean isActualizacion() {
        
        return actualizacion;
        
    }
    
    
    
    public void setActualizacion(boolean actualizacion) {
        
        this.actualizacion = actualizacion;
        
    }
    
    
    
    public boolean isActual() {
        
        return actual;
        
    }
    
    
    
    public void setActual(boolean actual) {
        
        this.actual = actual;
        
    }
    
    
    
    public boolean isActualizar() {
        
        return actualizar;
        
    }
    
    
    
    public void setActualizar(boolean actualizar) {
        
        this.actualizar = actualizar;
        
    }
    
    
    
    public boolean isError() {
        
        return error;
        
    }
    
    
    
    public void setError(boolean error) {
        
        this.error = error;
        
    }
    
    
    
    public Dimension getD() {
        
        return d;
        
    }
    
    
    
    public void setD(Dimension d) {
        
        this.d = d;
        
    }
    
    private void setEventoMouseClicked3(JTable tbl)
            
    {
        
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            
            
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                try {
                    
                    tblEjemploMouseClicked3(e);
                    
                } catch (Exception ex) {
                    
                    Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        });
        
    }
    
    private void setEventoMouseClicked4(JButton jb)
            
    {
        
        jb.addMouseListener(new java.awt.event.MouseAdapter() {
            
            
            
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                try {
                    
                    new Thread(new Cargando(2)).start();
                    
                } catch (Exception ex) {
                    
                    Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        });
        
    }
    
    
    
    private void setEventoKeyboard4(JTextField jb)
            
    {
        
        jb.addKeyListener(new java.awt.event.KeyAdapter() {
            
            
            
            @Override
            
            public void keyPressed(KeyEvent e) {
                
                new Thread(new Cargando(2)).start();
                
            }
            
        }
                
        );
        
    }
    
    
    
    private void setEventoMouseClicked6(JButton jb)
            
    {
        
        jb.addMouseListener(new java.awt.event.MouseAdapter() {
            
            
            
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                try {
                    
                    new Thread(new Cargando(4)).start();
                    
                } catch (Exception ex) {
                    
                    Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        });
        
    }
    
    void setEventoMouseingreso2()
            
    {
        if(turnonav==2){
            ingresotipo=1;
            new Thread(new Cargando(2)).start();
        }
        
        if(turnonav==3){
            
            ingresotipo=2;
            
            new Thread(new Cargando(2)).start();
            
        }
       
        turnonav2=2;
        
    }
    
    void setEventoMouseingreso3()
            
    {
                    
        if(turnonav==2){
            
            ingresotipo=1;
            
            new Thread(new Cargando(3)).start();
            
        }
        
        if(turnonav==3){
            
            ingresotipo=2;
            
            new Thread(new Cargando(3)).start();
            
        }
        
        turnonav2=3;    
        
        
    }
    
    void setEventoMouseingreso4()
            
    {    
        cambiopanel(n8);
        n8.refresh();
        
    }
    
    void setEventoMouseingreso1()
            
    {
        
    if(turnonav==2){
            
            ingresotipo=1;
            
        }
        
        if(turnonav==3){
            
            ingresotipo=2;
            
        }
        
        turnonav2=1;
        
    }
    
    
    
    public class Cargando implements Runnable{
        
        int n;
        
        int x;
        
        public Cargando(int x) {
            this.x=x;
        }
        
        @Override
        
        public void run() {
            try {
                llenartabla=false;
                Thread.sleep(800);
                if(x==1){
                    
                    CountdownTimerListener2sin();
                    
                }
                
                if(x==2){
                    
                    
                }
                
                if(x==3){
                    
                    
                }
                
                if(x==4){
                    
                    busqueda();
                    
                }
                
                if(x==5){
                    if(actual && actualizar){
                        actual=false;
                    }
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    private void setEventoMouseClicked5(JLabel lb)     
    {
        lb.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    actual=true;
                } catch (Exception ex) {
                    Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);   
                }   
            } 
        });    
    }
    
    public void busqueda(){
        service=null;
        int temporal=0;
        List<Registros> list;
        DefaultTableModel temp2 = (DefaultTableModel) n1.getjTable1().getModel();
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            temp2.removeRow(i);   
        }
        try{
            service = new ServiceHb();
            service.iniciarTransaccion();
            if((n1.getjDateChooser1().getDate()!=null)&&(n1.getjDateChooser2().getDate()!=null)){
                list = service.getRegistrosBusqueda2(n1.getjTextField2().getText(),n1.getjTextField3().getText(),n1.getjTextField4().getText(),n1.getjTextField6().getText(),n1.getjDateChooser1().getDate(),n1.getjDateChooser2().getDate(),n1.getjComboBox1().getSelectedItem().toString());
            }else{
                list = service.getRegistrosBusqueda(n1.getjTextField2().getText(),n1.getjTextField3().getText(),n1.getjTextField4().getText(),n1.getjTextField6().getText());
            }
            llenartabla=true;
            if(list!=null){
                for(int i=0; i<list.size();i++){
                    if(llenartabla){
                        n1.getjLabel6().setText((i+1)+"/"+list.size());
                        String campoo0= Integer.toString(list.get(i).getId());
                        String campoo4="";
                        if(list.get(i).getUsuario().getVehiculo()==null){
                        }else{
                            campoo4=list.get(i).getUsuario().getVehiculo().getPlaca();
                        }

                        String campoo1=list.get(i).getLocalidad();

                        String campoo2=list.get(i).getMonitor().getMonitor();

                        char campoo3=list.get(i).getTipoIngreso();

                        String campoo5=list.get(i).getUsuario().getCi();

                        String campoo6=list.get(i).getUsuario().getNombre();

                        String campoo7=list.get(i).getUsuario().getApellido();

                        String campoo8=list.get(i).getUsuario().getMaterial();

                        String campoo9=list.get(i).getUsuario().getObservacion();

                        String campoo11="";

                        if(list.get(i).getFechaSalida()==null){

                        }else{

                            campoo11=Funcion.DateTimeFormatJS(list.get(i).getFechaSalida());

                        }

                        String campoo10=Funcion.DateTimeFormatJS(list.get(i).getFechaIngreso());

                        DefaultTableModel temp = (DefaultTableModel) n1.getjTable1().getModel();

                        Object nuevo[]= {campoo0,campoo1,campoo2,campoo3,campoo4,campoo5,campoo6,campoo7,campoo8,campoo9,campoo10,campoo11};

                        temp.addRow(nuevo);

                    }
                }
            }
            service.cerrarSesion();
            
        } catch (Exception ex) {
            
            Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void CountdownTimerListener3 (){
        
    }
    
    
    
    
    
    
    
    class CountdownTimerListener2 implements ActionListener {
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            
            
            
            DefaultTableModel temp2 = (DefaultTableModel) n5.getjTable1().getModel();
            
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                
                temp2.removeRow(i);
                
            }
            
            try {
                
                ServiceHb servicereg = new ServiceHb();
                
                servicereg.iniciarTransaccion();
                
                List<Registros> list = servicereg.getRegistros();
                
                if(list!=null){
                    
                    for(int i=0; i<list.size();i++){
                        
                        int val0;
                        
                        int val1;
                        
                        char val2;
                        
                        String val3="";
                        String val9="";
                        
                        if(list.get(i).getFechaSalida()==null){
                            
                        }else{
                            
                            val9=Funcion.DateTimeFormatJS(list.get(i).getFechaSalida());
                            
                        }
                        
                        val1=list.get(i).getId();
                        
                        if(list.get(i).getUsuario().getVehiculo()==null){
                            
                        }else{
                            
                            val3=list.get(i).getUsuario().getVehiculo().getPlaca();
                            
                        }
                        
                        val2=list.get(i).getTipoIngreso();
                        
                        String val4=list.get(i).getUsuario().getCi();
                        
                        String val5=list.get(i).getUsuario().getNombre();
                        
                        String val6=list.get(i).getUsuario().getApellido();
                        
                        String val7=list.get(i).getObservacion();
                        
                        String val10=list.get(i).getUsuario().getAcreditacion().getDescripcion();
                        
                        val0=i+1;
                        
                        String val8=Funcion.DateTimeFormatJS(list.get(i).getFechaIngreso());
                        
                        DefaultTableModel temp = (DefaultTableModel) n5.getjTable1().getModel();
                        
                        Object nuevo[]= {val0,val1,val2,val3,val4,val5,val6,val7,val8,val9,val10};
                        
                        temp.addRow(nuevo);
                        
                    }
                    
                    
                    
                }
                
                servicereg.confirmarTransaccion();
                
                servicereg.cerrarTransaccion();
                
                servicereg.cerrarSesion();
                
            } catch (Exception ex) {
                
                Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
    }
    
    
    
    private void CountdownTimerListener2sin() {
        
        DefaultTableModel temp2 = (DefaultTableModel) n5.getjTable1().getModel();
        
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            
            temp2.removeRow(i);
            
        }
        
        try {
            
            ServiceHb registros = new ServiceHb();
            
            registros.iniciarTransaccion();
            
            List<Registros> list = registros.getRegistroslimite();
            llenartabla=true;
            if(list!=null){
                
                for(int i=0; i<list.size();i++){
                    if(llenartabla){
                        int val0;
                        int val1;
                        char val2;
                        String val3="";
                        String val10="";
                        if(list.get(i).getFechaSalida()==null){
                        }else{
                            val10=Funcion.DateTimeFormatJS(list.get(i).getFechaSalida());
                        }
                        
                        val1=list.get(i).getId();
                        
                        if(list.get(i).getUsuario().getVehiculo()==null){
                            
                        }else{
                            
                            val3=list.get(i).getUsuario().getVehiculo().getPlaca();
                            
                        }
                        
                        val2=list.get(i).getTipoIngreso();
                        
                        String val4=list.get(i).getUsuario().getCi();
                        
                        String val5=list.get(i).getUsuario().getNombre();
                        
                        String val6=list.get(i).getUsuario().getApellido();
                        
                        String val7=list.get(i).getLocalidad();
                        
                        String val8=list.get(i).getObservacion();
                        
                        //String val11=list.get(i).getUsuario().getAcreditacion().getDescripcion();
                        
                        val0=i+1;
                        
                        String val9=Funcion.DateTimeFormatJS(list.get(i).getFechaIngreso());
                        
                        DefaultTableModel temp = (DefaultTableModel) n5.getjTable1().getModel();
                        
                        Object nuevo[]= {val0,val1,val2,val3,val4,val5,val6,val7,val8,val9,val10};
                        
                        temp.addRow(nuevo);
                    }
                }
                
            }
            registros.confirmarTransaccion();
            registros.cerrarTransaccion();
            registros.cerrarSesion();
            
        } catch (Exception ex) {
            
            Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    
    
    public void CountdownTimerListener8() {
        
    }
    
    
    
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * 
     * WARNING: Do NOT modify this code. The content of this method is always
     * 
     * regenerated by the Form Editor.
     * 
     */
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        campo5 = new javax.swing.JLabel();
        campo1 = new javax.swing.JLabel();
        campo4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Access IC");
        setBackground(new java.awt.Color(255, 255, 0));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1200, 600));
        getContentPane().setLayout(null);

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 74, 151));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/flecha-abajo-blue.png"))); // NOI18N
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
        jLabel15.setBounds(1030, 0, 172, 58);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/cerrar-sesion-boton-lightblue.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(1030, 60, 172, 38);
        jLabel17.setVisible(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 100));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 100));
        jPanel1.setLayout(null);

        campo5.setBackground(new java.awt.Color(255, 255, 255));
        campo5.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        campo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-busquedA-blue.png"))); // NOI18N
        campo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo5MouseExited(evt);
            }
        });
        jPanel1.add(campo5);
        campo5.setBounds(380, 0, 185, 39);

        campo1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        campo1.setForeground(new java.awt.Color(255, 255, 255));
        campo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-registro-blue.png"))); // NOI18N
        campo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                campo1MouseReleased(evt);
            }
        });
        jPanel1.add(campo1);
        campo1.setBounds(0, 0, 185, 39);

        campo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-observaciones-blue.png"))); // NOI18N
        campo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campo4MouseExited(evt);
            }
        });
        jPanel1.add(campo4);
        campo4.setBounds(190, 0, 185, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 62, 570, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/titulo-bitacora.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 340, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/barra.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
        
    
    
    
    
    
    
    
        
    
    
    public void cambiopanel(JPanel pane){
        
        n1.setVisible(false);
        n5.setVisible(false);
        n8.setVisible(false);        
        pane.setVisible(true);
        
    }
    
    
    private void campo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo1MouseClicked
        
        ingreso=true;
        ingreso2=true;
        turnonav=1;
        
        naveprincipal(campo1);
        
        new Thread(new Cargando(1)).start();
        
        cambiopanel(n5);
        
    }//GEN-LAST:event_campo1MouseClicked
    
    
    
    public Monitor getMoni1() {
        
        return moni1;
        
    }
    
    
    
    public void setMoni1(Monitor moni1) {
        
        this.moni1 = moni1;
        
    }
    
    
    
    public int getIngresotipo() {
        
        return ingresotipo;
        
    }
    
    
    
    public void setIngresotipo(int ingresotipo) {
        
        this.ingresotipo = ingresotipo;
        
    }
    
    
    
    public boolean isIngreso2() {
        
        return ingreso2;
        
    }
    
    
    
    public void setIngreso2(boolean ingreso2) {
        
        this.ingreso2 = ingreso2;
        
    }
    
    
        
    
    
    private void campo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo1MouseEntered
        
        if(turnonav!=1){
            
            campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-registro-blue.png"))); // NOI18N
            
        }
        
    }//GEN-LAST:event_campo1MouseEntered
    
    
    
    private void campo1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo1MouseReleased
        
        
        
    }//GEN-LAST:event_campo1MouseReleased
    
    
    
    private void campo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo1MouseExited
        
        if(turnonav!=1){
            
            campo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-registro-grey.png"))); // NOI18N

        }
        
    }//GEN-LAST:event_campo1MouseExited
    
    
        
    
        
    
        
    
        
    
        
    
        
    
    
    public Timer getCountdownTimer2() {
        
        return countdownTimer2;
        
    }
    
    
    
    public void setCountdownTimer2(Timer countdownTimer2) {
        
        this.countdownTimer2 = countdownTimer2;
        
    }
    
    public boolean isIngreso() {
        
        return ingreso;
        
    }
    
    
    
    public void setIngreso(boolean ingreso) {
        
        this.ingreso = ingreso;
        
    }
    
    
    
    public boolean isPendiente() {
        
        return pendiente;
        
    }
    
    
    
    public void setPendiente(boolean pendiente) {
        
        this.pendiente = pendiente;
        
    }
    
    
    
    private void campo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo5MouseClicked
        
        turnonav=5;
        
        naveprincipal(campo5);        
        ingreso=true;
        
        ingreso=false;
        
        cambiopanel(n1);
        
    }//GEN-LAST:event_campo5MouseClicked
    
    
    
    private void campo5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo5MouseEntered
        
        if(turnonav!=5){
            
            campo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-busquedA-blue.png"))); // NOI18N

            
        }
        
    }//GEN-LAST:event_campo5MouseEntered
    
    
    
    private void campo5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo5MouseExited
        
        if(turnonav!=5){
            
            campo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-busquedA-grey.png"))); // NOI18N

        }
        
    }//GEN-LAST:event_campo5MouseExited
    
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
     
    public void fondos(Document documento,PdfContentByte canvas){
        try {
            Image imghead = Image.getInstance("C:\\plantilla.jpg");
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
        } catch (IOException io) {
            
        } catch (DocumentException io) {
        }
    }
    private void campo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo4MouseClicked
        cambiopanel(n8);
        n8.refresh();
        
        turnonav=4;
        naveprincipal(campo4);
    }//GEN-LAST:event_campo4MouseClicked
    
    
            
    
    
    private void campo4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo4MouseEntered
        
        if(turnonav!=4){
            
            campo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-observaciones-blue.png"))); // NOI18N

        }
        
    }//GEN-LAST:event_campo4MouseEntered
    
    
    
    private void campo4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo4MouseExited
        
        if(turnonav!=4){
            
            campo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/pestana-observaciones-grey.png"))); // NOI18N

        }
        
    }//GEN-LAST:event_campo4MouseExited
    
    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        configuracion= !configuracion;
        getjLabel17().setVisible(configuracion);
        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/flecha-arriba-blue.png"))); // NOI18N
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/flecha-abajo-blue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered

        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/flecha-arriba-blue.png"))); // NOI18N
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/flecha-abajo-blue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited

        if(configuracion){
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/flecha-arriba-lightblue.png"))); // NOI18
        }else{
            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/flecha-abajo-lightblue.png"))); // NOI18N
        }
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/cerrar-sesion-boton-blue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/cerrar-sesion-boton-lightblue.png"))); // NOI18N
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked
    
    public registrosparcial getN5() {
        
        return n5;
        
    }
    
    
    
    public void setN5(registrosparcial n5) {
        
        this.n5 = n5;
        
    }
    
    public Timer getCountdownTimer() {
        
        return countdownTimer;
        
    }
    
    
    
    public void setCountdownTimer(Timer countdownTimer) {
        
        this.countdownTimer = countdownTimer;
        
    }
    
    
    
    public ServiceHb getService() {
        
        return service;
        
    }
    
    
    
    public void setService(ServiceHb service) {
        
        this.service = service;
        
    }
    
    public int getTimeRemaining() {
        
        return timeRemaining;
        
    }
    
    
    
    public void setTimeRemaining(int timeRemaining) {
        
        this.timeRemaining = timeRemaining;
        
    }
    
    public JLabel getjLabel12() {
        
        return campo5;
        
    }
    
    
    
    public void setjLabel12(JLabel jLabel12) {
        
        this.campo5 = jLabel12;
        
    }
    
    
    
    public JPanel getjPanel1() {
        
        return jPanel1;
        
    }
    
    
    
    public void setjPanel1(JPanel jPanel1) {
        
        this.jPanel1 = jPanel1;
        
    }
    
    
    
    public JLabel getjLabel10() {
        
        return campo1;
        
    }
    
    
    
    public void setjLabel10(JLabel jLabel10) {
        
        this.campo1 = jLabel10;
        
    }
    
    private void tblEjemploMouseClicked3(java.awt.event.MouseEvent evt) throws Exception {
        
        String cadena="";
        Usuario us1 = new Usuario();        
        List<Registros> list=null;
        
        String selectedSiteName;
        
        ServiceHb serviceclick2 = new ServiceHb();
        
        serviceclick2.iniciarTransaccion();
        
        Registros rg1= (Registros)serviceclick2.obtenerObjeto(Registros.class,(Integer) n5.getjTable1().getModel().getValueAt(n5.getjTable1().getSelectedRow(), 1));
        
        if(n5.getjTable1().getSelectedColumn()==8){
            
            selectedSiteName = JOptionPane.showInputDialog(null,"Observacion: " +rg1.getObservacion());
            
            if(selectedSiteName != null){
                
                rg1.getUsuario().setObservacion(selectedSiteName);
                
                rg1.setObservacion(rg1.getObservacion()+" "+selectedSiteName);
                
            }
            
        }
        
        if(n5.getjTable1().getSelectedColumn()==7){
            selectedSiteName = JOptionPane.showInputDialog(null,"Material: " +rg1.getUsuario().getMaterial());
            if(selectedSiteName != null){
                rg1.getUsuario().setMaterial(rg1.getUsuario().getMaterial()+" "+selectedSiteName);
            }
        }
        
        serviceclick2.actualizarObjeto(rg1);
        serviceclick2.confirmarTransaccion();
        serviceclick2.cerrarSesion();
        
        new Thread(new Cargando(1)).start();
        actual=true;
        
        new Thread(new Cargando(5)).start();
        
        ServiceHb serviceact = new ServiceHb();
        
        serviceact.iniciarTransaccion();
        
        serviceact.actualizarObjeto(rg1);
        
        serviceact.confirmarTransaccion();
        
        serviceact.cerrarSesion();
        
    }
    
    /**
     * 
     * @param args the command line arguments
     * 
     */
    
    

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }
    
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
            
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        }
        
        //</editor-fold>
        
        
        
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            
            public void run() {
                try {           
                    new Cuadro(null,"","","").setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(Cuadro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campo1;
    private javax.swing.JLabel campo4;
    private javax.swing.JLabel campo5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}
class ButtonRenderer extends JButton implements TableCellRenderer {
    
    
    
    public ButtonRenderer() {
        
        setOpaque(true);
        
    }
    
    
    
    @Override
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (isSelected) {
            
            setForeground(table.getSelectionForeground());
            
            setBackground(table.getSelectionBackground());
            
        } else {
            
            setForeground(table.getForeground());
            
            setBackground(UIManager.getColor("Button.background"));
            
        }
        
        setText((value == null) ? "" : "X");
        
        return this;
        
    }
    
}



class ButtonEditor extends DefaultCellEditor {
    
    protected JButton button;
    
    
    
    private String label;
    
    
    
    private boolean isPushed;
    
    
    
    public ButtonEditor(JCheckBox checkBox) {
        
        super(checkBox);
        
        button = new JButton();
        
        button.setOpaque(true);
        
        button.addActionListener(new ActionListener() {
            
            @Override
            
            public void actionPerformed(ActionEvent e) {
                
                fireEditingStopped();
                
            }
            
        });
        
    }
    
    
    
    @Override
    
    public Component getTableCellEditorComponent(JTable table, Object value,
            
            boolean isSelected, int row, int column) {
        
        if (isSelected) {
            
            button.setForeground(table.getSelectionForeground());
            
            button.setBackground(table.getSelectionBackground());
            
        } else {
            
            button.setForeground(table.getForeground());
            
            button.setBackground(table.getBackground());
            
        }
        
        label = (value == null) ? "" : value.toString();
        
        button.setText(label);
        
        isPushed = true;
        
        return button;
        
    }
    
    
    
    @Override
    
    public Object getCellEditorValue() {
        
        if (isPushed) {
            JOptionPane.showMessageDialog(button, label + ": Ouch!");            
        }
        
        isPushed = false;
        
        return label;
        
    }
    
    
    
    @Override
    
    public boolean stopCellEditing() {
        
        isPushed = false;
        
        return stopCellEditing();
        
    }
    
    
    
    @Override
    
    protected void fireEditingStopped() {
        
        fireEditingStopped();
        
    }
    
}