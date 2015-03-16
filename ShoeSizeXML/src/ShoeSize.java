
/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 */
/*Modified by Lu Chen 16 Mar 2015
 *
 */
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class ShoeSize {
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.xml";

	private Integer shoesize;

	public ShoeSize() {
		shoesize = null;
		load();
	}

	public String show() {
		return (shoesize == null ? "" : shoesize.toString());
	}

	public boolean set(Integer v) {
		if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
			shoesize = v;
			save();
			return true;
		} else {
			shoesize = null;
			return false;
		}
	}

	void load() {
		// add code here that will save shoe size into a file called "FILENAME"
        File f = new File(FILENAME);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //load the xml tree
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);

            //parse the tree and obtain the person info
            NodeList nl = doc.getElementsByTagName("Shoesize");
            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                if(n.getNodeType() == Node.ELEMENT_NODE) {
                    Element noteElement = (Element) n;
                    System.out.println("You have load the shoesize" + noteElement.getAttribute("size"));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	void save() {
		// add code here that will load shoe size from a file called "FILENAME"
        File f = new File(FILENAME);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;

        try {
            //make the xml tree
            db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element sz = doc.createElement("Shoesize");
            doc.appendChild(sz);

            Element size = doc.createElement("size");
            size.appendChild(doc.createTextNode(shoesize.toString()));
            sz.appendChild(size);

            //save the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
