import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class TypingTest {
	
	public static int correctChars(String typed, String correct) {
		String longer = "";
		String shorter = "";
		int numCorrect = 0;
		if(typed.length()>correct.length()) {
			longer = typed;
			shorter = correct;
		}
		else {
			longer = correct;
			shorter = typed;
		}
		
		for(int i=0;i<shorter.length();i++) {
			if(shorter.substring(i, i+1).equals(longer.substring(i,i+1))) {
				numCorrect++;
			}
		}
		return numCorrect;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a topic for your typing test. Words will be generated\nbased on this topic. Separate words in the topic with underscores.");
		String topic = scan.nextLine().toLowerCase();
		WebWordScanner topicWords = new WebWordScanner(topic);
		ArrayList<String> words = topicWords.getTopicWords();
		
		while(words.size() < 50) {
			System.out.println("Error: invalid topic or not connected to internet. Please enter another topic.");
			topic = scan.nextLine().toLowerCase();
			topicWords = new WebWordScanner(topic);
			words = topicWords.getTopicWords();
		}
		
		ArrayList<String> testWords = new ArrayList<String>();
		for(int i=0;i<50;i++) {
			testWords.add(words.get(i));
		}
		Collections.shuffle(testWords);
		System.out.println("You will be tested on 50 words related to the topic "+topic+"."
				+ "\nPlease type begin and press enter to begin the test.");
		
		boolean begin = false;
		while(!begin) {
			String input = scan.nextLine();
			if(input.equals("begin")) {
				begin = true;
			}
		}
		int charCount = 0;
		int correctChars = 0;
		long startTime = System.currentTimeMillis();
		for(int i=0;i<50;i++) {
			System.out.println(testWords.get(i));
			String typedWord = scan.nextLine();
			charCount+=typedWord.length();
			correctChars+=correctChars(typedWord, testWords.get(i));
		}
		long endTime = System.currentTimeMillis();
		long timeMillis = endTime-startTime;
		double wordCount = (charCount/4.5);
		double wordsPerMin = wordCount/(timeMillis/60000.0);
		double accuracy = correctChars/((double)charCount);
		System.out.println("\n\nYour time was "+(timeMillis/1000)+" seconds.");
		System.out.println("Your typing speed was "+(int)wordsPerMin+" words per minute.");
		System.out.println("Your accuracy was "+(int)(accuracy*100)+"%.");
		System.exit(0);
}
}