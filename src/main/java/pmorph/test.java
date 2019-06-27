//package pmorph;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.parser.Parser;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class test {
//    public static void main(String[] args) throws IOException {
//
//        int i;
//        String link = "https://www.theguardian.com/international/rss";
//        Document doc = Jsoup.connect(link).parser(Parser.xmlParser()).get();
//
//        System.out.println(doc.getElementsByTag("description"));
//
//
//    }
//}