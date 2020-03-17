package by.training.khoroneko.service.impl;

import by.training.khoroneko.entity.Candy;
import by.training.khoroneko.exception.ServiceException;
import by.training.khoroneko.service.ParserService;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.util.HashSet;
import java.util.Set;

public class DOMParserService implements ParserService {
    private static final Logger LOGGER = Logger.getLogger(DOMParserService.class);

    @Override
    public Set<Candy> parse(Part filePart) throws ServiceException {
        return new HashSet<Candy>();
    }
}
