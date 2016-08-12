package service.tools;

import keys.BaseKeys;
import model.Article;
import model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andmatei on 8/12/2016.
 */
@Component
public class ParseFile {

    @Autowired
    private CountWords countWords;

    @Autowired
    private WriteFileFromXML writeFileFromXML;

    public List<Word> readFromFile() {
        List<Word> wordList = new ArrayList<Word>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BaseKeys.LOCAL_FILE_PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<Word> wordsFromDatabase = writeFileFromXML.writeFileFromXML(line);
                if (wordsFromDatabase != null) {
                    wordList.addAll(wordsFromDatabase);
                } else {
                    List<Word> topTenWords = countWords.countWords();
                    wordList.addAll(topTenWords);
                }
            }
            return wordList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
