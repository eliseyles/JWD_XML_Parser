package by.training.khoroneko.service;

import by.training.khoroneko.entity.Candy;
import by.training.khoroneko.exception.ServiceException;
import by.training.khoroneko.validation.Validator;

import javax.servlet.http.Part;
import java.util.Set;

public interface ParserService {
    Validator VALIDATOR = new Validator();

    Set<Candy> parse(Part filePart) throws ServiceException;
}
