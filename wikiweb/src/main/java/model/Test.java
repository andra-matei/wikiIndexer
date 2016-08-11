package model;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;


public class Test {

    public static void main(String[] args) {
        writeFileFromXML();
        countWords();
    }

    private static void countWords() {
        LinkedHashMap<String, Integer> wordcount = new LinkedHashMap<String, Integer>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("fisierXML.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                str = str.toLowerCase(); // convert to lower case
                String[] words = str.split("\\s+"); //split the line on whitespace, would return an array of words

                for (String word : words) {
                    if (word.length() == 0) {
                        continue;
                    }
                    Integer occurences = wordcount.get(word);

                    if (occurences == null) {
                        occurences = 1;
                    } else {
                        occurences++;
                    }
//                    if(!word.equals("="))
                    wordcount.put(word, occurences);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        wordcount.remove("the"); // =
        wordcount.remove("of");
        wordcount.remove("in");
        wordcount.remove("and");
        wordcount.remove("a");
        wordcount.remove("is");
        wordcount.remove("with");
        wordcount.remove("for");
        wordcount.remove("by");
        wordcount.remove("was");
        wordcount.remove("as");
        wordcount.remove("");
        wordcount.remove("to");
        wordcount.remove("from");
        wordcount.remove("I");
        wordcount.remove("on");
        wordcount.remove("de");
        wordcount.remove("at");
        wordcount.remove("has");
        wordcount.remove("are");




        ArrayList<Integer> values = new ArrayList<Integer>();
        values.addAll(wordcount.values());
        Collections.sort(values, Collections.reverseOrder());
        int last_i = -1;



        for (Integer i : values.subList(0, 9)) {
            if (last_i == i) // without duplicates
                continue;
            last_i = i;

            for (String s : wordcount.keySet()) {
                if (wordcount.get(s) == i) // which have this value
                    System.out.println(s + " " + i);
            }

        }
    }

    public static void writeFileFromXML() {
        URL url = null; //Reading
        try {
            url = new URL("https://en.wikipedia.org/wiki/Special:Export?pages=Romania");
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new FileWriter("fisierXML.txt"));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.write(inputLine);
                out.newLine();
            }
            in.close();
            out.close();

        } catch (MalformedURLException e) {
            System.err.println("malformedException");
        } catch (IOException e) {
            System.err.println("ioexception");
        }
    }
}