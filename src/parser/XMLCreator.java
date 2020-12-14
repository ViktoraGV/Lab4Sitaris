package parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLCreator {
    private static Node putFinalNode(Document doc, String tag, String value){
        Element node = doc.createElement(tag);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    private static Node putNode(Document doc, String tag, String[] attr, String[] attr_values) {
        Element element = doc.createElement(tag);
        for (int i = 0; i < attr.length; i++){
            element.setAttribute(attr[i], attr_values[i]);
        }
        return element;
    }
    public static void create(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            Node middle_node = putNode(doc, "cakes", new String[]{"count"}, new String[]{"3"});

            Node cake_node1 = putNode(doc, "cake", new String[]{"biscuits", "price"}, new String[]{"3", "64"});
            Node name1 = putFinalNode(doc, "name", "Red velvet");
            Node confectioner1 = putFinalNode(doc, "confectioner", "James Beard");
            cake_node1.appendChild(name1);
            cake_node1.appendChild(confectioner1);

            Node cake_node2 = putNode(doc, "cake", new String[]{"biscuits", "price"}, new String[]{"10", "50"});
            Node name2 = putFinalNode(doc, "name", "Milk girl");
            Node confectioner2 = putFinalNode(doc, "confectioner", "German confectioner");
            cake_node2.appendChild(name2);
            cake_node2.appendChild(confectioner2);

            Node cake_node3 = putNode(doc, "cake", new String[]{"biscuits", "price"}, new String[]{"5", "82"});
            Node name3 = putFinalNode(doc, "name", "Honey cake");
            Node confectioner3 = putFinalNode(doc, "confectioner", "Russian confectioner");
            cake_node3.appendChild(name3);
            cake_node3.appendChild(confectioner3);


            middle_node.appendChild(cake_node1);
            middle_node.appendChild(cake_node2);
            middle_node.appendChild(cake_node3);

            rootElement.appendChild(middle_node);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
            System.out.println(console);
            StreamResult file = new StreamResult(new File("C:\\Users\\1\\Desktop\\Универ\\3 курс\\СиТАиРИС\\Laba 4\\Parser\\file.xml"));

            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
