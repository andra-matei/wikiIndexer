package service.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by andmatei on 8/11/2016.
 */
public class CountWords {
    protected static void countWords() {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("fisierXML.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                line = line.toUpperCase(); // convert to lower case
                String[] words = line.split("\\s+"); //split the line on whitespace, would return an array of words
                for (String word : words) {
                    if (word.length() == 0) {
                        continue;
                    }
                    Integer occurences = wordCount.get(word);
                    if (occurences == null) {
                        occurences = 1;
                    } else {
                        occurences++;
                    }
                    if (!isPreposition(word)) {
                        wordCount.put(word, occurences);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Exception");
        }

        List<Integer> values = new ArrayList<>();
        values.addAll(wordCount.values());
        Collections.sort(values, Collections.reverseOrder());
        int last_i = -1;


        for (Integer i : values.subList(0, 9)) {
            if (last_i == i) // without duplicates
                continue;
            last_i = i;

            for (String s : wordCount.keySet()) {
                if (wordCount.get(s) == i) // which have this value
                    System.out.println(s + " " + i);
            }

        }
    }

    private static boolean isPreposition(String w) {
        for (PrepositionsEnum preposition : PrepositionsEnum.values()) {
            if (w.equals(preposition.toString())) {
                return true;
            }
        }
        return false;
    }
}
