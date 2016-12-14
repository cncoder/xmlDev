package Jdomtest2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Jdomtest2 {

	public static void main(String[] args) {
		SAXBuilder builder=new SAXBuilder();
		
		try {
			Document doc=builder.build(new File("student.xml"));
			System.out.println("文件加载成功");
			
			Element root=doc.getRootElement();
			Element student=new Element("学生");
			Attribute grade=new Attribute("年级", "14级");
			Attribute number=new Attribute("学号", "1440121205");
			
			student.setAttribute(grade);
			student.setAttribute(number);
			root.addContent(student);
			
			
			
			Element name=new Element("姓名");
			Element sex=new Element("性别");
			Element age=new Element("年龄");
			Element birth=new Element("生日");
			
			name.setText("张三");
			sex.setText("男");
			age.setText("20");
			birth.setText("1991-10-1");
			
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
				System.out.println("成功修改student.xml");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (JDOMException e) {
			System.out.println("文件加载失败");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件加载失败");
			e.printStackTrace();
		}
	}

}
