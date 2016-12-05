import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
public class XmlDom4J{
	public void generateDocument(){
	Document document = DocumentHelper.createDocument();
	     Element root = document.addElement("学生名册");
	     root.addComment("使用更加方便的方式创建xml");
	   //这样添加处理指令 root.addProcessingInstruction("target","text");
	     root.addAttribute("学校", "广州大学华软软件学院");
	 	 Element stuElement=root.addElement("学生");
	 	 stuElement.addAttribute("年级", "14级");
		 stuElement.addAttribute("学号", "14098765");
		 Element name=stuElement.addElement("姓名");
		 name.setText("张三");
		 Element sex=stuElement.addElement("性别");
		 sex.setText("女");
		 Element age=stuElement.addElement("年龄");
		 age.setText("18");
		 Element bir=stuElement.addElement("生日");
		 bir.setText("2010-08-08");
	     //添加dtd说明 document.addDocType("catalog",null,"file://c:/Dtds/catalog.dtd");
	    try{
	    OutputFormat format=new OutputFormat("    ", true,"GBK");
	    XMLWriter output = new XMLWriter(
	            new FileWriter( new File("student2_dom4j_with_DocumentHelper.xml") ),format);
	        output.write( document );
	        output.close();
	        }
	     catch(IOException e){System.out.println(e.getMessage());}
	}
	
	public static void main(String[] argv){
		XmlDom4J dom4j=new XmlDom4J();
		dom4j.generateDocument();
	}
}