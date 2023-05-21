package fileReader;

import classMay.SigninPage;
import classMay.TopNavBar;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import webDriver.WebDriverManagerClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileTest {
ExcelDataPractice excel;
String fileName;
String filePath;
    @BeforeSuite
    public void setUp() throws IOException {
        filePath="C:\\Users\\DELL\\Desktop\\GurpreetData.xlsx";
        //excel.workbook=new XSSFWorkbook(fileName);
        }
        @Test
        public void fileDetailTest() throws IOException {
        ExcelDataPractice excel=new ExcelDataPractice();
        excel.data1();
        }

    @Test(dataProvider ="excelDataUsingListForLoop",dataProviderClass =ExcelDataPractice.class)
    public void dataExcelFileTest1(String fName,String lName, String phone, String address) throws IOException, InvalidFormatException {
        System.out.println("fName = " + fName);
        System.out.println("lName = " + lName);
        System.out.println("phone = " + phone);
        System.out.println("address = " + address);
    }
    @Test(dataProvider ="excelDataUsingListIterator",dataProviderClass =ExcelDataPractice.class)
    public void dataExcelFileTest2(String fName,String lName, String phone, String address) throws IOException, InvalidFormatException {
        System.out.println("fName = " + fName);
        System.out.println("lName = " + lName);
        System.out.println("phone = " + phone);
        System.out.println("address = " + address);
    }
    @Test(dataProvider ="DataUsingObjectArray",dataProviderClass = ExcelDataPractice.class)
    public void dataExcelFileTest3(String fName, String lName, Double phone, String address) throws IOException, InvalidFormatException {
        System.out.println("fName = " + fName);
        System.out.println("lName = " + lName);
        System.out.println("phone = " + phone);
        System.out.println("address = " + address);
    }
    @Test
    public void data2Test() throws IOException {
        ExcelDataPractice excel=new ExcelDataPractice();
        List<Object[]> list=new ArrayList<>();
        list=excel.data3(filePath,"Account",false);
            //System.out.println(list.);
        }
    @Test
    public void data() throws IOException, InvalidFormatException {
        System.out.println("Test executed");
    }
    @AfterSuite
    public void tearDown()  {
            System.out.println("Test finished");
    }
}
