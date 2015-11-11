
package sgi.acceso;

import java.io.FileInputStream;
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
/**
* Create a new instance for cellDataList
*/

try
{
/**
* Create a new instance for FileInputStream class
*/
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
Iterator rowIterator = hssfSheet.rowIterator();
while (rowIterator.hasNext())
{
HSSFRow hssfRow = (HSSFRow) rowIterator.next();
Iterator iterator = hssfRow.cellIterator();
List cellTempList = new ArrayList();
while (iterator.hasNext())
{
HSSFCell hssfCell = (HSSFCell) iterator.next();
cellTempList.add(hssfCell);
}
cellDataList.add(cellTempList);
}
}
catch (Exception e)
{
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
        for (Object cellDataList1 : cellDataList) {
            List cellTempList = (List) cellDataList1;
            for (Object cellTempList1 : cellTempList) {
                HSSFCell hssfCell = (HSSFCell) cellTempList1;
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
String fileName = "C:\\Users\\Matheus\\Desktop\\excel\\Inventario.xls";
new ExcelSheetReader().readExcelFile(fileName,0);
}
}
