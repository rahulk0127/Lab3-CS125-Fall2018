import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(final String text, final String word) {
        int count = 0;
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();
        while (lowerText.contains(lowerWord)) {
            lowerText = lowerText.substring(lowerText.indexOf(lowerWord) + 1);
            count++;
        }
        return count;
    }

    public static int uniqueWordCount(final String text, final String word) {
        int count = 0;
        String remainingText = text;
        while (remainingText.contains(word)) {
            remainingText = remainingText.substring(remainingText.indexOf(word) + 1);
            count++;
        }
        return count;
    }

    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println("\n" + wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Prince"));
        System.out.println("\n" + uniqueWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Prince"));
    }
}
