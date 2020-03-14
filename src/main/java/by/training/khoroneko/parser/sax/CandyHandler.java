package by.training.khoroneko.parser.sax;

import by.training.khoroneko.entity.*;
import by.training.khoroneko.parser.CandyTag;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private Logger logger = Logger.getLogger(CandyHandler.class);
    private Set<Candy> candies;
    private Candy current;
    private CandyTag currentTag;

    public CandyHandler() {
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (CandyTag.CANDY.getTagName().equals(localName)) {
            current = new Candy();
            current.setId(attributes.getValue(0));
            current.setValue(new Value());
            current.setIngredient(new Ingredient());
        } else {
            currentTag = CandyTag.getCandyTagByValue(localName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (CandyTag.CANDY.getTagName().equals(localName)) {
            candies.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String tagValue = new String(ch, start, length).trim();
        if (currentTag != null) {
            switch (currentTag) {
                case NAME:
                    current.setName(tagValue);
                    break;
                case ENERGY:
                    current.setEnergy(Integer.parseInt(tagValue));
                    break;
                case PRODUCTION:
                    current.setProduction(tagValue);
                    break;
                case TYPE:
                    current.setCandyType(CandyType.getCandyTypeByValue(tagValue));
                    break;
                case WATER:
                    current.getIngredient().setWater(Integer.parseInt(tagValue));
                    break;
                case SUGAR:
                    current.getIngredient().setSugar(Integer.parseInt(tagValue));
                    break;
                case FRUCTOSE:
                    current.getIngredient().setFructose(Integer.parseInt(tagValue));
                    break;
                case CHOCOLATE_TYPE:
                    current.getIngredient().setChocolateType(ChocolateType.getChocolateTypeByValue(tagValue));
                    break;
                case FAT:
                    current.getValue().setFat(Integer.parseInt(tagValue));
                    break;
                case PROTEIN:
                    current.getValue().setProtein(Integer.parseInt(tagValue));
                    break;
                case CARBOHYDRATES:
                    current.getValue().setCarbohydrates(Integer.parseInt(tagValue));
                    break;
                case CANDY:
                case CANDIES:
                case INGREDIENTS:
                case VALUE:
                    break;
                default:
                    throw new SAXException("Invalid tag");
            }
        }
        currentTag = null;
    }
}
