import java.io.FileWriter;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class domcreatexmlfile {
/*
 * 创建XML file
 */
	public static void createxml() throws IOException{
	DocumentFactory factory=new DocumentFactory();
	Document doc=factory.createDocument();
	Element root=doc.addElement("学生名册");
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
	
	OutputFormat format=new OutputFormat("    ", true,"GBK");
	FileWriter fw=new FileWriter("student2_dom4j.xml");
	XMLWriter xmlWriter=new XMLWriter(fw,format);
	xmlWriter.write(doc);
	System.out.println(doc.toString());
	
	//xmlWriter.flush();
	xmlWriter.close();
 }
	public static void main(String[] args) {
		try {
			createxml();
			System.out.println("文档创建成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
