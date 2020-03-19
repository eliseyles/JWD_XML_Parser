package by.training.khoroneko.validation;

import by.training.khoroneko.exception.XMLValidatorException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Validator extends DefaultHandler {

    private static final Logger LOGGER = Logger.getLogger(Validator.class);
    private static final String SCHEMA_NAMESPACE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final String CANDIES_XSD = "candies.xsd";

    public void validateXMLFile(InputStream xmlFile) throws XMLValidatorException {
        if (xmlFile == null) {
            throw new XMLValidatorException("Null XML passed");
        }
        try {
            SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_NAMESPACE);
            Schema schema = factory.newSchema(getXSD());

            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate((Source) xmlFile);
        } catch (IOException | SAXException e) {
            LOGGER.warn("Invalid file: " + e.getMessage());
            throw new XMLValidatorException("File is invalid", e);
        }
    }

    private File getXSD() {
        System.out.println(this.getClass().getClassLoader().getResource(CANDIES_XSD).getPath());
        String fileURL = this.getClass().getClassLoader().getResource(CANDIES_XSD).getPath();
        fileURL = fileURL.replace("%20", " ");
        fileURL = fileURL.substring(1);
        System.out.println(fileURL);
        return new File(fileURL);
    }

}
