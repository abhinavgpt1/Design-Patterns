import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class DocumentBuilderFactoryDemo {
    public static void main(String[] args) throws Exception {
        String xml = "<html lang=\"en\"><head><title>Document</title></head><body>AAPL</body></html>";
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory abstractfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder factory = abstractfactory.newDocumentBuilder();
        Document document = factory.parse(bais);

        document.getDocumentElement().normalize();
        System.out.println("Top node: " + document.getDocumentElement().getNodeName());
        System.out.println(abstractfactory.getClass());
        System.out.println(factory.getClass());

    }
}
/*
 * Output:
 * --------
 * Top node: html
 * class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
 * class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl
 */
