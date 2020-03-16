package by.training.xmlparser.command.redirect;

import by.training.xmlparser.command.Command;
import by.training.xmlparser.command.JSPParameter;
import by.training.xmlparser.command.Pages;
import by.training.xmlparser.entity.Tariff;
import by.training.xmlparser.exception.ServiceException;
import by.training.xmlparser.factory.ServiceFactory;
import by.training.xmlparser.parser.dom.DOMBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class DOMCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        Set<Tariff> tariffs;
        try {
            Part part = request.getPart(JSPParameter.FILE.getValue());
            tariffs = ServiceFactory.INSTANCE.getDOMParserService().parse(part);
            request.setAttribute("tariffs", tariffs);
            page = Pages.RESULT_JSP.getValue();
        } catch (ServletException | IOException | ServiceException e) {
            String message = "You DOM is empty";
            request.setAttribute("informMessage", message);
            page = Pages.INFORMER_PAGE_JSP.getValue();
        }
        return page;
    }
}
