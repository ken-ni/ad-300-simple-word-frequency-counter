import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words to be counted");
        // Read input from user
        String input = scanner.nextLine();

        // Close scanner
        scanner.close();

        // Split multiple words into an array of word elements. Whitespace is trimmed and the \\s+ matches any one or more amount of whitespace
        String[] words = input.trim().split("\\s+");

        // Loop through each element in array, change elements to become lowercase
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }

        // Hashmap with K, V pairing
        Map<String, Integer> wordCount = new HashMap<>();
        // Enhanced for loop which puts each word into a bucket, i
        for (String word: words) {
            // Insert each word from words into hashmap by key (word) and value (occurence)
            // The second argument works by retrieving the wordcount of a word if it already exists, 
            // if it doesn't it returns default (0) + 1, if it does, it does existCount + 1
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Create TreeMap to sort words as it has natural ordering for keys which will result in a sorted map
        TreeMap<String, Integer> sortedWords = new TreeMap<>();
        // Insert key, value pairs from wordCount Hashmap into sortedWords TreeMap
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            sortedWords.put(entry.getKey(), entry.getValue());
        }

        // Enhanced for loop which loops through each entry in the set of key-value pairs in sortedWords Treemap
        for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Test Case 1: Normal scenario
        // hello hola bonjour hello bonjour salutations

        // Test Case 2: Capitals check
        // hello apple chicken banana zebra xylaphone hELLO APPLE ChiCkEN ORanGe baNANA orange apple APPLE apPLE

        // Test Case 3: Sorting check
        // ab az aa zz za ba bb bd bz xa xz

        // Edge Case 1: Previously, our program counted whitespace. It should not count whitespace anymore
        // hello                                    hello                       olleh bonjour    hola       olleh           hello

        // Edge Case 2: false words counted correctly
        // !!!         !!!        !!          >>           <   >     >         > >        >        <<  !! @ ## !

        // Edge Case 3: Single word, letters
        // apple
    }
}
