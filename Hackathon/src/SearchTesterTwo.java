
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchTesterTwo {
	public static void main(String[] args) {
		try {
			String searchTerm = "potato";
			String searchAddress = "https://www.google.com/search?q="+searchTerm+"&num=1";
			Document doc = Jsoup.connect(searchAddress).get();
			String body = doc.body().wholeText();
			System.out.println(body);
		}
		catch(Exception e) {
			System.out.println("error");
		}
	}
}
