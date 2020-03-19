package by.training.khoroneko.command;

import by.training.khoroneko.command.redirect.DOMCommand;
import by.training.khoroneko.command.redirect.IndexPageCommand;
import by.training.khoroneko.command.redirect.SAXCommand;
import by.training.khoroneko.command.redirect.STAXCommand;

public enum CommandParameter {
    DOM_PARSE(new DOMCommand()),
    SAX_PARSE(new SAXCommand()),
    STAX_PARSE(new STAXCommand()),
    INDEX_PAGE(new IndexPageCommand());

    Command command;

    CommandParameter(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
