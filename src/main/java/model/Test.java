package model;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

/**
 * Created by azburatura on 8/11/2016.
 */
public class Test {

    public static void main(String[] args) {

        Document doc = null;
        try {
            doc = loadTestDocument("https://en.wikipedia.org/wiki/Special:Export?pages=Sibiu&curonly=1");
            System.out.println(doc.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static Document loadTestDocument(String url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new URL(url).openStream());
    }

}
