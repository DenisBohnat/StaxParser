package by.htp.xml.parsers.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.htp.xml.model.*;
import by.htp.xml.parsers.stax.SimpleStaxParser;

public class SimpleClassParsers {

	public static void main(String[] args) {
		List<Family> families = null;
		try {
			SimpleSaxHandler handler = new SimpleSaxHandler();
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse("resources/Family.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		SimpleStaxParser staxParser = new SimpleStaxParser();
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLStreamReader reader = null;
		InputStream input;
		try {
			input = new FileInputStream(new File("resources/Family.xml"));
			reader = inputFactory.createXMLStreamReader(input);
		} catch (FileNotFoundException | XMLStreamException e1) {
			e1.printStackTrace();
		}
		try {
			families = staxParser.runParser(reader);
		} catch (NumberFormatException | XMLStreamException e) {
			e.printStackTrace();
		}
		System.out.println(families);

	}

}
