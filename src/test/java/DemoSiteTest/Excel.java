package DemoSiteTest;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;





public class Excel {

    FileInputStream file = null;
    FileOutputStream fileOut = null;
    XSSFWorkbook workbook = null;
    XSSFCell username;
    XSSFCell password;
    XSSFCell cellValue;


    public void read() throws EncryptedDocumentException, IOException, InvalidFormatException {
        file = new FileInputStream(Constant.USER_EXCELSHEET_PATH + Constant.FILE_TestData);
        workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int i = 0;
        int j = 0;
        username = sheet.getRow(i).getCell(j);

        while(!username.getStringCellValue().equals("")){
            file = new FileInputStream(Constant.USER_EXCELSHEET_PATH + Constant.FILE_TestData);
            workbook = new XSSFWorkbook(file);
            username = sheet.getRow(i).getCell(j);
            password = sheet.getRow(i).getCell(1);
            cellValue = sheet.getRow(i).getCell(2);

            if (cellValue == null){
                cellValue = sheet.getRow(i).createCell(2);
            }

            System.out.println(username.getStringCellValue());
            System.out.println(sheet.getRow(i).getCell(1));
            System.out.println();

        }
    }
}
