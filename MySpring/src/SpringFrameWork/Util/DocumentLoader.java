package SpringFrameWork.Util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class DocumentLoader {

	
	public Document GetDocument(File f)
	{
		
		SAXReader sreader=new SAXReader();
		Document document;
		try {
			document=sreader.read(f);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		
		return document;
		
	}
	
}
