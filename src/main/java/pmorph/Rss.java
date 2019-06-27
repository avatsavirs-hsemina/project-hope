package pmorph;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import lombok.ToString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import pmorph.NewsItem;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class Rss {

    public static  MongoClient mongoClient;
    public static Morphia morphia;
    public static Datastore ds;

    static {

        mongoClient = new MongoClient("localhost",27017);
        morphia = new Morphia();
        ds = morphia.createDatastore(mongoClient,"testDb");
    }

    public static void main(String[] args) throws IOException {

        morphia.map(NewsItem.class);

        int i;

        ArrayList<String> links = new ArrayList<String>();
        links.add("https://www.theguardian.com/international/rss");
        Document doc;
        NewsItem obj = null;

        for (i = 0; i < links.size(); i++) {
            doc = Jsoup.connect(links.get(i)).parser(Parser.xmlParser()).get();
            Elements items = doc.getElementsByTag("item");
            for (Element item : items) {
                obj = new NewsItem();
                obj.setTitle(item.select("title").first().text());
                obj.setDescription(item.select("description").first().text());
                obj.setLink(item.select("link").first().text());
//              System.out.println(obj.getTitle());
//              System.out.println(obj.getDescription());
//              System.out.println(obj.getLink());
//              ds.save(obj); ...for now
            }
        }


        RssReader reader = new RssReader();
        reader.findAll();
        reader.fillExcel();
  }
}
