package by.training.khoroneko.command.redirect;

import by.training.khoroneko.command.Attribute;
import by.training.khoroneko.command.Command;
import by.training.khoroneko.command.JSPParameter;
import by.training.khoroneko.command.Pages;
import by.training.khoroneko.entity.Candy;
import by.training.khoroneko.exception.ServiceException;
import by.training.khoroneko.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Set;

public class STAXCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        Set<Candy> candies;
        try {
            Part part = request.getPart(JSPParameter.FILE.getValue());
            candies = ServiceFactory.INSTANCE.getSTAXParserService().parse(part);
            request.setAttribute(Attribute.CANDIES.getValue(), candies);
            page = Pages.RESULT_JSP.getValue();
        } catch (ServletException | IOException | ServiceException e) {
            String message = "Something goes wrong";
            request.setAttribute(Attribute.INFORM_MESSAGE.getValue(), message);
            page = Pages.INFORMER_PAGE_JSP.getValue();
        }
        return page;
    }
}
