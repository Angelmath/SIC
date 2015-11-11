/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

/**
 *
 * @author Matheus
 */

import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaPastel1 {
    
    public static void main(String[] args) {
            // TODO code application logic here
    double cat1 = 0.0;
    double cat2 = 4.4;
    double cat3 = 6.7;
    
    ArrayList<Double> da = new ArrayList<>();
    ArrayList<String> st = new ArrayList<>();
    da.add(cat1);
    da.add(cat2);
    da.add(cat3);
    st.add("cat1");
    st.add("cat2");
    st.add("cat3");
    
    DefaultPieDataset data = new DefaultPieDataset();
    for(int i=0; i< da.size(); i++){
            data.setValue(st.get(i), da.get(i));
    }

    JFreeChart chart = ChartFactory.createPieChart3D("Gráfico", data, true, true, true);

//    try{
//    ChartUtilities.saveChartAsJPEG(new File("C:\\pie.jpg"), chart, 500, 300);
//    }
//    catch(IOException e){
//    System.out.println("Error al abrir el archivo");
//    }

    ChartFrame frame = new ChartFrame("Mi primer chart", chart);
    frame.pack();
    frame.setVisible(true);
    }
    
   public void crear(ArrayList<Double> entero, ArrayList<String> texto, String tipo, JPanel pane){
       // TODO code application logic here
        DefaultPieDataset data = new DefaultPieDataset();
        for(int i=0; i< entero.size(); i++){
            data.setValue(texto.get(i), entero.get(i));
        }
        JFreeChart chart = ChartFactory.createPieChart3D("Grafico", data, true, true, true);
        
        ChartFrame frame = new ChartFrame("Multas", chart);
//        pane.add(frame);
//        pane.setVisible(true);
        frame.pack();
        frame.setVisible(true);
//        return pane;
   }
}
