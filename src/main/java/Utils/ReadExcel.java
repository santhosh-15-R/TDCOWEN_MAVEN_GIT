package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter = new DataFormatter();
    //public static String file_location = System.getProperty("user.dir") + "/Akeneo_product";
    static String Sheet1 = "Equity";
    static String Sheet2 = "Futures";
    static String Sheet3 = "Options";
    static String Sheet4 = "Portfolio";
    static String Sheet5 = "Modify_Equity";
    static String Sheet6 = "Modify_Future";
    static File classpathRoot = new File(System.getProperty("user.dir"));
    static File appDir = new File(classpathRoot, "./input_data/");

    //  To change Driver Acceptance Feature
   //@DataProvider(name="DriverAcceptance")

   /*public static void main(String[] args) throws IOException {*/



    public  Object[][] readEquityData() throws IOException{

        File datFile = new File (appDir, "TC_Equity.xlsx");
        FileInputStream fileInputStream= new FileInputStream(datFile.getAbsolutePath());
        //FileInputStream fileInputStream= new FileInputStream(".\\src\\test\\resources\\testData\\DriverAcceptance.xls"); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook
        worksheet=workbook.getSheet(Sheet1);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum
        Row.getFirstCellNum();

        System.out.println("RowCount====" + RowNum);
        System.out.println("ColCount====" + ColNum);

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {
            XSSFRow row= worksheet.getRow(i+1);
            System.out.println();

            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {

               //short row= Row.getFirstCellNum();//getRow(i+1);
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        for(int i = 0; i < Data.length; i++) {
            for(int j = 0; j < Data[i].length; j++) {
                System.out.print(Data[i][j] + " ");
            }
            System.out.println();
        }
       return Data;
    }

    public  Object[][] ReadFutureData() throws IOException{

        File datFile = new File (appDir, "TC_Equity.xlsx");
        FileInputStream fileInputStream= new FileInputStream(datFile.getAbsolutePath());
        //FileInputStream fileInputStream= new FileInputStream(".\\src\\test\\resources\\testData\\DriverAcceptance.xls"); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook
        worksheet=workbook.getSheet(Sheet2);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum
        Row.getFirstCellNum();

        System.out.println("RowCount====" + RowNum);
        System.out.println("ColCount====" + ColNum);

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {
            XSSFRow row= worksheet.getRow(i+1);
            System.out.println();

            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {

                //short row= Row.getFirstCellNum();//getRow(i+1);
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        for(int i = 0; i < Data.length; i++) {
            for(int j = 0; j < Data[i].length; j++) {
                System.out.print(Data[i][j] + " ");
            }
            System.out.println();
        }
        return Data;
    }
    public  Object[][] ReadOptionData() throws IOException{

        File datFile = new File (appDir, "TC_Equity.xlsx");
        FileInputStream fileInputStream= new FileInputStream(datFile.getAbsolutePath());
        //FileInputStream fileInputStream= new FileInputStream(".\\src\\test\\resources\\testData\\DriverAcceptance.xls"); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook
        worksheet=workbook.getSheet(Sheet3);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum
        Row.getFirstCellNum();

        System.out.println("RowCount====" + RowNum);
        System.out.println("ColCount====" + ColNum);

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {
            XSSFRow row= worksheet.getRow(i+1);
            System.out.println();

            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {

                //short row= Row.getFirstCellNum();//getRow(i+1);
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        for(int i = 0; i < Data.length; i++) {
            for(int j = 0; j < Data[i].length; j++) {
                System.out.print(Data[i][j] + " ");
            }
            System.out.println();
        }
        return Data;
    }

    public  Object[][] ReadPortfolioData() throws IOException{

        File datFile = new File (appDir, "TC_Equity.xlsx");
        FileInputStream fileInputStream= new FileInputStream(datFile.getAbsolutePath());
        //FileInputStream fileInputStream= new FileInputStream(".\\src\\test\\resources\\testData\\DriverAcceptance.xls"); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook
        worksheet=workbook.getSheet(Sheet4);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum
        Row.getFirstCellNum();

        System.out.println("RowCount====" + RowNum);
        System.out.println("ColCount====" + ColNum);

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {
            XSSFRow row= worksheet.getRow(i+1);
            System.out.println();

            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {

                //short row= Row.getFirstCellNum();//getRow(i+1);
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        for(int i = 0; i < Data.length; i++) {
            for(int j = 0; j < Data[i].length; j++) {
                System.out.print(Data[i][j] + " ");
            }
            System.out.println();
        }
        return Data;
    }

    public  Object[][] ReadModifyEquityData() throws IOException{

        File datFile = new File (appDir, "TC_Equity.xlsx");
        FileInputStream fileInputStream= new FileInputStream(datFile.getAbsolutePath());
        //FileInputStream fileInputStream= new FileInputStream(".\\src\\test\\resources\\testData\\DriverAcceptance.xls"); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook
        worksheet=workbook.getSheet(Sheet5);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum
        Row.getFirstCellNum();

        System.out.println("RowCount====" + RowNum);
        System.out.println("ColCount====" + ColNum);

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {
            XSSFRow row= worksheet.getRow(i+1);
            System.out.println();

            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {

                //short row= Row.getFirstCellNum();//getRow(i+1);
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        for(int i = 0; i < Data.length; i++) {
            for(int j = 0; j < Data[i].length; j++) {
                System.out.print(Data[i][j] + " ");
            }
            System.out.println();
        }
        return Data;
    }

    public  Object[][] ReadModifyFutureData() throws IOException{

        File datFile = new File (appDir, "TC_Equity.xlsx");
        FileInputStream fileInputStream= new FileInputStream(datFile.getAbsolutePath());
        //FileInputStream fileInputStream= new FileInputStream(".\\src\\test\\resources\\testData\\DriverAcceptance.xls"); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook
        worksheet=workbook.getSheet(Sheet6);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum
        Row.getFirstCellNum();

        System.out.println("RowCount====" + RowNum);
        System.out.println("ColCount====" + ColNum);

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {
            XSSFRow row= worksheet.getRow(i+1);
            System.out.println();

            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {

                //short row= Row.getFirstCellNum();//getRow(i+1);
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        for(int i = 0; i < Data.length; i++) {
            for(int j = 0; j < Data[i].length; j++) {
                System.out.print(Data[i][j] + " ");
            }
            System.out.println();
        }
        return Data;
    }


}
