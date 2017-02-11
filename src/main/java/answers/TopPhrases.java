package answers;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TopPhrases {

    /**
     * Input file location.
     */
    private static final String fileName = "C:\\Users\\Ярослав\\java advanced\\WalletHub\\src\\main\\java\\tests\\TopPhrases.txt";

    /***
     * Main method.
     *
     * @param args
     *            - Program arguments.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                List<Entry<String, Integer>> tops = TopPhrases.countTopPhrases(line);
                for (Iterator<Entry<String, Integer>> iterator = tops.iterator(); iterator.hasNext(); ) {
                    Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
                    System.out.println(String.format("The phrase %s occurs %s times.", entry.getKey(), entry.getValue()));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Count top phrases given an file line.
     *
     * @param line
     *            - file line to be processed.
     * @return List<Entry<String, Integer>> - entries processed and ordered
     */
    public static List<Entry<String, Integer>> countTopPhrases(String line) {
        String[] words = line.split("\\|");
        Map<String, Integer> topWordOccurencies = new LinkedHashMap<String, Integer>();
        if (words != null) {
            for (String word : words) { // O(n) complexity
                if (word != null) {
                    word = word.trim();
                    if (!topWordOccurencies.containsKey(word)) {
                        topWordOccurencies.put(word, 0);
                    }
                    int count = topWordOccurencies.get(word);
                    topWordOccurencies.put(word, ++count);
                }
            }
        }
        // Sort by top n phrases in decreasing order
        Comparator<Entry<String, Integer>> byValue = (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue());
        return topWordOccurencies.entrySet().stream().sorted(byValue.reversed()).collect(Collectors.toList());
    }

}
