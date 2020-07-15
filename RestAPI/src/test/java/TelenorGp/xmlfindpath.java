package TelenorGp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import groovy.util.Node;

public class xmlfindpath {


		    public static void main(String[] args) {
		        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		        try {
		            DocumentBuilder builder = domFactory.newDocumentBuilder();
		            Document dDoc = builder.parse("C:\\Users\\rajesh.k\\Desktop\\DPDP_FrameWork\\Web.xml");

		            XPath xPath = XPathFactory.newInstance().newXPath();
		            Node node = (Node) xPath.evaluate("/configurations/appSettings[key='BLACKLIST_CHANNELS']/@value", dDoc, XPathConstants.NODE);
		            //System.out.println(node.getNodeValue());
		            while(node.iterator().hasNext()) {
		            	System.out.println(node);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

	
}
