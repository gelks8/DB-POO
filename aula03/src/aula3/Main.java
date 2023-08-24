package aula3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("passageiros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("passageiro");

            System.out.println("Número de passageiros: " + nodeList.getLength());

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                    String origem = element.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = element.getElementsByTagName("destino").item(0).getTextContent();

                    System.out.println("Passageiro: " + nome);
                    System.out.println("Origem: " + origem);
                    System.out.println("Destino: " + destino);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
