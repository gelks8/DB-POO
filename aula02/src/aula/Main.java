package aula;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;

public class Main {
	public static void main(String [] args) throws IOException {
		Document doc = Jsoup.connect("https://pt.wikipedia.org/wiki/F%C3%B3rmula_1").get();
		Elements titles = doc.getElementsByClass("mw-headline");
		
		StringBuilder xmlContent = new StringBuilder();
		xmlContent.append("<titles>\n");
		
		for (Element title : titles) {
            xmlContent.append("  <title>").append(title.text()).append("</title>\n");
        }
		
		xmlContent.append("</titles>");
		
		try {
            FileWriter fileWriter = new FileWriter("titles.xml");
            fileWriter.write(xmlContent.toString());
            fileWriter.close();
            
            System.out.println("Titles saved to titles.xml");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
