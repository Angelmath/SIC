
package Login.ventas;

import Login.Entidad.Ctepagar;
import Login.servicio.Funcion;
import Login.servicio.ServiceHb;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 * @author giftsam
 */
public class ExcelSheetReader
{
    DecimalFormat df = new DecimalFormat("#.##");
    public ExcelSheetReader(){
        
    }
    /**
     * This method is used to read the data's from an excel file.
     * @param fileName - Name of the excel file.
     */
    List cellDataList = new ArrayList();
    
    public List getCellDataList() {
        return cellDataList;
    }
    
    public void setCellDataList(List cellDataList) {
        this.cellDataList = cellDataList;
    }
    
    public void readExcelFile(String fileName, int campo)
    {
        try
        {
            
            FileInputStream fileInputStream = new FileInputStream(fileName);
            /**
             * Create a new instance for POIFSFileSystem class
             */
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            /*
            * Create a new instance for HSSFWorkBook Class
            */
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            HSSFSheet hssfSheet = workBook.getSheetAt(campo);
            /**
             * Iterate the rows and cells of the spreadsheet
             * to get all the datas.
             */
            try{
                ServiceHb helper = new ServiceHb();
                helper.iniciarTransaccion();
                Iterator rowIterator = hssfSheet.rowIterator();
                while (rowIterator.hasNext())
                {
                    HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                    Iterator iterator = hssfRow.cellIterator();
                    Ctepagar ct = new Ctepagar();
                    HSSFCell cell1 = (HSSFCell) iterator.next();
                    //System.out.println(cell1.getStringCellValue());//
                    ct.setDetalle(cell1.getStringCellValue());
                    HSSFCell cell2 = (HSSFCell) iterator.next();
                    //System.out.println(Funcion.DateFormatSql(cell2.getDateCellValue()));
                    ct.setFecha(Funcion.DateFormatSql(cell2.getDateCellValue()));
                    HSSFCell cell3 = (HSSFCell) iterator.next();
                    //System.out.println(cell3.getNumericCellValue());
                    ct.setValor(""+df.format(cell3.getNumericCellValue()).replace(",", "."));
                    ct.setTotal("Aprobado");
                    HSSFCell cell4 = (HSSFCell) iterator.next();
                    //System.out.println(cell4.getStringCellValue());
                    ct.setCliente(cell4.getStringCellValue());
                    HSSFCell cell5 = (HSSFCell) iterator.next();
                    //System.out.println(cell5.getStringCellValue());
                    ct.setInstalacion(cell5.getStringCellValue());
                    HSSFCell cell6 = (HSSFCell) iterator.next();
                    //System.out.println((int)cell6.getNumericCellValue());
                    ct.setIdcliente(""+((int)cell6.getNumericCellValue()));
                    HSSFCell cell7 = (HSSFCell) iterator.next();
                    //System.out.println((int)cell7.getNumericCellValue());
                    ct.setIdinstalacion(""+((int)cell7.getNumericCellValue()));
                    ct.setDias("1");
                    helper.crearObjeto(ct);
                }
                helper.confirmarTransaccion();
                helper.cerrarSesion();
            }catch(Exception io){
            
            }
        }
        catch (Exception io)
        {
            System.out.println(io);
        }
        /**
         * Call the printToConsole method to print the cell data in the
         * console.
         */
//printToConsole(cellDataList);
    }
    /**
     * This method is used to print the cell data to the console.
     * @param cellDataList - List of the data's in the spreadsheet.
     */
    private void printToConsole(List cellDataList)
    {
        for (int i = 0; i < cellDataList.size(); i++)
        {
            List cellTempList = (List) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++)
            {
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                
                if(hssfCell.getCellType()==0){
                    System.out.print(hssfCell.getCellNum() + "\t");
                }else{
                    System.out.print(hssfCell.getStringCellValue() + "\t");
                }
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        String fileName = "C:\\Users\\Matheus\\Desktop\\Surindu.xls";
        new ExcelSheetReader().readExcelFile(fileName,0);
    }
}
