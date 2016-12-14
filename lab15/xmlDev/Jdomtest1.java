package xmlDev;

import java.io.FileOutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Jdomtest1 {

	public static void main(String[] args) {
		System.out.println("开始生成xml文件");
		Jdomtest1.BuildXML();
	}

	private static void BuildXML() {
		Element root;
		Element student;
		Element name;
		Element sex;
		Element age;
		Element birth;
		
		root=new Element("学生名册");
		Attribute schoolname=new Attribute("学校名称", "广州大学华软软件学院");
		root.setAttribute(schoolname);
		
		student=new Element("学生");
		Attribute grade=new Attribute("年级", "14级");
		Attribute number=new Attribute("学号", "144******");
		
		student.setAttribute(grade);
		student.setAttribute(number);
		root.addContent(student);
		
		Document doc=new Document(root);
		
		name=new Element("姓名");
		sex=new Element("性别");
		age=new Element("年龄");
		birth=new Element("生日");
		
		name.setText("谢XX");
		sex.setText("男");
		age.setText("22");
		birth.setText("1994-10-1");
		
		student.addContent(name);
		student.addContent(sex);
		student.addContent(age);
		student.addContent(birth);
		
		Format format=Format.getCompactFormat();
		format.setEncoding("gb2312");
		format.setIndent("    ");
		
		XMLOutputter xmlout=new XMLOutputter(format);
		try {
			xmlout.output(doc, new FileOutputStream("student.xml"));
			System.out.println("生成文件student.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
