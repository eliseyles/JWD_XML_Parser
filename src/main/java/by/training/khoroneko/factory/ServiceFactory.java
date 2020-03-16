package by.training.khoroneko.factory;

import by.training.khoroneko.service.ParserService;
import by.training.khoroneko.service.impl.DOMParserService;
import by.training.khoroneko.service.impl.SAXParserService;
import by.training.khoroneko.service.impl.STAXParserService;

public enum ServiceFactory {
    INSTANCE;
    private ParserService domParserService = new DOMParserService();
    private ParserService saxParserService = new SAXParserService();
    private ParserService staxParserService = new STAXParserService();

    public ParserService getDOMParserService() {
        return domParserService;
    }

    public ParserService getSAXParserService() {
        return saxParserService;
    }

    public ParserService getSTAXParserService() {
        return staxParserService;
    }
}
