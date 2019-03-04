/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
/**
 *
 * @author Atharva
 */
public class ReadmyExcel {
    
    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Creates a Workbook from an Excel file which contains extension as .xls or .xlsx
        // Works for both type of extensions
        // Provide the absolute path of the file below, like I have provided eg:"D:\\Java\\sep_1.xlsx"
        Workbook workbook = WorkbookFactory.create(new File("D:\\Java\\sep_1.xlsx"));

        // Get the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // This 6 lines are used to get the sheet names that are present in your Excel File
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

        // Gets the sheet 0, If you want to read other sheet rather than 0 just type the number inplace of 0
        // Remember sheet number starts from 0, use whole numbers
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        //Row iterator iterates through each of the row
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
        workbook.close();
    }
}
