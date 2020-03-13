package by.training.khoroneko.validation;

import by.training.khoroneko.exceprion.XMLValidatorException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Validator extends DefaultHandler {

    private static final Logger LOGGER = Logger.getLogger(Validator.class);
    private static final String SCHEMA_NAMESPACE = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    public void validateXMLFile(InputStream inputStream, String schemaName) throws XMLValidatorException {
        if (inputStream == null) {
            throw new XMLValidatorException("Null XML passed");
        }
        if (schemaName == null) {
            throw new XMLValidatorException("Null XSD passed");
        }
        try {
            SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_NAMESPACE);
            Schema schema = factory.newSchema(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(schemaName)).getFile()));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.setErrorHandler(this);
            System.out.println(validator.toString());
            validator.validate(new StreamSource(inputStream));
        } catch (IOException | SAXException e) {
            LOGGER.warn("Invalid file: " + e.getMessage());
            throw new XMLValidatorException("File is invalid", e);
        }
    }

    @Override
    public void warning(SAXParseException e) {
        LOGGER.warn(getExceptionLocation(e) + "-" + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        LOGGER.error(getExceptionLocation(e) + " - " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        LOGGER.fatal(getExceptionLocation(e) + " - " + e.getMessage());
    }

    private String getExceptionLocation(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

}
