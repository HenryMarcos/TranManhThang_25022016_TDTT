import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> hashmap;
    public void analyze(String text) {
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");

        String[] texts = text.split("\\s+");

        hashmap = new HashMap<>();

        for (String word : texts) {
            if (hashmap.containsKey(word)) {
                hashmap.put(word, hashmap.get(word) + 1);
            } else {
                hashmap.put(word, 1);
            }
        }
    }

    public String mostFrequentWord() {
        Map.Entry<String, Integer> result = null;
        for (Map.Entry<String, Integer> i : hashmap.entrySet()) {
            if (result == null || result.getValue() < i.getValue()) {
                result = i;
            }
    
        }
        return result.getKey();
    }

    public void displayResult() {
        for (String i : hashmap.keySet()) {
            System.out.println(i + ": " + hashmap.get(i));
        }
    }
    
}
