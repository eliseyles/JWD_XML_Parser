package by.training.khoroneko.service.impl;

import by.training.khoroneko.entity.Candy;
import by.training.khoroneko.exception.ParserException;
import by.training.khoroneko.exception.ServiceException;
import by.training.khoroneko.exception.XMLValidatorException;
import by.training.khoroneko.parser.Parser;
import by.training.khoroneko.parser.dom.DOMParser;
import by.training.khoroneko.parser.stax.STAXParser;
import by.training.khoroneko.service.ParserService;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class STAXParserService implements ParserService {
    private final static Logger LOGGER = Logger.getLogger(STAXParserService.class);

    @Override
    public Set<Candy> parse(Part filePart) throws ServiceException {
        try {
            Parser parser = new STAXParser();
            InputStream stream = filePart.getInputStream();
            parser.buildCandies(stream);
            return parser.getCandies();
        } catch (IOException | ParserException e) {
            LOGGER.warn(e);
            throw new ServiceException(e);
        }
    }
}
