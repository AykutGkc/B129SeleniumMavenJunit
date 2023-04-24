package NT.day20_Excel_190423;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead  {
    @Test
    public void readExcelTest01() throws IOException {
        /*
    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Kullanılan satır sayısın bulun
    Ülke-Başkent şeklinde verileri yazdırın
     */

        //Excel dosyasindan bir veri okuyabilmemiz icin:
         //1-Dosya olunu aliriz.
        String dosyaYolu="src/test/java/resourses/Capitals.xlsx";
        String dosyaYolu1=" /Users/aykutgkc/Desktop/Capitals.xlsx";
        //2-Dosyayi okuyabilmek icin akisa almam gerekir.
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //3-Java ortaminda bir excel dosyasi olusturmamiz gerekir
        Workbook workbook= WorkbookFactory.create(fis); //crate(fis) ile excelde dosyayi okuruz
        //4-sayfayi(Sheet) secmemiz gerekir
        Sheet sheet=workbook.getSheet("Sheet1");
        //5-Satir(row) secmemiz gerekir.
        Row row=sheet.getRow(0); // 1.satir cünkü indey 0 dan baslar

        //6-Hücreyi(Cell) secmemiz gerekir.
        Cell cell=row.getCell(0); //1.sütün cünkü index 0 dan baslar

        System.out.println(cell);

    }

    @Test
    public void readExcelTest02() throws IOException {
        FileInputStream fis=new FileInputStream("src/test/java/resourses/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        //1.satir 1.sütunda ki bilgiyi yazdiriniz.
        String satir1sütün1=workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println(satir1sütün1);

    }

    @Test
    public void readExcelTest03() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        //1,yol
        FileInputStream fis=new FileInputStream("src/test/java/resourses/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("Sheet1");
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(1);
        System.out.println("1.Satir 2.Sütun bilgisi: " + cell);

        //2.yol
        System.out.println("1.Satir 2.Sütun bilgisi: " +workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3Sütun1=workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3.satir 1.sütun bilgisi: " + satir3Sütun1);
        Assert.assertEquals("France",satir3Sütun1);

        //    Kullanılan satır sayısın bulun
        System.out.println("Son satir sayisi: "+workbook.getSheet("Sheet1").getLastRowNum());
        //Excel tablosundaki son satir sayisini getShee("Sheet1") yani sayfayi belirledikten sonra getLastRowNum() methodu ile alabiliriz.
        System.out.println("Kullanilan Satir Sayisi: "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //excel tablosunda kullanilan satir sayisini getPhysicalNumberOfRows() methodu ile alabiliriz.

        System.out.println("Son sütun sayisi: "+workbook.getSheet("Sheet1").getRow(0).getLastCellNum());
        System.out.println("Kullanilan sütün sayisi: "+workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());

        //    Ülke-Başkent şeklinde verileri yazdırın
        Map<String,String> ulkeVeBaskentleri = new HashMap<>();

        for (int index = 1; index < workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; index++) {
            String ülke=workbook.getSheet("Sheet1").getRow(index).getCell(0).toString();
            String baskent=workbook.getSheet("Sheet1").getRow(index).getCell(1).toString();
            ulkeVeBaskentleri.put(ülke,baskent+"\n");


            //System.out.println(ülke+"-"+baskent);

        }
        System.out.println(ulkeVeBaskentleri);

    }
    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resourses/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }

}