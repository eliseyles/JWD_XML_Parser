package by.training.khoroneko.parser.stax;

import by.training.khoroneko.entity.*;
import by.training.khoroneko.exception.ParserException;
import by.training.khoroneko.parser.CandyTag;
import by.training.khoroneko.parser.Parser;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class STAXParser implements Parser {
    private Logger logger = Logger.getLogger(STAXParser.class);
    private Set<Candy> candies;
    private static final int ID_ATTRIBUTE_POSITION = 0;
    private XMLInputFactory inputFactory;

    public STAXParser() {
        candies = new HashSet<>();
        inputFactory = XMLInputFactory.newFactory();
    }

    @Override
    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void buildCandies(InputStream file) throws ParserException {
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(file);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    if (CandyTag.getCandyTagByValue(reader.getLocalName()) == CandyTag.CANDY) {
                        candies.add(getXMLCandy(reader));
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.error(e);
            throw new ParserException("");
        }
    }

    private Candy getXMLCandy(XMLStreamReader reader) throws XMLStreamException {
        Candy candy = new Candy();
        candy.setId(reader.getAttributeValue(0));
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (CandyTag.getCandyTagByValue(reader.getLocalName())) {
                        case NAME:
                            candy.setName(getXMLText(reader));
                            break;
                        case ENERGY:
                            candy.setEnergy(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PRODUCTION:
                            candy.setProduction(getXMLText(reader));
                            break;
                        case TYPE:
                            candy.setCandyType(CandyType.getCandyTypeByValue(getXMLText(reader)));
                            break;
                        case INGREDIENTS:
                            candy.setIngredient(getXMLIngredients(reader));
                            break;
                        case VALUE:
                            candy.setValue(getXMLValue(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (CandyTag.getCandyTagByValue(reader.getLocalName()) == CandyTag.CANDY) {
                        return candy;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unsupported element within tariff tag");
    }

    private Ingredient getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Ingredient ingredient = new Ingredient();
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (CandyTag.getCandyTagByValue(reader.getLocalName())) {
                        case WATER:
                            ingredient.setWater(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SUGAR:
                            ingredient.setSugar(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FRUCTOSE:
                            ingredient.setFructose(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CHOCOLATE_TYPE:
                            ingredient.setChocolateType(ChocolateType.getChocolateTypeByValue(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (CandyTag.getCandyTagByValue(reader.getLocalName()) == CandyTag.INGREDIENTS) {
                        return ingredient;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unsupported element within parameters tag");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (CandyTag.getCandyTagByValue(reader.getLocalName())) {
                        case FAT:
                            value.setFat(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PROTEIN:
                            value.setProtein(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CARBOHYDRATES:
                            value.setCarbohydrates(Integer.parseInt(getXMLText(reader)));
                            break;

                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (CandyTag.getCandyTagByValue(reader.getLocalName()) == CandyTag.VALUE) {
                        return value;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unsupported element within callPrice tag");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = "";
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }

        return text;
    }
}
