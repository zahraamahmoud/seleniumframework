package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excelreader {
  static   FileInputStream  fis=null;
  public FileInputStream fileInputStream(){

      String path=System.getProperty("user.dir")+"/src/test/java/data/userdata.xlsx";
      File source=new File(path);
      try {
          fis=new FileInputStream(source);
      } catch (FileNotFoundException e) {
          System.out.println("error ocurred:"+e.getMessage());
      }
      return fis;

  }
  public Object[][] getexceldata() throws IOException {

      fis=fileInputStream();
      XSSFWorkbook wb=new XSSFWorkbook(fis);
      XSSFSheet sheet= wb.getSheetAt(0);
      int noofrows=(sheet.getLastRowNum()+1);
      int noofcol=4;
      String[][] exceldataarray=new String[noofrows][noofcol];
      for (int i=0;i<noofrows;i++){
          for(int j=0;j<noofcol;j++){

              XSSFRow row=sheet.getRow(i);
              exceldataarray[i][j]=row.getCell(j).toString();
          }

      }
      wb.close();
    return exceldataarray;
  }


}
