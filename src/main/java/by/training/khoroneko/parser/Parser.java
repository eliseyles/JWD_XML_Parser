package by.training.khoroneko.parser;

import by.training.khoroneko.entity.Candy;
import by.training.khoroneko.exception.ParserException;
import org.xml.sax.InputSource;

import java.util.Set;

public interface Parser {
    Set<Candy> getCandies();
    void buildCandies(InputSource file) throws ParserException;
}
