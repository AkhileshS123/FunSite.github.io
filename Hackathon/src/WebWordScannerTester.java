import java.util.ArrayList;
import java.util.Scanner;

public class WebWordScannerTester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please type in a topic to receive a list of related words\nSpaces must be represented with underscores");
		String topic = scan.nextLine();
		WebWordScanner relatedWords = new WebWordScanner(topic);
		ArrayList<String> words = relatedWords.getTopicWords();
		
		for(String word: words) {
			System.out.println(word);
		}
	}
}
