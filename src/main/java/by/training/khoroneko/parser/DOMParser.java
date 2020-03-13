package by.training.khoroneko.parser;

import by.training.khoroneko.builder.CandyBuilder;
import by.training.khoroneko.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class DOMParser {
    private Set<Candy> candies;
    private DocumentBuilder docBuilder;
    private CandyBuilder candyBuilder;

    public DOMParser() {
        this.candies = new HashSet<Candy>();
        this.candyBuilder = new CandyBuilder();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Parser configuration error: " + e);
        }
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetCandies(InputStream file) {
        Document doc = null;
        try {
            doc = docBuilder.parse(file);
            Element root = doc.getDocumentElement();

            NodeList candyList = root.getElementsByTagName("candy");
            for (int i = 0; i < candyList.getLength(); i++) {
                Element candyElement = (Element) candyList.item(i);
                Candy candy = candyBuilder.buildCandy(candyElement);
                candies.add(candy);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }
}
