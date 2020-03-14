package by.training.khoroneko.parser.sax;

import by.training.khoroneko.entity.Candy;
import by.training.khoroneko.exception.ParserException;
import by.training.khoroneko.parser.Parser;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class SAXParser implements Parser {
    private Logger logger = Logger.getLogger(SAXParser.class);
    private Set<Candy> candies;
    private CandyHandler handler;
    private XMLReader reader;

    public SAXParser() {
        handler = new CandyHandler();
        candies = new HashSet<>();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            logger.error(e);
        }
    }

    @Override
    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void buildCandies(InputSource file) throws ParserException {
        try {
            reader.parse(file);
            candies.addAll(handler.getCandies());
        } catch (IOException | SAXException e) {
            logger.error(e);
        }
    }
}
