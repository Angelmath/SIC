/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.sic_rrhh;

/**
 *
 * @author Matheus
 */

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaPastel {
    
    public static void main(String[] args) {
        
    }
    
   public ChartPanel crear(ArrayList<Double> entero, ArrayList<String> texto, String tipo){
        DefaultPieDataset data = new DefaultPieDataset();
        for(int i=0; i< entero.size(); i++){
            data.setValue(texto.get(i), entero.get(i));
        }
        JFreeChart chart = ChartFactory.createPieChart3D(tipo, data, true, true, true);
        
        ChartPanel frame = new ChartPanel(chart);
        frame.setSize(400, 400);
        frame.setPreferredSize(new Dimension(300,300));
        frame.setVisible(true);
        return frame;
   }
}
