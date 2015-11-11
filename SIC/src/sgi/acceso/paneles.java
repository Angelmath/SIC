package sgi.acceso;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
import javax.swing.table.TableColumn;
import javax.xml.bind.DatatypeConverter;
import sgi.servicio.Funcion;
import sgi.servicio.ServiceHb;
import sgi.tablas.Acreditacion;
import sgi.tablas.Foto;
import sgi.tablas.Indexpatrulla;
import sgi.tablas.Observacion;
import sgi.tablas.Registros;
import sgi.tablas.Usuario;
import sgi.tablas.Login;
import sgi.tablas.RPall;
import sgi.tablas.Revpavitem;

/**
 * 
 *
 * 
 * @author Angelmath
 * 
 */

public final class paneles extends javax.swing.JFrame {
    busqueda busqueda;
    ingresos ingresos;
    Thread hilo2;
    Calendar dataa;
    egreso egreso;
    registrosparcial parcial;
    registros registros;
    Reloj hora2;
    observa observa;
    patrulla patrulla;
    Login moni1=null;
    Thread h1;
    String hora,minutos,segundos,ampm;
    Calendar calendario;
    Thread hilo;
    Timer countdownTimer;
    int ingresotipo=0;
    Timer countdownTimer2;
    Timer countdownTimer3;
    Timer countdownTimer4;
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
    Login mn1=null;
    String responsable="";
    boolean llenartabla=false;
    String direccion="";
    Login mn2;
    Login mn3;
    int x=0;
    int y=0;
    Calendar calendaini;
    Calendar calendafin;
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
     * @param direccion
     * @param mn2
     * @param mn3
     * @throws java.awt.FontFormatException
     * @throws com.itextpdf.text.DocumentException
     */
    @SuppressWarnings({"CallToThreadStartDuringObjectConstruction", "LeakingThisInConstructor"})
    
    public paneles(Login mn1,String localidad,String base,String direccion,Login mn2,Login mn3) throws FontFormatException, DocumentException {
        this.direccion= direccion;
        d = Toolkit.getDefaultToolkit().getScreenSize();
        responsable="";
        initComponents();
        diseñosmarco();
        dispose();
        
        setUndecorated(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(true);
        
        setLocationRelativeTo(null);
        
        //tablas();
        
        //eventos();
        
        Hora hora1 = new Hora();
        hora2 = new Reloj();
        //new Thread(new Cargando(1)).start();
        
        JLabel jLabel4 = new JLabel();
        jLabel4.setSize(d.width-60, d.height-60);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/fondo.jpg"))); // NOI18N
        jLabel4.setIcon(new ImageIcon(((ImageIcon) jLabel4.getIcon()).getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), java.awt.Image.SCALE_DEFAULT)));
        add(jLabel4);
        
        setVisible(true);
        
    }
    
    
    public void eventos(){
        
        setEventoMouseClicked(registros.getjTable1());
        
        setEventoMouseClicked3(parcial.getjTable1());
        
        setEventoMouseClicked2(egreso.getjTable1());
        
        setEventoKeyboard4(egreso.getjTextField1());
        
        setEventoKeyboard4(egreso.getjTextField2());
        
        setEventoKeyboard4(egreso.getjTextField3());
        
        setEventoKeyboard4(egreso.getjTextField4());
        
        setEventoMouseClicked5(ingresos.getjLabel4());
        
        setEventoMouseClicked6(busqueda.getjButton1());
        
    }
    
    public class Reloj implements Runnable{
        
        public Reloj() {
            hilo2 = new Thread(this);
            hilo2.start();
        }
        
        
        @Override
        public void run() {
            Calendar inti = Calendar.getInstance();
            inti.set(inti.get(Calendar.YEAR),inti.get(Calendar.MONTH),inti.get(Calendar.DAY_OF_MONTH),8,10,0);
            Calendar fiti = Calendar.getInstance();
            fiti.set(fiti.get(Calendar.YEAR),fiti.get(Calendar.MONTH),fiti.get(Calendar.DAY_OF_MONTH),20,10,0);
            try {
                Thread ct = Thread.currentThread();

                while(ct == hilo2) {
                    dataa = Calendar.getInstance();
                    int h= dataa.get(Calendar.HOUR_OF_DAY);
                    int m= dataa.get(Calendar.MINUTE);
                    int s= dataa.get(Calendar.SECOND);
                    
                    jLabel3.setText(Funcion.DateTimeToString4(dataa.getTime()));
                    if(h==20||h==8){
                        if(m==10&&s==0){
                            genenerarRoporte();
                        }
                    }
                    Thread.sleep(1000);
                }
            }catch(DocumentException | InterruptedException e) {}
            
        }
        
    }
    
    
    public void diseñosmarco(){
        
        setSize(d.width-60, d.height-60);
        jLabel3.setLocation(((d.width-60)/2) - (jLabel3.getWidth()/2), jLabel3.getY());
        jLabel1.setSize(d.width-60, jLabel1.getHeight());
        jLabel15.setLocation(((d.width-60)) - (jLabel15.getWidth()), jLabel15.getY());
        jLabel15.setText(/*moni1.getNombre()*/"");
        jLabel17.setLocation(((d.width-60)) - (jLabel17.getWidth()), jLabel17.getY());
        nav.setSize(160, d.height-60);
        panel_busqueda1.setSize((d.width-220)/2, ((d.height-60)-(jLabel1.getHeight()))/2);
        panel_diseño1.setSize((d.width-220)/2, ((d.height-60)-(jLabel1.getHeight()))/2);
        panel_guardia1.setSize((d.width-220)/2, ((d.height-60)-(jLabel1.getHeight()))/2);
        panel_rrhh1.setSize((d.width-220)/2, ((d.height-60)-(jLabel1.getHeight()))/2);
        panel_guardia1.setLocation((d.width-60)-panel_guardia1.getWidth()*2,(d.height-60)-panel_guardia1.getHeight()*2);
        panel_rrhh1.setLocation((d.width-60)-panel_guardia1.getWidth()*2, (d.height-60)-panel_guardia1.getHeight());
        panel_diseño1.setLocation((d.width-60)-panel_guardia1.getWidth(), (d.height-60)-panel_guardia1.getHeight()*2);
        panel_busqueda1.setLocation((d.width-60)-panel_guardia1.getWidth(), (d.height-60)-panel_guardia1.getHeight());  
        
    }
    
    
    
    @Override
    
    public java.awt.Image getIconImage() {
        
        java.awt.Image retValue = Toolkit.getDefaultToolkit().
                
                getImage(ClassLoader.getSystemResource("imagenes/icon-caja.png"));
        
        return retValue;
        
    }
    
    private void setEventoMouseClicked(JTable tbl)
            
    {
        
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            
            
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                try {
                    
                    tblEjemploMouseClicked(e);
                    
                } catch (Exception ex) {
                    
                    Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        });
        
    }
    
    protected int compare(int i, int j) {
        
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        
        return s1.compareTo(s2);
        
    }
    
    public void naveprincipal(JLabel lb){
        
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
        
        tablasmodelos(observa.getjTable1(),observa);
        
        observa.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        observa.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        observa.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        observa.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        observa.getjTable1().getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        observa.getjTable1().getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        tablasmodelos(patrulla.getjTable1(),patrulla);
        
        patrulla.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        patrulla.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        patrulla.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        patrulla.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        patrulla.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        patrulla.getjTable1().getColumn("VER").setCellRenderer(new ButtonRenderer());
        patrulla.getjTable1().getColumn("Ver Diseño").setCellRenderer(new ButtonRenderer());
        
        tablasmodelos(patrulla.getjTable2(),patrulla);
        
        patrulla.getjScrollPane2().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        patrulla.getjTable2().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        patrulla.getjTable2().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        patrulla.getjTable2().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        patrulla.getjTable2().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        
        patrulla.getjTable2().getColumn("VER").setCellRenderer(new ButtonRenderer());
        patrulla.getjTable2().getColumn("VER").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        
        tablasmodelos(busqueda.getjTable1(),busqueda);
        
        busqueda.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        busqueda.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(11).setCellRenderer( new CellRenderer("text center") );
        
        busqueda.getjTable1().getColumnModel().getColumn(12).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(egreso.getjTable1(),egreso);
        
        egreso.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        egreso.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("text center") );
        
        egreso.getjTable1().getColumnModel().getColumn(11).setCellRenderer( new CellRenderer("text center") );
        
        
        
        tablasmodelos(parcial.getjTable1(),parcial);
        
        parcial.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        parcial.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(11).setCellRenderer( new CellRenderer("text center") );
        
        parcial.getjTable1().getColumnModel().getColumn(12).setCellRenderer( new CellRenderer("text center") );
        
        tablasmodelos(registros.getjTable1(),registros);
        
        registros.getjScrollPane1().getVerticalScrollBar().setUI(new MyScrollbarUI());
        
        registros.getjTable1().getColumnModel().getColumn(0).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(1).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(2).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(3).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(4).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(5).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(6).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(7).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(8).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(9).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(10).setCellRenderer( new CellRenderer("text center") );
        
        registros.getjTable1().getColumnModel().getColumn(11).setCellRenderer( new CellRenderer("text center") );
        
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
        
        return busqueda;
        
    }
    
    public void setN1(busqueda n1) {
        
        this.busqueda = n1;
        
    }
    
    public registros getN7() {
        
        return registros;
        
    }
    
    
    
    public void setN7(registros n7) {
        
        this.registros = n7;
        
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
                    
                    Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        });
        
    }
    
    
    
    private void setEventoMouseClicked2(JTable tbl)
            
    {
        
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            
            public void mouseClicked(MouseEvent e) {
                
                try {
                    
                    tblEjemploMouseClicked2(e);
                    
                } catch (Exception ex) {
                    
                    Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                    
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
                    
                    Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                    
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
                    
                    Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        });
        
    }
    
    void setEventoMouseingreso2()
    {
        if(turnonav==2){
            ingresotipo=1;
            cambiopanel(egreso);
            new Thread(new Cargando(2)).start();
        }
        
        if(turnonav==3){
            
            ingresotipo=2;
            
            cambiopanel(egreso);
            
            new Thread(new Cargando(2)).start();
            
        }
       
        turnonav2=2;
        
    }
    
    void setEventoMouseingreso3()
            
    {
                    
        if(turnonav==2){
            
            ingresotipo=1;
            
            new Thread(new Cargando(3)).start();
            
            cambiopanel(registros);
            
        }
        
        if(turnonav==3){
            
            ingresotipo=2;
            
            new Thread(new Cargando(3)).start();
            
            cambiopanel(registros);
            
        }
        
        turnonav2=3;    
        
    }
    
    void setEventoMouseingreso4()
            
    {    
        cambiopanel(observa);
        observa.refresh();
        
    }
    
    void setEventoMouseingreso5()
            
    {
        cambiopanel(patrulla);
        patrulla.llenar();
    }
    
    void setEventoMouseingreso1()
            
    {
        
    if(turnonav==2){
            
            ingresotipo=1;
            
            tipoingreso(ingresotipo);
            
            ingresos.getjLabel5().setVisible(false);
            
            ingresos.getjTextField1().setVisible(false);
            
            vaciaringresos("USUARIO");
            
        }
        
        if(turnonav==3){
            
            ingresotipo=2;
            
            tipoingreso(ingresotipo);
            
            ingresos.getjLabel5().setVisible(true);
            
            ingresos.getjTextField1().setVisible(true);
            
            vaciaringresos("VEHICULO");
            
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
                    
                    CountdownTimerListener4sin();
                    
                }
                
                if(x==3){
                    
                    CountdownTimerListenersin();
                    
                }
                
                if(x==4){
                    
                    busqueda();
                    
                }
                
                if(x==5){
                    if(actual && actualizar){
                        actualizaroff();
                        actual=false;
                    }
                    
                }
                if(x==6){
                    try{
                        genenerarRoporte();
                    }catch(Exception io){}
                }
                if(x==7){
                    try{
                        genenerarRoporte2();
                    }catch(Exception io){}
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public class Hora implements Runnable{
        
        
        
        public Hora() {
            hilo = new Thread(this);
            hilo.start();
        }
        
        public void calcula () {
            Calendar calendario = new GregorianCalendar();
            Date fechaHoraActual = new Date();
            calendario.setTime(fechaHoraActual);
            ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
            if(ampm.equals("PM")){
                int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
                hora = h>9?""+h:"0"+h;
            }else{
                hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
            }
            minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
        }
        
        public void visi(){
            
            
            
        }
        
        @Override
        public void run() {
            
            Thread ct = Thread.currentThread();
            int inicio1;
            int inicio2;
            int inicio3;
            Calendar dat = Calendar.getInstance();
            int fin1;
            int fin2;
            
            int fin3;
            
            Calendar dat2 = Calendar.getInstance();
            
            Calendar dif=Calendar.getInstance();
            
            while(ct == hilo) {
                
                calcula();
                
                visi();
                
                dif.setTimeInMillis(dat2.getTimeInMillis()-dat.getTimeInMillis());
                
//                patrulla.getjLabel2().setText(dif.get(Calendar.HOUR)-7+" H :"+dif.get(Calendar.MINUTE)+" M :"+dif.get(Calendar.SECOND)+" S");
                
                    observa.getjLabel2().setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e) {}
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
                    Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);   
                }   
            } 
        });    
    }
    
    public void busqueda(){
        ServiceHb helper=null;
        int temporal=0;
        List<Registros> list;
        DefaultTableModel temp2 = (DefaultTableModel) busqueda.getjTable1().getModel();
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            temp2.removeRow(i);   
        }
        try{
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            if((busqueda.getjDateChooser1().getDate()!=null)&&(busqueda.getjDateChooser2().getDate()!=null)){
                list = helper.getRegistrosBusqueda2(busqueda.getjTextField2().getText(),busqueda.getjTextField3().getText(),busqueda.getjTextField4().getText(),busqueda.getjTextField6().getText(),busqueda.getjDateChooser1().getDate(),busqueda.getjDateChooser2().getDate());
            }else{
                list = helper.getRegistrosBusqueda(busqueda.getjTextField2().getText(),busqueda.getjTextField3().getText(),busqueda.getjTextField4().getText(),busqueda.getjTextField6().getText());
            }
            llenartabla=true;
            int temp=0;
            DefaultTableModel tempo = (DefaultTableModel) busqueda.getjTable1().getModel();
            list.stream().filter((i) -> (llenartabla)).map((i) -> {
                busqueda.getjLabel6().setText((temp+1)+"/"+list.size());
                String campoo0= Integer.toString(i.getId());
                String campoo4="";
                if(i.getUsuario().getVehiculo()==null){
                }else{
                    campoo4=i.getUsuario().getVehiculo().getPlaca();
                }
                String campoo1=i.getLocalidad();
                String campoo2=i.getLogin();
                String campoo3=i.getTipo();
                String campoo5=i.getUsuario().getCi();
                String campoo6=i.getUsuario().getNombre();
                String campoo7=i.getUsuario().getApellido();
                String campoo11="";
                String campoo12=i.getExtra();
                String campoo13=i.getAcreditacion();
                if(i.getFinTiempo()==null){
                    
                }else{
                    campoo11=Funcion.DateTimeFormatJS(i.getFinTiempo());
                }
                String campoo10=Funcion.DateTimeFormatJS(i.getInicioTiempo());
                Object nuevo[]= {campoo0,campoo1,campoo2,campoo3,campoo4,campoo5,campoo6,campoo7,"","",campoo10,campoo11,campoo13,campoo12};
                return nuevo;
            }).forEach((nuevo) -> {
                tempo.addRow(nuevo);
            });
            helper.cerrarSesion();
            
        } catch (Exception ex) {
            
            Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public void CountdownTimerListener3 (){
        
    }
    
    class CountdownTimerListener implements ActionListener {
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            
            
            
            DefaultTableModel temp2 = (DefaultTableModel) registros.getjTable1().getModel();
            
            for(int i=temp2.getRowCount()-1;i>=0;i--){
                
                temp2.removeRow(i);
                
            }
            
            List<Registros> list;
            
            try {
                
                ServiceHb servicelstreg = new ServiceHb();
                
                servicelstreg.iniciarTransaccion();
                
                if(ingresotipo==1){
                    
                    list = servicelstreg.getRegistros2();
                    
                }
                
                else{
                    
                    list = servicelstreg.getRegistros3();
                    
                    for(int i=list.size()-1; i>=0; i--){
                        
                        if(list.get(i).getUsuario().getVehiculo()==null){
                            
                            list.remove(i);
                            
                        }
                        
                    }
                    
                }
                
                servicelstreg.confirmarTransaccion();
                
                servicelstreg.cerrarSesion();
                
                if(list!=null){
                    
                    if(registros.getjTable1().getColumnCount()==9){
                        
                        registros.getjTable1().addColumn(new TableColumn(2));
                        
                        registros.getjTable1().moveColumn(9, 2);
                        
                    }
                    
                    for(int i=0; i<list.size();i++){
                        
                        if(registros.getjTable1().getRowCount()< list.size()){
                            
                            DefaultTableModel temp = (DefaultTableModel) registros.getjTable1().getModel();
                            
                            Object nuevo[]= {temp.getRowCount()+1,"",""};
                            
                            temp.addRow(nuevo);
                            
                        }
                        
                        
                        
                        if(list.get(i).getFinTiempo()==null){
                            
                            registros.getjTable1().getModel().setValueAt("", i, 9);
                            
                        }else{
                            
                            registros.getjTable1().getModel().setValueAt(Funcion.DateTimeFormatJS(list.get(i).getFinTiempo()), i, 9);
                            
                        }
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getId(), i, 1);
                        
                        if(list.get(i).getUsuario().getVehiculo()==null){
                            
                            registros.getjTable1().getModel().setValueAt("", i, 2);
                            
                        }else{
                            
                            registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getVehiculo().getPlaca(), i, 2);
                            
                        }
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getCi(), i, 3);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getNombre(), i,4);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getApellido(), i, 5);
                        
                        registros.getjTable1().getModel().setValueAt("", i, 6);
                        
                        registros.getjTable1().getModel().setValueAt("", i, 7);
                        
                        registros.getjTable1().getModel().setValueAt(i+1, i, 0);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getAcreditacion(), i, 10);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getExtra(), i, 11);
                        
                        if(list.get(i).getFinTiempo()==null){
                            
                            registros.getjTable1().getModel().setValueAt("", i, 8);
                            
                        }else{
                            
                            registros.getjTable1().getModel().setValueAt(Funcion.DateTimeFormatJS(list.get(i).getInicioTiempo()), i, 8);
                            
                        }
                        
                    }
                    
                }
                
                servicelstreg.cerrarSesion();
                
            } catch (Exception ex) {
                
                Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            
            
        }
        
    }
    
    
    
    public void CountdownTimerListenersin() {
        
        
        
        DefaultTableModel temp2 = (DefaultTableModel) registros.getjTable1().getModel();
        
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            
            temp2.removeRow(i);
            
        }
        
        try {
            
            ServiceHb serviceregis2 = new ServiceHb();
            
            serviceregis2.iniciarTransaccion();
            
            List<Registros> list;
            
            if(ingresotipo==1){
                list = serviceregis2.getRegistroslimite3();
                llenartabla=true;
            }
            
            else{
                list = serviceregis2.getRegistroslimite2();
                llenartabla=true;
            }
            
            if(list!=null){
                
                if(registros.getjTable1().getColumnCount()==9){
                    
                    registros.getjTable1().addColumn(new TableColumn(2));
                    
                    registros.getjTable1().moveColumn(9, 2);
                    
                }
                
                for(int i=0; i<list.size();i++){
                    
                    if(llenartabla){
                        if(registros.getjTable1().getRowCount()< list.size()){
                            DefaultTableModel temp = (DefaultTableModel) registros.getjTable1().getModel();
                            Object nuevo[]= {temp.getRowCount()+1,"",""};
                            temp.addRow(nuevo);
                        }
                        if(list.get(i).getFinTiempo()==null){
                            registros.getjTable1().getModel().setValueAt("", i, 9);
                        }else{
                            registros.getjTable1().getModel().setValueAt(Funcion.DateTimeFormatJS(list.get(i).getFinTiempo()), i, 9);
                        }
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getId(), i, 1);
                        
                        if(list.get(i).getUsuario().getVehiculo()==null){
                            
                            registros.getjTable1().getModel().setValueAt("", i, 2);
                            
                        }else{
                            
                            registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getVehiculo().getPlaca(), i, 2);
                            
                        }
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getCi(), i, 3);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getNombre(), i,4);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getUsuario().getApellido(), i, 5);
                        
                        registros.getjTable1().getModel().setValueAt("", i, 6);
                        
                        registros.getjTable1().getModel().setValueAt("", i, 7);
                        
                        registros.getjTable1().getModel().setValueAt(i+1, i, 0);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getAcreditacion(), i, 10);
                        
                        registros.getjTable1().getModel().setValueAt(list.get(i).getExtra(), i, 11);
                        
                        if(list.get(i).getInicioTiempo()==null){
                            
                            registros.getjTable1().getModel().setValueAt("", i, 8);
                            
                        }else{
                            
                            registros.getjTable1().getModel().setValueAt(Funcion.DateTimeFormatJS(list.get(i).getInicioTiempo()), i, 8);
                            
                        }
                    }
                }
                
                
                
            }
            
            serviceregis2.cerrarSesion();
            
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
    }
    
    
    
    class CountdownTimerListener4 implements ActionListener {
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            
            
            
            DefaultTableModel temp2a = (DefaultTableModel) egreso.getjTable1().getModel();
            
            for(int i=temp2a.getRowCount()-1;i>=0;i--){
                temp2a.removeRow(i);   
            }
            try {
                ServiceHb serviceregis3 = new ServiceHb();
                serviceregis3.iniciarTransaccion();
                List<Registros> list2;
                if(ingresotipo==1){
                    list2 = serviceregis3.getRegistros7();
                    for(int i=list2.size()-1; i>=0; i--){
                        if(list2.get(i).getUsuario().getVehiculo()!=null){
                            list2.remove(i);   
                        }   
                    }   
                }else{
                    list2 = serviceregis3.getRegistros8();
                    for(int i=list2.size()-1; i>=0; i--){
                        if(list2.get(i).getUsuario().getVehiculo()==null){
                            list2.remove(i);   
                        }   
                    }   
                }
                if(list2!=null){
                    list2.stream().forEach((list21) -> {
                        if(egreso.getjTable1().getRowCount()< list2.size()){
                            DefaultTableModel temp = (DefaultTableModel) egreso.getjTable1().getModel();
                            Object nuevo[]= {temp.getRowCount()+1,"",""};
                            temp.addRow(nuevo);    
                        }
                        int val0;
                        int val1;
                        String val2="";
                        String val8="";
                        String val10="";
                        String val11="";
                        String val9="";
                        egreso.getjTable1().getColumn("Accion").setCellRenderer(new ButtonRenderer());
                        egreso.getjTable1().getColumn("Accion").setCellEditor(new ButtonEditor(new JCheckBox()));
                        if (list21.getFinTiempo() == null) {
                        } else {
                            val9 = Funcion.DateTimeFormatJS(list21.getFinTiempo());
                        }
                        val1 = list21.getId();
                        if (list21.getUsuario().getVehiculo() == null) {
                        } else {
                            val2 = list21.getUsuario().getVehiculo().getPlaca();
                        }
                        String val3 = list21.getUsuario().getCi();
                        String val4 = list21.getUsuario().getNombre();
                        String val5 = list21.getUsuario().getApellido();
                        String val6 = "";
                        String val7 = "";
                        if (list21.getInicioTiempo() == null) {
                        } else {
                            val8 = Funcion.DateTimeFormatJS(list21.getInicioTiempo());
                        }
                        val0=1+1;
                        val11 = list21.getAcreditacion();
                        DefaultTableModel temp = (DefaultTableModel) egreso.getjTable1().getModel();
                        Object nuevo[]= {val0,val1,val2,val3,val4,val5,val6,val7,val8,val9,val10};
                        temp.addRow(nuevo);
                    });
                    
                    
                    
                    egreso.getjTable1().removeColumn(egreso.getjTable1().getColumn("Placa"));
                    
                    
                    
                }
                
                serviceregis3.cerrarSesion();
                
            } catch (Exception ex) {
                
                Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            
            
        }
        
    }
    
    
    
    public void CountdownTimerListener4sin() {
        
        DefaultTableModel temp2a = (DefaultTableModel) egreso.getjTable1().getModel();
        
        for(int i=temp2a.getRowCount()-1;i>=0;i--){
            temp2a.removeRow(i);
        }
        
        try {
            
            ServiceHb registrosact = new ServiceHb();
            
            registrosact.iniciarTransaccion();
            
            List<Registros> list2;
            
            if(ingresotipo==1){
                
                list2 = registrosact.getRegistros5(egreso.getjTextField4().getText(),egreso.getjTextField3().getText(),egreso.getjTextField1().getText(),egreso.getjTextField2().getText());
                
            }
            
            else{
                
                list2 = registrosact.getRegistros6(egreso.getjTextField4().getText(),egreso.getjTextField3().getText(),egreso.getjTextField1().getText(),egreso.getjTextField2().getText());
                
            }
            llenartabla=true;
            if(list2!=null){
                
                for(int i=0; i<list2.size();i++){
                    
                    if(llenartabla){
                        egreso.getjTable1().getColumn("Accion").setCellRenderer(new ButtonRenderer());
                        
                        egreso.getjTable1().getColumn("Accion").setCellEditor(new ButtonEditor(new JCheckBox()));
                        
                        String campoo9="";
                        
                        if(list2.get(i).getFinTiempo()==null){
                            
                        }else{
                            
                            campoo9=Funcion.DateTimeFormatJS(list2.get(i).getFinTiempo());
                            
                        }
                        
                        int campoo1=list2.get(i).getId();
                        
                        String campoo2="";
                        
                        if(list2.get(i).getUsuario().getVehiculo()==null){
                            
                        }else{
                            
                            campoo2=list2.get(i).getUsuario().getVehiculo().getPlaca();
                            
                        }
                        
                        
                        
                        String campoo3=list2.get(i).getUsuario().getCi();
                        
                        String campoo4=list2.get(i).getUsuario().getNombre();
                        
                        String campoo5=list2.get(i).getUsuario().getApellido();
                        
                        String campoo6="";
                        
                        String campoo7="";
                        
                        String campoo8="";
                        
                        String campoo10=list2.get(i).getAcreditacion();
                        
                        String campoo12=list2.get(i).getExtra();
                        
                        if(list2.get(i).getInicioTiempo()==null){
                            
                        }else{
                            
                            campoo8=Funcion.DateTimeFormatJS(list2.get(i).getInicioTiempo());
                            
                        }
                        
                        int campoo0=i+1;
                        
                        String campoo11=list2.get(i).getAcreditacion();
                        
                        DefaultTableModel temp = (DefaultTableModel) egreso.getjTable1().getModel();
                        
                        Object nuevo[]= {campoo0,campoo1,campoo2,campoo3,campoo4,campoo5,campoo6,campoo7,campoo8,campoo9,campoo10,campoo11,campoo12};
                        
                        temp.addRow(nuevo);
                    }
                }
                
            }
            registrosact.cerrarSesion();
            
        } catch (Exception ex) {
            
            Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
    }
    
    
    
    class CountdownTimerListener2 implements ActionListener {
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            
            
            
            DefaultTableModel temp2 = (DefaultTableModel) parcial.getjTable1().getModel();
            
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
                        
                        String val2;
                        
                        String val3="";
                        String val9="";
                        
                        if(list.get(i).getFinTiempo()==null){
                            
                        }else{
                            
                            val9=Funcion.DateTimeFormatJS(list.get(i).getFinTiempo());
                            
                        }
                        
                        val1=list.get(i).getId();
                        
                        if(list.get(i).getUsuario().getVehiculo()==null){
                            
                        }else{
                            
                            val3=list.get(i).getUsuario().getVehiculo().getPlaca();
                            
                        }
                        
                        val2=list.get(i).getTipo();
                        
                        String val4=list.get(i).getUsuario().getCi();
                        
                        String val5=list.get(i).getUsuario().getNombre();
                        
                        String val6=list.get(i).getUsuario().getApellido();
                        
                        String val7="";
                        
                        String val10=list.get(i).getAcreditacion();
                        
                        String val11=list.get(i).getExtra();
                        
                        val0=i+1;
                        
                        String val8=Funcion.DateTimeFormatJS(list.get(i).getInicioTiempo());
                        
                        DefaultTableModel temp = (DefaultTableModel) parcial.getjTable1().getModel();
                        
                        Object nuevo[]= {val0,val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11};
                        
                        temp.addRow(nuevo);
                        
                    }
                    
                    
                    
                }
                servicereg.cerrarSesion();
                
            } catch (Exception ex) {
                
                Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
    }
    
    
    
    private void CountdownTimerListener2sin() {
        
        DefaultTableModel temp2 = (DefaultTableModel) parcial.getjTable1().getModel();
        
        for(int i=temp2.getRowCount()-1;i>=0;i--){
            
            temp2.removeRow(i);
            
        }
        
        try {
            
            ServiceHb helper = new ServiceHb();
            
            helper.iniciarTransaccion();
            
            List<Registros> list = helper.getRegistroslimite();
            llenartabla=true;
            if(list!=null){
                
                for(int i=0; i<list.size();i++){
                    if(llenartabla){
                        int val0;
                        int val1;
                        String val2;
                        String val3="";
                        String val10="";
                        if(list.get(i).getFinTiempo()==null){
                        }else{
                            val10=Funcion.DateTimeFormatJS(list.get(i).getFinTiempo());
                        }
                        
                        val1=list.get(i).getId();
                        
                        if(list.get(i).getUsuario().getVehiculo()==null){
                            
                        }else{
                            
                            val3=list.get(i).getUsuario().getVehiculo().getPlaca();
                            
                        }
                        
                        val2=list.get(i).getTipo();
                        
                        String val4=list.get(i).getUsuario().getCi();
                        
                        String val5=list.get(i).getUsuario().getNombre();
                        
                        String val6=list.get(i).getUsuario().getApellido();
                        
                        String val7="";
                        
                        String val8="";
                        
                        String val11=list.get(i).getAcreditacion();
                        
                        val0=i+1;
                        
                        String val9=Funcion.DateTimeFormatJS(list.get(i).getInicioTiempo());
                        
                        String val12=list.get(i).getExtra();
                        
                        DefaultTableModel temp = (DefaultTableModel) parcial.getjTable1().getModel();
                        
                        Object nuevo[]= {val0,val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11,val12};
                        
                        temp.addRow(nuevo);
                    }
                }
                
            }
            helper.cerrarSesion();
            
        } catch (Exception ex) {
            
            Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
            
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nav = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel_busqueda1 = new sgi.acceso.panel_busqueda();
        panel_guardia1 = new sgi.acceso.panel_guardia();
        panel_rrhh1 = new sgi.acceso.panel_rrhh();
        panel_diseño1 = new sgi.acceso.panel_diseño();

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/titulo-bitacora.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 340, 60);

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 0, 230, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/barra.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 60);

        nav.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nav.setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nav.add(jComboBox1);
        jComboBox1.setBounds(0, 20, 160, 40);

        jButton1.setText("jButton1");
        nav.add(jButton1);
        jButton1.setBounds(0, 530, 160, 40);

        jButton2.setText("jButton1");
        nav.add(jButton2);
        jButton2.setBounds(0, 480, 160, 40);

        getContentPane().add(nav);
        nav.setBounds(0, 60, 190, 590);

        panel_busqueda1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel_busqueda1Layout = new javax.swing.GroupLayout(panel_busqueda1);
        panel_busqueda1.setLayout(panel_busqueda1Layout);
        panel_busqueda1Layout.setHorizontalGroup(
            panel_busqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        panel_busqueda1Layout.setVerticalGroup(
            panel_busqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        getContentPane().add(panel_busqueda1);
        panel_busqueda1.setBounds(560, 320, 370, 260);

        panel_guardia1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel_guardia1Layout = new javax.swing.GroupLayout(panel_guardia1);
        panel_guardia1.setLayout(panel_guardia1Layout);
        panel_guardia1Layout.setHorizontalGroup(
            panel_guardia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        panel_guardia1Layout.setVerticalGroup(
            panel_guardia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        getContentPane().add(panel_guardia1);
        panel_guardia1.setBounds(190, 60, 370, 260);

        panel_rrhh1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel_rrhh1Layout = new javax.swing.GroupLayout(panel_rrhh1);
        panel_rrhh1.setLayout(panel_rrhh1Layout);
        panel_rrhh1Layout.setHorizontalGroup(
            panel_rrhh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        panel_rrhh1Layout.setVerticalGroup(
            panel_rrhh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        getContentPane().add(panel_rrhh1);
        panel_rrhh1.setBounds(190, 320, 370, 260);

        panel_diseño1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel_diseño1Layout = new javax.swing.GroupLayout(panel_diseño1);
        panel_diseño1.setLayout(panel_diseño1Layout);
        panel_diseño1Layout.setHorizontalGroup(
            panel_diseño1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        panel_diseño1Layout.setVerticalGroup(
            panel_diseño1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        getContentPane().add(panel_diseño1);
        panel_diseño1.setBounds(560, 60, 370, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
        
    
    
    
    
    
    
    
        
    
    
    public void vaciaringresos(String nuevo){
        ingresos.vaciar();
    }
    
    public void cambiopanel(JPanel pane){
        
        busqueda.setVisible(false);
        ingresos.setVisible(false);
        registros.setVisible(false);
        parcial.setVisible(false);
        egreso.setVisible(false);
        observa.setVisible(false);        
        patrulla.setVisible(false);
        pane.setVisible(true);
        
    }
    
    private void tipoingreso(int tipo){
        
        List<Acreditacion> list=null;
        ingresos.getjComboBox1().removeAllItems();
        try {
            ServiceHb helper = new ServiceHb();
            helper.iniciarTransaccion();
            list = helper.getAcreditaciones();
            helper.cerrarSesion();
            if(tipo==3){
                ingresos.getjTextField1().setVisible(false);   
            }else{
                ingresos.getjTextField1().setVisible(true);
            }
            if(list!=null){
                for (Acreditacion list1 : list) {
                    ingresos.getjComboBox1().addItem(list1.getNombre());
                }
            }
        } catch (Exception ex) {
            
        }
        
        
        
        cambiopanel(ingresos);
        
    }
    
    
        
    
    
    public Login getMoni1() {
        
        return moni1;
        
    }
    
    
    
    public void setMoni1(Login moni1) {
        
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
    
    
        
    
        
    
           
    public void agregartablaimg2(PdfPTable tabla, Chunk dato, int col){
        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(new Color(230,231,232));
        celda.addElement(dato);
        celda.setColspan(col);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBorder(PdfPCell.NO_BORDER);
        tabla.addCell(celda);
    }
        
    public void agregartablaimg(PdfPTable tabla, Chunk dato, int col){
        PdfPCell celda = new PdfPCell();
        celda.addElement(dato);
        celda.setColspan(col);
        celda.setPadding(2f);
        celda.setUseBorderPadding(true);
        celda.setBorderWidth(3f);
        celda.setBorderColor(Color.GRAY);
        //celda.setBorder(PdfPCell.NO_BORDER);
        
        tabla.addCell(celda);
    }

    public void agregartablaimgx(PdfPTable tabla, Chunk dato, int col){
        PdfPCell celda = new PdfPCell();
        celda.addElement(dato);
        celda.setColspan(col);
        celda.setPadding(2f);
        celda.setUseBorderPadding(true);
        celda.setBorderWidth(2f);
        celda.setBorderColor(Color.WHITE);
        //celda.setBorder(PdfPCell.NO_BORDER);
        
        tabla.addCell(celda);
    }
    
    public void agregartablaimgC(PdfPTable tabla, Chunk dato, int col){
        PdfPCell celda = new PdfPCell();
        celda.addElement(dato);
        celda.setColspan(col);
        celda.setPaddingBottom(10f);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setBorder(PdfPCell.NO_BORDER);
        tabla.addCell(celda);
    }
    
    public void agregartabla(PdfPTable tabla, String dato, int col, int aling, int tam, int font){
        Font fontpersonalizado = FontFactory.getFont("ARIAL", tam, font);
        PdfPCell celda = new PdfPCell(new Phrase(dato,new Font(fontpersonalizado)));
        celda.setColspan(col);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if(aling==0){
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        }else if(aling==1){
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        }
        celda.setBorder(PdfPCell.NO_BORDER);
        tabla.addCell(celda);
    }
    public void agregartablag1(PdfPTable tabla, String dato, int col, int aling, int tam, int font){
        Font fontpersonalizado = FontFactory.getFont("ARIAL", tam, font);
        PdfPCell celda = new PdfPCell(new Phrase(dato,new Font(fontpersonalizado)));
        celda.setBackgroundColor(new Color(88,89,91));
        celda.setColspan(col);
        if(aling==0){
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        }else if(aling==1){
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        }
        celda.setBorder(PdfPCell.NO_BORDER);
        tabla.addCell(celda);
    }
    
    public void agregartablag3(PdfPTable tabla, String dato, int col, int aling, int tam, int font){
        Font fontpersonalizado = FontFactory.getFont("ARIAL", tam, font);
        fontpersonalizado.setColor(Color.WHITE);
        Phrase p = new Phrase(dato,new Font(fontpersonalizado));
        PdfPCell celda = new PdfPCell(p);
        celda.setBackgroundColor(new Color(88,89,91));
        celda.setColspan(col);
        if(aling==0){
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        }else if(aling==1){
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        }
        celda.setUseBorderPadding(true);
        celda.setBorderWidth(3f);
        celda.setBorderColor(Color.WHITE);
        tabla.addCell(celda);
    }
    
    public void agregartablag2(PdfPTable tabla, String dato, int col, int aling, int tam, int font){
        Font fontpersonalizado = FontFactory.getFont("ARIAL", tam, font);
        PdfPCell celda = new PdfPCell(new Phrase(dato,new Font(fontpersonalizado)));
        celda.setBackgroundColor(new Color(230,231,232));
        celda.setColspan(col);
        celda.setPadding(2f);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if(aling==0){
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        }else if(aling==1){
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        }
        celda.setBorder(PdfPCell.NO_BORDER);
        tabla.addCell(celda);
    }
    
    public void agregartablag2x(PdfPTable tabla, String dato, int col, int aling, int tam, int font){
        Font fontpersonalizado = FontFactory.getFont("ARIAL", tam, font);
        PdfPCell celda = new PdfPCell(new Phrase(dato,new Font(fontpersonalizado)));
        celda.setBackgroundColor(new Color(230,231,232));
        celda.setColspan(col);
        celda.setPadding(2f);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if(aling==0){
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        }else if(aling==1){
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        }
        celda.setUseBorderPadding(true);
        celda.setBorderWidth(2f);
        celda.setBorderColor(Color.WHITE);
        tabla.addCell(celda);
    }
    
    public void agregartablag2a(PdfPTable tabla, String dato, int col, int aling, int tam, int font){
        Font fontpersonalizado = FontFactory.getFont("ARIAL", tam, font);
        PdfPCell celda = new PdfPCell(new Phrase(dato,new Font(fontpersonalizado)));
        celda.setColspan(col);
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if(aling==0){
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        }else if(aling==1){
            celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        }
        celda.setBorder(PdfPCell.NO_BORDER);
        tabla.addCell(celda);
    }
    
    public void agregartablain(PdfPTable tabla, PdfPTable in, int col){
        PdfPCell celda = new PdfPCell(in);
        celda.setColspan(col);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setBorder(PdfPCell.NO_BORDER);
        tabla.addCell(celda);
    }
        
    public void genenerarRoporte() throws DocumentException{
        Document documento = new Document(PageSize.A4, 0, 0, 0, 0);
        FileOutputStream ficheroPdf;
        PdfWriter writer=null;
        PdfWriter writer2=null;
        Calendar now2 = Calendar.getInstance();
        String ca2="";
        try
        {
            String cad= Funcion.DateFormatSql(now2.getTime());
            cad=cad.replaceAll("-", "");
            String ca1= Funcion.DateTimeToString4Hour(now2.getTime());
            ca2= direccion+cad+ca1+".pdf";
            ficheroPdf = new FileOutputStream(ca2);
            writer= PdfWriter.getInstance(documento,ficheroPdf);
        }catch (IOException ex){
            System.out.println(ex.toString());
        }
        ServiceHb helper=null;
        try{
            Calendar principal1=null;
            Calendar principal2=null;
            Calendar now = Calendar.getInstance();
            Calendar basen = Calendar.getInstance();
            basen.set(basen.get(Calendar.YEAR),basen.get(Calendar.MONTH),basen.get(Calendar.DAY_OF_MONTH)-1,20,10,0);
            //1
            Calendar base2 = Calendar.getInstance();
            base2.set(base2.get(Calendar.YEAR),base2.get(Calendar.MONTH),base2.get(Calendar.DAY_OF_MONTH),8,10,0);
            //2
            Calendar base3 = Calendar.getInstance();
            base3.set(base3.get(Calendar.YEAR),base3.get(Calendar.MONTH),base3.get(Calendar.DAY_OF_MONTH),20,10,0);
            
            Calendar base4 = Calendar.getInstance();
            base4.set(base4.get(Calendar.YEAR),base4.get(Calendar.MONTH),base4.get(Calendar.DAY_OF_MONTH)+1,8,10,0);
            
            List<RPall> listP=null;
            List<RPall> listR=null;
            List<Observacion> list2=null;
            List<Registros> regis=null;
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            if(now.before(base3)&&now.after(base2)){
                principal2=base3;
                principal1=base2;
                listP = helper.getListPatrulla(base2.getTime(), base3.getTime(),localidad);
                listR = helper.getListrelevo(base2.getTime(), base3.getTime(),localidad);
                list2 = helper.getListObservacion(base2.getTime(), base3.getTime());
                regis= helper.getRegistrosex(base2.getTime(), base3.getTime());
            }else if(now.before(base2)){
                principal2=base2;
                principal1=basen;
                listP = helper.getListPatrulla(basen.getTime(), base2.getTime(),localidad);
                listR = helper.getListrelevo(basen.getTime(), base2.getTime(),localidad);
                list2 = helper.getListObservacion(basen.getTime(), base2.getTime());
                regis= helper.getRegistrosex(basen.getTime(), base2.getTime());
            }else if(now.after(base3)){
                principal2=base4;
                principal1=base3;
                listP = helper.getListPatrulla(base3.getTime(), base4.getTime(),localidad);
                listR = helper.getListrelevo(base3.getTime(), base4.getTime(),localidad);
                list2 = helper.getListObservacion(base3.getTime(), base4.getTime());
                regis= helper.getRegistrosex(base3.getTime(), base4.getTime());
            }
            
            documento.open();
            PdfContentByte canvas = writer.getDirectContent();
            
            fondos(documento,canvas);
            PdfPCell casilla= new PdfPCell();
            PdfPTable salto= new PdfPTable(1);
            casilla.setMinimumHeight(500);
            casilla.setBorder(PdfPCell.NO_BORDER);
            salto.addCell(casilla);
            documento.add(salto);
            
            PdfPTable tabla = new PdfPTable(1);
            tabla.setTotalWidth(500);
            float[] widths = new float[] {500f};
            tabla.setWidths(widths);
            String propiedad = helper.getConfiguracionCampo("Propiedad").get(0).getDato();
            agregartabla(tabla,propiedad,1,0,26,Font.BOLDITALIC);
            agregartabla(tabla,localidad,1,0,20,Font.BOLDITALIC);
            agregartabla(tabla,"",1,0,20,Font.BOLDITALIC);
            documento.add(tabla);
            
            documento.newPage();
            fondos2(documento,canvas);
            /*Parte 1*/
            casilla= new PdfPCell();
            salto= new PdfPTable(1);
            casilla.setMinimumHeight(54);
            casilla.setBorder(PdfPCell.NO_BORDER);
            salto.addCell(casilla);
            
            documento.add(salto);
            tabla = new PdfPTable(9);
            tabla.setTotalWidth(500);
            widths = new float[] { 8f, 110f,80f, 80f, 30f, 20f, 20f, 100f, 75f };
            tabla.setWidths(widths);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"• DATOS GUARDIAS CAJAMARCA",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"Estos son los guardias que trabajaron en esta jornada.",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            if(mn1!=null){
                try{
                    agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                    String cadena="";
                    File sourceimage=null;
                    try{
                        if(mn1.getCi().split("")[0].contains("0")){
                            sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn1.getCi().substring(1, mn1.getCi().length())+".jpeg");
                            if(!sourceimage.exists()){
                                sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn1.getCi().substring(1, mn1.getCi().length())+".jpg");
                            }
                        }else{
                            sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn1.getCi()+".jpeg");
                            if(!sourceimage.exists()){
                                sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn1.getCi()+".jpeg");
                            }
                        }
                        BufferedImage image = ImageIO.read(sourceimage);
                        Image imghead = com.itextpdf.text.Image.getInstance(image , null);
                        imghead.scaleAbsolute(90, 110);
                        imghead.setAbsolutePosition(0, 0);
                        imghead.setAlignment(Image.ALIGN_CENTER);
                        //imghead.scalePercent(scaler);
                        agregartablaimg(tabla,new Chunk(imghead, 0, 0),1);
                    }catch(IOException | BadElementException io){
                        Image img2 = null;
                        int xx2=90;
                        int yy2=110;
                        java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                        ig = ig.getScaledInstance(xx2,yy2,  java.awt.Image.SCALE_SMOOTH);
                        img2 = com.itextpdf.text.Image.getInstance(ig, null);
                        agregartablaimg(tabla,new Chunk(img2, 0, 0),1);
                    }
                    PdfPTable tabla2 = new PdfPTable(2);
                    tabla2.setTotalWidth(100);
                    agregartabla(tabla2, "NOMBRES ", 1,1,7,Font.BOLDITALIC);
                    agregartabla(tabla2, mn1.getNombre(), 1,1,5,Font.NORMAL);
                    agregartabla(tabla2, "CEDULA ", 1,1,7,Font.BOLDITALIC);
                    agregartabla(tabla2, mn1.getCi(), 1,1,5,Font.NORMAL);
                    agregartablain(tabla,tabla2,2);
                    PdfPTable tabla3 = new PdfPTable(1);
                    agregartablain(tabla,tabla3,6);
                }catch(IOException | BadElementException io){
                    System.out.println(io);
                }
            }
            if(mn2!=null){
                try{
                    String cadena="";
                    agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                    File sourceimage=null;
                    try{
                        if(mn2.getCi().split("")[0].contains("0")){
                            sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn2.getCi().substring(1, mn2.getCi().length())+".jpeg");
                            if(!sourceimage.exists()){
                                sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn2.getCi().substring(1, mn2.getCi().length())+".jpg");
                            }
                        }else{
                            sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn2.getCi()+".jpeg");
                            if(!sourceimage.exists()){
                                sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn2.getCi()+".jpeg");
                            }
                        }
                        BufferedImage image = ImageIO.read(sourceimage);
                        Image imghead = com.itextpdf.text.Image.getInstance(image , null);
                        imghead.scaleAbsolute(90, 110);
                        imghead.setAbsolutePosition(0, 0);
                        imghead.setAlignment(Image.ALIGN_CENTER);

                        agregartablaimg(tabla,new Chunk(imghead, 0, 0),1);
                    }catch(IOException | BadElementException io){
                        Image img2 = null;
                        int xx2=90;
                        int yy2=110;
                        java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                        ig = ig.getScaledInstance(xx2,yy2,  java.awt.Image.SCALE_SMOOTH);
                        img2 = com.itextpdf.text.Image.getInstance(ig, null);
                        agregartablaimg(tabla,new Chunk(img2, 0, 0),1);
                    }
                    PdfPTable tabla2 = new PdfPTable(2);
                    tabla2.setTotalWidth(100);
                    agregartabla(tabla2, "NOMBRES ", 1,1,7,Font.BOLDITALIC);
                    agregartabla(tabla2, mn2.getNombre(), 1,1,5,Font.NORMAL);
                    agregartabla(tabla2, "CEDULA ", 1,1,7,Font.BOLDITALIC);
                    agregartabla(tabla2, mn2.getCi(), 1,1,5,Font.NORMAL);
                    agregartablain(tabla,tabla2,2);
                    PdfPTable tabla3 = new PdfPTable(1);
                    agregartablain(tabla,tabla3,5);
                }catch(IOException | BadElementException io){}
            }
            if(mn3!=null){
                try{
                    String cadena="";
                    agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                    File sourceimage=null;
                    try{
                        if(mn3.getCi().split("")[0].contains("0")){
                            sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn3.getCi().substring(1, mn3.getCi().length())+".jpeg");
                            if(!sourceimage.exists()){
                                sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn3.getCi().substring(1, mn3.getCi().length())+".jpg");
                            }
                        }else{
                            sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn3.getCi()+".jpeg");
                            if(!sourceimage.exists()){
                                sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn3.getCi()+".jpeg");
                            }
                        }
                        BufferedImage image = ImageIO.read(sourceimage);
                        Image imghead = com.itextpdf.text.Image.getInstance(image , null);
                        imghead.scaleAbsolute(90, 110);
                        imghead.setAbsolutePosition(0, 0);
                        imghead.setAlignment(Image.ALIGN_CENTER);
                        
                        agregartablaimg(tabla,new Chunk(imghead, 0, 0),1);
                    }catch(IOException | BadElementException io){
                        Image img2 = null;
                        int xx2=90;
                        int yy2=110;
                        java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                        ig = ig.getScaledInstance(xx2,yy2,  java.awt.Image.SCALE_SMOOTH);
                        img2 = com.itextpdf.text.Image.getInstance(ig, null);
                        agregartablaimg(tabla,new Chunk(img2, 0, 0),1);
                    }
                    PdfPTable tabla2 = new PdfPTable(2);
                    tabla2.setTotalWidth(100);
                    agregartabla(tabla2, "NOMBRES ", 1,1,7,Font.BOLDITALIC);
                    agregartabla(tabla2, mn3.getNombre(), 1,1,5,Font.NORMAL);
                    agregartabla(tabla2, "CEDULA ", 1,1,7,Font.BOLDITALIC);
                    agregartabla(tabla2, mn3.getCi(), 1,1,5,Font.NORMAL);
                    agregartablain(tabla,tabla2,2);
                    PdfPTable tabla3 = new PdfPTable(1);
                    agregartablain(tabla,tabla3,5);
                }catch(IOException | BadElementException io){}
            }
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"• NOVEDADES",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"Ninguna",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            
            documento.add(tabla);
            documento.newPage();
            /*BASE 2*/
            fondos2(documento,canvas);
            documento.add(salto);
            tabla = new PdfPTable(4);
            tabla.setTotalWidth(500);
            widths = new float[] {8f,300f, 90f, 120f};
            tabla.setWidths(widths);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"• Relevo en el Punto", 3,1,9,Font.BOLDITALIC);
            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
            int tempo=0;    
            if(listR!=null){
                int temp=0;
                for(RPall i: listR){
                    int t1= Integer.parseInt(i.getHorafin().split(",")[0]);
                    int t2= Integer.parseInt(i.getHorafin().split(",")[1]);
                    int t3= Integer.parseInt(i.getHorafin().split(",")[2]);
                    Calendar itemR= Calendar.getInstance();
                    itemR.set(itemR.get(Calendar.YEAR),itemR.get(Calendar.MONTH),itemR.get(Calendar.DAY_OF_MONTH),t1,t2,t3);
                    temp++;
                    try{
                        List<Revpavitem> item= helper.getRevpatbyDispositivositem(""+i.getId(),principal1.getTime(),principal2.getTime());
                        if(item!=null){
                        
                        for(Revpavitem it: item){
                            tempo++;
                            if(tempo==3){
                                documento.add(tabla);
                                tempo=1;
                                documento.newPage();
                                documento.add(salto);
                                fondos2(documento,canvas);
                                tabla = new PdfPTable(4);
                                tabla.setTotalWidth(500);
                                widths = new float[] {8f,300f, 90f, 120f};
                                tabla.setWidths(widths);
                                agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                                agregartabla(tabla,"• Relevo en el Punto", 3,1,9,Font.BOLDITALIC);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                            }
                            String campoo1=it.getNombre();
                            String campoo2=Funcion.DateTimeToString2(it.getFecha());
                            String campoo3="";
                            Foto foto = helper.getfotoid(""+it.getIdfoto());
                            Image img = null;
                            int xx2=500;
                            int yy2=320;
                            java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                            ig = ig.getScaledInstance(xx2,yy2, java.awt.Image.SCALE_SMOOTH);
                            img = com.itextpdf.text.Image.getInstance(ig, null);
                            if(foto!=null){
                                try{
                                    String cadena= foto.getFoto();
                                    byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                                    InputStream in = new ByteArrayInputStream(decodedString);
                                    BufferedImage bg = ImageIO.read(in);
                                    java.awt.Image im=null;
                                    int xx=500;
                                    int yy=320;
                                    if(!foto.getObservacion().contains("null")){
                                        campoo3=foto.getObservacion();
                                    }
                                    img = com.itextpdf.text.Image.getInstance(bg,null);
                                    img.scaleAbsolute(500, 320);
                                    
                                }catch(IOException | BadElementException io){
                                    System.out.println(io);
                                } 
                                //helper.eliminarObjeto(foto);
                            }
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            PdfPTable tabla2 = new PdfPTable(1);
                            tabla2.setTotalWidth(500);
                            agregartablag2a(tabla2,campoo1,1,0,7,Font.BOLDITALIC);
                            agregartablag2a(tabla2,campoo2,1,0,7,Font.NORMAL);
                            agregartablag2a(tabla2,campoo3,1,0,7,Font.NORMAL);
                            agregartablain(tabla,tabla2,3);
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            agregartablaimg(tabla,new Chunk(img, 0, 0),3);
                            helper.eliminarObjeto(it);
                            }
                        }
                        }catch(Exception io){
                            System.out.println(io);
                        }
                    }
                if(tempo!=5){
                    documento.add(tabla);
                }
                
            }else{
                agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                agregartabla(tabla,"", 3,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"", 1,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"Sin Datos", 3,1,9,Font.BOLDITALIC);
                documento.add(tabla);
            }
            documento.newPage();
            fondos2(documento,canvas);
            documento.add(salto);
            tabla = new PdfPTable(4);
            tabla.setTotalWidth(500);
            widths = new float[] {8f,300f, 90f, 120f};
            tabla.setWidths(widths);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"• Patrullas en el Punto", 3,1,9,Font.BOLDITALIC);
            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
            tempo=0;
            if(listP!=null){
                int temp=0;
                for(RPall i: listP){
                    int t1= Integer.parseInt(i.getHorafin().split(",")[0]);
                    int t2= Integer.parseInt(i.getHorafin().split(",")[1]);
                    int t3= Integer.parseInt(i.getHorafin().split(",")[2]);
                    Calendar itemP= Calendar.getInstance();
                    itemP.set(itemP.get(Calendar.YEAR),itemP.get(Calendar.MONTH),itemP.get(Calendar.DAY_OF_MONTH),t1,t2,t3);
                    temp++;
                    try{
                        List<Revpavitem> item= helper.getRevpatbyDispositivositem(""+i.getId(),principal1.getTime(),principal2.getTime());
                        if(item!=null){
                        
                        for(Revpavitem it: item){
                            tempo++;
                            if(tempo==3){
                                documento.add(tabla);
                                tempo=1;
                                documento.newPage();
                                documento.add(salto);
                                fondos2(documento,canvas);
                                tabla = new PdfPTable(4);
                                tabla.setTotalWidth(500);
                                widths = new float[] {8f,300f, 90f, 120f};
                                tabla.setWidths(widths);
                                agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                                agregartabla(tabla,"• Relevo en el Punto", 3,1,9,Font.BOLDITALIC);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                            }
                            String campoo1=it.getNombre();
                            String campoo2=Funcion.DateTimeToString2(it.getFecha());
                            String campoo3="";
                            Foto foto = helper.getfotoid(""+it.getIdfoto());
                            Image img = null;
                            int xx2=500;
                            int yy2=320;
                            java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                            ig = ig.getScaledInstance(xx2,yy2, java.awt.Image.SCALE_SMOOTH);
                            img = com.itextpdf.text.Image.getInstance(ig, null);
                            if(foto!=null){
                                try{
                                    String cadena= foto.getFoto();
                                    byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                                    InputStream in = new ByteArrayInputStream(decodedString);
                                    BufferedImage bg = ImageIO.read(in);
                                    java.awt.Image im=null;
                                    int xx=500;
                                    int yy=320;
                                    if(!foto.getObservacion().contains("null")){
                                        campoo3=foto.getObservacion();
                                    }
                                    img = com.itextpdf.text.Image.getInstance(bg,null);
                                    img.scaleAbsolute(500, 320);
                                    
                                }catch(IOException | BadElementException io){
                                    System.out.println(io);
                                } 
                                //helper.eliminarObjeto(foto);
                            }
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            PdfPTable tabla2 = new PdfPTable(1);
                            tabla2.setTotalWidth(500);
                            agregartablag2a(tabla2,campoo1,1,0,7,Font.BOLDITALIC);
                            agregartablag2a(tabla2,campoo2,1,0,7,Font.NORMAL);
                            agregartablag2a(tabla2,campoo3,1,0,7,Font.NORMAL);
                            agregartablain(tabla,tabla2,3);
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            agregartablaimg(tabla,new Chunk(img, 0, 0),3);
                            helper.eliminarObjeto(it);
                            }
                        }
                        }catch(Exception io){
                            System.out.println(io);
                        }
                    
                }
                if(tempo!=5){
                    documento.add(tabla);
                }
                
            }else{
                agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                agregartabla(tabla,"", 3,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"Sin Datos", 4,1,9,Font.BOLDITALIC);
                documento.add(tabla);
            }
            
            documento.newPage();
            
            documento.add(salto);
            fondos2(documento,canvas);
            tabla = new PdfPTable(8);
            tabla.setTotalWidth(500);
            widths = new float[] { 8f,60f, 80f, 60f, 80f,80f, 90f, 85f};
            tabla.setWidths(widths);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"• Reporte Registros en el Punto", 7,1,9,Font.BOLDITALIC);
            agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
            agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
            
            agregartabla(tabla,"",1,1,7,Font.NORMAL);
            agregartablag1(tabla,"VEHICULO",1,0,9,Font.BOLDITALIC);
            agregartablag1(tabla,"CONDUCTOR",1,0,9,Font.BOLDITALIC);
            agregartablag1(tabla,"CEDULA",1,0,9,Font.BOLDITALIC);
            agregartablag1(tabla,"NOMBRE",1,0,9,Font.BOLDITALIC);
            agregartablag1(tabla,"FOTO PLACA",1,0,9,Font.BOLDITALIC);
            agregartablag1(tabla,"HORA DE INGRESO",1,0,9,Font.BOLDITALIC);
            agregartablag1(tabla,"HORA SALIDA",1,0,9,Font.BOLDITALIC);
            tempo=0;    
            if(regis!=null){
                int temp=0;
                for(Registros i: regis){
                    tempo++;
                    if(tempo==10){
                        documento.add(tabla);
                        tempo=1;
                        documento.newPage();
                        documento.add(salto);
                        fondos2(documento,canvas);
                        tabla = new PdfPTable(8);
                        tabla.setTotalWidth(500);
                        widths = new float[] { 8f,60f, 80f, 60f, 80f,80f, 90f, 85f};
                        tabla.setWidths(widths);
                        agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                        agregartabla(tabla,"• Reporte Registros en el Punto", 7,1,9,Font.BOLDITALIC);
                        agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
                        agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);

                        agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                        agregartablag1(tabla,"VEHICULO",1,0,9,Font.BOLDITALIC);
                        agregartablag1(tabla,"CONDUCTOR",1,0,9,Font.BOLDITALIC);
                        agregartablag1(tabla,"CEDULA",1,0,9,Font.BOLDITALIC);
                        agregartablag1(tabla,"NOMBRES",1,0,9,Font.BOLDITALIC);
                        agregartablag1(tabla,"FOTO PLACA",1,0,9,Font.BOLDITALIC);
                        agregartablag1(tabla,"HORA DE INGRESO",1,0,9,Font.BOLDITALIC);
                        agregartablag1(tabla,"HORA SALIDA",1,0,9,Font.BOLDITALIC);
                    }
                    temp++;
                    try{
                    String campoo4="";
                    if(i.getUsuario().getVehiculo()==null){
                    }else{
                        campoo4=i.getUsuario().getVehiculo().getPlaca();
                    }
                    String campoo2=i.getLogin();
                    String campoo3=""+i.getTipo();
                    String campoo5=i.getUsuario().getCi();
                    String campoo6=i.getUsuario().getNombre();
                    String campoo7=i.getUsuario().getApellido();
                    String campoo9="";
                    String campoo11="";
                    if(i.getFinTiempo()==null){
                    }else{
                        campoo11=Funcion.DateTimeFormatJS(i.getFinTiempo());
                    }
                    String campoo10=Funcion.DateTimeFormatJS(i.getInicioTiempo());
                    
                    Foto foto = helper.getfotoCi(campoo5);
                    Foto foto2 = helper.getfotoPlaca(campoo4);
                    Image img = null;
                    Image img2 = null;
                    int xx2=70;
                    int yy2=70;
                    java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                    ig = ig.getScaledInstance(xx2,yy2, 0);
                    img2 = com.itextpdf.text.Image.getInstance(ig, null);
                    img = com.itextpdf.text.Image.getInstance(ig, null);
                    if(foto!=null){
                        try{
                            String cadena= foto.getFoto();
                            byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                            InputStream in = new ByteArrayInputStream(decodedString);
                            BufferedImage bg = ImageIO.read(in);
                            java.awt.Image im=null;
                            int xx=70;
                            int yy=70;
                            img = com.itextpdf.text.Image.getInstance(bg, null);
                            img.scaleAbsolute(70, 70);
                        }catch(IOException | BadElementException io){
                            System.out.println(io);
                        }
                    }
                    if(foto2!=null){
                        try{
                            String cadena= foto2.getFoto();
                            byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                            InputStream in = new ByteArrayInputStream(decodedString);
                            BufferedImage bg = ImageIO.read(in);
                            java.awt.Image im=null;
                            int xx=70;
                            int yy=70;
                            img2 = com.itextpdf.text.Image.getInstance(bg, null);
                            img2.scaleAbsolute(70, 70);
                        }catch(IOException | BadElementException io){
                            System.out.println(io);
                        }
                    }
                    agregartabla(tabla,"",1,1,7,Font.NORMAL);
                    agregartablag2(tabla,campoo4,1,0,6,Font.NORMAL);
                    agregartablaimg(tabla,new Chunk(img, 0, 0),1);
                    agregartablag2(tabla,campoo5,1,0,6,Font.NORMAL);
                    agregartablag2(tabla,campoo6+" "+campoo7,1,0,6,Font.NORMAL);
                    agregartablaimg(tabla,new Chunk(img2, 0, 0),1);
                    agregartablag2(tabla,campoo10,1,0,6,Font.NORMAL);
                    agregartablag2(tabla,campoo11,1,0,6,Font.NORMAL);
                    }catch(Exception io){
                        System.out.println(io);
                    }
                }
                if(tempo!=10){
                    documento.add(tabla);
                }
            }else{
                agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
                agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"", 1,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"Sin Datos", 7,1,9,Font.BOLDITALIC);
                documento.add(tabla);
            }
            
            documento.add(salto);
            /*Fin Parte 3*/
            documento.close();
            helper.confirmarTransaccion();
            helper.cerrarSesion();
        }catch(Exception ex){
            try{
                helper.cerrarSesion();
            }catch(Exception io){}
            documento.close();
        }
        JOptionPane.showMessageDialog(null, "termino");
    }
    
    public void ingresoLog(PdfPTable tabla, Login mn){
        try{
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            String cadena="";
            File sourceimage=null;
            try{
                if(mn.getCi().split("")[0].contains("0")){
                    sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn.getCi().substring(1, mn.getCi().length())+".jpeg");
                    if(!sourceimage.exists()){
                        sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn.getCi().substring(1, mn.getCi().length())+".jpg");
                    }
                }else{
                    sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn.getCi()+".jpeg");
                    if(!sourceimage.exists()){
                        sourceimage = new File("C:\\cdgcajamarca\\foto\\"+mn.getCi()+".jpeg");
                    }
                }
                BufferedImage image = ImageIO.read(sourceimage);
                Image imghead = com.itextpdf.text.Image.getInstance(image , null);
                imghead.scaleAbsolute(90, 110);
                imghead.setAbsolutePosition(0, 0);
                imghead.setAlignment(Image.ALIGN_CENTER);
                //imghead.scalePercent(scaler);
                agregartablaimg(tabla,new Chunk(imghead, 0, 0),1);
            }catch(IOException | BadElementException io){
                Image img2 = null;
                int xx2=90;
                int yy2=110;
                java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                ig = ig.getScaledInstance(xx2,yy2,  java.awt.Image.SCALE_SMOOTH);
                img2 = com.itextpdf.text.Image.getInstance(ig, null);
                agregartablaimg(tabla,new Chunk(img2, 0, 0),1);
            }
            PdfPTable tabla2 = new PdfPTable(2);
            tabla2.setTotalWidth(100);
            agregartabla(tabla2, "     NOMBRES ", 1,1,9,Font.BOLDITALIC);
            agregartabla(tabla2, mn.getNombre(), 1,1,8,Font.NORMAL);
            agregartabla(tabla2, "     CEDULA ", 1,1,9,Font.BOLDITALIC);
            agregartabla(tabla2, mn.getCi(), 1,1,8,Font.NORMAL);
            agregartablain(tabla,tabla2,2);
            PdfPTable tabla3 = new PdfPTable(1);
            agregartablain(tabla,tabla3,6);
        }catch(IOException | BadElementException io){
            System.out.println(io);
        }
    }
    
    public Chunk barrita(){
        Image img2=null;
        try{
            java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/barra2.png")).getImage();
            img2 = com.itextpdf.text.Image.getInstance(ig, null);
        }catch(BadElementException | IOException io){
        }
        return new Chunk(img2,0,0);
    }
    
    public void genenerarRoporte2() throws DocumentException{
        Document documento=null;
        FileOutputStream ficheroPdf;
        PdfWriter writer=null;
        PdfWriter writer2=null;
        try
        {
        Rectangle rt = PageSize.A4;
        documento = new Document(rt, 0 ,0, 0, 0);
        Calendar now2 = calendafin;
        String ca2="";        
        String cad= Funcion.DateFormatSql(now2.getTime());
        cad=cad.replaceAll("-", "");
        String ca1= Funcion.DateTimeToString4Hour(now2.getTime());
        ca2= direccion+cad+ca1+".pdf";
        ficheroPdf = new FileOutputStream(ca2);
        writer= PdfWriter.getInstance(documento,ficheroPdf);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        ServiceHb helper=null;
        try{
            Calendar principal1=null;
            Calendar principal2=null;
            
            List<RPall> listP=null;
            List<RPall> listR=null;
            List<Observacion> list2=null;
            List<Registros> regis=null;
            helper = new ServiceHb();
            helper.iniciarTransaccion();
            principal2=calendafin;
            principal1=calendaini;
            listP = helper.getListPatrulla(calendaini.getTime(), calendafin.getTime(),localidad);
            listR = helper.getListrelevo(calendaini.getTime(), calendafin.getTime(),localidad);
            list2 = helper.getListObservacion(calendaini.getTime(), calendafin.getTime());
            regis= helper.getRegistrosex(calendaini.getTime(), calendafin.getTime());
            documento.open();
            PdfContentByte canvas = writer.getDirectContent();
            fondos(documento,canvas);
            PdfPCell casilla= new PdfPCell();
            PdfPTable salto= new PdfPTable(1);
            casilla.setMinimumHeight(650);
            casilla.setBorder(PdfPCell.NO_BORDER);
            salto.addCell(casilla);
            documento.add(salto);
            
            PdfPTable tabla = new PdfPTable(1);
            tabla.setTotalWidth(500);
            float[] widths = new float[] {500f};
            tabla.setWidths(widths);
            String propiedad = helper.getConfiguracionCampo("Propiedad").get(0).getDato();
            String nombre = helper.getConfiguracionCampo("Nombre").get(0).getDato();
            agregartabla(tabla,propiedad,1,0,26,Font.BOLDITALIC);
            agregartabla(tabla,nombre,1,0,20,Font.BOLDITALIC);
            agregartabla(tabla,"",1,0,20,Font.BOLDITALIC);
            agregartabla(tabla,"",1,0,20,Font.BOLDITALIC);
            agregartabla(tabla,Funcion.DateFormatSql(calendafin.getTime()),1,0,20,Font.BOLDITALIC);
            documento.add(tabla);
            documento.setMargins(-92, 0, 0, 0);
            documento.newPage();
            documento.setMargins(0, 0, 0, 0);
            fondos2(documento,canvas);
            /*Parte 1*/
            casilla= new PdfPCell();
            salto= new PdfPTable(1);
            casilla.setMinimumHeight(54);
            casilla.setBorder(PdfPCell.NO_BORDER);
            salto.addCell(casilla);
            
            documento.add(salto);
            tabla = new PdfPTable(9);
            
            tabla.setTotalWidth(500);
            widths = new float[] { 90f, 90f,100f, 80f, 30f, 20f, 20f, 10f, 60f };
            tabla.setWidths(widths);
            agregartablaimgC(tabla,barrita(),1);
            agregartabla(tabla,"• DATOS GUARDIAS CAJAMARCA",8,1,10,Font.BOLDITALIC);
            
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"Estos son los guardias que trabajaron en esta jornada.",8,1,8,Font.BOLDITALIC);
            
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            if(mn1!=null){
                ingresoLog(tabla, mn1);
            }
            if(mn2!=null){
                ingresoLog(tabla, mn2);
            }
            if(mn3!=null){
                ingresoLog(tabla, mn3);
            }
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartablaimgC(tabla,barrita(),1);
            agregartabla(tabla,"• NOVEDADES",8,1,10,Font.BOLD);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"Sin Ninguna",8,1,8,Font.BOLD);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
            agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
            documento.setMargins(-95, 0, 0, 0);
            documento.add(tabla);
            /*BASE 2*/
            if(listR!=null){
                int tempo=0;    
                int temp=0;
                List<Revpavitem> item=null;
                for(RPall i: listR){
                    int t1= Integer.parseInt(i.getHorafin().split(",")[0]);
                    int t2= Integer.parseInt(i.getHorafin().split(",")[1]);
                    int t3= Integer.parseInt(i.getHorafin().split(",")[2]);
                    Calendar itemR= Calendar.getInstance();
                    itemR.set(itemR.get(Calendar.YEAR),itemR.get(Calendar.MONTH),itemR.get(Calendar.DAY_OF_MONTH),t1,t2,t3);
                    temp++;
                    try{
                        item= helper.getRevpatbyDispositivositem(""+i.getId(),principal1.getTime(),principal2.getTime());
                        if(item!=null){
                            documento.newPage();
                            documento.setMargins(0, 0, 0, 0);
                            fondos2(documento,canvas);
                            documento.add(salto);
                            tabla = new PdfPTable(4);
                            tabla.setTotalWidth(500);
                            widths = new float[] {95f,450f, 1f, 10f};
                            tabla.setWidths(widths);
                            agregartablaimgC(tabla,barrita(),1);
                            agregartabla(tabla,"  • Relevo en el Punto", 3,1,10,Font.BOLD);
                            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                        for(Revpavitem it: item){
                            tempo++;
                            if(tempo==3){
                                documento.setMargins(-95, 0, 0, 0);
                                documento.add(tabla);
                                tempo=1;
                                documento.newPage();
                                documento.add(salto);
                                documento.setMargins(0, 0, 0, 0);
                                fondos2(documento,canvas);
                                tabla = new PdfPTable(4);
                                tabla.setTotalWidth(500);
                                widths = new float[] {95f,450f, 1f, 10f};
                                tabla.setWidths(widths);
                                agregartablaimgC(tabla,barrita(),1);
                                agregartabla(tabla,"  • Relevo en el Punto", 3,1,10,Font.BOLD);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                            }
                            String campoo1=it.getNombre();
                            String campoo2=Funcion.DateTimeToString2(it.getFecha());
                            String campoo3="";
                            Foto foto = helper.getfotoid(""+it.getIdfoto());
                            Image img = null;
                            int xx2=450;
                            int yy2=320;
                            java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                            ig = ig.getScaledInstance(xx2,yy2, java.awt.Image.SCALE_SMOOTH);
                            img = com.itextpdf.text.Image.getInstance(ig, null);
                            if(foto!=null){
                                try{
                                    String cadena= foto.getFoto();
                                    byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                                    InputStream in = new ByteArrayInputStream(decodedString);
                                    BufferedImage bg = ImageIO.read(in);
                                    java.awt.Image im=null;
                                    if(!foto.getObservacion().contains("null")){
                                        campoo3=foto.getObservacion();
                                    }
                                    img = com.itextpdf.text.Image.getInstance(bg,null);
                                    img.scaleAbsolute(450, 320);
                                }catch(IOException | BadElementException io){
                                    System.out.println(io);
                                } 
                                //helper.eliminarObjeto(foto);
                            }
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            PdfPTable tabla2 = new PdfPTable(1);
                            tabla2.setTotalWidth(500);
                            agregartablag2a(tabla2,campoo1,1,0,7,Font.BOLD);
                            agregartablag2a(tabla2,campoo2,1,0,7,Font.NORMAL);
                            agregartablag2a(tabla2,campoo3,1,0,7,Font.NORMAL);
                            agregartablain(tabla,tabla2,3);
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            agregartablaimg(tabla,new Chunk(img, 0, 0),3);
                            //helper.eliminarObjeto(it);
                            }
                        }
                        }catch(Exception io){
                            System.out.println(io);
                        }
                    }
                if(tempo!=3 && item!=null){
                    documento.setMargins(-95, 0, 0, 0);
                    documento.add(tabla);
                }
            }else{

            }
            
            if(listP!=null){
            List<Revpavitem> item=null;
            int tempo=0;
                int temp=0;
                for(RPall i: listP){
                    int t1= Integer.parseInt(i.getHorafin().split(",")[0]);
                    int t2= Integer.parseInt(i.getHorafin().split(",")[1]);
                    int t3= Integer.parseInt(i.getHorafin().split(",")[2]);
                    Calendar itemR= Calendar.getInstance();
                    itemR.set(itemR.get(Calendar.YEAR),itemR.get(Calendar.MONTH),itemR.get(Calendar.DAY_OF_MONTH),t1,t2,t3);
                    temp++;
                    try{
                        item= helper.getRevpatbyDispositivositem(""+i.getId(),principal1.getTime(),principal2.getTime());
                        if(item!=null){
                            documento.newPage();
                            documento.setMargins(0, 0, 0, 0);
                            fondos2(documento,canvas);
                            documento.add(salto);
                            tabla = new PdfPTable(4);
                            tabla.setTotalWidth(500);
                            widths = new float[] {95f,450f, 1f, 10f};
                            tabla.setWidths(widths);
                            agregartablaimgC(tabla,barrita(),1);
                            agregartabla(tabla,"  • Relevo en el Punto", 3,1,10,Font.BOLD);
                            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                            agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                        for(Revpavitem it: item){
                            tempo++;
                            if(tempo==3){
                                documento.setMargins(-95, 0, 0, 0);
                                documento.add(tabla);
                                tempo=1;
                                documento.newPage();
                                documento.add(salto);
                                documento.setMargins(0, 0, 0, 0);
                                fondos2(documento,canvas);
                                tabla = new PdfPTable(4);
                                tabla.setTotalWidth(500);
                                widths = new float[] {95f,450f, 1f, 10f};
                                tabla.setWidths(widths);
                                agregartablaimgC(tabla,barrita(),1);
                                agregartabla(tabla,"  • Relevo en el Punto", 3,1,10,Font.BOLD);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                                agregartabla(tabla,"", 4,1,9,Font.BOLDITALIC);
                            }
                            String campoo1=it.getNombre();
                            String campoo2=Funcion.DateTimeToString2(it.getFecha());
                            String campoo3="";
                            Foto foto = helper.getfotoid(""+it.getIdfoto());
                            Image img = null;
                            int xx2=450;
                            int yy2=320;
                            java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoblanco.png")).getImage();
                            ig = ig.getScaledInstance(xx2,yy2, java.awt.Image.SCALE_SMOOTH);
                            img = com.itextpdf.text.Image.getInstance(ig, null);
                            if(foto!=null){
                                try{
                                    String cadena= foto.getFoto();
                                    byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                                    InputStream in = new ByteArrayInputStream(decodedString);
                                    BufferedImage bg = ImageIO.read(in);
                                    java.awt.Image im=null;
                                    if(!foto.getObservacion().contains("null")){
                                        campoo3=foto.getObservacion();
                                    }
                                    img = com.itextpdf.text.Image.getInstance(bg,null);
                                    img.scaleAbsolute(450, 320);
                                }catch(IOException | BadElementException io){
                                    System.out.println(io);
                                } 
                                //helper.eliminarObjeto(foto);
                            }
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            PdfPTable tabla2 = new PdfPTable(1);
                            tabla2.setTotalWidth(500);
                            agregartablag2a(tabla2,campoo1,1,0,7,Font.BOLD);
                            agregartablag2a(tabla2,campoo2,1,0,7,Font.NORMAL);
                            agregartablag2a(tabla2,campoo3,1,0,7,Font.NORMAL);
                            agregartablain(tabla,tabla2,3);
                            
                            agregartabla(tabla,"",1,1,7,Font.BOLDITALIC);
                            agregartablaimg(tabla,new Chunk(img, 0, 0),3);
                            //helper.eliminarObjeto(it);
                            }
                        }
                        }catch(Exception io){
                            System.out.println(io);
                        }
                    }
                if(tempo!=3 && item!=null){
                    documento.setMargins(-95, 0, 0, 0);
                    documento.add(tabla);
                }
                
            }else{

            }
            documento.newPage();
            
            documento.add(salto);
            documento.setMargins(0, 0, 0, 0);
            fondos2(documento,canvas);
            documento.setMargins(-95, 0, 0, 0);
            tabla = new PdfPTable(8);
            tabla.setTotalWidth(500);
            widths = new float[] {95f,60f, 90f, 60f, 80f,90f, 90f, 85f};
            tabla.setWidths(widths);
            agregartablaimgC(tabla,barrita(),1);
            agregartabla(tabla,"       • Reporte Registros en el Punto", 7,1,8,Font.BOLD);
            agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
            agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
            
            agregartabla(tabla,"",1,1,7,Font.NORMAL);
            agregartablag3(tabla,"VEHICULO",1,0,8,Font.BOLD);
            agregartablag3(tabla,"CONDUCTOR",1,0,8,Font.BOLD);
            agregartablag3(tabla,"CEDULA",1,0,8,Font.BOLD);
            agregartablag3(tabla,"NOMBRE",1,0,8,Font.BOLD);
            agregartablag3(tabla,"FOTO PLACA",1,0,8,Font.BOLD);
            agregartablag3(tabla,"HORA DE I/S",1,0,8,Font.BOLD);
            agregartablag3(tabla,"OBSERVACION",1,0,8,Font.BOLD);
            int tempo=0;    
            if(regis!=null){
                int temp=0;
                for(Registros i: regis){
                    tempo++;
                    if(tempo==10){
                        documento.setMargins(-95, 0, 0, 0);
                        documento.add(tabla);
                        tempo=1;
                        documento.newPage();
                        documento.add(salto);
                        documento.setMargins(0, 0, 0, 0);
                        fondos2(documento,canvas);
                        tabla = new PdfPTable(8);
                        tabla.setTotalWidth(500);
                        widths = new float[] {95f,60f, 90f, 60f, 80f,90f, 90f, 85f};
                        tabla.setWidths(widths);
                        agregartablaimgC(tabla,barrita(),1);
                        agregartabla(tabla,"       • Reporte Registros en el Punto", 7,1,8,Font.BOLD);
                        agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
                        agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);

                        agregartabla(tabla,"",1,1,7,Font.NORMAL);
                        agregartablag3(tabla,"VEHICULO",1,0,8,Font.BOLD);
                        agregartablag3(tabla,"CONDUCTOR",1,0,8,Font.BOLD);
                        agregartablag3(tabla,"CEDULA",1,0,8,Font.BOLD);
                        agregartablag3(tabla,"NOMBRE",1,0,8,Font.BOLD);
                        agregartablag3(tabla,"FOTO PLACA",1,0,8,Font.BOLD);
                        agregartablag3(tabla,"HORA DE I/S",1,0,8,Font.BOLD);
                        agregartablag3(tabla,"OBSERVACION",1,0,8,Font.BOLD);
                    }
                    temp++;
                    try{
                    String campoo4="";
                    if(i.getUsuario().getVehiculo()==null){
                    }else{
                        campoo4=i.getUsuario().getVehiculo().getPlaca();
                    }
                    String campoo2=i.getLogin();
                    String campoo3=""+i.getTipo();
                    String campoo5=i.getUsuario().getCi();
                    String campoo6=i.getUsuario().getNombre();
                    String campoo7=i.getUsuario().getApellido();
                    String campoo9="";
                    String campoo11="";
                    String campoo10=Funcion.DateTimeFormatJS(i.getInicioTiempo());
                    if(i.getFinTiempo()==null){
                    }else{
                        campoo10=campoo10 + "-" + Funcion.DateTimeFormatJS(i.getFinTiempo());
                    }
                    if(i.getExtra()!=null){
                        campoo11=""+i.getExtra();
                    }
                    
                    Foto foto = helper.getfotoCi(campoo5);
                    Foto foto2 = helper.getfotoPlaca(campoo4);
                    Image img = null;
                    Image img2 = null;
                    int xx2=70;
                    int yy2=70;
                    java.awt.Image ig = new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/nofoto.png")).getImage();
                    img2 = com.itextpdf.text.Image.getInstance(ig, null);
                    img = com.itextpdf.text.Image.getInstance(ig, null);
                    img.scaleAbsolute(70, 70);
                    img2.scaleAbsolute(70, 70);
                    if(foto!=null){
                        try{
                            String cadena= foto.getFoto();
                            byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                            InputStream in = new ByteArrayInputStream(decodedString);
                            BufferedImage bg = ImageIO.read(in);
                            //bg=getScaledImage(bg,70,70);
                            java.awt.Image im=null;
                            int xx=70;
                            int yy=70;
                            img = com.itextpdf.text.Image.getInstance(bg, null);
                            img.scaleAbsolute(70, 70);
                            
                        }catch(IOException | BadElementException io){
                            System.out.println(io);
                        }
                    }
                    if(foto2!=null){
                        try{
                            String cadena= foto2.getFoto();
                            byte[] decodedString = DatatypeConverter.parseBase64Binary(cadena);
                            InputStream in = new ByteArrayInputStream(decodedString);
                            BufferedImage bg = ImageIO.read(in);
                            //bg=getScaledImage(bg,70,70);
                            java.awt.Image im=null;
                            int xx=70;
                            int yy=70;
                            img2 = com.itextpdf.text.Image.getInstance(bg, null);
                            img2.scaleAbsolute(70, 70);
                        }catch(IOException | BadElementException io){
                            System.out.println(io);
                        }
                    }
                    agregartabla(tabla,"",1,1,7,Font.NORMAL);
                    agregartablag2x(tabla,campoo4,1,0,6,Font.NORMAL);
                    agregartablaimgx(tabla,new Chunk(img, 0, 0),1);
                    agregartablag2x(tabla,campoo5,1,0,6,Font.NORMAL);
                    agregartablag2x(tabla,campoo6+" "+campoo7,1,0,6,Font.NORMAL);
                    agregartablaimgx(tabla,new Chunk(img2, 0, 0),1);
                    agregartablag2x(tabla,campoo10,1,0,6,Font.NORMAL);
                    agregartablag2x(tabla,campoo11,1,0,6,Font.NORMAL);
                    }catch(Exception io){
                        System.out.println(io);
                    }
                }
                if(tempo!=10){
                    documento.setMargins(-95, 0, 0, 0);
                    documento.add(tabla);
                }
            }else{
                agregartabla(tabla,"",8,1,7,Font.BOLDITALIC);
                agregartabla(tabla,"", 8,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"", 1,1,9,Font.BOLDITALIC);
                agregartabla(tabla,"No hay datos por presentar en los Paramentros de Fecha Designados", 7,1,9,Font.BOLDITALIC);
                documento.setMargins(-95, 0, 0, 0);
                documento.add(tabla);
            }
            
            documento.add(salto);
            documento.close();
            helper.cerrarSesion();
        }catch(Exception ex){
            try{
                helper.cerrarSesion();
            }catch(Exception io){}
            documento.close();
        }
        JOptionPane.showMessageDialog(null, "termino");
    }
    
    private BufferedImage getScaledImage(java.awt.Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, Transparency.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }  
    
    public void actualizaroff() {
        
    }
    
    public void fondos(Document documento,PdfContentByte canvas){
        try {
            java.awt.Image im = new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/plantilla3.jpg")).getImage();
            Image imghead = com.itextpdf.text.Image.getInstance(im, null);
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
    public void fondos2(Document documento,PdfContentByte canvas){
        try {
            java.awt.Image im = new javax.swing.ImageIcon(getClass().getResource("/imagenesnew/plantilla4.jpg")).getImage();
            Image imghead = com.itextpdf.text.Image.getInstance(im, null);
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
    
    public Timer getCountdownTimer() {
        
        return countdownTimer;
        
    }
    
    public void setCountdownTimer(Timer countdownTimer) {
        
        this.countdownTimer = countdownTimer;
        
    }
    
    public int getTimeRemaining() {
        
        return timeRemaining;
        
    }
    
    public void setTimeRemaining(int timeRemaining) {
        
        this.timeRemaining = timeRemaining;
        
    }
    
    
    
    private void tblEjemploMouseClicked(java.awt.event.MouseEvent evt) throws Exception {
//        
//        String cadena="";
//        
//        Registros rg1= null;
//        
//        Usuario us1 = new Usuario();
//        
//        List<Registros> list=null;
//        
//        
//        
//        int rows = registros.getjTable1().rowAtPoint(evt.getPoint());
//        
//        if (rows >= 0 && registros.getjTable1().isEnabled())
//            
//        {
//            
//            cadena= registros.getjTable1().getModel().getValueAt(rows, 7).toString();
//            
//        }
//        
//        JOptionPane.showMessageDialog(null, cadena);
//        
    }
    
    
    
    private void tblEjemploMouseClicked3(java.awt.event.MouseEvent evt) throws Exception {
        String cadena="";
        Usuario us1 = new Usuario();        
        List<Registros> list=null;
        
        String selectedSiteName;
        
        
        
        if(parcial.getjTable1().getSelectedColumn()==8){
            ServiceHb serviceclick2 = new ServiceHb();
            serviceclick2.iniciarTransaccion();
            Registros rg1= (Registros)serviceclick2.obtenerObjeto(Registros.class,(Integer) parcial.getjTable1().getModel().getValueAt(parcial.getjTable1().getSelectedRow(), 1));
            selectedSiteName = JOptionPane.showConfirmDialog(null,"Observacion: " +rg1.getExtra())+"";
            if(selectedSiteName != null){
                rg1.setActualizacion(null);
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
            }else{
                serviceclick2.cerrarSesion();
            }
        }
        
        
    }
    
    /**
     * 
     * @param n
     * @return 
     * 
     */
    
    public String mostrar(String[] n){
        return "H: "+n[0]+" M: "+n[1]+" S: "+n[2];
    }
    
    private void tblEjemploMouseClicked2(java.awt.event.MouseEvent evt) throws Exception {
        
        Registros rg1= null;
        ServiceHb helper = null;
        String selectedSiteName;
        int configurar=0;
        int rows = egreso.getjTable1().rowAtPoint(evt.getPoint());
        int col = egreso.getjTable1().getSelectedColumn();
        if(col==10){
        if(configurar==0)    
        {    
        helper = new ServiceHb();
        
        helper.iniciarTransaccion();
        
        if (rows >= 0 && egreso.getjTable1().isEnabled())   
        {
            rg1= (Registros)helper.obtenerObjeto(Registros.class,(Integer) egreso.getjTable1().getModel().getValueAt(rows, 1));
            
            Date now = new Date(System.currentTimeMillis());
            
            if(rg1.getInicioTiempo()==null){
                
                selectedSiteName = JOptionPane.showInputDialog(null,Funcion.DateTimeFormatJS(now));
                
                if(selectedSiteName != null){
                    rg1.setInicioTiempo(now);
                }
                
            }else{
                
                selectedSiteName = JOptionPane.showInputDialog(null,Funcion.DateTimeFormatJS(now));
                
                if(selectedSiteName != null){
                    rg1.setFinTiempo(now);
                    rg1.setSync("culminado");
                }
                
            }
            helper.actualizarObjeto(rg1);
            helper.confirmarTransaccion();
            
        }
        
        
        
        helper.cerrarSesion();
        
    }
    }
        
        new Thread(new Cargando(2)).start();
        
        actual=true;
        
        new Thread(new Cargando(5)).start();
        
    }

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
            
            
            
        } catch (InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            
            
        }
        //</editor-fold>
        //</editor-fold>
        
        
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new paneles(null,"","","",null,null).setVisible(true);
            } catch (FontFormatException | DocumentException ex) {
                Logger.getLogger(paneles.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel nav;
    private sgi.acceso.panel_busqueda panel_busqueda1;
    private sgi.acceso.panel_diseño panel_diseño1;
    private sgi.acceso.panel_guardia panel_guardia1;
    private sgi.acceso.panel_rrhh panel_rrhh1;
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



final class ButtonEditor extends DefaultCellEditor {
    
    protected JButton button;
    
    
    
    private String label;
    
    
    
    private boolean isPushed;
    
    
    
    public ButtonEditor(JCheckBox checkBox) {
        
        super(checkBox);
        
        button = new JButton();
        
        button.setOpaque(true);
        
        button.addActionListener((ActionEvent e) -> {
            fireEditingStopped();
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