import java.util.*;

public class Main {

    public static String normalize(String text) {
        return text.toLowerCase().replaceAll("[^a-z\\s]", "");
    }

    public static String[] convertToList(String text) {
        return text.split("\\s+");
    }

    public static Map<String, Integer> wordCountMap(String[] texts) {
        Map<String, Integer> ans = new HashMap<>();
        for (String word : texts) {
            if (word.isEmpty()) continue;

            ans.put(word, ans.getOrDefault(word, 0) + 1);
        }

        // Find the most frequent word
        if (!ans.isEmpty()) {
            Map.Entry<String, Integer> mostFrequent = null;
            for (Map.Entry<String, Integer> entry : ans.entrySet()) {
                if (mostFrequent == null || entry.getValue() > mostFrequent.getValue()) {
                    mostFrequent = entry;
                }
            }
            System.out.println("-> Từ xuất hiện nhiều nhất: '" + mostFrequent.getKey() + 
                               "' (" + mostFrequent.getValue() + " lần)");
        }

        // 3.2 Liệt kê các từ chỉ xuất hiện đúng 1 lần (Unique words)
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ans.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }
        
        System.out.println("-> Các từ chỉ xuất hiện đúng 1 lần (Unique words):");
        System.out.println(uniqueWords);

        return ans;
    }

    public static void main(String[] args) {
        String text = "Java is a programming language. Java is widely used, " +
                      "and it is an object-oriented language! " +
                      "Learning Java is fun and \"rewarding\".";
        text = normalize(text);

        String[] convertedText = convertToList(text);

        wordCountMap(convertedText);
    }
}
