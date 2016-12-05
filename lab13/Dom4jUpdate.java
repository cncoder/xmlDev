import org.dom4j.Document;
import org.dom4j.Element;
import java.util.List;
import java.util.Iterator;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.io.*;
import org.dom4j.io.SAXReader; 
public class Dom4jUpdate {
	public static void alterXml(File inputXml) {
		try {
			SAXReader saxReader = new SAXReader();
			saxReader.setStripWhitespaceText(true);
			saxReader.setMergeAdjacentText(true);
			   Document document = saxReader.read(inputXml);
			   Element rootElm = document.getRootElement();
			   List nodes = rootElm.elements("学生");
			   Iterator iter=nodes.iterator();
			   while(iter.hasNext()){
				      Element element=(Element)iter.next();
				     
				    	 Element pro=element.addElement("专业");
						 pro.setText("软件工程");
				      Iterator iterator=element.elementIterator("姓名");
				     while(iterator.hasNext()){
				      Element lastNameElement=(Element)iterator.next();
				      if(lastNameElement.getText().equals("张三"))
				      lastNameElement.setText("李四");
				                                  }
				                               }
			   OutputFormat format=new OutputFormat("   ", true,"GBK");
			   XMLWriter xmlWriter = new XMLWriter(
			            new FileWriter( new File("student2_dom4j.xml") ),format);
				xmlWriter.write(document);
			   xmlWriter.close();
		}
		  catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		alterXml(new File("student2_dom4j.xml"));
	}
}
