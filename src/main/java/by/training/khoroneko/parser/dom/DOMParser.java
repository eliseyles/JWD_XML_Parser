package by.training.khoroneko.parser.dom;

import by.training.khoroneko.builder.CandyBuilder;
import by.training.khoroneko.entity.*;
import by.training.khoroneko.exception.ParserException;
import by.training.khoroneko.parser.CandyTag;
import by.training.khoroneko.parser.Parser;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class DOMParser implements Parser {
    private Logger logger = Logger.getLogger(DOMParser.class);
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
            logger.error("Parser configuration error: " + e);
        }
    }

    @Override
    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void buildCandies(InputSource file) throws ParserException{
        Document doc = null;
        try {
            doc = docBuilder.parse(file);
            Element root = doc.getDocumentElement();

            NodeList candyList = root.getElementsByTagName(CandyTag.CANDY.getTagName());
            for (int i = 0; i < candyList.getLength(); i++) {
                Element candyElement = (Element) candyList.item(i);
                Candy candy = candyBuilder.buildCandy(candyElement);
                candies.add(candy);
            }
        } catch (IOException e) {
            logger.error("File error or I/O error: " + e);
            throw new ParserException("File error");
        } catch (SAXException e) {
            logger.error("Parsing failure: " + e);
            throw new ParserException("Parsing error");
        }
    }
}
