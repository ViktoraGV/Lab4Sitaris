package parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleDOM {
    private String file_name;
    private ArrayList<Cake> cakes;

    SimpleDOM(String file_name){
        this.file_name = file_name;
        cakes = new ArrayList<>();
    }

    public ArrayList<Cake> parse() throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbf;
        DocumentBuilder        db;
        Document               doc;
        dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();

        FileInputStream fis = new FileInputStream(file_name);
        doc = db.parse(fis);

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("cake");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element)node;
                Cake b = new Cake();
                NamedNodeMap attrs = node.getAttributes();

                b.setPrice(Integer.parseInt(attrs.getNamedItem("price").getNodeValue()));
                b.setBiscuits(Integer.parseInt(attrs.getNamedItem("biscuits").getNodeValue()));
                b.setName(el.getElementsByTagName("name").item(0).getTextContent());
                b.setConfectioner(el.getElementsByTagName("confectioner").item(0).getTextContent());

                cakes.add(b);
            }
        }
        return cakes;
    }
}
