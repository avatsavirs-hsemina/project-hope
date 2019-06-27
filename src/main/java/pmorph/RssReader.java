package pmorph;

import dev.morphia.query.internal.MorphiaCursor;

import dev.morphia.query.Query;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RssReader {

    ArrayList<NewsItem> items = new ArrayList<NewsItem>();


    public void findAll() {
        Query<NewsItem> query = Rss.ds.createQuery(NewsItem.class);
        MorphiaCursor<NewsItem> result = query.find();

        while (result.hasNext()) {
//          System.out.println(result.next().getTitle());
            items.add(result.next());
        }
    }

    public void fillExcel() throws IOException, FileNotFoundException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Feeds");

        int rownum = 0;
        for (NewsItem item : items) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(item.getTitle());
            row.createCell(1).setCellValue(item.getDescription());
            row.createCell(2).setCellValue(item.getLink());
            }

            FileOutputStream fileOut = new FileOutputStream("/home/animesh/RssFeed.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
    }

}


