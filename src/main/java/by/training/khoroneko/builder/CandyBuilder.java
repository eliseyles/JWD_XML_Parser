package by.training.khoroneko.builder;

import by.training.khoroneko.entity.*;
import by.training.khoroneko.parser.CandyTag;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CandyBuilder {

    public Candy buildCandy(Element candyElement) {
        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute(CandyTag.ID.getTagName()));

        candy.setName(getElementTextContent(candyElement, CandyTag.NAME.getTagName()));
        candy.setEnergy(Integer.parseInt(getElementTextContent(candyElement,CandyTag.ENERGY.getTagName())));
        candy.setCandyType(CandyType.valueOf(getElementTextContent(candyElement, CandyTag.TYPE.getTagName()).toUpperCase()));
        //set ingredient
        Ingredient ingredient = new Ingredient();
        Element ingredientElement = (Element) candyElement.getElementsByTagName(CandyTag.INGREDIENTS.getTagName()).item(0);
        ingredient.setWater(Integer.parseInt(getElementTextContent(ingredientElement, CandyTag.WATER.getTagName())));
        ingredient.setSugar(Integer.parseInt(getElementTextContent(ingredientElement, CandyTag.SUGAR.getTagName())));
        ingredient.setFructose(Integer.parseInt(getElementTextContent(ingredientElement, CandyTag.FRUCTOSE.getTagName())));
        ingredient.setChocolateType(ChocolateType.valueOf(getElementTextContent(ingredientElement, CandyTag.CHOCOLATE_TYPE.getTagName()).toUpperCase()));
        candy.setIngredient(ingredient);
        //set value
        Value value = new Value();
        Element valueElement = (Element) candyElement.getElementsByTagName(CandyTag.VALUE.getTagName()).item(0);
        value.setFat(Integer.parseInt(getElementTextContent(ingredientElement, CandyTag.FAT.getTagName())));
        value.setProtein(Integer.parseInt(getElementTextContent(ingredientElement, CandyTag.PROTEIN.getTagName())));
        value.setCarbohydrates(Integer.parseInt(getElementTextContent(ingredientElement, CandyTag.CARBOHYDRATES.getTagName())));
        candy.setValue(value);
        //set production
        candy.setProduction(getElementTextContent(candyElement, CandyTag.PRODUCTION.getTagName()));
        return candy;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
