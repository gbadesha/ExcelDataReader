package fileReader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExcelDataPractice {
    FileInputStream stream=new FileInputStream(new File("C:\\Users\\DELL\\Desktop\\GurpreetData.xlsx"));

    Workbook workbook=new XSSFWorkbook(stream);
    Sheet sheet=workbook.getSheet("Account");
    int noOfRows=sheet.getPhysicalNumberOfRows();
    int cellNumber=sheet.getRow(0).getPhysicalNumberOfCells();
    Cell cell;
    public ExcelDataPractice() throws IOException {
    }
    public void fileDetail(){
        System.out.println("no of rows "+ noOfRows + " no of columns "+ cellNumber);
        }
   @DataProvider(name="excelDataUsingListForLoop")
    public Iterator<Object[]> data1(){
        List<Object[]> data=new ArrayList<>();
        List<Object> cellData=new ArrayList<>();
        for(int i=1;i<noOfRows;i++) {
                for (int j = 0; j < cellNumber; j++) {
                cell = sheet.getRow(i).getCell(j);
                if(cell.getCellType()== CellType.STRING){
                cellData.add(cell.getStringCellValue());
            }
                if(cell.getCellType()==CellType.NUMERIC){
                    cellData.add(String.valueOf(cell.getNumericCellValue()));
                }
                if(cell.getCellType()==CellType.BOOLEAN){
                    cellData.add(cell.getBooleanCellValue());
                }
                if(cell.getCellType()==CellType.BLANK){
                    cellData.add("null");
                }
                }
            data.add(cellData.toArray());
            cellData=new ArrayList<>();
            }
        return data.iterator();
    }
    @DataProvider(name="excelDataUsingListIterator")
    public Iterator<Object[]> data2(){
        List<Object[]> data=new ArrayList<>();
        List<Object> cellData;
        Iterator<Row> rowIterator= sheet.rowIterator();
        //if(skipHeader&&rowIterator.hasNext()){
            rowIterator.next(); // to skip first row
        //}
        while(rowIterator.hasNext())
        {   Row row=rowIterator.next();
            Iterator<Cell> cellIterator=row.cellIterator();
            cellData=new ArrayList<>();
            while(cellIterator.hasNext()){
                 Cell cell=cellIterator.next();
                 if(cell.getCellType()== CellType.STRING){
                    cellData.add(cell.getStringCellValue());
                }
                if(cell.getCellType()==CellType.NUMERIC){
                    cellData.add(String.valueOf(cell.getNumericCellValue()));
                }
                if(cell.getCellType()==CellType.BOOLEAN){
                    cellData.add(cell.getBooleanCellValue());
                }
                if(cell.getCellType()==CellType.BLANK){
                    cellData.add("null");
                }
            }
            data.add(cellData.toArray());
        }
        return data.iterator();
    }


    public List<Object[]> data3(String filePath,String sheetName,Boolean skipHeader) throws IOException {
        FileInputStream stream=new FileInputStream(filePath);
        workbook=new XSSFWorkbook(stream);
        sheet=workbook.getSheet(sheetName);
        List<Object[]> data=new ArrayList<>();
        List<Object> cellData=new ArrayList<>();
        int startingrow;
        if(skipHeader){
            startingrow=1;
        } else{
            startingrow=0;
        }
        for(int i=startingrow;i<noOfRows;i++) {
            for (int j = 0; j < cellNumber; j++) {
                cell = sheet.getRow(i).getCell(j);
                if(cell.getCellType()== CellType.STRING){
                    cellData.add(cell.getStringCellValue());
                }
                if(cell.getCellType()==CellType.NUMERIC){
                    cellData.add(String.valueOf(cell.getNumericCellValue()));
                }
                if(cell.getCellType()==CellType.BOOLEAN){
                    cellData.add(cell.getBooleanCellValue());
                }
                if(cell.getCellType()==CellType.BLANK){
                    cellData.add("null");
                }
            }
            data.add(cellData.toArray());
            cellData=new ArrayList<>();
        }
        return data;
    }
    @DataProvider(name="DataUsingObjectArray")
public Object[][] dataString(){
        Object[][] data=new Object[noOfRows-1][cellNumber];// row-1 because we donot want first row
        for(int i=1;i<noOfRows;i++) {
            //row = sheet.getRow(i);
            for (int j = 0; j < cellNumber; j++) {
                cell = sheet.getRow(i).getCell(j);
                if (cell.getCellType() == CellType.STRING) {
                    data[i - 1][j] = cell.getStringCellValue();
                }
                if (cell.getCellType() == CellType.NUMERIC) {
                    data[i - 1][j] = cell.getNumericCellValue();
                }
                if (cell.getCellType() == CellType.BOOLEAN) {
                    data[i - 1][j] = cell.getBooleanCellValue();
                }
                //if(cell.getCellType()==CellType.BLANK){
                //  cellData.add("null");
                //}
            }
        }
            return data;
        }
}
